package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class AddressUser implements Serializable {
    private AddressData address;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressData getAddress() {
        return this.address;
    }

    public void setAddress(AddressData address) {
        this.address = address;
    }
}
