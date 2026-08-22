package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzjp;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzgq<MessageType extends zzjp> implements zzjz<MessageType> {
    private static final zzhr zza = zzhr.zza();

    private final MessageType zzb(InputStream inputStream, zzhr zzhrVar) throws zzip {
        zzhf zzhkVar;
        if (inputStream == null) {
            byte[] bArr = zzig.zzb;
            zzhkVar = zzhf.zza(bArr, 0, bArr.length, false);
        } else {
            zzhkVar = new zzhk(inputStream);
        }
        MessageType messagetypeZza = zza(zzhkVar, zzhrVar);
        try {
            zzhkVar.zza(0);
            return messagetypeZza;
        } catch (zzip e2) {
            throw e2.zza(messagetypeZza);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjz
    public final /* synthetic */ Object zza(InputStream inputStream, zzhr zzhrVar) throws zzip {
        zzky zzkyVar;
        zzjp zzjpVarZzb = zzb(inputStream, zzhrVar);
        if (zzjpVarZzb == null || zzjpVarZzb.zzaa()) {
            return zzjpVarZzb;
        }
        if (zzjpVarZzb instanceof zzgl) {
            zzkyVar = new zzky((zzgl) zzjpVarZzb);
        } else if (zzjpVarZzb instanceof zzgn) {
            zzkyVar = new zzky((zzgn) zzjpVarZzb);
        } else {
            zzkyVar = new zzky(zzjpVarZzb);
        }
        throw new zzip(zzkyVar.getMessage()).zza(zzjpVarZzb);
    }
}
