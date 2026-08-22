package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzgo;
import com.google.android.gms.internal.play_billing.zzgs;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzgs<MessageType extends zzgs<MessageType, BuilderType>, BuilderType extends zzgo<MessageType, BuilderType>> extends zzfd<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzis zzc = zzis.zzc();

    private static zzgs zzB(zzgs zzgsVar, byte[] bArr, int i, int i2, zzge zzgeVar) throws zzgz {
        if (i2 == 0) {
            return zzgsVar;
        }
        zzgs zzgsVarZzp = zzgsVar.zzp();
        try {
            zzif zzifVarZzb = zzic.zza().zzb(zzgsVarZzp.getClass());
            zzifVarZzb.zzh(zzgsVarZzp, bArr, 0, i2, new zzfh(zzgeVar));
            zzifVarZzb.zzf(zzgsVarZzp);
            return zzgsVarZzp;
        } catch (zzgz e2) {
            throw e2;
        } catch (zziq e3) {
            throw e3.zza();
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzgz) {
                throw ((zzgz) e4.getCause());
            }
            throw new zzgz(e4);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgz("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final int zzc(zzif zzifVar) {
        return zzic.zza().zzb(getClass()).zza(this);
    }

    static zzgs zzo(Class cls) {
        Map map = zzb;
        zzgs zzgsVar = (zzgs) map.get(cls);
        if (zzgsVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgsVar = (zzgs) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzgsVar != null) {
            return zzgsVar;
        }
        zzgs zzgsVar2 = (zzgs) ((zzgs) zziy.zze(cls)).zzd(6, null, null);
        if (zzgsVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzgsVar2);
        return zzgsVar2;
    }

    protected static zzgs zzq(zzgs zzgsVar, byte[] bArr, zzge zzgeVar) throws zzgz {
        zzgs zzgsVarZzB = zzB(zzgsVar, bArr, 0, bArr.length, zzgeVar);
        if (zzgsVarZzB == null || zzz(zzgsVarZzB, true)) {
            return zzgsVarZzB;
        }
        throw new zziq(zzgsVarZzB).zza();
    }

    protected static zzgv zzr() {
        return zzgt.zzf();
    }

    protected static zzgw zzs() {
        return zzid.zze();
    }

    static Object zzt(Method method, Object obj, Object... objArr) {
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

    protected static Object zzu(zzhu zzhuVar, String str, Object[] objArr) {
        return new zzie(zzhuVar, str, objArr);
    }

    protected static void zzx(Class cls, zzgs zzgsVar) {
        zzgsVar.zzw();
        zzb.put(cls, zzgsVar);
    }

    protected static final boolean zzz(zzgs zzgsVar, boolean z) {
        byte bByteValue = ((Byte) zzgsVar.zzd(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzic.zza().zzb(zzgsVar.getClass()).zzk(zzgsVar);
        if (z) {
            zzgsVar.zzd(2, true != zZzk ? null : zzgsVar, null);
        }
        return zZzk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzic.zza().zzb(getClass()).zzj(this, (zzgs) obj);
    }

    public final int hashCode() {
        if (zzA()) {
            return zzj();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzj = zzj();
        this.zza = iZzj;
        return iZzj;
    }

    public final String toString() {
        return zzhw.zza(this, super.toString());
    }

    final boolean zzA() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final /* synthetic */ zzht zzI() {
        return (zzgo) zzd(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final void zzJ(zzfz zzfzVar) throws IOException {
        zzic.zza().zzb(getClass()).zzi(this, zzga.zza(zzfzVar));
    }

    protected abstract Object zzd(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.play_billing.zzfd
    final int zze(zzif zzifVar) {
        if (zzA()) {
            int iZza = zzifVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzifVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final /* synthetic */ zzhu zzi() {
        return (zzgs) zzd(6, null, null);
    }

    final int zzj() {
        return zzic.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final boolean zzl() {
        return zzz(this, true);
    }

    protected final zzgo zzm() {
        return (zzgo) zzd(5, null, null);
    }

    public final zzgo zzn() {
        zzgo zzgoVar = (zzgo) zzd(5, null, null);
        zzgoVar.zze(this);
        return zzgoVar;
    }

    final zzgs zzp() {
        return (zzgs) zzd(4, null, null);
    }

    protected final void zzv() {
        zzic.zza().zzb(getClass()).zzf(this);
        zzw();
    }

    final void zzw() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzy(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhu
    public final int zzk() {
        if (zzA()) {
            int iZzc = zzc(null);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZzc2 = zzc(null);
        if (iZzc2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzc2;
            return iZzc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZzc2);
    }
}
