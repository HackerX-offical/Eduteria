package com.karumi.dexter.listener;

/* JADX INFO: loaded from: classes9.dex */
public final class PermissionRequest {
    private final String name;

    public PermissionRequest(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Permission name: " + this.name;
    }
}
