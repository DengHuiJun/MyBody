package com.zero.mybody;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zero.mybody.jsonResult.CategoryDetailResult;
import com.zero.mybody.net.HttpManager;

import rx.Subscriber;

/**
 * Created by hui_deng on 16/9/27.
 */

public class NewsDetailFragment extends DialogFragment {

    private TextView mContentTv;
    private View mLoadLayout;

    public static final String KEY_NEWS_ID = "keyNewsId";

    private int mId = 0;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.news_detail_fragment, null);

        mContentTv = (TextView) view.findViewById(R.id.news_detail_tv);
        mContentTv.setMovementMethod(ScrollingMovementMethod.getInstance());

        mLoadLayout = view.findViewById(R.id.loading_layout);

        builder.setView(view)
                .setNegativeButton(R.string.has_read, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        NewsDetailFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        mId = (int) getArguments().get(KEY_NEWS_ID);
        setDetail();
    }

    @SuppressWarnings("deprecation")
    private void setDetail() {
        Subscriber<CategoryDetailResult> subscriber = new Subscriber<CategoryDetailResult>() {
            @Override
            public void onCompleted() {
                mLoadLayout.setVisibility(View.GONE);
                mContentTv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Throwable e) {
                mLoadLayout.setVisibility(View.GONE);
                mContentTv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNext(CategoryDetailResult categoryDetailResult) {
                mContentTv.setText(Html.fromHtml(categoryDetailResult.getMessage()));
            }

            @Override
            public void onStart() {
                mContentTv.setVisibility(View.GONE);
                mLoadLayout.setVisibility(View.VISIBLE);
            }
        };

        HttpManager.getInstance().requestGetCategoryDetail(subscriber, mId);
    }

}
