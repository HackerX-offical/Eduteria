package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhe;
import com.google.android.gms.internal.vision.zzhf;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzhe<MessageType extends zzhf<MessageType, BuilderType>, BuilderType extends zzhe<MessageType, BuilderType>> implements zzkn {
    @Override // 
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzif zzifVar, zzio zzioVar) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2, zzio zzioVar) throws zzjk {
        try {
            zzif zzifVarZza = zzif.zza(bArr, 0, i2, false);
            zza(zzifVarZza, zzioVar);
            zzifVarZza.zza(0);
            return this;
        } catch (zzjk e2) {
            throw e2;
        } catch (IOException e3) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf("byte array").length()).append("Reading ").append(name).append(" from a byte array threw an IOException (should never happen).").toString(), e3);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkn
    public final /* synthetic */ zzkn zza(zzkk zzkkVar) {
        if (!zzr().getClass().isInstance(zzkkVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzhf) zzkkVar);
    }
}
