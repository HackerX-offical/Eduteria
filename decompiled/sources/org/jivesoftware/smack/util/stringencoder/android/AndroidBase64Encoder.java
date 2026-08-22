package org.jivesoftware.smack.util.stringencoder.android;

import org.jivesoftware.smack.util.stringencoder.Base64;

/* JADX INFO: loaded from: classes10.dex */
public final class AndroidBase64Encoder implements Base64.Encoder {
    private static final int BASE64_ENCODER_FLAGS = 2;
    private static AndroidBase64Encoder instance = new AndroidBase64Encoder();

    private AndroidBase64Encoder() {
    }

    public static AndroidBase64Encoder getInstance() {
        return instance;
    }

    @Override // org.jivesoftware.smack.util.stringencoder.Base64.Encoder
    public byte[] decode(String str) {
        return android.util.Base64.decode(str, 0);
    }

    @Override // org.jivesoftware.smack.util.stringencoder.Base64.Encoder
    public String encodeToString(byte[] bArr) {
        return android.util.Base64.encodeToString(bArr, 2);
    }

    @Override // org.jivesoftware.smack.util.stringencoder.Base64.Encoder
    public String encodeToStringWithoutPadding(byte[] bArr) {
        return android.util.Base64.encodeToString(bArr, 3);
    }

    @Override // org.jivesoftware.smack.util.stringencoder.Base64.Encoder
    public byte[] encode(byte[] bArr) {
        return android.util.Base64.encode(bArr, 2);
    }
}
