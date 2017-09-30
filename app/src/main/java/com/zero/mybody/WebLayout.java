package com.zero.mybody;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.just.library.IWebLayout;

/**
 * Created by hui_deng on 2017/9/30.
 */

public class WebLayout implements IWebLayout {

    private WebView mWebView = null;
    private LinearLayout mVG;

    public WebLayout(Activity activity) {
        View v = LayoutInflater.from(activity).inflate(R.layout.web_layout, null);
        mVG = (LinearLayout) v.findViewById(R.id.web_ly);
        mWebView = (WebView) v.findViewById(R.id.webView);
    }

    @NonNull
    @Override
    public ViewGroup getLayout() {
        return mVG;
    }

    @Nullable
    @Override
    public WebView getWeb() {
        return mWebView;
    }
}
