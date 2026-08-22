package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public enum zzjc {
    DOUBLE(zzjd.DOUBLE, 1),
    FLOAT(zzjd.FLOAT, 5),
    INT64(zzjd.LONG, 0),
    UINT64(zzjd.LONG, 0),
    INT32(zzjd.INT, 0),
    FIXED64(zzjd.LONG, 1),
    FIXED32(zzjd.INT, 5),
    BOOL(zzjd.BOOLEAN, 0),
    STRING(zzjd.STRING, 2),
    GROUP(zzjd.MESSAGE, 3),
    MESSAGE(zzjd.MESSAGE, 2),
    BYTES(zzjd.BYTE_STRING, 2),
    UINT32(zzjd.INT, 0),
    ENUM(zzjd.ENUM, 0),
    SFIXED32(zzjd.INT, 5),
    SFIXED64(zzjd.LONG, 1),
    SINT32(zzjd.INT, 0),
    SINT64(zzjd.LONG, 0);

    private final zzjd zzt;

    zzjc(zzjd zzjdVar, int i) {
        this.zzt = zzjdVar;
    }

    public final zzjd zza() {
        return this.zzt;
    }
}
