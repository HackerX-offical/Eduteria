package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class GoogleAuthProvider {
    public static final String GOOGLE_SIGN_IN_METHOD = "google.com";
    public static final String PROVIDER_ID = "google.com";

    private GoogleAuthProvider() {
    }

    public static AuthCredential getCredential(String str, String str2) {
        return new GoogleAuthCredential(str, str2);
    }
}
