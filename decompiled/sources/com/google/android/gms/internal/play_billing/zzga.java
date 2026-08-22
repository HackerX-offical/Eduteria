package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzga implements zzje {
    private final zzfz zza;

    private zzga(zzfz zzfzVar) {
        byte[] bArr = zzgx.zzb;
        this.zza = zzfzVar;
        zzfzVar.zza = this;
    }

    public static zzga zza(zzfz zzfzVar) {
        zzga zzgaVar = zzfzVar.zza;
        return zzgaVar != null ? zzgaVar : new zzga(zzfzVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzs(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzu(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzr(i, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzp(i, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzs(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzd(int i, zzfs zzfsVar) throws IOException {
        this.zza.zze(i, zzfsVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzfs) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzf(int i, double d2) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d2));
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzr(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzo(int i, float f2) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f2));
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzq(int i, Object obj, zzif zzifVar) throws IOException {
        zzfz zzfzVar = this.zza;
        zzfzVar.zzr(i, 3);
        zzifVar.zzi((zzhu) obj, zzfzVar.zza);
        zzfzVar.zzr(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzv(int i, Object obj, zzif zzifVar) throws IOException {
        this.zza.zzm(i, (zzhu) obj, zzifVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzfs) {
            this.zza.zzo(i, (zzfs) obj);
        } else {
            this.zza.zzn(i, (zzhu) obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhg)) {
            while (i2 < list.size()) {
                this.zza.zzp(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzhg zzhgVar = (zzhg) list;
        while (i2 < list.size()) {
            Object objZzc = zzhgVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzp(i, (String) objZzc);
            } else {
                this.zza.zze(i, (zzfs) objZzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgt)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzs(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzz += zzfz.zzz(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzt(iZzz);
            while (i2 < list.size()) {
                this.zza.zzt(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgt zzgtVar = (zzgt) list;
        if (!z) {
            while (i2 < zzgtVar.size()) {
                this.zza.zzs(i, zzgtVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzgtVar.size(); i4++) {
            iZzz2 += zzfz.zzz(zzgtVar.zze(i4));
        }
        this.zza.zzt(iZzz2);
        while (i2 < zzgtVar.size()) {
            this.zza.zzt(zzgtVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzA += zzfz.zzA(((Long) list.get(i3)).longValue());
            }
            this.zza.zzt(iZzA);
            while (i2 < list.size()) {
                this.zza.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                this.zza.zzu(i, zzhjVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzhjVar.size(); i4++) {
            iZzA2 += zzfz.zzA(zzhjVar.zze(i4));
        }
        this.zza.zzt(iZzA2);
        while (i2 < zzhjVar.size()) {
            this.zza.zzv(zzhjVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgt)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzt(i3);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgt zzgtVar = (zzgt) list;
        if (!z) {
            while (i2 < zzgtVar.size()) {
                this.zza.zzf(i, zzgtVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgtVar.size(); i6++) {
            zzgtVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzt(i5);
        while (i2 < zzgtVar.size()) {
            this.zza.zzg(zzgtVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzt(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                this.zza.zzh(i, zzhjVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhjVar.size(); i6++) {
            zzhjVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzt(i5);
        while (i2 < zzhjVar.size()) {
            this.zza.zzi(zzhjVar.zze(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzfj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            this.zza.zzt(i3);
            while (i2 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzfj zzfjVar = (zzfj) list;
        if (!z) {
            while (i2 < zzfjVar.size()) {
                this.zza.zzd(i, zzfjVar.zzf(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzfjVar.size(); i6++) {
            zzfjVar.zzf(i6);
            i5++;
        }
        this.zza.zzt(i5);
        while (i2 < zzfjVar.size()) {
            this.zza.zzb(zzfjVar.zzf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgt)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzA += zzfz.zzA(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgt zzgtVar = (zzgt) list;
        if (!z) {
            while (i2 < zzgtVar.size()) {
                this.zza.zzj(i, zzgtVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzgtVar.size(); i4++) {
            iZzA2 += zzfz.zzA(zzgtVar.zze(i4));
        }
        this.zza.zzt(iZzA2);
        while (i2 < zzgtVar.size()) {
            this.zza.zzk(zzgtVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zza.zzt(i3);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                this.zza.zzh(i, zzhjVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzhjVar.size(); i6++) {
            zzhjVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzt(i5);
        while (i2 < zzhjVar.size()) {
            this.zza.zzi(zzhjVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgb)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            this.zza.zzt(i3);
            while (i2 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzgb zzgbVar = (zzgb) list;
        if (!z) {
            while (i2 < zzgbVar.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(zzgbVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgbVar.size(); i6++) {
            zzgbVar.zze(i6);
            i5 += 8;
        }
        this.zza.zzt(i5);
        while (i2 < zzgbVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzgbVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgl)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.zza.zzt(i3);
            while (i2 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzgl zzglVar = (zzgl) list;
        if (!z) {
            while (i2 < zzglVar.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(zzglVar.zze(i2)));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzglVar.size(); i6++) {
            zzglVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzt(i5);
        while (i2 < zzglVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzglVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgt)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zza.zzt(i3);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgt zzgtVar = (zzgt) list;
        if (!z) {
            while (i2 < zzgtVar.size()) {
                this.zza.zzf(i, zzgtVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzgtVar.size(); i6++) {
            zzgtVar.zze(i6);
            i5 += 4;
        }
        this.zza.zzt(i5);
        while (i2 < zzgtVar.size()) {
            this.zza.zzg(zzgtVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgt)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzfz zzfzVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzfzVar.zzs(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzz += zzfz.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzt(iZzz);
            while (i2 < list.size()) {
                zzfz zzfzVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzfzVar2.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzgt zzgtVar = (zzgt) list;
        if (!z) {
            while (i2 < zzgtVar.size()) {
                zzfz zzfzVar3 = this.zza;
                int iZze = zzgtVar.zze(i2);
                zzfzVar3.zzs(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzgtVar.size(); i4++) {
            int iZze2 = zzgtVar.zze(i4);
            iZzz2 += zzfz.zzz((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzt(iZzz2);
        while (i2 < zzgtVar.size()) {
            zzfz zzfzVar4 = this.zza;
            int iZze3 = zzgtVar.zze(i2);
            zzfzVar4.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzfz zzfzVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzfzVar.zzu(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZzA += zzfz.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzt(iZzA);
            while (i2 < list.size()) {
                zzfz zzfzVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzfzVar2.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                zzfz zzfzVar3 = this.zza;
                long jZze = zzhjVar.zze(i2);
                zzfzVar3.zzu(i, (jZze >> 63) ^ (jZze + jZze));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzhjVar.size(); i4++) {
            long jZze2 = zzhjVar.zze(i4);
            iZzA2 += zzfz.zzA((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzt(iZzA2);
        while (i2 < zzhjVar.size()) {
            zzfz zzfzVar4 = this.zza;
            long jZze3 = zzhjVar.zze(i2);
            zzfzVar4.zzv((jZze3 >> 63) ^ (jZze3 + jZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzgt)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzA += zzfz.zzA(((Integer) list.get(i3)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzgt zzgtVar = (zzgt) list;
        if (!z) {
            while (i2 < zzgtVar.size()) {
                this.zza.zzj(i, zzgtVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzgtVar.size(); i4++) {
            iZzA2 += zzfz.zzA(zzgtVar.zze(i4));
        }
        this.zza.zzt(iZzA2);
        while (i2 < zzgtVar.size()) {
            this.zza.zzk(zzgtVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzje
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhj)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zza.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzA += zzfz.zzA(((Long) list.get(i3)).longValue());
            }
            this.zza.zzt(iZzA);
            while (i2 < list.size()) {
                this.zza.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzhj zzhjVar = (zzhj) list;
        if (!z) {
            while (i2 < zzhjVar.size()) {
                this.zza.zzu(i, zzhjVar.zze(i2));
                i2++;
            }
            return;
        }
        this.zza.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzhjVar.size(); i4++) {
            iZzA2 += zzfz.zzA(zzhjVar.zze(i4));
        }
        this.zza.zzt(iZzA2);
        while (i2 < zzhjVar.size()) {
            this.zza.zzv(zzhjVar.zze(i2));
            i2++;
        }
    }
}
