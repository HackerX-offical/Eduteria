package com.google.android.gms.maps.model;

import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes8.dex */
public final class Dash extends PatternItem {
    public final float length;

    public Dash(float f2) {
        super(0, Float.valueOf(Math.max(f2, 0.0f)));
        this.length = Math.max(f2, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        return new StringBuilder(30).append("[Dash: length=").append(this.length).append(Constants.AES_SUFFIX).toString();
    }
}
