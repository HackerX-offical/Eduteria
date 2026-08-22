package com.razorpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: RazorpayAmazonpayExternalPlugin.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J*\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0003H&J \u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0001H&J \u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H&¨\u0006#"}, d2 = {"Lcom/razorpay/RazorpayAmazonpayExternalPlugin;", "", "getPaymentMetadata", "", "activity", "Landroid/app/Activity;", "initialize", "", "context", "Landroid/content/Context;", DynamicLink.Builder.KEY_API_KEY, "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "payload", "Lorg/json/JSONObject;", "setDataForPolling", "payment_id", "shouldOverrideUrlLoading", "", "webView", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "url", "startAuthorization", "customerId", "amazonpayAuthCodeCallback", "startTransaction", "amazonpayUrl", "razorpayAmazonpayInternalCallback", "Lcom/razorpay/RzpInternalCallback;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RazorpayAmazonpayExternalPlugin {
    String getPaymentMetadata(Activity activity);

    void initialize(Context context, String apiKey);

    void onActivityResult(int requestCode, int resultCode, Intent data, JSONObject payload);

    void setDataForPolling(String apiKey, String payment_id);

    boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request);

    boolean shouldOverrideUrlLoading(WebView webView, String url);

    void startAuthorization(String customerId, Activity activity, Object amazonpayAuthCodeCallback);

    void startTransaction(String amazonpayUrl, Activity activity, RzpInternalCallback razorpayAmazonpayInternalCallback);
}
