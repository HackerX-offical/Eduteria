package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SourceTableDetails implements Serializable {
    private Long itemCount;
    private List<KeySchemaElement> keySchema;
    private ProvisionedThroughput provisionedThroughput;
    private String tableArn;
    private Date tableCreationDateTime;
    private String tableId;
    private String tableName;
    private Long tableSizeBytes;

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public SourceTableDetails withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String str) {
        this.tableId = str;
    }

    public SourceTableDetails withTableId(String str) {
        this.tableId = str;
        return this;
    }

    public String getTableArn() {
        return this.tableArn;
    }

    public void setTableArn(String str) {
        this.tableArn = str;
    }

    public SourceTableDetails withTableArn(String str) {
        this.tableArn = str;
        return this;
    }

    public Long getTableSizeBytes() {
        return this.tableSizeBytes;
    }

    public void setTableSizeBytes(Long l) {
        this.tableSizeBytes = l;
    }

    public SourceTableDetails withTableSizeBytes(Long l) {
        this.tableSizeBytes = l;
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

    public SourceTableDetails withKeySchema(KeySchemaElement... keySchemaElementArr) {
        if (getKeySchema() == null) {
            this.keySchema = new ArrayList(keySchemaElementArr.length);
        }
        for (KeySchemaElement keySchemaElement : keySchemaElementArr) {
            this.keySchema.add(keySchemaElement);
        }
        return this;
    }

    public SourceTableDetails withKeySchema(Collection<KeySchemaElement> collection) {
        setKeySchema(collection);
        return this;
    }

    public Date getTableCreationDateTime() {
        return this.tableCreationDateTime;
    }

    public void setTableCreationDateTime(Date date) {
        this.tableCreationDateTime = date;
    }

    public SourceTableDetails withTableCreationDateTime(Date date) {
        this.tableCreationDateTime = date;
        return this;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
    }

    public SourceTableDetails withProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
        return this;
    }

    public Long getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(Long l) {
        this.itemCount = l;
    }

    public SourceTableDetails withItemCount(Long l) {
        this.itemCount = l;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getTableId() != null) {
            sb.append("TableId: " + getTableId() + Constants.SEPARATOR_COMMA);
        }
        if (getTableArn() != null) {
            sb.append("TableArn: " + getTableArn() + Constants.SEPARATOR_COMMA);
        }
        if (getTableSizeBytes() != null) {
            sb.append("TableSizeBytes: " + getTableSizeBytes() + Constants.SEPARATOR_COMMA);
        }
        if (getKeySchema() != null) {
            sb.append("KeySchema: " + getKeySchema() + Constants.SEPARATOR_COMMA);
        }
        if (getTableCreationDateTime() != null) {
            sb.append("TableCreationDateTime: " + getTableCreationDateTime() + Constants.SEPARATOR_COMMA);
        }
        if (getProvisionedThroughput() != null) {
            sb.append("ProvisionedThroughput: " + getProvisionedThroughput() + Constants.SEPARATOR_COMMA);
        }
        if (getItemCount() != null) {
            sb.append("ItemCount: " + getItemCount());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getTableId() == null ? 0 : getTableId().hashCode())) * 31) + (getTableArn() == null ? 0 : getTableArn().hashCode())) * 31) + (getTableSizeBytes() == null ? 0 : getTableSizeBytes().hashCode())) * 31) + (getKeySchema() == null ? 0 : getKeySchema().hashCode())) * 31) + (getTableCreationDateTime() == null ? 0 : getTableCreationDateTime().hashCode())) * 31) + (getProvisionedThroughput() == null ? 0 : getProvisionedThroughput().hashCode())) * 31) + (getItemCount() != null ? getItemCount().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SourceTableDetails)) {
            return false;
        }
        SourceTableDetails sourceTableDetails = (SourceTableDetails) obj;
        if ((sourceTableDetails.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (sourceTableDetails.getTableName() != null && !sourceTableDetails.getTableName().equals(getTableName())) {
            return false;
        }
        if ((sourceTableDetails.getTableId() == null) ^ (getTableId() == null)) {
            return false;
        }
        if (sourceTableDetails.getTableId() != null && !sourceTableDetails.getTableId().equals(getTableId())) {
            return false;
        }
        if ((sourceTableDetails.getTableArn() == null) ^ (getTableArn() == null)) {
            return false;
        }
        if (sourceTableDetails.getTableArn() != null && !sourceTableDetails.getTableArn().equals(getTableArn())) {
            return false;
        }
        if ((sourceTableDetails.getTableSizeBytes() == null) ^ (getTableSizeBytes() == null)) {
            return false;
        }
        if (sourceTableDetails.getTableSizeBytes() != null && !sourceTableDetails.getTableSizeBytes().equals(getTableSizeBytes())) {
            return false;
        }
        if ((sourceTableDetails.getKeySchema() == null) ^ (getKeySchema() == null)) {
            return false;
        }
        if (sourceTableDetails.getKeySchema() != null && !sourceTableDetails.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        if ((sourceTableDetails.getTableCreationDateTime() == null) ^ (getTableCreationDateTime() == null)) {
            return false;
        }
        if (sourceTableDetails.getTableCreationDateTime() != null && !sourceTableDetails.getTableCreationDateTime().equals(getTableCreationDateTime())) {
            return false;
        }
        if ((sourceTableDetails.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        if (sourceTableDetails.getProvisionedThroughput() != null && !sourceTableDetails.getProvisionedThroughput().equals(getProvisionedThroughput())) {
            return false;
        }
        if ((sourceTableDetails.getItemCount() == null) ^ (getItemCount() == null)) {
            return false;
        }
        return sourceTableDetails.getItemCount() == null || sourceTableDetails.getItemCount().equals(getItemCount());
    }
}
