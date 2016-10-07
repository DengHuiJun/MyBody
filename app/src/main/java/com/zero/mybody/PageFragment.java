package com.zero.mybody;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.zero.mybody.jsonResult.CategoryItemResult.CategoryItem;
import com.zero.mybody.net.HttpManager;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * 资讯列表
 * Created by zero on 16-9-19.
 */
public class PageFragment extends Fragment implements CategoryItemAdapter.OnCategoryClickListener {

    public static final String CATEGORY_ID = "category_id";

    private ListView mListView;
    private CategoryItemAdapter mAdapter;
    private int mCategoryId = 0;

    private ProgressBar mPb;
    private NewsDetailFragment mDetailFragment = null;

    private List<CategoryItem> mDataList = new ArrayList<>();

    public static PageFragment newInstance(int categoryId) {
        Bundle args = new Bundle();
        args.putInt(CATEGORY_ID, categoryId);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategoryId = getArguments().getInt(CATEGORY_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_fragment, container, false);
        mPb = (ProgressBar) view.findViewById(R.id.page_pb);
        mListView = (ListView) view.findViewById(R.id.page_list_view);
        mAdapter = new CategoryItemAdapter(getActivity(), mDataList);
        mAdapter.setOnCategoryClickListener(this);
        mListView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Subscriber subscriber = new Subscriber<CategoryItem>() {
            @Override
            public void onCompleted() {
                mAdapter.setList(mDataList);
                mPb.setVisibility(View.GONE);
                if (mDataList.isEmpty()) {
                    Snackbar.make(mListView, "加载失败！", Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CategoryItem categoryItem) {
                mDataList.add(categoryItem);
            }

            @Override
            public void onStart() {
                super.onStart();
                // 清空一次，防止反复添加
                mDataList.clear();

                mPb.setVisibility(View.VISIBLE);
            }
        };

        HttpManager.getInstance().requestGetCategoryList(subscriber, mCategoryId);
    }

    @Override
    public void onClickItem(int id) {
        if (mDetailFragment == null) {
            mDetailFragment = new NewsDetailFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putInt(NewsDetailFragment.KEY_NEWS_ID, id);
        mDetailFragment.setArguments(bundle);
        mDetailFragment.show(getFragmentManager(), "NewsDetailFragment");
    }
}
