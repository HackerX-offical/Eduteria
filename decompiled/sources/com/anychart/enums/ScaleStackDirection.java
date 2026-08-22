package com.anychart.enums;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum ScaleStackDirection {
    DIRECT(DevicePublicKeyStringDef.DIRECT),
    REVERSE("reverse");

    private final String value;

    ScaleStackDirection(String str) {
        this.value = str;
    }

    public String getJsBase() {
        return String.format(Locale.US, "\"%s\"", this.value);
    }
}
