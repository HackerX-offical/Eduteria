package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.internal.zzdv;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzal extends BroadcastReceiver {
    private final WeakReference<Activity> zza;
    private final TaskCompletionSource<AuthResult> zzb;
    private final FirebaseAuth zzc;
    private final FirebaseUser zzd;
    private final /* synthetic */ zzad zze;

    zzal(zzad zzadVar, Activity activity, TaskCompletionSource<AuthResult> taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zze = zzadVar;
        this.zza = new WeakReference<>(activity);
        this.zzb = taskCompletionSource;
        this.zzc = firebaseAuth;
        this.zzd = firebaseUser;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Activity activity = this.zza.get();
        if (activity == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.zzb.setException(zzdv.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzad.zzb();
            return;
        }
        LocalBroadcastManager.getInstance(activity).unregisterReceiver(this);
        if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.SIGN_IN".equals(stringExtra)) {
                this.zze.zza(intent, (TaskCompletionSource<AuthResult>) this.zzb, this.zzc);
                return;
            } else if ("com.google.firebase.auth.internal.LINK".equals(stringExtra)) {
                this.zze.zza(intent, (TaskCompletionSource<AuthResult>) this.zzb, this.zzd);
                return;
            } else if (!"com.google.firebase.auth.internal.REAUTHENTICATE".equals(stringExtra)) {
                this.zzb.setException(zzdv.zza(zzy.zza(new StringBuilder(String.valueOf(stringExtra).length() + 50).append("WEB_CONTEXT_CANCELED:Unknown operation received (").append(stringExtra).append(")").toString())));
                return;
            } else {
                this.zze.zzb(intent, this.zzb, this.zzd);
                return;
            }
        }
        if (zzay.zza(intent)) {
            this.zzb.setException(zzdv.zza(zzay.zzb(intent)));
            zzad.zzb();
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzb.setException(zzdv.zza(zzy.zza("WEB_CONTEXT_CANCELED")));
            zzad.zzb();
        }
    }
}
