package com.google.firebase.database.connection;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface ConnectionAuthTokenProvider {

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public interface GetTokenCallback {
        void onError(String str);

        void onSuccess(String str);
    }

    void getToken(boolean z, GetTokenCallback getTokenCallback);
}
