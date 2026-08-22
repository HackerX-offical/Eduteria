package org.mozilla.javascript;

import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.Constants;
import com.facebook.AuthenticationTokenClaims;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;
import org.mozilla.javascript.typedarrays.Conversions;

/* JADX INFO: loaded from: classes10.dex */
final class NativeMath extends IdScriptableObject {
    private static final int Id_E = 30;
    private static final int Id_LN10 = 32;
    private static final int Id_LN2 = 33;
    private static final int Id_LOG10E = 35;
    private static final int Id_LOG2E = 34;
    private static final int Id_PI = 31;
    private static final int Id_SQRT1_2 = 36;
    private static final int Id_SQRT2 = 37;
    private static final int Id_abs = 2;
    private static final int Id_acos = 3;
    private static final int Id_asin = 4;
    private static final int Id_atan = 5;
    private static final int Id_atan2 = 6;
    private static final int Id_cbrt = 20;
    private static final int Id_ceil = 7;
    private static final int Id_cos = 8;
    private static final int Id_cosh = 21;
    private static final int Id_exp = 9;
    private static final int Id_expm1 = 22;
    private static final int Id_floor = 10;
    private static final int Id_hypot = 23;
    private static final int Id_imul = 28;
    private static final int Id_log = 11;
    private static final int Id_log10 = 25;
    private static final int Id_log1p = 24;
    private static final int Id_max = 12;
    private static final int Id_min = 13;
    private static final int Id_pow = 14;
    private static final int Id_random = 15;
    private static final int Id_round = 16;
    private static final int Id_sin = 17;
    private static final int Id_sinh = 26;
    private static final int Id_sqrt = 18;
    private static final int Id_tan = 19;
    private static final int Id_tanh = 27;
    private static final int Id_toSource = 1;
    private static final int Id_trunc = 29;
    private static final int LAST_METHOD_ID = 29;
    private static final Object MATH_TAG = "Math";
    private static final int MAX_ID = 37;
    static final long serialVersionUID = -8838847185801131569L;

    static void init(Scriptable scriptable, boolean z) {
        NativeMath nativeMath = new NativeMath();
        nativeMath.activatePrototypeMap(37);
        nativeMath.setPrototype(getObjectPrototype(scriptable));
        nativeMath.setParentScope(scriptable);
        if (z) {
            nativeMath.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "Math", nativeMath, 2);
    }

    private NativeMath() {
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Math";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        double d2;
        String str;
        String str2;
        String str3;
        if (i <= 29) {
            int i2 = 1;
            switch (i) {
                case 1:
                    str2 = "toSource";
                    i2 = 0;
                    str3 = str2;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 2:
                    str3 = "abs";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 3:
                    str3 = "acos";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 4:
                    str3 = "asin";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 5:
                    str3 = "atan";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 6:
                    str3 = "atan2";
                    i2 = 2;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 7:
                    str3 = "ceil";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 8:
                    str3 = "cos";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 9:
                    str3 = AuthenticationTokenClaims.JSON_KEY_EXP;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 10:
                    str3 = "floor";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 11:
                    str3 = "log";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 12:
                    str3 = Constants.PRIORITY_MAX;
                    i2 = 2;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 13:
                    str3 = "min";
                    i2 = 2;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 14:
                    str3 = "pow";
                    i2 = 2;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 15:
                    str2 = "random";
                    i2 = 0;
                    str3 = str2;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 16:
                    str3 = "round";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 17:
                    str3 = "sin";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 18:
                    str3 = "sqrt";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 19:
                    str3 = "tan";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 20:
                    str3 = "cbrt";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 21:
                    str3 = "cosh";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 22:
                    str3 = "expm1";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 23:
                    str3 = "hypot";
                    i2 = 2;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 24:
                    str3 = "log1p";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 25:
                    str3 = "log10";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 26:
                    str3 = "sinh";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 27:
                    str3 = "tanh";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 28:
                    str3 = "imul";
                    i2 = 2;
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                case 29:
                    str3 = "trunc";
                    initPrototypeMethod(MATH_TAG, i, str3, i2);
                    return;
                default:
                    throw new IllegalStateException(String.valueOf(i));
            }
        }
        switch (i) {
            case 30:
                d2 = 2.718281828459045d;
                str = ExifInterface.LONGITUDE_EAST;
                break;
            case 31:
                d2 = 3.141592653589793d;
                str = "PI";
                break;
            case 32:
                d2 = 2.302585092994046d;
                str = "LN10";
                break;
            case 33:
                d2 = 0.6931471805599453d;
                str = "LN2";
                break;
            case 34:
                d2 = 1.4426950408889634d;
                str = "LOG2E";
                break;
            case 35:
                d2 = 0.4342944819032518d;
                str = "LOG10E";
                break;
            case 36:
                d2 = 0.7071067811865476d;
                str = "SQRT1_2";
                break;
            case 37:
                d2 = 1.4142135623730951d;
                str = "SQRT2";
                break;
            default:
                throw new IllegalStateException(String.valueOf(i));
        }
        initPrototypeValue(i, str, ScriptRuntime.wrapNumber(d2), 7);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number;
        double dMin;
        if (!idFunctionObject.hasTag(MATH_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        double dAtan = Double.NaN;
        int i = 0;
        switch (iMethodId) {
            case 1:
                return "Math";
            case 2:
                number = ScriptRuntime.toNumber(objArr, 0);
                if (number != 0.0d) {
                    if (number < 0.0d) {
                        number = -number;
                    }
                    dAtan = number;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = 0.0d;
                return ScriptRuntime.wrapNumber(dAtan);
            case 3:
            case 4:
                double number2 = ScriptRuntime.toNumber(objArr, 0);
                if (number2 == number2 && -1.0d <= number2 && number2 <= 1.0d) {
                    number = iMethodId == 3 ? Math.acos(number2) : Math.asin(number2);
                    dAtan = number;
                }
                return ScriptRuntime.wrapNumber(dAtan);
            case 5:
                dAtan = Math.atan(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 6:
                dAtan = Math.atan2(ScriptRuntime.toNumber(objArr, 0), ScriptRuntime.toNumber(objArr, 1));
                return ScriptRuntime.wrapNumber(dAtan);
            case 7:
                dAtan = Math.ceil(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 8:
                double number3 = ScriptRuntime.toNumber(objArr, 0);
                if (number3 != Double.POSITIVE_INFINITY && number3 != Double.NEGATIVE_INFINITY) {
                    number = Math.cos(number3);
                    dAtan = number;
                }
                return ScriptRuntime.wrapNumber(dAtan);
            case 9:
                number = ScriptRuntime.toNumber(objArr, 0);
                if (number != Double.POSITIVE_INFINITY) {
                    if (number != Double.NEGATIVE_INFINITY) {
                        number = Math.exp(number);
                    }
                    dAtan = 0.0d;
                    return ScriptRuntime.wrapNumber(dAtan);
                }
                dAtan = number;
                return ScriptRuntime.wrapNumber(dAtan);
            case 10:
                dAtan = Math.floor(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 11:
                double number4 = ScriptRuntime.toNumber(objArr, 0);
                if (number4 >= 0.0d) {
                    number = Math.log(number4);
                    dAtan = number;
                }
                return ScriptRuntime.wrapNumber(dAtan);
            case 12:
            case 13:
                double d2 = iMethodId != 12 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
                while (true) {
                    if (i != objArr.length) {
                        dAtan = ScriptRuntime.toNumber(objArr[i]);
                        if (dAtan == dAtan) {
                            if (iMethodId == 12) {
                                dMin = Math.max(d2, dAtan);
                            } else {
                                dMin = Math.min(d2, dAtan);
                            }
                            d2 = dMin;
                            i++;
                        }
                    } else {
                        dAtan = d2;
                    }
                }
                return ScriptRuntime.wrapNumber(dAtan);
            case 14:
                dAtan = js_pow(ScriptRuntime.toNumber(objArr, 0), ScriptRuntime.toNumber(objArr, 1));
                return ScriptRuntime.wrapNumber(dAtan);
            case 15:
                dAtan = Math.random();
                return ScriptRuntime.wrapNumber(dAtan);
            case 16:
                dAtan = ScriptRuntime.toNumber(objArr, 0);
                if (dAtan == dAtan && dAtan != Double.POSITIVE_INFINITY && dAtan != Double.NEGATIVE_INFINITY) {
                    long jRound = Math.round(dAtan);
                    if (jRound != 0) {
                        number = jRound;
                    } else if (dAtan < 0.0d) {
                        number = ScriptRuntime.negativeZero;
                    } else if (dAtan != 0.0d) {
                        dAtan = 0.0d;
                    }
                    dAtan = number;
                }
                return ScriptRuntime.wrapNumber(dAtan);
            case 17:
                double number5 = ScriptRuntime.toNumber(objArr, 0);
                if (number5 != Double.POSITIVE_INFINITY && number5 != Double.NEGATIVE_INFINITY) {
                    number = Math.sin(number5);
                    dAtan = number;
                }
                return ScriptRuntime.wrapNumber(dAtan);
            case 18:
                dAtan = Math.sqrt(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 19:
                dAtan = Math.tan(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 20:
                dAtan = Math.cbrt(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 21:
                dAtan = Math.cosh(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 22:
                dAtan = Math.expm1(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 23:
                dAtan = js_hypot(objArr);
                return ScriptRuntime.wrapNumber(dAtan);
            case 24:
                dAtan = Math.log1p(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 25:
                dAtan = Math.log10(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 26:
                dAtan = Math.sinh(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 27:
                dAtan = Math.tanh(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            case 28:
                return js_imul(objArr);
            case 29:
                dAtan = js_trunc(ScriptRuntime.toNumber(objArr, 0));
                return ScriptRuntime.wrapNumber(dAtan);
            default:
                throw new IllegalStateException(String.valueOf(iMethodId));
        }
    }

    private double js_pow(double d2, double d3) {
        if (d3 != d3) {
            return d3;
        }
        if (d3 == 0.0d) {
            return 1.0d;
        }
        if (d2 == 0.0d) {
            if (1.0d / d2 > 0.0d) {
                return d3 > 0.0d ? 0.0d : Double.POSITIVE_INFINITY;
            }
            long j = (long) d3;
            return (((double) j) != d3 || (j & 1) == 0) ? d3 > 0.0d ? 0.0d : Double.POSITIVE_INFINITY : d3 > 0.0d ? -0.0d : Double.NEGATIVE_INFINITY;
        }
        double dPow = Math.pow(d2, d3);
        if (dPow != dPow) {
            if (d3 == Double.POSITIVE_INFINITY) {
                if (d2 < -1.0d || 1.0d < d2) {
                    return Double.POSITIVE_INFINITY;
                }
                if (-1.0d < d2 && d2 < 1.0d) {
                    return 0.0d;
                }
            } else if (d3 == Double.NEGATIVE_INFINITY) {
                if (d2 < -1.0d || 1.0d < d2) {
                    return 0.0d;
                }
                if (-1.0d < d2 && d2 < 1.0d) {
                    return Double.POSITIVE_INFINITY;
                }
            } else {
                if (d2 == Double.POSITIVE_INFINITY) {
                    return d3 > 0.0d ? Double.POSITIVE_INFINITY : 0.0d;
                }
                if (d2 == Double.NEGATIVE_INFINITY) {
                    long j2 = (long) d3;
                    return (((double) j2) != d3 || (j2 & 1) == 0) ? d3 > 0.0d ? Double.POSITIVE_INFINITY : 0.0d : d3 > 0.0d ? Double.NEGATIVE_INFINITY : -0.0d;
                }
            }
        }
        return dPow;
    }

    private double js_hypot(Object[] objArr) {
        double d2 = 0.0d;
        if (objArr == null) {
            return 0.0d;
        }
        for (Object obj : objArr) {
            double number = ScriptRuntime.toNumber(obj);
            if (number == ScriptRuntime.NaN) {
                return number;
            }
            if (number == Double.POSITIVE_INFINITY || number == Double.NEGATIVE_INFINITY) {
                return Double.POSITIVE_INFINITY;
            }
            d2 += number * number;
        }
        return Math.sqrt(d2);
    }

    private double js_trunc(double d2) {
        return d2 < 0.0d ? Math.ceil(d2) : Math.floor(d2);
    }

    private Object js_imul(Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            return ScriptRuntime.wrapNumber(ScriptRuntime.NaN);
        }
        long uint32 = (Conversions.toUint32(objArr[0]) * Conversions.toUint32(objArr[1])) % Conversions.THIRTYTWO_BIT;
        if (uint32 >= CacheValidityPolicy.MAX_AGE) {
            uint32 -= Conversions.THIRTYTWO_BIT;
        }
        return Double.valueOf(ScriptRuntime.toNumber(Long.valueOf(uint32)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01df A[ADDED_TO_REGION] */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findPrototypeId(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.findPrototypeId(java.lang.String):int");
    }
}
