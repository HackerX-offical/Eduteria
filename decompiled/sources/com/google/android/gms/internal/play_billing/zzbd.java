package com.google.android.gms.internal.play_billing;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbd {
    private static final Collector zza = Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzar
        @Override // java.util.function.Supplier
        public final Object get() {
            return new zzbs(4);
        }
    }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzau
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((zzbs) obj).zzd(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzav
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            zzbs zzbsVar = (zzbs) obj;
            zzbs zzbsVar2 = (zzbs) obj2;
            zzbsVar.zzb(zzbsVar2.zza, zzbsVar2.zzb);
            return zzbsVar;
        }
    }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzaw
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((zzbs) obj).zze();
        }
    }, new Collector.Characteristics[0]);

    static {
        Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzax
            @Override // java.util.function.Supplier
            public final Object get() {
                return new zzcc();
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzay
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((zzcc) obj).zzd(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzaz
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                zzcc zzccVar = (zzcc) obj;
                zzcc zzccVar2 = (zzcc) obj2;
                zzccVar.zzb(zzccVar2.zza, zzccVar2.zzb);
                return zzccVar;
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzba
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzcc zzccVar = (zzcc) obj;
                int i = zzccVar.zzb;
                if (i == 0) {
                    return zzcy.zza;
                }
                if (i == 1) {
                    return new zzdb(Objects.requireNonNull(zzccVar.zza[0]));
                }
                zzcd zzcdVarZzl = zzcd.zzl(i, zzccVar.zza);
                zzccVar.zzb = zzcdVarZzl.size();
                zzccVar.zzc = true;
                return zzcdVarZzl;
            }
        }, new Collector.Characteristics[0]);
        Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzbb
            @Override // java.util.function.Supplier
            public final Object get() {
                return new zzca();
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzbc
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((zzca) obj).zza((zzcp) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzas
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                zzca zzcaVar = (zzca) obj;
                zzcaVar.zzb((zzca) obj2);
                return zzcaVar;
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzat
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((zzca) obj).zzc();
            }
        }, new Collector.Characteristics[0]);
    }

    static Collector zza() {
        return zza;
    }
}
