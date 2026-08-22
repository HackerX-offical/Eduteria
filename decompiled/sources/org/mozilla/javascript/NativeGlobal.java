package org.mozilla.javascript;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.Serializable;
import okio.Utf8;
import org.mozilla.javascript.xml.XMLLib;

/* JADX INFO: loaded from: classes10.dex */
public class NativeGlobal implements Serializable, IdFunctionCall {
    private static final Object FTAG = "Global";
    private static final int INVALID_UTF8 = Integer.MAX_VALUE;
    private static final int Id_decodeURI = 1;
    private static final int Id_decodeURIComponent = 2;
    private static final int Id_encodeURI = 3;
    private static final int Id_encodeURIComponent = 4;
    private static final int Id_escape = 5;
    private static final int Id_eval = 6;
    private static final int Id_isFinite = 7;
    private static final int Id_isNaN = 8;
    private static final int Id_isXMLName = 9;
    private static final int Id_new_CommonError = 14;
    private static final int Id_parseFloat = 10;
    private static final int Id_parseInt = 11;
    private static final int Id_unescape = 12;
    private static final int Id_uneval = 13;
    private static final int LAST_SCOPE_FUNCTION_ID = 13;
    private static final String URI_DECODE_RESERVED = ";/?:@&=+$,#";
    static final long serialVersionUID = 6080442165748707530L;

    private static int unHex(char c2) {
        if ('A' <= c2 && c2 <= 'F') {
            return c2 - '7';
        }
        if ('a' <= c2 && c2 <= 'f') {
            return c2 - 'W';
        }
        if ('0' > c2 || c2 > '9') {
            return -1;
        }
        return c2 - '0';
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void init(org.mozilla.javascript.Context r11, org.mozilla.javascript.Scriptable r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.init(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, boolean):void");
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG)) {
            int iMethodId = idFunctionObject.methodId();
            switch (iMethodId) {
                case 1:
                case 2:
                    return decode(ScriptRuntime.toString(objArr, 0), iMethodId == 1);
                case 3:
                case 4:
                    return encode(ScriptRuntime.toString(objArr, 0), iMethodId == 3);
                case 5:
                    return js_escape(objArr);
                case 6:
                    return js_eval(context, scriptable, objArr);
                case 7:
                    if (objArr.length < 1) {
                        return Boolean.FALSE;
                    }
                    return NativeNumber.isFinite(objArr[0]);
                case 8:
                    if (objArr.length >= 1) {
                        double number = ScriptRuntime.toNumber(objArr[0]);
                        if (number == number) {
                            z = false;
                        }
                    }
                    return ScriptRuntime.wrapBoolean(z);
                case 9:
                    return ScriptRuntime.wrapBoolean(XMLLib.extractFromScope(scriptable).isXMLName(context, objArr.length == 0 ? Undefined.instance : objArr[0]));
                case 10:
                    return js_parseFloat(objArr);
                case 11:
                    return js_parseInt(objArr);
                case 12:
                    return js_unescape(objArr);
                case 13:
                    return ScriptRuntime.uneval(context, scriptable, objArr.length != 0 ? objArr[0] : Undefined.instance);
                case 14:
                    return NativeError.make(context, scriptable, idFunctionObject, objArr);
            }
        }
        throw idFunctionObject.unknown();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[PHI: r0
      0x002e: PHI (r0v1 boolean) = (r0v0 boolean), (r0v3 boolean) binds: [B:13:0x0025, B:17:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.Object js_parseInt(java.lang.Object[] r11) {
        /*
            r0 = 0
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString(r11, r0)
            r2 = 1
            int r11 = org.mozilla.javascript.ScriptRuntime.toInt32(r11, r2)
            int r3 = r1.length()
            if (r3 != 0) goto L13
            java.lang.Double r11 = org.mozilla.javascript.ScriptRuntime.NaNobj
            return r11
        L13:
            r4 = r0
        L14:
            char r5 = r1.charAt(r4)
            boolean r6 = org.mozilla.javascript.ScriptRuntime.isStrWhiteSpaceChar(r5)
            if (r6 != 0) goto L1f
            goto L23
        L1f:
            int r4 = r4 + 1
            if (r4 < r3) goto L14
        L23:
            r6 = 43
            if (r5 == r6) goto L2e
            r6 = 45
            if (r5 != r6) goto L2c
            r0 = r2
        L2c:
            if (r0 == 0) goto L30
        L2e:
            int r4 = r4 + 1
        L30:
            r5 = 88
            r6 = 120(0x78, float:1.68E-43)
            r7 = 16
            r8 = -1
            r9 = 48
            if (r11 != 0) goto L3d
            r11 = r8
            goto L5d
        L3d:
            r10 = 2
            if (r11 < r10) goto L90
            r10 = 36
            if (r11 <= r10) goto L45
            goto L90
        L45:
            if (r11 != r7) goto L5d
            int r10 = r3 - r4
            if (r10 <= r2) goto L5d
            char r10 = r1.charAt(r4)
            if (r10 != r9) goto L5d
            int r10 = r4 + 1
            char r10 = r1.charAt(r10)
            if (r10 == r6) goto L5b
            if (r10 != r5) goto L5d
        L5b:
            int r4 = r4 + 2
        L5d:
            if (r11 != r8) goto L83
            int r3 = r3 - r4
            if (r3 <= r2) goto L80
            char r11 = r1.charAt(r4)
            if (r11 != r9) goto L80
            int r11 = r4 + 1
            char r2 = r1.charAt(r11)
            if (r2 == r6) goto L7d
            if (r2 != r5) goto L73
            goto L7d
        L73:
            if (r9 > r2) goto L80
            r3 = 57
            if (r2 > r3) goto L80
            r7 = 8
            r4 = r11
            goto L84
        L7d:
            int r4 = r4 + 2
            goto L84
        L80:
            r7 = 10
            goto L84
        L83:
            r7 = r11
        L84:
            double r1 = org.mozilla.javascript.ScriptRuntime.stringPrefixToNumber(r1, r4, r7)
            if (r0 == 0) goto L8b
            double r1 = -r1
        L8b:
            java.lang.Number r11 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r1)
            return r11
        L90:
            java.lang.Double r11 = org.mozilla.javascript.ScriptRuntime.NaNobj
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.js_parseInt(java.lang.Object[]):java.lang.Object");
    }

    static Object js_parseFloat(Object[] objArr) {
        int i;
        if (objArr.length < 1) {
            return ScriptRuntime.NaNobj;
        }
        boolean z = false;
        String string = ScriptRuntime.toString(objArr[0]);
        int length = string.length();
        for (int i2 = 0; i2 != length; i2++) {
            char cCharAt = string.charAt(i2);
            if (!ScriptRuntime.isStrWhiteSpaceChar(cCharAt)) {
                if (cCharAt == '+' || cCharAt == '-') {
                    int i3 = i2 + 1;
                    if (i3 == length) {
                        return ScriptRuntime.NaNobj;
                    }
                    i = i3;
                    cCharAt = string.charAt(i3);
                } else {
                    i = i2;
                }
                if (cCharAt == 'I') {
                    if (i + 8 <= length && string.regionMatches(i, "Infinity", 0, 8)) {
                        return ScriptRuntime.wrapNumber(string.charAt(i2) == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                    }
                    return ScriptRuntime.NaNobj;
                }
                int i4 = -1;
                int i5 = -1;
                while (true) {
                    if (i < length) {
                        char cCharAt2 = string.charAt(i);
                        if (cCharAt2 != '+') {
                            if (cCharAt2 == 'E' || cCharAt2 == 'e') {
                                if (i4 == -1 && i != length - 1) {
                                    i4 = i;
                                    i++;
                                }
                            } else if (cCharAt2 != '-') {
                                if (cCharAt2 != '.') {
                                    switch (cCharAt2) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            if (i4 != -1) {
                                                z = true;
                                            }
                                            break;
                                    }
                                    i++;
                                } else if (i5 == -1) {
                                    i5 = i;
                                    i++;
                                }
                            }
                        }
                        if (i4 == i - 1) {
                            if (i == length - 1) {
                                i--;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                if (i4 == -1 || z) {
                    i4 = i;
                }
                try {
                    return Double.valueOf(string.substring(i2, i4));
                } catch (NumberFormatException unused) {
                    return ScriptRuntime.NaNobj;
                }
            }
        }
        return ScriptRuntime.NaNobj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if ((r12 & (-8)) == 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object js_escape(java.lang.Object[] r12) {
        /*
            r11 = this;
            r0 = 0
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString(r12, r0)
            int r2 = r12.length
            r3 = 1
            if (r2 <= r3) goto L25
            r12 = r12[r3]
            double r4 = org.mozilla.javascript.ScriptRuntime.toNumber(r12)
            int r12 = (r4 > r4 ? 1 : (r4 == r4 ? 0 : -1))
            if (r12 != 0) goto L1e
            int r12 = (int) r4
            double r6 = (double) r12
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 != 0) goto L1e
            r2 = r12 & (-8)
            if (r2 != 0) goto L1e
            goto L26
        L1e:
            java.lang.String r12 = "msg.bad.esc.mask"
            org.mozilla.javascript.EvaluatorException r12 = org.mozilla.javascript.Context.reportRuntimeError0(r12)
            throw r12
        L25:
            r12 = 7
        L26:
            int r2 = r1.length()
            r4 = 0
        L2b:
            if (r0 == r2) goto Lbc
            char r5 = r1.charAt(r0)
            r6 = 43
            if (r12 == 0) goto L72
            r7 = 48
            if (r5 < r7) goto L3d
            r7 = 57
            if (r5 <= r7) goto L6b
        L3d:
            r7 = 65
            if (r5 < r7) goto L45
            r7 = 90
            if (r5 <= r7) goto L6b
        L45:
            r7 = 97
            if (r5 < r7) goto L4d
            r7 = 122(0x7a, float:1.71E-43)
            if (r5 <= r7) goto L6b
        L4d:
            r7 = 64
            if (r5 == r7) goto L6b
            r7 = 42
            if (r5 == r7) goto L6b
            r7 = 95
            if (r5 == r7) goto L6b
            r7 = 45
            if (r5 == r7) goto L6b
            r7 = 46
            if (r5 == r7) goto L6b
            r7 = r12 & 4
            if (r7 == 0) goto L72
            r7 = 47
            if (r5 == r7) goto L6b
            if (r5 != r6) goto L72
        L6b:
            if (r4 == 0) goto Lb8
            char r5 = (char) r5
            r4.append(r5)
            goto Lb8
        L72:
            if (r4 != 0) goto L81
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r7 = r2 + 3
            r4.<init>(r7)
            r4.append(r1)
            r4.setLength(r0)
        L81:
            r7 = 256(0x100, float:3.59E-43)
            r8 = 37
            r9 = 4
            if (r5 >= r7) goto L97
            r7 = 32
            r10 = 2
            if (r5 != r7) goto L93
            if (r12 != r10) goto L93
            r4.append(r6)
            goto Lb8
        L93:
            r4.append(r8)
            goto La0
        L97:
            r4.append(r8)
            r6 = 117(0x75, float:1.64E-43)
            r4.append(r6)
            r10 = r9
        La0:
            int r10 = r10 - r3
            int r10 = r10 * r9
        La2:
            if (r10 < 0) goto Lb8
            int r6 = r5 >> r10
            r6 = r6 & 15
            r7 = 10
            if (r6 >= r7) goto Laf
            int r6 = r6 + 48
            goto Lb1
        Laf:
            int r6 = r6 + 55
        Lb1:
            char r6 = (char) r6
            r4.append(r6)
            int r10 = r10 + (-4)
            goto La2
        Lb8:
            int r0 = r0 + 1
            goto L2b
        Lbc:
            if (r4 != 0) goto Lbf
            return r1
        Lbf:
            java.lang.String r12 = r4.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.js_escape(java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object js_unescape(java.lang.Object[] r11) {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r11 = org.mozilla.javascript.ScriptRuntime.toString(r11, r0)
            r1 = 37
            int r2 = r11.indexOf(r1)
            if (r2 < 0) goto L4c
            int r3 = r11.length()
            char[] r11 = r11.toCharArray()
            r4 = r2
        L16:
            if (r2 == r3) goto L46
            char r5 = r11[r2]
            int r6 = r2 + 1
            if (r5 != r1) goto L40
            if (r6 == r3) goto L40
            char r7 = r11[r6]
            r8 = 117(0x75, float:1.64E-43)
            if (r7 != r8) goto L2b
            int r7 = r2 + 2
            int r2 = r2 + 6
            goto L2e
        L2b:
            int r2 = r2 + 3
            r7 = r6
        L2e:
            if (r2 > r3) goto L40
            r8 = r0
        L31:
            if (r7 == r2) goto L3c
            char r9 = r11[r7]
            int r8 = org.mozilla.javascript.Kit.xDigitToInt(r9, r8)
            int r7 = r7 + 1
            goto L31
        L3c:
            if (r8 < 0) goto L40
            char r5 = (char) r8
            goto L41
        L40:
            r2 = r6
        L41:
            r11[r4] = r5
            int r4 = r4 + 1
            goto L16
        L46:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r11, r0, r4)
            return r1
        L4c:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.js_unescape(java.lang.Object[]):java.lang.Object");
    }

    private Object js_eval(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        return ScriptRuntime.evalSpecial(context, topLevelScope, topLevelScope, objArr, "eval code", 1);
    }

    static boolean isEvalFunction(Object obj) {
        if (!(obj instanceof IdFunctionObject)) {
            return false;
        }
        IdFunctionObject idFunctionObject = (IdFunctionObject) obj;
        return idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 6;
    }

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable) {
        return ScriptRuntime.constructError(str, str2);
    }

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable, String str3, int i, int i2, String str4) {
        return ScriptRuntime.constructError(str, str2, str3, i, str4, i2);
    }

    private static String encode(String str, boolean z) {
        int length = str.length();
        StringBuilder sb = null;
        byte[] bArr = null;
        int i = 0;
        while (i != length) {
            char cCharAt = str.charAt(i);
            sb = sb;
            if (!encodeUnescaped(cCharAt, z)) {
                if (sb == null) {
                    StringBuilder sb2 = new StringBuilder(length + 3);
                    sb2.append(str);
                    sb2.setLength(i);
                    bArr = new byte[6];
                    sb = sb2;
                }
                if (56320 <= cCharAt && cCharAt <= 57343) {
                    throw uriError();
                }
                int i2 = cCharAt;
                if (cCharAt >= 55296) {
                    i2 = cCharAt;
                    if (56319 >= cCharAt) {
                        i++;
                        if (i == length) {
                            throw uriError();
                        }
                        char cCharAt2 = str.charAt(i);
                        if (56320 > cCharAt2 || cCharAt2 > 57343) {
                            throw uriError();
                        }
                        i2 = ((cCharAt - 55296) << 10) + (cCharAt2 - Utf8.LOG_SURROGATE_HEADER) + 65536;
                    }
                }
                int iOneUcs4ToUtf8Char = oneUcs4ToUtf8Char(bArr, i2);
                for (int i3 = 0; i3 < iOneUcs4ToUtf8Char; i3++) {
                    byte b2 = bArr[i3];
                    sb.append('%');
                    sb.append(toHexChar((b2 & 255) >>> 4));
                    sb.append(toHexChar(b2 & Ascii.SI));
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i++;
            sb = sb;
        }
        return sb == null ? str : sb.toString();
    }

    private static char toHexChar(int i) {
        if ((i >> 4) != 0) {
            Kit.codeBug();
        }
        return (char) (i < 10 ? i + 48 : i + 55);
    }

    private static int unHex(char c2, char c3) {
        int iUnHex = unHex(c2);
        int iUnHex2 = unHex(c3);
        if (iUnHex < 0 || iUnHex2 < 0) {
            return -1;
        }
        return (iUnHex << 4) | iUnHex2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[PHI: r6 r8
      0x0040: PHI (r6v5 int) = (r6v1 int), (r6v2 int) binds: [B:16:0x003e, B:62:0x00d0] A[DONT_GENERATE, DONT_INLINE]
      0x0040: PHI (r8v22 int) = (r8v2 int), (r8v10 int) binds: [B:16:0x003e, B:62:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String decode(java.lang.String r16, boolean r17) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.decode(java.lang.String, boolean):java.lang.String");
    }

    private static boolean encodeUnescaped(char c2, boolean z) {
        if (('A' > c2 || c2 > 'Z') && (('a' > c2 || c2 > 'z') && (('0' > c2 || c2 > '9') && "-_.!~*'()".indexOf(c2) < 0))) {
            return z && URI_DECODE_RESERVED.indexOf(c2) >= 0;
        }
        return true;
    }

    private static EcmaError uriError() {
        return ScriptRuntime.constructError("URIError", ScriptRuntime.getMessage0("msg.bad.uri"));
    }

    private static int oneUcs4ToUtf8Char(byte[] bArr, int i) {
        if ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) == 0) {
            bArr[0] = (byte) i;
            return 1;
        }
        int i2 = i >>> 11;
        int i3 = 2;
        while (i2 != 0) {
            i2 >>>= 5;
            i3++;
        }
        int i4 = i3;
        while (true) {
            i4--;
            if (i4 > 0) {
                bArr[i4] = (byte) ((i & 63) | 128);
                i >>>= 6;
            } else {
                bArr[0] = (byte) ((256 - (1 << (8 - i3))) + i);
                return i3;
            }
        }
    }
}
