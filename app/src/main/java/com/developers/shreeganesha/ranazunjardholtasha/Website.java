package com.developers.shreeganesha.ranazunjardholtasha;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import static android.webkit.WebSettings.LOAD_CACHE_ONLY;
import static android.webkit.WebSettings.getDefaultUserAgent;


/**
 * A simple {@link Fragment} subclass.
 */
public class Website extends Fragment {
    ProgressBar progressBar;
    WebView webView;



    public Website() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootViev = inflater.inflate(R.layout.fragment_website, container, false);
        progressBar = (ProgressBar)rootViev.findViewById(R.id.progressBar);
        webView= (WebView)rootViev.findViewById(R.id.web);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){

            public void onProgressChanged(WebView view,int progress){
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(progress);
                if (progress==100){
                    progressBar.setVisibility(View.GONE);
                }

            }

        });
        progressBar.setVisibility(View.VISIBLE);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        //webView.getSettings().setOffscreenPreRaster(true);
        //webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        //WebSettings webSettings = webView.getSettings();
        //webSettings.setDomStorageEnabled(true);
        //webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.loadUrl("https://ssatish880.wixsite.com/ranazunjardholtasha");



        return rootViev;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
