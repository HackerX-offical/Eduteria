package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzav {
    private Context zza;
    private String zzb;
    private SharedPreferences zzc;
    private Logger zzd;

    public zzav(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zza = context.getApplicationContext();
        this.zzc = this.zza.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.zzb), 0);
        this.zzd = new Logger("StorageHelpers", new String[0]);
    }

    public final void zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String strZzc = zzc(firebaseUser);
        if (TextUtils.isEmpty(strZzc)) {
            return;
        }
        this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", strZzc).apply();
    }

    public final FirebaseUser zza() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zza(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void zza(FirebaseUser firebaseUser, zzff zzffVar) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzffVar);
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), zzffVar.zzh()).apply();
    }

    public final zzff zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), null);
        if (string != null) {
            return zzff.zzb(string);
        }
        return null;
    }

    public final void zza(String str) {
        this.zzc.edit().remove(str).apply();
    }

    private final String zzc(FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        if (!zzn.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzn zznVar = (zzn) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zznVar.zzf());
            jSONObject.put("applicationName", zznVar.zzc().getName());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zznVar.zzi() != null) {
                JSONArray jSONArray = new JSONArray();
                List<zzj> listZzi = zznVar.zzi();
                for (int i = 0; i < listZzi.size(); i++) {
                    jSONArray.put(listZzi.get(i).zzb());
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zznVar.isAnonymous());
            jSONObject.put("version", "2");
            if (zznVar.getMetadata() != null) {
                jSONObject.put("userMetadata", ((zzp) zznVar.getMetadata()).zza());
            }
            List<com.google.firebase.auth.zzy> listZza = ((zzr) zznVar.zzh()).zza();
            if (listZza != null && !listZza.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < listZza.size(); i2++) {
                    jSONArray2.put(listZza.get(i2).zza());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            this.zzd.wtf("Failed to turn object into JSON", e2, new Object[0]);
            throw new com.google.firebase.auth.api.zza(e2);
        }
    }

    private final zzn zza(JSONObject jSONObject) {
        JSONArray jSONArray;
        zzp zzpVarZza;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray2 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray2.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzj.zza(jSONArray2.getString(i)));
            }
            zzn zznVar = new zzn(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zznVar.zza(zzff.zzb(string));
            }
            if (!z) {
                zznVar.zzb();
            }
            zznVar.zza(str);
            if (jSONObject.has("userMetadata") && (zzpVarZza = zzp.zza(jSONObject.getJSONObject("userMetadata"))) != null) {
                zznVar.zza(zzpVarZza);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i2));
                    arrayList2.add("phone".equals(jSONObject2.optString("factorIdKey")) ? com.google.firebase.auth.zzaf.zza(jSONObject2) : null);
                }
                zznVar.zzb(arrayList2);
            }
            return zznVar;
        } catch (com.google.firebase.auth.api.zza | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e2) {
            this.zzd.wtf(e2);
            return null;
        }
    }
}
