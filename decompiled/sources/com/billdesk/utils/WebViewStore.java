package com.billdesk.utils;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes6.dex */
public class WebViewStore extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f553b;

    public WebViewStore() {
    }

    public WebViewStore(WebView webView, LinearLayout linearLayout, boolean z) {
        this.f552a = webView;
        this.f553b = linearLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (bundle != null) {
            this.f552a = (WebView) bundle.getSerializable("webView");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
