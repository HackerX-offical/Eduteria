package com.google.firebase.database.logging;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface Logger {

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public enum Level {
        DEBUG,
        INFO,
        WARN,
        ERROR,
        NONE
    }

    Level getLogLevel();

    void onLogMessage(Level level, String str, String str2, long j);
}
