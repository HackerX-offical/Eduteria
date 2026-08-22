package com.google.firebase.appinvite;

import android.os.Bundle;
import com.google.android.gms.internal.appinvite.zzt;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FirebaseAppInvite {
    public abstract String getInvitationId();

    public static FirebaseAppInvite getInvitation(PendingDynamicLinkData pendingDynamicLinkData) {
        Bundle extensions = pendingDynamicLinkData.getExtensions();
        if (extensions == null || extensions.getString("com.google.firebase.appinvite.fdl.extension.InvitationId", null) == null) {
            return null;
        }
        return new zzt(extensions);
    }
}
