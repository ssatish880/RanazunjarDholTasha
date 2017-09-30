package com.developers.shreeganesha.ranazunjardholtasha;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Application_Form extends Fragment {

    WebView webView;
    ProgressBar progressBar;


    public Application_Form() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootViev = inflater.inflate(R.layout.fragment_application__form, container, false);
        progressBar = (ProgressBar)rootViev.findViewById(R.id.progressBar2);
        webView= (WebView)rootViev.findViewById(R.id.web2);
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
        //webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        //WebSettings webSettings = webView.getSettings();
        //webSettings.setDomStorageEnabled(true);
        //webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.loadUrl("https://goo.gl/forms/blc3jl9rLTos9BNQ2");



        return rootViev;
    }

}
