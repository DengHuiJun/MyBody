package com.zero.mybody.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zero.mybody.BaseApplication;
import com.zero.mybody.HttpManager;
import com.zero.mybody.bean.CategoryResult;

import rx.Subscriber;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Subscriber subscriber = new Subscriber<CategoryResult.Category>() {
            @Override
            public void onCompleted() {
                goToMain();
                finish();
            }

            @Override
            public void onError(Throwable e) {
                finish();
            }

            @Override
            public void onNext(CategoryResult.Category category) {
                BaseApplication.TITLE_LIST.add(category);
            }

            @Override
            public void onStart() {
                super.onStart();
                // 清空一次，防止反复添加
                BaseApplication.TITLE_LIST.clear();
            }
        };

        HttpManager.getInstance().requestGetAllCategory(subscriber);
    }

    private void goToMain() {
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
