package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public interface AdditionalUserInfo extends SafeParcelable {
    Map<String, Object> getProfile();

    String getProviderId();

    String getUsername();

    boolean isNewUser();
}
