package com.zero.mybody.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.zero.mybody.R;

import static android.view.KeyEvent.KEYCODE_BACK;

public class DetailActivity extends AppCompatActivity {

    public int mId;
    private WebView mWebView;
    private ProgressBar mPb;
    public static final String EXTRA_KEY_URL = "key_url";

    private static final String URL_BASE = "http://www.tngou.net/info/show/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null) {
            mId = getIntent().getIntExtra(EXTRA_KEY_URL, 0);
        }

        mWebView = (WebView) findViewById(R.id.web_view);
        mPb = (ProgressBar) findViewById(R.id.load_pb);

        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDefaultFontSize(15);
        mWebView.getSettings().setJavaScriptEnabled(true);

        if (mId != 0) {
            mWebView.loadUrl(URL_BASE + mId);
        } else {
            finish();
        }

        mWebView.setWebViewClient(new WebViewClient() {
//            @SuppressWarnings("deprecation")
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                final Uri uri = Uri.parse(url);
//                return handleUri(uri);
//            }
//
//            @TargetApi(Build.VERSION_CODES.N)
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                final Uri uri = request.getUrl();
//                return handleUri(uri);
//            }
//
//            private boolean handleUri(final Uri uri) {
//                final String host = uri.getHost();
//                final String scheme = uri.getScheme();
//                // Based on some condition you need to determine if you are going to load the url
//                // in your web view itself or in a browser.
//                // You can use `host` or `scheme` or any part of the `uri` to decide.
//                if (mId != 0) {
//                    mWebView.loadUrl(URL_BASE + mId);
//                    // Returning false means that you are going to load this url in the webView itself
//                    return false;
//                } else {
//                    // Returning true means that you need to handle what to do with the url
//                    // e.g. open web page in a Browser
////                    final Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////                    startActivity(intent);
//                    return true;
//                }
//            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view,url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                mPb.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                mPb.setVisibility(View.VISIBLE);
                mWebView.setVisibility(View.GONE);


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mWebView.destroy();
        mWebView = null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
