package com.google.firebase.crashlytics.internal.stacktrace;

/* JADX INFO: loaded from: classes9.dex */
public interface StackTraceTrimmingStrategy {
    StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr);
}
