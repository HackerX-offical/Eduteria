package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzgj {
    private static final zzgj zzb = new zzgj(true);
    final zzin zza = new zzii();
    private boolean zzc;
    private boolean zzd;

    private zzgj() {
    }

    static int zza(zzjc zzjcVar, int i, Object obj) {
        zzfz.zzz(i << 3);
        if (zzjc.GROUP == null) {
            zzhu zzhuVar = (zzhu) obj;
            byte[] bArr = zzgx.zzb;
            if (zzhuVar instanceof zzfe) {
                throw null;
            }
        }
        zzjd zzjdVar = zzjd.INT;
        throw null;
    }

    public static int zzb(zzgi zzgiVar, Object obj) {
        zzjc zzjcVarZzb = zzgiVar.zzb();
        int iZza = zzgiVar.zza();
        if (!zzgiVar.zze()) {
            return zza(zzjcVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        if (!zzgiVar.zzd()) {
            int iZza2 = 0;
            for (int i = 0; i < size; i++) {
                iZza2 += zza(zzjcVarZzb, iZza, list.get(i));
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        if (size <= 0) {
            return zzfz.zzz(iZza << 3) + zzfz.zzz(0);
        }
        list.get(0);
        zzjc zzjcVar = zzjc.DOUBLE;
        zzjd zzjdVar = zzjd.INT;
        throw null;
    }

    public static zzgj zzd() {
        return zzb;
    }

    private static boolean zzi(Map.Entry entry) {
        zzgi zzgiVar = (zzgi) entry.getKey();
        if (zzgiVar.zzc() != zzjd.MESSAGE) {
            return true;
        }
        if (!zzgiVar.zze()) {
            return zzj(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzj(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzj(Object obj) {
        if (obj instanceof zzhv) {
            return ((zzhv) obj).zzl();
        }
        if (obj instanceof zzhe) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzk(Map.Entry entry) {
        int i;
        int iZzz;
        int iZzz2;
        int iZzk;
        int iZzz3;
        zzgi zzgiVar = (zzgi) entry.getKey();
        Object value = entry.getValue();
        if (zzgiVar.zzc() != zzjd.MESSAGE || zzgiVar.zze() || zzgiVar.zzd()) {
            return zzb(zzgiVar, value);
        }
        if (value instanceof zzhe) {
            int iZza = ((zzgi) entry.getKey()).zza();
            int iZzz4 = zzfz.zzz(8);
            i = iZzz4 + iZzz4;
            iZzz = zzfz.zzz(16) + zzfz.zzz(iZza);
            iZzz2 = zzfz.zzz(24);
            iZzk = ((zzhe) value).zza();
            iZzz3 = zzfz.zzz(iZzk);
        } else {
            int iZza2 = ((zzgi) entry.getKey()).zza();
            int iZzz5 = zzfz.zzz(8);
            i = iZzz5 + iZzz5;
            iZzz = zzfz.zzz(16) + zzfz.zzz(iZza2);
            iZzz2 = zzfz.zzz(24);
            iZzk = ((zzhu) value).zzk();
            iZzz3 = zzfz.zzz(iZzk);
        }
        return i + iZzz + iZzz2 + iZzz3 + iZzk;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzl(com.google.android.gms.internal.play_billing.zzgi r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.play_billing.zzjc r0 = r2.zzb()
            byte[] r1 = com.google.android.gms.internal.play_billing.zzgx.zzb
            r3.getClass()
            com.google.android.gms.internal.play_billing.zzjc r1 = com.google.android.gms.internal.play_billing.zzjc.DOUBLE
            com.google.android.gms.internal.play_billing.zzjd r1 = com.google.android.gms.internal.play_billing.zzjd.INT
            com.google.android.gms.internal.play_billing.zzjd r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r3 instanceof com.google.android.gms.internal.play_billing.zzhu
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof com.google.android.gms.internal.play_billing.zzhe
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof com.google.android.gms.internal.play_billing.zzjv
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r3 instanceof com.google.android.gms.internal.play_billing.zzfs
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r3 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r3 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r3 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r3 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r3 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.play_billing.zzjc r2 = r2.zzb()
            com.google.android.gms.internal.play_billing.zzjd r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgj.zzl(com.google.android.gms.internal.play_billing.zzgi, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgj zzgjVar = new zzgj();
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzgjVar.zzg((zzgi) ((zzij) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzgjVar.zzg((zzgi) entry.getKey(), entry.getValue());
        }
        zzgjVar.zzd = this.zzd;
        return zzgjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgj) {
            return this.zza.equals(((zzgj) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int iZzc = this.zza.zzc();
        int iZzk = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzk += zzk(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzk += zzk((Map.Entry) it.next());
        }
        return iZzk;
    }

    public final Iterator zze() {
        return this.zza.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzhc(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzf() {
        if (this.zzc) {
            return;
        }
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = this.zza.zzg(i).getValue();
            if (value instanceof zzgs) {
                ((zzgs) value).zzv();
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzgs) {
                ((zzgs) value2).zzv();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzg(zzgi zzgiVar, Object obj) {
        if (!zzgiVar.zze()) {
            zzl(zzgiVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzl(zzgiVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzhe) {
            this.zzd = true;
        }
        this.zza.put(zzgiVar, obj);
    }

    public final boolean zzh() {
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzi(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zzi((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzgj(boolean z) {
        zzf();
        zzf();
    }
}
