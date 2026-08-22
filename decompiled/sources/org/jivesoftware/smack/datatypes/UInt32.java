package org.jivesoftware.smack.datatypes;

import org.jivesoftware.smack.util.NumberUtil;

/* JADX INFO: loaded from: classes10.dex */
public final class UInt32 extends Scalar {
    public static final long MAX_VALUE_LONG = 4294967295L;
    public static final long MIN_VALUE_LONG = 0;
    private static final long serialVersionUID = 1;
    private final long number;
    public static final UInt32 MIN_VALUE = from(4294967295L);
    public static final UInt32 MAX_VALUE = from(4294967295L);

    private UInt32(long j) {
        super(Long.valueOf(NumberUtil.requireUInt32(j)));
        this.number = j;
    }

    public long nativeRepresentation() {
        return this.number;
    }

    public static UInt32 from(long j) {
        return new UInt32(j);
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public int hashCode() {
        long j = this.number;
        return (int) (j ^ (j >>> 32));
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public boolean equals(Object obj) {
        if (obj instanceof UInt32) {
            return this.number == ((UInt32) obj).number;
        }
        return super.equals(obj);
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public UInt32 getMinValue() {
        return MIN_VALUE;
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public UInt32 getMaxValue() {
        return MAX_VALUE;
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public UInt32 incrementedByOne() {
        long j = this.number;
        return from(j < 4294967295L ? j + 1 : 0L);
    }
}
