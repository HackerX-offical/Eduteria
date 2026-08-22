package org.mozilla.javascript.tools;

import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes10.dex */
public class SourceReader {
    public static URL toUrl(String str) {
        if (str.indexOf(58) < 2) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object readFileOrUrl(java.lang.String r10, boolean r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.SourceReader.readFileOrUrl(java.lang.String, boolean, java.lang.String):java.lang.Object");
    }
}
