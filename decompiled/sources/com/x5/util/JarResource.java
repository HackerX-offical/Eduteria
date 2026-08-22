package com.x5.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessControlException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes9.dex */
public class JarResource {
    public static InputStream peekInsideJar(String str, String str2) {
        try {
            InputStream inputStreamOpenStream = new URL(str + "!" + str2).openStream();
            if (inputStreamOpenStream != null) {
                return inputStreamOpenStream;
            }
        } catch (MalformedURLException | IOException | AccessControlException unused) {
        }
        try {
            String strReplaceFirst = str.replaceFirst("^jar:file:", "");
            String strReplaceFirst2 = str2.replaceFirst("^/", "");
            ZipFile zipFile = new ZipFile(strReplaceFirst);
            ZipEntry entry = zipFile.getEntry(strReplaceFirst2);
            if (entry != null) {
                return zipFile.getInputStream(entry);
            }
            return null;
        } catch (IOException | AccessControlException unused2) {
            return null;
        }
    }
}
