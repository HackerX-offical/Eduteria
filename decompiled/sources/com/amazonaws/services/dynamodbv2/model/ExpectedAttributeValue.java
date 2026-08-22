package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ExpectedAttributeValue implements Serializable {
    private List<AttributeValue> attributeValueList;
    private String comparisonOperator;
    private Boolean exists;
    private AttributeValue value;

    public ExpectedAttributeValue() {
    }

    public ExpectedAttributeValue(AttributeValue attributeValue) {
        setValue(attributeValue);
    }

    public ExpectedAttributeValue(Boolean bool) {
        setExists(bool);
    }

    public AttributeValue getValue() {
        return this.value;
    }

    public void setValue(AttributeValue attributeValue) {
        this.value = attributeValue;
    }

    public ExpectedAttributeValue withValue(AttributeValue attributeValue) {
        this.value = attributeValue;
        return this;
    }

    public Boolean isExists() {
        return this.exists;
    }

    public Boolean getExists() {
        return this.exists;
    }

    public void setExists(Boolean bool) {
        this.exists = bool;
    }

    public ExpectedAttributeValue withExists(Boolean bool) {
        this.exists = bool;
        return this;
    }

    public String getComparisonOperator() {
        return this.comparisonOperator;
    }

    public void setComparisonOperator(String str) {
        this.comparisonOperator = str;
    }

    public ExpectedAttributeValue withComparisonOperator(String str) {
        this.comparisonOperator = str;
        return this;
    }

    public void setComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator.toString();
    }

    public ExpectedAttributeValue withComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator.toString();
        return this;
    }

    public List<AttributeValue> getAttributeValueList() {
        return this.attributeValueList;
    }

    public void setAttributeValueList(Collection<AttributeValue> collection) {
        if (collection == null) {
            this.attributeValueList = null;
        } else {
            this.attributeValueList = new ArrayList(collection);
        }
    }

    public ExpectedAttributeValue withAttributeValueList(AttributeValue... attributeValueArr) {
        if (getAttributeValueList() == null) {
            this.attributeValueList = new ArrayList(attributeValueArr.length);
        }
        for (AttributeValue attributeValue : attributeValueArr) {
            this.attributeValueList.add(attributeValue);
        }
        return this;
    }

    public ExpectedAttributeValue withAttributeValueList(Collection<AttributeValue> collection) {
        setAttributeValueList(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getValue() != null) {
            sb.append("Value: " + getValue() + Constants.SEPARATOR_COMMA);
        }
        if (getExists() != null) {
            sb.append("Exists: " + getExists() + Constants.SEPARATOR_COMMA);
        }
        if (getComparisonOperator() != null) {
            sb.append("ComparisonOperator: " + getComparisonOperator() + Constants.SEPARATOR_COMMA);
        }
        if (getAttributeValueList() != null) {
            sb.append("AttributeValueList: " + getAttributeValueList());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getValue() == null ? 0 : getValue().hashCode()) + 31) * 31) + (getExists() == null ? 0 : getExists().hashCode())) * 31) + (getComparisonOperator() == null ? 0 : getComparisonOperator().hashCode())) * 31) + (getAttributeValueList() != null ? getAttributeValueList().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ExpectedAttributeValue)) {
            return false;
        }
        ExpectedAttributeValue expectedAttributeValue = (ExpectedAttributeValue) obj;
        if ((expectedAttributeValue.getValue() == null) ^ (getValue() == null)) {
            return false;
        }
        if (expectedAttributeValue.getValue() != null && !expectedAttributeValue.getValue().equals(getValue())) {
            return false;
        }
        if ((expectedAttributeValue.getExists() == null) ^ (getExists() == null)) {
            return false;
        }
        if (expectedAttributeValue.getExists() != null && !expectedAttributeValue.getExists().equals(getExists())) {
            return false;
        }
        if ((expectedAttributeValue.getComparisonOperator() == null) ^ (getComparisonOperator() == null)) {
            return false;
        }
        if (expectedAttributeValue.getComparisonOperator() != null && !expectedAttributeValue.getComparisonOperator().equals(getComparisonOperator())) {
            return false;
        }
        if ((expectedAttributeValue.getAttributeValueList() == null) ^ (getAttributeValueList() == null)) {
            return false;
        }
        return expectedAttributeValue.getAttributeValueList() == null || expectedAttributeValue.getAttributeValueList().equals(getAttributeValueList());
    }
}
