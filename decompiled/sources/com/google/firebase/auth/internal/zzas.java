package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.internal.zzdv;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzas {
    private static long zza = 3600000;
    private static final zzbg<String> zzb = zzbg.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");
    private static final zzas zzc = new zzas();
    private Task<AuthResult> zzd;
    private long zze = 0;

    private zzas() {
    }

    public static zzas zza() {
        return zzc;
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.zzb().getName());
        editorEdit.commit();
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        Preconditions.checkNotNull(firebaseUser);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.zzb().getName());
        editorEdit.putString("firebaseUserUid", firebaseUser.getUid());
        editorEdit.commit();
    }

    public static void zza(Context context, zzfy zzfyVar, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzfyVar));
        editorEdit.putString("operation", str);
        editorEdit.putString("tenantId", str2);
        editorEdit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        editorEdit.commit();
    }

    public static void zza(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.getStatusCode());
        editorEdit.putString("statusMessage", status.getStatusMessage());
        editorEdit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        editorEdit.commit();
    }

    public final void zza(FirebaseAuth firebaseAuth) {
        zzfy zzfyVar;
        String string;
        Preconditions.checkNotNull(firebaseAuth);
        SharedPreferences sharedPreferences = firebaseAuth.zzb().getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (firebaseAuth.zzb().getName().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            if (sharedPreferences.contains("verifyAssertionRequest")) {
                zzfyVar = (zzfy) SafeParcelableSerializer.deserializeFromString(sharedPreferences.getString("verifyAssertionRequest", ""), zzfy.CREATOR);
                String string2 = sharedPreferences.getString("operation", "");
                String string3 = sharedPreferences.getString("tenantId", null);
                string = sharedPreferences.getString("firebaseUserUid", "");
                this.zze = sharedPreferences.getLong("timestamp", 0L);
                if (string3 != null) {
                    firebaseAuth.zza(string3);
                    zzfyVar.zzb(string3);
                }
                string2.hashCode();
                switch (string2) {
                    case "com.google.firebase.auth.internal.REAUTHENTICATE":
                        if (firebaseAuth.getCurrentUser().getUid().equals(string)) {
                            this.zzd = firebaseAuth.getCurrentUser().reauthenticateAndRetrieveData(com.google.firebase.auth.zzg.zza(zzfyVar));
                            break;
                        } else {
                            this.zzd = null;
                            break;
                        }
                        break;
                    case "com.google.firebase.auth.internal.LINK":
                        if (firebaseAuth.getCurrentUser().getUid().equals(string)) {
                            this.zzd = firebaseAuth.getCurrentUser().linkWithCredential(com.google.firebase.auth.zzg.zza(zzfyVar));
                            break;
                        } else {
                            this.zzd = null;
                            break;
                        }
                        break;
                    case "com.google.firebase.auth.internal.SIGN_IN":
                        this.zzd = firebaseAuth.signInWithCredential(com.google.firebase.auth.zzg.zza(zzfyVar));
                        break;
                    default:
                        this.zzd = null;
                        break;
                }
                zza(sharedPreferences);
                return;
            }
            if (sharedPreferences.contains("statusCode")) {
                Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
                this.zze = sharedPreferences.getLong("timestamp", 0L);
                zza(sharedPreferences);
                this.zzd = Tasks.forException(zzdv.zza(status));
            }
        }
    }

    public final Task<AuthResult> zzb() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zze < zza) {
            return this.zzd;
        }
        return null;
    }

    public final void zza(Context context) {
        Preconditions.checkNotNull(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzd = null;
        this.zze = 0L;
    }

    private static void zza(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        zzbg<String> zzbgVar = zzb;
        int size = zzbgVar.size();
        int i = 0;
        while (i < size) {
            String str = zzbgVar.get(i);
            i++;
            editorEdit.remove(str);
        }
        editorEdit.commit();
    }
}
