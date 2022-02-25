package com.faizanfirstproject.newsnow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.faizanfirstproject.newsnow.Adapters.MyRecycleViewAdapter;
import com.faizanfirstproject.newsnow.Model.ModelClass;

import java.util.ArrayList;

public class webView extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar=findViewById(R.id.toolbarWebView);
        webView=findViewById(R.id.webView);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();
        String url= intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}