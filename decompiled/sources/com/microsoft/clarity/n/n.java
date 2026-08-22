package com.microsoft.clarity.n;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class n {
    public static boolean a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        String name = webView.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "webView.javaClass.name");
        return StringsKt.startsWith$default(name, "com.google.android.gms.ads.internal.webview", false, 2, (Object) null);
    }
}
