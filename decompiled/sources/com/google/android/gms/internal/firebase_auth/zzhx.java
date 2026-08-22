package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhx<T extends zzhz<T>> {
    private static final zzhx zzd = new zzhx(true);
    final zzkg<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzhx() {
        this.zza = zzkg.zza(16);
    }

    private zzhx(boolean z) {
        this(zzkg.zza(0));
        zzb();
    }

    private zzhx(zzkg<T, Object> zzkgVar) {
        this.zza = zzkgVar;
        zzb();
    }

    public static <T extends zzhz<T>> zzhx<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhx) {
            return this.zza.equals(((zzhx) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zziv(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zziv(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zziq)) {
            return obj;
        }
        return zziq.zza();
    }

    private final void zzb(T t, Object obj) {
        if (t.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            zza(t.zzb(), obj);
        }
        if (obj instanceof zziq) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private static void zza(zzlo zzloVar, Object obj) {
        zzig.zza(obj);
        boolean z = true;
        switch (zzhw.zza[zzloVar.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzgt) && !(obj instanceof byte[])) {
                    z = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzij)) {
                    z = false;
                }
                break;
            case 9:
                if (!(obj instanceof zzjp) && !(obj instanceof zziq)) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zza((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzhz<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzlr.MESSAGE) {
            if (key.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzjp) it.next()).zzaa()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjp) {
                    if (!((zzjp) value).zzaa()) {
                        return false;
                    }
                } else {
                    if (value instanceof zziq) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzhx<T> zzhxVar) {
        for (int i = 0; i < zzhxVar.zza.zzc(); i++) {
            zzb(zzhxVar.zza.zzb(i));
        }
        Iterator it = zzhxVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzjv) {
            return ((zzjv) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzjp zzjpVarZzf;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zziq) {
            value = zziq.zza();
        }
        if (key.zzd()) {
            Object objZza = zza((zzhz) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.put(key, objZza);
            return;
        }
        if (key.zzc() == zzlr.MESSAGE) {
            Object objZza2 = zza((zzhz) key);
            if (objZza2 == null) {
                this.zza.put(key, zza(value));
                return;
            }
            if (objZza2 instanceof zzjv) {
                zzjpVarZzf = key.zza((zzjv) objZza2, (zzjv) value);
            } else {
                zzjpVarZzf = key.zza(((zzjp) objZza2).zzae(), (zzjp) value).zzf();
            }
            this.zza.put(key, zzjpVarZzf);
            return;
        }
        this.zza.put(key, zza(value));
    }

    static void zza(zzho zzhoVar, zzlo zzloVar, int i, Object obj) throws IOException {
        if (zzloVar == zzlo.zzj) {
            zzjp zzjpVar = (zzjp) obj;
            zzig.zza(zzjpVar);
            zzhoVar.zza(i, 3);
            zzjpVar.zza(zzhoVar);
            zzhoVar.zza(i, 4);
        }
        zzhoVar.zza(i, zzloVar.zzb());
        switch (zzhw.zzb[zzloVar.ordinal()]) {
            case 1:
                zzhoVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzhoVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzhoVar.zza(((Long) obj).longValue());
                break;
            case 4:
                zzhoVar.zza(((Long) obj).longValue());
                break;
            case 5:
                zzhoVar.zza(((Integer) obj).intValue());
                break;
            case 6:
                zzhoVar.zzc(((Long) obj).longValue());
                break;
            case 7:
                zzhoVar.zzd(((Integer) obj).intValue());
                break;
            case 8:
                zzhoVar.zza(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzjp) obj).zza(zzhoVar);
                break;
            case 10:
                zzhoVar.zza((zzjp) obj);
                break;
            case 11:
                if (obj instanceof zzgt) {
                    zzhoVar.zza((zzgt) obj);
                } else {
                    zzhoVar.zza((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzgt) {
                    zzhoVar.zza((zzgt) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzhoVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzhoVar.zzb(((Integer) obj).intValue());
                break;
            case 14:
                zzhoVar.zzd(((Integer) obj).intValue());
                break;
            case 15:
                zzhoVar.zzc(((Long) obj).longValue());
                break;
            case 16:
                zzhoVar.zzc(((Integer) obj).intValue());
                break;
            case 17:
                zzhoVar.zzb(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzij) {
                    zzhoVar.zza(((zzij) obj).zza());
                } else {
                    zzhoVar.zza(((Integer) obj).intValue());
                }
                break;
        }
    }

    public final int zzg() {
        int iZzc = 0;
        for (int i = 0; i < this.zza.zzc(); i++) {
            iZzc += zzc(this.zza.zzb(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzc += zzc((Map.Entry) it.next());
        }
        return iZzc;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzlr.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zziq) {
                return zzho.zzb(entry.getKey().zza(), (zziq) value);
            }
            return zzho.zzb(entry.getKey().zza(), (zzjp) value);
        }
        return zza((zzhz<?>) key, value);
    }

    static int zza(zzlo zzloVar, int i, Object obj) {
        int iZze = zzho.zze(i);
        if (zzloVar == zzlo.zzj) {
            zzig.zza((zzjp) obj);
            iZze <<= 1;
        }
        return iZze + zzb(zzloVar, obj);
    }

    private static int zzb(zzlo zzloVar, Object obj) {
        switch (zzhw.zzb[zzloVar.ordinal()]) {
            case 1:
                return zzho.zzb(((Double) obj).doubleValue());
            case 2:
                return zzho.zzb(((Float) obj).floatValue());
            case 3:
                return zzho.zzd(((Long) obj).longValue());
            case 4:
                return zzho.zze(((Long) obj).longValue());
            case 5:
                return zzho.zzf(((Integer) obj).intValue());
            case 6:
                return zzho.zzg(((Long) obj).longValue());
            case 7:
                return zzho.zzi(((Integer) obj).intValue());
            case 8:
                return zzho.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzho.zzc((zzjp) obj);
            case 10:
                if (obj instanceof zziq) {
                    return zzho.zza((zziq) obj);
                }
                return zzho.zzb((zzjp) obj);
            case 11:
                if (obj instanceof zzgt) {
                    return zzho.zzb((zzgt) obj);
                }
                return zzho.zzb((String) obj);
            case 12:
                if (obj instanceof zzgt) {
                    return zzho.zzb((zzgt) obj);
                }
                return zzho.zzb((byte[]) obj);
            case 13:
                return zzho.zzg(((Integer) obj).intValue());
            case 14:
                return zzho.zzj(((Integer) obj).intValue());
            case 15:
                return zzho.zzh(((Long) obj).longValue());
            case 16:
                return zzho.zzh(((Integer) obj).intValue());
            case 17:
                return zzho.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzij) {
                    return zzho.zzk(((zzij) obj).zza());
                }
                return zzho.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzhz<?> zzhzVar, Object obj) {
        zzlo zzloVarZzb = zzhzVar.zzb();
        int iZza = zzhzVar.zza();
        if (zzhzVar.zzd()) {
            int iZza2 = 0;
            if (zzhzVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zzb(zzloVarZzb, it.next());
                }
                return zzho.zze(iZza) + iZza2 + zzho.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzloVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzloVarZzb, iZza, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhx zzhxVar = new zzhx();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zzhxVar.zzb((zzhz) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzhxVar.zzb((zzhz) entry.getKey(), entry.getValue());
        }
        zzhxVar.zzc = this.zzc;
        return zzhxVar;
    }
}
