package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class DrishtiVerification implements Serializable {
    private String backImage;
    private String drishtiId;
    private String frontImage;
    private String isVerified;

    public String getDrishtiId() {
        return this.drishtiId;
    }

    public void setDrishtiId(String drishtiId) {
        this.drishtiId = drishtiId;
    }

    public String getFrontImage() {
        return this.frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    public String getBackImage() {
        return this.backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public String getIsVerified() {
        return this.isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }
}
