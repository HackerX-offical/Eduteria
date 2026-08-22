package com.appnew.android.JWextractor;

/* JADX INFO: loaded from: classes6.dex */
public interface NetworkCheckerInterface {
    void cancelExecution();

    void continueExecution();

    default void onUnstableInternet() {
    }
}
