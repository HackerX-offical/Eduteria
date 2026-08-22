package com.google.android.gms.internal.play_billing;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdd {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = zzck.zza;
            }
        } else {
            if (!(iterable instanceof zzdc)) {
                return false;
            }
            comparator2 = ((zzdc) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
