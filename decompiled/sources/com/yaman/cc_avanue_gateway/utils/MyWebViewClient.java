package com.yaman.cc_avanue_gateway.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.paytm.pgsdk.TransactionManager;
import com.razorpay.BaseConstants;
import com.yaman.cc_avanue_gateway.model.orderDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WebViewClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020\u001bJ\u0006\u0010$\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/yaman/cc_avanue_gateway/utils/MyWebViewClient;", "Landroid/webkit/WebViewClient;", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yaman/cc_avanue_gateway/utils/UpiListener;", "progress", "Landroid/app/ProgressDialog;", "webview", "Landroid/webkit/WebView;", Const.ORDER, "Lcom/yaman/cc_avanue_gateway/model/orderDetails;", "<init>", "(Landroid/app/Activity;Lcom/yaman/cc_avanue_gateway/utils/UpiListener;Landroid/app/ProgressDialog;Landroid/webkit/WebView;Lcom/yaman/cc_avanue_gateway/model/orderDetails;)V", "getActivity", "()Landroid/app/Activity;", "getProgress", "()Landroid/app/ProgressDialog;", "setProgress", "(Landroid/app/ProgressDialog;)V", "getWebview", "()Landroid/webkit/WebView;", "getOrder", "()Lcom/yaman/cc_avanue_gateway/model/orderDetails;", "setOrder", "(Lcom/yaman/cc_avanue_gateway/model/orderDetails;)V", "onPageFinished", "", ViewHierarchyConstants.VIEW_KEY, "url", "", "shouldOverrideUrlLoading", "", "request", "Landroid/webkit/WebResourceRequest;", "show", "hide", "cc_avanue_gateway_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyWebViewClient extends WebViewClient {
    private final Activity activity;
    private final UpiListener listener;
    private orderDetails order;
    private ProgressDialog progress;
    private final WebView webview;

    public final Activity getActivity() {
        return this.activity;
    }

    public final ProgressDialog getProgress() {
        return this.progress;
    }

    public final void setProgress(ProgressDialog progressDialog) {
        Intrinsics.checkNotNullParameter(progressDialog, "<set-?>");
        this.progress = progressDialog;
    }

    public final orderDetails getOrder() {
        return this.order;
    }

    public final WebView getWebview() {
        return this.webview;
    }

    public final void setOrder(orderDetails orderdetails) {
        Intrinsics.checkNotNullParameter(orderdetails, "<set-?>");
        this.order = orderdetails;
    }

    public MyWebViewClient(Activity activity, UpiListener listener, ProgressDialog progress, WebView webview, orderDetails order) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(webview, "webview");
        Intrinsics.checkNotNullParameter(order, "order");
        this.activity = activity;
        this.listener = listener;
        this.progress = progress;
        this.webview = webview;
        this.order = order;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (this.progress.isShowing()) {
            hide();
        }
        if (view != null) {
            view.evaluateJavascript("(function() {\n    try {\n        var labels = document.getElementsByTagName(\"label\");\n        for (var i = 0; i < labels.length; i++) {\n            if (labels[i].innerText &&\n                labels[i].innerText.toLowerCase().includes(\"shipping address\")) {\n                \n                var parent = labels[i].closest(\"div\");\n                if (parent) {\n                    parent.style.display = \"none\";\n                }\n            }\n        }\n    } catch(e) {}\n})();", null);
        }
        if (StringsKt.equals(url, this.order.getRedirect_url(), true) || StringsKt.equals(url, this.order.getCancel_url(), true)) {
            this.webview.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (!StringsKt.startsWith$default(string, "upi://", false, 2, (Object) null) && !StringsKt.startsWith$default(string, "bhim://", false, 2, (Object) null) && !StringsKt.startsWith$default(string, "phonepe://", false, 2, (Object) null) && !StringsKt.startsWith$default(string, "tez://", false, 2, (Object) null) && !StringsKt.startsWith$default(string, "paytmmp://", false, 2, (Object) null) && !StringsKt.startsWith$default(string, "credpay://", false, 2, (Object) null)) {
            return false;
        }
        if (StringsKt.startsWith$default(string, "phonepe://", false, 2, (Object) null)) {
            str = "com.phonepe.app";
        } else if (StringsKt.startsWith$default(string, "paytmmp://", false, 2, (Object) null)) {
            str = TransactionManager.PAYTM_APP_PACKAGE;
        } else if (StringsKt.startsWith$default(string, "tez://", false, 2, (Object) null)) {
            str = "com.google.android.apps.nbu.paisa.user";
        } else if (StringsKt.startsWith$default(string, "bhim://", false, 2, (Object) null) || StringsKt.startsWith$default(string, "upi://", false, 2, (Object) null)) {
            str = BaseConstants.BHIM_PACKAGE_NAME;
        } else {
            if (!StringsKt.startsWith$default(string, "credpay://", false, 2, (Object) null)) {
                return false;
            }
            str = BaseConstants.CRED_PACKAGE;
        }
        if (AppInstalledKt.isAppInstalled(str, this.activity)) {
            if (StringsKt.startsWith$default(string, "bhim://upi/pay", false, 2, (Object) null)) {
                String strSubstring = string.substring(14);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                this.listener.openApp("upi://pay" + strSubstring);
                return true;
            }
            this.listener.openApp(string);
            return true;
        }
        this.listener.openPlayStore(str);
        return true;
    }

    public final void show() {
        ProgressDialog progressDialog;
        if (this.activity.isFinishing() || (progressDialog = this.progress) == null || progressDialog.isShowing()) {
            return;
        }
        this.progress.show();
    }

    public final void hide() {
        ProgressDialog progressDialog;
        if (this.activity.isFinishing() || (progressDialog = this.progress) == null || !progressDialog.isShowing()) {
            return;
        }
        this.progress.dismiss();
    }
}
