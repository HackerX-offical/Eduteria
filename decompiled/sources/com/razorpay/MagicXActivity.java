package com.razorpay;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.razorpay.MagicXActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MagicXActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/razorpay/MagicXActivity;", "Landroid/app/Activity;", "()V", "itemsToBeAddedToCart", "Lorg/json/JSONArray;", "magicxLoaded", "", "parentContainer", "Landroid/view/ViewGroup;", "storefrontUrl", "", "viewCover", "Landroid/view/View;", "webView", "Landroid/webkit/WebView;", "dismissHalfTransparentPage", "", "errorFromJs", "error", "handleShouldInterceptRequest", "url", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setSettingsForWebView", "setWebViewClientForMagicX", "showHalfTransparentPage", "Companion", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MagicXActivity extends Activity {
    public static final int MAGICX_REQUEST_CODE = 98001;
    public static final int MAGICX_RESPONSE_CODE = 99002;
    private static final String TAG = "MagicXActivity";
    private JSONArray itemsToBeAddedToCart;
    private boolean magicxLoaded;
    private ViewGroup parentContainer;
    private String storefrontUrl;
    private View viewCover;
    private WebView webView;

    private final void handleShouldInterceptRequest(String url) {
    }

    private final void showHalfTransparentPage() {
        if (this.viewCover != null) {
            runOnUiThread(new Runnable() { // from class: com.razorpay.MagicXActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MagicXActivity.m12326showHalfTransparentPage$lambda0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showHalfTransparentPage$lambda-0, reason: not valid java name */
    public static final void m12326showHalfTransparentPage$lambda0(MagicXActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.parentContainer;
        View view = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
            viewGroup = null;
        }
        View view2 = this$0.viewCover;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewCover");
        } else {
            view = view2;
        }
        viewGroup.addView(view);
        CheckoutUtils.showLoaderForMagicX(this$0, Constants.BLACK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissHalfTransparentPage() {
        if (this.viewCover != null) {
            this.magicxLoaded = true;
            runOnUiThread(new Runnable() { // from class: com.razorpay.MagicXActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MagicXActivity.m12325dismissHalfTransparentPage$lambda1(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: dismissHalfTransparentPage$lambda-1, reason: not valid java name */
    public static final void m12325dismissHalfTransparentPage$lambda1(MagicXActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.parentContainer;
        View view = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
            viewGroup = null;
        }
        View view2 = this$0.viewCover;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewCover");
        } else {
            view = view2;
        }
        viewGroup.removeView(view);
        CheckoutUtils.dismissLoader();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View viewFindViewById = findViewById(android.R.id.content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(android.R.id.content)");
        this.parentContainer = (ViewGroup) viewFindViewById;
        MagicXActivity magicXActivity = this;
        this.webView = new WebView(magicXActivity);
        setSettingsForWebView();
        setWebViewClientForMagicX();
        View view = new View(magicXActivity);
        this.viewCover = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view2 = this.viewCover;
        String str = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewCover");
            view2 = null;
        }
        view2.setBackgroundColor(Color.parseColor("#cc000000"));
        String stringExtra = getIntent().getStringExtra("url");
        if (stringExtra != null) {
            this.storefrontUrl = stringExtra;
        }
        String stringExtra2 = getIntent().getStringExtra("itemsJsonArray");
        if (stringExtra2 != null) {
            this.itemsToBeAddedToCart = new JSONArray(stringExtra2);
        }
        if (this.storefrontUrl == null && this.itemsToBeAddedToCart == null) {
            Intent intent = new Intent();
            intent.putExtra(SaslNonza.Response.ELEMENT, new JSONObject("{\n    \"error\":{\n        \"code\":\"BAD_REQUEST_ERROR\",\n        \"description\":\"Storefront URL or Items List not provided\",\n        \"step\":\"initialization\"\n    }\n}").toString());
            Unit unit = Unit.INSTANCE;
            setResult(99002, intent);
            finishActivity(98001);
            return;
        }
        ViewGroup viewGroup = this.parentContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentContainer");
            viewGroup = null;
        }
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        viewGroup.addView(webView);
        showHalfTransparentPage();
        WebView webView2 = this.webView;
        if (webView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView2 = null;
        }
        String str2 = this.storefrontUrl;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storefrontUrl");
        } else {
            str = str2;
        }
        webView2.loadUrl(str);
    }

    @JavascriptInterface
    public final void errorFromJs(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Toast.makeText(this, error, 1).show();
    }

    /* JADX INFO: renamed from: com.razorpay.MagicXActivity$setWebViewClientForMagicX$1, reason: invalid class name */
    /* JADX INFO: compiled from: MagicXActivity.kt */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0011"}, d2 = {"com/razorpay/MagicXActivity$setWebViewClientForMagicX$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "shouldOverrideUrlLoading", "", "checkout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 extends WebViewClient {
        AnonymousClass1() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView view, String url) {
            String str = MagicXActivity.this.storefrontUrl;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storefrontUrl");
                str = null;
            }
            if (StringsKt.equals(str, url, true)) {
                final MagicXActivity magicXActivity = MagicXActivity.this;
                magicXActivity.runOnUiThread(new Runnable() { // from class: com.razorpay.MagicXActivity$setWebViewClientForMagicX$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MagicXActivity.AnonymousClass1.m12327onPageFinished$lambda0(magicXActivity);
                    }
                });
            }
            super.onPageFinished(view, url);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onPageFinished$lambda-0, reason: not valid java name */
        public static final void m12327onPageFinished$lambda0(MagicXActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WebView webView = this$0.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            StringBuilder sb = new StringBuilder("\n                            fetch(window.Shopify.routes.root + 'cart/clear.js')\n                              .then(res => {res.json()}).then(data => {\n                                const stringifiedFormData = { 'items': ");
            JSONArray jSONArray = this$0.itemsToBeAddedToCart;
            if (jSONArray == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsToBeAddedToCart");
                jSONArray = null;
            }
            webView.evaluateJavascript(StringsKt.trimIndent(sb.append(jSONArray).append("}\n\n\n                                fetch(window.Shopify.routes.root + 'cart/add.js', {\n                                  method: 'POST',\n                                  headers: {\n                                    'Content-Type': 'application/json'\n                                  },\n                                  body: JSON.stringify(stringifiedFormData)\n                                })\n                                .then(response => {\n                                  openRzpLogin();\n                                  return response.json();\n                                }).then(data=>{\n\n                                })\n                                .catch((error) => {\n                                  MagicXBridge.errorFromJs(JSON.stringify(error));\n                                });\n                              }).catch((error)=>{\n                                MagicXBridge.errorFromJs(JSON.stringify(error));\n                              });\n                        ").toString()), null);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.d("OVERRIDE", String.valueOf(request != null ? request.getUrl() : null));
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            if (request != null) {
                MagicXActivity magicXActivity = MagicXActivity.this;
                if (magicXActivity.magicxLoaded) {
                    String string = request.getUrl().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "it.url.toString()");
                    if (StringsKt.startsWith$default(string, "https://api.razorpay.com/v1/checkout/public?", false, 2, (Object) null)) {
                        magicXActivity.magicxLoaded = false;
                        magicXActivity.finish();
                        return null;
                    }
                }
                String string2 = request.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "it.url.toString()");
                if (StringsKt.startsWith$default(string2, "https://api.razorpay.com/v1/magic/order?", false, 2, (Object) null)) {
                    magicXActivity.dismissHalfTransparentPage();
                }
                String string3 = request.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(string3, "it.url.toString()");
                if (StringsKt.startsWith$default(string3, "https://checkout.razorpay.com/app/shopify/v1/payment/", false, 2, (Object) null)) {
                    Intent intent = new Intent();
                    intent.putExtra("checkout_url", request.getUrl().toString());
                    Unit unit = Unit.INSTANCE;
                    magicXActivity.setResult(99002, intent);
                    magicXActivity.finish();
                    return null;
                }
                return super.shouldInterceptRequest(view, request);
            }
            return super.shouldInterceptRequest(view, request);
        }
    }

    private final void setWebViewClientForMagicX() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setWebViewClient(new AnonymousClass1());
    }

    private final void setSettingsForWebView() {
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.getSettings().setDomStorageEnabled(true);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView4;
        }
        webView2.addJavascriptInterface(this, "MagicXBridge");
    }
}
