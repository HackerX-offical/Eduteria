package com.google.firebase.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public interface ActionCodeResult {
    public static final int EMAIL = 0;
    public static final int ERROR = 3;
    public static final int FROM_EMAIL = 1;
    public static final int PASSWORD_RESET = 0;
    public static final int RECOVER_EMAIL = 2;
    public static final int SIGN_IN_WITH_EMAIL_LINK = 4;
    public static final int VERIFY_EMAIL = 1;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActionDataKey {
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Operation {
    }

    String getData(int i);

    int getOperation();
}
