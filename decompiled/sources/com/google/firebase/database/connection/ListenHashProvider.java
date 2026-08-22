package com.google.firebase.database.connection;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface ListenHashProvider {
    CompoundHash getCompoundHash();

    String getSimpleHash();

    boolean shouldIncludeCompoundHash();
}
