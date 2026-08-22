package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzgl;
import com.google.android.gms.internal.firebase_auth.zzgo;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzgo<MessageType extends zzgl<MessageType, BuilderType>, BuilderType extends zzgo<MessageType, BuilderType>> implements zzjo {
    @Override // 
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    protected abstract BuilderType zza(MessageType messagetype);

    @Override // com.google.android.gms.internal.firebase_auth.zzjo
    public final /* synthetic */ zzjo zza(zzjp zzjpVar) {
        if (!zzag().getClass().isInstance(zzjpVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzgl) zzjpVar);
    }
}
