package com.appnew.android.player.customview.ExoSpeedDemo;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CookieData implements Serializable {
    private String cloudFrontExpires;
    private String cloudFrontKeyPairId;
    private String cloudFrontSignature;

    public String getCloudFrontKeyPairId() {
        return this.cloudFrontKeyPairId;
    }

    public void setCloudFrontKeyPairId(String cloudFrontKeyPairId) {
        this.cloudFrontKeyPairId = cloudFrontKeyPairId;
    }

    public String getCloudFrontSignature() {
        return this.cloudFrontSignature;
    }

    public void setCloudFrontSignature(String cloudFrontSignature) {
        this.cloudFrontSignature = cloudFrontSignature;
    }

    public String getCloudFrontExpires() {
        return this.cloudFrontExpires;
    }

    public void setCloudFrontExpires(String cloudFrontExpires) {
        this.cloudFrontExpires = cloudFrontExpires;
    }
}
