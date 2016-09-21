package com.zero.mybody.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zero.mybody.BaseApplication;
import com.zero.mybody.PageFragment;
import com.zero.mybody.R;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private ListView mDrawerLv;

    private String[] mStrs = {"夜间模式", "离线下载", "相关设置"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        findView();
        initDrawer();
        initFragment();
    }

    private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.inflateMenu(R.menu.fix_tool_bar_menu);

        mToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        mToolbar.setTitle("首页");
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.toolbar_text_color));

        setSupportActionBar(mToolbar);
    }

    private void findView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLv = (ListView) findViewById(R.id.left_drawer_lv);
        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void initDrawer() {
        mDrawerLv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fix_tool_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (id == R.id.action_search) {
            Snackbar.make(mTabLayout, "search", Snackbar.LENGTH_SHORT).show();
        } else if (id == R.id.action_settings) {
            Snackbar.make(mTabLayout, "settings", Snackbar.LENGTH_SHORT).show();
        } else if (id == R.id.action_about) {
            Snackbar.make(mTabLayout, "about", Snackbar.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
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
            return PageFragment.newInstance(BaseApplication.TITLE_LIST.get(position).getId());
        }

        @Override
        public int getCount() {
            return BaseApplication.TITLE_LIST.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return BaseApplication.TITLE_LIST.get(position).getTitle();
        }
    }
}
