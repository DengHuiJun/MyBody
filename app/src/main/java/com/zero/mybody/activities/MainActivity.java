package com.zero.mybody.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.zero.mybody.PageFragment;
import com.zero.mybody.R;
import com.zero.mybody.jsonResult.CategoryResult;
import com.zero.mybody.net.HttpManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

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
        Consumer<CategoryResult> consumer = new Consumer<CategoryResult>() {
            @Override
            public void accept(CategoryResult categoryResult) throws Exception {
                mList = categoryResult.getCategories();
                initFragment();
            }
        };

        HttpManager.getInstance().requestGetAllCategory(consumer);
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
