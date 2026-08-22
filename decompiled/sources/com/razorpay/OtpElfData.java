package com.razorpay;

import android.app.Activity;

/* JADX INFO: loaded from: classes9.dex */
class OtpElfData {
    public static String versionKey = "otpelf_version";
    Activity activity;
    private String otpElfJs;

    OtpElfData(Activity activity) {
        this.activity = activity;
    }

    void checkForUpdates() {
        Owl.get(GlobalUrlConfig.instance().getOtpelfVersionUrl(), new Callback() { // from class: com.razorpay.OtpElfData.1
            @Override // com.razorpay.Callback
            public void run(ResponseObject responseObject) {
                if (responseObject.getResponseResult() == null) {
                    return;
                }
                try {
                    String versionFromJsonString = BaseUtils.getVersionFromJsonString(responseObject.getResponseResult(), OtpElfData.versionKey);
                    if (BaseUtils.getLocalVersion(OtpElfData.this.activity, OtpElfData.versionKey).equals(versionFromJsonString)) {
                        return;
                    }
                    AnalyticsUtil.trackEvent(AnalyticsEvent.OTPELF_UPDATE_CALLED);
                    OtpElfData.this.updateOtpElf(versionFromJsonString);
                } catch (Exception unused) {
                    AnalyticsUtil.reportError(getClass().getName(), "S1", "Could not extract version from server json");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOtpElf(final String str) {
        Owl.get(GlobalUrlConfig.instance().getOtpelfJsUrl(), new Callback() { // from class: com.razorpay.OtpElfData.2
            @Override // com.razorpay.Callback
            public void run(ResponseObject responseObject) {
                if (responseObject.getResponseResult() != null) {
                    if (BaseUtils.storeFileInInternal(OtpElfData.this.activity, BaseUtils.getVersionedAssetName(str, CoreConfig.getInstance().getOTPElfJsFileName()), responseObject.getResponseResult())) {
                        OtpElfData.this.otpElfJs = responseObject.getResponseResult();
                        BaseUtils.updateLocalVersion(OtpElfData.this.activity, OtpElfData.versionKey, str);
                        return;
                    }
                    AnalyticsUtil.trackEvent(AnalyticsEvent.OTPELF_LOCAL_SAVE_FAILED);
                }
            }
        });
    }

    String getOtpElfJs() {
        if (this.otpElfJs == null) {
            if (BaseUtils.getLocalVersion(this.activity, versionKey).equals(BaseUtils.getVersionFromJsonString("{\n  \"hash\" : \"c4171614448e750850bd4daca2c7e8d1\",\n  \"magic_hash\": \"e1ff492228196aa72f4892db1e05624e\"\n}\n", versionKey))) {
                this.otpElfJs = CoreConfig.getOtpelfJsFromFile(this.activity, R.raw.otpelf);
            } else {
                try {
                    String fileFromInternal = BaseUtils.getFileFromInternal(this.activity, CoreConfig.getInstance().getOTPElfJsFileName(), versionKey);
                    this.otpElfJs = fileFromInternal;
                    if (fileFromInternal.equals("")) {
                        this.otpElfJs = CoreConfig.getOtpelfJsFromFile(this.activity, R.raw.otpelf);
                    }
                } catch (Exception unused) {
                    this.otpElfJs = CoreConfig.getOtpelfJsFromFile(this.activity, R.raw.otpelf);
                }
            }
        }
        return this.otpElfJs;
    }
}
