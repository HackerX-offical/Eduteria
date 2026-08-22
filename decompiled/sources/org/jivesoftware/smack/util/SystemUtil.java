package org.jivesoftware.smack.util;

import com.clevertap.android.sdk.network.api.CtApi;

/* JADX INFO: loaded from: classes10.dex */
public class SystemUtil {
    public static final String PROPERTY_JAVA_VENDOR = "java.vendor";

    public static boolean onAndroid() {
        return System.getProperty(PROPERTY_JAVA_VENDOR).contains(CtApi.DEFAULT_QUERY_PARAM_OS);
    }
}
