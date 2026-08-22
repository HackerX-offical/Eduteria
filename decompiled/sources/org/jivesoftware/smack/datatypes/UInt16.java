package org.jivesoftware.smack.datatypes;

import org.jivesoftware.smack.util.NumberUtil;

/* JADX INFO: loaded from: classes10.dex */
public final class UInt16 extends Scalar implements Comparable<UInt16> {
    public static final int MAX_VALUE_INT = 65535;
    public static final int MIN_VALUE_INT = 0;
    private static final long serialVersionUID = 1;
    private final int number;
    public static final UInt16 MIN_VALUE = from(0);
    public static final UInt16 MAX_VALUE = from(65535);

    private UInt16(int i) {
        super(Integer.valueOf(NumberUtil.requireUShort16(i)));
        this.number = i;
    }

    public int nativeRepresentation() {
        return this.number;
    }

    public static UInt16 from(int i) {
        return new UInt16(i);
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public int hashCode() {
        return this.number;
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public boolean equals(Object obj) {
        if (obj instanceof UInt16) {
            return this.number == ((UInt16) obj).number;
        }
        return super.equals(obj);
    }

    @Override // java.lang.Comparable
    public int compareTo(UInt16 uInt16) {
        return Integer.compare(this.number, uInt16.number);
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public UInt16 getMinValue() {
        return MIN_VALUE;
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public UInt16 getMaxValue() {
        return MAX_VALUE;
    }

    @Override // org.jivesoftware.smack.datatypes.Scalar
    public UInt16 incrementedByOne() {
        int i = this.number;
        return from(i < 65535 ? i + 1 : 0);
    }
}
