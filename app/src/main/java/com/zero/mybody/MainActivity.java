package com.zero.mybody;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.zero.mybody.bean.CategoryResult;
import com.zero.mybody.bean.CategoryResult.Category;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    private List<CategoryResult.Category> mTitleList = new ArrayList<>(10);

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        initData();
    }

    private void initData() {
        Subscriber subscriber = new Subscriber<Category>() {
            @Override
            public void onCompleted() {
                initFragment();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Category category) {
                mTitleList.add(category);
            }
        };

        HttpManager.getInstance().requestGetAllCategory(subscriber);
    }

    private void initFragment() {
        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(mTitleList.get(position).getId());
        }

        @Override
        public int getCount() {
            return mTitleList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position).getTitle();
        }
    }
}
