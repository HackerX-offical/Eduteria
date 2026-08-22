package com.google.android.gms.internal.vision;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzho extends zzhm {
    private final boolean zza;
    private final byte[] zzb;
    private int zzc;
    private final int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public zzho(ByteBuffer byteBuffer, boolean z) {
        super(null);
        this.zza = true;
        this.zzb = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.zzc = iArrayOffset;
        this.zzd = iArrayOffset;
        this.zze = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final boolean zzu() {
        return this.zzc == this.zze;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zza() throws IOException {
        if (zzu()) {
            return Integer.MAX_VALUE;
        }
        int iZzv = zzv();
        this.zzf = iZzv;
        if (iZzv == this.zzg) {
            return Integer.MAX_VALUE;
        }
        return iZzv >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzb() {
        return this.zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0076  */
    @Override // com.google.android.gms.internal.vision.zzld
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzu()
            r1 = 0
            if (r0 != 0) goto L85
            int r0 = r7.zzf
            int r2 = r7.zzg
            if (r0 != r2) goto Lf
            goto L85
        Lf:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L59
            if (r3 == r4) goto L53
            r1 = 2
            if (r3 == r1) goto L4b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L29
            r0 = 5
            if (r3 != r0) goto L24
            r7.zza(r1)
            return r4
        L24:
            com.google.android.gms.internal.vision.zzjn r0 = com.google.android.gms.internal.vision.zzjk.zzf()
            throw r0
        L29:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.zzg = r0
        L2e:
            int r0 = r7.zza()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L3d
            boolean r0 = r7.zzc()
            if (r0 != 0) goto L2e
        L3d:
            int r0 = r7.zzf
            int r1 = r7.zzg
            if (r0 != r1) goto L46
            r7.zzg = r2
            return r4
        L46:
            com.google.android.gms.internal.vision.zzjk r0 = com.google.android.gms.internal.vision.zzjk.zzg()
            throw r0
        L4b:
            int r0 = r7.zzv()
            r7.zza(r0)
            return r4
        L53:
            r0 = 8
            r7.zza(r0)
            return r4
        L59:
            int r0 = r7.zze
            int r2 = r7.zzc
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L74
            byte[] r0 = r7.zzb
            r5 = r1
        L65:
            if (r5 >= r3) goto L74
            int r6 = r2 + 1
            r2 = r0[r2]
            if (r2 < 0) goto L70
            r7.zzc = r6
            goto L7f
        L70:
            int r5 = r5 + 1
            r2 = r6
            goto L65
        L74:
            if (r1 >= r3) goto L80
            byte r0 = r7.zzy()
            if (r0 >= 0) goto L7f
            int r1 = r1 + 1
            goto L74
        L7f:
            return r4
        L80:
            com.google.android.gms.internal.vision.zzjk r0 = com.google.android.gms.internal.vision.zzjk.zzc()
            throw r0
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzho.zzc():boolean");
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final double zzd() throws IOException {
        zzc(1);
        return Double.longBitsToDouble(zzaa());
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final float zze() throws IOException {
        zzc(5);
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzf() throws IOException {
        zzc(0);
        return zzw();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzg() throws IOException {
        zzc(0);
        return zzw();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzh() throws IOException {
        zzc(0);
        return zzv();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzi() throws IOException {
        zzc(1);
        return zzaa();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzj() throws IOException {
        zzc(5);
        return zzz();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final boolean zzk() throws IOException {
        zzc(0);
        return zzv() != 0;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final String zzl() throws IOException {
        return zza(false);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final String zzm() throws IOException {
        return zza(true);
    }

    private final String zza(boolean z) throws IOException {
        zzc(2);
        int iZzv = zzv();
        if (iZzv == 0) {
            return "";
        }
        zzb(iZzv);
        if (z) {
            byte[] bArr = this.zzb;
            int i = this.zzc;
            if (!zzmd.zza(bArr, i, i + iZzv)) {
                throw zzjk.zzh();
            }
        }
        String str = new String(this.zzb, this.zzc, iZzv, zzjf.zza);
        this.zzc += iZzv;
        return str;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zza(Class<T> cls, zzio zzioVar) throws IOException {
        zzc(2);
        return (T) zzc(zzky.zza().zza((Class) cls), zzioVar);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zza(zzlc<T> zzlcVar, zzio zzioVar) throws IOException {
        zzc(2);
        return (T) zzc(zzlcVar, zzioVar);
    }

    private final <T> T zzc(zzlc<T> zzlcVar, zzio zzioVar) throws IOException {
        int iZzv = zzv();
        zzb(iZzv);
        int i = this.zze;
        int i2 = this.zzc + iZzv;
        this.zze = i2;
        try {
            T tZza = zzlcVar.zza();
            zzlcVar.zza(tZza, this, zzioVar);
            zzlcVar.zzc(tZza);
            if (this.zzc == i2) {
                return tZza;
            }
            throw zzjk.zzg();
        } finally {
            this.zze = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zzb(Class<T> cls, zzio zzioVar) throws IOException {
        zzc(3);
        return (T) zzd(zzky.zza().zza((Class) cls), zzioVar);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zzb(zzlc<T> zzlcVar, zzio zzioVar) throws IOException {
        zzc(3);
        return (T) zzd(zzlcVar, zzioVar);
    }

    private final <T> T zzd(zzlc<T> zzlcVar, zzio zzioVar) throws IOException {
        int i = this.zzg;
        this.zzg = ((this.zzf >>> 3) << 3) | 4;
        try {
            T tZza = zzlcVar.zza();
            zzlcVar.zza(tZza, this, zzioVar);
            zzlcVar.zzc(tZza);
            if (this.zzf == this.zzg) {
                return tZza;
            }
            throw zzjk.zzg();
        } finally {
            this.zzg = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final zzht zzn() throws IOException {
        zzht zzhtVarZza;
        zzc(2);
        int iZzv = zzv();
        if (iZzv == 0) {
            return zzht.zza;
        }
        zzb(iZzv);
        if (this.zza) {
            zzhtVarZza = zzht.zzb(this.zzb, this.zzc, iZzv);
        } else {
            zzhtVarZza = zzht.zza(this.zzb, this.zzc, iZzv);
        }
        this.zzc += iZzv;
        return zzhtVarZza;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzo() throws IOException {
        zzc(0);
        return zzv();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzp() throws IOException {
        zzc(0);
        return zzv();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzq() throws IOException {
        zzc(5);
        return zzz();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzr() throws IOException {
        zzc(1);
        return zzaa();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzs() throws IOException {
        zzc(0);
        return zzif.zze(zzv());
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzt() throws IOException {
        zzc(0);
        return zzif.zza(zzw());
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zza(List<Double> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzin) {
            zzin zzinVar = (zzin) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzinVar.zza(zzd());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            if (i3 == 2) {
                int iZzv = zzv();
                zzd(iZzv);
                int i4 = this.zzc + iZzv;
                while (this.zzc < i4) {
                    zzinVar.zza(Double.longBitsToDouble(zzac()));
                }
                return;
            }
            throw zzjk.zzf();
        }
        int i5 = this.zzf & 7;
        if (i5 == 1) {
            do {
                list.add(Double.valueOf(zzd()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        if (i5 == 2) {
            int iZzv2 = zzv();
            zzd(iZzv2);
            int i6 = this.zzc + iZzv2;
            while (this.zzc < i6) {
                list.add(Double.valueOf(Double.longBitsToDouble(zzac())));
            }
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzb(List<Float> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzja) {
            zzja zzjaVar = (zzja) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int iZzv = zzv();
                zze(iZzv);
                int i4 = this.zzc + iZzv;
                while (this.zzc < i4) {
                    zzjaVar.zza(Float.intBitsToFloat(zzab()));
                }
                return;
            }
            if (i3 == 5) {
                do {
                    zzjaVar.zza(zze());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            throw zzjk.zzf();
        }
        int i5 = this.zzf & 7;
        if (i5 == 2) {
            int iZzv2 = zzv();
            zze(iZzv2);
            int i6 = this.zzc + iZzv2;
            while (this.zzc < i6) {
                list.add(Float.valueOf(Float.intBitsToFloat(zzab())));
            }
            return;
        }
        if (i5 == 5) {
            do {
                list.add(Float.valueOf(zze()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzc(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjyVar = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjyVar.zza(zzf());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            if (i3 == 2) {
                int iZzv = this.zzc + zzv();
                while (this.zzc < iZzv) {
                    zzjyVar.zza(zzw());
                }
                zzf(iZzv);
                return;
            }
            throw zzjk.zzf();
        }
        int i4 = this.zzf & 7;
        if (i4 == 0) {
            do {
                list.add(Long.valueOf(zzf()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        if (i4 == 2) {
            int iZzv2 = this.zzc + zzv();
            while (this.zzc < iZzv2) {
                list.add(Long.valueOf(zzw()));
            }
            zzf(iZzv2);
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzd(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjyVar = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjyVar.zza(zzg());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            if (i3 == 2) {
                int iZzv = this.zzc + zzv();
                while (this.zzc < iZzv) {
                    zzjyVar.zza(zzw());
                }
                zzf(iZzv);
                return;
            }
            throw zzjk.zzf();
        }
        int i4 = this.zzf & 7;
        if (i4 == 0) {
            do {
                list.add(Long.valueOf(zzg()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        if (i4 == 2) {
            int iZzv2 = this.zzc + zzv();
            while (this.zzc < iZzv2) {
                list.add(Long.valueOf(zzw()));
            }
            zzf(iZzv2);
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zze(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjdVar.zzc(zzh());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            if (i3 == 2) {
                int iZzv = this.zzc + zzv();
                while (this.zzc < iZzv) {
                    zzjdVar.zzc(zzv());
                }
                zzf(iZzv);
                return;
            }
            throw zzjk.zzf();
        }
        int i4 = this.zzf & 7;
        if (i4 == 0) {
            do {
                list.add(Integer.valueOf(zzh()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        if (i4 == 2) {
            int iZzv2 = this.zzc + zzv();
            while (this.zzc < iZzv2) {
                list.add(Integer.valueOf(zzv()));
            }
            zzf(iZzv2);
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzf(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjyVar = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzjyVar.zza(zzi());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            if (i3 == 2) {
                int iZzv = zzv();
                zzd(iZzv);
                int i4 = this.zzc + iZzv;
                while (this.zzc < i4) {
                    zzjyVar.zza(zzac());
                }
                return;
            }
            throw zzjk.zzf();
        }
        int i5 = this.zzf & 7;
        if (i5 == 1) {
            do {
                list.add(Long.valueOf(zzi()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        if (i5 == 2) {
            int iZzv2 = zzv();
            zzd(iZzv2);
            int i6 = this.zzc + iZzv2;
            while (this.zzc < i6) {
                list.add(Long.valueOf(zzac()));
            }
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzg(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int iZzv = zzv();
                zze(iZzv);
                int i4 = this.zzc + iZzv;
                while (this.zzc < i4) {
                    zzjdVar.zzc(zzab());
                }
                return;
            }
            if (i3 == 5) {
                do {
                    zzjdVar.zzc(zzj());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            throw zzjk.zzf();
        }
        int i5 = this.zzf & 7;
        if (i5 == 2) {
            int iZzv2 = zzv();
            zze(iZzv2);
            int i6 = this.zzc + iZzv2;
            while (this.zzc < i6) {
                list.add(Integer.valueOf(zzab()));
            }
            return;
        }
        if (i5 == 5) {
            do {
                list.add(Integer.valueOf(zzj()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzh(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhr) {
            zzhr zzhrVar = (zzhr) list;
            int i3 = this.zzf & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzv = this.zzc + zzv();
                    while (this.zzc < iZzv) {
                        zzhrVar.zza(zzv() != 0);
                    }
                    zzf(iZzv);
                    return;
                }
                throw zzjk.zzf();
            }
            do {
                zzhrVar.zza(zzk());
                if (zzu()) {
                    return;
                } else {
                    i2 = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i2;
            return;
        }
        int i4 = this.zzf & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzv2 = this.zzc + zzv();
                while (this.zzc < iZzv2) {
                    list.add(Boolean.valueOf(zzv() != 0));
                }
                zzf(iZzv2);
                return;
            }
            throw zzjk.zzf();
        }
        do {
            list.add(Boolean.valueOf(zzk()));
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == this.zzf);
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzi(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzj(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.zzf & 7) != 2) {
            throw zzjk.zzf();
        }
        if ((list instanceof zzjv) && !z) {
            zzjv zzjvVar = (zzjv) list;
            do {
                zzjvVar.zza(zzn());
                if (zzu()) {
                    return;
                } else {
                    i2 = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i2;
            return;
        }
        do {
            list.add(zza(z));
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == this.zzf);
        this.zzc = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> void zza(List<T> list, zzlc<T> zzlcVar, zzio zzioVar) throws IOException {
        int i;
        int i2 = this.zzf;
        if ((i2 & 7) != 2) {
            throw zzjk.zzf();
        }
        do {
            list.add(zzc(zzlcVar, zzioVar));
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == i2);
        this.zzc = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> void zzb(List<T> list, zzlc<T> zzlcVar, zzio zzioVar) throws IOException {
        int i;
        int i2 = this.zzf;
        if ((i2 & 7) != 3) {
            throw zzjk.zzf();
        }
        do {
            list.add(zzd(zzlcVar, zzioVar));
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == i2);
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzk(List<zzht> list) throws IOException {
        int i;
        if ((this.zzf & 7) != 2) {
            throw zzjk.zzf();
        }
        do {
            list.add(zzn());
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == this.zzf);
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzl(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzv = this.zzc + zzv();
                    while (this.zzc < iZzv) {
                        zzjdVar.zzc(zzv());
                    }
                    return;
                }
                throw zzjk.zzf();
            }
            do {
                zzjdVar.zzc(zzo());
                if (zzu()) {
                    return;
                } else {
                    i2 = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i2;
            return;
        }
        int i4 = this.zzf & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzv2 = this.zzc + zzv();
                while (this.zzc < iZzv2) {
                    list.add(Integer.valueOf(zzv()));
                }
                return;
            }
            throw zzjk.zzf();
        }
        do {
            list.add(Integer.valueOf(zzo()));
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == this.zzf);
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzm(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzv = this.zzc + zzv();
                    while (this.zzc < iZzv) {
                        zzjdVar.zzc(zzv());
                    }
                    return;
                }
                throw zzjk.zzf();
            }
            do {
                zzjdVar.zzc(zzp());
                if (zzu()) {
                    return;
                } else {
                    i2 = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i2;
            return;
        }
        int i4 = this.zzf & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzv2 = this.zzc + zzv();
                while (this.zzc < iZzv2) {
                    list.add(Integer.valueOf(zzv()));
                }
                return;
            }
            throw zzjk.zzf();
        }
        do {
            list.add(Integer.valueOf(zzp()));
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == this.zzf);
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzn(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int iZzv = zzv();
                zze(iZzv);
                int i4 = this.zzc + iZzv;
                while (this.zzc < i4) {
                    zzjdVar.zzc(zzab());
                }
                return;
            }
            if (i3 == 5) {
                do {
                    zzjdVar.zzc(zzq());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            throw zzjk.zzf();
        }
        int i5 = this.zzf & 7;
        if (i5 == 2) {
            int iZzv2 = zzv();
            zze(iZzv2);
            int i6 = this.zzc + iZzv2;
            while (this.zzc < i6) {
                list.add(Integer.valueOf(zzab()));
            }
            return;
        }
        if (i5 == 5) {
            do {
                list.add(Integer.valueOf(zzq()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzo(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjyVar = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzjyVar.zza(zzr());
                    if (zzu()) {
                        return;
                    } else {
                        i2 = this.zzc;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
                return;
            }
            if (i3 == 2) {
                int iZzv = zzv();
                zzd(iZzv);
                int i4 = this.zzc + iZzv;
                while (this.zzc < i4) {
                    zzjyVar.zza(zzac());
                }
                return;
            }
            throw zzjk.zzf();
        }
        int i5 = this.zzf & 7;
        if (i5 == 1) {
            do {
                list.add(Long.valueOf(zzr()));
                if (zzu()) {
                    return;
                } else {
                    i = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        if (i5 == 2) {
            int iZzv2 = zzv();
            zzd(iZzv2);
            int i6 = this.zzc + iZzv2;
            while (this.zzc < i6) {
                list.add(Long.valueOf(zzac()));
            }
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzp(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjdVar = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzv = this.zzc + zzv();
                    while (this.zzc < iZzv) {
                        zzjdVar.zzc(zzif.zze(zzv()));
                    }
                    return;
                }
                throw zzjk.zzf();
            }
            do {
                zzjdVar.zzc(zzs());
                if (zzu()) {
                    return;
                } else {
                    i2 = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i2;
            return;
        }
        int i4 = this.zzf & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzv2 = this.zzc + zzv();
                while (this.zzc < iZzv2) {
                    list.add(Integer.valueOf(zzif.zze(zzv())));
                }
                return;
            }
            throw zzjk.zzf();
        }
        do {
            list.add(Integer.valueOf(zzs()));
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == this.zzf);
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzq(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjyVar = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iZzv = this.zzc + zzv();
                    while (this.zzc < iZzv) {
                        zzjyVar.zza(zzif.zza(zzw()));
                    }
                    return;
                }
                throw zzjk.zzf();
            }
            do {
                zzjyVar.zza(zzt());
                if (zzu()) {
                    return;
                } else {
                    i2 = this.zzc;
                }
            } while (zzv() == this.zzf);
            this.zzc = i2;
            return;
        }
        int i4 = this.zzf & 7;
        if (i4 != 0) {
            if (i4 == 2) {
                int iZzv2 = this.zzc + zzv();
                while (this.zzc < iZzv2) {
                    list.add(Long.valueOf(zzif.zza(zzw())));
                }
                return;
            }
            throw zzjk.zzf();
        }
        do {
            list.add(Long.valueOf(zzt()));
            if (zzu()) {
                return;
            } else {
                i = this.zzc;
            }
        } while (zzv() == this.zzf);
        this.zzc = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <K, V> void zza(Map<K, V> map, zzkf<K, V> zzkfVar, zzio zzioVar) throws IOException {
        zzc(2);
        int iZzv = zzv();
        zzb(iZzv);
        int i = this.zze;
        this.zze = this.zzc + iZzv;
        try {
            Object objZza = zzkfVar.zzb;
            Object objZza2 = zzkfVar.zzd;
            while (true) {
                int iZza = zza();
                if (iZza == Integer.MAX_VALUE) {
                    map.put(objZza, objZza2);
                    return;
                }
                if (iZza == 1) {
                    objZza = zza(zzkfVar.zza, (Class<?>) null, (zzio) null);
                } else if (iZza == 2) {
                    objZza2 = zza(zzkfVar.zzc, zzkfVar.zzd.getClass(), zzioVar);
                } else {
                    try {
                        if (!zzc()) {
                            throw new zzjk("Unable to parse map entry.");
                        }
                    } catch (zzjn unused) {
                        if (!zzc()) {
                            throw new zzjk("Unable to parse map entry.");
                        }
                    }
                }
            }
        } finally {
            this.zze = i;
        }
    }

    private final Object zza(zzml zzmlVar, Class<?> cls, zzio zzioVar) throws IOException {
        switch (zzhp.zza[zzmlVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                return zza(cls, zzioVar);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zza(true);
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzv() throws IOException {
        int i;
        int i2 = this.zzc;
        int i3 = this.zze;
        if (i3 == i2) {
            throw zzjk.zza();
        }
        byte[] bArr = this.zzb;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            this.zzc = i4;
            return b2;
        }
        if (i3 - i4 < 9) {
            return (int) zzx();
        }
        int i5 = i2 + 2;
        int i6 = (bArr[i4] << 7) ^ b2;
        if (i6 < 0) {
            i = i6 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        } else {
            int i7 = i2 + 3;
            int i8 = (bArr[i5] << 14) ^ i6;
            if (i8 >= 0) {
                i = i8 ^ 16256;
            } else {
                int i9 = i2 + 4;
                int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                if (i10 < 0) {
                    i = (-2080896) ^ i10;
                } else {
                    i7 = i2 + 5;
                    byte b3 = bArr[i9];
                    int i11 = (i10 ^ (b3 << Ascii.FS)) ^ 266354560;
                    if (b3 < 0) {
                        i9 = i2 + 6;
                        if (bArr[i7] < 0) {
                            i7 = i2 + 7;
                            if (bArr[i9] < 0) {
                                i9 = i2 + 8;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 9;
                                    if (bArr[i9] < 0) {
                                        int i12 = i2 + 10;
                                        if (bArr[i7] < 0) {
                                            throw zzjk.zzc();
                                        }
                                        i5 = i12;
                                        i = i11;
                                    }
                                }
                            }
                        }
                        i = i11;
                    }
                    i = i11;
                }
                i5 = i9;
            }
            i5 = i7;
        }
        this.zzc = i5;
        return i;
    }

    private final long zzw() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzc;
        int i2 = this.zze;
        if (i2 == i) {
            throw zzjk.zza();
        }
        byte[] bArr = this.zzb;
        int i3 = i + 1;
        byte b2 = bArr[i];
        if (b2 >= 0) {
            this.zzc = i3;
            return b2;
        }
        if (i2 - i3 < 9) {
            return zzx();
        }
        int i4 = i + 2;
        int i5 = (bArr[i3] << 7) ^ b2;
        if (i5 < 0) {
            j = i5 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        } else {
            int i6 = i + 3;
            int i7 = (bArr[i4] << 14) ^ i5;
            if (i7 >= 0) {
                j = i7 ^ 16256;
                i4 = i6;
            } else {
                int i8 = i + 4;
                int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                if (i9 < 0) {
                    long j4 = (-2080896) ^ i9;
                    i4 = i8;
                    j = j4;
                } else {
                    long j5 = i9;
                    i4 = i + 5;
                    long j6 = j5 ^ (((long) bArr[i8]) << 28);
                    if (j6 >= 0) {
                        j3 = 266354560;
                    } else {
                        int i10 = i + 6;
                        long j7 = j6 ^ (((long) bArr[i4]) << 35);
                        if (j7 < 0) {
                            j2 = -34093383808L;
                        } else {
                            i4 = i + 7;
                            j6 = j7 ^ (((long) bArr[i10]) << 42);
                            if (j6 >= 0) {
                                j3 = 4363953127296L;
                            } else {
                                i10 = i + 8;
                                j7 = j6 ^ (((long) bArr[i4]) << 49);
                                if (j7 < 0) {
                                    j2 = -558586000294016L;
                                } else {
                                    i4 = i + 9;
                                    long j8 = (j7 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                    if (j8 < 0) {
                                        int i11 = i + 10;
                                        if (bArr[i4] < 0) {
                                            throw zzjk.zzc();
                                        }
                                        i4 = i11;
                                    }
                                    j = j8;
                                }
                            }
                        }
                        j = j7 ^ j2;
                        i4 = i10;
                    }
                    j = j6 ^ j3;
                }
            }
        }
        this.zzc = i4;
        return j;
    }

    private final long zzx() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzy = zzy();
            j |= ((long) (bZzy & 127)) << i;
            if ((bZzy & 128) == 0) {
                return j;
            }
        }
        throw zzjk.zzc();
    }

    private final byte zzy() throws IOException {
        int i = this.zzc;
        if (i == this.zze) {
            throw zzjk.zza();
        }
        byte[] bArr = this.zzb;
        this.zzc = i + 1;
        return bArr[i];
    }

    private final int zzz() throws IOException {
        zzb(4);
        return zzab();
    }

    private final long zzaa() throws IOException {
        zzb(8);
        return zzac();
    }

    private final int zzab() {
        int i = this.zzc;
        byte[] bArr = this.zzb;
        this.zzc = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzac() {
        int i = this.zzc;
        byte[] bArr = this.zzb;
        this.zzc = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zza(int i) throws IOException {
        zzb(i);
        this.zzc += i;
    }

    private final void zzb(int i) throws IOException {
        if (i < 0 || i > this.zze - this.zzc) {
            throw zzjk.zza();
        }
    }

    private final void zzc(int i) throws IOException {
        if ((this.zzf & 7) != i) {
            throw zzjk.zzf();
        }
    }

    private final void zzd(int i) throws IOException {
        zzb(i);
        if ((i & 7) != 0) {
            throw zzjk.zzg();
        }
    }

    private final void zze(int i) throws IOException {
        zzb(i);
        if ((i & 3) != 0) {
            throw zzjk.zzg();
        }
    }

    private final void zzf(int i) throws IOException {
        if (this.zzc != i) {
            throw zzjk.zza();
        }
    }
}
