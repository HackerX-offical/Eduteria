package com.appnew.android.Utils;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class CookieHelper implements Parcelable {
    public static final Parcelable.Creator<CookieHelper> CREATOR = new Parcelable.Creator<CookieHelper>() { // from class: com.appnew.android.Utils.CookieHelper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CookieHelper createFromParcel(Parcel in) {
            return new CookieHelper(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CookieHelper[] newArray(int size) {
            return new CookieHelper[size];
        }
    };
    private String expires;
    private boolean isV2;
    private String keyPairId;
    private String signature;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CookieHelper() {
        this.isV2 = false;
    }

    public CookieHelper(Parcel in) {
        this.isV2 = false;
        this.expires = in.readString();
        this.signature = in.readString();
        this.keyPairId = in.readString();
        this.isV2 = in.readByte() != 0;
    }

    public boolean isV2() {
        return this.isV2;
    }

    public void setV2(boolean v2) {
        this.isV2 = v2;
    }

    public String getExpires() {
        return this.expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getKeyPairId() {
        return this.keyPairId;
    }

    public void setKeyPairId(String keyPairId) {
        this.keyPairId = keyPairId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.expires);
        parcel.writeString(this.signature);
        parcel.writeString(this.keyPairId);
        parcel.writeByte(this.isV2 ? (byte) 1 : (byte) 0);
    }
}
