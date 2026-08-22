package org.jivesoftware.smack.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes10.dex */
public class ExceptionUtil {
    public static String getStackTrace(Throwable th) {
        if (th == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.getBuffer().toString();
    }
}
