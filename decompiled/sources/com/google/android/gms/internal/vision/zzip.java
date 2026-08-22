package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzip extends zziq<zzjb.zzf> {
    zzip() {
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final boolean zza(zzkk zzkkVar) {
        return zzkkVar instanceof zzjb.zzc;
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final zziu<zzjb.zzf> zza(Object obj) {
        return ((zzjb.zzc) obj).zzc;
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final zziu<zzjb.zzf> zzb(Object obj) {
        return ((zzjb.zzc) obj).zza();
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final <UT, UB> UB zza(zzld zzldVar, Object obj, zzio zzioVar, zziu<zzjb.zzf> zziuVar, UB ub, zzlu<UT, UB> zzluVar) throws IOException {
        Object objZza;
        zzjb.zze zzeVar = (zzjb.zze) obj;
        int i = zzeVar.zzd.zzb;
        boolean z = zzeVar.zzd.zzd;
        zzjh zzjhVar = null;
        Object objZza2 = null;
        if (zzeVar.zzd.zzc == zzml.zzn) {
            zzjhVar.zza(zzldVar.zzh());
            throw null;
        }
        switch (zzis.zza[zzeVar.zzd.zzc.ordinal()]) {
            case 1:
                objZza2 = Double.valueOf(zzldVar.zzd());
                break;
            case 2:
                objZza2 = Float.valueOf(zzldVar.zze());
                break;
            case 3:
                objZza2 = Long.valueOf(zzldVar.zzg());
                break;
            case 4:
                objZza2 = Long.valueOf(zzldVar.zzf());
                break;
            case 5:
                objZza2 = Integer.valueOf(zzldVar.zzh());
                break;
            case 6:
                objZza2 = Long.valueOf(zzldVar.zzi());
                break;
            case 7:
                objZza2 = Integer.valueOf(zzldVar.zzj());
                break;
            case 8:
                objZza2 = Boolean.valueOf(zzldVar.zzk());
                break;
            case 9:
                objZza2 = Integer.valueOf(zzldVar.zzo());
                break;
            case 10:
                objZza2 = Integer.valueOf(zzldVar.zzq());
                break;
            case 11:
                objZza2 = Long.valueOf(zzldVar.zzr());
                break;
            case 12:
                objZza2 = Integer.valueOf(zzldVar.zzs());
                break;
            case 13:
                objZza2 = Long.valueOf(zzldVar.zzt());
                break;
            case 14:
                throw new IllegalStateException("Shouldn't reach here.");
            case 15:
                objZza2 = zzldVar.zzn();
                break;
            case 16:
                objZza2 = zzldVar.zzl();
                break;
            case 17:
                objZza2 = zzldVar.zzb(zzeVar.zzc.getClass(), zzioVar);
                break;
            case 18:
                objZza2 = zzldVar.zza(zzeVar.zzc.getClass(), zzioVar);
                break;
        }
        if (zzeVar.zzd.zzd) {
            zziuVar.zzb(zzeVar.zzd, objZza2);
            return ub;
        }
        int i2 = zzis.zza[zzeVar.zzd.zzc.ordinal()];
        if ((i2 == 17 || i2 == 18) && (objZza = zziuVar.zza(zzeVar.zzd)) != null) {
            objZza2 = zzjf.zza(objZza, objZza2);
        }
        zziuVar.zza(zzeVar.zzd, objZza2);
        return ub;
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final int zza(Map.Entry<?, ?> entry) {
        return ((zzjb.zzf) entry.getKey()).zzb;
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final void zza(zzmr zzmrVar, Map.Entry<?, ?> entry) throws IOException {
        zzjb.zzf zzfVar = (zzjb.zzf) entry.getKey();
        if (zzfVar.zzd) {
            switch (zzis.zza[zzfVar.zzc.ordinal()]) {
                case 1:
                    zzle.zza(zzfVar.zzb, (List<Double>) entry.getValue(), zzmrVar, false);
                    break;
                case 2:
                    zzle.zzb(zzfVar.zzb, (List<Float>) entry.getValue(), zzmrVar, false);
                    break;
                case 3:
                    zzle.zzc(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 4:
                    zzle.zzd(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 5:
                    zzle.zzh(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 6:
                    zzle.zzf(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 7:
                    zzle.zzk(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 8:
                    zzle.zzn(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 9:
                    zzle.zzi(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 10:
                    zzle.zzl(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 11:
                    zzle.zzg(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 12:
                    zzle.zzj(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 13:
                    zzle.zze(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 14:
                    zzle.zzh(zzfVar.zzb, (List) entry.getValue(), zzmrVar, false);
                    break;
                case 15:
                    zzle.zzb(zzfVar.zzb, (List<zzht>) entry.getValue(), zzmrVar);
                    break;
                case 16:
                    zzle.zza(zzfVar.zzb, (List<String>) entry.getValue(), zzmrVar);
                    break;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzle.zzb(zzfVar.zzb, (List<?>) entry.getValue(), zzmrVar, zzky.zza().zza((Class) list.get(0).getClass()));
                        break;
                    }
                    break;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzle.zza(zzfVar.zzb, (List<?>) entry.getValue(), zzmrVar, zzky.zza().zza((Class) list2.get(0).getClass()));
                        break;
                    }
                    break;
            }
        }
        switch (zzis.zza[zzfVar.zzc.ordinal()]) {
            case 1:
                zzmrVar.zza(zzfVar.zzb, ((Double) entry.getValue()).doubleValue());
                break;
            case 2:
                zzmrVar.zza(zzfVar.zzb, ((Float) entry.getValue()).floatValue());
                break;
            case 3:
                zzmrVar.zza(zzfVar.zzb, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                zzmrVar.zzc(zzfVar.zzb, ((Long) entry.getValue()).longValue());
                break;
            case 5:
                zzmrVar.zzc(zzfVar.zzb, ((Integer) entry.getValue()).intValue());
                break;
            case 6:
                zzmrVar.zzd(zzfVar.zzb, ((Long) entry.getValue()).longValue());
                break;
            case 7:
                zzmrVar.zzd(zzfVar.zzb, ((Integer) entry.getValue()).intValue());
                break;
            case 8:
                zzmrVar.zza(zzfVar.zzb, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 9:
                zzmrVar.zze(zzfVar.zzb, ((Integer) entry.getValue()).intValue());
                break;
            case 10:
                zzmrVar.zza(zzfVar.zzb, ((Integer) entry.getValue()).intValue());
                break;
            case 11:
                zzmrVar.zzb(zzfVar.zzb, ((Long) entry.getValue()).longValue());
                break;
            case 12:
                zzmrVar.zzf(zzfVar.zzb, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                zzmrVar.zze(zzfVar.zzb, ((Long) entry.getValue()).longValue());
                break;
            case 14:
                zzmrVar.zzc(zzfVar.zzb, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                zzmrVar.zza(zzfVar.zzb, (zzht) entry.getValue());
                break;
            case 16:
                zzmrVar.zza(zzfVar.zzb, (String) entry.getValue());
                break;
            case 17:
                zzmrVar.zzb(zzfVar.zzb, entry.getValue(), zzky.zza().zza((Class) entry.getValue().getClass()));
                break;
            case 18:
                zzmrVar.zza(zzfVar.zzb, entry.getValue(), zzky.zza().zza((Class) entry.getValue().getClass()));
                break;
        }
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final Object zza(zzio zzioVar, zzkk zzkkVar, int i) {
        return zzioVar.zza(zzkkVar, i);
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final void zza(zzld zzldVar, Object obj, zzio zzioVar, zziu<zzjb.zzf> zziuVar) throws IOException {
        zzjb.zze zzeVar = (zzjb.zze) obj;
        zziuVar.zza(zzeVar.zzd, zzldVar.zza(zzeVar.zzc.getClass(), zzioVar));
    }

    @Override // com.google.android.gms.internal.vision.zziq
    final void zza(zzht zzhtVar, Object obj, zzio zzioVar, zziu<zzjb.zzf> zziuVar) throws IOException {
        byte[] bArr;
        zzjb.zze zzeVar = (zzjb.zze) obj;
        zzkk zzkkVarZze = zzeVar.zzc.zzq().zze();
        int iZza = zzhtVar.zza();
        if (iZza == 0) {
            bArr = zzjf.zzb;
        } else {
            byte[] bArr2 = new byte[iZza];
            zzhtVar.zza(bArr2, 0, 0, iZza);
            bArr = bArr2;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (byteBufferWrap.hasArray()) {
            zzho zzhoVar = new zzho(byteBufferWrap, true);
            zzky.zza().zza(zzkkVarZze).zza(zzkkVarZze, zzhoVar, zzioVar);
            zziuVar.zza(zzeVar.zzd, zzkkVarZze);
            if (zzhoVar.zza() != Integer.MAX_VALUE) {
                throw zzjk.zze();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
