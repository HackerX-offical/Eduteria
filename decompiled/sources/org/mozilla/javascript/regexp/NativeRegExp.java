package org.mozilla.javascript.regexp;

import com.appnew.android.Utils.Const;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.x5.template.MacroTag;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes10.dex */
public class NativeRegExp extends IdScriptableObject implements Function {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANCHOR_BOL = -2;
    private static final int INDEX_LEN = 2;
    private static final int Id_compile = 1;
    private static final int Id_exec = 4;
    private static final int Id_global = 3;
    private static final int Id_ignoreCase = 4;
    private static final int Id_lastIndex = 1;
    private static final int Id_multiline = 5;
    private static final int Id_prefix = 6;
    private static final int Id_source = 2;
    private static final int Id_test = 5;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    public static final int JSREG_FOLD = 2;
    public static final int JSREG_GLOB = 1;
    public static final int JSREG_MULTILINE = 4;
    public static final int MATCH = 1;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    public static final int PREFIX = 2;
    private static final Object REGEXP_TAG = new Object();
    private static final byte REOP_ALNUM = 9;
    private static final byte REOP_ALT = 31;
    private static final byte REOP_ALTPREREQ = 53;
    private static final byte REOP_ALTPREREQ2 = 55;
    private static final byte REOP_ALTPREREQi = 54;
    private static final byte REOP_ASSERT = 41;
    private static final byte REOP_ASSERTNOTTEST = 44;
    private static final byte REOP_ASSERTTEST = 43;
    private static final byte REOP_ASSERT_NOT = 42;
    private static final byte REOP_BACKREF = 13;
    private static final byte REOP_BOL = 2;
    private static final byte REOP_CLASS = 22;
    private static final byte REOP_DIGIT = 7;
    private static final byte REOP_DOT = 6;
    private static final byte REOP_EMPTY = 1;
    private static final byte REOP_END = 57;
    private static final byte REOP_ENDCHILD = 49;
    private static final byte REOP_EOL = 3;
    private static final byte REOP_FLAT = 14;
    private static final byte REOP_FLAT1 = 15;
    private static final byte REOP_FLAT1i = 17;
    private static final byte REOP_FLATi = 16;
    private static final byte REOP_JUMP = 32;
    private static final byte REOP_LPAREN = 29;
    private static final byte REOP_MINIMALOPT = 47;
    private static final byte REOP_MINIMALPLUS = 46;
    private static final byte REOP_MINIMALQUANT = 48;
    private static final byte REOP_MINIMALREPEAT = 52;
    private static final byte REOP_MINIMALSTAR = 45;
    private static final byte REOP_NCLASS = 23;
    private static final byte REOP_NONALNUM = 10;
    private static final byte REOP_NONDIGIT = 8;
    private static final byte REOP_NONSPACE = 12;
    private static final byte REOP_OPT = 28;
    private static final byte REOP_PLUS = 27;
    private static final byte REOP_QUANT = 25;
    private static final byte REOP_REPEAT = 51;
    private static final byte REOP_RPAREN = 30;
    private static final byte REOP_SIMPLE_END = 23;
    private static final byte REOP_SIMPLE_START = 1;
    private static final byte REOP_SPACE = 11;
    private static final byte REOP_STAR = 26;
    private static final byte REOP_UCFLAT1 = 18;
    private static final byte REOP_UCFLAT1i = 19;
    private static final byte REOP_WBDRY = 4;
    private static final byte REOP_WNONBDRY = 5;
    public static final int TEST = 0;
    private static final boolean debug = false;
    static final long serialVersionUID = 4965263491464903264L;
    Object lastIndex;
    private int lastIndexAttr;
    private RECompiled re;

    private static boolean isControlLetter(char c2) {
        if ('a' > c2 || c2 > 'z') {
            return 'A' <= c2 && c2 <= 'Z';
        }
        return true;
    }

    static boolean isDigit(char c2) {
        return '0' <= c2 && c2 <= '9';
    }

    private static boolean reopIsSimple(int i) {
        return i >= 1 && i <= 23;
    }

    private static int toASCIIHexDigit(int i) {
        if (i < 48) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = i | 32;
        if (97 > i2 || i2 > 102) {
            return -1;
        }
        return i2 - 87;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 5;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.re = compileRE(context, "", null, false);
        nativeRegExp.activatePrototypeMap(6);
        nativeRegExp.setParentScope(scriptable);
        nativeRegExp.setPrototype(getObjectPrototype(scriptable));
        NativeRegExpCtor nativeRegExpCtor = new NativeRegExpCtor();
        nativeRegExp.defineProperty("constructor", nativeRegExpCtor, 2);
        ScriptRuntime.setFunctionProtoAndParent(nativeRegExpCtor, scriptable);
        nativeRegExpCtor.setImmunePrototypeProperty(nativeRegExp);
        if (z) {
            nativeRegExp.sealObject();
            nativeRegExpCtor.sealObject();
        }
        defineProperty(scriptable, "RegExp", nativeRegExpCtor, 2);
    }

    NativeRegExp(Scriptable scriptable, RECompiled rECompiled) {
        Double dValueOf = Double.valueOf(0.0d);
        this.lastIndex = dValueOf;
        this.lastIndexAttr = 6;
        this.re = rECompiled;
        this.lastIndex = dValueOf;
        ScriptRuntime.setBuiltinProtoAndParent(this, scriptable, TopLevel.Builtins.RegExp);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "RegExp";
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return "object";
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return execSub(context, scriptable, objArr, 1);
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        return (Scriptable) execSub(context, scriptable, objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    org.mozilla.javascript.Scriptable compile(org.mozilla.javascript.Context r5, org.mozilla.javascript.Scriptable r6, java.lang.Object[] r7) {
        /*
            r4 = this;
            int r6 = r7.length
            r0 = 0
            r1 = 1
            if (r6 <= 0) goto L29
            r6 = r7[r0]
            boolean r6 = r6 instanceof org.mozilla.javascript.regexp.NativeRegExp
            if (r6 == 0) goto L29
            int r5 = r7.length
            if (r5 <= r1) goto L1c
            r5 = r7[r1]
            java.lang.Object r6 = org.mozilla.javascript.Undefined.instance
            if (r5 != r6) goto L15
            goto L1c
        L15:
            java.lang.String r5 = "msg.bad.regexp.compile"
            org.mozilla.javascript.EcmaError r5 = org.mozilla.javascript.ScriptRuntime.typeError0(r5)
            throw r5
        L1c:
            r5 = r7[r0]
            org.mozilla.javascript.regexp.NativeRegExp r5 = (org.mozilla.javascript.regexp.NativeRegExp) r5
            org.mozilla.javascript.regexp.RECompiled r6 = r5.re
            r4.re = r6
            java.lang.Object r5 = r5.lastIndex
            r4.lastIndex = r5
            return r4
        L29:
            int r6 = r7.length
            if (r6 == 0) goto L38
            r6 = r7[r0]
            boolean r2 = r6 instanceof org.mozilla.javascript.Undefined
            if (r2 == 0) goto L33
            goto L38
        L33:
            java.lang.String r6 = escapeRegExp(r6)
            goto L3a
        L38:
            java.lang.String r6 = ""
        L3a:
            int r2 = r7.length
            if (r2 <= r1) goto L4a
            r2 = r7[r1]
            java.lang.Object r3 = org.mozilla.javascript.Undefined.instance
            if (r2 == r3) goto L4a
            r7 = r7[r1]
            java.lang.String r7 = org.mozilla.javascript.ScriptRuntime.toString(r7)
            goto L4b
        L4a:
            r7 = 0
        L4b:
            org.mozilla.javascript.regexp.RECompiled r5 = compileRE(r5, r6, r7, r0)
            r4.re = r5
            r5 = 0
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r4.lastIndex = r5
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.compile(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[]):org.mozilla.javascript.Scriptable");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (this.re.source.length != 0) {
            sb.append(this.re.source);
        } else {
            sb.append("(?:)");
        }
        sb.append('/');
        if ((this.re.flags & 1) != 0) {
            sb.append('g');
        }
        if ((this.re.flags & 2) != 0) {
            sb.append('i');
        }
        if ((this.re.flags & 4) != 0) {
            sb.append('m');
        }
        return sb.toString();
    }

    NativeRegExp() {
        this.lastIndex = Double.valueOf(0.0d);
        this.lastIndexAttr = 6;
    }

    private static RegExpImpl getImpl(Context context) {
        return (RegExpImpl) ScriptRuntime.getRegExpProxy(context);
    }

    private static String escapeRegExp(Object obj) {
        String string = ScriptRuntime.toString(obj);
        StringBuilder sb = null;
        int i = 0;
        for (int iIndexOf = string.indexOf(47); iIndexOf > -1; iIndexOf = string.indexOf(47, iIndexOf + 1)) {
            if (iIndexOf == i || string.charAt(iIndexOf - 1) != '\\') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) string, i, iIndexOf);
                sb.append("\\/");
                i = iIndexOf + 1;
            }
        }
        if (sb == null) {
            return string;
        }
        sb.append((CharSequence) string, i, string.length());
        return sb.toString();
    }

    private Object execSub(Context context, Scriptable scriptable, Object[] objArr, int i) {
        String string;
        RegExpImpl impl = getImpl(context);
        if (objArr.length == 0) {
            string = impl.input;
            if (string == null) {
                string = ScriptRuntime.toString(Undefined.instance);
            }
        } else {
            string = ScriptRuntime.toString(objArr[0]);
        }
        String str = string;
        double d2 = 0.0d;
        double integer = (this.re.flags & 1) != 0 ? ScriptRuntime.toInteger(this.lastIndex) : 0.0d;
        if (integer < 0.0d || str.length() < integer) {
            this.lastIndex = Double.valueOf(0.0d);
            return null;
        }
        int[] iArr = {(int) integer};
        Object objExecuteRegExp = executeRegExp(context, scriptable, impl, str, iArr, i);
        if ((this.re.flags & 1) != 0) {
            if (objExecuteRegExp != null && objExecuteRegExp != Undefined.instance) {
                d2 = iArr[0];
            }
            this.lastIndex = Double.valueOf(d2);
        }
        return objExecuteRegExp;
    }

    static RECompiled compileRE(Context context, String str, String str2, boolean z) {
        int i;
        int i2;
        RECompiled rECompiled = new RECompiled(str);
        int length = str.length();
        if (str2 != null) {
            i = 0;
            for (int i3 = 0; i3 < str2.length(); i3++) {
                char cCharAt = str2.charAt(i3);
                if (cCharAt == 'g') {
                    i2 = 1;
                } else if (cCharAt == 'i') {
                    i2 = 2;
                } else if (cCharAt == 'm') {
                    i2 = 4;
                } else {
                    reportError("msg.invalid.re.flag", String.valueOf(cCharAt));
                    i2 = 0;
                }
                if ((i & i2) != 0) {
                    reportError("msg.invalid.re.flag", String.valueOf(cCharAt));
                }
                i |= i2;
            }
        } else {
            i = 0;
        }
        rECompiled.flags = i;
        CompilerState compilerState = new CompilerState(context, rECompiled.source, length, i);
        if (z && length > 0) {
            compilerState.result = new RENode((byte) 14);
            compilerState.result.chr = compilerState.cpbegin[0];
            compilerState.result.length = length;
            compilerState.result.flatIndex = 0;
            compilerState.progLength += 5;
        } else {
            if (!parseDisjunction(compilerState)) {
                return null;
            }
            if (compilerState.maxBackReference > compilerState.parenCount) {
                compilerState = new CompilerState(context, rECompiled.source, length, i);
                compilerState.backReferenceLimit = compilerState.parenCount;
                if (!parseDisjunction(compilerState)) {
                    return null;
                }
            }
        }
        rECompiled.program = new byte[compilerState.progLength + 1];
        if (compilerState.classCount != 0) {
            rECompiled.classList = new RECharSet[compilerState.classCount];
            rECompiled.classCount = compilerState.classCount;
        }
        rECompiled.program[emitREBytecode(compilerState, rECompiled, 0, compilerState.result)] = REOP_END;
        rECompiled.parenCount = compilerState.parenCount;
        byte b2 = rECompiled.program[0];
        if (b2 == 2) {
            rECompiled.anchorCh = -2;
            return rECompiled;
        }
        if (b2 != 31) {
            switch (b2) {
                case 14:
                case 16:
                    rECompiled.anchorCh = rECompiled.source[getIndex(rECompiled.program, 1)];
                    break;
                case 15:
                case 17:
                    rECompiled.anchorCh = (char) (rECompiled.program[1] & 255);
                    break;
                case 18:
                case 19:
                    rECompiled.anchorCh = (char) getIndex(rECompiled.program, 1);
                    break;
            }
            return null;
        }
        RENode rENode = compilerState.result;
        if (rENode.kid.op == 2 && rENode.kid2.op == 2) {
            rECompiled.anchorCh = -2;
        }
        return rECompiled;
    }

    private static boolean isWord(char c2) {
        if ('a' > c2 || c2 > 'z') {
            return ('A' <= c2 && c2 <= 'Z') || isDigit(c2) || c2 == '_';
        }
        return true;
    }

    private static boolean isLineTerm(char c2) {
        return ScriptRuntime.isJSLineTerminator(c2);
    }

    private static boolean isREWhiteSpace(int i) {
        return ScriptRuntime.isJSWhitespaceOrLineTerminator(i);
    }

    private static char upcase(char c2) {
        if (c2 >= 128) {
            char upperCase = Character.toUpperCase(c2);
            if (upperCase >= 128) {
                return upperCase;
            }
        } else if ('a' <= c2 && c2 <= 'z') {
            return (char) (c2 - ' ');
        }
        return c2;
    }

    private static char downcase(char c2) {
        if (c2 >= 128) {
            char lowerCase = Character.toLowerCase(c2);
            if (lowerCase >= 128) {
                return lowerCase;
            }
        } else if ('A' <= c2 && c2 <= 'Z') {
            return (char) (c2 + ' ');
        }
        return c2;
    }

    private static boolean parseDisjunction(CompilerState compilerState) {
        if (!parseAlternative(compilerState)) {
            return false;
        }
        char[] cArr = compilerState.cpbegin;
        int i = compilerState.cp;
        if (i != cArr.length && cArr[i] == '|') {
            compilerState.cp++;
            RENode rENode = new RENode((byte) 31);
            rENode.kid = compilerState.result;
            if (!parseDisjunction(compilerState)) {
                return false;
            }
            rENode.kid2 = compilerState.result;
            compilerState.result = rENode;
            if (rENode.kid.op == 14 && rENode.kid2.op == 14) {
                rENode.op = (compilerState.flags & 2) == 0 ? REOP_ALTPREREQ : REOP_ALTPREREQi;
                rENode.chr = rENode.kid.chr;
                rENode.index = rENode.kid2.chr;
                compilerState.progLength += 13;
            } else if (rENode.kid.op == 22 && rENode.kid.index < 256 && rENode.kid2.op == 14 && (compilerState.flags & 2) == 0) {
                rENode.op = REOP_ALTPREREQ2;
                rENode.chr = rENode.kid2.chr;
                rENode.index = rENode.kid.index;
                compilerState.progLength += 13;
            } else if (rENode.kid.op == 14 && rENode.kid2.op == 22 && rENode.kid2.index < 256 && (compilerState.flags & 2) == 0) {
                rENode.op = REOP_ALTPREREQ2;
                rENode.chr = rENode.kid.chr;
                rENode.index = rENode.kid2.index;
                compilerState.progLength += 13;
            } else {
                compilerState.progLength += 9;
            }
        }
        return true;
    }

    private static boolean parseAlternative(CompilerState compilerState) {
        char[] cArr = compilerState.cpbegin;
        RENode rENode = null;
        RENode rENode2 = null;
        while (compilerState.cp != compilerState.cpend && cArr[compilerState.cp] != '|' && (compilerState.parenNesting == 0 || cArr[compilerState.cp] != ')')) {
            if (!parseTerm(compilerState)) {
                return false;
            }
            if (rENode == null) {
                rENode = compilerState.result;
                rENode2 = rENode;
            } else {
                rENode2.next = compilerState.result;
            }
            while (rENode2.next != null) {
                rENode2 = rENode2.next;
            }
        }
        if (rENode == null) {
            compilerState.result = new RENode((byte) 1);
        } else {
            compilerState.result = rENode;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:31:0x005b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static boolean calculateBitmapSize(org.mozilla.javascript.regexp.CompilerState r16, org.mozilla.javascript.regexp.RENode r17, char[] r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.calculateBitmapSize(org.mozilla.javascript.regexp.CompilerState, org.mozilla.javascript.regexp.RENode, char[], int, int):boolean");
    }

    private static void doFlat(CompilerState compilerState, char c2) {
        compilerState.result = new RENode((byte) 14);
        compilerState.result.chr = c2;
        compilerState.result.length = 1;
        compilerState.result.flatIndex = -1;
        compilerState.progLength += 3;
    }

    private static int getDecimalValue(char c2, CompilerState compilerState, int i, String str) {
        int i2 = compilerState.cp;
        char[] cArr = compilerState.cpbegin;
        int i3 = c2 - 48;
        boolean z = false;
        while (compilerState.cp != compilerState.cpend) {
            char c3 = cArr[compilerState.cp];
            if (!isDigit(c3)) {
                break;
            }
            if (!z && (i3 = (i3 * 10) + (c3 - '0')) >= i) {
                i3 = i;
                z = true;
            }
            compilerState.cp++;
        }
        if (z) {
            reportError(str, String.valueOf(cArr, i2, compilerState.cp - i2));
        }
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v100 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v63, types: [int] */
    /* JADX WARN: Type inference failed for: r4v64, types: [int] */
    /* JADX WARN: Type inference failed for: r4v69, types: [char] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:72:0x0161
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static boolean parseTerm(org.mozilla.javascript.regexp.CompilerState r18) {
        /*
            Method dump skipped, instruction units count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.parseTerm(org.mozilla.javascript.regexp.CompilerState):boolean");
    }

    private static void resolveForwardJump(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw Kit.codeBug();
        }
        addIndex(bArr, i, i2 - i);
    }

    private static int getOffset(byte[] bArr, int i) {
        return getIndex(bArr, i);
    }

    private static int addIndex(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw Kit.codeBug();
        }
        if (i2 > 65535) {
            throw Context.reportRuntimeError("Too complex regexp");
        }
        bArr[i] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) i2;
        return i + 2;
    }

    private static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int emitREBytecode(org.mozilla.javascript.regexp.CompilerState r8, org.mozilla.javascript.regexp.RECompiled r9, int r10, org.mozilla.javascript.regexp.RENode r11) {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.emitREBytecode(org.mozilla.javascript.regexp.CompilerState, org.mozilla.javascript.regexp.RECompiled, int, org.mozilla.javascript.regexp.RENode):int");
    }

    private static void pushProgState(REGlobalData rEGlobalData, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        rEGlobalData.stateStackTop = new REProgState(rEGlobalData.stateStackTop, i, i2, i3, rEBackTrackData, i4, i5);
    }

    private static REProgState popProgState(REGlobalData rEGlobalData) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.stateStackTop = rEProgState.previous;
        return rEProgState;
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b2, int i) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b2, i, rEGlobalData.cp, rEProgState.continuationOp, rEProgState.continuationPc);
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b2, int i, int i2, int i3, int i4) {
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b2, i, i2, i3, i4);
    }

    private static boolean flatNMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.cp + i2 > i3) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (rEGlobalData.regexp.source[i + i4] != str.charAt(rEGlobalData.cp + i4)) {
                return false;
            }
        }
        rEGlobalData.cp += i2;
        return true;
    }

    private static boolean flatNIMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.cp + i2 > i3) {
            return false;
        }
        char[] cArr = rEGlobalData.regexp.source;
        for (int i4 = 0; i4 < i2; i4++) {
            char c2 = cArr[i + i4];
            char cCharAt = str.charAt(rEGlobalData.cp + i4);
            if (c2 != cCharAt && upcase(c2) != upcase(cCharAt)) {
                return false;
            }
        }
        rEGlobalData.cp += i2;
        return true;
    }

    private static boolean backrefMatcher(REGlobalData rEGlobalData, int i, String str, int i2) {
        if (rEGlobalData.parens == null || i >= rEGlobalData.parens.length) {
            return false;
        }
        int iParensIndex = rEGlobalData.parensIndex(i);
        if (iParensIndex == -1) {
            return true;
        }
        int iParensLength = rEGlobalData.parensLength(i);
        if (rEGlobalData.cp + iParensLength > i2) {
            return false;
        }
        if ((rEGlobalData.regexp.flags & 2) != 0) {
            for (int i3 = 0; i3 < iParensLength; i3++) {
                char cCharAt = str.charAt(iParensIndex + i3);
                char cCharAt2 = str.charAt(rEGlobalData.cp + i3);
                if (cCharAt != cCharAt2 && upcase(cCharAt) != upcase(cCharAt2)) {
                    return false;
                }
            }
        } else if (!str.regionMatches(iParensIndex, str, rEGlobalData.cp, iParensLength)) {
            return false;
        }
        rEGlobalData.cp += iParensLength;
        return true;
    }

    private static void addCharacterToCharSet(RECharSet rECharSet, char c2) {
        int i = c2 / '\b';
        if (c2 >= rECharSet.length) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        byte[] bArr = rECharSet.bits;
        bArr[i] = (byte) ((1 << (c2 & 7)) | bArr[i]);
    }

    private static void addCharacterRangeToCharSet(RECharSet rECharSet, char c2, char c3) {
        int i = c2 / '\b';
        int i2 = c3 / '\b';
        if (c3 >= rECharSet.length || c2 > c3) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        char c4 = (char) (c2 & 7);
        char c5 = (char) (c3 & 7);
        if (i == i2) {
            byte[] bArr = rECharSet.bits;
            bArr[i] = (byte) (((255 >> (7 - (c5 - c4))) << c4) | bArr[i]);
            return;
        }
        byte[] bArr2 = rECharSet.bits;
        bArr2[i] = (byte) ((255 << c4) | bArr2[i]);
        while (true) {
            i++;
            if (i < i2) {
                rECharSet.bits[i] = -1;
            } else {
                byte[] bArr3 = rECharSet.bits;
                bArr3[i2] = (byte) (bArr3[i2] | (255 >> (7 - c5)));
                return;
            }
        }
    }

    private static void processCharSet(REGlobalData rEGlobalData, RECharSet rECharSet) {
        synchronized (rECharSet) {
            if (!rECharSet.converted) {
                processCharSetImpl(rEGlobalData, rECharSet);
                rECharSet.converted = true;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0064. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0067. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x006a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:39:0x008b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static void processCharSetImpl(org.mozilla.javascript.regexp.REGlobalData r17, org.mozilla.javascript.regexp.RECharSet r18) {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.processCharSetImpl(org.mozilla.javascript.regexp.REGlobalData, org.mozilla.javascript.regexp.RECharSet):void");
    }

    private static boolean classMatcher(REGlobalData rEGlobalData, RECharSet rECharSet, char c2) {
        if (!rECharSet.converted) {
            processCharSet(rEGlobalData, rECharSet);
        }
        int i = c2 >> 3;
        boolean z = true;
        if (rECharSet.length != 0 && c2 < rECharSet.length && (rECharSet.bits[i] & (1 << (c2 & 7))) != 0) {
            z = false;
        }
        return rECharSet.sense ^ z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ce A[PHI: r5
      0x01ce: PHI (r5v16 boolean) = (r5v10 boolean), (r5v20 boolean), (r5v20 boolean) binds: [B:99:0x01cb, B:85:0x0199, B:87:0x01a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01fb A[PHI: r7
      0x01fb: PHI (r7v13 int) = 
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v0 int)
      (r7v7 int)
      (r7v11 int)
      (r7v11 int)
      (r7v12 int)
      (r7v12 int)
      (r7v14 int)
      (r7v14 int)
     binds: [B:113:0x01ec, B:115:0x01f9, B:106:0x01d7, B:108:0x01e3, B:73:0x016d, B:75:0x0179, B:68:0x0156, B:70:0x0162, B:63:0x013f, B:65:0x014b, B:58:0x0128, B:60:0x0134, B:53:0x0111, B:55:0x011d, B:48:0x00fa, B:50:0x0106, B:43:0x00e3, B:45:0x00ef, B:39:0x00c0, B:19:0x005c, B:21:0x0064, B:12:0x0038, B:16:0x004a, B:7:0x0014, B:9:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int simpleMatch(org.mozilla.javascript.regexp.REGlobalData r3, java.lang.String r4, int r5, byte[] r6, int r7, int r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.simpleMatch(org.mozilla.javascript.regexp.REGlobalData, java.lang.String, int, byte[], int, int, boolean):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0438  */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v67, types: [int] */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50, types: [int] */
    /* JADX WARN: Type inference failed for: r2v56 */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean executeREBytecode(org.mozilla.javascript.regexp.REGlobalData r20, java.lang.String r21, int r22) {
        /*
            Method dump skipped, instruction units count: 1198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.executeREBytecode(org.mozilla.javascript.regexp.REGlobalData, java.lang.String, int):boolean");
    }

    private static boolean matchRegExp(REGlobalData rEGlobalData, RECompiled rECompiled, String str, int i, int i2, boolean z) {
        if (rECompiled.parenCount != 0) {
            rEGlobalData.parens = new long[rECompiled.parenCount];
        } else {
            rEGlobalData.parens = null;
        }
        rEGlobalData.backTrackStackTop = null;
        rEGlobalData.stateStackTop = null;
        rEGlobalData.multiline = z || (rECompiled.flags & 4) != 0;
        rEGlobalData.regexp = rECompiled;
        int i3 = rEGlobalData.regexp.anchorCh;
        int i4 = i;
        while (i4 <= i2) {
            if (i3 >= 0) {
                while (i4 != i2) {
                    char cCharAt = str.charAt(i4);
                    if (cCharAt != i3 && ((rEGlobalData.regexp.flags & 2) == 0 || upcase(cCharAt) != upcase((char) i3))) {
                        i4++;
                    }
                }
                return false;
            }
            rEGlobalData.cp = i4;
            rEGlobalData.skipped = i4 - i;
            for (int i5 = 0; i5 < rECompiled.parenCount; i5++) {
                rEGlobalData.parens[i5] = -1;
            }
            boolean zExecuteREBytecode = executeREBytecode(rEGlobalData, str, i2);
            rEGlobalData.backTrackStackTop = null;
            rEGlobalData.stateStackTop = null;
            if (zExecuteREBytecode) {
                return true;
            }
            if (i3 == -2 && !rEGlobalData.multiline) {
                rEGlobalData.skipped = i2;
                return false;
            }
            i4 = rEGlobalData.skipped + i + 1;
        }
        return false;
    }

    Object executeRegExp(Context context, Scriptable scriptable, RegExpImpl regExpImpl, String str, int[] iArr, int i) {
        Context context2;
        Scriptable scriptable2;
        Object obj;
        NativeRegExp nativeRegExp = this;
        REGlobalData rEGlobalData = new REGlobalData();
        int i2 = iArr[0];
        int length = str.length();
        int i3 = i2 > length ? length : i2;
        SubString subString = null;
        if (!matchRegExp(rEGlobalData, nativeRegExp.re, str, i3, length, regExpImpl.multiline)) {
            if (i != 2) {
                return null;
            }
            return Undefined.instance;
        }
        int i4 = rEGlobalData.cp;
        iArr[0] = i4;
        int i5 = i4 - (rEGlobalData.skipped + i3);
        int i6 = i4 - i5;
        if (i == 0) {
            scriptable2 = null;
            obj = Boolean.TRUE;
            context2 = context;
        } else {
            context2 = context;
            Scriptable scriptableNewArray = context2.newArray(scriptable, 0);
            scriptableNewArray.put(0, scriptableNewArray, str.substring(i6, i6 + i5));
            scriptable2 = scriptableNewArray;
            obj = scriptableNewArray;
        }
        if (nativeRegExp.re.parenCount == 0) {
            regExpImpl.parens = null;
            regExpImpl.lastParen = new SubString();
        } else {
            regExpImpl.parens = new SubString[nativeRegExp.re.parenCount];
            int i7 = 0;
            while (i7 < nativeRegExp.re.parenCount) {
                int iParensIndex = rEGlobalData.parensIndex(i7);
                if (iParensIndex != -1) {
                    subString = new SubString(str, iParensIndex, rEGlobalData.parensLength(i7));
                    regExpImpl.parens[i7] = subString;
                    if (i != 0) {
                        scriptable2.put(i7 + 1, scriptable2, subString.toString());
                    }
                } else if (i != 0) {
                    scriptable2.put(i7 + 1, scriptable2, Undefined.instance);
                }
                i7++;
                nativeRegExp = this;
            }
            regExpImpl.lastParen = subString;
        }
        if (i != 0) {
            scriptable2.put(FirebaseAnalytics.Param.INDEX, scriptable2, Integer.valueOf(rEGlobalData.skipped + i3));
            scriptable2.put("input", scriptable2, str);
        }
        if (regExpImpl.lastMatch == null) {
            regExpImpl.lastMatch = new SubString();
            regExpImpl.leftContext = new SubString();
            regExpImpl.rightContext = new SubString();
        }
        regExpImpl.lastMatch.str = str;
        regExpImpl.lastMatch.index = i6;
        regExpImpl.lastMatch.length = i5;
        regExpImpl.leftContext.str = str;
        if (context2.getLanguageVersion() == 120) {
            regExpImpl.leftContext.index = i3;
            regExpImpl.leftContext.length = rEGlobalData.skipped;
        } else {
            regExpImpl.leftContext.index = 0;
            regExpImpl.leftContext.length = i3 + rEGlobalData.skipped;
        }
        regExpImpl.rightContext.str = str;
        regExpImpl.rightContext.index = i4;
        regExpImpl.rightContext.length = length - i4;
        return obj;
    }

    int getFlags() {
        return this.re.flags;
    }

    private static void reportWarning(Context context, String str, String str2) {
        if (context.hasFeature(11)) {
            Context.reportWarning(ScriptRuntime.getMessage1(str, str2));
        }
    }

    private static void reportError(String str, String str2) {
        throw ScriptRuntime.constructError("SyntaxError", ScriptRuntime.getMessage1(str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findInstanceIdInfo(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.length()
            r1 = 6
            r2 = 5
            r3 = 2
            r4 = 1
            r5 = 4
            r6 = 3
            r7 = 0
            if (r0 != r1) goto L21
            char r0 = r9.charAt(r7)
            r1 = 103(0x67, float:1.44E-43)
            if (r0 != r1) goto L19
            java.lang.String r0 = "global"
            r1 = r6
            goto L43
        L19:
            r1 = 115(0x73, float:1.61E-43)
            if (r0 != r1) goto L41
            java.lang.String r0 = "source"
            r1 = r3
            goto L43
        L21:
            r1 = 9
            if (r0 != r1) goto L39
            char r0 = r9.charAt(r7)
            r1 = 108(0x6c, float:1.51E-43)
            if (r0 != r1) goto L31
            java.lang.String r0 = "lastIndex"
            r1 = r4
            goto L43
        L31:
            r1 = 109(0x6d, float:1.53E-43)
            if (r0 != r1) goto L41
            java.lang.String r0 = "multiline"
            r1 = r2
            goto L43
        L39:
            r1 = 10
            if (r0 != r1) goto L41
            java.lang.String r0 = "ignoreCase"
            r1 = r5
            goto L43
        L41:
            r0 = 0
            r1 = r7
        L43:
            if (r0 == 0) goto L4e
            if (r0 == r9) goto L4e
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L4e
            goto L4f
        L4e:
            r7 = r1
        L4f:
            if (r7 != 0) goto L56
            int r9 = super.findInstanceIdInfo(r9)
            return r9
        L56:
            if (r7 == r4) goto L69
            if (r7 == r3) goto L67
            if (r7 == r6) goto L67
            if (r7 == r5) goto L67
            if (r7 != r2) goto L61
            goto L67
        L61:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L67:
            r9 = 7
            goto L6b
        L69:
            int r9 = r8.lastIndexAttr
        L6b:
            int r9 = instanceIdInfo(r9, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.findInstanceIdInfo(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        if (i == 1) {
            return "lastIndex";
        }
        if (i == 2) {
            return "source";
        }
        if (i == 3) {
            return "global";
        }
        if (i == 4) {
            return "ignoreCase";
        }
        if (i == 5) {
            return "multiline";
        }
        return super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        if (i == 1) {
            return this.lastIndex;
        }
        if (i == 2) {
            return new String(this.re.source);
        }
        if (i == 3) {
            return ScriptRuntime.wrapBoolean((this.re.flags & 1) != 0);
        }
        if (i == 4) {
            return ScriptRuntime.wrapBoolean((this.re.flags & 2) != 0);
        }
        if (i != 5) {
            return super.getInstanceIdValue(i);
        }
        return ScriptRuntime.wrapBoolean((this.re.flags & 4) != 0);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            this.lastIndex = obj;
        } else {
            if (i == 2 || i == 3 || i == 4 || i == 5) {
                return;
            }
            super.setInstanceIdValue(i, obj);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.lastIndexAttr = i2;
        } else {
            super.setInstanceIdAttributes(i, i2);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 0;
        int i3 = 1;
        switch (i) {
            case 1:
                i2 = 2;
                str = "compile";
                String str3 = str;
                i3 = i2;
                str2 = str3;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 2:
                str = InAppPurchaseConstants.METHOD_TO_STRING;
                String str32 = str;
                i3 = i2;
                str2 = str32;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 3:
                str = "toSource";
                String str322 = str;
                i3 = i2;
                str2 = str322;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 4:
                str2 = MacroTag.MACRO_MARKER;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 5:
                str2 = Const.TEST;
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            case 6:
                str2 = "prefix";
                initPrototypeMethod(REGEXP_TAG, i, str2, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(REGEXP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                return realThis(scriptable2, idFunctionObject).compile(context, scriptable, objArr);
            case 2:
            case 3:
                return realThis(scriptable2, idFunctionObject).toString();
            case 4:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
            case 5:
                return Boolean.TRUE.equals(realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 0)) ? Boolean.TRUE : Boolean.FALSE;
            case 6:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 2);
            default:
                throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
    }

    private static NativeRegExp realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof NativeRegExp)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (NativeRegExp) scriptable;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findPrototypeId(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.length()
            r1 = 116(0x74, float:1.63E-43)
            r2 = 0
            r3 = 4
            if (r0 == r3) goto L2e
            r3 = 6
            if (r0 == r3) goto L2b
            r3 = 7
            if (r0 == r3) goto L27
            r3 = 8
            if (r0 == r3) goto L15
            goto L3f
        L15:
            r3 = 3
            char r0 = r6.charAt(r3)
            r4 = 111(0x6f, float:1.56E-43)
            if (r0 != r4) goto L21
            java.lang.String r0 = "toSource"
            goto L41
        L21:
            if (r0 != r1) goto L3f
            java.lang.String r0 = "toString"
            r3 = 2
            goto L41
        L27:
            java.lang.String r0 = "compile"
            r3 = 1
            goto L41
        L2b:
            java.lang.String r0 = "prefix"
            goto L41
        L2e:
            char r0 = r6.charAt(r2)
            r4 = 101(0x65, float:1.42E-43)
            if (r0 != r4) goto L39
            java.lang.String r0 = "exec"
            goto L41
        L39:
            if (r0 != r1) goto L3f
            java.lang.String r0 = "test"
            r3 = 5
            goto L41
        L3f:
            r0 = 0
            r3 = r2
        L41:
            if (r0 == 0) goto L4c
            if (r0 == r6) goto L4c
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L4c
            return r2
        L4c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.findPrototypeId(java.lang.String):int");
    }
}
