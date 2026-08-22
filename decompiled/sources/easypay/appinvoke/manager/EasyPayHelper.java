package easypay.appinvoke.manager;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import easypay.appinvoke.entity.AssistDetailsResponse;
import easypay.appinvoke.listeners.JavaScriptCallBacks;
import easypay.appinvoke.utils.AssistLogs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public class EasyPayHelper {
    private AssistDetailsResponse bankResponse;
    private ArrayList<JavaScriptCallBacks> mJsCallListListener = new ArrayList<>();

    EasyPayHelper() {
        PaytmAssist.getAssistInstance().getWebView().addJavascriptInterface(this, Constants.EASYPAY_JS_INTERFACE);
    }

    public AssistDetailsResponse getBankResponse() {
        return this.bankResponse;
    }

    public void setBankResponse(AssistDetailsResponse assistDetailsResponse) {
        this.bankResponse = assistDetailsResponse;
    }

    public void addJsCallListener(JavaScriptCallBacks javaScriptCallBacks) {
        ArrayList<JavaScriptCallBacks> arrayList = this.mJsCallListListener;
        if (arrayList != null) {
            arrayList.add(javaScriptCallBacks);
        }
    }

    @JavascriptInterface
    public void successEvent(int i, String str) {
        if (i != 100 && i != 101) {
            if (i != 107) {
                switch (i) {
                }
                return;
            }
            for (JavaScriptCallBacks javaScriptCallBacks : this.mJsCallListListener) {
                AssistLogs.printLog("EasyPayHelper :Web success Ui callback" + javaScriptCallBacks.toString(), this);
                javaScriptCallBacks.uiCallBack("", str, i);
            }
            return;
        }
        Iterator<JavaScriptCallBacks> it = this.mJsCallListListener.iterator();
        while (it.hasNext()) {
            it.next().helperCallBack("", str, i);
        }
    }

    @JavascriptInterface
    public void NBWatcher(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return;
        }
        if (i == 106) {
            Iterator<JavaScriptCallBacks> it = this.mJsCallListListener.iterator();
            while (it.hasNext()) {
                it.next().helperCallBack("", str, i);
            }
            return;
        }
        if (i != 156) {
            if (i != 157) {
                switch (i) {
                    case 151:
                    case 152:
                    case 153:
                        break;
                    default:
                        switch (i) {
                            case 159:
                            case 160:
                            case 161:
                                break;
                            default:
                                switch (i) {
                                    case 165:
                                        AssistLogs.printLog("Bank Bage optimized called", this);
                                        if (PaytmAssist.getAssistInstance().getmEventMap() != null) {
                                            PaytmAssist.getAssistInstance().getmEventMap().put("isWebPageOptimized", true);
                                            AssistLogs.printLog("Bank Bage optimized called" + PaytmAssist.getAssistInstance().getmEventMap(), this);
                                        }
                                        break;
                                }
                                return;
                        }
                        break;
                }
            }
            Iterator<JavaScriptCallBacks> it2 = this.mJsCallListListener.iterator();
            while (it2.hasNext()) {
                it2.next().uiCallBack(str2, str, i);
            }
            return;
        }
        Iterator<JavaScriptCallBacks> it3 = this.mJsCallListListener.iterator();
        while (it3.hasNext()) {
            it3.next().helperCallBack(str, str2, i);
        }
    }

    @JavascriptInterface
    public void OTPWatcher(String str, String str2, int i) {
        if (i != 108) {
            if (i == 158) {
                Iterator<JavaScriptCallBacks> it = this.mJsCallListListener.iterator();
                while (it.hasNext()) {
                    it.next().uiCallBack(str2, str, i);
                }
                return;
            }
            if (i != 201) {
                if (i == 300) {
                    Iterator<JavaScriptCallBacks> it2 = this.mJsCallListListener.iterator();
                    while (it2.hasNext()) {
                        it2.next().helperCallBack(str2, str, i);
                    }
                    return;
                } else if (i == 221) {
                    Iterator<JavaScriptCallBacks> it3 = this.mJsCallListListener.iterator();
                    while (it3.hasNext()) {
                        it3.next().uiCallBack(str2, str, i);
                    }
                    return;
                } else {
                    if (i != 222) {
                        return;
                    }
                    Iterator<JavaScriptCallBacks> it4 = this.mJsCallListListener.iterator();
                    while (it4.hasNext()) {
                        it4.next().uiCallBack(str2, str, i);
                    }
                    return;
                }
            }
        }
        Iterator<JavaScriptCallBacks> it5 = this.mJsCallListListener.iterator();
        while (it5.hasNext()) {
            it5.next().uiCallBack(str2, str, i);
        }
    }

    @JavascriptInterface
    public void logError(String str) {
        Iterator<JavaScriptCallBacks> it = this.mJsCallListListener.iterator();
        while (it.hasNext()) {
            it.next().uiCallBack("", str, 110);
        }
        PaytmAssist.getAssistInstance().getmEventMap().put("JSError", str);
        if (TextUtils.isEmpty(PaytmAssist.getAssistInstance().getCardDetails())) {
            return;
        }
        PaytmAssist.getAssistInstance().getmEventMap().put("JSError", str + "bank Details" + PaytmAssist.getAssistInstance().getCardDetails());
    }

    @JavascriptInterface
    public void sendBnkDtlToApp(String str) {
        String string;
        String string2;
        AssistLogs.printLog("Json From UI:" + str, this);
        HashMap map = (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, String>>() { // from class: easypay.appinvoke.manager.EasyPayHelper.1
        }.getType());
        String string3 = "";
        if (map == null || map.get(Constants.EXTRA_BANK_CODE) == null) {
            string = "";
        } else {
            string = map.get(Constants.EXTRA_BANK_CODE).toString();
        }
        if (map == null || map.get(Constants.EXTRA_BANK_PAYTYPE) == null) {
            string2 = "";
        } else {
            string2 = map.get(Constants.EXTRA_BANK_PAYTYPE).toString();
        }
        if (map != null && map.get(Constants.EXTRA_BANK_SCHEME) != null) {
            string3 = map.get(Constants.EXTRA_BANK_SCHEME).toString();
        }
        PaytmAssist.getAssistInstance().setBankInfo(string, string2, string3);
    }

    @JavascriptInterface
    public void showLog(String str) {
        Iterator<JavaScriptCallBacks> it = this.mJsCallListListener.iterator();
        while (it.hasNext()) {
            it.next().uiCallBack("", str, 109);
        }
        PaytmAssist.getAssistInstance().setAssistEngineTerminatedStatus(true);
    }
}
