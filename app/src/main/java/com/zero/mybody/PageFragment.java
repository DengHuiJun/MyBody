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

import com.zero.mybody.jsonResult.CategoryList;
import com.zero.mybody.jsonResult.CategoryList.ShowapiResBodyBean.PagebeanBean.ContentlistBean;
import com.zero.mybody.net.HttpManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

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

    private List<ContentlistBean> mDataList = new ArrayList<>();

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

        Consumer<CategoryList> consumer = new Consumer<CategoryList>() {
            @Override
            public void accept(CategoryList categoryItemResult) throws Exception {
                mDataList = categoryItemResult.getShowapi_res_body().getPagebean().getContentlist();
                if (mDataList == null || mDataList.isEmpty()) {
                    Snackbar.make(mListView, "加载失败！", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                mAdapter.setList(mDataList);
                mPb.setVisibility(View.GONE);
            }
        };

        mPb.setVisibility(View.VISIBLE);
        HttpManager.getInstance().requestGetCategoryList(consumer, mCategoryId);
    }

    @Override
    public void onClickItem(String url) {
        if (mDetailFragment == null) {
            mDetailFragment = new NewsDetailFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putString(NewsDetailFragment.KEY_URL, url);
        mDetailFragment.setArguments(bundle);
        mDetailFragment.show(getFragmentManager(), "NewsDetailFragment");
    }
}
