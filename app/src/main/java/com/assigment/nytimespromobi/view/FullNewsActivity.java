package com.assigment.nytimespromobi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebView;

import com.assigment.nytimespromobi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullNewsActivity extends AppCompatActivity {

    public static final String KEY_ARTICAL_URL = "KEY_ARTICAL_URL";
    public static final String KEY_ARTICAL_TITLE = "KEY_ARTICAL_TITLE";


    @BindView(R.id.full_news_webview)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getStringExtra(KEY_ARTICAL_TITLE);
        String url = intent.getStringExtra(KEY_ARTICAL_URL);
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }

        if (!TextUtils.isEmpty(url)) {
            mWebView.loadUrl(url);
        }


    }
}
