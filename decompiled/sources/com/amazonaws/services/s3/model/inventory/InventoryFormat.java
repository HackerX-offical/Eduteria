package com.amazonaws.services.s3.model.inventory;

/* JADX INFO: loaded from: classes4.dex */
public enum InventoryFormat {
    CSV("CSV");

    private final String format;

    InventoryFormat(String str) {
        this.format = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.format;
    }
}
