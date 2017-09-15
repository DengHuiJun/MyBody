package com.zero.mybody.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.zero.mybody.ICallBack;
import com.zero.mybody.ICatchNews;
import com.zero.mybody.jsonResult.Category;

import java.util.ArrayList;
import java.util.List;

public class NewsService extends Service {

    private ICallBack mCallBack;
    private List<Category> datas = new ArrayList<>();

    public NewsService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IBinder mBinder = new ICatchNews.Stub() {
        @Override
        public void registerCallback(ICallBack c) throws RemoteException {
            mCallBack = c;
        }

        @Override
        public void refreshData() throws RemoteException {
            loadTitleListFromNet();
        }
    };

    private void loadTitleListFromNet() {
//        Subscriber subscriber = new Subscriber<CategoryResult.Category>() {
//            @Override
//            public void onCompleted() {
//                try {
//                    mCallBack.setTitles(datas);
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Toast.makeText(getApplicationContext(), "加载出错！请联系开发者！", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNext(CategoryResult.Category category) {
//                Category c = new Category();
//                c.setId(category.getId());
//                c.setDescription(category.getDescription());
//                c.setKeywords(category.getKeywords());
//                c.setName(category.getName());
//                c.setSeq(category.getSeq());
//                c.setTitle(category.getTitle());
//                datas.add(c);
//            }
//        };

//        HttpManager.getInstance().requestGetAllCategory(subscriber);
    }
}
