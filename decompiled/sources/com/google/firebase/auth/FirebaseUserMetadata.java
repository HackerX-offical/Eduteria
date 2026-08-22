package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public interface FirebaseUserMetadata extends SafeParcelable {
    long getCreationTimestamp();

    long getLastSignInTimestamp();
}
