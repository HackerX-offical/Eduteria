package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhy implements zzif {
    private final zzhu zza;
    private final zzir zzb;
    private final boolean zzc;
    private final zzgf zzd;

    private zzhy(zzir zzirVar, zzgf zzgfVar, zzhu zzhuVar) {
        this.zzb = zzirVar;
        this.zzc = zzhuVar instanceof zzgp;
        this.zzd = zzgfVar;
        this.zza = zzhuVar;
    }

    static zzhy zzc(zzir zzirVar, zzgf zzgfVar, zzhu zzhuVar) {
        return new zzhy(zzirVar, zzgfVar, zzhuVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final int zza(Object obj) {
        int iZzb = ((zzgs) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzgp) obj).zzb.zzc() : iZzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final int zzb(Object obj) {
        int iHashCode = ((zzgs) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzgp) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final Object zze() {
        zzhu zzhuVar = this.zza;
        return zzhuVar instanceof zzgs ? ((zzgs) zzhuVar).zzp() : zzhuVar.zzI().zzh();
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final void zzf(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final void zzg(Object obj, Object obj2) {
        zzih.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzih.zzo(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzfh zzfhVar) throws IOException {
        zzgs zzgsVar = (zzgs) obj;
        if (zzgsVar.zzc == zzis.zzc()) {
            zzgsVar.zzc = zzis.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final void zzi(Object obj, zzje zzjeVar) throws IOException {
        Iterator itZze = ((zzgp) obj).zzb.zze();
        while (itZze.hasNext()) {
            Map.Entry entry = (Map.Entry) itZze.next();
            zzgi zzgiVar = (zzgi) entry.getKey();
            if (zzgiVar.zzc() != zzjd.MESSAGE || zzgiVar.zze() || zzgiVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzhb) {
                zzjeVar.zzw(zzgiVar.zza(), ((zzhb) entry).zza().zzb());
            } else {
                zzjeVar.zzw(zzgiVar.zza(), entry.getValue());
            }
        }
        ((zzgs) obj).zzc.zzk(zzjeVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzgs) obj).zzc.equals(((zzgs) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzgp) obj).zzb.equals(((zzgp) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzif
    public final boolean zzk(Object obj) {
        return ((zzgp) obj).zzb.zzh();
    }
}
