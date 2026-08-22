package com.ahmadnemati.clickablewebview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.ahmadnemati.clickablewebview.listener.OnWebViewClicked;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public class ClickableWebView extends WebView implements View.OnClickListener, View.OnTouchListener {
    private static final int IMAGE_TYPE = 5;
    private static final int MAX_CLICK_DURATION = 200;
    private OnWebViewClicked listener;
    private long startClickTime;

    public ClickableWebView(Context context) {
        super(context);
        init();
    }

    public ClickableWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ClickableWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public ClickableWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    public ClickableWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init();
    }

    private void init() {
        setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void setOnWebViewClickListener(OnWebViewClicked onWebViewClicked) {
        this.listener = onWebViewClicked;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView.HitTestResult hitTestResult = getHitTestResult();
        try {
            if (this.listener == null || hitTestResult.getType() != 5) {
                return;
            }
            this.listener.onClick(hitTestResult.getExtra());
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startClickTime = Calendar.getInstance().getTimeInMillis();
            return false;
        }
        if (action != 1 || Calendar.getInstance().getTimeInMillis() - this.startClickTime >= 200) {
            return false;
        }
        performClick();
        return false;
    }
}
