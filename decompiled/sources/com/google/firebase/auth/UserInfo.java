package com.google.firebase.auth;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public interface UserInfo {
    String getDisplayName();

    String getEmail();

    String getPhoneNumber();

    Uri getPhotoUrl();

    String getProviderId();

    String getUid();

    boolean isEmailVerified();
}
