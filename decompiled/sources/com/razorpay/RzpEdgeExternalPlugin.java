package com.razorpay;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.Metadata;

/* JADX INFO: compiled from: RzpEdgeExternalPlugin.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0001H&¨\u0006\u0015"}, d2 = {"Lcom/razorpay/RzpEdgeExternalPlugin;", "", "initEdge", "", "activity", "Landroid/app/Activity;", DynamicLink.Builder.KEY_API_KEY, "", "sdkSessionId", "onActivityResultReceived", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPageFinished", "reset", "startSmsListener", "webView", "Landroid/webkit/WebView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RzpEdgeExternalPlugin {
    void initEdge(Activity activity, String apiKey, String sdkSessionId);

    void onActivityResultReceived(int requestCode, int resultCode, Intent data);

    void onPageFinished();

    void reset();

    void startSmsListener(WebView webView);

    void startSmsListener(Object listener);
}
