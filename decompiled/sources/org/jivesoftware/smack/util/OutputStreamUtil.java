package org.jivesoftware.smack.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes10.dex */
public class OutputStreamUtil {
    public static void writeByteSafe(OutputStream outputStream, int i, String str) throws IOException {
        if (i < 0 || i > 255) {
            throw new IOException(str + ". The value " + i + " is not within the allowed range for bytes");
        }
        outputStream.write(i);
    }

    public static void writeResetAndFlush(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) throws IOException {
        byteArrayOutputStream.writeTo(outputStream);
        byteArrayOutputStream.reset();
        outputStream.flush();
    }
}
