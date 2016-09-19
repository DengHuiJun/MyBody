package com.zero.mybody;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zero.mybody.bean.HttpResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<HttpResult.TngouBean> mData = new ArrayList<>(10);

    private ListView mListView;
    private CategoryAdapter mAdapter;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == HttpManager.REQUEST_GET_CATEGORY) {
                mData = (List<HttpResult.TngouBean>) msg.obj;
                mAdapter.setList(mData);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.main_lv);
        mAdapter = new CategoryAdapter(this, mData);
        mListView.setAdapter(mAdapter);

        HttpManager.getInstance().requestGetAllCategory(mHandler);

    }
}
