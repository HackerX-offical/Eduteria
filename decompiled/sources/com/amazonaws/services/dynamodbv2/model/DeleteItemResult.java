package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DeleteItemResult implements Serializable {
    private Map<String, AttributeValue> attributes;
    private ConsumedCapacity consumedCapacity;
    private ItemCollectionMetrics itemCollectionMetrics;

    public Map<String, AttributeValue> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Map<String, AttributeValue> map) {
        this.attributes = map;
    }

    public DeleteItemResult withAttributes(Map<String, AttributeValue> map) {
        this.attributes = map;
        return this;
    }

    public DeleteItemResult addAttributesEntry(String str, AttributeValue attributeValue) {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        if (this.attributes.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.attributes.put(str, attributeValue);
        return this;
    }

    public DeleteItemResult clearAttributesEntries() {
        this.attributes = null;
        return this;
    }

    public ConsumedCapacity getConsumedCapacity() {
        return this.consumedCapacity;
    }

    public void setConsumedCapacity(ConsumedCapacity consumedCapacity) {
        this.consumedCapacity = consumedCapacity;
    }

    public DeleteItemResult withConsumedCapacity(ConsumedCapacity consumedCapacity) {
        this.consumedCapacity = consumedCapacity;
        return this;
    }

    public ItemCollectionMetrics getItemCollectionMetrics() {
        return this.itemCollectionMetrics;
    }

    public void setItemCollectionMetrics(ItemCollectionMetrics itemCollectionMetrics) {
        this.itemCollectionMetrics = itemCollectionMetrics;
    }

    public DeleteItemResult withItemCollectionMetrics(ItemCollectionMetrics itemCollectionMetrics) {
        this.itemCollectionMetrics = itemCollectionMetrics;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAttributes() != null) {
            sb.append("Attributes: " + getAttributes() + Constants.SEPARATOR_COMMA);
        }
        if (getConsumedCapacity() != null) {
            sb.append("ConsumedCapacity: " + getConsumedCapacity() + Constants.SEPARATOR_COMMA);
        }
        if (getItemCollectionMetrics() != null) {
            sb.append("ItemCollectionMetrics: " + getItemCollectionMetrics());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getAttributes() == null ? 0 : getAttributes().hashCode()) + 31) * 31) + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode())) * 31) + (getItemCollectionMetrics() != null ? getItemCollectionMetrics().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteItemResult)) {
            return false;
        }
        DeleteItemResult deleteItemResult = (DeleteItemResult) obj;
        if ((deleteItemResult.getAttributes() == null) ^ (getAttributes() == null)) {
            return false;
        }
        if (deleteItemResult.getAttributes() != null && !deleteItemResult.getAttributes().equals(getAttributes())) {
            return false;
        }
        if ((deleteItemResult.getConsumedCapacity() == null) ^ (getConsumedCapacity() == null)) {
            return false;
        }
        if (deleteItemResult.getConsumedCapacity() != null && !deleteItemResult.getConsumedCapacity().equals(getConsumedCapacity())) {
            return false;
        }
        if ((deleteItemResult.getItemCollectionMetrics() == null) ^ (getItemCollectionMetrics() == null)) {
            return false;
        }
        return deleteItemResult.getItemCollectionMetrics() == null || deleteItemResult.getItemCollectionMetrics().equals(getItemCollectionMetrics());
    }
}
