package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzle implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzlc zzb;

    zzle(zzlc zzlcVar) {
        this.zzb = zzlcVar;
        this.zza = zzlcVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }
}
