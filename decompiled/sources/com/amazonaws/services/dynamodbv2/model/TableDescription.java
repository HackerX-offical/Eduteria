package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TableDescription implements Serializable {
    private List<AttributeDefinition> attributeDefinitions;
    private Date creationDateTime;
    private List<GlobalSecondaryIndexDescription> globalSecondaryIndexes;
    private Long itemCount;
    private List<KeySchemaElement> keySchema;
    private String latestStreamArn;
    private String latestStreamLabel;
    private List<LocalSecondaryIndexDescription> localSecondaryIndexes;
    private ProvisionedThroughputDescription provisionedThroughput;
    private RestoreSummary restoreSummary;
    private SSEDescription sSEDescription;
    private StreamSpecification streamSpecification;
    private String tableArn;
    private String tableId;
    private String tableName;
    private Long tableSizeBytes;
    private String tableStatus;

    public List<AttributeDefinition> getAttributeDefinitions() {
        return this.attributeDefinitions;
    }

    public void setAttributeDefinitions(Collection<AttributeDefinition> collection) {
        if (collection == null) {
            this.attributeDefinitions = null;
        } else {
            this.attributeDefinitions = new ArrayList(collection);
        }
    }

    public TableDescription withAttributeDefinitions(AttributeDefinition... attributeDefinitionArr) {
        if (getAttributeDefinitions() == null) {
            this.attributeDefinitions = new ArrayList(attributeDefinitionArr.length);
        }
        for (AttributeDefinition attributeDefinition : attributeDefinitionArr) {
            this.attributeDefinitions.add(attributeDefinition);
        }
        return this;
    }

    public TableDescription withAttributeDefinitions(Collection<AttributeDefinition> collection) {
        setAttributeDefinitions(collection);
        return this;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public TableDescription withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public List<KeySchemaElement> getKeySchema() {
        return this.keySchema;
    }

    public void setKeySchema(Collection<KeySchemaElement> collection) {
        if (collection == null) {
            this.keySchema = null;
        } else {
            this.keySchema = new ArrayList(collection);
        }
    }

    public TableDescription withKeySchema(KeySchemaElement... keySchemaElementArr) {
        if (getKeySchema() == null) {
            this.keySchema = new ArrayList(keySchemaElementArr.length);
        }
        for (KeySchemaElement keySchemaElement : keySchemaElementArr) {
            this.keySchema.add(keySchemaElement);
        }
        return this;
    }

    public TableDescription withKeySchema(Collection<KeySchemaElement> collection) {
        setKeySchema(collection);
        return this;
    }

    public String getTableStatus() {
        return this.tableStatus;
    }

    public void setTableStatus(String str) {
        this.tableStatus = str;
    }

    public TableDescription withTableStatus(String str) {
        this.tableStatus = str;
        return this;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus.toString();
    }

    public TableDescription withTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus.toString();
        return this;
    }

    public Date getCreationDateTime() {
        return this.creationDateTime;
    }

    public void setCreationDateTime(Date date) {
        this.creationDateTime = date;
    }

    public TableDescription withCreationDateTime(Date date) {
        this.creationDateTime = date;
        return this;
    }

    public ProvisionedThroughputDescription getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughputDescription) {
        this.provisionedThroughput = provisionedThroughputDescription;
    }

    public TableDescription withProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughputDescription) {
        this.provisionedThroughput = provisionedThroughputDescription;
        return this;
    }

    public Long getTableSizeBytes() {
        return this.tableSizeBytes;
    }

    public void setTableSizeBytes(Long l) {
        this.tableSizeBytes = l;
    }

    public TableDescription withTableSizeBytes(Long l) {
        this.tableSizeBytes = l;
        return this;
    }

    public Long getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(Long l) {
        this.itemCount = l;
    }

    public TableDescription withItemCount(Long l) {
        this.itemCount = l;
        return this;
    }

    public String getTableArn() {
        return this.tableArn;
    }

    public void setTableArn(String str) {
        this.tableArn = str;
    }

    public TableDescription withTableArn(String str) {
        this.tableArn = str;
        return this;
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String str) {
        this.tableId = str;
    }

    public TableDescription withTableId(String str) {
        this.tableId = str;
        return this;
    }

    public List<LocalSecondaryIndexDescription> getLocalSecondaryIndexes() {
        return this.localSecondaryIndexes;
    }

    public void setLocalSecondaryIndexes(Collection<LocalSecondaryIndexDescription> collection) {
        if (collection == null) {
            this.localSecondaryIndexes = null;
        } else {
            this.localSecondaryIndexes = new ArrayList(collection);
        }
    }

    public TableDescription withLocalSecondaryIndexes(LocalSecondaryIndexDescription... localSecondaryIndexDescriptionArr) {
        if (getLocalSecondaryIndexes() == null) {
            this.localSecondaryIndexes = new ArrayList(localSecondaryIndexDescriptionArr.length);
        }
        for (LocalSecondaryIndexDescription localSecondaryIndexDescription : localSecondaryIndexDescriptionArr) {
            this.localSecondaryIndexes.add(localSecondaryIndexDescription);
        }
        return this;
    }

    public TableDescription withLocalSecondaryIndexes(Collection<LocalSecondaryIndexDescription> collection) {
        setLocalSecondaryIndexes(collection);
        return this;
    }

    public List<GlobalSecondaryIndexDescription> getGlobalSecondaryIndexes() {
        return this.globalSecondaryIndexes;
    }

    public void setGlobalSecondaryIndexes(Collection<GlobalSecondaryIndexDescription> collection) {
        if (collection == null) {
            this.globalSecondaryIndexes = null;
        } else {
            this.globalSecondaryIndexes = new ArrayList(collection);
        }
    }

    public TableDescription withGlobalSecondaryIndexes(GlobalSecondaryIndexDescription... globalSecondaryIndexDescriptionArr) {
        if (getGlobalSecondaryIndexes() == null) {
            this.globalSecondaryIndexes = new ArrayList(globalSecondaryIndexDescriptionArr.length);
        }
        for (GlobalSecondaryIndexDescription globalSecondaryIndexDescription : globalSecondaryIndexDescriptionArr) {
            this.globalSecondaryIndexes.add(globalSecondaryIndexDescription);
        }
        return this;
    }

    public TableDescription withGlobalSecondaryIndexes(Collection<GlobalSecondaryIndexDescription> collection) {
        setGlobalSecondaryIndexes(collection);
        return this;
    }

    public StreamSpecification getStreamSpecification() {
        return this.streamSpecification;
    }

    public void setStreamSpecification(StreamSpecification streamSpecification) {
        this.streamSpecification = streamSpecification;
    }

    public TableDescription withStreamSpecification(StreamSpecification streamSpecification) {
        this.streamSpecification = streamSpecification;
        return this;
    }

    public String getLatestStreamLabel() {
        return this.latestStreamLabel;
    }

    public void setLatestStreamLabel(String str) {
        this.latestStreamLabel = str;
    }

    public TableDescription withLatestStreamLabel(String str) {
        this.latestStreamLabel = str;
        return this;
    }

    public String getLatestStreamArn() {
        return this.latestStreamArn;
    }

    public void setLatestStreamArn(String str) {
        this.latestStreamArn = str;
    }

    public TableDescription withLatestStreamArn(String str) {
        this.latestStreamArn = str;
        return this;
    }

    public RestoreSummary getRestoreSummary() {
        return this.restoreSummary;
    }

    public void setRestoreSummary(RestoreSummary restoreSummary) {
        this.restoreSummary = restoreSummary;
    }

    public TableDescription withRestoreSummary(RestoreSummary restoreSummary) {
        this.restoreSummary = restoreSummary;
        return this;
    }

    public SSEDescription getSSEDescription() {
        return this.sSEDescription;
    }

    public void setSSEDescription(SSEDescription sSEDescription) {
        this.sSEDescription = sSEDescription;
    }

    public TableDescription withSSEDescription(SSEDescription sSEDescription) {
        this.sSEDescription = sSEDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAttributeDefinitions() != null) {
            sb.append("AttributeDefinitions: " + getAttributeDefinitions() + Constants.SEPARATOR_COMMA);
        }
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getKeySchema() != null) {
            sb.append("KeySchema: " + getKeySchema() + Constants.SEPARATOR_COMMA);
        }
        if (getTableStatus() != null) {
            sb.append("TableStatus: " + getTableStatus() + Constants.SEPARATOR_COMMA);
        }
        if (getCreationDateTime() != null) {
            sb.append("CreationDateTime: " + getCreationDateTime() + Constants.SEPARATOR_COMMA);
        }
        if (getProvisionedThroughput() != null) {
            sb.append("ProvisionedThroughput: " + getProvisionedThroughput() + Constants.SEPARATOR_COMMA);
        }
        if (getTableSizeBytes() != null) {
            sb.append("TableSizeBytes: " + getTableSizeBytes() + Constants.SEPARATOR_COMMA);
        }
        if (getItemCount() != null) {
            sb.append("ItemCount: " + getItemCount() + Constants.SEPARATOR_COMMA);
        }
        if (getTableArn() != null) {
            sb.append("TableArn: " + getTableArn() + Constants.SEPARATOR_COMMA);
        }
        if (getTableId() != null) {
            sb.append("TableId: " + getTableId() + Constants.SEPARATOR_COMMA);
        }
        if (getLocalSecondaryIndexes() != null) {
            sb.append("LocalSecondaryIndexes: " + getLocalSecondaryIndexes() + Constants.SEPARATOR_COMMA);
        }
        if (getGlobalSecondaryIndexes() != null) {
            sb.append("GlobalSecondaryIndexes: " + getGlobalSecondaryIndexes() + Constants.SEPARATOR_COMMA);
        }
        if (getStreamSpecification() != null) {
            sb.append("StreamSpecification: " + getStreamSpecification() + Constants.SEPARATOR_COMMA);
        }
        if (getLatestStreamLabel() != null) {
            sb.append("LatestStreamLabel: " + getLatestStreamLabel() + Constants.SEPARATOR_COMMA);
        }
        if (getLatestStreamArn() != null) {
            sb.append("LatestStreamArn: " + getLatestStreamArn() + Constants.SEPARATOR_COMMA);
        }
        if (getRestoreSummary() != null) {
            sb.append("RestoreSummary: " + getRestoreSummary() + Constants.SEPARATOR_COMMA);
        }
        if (getSSEDescription() != null) {
            sb.append("SSEDescription: " + getSSEDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((getAttributeDefinitions() == null ? 0 : getAttributeDefinitions().hashCode()) + 31) * 31) + (getTableName() == null ? 0 : getTableName().hashCode())) * 31) + (getKeySchema() == null ? 0 : getKeySchema().hashCode())) * 31) + (getTableStatus() == null ? 0 : getTableStatus().hashCode())) * 31) + (getCreationDateTime() == null ? 0 : getCreationDateTime().hashCode())) * 31) + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode())) * 31) + (getTableSizeBytes() == null ? 0 : getTableSizeBytes().hashCode())) * 31) + (getItemCount() == null ? 0 : getItemCount().hashCode())) * 31) + (getTableArn() == null ? 0 : getTableArn().hashCode())) * 31) + (getTableId() == null ? 0 : getTableId().hashCode())) * 31) + (getLocalSecondaryIndexes() == null ? 0 : getLocalSecondaryIndexes().hashCode())) * 31) + (getGlobalSecondaryIndexes() == null ? 0 : getGlobalSecondaryIndexes().hashCode())) * 31) + (getStreamSpecification() == null ? 0 : getStreamSpecification().hashCode())) * 31) + (getLatestStreamLabel() == null ? 0 : getLatestStreamLabel().hashCode())) * 31) + (getLatestStreamArn() == null ? 0 : getLatestStreamArn().hashCode())) * 31) + (getRestoreSummary() == null ? 0 : getRestoreSummary().hashCode())) * 31) + (getSSEDescription() != null ? getSSEDescription().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TableDescription)) {
            return false;
        }
        TableDescription tableDescription = (TableDescription) obj;
        if ((tableDescription.getAttributeDefinitions() == null) ^ (getAttributeDefinitions() == null)) {
            return false;
        }
        if (tableDescription.getAttributeDefinitions() != null && !tableDescription.getAttributeDefinitions().equals(getAttributeDefinitions())) {
            return false;
        }
        if ((tableDescription.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (tableDescription.getTableName() != null && !tableDescription.getTableName().equals(getTableName())) {
            return false;
        }
        if ((tableDescription.getKeySchema() == null) ^ (getKeySchema() == null)) {
            return false;
        }
        if (tableDescription.getKeySchema() != null && !tableDescription.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        if ((tableDescription.getTableStatus() == null) ^ (getTableStatus() == null)) {
            return false;
        }
        if (tableDescription.getTableStatus() != null && !tableDescription.getTableStatus().equals(getTableStatus())) {
            return false;
        }
        if ((tableDescription.getCreationDateTime() == null) ^ (getCreationDateTime() == null)) {
            return false;
        }
        if (tableDescription.getCreationDateTime() != null && !tableDescription.getCreationDateTime().equals(getCreationDateTime())) {
            return false;
        }
        if ((tableDescription.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        if (tableDescription.getProvisionedThroughput() != null && !tableDescription.getProvisionedThroughput().equals(getProvisionedThroughput())) {
            return false;
        }
        if ((tableDescription.getTableSizeBytes() == null) ^ (getTableSizeBytes() == null)) {
            return false;
        }
        if (tableDescription.getTableSizeBytes() != null && !tableDescription.getTableSizeBytes().equals(getTableSizeBytes())) {
            return false;
        }
        if ((tableDescription.getItemCount() == null) ^ (getItemCount() == null)) {
            return false;
        }
        if (tableDescription.getItemCount() != null && !tableDescription.getItemCount().equals(getItemCount())) {
            return false;
        }
        if ((tableDescription.getTableArn() == null) ^ (getTableArn() == null)) {
            return false;
        }
        if (tableDescription.getTableArn() != null && !tableDescription.getTableArn().equals(getTableArn())) {
            return false;
        }
        if ((tableDescription.getTableId() == null) ^ (getTableId() == null)) {
            return false;
        }
        if (tableDescription.getTableId() != null && !tableDescription.getTableId().equals(getTableId())) {
            return false;
        }
        if ((tableDescription.getLocalSecondaryIndexes() == null) ^ (getLocalSecondaryIndexes() == null)) {
            return false;
        }
        if (tableDescription.getLocalSecondaryIndexes() != null && !tableDescription.getLocalSecondaryIndexes().equals(getLocalSecondaryIndexes())) {
            return false;
        }
        if ((tableDescription.getGlobalSecondaryIndexes() == null) ^ (getGlobalSecondaryIndexes() == null)) {
            return false;
        }
        if (tableDescription.getGlobalSecondaryIndexes() != null && !tableDescription.getGlobalSecondaryIndexes().equals(getGlobalSecondaryIndexes())) {
            return false;
        }
        if ((tableDescription.getStreamSpecification() == null) ^ (getStreamSpecification() == null)) {
            return false;
        }
        if (tableDescription.getStreamSpecification() != null && !tableDescription.getStreamSpecification().equals(getStreamSpecification())) {
            return false;
        }
        if ((tableDescription.getLatestStreamLabel() == null) ^ (getLatestStreamLabel() == null)) {
            return false;
        }
        if (tableDescription.getLatestStreamLabel() != null && !tableDescription.getLatestStreamLabel().equals(getLatestStreamLabel())) {
            return false;
        }
        if ((tableDescription.getLatestStreamArn() == null) ^ (getLatestStreamArn() == null)) {
            return false;
        }
        if (tableDescription.getLatestStreamArn() != null && !tableDescription.getLatestStreamArn().equals(getLatestStreamArn())) {
            return false;
        }
        if ((tableDescription.getRestoreSummary() == null) ^ (getRestoreSummary() == null)) {
            return false;
        }
        if (tableDescription.getRestoreSummary() != null && !tableDescription.getRestoreSummary().equals(getRestoreSummary())) {
            return false;
        }
        if ((tableDescription.getSSEDescription() == null) ^ (getSSEDescription() == null)) {
            return false;
        }
        return tableDescription.getSSEDescription() == null || tableDescription.getSSEDescription().equals(getSSEDescription());
    }
}
