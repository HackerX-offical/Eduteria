package com.amazonaws.logging;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LogFactory {
    private static final String APACHE_COMMONS_LOGGING_LOGFACTORY = "org.apache.commons.logging.LogFactory";
    private static final String TAG = "LogFactory";
    private static Map<String, Log> logMap = new HashMap();

    public static synchronized Log getLog(Class cls) {
        return getLog(cls.getSimpleName());
    }

    public static synchronized Log getLog(String str) {
        Log androidLog;
        Log apacheCommonsLogging;
        Exception e2;
        androidLog = logMap.get(str);
        if (androidLog == null) {
            if (checkApacheCommonsLoggingExists()) {
                try {
                    apacheCommonsLogging = new ApacheCommonsLogging(str);
                } catch (Exception e3) {
                    apacheCommonsLogging = androidLog;
                    e2 = e3;
                }
                try {
                    logMap.put(str, apacheCommonsLogging);
                } catch (Exception e4) {
                    e2 = e4;
                    android.util.Log.w(TAG, "Could not create log from org.apache.commons.logging.LogFactory", e2);
                }
                androidLog = apacheCommonsLogging;
            }
            if (androidLog == null) {
                androidLog = new AndroidLog(str);
                logMap.put(str, androidLog);
            }
        }
        return androidLog;
    }

    private static boolean checkApacheCommonsLoggingExists() {
        try {
            Class.forName(APACHE_COMMONS_LOGGING_LOGFACTORY);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Exception e2) {
            android.util.Log.e(TAG, e2.getMessage());
            return false;
        }
    }
}
