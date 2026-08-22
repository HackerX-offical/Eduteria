package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjt<T> implements zzkf<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzld.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjp zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzju zzo;
    private final zziz zzp;
    private final zzkx<?, ?> zzq;
    private final zzht<?> zzr;
    private final zzji zzs;

    private zzjt(int[] iArr, Object[] objArr, int i, int i2, zzjp zzjpVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzju zzjuVar, zziz zzizVar, zzkx<?, ?> zzkxVar, zzht<?> zzhtVar, zzji zzjiVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjpVar instanceof zzie;
        this.zzj = z;
        this.zzh = zzhtVar != null && zzhtVar.zza(zzjpVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjuVar;
        this.zzp = zzizVar;
        this.zzq = zzkxVar;
        this.zzr = zzhtVar;
        this.zzg = zzjpVar;
        this.zzs = zzjiVar;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.android.gms.internal.firebase_auth.zzjt<T> zza(java.lang.Class<T> r34, com.google.android.gms.internal.firebase_auth.zzjn r35, com.google.android.gms.internal.firebase_auth.zzju r36, com.google.android.gms.internal.firebase_auth.zziz r37, com.google.android.gms.internal.firebase_auth.zzkx<?, ?> r38, com.google.android.gms.internal.firebase_auth.zzht<?> r39, com.google.android.gms.internal.firebase_auth.zzji r40) {
        /*
            Method dump skipped, instruction units count: 1095
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjt.zza(java.lang.Class, com.google.android.gms.internal.firebase_auth.zzjn, com.google.android.gms.internal.firebase_auth.zzju, com.google.android.gms.internal.firebase_auth.zziz, com.google.android.gms.internal.firebase_auth.zzkx, com.google.android.gms.internal.firebase_auth.zzht, com.google.android.gms.internal.firebase_auth.zzji):com.google.android.gms.internal.firebase_auth.zzjt");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            throw new RuntimeException(new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length()).append("Field ").append(str).append(" for ").append(name).append(" not found. Known fields are ").append(string).toString());
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(T r10, T r11) {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjt.zza(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final int zza(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzd = zzd(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzd;
            int iHashCode = 37;
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzig.zza(Double.doubleToLongBits(zzld.zze(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzld.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzig.zza(zzld.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzig.zza(zzld.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzld.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzig.zza(zzld.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzld.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzig.zza(zzld.zzc(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzld.zzf(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZzf = zzld.zzf(t, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzld.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzld.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzld.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzld.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzig.zza(zzld.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzld.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzig.zza(zzld.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZzf2 = zzld.zzf(t, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZza = zzld.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzld.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzig.zza(Double.doubleToLongBits(zzb(t, j)));
                        i2 = i + iZza;
                    }
                    break;
                case 52:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzc(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 53:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzig.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 54:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzig.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 55:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 56:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzig.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 57:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 58:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzig.zza(zzf(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 59:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzld.zzf(t, j)).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 60:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzld.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 61:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzld.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 62:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 63:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 64:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 65:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzig.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 66:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 67:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzig.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 68:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzld.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzq.zzb(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzr.zza(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final void zzb(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzd = zzd(i);
            long j = 1048575 & iZzd;
            int i2 = this.zzc[i];
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    if (zza((Object) t2, i)) {
                        zzld.zza(t, j, zzld.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 1:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 2:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 3:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 4:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 5:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 6:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 7:
                    if (zza((Object) t2, i)) {
                        zzld.zza(t, j, zzld.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 8:
                    if (zza((Object) t2, i)) {
                        zzld.zza(t, j, zzld.zzf(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((Object) t2, i)) {
                        zzld.zza(t, j, zzld.zzf(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 11:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 12:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 13:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 14:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 15:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 16:
                    if (zza((Object) t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzkh.zza(this.zzs, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzld.zza(t, j, zzld.zzf(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza(t2, i2, i)) {
                        zzld.zza(t, j, zzld.zzf(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzkh.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzkh.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzd = zzd(i) & 1048575;
        if (zza((Object) t2, i)) {
            Object objZzf = zzld.zzf(t, jZzd);
            Object objZzf2 = zzld.zzf(t2, jZzd);
            if (objZzf != null && objZzf2 != null) {
                zzld.zza(t, jZzd, zzig.zza(objZzf, objZzf2));
                zzb((Object) t, i);
            } else if (objZzf2 != null) {
                zzld.zza(t, jZzd, objZzf2);
                zzb((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int iZzd = zzd(i);
        int i2 = this.zzc[i];
        long j = iZzd & 1048575;
        if (zza(t2, i2, i)) {
            Object objZzf = zzld.zzf(t, j);
            Object objZzf2 = zzld.zzf(t2, j);
            if (objZzf != null && objZzf2 != null) {
                zzld.zza(t, j, zzig.zza(objZzf, objZzf2));
                zzb(t, i2, i);
            } else if (objZzf2 != null) {
                zzld.zza(t, j, objZzf2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final int zzd(T t) {
        int i;
        int i2;
        int i3;
        boolean z;
        int iZzd;
        int iZzb;
        int iZzj;
        int i4;
        int iZzh;
        int iZzi;
        int iZze;
        int iZzg;
        int iZzb2;
        int iZzi2;
        int iZze2;
        int iZzg2;
        int i5 = 267386880;
        int i6 = 1048575;
        int i7 = 0;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i8 = 0;
            int i9 = 0;
            while (i8 < this.zzc.length) {
                int iZzd2 = zzd(i8);
                int i10 = (iZzd2 & i5) >>> 20;
                int i11 = i5;
                int i12 = this.zzc[i8];
                long j = iZzd2 & 1048575;
                int i13 = (i10 < zzhy.DOUBLE_LIST_PACKED.zza() || i10 > zzhy.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i8 + 2] & 1048575;
                switch (i10) {
                    case 0:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzb(i12, 0.0d);
                            i9 += iZzb2;
                        }
                        break;
                    case 1:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzb(i12, 0.0f);
                            i9 += iZzb2;
                        }
                        break;
                    case 2:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzd(i12, zzld.zzb(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 3:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zze(i12, zzld.zzb(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 4:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzf(i12, zzld.zza(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 5:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzg(i12, 0L);
                            i9 += iZzb2;
                        }
                        break;
                    case 6:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzi(i12, 0);
                            i9 += iZzb2;
                        }
                        break;
                    case 7:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzb(i12, true);
                            i9 += iZzb2;
                        }
                        break;
                    case 8:
                        if (zza((Object) t, i8)) {
                            Object objZzf = zzld.zzf(t, j);
                            if (objZzf instanceof zzgt) {
                                iZzb2 = zzho.zzc(i12, (zzgt) objZzf);
                            } else {
                                iZzb2 = zzho.zzb(i12, (String) objZzf);
                            }
                            i9 += iZzb2;
                        }
                        break;
                    case 9:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzkh.zza(i12, zzld.zzf(t, j), zza(i8));
                            i9 += iZzb2;
                        }
                        break;
                    case 10:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzc(i12, (zzgt) zzld.zzf(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 11:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzg(i12, zzld.zza(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 12:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzk(i12, zzld.zza(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 13:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzj(i12, 0);
                            i9 += iZzb2;
                        }
                        break;
                    case 14:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzh(i12, 0L);
                            i9 += iZzb2;
                        }
                        break;
                    case 15:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzh(i12, zzld.zza(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 16:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzf(i12, zzld.zzb(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 17:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzho.zzc(i12, (zzjp) zzld.zzf(t, j), zza(i8));
                            i9 += iZzb2;
                        }
                        break;
                    case 18:
                        iZzb2 = zzkh.zzi(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 19:
                        iZzb2 = zzkh.zzh(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 20:
                        iZzb2 = zzkh.zza(i12, (List<Long>) zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 21:
                        iZzb2 = zzkh.zzb(i12, (List<Long>) zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 22:
                        iZzb2 = zzkh.zze(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 23:
                        iZzb2 = zzkh.zzi(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 24:
                        iZzb2 = zzkh.zzh(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 25:
                        iZzb2 = zzkh.zzj(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 26:
                        iZzb2 = zzkh.zza(i12, zza(t, j));
                        i9 += iZzb2;
                        break;
                    case 27:
                        iZzb2 = zzkh.zza(i12, zza(t, j), zza(i8));
                        i9 += iZzb2;
                        break;
                    case 28:
                        iZzb2 = zzkh.zzb(i12, zza(t, j));
                        i9 += iZzb2;
                        break;
                    case 29:
                        iZzb2 = zzkh.zzf(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 30:
                        iZzb2 = zzkh.zzd(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 31:
                        iZzb2 = zzkh.zzh(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 32:
                        iZzb2 = zzkh.zzi(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 33:
                        iZzb2 = zzkh.zzg(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 34:
                        iZzb2 = zzkh.zzc(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 35:
                        iZzi2 = zzkh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 36:
                        iZzi2 = zzkh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 37:
                        iZzi2 = zzkh.zza((List<Long>) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 38:
                        iZzi2 = zzkh.zzb((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 39:
                        iZzi2 = zzkh.zze((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 40:
                        iZzi2 = zzkh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 41:
                        iZzi2 = zzkh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 42:
                        iZzi2 = zzkh.zzj((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 43:
                        iZzi2 = zzkh.zzf((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 44:
                        iZzi2 = zzkh.zzd((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 45:
                        iZzi2 = zzkh.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 46:
                        iZzi2 = zzkh.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 47:
                        iZzi2 = zzkh.zzg((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 48:
                        iZzi2 = zzkh.zzc((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzho.zze(i12);
                            iZzg2 = zzho.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 49:
                        iZzb2 = zzkh.zzb(i12, (List<zzjp>) zza(t, j), zza(i8));
                        i9 += iZzb2;
                        break;
                    case 50:
                        iZzb2 = this.zzs.zza(i12, zzld.zzf(t, j), zzb(i8));
                        i9 += iZzb2;
                        break;
                    case 51:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzb(i12, 0.0d);
                            i9 += iZzb2;
                        }
                        break;
                    case 52:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzb(i12, 0.0f);
                            i9 += iZzb2;
                        }
                        break;
                    case 53:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzd(i12, zze(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 54:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zze(i12, zze(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 55:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzf(i12, zzd(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 56:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzg(i12, 0L);
                            i9 += iZzb2;
                        }
                        break;
                    case 57:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzi(i12, 0);
                            i9 += iZzb2;
                        }
                        break;
                    case 58:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzb(i12, true);
                            i9 += iZzb2;
                        }
                        break;
                    case 59:
                        if (zza(t, i12, i8)) {
                            Object objZzf2 = zzld.zzf(t, j);
                            if (objZzf2 instanceof zzgt) {
                                iZzb2 = zzho.zzc(i12, (zzgt) objZzf2);
                            } else {
                                iZzb2 = zzho.zzb(i12, (String) objZzf2);
                            }
                            i9 += iZzb2;
                        }
                        break;
                    case 60:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzkh.zza(i12, zzld.zzf(t, j), zza(i8));
                            i9 += iZzb2;
                        }
                        break;
                    case 61:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzc(i12, (zzgt) zzld.zzf(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 62:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzg(i12, zzd(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 63:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzk(i12, zzd(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 64:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzj(i12, 0);
                            i9 += iZzb2;
                        }
                        break;
                    case 65:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzh(i12, 0L);
                            i9 += iZzb2;
                        }
                        break;
                    case 66:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzh(i12, zzd(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 67:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzf(i12, zze(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 68:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzho.zzc(i12, (zzjp) zzld.zzf(t, j), zza(i8));
                            i9 += iZzb2;
                        }
                        break;
                }
                i8 += 3;
                i5 = i11;
            }
            return i9 + zza((zzkx) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i14 = -1;
        int i15 = 0;
        int iZzb3 = 0;
        int i16 = 0;
        while (i15 < this.zzc.length) {
            int iZzd3 = zzd(i15);
            int[] iArr = this.zzc;
            int i17 = iArr[i15];
            int i18 = i6;
            int i19 = (iZzd3 & 267386880) >>> 20;
            if (i19 <= 17) {
                i = iArr[i15 + 2];
                int i20 = i & i18;
                i2 = 1 << (i >>> 20);
                if (i20 != i14) {
                    i16 = unsafe2.getInt(t, i20);
                    i14 = i20;
                }
            } else {
                i = (!this.zzk || i19 < zzhy.DOUBLE_LIST_PACKED.zza() || i19 > zzhy.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i15 + 2] & i18;
                i2 = 0;
            }
            long j2 = iZzd3 & i18;
            switch (i19) {
                case 0:
                    i3 = 0;
                    z = false;
                    if ((i16 & i2) != 0) {
                        iZzb3 += zzho.zzb(i17, 0.0d);
                    }
                    break;
                case 1:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        z = false;
                        iZzb3 += zzho.zzb(i17, 0.0f);
                    } else {
                        z = false;
                    }
                    break;
                case 2:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzho.zzd(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 3:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzho.zze(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 4:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzho.zzf(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 5:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzho.zzg(i17, 0L);
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 6:
                    if ((i16 & i2) != 0) {
                        i3 = 0;
                        iZzd = zzho.zzi(i17, 0);
                        iZzb3 += iZzd;
                        z = false;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 7:
                    if ((i16 & i2) != 0) {
                        iZzb = zzho.zzb(i17, true);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 8:
                    if ((i16 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzgt) {
                            iZzb = zzho.zzc(i17, (zzgt) object);
                        } else {
                            iZzb = zzho.zzb(i17, (String) object);
                        }
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 9:
                    if ((i16 & i2) != 0) {
                        iZzb = zzkh.zza(i17, unsafe2.getObject(t, j2), zza(i15));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 10:
                    if ((i16 & i2) != 0) {
                        iZzb = zzho.zzc(i17, (zzgt) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 11:
                    if ((i16 & i2) != 0) {
                        iZzb = zzho.zzg(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 12:
                    if ((i16 & i2) != 0) {
                        iZzb = zzho.zzk(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 13:
                    if ((i16 & i2) != 0) {
                        iZzj = zzho.zzj(i17, 0);
                        iZzb3 += iZzj;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 14:
                    if ((i16 & i2) != 0) {
                        iZzb = zzho.zzh(i17, 0L);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 15:
                    if ((i16 & i2) != 0) {
                        iZzb = zzho.zzh(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 16:
                    if ((i16 & i2) != 0) {
                        iZzb = zzho.zzf(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 17:
                    if ((i16 & i2) != 0) {
                        iZzb = zzho.zzc(i17, (zzjp) unsafe2.getObject(t, j2), zza(i15));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 18:
                    iZzb = zzkh.zzi(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 19:
                    i4 = 0;
                    iZzh = zzkh.zzh(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 20:
                    i4 = 0;
                    iZzh = zzkh.zza(i17, (List<Long>) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 21:
                    i4 = 0;
                    iZzh = zzkh.zzb(i17, (List<Long>) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 22:
                    i4 = 0;
                    iZzh = zzkh.zze(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 23:
                    i4 = 0;
                    iZzh = zzkh.zzi(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 24:
                    i4 = 0;
                    iZzh = zzkh.zzh(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 25:
                    i4 = 0;
                    iZzh = zzkh.zzj(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 26:
                    iZzb = zzkh.zza(i17, (List<?>) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 27:
                    iZzb = zzkh.zza(i17, (List<?>) unsafe2.getObject(t, j2), zza(i15));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 28:
                    iZzb = zzkh.zzb(i17, (List) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 29:
                    iZzb = zzkh.zzf(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 30:
                    i4 = 0;
                    iZzh = zzkh.zzd(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 31:
                    i4 = 0;
                    iZzh = zzkh.zzh(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 32:
                    i4 = 0;
                    iZzh = zzkh.zzi(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 33:
                    i4 = 0;
                    iZzh = zzkh.zzg(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 34:
                    i4 = 0;
                    iZzh = zzkh.zzc(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 35:
                    iZzi = zzkh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 36:
                    iZzi = zzkh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 37:
                    iZzi = zzkh.zza((List<Long>) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 38:
                    iZzi = zzkh.zzb((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 39:
                    iZzi = zzkh.zze((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 40:
                    iZzi = zzkh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 41:
                    iZzi = zzkh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 42:
                    iZzi = zzkh.zzj((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 43:
                    iZzi = zzkh.zzf((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 44:
                    iZzi = zzkh.zzd((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 45:
                    iZzi = zzkh.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 46:
                    iZzi = zzkh.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 47:
                    iZzi = zzkh.zzg((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 48:
                    iZzi = zzkh.zzc((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzho.zze(i17);
                        iZzg = zzho.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 49:
                    iZzb = zzkh.zzb(i17, (List<zzjp>) unsafe2.getObject(t, j2), zza(i15));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 50:
                    iZzb = this.zzs.zza(i17, unsafe2.getObject(t, j2), zzb(i15));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 51:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzb(i17, 0.0d);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 52:
                    if (zza(t, i17, i15)) {
                        iZzj = zzho.zzb(i17, 0.0f);
                        iZzb3 += iZzj;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 53:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzd(i17, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 54:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zze(i17, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 55:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzf(i17, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 56:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzg(i17, 0L);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 57:
                    if (zza(t, i17, i15)) {
                        iZzj = zzho.zzi(i17, 0);
                        iZzb3 += iZzj;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 58:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzb(i17, true);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 59:
                    if (zza(t, i17, i15)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzgt) {
                            iZzb = zzho.zzc(i17, (zzgt) object2);
                        } else {
                            iZzb = zzho.zzb(i17, (String) object2);
                        }
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 60:
                    if (zza(t, i17, i15)) {
                        iZzb = zzkh.zza(i17, unsafe2.getObject(t, j2), zza(i15));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 61:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzc(i17, (zzgt) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 62:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzg(i17, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 63:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzk(i17, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 64:
                    if (zza(t, i17, i15)) {
                        iZzj = zzho.zzj(i17, 0);
                        iZzb3 += iZzj;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 65:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzh(i17, 0L);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 66:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzh(i17, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 67:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzf(i17, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 68:
                    if (zza(t, i17, i15)) {
                        iZzb = zzho.zzc(i17, (zzjp) unsafe2.getObject(t, j2), zza(i15));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                default:
                    i3 = 0;
                    z = false;
                    break;
            }
            i15 += 3;
            i7 = i3;
            i6 = i18;
        }
        int iZza = i7;
        int iZza2 = iZzb3 + zza((zzkx) this.zzq, (Object) t);
        if (!this.zzh) {
            return iZza2;
        }
        zzhx<T> zzhxVarZza = this.zzr.zza(t);
        for (int i21 = iZza; i21 < zzhxVarZza.zza.zzc(); i21++) {
            Map.Entry entryZzb = zzhxVarZza.zza.zzb(i21);
            iZza += zzhx.zza((zzhz<?>) entryZzb.getKey(), entryZzb.getValue());
        }
        for (Map.Entry entry : zzhxVarZza.zza.zzd()) {
            iZza += zzhx.zza((zzhz<?>) entry.getKey(), entry.getValue());
        }
        return iZza2 + iZza;
    }

    private static <UT, UB> int zza(zzkx<UT, UB> zzkxVar, T t) {
        return zzkxVar.zzf(zzkxVar.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzld.zzf(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r14, com.google.android.gms.internal.firebase_auth.zzlu r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 2916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjt.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzlu):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzb(T r19, com.google.android.gms.internal.firebase_auth.zzlu r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjt.zzb(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzlu):void");
    }

    private final <K, V> void zza(zzlu zzluVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzluVar.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzkx<UT, UB> zzkxVar, T t, zzlu zzluVar) throws IOException {
        zzkxVar.zza(zzkxVar.zzb(t), zzluVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:174:0x05ba A[DONT_GENERATE, FINALLY_INSNS, LOOP:6: B:172:0x05b6->B:174:0x05ba, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05c7 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r13, com.google.android.gms.internal.firebase_auth.zzkc r14, com.google.android.gms.internal.firebase_auth.zzhr r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjt.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzkc, com.google.android.gms.internal.firebase_auth.zzhr):void");
    }

    private final zzkf zza(int i) {
        int i2 = (i / 3) << 1;
        zzkf zzkfVar = (zzkf) this.zzd[i2];
        if (zzkfVar != null) {
            return zzkfVar;
        }
        zzkf<T> zzkfVarZza = zzkb.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzkfVarZza;
        return zzkfVarZza;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzil zzc(int i) {
        return (zzil) this.zzd[((i / 3) << 1) + 1];
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final void zzb(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long jZzd = zzd(this.zzl[i2]) & 1048575;
            Object objZzf = zzld.zzf(t, jZzd);
            if (objZzf != null) {
                zzld.zza(t, jZzd, this.zzs.zzd(objZzf));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkx<UT, UB> zzkxVar) {
        zzil zzilVarZzc;
        int i2 = this.zzc[i];
        Object objZzf = zzld.zzf(obj, zzd(i) & 1048575);
        return (objZzf == null || (zzilVarZzc = zzc(i)) == null) ? ub : (UB) zza(i, i2, this.zzs.zza(objZzf), zzilVarZzc, ub, zzkxVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzil zzilVar, UB ub, zzkx<UT, UB> zzkxVar) {
        zzjg<?, ?> zzjgVarZzf = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzilVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzkxVar.zza();
                }
                zzhb zzhbVarZzc = zzgt.zzc(zzjh.zza(zzjgVarZzf, next.getKey(), next.getValue()));
                try {
                    zzjh.zza(zzhbVarZzc.zzb(), zzjgVarZzf, next.getKey(), next.getValue());
                    zzkxVar.zza(ub, i2, zzhbVarZzc.zza());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2  */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.firebase_auth.zzkf] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.internal.firebase_auth.zzkf] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(T r14) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjt.zzc(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzkf zzkfVar) {
        return zzkfVar.zzc(zzld.zzf(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzlu zzluVar) throws IOException {
        if (obj instanceof String) {
            zzluVar.zza(i, (String) obj);
        } else {
            zzluVar.zza(i, (zzgt) obj);
        }
    }

    private final void zza(Object obj, int i, zzkc zzkcVar) throws IOException {
        if (zzf(i)) {
            zzld.zza(obj, i & 1048575, zzkcVar.zzm());
        } else if (this.zzi) {
            zzld.zza(obj, i & 1048575, zzkcVar.zzl());
        } else {
            zzld.zza(obj, i & 1048575, zzkcVar.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzld.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzld.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzld.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzld.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzld.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((Object) t, i) == zza((Object) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzj) {
            return zza((Object) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzj) {
            int iZzd = zzd(i);
            long j = iZzd & 1048575;
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    return zzld.zze(t, j) != 0.0d;
                case 1:
                    return zzld.zzd(t, j) != 0.0f;
                case 2:
                    return zzld.zzb(t, j) != 0;
                case 3:
                    return zzld.zzb(t, j) != 0;
                case 4:
                    return zzld.zza(t, j) != 0;
                case 5:
                    return zzld.zzb(t, j) != 0;
                case 6:
                    return zzld.zza(t, j) != 0;
                case 7:
                    return zzld.zzc(t, j);
                case 8:
                    Object objZzf = zzld.zzf(t, j);
                    if (objZzf instanceof String) {
                        return !((String) objZzf).isEmpty();
                    }
                    if (objZzf instanceof zzgt) {
                        return !zzgt.zza.equals(objZzf);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzld.zzf(t, j) != null;
                case 10:
                    return !zzgt.zza.equals(zzld.zzf(t, j));
                case 11:
                    return zzld.zza(t, j) != 0;
                case 12:
                    return zzld.zza(t, j) != 0;
                case 13:
                    return zzld.zza(t, j) != 0;
                case 14:
                    return zzld.zzb(t, j) != 0;
                case 15:
                    return zzld.zza(t, j) != 0;
                case 16:
                    return zzld.zzb(t, j) != 0;
                case 17:
                    return zzld.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iZze = zze(i);
        return (zzld.zza(t, (long) (iZze & 1048575)) & (1 << (iZze >>> 20))) != 0;
    }

    private final void zzb(T t, int i) {
        if (this.zzj) {
            return;
        }
        int iZze = zze(i);
        long j = iZze & 1048575;
        zzld.zza((Object) t, j, zzld.zza(t, j) | (1 << (iZze >>> 20)));
    }

    private final boolean zza(T t, int i, int i2) {
        return zzld.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzld.zza((Object) t, zze(i2) & 1048575, i);
    }
}
