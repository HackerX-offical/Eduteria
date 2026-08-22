package com.google.firebase.auth.api.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzfj;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzgk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzau extends zzam<zzei> {
    private final Context zza;
    private final zzei zzb;
    private final Future<zzal<zzei>> zzc = zza();

    zzau(Context context, zzei zzeiVar) {
        this.zza = context;
        this.zzb = zzeiVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    final Future<zzal<zzei>> zza() {
        Future<zzal<zzei>> future = this.zzc;
        if (future != null) {
            return future;
        }
        return com.google.android.gms.internal.firebase_auth.zzf.zza().zza(com.google.android.gms.internal.firebase_auth.zzk.zza).submit(new zzdr(this.zzb, this.zza));
    }

    public final Task<GetTokenResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzbi zzbiVar = (zzbi) new zzbi(str).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zza(zzbiVar), (zzap) zzbiVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, com.google.firebase.auth.internal.zza zzaVar) {
        zzcu zzcuVar = (zzcu) new zzcu(str, str2).zza(firebaseApp).zza(zzaVar);
        return zza((Task) zzb(zzcuVar), (zzap) zzcuVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, AuthCredential authCredential, String str, com.google.firebase.auth.internal.zza zzaVar) {
        zzcs zzcsVar = (zzcs) new zzcs(authCredential, str).zza(firebaseApp).zza(zzaVar);
        return zza((Task) zzb(zzcsVar), (zzap) zzcsVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzbs zzbsVar = (zzbs) new zzbs(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzbsVar), (zzap) zzbsVar);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzbu zzbuVar = (zzbu) new zzbu(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzbuVar), (zzap) zzbuVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, com.google.firebase.auth.internal.zza zzaVar, String str) {
        zzcq zzcqVar = (zzcq) new zzcq(str).zza(firebaseApp).zza(zzaVar);
        return zza((Task) zzb(zzcqVar), (zzap) zzcqVar);
    }

    public final void zza(FirebaseApp firebaseApp, zzfr zzfrVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zzdq zzdqVar = (zzdq) new zzdq(zzfrVar).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor);
        zza((Task) zzb(zzdqVar), (zzap) zzdqVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzdm zzdmVar = (zzdm) new zzdm(userProfileChangeRequest).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzdmVar), (zzap) zzdmVar);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzdg zzdgVar = (zzdg) new zzdg(str).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzdgVar), (zzap) zzdgVar);
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzdi zzdiVar = (zzdi) new zzdi(str).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzdiVar), (zzap) zzdiVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzdk zzdkVar = (zzdk) new zzdk(phoneAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzdkVar), (zzap) zzdkVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, String str3, com.google.firebase.auth.internal.zza zzaVar) {
        zzbc zzbcVar = (zzbc) new zzbc(str, str2, str3).zza(firebaseApp).zza(zzaVar);
        return zza((Task) zzb(zzbcVar), (zzap) zzbcVar);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, String str, String str2, String str3, com.google.firebase.auth.internal.zza zzaVar) {
        zzcw zzcwVar = (zzcw) new zzcw(str, str2, str3).zza(firebaseApp).zza(zzaVar);
        return zza((Task) zzb(zzcwVar), (zzap) zzcwVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, com.google.firebase.auth.internal.zza zzaVar) {
        zzcy zzcyVar = (zzcy) new zzcy(emailAuthCredential).zza(firebaseApp).zza(zzaVar);
        return zza((Task) zzb(zzcyVar), (zzap) zzcyVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzca zzcaVar = (zzca) new zzca(str, str2, str3).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzcaVar), (zzap) zzcaVar);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzcc zzccVar = (zzcc) new zzcc(str, str2, str3).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzccVar), (zzap) zzccVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzbw zzbwVar = (zzbw) new zzbw(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzbwVar), (zzap) zzbwVar);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzby zzbyVar = (zzby) new zzby(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzbyVar), (zzap) zzbyVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, com.google.firebase.auth.internal.zza zzaVar) {
        zzda zzdaVar = (zzda) new zzda(phoneAuthCredential, str).zza(firebaseApp).zza(zzaVar);
        return zza((Task) zzb(zzdaVar), (zzap) zzdaVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzce zzceVar = (zzce) new zzce(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzceVar), (zzap) zzceVar);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzcg zzcgVar = (zzcg) new zzcg(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzcgVar), (zzap) zzcgVar);
    }

    public final Task<SignInMethodQueryResult> zza(FirebaseApp firebaseApp, String str, String str2) {
        zzbg zzbgVar = (zzbg) new zzbg(str, str2).zza(firebaseApp);
        return zza((Task) zza(zzbgVar), (zzap) zzbgVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zza(zzgk.PASSWORD_RESET);
        zzcm zzcmVar = (zzcm) new zzcm(str, actionCodeSettings, str2, "sendPasswordResetEmail").zza(firebaseApp);
        return zza((Task) zzb(zzcmVar), (zzap) zzcmVar);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zza(zzgk.EMAIL_SIGNIN);
        zzcm zzcmVar = (zzcm) new zzcm(str, actionCodeSettings, str2, "sendSignInLinkToEmail").zza(firebaseApp);
        return zza((Task) zzb(zzcmVar), (zzap) zzcmVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        zzck zzckVar = (zzck) new zzck(str, actionCodeSettings).zza(firebaseApp);
        return zza((Task) zzb(zzckVar), (zzap) zzckVar);
    }

    public final Task<ActionCodeResult> zzb(FirebaseApp firebaseApp, String str, String str2) {
        zzay zzayVar = (zzay) new zzay(str, str2).zza(firebaseApp);
        return zza((Task) zzb(zzayVar), (zzap) zzayVar);
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, String str, String str2) {
        zzaw zzawVar = (zzaw) new zzaw(str, str2).zza(firebaseApp);
        return zza((Task) zzb(zzawVar), (zzap) zzawVar);
    }

    public final Task<String> zzd(FirebaseApp firebaseApp, String str, String str2) {
        zzdo zzdoVar = (zzdo) new zzdo(str, str2).zza(firebaseApp);
        return zza((Task) zzb(zzdoVar), (zzap) zzdoVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2, String str3) {
        zzba zzbaVar = (zzba) new zzba(str, str2, str3).zza(firebaseApp);
        return zza((Task) zzb(zzbaVar), (zzap) zzbaVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, com.google.firebase.auth.internal.zzaz zzazVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzazVar);
        List<String> listZza = firebaseUser.zza();
        if (listZza != null && listZza.contains(authCredential.getProvider())) {
            return Tasks.forException(zzdv.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzg()) {
                zzbk zzbkVar = (zzbk) new zzbk(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
                return zza((Task) zzb(zzbkVar), (zzap) zzbkVar);
            }
            zzbq zzbqVar = (zzbq) new zzbq(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
            return zza((Task) zzb(zzbqVar), (zzap) zzbqVar);
        }
        if (authCredential instanceof PhoneAuthCredential) {
            zzbo zzboVar = (zzbo) new zzbo((PhoneAuthCredential) authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
            return zza((Task) zzb(zzboVar), (zzap) zzboVar);
        }
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzazVar);
        zzbm zzbmVar = (zzbm) new zzbm(authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzbmVar), (zzap) zzbmVar);
    }

    public final Task<AuthResult> zzd(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, com.google.firebase.auth.internal.zzaz zzazVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzazVar);
        List<String> listZza = firebaseUser.zza();
        if ((listZza != null && !listZza.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzdv.zza(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        str.hashCode();
        if (str.equals("password")) {
            zzdc zzdcVar = (zzdc) new zzdc().zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
            return zza((Task) zzb(zzdcVar), (zzap) zzdcVar);
        }
        zzde zzdeVar = (zzde) new zzde(str).zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zzb(zzdeVar), (zzap) zzdeVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, com.google.firebase.auth.internal.zzaz zzazVar) {
        zzci zzciVar = (zzci) new zzci().zza(firebaseApp).zza(firebaseUser).zza(zzazVar).zza((com.google.firebase.auth.internal.zzae) zzazVar);
        return zza((Task) zza(zzciVar), (zzap) zzciVar);
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, com.google.firebase.auth.internal.zzab zzabVar) {
        zzbe zzbeVar = (zzbe) new zzbe().zza(firebaseUser).zza(zzabVar).zza((com.google.firebase.auth.internal.zzae) zzabVar);
        return zza((Task) zzb(zzbeVar), (zzap) zzbeVar);
    }

    public final Task<Void> zza(String str) {
        zzco zzcoVar = new zzco(str);
        return zza((Task) zzb(zzcoVar), (zzap) zzcoVar);
    }

    static com.google.firebase.auth.internal.zzn zza(FirebaseApp firebaseApp, com.google.android.gms.internal.firebase_auth.zzew zzewVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzewVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.google.firebase.auth.internal.zzj(zzewVar, FirebaseAuthProvider.PROVIDER_ID));
        List<zzfj> listZzj = zzewVar.zzj();
        if (listZzj != null && !listZzj.isEmpty()) {
            for (int i = 0; i < listZzj.size(); i++) {
                arrayList.add(new com.google.firebase.auth.internal.zzj(listZzj.get(i)));
            }
        }
        com.google.firebase.auth.internal.zzn zznVar = new com.google.firebase.auth.internal.zzn(firebaseApp, arrayList);
        zznVar.zza(new com.google.firebase.auth.internal.zzp(zzewVar.zzh(), zzewVar.zzg()));
        zznVar.zza(zzewVar.zzi());
        zznVar.zza(zzewVar.zzl());
        zznVar.zzb(com.google.firebase.auth.internal.zzar.zza(zzewVar.zzm()));
        return zznVar;
    }

    private final <ResultT> Task<ResultT> zza(Task<ResultT> task, zzap<zzdt, ResultT> zzapVar) {
        return (Task<ResultT>) task.continueWithTask(new zzat(this, zzapVar));
    }
}
