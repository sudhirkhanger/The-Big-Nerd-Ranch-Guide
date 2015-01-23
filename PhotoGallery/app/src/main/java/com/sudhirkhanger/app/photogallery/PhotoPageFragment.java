package com.sudhirkhanger.app.photogallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created on 1/22/15 by
 * Sudhir Khanger
 * sudhirkhanger.com
 * github.com/donniezazen
 * 5577 8CDB A059 085D 1D60  807F 8C00 45D9 F5EF C394
 */
public class PhotoPageFragment extends VisibleFragment {
    private String mUrl;
    private WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mUrl = getActivity().getIntent().getData().toString();
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_page, parent, false);

        final ProgressBar progressBar = (ProgressBar)v.findViewById(R.id.progressBar);
        progressBar.setMax(100); // WebChromeClient reports in range 0-100
        final TextView titleTextView = (TextView)v.findViewById(R.id.titleTextView);

        mWebView = (WebView) v.findViewById(R.id.webView);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int progress) {
                if (progress == 100) {
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(progress);
                }
            }
            public void onReceivedTitle(WebView webView, String title) {
                titleTextView.setText(title);
            }
        });

        mWebView.loadUrl(mUrl);
        return v;
    }

}
