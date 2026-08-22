package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.api.internal.zzao;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzam<T extends zzao> {
    private static Logger zza = new Logger("BiChannelGoogleApi", "FirebaseAuth: ");
    private zzal<T> zzb;

    abstract Future<zzal<T>> zza();

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> zza(zzap<A, ResultT> zzapVar) {
        GoogleApi<T> googleApiZza = zza(zzapVar.zza());
        if (googleApiZza == null) {
            return zzb();
        }
        if (((zzao) googleApiZza.getApiOptions()).zza) {
            zzapVar.zzd();
        }
        return (Task<ResultT>) googleApiZza.doRead(zzapVar.zzb());
    }

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> zzb(zzap<A, ResultT> zzapVar) {
        GoogleApi<T> googleApiZza = zza(zzapVar.zza());
        if (googleApiZza == null) {
            return zzb();
        }
        if (((zzao) googleApiZza.getApiOptions()).zza) {
            zzapVar.zzd();
        }
        return (Task<ResultT>) googleApiZza.doWrite(zzapVar.zzb());
    }

    private static <ResultT> Task<ResultT> zzb() {
        return Tasks.forException(zzdv.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
    }

    private final GoogleApi<T> zza(String str) {
        zzal<T> zzalVarZzc = zzc();
        if (zzalVarZzc.zzc.zza(str)) {
            Logger logger = zza;
            String strValueOf = String.valueOf(zzalVarZzc.zzb);
            logger.i(new StringBuilder(String.valueOf(strValueOf).length() + 43).append("getGoogleApiForMethod() returned Fallback: ").append(strValueOf).toString(), new Object[0]);
            return (GoogleApi<T>) zzalVarZzc.zzb;
        }
        Logger logger2 = zza;
        String strValueOf2 = String.valueOf(zzalVarZzc.zza);
        logger2.i(new StringBuilder(String.valueOf(strValueOf2).length() + 38).append("getGoogleApiForMethod() returned Gms: ").append(strValueOf2).toString(), new Object[0]);
        return (GoogleApi<T>) zzalVarZzc.zza;
    }

    private final zzal<T> zzc() {
        zzal<T> zzalVar;
        synchronized (this) {
            if (this.zzb == null) {
                try {
                    this.zzb = zza().get();
                } catch (Exception e2) {
                    String strValueOf = String.valueOf(e2.getMessage());
                    throw new RuntimeException(strValueOf.length() != 0 ? "There was an error while initializing the connection to Google Play Services: ".concat(strValueOf) : new String("There was an error while initializing the connection to Google Play Services: "));
                }
            }
            zzalVar = this.zzb;
        }
        return zzalVar;
    }
}
