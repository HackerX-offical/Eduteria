package com.microsoft.clarity.n;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static byte[] a(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        Writer outputStreamWriter = new OutputStreamWriter(gZIPOutputStream, UTF_8);
        BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
        try {
            bufferedWriter.write(content);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "bos.toByteArray()");
            return byteArray;
        } finally {
        }
    }

    public static byte[] a(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(content);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(gZIPOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "byteArrayOutputStream.toByteArray()");
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static String b(String selector) {
        int i;
        Intrinsics.checkNotNullParameter(selector, "selector");
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, selector.length() - 1, 2);
        int iCharAt = 5381;
        if (progressionLastElement >= 0) {
            int i2 = 0;
            int iCharAt2 = 5381;
            while (true) {
                iCharAt = ((iCharAt << 5) + iCharAt) ^ selector.charAt(i2);
                int i3 = i2 + 1;
                if (i3 < selector.length()) {
                    iCharAt2 = ((iCharAt2 << 5) + iCharAt2) ^ selector.charAt(i3);
                }
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 += 2;
            }
            i = iCharAt;
            iCharAt = iCharAt2;
        } else {
            i = 5381;
        }
        String string = Long.toString(Math.abs((((long) iCharAt) * ((long) 11579)) + ((long) i)), CharsKt.checkRadix(36));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }

    public static String b(byte[] data) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(data, "data");
        MessageDigest messageDigest = MessageDigest.getInstance(StringUtils.MD5);
        String strEncodeToString = Base64.getUrlEncoder().encodeToString(messageDigest.digest(messageDigest.digest(data)));
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "getUrlEncoder().encodeToString(bytes)");
        return StringsKt.trim((CharSequence) strEncodeToString).toString();
    }
}
