package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzeu extends zzeb {
    final /* synthetic */ zzes zza;

    zzeu(zzes zzesVar) {
        this.zza = zzesVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 1, new StringBuilder(37).append("Unexpected response type: ").append(this.zza.zzb).toString());
        this.zza.zzk = zzffVar;
        this.zza.zzf();
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar, com.google.android.gms.internal.firebase_auth.zzew zzewVar) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 2, new StringBuilder(37).append("Unexpected response type: ").append(this.zza.zzb).toString());
        this.zza.zzk = zzffVar;
        this.zza.zzl = zzewVar;
        this.zza.zzf();
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(zzem zzemVar) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 3, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        this.zza.zzm = zzemVar;
        this.zza.zzf();
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(zzfm zzfmVar) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 4, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        this.zza.zzn = zzfmVar;
        this.zza.zzf();
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void a_() throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 5, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        this.zza.zzf();
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zzb() throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 6, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        this.zza.zzf();
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 7, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        this.zza.zzo = str;
        this.zza.zzf();
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zzb(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 8, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        this.zza.zzp = str;
        zza(new zzew(this, str));
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 8, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        zzes.zza(this.zza, true);
        this.zza.zzw = true;
        zza(new zzev(this, phoneAuthCredential));
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zzc(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 8, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        this.zza.zzp = str;
        zzes.zza(this.zza, true);
        this.zza.zzw = true;
        zza(new zzey(this, str));
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        if (this.zza.zzb != 8) {
            this.zza.zzb(status);
            this.zza.zza(status);
        } else {
            zzes.zza(this.zza, true);
            this.zza.zzw = false;
            zza(new zzex(this, status));
        }
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 2, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        zza(status, phoneAuthCredential, (String) null, (String) null);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(com.google.android.gms.internal.firebase_auth.zzeh zzehVar) {
        zza(zzehVar.zza(), zzehVar.zzb(), zzehVar.zzc(), zzehVar.zzd());
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(com.google.android.gms.internal.firebase_auth.zzej zzejVar) {
        this.zza.zzt = zzejVar;
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        this.zza.zzb(status);
        this.zza.zzq = authCredential;
        this.zza.zzr = str;
        this.zza.zzs = str2;
        if (this.zza.zzg != null) {
            this.zza.zzg.zza(status);
        }
        this.zza.zza(status);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zzc() throws RemoteException {
        Preconditions.checkState(this.zza.zzb == 9, new StringBuilder(36).append("Unexpected response type ").append(this.zza.zzb).toString());
        this.zza.zzf();
    }

    private final void zza(zzez zzezVar) {
        this.zza.zzj.execute(new zzfa(this, zzezVar));
    }
}
