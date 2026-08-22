package org.jxmpp.util;

/* JADX INFO: loaded from: classes10.dex */
public class Objects {
    public static <T> T requireNonNull(T t, String str) throws IllegalArgumentException {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Argument '" + str + "' must not be null");
    }
}
