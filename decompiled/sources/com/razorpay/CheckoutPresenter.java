package com.razorpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.razorpay.BaseCheckoutActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
interface CheckoutPresenter {
    void backPressed(Map<String, Object> map);

    void cleanUpOnDestroy();

    void destroyActivity(int i, String str);

    void fetchCondfig();

    CheckoutOptions getCheckoutOptions();

    String getProgressBarColor();

    List<String> getWalletsWithAppToAppRedirection();

    void handleCardSaving();

    boolean isAllowRotation();

    boolean isMagicPresent();

    void loadFetchedForm(String str, String str2);

    void loadForm(String str);

    void onActivityResultReceived(int i, int i2, Intent intent);

    void onPageFinished(int i, WebView webView, String str);

    void onPageStarted(int i, WebView webView, String str);

    void onProgressChanges(int i, int i2);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onResumeTriggered();

    void passPrefillToSegment();

    void saveInstanceState(Bundle bundle);

    void sendExternalSdkResponse(String str);

    void sendOtpPermissionCallback(boolean z);

    void setCheckoutLoadStartAt();

    void setEventCallback(EventCallback eventCallback);

    boolean setOptions(Bundle bundle, boolean z);

    void setOptionsWithDynamicUrl(Context context, Bundle bundle, boolean z, BaseCheckoutActivity.SetOptionsCallback setOptionsCallback);

    void setSubscribedAnalyticsEvents(ArrayList<String> arrayList);

    void setUpAddOn();

    boolean shouldOverrideUrlLoading(WebView webView, String str);

    void showLoaderDialog(int i, String str);

    void showRetryDialog(int i, String str);

    void unregisterReceivers();
}
