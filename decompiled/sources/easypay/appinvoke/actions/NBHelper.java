package easypay.appinvoke.actions;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.CheckBox;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import easypay.appinvoke.entity.AssistDetailsResponse;
import easypay.appinvoke.entity.Operation;
import easypay.appinvoke.listeners.JavaScriptCallBacks;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasyPayHelper;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.utils.AssistLogs;
import easypay.appinvoke.utils.EasyPaySecureSharedPref;
import java.util.ArrayList;
import java.util.HashMap;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
class NBHelper implements WebClientListener, JavaScriptCallBacks {
    private Activity activity;
    private Operation autoFillOperation;
    private String bank;
    private WebView browser;
    private CheckBox etUserName;
    private EasypayBrowserFragment fragment;
    private GAEventManager mAnalyticsManager;
    private HashMap<String, Operation> operationMap;
    private StringBuilder pwdBuilder;
    private boolean autoFillCalledAlready = false;
    private int mNumberOfSavedUserId = 0;

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void WcshouldInterceptRequest(WebView webView, String str) {
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        return false;
    }

    NBHelper(HashMap<String, Operation> map, WebView webView, Activity activity, AssistDetailsResponse assistDetailsResponse) {
        if (map != null) {
            try {
                this.operationMap = map;
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
                return;
            }
        }
        if (assistDetailsResponse != null) {
            this.bank = assistDetailsResponse.getBank();
        }
        this.browser = webView;
        this.activity = activity;
        this.etUserName = (CheckBox) activity.findViewById(R.id.cb_nb_userId);
        EasyPayHelper easyPayHelper = PaytmAssist.getAssistInstance().getEasyPayHelper();
        this.mAnalyticsManager = PaytmAssist.getAssistInstance().getmAnalyticsManager();
        this.fragment = PaytmAssist.getAssistInstance().getFragment();
        easyPayHelper.addJsCallListener(this);
        PaytmAssist.getAssistInstance().getmAnalyticsManager().isNetBanking(true);
        EasypayWebViewClient webClientInstance = PaytmAssist.getAssistInstance().getWebClientInstance();
        PaytmAssist.getAssistInstance().getmAnalyticsManager().NbUrl(webView.getUrl());
        this.mAnalyticsManager.isNetBanking(true);
        webClientInstance.addAssistWebClientListener(this);
        this.pwdBuilder = new StringBuilder();
        this.fragment.setUIDCheck(true);
        PaytmAssist.getAssistInstance().getmEventMap().put("rememberUserId", "Checked");
    }

    void startNbFeatures(HashMap<String, Operation> map, AssistDetailsResponse assistDetailsResponse) {
        if (map != null) {
            try {
                this.operationMap = map;
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
                return;
            }
        }
        if (assistDetailsResponse != null) {
            this.bank = assistDetailsResponse.getBank();
        }
        HashMap<String, Operation> map2 = this.operationMap;
        if (map2 == null || !map2.containsKey(Constants.FILLER_FROM_WEB)) {
            return;
        }
        fireActions(Constants.FILLER_FROM_WEB, this.operationMap.get(Constants.FILLER_FROM_WEB));
    }

    void fireActions(final String str, final Operation operation) {
        try {
            Activity activity = this.activity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NBHelper.1
                    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                    @Override // java.lang.Runnable
                    public void run() {
                        Operation operation2 = operation;
                        if (operation2 == null || TextUtils.isEmpty(operation2.getJsTemplate())) {
                            return;
                        }
                        try {
                            String str2 = str;
                            switch (str2.hashCode()) {
                                case -2086665488:
                                    if (str2.equals(Constants.NEXT_BTN)) {
                                        AssistLogs.printLog("Action  NEXT_BTN", this);
                                        NBHelper.this.inectJS(operation.getJsTemplate());
                                        return;
                                    }
                                    return;
                                case -1590453867:
                                    if (str2.equals(Constants.SUBMIT_BTN)) {
                                        AssistLogs.printLog("Action  SUBMIT_BTN", this);
                                        NBHelper.this.inectJS(operation.getJsTemplate());
                                        if (NBHelper.this.fragment == null || !NBHelper.this.fragment.isAdded()) {
                                            return;
                                        }
                                        NBHelper.this.fragment.passwordViewer("", 3);
                                        return;
                                    }
                                    return;
                                case -469982381:
                                    if (str2.equals(Constants.AUTOFILL_USERID)) {
                                        AssistLogs.printLog("Inside AUTOFILL_USERID", this);
                                        NBHelper.this.autoFillOperation = operation;
                                        NBHelper.this.fetchUserId();
                                        return;
                                    }
                                    return;
                                case -83625758:
                                    str2.equals(Constants.READ_OTP);
                                    return;
                                case 64933036:
                                    if (!str2.equals(Constants.PASSWORD_INPUT_REGISTER)) {
                                        return;
                                    }
                                    break;
                                case 1110972755:
                                    str2.equals(Constants.FILLER_FROM_CODE);
                                    return;
                                case 1201244404:
                                    if (str2.equals(Constants.PREVIOUS_BTN)) {
                                        NBHelper.this.inectJS(operation.getJsTemplate());
                                        return;
                                    }
                                    return;
                                case 1559877390:
                                    if (str2.equals(Constants.FILLER_FROM_WEB)) {
                                        AssistLogs.printLog(" called Action FILLER_FROM_WEB ", this);
                                        NBHelper.this.inectJS(operation.getJsTemplate());
                                        return;
                                    }
                                    return;
                                case 1881123402:
                                    if (!str2.equals(Constants.PASSWORD_FINDER)) {
                                        return;
                                    }
                                    break;
                                default:
                                    return;
                            }
                            NBHelper.this.inectJS(operation.getJsTemplate());
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillUserId(String str) {
        String jsTemplate = this.autoFillOperation.getJsTemplate();
        try {
            int iIndexOf = jsTemplate.indexOf("''") + 1;
            String str2 = jsTemplate.substring(0, iIndexOf) + str + jsTemplate.substring(iIndexOf);
            AssistLogs.printLog("Autofill JS After UserId" + str2, this);
            EasypayBrowserFragment easypayBrowserFragment = this.fragment;
            if (easypayBrowserFragment != null && easypayBrowserFragment.isAdded()) {
                this.fragment.setUIdToTextView(str);
            }
            AssistLogs.printLog("autofill js:" + str2, this);
            inectJS(str2);
            GAEventManager gAEventManager = this.mAnalyticsManager;
            if (gAEventManager != null) {
                gAEventManager.isAutoFillUserIdSuccess(true);
            }
        } catch (Exception e2) {
            GAEventManager gAEventManager2 = this.mAnalyticsManager;
            if (gAEventManager2 != null) {
                gAEventManager2.isAutoFillUserIdSuccess(false);
            }
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchUserId() {
        AssistLogs.printLog("inside fetch USerID before run", this);
        new Thread(new Runnable() { // from class: easypay.appinvoke.actions.NBHelper.2
            @Override // java.lang.Runnable
            public void run() {
                String string = new EasyPaySecureSharedPref(NBHelper.this.activity.getApplicationContext(), "PaytmAsist").getString(Constants.USER_ID_NET_BANK_KEY, "");
                AssistLogs.printLog("inside fetch USerID" + string, this);
                try {
                    HashMap map = (HashMap) new Gson().fromJson(string, new TypeToken<HashMap<String, ArrayList<String>>>() { // from class: easypay.appinvoke.actions.NBHelper.2.1
                    }.getType());
                    if (map != null) {
                        AssistLogs.printLog("inside fetch USerID", this);
                        final ArrayList arrayList = (ArrayList) map.get(NBHelper.this.bank);
                        if (arrayList != null) {
                            NBHelper.this.mNumberOfSavedUserId = arrayList.size();
                            if (NBHelper.this.mNumberOfSavedUserId > 0) {
                                final String str = (String) arrayList.get(NBHelper.this.mNumberOfSavedUserId - 1);
                                if (NBHelper.this.activity != null && !NBHelper.this.activity.isFinishing()) {
                                    NBHelper.this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NBHelper.2.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            NBHelper.this.fragment.setCurrentUserId(str);
                                            if (NBHelper.this.mNumberOfSavedUserId > 1) {
                                                NBHelper.this.fragment.toggleHistoricIds(NBHelper.this.mNumberOfSavedUserId, true);
                                                NBHelper.this.fragment.toggleSuggestionBox(true);
                                                NBHelper.this.fragment.setHistoricIdTexts(arrayList);
                                            } else {
                                                NBHelper.this.fragment.toggleHistoricIds(NBHelper.this.mNumberOfSavedUserId, false);
                                                NBHelper.this.fragment.toggleSuggestionBox(false);
                                            }
                                        }
                                    });
                                }
                                if (NBHelper.this.activity == null || NBHelper.this.activity.isFinishing()) {
                                    return;
                                }
                                NBHelper.this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NBHelper.2.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NBHelper.this.fillUserId((String) arrayList.get(NBHelper.this.mNumberOfSavedUserId - 1));
                                        NBHelper.this.fragment.hideNBCustIdShowPassword();
                                    }
                                });
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inectJS(String str) {
        try {
            if (this.browser == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.browser.evaluateJavascript(str, new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NBHelper.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str2) {
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageFinish(WebView webView, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                EasypayBrowserFragment easypayBrowserFragment = this.fragment;
                if (easypayBrowserFragment != null) {
                    easypayBrowserFragment.passwordViewer("", 3);
                    return;
                }
                return;
            }
            EasypayBrowserFragment easypayBrowserFragment2 = this.fragment;
            if (easypayBrowserFragment2 != null) {
                easypayBrowserFragment2.passwordViewer("", 4);
                this.fragment.passwordViewer("", 4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    @Override // easypay.appinvoke.listeners.JavaScriptCallBacks
    public void uiCallBack(final String str, final String str2, final int i) {
        try {
            this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NBHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = i;
                    if (i2 == 106) {
                        NBHelper nBHelper = NBHelper.this;
                        nBHelper.fireActions(Constants.PASSWORD_FINDER, (Operation) nBHelper.operationMap.get(Constants.PASSWORD_FINDER));
                        return;
                    }
                    if (i2 == 108) {
                        if (NBHelper.this.fragment.getCurrentNewOtpHelper() != null) {
                            NBHelper.this.fragment.getCurrentNewOtpHelper().passwordInputDataChange("");
                            return;
                        }
                        return;
                    }
                    if (i2 != 157) {
                        switch (i2) {
                            case 151:
                                NBHelper.this.pwdBuilder.append(str2);
                                NBHelper.this.fragment.passwordViewer(str2, 1);
                                break;
                            case 152:
                                if (Constants.IS_RELEASE_8_1_0) {
                                    NBHelper.this.fragment.passwordViewer(str2, 0);
                                } else {
                                    NBHelper.this.fragment.hideNBPasswordShowCustIdView();
                                    NBHelper.this.fragment.toggleView(R.id.layout_netbanking, true);
                                    NBHelper.this.fragment.setUIdToTextView(str2);
                                    NBHelper.this.fragment.mLoaderCount++;
                                    if (!NBHelper.this.autoFillCalledAlready) {
                                        NBHelper.this.autoFillCalledAlready = true;
                                        AssistLogs.printLog("Autofill called", this);
                                        NBHelper nBHelper2 = NBHelper.this;
                                        nBHelper2.fireActions(Constants.AUTOFILL_USERID, (Operation) nBHelper2.operationMap.get(Constants.AUTOFILL_USERID));
                                    }
                                }
                                break;
                            case 153:
                                NBHelper.this.fragment.passwordViewer(str2, 3);
                                break;
                            default:
                                switch (i2) {
                                    case 159:
                                        NBHelper.this.fragment.hideNBCustIdShowPassword();
                                        break;
                                    case 160:
                                        NBHelper.this.fragment.hideNBPasswordShowCustIdView();
                                        if (NBHelper.this.mNumberOfSavedUserId > 0) {
                                            NBHelper.this.fragment.toggleSuggestionBox(true);
                                        }
                                        break;
                                    case 161:
                                        NBHelper.this.fragment.passwordViewer("", 5);
                                        break;
                                }
                                break;
                        }
                        return;
                    }
                    if (NBHelper.this.etUserName == null || !NBHelper.this.etUserName.isChecked()) {
                        return;
                    }
                    NBHelper.this.saveUserId(str);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // easypay.appinvoke.listeners.JavaScriptCallBacks
    public void helperCallBack(String str, String str2, int i) {
        try {
            if (i == 100) {
                fireActions(Constants.SUBMIT_BTN, this.operationMap.get(Constants.SUBMIT_BTN));
                return;
            }
            if (i == 106) {
                fireActions(Constants.PASSWORD_FINDER, this.operationMap.get(Constants.PASSWORD_FINDER));
                return;
            }
            switch (i) {
                case 154:
                    uiStarter(154);
                    fireActions(Constants.PASSWORD_INPUT_REGISTER, this.operationMap.get(Constants.PASSWORD_INPUT_REGISTER));
                    break;
                case 155:
                    EasypayBrowserFragment easypayBrowserFragment = this.fragment;
                    if (easypayBrowserFragment != null) {
                        easypayBrowserFragment.onHelperAction(155, "START OTP FROM NET BANKING");
                    }
                    break;
                case 156:
                    new Handler().postDelayed(new Runnable() { // from class: easypay.appinvoke.actions.NBHelper.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NBHelper nBHelper = NBHelper.this;
                            nBHelper.fireActions(Constants.PASSWORD_FINDER, (Operation) nBHelper.operationMap.get(Constants.PASSWORD_FINDER));
                        }
                    }, 500L);
                    break;
            }
        } catch (Exception unused) {
        }
    }

    private void uiStarter(final int i) {
        try {
            Activity activity = this.activity;
            if (activity == null || this.fragment == null) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NBHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = i;
                    if (i2 == 154) {
                        NBHelper.this.fragment.toggleView(R.id.layout_netbanking, true);
                        NBHelper.this.fragment.passwordViewer("", 1);
                    } else {
                        if (i2 != 156) {
                            return;
                        }
                        NBHelper.this.fragment.toggleView(R.id.layout_netbanking, true);
                        NBHelper.this.fragment.passwordViewer("", 1);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveUserId(String str) {
        String json;
        try {
            EasypayBrowserFragment easypayBrowserFragment = this.fragment;
            if (easypayBrowserFragment == null || easypayBrowserFragment.isSaveIdChecked) {
                EasyPaySecureSharedPref easyPaySecureSharedPref = new EasyPaySecureSharedPref(this.activity.getApplicationContext(), "PaytmAsist");
                EasyPaySecureSharedPref.Editor editorEdit = easyPaySecureSharedPref.edit();
                String str2 = this.bank;
                HashMap map = (HashMap) new Gson().fromJson(easyPaySecureSharedPref.getString(Constants.USER_ID_NET_BANK_KEY, ""), new TypeToken<HashMap<String, ArrayList<String>>>() { // from class: easypay.appinvoke.actions.NBHelper.7
                }.getType());
                Gson gson = new Gson();
                if (map != null) {
                    ArrayList arrayList = (ArrayList) map.get(this.bank);
                    if (arrayList != null) {
                        if (!arrayList.contains(str)) {
                            if (arrayList.size() == 3) {
                                arrayList.remove(0);
                                arrayList.add(str);
                            } else {
                                arrayList.add(str);
                            }
                        } else {
                            arrayList.remove(str);
                            arrayList.add(str);
                        }
                        map.put(str2, arrayList);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str);
                        map.put(str2, arrayList2);
                    }
                    json = gson.toJson(map);
                } else {
                    HashMap map2 = new HashMap();
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str);
                    map2.put(str2, arrayList3);
                    json = gson.toJson(map2);
                }
                editorEdit.putString(Constants.USER_ID_NET_BANK_KEY, json);
                editorEdit.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    void updateValueForAutoFill(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fillUserId(str);
    }

    int getNumberOfSavedId() {
        return this.mNumberOfSavedUserId;
    }
}
