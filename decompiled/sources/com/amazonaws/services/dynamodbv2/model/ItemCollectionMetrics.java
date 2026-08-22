package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ItemCollectionMetrics implements Serializable {
    private Map<String, AttributeValue> itemCollectionKey;
    private List<Double> sizeEstimateRangeGB;

    public Map<String, AttributeValue> getItemCollectionKey() {
        return this.itemCollectionKey;
    }

    public void setItemCollectionKey(Map<String, AttributeValue> map) {
        this.itemCollectionKey = map;
    }

    public ItemCollectionMetrics withItemCollectionKey(Map<String, AttributeValue> map) {
        this.itemCollectionKey = map;
        return this;
    }

    public ItemCollectionMetrics addItemCollectionKeyEntry(String str, AttributeValue attributeValue) {
        if (this.itemCollectionKey == null) {
            this.itemCollectionKey = new HashMap();
        }
        if (this.itemCollectionKey.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.itemCollectionKey.put(str, attributeValue);
        return this;
    }

    public ItemCollectionMetrics clearItemCollectionKeyEntries() {
        this.itemCollectionKey = null;
        return this;
    }

    public List<Double> getSizeEstimateRangeGB() {
        return this.sizeEstimateRangeGB;
    }

    public void setSizeEstimateRangeGB(Collection<Double> collection) {
        if (collection == null) {
            this.sizeEstimateRangeGB = null;
        } else {
            this.sizeEstimateRangeGB = new ArrayList(collection);
        }
    }

    public ItemCollectionMetrics withSizeEstimateRangeGB(Double... dArr) {
        if (getSizeEstimateRangeGB() == null) {
            this.sizeEstimateRangeGB = new ArrayList(dArr.length);
        }
        for (Double d2 : dArr) {
            this.sizeEstimateRangeGB.add(d2);
        }
        return this;
    }

    public ItemCollectionMetrics withSizeEstimateRangeGB(Collection<Double> collection) {
        setSizeEstimateRangeGB(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getItemCollectionKey() != null) {
            sb.append("ItemCollectionKey: " + getItemCollectionKey() + Constants.SEPARATOR_COMMA);
        }
        if (getSizeEstimateRangeGB() != null) {
            sb.append("SizeEstimateRangeGB: " + getSizeEstimateRangeGB());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getItemCollectionKey() == null ? 0 : getItemCollectionKey().hashCode()) + 31) * 31) + (getSizeEstimateRangeGB() != null ? getSizeEstimateRangeGB().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ItemCollectionMetrics)) {
            return false;
        }
        ItemCollectionMetrics itemCollectionMetrics = (ItemCollectionMetrics) obj;
        if ((itemCollectionMetrics.getItemCollectionKey() == null) ^ (getItemCollectionKey() == null)) {
            return false;
        }
        if (itemCollectionMetrics.getItemCollectionKey() != null && !itemCollectionMetrics.getItemCollectionKey().equals(getItemCollectionKey())) {
            return false;
        }
        if ((itemCollectionMetrics.getSizeEstimateRangeGB() == null) ^ (getSizeEstimateRangeGB() == null)) {
            return false;
        }
        return itemCollectionMetrics.getSizeEstimateRangeGB() == null || itemCollectionMetrics.getSizeEstimateRangeGB().equals(getSizeEstimateRangeGB());
    }
}
