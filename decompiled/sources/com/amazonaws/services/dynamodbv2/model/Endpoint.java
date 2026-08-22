package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class Endpoint implements Serializable {
    private String address;
    private Long cachePeriodInMinutes;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public Endpoint withAddress(String str) {
        this.address = str;
        return this;
    }

    public Long getCachePeriodInMinutes() {
        return this.cachePeriodInMinutes;
    }

    public void setCachePeriodInMinutes(Long l) {
        this.cachePeriodInMinutes = l;
    }

    public Endpoint withCachePeriodInMinutes(Long l) {
        this.cachePeriodInMinutes = l;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAddress() != null) {
            sb.append("Address: " + getAddress() + Constants.SEPARATOR_COMMA);
        }
        if (getCachePeriodInMinutes() != null) {
            sb.append("CachePeriodInMinutes: " + getCachePeriodInMinutes());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getAddress() == null ? 0 : getAddress().hashCode()) + 31) * 31) + (getCachePeriodInMinutes() != null ? getCachePeriodInMinutes().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Endpoint)) {
            return false;
        }
        Endpoint endpoint = (Endpoint) obj;
        if ((endpoint.getAddress() == null) ^ (getAddress() == null)) {
            return false;
        }
        if (endpoint.getAddress() != null && !endpoint.getAddress().equals(getAddress())) {
            return false;
        }
        if ((endpoint.getCachePeriodInMinutes() == null) ^ (getCachePeriodInMinutes() == null)) {
            return false;
        }
        return endpoint.getCachePeriodInMinutes() == null || endpoint.getCachePeriodInMinutes().equals(getCachePeriodInMinutes());
    }
}
