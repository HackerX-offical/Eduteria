package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public enum zzhy {
    DOUBLE(0, zzia.SCALAR, zzir.DOUBLE),
    FLOAT(1, zzia.SCALAR, zzir.FLOAT),
    INT64(2, zzia.SCALAR, zzir.LONG),
    UINT64(3, zzia.SCALAR, zzir.LONG),
    INT32(4, zzia.SCALAR, zzir.INT),
    FIXED64(5, zzia.SCALAR, zzir.LONG),
    FIXED32(6, zzia.SCALAR, zzir.INT),
    BOOL(7, zzia.SCALAR, zzir.BOOLEAN),
    STRING(8, zzia.SCALAR, zzir.STRING),
    MESSAGE(9, zzia.SCALAR, zzir.MESSAGE),
    BYTES(10, zzia.SCALAR, zzir.BYTE_STRING),
    UINT32(11, zzia.SCALAR, zzir.INT),
    ENUM(12, zzia.SCALAR, zzir.ENUM),
    SFIXED32(13, zzia.SCALAR, zzir.INT),
    SFIXED64(14, zzia.SCALAR, zzir.LONG),
    SINT32(15, zzia.SCALAR, zzir.INT),
    SINT64(16, zzia.SCALAR, zzir.LONG),
    GROUP(17, zzia.SCALAR, zzir.MESSAGE),
    DOUBLE_LIST(18, zzia.VECTOR, zzir.DOUBLE),
    FLOAT_LIST(19, zzia.VECTOR, zzir.FLOAT),
    INT64_LIST(20, zzia.VECTOR, zzir.LONG),
    UINT64_LIST(21, zzia.VECTOR, zzir.LONG),
    INT32_LIST(22, zzia.VECTOR, zzir.INT),
    FIXED64_LIST(23, zzia.VECTOR, zzir.LONG),
    FIXED32_LIST(24, zzia.VECTOR, zzir.INT),
    BOOL_LIST(25, zzia.VECTOR, zzir.BOOLEAN),
    STRING_LIST(26, zzia.VECTOR, zzir.STRING),
    MESSAGE_LIST(27, zzia.VECTOR, zzir.MESSAGE),
    BYTES_LIST(28, zzia.VECTOR, zzir.BYTE_STRING),
    UINT32_LIST(29, zzia.VECTOR, zzir.INT),
    ENUM_LIST(30, zzia.VECTOR, zzir.ENUM),
    SFIXED32_LIST(31, zzia.VECTOR, zzir.INT),
    SFIXED64_LIST(32, zzia.VECTOR, zzir.LONG),
    SINT32_LIST(33, zzia.VECTOR, zzir.INT),
    SINT64_LIST(34, zzia.VECTOR, zzir.LONG),
    DOUBLE_LIST_PACKED(35, zzia.PACKED_VECTOR, zzir.DOUBLE),
    FLOAT_LIST_PACKED(36, zzia.PACKED_VECTOR, zzir.FLOAT),
    INT64_LIST_PACKED(37, zzia.PACKED_VECTOR, zzir.LONG),
    UINT64_LIST_PACKED(38, zzia.PACKED_VECTOR, zzir.LONG),
    INT32_LIST_PACKED(39, zzia.PACKED_VECTOR, zzir.INT),
    FIXED64_LIST_PACKED(40, zzia.PACKED_VECTOR, zzir.LONG),
    FIXED32_LIST_PACKED(41, zzia.PACKED_VECTOR, zzir.INT),
    BOOL_LIST_PACKED(42, zzia.PACKED_VECTOR, zzir.BOOLEAN),
    UINT32_LIST_PACKED(43, zzia.PACKED_VECTOR, zzir.INT),
    ENUM_LIST_PACKED(44, zzia.PACKED_VECTOR, zzir.ENUM),
    SFIXED32_LIST_PACKED(45, zzia.PACKED_VECTOR, zzir.INT),
    SFIXED64_LIST_PACKED(46, zzia.PACKED_VECTOR, zzir.LONG),
    SINT32_LIST_PACKED(47, zzia.PACKED_VECTOR, zzir.INT),
    SINT64_LIST_PACKED(48, zzia.PACKED_VECTOR, zzir.LONG),
    GROUP_LIST(49, zzia.VECTOR, zzir.MESSAGE),
    MAP(50, zzia.MAP, zzir.VOID);

    private static final zzhy[] zzbe;
    private static final Type[] zzbf = new Type[0];
    private final zzir zzaz;
    private final int zzba;
    private final zzia zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    zzhy(int i, zzia zziaVar, zzir zzirVar) {
        int i2;
        this.zzba = i;
        this.zzbb = zziaVar;
        this.zzaz = zzirVar;
        int i3 = zzib.zza[zziaVar.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this.zzbc = zzirVar.zza();
        } else {
            this.zzbc = null;
        }
        this.zzbd = (zziaVar != zzia.SCALAR || (i2 = zzib.zzb[zzirVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        zzhy[] zzhyVarArrValues = values();
        zzbe = new zzhy[zzhyVarArrValues.length];
        for (zzhy zzhyVar : zzhyVarArrValues) {
            zzbe[zzhyVar.zzba] = zzhyVar;
        }
    }
}
