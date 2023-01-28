package com.example.postapiimpli;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
WebView webview;
ProgressBar pgbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pgbar=findViewById(R.id.progress);

   webview=findViewById(R.id.webview);
   WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
   webview.loadUrl("https://www.google.com");
   webview.setWebViewClient(new WebViewClient(){
       @Override
       public void onPageStarted(WebView view, String url, Bitmap favicon) {
           pgbar.setVisibility(View.VISIBLE);
           super.onPageStarted(view, url, favicon);
       }

       @Override
       public void onPageFinished(WebView view, String url) {
           pgbar.setVisibility(View.GONE);
           super.onPageFinished(view, url);
       }
       //       @Override
//       public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//           return super.shouldOverrideUrlLoading(view, request);
//       }
   });

    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }else {
            super.onBackPressed();
        }

    }
}