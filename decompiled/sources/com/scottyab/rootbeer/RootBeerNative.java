package com.scottyab.rootbeer;

import com.scottyab.rootbeer.util.QLog;

/* JADX INFO: loaded from: classes9.dex */
public class RootBeerNative {
    private static boolean libraryLoaded = false;

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z);

    static {
        try {
            System.loadLibrary("toolChecker");
            libraryLoaded = true;
        } catch (UnsatisfiedLinkError e2) {
            QLog.e(e2);
        }
    }

    public boolean wasNativeLibraryLoaded() {
        return libraryLoaded;
    }
}
