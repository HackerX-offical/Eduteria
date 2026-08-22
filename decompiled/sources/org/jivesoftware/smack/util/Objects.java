package org.jivesoftware.smack.util;

import java.util.Collection;

/* JADX INFO: loaded from: classes10.dex */
public class Objects {
    public static <T> T requireNonNull(T t, String str) throws IllegalArgumentException {
        if (t != null) {
            return t;
        }
        if (str == null) {
            str = "Can not provide null argument";
        }
        throw new IllegalArgumentException(str);
    }

    public static <T> T requireNonNull(T t) {
        return (T) requireNonNull(t, null);
    }

    public static <T extends Collection<?>> T requireNonNullNorEmpty(T t, String str) {
        if (((Collection) requireNonNull(t)).isEmpty()) {
            throw new IllegalArgumentException(str);
        }
        return t;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
