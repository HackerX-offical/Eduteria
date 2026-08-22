package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class GlobalSecondaryIndexUpdate implements Serializable {
    private CreateGlobalSecondaryIndexAction create;
    private DeleteGlobalSecondaryIndexAction delete;
    private UpdateGlobalSecondaryIndexAction update;

    public UpdateGlobalSecondaryIndexAction getUpdate() {
        return this.update;
    }

    public void setUpdate(UpdateGlobalSecondaryIndexAction updateGlobalSecondaryIndexAction) {
        this.update = updateGlobalSecondaryIndexAction;
    }

    public GlobalSecondaryIndexUpdate withUpdate(UpdateGlobalSecondaryIndexAction updateGlobalSecondaryIndexAction) {
        this.update = updateGlobalSecondaryIndexAction;
        return this;
    }

    public CreateGlobalSecondaryIndexAction getCreate() {
        return this.create;
    }

    public void setCreate(CreateGlobalSecondaryIndexAction createGlobalSecondaryIndexAction) {
        this.create = createGlobalSecondaryIndexAction;
    }

    public GlobalSecondaryIndexUpdate withCreate(CreateGlobalSecondaryIndexAction createGlobalSecondaryIndexAction) {
        this.create = createGlobalSecondaryIndexAction;
        return this;
    }

    public DeleteGlobalSecondaryIndexAction getDelete() {
        return this.delete;
    }

    public void setDelete(DeleteGlobalSecondaryIndexAction deleteGlobalSecondaryIndexAction) {
        this.delete = deleteGlobalSecondaryIndexAction;
    }

    public GlobalSecondaryIndexUpdate withDelete(DeleteGlobalSecondaryIndexAction deleteGlobalSecondaryIndexAction) {
        this.delete = deleteGlobalSecondaryIndexAction;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getUpdate() != null) {
            sb.append("Update: " + getUpdate() + Constants.SEPARATOR_COMMA);
        }
        if (getCreate() != null) {
            sb.append("Create: " + getCreate() + Constants.SEPARATOR_COMMA);
        }
        if (getDelete() != null) {
            sb.append("Delete: " + getDelete());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUpdate() == null ? 0 : getUpdate().hashCode()) + 31) * 31) + (getCreate() == null ? 0 : getCreate().hashCode())) * 31) + (getDelete() != null ? getDelete().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GlobalSecondaryIndexUpdate)) {
            return false;
        }
        GlobalSecondaryIndexUpdate globalSecondaryIndexUpdate = (GlobalSecondaryIndexUpdate) obj;
        if ((globalSecondaryIndexUpdate.getUpdate() == null) ^ (getUpdate() == null)) {
            return false;
        }
        if (globalSecondaryIndexUpdate.getUpdate() != null && !globalSecondaryIndexUpdate.getUpdate().equals(getUpdate())) {
            return false;
        }
        if ((globalSecondaryIndexUpdate.getCreate() == null) ^ (getCreate() == null)) {
            return false;
        }
        if (globalSecondaryIndexUpdate.getCreate() != null && !globalSecondaryIndexUpdate.getCreate().equals(getCreate())) {
            return false;
        }
        if ((globalSecondaryIndexUpdate.getDelete() == null) ^ (getDelete() == null)) {
            return false;
        }
        return globalSecondaryIndexUpdate.getDelete() == null || globalSecondaryIndexUpdate.getDelete().equals(getDelete());
    }
}
