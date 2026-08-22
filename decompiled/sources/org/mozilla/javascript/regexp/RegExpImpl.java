package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.RegExpProxy;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes10.dex */
public class RegExpImpl implements RegExpProxy {
    protected String input;
    protected SubString lastMatch;
    protected SubString lastParen;
    protected SubString leftContext;
    protected boolean multiline;
    protected SubString[] parens;
    protected SubString rightContext;

    @Override // org.mozilla.javascript.RegExpProxy
    public boolean isRegExp(Scriptable scriptable) {
        return scriptable instanceof NativeRegExp;
    }

    @Override // org.mozilla.javascript.RegExpProxy
    public Object compileRegExp(Context context, String str, String str2) {
        return NativeRegExp.compileRE(context, str, str2, false);
    }

    @Override // org.mozilla.javascript.RegExpProxy
    public Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return new NativeRegExp(scriptable, (RECompiled) obj);
    }

    @Override // org.mozilla.javascript.RegExpProxy
    public Object action(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, int i) {
        String string;
        NativeRegExp nativeRegExpCreateRegExp;
        String string2;
        Function function;
        RegExpImpl regExpImpl;
        Scriptable scriptable3;
        Object objMatchOrReplace;
        GlobData globData = new GlobData();
        globData.mode = i;
        globData.str = ScriptRuntime.toString(scriptable2);
        if (i == 1) {
            return globData.arrayobj == null ? matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, createRegExp(context, scriptable, objArr, 1, false)) : globData.arrayobj;
        }
        if (i != 2) {
            if (i == 3) {
                return matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, createRegExp(context, scriptable, objArr, 1, false));
            }
            throw Kit.codeBug();
        }
        boolean z = (objArr.length > 0 && (objArr[0] instanceof NativeRegExp)) || objArr.length > 2;
        if (z) {
            nativeRegExpCreateRegExp = createRegExp(context, scriptable, objArr, 2, true);
            string = null;
        } else {
            string = ScriptRuntime.toString(objArr.length < 1 ? Undefined.instance : objArr[0]);
            nativeRegExpCreateRegExp = null;
        }
        Object obj = objArr.length < 2 ? Undefined.instance : objArr[1];
        if (obj instanceof Function) {
            function = (Function) obj;
            string2 = null;
        } else {
            string2 = ScriptRuntime.toString(obj);
            function = null;
        }
        globData.lambda = function;
        globData.repstr = string2;
        globData.dollar = string2 == null ? -1 : string2.indexOf(36);
        globData.charBuf = null;
        globData.leftIndex = 0;
        if (z) {
            regExpImpl = this;
            scriptable3 = scriptable;
            objMatchOrReplace = matchOrReplace(context, scriptable3, scriptable2, objArr, regExpImpl, globData, nativeRegExpCreateRegExp);
        } else {
            regExpImpl = this;
            scriptable3 = scriptable;
            String str = globData.str;
            int iIndexOf = str.indexOf(string);
            if (iIndexOf >= 0) {
                int length = string.length();
                regExpImpl.lastParen = null;
                regExpImpl.leftContext = new SubString(str, 0, iIndexOf);
                regExpImpl.lastMatch = new SubString(str, iIndexOf, length);
                regExpImpl.rightContext = new SubString(str, iIndexOf + length, (str.length() - iIndexOf) - length);
                objMatchOrReplace = Boolean.TRUE;
            } else {
                objMatchOrReplace = Boolean.FALSE;
            }
        }
        if (globData.charBuf == null) {
            if (globData.global || objMatchOrReplace == null || !objMatchOrReplace.equals(Boolean.TRUE)) {
                return globData.str;
            }
            SubString subString = regExpImpl.leftContext;
            replace_glob(globData, context, scriptable3, this, subString.index, subString.length);
            globData = globData;
            regExpImpl = this;
        }
        SubString subString2 = regExpImpl.rightContext;
        globData.charBuf.append((CharSequence) subString2.str, subString2.index, subString2.index + subString2.length);
        return globData.charBuf.toString();
    }

    private static NativeRegExp createRegExp(Context context, Scriptable scriptable, Object[] objArr, int i, boolean z) {
        String string;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        if (objArr.length == 0 || objArr[0] == Undefined.instance) {
            return new NativeRegExp(topLevelScope, NativeRegExp.compileRE(context, "", "", false));
        }
        Object obj = objArr[0];
        if (obj instanceof NativeRegExp) {
            return (NativeRegExp) obj;
        }
        String string2 = ScriptRuntime.toString(obj);
        if (i < objArr.length) {
            objArr[0] = string2;
            string = ScriptRuntime.toString(objArr[i]);
        } else {
            string = null;
        }
        return new NativeRegExp(topLevelScope, NativeRegExp.compileRE(context, string2, string, z));
    }

    private static Object matchOrReplace(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RegExpImpl regExpImpl, GlobData globData, NativeRegExp nativeRegExp) {
        GlobData globData2;
        GlobData globData3 = globData;
        String str = globData3.str;
        globData3.global = (nativeRegExp.getFlags() & 1) != 0;
        int[] iArr = {0};
        if (globData3.mode == 3) {
            Object objExecuteRegExp = nativeRegExp.executeRegExp(context, scriptable, regExpImpl, str, iArr, 0);
            if (objExecuteRegExp != null && objExecuteRegExp.equals(Boolean.TRUE)) {
                return Integer.valueOf(regExpImpl.leftContext.length);
            }
            return -1;
        }
        if (!globData3.global) {
            return nativeRegExp.executeRegExp(context, scriptable, regExpImpl, str, iArr, globData3.mode == 2 ? 0 : 1);
        }
        NativeRegExp nativeRegExp2 = nativeRegExp;
        nativeRegExp2.lastIndex = Double.valueOf(0.0d);
        Object obj = null;
        int i = 0;
        while (iArr[0] <= str.length()) {
            Object objExecuteRegExp2 = nativeRegExp2.executeRegExp(context, scriptable, regExpImpl, str, iArr, 0);
            String str2 = str;
            int[] iArr2 = iArr;
            if (objExecuteRegExp2 != null && objExecuteRegExp2.equals(Boolean.TRUE)) {
                if (globData3.mode == 1) {
                    match_glob(globData3, context, scriptable, i, regExpImpl);
                    globData2 = globData3;
                } else {
                    if (globData3.mode != 2) {
                        Kit.codeBug();
                    }
                    SubString subString = regExpImpl.lastMatch;
                    int i2 = globData3.leftIndex;
                    int i3 = subString.index - i2;
                    globData3.leftIndex = subString.index + subString.length;
                    globData2 = globData3;
                    replace_glob(globData2, context, scriptable, regExpImpl, i2, i3);
                }
                if (regExpImpl.lastMatch.length == 0) {
                    if (iArr2[0] != str2.length()) {
                        iArr2[0] = iArr2[0] + 1;
                    }
                }
                i++;
                nativeRegExp2 = nativeRegExp;
                globData3 = globData2;
                obj = objExecuteRegExp2;
                str = str2;
                iArr = iArr2;
            }
            return objExecuteRegExp2;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        r1 = r1 - r5;
     */
    @Override // org.mozilla.javascript.RegExpProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int find_split(org.mozilla.javascript.Context r13, org.mozilla.javascript.Scriptable r14, java.lang.String r15, java.lang.String r16, org.mozilla.javascript.Scriptable r17, int[] r18, int[] r19, boolean[] r20, java.lang.String[][] r21) {
        /*
            r12 = this;
            r0 = 0
            r1 = r18[r0]
            int r2 = r15.length()
            int r3 = r13.getLanguageVersion()
            r4 = r17
            org.mozilla.javascript.regexp.NativeRegExp r4 = (org.mozilla.javascript.regexp.NativeRegExp) r4
        Lf:
            r11 = r18[r0]
            r18[r0] = r1
            r10 = 0
            r7 = r12
            r5 = r13
            r6 = r14
            r8 = r15
            r9 = r18
            java.lang.Object r1 = r4.executeRegExp(r5, r6, r7, r8, r9, r10)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r6 = 1
            if (r1 == r5) goto L2a
            r18[r0] = r11
            r19[r0] = r6
            r20[r0] = r0
            return r2
        L2a:
            r1 = r18[r0]
            r18[r0] = r11
            r20[r0] = r6
            org.mozilla.javascript.regexp.SubString r5 = r12.lastMatch
            int r5 = r5.length
            r19[r0] = r5
            if (r5 != 0) goto L4a
            r8 = r18[r0]
            if (r1 != r8) goto L4a
            if (r1 != r2) goto L47
            r13 = 120(0x78, float:1.68E-43)
            if (r3 != r13) goto L45
            r19[r0] = r6
            goto L4b
        L45:
            r1 = -1
            goto L4b
        L47:
            int r1 = r1 + 1
            goto Lf
        L4a:
            int r1 = r1 - r5
        L4b:
            org.mozilla.javascript.regexp.SubString[] r13 = r12.parens
            if (r13 != 0) goto L51
            r13 = r0
            goto L52
        L51:
            int r13 = r13.length
        L52:
            java.lang.String[] r14 = new java.lang.String[r13]
            r21[r0] = r14
            r14 = r0
        L57:
            if (r14 >= r13) goto L68
            org.mozilla.javascript.regexp.SubString r15 = r12.getParenSubString(r14)
            r2 = r21[r0]
            java.lang.String r15 = r15.toString()
            r2[r14] = r15
            int r14 = r14 + 1
            goto L57
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.find_split(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.String, java.lang.String, org.mozilla.javascript.Scriptable, int[], int[], boolean[], java.lang.String[][]):int");
    }

    SubString getParenSubString(int i) {
        SubString subString;
        SubString[] subStringArr = this.parens;
        return (subStringArr == null || i >= subStringArr.length || (subString = subStringArr[i]) == null) ? new SubString() : subString;
    }

    private static void match_glob(GlobData globData, Context context, Scriptable scriptable, int i, RegExpImpl regExpImpl) {
        if (globData.arrayobj == null) {
            globData.arrayobj = context.newArray(scriptable, 0);
        }
        globData.arrayobj.put(i, globData.arrayobj, regExpImpl.lastMatch.toString());
    }

    private static void replace_glob(GlobData globData, Context context, Scriptable scriptable, RegExpImpl regExpImpl, int i, int i2) {
        int length;
        String string;
        int i3;
        if (globData.lambda != null) {
            SubString[] subStringArr = regExpImpl.parens;
            int length2 = subStringArr == null ? 0 : subStringArr.length;
            Object[] objArr = new Object[length2 + 3];
            objArr[0] = regExpImpl.lastMatch.toString();
            for (int i4 = 0; i4 < length2; i4++) {
                SubString subString = subStringArr[i4];
                if (subString != null) {
                    objArr[i4 + 1] = subString.toString();
                } else {
                    objArr[i4 + 1] = Undefined.instance;
                }
            }
            objArr[length2 + 1] = Integer.valueOf(regExpImpl.leftContext.length);
            objArr[length2 + 2] = globData.str;
            if (regExpImpl != ScriptRuntime.getRegExpProxy(context)) {
                Kit.codeBug();
            }
            RegExpImpl regExpImpl2 = new RegExpImpl();
            regExpImpl2.multiline = regExpImpl.multiline;
            regExpImpl2.input = regExpImpl.input;
            ScriptRuntime.setRegExpProxy(context, regExpImpl2);
            try {
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
                string = ScriptRuntime.toString(globData.lambda.call(context, topLevelScope, topLevelScope, objArr));
                ScriptRuntime.setRegExpProxy(context, regExpImpl);
                length = string.length();
            } catch (Throwable th) {
                ScriptRuntime.setRegExpProxy(context, regExpImpl);
                throw th;
            }
        } else {
            length = globData.repstr.length();
            if (globData.dollar >= 0) {
                int[] iArr = new int[1];
                int iIndexOf = globData.dollar;
                do {
                    SubString subStringInterpretDollar = interpretDollar(context, regExpImpl, globData.repstr, iIndexOf, iArr);
                    if (subStringInterpretDollar != null) {
                        int i5 = subStringInterpretDollar.length;
                        int i6 = iArr[0];
                        length += i5 - i6;
                        i3 = iIndexOf + i6;
                    } else {
                        i3 = iIndexOf + 1;
                    }
                    iIndexOf = globData.repstr.indexOf(36, i3);
                } while (iIndexOf >= 0);
            }
            string = null;
        }
        int i7 = length + i2 + regExpImpl.rightContext.length;
        StringBuilder sb = globData.charBuf;
        if (sb == null) {
            sb = new StringBuilder(i7);
            globData.charBuf = sb;
        } else {
            sb.ensureCapacity(globData.charBuf.length() + i7);
        }
        sb.append((CharSequence) regExpImpl.leftContext.str, i, i2 + i);
        if (globData.lambda != null) {
            sb.append(string);
        } else {
            do_replace(globData, context, regExpImpl);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.mozilla.javascript.regexp.SubString interpretDollar(org.mozilla.javascript.Context r7, org.mozilla.javascript.regexp.RegExpImpl r8, java.lang.String r9, int r10, int[] r11) {
        /*
            char r0 = r9.charAt(r10)
            r1 = 36
            if (r0 == r1) goto Lb
            org.mozilla.javascript.Kit.codeBug()
        Lb:
            int r7 = r7.getLanguageVersion()
            r0 = 140(0x8c, float:1.96E-43)
            r2 = 0
            if (r7 == 0) goto L23
            if (r7 > r0) goto L23
            if (r10 <= 0) goto L23
            int r3 = r10 + (-1)
            char r3 = r9.charAt(r3)
            r4 = 92
            if (r3 != r4) goto L23
            return r2
        L23:
            int r3 = r9.length()
            int r4 = r10 + 1
            if (r4 < r3) goto L2c
            return r2
        L2c:
            char r4 = r9.charAt(r4)
            boolean r5 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r4)
            r6 = 0
            if (r5 == 0) goto L8c
            r1 = 48
            if (r7 == 0) goto L5a
            if (r7 > r0) goto L5a
            if (r4 != r1) goto L40
            return r2
        L40:
            r7 = r10
            r0 = r6
        L42:
            int r7 = r7 + 1
            if (r7 >= r3) goto L82
            char r1 = r9.charAt(r7)
            boolean r2 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r1)
            if (r2 == 0) goto L82
            int r2 = r0 * 10
            int r1 = r1 + (-48)
            int r2 = r2 + r1
            if (r2 >= r0) goto L58
            goto L82
        L58:
            r0 = r2
            goto L42
        L5a:
            org.mozilla.javascript.regexp.SubString[] r7 = r8.parens
            if (r7 != 0) goto L60
            r7 = r6
            goto L61
        L60:
            int r7 = r7.length
        L61:
            int r4 = r4 - r1
            if (r4 <= r7) goto L65
            return r2
        L65:
            int r0 = r10 + 2
            if (r0 >= r3) goto L7d
            char r9 = r9.charAt(r0)
            boolean r3 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r9)
            if (r3 == 0) goto L7d
            int r3 = r4 * 10
            int r9 = r9 - r1
            int r3 = r3 + r9
            if (r3 > r7) goto L7d
            int r7 = r10 + 3
            r0 = r3
            goto L7f
        L7d:
            r7 = r0
            r0 = r4
        L7f:
            if (r0 != 0) goto L82
            return r2
        L82:
            int r0 = r0 + (-1)
            int r7 = r7 - r10
            r11[r6] = r7
            org.mozilla.javascript.regexp.SubString r7 = r8.getParenSubString(r0)
            return r7
        L8c:
            r9 = 2
            r11[r6] = r9
            if (r4 == r1) goto Lbe
            r9 = 43
            if (r4 == r9) goto Lbb
            r9 = 96
            if (r4 == r9) goto La8
            r7 = 38
            if (r4 == r7) goto La5
            r7 = 39
            if (r4 == r7) goto La2
            return r2
        La2:
            org.mozilla.javascript.regexp.SubString r7 = r8.rightContext
            return r7
        La5:
            org.mozilla.javascript.regexp.SubString r7 = r8.lastMatch
            return r7
        La8:
            r9 = 120(0x78, float:1.68E-43)
            if (r7 != r9) goto Lb8
            org.mozilla.javascript.regexp.SubString r7 = r8.leftContext
            r7.index = r6
            org.mozilla.javascript.regexp.SubString r7 = r8.leftContext
            org.mozilla.javascript.regexp.SubString r9 = r8.lastMatch
            int r9 = r9.index
            r7.length = r9
        Lb8:
            org.mozilla.javascript.regexp.SubString r7 = r8.leftContext
            return r7
        Lbb:
            org.mozilla.javascript.regexp.SubString r7 = r8.lastParen
            return r7
        Lbe:
            org.mozilla.javascript.regexp.SubString r7 = new org.mozilla.javascript.regexp.SubString
            java.lang.String r8 = "$"
            r7.<init>(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.interpretDollar(org.mozilla.javascript.Context, org.mozilla.javascript.regexp.RegExpImpl, java.lang.String, int, int[]):org.mozilla.javascript.regexp.SubString");
    }

    private static void do_replace(GlobData globData, Context context, RegExpImpl regExpImpl) {
        int i;
        StringBuilder sb = globData.charBuf;
        String str = globData.repstr;
        int iIndexOf = globData.dollar;
        int i2 = 0;
        if (iIndexOf != -1) {
            int[] iArr = new int[1];
            int i3 = 0;
            do {
                sb.append(str.substring(i3, iIndexOf));
                SubString subStringInterpretDollar = interpretDollar(context, regExpImpl, str, iIndexOf, iArr);
                if (subStringInterpretDollar != null) {
                    int i4 = subStringInterpretDollar.length;
                    if (i4 > 0) {
                        sb.append((CharSequence) subStringInterpretDollar.str, subStringInterpretDollar.index, subStringInterpretDollar.index + i4);
                    }
                    int i5 = iArr[0];
                    int i6 = iIndexOf + i5;
                    i = iIndexOf + i5;
                    i3 = i6;
                } else {
                    i3 = iIndexOf;
                    i = iIndexOf + 1;
                }
                iIndexOf = str.indexOf(36, i);
            } while (iIndexOf >= 0);
            i2 = i3;
        }
        int length = str.length();
        if (length > i2) {
            sb.append(str.substring(i2, length));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    @Override // org.mozilla.javascript.RegExpProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object js_split(org.mozilla.javascript.Context r20, org.mozilla.javascript.Scriptable r21, java.lang.String r22, java.lang.Object[] r23) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.js_split(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.String, java.lang.Object[]):java.lang.Object");
    }

    private static int find_split(Context context, Scriptable scriptable, String str, String str2, int i, RegExpProxy regExpProxy, Scriptable scriptable2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr) {
        int iIndexOf;
        int i2 = iArr[0];
        int length = str.length();
        if (i == 120 && scriptable2 == null && str2.length() == 1 && str2.charAt(0) == ' ') {
            if (i2 == 0) {
                while (i2 < length && Character.isWhitespace(str.charAt(i2))) {
                    i2++;
                }
                iArr[0] = i2;
            }
            if (i2 == length) {
                return -1;
            }
            while (i2 < length && !Character.isWhitespace(str.charAt(i2))) {
                i2++;
            }
            int i3 = i2;
            while (i3 < length && Character.isWhitespace(str.charAt(i3))) {
                i3++;
            }
            iArr2[0] = i3 - i2;
            return i2;
        }
        if (i2 > length) {
            return -1;
        }
        if (scriptable2 != null) {
            return regExpProxy.find_split(context, scriptable, str, str2, scriptable2, iArr, iArr2, zArr, strArr);
        }
        if (i != 0 && i < 130 && length == 0) {
            return -1;
        }
        if (str2.length() != 0) {
            int i4 = iArr[0];
            return (i4 < length && (iIndexOf = str.indexOf(str2, i4)) != -1) ? iIndexOf : length;
        }
        if (i != 120) {
            if (i2 == length) {
                return -1;
            }
            return i2 + 1;
        }
        if (i2 != length) {
            return i2 + 1;
        }
        iArr2[0] = 1;
        return i2;
    }
}
