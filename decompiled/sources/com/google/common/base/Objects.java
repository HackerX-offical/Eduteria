package com.google.common.base;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes8.dex */
@ElementTypesAreNonnullByDefault
public final class Objects extends ExtraObjectsMethodsForWeb {
    private Objects() {
    }

    public static boolean equal(@CheckForNull Object a2, @CheckForNull Object b2) {
        if (a2 != b2) {
            return a2 != null && a2.equals(b2);
        }
        return true;
    }

    public static int hashCode(@CheckForNull Object... objects) {
        return Arrays.hashCode(objects);
    }
}
