package com.google.firebase.database.core;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface AuthTokenProvider {

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public interface GetTokenCompletionListener {
        void onError(String str);

        void onSuccess(String str);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public interface TokenChangeListener {
        void onTokenChange();

        void onTokenChange(String str);
    }

    void addTokenChangeListener(ExecutorService executorService, TokenChangeListener tokenChangeListener);

    void getToken(boolean z, GetTokenCompletionListener getTokenCompletionListener);

    void removeTokenChangeListener(TokenChangeListener tokenChangeListener);
}
