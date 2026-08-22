package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzgl;
import com.google.android.gms.internal.firebase_auth.zzgo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzgl<MessageType extends zzgl<MessageType, BuilderType>, BuilderType extends zzgo<MessageType, BuilderType>> implements zzjp {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.firebase_auth.zzjp
    public final zzgt zzw() {
        try {
            zzhb zzhbVarZzc = zzgt.zzc(zzab());
            zza(zzhbVarZzc.zzb());
            return zzhbVarZzc.zza();
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ByteString threw an IOException (should never happen).").toString(), e2);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjp
    public final byte[] zzx() {
        try {
            byte[] bArr = new byte[zzab()];
            zzho zzhoVarZza = zzho.zza(bArr);
            zza(zzhoVarZza);
            zzhoVarZza.zzb();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length()).append("Serializing ").append(name).append(" to a byte array threw an IOException (should never happen).").toString(), e2);
        }
    }

    int zzy() {
        throw new UnsupportedOperationException();
    }

    void zzb(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzig.zza(iterable);
        if (iterable instanceof zziw) {
            List<?> listZzb = ((zziw) iterable).zzb();
            zziw zziwVar = (zziw) list;
            int size = list.size();
            for (Object obj : listZzb) {
                if (obj == null) {
                    String string = new StringBuilder(37).append("Element at index ").append(zziwVar.size() - size).append(" is null.").toString();
                    for (int size2 = zziwVar.size() - 1; size2 >= size; size2--) {
                        zziwVar.remove(size2);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzgt) {
                    zziwVar.zza((zzgt) obj);
                } else {
                    zziwVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzjy) {
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
