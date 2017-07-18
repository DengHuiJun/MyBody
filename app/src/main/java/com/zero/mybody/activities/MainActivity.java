package com.zero.mybody.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zero.mybody.PageFragment;
import com.zero.mybody.R;
import com.zero.mybody.jsonResult.CategoryResult;
import com.zero.mybody.net.HttpManager;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<CategoryResult.Category> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        findView();
        loadTitleListFromNet();
    }

    private void findView() {
        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void initFragment() {
        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void loadTitleListFromNet() {
        Subscriber subscriber = new Subscriber<CategoryResult.Category>() {
            @Override
            public void onCompleted() {
                initFragment();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getApplicationContext(), "加载出错！请联系开发者！", Toast.LENGTH_LONG).show();
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

    private class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(mList.get(position).getId());
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mList.get(position).getTitle();
        }
    }
}
