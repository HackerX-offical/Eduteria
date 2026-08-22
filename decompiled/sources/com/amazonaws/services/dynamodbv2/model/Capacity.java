package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class Capacity implements Serializable {
    private Double capacityUnits;

    public Double getCapacityUnits() {
        return this.capacityUnits;
    }

    public void setCapacityUnits(Double d2) {
        this.capacityUnits = d2;
    }

    public Capacity withCapacityUnits(Double d2) {
        this.capacityUnits = d2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCapacityUnits() != null) {
            sb.append("CapacityUnits: " + getCapacityUnits());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getCapacityUnits() == null ? 0 : getCapacityUnits().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Capacity)) {
            return false;
        }
        Capacity capacity = (Capacity) obj;
        if ((capacity.getCapacityUnits() == null) ^ (getCapacityUnits() == null)) {
            return false;
        }
        return capacity.getCapacityUnits() == null || capacity.getCapacityUnits().equals(getCapacityUnits());
    }
}
