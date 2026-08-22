package com.razorpay;

import android.app.Activity;

/* JADX INFO: loaded from: classes9.dex */
class MagicData {
    public static String versionKey = "magic_version";
    Activity activity;
    private String magicJs;

    MagicData(Activity activity) {
        this.activity = activity;
    }

    void checkForUpdates() {
        Owl.get(ConfigCheckout.getInstance().getMagicVersionUrl(), new Callback() { // from class: com.razorpay.MagicData.1
            @Override // com.razorpay.Callback
            public void run(ResponseObject responseObject) {
                if (responseObject.getResponseResult() == null) {
                    return;
                }
                try {
                    String versionFromJsonString = BaseUtils.getVersionFromJsonString(responseObject.getResponseResult(), MagicData.versionKey);
                    if (BaseUtils.getLocalVersion(MagicData.this.activity, MagicData.versionKey).equals(versionFromJsonString)) {
                        return;
                    }
                    MagicData.this.updateMagic(versionFromJsonString);
                } catch (Exception unused) {
                    AnalyticsUtil.reportError(getClass().getName(), "S1", "Could not extract version from server json");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMagic(final String str) {
        Owl.get(ConfigCheckout.getInstance().getMagicJsUrl(), new Callback() { // from class: com.razorpay.MagicData.2
            @Override // com.razorpay.Callback
            public void run(ResponseObject responseObject) {
                String strDecryptFile;
                if (responseObject.getResponseResult() == null || (strDecryptFile = BaseUtils.decryptFile(responseObject.getResponseResult())) == null) {
                    return;
                }
                if (BaseUtils.storeFileInInternal(MagicData.this.activity, BaseUtils.getVersionedAssetName(str, ConfigCheckout.getInstance().getMagicJsFileName()), responseObject.getResponseResult())) {
                    MagicData.this.magicJs = strDecryptFile;
                    BaseUtils.updateLocalVersion(MagicData.this.activity, MagicData.versionKey, str);
                }
            }
        });
    }

    String getMagicJs() {
        if (this.magicJs == null) {
            if (BaseUtils.getLocalVersion(this.activity, versionKey).equals(BaseUtils.getVersionFromJsonString(ConfigCheckout.getVersionJSON(), versionKey))) {
                this.magicJs = ConfigCheckout.getMagicJs();
            } else {
                try {
                    this.magicJs = BaseUtils.getFileFromInternal(this.activity, ConfigCheckout.getInstance().getMagicJsFileName(), versionKey);
                } catch (Exception unused) {
                    this.magicJs = ConfigCheckout.getMagicJs();
                }
            }
        }
        return this.magicJs;
    }
}
