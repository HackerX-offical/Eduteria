package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: TimeUtilities.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/utils/TimeUtilities;", "", "()V", "formatTime", "", "timeInSeconds", "", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimeUtilities {
    public static final TimeUtilities INSTANCE = new TimeUtilities();

    private TimeUtilities() {
    }

    @JvmStatic
    public static final String formatTime(float timeInSeconds) {
        float f2 = 60;
        int i = (int) (timeInSeconds / f2);
        int i2 = (int) (timeInSeconds % f2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }
}
