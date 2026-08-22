package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateItemRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, AttributeValueUpdate> attributeUpdates;
    private String conditionExpression;
    private String conditionalOperator;
    private Map<String, ExpectedAttributeValue> expected;
    private Map<String, String> expressionAttributeNames;
    private Map<String, AttributeValue> expressionAttributeValues;
    private Map<String, AttributeValue> key;
    private String returnConsumedCapacity;
    private String returnItemCollectionMetrics;
    private String returnValues;
    private String tableName;
    private String updateExpression;

    public UpdateItemRequest() {
    }

    public UpdateItemRequest(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2) {
        setTableName(str);
        setKey(map);
        setAttributeUpdates(map2);
    }

    public UpdateItemRequest(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2, String str2) {
        setTableName(str);
        setKey(map);
        setAttributeUpdates(map2);
        setReturnValues(str2);
    }

    public UpdateItemRequest(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2, ReturnValue returnValue) {
        setTableName(str);
        setKey(map);
        setAttributeUpdates(map2);
        setReturnValues(returnValue.toString());
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public UpdateItemRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public Map<String, AttributeValue> getKey() {
        return this.key;
    }

    public void setKey(Map<String, AttributeValue> map) {
        this.key = map;
    }

    public UpdateItemRequest withKey(Map<String, AttributeValue> map) {
        this.key = map;
        return this;
    }

    public UpdateItemRequest addKeyEntry(String str, AttributeValue attributeValue) {
        if (this.key == null) {
            this.key = new HashMap();
        }
        if (this.key.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.key.put(str, attributeValue);
        return this;
    }

    public UpdateItemRequest clearKeyEntries() {
        this.key = null;
        return this;
    }

    public Map<String, AttributeValueUpdate> getAttributeUpdates() {
        return this.attributeUpdates;
    }

    public void setAttributeUpdates(Map<String, AttributeValueUpdate> map) {
        this.attributeUpdates = map;
    }

    public UpdateItemRequest withAttributeUpdates(Map<String, AttributeValueUpdate> map) {
        this.attributeUpdates = map;
        return this;
    }

    public UpdateItemRequest addAttributeUpdatesEntry(String str, AttributeValueUpdate attributeValueUpdate) {
        if (this.attributeUpdates == null) {
            this.attributeUpdates = new HashMap();
        }
        if (this.attributeUpdates.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.attributeUpdates.put(str, attributeValueUpdate);
        return this;
    }

    public UpdateItemRequest clearAttributeUpdatesEntries() {
        this.attributeUpdates = null;
        return this;
    }

    public Map<String, ExpectedAttributeValue> getExpected() {
        return this.expected;
    }

    public void setExpected(Map<String, ExpectedAttributeValue> map) {
        this.expected = map;
    }

    public UpdateItemRequest withExpected(Map<String, ExpectedAttributeValue> map) {
        this.expected = map;
        return this;
    }

    public UpdateItemRequest addExpectedEntry(String str, ExpectedAttributeValue expectedAttributeValue) {
        if (this.expected == null) {
            this.expected = new HashMap();
        }
        if (this.expected.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.expected.put(str, expectedAttributeValue);
        return this;
    }

    public UpdateItemRequest clearExpectedEntries() {
        this.expected = null;
        return this;
    }

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    public void setConditionalOperator(String str) {
        this.conditionalOperator = str;
    }

    public UpdateItemRequest withConditionalOperator(String str) {
        this.conditionalOperator = str;
        return this;
    }

    public void setConditionalOperator(ConditionalOperator conditionalOperator) {
        this.conditionalOperator = conditionalOperator.toString();
    }

    public UpdateItemRequest withConditionalOperator(ConditionalOperator conditionalOperator) {
        this.conditionalOperator = conditionalOperator.toString();
        return this;
    }

    public String getReturnValues() {
        return this.returnValues;
    }

    public void setReturnValues(String str) {
        this.returnValues = str;
    }

    public UpdateItemRequest withReturnValues(String str) {
        this.returnValues = str;
        return this;
    }

    public void setReturnValues(ReturnValue returnValue) {
        this.returnValues = returnValue.toString();
    }

    public UpdateItemRequest withReturnValues(ReturnValue returnValue) {
        this.returnValues = returnValue.toString();
        return this;
    }

    public String getReturnConsumedCapacity() {
        return this.returnConsumedCapacity;
    }

    public void setReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
    }

    public UpdateItemRequest withReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
        return this;
    }

    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity.toString();
    }

    public UpdateItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity.toString();
        return this;
    }

    public String getReturnItemCollectionMetrics() {
        return this.returnItemCollectionMetrics;
    }

    public void setReturnItemCollectionMetrics(String str) {
        this.returnItemCollectionMetrics = str;
    }

    public UpdateItemRequest withReturnItemCollectionMetrics(String str) {
        this.returnItemCollectionMetrics = str;
        return this;
    }

    public void setReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics) {
        this.returnItemCollectionMetrics = returnItemCollectionMetrics.toString();
    }

    public UpdateItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics) {
        this.returnItemCollectionMetrics = returnItemCollectionMetrics.toString();
        return this;
    }

    public String getUpdateExpression() {
        return this.updateExpression;
    }

    public void setUpdateExpression(String str) {
        this.updateExpression = str;
    }

    public UpdateItemRequest withUpdateExpression(String str) {
        this.updateExpression = str;
        return this;
    }

    public String getConditionExpression() {
        return this.conditionExpression;
    }

    public void setConditionExpression(String str) {
        this.conditionExpression = str;
    }

    public UpdateItemRequest withConditionExpression(String str) {
        this.conditionExpression = str;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
    }

    public UpdateItemRequest withExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
        return this;
    }

    public UpdateItemRequest addExpressionAttributeNamesEntry(String str, String str2) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (this.expressionAttributeNames.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.expressionAttributeNames.put(str, str2);
        return this;
    }

    public UpdateItemRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public Map<String, AttributeValue> getExpressionAttributeValues() {
        return this.expressionAttributeValues;
    }

    public void setExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
    }

    public UpdateItemRequest withExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
        return this;
    }

    public UpdateItemRequest addExpressionAttributeValuesEntry(String str, AttributeValue attributeValue) {
        if (this.expressionAttributeValues == null) {
            this.expressionAttributeValues = new HashMap();
        }
        if (this.expressionAttributeValues.containsKey(str)) {
            throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
        }
        this.expressionAttributeValues.put(str, attributeValue);
        return this;
    }

    public UpdateItemRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getKey() != null) {
            sb.append("Key: " + getKey() + Constants.SEPARATOR_COMMA);
        }
        if (getAttributeUpdates() != null) {
            sb.append("AttributeUpdates: " + getAttributeUpdates() + Constants.SEPARATOR_COMMA);
        }
        if (getExpected() != null) {
            sb.append("Expected: " + getExpected() + Constants.SEPARATOR_COMMA);
        }
        if (getConditionalOperator() != null) {
            sb.append("ConditionalOperator: " + getConditionalOperator() + Constants.SEPARATOR_COMMA);
        }
        if (getReturnValues() != null) {
            sb.append("ReturnValues: " + getReturnValues() + Constants.SEPARATOR_COMMA);
        }
        if (getReturnConsumedCapacity() != null) {
            sb.append("ReturnConsumedCapacity: " + getReturnConsumedCapacity() + Constants.SEPARATOR_COMMA);
        }
        if (getReturnItemCollectionMetrics() != null) {
            sb.append("ReturnItemCollectionMetrics: " + getReturnItemCollectionMetrics() + Constants.SEPARATOR_COMMA);
        }
        if (getUpdateExpression() != null) {
            sb.append("UpdateExpression: " + getUpdateExpression() + Constants.SEPARATOR_COMMA);
        }
        if (getConditionExpression() != null) {
            sb.append("ConditionExpression: " + getConditionExpression() + Constants.SEPARATOR_COMMA);
        }
        if (getExpressionAttributeNames() != null) {
            sb.append("ExpressionAttributeNames: " + getExpressionAttributeNames() + Constants.SEPARATOR_COMMA);
        }
        if (getExpressionAttributeValues() != null) {
            sb.append("ExpressionAttributeValues: " + getExpressionAttributeValues());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((((((((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getKey() == null ? 0 : getKey().hashCode())) * 31) + (getAttributeUpdates() == null ? 0 : getAttributeUpdates().hashCode())) * 31) + (getExpected() == null ? 0 : getExpected().hashCode())) * 31) + (getConditionalOperator() == null ? 0 : getConditionalOperator().hashCode())) * 31) + (getReturnValues() == null ? 0 : getReturnValues().hashCode())) * 31) + (getReturnConsumedCapacity() == null ? 0 : getReturnConsumedCapacity().hashCode())) * 31) + (getReturnItemCollectionMetrics() == null ? 0 : getReturnItemCollectionMetrics().hashCode())) * 31) + (getUpdateExpression() == null ? 0 : getUpdateExpression().hashCode())) * 31) + (getConditionExpression() == null ? 0 : getConditionExpression().hashCode())) * 31) + (getExpressionAttributeNames() == null ? 0 : getExpressionAttributeNames().hashCode())) * 31) + (getExpressionAttributeValues() != null ? getExpressionAttributeValues().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateItemRequest)) {
            return false;
        }
        UpdateItemRequest updateItemRequest = (UpdateItemRequest) obj;
        if ((updateItemRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (updateItemRequest.getTableName() != null && !updateItemRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((updateItemRequest.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (updateItemRequest.getKey() != null && !updateItemRequest.getKey().equals(getKey())) {
            return false;
        }
        if ((updateItemRequest.getAttributeUpdates() == null) ^ (getAttributeUpdates() == null)) {
            return false;
        }
        if (updateItemRequest.getAttributeUpdates() != null && !updateItemRequest.getAttributeUpdates().equals(getAttributeUpdates())) {
            return false;
        }
        if ((updateItemRequest.getExpected() == null) ^ (getExpected() == null)) {
            return false;
        }
        if (updateItemRequest.getExpected() != null && !updateItemRequest.getExpected().equals(getExpected())) {
            return false;
        }
        if ((updateItemRequest.getConditionalOperator() == null) ^ (getConditionalOperator() == null)) {
            return false;
        }
        if (updateItemRequest.getConditionalOperator() != null && !updateItemRequest.getConditionalOperator().equals(getConditionalOperator())) {
            return false;
        }
        if ((updateItemRequest.getReturnValues() == null) ^ (getReturnValues() == null)) {
            return false;
        }
        if (updateItemRequest.getReturnValues() != null && !updateItemRequest.getReturnValues().equals(getReturnValues())) {
            return false;
        }
        if ((updateItemRequest.getReturnConsumedCapacity() == null) ^ (getReturnConsumedCapacity() == null)) {
            return false;
        }
        if (updateItemRequest.getReturnConsumedCapacity() != null && !updateItemRequest.getReturnConsumedCapacity().equals(getReturnConsumedCapacity())) {
            return false;
        }
        if ((updateItemRequest.getReturnItemCollectionMetrics() == null) ^ (getReturnItemCollectionMetrics() == null)) {
            return false;
        }
        if (updateItemRequest.getReturnItemCollectionMetrics() != null && !updateItemRequest.getReturnItemCollectionMetrics().equals(getReturnItemCollectionMetrics())) {
            return false;
        }
        if ((updateItemRequest.getUpdateExpression() == null) ^ (getUpdateExpression() == null)) {
            return false;
        }
        if (updateItemRequest.getUpdateExpression() != null && !updateItemRequest.getUpdateExpression().equals(getUpdateExpression())) {
            return false;
        }
        if ((updateItemRequest.getConditionExpression() == null) ^ (getConditionExpression() == null)) {
            return false;
        }
        if (updateItemRequest.getConditionExpression() != null && !updateItemRequest.getConditionExpression().equals(getConditionExpression())) {
            return false;
        }
        if ((updateItemRequest.getExpressionAttributeNames() == null) ^ (getExpressionAttributeNames() == null)) {
            return false;
        }
        if (updateItemRequest.getExpressionAttributeNames() != null && !updateItemRequest.getExpressionAttributeNames().equals(getExpressionAttributeNames())) {
            return false;
        }
        if ((updateItemRequest.getExpressionAttributeValues() == null) ^ (getExpressionAttributeValues() == null)) {
            return false;
        }
        return updateItemRequest.getExpressionAttributeValues() == null || updateItemRequest.getExpressionAttributeValues().equals(getExpressionAttributeValues());
    }
}
