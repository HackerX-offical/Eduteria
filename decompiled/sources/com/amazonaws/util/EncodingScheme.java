package com.amazonaws.util;

/* JADX INFO: loaded from: classes4.dex */
public interface EncodingScheme {
    byte[] decode(String str);

    String encodeAsString(byte[] bArr);
}
