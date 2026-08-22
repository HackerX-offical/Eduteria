package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class InventorySchedule implements Serializable {
    private String frequency;

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public void setFrequency(InventoryFrequency inventoryFrequency) {
        String string;
        if (inventoryFrequency == null) {
            string = null;
        } else {
            string = inventoryFrequency.toString();
        }
        setFrequency(string);
    }

    public InventorySchedule withFrequency(String str) {
        setFrequency(str);
        return this;
    }

    public InventorySchedule withFrequency(InventoryFrequency inventoryFrequency) {
        setFrequency(inventoryFrequency);
        return this;
    }
}
