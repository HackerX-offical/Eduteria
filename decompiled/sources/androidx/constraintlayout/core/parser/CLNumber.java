package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes3.dex */
public class CLNumber extends CLElement {
    float value;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.value = Float.NaN;
    }

    public CLNumber(float f2) {
        super(null);
        this.value = f2;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        float f2 = getFloat();
        int i = (int) f2;
        if (i == f2) {
            return "" + i;
        }
        return "" + f2;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        float f2 = getFloat();
        int i3 = (int) f2;
        if (i3 == f2) {
            sb.append(i3);
        } else {
            sb.append(f2);
        }
        return sb.toString();
    }

    public boolean isInt() {
        float f2 = getFloat();
        return ((float) ((int) f2)) == f2;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.value)) {
            this.value = Integer.parseInt(content());
        }
        return (int) this.value;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.value)) {
            this.value = Float.parseFloat(content());
        }
        return this.value;
    }

    public void putValue(float f2) {
        this.value = f2;
    }
}
