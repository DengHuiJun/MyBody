package com.zero.mybody.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zero.mybody.BaseApplication;
import com.zero.mybody.net.HttpManager;
import com.zero.mybody.jsonResult.CategoryResult;
import com.zero.mybody.db.DataManager;
import com.zero.mybody.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String TAG = "SplashScreenActivity";

    // 将网络下载的类目存入本地数据库
    private List<CategoryResult.Category> mList = new ArrayList<>(7);

    private Subscription mSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (NetUtils.isConnected(this)) {
            getTitleListFromNet();
        } else {
            getTitleListFromDB();
        }
    }

    private void initTitleAndGoToMain(List<CategoryResult.Category> list) {
        if (list == null || list.isEmpty()) {
            Toast.makeText(this, "第一次进入请打开网络！", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        BaseApplication.TITLE_LIST.clear();
        for (CategoryResult.Category category : list) {
            BaseApplication.TITLE_LIST.add(category);
        }
        goToMainAndFinish();
    }

    private void goToMainAndFinish() {
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void getTitleListFromDB() {
        mSubscription = DataManager.getInstance(getApplicationContext()).getCategoryList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<CategoryResult.Category>>() {
            @Override
            public void call(List<CategoryResult.Category> categories) {
                initTitleAndGoToMain(categories);

                // 第一次更新后取消订阅
                mSubscription.unsubscribe();
            }
        });
    }

    private void getTitleListFromNet() {
        Subscriber subscriber = new Subscriber<CategoryResult.Category>() {
            @Override
            public void onCompleted() {
                if (mList.size() > 0) {
                    DataManager.getInstance(getApplicationContext()).deleteAllCategory();
                    DataManager.getInstance(getApplicationContext()).addCategoryList(mList.toArray(new CategoryResult.Category[mList.size()]));
                    initTitleAndGoToMain(mList);
                } else {
                    // 从本地获取标题列表
                    getTitleListFromDB();
                }
            }

            @Override
            public void onError(Throwable e) {
                finish();
            }

            @Override
            public void onNext(CategoryResult.Category category) {
                mList.add(category);
            }

            @Override
            public void onStart() {
                super.onStart();
                if (mList == null) {
                    mList = new ArrayList<>(10);
                } else {
                    mList.clear();
                }
            }
        };

        HttpManager.getInstance().requestGetAllCategory(subscriber);
    }
}
