package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzfc;
import com.google.android.gms.internal.play_billing.zzfd;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfd<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzfc<MessageType, BuilderType>> implements zzhu {
    protected int zza = 0;

    protected static void zzg(Iterable iterable, List list) {
        zzfc.zzc(iterable, list);
    }

    int zze(zzif zzifVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final zzfs zzf() {
        try {
            int iZzk = zzk();
            zzfs zzfsVar = zzfs.zzb;
            byte[] bArr = new byte[iZzk];
            zzfw zzfwVar = new zzfw(bArr, 0, iZzk);
            zzJ(zzfwVar);
            zzfwVar.zzB();
            return new zzfq(bArr);
        } catch (IOException e2) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e2);
        }
    }

    public final byte[] zzh() {
        try {
            int iZzk = zzk();
            byte[] bArr = new byte[iZzk];
            zzfw zzfwVar = new zzfw(bArr, 0, iZzk);
            zzJ(zzfwVar);
            zzfwVar.zzB();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e2);
        }
    }
}
