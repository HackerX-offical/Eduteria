package com.appnew.android.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.amazonaws.services.s3.util.Mimetypes;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class YTubePlayerViewShorts extends WebView {
    public Activity activity;
    private ArrayList<String> classes;
    public Handler handler;
    private WebView webView;

    public YTubePlayerViewShorts(Context context) {
        super(context);
        this.classes = new ArrayList<>();
        this.handler = new Handler();
        initView(context);
    }

    public YTubePlayerViewShorts(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.classes = new ArrayList<>();
        this.handler = new Handler();
        this.webView = new WebView(context.getApplicationContext());
        initView(context);
    }

    public void setInstanseOfActivity(Activity activity2) {
        this.activity = activity2;
        MyStorage.getInstance().storage.put("myActivity", this.activity);
    }

    private void initView(Context context) {
        initialList();
        hideSomeSectionOfBlog(this);
        LayoutInflater.from(context);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(false);
        setWebChromeClient(new MyChrome());
        getSettings().setUserAgentString("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:50.0) Gecko/20100101 Firefox/50.0");
        getSettings().setDisplayZoomControls(true);
        getSettings().setAllowContentAccess(false);
        setWebViewClient(new WebViewClient() { // from class: com.appnew.android.player.YTubePlayerViewShorts.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageCommitVisible(WebView webView, String str) {
                super.onPageCommitVisible(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                try {
                    webView.loadUrl("javascript:(function() { document.getElementsByClassName('ytp-play-button ytp-button')[0].click(); })()");
                    YTubePlayerViewShorts.this.hideSomeSectionOfBlog(webView);
                    YTubePlayerViewShorts.this.scheduleHideContent(webView);
                } catch (Exception unused) {
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                webView.getSettings();
                webView.loadData("Please try after some time.", Mimetypes.MIMETYPE_HTML, "UTF-8");
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.YTubePlayerViewShorts.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 1) {
            event.setAction(3);
            super.onTouchEvent(event);
            event.setAction(0);
            super.onTouchEvent(event);
            event.setAction(1);
        }
        return super.onTouchEvent(event);
    }

    private void initialList() {
        this.classes.add("ytp-chrome-top-buttons");
        this.classes.add("ytp-title");
        this.classes.add("ytp-youtube-button ytp-button yt-uix-sessionlink");
        this.classes.add("ytp-button ytp-endscreen-next");
        this.classes.add("ytp-button ytp-endscreen-previous");
        this.classes.add("ytp-show-cards-title");
        this.classes.add("ytp-endscreen-content");
        this.classes.add("ytp-chrome-top");
        this.classes.add("ytp-share-button");
        this.classes.add("ytp-watch-later-button");
        this.classes.add("ytp-pause-overlay");
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (getLayoutParams().height == -2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) * 9) / 24, 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void hideSomeSectionOfBlog(final WebView webView2) {
        try {
            for (String str : this.classes) {
                hideElementByClassName(webView2, str);
                removeElementByClassName(webView2, str);
            }
            hideContextMenu(webView2);
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.YTubePlayerViewShorts$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    YTubePlayerViewShorts.lambda$hideSomeSectionOfBlog$0(webView2);
                }
            }, 500L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$hideSomeSectionOfBlog$0(WebView webView) {
        webView.loadUrl("javascript:(function() { document.getElementsByClassName('ytp-button ytp-settings-button')[0].style.display='inline'; })()");
        webView.loadUrl("javascript:(function() { document.getElementsByClassName('ytp-fullscreen-button ytp-button')[0].style.display='none'; })()");
        webView.loadUrl("javascript:(function() { document.getElementsByClassName('annotation annotation-type-custom iv-branding')[0].style.display='none'; })()");
    }

    private void hideElementByClassName(WebView webView2, String str) {
        webView2.loadUrl("javascript:(function() { document.getElementsByClassName('" + str + "')[0].style.display='none'; })()");
    }

    private void removeElementByClassName(WebView webView2, String str) {
        webView2.loadUrl("javascript:(function() {  var elements = document.getElementsByClassName('" + str + "');    while(elements.length > 0){        elements[0].parentNode.removeChild(elements[0]);    } })()");
    }

    public void scheduleHideContent(final WebView webView2) {
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.YTubePlayerViewShorts.3
            @Override // java.lang.Runnable
            public void run() {
                YTubePlayerViewShorts.this.hideSomeSectionOfBlog(webView2);
                YTubePlayerViewShorts.this.handler.postDelayed(this, 1000L);
            }
        }, 1000L);
    }

    public void goFullScreenVideo() {
        Activity activity = (Activity) MyStorage.getInstance().storage.get("myActivity");
        this.activity = activity;
        activity.getWindow().setFlags(1024, 1024);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        hideSomeSectionOfBlog(this.webView);
    }

    private void hideContextMenu(WebView webView2) {
        webView2.loadUrl("javascript:(function() { var css = document.createElement('style');  css.type = 'text/css'; var styles = '.ytp-contextmenu { width: 0px !important}';if (css.styleSheet) css.styleSheet.cssText = styles; else css.appendChild(document.createTextNode(styles));document.getElementsByTagName('head')[0].appendChild(css); })()");
    }

    private class MyChrome extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        private int mOriginalSystemUiVisibility;

        MyChrome() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            if (this.mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(YTubePlayerViewShorts.this.activity.getApplicationContext().getResources(), 2130837573);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            ((FrameLayout) YTubePlayerViewShorts.this.activity.getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            YTubePlayerViewShorts.this.activity.setRequestedOrientation(1);
            this.mCustomViewCallback = null;
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            YTubePlayerViewShorts.this.activity = (Activity) MyStorage.getInstance().storage.get("myActivity");
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = view;
            view.setLongClickable(true);
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.YTubePlayerViewShorts.MyChrome.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    return true;
                }
            });
            FrameLayout frameLayout = (FrameLayout) view;
            int childCount = frameLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = frameLayout.getChildAt(i);
                if (childAt != null) {
                    childAt.setLongClickable(true);
                    childAt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.YTubePlayerViewShorts.MyChrome.2
                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View view2) {
                            return true;
                        }
                    });
                }
            }
            this.mOriginalSystemUiVisibility = YTubePlayerViewShorts.this.activity.getWindow().getDecorView().getSystemUiVisibility();
            this.mCustomViewCallback = customViewCallback;
            ((FrameLayout) YTubePlayerViewShorts.this.activity.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            YTubePlayerViewShorts.this.activity.setRequestedOrientation(6);
            YTubePlayerViewShorts.this.goFullScreenVideo();
        }
    }
}
