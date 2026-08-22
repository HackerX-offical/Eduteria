package com.appnew.android.Utils;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.appnew.android.Courses.Activity.Concept_newActivity;

/* JADX INFO: loaded from: classes6.dex */
public class ReadJSInterface {
    private static final String TAG = "ReadJSInterface";
    private Context context;
    WebView webview;

    @JavascriptInterface
    public void onWebSearchTap() {
    }

    public ReadJSInterface() {
        this.webview = null;
    }

    public ReadJSInterface(WebView webview, Context context) {
        this.webview = webview;
        this.context = context;
    }

    @JavascriptInterface
    public void annotationData(String annotationString, String action) {
        ((Concept_newActivity) this.context).onAnnotationCall(annotationString, action);
    }

    @JavascriptInterface
    public void scrollEnd() {
        ((Concept_newActivity) this.context).onScrolledBottom();
    }

    @JavascriptInterface
    public void onWebSearchTap(String query) {
        try {
            ((Concept_newActivity) this.context).onWebSearchTap(query);
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void onAnnotationTap(boolean state) {
        ((Concept_newActivity) this.context).onAnnotationTap(state);
    }
}
