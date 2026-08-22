package org.jivesoftware.smack.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes10.dex */
public class UTF8 {
    public static final String UTF8_CHARSET_NAME = "UTF-8";
    private static final Charset utf8Charset = Charset.forName("UTF-8");

    public static ByteBuffer encode(CharSequence charSequence) {
        return encode(charSequence.toString());
    }

    public static ByteBuffer encode(String str) {
        return utf8Charset.encode(str);
    }
}
