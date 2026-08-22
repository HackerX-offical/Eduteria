package com.appnew.android.player.customview.ExoSpeedDemo;

import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
final class DemoUtil {
    public static String buildTrackName(Format format) {
        String strJoinWithSeparator = MimeTypes.isVideo(format.sampleMimeType) ? joinWithSeparator(joinWithSeparator(joinWithSeparator(buildResolutionString(format), buildBitrateString(format)), buildTrackIdString(format)), buildSampleMimeTypeString(format)) : MimeTypes.isAudio(format.sampleMimeType) ? joinWithSeparator(joinWithSeparator(joinWithSeparator(joinWithSeparator(buildLanguageString(format), buildAudioPropertyString(format)), buildBitrateString(format)), buildTrackIdString(format)), buildSampleMimeTypeString(format)) : joinWithSeparator(joinWithSeparator(joinWithSeparator(buildLanguageString(format), buildBitrateString(format)), buildTrackIdString(format)), buildSampleMimeTypeString(format));
        return strJoinWithSeparator.length() == 0 ? "unknown" : strJoinWithSeparator;
    }

    private static String buildResolutionString(Format format) {
        return (format.width == -1 || format.height == -1) ? "" : format.width + "x" + format.height;
    }

    private static String buildAudioPropertyString(Format format) {
        return (format.channelCount == -1 || format.sampleRate == -1) ? "" : format.channelCount + "ch, " + format.sampleRate + "Hz";
    }

    private static String buildLanguageString(Format format) {
        if (TextUtils.isEmpty(format.language) || "und".equals(format.language)) {
            return "";
        }
        return format.language;
    }

    private static String buildBitrateString(Format format) {
        return format.bitrate == -1 ? "" : String.format(Locale.US, "%.2fMbit", Float.valueOf(format.bitrate / 1000000.0f));
    }

    private static String joinWithSeparator(String first, String second) {
        return first.length() == 0 ? second : second.length() == 0 ? first : first + ", " + second;
    }

    private static String buildTrackIdString(Format format) {
        return format.id == null ? "" : "id:" + format.id;
    }

    private static String buildSampleMimeTypeString(Format format) {
        return format.sampleMimeType == null ? "" : format.sampleMimeType;
    }

    private DemoUtil() {
    }
}
