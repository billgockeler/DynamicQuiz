package com.learnvest.quiz;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class QuizWebView extends WebView {

    private static final String INTERFACE_NAME = "QuizWebView";

    private OnNextClickedListener listener;
    private Handler handler = new Handler(Looper.getMainLooper());


    public QuizWebView(Context context, AttributeSet attrs){
        super(context, attrs);

        getSettings().setJavaScriptEnabled(true);
        addJavascriptInterface(this, INTERFACE_NAME);
        setWebViewClient(new WebViewClient());
        setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage message) {
                Log.d(INTERFACE_NAME, message.lineNumber() + ": " + message.message() + " source:" + message.sourceId());
                return true;
            }
        });

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (0 != (context.getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE))
                setWebContentsDebuggingEnabled(true);
        }
    }

    public void setOnNextPageListener(OnNextClickedListener listener){
        this.listener = listener;
    }

    @JavascriptInterface
    public void next(final String url, final String[] args){
        if(listener != null){
            handler.post(new Runnable() {
                public void run() {
                    listener.onNextClicked(url, args);
                }
            });
        }
    }
}
