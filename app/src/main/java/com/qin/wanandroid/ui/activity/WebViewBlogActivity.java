package com.qin.wanandroid.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.qin.wanandroid.R;
import com.qin.wanandroid.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewBlogActivity extends BaseActivity {
    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @BindView(R.id.iv_toolbar_delete)
    ImageView ivToolbarDelete;
    @BindView(R.id.iv_toolbar_share)
    ImageView ivToolbarShare;
    @BindView(R.id.ll_common_edit)
    LinearLayout llCommonEdit;
    @BindView(R.id.et_common)
    EditText etCommon;
    @BindView(R.id.ll_common_message)
    LinearLayout llCommonMessage;
    private String mUrl;

    @Override
    public void initData() {
        initToolBar(R.id.toolbar_common);
        mUrl = getIntent().getStringExtra("url");
        initWebView();
        webView.loadUrl(mUrl);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
            }
        });
    }

    private void initWebView() {
        webView.addJavascriptInterface(this, "android");
        webView.setWebChromeClient(webChromeClient);
        webView.setWebViewClient(webViewClient);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_webview_blog;
    }

    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (!request.getUrl().getPath().startsWith("http") || !request.getUrl().getPath().startsWith("https")) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("TAG", "没有安装-哈哈哈" + request.getUrl());
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(view, request);
        }
    };

    private WebChromeClient webChromeClient = new WebChromeClient() {
        @Override
        public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(webView.getContext());
            localBuilder.setMessage(message).setPositiveButton("确定", null);
            localBuilder.setCancelable(false);
            localBuilder.create().show();
            result.confirm();
            return true;
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            progressBar.setProgress(newProgress);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("TAG", "是否有上一个页面:" + webView.canGoBack());
        if (webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @JavascriptInterface
    public void getClient(String str) {

    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }

    @OnClick({R.id.iv_toolbar_delete, R.id.iv_toolbar_share, R.id.ll_common_edit, R.id.ll_common_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_delete:
                break;
            case R.id.iv_toolbar_share:
                share(mUrl);
                break;
            case R.id.ll_common_edit:
                break;
            case R.id.ll_common_message:
                break;
        }
    }
}
