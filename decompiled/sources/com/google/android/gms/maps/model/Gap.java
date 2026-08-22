package com.google.android.gms.maps.model;

import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes8.dex */
public final class Gap extends PatternItem {
    public final float length;

    public Gap(float f2) {
        super(2, Float.valueOf(Math.max(f2, 0.0f)));
        this.length = Math.max(f2, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        return new StringBuilder(29).append("[Gap: length=").append(this.length).append(Constants.AES_SUFFIX).toString();
    }
}
