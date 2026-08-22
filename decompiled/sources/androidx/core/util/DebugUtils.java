package androidx.core.util;

import com.amazonaws.services.s3.internal.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class DebugUtils {
    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        int iLastIndexOf;
        if (obj == null) {
            sb.append(Constants.NULL_VERSION_ID);
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if ((simpleName == null || simpleName.length() <= 0) && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    private DebugUtils() {
    }
}
