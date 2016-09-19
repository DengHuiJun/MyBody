package com.zero.mybody;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zero.mybody.bean.CategoryItemResult.CategoryItem;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * 资讯列表
 * Created by zero on 16-9-19.
 */
public class PageFragment extends Fragment {

    public static final String CATEGORY_ID = "category_id";

    private ListView mListView;
    private CategoryItemAdapter mAdapter;
    private int mCategoryId = 0;

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
        mListView = (ListView) view.findViewById(R.id.page_list_view);
        mAdapter = new CategoryItemAdapter(getActivity(), mDataList);
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
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CategoryItem categoryItem) {
                mDataList.add(categoryItem);
            }
        };

        HttpManager.getInstance().requestGetCategoryList(subscriber, mCategoryId);
    }

}