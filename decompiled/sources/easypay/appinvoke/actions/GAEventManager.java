package easypay.appinvoke.actions;

import android.text.TextUtils;
import com.appnew.android.Utils.Const;
import easypay.appinvoke.listeners.AnalyticsListener;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.utils.AssistLogs;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class GAEventManager implements AnalyticsListener, Serializable {
    private HashMap<String, Object> mEventMap = new HashMap<>();

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isNetBanking(boolean z) {
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onOpenPasswordHelper() {
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onOpenPaytmAssist(boolean z) {
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onOpenProceedHelper() {
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onOpenRadioHelper() {
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onPasswordHelperURL(String str) {
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onProceedHelperURL(String str) {
    }

    HashMap<String, Object> getEventMap() {
        return this.mEventMap;
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void midInfo(String str) {
        this.mEventMap.put("mid", str);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onOpenPaytmAssistURL(boolean z) {
        AssistLogs.printLog("AssistAnalytics:isAssistPopped:" + z, this);
        this.mEventMap.put("isAssistPopped", Boolean.valueOf(z));
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void assistMerchantDetails(String str, String str2, String str3) {
        this.mEventMap.put("appName", str);
        this.mEventMap.put("orderId", str2);
        this.mEventMap.put("appVersion", str3);
        AssistLogs.printLog("AssistAnalytics:" + str + str2 + str3, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isSmsPermission(boolean z) {
        this.mEventMap.put("smsPermission", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:smsPermission:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void smsSenderName(String str) {
        this.mEventMap.put("sender", str);
        AssistLogs.printLog("AssistAnalytics:sender:" + str, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void cardIssuer(String str) {
        this.mEventMap.put("cardIssuer", str);
        AssistLogs.printLog("AssistAnalytics:cardIssuer:" + str, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onReadOTPByPaytmAssist(boolean z) {
        this.mEventMap.put("isSMSRead", true);
        this.mEventMap.put(Const.OTP, Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isSMSRead:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void cardType(String str) {
        this.mEventMap.put("cardType", str);
        AssistLogs.printLog("AssistAnalytics:cardType:" + str, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onSubmitOtpPaytmAssist(boolean z) {
        this.mEventMap.put("isSubmitted", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isSubmitted:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isAssitEnabled(boolean z) {
        this.mEventMap.put("isAssistEnable", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isAssistEnabled:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void assistAcsUrl(String str) {
        this.mEventMap.put("acsUrl", str);
        AssistLogs.printLog("AssistAnalytics:acsUrl:" + str, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isNetBankingInvoked(boolean z) {
        this.mEventMap.put("isNetbanking", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isNetbanking:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void NbUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mEventMap.put("NBPageUrl", str);
            this.mEventMap.put("acsUrl", str);
        } else {
            this.mEventMap.put("NBPageUrl", "URl Not supported|couldnot invoke netbaking asssist");
        }
        AssistLogs.printLog("AssistAnalytics:NbPageUrl:" + str, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void NBOtpSubmitted(boolean z) {
        this.mEventMap.put("NBOtpSubmitted", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:NBOtpSubmitted:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isNbOtpSelected(boolean z) {
        this.mEventMap.put("NBIsotpSelected", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:NbIsotpSelected:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void OnBackPressClicked(Boolean bool) {
        AssistLogs.printLog("AssistAnalytics:backPressClicked:" + bool, this);
        if (PaytmAssist.getAssistInstance().isFragmentResumed()) {
            if (TextUtils.isEmpty(PaytmAssist.getAssistInstance().getLastLoadedUrl()) || PaytmAssist.getAssistInstance().getLastLoadedUrl().contains("paytm")) {
                return;
            }
            this.mEventMap.put("isBackClickedOnAcsPage", bool);
            return;
        }
        if (PaytmAssist.getAssistInstance().isFragmentPaused()) {
            return;
        }
        this.mEventMap.put("backPressClicked", bool);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onAcsUrlRequested(String str) {
        this.mEventMap.put("acsUrlRequested", str);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onAcsUrlLoaded(String str) {
        this.mEventMap.put("acsUrlLoaded", str);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onOTPManuallyEntered(boolean z) {
        this.mEventMap.put("OTPManuallyEntered", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:OTPManuallyEntered:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onNonOTPRequest(boolean z) {
        this.mEventMap.put("NonOTPRequest", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:NonOTPRequest:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onsmsDetected(boolean z) {
        this.mEventMap.put("smsDetected", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:smsDetected:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void OnredirectUrls(StringBuilder sb) {
        this.mEventMap.put("redirectUrls", sb.toString());
        AssistLogs.printLog("AssistAnalytics:redirectUrls:" + sb.toString(), this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void onExtraInfo(Object obj) {
        try {
            this.mEventMap.put("extendedInfo", (HashMap) obj);
            AssistLogs.printLog("AssistAnalytics:extendedInfo:" + obj.toString(), this);
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isSubmitButtonClicked(boolean z, int i) {
        PaytmAssist.getAssistInstance().getmEventMap().put("buttonClicked", Boolean.valueOf(z));
        PaytmAssist.getAssistInstance().getmEventMap().put("buttonClickedCount", Integer.valueOf(i));
        this.mEventMap.put("buttonClickedWithCount", PaytmAssist.getAssistInstance().getmEventMap());
        AssistLogs.printLog("AssistAnalytics:buttonClickedWithCount:" + PaytmAssist.getAssistInstance().getmEventMap(), this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isAutoSubmit(boolean z) {
        PaytmAssist.getAssistInstance().getmEventMap().put("autoSubmit", Boolean.valueOf(z));
        this.mEventMap.put("autoSubmitAssist", PaytmAssist.getAssistInstance().getmEventMap());
        AssistLogs.printLog("AssistAnalytics:autoSubmitAssist:" + PaytmAssist.getAssistInstance().getmEventMap(), this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isAutoFillSuccess(boolean z) {
        PaytmAssist.getAssistInstance().getmEventMap().put("isAutoFillSuccess", Boolean.valueOf(z));
        this.mEventMap.put("isAutoFillSuccess", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isAutoFillSuccess:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isBankEnabled(boolean z) {
        this.mEventMap.put("isBankEnabled", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isBankEnabled:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isRememberUserIdChecked(boolean z) {
        this.mEventMap.put("isRememberUserIdChecked", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isRememberUserIdChecked:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isPauseButtonTapped(boolean z) {
        this.mEventMap.put("isPauseButtonTapped", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isPauseButtonTapped:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isShowPasswordClicked(boolean z) {
        this.mEventMap.put("isShowPasswordClicked", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isShowPasswordClicked:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isAutoFillUserIdSuccess(boolean z) {
        this.mEventMap.put("isAutoFillUserIdSuccess", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isAutoFillUserIdSuccess:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isNbSubmitButtonClicked(boolean z) {
        this.mEventMap.put("isNbSubmitButtonClicked", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isNbSubmitButtonClicked:" + z, this);
    }

    @Override // easypay.appinvoke.listeners.AnalyticsListener
    public void isAssistMinimized(boolean z) {
        this.mEventMap.put("isAssistMinimized", Boolean.valueOf(z));
        AssistLogs.printLog("AssistAnalytics:isAssistMinimized:" + z, this);
    }
}
