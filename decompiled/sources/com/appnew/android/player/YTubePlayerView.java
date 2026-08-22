package com.appnew.android.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.amazonaws.services.s3.util.Mimetypes;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class YTubePlayerView extends WebView {
    public Activity activity;
    private ArrayList<String> classes;
    public Handler handler;
    private WebView webView;

    public YTubePlayerView(Context context) {
        super(context);
        this.classes = new ArrayList<>();
        this.handler = new Handler();
        initView(context);
    }

    public YTubePlayerView(Context context, AttributeSet attributeSet) {
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
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        setWebChromeClient(new MyChrome());
        getSettings().setUserAgentString("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:50.0) Gecko/20100101 Firefox/50.0");
        getSettings().setDisplayZoomControls(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setDomStorageEnabled(true);
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setMixedContentMode(0);
        getSettings().setAllowContentAccess(true);
        getSettings().setAllowFileAccess(true);
        setWebViewClient(new WebViewClient() { // from class: com.appnew.android.player.YTubePlayerView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
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
            public void onPageFinished(WebView webView, String url) {
                super.onPageFinished(webView, url);
                YTubePlayerView.this.tryAutoPlay(webView);
                YTubePlayerView.this.hideSomeSectionOfBlog(webView);
                YTubePlayerView.this.scheduleHideContent(webView);
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
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.YTubePlayerView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryAutoPlay(WebView webView) {
        webView.loadUrl("javascript:(function() {  var btn = document.getElementsByClassName('ytp-play-button ytp-button')[0];  if(btn && btn.getAttribute('aria-label').indexOf('Play') !== -1) {    btn.click();  } else {    setTimeout(arguments.callee, 500);  }})();");
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

    @Override // android.webkit.WebView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.activity.getWindow().clearFlags(1024);
                hideFullScreen();
            } else if (configuration.orientation == 2) {
                goFullScreenVideo();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.YTubePlayerView.3
                @Override // java.lang.Runnable
                public void run() {
                    webView2.loadUrl("javascript:(function() { document.getElementsByClassName('ytp-button ytp-settings-button')[0].style.display='inline'; })()");
                    webView2.loadUrl("javascript:(function() { document.getElementsByClassName('ytp-fullscreen-button ytp-button')[0].style.display='inline'; })()");
                    webView2.loadUrl("javascript:(function() { document.getElementsByClassName('annotation annotation-type-custom iv-branding')[0].style.display='none'; })()");
                }
            }, 1000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void hideElementByClassName(WebView webView2, String str) {
        webView2.loadUrl("javascript:(function() { document.getElementsByClassName('" + str + "')[0].style.display='none'; })()");
    }

    private void removeElementByClassName(WebView webView2, String str) {
        webView2.loadUrl("javascript:(function() {  var elements = document.getElementsByClassName('" + str + "');    while(elements.length > 0){        elements[0].parentNode.removeChild(elements[0]);    } })()");
    }

    public void scheduleHideContent(final WebView webView2) {
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.YTubePlayerView.4
            @Override // java.lang.Runnable
            public void run() {
                YTubePlayerView.this.hideSomeSectionOfBlog(webView2);
                YTubePlayerView.this.handler.postDelayed(this, 2000L);
            }
        }, 2000L);
    }

    public void goFullScreenVideo() {
        Activity activity = (Activity) MyStorage.getInstance().storage.get("myActivity");
        this.activity = activity;
        activity.getWindow().setFlags(1024, 1024);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        hideSomeSectionOfBlog(this.webView);
    }

    public void hideFullScreen() {
        this.activity = (Activity) MyStorage.getInstance().storage.get("myActivity");
        float f2 = getResources().getDisplayMetrics().density;
        int i = (int) ((250.0f * f2) + 0.5f);
        boolean z = (getResources().getConfiguration().screenLayout & 15) == 4;
        if ((getResources().getConfiguration().screenLayout & 15) == 3 || z) {
            i = (int) ((f2 * 350.0f) + 0.5f);
        }
        hideSomeSectionOfBlog(this.webView);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
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
            return BitmapFactory.decodeResource(YTubePlayerView.this.activity.getApplicationContext().getResources(), 2130837573);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            ((FrameLayout) YTubePlayerView.this.activity.getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            YTubePlayerView.this.activity.setRequestedOrientation(1);
            this.mCustomViewCallback = null;
            YTubePlayerView.this.hideFullScreen();
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            YTubePlayerView.this.activity = (Activity) MyStorage.getInstance().storage.get("myActivity");
            if (this.mCustomView != null) {
                onHideCustomView();
                return;
            }
            this.mCustomView = view;
            view.setLongClickable(true);
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.YTubePlayerView.MyChrome.1
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
                    childAt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.YTubePlayerView.MyChrome.2
                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View view2) {
                            return true;
                        }
                    });
                }
            }
            this.mOriginalSystemUiVisibility = YTubePlayerView.this.activity.getWindow().getDecorView().getSystemUiVisibility();
            this.mCustomViewCallback = customViewCallback;
            ((FrameLayout) YTubePlayerView.this.activity.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            YTubePlayerView.this.activity.setRequestedOrientation(6);
            YTubePlayerView.this.goFullScreenVideo();
        }
    }
}
