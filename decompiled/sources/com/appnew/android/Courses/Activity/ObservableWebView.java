package com.appnew.android.Courses.Activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes6.dex */
public class ObservableWebView extends WebView {
    private OnScrollChangedCallback mOnScrollChangedCallback;

    public interface OnScrollChangedCallback {
        void onScroll(int l, int t);
    }

    public ObservableWebView(final Context context) {
        super(context);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(final int l, final int t, final int oldl, final int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        OnScrollChangedCallback onScrollChangedCallback = this.mOnScrollChangedCallback;
        if (onScrollChangedCallback != null) {
            onScrollChangedCallback.onScroll(l, t);
        }
    }

    public OnScrollChangedCallback getOnScrollChangedCallback() {
        return this.mOnScrollChangedCallback;
    }

    public void setOnScrollChangedCallback(final OnScrollChangedCallback onScrollChangedCallback) {
        this.mOnScrollChangedCallback = onScrollChangedCallback;
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return hiddenActionMode();
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        return hiddenActionMode();
    }

    private ActionMode hiddenActionMode() {
        return new ActionMode() { // from class: com.appnew.android.Courses.Activity.ObservableWebView.1
            @Override // android.view.ActionMode
            public void finish() {
            }

            @Override // android.view.ActionMode
            public View getCustomView() {
                return null;
            }

            @Override // android.view.ActionMode
            public Menu getMenu() {
                return null;
            }

            @Override // android.view.ActionMode
            public MenuInflater getMenuInflater() {
                return null;
            }

            @Override // android.view.ActionMode
            public CharSequence getSubtitle() {
                return null;
            }

            @Override // android.view.ActionMode
            public CharSequence getTitle() {
                return null;
            }

            @Override // android.view.ActionMode
            public void invalidate() {
            }

            @Override // android.view.ActionMode
            public void setCustomView(View view) {
            }

            @Override // android.view.ActionMode
            public void setSubtitle(int resId) {
            }

            @Override // android.view.ActionMode
            public void setSubtitle(CharSequence subtitle) {
            }

            @Override // android.view.ActionMode
            public void setTitle(int resId) {
            }

            @Override // android.view.ActionMode
            public void setTitle(CharSequence title) {
            }
        };
    }
}
