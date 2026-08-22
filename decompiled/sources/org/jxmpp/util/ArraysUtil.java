package org.jxmpp.util;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes10.dex */
public class ArraysUtil {
    public static <T> T concatenate(T t, T t2) {
        if (!t.getClass().isArray() || !t2.getClass().isArray()) {
            throw new IllegalArgumentException();
        }
        int length = Array.getLength(t);
        int length2 = Array.getLength(t2);
        T t3 = (T) Array.newInstance(t.getClass().getComponentType(), length + length2);
        System.arraycopy(t, 0, t3, 0, length);
        System.arraycopy(t2, 0, t3, length, length2);
        return t3;
    }
}
