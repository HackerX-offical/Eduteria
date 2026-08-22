package com.clevertap.android.sdk.utils;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"toValidColorOrFallback", "", FallbackIndicationElement.ELEMENT, "clevertap-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorUtilsKt {
    public static final String toValidColorOrFallback(String str, String fallback) {
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        if (!StringsKt.startsWith$default(fallback, MqttTopic.MULTI_LEVEL_WILDCARD, false, 2, (Object) null)) {
            fallback = null;
        }
        if (fallback != null) {
            try {
                Color.parseColor(fallback);
            } catch (Exception unused) {
                fallback = null;
            }
        }
        if (fallback == null) {
            fallback = "#FFFFFF";
        }
        if (str == null || !StringsKt.startsWith$default(str, MqttTopic.MULTI_LEVEL_WILDCARD, false, 2, (Object) null)) {
            return fallback;
        }
        try {
            Color.parseColor(str);
            return str;
        } catch (Exception unused2) {
            return fallback;
        }
    }
}
