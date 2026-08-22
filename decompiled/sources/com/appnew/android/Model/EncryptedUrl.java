package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class EncryptedUrl implements Serializable {
    private String encrypt_type;
    private String name;
    private String size;
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return this.name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEncrypt_type() {
        return this.encrypt_type;
    }

    public void setEncrypt_type(String encrypt_type) {
        this.encrypt_type = encrypt_type;
    }
}
