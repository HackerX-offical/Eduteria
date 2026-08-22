package com.razorpay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.razorpay.CheckoutPresenterImpl;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class BaseCheckoutActivity extends Activity implements CheckoutPresenterImpl.CheckoutView, SmsAgentInterface {
    private static int UPI_REQUEST_CODE = 99;
    protected Object checkoutBridgeObject;
    private RelativeLayout container;
    private String lifecycleContext = "";
    private ViewGroup parent;
    protected CheckoutPresenter presenter;
    private WebChromeClient primaryWebChromeClient;
    private WebView primaryWebView;
    private WebViewClient primaryWebViewClient;
    private RZPProgressBar rzpbar;
    private WebChromeClient secondaryWebChromeClient;
    private WebView secondaryWebView;
    private WebViewClient secondaryWebViewClient;
    private SmsAgent smsAgent;

    interface SetOptionsCallback {
        void onError();

        void onFeatureDisabled();

        void onOptionsSet();
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void checkSmsPermission() {
    }

    BaseCheckoutActivity() {
    }

    protected void setLifecycleContext(LifecycleContext lifecycleContext, String str) {
        this.lifecycleContext = lifecycleContext.format(str);
    }

    private void setWebViewClient(int i, WebViewClient webViewClient) {
        if (i == 1) {
            this.primaryWebViewClient = webViewClient;
        } else {
            if (i != 2) {
                return;
            }
            this.secondaryWebViewClient = webViewClient;
        }
    }

    private void setWebChromeClient(int i, WebChromeClient webChromeClient) {
        if (i == 1) {
            this.primaryWebChromeClient = webChromeClient;
        } else {
            if (i != 2) {
                return;
            }
            this.secondaryWebChromeClient = webChromeClient;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyStatusBarScrim() {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(viewGroup);
            int i = rootWindowInsets != null ? rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars()).top : 0;
            View view = new View(this);
            view.setBackgroundColor(Color.parseColor("#99000000"));
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, i));
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            getWindow().setStatusBarColor(0);
            getWindow().setNavigationBarColor(0);
            if (Build.VERSION.SDK_INT >= 29) {
                getWindow().setStatusBarContrastEnforced(false);
                getWindow().setNavigationBarContrastEnforced(false);
            }
            BaseConfig.paymentInProgress = true;
            SharedPreferenceUtil.handleSdkUpdate(this, ConfigCheckout.SDK_VERSION);
            ConfigCheckout.ensureInitialized(this);
            BaseUtils.checkForLatestVersion(this, ConfigCheckout.SDK_VERSION_CODE);
            this.presenter.setCheckoutLoadStartAt();
            EventCallback eventCallback = Checkout.getEventCallback();
            if (eventCallback != null) {
                this.presenter.setEventCallback(eventCallback);
            }
            ArrayList<String> subscribedAnalyticsEvents = Checkout.getSubscribedAnalyticsEvents();
            if (subscribedAnalyticsEvents != null) {
                this.presenter.setSubscribedAnalyticsEvents(subscribedAnalyticsEvents);
            }
            AnalyticsUtil.libraryType = "CHECKOUTJS";
            setWebViewClient(1, new PrimaryWebViewClient(this.presenter));
            setWebViewClient(2, new SecondaryWebViewClient(this.presenter));
            setWebChromeClient(1, new PrimaryWebChromeClient(this.presenter));
            setWebChromeClient(2, new SecondaryWebChromeClient(this.presenter));
            BaseUtils.setup();
            Logger.d("CheckoutActivity onCreate called");
            if (bundle == null) {
                bundle = getIntent().getExtras();
                z = false;
            } else {
                z = true;
            }
            if (bundle == null) {
                bundle = CheckoutUtils.getCheckoutActivityStateBundle(this);
            }
            if (this.presenter.setOptions(bundle, z)) {
                this.parent = (ViewGroup) findViewById(android.R.id.content);
                createPrimaryWebView(this.checkoutBridgeObject);
                createSecondaryWebView();
                createContainer();
                AnalyticsUtil.logCheckoutFunctionEntry("BaseCheckoutActivity", "onCreate", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
                HashMap map = new HashMap();
                if (!this.lifecycleContext.isEmpty()) {
                    map.put("reason", this.lifecycleContext);
                }
                AnalyticsUtil.trackEvent(AnalyticsEvent.ACTIVITY_ONCREATE_CALLED, map);
                this.lifecycleContext = "";
                getWindow().getDecorView().post(new Runnable() { // from class: com.razorpay.BaseCheckoutActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.applyStatusBarScrim();
                    }
                });
                if (!CheckoutUtils.isDynamicUrlConfigUsed(bundle)) {
                    if (CheckoutCacheManager.getInstance().publicPageResponse == null) {
                        this.presenter.loadForm("");
                    } else {
                        CheckoutCacheManager.getInstance().isFetchedPublicPageUsed = true;
                        this.presenter.loadFetchedForm(CheckoutCacheManager.getInstance().checkoutPublicUrl, CheckoutCacheManager.getInstance().publicPageResponse);
                    }
                } else {
                    this.presenter.setOptionsWithDynamicUrl(this, bundle, z, new SetOptionsCallback() { // from class: com.razorpay.BaseCheckoutActivity.1
                        @Override // com.razorpay.BaseCheckoutActivity.SetOptionsCallback
                        public void onOptionsSet() {
                            SharedPreferenceUtil.setValue(BaseCheckoutActivity.this, "optimizer_hosted", "true");
                            if (CheckoutCacheManager.getInstance().publicPageResponse != null) {
                                CheckoutCacheManager.getInstance().isFetchedPublicPageUsed = true;
                                BaseCheckoutActivity.this.presenter.loadFetchedForm(CheckoutCacheManager.getInstance().checkoutPublicUrl, CheckoutCacheManager.getInstance().publicPageResponse);
                            } else {
                                BaseCheckoutActivity.this.presenter.loadForm("");
                            }
                        }

                        @Override // com.razorpay.BaseCheckoutActivity.SetOptionsCallback
                        public void onFeatureDisabled() {
                            BaseCheckoutActivity.this.destroy(3, "Dynamic URL Config is disabled. Please contact the administrator if you believe this is wrong.");
                        }

                        @Override // com.razorpay.BaseCheckoutActivity.SetOptionsCallback
                        public void onError() {
                            BaseCheckoutActivity.this.destroy(3, "Dynamic URL Config is disabled. Please contact the administrator if you believe this is wrong.");
                        }
                    });
                }
                AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_INIT);
                this.presenter.passPrefillToSegment();
                if ((getWindow().getAttributes().flags & 1024) != 0) {
                    AndroidBug5497Workaround.assistActivity(this);
                    Logger.d("FULLSCREEN");
                } else {
                    Logger.d("NOT FULLSCREEN");
                }
                if (this.presenter.isAllowRotation()) {
                    return;
                }
                if (ResourceUtils.isTablet(this)) {
                    Logger.d("is tablet");
                    setFinishOnTouchOutside(false);
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    int iDpToPx = ResourceUtils.dpToPx(this, 375);
                    int viewHeight = ResourceUtils.getViewHeight(this);
                    if (viewHeight > 600) {
                        viewHeight = ResourceUtils.dpToPx(this, 600);
                    }
                    attributes.height = viewHeight;
                    attributes.width = iDpToPx;
                    getWindow().setAttributes(attributes);
                } else {
                    setRequestedOrientation(1);
                }
                this.presenter.fetchCondfig();
                this.presenter.handleCardSaving();
                if (!BaseUtils.isDeviceHaveCorrectTlsVersion()) {
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_TLS_ERROR);
                    destroy(6, "TLSv1  is not supported for security reasons");
                } else {
                    AnalyticsUtil.logCheckoutFunctionExit("BaseCheckoutActivity", "onCreate", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
                }
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.presenter.saveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.presenter.backPressed(new HashMap());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            CheckoutNfcUtility.INSTANCE.cleanup(this);
            AnalyticsUtil.logCheckoutFunctionEntry("BaseCheckoutActivity", "onDestroy", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            AnalyticsUtil.trackEvent(AnalyticsEvent.ACTIVITY_ONDESTROY_CALLED);
            Logger.d("CheckoutActivity onDestroy called");
            try {
                this.presenter.cleanUpOnDestroy();
            } catch (ConcurrentModificationException e2) {
                AnalyticsUtil.reportError(getClass().getName(), "S0", e2.getLocalizedMessage());
                e2.printStackTrace();
            }
            super.onDestroy();
            AnalyticsUtil.logCheckoutFunctionExit("BaseCheckoutActivity", "onDestroy", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e3) {
            AnalyticsUtil.reportCaughtException(e3);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void createPrimaryWebView(Object obj) {
        try {
            WebView webView = new WebView(this);
            this.primaryWebView = webView;
            webView.setBackgroundColor(Color.parseColor("#99000000"));
            this.primaryWebView.setContentDescription("primary_webview");
            if (CheckoutUtils.shouldDisableHardwareAcceleration(this, this.presenter.getCheckoutOptions())) {
                this.primaryWebView.setLayerType(1, null);
            }
            BaseUtils.setWebViewSettings(this, this.primaryWebView, false);
            this.primaryWebView.clearFormData();
            this.primaryWebView.addJavascriptInterface(obj, "CheckoutBridge");
            this.primaryWebView.setWebChromeClient(this.primaryWebChromeClient);
            this.primaryWebView.setWebViewClient(this.primaryWebViewClient);
        } catch (Throwable th) {
            HashMap map = new HashMap();
            map.put("reason", th.getLocalizedMessage());
            map.put("webview_type", 1);
            AnalyticsUtil.trackEvent(AnalyticsEvent.WEBVIEW_CREATION_FAILED, AnalyticsUtil.getJSONResponse(map));
            destroy(8, BaseConstants.WEBVIEW_CREATION_FAILED_MESSAGE);
        }
    }

    private void createSecondaryWebView() {
        try {
            WebView webView = new WebView(this);
            this.secondaryWebView = webView;
            webView.setBackgroundColor(Color.parseColor("#99000000"));
            if (CheckoutUtils.shouldDisableHardwareAcceleration(this, this.presenter.getCheckoutOptions())) {
                this.secondaryWebView.setLayerType(1, null);
            }
            BaseUtils.setWebViewSettings(this, this.secondaryWebView, false);
            this.secondaryWebView.clearFormData();
            this.secondaryWebView.addJavascriptInterface(new MagicBridge((CheckoutInteractor) this.presenter), "MagicBridge");
            this.secondaryWebView.addJavascriptInterface(new CheckoutBridge((CheckoutInteractor) this.presenter, 2), "CheckoutBridge");
            this.secondaryWebView.setVisibility(8);
            this.secondaryWebView.setWebChromeClient(this.secondaryWebChromeClient);
            this.secondaryWebView.setWebViewClient(this.secondaryWebViewClient);
        } catch (Throwable th) {
            HashMap map = new HashMap();
            map.put("reason", th.getLocalizedMessage());
            map.put("webview_type", 2);
            AnalyticsUtil.trackEvent(AnalyticsEvent.WEBVIEW_CREATION_FAILED, AnalyticsUtil.getJSONResponse(map));
            destroy(8, BaseConstants.WEBVIEW_CREATION_FAILED_MESSAGE);
        }
    }

    private void createContainer() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.container = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.container.setBackgroundColor(0);
        this.parent.addView(this.container);
        ViewCompat.setOnApplyWindowInsetsListener(this.container, new OnApplyWindowInsetsListener() { // from class: com.razorpay.BaseCheckoutActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return BaseCheckoutActivity.lambda$createContainer$0(view, windowInsetsCompat);
            }
        });
        this.primaryWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.secondaryWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.primaryWebView.setContentDescription("primary_webview");
        this.secondaryWebView.setContentDescription("secondary_webview");
        this.container.addView(this.primaryWebView);
        this.container.addView(this.secondaryWebView);
        String progressBarColor = this.presenter.getProgressBarColor();
        if (progressBarColor != null) {
            this.rzpbar = new RZPProgressBar(this, this.container, progressBarColor);
        } else {
            this.rzpbar = new RZPProgressBar(this, this.container);
        }
        this.presenter.setUpAddOn();
    }

    static /* synthetic */ WindowInsetsCompat lambda$createContainer$0(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getInsets(WindowInsetsCompat.Type.statusBars()).top, view.getPaddingRight(), windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom);
        return windowInsetsCompat;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("BaseCheckoutActivity", "onActivityResult", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            super.onActivityResult(i, i2, intent);
            if (i == 1001) {
                this.presenter.sendOtpPermissionCallback(true);
            }
            this.presenter.onActivityResultReceived(i, i2, intent);
            AnalyticsUtil.logCheckoutFunctionExit("BaseCheckoutActivity", "onActivityResult", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.presenter.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.razorpay.SmsAgentInterface
    public void postSms(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sender", str);
            jSONObject.put("message", str2);
            loadUrl(1, String.format("OTPElf.showOTP('%s','%s')", str2, str));
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(getClass().getName(), "S1", e2.getMessage());
            e2.printStackTrace();
        }
    }

    @Override // com.razorpay.SmsAgentInterface
    public void setSmsPermission(boolean z) {
        this.presenter.sendOtpPermissionCallback(z);
        SmsAgent smsAgent = this.smsAgent;
        if (smsAgent != null) {
            smsAgent.deregisterForCallbacks(this);
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void loadUrl(int i, String str) {
        WebView webView;
        if (i != 1) {
            if (i == 2 && (webView = this.secondaryWebView) != null) {
                webView.loadUrl(str);
                return;
            }
            return;
        }
        WebView webView2 = this.primaryWebView;
        if (webView2 != null) {
            webView2.loadUrl(str);
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void addJavascriptInterfaceToPrimaryWebview(Object obj, String str) {
        this.primaryWebView.addJavascriptInterface(obj, str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void loadData(int i, String str, String str2, String str3) {
        if (i == 1) {
            this.primaryWebView.loadData(str, str2, str3);
        } else {
            if (i != 2) {
                return;
            }
            this.secondaryWebView.loadData(str, str2, str3);
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void loadDataWithBaseURL(int i, String str, String str2, String str3, String str4, String str5) {
        if (i == 1) {
            this.primaryWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            if (i != 2) {
                return;
            }
            this.secondaryWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void makeWebViewVisible(int i) {
        if (i == 1) {
            if (this.primaryWebView.getVisibility() == 8) {
                this.primaryWebView.setVisibility(0);
                this.secondaryWebView.setVisibility(8);
                CheckoutUtils.dismissLoader();
                AnalyticsUtil.trackEvent(AnalyticsEvent.WEB_VIEW_SECONDARY_TO_PRIMARY_SWITCH);
                return;
            }
            return;
        }
        if (i == 2 && this.secondaryWebView.getVisibility() == 8) {
            this.primaryWebView.setVisibility(8);
            this.secondaryWebView.setVisibility(0);
            CheckoutUtils.dismissLoader();
            AnalyticsUtil.trackEvent(AnalyticsEvent.WEB_VIEW_PRIMARY_TO_SECONDARY_SWITCH);
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public boolean isWebViewVisible(int i) {
        WebView webView;
        if (i != 1) {
            return i == 2 && (webView = this.secondaryWebView) != null && webView.getVisibility() == 0;
        }
        WebView webView2 = this.primaryWebView;
        return webView2 != null && webView2.getVisibility() == 0;
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void showToast(String str, int i) {
        Toast.makeText(this, str, i).show();
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void destroy(int i, String str) {
        BaseConfig.paymentInProgress = false;
        Intent intent = new Intent();
        intent.putExtra("RESULT", str);
        if (str == null || TextUtils.isEmpty(str)) {
            i = 5;
        }
        setResult(i, intent);
        BaseUtils.getInstance().clearMetadata();
        finish();
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void showProgressBar(int i) {
        RZPProgressBar rZPProgressBar = this.rzpbar;
        if (rZPProgressBar != null) {
            rZPProgressBar.show(i);
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void hideProgressBar() {
        RZPProgressBar rZPProgressBar = this.rzpbar;
        if (rZPProgressBar != null) {
            rZPProgressBar.hide();
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public void clearWebViewHistory(int i) {
        if (i == 1) {
            this.primaryWebView.clearHistory();
        } else {
            if (i != 2) {
                return;
            }
            this.secondaryWebView.clearHistory();
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl.CheckoutView
    public WebView getWebView(int i) {
        if (i == 1) {
            return this.primaryWebView;
        }
        if (i != 2) {
            return null;
        }
        return this.secondaryWebView;
    }

    @Override // android.app.Activity
    public void onPause() {
        CheckoutNfcUtility.INSTANCE.disableReaderMode(this);
        HashMap map = new HashMap();
        if (!this.lifecycleContext.isEmpty()) {
            map.put("reason", this.lifecycleContext);
            Logger.d("CheckoutActivity onPause called with reason: " + this.lifecycleContext);
        } else {
            Logger.d("CheckoutActivity onPause called");
        }
        AnalyticsUtil.trackEvent(AnalyticsEvent.ACTIVITY_ONPAUSE_CALLED, map);
        this.lifecycleContext = "";
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        CheckoutNfcUtility.INSTANCE.resumeReaderModeIfActive(this);
        HashMap map = new HashMap();
        if (!this.lifecycleContext.isEmpty()) {
            map.put("reason", this.lifecycleContext);
            Logger.d("CheckoutActivity onResume called with reason: " + this.lifecycleContext);
        } else {
            Logger.d("CheckoutActivity onResume called");
        }
        AnalyticsUtil.trackEvent(AnalyticsEvent.ACTIVITY_ONRESUME_CALLED, map);
        this.lifecycleContext = "";
        super.onResume();
        this.presenter.onResumeTriggered();
    }
}
