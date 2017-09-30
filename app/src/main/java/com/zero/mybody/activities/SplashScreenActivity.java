package com.zero.mybody.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zero.mybody.BaseApplication;
import com.zero.mybody.R;
import com.zero.mybody.jsonResult.Category.ShowapiResBodyBean.ListBean;
import com.zero.mybody.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String TAG = "SplashScreenActivity";

    // 将网络下载的类目存入本地数据库
    private List<ListBean> mList = new ArrayList<>(7);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (NetUtils.isConnected(this)) {
            getTitleListFromNet();
        }

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainAndFinish();
            }
        });
    }

    private void initTitleAndGoToMain(List<ListBean> list) {
        if (list == null || list.isEmpty()) {
            Toast.makeText(this, "第一次进入请打开网络！", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        BaseApplication.TITLE_LIST.clear();
        for (ListBean category : list) {
            BaseApplication.TITLE_LIST.add(category);
        }
        goToMainAndFinish();
    }

    private void goToMainAndFinish() {
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void getTitleListFromNet() {

    }
}
