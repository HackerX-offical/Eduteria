package com.google.android.gms.internal.appinvite;

import android.os.Bundle;
import com.google.firebase.appinvite.FirebaseAppInvite;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public final class zzt extends FirebaseAppInvite {
    private final Bundle zzt;

    public zzt(Bundle bundle) {
        this.zzt = bundle;
    }

    @Override // com.google.firebase.appinvite.FirebaseAppInvite
    public final String getInvitationId() {
        return this.zzt.getString("com.google.firebase.appinvite.fdl.extension.InvitationId", null);
    }
}
