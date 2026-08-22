package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzau {
    private final zzaf zza;
    private final boolean zzb;
    private final zzba zzc;
    private final int zzd;

    private zzau(zzba zzbaVar) {
        this(zzbaVar, false, zzaj.zza, Integer.MAX_VALUE);
    }

    private zzau(zzba zzbaVar, boolean z, zzaf zzafVar, int i) {
        this.zzc = zzbaVar;
        this.zzb = false;
        this.zza = zzafVar;
        this.zzd = Integer.MAX_VALUE;
    }

    public static zzau zza(char c2) {
        zzah zzahVar = new zzah('.');
        zzav.zza(zzahVar);
        return new zzau(new zzax(zzahVar));
    }

    public static zzau zza(String str) {
        zzal zzalVarZza = zzar.zza(str);
        if (zzalVarZza.zza("").zza()) {
            throw new IllegalArgumentException(zzbd.zza("The pattern may not match the empty string: %s", zzalVarZza));
        }
        return new zzau(new zzaz(zzalVarZza));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzav.zza(charSequence);
        Iterator<String> itZza = this.zzc.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZza.hasNext()) {
            arrayList.add(itZza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
