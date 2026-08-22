package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;
import com.google.android.gms.internal.firebase_auth.zzie.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzie<MessageType extends zzie<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgl<MessageType, BuilderType> {
    private static Map<Object, zzie<?, ?>> zzd = new ConcurrentHashMap();
    protected zzla zzb = zzla.zza();
    private int zzc = -1;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    static final class zzc implements zzhz<zzc> {
        @Override // com.google.android.gms.internal.firebase_auth.zzhz
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhz
        public final zzlo zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhz
        public final zzlr zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhz
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhz
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhz
        public final zzjo zza(zzjo zzjoVar, zzjp zzjpVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzhz
        public final zzjv zza(zzjv zzjvVar, zzjv zzjvVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzie<MessageType, BuilderType> implements zzjr {
        protected zzhx<zzc> zzc = zzhx.zza();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzh = 1;
        public static final int zzi = 2;
        private static final /* synthetic */ int[] zzm = {1, 2};
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static class zzf<ContainingType extends zzjp, Type> extends zzhs<ContainingType, Type> {
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static class zza<T extends zzie<T, ?>> extends zzgq<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzjz
        public final /* synthetic */ Object zza(zzhf zzhfVar, zzhr zzhrVar) throws zzip {
            return zzie.zza(this.zza, zzhfVar, zzhrVar);
        }
    }

    public String toString() {
        return zzjq.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzkb.zza().zza(this).zza(this);
        return this.zza;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static abstract class zzb<MessageType extends zzie<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgo<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) messagetype.zza(zze.zzd, null, null);
        }

        protected void zzb() {
            MessageType messagetype = (MessageType) this.zza.zza(zze.zzd, null, null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzjr
        public final boolean zzaa() {
            return zzie.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzjo
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public MessageType zze() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzkb.zza().zza(messagetype).zzb(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzjo
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public final MessageType zzf() {
            MessageType messagetype = (MessageType) zze();
            if (messagetype.zzaa()) {
                return messagetype;
            }
            throw new zzky(messagetype);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzgo
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzkb.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzgo
        /* JADX INFO: renamed from: zza */
        public final /* synthetic */ zzgo clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzjr
        public final /* synthetic */ zzjp zzag() {
            return this.zzc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.firebase_auth.zzgo
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzc.zza(zze.zze, null, null);
            zzbVar.zza((zzie) zze());
            return zzbVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzie) zza(zze.zzf, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return zzkb.zza().zza(this).zza(this, (zzie) obj);
        }
        return false;
    }

    protected final <MessageType extends zzie<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzz() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjr
    public final boolean zzaa() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    final int zzy() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgl
    final void zzb(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjp
    public final void zza(zzho zzhoVar) throws IOException {
        zzkb.zza().zza(this).zza(this, zzhq.zza(zzhoVar));
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjp
    public final int zzab() {
        if (this.zzc == -1) {
            this.zzc = zzkb.zza().zza(this).zzd(this);
        }
        return this.zzc;
    }

    static <T extends zzie<?, ?>> T zza(Class<T> cls) {
        T t = (T) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) ((zzie) zzld.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
        if (t2 == null) {
            throw new IllegalStateException();
        }
        zzd.put(cls, t2);
        return t2;
    }

    protected static <T extends zzie<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzjp zzjpVar, String str, Object[] objArr) {
        return new zzkd(zzjpVar, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzie<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzc = zzkb.zza().zza(t).zzc(t);
        if (z) {
            t.zza(zze.zzb, zZzc ? t : null, null);
        }
        return zZzc;
    }

    protected static zzik zzac() {
        return zzih.zzd();
    }

    protected static <E> zzim<E> zzad() {
        return zzka.zzd();
    }

    static <T extends zzie<T, ?>> T zza(T t, zzhf zzhfVar, zzhr zzhrVar) throws zzip {
        T t2 = (T) t.zza(zze.zzd, null, null);
        try {
            zzkf zzkfVarZza = zzkb.zza().zza(t2);
            zzkfVarZza.zza(t2, zzhm.zza(zzhfVar), zzhrVar);
            zzkfVarZza.zzb(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzip) {
                throw ((zzip) e2.getCause());
            }
            throw new zzip(e2.getMessage()).zza(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzip) {
                throw ((zzip) e3.getCause());
            }
            throw e3;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjp
    public final /* synthetic */ zzjo zzae() {
        zzb zzbVar = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzbVar.zza(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjp
    public final /* synthetic */ zzjo zzaf() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjr
    public final /* synthetic */ zzjp zzag() {
        return (zzie) zza(zze.zzf, (Object) null, (Object) null);
    }
}
