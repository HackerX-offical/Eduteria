package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class OAuthCredential extends AuthCredential {
    public abstract String getAccessToken();

    public abstract String getIdToken();

    public abstract String getSecret();
}
