package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class GetItemResult implements Serializable {
    private ConsumedCapacity consumedCapacity;
    private Map<String, AttributeValue> item;

    public Map<String, AttributeValue> getItem() {
        return this.item;
    }

    public void setItem(Map<String, AttributeValue> map) {
        this.item = map;
    }

    public GetItemResult withItem(Map<String, AttributeValue> map) {
        this.item = map;
        return this;
    }

    public GetItemResult addItemEntry(String str, AttributeValue attributeValue) {
        if (this.item == null) {
            this.item = new HashMap();
        }
        if (this.item.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.item.put(str, attributeValue);
        return this;
    }

    public GetItemResult clearItemEntries() {
        this.item = null;
        return this;
    }

    public ConsumedCapacity getConsumedCapacity() {
        return this.consumedCapacity;
    }

    public void setConsumedCapacity(ConsumedCapacity consumedCapacity) {
        this.consumedCapacity = consumedCapacity;
    }

    public GetItemResult withConsumedCapacity(ConsumedCapacity consumedCapacity) {
        this.consumedCapacity = consumedCapacity;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getItem() != null) {
            sb.append("Item: " + getItem() + Constants.SEPARATOR_COMMA);
        }
        if (getConsumedCapacity() != null) {
            sb.append("ConsumedCapacity: " + getConsumedCapacity());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getItem() == null ? 0 : getItem().hashCode()) + 31) * 31) + (getConsumedCapacity() != null ? getConsumedCapacity().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetItemResult)) {
            return false;
        }
        GetItemResult getItemResult = (GetItemResult) obj;
        if ((getItemResult.getItem() == null) ^ (getItem() == null)) {
            return false;
        }
        if (getItemResult.getItem() != null && !getItemResult.getItem().equals(getItem())) {
            return false;
        }
        if ((getItemResult.getConsumedCapacity() == null) ^ (getConsumedCapacity() == null)) {
            return false;
        }
        return getItemResult.getConsumedCapacity() == null || getItemResult.getConsumedCapacity().equals(getConsumedCapacity());
    }
}
