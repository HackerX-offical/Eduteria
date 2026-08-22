package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zziw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zziu<T extends zziw<T>> {
    private static final zziu zzd = new zziu(true);
    final zzlh<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zziu() {
        this.zza = zzlh.zza(16);
    }

    private zziu(boolean z) {
        this(zzlh.zza(0));
        zzb();
    }

    private zziu(zzlh<T, Object> zzlhVar) {
        this.zza = zzlhVar;
        zzb();
    }

    public static <T extends zziw<T>> zziu<T> zza() {
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
        if (obj instanceof zziu) {
            return this.zza.equals(((zziu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzjq(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzjq(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    public final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzjp)) {
            return obj;
        }
        return zzjp.zza();
    }

    public final void zza(T t, Object obj) {
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
                zzd(t, obj2);
            }
            obj = arrayList;
        } else {
            zzd(t, obj);
        }
        if (obj instanceof zzjp) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    public final void zzb(T t, Object obj) {
        List arrayList;
        if (!t.zzd()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        zzd(t, obj);
        Object objZza = zza((zziw) t);
        if (objZza == null) {
            arrayList = new ArrayList();
            this.zza.put(t, arrayList);
        } else {
            arrayList = (List) objZza;
        }
        arrayList.add(obj);
    }

    private static void zzd(T t, Object obj) {
        zzml zzmlVarZzb = t.zzb();
        zzjf.zza(obj);
        boolean z = true;
        switch (zzit.zza[zzmlVarZzb.zza().ordinal()]) {
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
                if (!(obj instanceof zzht) && !(obj instanceof byte[])) {
                    z = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzje)) {
                    z = false;
                }
                break;
            case 9:
                if (!(obj instanceof zzkk) && !(obj instanceof zzjp)) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zza(), obj.getClass().getName()));
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

    private static <T extends zziw<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzmo.MESSAGE) {
            if (key.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzkk) it.next()).zzk()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzkk) {
                    if (!((zzkk) value).zzk()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzjp) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zziu<T> zziuVar) {
        for (int i = 0; i < zziuVar.zza.zzc(); i++) {
            zzb(zziuVar.zza.zzb(i));
        }
        Iterator it = zziuVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzkt) {
            return ((zzkt) obj).clone();
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
        zzkk zzkkVarZzf;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzjp) {
            value = zzjp.zza();
        }
        if (key.zzd()) {
            Object objZza = zza((zziw) key);
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
        if (key.zzc() == zzmo.MESSAGE) {
            Object objZza2 = zza((zziw) key);
            if (objZza2 == null) {
                this.zza.put(key, zza(value));
                return;
            }
            if (objZza2 instanceof zzkt) {
                zzkkVarZzf = key.zza((zzkt) objZza2, (zzkt) value);
            } else {
                zzkkVarZzf = key.zza(((zzkk) objZza2).zzp(), (zzkk) value).zzf();
            }
            this.zza.put(key, zzkkVarZzf);
            return;
        }
        this.zza.put(key, zza(value));
    }

    static void zza(zzii zziiVar, zzml zzmlVar, int i, Object obj) throws IOException {
        if (zzmlVar == zzml.zzj) {
            zzkk zzkkVar = (zzkk) obj;
            zzjf.zza(zzkkVar);
            zziiVar.zza(i, 3);
            zzkkVar.zza(zziiVar);
            zziiVar.zza(i, 4);
        }
        zziiVar.zza(i, zzmlVar.zzb());
        switch (zzit.zzb[zzmlVar.ordinal()]) {
            case 1:
                zziiVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zziiVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zziiVar.zza(((Long) obj).longValue());
                break;
            case 4:
                zziiVar.zza(((Long) obj).longValue());
                break;
            case 5:
                zziiVar.zza(((Integer) obj).intValue());
                break;
            case 6:
                zziiVar.zzc(((Long) obj).longValue());
                break;
            case 7:
                zziiVar.zzd(((Integer) obj).intValue());
                break;
            case 8:
                zziiVar.zza(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzkk) obj).zza(zziiVar);
                break;
            case 10:
                zziiVar.zza((zzkk) obj);
                break;
            case 11:
                if (obj instanceof zzht) {
                    zziiVar.zza((zzht) obj);
                } else {
                    zziiVar.zza((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzht) {
                    zziiVar.zza((zzht) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zziiVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zziiVar.zzb(((Integer) obj).intValue());
                break;
            case 14:
                zziiVar.zzd(((Integer) obj).intValue());
                break;
            case 15:
                zziiVar.zzc(((Long) obj).longValue());
                break;
            case 16:
                zziiVar.zzc(((Integer) obj).intValue());
                break;
            case 17:
                zziiVar.zzb(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzje) {
                    zziiVar.zza(((zzje) obj).zza());
                } else {
                    zziiVar.zza(((Integer) obj).intValue());
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
        if (key.zzc() == zzmo.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zzjp) {
                return zzii.zzb(entry.getKey().zza(), (zzjp) value);
            }
            return zzii.zzb(entry.getKey().zza(), (zzkk) value);
        }
        return zzc(key, value);
    }

    static int zza(zzml zzmlVar, int i, Object obj) {
        int iZze = zzii.zze(i);
        if (zzmlVar == zzml.zzj) {
            zzjf.zza((zzkk) obj);
            iZze <<= 1;
        }
        return iZze + zza(zzmlVar, obj);
    }

    private static int zza(zzml zzmlVar, Object obj) {
        switch (zzit.zzb[zzmlVar.ordinal()]) {
            case 1:
                return zzii.zzb(((Double) obj).doubleValue());
            case 2:
                return zzii.zzb(((Float) obj).floatValue());
            case 3:
                return zzii.zzd(((Long) obj).longValue());
            case 4:
                return zzii.zze(((Long) obj).longValue());
            case 5:
                return zzii.zzf(((Integer) obj).intValue());
            case 6:
                return zzii.zzg(((Long) obj).longValue());
            case 7:
                return zzii.zzi(((Integer) obj).intValue());
            case 8:
                return zzii.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzii.zzc((zzkk) obj);
            case 10:
                if (obj instanceof zzjp) {
                    return zzii.zza((zzjp) obj);
                }
                return zzii.zzb((zzkk) obj);
            case 11:
                if (obj instanceof zzht) {
                    return zzii.zzb((zzht) obj);
                }
                return zzii.zzb((String) obj);
            case 12:
                if (obj instanceof zzht) {
                    return zzii.zzb((zzht) obj);
                }
                return zzii.zzb((byte[]) obj);
            case 13:
                return zzii.zzg(((Integer) obj).intValue());
            case 14:
                return zzii.zzj(((Integer) obj).intValue());
            case 15:
                return zzii.zzh(((Long) obj).longValue());
            case 16:
                return zzii.zzh(((Integer) obj).intValue());
            case 17:
                return zzii.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzje) {
                    return zzii.zzk(((zzje) obj).zza());
                }
                return zzii.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzc(zziw<?> zziwVar, Object obj) {
        zzml zzmlVarZzb = zziwVar.zzb();
        int iZza = zziwVar.zza();
        if (zziwVar.zzd()) {
            int iZza2 = 0;
            if (zziwVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zza(zzmlVarZzb, it.next());
                }
                return zzii.zze(iZza) + iZza2 + zzii.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzmlVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzmlVarZzb, iZza, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zziu zziuVar = new zziu();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zziuVar.zza((zziw) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zziuVar.zza((zziw) entry.getKey(), entry.getValue());
        }
        zziuVar.zzc = this.zzc;
        return zziuVar;
    }
}
