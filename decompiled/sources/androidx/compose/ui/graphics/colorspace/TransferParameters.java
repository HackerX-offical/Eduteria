package androidx.compose.ui.graphics.colorspace;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TransferParameters.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006("}, d2 = {"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "<init>", "(DDDDDDD)V", "getGamma", "()D", "getA", "getB", "getC", "getD", "getE", "getF", "isHLGish", "", "isHLGish$ui_graphics", "()Z", "isPQish", "isPQish$ui_graphics", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TransferParameters {
    public static final int $stable = 0;
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double gamma;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getGamma() {
        return this.gamma;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getA() {
        return this.a;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getB() {
        return this.b;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getC() {
        return this.c;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getD() {
        return this.d;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getE() {
        return this.e;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final double getF() {
        return this.f;
    }

    public final TransferParameters copy(double gamma, double a2, double b2, double c2, double d2, double e2, double f2) {
        return new TransferParameters(gamma, a2, b2, c2, d2, e2, f2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) other;
        return Double.compare(this.gamma, transferParameters.gamma) == 0 && Double.compare(this.a, transferParameters.a) == 0 && Double.compare(this.b, transferParameters.b) == 0 && Double.compare(this.c, transferParameters.c) == 0 && Double.compare(this.d, transferParameters.d) == 0 && Double.compare(this.e, transferParameters.e) == 0 && Double.compare(this.f, transferParameters.f) == 0;
    }

    public int hashCode() {
        return (((((((((((Double.hashCode(this.gamma) * 31) + Double.hashCode(this.a)) * 31) + Double.hashCode(this.b)) * 31) + Double.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Double.hashCode(this.e)) * 31) + Double.hashCode(this.f);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }

    public TransferParameters(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        this.gamma = d2;
        this.a = d3;
        this.b = d4;
        this.c = d5;
        this.d = d6;
        this.e = d7;
        this.f = d8;
        if (!Double.isNaN(d3) && !Double.isNaN(d4) && !Double.isNaN(d5) && !Double.isNaN(d6) && !Double.isNaN(d7) && !Double.isNaN(d8) && !Double.isNaN(d2)) {
            if (TransferParametersKt.isSpecialG(d2)) {
                return;
            }
            if (d6 < 0.0d || d6 > 1.0d) {
                throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d6);
            }
            if (d6 == 0.0d && (d3 == 0.0d || d2 == 0.0d)) {
                throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
            }
            if (d6 >= 1.0d && d5 == 0.0d) {
                throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
            }
            if ((d3 == 0.0d || d2 == 0.0d) && d5 == 0.0d) {
                throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
            }
            if (d5 < 0.0d) {
                throw new IllegalArgumentException("The transfer function must be increasing");
            }
            if (d3 < 0.0d || d2 < 0.0d) {
                throw new IllegalArgumentException("The transfer function must be positive or increasing");
            }
            return;
        }
        throw new IllegalArgumentException("Parameters cannot be NaN");
    }

    public /* synthetic */ TransferParameters(double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d2, d3, d4, d5, d6, (i & 32) != 0 ? 0.0d : d7, (i & 64) != 0 ? 0.0d : d8);
    }

    public final double getGamma() {
        return this.gamma;
    }

    public final double getA() {
        return this.a;
    }

    public final double getB() {
        return this.b;
    }

    public final double getC() {
        return this.c;
    }

    public final double getD() {
        return this.d;
    }

    public final double getE() {
        return this.e;
    }

    public final double getF() {
        return this.f;
    }

    public final boolean isHLGish$ui_graphics() {
        return this.gamma == -3.0d;
    }

    public final boolean isPQish$ui_graphics() {
        return this.gamma == -2.0d;
    }
}
