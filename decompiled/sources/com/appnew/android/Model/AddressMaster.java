package com.appnew.android.Model;

/* JADX INFO: loaded from: classes6.dex */
public class AddressMaster {
    String address;
    String id;
    boolean isChecked;
    String is_default;

    public AddressMaster() {
        this.isChecked = false;
    }

    public AddressMaster(String address, String id, String is_default, boolean isChecked) {
        this.address = address;
        this.id = id;
        this.is_default = is_default;
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_default() {
        return this.is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
