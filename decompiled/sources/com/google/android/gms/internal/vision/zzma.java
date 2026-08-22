package com.google.android.gms.internal.vision;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzma {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc;
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzd zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu;
    private static final long zzv;
    private static final int zzw;

    private zzma() {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final byte zza(Object obj, long j) {
            if (zzma.zza) {
                return zzma.zzk(obj, j);
            }
            return zzma.zzl(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, byte b2) {
            if (zzma.zza) {
                zzma.zzc(obj, j, b2);
            } else {
                zzma.zzd(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final boolean zzb(Object obj, long j) {
            if (zzma.zza) {
                return zzma.zzm(obj, j);
            }
            return zzma.zzn(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzma.zza) {
                zzma.zzd(obj, j, z);
            } else {
                zzma.zze(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final byte zza(Object obj, long j) {
            return this.zza.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, byte b2) {
            this.zza.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final boolean zzb(Object obj, long j) {
            return this.zza.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zza.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final float zzc(Object obj, long j) {
            return this.zza.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, float f2) {
            this.zza.putFloat(obj, j, f2);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final double zzd(Object obj, long j) {
            return this.zza.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, double d2) {
            this.zza.putDouble(obj, j, d2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final byte zza(Object obj, long j) {
            if (zzma.zza) {
                return zzma.zzk(obj, j);
            }
            return zzma.zzl(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, byte b2) {
            if (zzma.zza) {
                zzma.zzc(obj, j, b2);
            } else {
                zzma.zzd(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final boolean zzb(Object obj, long j) {
            if (zzma.zza) {
                return zzma.zzm(obj, j);
            }
            return zzma.zzn(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzma.zza) {
                zzma.zzd(obj, j, z);
            } else {
                zzma.zze(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzma.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static boolean zza() {
        return zzh;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private static abstract class zzd {
        Unsafe zza;

        zzd(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract byte zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b2);

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f2);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract boolean zzb(Object obj, long j);

        public abstract float zzc(Object obj, long j);

        public abstract double zzd(Object obj, long j);

        public final int zze(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public final long zzf(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }
    }

    static boolean zzb() {
        return zzg;
    }

    static <T> T zza(Class<T> cls) {
        try {
            return (T) zzb.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzb(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzc(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zza(Object obj, long j) {
        return zzf.zze(obj, j);
    }

    static void zza(Object obj, long j, int i) {
        zzf.zza(obj, j, i);
    }

    static long zzb(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzf.zza(obj, j, j2);
    }

    static boolean zzc(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzf.zza(obj, j, z);
    }

    static float zzd(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    static void zza(Object obj, long j, float f2) {
        zzf.zza(obj, j, f2);
    }

    static double zze(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    static void zza(Object obj, long j, double d2) {
        zzf.zza(obj, j, d2);
    }

    static Object zzf(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzf.zza(bArr, zzi + j);
    }

    static void zza(byte[] bArr, long j, byte b2) {
        zzf.zza((Object) bArr, zzi + j, b2);
    }

    static Unsafe zzc() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmc());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzd() {
        Unsafe unsafe = zzb;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzhi.zza()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(zzma.class.getName());
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(strValueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(strValueOf).toString());
            return false;
        }
    }

    private static boolean zze() {
        Unsafe unsafe = zzb;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzf() == null) {
                return false;
            }
            if (zzhi.zza()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(zzma.class.getName());
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(strValueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(strValueOf).toString());
            return false;
        }
    }

    private static boolean zzd(Class<?> cls) {
        if (!zzhi.zza()) {
            return false;
        }
        try {
            Class<?> cls2 = zzc;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzf() {
        Field fieldZza;
        if (zzhi.zza() && (fieldZza = zza((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldZza;
        }
        Field fieldZza2 = zza((Class<?>) Buffer.class, "address");
        if (fieldZza2 == null || fieldZza2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZza2;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzk(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzl(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iZza = zza(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (iZza & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zza(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzm(Object obj, long j) {
        return zzk(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzn(Object obj, long j) {
        return zzl(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zze(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : (byte) 0);
    }

    static {
        Unsafe unsafeZzc = zzc();
        zzb = unsafeZzc;
        zzc = zzhi.zzb();
        boolean zZzd = zzd(Long.TYPE);
        zzd = zZzd;
        boolean zZzd2 = zzd(Integer.TYPE);
        zze = zZzd2;
        zzd zzbVar = null;
        if (unsafeZzc != null) {
            if (!zzhi.zza()) {
                zzbVar = new zzb(unsafeZzc);
            } else if (zZzd) {
                zzbVar = new zzc(unsafeZzc);
            } else if (zZzd2) {
                zzbVar = new zza(unsafeZzc);
            }
        }
        zzf = zzbVar;
        zzg = zze();
        zzh = zzd();
        long jZzb = zzb(byte[].class);
        zzi = jZzb;
        zzj = zzb(boolean[].class);
        zzk = zzc(boolean[].class);
        zzl = zzb(int[].class);
        zzm = zzc(int[].class);
        zzn = zzb(long[].class);
        zzo = zzc(long[].class);
        zzp = zzb(float[].class);
        zzq = zzc(float[].class);
        zzr = zzb(double[].class);
        zzs = zzc(double[].class);
        zzt = zzb(Object[].class);
        zzu = zzc(Object[].class);
        Field fieldZzf = zzf();
        zzv = (fieldZzf == null || zzbVar == null) ? -1L : zzbVar.zza.objectFieldOffset(fieldZzf);
        zzw = (int) (jZzb & 7);
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
