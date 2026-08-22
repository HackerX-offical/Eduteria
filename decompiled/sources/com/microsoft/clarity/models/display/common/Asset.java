package com.microsoft.clarity.models.display.common;

import com.microsoft.clarity.models.AssetType;

/* JADX INFO: loaded from: classes9.dex */
public class Asset {
    private transient byte[] data;
    private String dataHash;
    private transient AssetType type;

    public Asset(AssetType assetType, byte[] bArr, String str) {
        this.type = assetType;
        this.data = bArr;
        this.dataHash = str;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getDataHash() {
        return this.dataHash;
    }

    public AssetType getType() {
        return this.type;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDataHash(String str) {
        this.dataHash = str;
    }

    public void setType(AssetType assetType) {
        this.type = assetType;
    }
}
