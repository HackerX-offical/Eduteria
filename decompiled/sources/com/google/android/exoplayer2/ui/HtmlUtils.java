package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.util.Util;

/* JADX INFO: loaded from: classes7.dex */
final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String toCssRgba(int i) {
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(((double) Color.alpha(i)) / 255.0d));
    }

    public static String cssAllClassDescendantsSelector(String str) {
        return new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str).length()).append(InstructionFileId.DOT).append(str).append(",.").append(str).append(" *").toString();
    }
}
