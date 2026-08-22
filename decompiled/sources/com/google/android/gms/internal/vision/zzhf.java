package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzhe;
import com.google.android.gms.internal.vision.zzhf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzhf<MessageType extends zzhf<MessageType, BuilderType>, BuilderType extends zzhe<MessageType, BuilderType>> implements zzkk {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.vision.zzkk
    public final zzht zzg() {
        try {
            zzib zzibVarZzc = zzht.zzc(zzm());
            zza(zzibVarZzc.zzb());
            return zzibVarZzc.zza();
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ByteString threw an IOException (should never happen).").toString(), e2);
        }
    }

    public final byte[] zzh() {
        try {
            byte[] bArr = new byte[zzm()];
            zzii zziiVarZza = zzii.zza(bArr);
            zza(zziiVarZza);
            zziiVarZza.zzb();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length()).append("Serializing ").append(name).append(" to a byte array threw an IOException (should never happen).").toString(), e2);
        }
    }

    int zzi() {
        throw new UnsupportedOperationException();
    }

    void zzb(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzjf.zza(iterable);
        if (iterable instanceof zzjv) {
            List<?> listZzd = ((zzjv) iterable).zzd();
            zzjv zzjvVar = (zzjv) list;
            int size = list.size();
            for (Object obj : listZzd) {
                if (obj == null) {
                    String string = new StringBuilder(37).append("Element at index ").append(zzjvVar.size() - size).append(" is null.").toString();
                    for (int size2 = zzjvVar.size() - 1; size2 >= size; size2--) {
                        zzjvVar.remove(size2);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzht) {
                    zzjvVar.zza((zzht) obj);
                } else {
                    zzjvVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzkw) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size3 = list.size();
        for (T t : iterable) {
            if (t == null) {
                String string2 = new StringBuilder(37).append("Element at index ").append(list.size() - size3).append(" is null.").toString();
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(string2);
            }
            list.add(t);
        }
    }
}
