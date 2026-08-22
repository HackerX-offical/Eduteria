package easypay.appinvoke.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.ComposeVersion;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;
import com.clevertap.android.sdk.network.api.CtApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import easypay.appinvoke.actions.EasypayBrowserFragment;
import easypay.appinvoke.actions.GAEventManager;
import easypay.appinvoke.clients.EasypayWebChromeClient;
import easypay.appinvoke.entity.GetUrlResponnse;
import easypay.appinvoke.listeners.AppCallbacks;
import easypay.appinvoke.listeners.AssistEventsCallBack;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.utils.AssistLogs;
import easypay.appinvoke.utils.EasyPayConfigDownloader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class PaytmAssist {
    private static PaytmAssist assistInstance = null;
    private static Context context = null;
    private static boolean isEasyPayActive = true;
    public static boolean isEasyPayEnabled = true;
    private String appVersionTest;
    private String bankName;
    private String cardDetails;
    private String cardScheme;
    private EasyPayHelper easyPayHelper;
    private EasypayBrowserFragment fragment;
    private Integer fragmentViewId;
    private boolean isAssistEngineTerminated;
    private String lastLoadedUrl;
    private AppCompatActivity mActivity;
    private StringBuilder mAnalyticsExtraParam;
    private GAEventManager mAnalyticsManager;
    private AppCallbacks mAppCallback;
    private AssistEventsCallBack mEventCallBack;
    private ArrayList<WebClientListener> mWcListListener;
    private String mid;
    private String orderId;
    private String payType;
    private WebViewClient paymentWebClient;
    private EasypayWebViewClient webClientInstance;
    private WebView webView = null;
    private Map<String, Object> mEventMap = new HashMap();
    private boolean isShowNbLoader = false;
    private String configUrlToHit = "";
    private boolean isFragmentResumed = true;
    private boolean isFragmentStopped = true;

    void setAssistEngineTerminatedStatus(boolean z) {
        this.isAssistEngineTerminated = z;
    }

    boolean getAssistEngineTerminatedStatus() {
        return this.isAssistEngineTerminated;
    }

    public AssistEventsCallBack getmEventCallBack() {
        return this.mEventCallBack;
    }

    public String getAppVersionTest() {
        return this.appVersionTest;
    }

    public void setAppVersionTest(String str) {
        AssistLogs.printLog("AppVersion:" + str, this);
        this.appVersionTest = str;
    }

    public boolean isFragmentResumed() {
        return this.isFragmentResumed;
    }

    public void setFragmentResumed(boolean z) {
        this.isFragmentResumed = z;
    }

    public boolean isFragmentPaused() {
        return this.isFragmentStopped;
    }

    public void setFragmentPaused(boolean z) {
        this.isFragmentStopped = z;
    }

    public Map<String, Object> getmEventMap() {
        return this.mEventMap;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    String getCardDetails() {
        return this.cardDetails;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public static synchronized PaytmAssist getAssistInstance() {
        if (assistInstance == null) {
            assistInstance = new PaytmAssist();
        }
        return assistInstance;
    }

    private static void setAssistInstance(PaytmAssist paytmAssist) {
        assistInstance = paytmAssist;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static boolean getEasyPayActiveStatus() {
        return isEasyPayActive;
    }

    public static void setEasyPayActiveStatus(boolean z) {
        isEasyPayActive = z;
    }

    public static boolean setEasyPayEnabledStatus() {
        return isEasyPayEnabled;
    }

    public static void getEasyPayEnabledStatus(boolean z) {
        isEasyPayEnabled = z;
    }

    public EasyPayHelper getEasyPayHelper() {
        EasyPayHelper easyPayHelper = this.easyPayHelper;
        return easyPayHelper == null ? new EasyPayHelper() : easyPayHelper;
    }

    private void setEasyPayHelper() {
        this.easyPayHelper = new EasyPayHelper();
    }

    public String getLastLoadedUrl() {
        return this.lastLoadedUrl;
    }

    void setLastLoadedUrl(String str) {
        this.lastLoadedUrl = str;
    }

    private void setFragmentViewId(Integer num) {
        this.fragmentViewId = num;
    }

    private void setWebClientInstance(EasypayWebViewClient easypayWebViewClient) {
        this.webClientInstance = easypayWebViewClient;
    }

    public EasypayWebViewClient getWebClientInstance() {
        if (this.webClientInstance == null && this.mActivity != null) {
            this.webClientInstance = new EasypayWebViewClient(this.mActivity);
        }
        return this.webClientInstance;
    }

    private void setWebClientInstance(Activity activity) {
        if (activity != null) {
            this.webClientInstance = new EasypayWebViewClient(activity);
        }
    }

    public void setPaymentWebClient(WebViewClient webViewClient) {
        if (webViewClient != null) {
            this.paymentWebClient = webViewClient;
        } else {
            this.paymentWebClient = this.webClientInstance;
        }
        configureWebClient();
    }

    ArrayList<WebClientListener> getmWcListListener() {
        return this.mWcListListener;
    }

    protected void setmWcListListener(ArrayList<WebClientListener> arrayList) {
        this.mWcListListener = arrayList;
    }

    public StringBuilder getmAnalyticsExtraParam() {
        return this.mAnalyticsExtraParam;
    }

    public void setLoaderVisibility(boolean z) {
        this.isShowNbLoader = z;
    }

    public boolean setAssistLoader() {
        return this.isShowNbLoader;
    }

    public void setmAnalyticsExtraParam(StringBuilder sb) {
        this.mAnalyticsExtraParam = sb;
    }

    public boolean startConfigAssist(Context context2, Boolean bool, Boolean bool2, Integer num, WebView webView, Activity activity, String str, String str2) {
        context = context2;
        this.mActivity = (AppCompatActivity) activity;
        isEasyPayActive = bool.booleanValue();
        isEasyPayEnabled = bool2.booleanValue();
        setWebView(webView);
        setContext(context2);
        setFragmentViewId(num);
        this.orderId = str;
        this.mAnalyticsManager = new GAEventManager();
        StringBuilder sb = new StringBuilder();
        this.mAnalyticsExtraParam = sb;
        sb.append("networkInfo");
        if (getNetworkType(context) != null) {
            this.mAnalyticsExtraParam.append(getNetworkType(context));
        }
        this.mAnalyticsExtraParam.append("deviceInfo");
        this.mAnalyticsExtraParam.append(Build.MANUFACTURER);
        this.mAnalyticsExtraParam.append(Build.MODEL);
        this.mAnalyticsExtraParam.append(Build.DEVICE);
        this.mAnalyticsExtraParam.append(Build.BRAND);
        this.mAnalyticsExtraParam.append("Security patchLevel:");
        this.mAnalyticsExtraParam.append(Build.DISPLAY);
        String strFreeStorage = freeStorage();
        if (TextUtils.isEmpty(strFreeStorage)) {
            strFreeStorage = "N/A";
        }
        this.mAnalyticsExtraParam.append(strFreeStorage);
        this.mEventMap.put("deviceInfo", Build.MANUFACTURER + "|" + Build.MODEL + "|" + Build.DEVICE + "|" + Build.BRAND + "|" + freeStorage());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mEventMap.put("display", displayMetrics.heightPixels + "|" + displayMetrics.widthPixels);
        double d2 = displayMetrics.densityDpi;
        this.mEventMap.put("displayInInches", (((double) displayMetrics.heightPixels) / d2) + "|" + (((double) displayMetrics.widthPixels) / d2));
        this.fragmentViewId = num;
        this.mid = str2;
        this.mWcListListener = new ArrayList<>();
        setWebClientInstance(activity);
        this.webView.addJavascriptInterface(this.mActivity, CtApi.DEFAULT_QUERY_PARAM_OS);
        setOrderId(this.orderId);
        setMid(this.mid);
        setEasyPayHelper();
        this.mAnalyticsManager.isAssitEnabled(bool2.booleanValue());
        return true;
    }

    private void fetchAPIByAppVersion(final String str) {
        new Thread(new Runnable() { // from class: easypay.appinvoke.manager.PaytmAssist.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Constants.FETCH_URL_API).openConnection();
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setConnectTimeout(ComposeVersion.version);
                    httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceType", "android");
                    jSONObject.put("version", "8.2.2");
                    jSONObject.put("orderId", PaytmAssist.getAssistInstance().getOrderId());
                    jSONObject.put("mid", PaytmAssist.getAssistInstance().getMid());
                    jSONObject.put("deviceType", "ANDROID");
                    AssistLogs.printLog("Fetch APi requestURL:https://securegw.paytm.in/payassist/api/getURLByAppVersion", this);
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(jSONObject.toString().getBytes());
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5120);
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    }
                    GetUrlResponnse getUrlResponnse = (GetUrlResponnse) new Gson().fromJson(sb.toString(), GetUrlResponnse.class);
                    if (getUrlResponnse != null && getUrlResponnse.getResponseCode() == 200) {
                        if (!TextUtils.isEmpty(getUrlResponnse.getResponseUrl())) {
                            PaytmAssist.this.setConfigUrlToHit(getUrlResponnse.getResponseUrl());
                            PaytmAssist.this.downloadBankWiseConfig(str);
                            AssistLogs.printLog("Get Config URL to hitURL:" + PaytmAssist.this.getConfigUrlToHit(), this);
                        } else {
                            PaytmAssist.this.setConfigUrlToHit("");
                        }
                    }
                    bufferedInputStream.close();
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }).start();
    }

    private void configureWebClient() {
        WebViewClient paymentWebClient = getAssistInstance().getPaymentWebClient();
        if (paymentWebClient == null) {
            paymentWebClient = getAssistInstance().getWebClientInstance();
        }
        this.webView.setWebViewClient(paymentWebClient);
    }

    public void startAssist() {
        accessCheckApi();
    }

    private void accessCheckApi() {
        new Thread(new Runnable() { // from class: easypay.appinvoke.manager.PaytmAssist.2
            @Override // java.lang.Runnable
            public void run() {
                if (PaytmAssist.this.mid != null) {
                    try {
                        HashMap map = new HashMap();
                        map.put("mid", PaytmAssist.this.mid);
                        MediaType mediaType = MediaType.parse(CtApi.DEFAULT_CONTENT_TYPE);
                        if (new OkHttpClient().newCall(new Request.Builder().url(Constants.WelcomeApi).post(RequestBody.create(mediaType, new GsonBuilder().create().toJson(map))).build()).execute().body() == null || PaytmAssist.this.mActivity == null) {
                            return;
                        }
                        PaytmAssist.this.mActivity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.manager.PaytmAssist.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PaytmAssist.this.initAssist();
                            }
                        });
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void registerSMSCallBack(AppCallbacks appCallbacks) {
        this.mAppCallback = appCallbacks;
    }

    public void setAppSMSCallback(String str) {
        AppCallbacks appCallbacks = this.mAppCallback;
        if (appCallbacks != null) {
            appCallbacks.smsReceivedCallback(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAssist() {
        Context context2;
        AppCompatActivity appCompatActivity = this.mActivity;
        if (appCompatActivity == null || (context2 = context) == null) {
            return;
        }
        try {
            if (isEasyPayEnabled) {
                if (ActivityCompat.checkSelfPermission(context2, "android.permission.READ_SMS") != 0) {
                    if (ActivityCompat.checkSelfPermission(context, "android.permission.READ_SMS") == 0 || !isEasyPayEnabled) {
                        return;
                    }
                    this.mAnalyticsManager.isSmsPermission(false);
                    inflatePaytmAssist();
                    if (this.mActivity.getPackageManager() != null) {
                        this.mAnalyticsManager.assistMerchantDetails(this.mActivity.getPackageName(), this.orderId, this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
                        return;
                    } else {
                        this.mAnalyticsManager.assistMerchantDetails(this.mActivity.getPackageName(), this.orderId, "Version Not Found");
                        return;
                    }
                }
                this.mAnalyticsManager.isSmsPermission(true);
                inflatePaytmAssist();
                if (this.mActivity.getPackageManager() != null) {
                    this.mAnalyticsManager.assistMerchantDetails(this.mActivity.getPackageName(), this.orderId, this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
                    return;
                } else {
                    this.mAnalyticsManager.assistMerchantDetails(this.mActivity.getPackageName(), this.orderId, "Version Not Found");
                    return;
                }
            }
            this.mAnalyticsManager.assistMerchantDetails(this.mActivity.getPackageName(), this.orderId, appCompatActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadBankWiseConfig(String str) {
        try {
            Intent intent = new Intent(this.mActivity, (Class<?>) EasyPayConfigDownloader.class);
            intent.putExtra(Constants.EXTRA_BANK_REQ_JSON, str);
            EasyPayConfigDownloader.enqueueWork(this.mActivity.getBaseContext(), intent);
        } catch (Exception unused) {
        }
    }

    public void removeAssist() {
        try {
            EasypayBrowserFragment easypayBrowserFragment = this.fragment;
            if (easypayBrowserFragment != null && easypayBrowserFragment.isAdded()) {
                FragmentTransaction fragmentTransactionBeginTransaction = this.mActivity.getSupportFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction.remove(this.fragment);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            }
            if (this.mActivity != null) {
                this.mActivity = null;
            }
            if (assistInstance != null) {
                assistInstance = null;
            }
            if (context != null) {
                context = null;
            }
        } catch (Exception unused) {
        }
    }

    private void inflatePaytmAssist() {
        try {
            AssistLogs.printLog("Creating EasypayBrowserFragment", this);
            EasypayBrowserFragment easypayBrowserFragmentNewInstance = EasypayBrowserFragment.newInstance();
            this.fragment = easypayBrowserFragmentNewInstance;
            setFragment(easypayBrowserFragmentNewInstance);
            FragmentTransaction fragmentTransactionBeginTransaction = this.mActivity.getSupportFragmentManager().beginTransaction();
            if (this.mActivity == null || this.fragment.isAdded()) {
                return;
            }
            fragmentTransactionBeginTransaction.add(this.fragmentViewId.intValue(), this.fragment);
            fragmentTransactionBeginTransaction.commit();
            this.webView.setWebChromeClient(new EasypayWebChromeClient(this.fragment));
            this.mAnalyticsManager.assistMerchantDetails(this.mActivity.getPackageName(), this.orderId, this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
            this.mAnalyticsManager.midInfo(this.mid);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public WebView getWebView() {
        return this.webView;
    }

    private void setWebView(WebView webView) {
        this.webView = webView;
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT");
        intent.putExtra("eventName", str);
        intent.putExtra("data0", str2);
        intent.putExtra("data1", str3);
        this.mActivity.sendBroadcast(intent);
    }

    public EasypayBrowserFragment getFragment() {
        return this.fragment;
    }

    public void setFragment(EasypayBrowserFragment easypayBrowserFragment) {
        this.fragment = easypayBrowserFragment;
    }

    public GAEventManager getmAnalyticsManager() {
        return this.mAnalyticsManager;
    }

    public void setmAnalyticsManager(GAEventManager gAEventManager) {
        this.mAnalyticsManager = gAEventManager;
    }

    public void setToolbarText(AppCompatActivity appCompatActivity, String str) throws ClassCastException {
        View viewInflate = appCompatActivity.getLayoutInflater().inflate(R.layout.easy_pay_toolbar, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.easy_pay_toolbar_tv)).setText(str);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setCustomView(viewInflate);
            supportActionBar.setHomeButtonEnabled(false);
        }
    }

    public void setBankInfo(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && str.contains("-")) {
            str = str.substring(0, str.indexOf("-"));
        }
        this.bankName = str;
        this.payType = str2.toLowerCase();
        this.cardScheme = str3.toLowerCase();
        GAEventManager gAEventManager = this.mAnalyticsManager;
        if (gAEventManager != null) {
            gAEventManager.cardType(this.payType);
            this.mAnalyticsManager.cardIssuer(str3);
            this.cardDetails = str + str3 + str2;
            String lowerCase = (str + str3 + str2).toLowerCase();
            if (lowerCase.contains(Constants.EASYPAY_PAYTYPE_ATM) || lowerCase.contains("idebit") || lowerCase.contains("atm")) {
                this.mAnalyticsManager.onNonOTPRequest(true);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_BANK_CODE, str);
                jSONObject.put(Constants.EXTRA_BANK_PAYTYPE, str2);
                jSONObject.put(Constants.EXTRA_BANK_SCHEME, str3);
                fetchAPIByAppVersion(jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private String getNetworkType(Context context2) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "WIFI";
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String freeStorage() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString((((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1048576);
        } catch (Exception unused) {
            return "";
        }
    }

    public String geTxnBank() {
        if (TextUtils.isEmpty(this.bankName)) {
            return null;
        }
        return this.bankName;
    }

    public void setTxnBank(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bankName = str;
    }

    public void setTxnPayType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.payType = str;
    }

    public String getTxnPayType() {
        if (TextUtils.isEmpty(this.payType)) {
            this.payType = "";
        }
        return this.payType;
    }

    private WebViewClient getPaymentWebClient() {
        return this.paymentWebClient;
    }

    public String getConfigUrlToHit() {
        return this.configUrlToHit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigUrlToHit(String str) {
        this.configUrlToHit = str;
    }

    public boolean isAssistLayoutPopped() {
        EasypayBrowserFragment easypayBrowserFragment = this.fragment;
        if (easypayBrowserFragment != null) {
            return easypayBrowserFragment.isAssistVisible;
        }
        return false;
    }
}
