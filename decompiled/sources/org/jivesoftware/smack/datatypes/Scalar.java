package org.jivesoftware.smack.datatypes;

import org.jivesoftware.smack.util.DefaultCharSequence;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Scalar extends Number implements DefaultCharSequence {
    private static final long serialVersionUID = 1;
    private final Number number;

    public abstract Scalar getMaxValue();

    public abstract Scalar getMinValue();

    public abstract int hashCode();

    public abstract Scalar incrementedByOne();

    protected Scalar(Number number) {
        this.number = number;
    }

    public final Number number() {
        return this.number;
    }

    @Override // java.lang.Number
    public final int intValue() {
        return this.number.intValue();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return this.number.longValue();
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return this.number.floatValue();
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return this.number.doubleValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Scalar)) {
            return false;
        }
        Scalar scalar = (Scalar) obj;
        return longValue() == scalar.longValue() || doubleValue() == scalar.doubleValue() || floatValue() == scalar.floatValue();
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.number.toString();
    }
}
