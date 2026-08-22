package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzei extends zzao implements Api.ApiOptions.HasOptions {
    private final String zzb;

    private zzei(String str) {
        this.zzb = Preconditions.checkNotEmpty(str, "A valid API key must be provided");
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzei) {
            return Objects.equal(this.zzb, ((zzei) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    @Override // com.google.firebase.auth.api.internal.zzao
    /* JADX INFO: renamed from: zza */
    public final /* synthetic */ zzao clone() {
        return (zzei) clone();
    }

    @Override // com.google.firebase.auth.api.internal.zzao
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new zzel(this.zzb).zza();
    }

    /* synthetic */ zzei(String str, zzej zzejVar) {
        this(str);
    }
}
