package kotlin.math;

import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import org.jivesoftware.smackx.ox.element.SignElement;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MathJVM.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0006\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0019\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0018\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010#\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u00012\u0006\u0010&\u001a\u00020'H\u0087\b\u001a\u0015\u0010(\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0001H\u0087\b\u001a\u0015\u00101\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\b\u001a\u0015\u00101\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001f\u001a\u00020'H\u0087\b\u001a\r\u00105\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u00106\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u00107\u001a\u00020\u0001*\u00020\u00012\u0006\u00108\u001a\u00020\u0001H\u0087\b\u001a\f\u00109\u001a\u00020'*\u00020\u0001H\u0007\u001a\f\u0010:\u001a\u00020;*\u00020\u0001H\u0007\u001a\u0011\u0010\u0000\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0003\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0004\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0005\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0006\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0019\u0010\b\u001a\u00020<2\u0006\u0010\t\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\n\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u000b\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\f\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\r\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u000e\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0019\u0010\u0010\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<2\u0006\u0010\t\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0011\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0012\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0013\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0018\u0010\u0014\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020<H\u0007\u001a\u0011\u0010\u0016\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u0017\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0010\u0010\u0018\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0007\u001a\u0011\u0010\u0019\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u001a\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0007\u001a\u0011\u0010\u001d\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0011\u0010\u001f\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0019\u0010 \u001a\u00020<2\u0006\u0010!\u001a\u00020<2\u0006\u0010\"\u001a\u00020<H\u0087\b\u001a\u0019\u0010#\u001a\u00020<2\u0006\u0010!\u001a\u00020<2\u0006\u0010\"\u001a\u00020<H\u0087\b\u001a\u0011\u0010$\u001a\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0015\u0010%\u001a\u00020<*\u00020<2\u0006\u0010\u0002\u001a\u00020<H\u0087\b\u001a\u0015\u0010%\u001a\u00020<*\u00020<2\u0006\u0010&\u001a\u00020'H\u0087\b\u001a\u0015\u0010(\u001a\u00020<*\u00020<2\u0006\u0010)\u001a\u00020<H\u0087\b\u001a\u0015\u00101\u001a\u00020<*\u00020<2\u0006\u0010\u001f\u001a\u00020<H\u0087\b\u001a\u0015\u00101\u001a\u00020<*\u00020<2\u0006\u0010\u001f\u001a\u00020'H\u0087\b\u001a\r\u00105\u001a\u00020<*\u00020<H\u0087\b\u001a\r\u00106\u001a\u00020<*\u00020<H\u0087\b\u001a\u0015\u00107\u001a\u00020<*\u00020<2\u0006\u00108\u001a\u00020<H\u0087\b\u001a\f\u00109\u001a\u00020'*\u00020<H\u0007\u001a\f\u0010:\u001a\u00020;*\u00020<H\u0007\u001a\u0011\u0010\u001e\u001a\u00020'2\u0006\u0010&\u001a\u00020'H\u0087\b\u001a\u0019\u0010 \u001a\u00020'2\u0006\u0010!\u001a\u00020'2\u0006\u0010\"\u001a\u00020'H\u0087\b\u001a\u0019\u0010#\u001a\u00020'2\u0006\u0010!\u001a\u00020'2\u0006\u0010\"\u001a\u00020'H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020;2\u0006\u0010&\u001a\u00020;H\u0087\b\u001a\u0019\u0010 \u001a\u00020;2\u0006\u0010!\u001a\u00020;2\u0006\u0010\"\u001a\u00020;H\u0087\b\u001a\u0019\u0010#\u001a\u00020;2\u0006\u0010!\u001a\u00020;2\u0006\u0010\"\u001a\u00020;H\u0087\b\"\u001f\u0010*\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u001f\u0010\u001f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010,\u001a\u0004\b0\u0010.\"\u001f\u00102\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010,\u001a\u0004\b4\u0010.\"\u001f\u0010*\u001a\u00020<*\u00020<8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010=\u001a\u0004\b-\u0010>\"\u001f\u0010\u001f\u001a\u00020<*\u00020<8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010=\u001a\u0004\b0\u0010>\"\u001f\u00102\u001a\u00020<*\u00020<8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010=\u001a\u0004\b4\u0010>\"\u001f\u0010*\u001a\u00020'*\u00020'8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010?\u001a\u0004\b-\u0010@\"\u001e\u0010\u001f\u001a\u00020'*\u00020'8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010?\u001a\u0004\b0\u0010@\"\u001f\u0010*\u001a\u00020;*\u00020;8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010A\u001a\u0004\b-\u0010B\"\u001e\u0010\u001f\u001a\u00020'*\u00020;8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010A\u001a\u0004\b0\u0010C¨\u0006D"}, d2 = {"sin", "", "x", "cos", "tan", "asin", "acos", "atan", "atan2", "y", "sinh", "cosh", "tanh", "asinh", "acosh", "atanh", "hypot", "sqrt", AuthenticationTokenClaims.JSON_KEY_EXP, "expm1", "log", "base", UserDataStore.LAST_NAME, "log10", "log2", "ln1p", "ceil", "floor", "truncate", "round", "abs", SignElement.ELEMENT, "min", "a", "b", com.clevertap.android.sdk.Constants.PRIORITY_MAX, "cbrt", "pow", CTProductConfigConstants.PRODUCT_CONFIG_JSON_KEY_FOR_KEY, "", "IEEErem", "divisor", "absoluteValue", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "getSign$annotations", "getSign", "withSign", "ulp", "getUlp$annotations", "getUlp", "nextUp", "nextDown", "nextTowards", "to", "roundToInt", "roundToLong", "", "", "(F)V", "(F)F", "(I)V", "(I)I", "(J)V", "(J)J", "(J)I", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/math/MathKt")
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static /* synthetic */ void getAbsoluteValue$annotations(double d2) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(float f2) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(int i) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    public static /* synthetic */ void getSign$annotations(double d2) {
    }

    public static /* synthetic */ void getSign$annotations(float f2) {
    }

    public static /* synthetic */ void getSign$annotations(int i) {
    }

    public static /* synthetic */ void getSign$annotations(long j) {
    }

    public static /* synthetic */ void getUlp$annotations(double d2) {
    }

    public static /* synthetic */ void getUlp$annotations(float f2) {
    }

    private static final double sin(double d2) {
        return Math.sin(d2);
    }

    private static final double cos(double d2) {
        return Math.cos(d2);
    }

    private static final double tan(double d2) {
        return Math.tan(d2);
    }

    private static final double asin(double d2) {
        return Math.asin(d2);
    }

    private static final double acos(double d2) {
        return Math.acos(d2);
    }

    private static final double atan(double d2) {
        return Math.atan(d2);
    }

    private static final double atan2(double d2, double d3) {
        return Math.atan2(d2, d3);
    }

    private static final double sinh(double d2) {
        return Math.sinh(d2);
    }

    private static final double cosh(double d2) {
        return Math.cosh(d2);
    }

    private static final double tanh(double d2) {
        return Math.tanh(d2);
    }

    public static final double asinh(double d2) {
        if (d2 < Constants.taylor_n_bound) {
            return d2 <= (-Constants.taylor_n_bound) ? -MathKt.asinh(-d2) : Math.abs(d2) >= Constants.taylor_2_bound ? d2 - (((d2 * d2) * d2) / ((double) 6)) : d2;
        }
        if (d2 <= Constants.upper_taylor_n_bound) {
            return Math.log(d2 + Math.sqrt((d2 * d2) + ((double) 1)));
        }
        if (d2 > Constants.upper_taylor_2_bound) {
            return Math.log(d2) + Constants.LN2;
        }
        double d3 = d2 * ((double) 2);
        return Math.log(d3 + (((double) 1) / d3));
    }

    public static final double acosh(double d2) {
        if (d2 < 1.0d) {
            return Double.NaN;
        }
        if (d2 > Constants.upper_taylor_2_bound) {
            return Math.log(d2) + Constants.LN2;
        }
        double d3 = 1;
        double d4 = d2 - d3;
        if (d4 >= Constants.taylor_n_bound) {
            return Math.log(d2 + Math.sqrt((d2 * d2) - d3));
        }
        double dSqrt = Math.sqrt(d4);
        if (dSqrt >= Constants.taylor_2_bound) {
            dSqrt -= ((dSqrt * dSqrt) * dSqrt) / ((double) 12);
        }
        return Math.sqrt(2.0d) * dSqrt;
    }

    public static final double atanh(double d2) {
        if (Math.abs(d2) < Constants.taylor_n_bound) {
            return Math.abs(d2) > Constants.taylor_2_bound ? d2 + (((d2 * d2) * d2) / ((double) 3)) : d2;
        }
        double d3 = 1;
        return Math.log((d3 + d2) / (d3 - d2)) / ((double) 2);
    }

    private static final double hypot(double d2, double d3) {
        return Math.hypot(d2, d3);
    }

    private static final double sqrt(double d2) {
        return Math.sqrt(d2);
    }

    private static final double exp(double d2) {
        return Math.exp(d2);
    }

    private static final double expm1(double d2) {
        return Math.expm1(d2);
    }

    public static final double log(double d2, double d3) {
        if (d3 <= 0.0d || d3 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d2) / Math.log(d3);
    }

    private static final double ln(double d2) {
        return Math.log(d2);
    }

    private static final double log10(double d2) {
        return Math.log10(d2);
    }

    public static final double log2(double d2) {
        return Math.log(d2) / Constants.LN2;
    }

    private static final double ln1p(double d2) {
        return Math.log1p(d2);
    }

    private static final double ceil(double d2) {
        return Math.ceil(d2);
    }

    private static final double floor(double d2) {
        return Math.floor(d2);
    }

    public static final double truncate(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            return d2;
        }
        if (d2 > 0.0d) {
            return Math.floor(d2);
        }
        return Math.ceil(d2);
    }

    private static final double round(double d2) {
        return Math.rint(d2);
    }

    private static final double abs(double d2) {
        return Math.abs(d2);
    }

    private static final double sign(double d2) {
        return Math.signum(d2);
    }

    private static final double min(double d2, double d3) {
        return Math.min(d2, d3);
    }

    private static final double max(double d2, double d3) {
        return Math.max(d2, d3);
    }

    private static final double cbrt(double d2) {
        return Math.cbrt(d2);
    }

    private static final double pow(double d2, double d3) {
        return Math.pow(d2, d3);
    }

    private static final double pow(double d2, int i) {
        return Math.pow(d2, i);
    }

    private static final double IEEErem(double d2, double d3) {
        return Math.IEEEremainder(d2, d3);
    }

    private static final double getAbsoluteValue(double d2) {
        return Math.abs(d2);
    }

    private static final double getSign(double d2) {
        return Math.signum(d2);
    }

    private static final double withSign(double d2, double d3) {
        return Math.copySign(d2, d3);
    }

    private static final double withSign(double d2, int i) {
        return Math.copySign(d2, i);
    }

    private static final double getUlp(double d2) {
        return Math.ulp(d2);
    }

    private static final double nextUp(double d2) {
        return Math.nextUp(d2);
    }

    private static final double nextDown(double d2) {
        return Math.nextAfter(d2, Double.NEGATIVE_INFINITY);
    }

    private static final double nextTowards(double d2, double d3) {
        return Math.nextAfter(d2, d3);
    }

    public static final int roundToInt(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d2 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d2 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d2);
    }

    public static final long roundToLong(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d2);
    }

    private static final float sin(float f2) {
        return (float) Math.sin(f2);
    }

    private static final float cos(float f2) {
        return (float) Math.cos(f2);
    }

    private static final float tan(float f2) {
        return (float) Math.tan(f2);
    }

    private static final float asin(float f2) {
        return (float) Math.asin(f2);
    }

    private static final float acos(float f2) {
        return (float) Math.acos(f2);
    }

    private static final float atan(float f2) {
        return (float) Math.atan(f2);
    }

    private static final float atan2(float f2, float f3) {
        return (float) Math.atan2(f2, f3);
    }

    private static final float sinh(float f2) {
        return (float) Math.sinh(f2);
    }

    private static final float cosh(float f2) {
        return (float) Math.cosh(f2);
    }

    private static final float tanh(float f2) {
        return (float) Math.tanh(f2);
    }

    private static final float asinh(float f2) {
        return (float) MathKt.asinh(f2);
    }

    private static final float acosh(float f2) {
        return (float) MathKt.acosh(f2);
    }

    private static final float atanh(float f2) {
        return (float) MathKt.atanh(f2);
    }

    private static final float hypot(float f2, float f3) {
        return (float) Math.hypot(f2, f3);
    }

    private static final float sqrt(float f2) {
        return (float) Math.sqrt(f2);
    }

    private static final float exp(float f2) {
        return (float) Math.exp(f2);
    }

    private static final float expm1(float f2) {
        return (float) Math.expm1(f2);
    }

    public static final float log(float f2, float f3) {
        if (f3 <= 0.0f || f3 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f2) / Math.log(f3));
    }

    private static final float ln(float f2) {
        return (float) Math.log(f2);
    }

    private static final float log10(float f2) {
        return (float) Math.log10(f2);
    }

    public static final float log2(float f2) {
        return (float) (Math.log(f2) / Constants.LN2);
    }

    private static final float ln1p(float f2) {
        return (float) Math.log1p(f2);
    }

    private static final float ceil(float f2) {
        return (float) Math.ceil(f2);
    }

    private static final float floor(float f2) {
        return (float) Math.floor(f2);
    }

    public static final float truncate(float f2) {
        double dCeil;
        if (Float.isNaN(f2) || Float.isInfinite(f2)) {
            return f2;
        }
        if (f2 > 0.0f) {
            dCeil = Math.floor(f2);
        } else {
            dCeil = Math.ceil(f2);
        }
        return (float) dCeil;
    }

    private static final float round(float f2) {
        return (float) Math.rint(f2);
    }

    private static final float abs(float f2) {
        return Math.abs(f2);
    }

    private static final float sign(float f2) {
        return Math.signum(f2);
    }

    private static final float min(float f2, float f3) {
        return Math.min(f2, f3);
    }

    private static final float max(float f2, float f3) {
        return Math.max(f2, f3);
    }

    private static final float cbrt(float f2) {
        return (float) Math.cbrt(f2);
    }

    private static final float pow(float f2, float f3) {
        return (float) Math.pow(f2, f3);
    }

    private static final float pow(float f2, int i) {
        return (float) Math.pow(f2, i);
    }

    private static final float IEEErem(float f2, float f3) {
        return (float) Math.IEEEremainder(f2, f3);
    }

    private static final float getAbsoluteValue(float f2) {
        return Math.abs(f2);
    }

    private static final float getSign(float f2) {
        return Math.signum(f2);
    }

    private static final float withSign(float f2, float f3) {
        return Math.copySign(f2, f3);
    }

    private static final float withSign(float f2, int i) {
        return Math.copySign(f2, i);
    }

    private static final float getUlp(float f2) {
        return Math.ulp(f2);
    }

    private static final float nextUp(float f2) {
        return Math.nextUp(f2);
    }

    private static final float nextDown(float f2) {
        return Math.nextAfter(f2, Double.NEGATIVE_INFINITY);
    }

    private static final float nextTowards(float f2, float f3) {
        return Math.nextAfter(f2, f3);
    }

    public static final int roundToInt(float f2) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f2);
    }

    public static final long roundToLong(float f2) {
        return MathKt.roundToLong(f2);
    }

    private static final int abs(int i) {
        return Math.abs(i);
    }

    private static final int min(int i, int i2) {
        return Math.min(i, i2);
    }

    private static final int max(int i, int i2) {
        return Math.max(i, i2);
    }

    private static final int getAbsoluteValue(int i) {
        return Math.abs(i);
    }

    public static final int getSign(int i) {
        return Integer.signum(i);
    }

    private static final long abs(long j) {
        return Math.abs(j);
    }

    private static final long min(long j, long j2) {
        return Math.min(j, j2);
    }

    private static final long max(long j, long j2) {
        return Math.max(j, j2);
    }

    private static final long getAbsoluteValue(long j) {
        return Math.abs(j);
    }

    public static final int getSign(long j) {
        return Long.signum(j);
    }
}
