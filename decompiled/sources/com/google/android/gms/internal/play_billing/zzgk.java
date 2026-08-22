package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public enum zzgk {
    DOUBLE(0, 1, zzha.DOUBLE),
    FLOAT(1, 1, zzha.FLOAT),
    INT64(2, 1, zzha.LONG),
    UINT64(3, 1, zzha.LONG),
    INT32(4, 1, zzha.INT),
    FIXED64(5, 1, zzha.LONG),
    FIXED32(6, 1, zzha.INT),
    BOOL(7, 1, zzha.BOOLEAN),
    STRING(8, 1, zzha.STRING),
    MESSAGE(9, 1, zzha.MESSAGE),
    BYTES(10, 1, zzha.BYTE_STRING),
    UINT32(11, 1, zzha.INT),
    ENUM(12, 1, zzha.ENUM),
    SFIXED32(13, 1, zzha.INT),
    SFIXED64(14, 1, zzha.LONG),
    SINT32(15, 1, zzha.INT),
    SINT64(16, 1, zzha.LONG),
    GROUP(17, 1, zzha.MESSAGE),
    DOUBLE_LIST(18, 2, zzha.DOUBLE),
    FLOAT_LIST(19, 2, zzha.FLOAT),
    INT64_LIST(20, 2, zzha.LONG),
    UINT64_LIST(21, 2, zzha.LONG),
    INT32_LIST(22, 2, zzha.INT),
    FIXED64_LIST(23, 2, zzha.LONG),
    FIXED32_LIST(24, 2, zzha.INT),
    BOOL_LIST(25, 2, zzha.BOOLEAN),
    STRING_LIST(26, 2, zzha.STRING),
    MESSAGE_LIST(27, 2, zzha.MESSAGE),
    BYTES_LIST(28, 2, zzha.BYTE_STRING),
    UINT32_LIST(29, 2, zzha.INT),
    ENUM_LIST(30, 2, zzha.ENUM),
    SFIXED32_LIST(31, 2, zzha.INT),
    SFIXED64_LIST(32, 2, zzha.LONG),
    SINT32_LIST(33, 2, zzha.INT),
    SINT64_LIST(34, 2, zzha.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzha.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzha.FLOAT),
    INT64_LIST_PACKED(37, 3, zzha.LONG),
    UINT64_LIST_PACKED(38, 3, zzha.LONG),
    INT32_LIST_PACKED(39, 3, zzha.INT),
    FIXED64_LIST_PACKED(40, 3, zzha.LONG),
    FIXED32_LIST_PACKED(41, 3, zzha.INT),
    BOOL_LIST_PACKED(42, 3, zzha.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzha.INT),
    ENUM_LIST_PACKED(44, 3, zzha.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzha.INT),
    SFIXED64_LIST_PACKED(46, 3, zzha.LONG),
    SINT32_LIST_PACKED(47, 3, zzha.INT),
    SINT64_LIST_PACKED(48, 3, zzha.LONG),
    GROUP_LIST(49, 2, zzha.MESSAGE),
    MAP(50, 4, zzha.VOID);

    private static final zzgk[] zzZ;
    private final int zzab;

    static {
        zzgk[] zzgkVarArrValues = values();
        zzZ = new zzgk[zzgkVarArrValues.length];
        for (zzgk zzgkVar : zzgkVarArrValues) {
            zzZ[zzgkVar.zzab] = zzgkVar;
        }
    }

    zzgk(int i, int i2, zzha zzhaVar) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzhaVar.zza();
        }
        if (i2 == 1) {
            zzha zzhaVar2 = zzha.VOID;
            zzhaVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
