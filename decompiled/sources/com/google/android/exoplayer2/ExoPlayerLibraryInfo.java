package com.google.android.exoplayer2;

import java.util.HashSet;

/* JADX INFO: loaded from: classes7.dex */
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final String TAG = "ExoPlayerLib";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.17.1";
    public static final int VERSION_INT = 2017001;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.17.1";
    private static final HashSet<String> registeredModules = new HashSet<>();
    private static String registeredModulesString = "goog.exo.core";

    private ExoPlayerLibraryInfo() {
    }

    public static synchronized String registeredModules() {
        return registeredModulesString;
    }

    public static synchronized void registerModule(String str) {
        if (registeredModules.add(str)) {
            String str2 = registeredModulesString;
            registeredModulesString = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length()).append(str2).append(", ").append(str).toString();
        }
    }
}
