package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class FacebookAuthProvider {
    public static final String FACEBOOK_SIGN_IN_METHOD = "facebook.com";
    public static final String PROVIDER_ID = "facebook.com";

    private FacebookAuthProvider() {
    }

    public static AuthCredential getCredential(String str) {
        return new FacebookAuthCredential(str);
    }
}
