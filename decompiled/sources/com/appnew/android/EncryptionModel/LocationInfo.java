package com.appnew.android.EncryptionModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class LocationInfo implements Serializable {
    private String device_model;
    private String ip;
    private String lat;
    private String lng;
    private String manufacturer;
    private String os_version;

    public String getDevice_model() {
        return this.device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getOs_version() {
        return this.os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
