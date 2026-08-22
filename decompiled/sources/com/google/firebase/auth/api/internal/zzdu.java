package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdu {
    private final zzec zza;
    private final Logger zzb;

    public zzdu(zzec zzecVar, Logger logger) {
        this.zza = (zzec) Preconditions.checkNotNull(zzecVar);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        try {
            this.zza.zza(zzffVar);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending token result.", e2, new Object[0]);
        }
    }

    public final void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar, com.google.android.gms.internal.firebase_auth.zzew zzewVar) {
        try {
            this.zza.zza(zzffVar, zzewVar);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending get token and account info user response", e2, new Object[0]);
        }
    }

    public final void zza(zzem zzemVar) {
        try {
            this.zza.zza(zzemVar);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending create auth uri response.", e2, new Object[0]);
        }
    }

    public final void zza(zzfm zzfmVar) {
        try {
            this.zza.zza(zzfmVar);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending password reset response.", e2, new Object[0]);
        }
    }

    public final void zza() {
        try {
            this.zza.a_();
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending delete account response.", e2, new Object[0]);
        }
    }

    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending email verification response.", e2, new Object[0]);
        }
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending set account info response.", e2, new Object[0]);
        }
    }

    public final void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending send verification code response.", e2, new Object[0]);
        }
    }

    public final void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending failure result.", e2, new Object[0]);
        }
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zza(status, phoneAuthCredential);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending failure result.", e2, new Object[0]);
        }
    }

    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when setting FirebaseUI Version", e2, new Object[0]);
        }
    }

    public final void zza(com.google.android.gms.internal.firebase_auth.zzeh zzehVar) {
        try {
            this.zza.zza(zzehVar);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending failure result with credential", e2, new Object[0]);
        }
    }

    public final void zza(com.google.android.gms.internal.firebase_auth.zzej zzejVar) {
        try {
            this.zza.zza(zzejVar);
        } catch (RemoteException e2) {
            this.zzb.e("RemoteException when sending failure result for mfa", e2, new Object[0]);
        }
    }
}
