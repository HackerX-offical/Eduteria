package easypay.appinvoke.listeners;

/* JADX INFO: loaded from: classes9.dex */
public interface AnalyticsListener {
    void NBOtpSubmitted(boolean z);

    void NbUrl(String str);

    void OnBackPressClicked(Boolean bool);

    void OnredirectUrls(StringBuilder sb);

    void assistAcsUrl(String str);

    void assistMerchantDetails(String str, String str2, String str3);

    void cardIssuer(String str);

    void cardType(String str);

    void isAssistMinimized(boolean z);

    void isAssitEnabled(boolean z);

    void isAutoFillSuccess(boolean z);

    void isAutoFillUserIdSuccess(boolean z);

    void isAutoSubmit(boolean z);

    void isBankEnabled(boolean z);

    void isNbOtpSelected(boolean z);

    void isNbSubmitButtonClicked(boolean z);

    void isNetBanking(boolean z);

    void isNetBankingInvoked(boolean z);

    void isPauseButtonTapped(boolean z);

    void isRememberUserIdChecked(boolean z);

    void isShowPasswordClicked(boolean z);

    void isSmsPermission(boolean z);

    void isSubmitButtonClicked(boolean z, int i);

    void midInfo(String str);

    void onAcsUrlLoaded(String str);

    void onAcsUrlRequested(String str);

    void onExtraInfo(Object obj);

    void onNonOTPRequest(boolean z);

    void onOTPManuallyEntered(boolean z);

    void onOpenPasswordHelper();

    void onOpenPaytmAssist(boolean z);

    void onOpenPaytmAssistURL(boolean z);

    void onOpenProceedHelper();

    void onOpenRadioHelper();

    void onPasswordHelperURL(String str);

    void onProceedHelperURL(String str);

    void onReadOTPByPaytmAssist(boolean z);

    void onSubmitOtpPaytmAssist(boolean z);

    void onsmsDetected(boolean z);

    void smsSenderName(String str);
}
