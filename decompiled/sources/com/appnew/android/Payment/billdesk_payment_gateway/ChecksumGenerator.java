package com.appnew.android.Payment.billdesk_payment_gateway;

import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChecksumGenerator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/Payment/billdesk_payment_gateway/ChecksumGenerator;", "", "<init>", "()V", "createCheckSum", "", "checkSumSHA256", "plaintext", "char2hex", "x", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChecksumGenerator {
    public static final int $stable = 0;

    public final String createCheckSum() {
        if ("VideoCrypt".length() > 0) {
            return checkSumSHA256("LAWLEGUAT|ARP1669122017340|NA|2|NA|NA|NA|INR|NA|R|lawleguat|NA|NA|F|NA|NA|NA|NA|NA|NA|NA|https://uat.billdesk.com/pgidsk/pgmerc/pg_dump.jsp|wughPl3UcXvJ|VideoCrypt");
        }
        return "";
    }

    private final String checkSumSHA256(String plaintext) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = plaintext.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes);
        } catch (Exception unused) {
            messageDigest = null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArrDigest = messageDigest != null ? messageDigest.digest() : null;
        Intrinsics.checkNotNull(bArrDigest);
        for (byte b2 : bArrDigest) {
            stringBuffer.append(char2hex(b2));
        }
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String char2hex(byte x) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(x & 240) >> 4], cArr[x & Ascii.SI]});
    }
}
