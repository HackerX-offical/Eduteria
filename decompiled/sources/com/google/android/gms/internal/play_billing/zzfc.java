package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzfc;
import com.google.android.gms.internal.play_billing.zzfd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfc<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzfc<MessageType, BuilderType>> implements zzht {
    private static void zza(List list, int i) {
        String str = "Element at index " + (list.size() - i) + " is null.";
        int size = list.size();
        while (true) {
            size--;
            if (size < i) {
                throw new NullPointerException(str);
            }
            list.remove(size);
        }
    }

    protected static void zzc(Iterable iterable, List list) {
        byte[] bArr = zzgx.zzb;
        iterable.getClass();
        if (iterable instanceof zzhg) {
            List listZza = ((zzhg) iterable).zza();
            zzhg zzhgVar = (zzhg) list;
            int size = list.size();
            for (Object obj : listZza) {
                if (obj == null) {
                    String str = "Element at index " + (zzhgVar.size() - size) + " is null.";
                    int size2 = zzhgVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        zzhgVar.remove(size2);
                    }
                } else if (obj instanceof zzfs) {
                    zzhgVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj;
                    zzfs.zzj(bArr2, 0, bArr2.length);
                    zzhgVar.zzb();
                } else {
                    zzhgVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzib) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size3 = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size3);
            }
            if (list instanceof zzid) {
                ((zzid) list).zzf(list.size() + size3);
            }
        }
        int size4 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    zza(list, size4);
                }
                list.add(obj2);
            }
            return;
        }
        List list2 = (List) iterable;
        int size5 = list2.size();
        for (int i = 0; i < size5; i++) {
            Object obj3 = list2.get(i);
            if (obj3 == null) {
                zza(list, size4);
            }
            list.add(obj3);
        }
    }

    @Override // 
    public abstract zzfc zzb();
}
