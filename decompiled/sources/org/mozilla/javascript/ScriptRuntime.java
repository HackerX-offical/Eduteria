package org.mozilla.javascript;

import androidx.collection.SieveCacheKt;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.BuildConfig;
import com.clevertap.android.sdk.variables.CTVariableUtils;
import com.csvreader.CsvReader;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.mozilla.javascript.NativeIterator;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.typedarrays.NativeArrayBuffer;
import org.mozilla.javascript.typedarrays.NativeDataView;
import org.mozilla.javascript.v8dtoa.DoubleConversion;
import org.mozilla.javascript.v8dtoa.FastDtoa;
import org.mozilla.javascript.xml.XMLLib;
import org.mozilla.javascript.xml.XMLObject;

/* JADX INFO: loaded from: classes10.dex */
public class ScriptRuntime {
    private static final String DEFAULT_NS_TAG = "__default_namespace__";
    public static final int ENUMERATE_ARRAY = 2;
    public static final int ENUMERATE_ARRAY_NO_ITERATOR = 5;
    public static final int ENUMERATE_KEYS = 0;
    public static final int ENUMERATE_KEYS_NO_ITERATOR = 3;
    public static final int ENUMERATE_VALUES = 1;
    public static final int ENUMERATE_VALUES_IN_ORDER = 6;
    public static final int ENUMERATE_VALUES_NO_ITERATOR = 4;
    public static final double NaN;
    public static final Double NaNobj;
    public static final Object[] emptyArgs;
    public static final String[] emptyStrings;
    public static MessageProvider messageProvider;
    public static final double negativeZero;
    public static final Class<?> BooleanClass = Kit.classOrNull("java.lang.Boolean");
    public static final Class<?> ByteClass = Kit.classOrNull("java.lang.Byte");
    public static final Class<?> CharacterClass = Kit.classOrNull("java.lang.Character");
    public static final Class<?> ClassClass = Kit.classOrNull("java.lang.Class");
    public static final Class<?> DoubleClass = Kit.classOrNull("java.lang.Double");
    public static final Class<?> FloatClass = Kit.classOrNull("java.lang.Float");
    public static final Class<?> IntegerClass = Kit.classOrNull("java.lang.Integer");
    public static final Class<?> LongClass = Kit.classOrNull("java.lang.Long");
    public static final Class<?> NumberClass = Kit.classOrNull("java.lang.Number");
    public static final Class<?> ObjectClass = Kit.classOrNull("java.lang.Object");
    public static final Class<?> ShortClass = Kit.classOrNull("java.lang.Short");
    public static final Class<?> StringClass = Kit.classOrNull("java.lang.String");
    public static final Class<?> DateClass = Kit.classOrNull("java.util.Date");
    public static final Class<?> ContextClass = Kit.classOrNull("org.mozilla.javascript.Context");
    public static final Class<?> ContextFactoryClass = Kit.classOrNull("org.mozilla.javascript.ContextFactory");
    public static final Class<?> FunctionClass = Kit.classOrNull("org.mozilla.javascript.Function");
    public static final Class<?> ScriptableObjectClass = Kit.classOrNull("org.mozilla.javascript.ScriptableObject");
    public static final Class<Scriptable> ScriptableClass = Scriptable.class;
    public static Locale ROOT_LOCALE = new Locale("");
    private static final Object LIBRARY_SCOPE_KEY = "LIBRARY_SCOPE";

    public interface MessageProvider {
        String getMessage(String str, Object[] objArr);
    }

    public static boolean isJSLineTerminator(int i) {
        if ((57296 & i) != 0) {
            return false;
        }
        return i == 10 || i == 13 || i == 8232 || i == 8233;
    }

    protected ScriptRuntime() {
    }

    @Deprecated
    public static BaseFunction typeErrorThrower() {
        return typeErrorThrower(Context.getCurrentContext());
    }

    public static BaseFunction typeErrorThrower(Context context) {
        if (context.typeErrorThrower == null) {
            BaseFunction baseFunction = new BaseFunction() { // from class: org.mozilla.javascript.ScriptRuntime.1
                static final long serialVersionUID = -5891740962154902286L;

                @Override // org.mozilla.javascript.BaseFunction
                public int getLength() {
                    return 0;
                }

                @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
                public Object call(Context context2, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                    throw ScriptRuntime.typeError0("msg.op.not.allowed");
                }
            };
            setFunctionProtoAndParent(baseFunction, context.topCallScope);
            baseFunction.preventExtensions();
            context.typeErrorThrower = baseFunction;
        }
        return context.typeErrorThrower;
    }

    static class NoSuchMethodShim implements Callable {
        String methodName;
        Callable noSuchMethodMethod;

        NoSuchMethodShim(Callable callable, String str) {
            this.noSuchMethodMethod = callable;
            this.methodName = str;
        }

        @Override // org.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return this.noSuchMethodMethod.call(context, scriptable, scriptable2, new Object[]{this.methodName, ScriptRuntime.newArrayLiteral(objArr, null, context, scriptable)});
        }
    }

    static {
        double dLongBitsToDouble = Double.longBitsToDouble(9221120237041090560L);
        NaN = dLongBitsToDouble;
        negativeZero = Double.longBitsToDouble(Long.MIN_VALUE);
        NaNobj = new Double(dLongBitsToDouble);
        messageProvider = new DefaultMessageProvider();
        emptyArgs = new Object[0];
        emptyStrings = new String[0];
    }

    public static boolean isRhinoRuntimeType(Class<?> cls) {
        return cls.isPrimitive() ? cls != Character.TYPE : cls == StringClass || cls == BooleanClass || NumberClass.isAssignableFrom(cls) || ScriptableClass.isAssignableFrom(cls);
    }

    public static ScriptableObject initSafeStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        if (scriptableObject == null) {
            scriptableObject = new NativeObject();
        }
        ScriptableObject scriptableObject2 = scriptableObject;
        scriptableObject2.associateValue(LIBRARY_SCOPE_KEY, scriptableObject2);
        new ClassCache().associate(scriptableObject2);
        BaseFunction.init(scriptableObject2, z);
        NativeObject.init(scriptableObject2, z);
        Scriptable objectPrototype = ScriptableObject.getObjectPrototype(scriptableObject2);
        ScriptableObject.getClassPrototype(scriptableObject2, "Function").setPrototype(objectPrototype);
        if (scriptableObject2.getPrototype() == null) {
            scriptableObject2.setPrototype(objectPrototype);
        }
        NativeError.init(scriptableObject2, z);
        NativeGlobal.init(context, scriptableObject2, z);
        NativeArray.init(scriptableObject2, z);
        if (context.getOptimizationLevel() > 0) {
            NativeArray.setMaximumInitialCapacity(200000);
        }
        NativeString.init(scriptableObject2, z);
        NativeBoolean.init(scriptableObject2, z);
        NativeNumber.init(scriptableObject2, z);
        NativeDate.init(scriptableObject2, z);
        NativeMath.init(scriptableObject2, z);
        NativeJSON.init(scriptableObject2, z);
        NativeWith.init(scriptableObject2, z);
        NativeCall.init(scriptableObject2, z);
        NativeScript.init(scriptableObject2, z);
        NativeIterator.init(scriptableObject2, z);
        NativeArrayIterator.init(scriptableObject2, z);
        NativeStringIterator.init(scriptableObject2, z);
        boolean z2 = context.hasFeature(6) && context.getE4xImplementationFactory() != null;
        new LazilyLoadedCtor(scriptableObject2, "RegExp", "org.mozilla.javascript.regexp.NativeRegExp", z, true);
        new LazilyLoadedCtor(scriptableObject2, "Continuation", "org.mozilla.javascript.NativeContinuation", z, true);
        if (z2) {
            String implementationClassName = context.getE4xImplementationFactory().getImplementationClassName();
            new LazilyLoadedCtor(scriptableObject2, "XML", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject2, "XMLList", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject2, "Namespace", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject2, "QName", implementationClassName, z, true);
        }
        if ((context.getLanguageVersion() >= 180 && context.hasFeature(14)) || context.getLanguageVersion() >= 200) {
            new LazilyLoadedCtor(scriptableObject2, NativeArrayBuffer.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeArrayBuffer", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Int8Array", "org.mozilla.javascript.typedarrays.NativeInt8Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Uint8Array", "org.mozilla.javascript.typedarrays.NativeUint8Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Uint8ClampedArray", "org.mozilla.javascript.typedarrays.NativeUint8ClampedArray", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Int16Array", "org.mozilla.javascript.typedarrays.NativeInt16Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Uint16Array", "org.mozilla.javascript.typedarrays.NativeUint16Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Int32Array", "org.mozilla.javascript.typedarrays.NativeInt32Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Uint32Array", "org.mozilla.javascript.typedarrays.NativeUint32Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Float32Array", "org.mozilla.javascript.typedarrays.NativeFloat32Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, "Float64Array", "org.mozilla.javascript.typedarrays.NativeFloat64Array", z, true);
            new LazilyLoadedCtor(scriptableObject2, NativeDataView.CLASS_NAME, "org.mozilla.javascript.typedarrays.NativeDataView", z, true);
        }
        if (context.getLanguageVersion() >= 200) {
            NativeSymbol.init(context, scriptableObject2, z);
        }
        if (scriptableObject2 instanceof TopLevel) {
            ((TopLevel) scriptableObject2).cacheBuiltins();
        }
        return scriptableObject2;
    }

    public static ScriptableObject initStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        ScriptableObject scriptableObjectInitSafeStandardObjects = initSafeStandardObjects(context, scriptableObject, z);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "Packages", "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "getClass", "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "JavaAdapter", "org.mozilla.javascript.JavaAdapter", z, true);
        new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, "JavaImporter", "org.mozilla.javascript.ImporterTopLevel", z, true);
        for (String str : getTopPackageNames()) {
            new LazilyLoadedCtor(scriptableObjectInitSafeStandardObjects, str, "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        }
        return scriptableObjectInitSafeStandardObjects;
    }

    static String[] getTopPackageNames() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new String[]{"java", "javax", "org", "com", "edu", "net", "android"} : new String[]{"java", "javax", "org", "com", "edu", "net"};
    }

    public static ScriptableObject getLibraryScopeOrNull(Scriptable scriptable) {
        return (ScriptableObject) ScriptableObject.getTopScopeValue(scriptable, LIBRARY_SCOPE_KEY);
    }

    public static boolean isJSWhitespaceOrLineTerminator(int i) {
        return isStrWhiteSpaceChar(i) || isJSLineTerminator(i);
    }

    static boolean isStrWhiteSpaceChar(int i) {
        if (i != 32 && i != 160 && i != 65279 && i != 8232 && i != 8233) {
            switch (i) {
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    if (Character.getType(i) == 12) {
                    }
                    break;
            }
            return true;
        }
        return true;
    }

    public static Boolean wrapBoolean(boolean z) {
        return z ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Integer wrapInt(int i) {
        return Integer.valueOf(i);
    }

    public static Number wrapNumber(double d2) {
        if (d2 != d2) {
            return NaNobj;
        }
        return new Double(d2);
    }

    public static boolean toBoolean(Object obj) {
        while (!(obj instanceof Boolean)) {
            if (obj == null || obj == Undefined.instance) {
                return false;
            }
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() != 0;
            }
            if (obj instanceof Number) {
                double dDoubleValue = ((Number) obj).doubleValue();
                return dDoubleValue == dDoubleValue && dDoubleValue != 0.0d;
            }
            if (obj instanceof Scriptable) {
                if ((obj instanceof ScriptableObject) && ((ScriptableObject) obj).avoidObjectDetection()) {
                    return false;
                }
                if (Context.getContext().isVersionECMA1()) {
                    return true;
                }
                obj = ((Scriptable) obj).getDefaultValue(BooleanClass);
                if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                    throw errorWithClassName("msg.primitive.expected", obj);
                }
            } else {
                warnAboutNonJSObject(obj);
                return true;
            }
        }
        return ((Boolean) obj).booleanValue();
    }

    public static double toNumber(Object obj) {
        while (!(obj instanceof Number)) {
            if (obj == null) {
                return 0.0d;
            }
            if (obj == Undefined.instance) {
                return NaN;
            }
            if (obj instanceof String) {
                return toNumber((String) obj);
            }
            if (obj instanceof CharSequence) {
                return toNumber(obj.toString());
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue() ? 1.0d : 0.0d;
            }
            if (obj instanceof Symbol) {
                throw typeError0("msg.not.a.number");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
                if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                    throw errorWithClassName("msg.primitive.expected", obj);
                }
            } else {
                warnAboutNonJSObject(obj);
                return NaN;
            }
        }
        return ((Number) obj).doubleValue();
    }

    public static double toNumber(Object[] objArr, int i) {
        return i < objArr.length ? toNumber(objArr[i]) : NaN;
    }

    static double stringPrefixToNumber(String str, int i, int i2) {
        return stringToNumber(str, i, str.length() - 1, i2, true);
    }

    static double stringToNumber(String str, int i, int i2, int i3) {
        return stringToNumber(str, i, i2, i3, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static double stringToNumber(java.lang.String r27, int r28, int r29, int r30, boolean r31) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.stringToNumber(java.lang.String, int, int, int, boolean):double");
    }

    public static double toNumber(String str) {
        char cCharAt;
        int i;
        char cCharAt2;
        int length = str.length();
        int i2 = 0;
        while (i2 != length) {
            char cCharAt3 = str.charAt(i2);
            if (!isStrWhiteSpaceChar(cCharAt3)) {
                int i3 = length - 1;
                while (true) {
                    cCharAt = str.charAt(i3);
                    if (!isStrWhiteSpaceChar(cCharAt)) {
                        break;
                    }
                    i3--;
                }
                Context currentContext = Context.getCurrentContext();
                boolean z = currentContext == null || currentContext.getLanguageVersion() < 200;
                int i4 = 16;
                if (cCharAt3 == '0') {
                    int i5 = i2 + 2;
                    if (i5 <= i3) {
                        char cCharAt4 = str.charAt(i2 + 1);
                        if (cCharAt4 != 'x' && cCharAt4 != 'X') {
                            i4 = (z || !(cCharAt4 == 'o' || cCharAt4 == 'O')) ? (z || !(cCharAt4 == 'b' || cCharAt4 == 'B')) ? -1 : 2 : 8;
                        }
                        if (i4 != -1) {
                            if (z) {
                                return stringPrefixToNumber(str, i5, i4);
                            }
                            return stringToNumber(str, i5, i3, i4);
                        }
                    }
                } else if (z && ((cCharAt3 == '+' || cCharAt3 == '-') && (i = i2 + 3) <= i3 && str.charAt(i2 + 1) == '0' && ((cCharAt2 = str.charAt(i2 + 2)) == 'x' || cCharAt2 == 'X'))) {
                    double dStringPrefixToNumber = stringPrefixToNumber(str, i, 16);
                    return cCharAt3 == '-' ? -dStringPrefixToNumber : dStringPrefixToNumber;
                }
                if (cCharAt == 'y') {
                    if (cCharAt3 == '+' || cCharAt3 == '-') {
                        i2++;
                    }
                    if (i2 + 7 == i3 && str.regionMatches(i2, "Infinity", 0, 8)) {
                        return cCharAt3 == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                    }
                    return NaN;
                }
                String strSubstring = str.substring(i2, i3 + 1);
                for (int length2 = strSubstring.length() - 1; length2 >= 0; length2--) {
                    char cCharAt5 = strSubstring.charAt(length2);
                    if (('0' > cCharAt5 || cCharAt5 > '9') && cCharAt5 != '.' && cCharAt5 != 'e' && cCharAt5 != 'E' && cCharAt5 != '+' && cCharAt5 != '-') {
                        return NaN;
                    }
                }
                try {
                    return Double.parseDouble(strSubstring);
                } catch (NumberFormatException unused) {
                    return NaN;
                }
            }
            i2++;
        }
        return 0.0d;
    }

    public static Object[] padArguments(Object[] objArr, int i) {
        if (i < objArr.length) {
            return objArr;
        }
        Object[] objArr2 = new Object[i];
        int i2 = 0;
        while (i2 < objArr.length) {
            objArr2[i2] = objArr[i2];
            i2++;
        }
        while (i2 < i) {
            objArr2[i2] = Undefined.instance;
            i2++;
        }
        return objArr2;
    }

    public static String escapeString(String str) {
        return escapeString(str, '\"');
    }

    public static String escapeString(String str, char c2) {
        int i;
        if (c2 != '\"' && c2 != '\'') {
            Kit.codeBug();
        }
        int length = str.length();
        StringBuilder sb = null;
        for (int i2 = 0; i2 != length; i2++) {
            char cCharAt = str.charAt(i2);
            int i3 = 32;
            if (' ' > cCharAt || cCharAt > '~' || cCharAt == c2 || cCharAt == '\\') {
                if (sb == null) {
                    sb = new StringBuilder(length + 3);
                    sb.append(str);
                    sb.setLength(i2);
                }
                if (cCharAt != ' ') {
                    if (cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                i3 = 98;
                                break;
                            case '\t':
                                i3 = 116;
                                break;
                            case '\n':
                                i3 = 110;
                                break;
                            case 11:
                                i3 = 118;
                                break;
                            case '\f':
                                i3 = 102;
                                break;
                            case '\r':
                                i3 = 114;
                                break;
                            default:
                                i3 = -1;
                                break;
                        }
                    } else {
                        i3 = 92;
                    }
                }
                if (i3 >= 0) {
                    sb.append('\\');
                    sb.append((char) i3);
                } else if (cCharAt == c2) {
                    sb.append('\\');
                    sb.append(c2);
                } else {
                    if (cCharAt < 256) {
                        sb.append("\\x");
                        i = 2;
                    } else {
                        sb.append("\\u");
                        i = 4;
                    }
                    for (int i4 = (i - 1) * 4; i4 >= 0; i4 -= 4) {
                        int i5 = (cCharAt >> i4) & 15;
                        sb.append((char) (i5 < 10 ? i5 + 48 : i5 + 87));
                    }
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb == null ? str : sb.toString();
    }

    static boolean isValidIdentifierName(String str, Context context, boolean z) {
        int length = str.length();
        if (length == 0 || !Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i != length; i++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                return false;
            }
        }
        return !TokenStream.isKeyword(str, context.getLanguageVersion(), z);
    }

    public static CharSequence toCharSequence(Object obj) {
        if (obj instanceof NativeString) {
            return ((NativeString) obj).toCharSequence();
        }
        return obj instanceof CharSequence ? (CharSequence) obj : toString(obj);
    }

    public static String toString(Object obj) {
        while (obj != null) {
            if (obj == Undefined.instance || obj == Undefined.SCRIPTABLE_UNDEFINED) {
                return "undefined";
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof Number) {
                return numberToString(((Number) obj).doubleValue(), 10);
            }
            if (obj instanceof Symbol) {
                throw typeError0("msg.not.a.string");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(StringClass);
                if ((obj instanceof Scriptable) && !isSymbol(obj)) {
                    throw errorWithClassName("msg.primitive.expected", obj);
                }
            } else {
                return obj.toString();
            }
        }
        return Constants.NULL_VERSION_ID;
    }

    static String defaultObjectToString(Scriptable scriptable) {
        if (scriptable == null) {
            return "[object Null]";
        }
        if (Undefined.isUndefined(scriptable)) {
            return "[object Undefined]";
        }
        return "[object " + scriptable.getClassName() + ']';
    }

    public static String toString(Object[] objArr, int i) {
        return i < objArr.length ? toString(objArr[i]) : "undefined";
    }

    public static String toString(double d2) {
        return numberToString(d2, 10);
    }

    public static String numberToString(double d2, int i) {
        if (i < 2 || i > 36) {
            throw Context.reportRuntimeError1("msg.bad.radix", Integer.toString(i));
        }
        if (d2 != d2) {
            return BuildConfig.FAQ_URL;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d2 == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (d2 == 0.0d) {
            return "0";
        }
        if (i != 10) {
            return DToA.JS_dtobasestr(i, d2);
        }
        String strNumberToString = FastDtoa.numberToString(d2);
        if (strNumberToString != null) {
            return strNumberToString;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, 0, 0, d2);
        return sb.toString();
    }

    static String uneval(Context context, Scriptable scriptable, Object obj) {
        if (obj == null) {
            return Constants.NULL_VERSION_ID;
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof CharSequence) {
            String strEscapeString = escapeString(obj.toString());
            StringBuilder sb = new StringBuilder(strEscapeString.length() + 2);
            sb.append('\"');
            sb.append(strEscapeString);
            sb.append('\"');
            return sb.toString();
        }
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            if (dDoubleValue == 0.0d && 1.0d / dDoubleValue < 0.0d) {
                return "-0";
            }
            return toString(dDoubleValue);
        }
        if (obj instanceof Boolean) {
            return toString(obj);
        }
        if (obj instanceof Scriptable) {
            Scriptable scriptable2 = (Scriptable) obj;
            if (ScriptableObject.hasProperty(scriptable2, "toSource")) {
                Object property = ScriptableObject.getProperty(scriptable2, "toSource");
                if (property instanceof Function) {
                    return toString(((Function) property).call(context, scriptable, scriptable2, emptyArgs));
                }
            }
            return toString(obj);
        }
        warnAboutNonJSObject(obj);
        return obj.toString();
    }

    static String defaultObjectToSource(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        boolean zHas;
        boolean z;
        Object obj;
        if (context.iterating == null) {
            context.iterating = new ObjToIntMap(31);
            z = true;
            zHas = false;
        } else {
            zHas = context.iterating.has(scriptable2);
            z = false;
        }
        StringBuilder sb = new StringBuilder(128);
        if (z) {
            sb.append("(");
        }
        sb.append('{');
        if (!zHas) {
            try {
                context.iterating.intern(scriptable2);
                Object[] ids = scriptable2.getIds();
                for (int i = 0; i < ids.length; i++) {
                    Object obj2 = ids[i];
                    if (obj2 instanceof Integer) {
                        int iIntValue = ((Integer) obj2).intValue();
                        obj = scriptable2.get(iIntValue, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i > 0) {
                                sb.append(", ");
                            }
                            sb.append(iIntValue);
                            sb.append(':');
                            sb.append(uneval(context, scriptable, obj));
                        }
                    } else {
                        String str = (String) obj2;
                        obj = scriptable2.get(str, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i > 0) {
                                sb.append(", ");
                            }
                            if (isValidIdentifierName(str, context, context.isStrictMode())) {
                                sb.append(str);
                            } else {
                                sb.append('\'');
                                sb.append(escapeString(str, '\''));
                                sb.append('\'');
                            }
                            sb.append(':');
                            sb.append(uneval(context, scriptable, obj));
                        }
                    }
                }
            } finally {
                if (z) {
                    context.iterating = null;
                }
            }
        }
        sb.append('}');
        if (z) {
            sb.append(')');
        }
        return sb.toString();
    }

    public static Scriptable toObject(Scriptable scriptable, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return toObject(Context.getContext(), scriptable, obj);
    }

    @Deprecated
    public static Scriptable toObjectOrNull(Context context, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.instance) {
            return null;
        }
        return toObject(context, getTopCallScope(context), obj);
    }

    public static Scriptable toObjectOrNull(Context context, Object obj, Scriptable scriptable) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.instance) {
            return null;
        }
        return toObject(context, scriptable, obj);
    }

    @Deprecated
    public static Scriptable toObject(Scriptable scriptable, Object obj, Class<?> cls) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return toObject(Context.getContext(), scriptable, obj);
    }

    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj) {
        if (isSymbol(obj)) {
            NativeSymbol nativeSymbol = new NativeSymbol((NativeSymbol) obj);
            setBuiltinProtoAndParent(nativeSymbol, scriptable, TopLevel.Builtins.Symbol);
            return nativeSymbol;
        }
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj instanceof CharSequence) {
            NativeString nativeString = new NativeString((CharSequence) obj);
            setBuiltinProtoAndParent(nativeString, scriptable, TopLevel.Builtins.String);
            return nativeString;
        }
        if (obj instanceof Number) {
            NativeNumber nativeNumber = new NativeNumber(((Number) obj).doubleValue());
            setBuiltinProtoAndParent(nativeNumber, scriptable, TopLevel.Builtins.Number);
            return nativeNumber;
        }
        if (obj instanceof Boolean) {
            NativeBoolean nativeBoolean = new NativeBoolean(((Boolean) obj).booleanValue());
            setBuiltinProtoAndParent(nativeBoolean, scriptable, TopLevel.Builtins.Boolean);
            return nativeBoolean;
        }
        if (obj == null) {
            throw typeError0("msg.null.to.object");
        }
        if (obj == Undefined.instance) {
            throw typeError0("msg.undef.to.object");
        }
        Object objWrap = context.getWrapFactory().wrap(context, scriptable, obj, null);
        if (objWrap instanceof Scriptable) {
            return (Scriptable) objWrap;
        }
        throw errorWithClassName("msg.invalid.type", obj);
    }

    @Deprecated
    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        return toObject(context, scriptable, obj);
    }

    @Deprecated
    public static Object call(Context context, Object obj, Object obj2, Object[] objArr, Scriptable scriptable) {
        if (!(obj instanceof Function)) {
            throw notFunctionError(toString(obj));
        }
        Function function = (Function) obj;
        Scriptable objectOrNull = toObjectOrNull(context, obj2, scriptable);
        if (objectOrNull == null) {
            throw undefCallError(objectOrNull, "function");
        }
        return function.call(context, scriptable, objectOrNull, objArr);
    }

    public static Scriptable newObject(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function existingCtor = getExistingCtor(context, topLevelScope, str);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return existingCtor.construct(context, topLevelScope, objArr);
    }

    public static Scriptable newBuiltinObject(Context context, Scriptable scriptable, TopLevel.Builtins builtins, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function builtinCtor = TopLevel.getBuiltinCtor(context, topLevelScope, builtins);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return builtinCtor.construct(context, topLevelScope, objArr);
    }

    static Scriptable newNativeError(Context context, Scriptable scriptable, TopLevel.NativeErrors nativeErrors, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function nativeErrorCtor = TopLevel.getNativeErrorCtor(context, topLevelScope, nativeErrors);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return nativeErrorCtor.construct(context, topLevelScope, objArr);
    }

    public static double toInteger(Object obj) {
        return toInteger(toNumber(obj));
    }

    public static double toInteger(double d2) {
        if (d2 != d2) {
            return 0.0d;
        }
        if (d2 == 0.0d || d2 == Double.POSITIVE_INFINITY || d2 == Double.NEGATIVE_INFINITY) {
            return d2;
        }
        if (d2 > 0.0d) {
            return Math.floor(d2);
        }
        return Math.ceil(d2);
    }

    public static double toInteger(Object[] objArr, int i) {
        if (i < objArr.length) {
            return toInteger(objArr[i]);
        }
        return 0.0d;
    }

    public static int toInt32(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return toInt32(toNumber(obj));
    }

    public static int toInt32(Object[] objArr, int i) {
        if (i < objArr.length) {
            return toInt32(objArr[i]);
        }
        return 0;
    }

    public static int toInt32(double d2) {
        return DoubleConversion.doubleToInt32(d2);
    }

    public static long toUint32(double d2) {
        return ((long) DoubleConversion.doubleToInt32(d2)) & 4294967295L;
    }

    public static long toUint32(Object obj) {
        return toUint32(toNumber(obj));
    }

    public static char toUint16(Object obj) {
        return (char) DoubleConversion.doubleToInt32(toNumber(obj));
    }

    public static Object setDefaultNamespace(Object obj, Context context) {
        Scriptable topCallScope = context.currentActivationCall;
        if (topCallScope == null) {
            topCallScope = getTopCallScope(context);
        }
        Object defaultXmlNamespace = currentXMLLib(context).toDefaultXmlNamespace(context, obj);
        if (!topCallScope.has(DEFAULT_NS_TAG, topCallScope)) {
            ScriptableObject.defineProperty(topCallScope, DEFAULT_NS_TAG, defaultXmlNamespace, 6);
        } else {
            topCallScope.put(DEFAULT_NS_TAG, topCallScope, defaultXmlNamespace);
        }
        return Undefined.instance;
    }

    public static Object searchDefaultNamespace(Context context) {
        Scriptable topCallScope = context.currentActivationCall;
        if (topCallScope == null) {
            topCallScope = getTopCallScope(context);
        }
        while (true) {
            Scriptable parentScope = topCallScope.getParentScope();
            if (parentScope == null) {
                Object property = ScriptableObject.getProperty(topCallScope, DEFAULT_NS_TAG);
                if (property == Scriptable.NOT_FOUND) {
                    return null;
                }
                return property;
            }
            Object obj = topCallScope.get(DEFAULT_NS_TAG, topCallScope);
            if (obj != Scriptable.NOT_FOUND) {
                return obj;
            }
            topCallScope = parentScope;
        }
    }

    public static Object getTopLevelProp(Scriptable scriptable, String str) {
        return ScriptableObject.getProperty(ScriptableObject.getTopLevelScope(scriptable), str);
    }

    static Function getExistingCtor(Context context, Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property instanceof Function) {
            return (Function) property;
        }
        if (property == Scriptable.NOT_FOUND) {
            throw Context.reportRuntimeError1("msg.ctor.not.found", str);
        }
        throw Context.reportRuntimeError1("msg.not.ctor", str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r4 <= (r5 != 0 ? 8 : 7)) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long indexFromString(java.lang.String r12) {
        /*
            int r0 = r12.length()
            r1 = -1
            if (r0 <= 0) goto L67
            r3 = 0
            char r4 = r12.charAt(r3)
            r5 = 45
            r6 = 48
            r7 = 1
            if (r4 != r5) goto L1f
            if (r0 <= r7) goto L1f
            char r4 = r12.charAt(r7)
            if (r4 != r6) goto L1d
            return r1
        L1d:
            r5 = r7
            goto L20
        L1f:
            r5 = r3
        L20:
            r8 = r5
            int r4 = r4 + (-48)
            if (r4 < 0) goto L67
            r9 = 9
            if (r4 > r9) goto L67
            if (r5 == 0) goto L2e
            r10 = 11
            goto L30
        L2e:
            r10 = 10
        L30:
            if (r0 > r10) goto L67
            int r10 = -r4
            int r8 = r8 + r7
            if (r10 == 0) goto L4a
        L36:
            if (r8 == r0) goto L4a
            char r4 = r12.charAt(r8)
            int r4 = r4 - r6
            if (r4 < 0) goto L4a
            if (r4 > r9) goto L4a
            int r3 = r10 * 10
            int r3 = r3 - r4
            int r8 = r8 + 1
            r11 = r10
            r10 = r3
            r3 = r11
            goto L36
        L4a:
            if (r8 != r0) goto L67
            r12 = -214748364(0xfffffffff3333334, float:-1.4197688E31)
            if (r3 > r12) goto L5b
            if (r3 != r12) goto L67
            if (r5 == 0) goto L58
            r12 = 8
            goto L59
        L58:
            r12 = 7
        L59:
            if (r4 > r12) goto L67
        L5b:
            if (r5 == 0) goto L5e
            goto L5f
        L5e:
            int r10 = -r10
        L5f:
            long r0 = (long) r10
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r0 = r0 & r2
            return r0
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.indexFromString(java.lang.String):long");
    }

    public static long testUint32String(String str) {
        int length = str.length();
        if (1 <= length && length <= 10) {
            int iCharAt = str.charAt(0) - '0';
            if (iCharAt == 0) {
                return length == 1 ? 0L : -1L;
            }
            if (1 <= iCharAt && iCharAt <= 9) {
                long j = iCharAt;
                for (int i = 1; i != length; i++) {
                    int iCharAt2 = str.charAt(i) - '0';
                    if (iCharAt2 < 0 || iCharAt2 > 9) {
                        return -1L;
                    }
                    j = (j * 10) + ((long) iCharAt2);
                }
                if ((j >>> 32) == 0) {
                    return j;
                }
            }
        }
        return -1L;
    }

    static Object getIndexObject(String str) {
        long jIndexFromString = indexFromString(str);
        return jIndexFromString >= 0 ? Integer.valueOf((int) jIndexFromString) : str;
    }

    static Object getIndexObject(double d2) {
        int i = (int) d2;
        if (i == d2) {
            return Integer.valueOf(i);
        }
        return toString(d2);
    }

    static String toStringIdOrIndex(Context context, Object obj) {
        String string;
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            int i = (int) dDoubleValue;
            if (i == dDoubleValue) {
                storeIndexResult(context, i);
                return null;
            }
            return toString(obj);
        }
        if (obj instanceof String) {
            string = (String) obj;
        } else {
            string = toString(obj);
        }
        long jIndexFromString = indexFromString(string);
        if (jIndexFromString < 0) {
            return string;
        }
        storeIndexResult(context, (int) jIndexFromString);
        return null;
    }

    @Deprecated
    public static Object getObjectElem(Object obj, Object obj2, Context context) {
        return getObjectElem(obj, obj2, context, getTopCallScope(context));
    }

    public static Object getObjectElem(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, obj2);
        }
        return getObjectElem(objectOrNull, obj2, context);
    }

    public static Object getObjectElem(Scriptable scriptable, Object obj, Context context) {
        Object property;
        if (scriptable instanceof XMLObject) {
            property = ((XMLObject) scriptable).get(context, obj);
        } else if (isSymbol(obj)) {
            property = ScriptableObject.getProperty(scriptable, (Symbol) obj);
        } else {
            String stringIdOrIndex = toStringIdOrIndex(context, obj);
            if (stringIdOrIndex == null) {
                property = ScriptableObject.getProperty(scriptable, lastIndexResult(context));
            } else {
                property = ScriptableObject.getProperty(scriptable, stringIdOrIndex);
            }
        }
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    @Deprecated
    public static Object getObjectProp(Object obj, String str, Context context) {
        return getObjectProp(obj, str, context, getTopCallScope(context));
    }

    public static Object getObjectProp(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        return getObjectProp(objectOrNull, str, context);
    }

    public static Object getObjectProp(Scriptable scriptable, String str, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property != Scriptable.NOT_FOUND) {
            return property;
        }
        if (context.hasFeature(11)) {
            Context.reportWarning(getMessage1("msg.ref.undefined.prop", str));
        }
        return Undefined.instance;
    }

    @Deprecated
    public static Object getObjectPropNoWarn(Object obj, String str, Context context) {
        return getObjectPropNoWarn(obj, str, context, getTopCallScope(context));
    }

    public static Object getObjectPropNoWarn(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        Object property = ScriptableObject.getProperty(objectOrNull, str);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    @Deprecated
    public static Object getObjectIndex(Object obj, double d2, Context context) {
        return getObjectIndex(obj, d2, context, getTopCallScope(context));
    }

    public static Object getObjectIndex(Object obj, double d2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, toString(d2));
        }
        int i = (int) d2;
        if (i == d2) {
            return getObjectIndex(objectOrNull, i, context);
        }
        return getObjectProp(objectOrNull, toString(d2), context);
    }

    public static Object getObjectIndex(Scriptable scriptable, int i, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, i);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    @Deprecated
    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context) {
        return setObjectElem(obj, obj2, obj3, context, getTopCallScope(context));
    }

    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefWriteError(obj, obj2, obj3);
        }
        return setObjectElem(objectOrNull, obj2, obj3, context);
    }

    public static Object setObjectElem(Scriptable scriptable, Object obj, Object obj2, Context context) {
        if (scriptable instanceof XMLObject) {
            ((XMLObject) scriptable).put(context, obj, obj2);
            return obj2;
        }
        if (isSymbol(obj)) {
            ScriptableObject.putProperty(scriptable, (Symbol) obj, obj2);
            return obj2;
        }
        String stringIdOrIndex = toStringIdOrIndex(context, obj);
        if (stringIdOrIndex == null) {
            ScriptableObject.putProperty(scriptable, lastIndexResult(context), obj2);
            return obj2;
        }
        ScriptableObject.putProperty(scriptable, stringIdOrIndex, obj2);
        return obj2;
    }

    @Deprecated
    public static Object setObjectProp(Object obj, String str, Object obj2, Context context) {
        return setObjectProp(obj, str, obj2, context, getTopCallScope(context));
    }

    public static Object setObjectProp(Object obj, String str, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefWriteError(obj, str, obj2);
        }
        return setObjectProp(objectOrNull, str, obj2, context);
    }

    public static Object setObjectProp(Scriptable scriptable, String str, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, str, obj);
        return obj;
    }

    @Deprecated
    public static Object setObjectIndex(Object obj, double d2, Object obj2, Context context) {
        return setObjectIndex(obj, d2, obj2, context, getTopCallScope(context));
    }

    public static Object setObjectIndex(Object obj, double d2, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefWriteError(obj, String.valueOf(d2), obj2);
        }
        int i = (int) d2;
        if (i == d2) {
            return setObjectIndex(objectOrNull, i, obj2, context);
        }
        return setObjectProp(objectOrNull, toString(d2), obj2, context);
    }

    public static Object setObjectIndex(Scriptable scriptable, int i, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, i, obj);
        return obj;
    }

    public static boolean deleteObjectElem(Scriptable scriptable, Object obj, Context context) {
        boolean zHas;
        if (isSymbol(obj)) {
            SymbolScriptable symbolScriptableEnsureSymbolScriptable = ScriptableObject.ensureSymbolScriptable(scriptable);
            Symbol symbol = (Symbol) obj;
            symbolScriptableEnsureSymbolScriptable.delete(symbol);
            zHas = symbolScriptableEnsureSymbolScriptable.has(symbol, scriptable);
        } else {
            String stringIdOrIndex = toStringIdOrIndex(context, obj);
            if (stringIdOrIndex == null) {
                int iLastIndexResult = lastIndexResult(context);
                scriptable.delete(iLastIndexResult);
                zHas = scriptable.has(iLastIndexResult, scriptable);
            } else {
                scriptable.delete(stringIdOrIndex);
                zHas = scriptable.has(stringIdOrIndex, scriptable);
            }
        }
        return !zHas;
    }

    public static boolean hasObjectElem(Scriptable scriptable, Object obj, Context context) {
        if (isSymbol(obj)) {
            return ScriptableObject.hasProperty(scriptable, (Symbol) obj);
        }
        String stringIdOrIndex = toStringIdOrIndex(context, obj);
        if (stringIdOrIndex == null) {
            return ScriptableObject.hasProperty(scriptable, lastIndexResult(context));
        }
        return ScriptableObject.hasProperty(scriptable, stringIdOrIndex);
    }

    public static Object refGet(Ref ref, Context context) {
        return ref.get(context);
    }

    @Deprecated
    public static Object refSet(Ref ref, Object obj, Context context) {
        return refSet(ref, obj, context, getTopCallScope(context));
    }

    public static Object refSet(Ref ref, Object obj, Context context, Scriptable scriptable) {
        return ref.set(context, scriptable, obj);
    }

    public static Object refDel(Ref ref, Context context) {
        return wrapBoolean(ref.delete(context));
    }

    static boolean isSpecialProperty(String str) {
        return str.equals("__proto__") || str.equals("__parent__");
    }

    @Deprecated
    public static Ref specialRef(Object obj, String str, Context context) {
        return specialRef(obj, str, context, getTopCallScope(context));
    }

    public static Ref specialRef(Object obj, String str, Context context, Scriptable scriptable) {
        return SpecialRef.createSpecial(context, scriptable, obj, str);
    }

    @Deprecated
    public static Object delete(Object obj, Object obj2, Context context) {
        return delete(obj, obj2, context, false);
    }

    @Deprecated
    public static Object delete(Object obj, Object obj2, Context context, boolean z) {
        return delete(obj, obj2, context, getTopCallScope(context), z);
    }

    public static Object delete(Object obj, Object obj2, Context context, Scriptable scriptable, boolean z) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            return wrapBoolean(deleteObjectElem(objectOrNull, obj2, context));
        }
        if (z) {
            return Boolean.TRUE;
        }
        throw undefDeleteError(obj, obj2);
    }

    public static Object name(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope == null) {
            Object obj = topScopeName(context, scriptable, str);
            if (obj != Scriptable.NOT_FOUND) {
                return obj;
            }
            throw notFoundError(scriptable, str);
        }
        return nameOrFunction(context, scriptable, parentScope, str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r6 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075 A[LOOP:0: B:3:0x0002->B:43:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object nameOrFunction(org.mozilla.javascript.Context r5, org.mozilla.javascript.Scriptable r6, org.mozilla.javascript.Scriptable r7, java.lang.String r8, boolean r9) {
        /*
            r0 = 0
            r1 = r6
        L2:
            boolean r2 = r1 instanceof org.mozilla.javascript.NativeWith
            if (r2 == 0) goto L28
            org.mozilla.javascript.Scriptable r1 = r1.getPrototype()
            boolean r2 = r1 instanceof org.mozilla.javascript.xml.XMLObject
            if (r2 == 0) goto L1f
            org.mozilla.javascript.xml.XMLObject r1 = (org.mozilla.javascript.xml.XMLObject) r1
            boolean r2 = r1.has(r8, r1)
            if (r2 == 0) goto L1b
            java.lang.Object r6 = r1.get(r8, r1)
            goto L65
        L1b:
            if (r0 != 0) goto L48
            r0 = r1
            goto L48
        L1f:
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty(r1, r8)
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r2 == r3) goto L48
            goto L46
        L28:
            boolean r2 = r1 instanceof org.mozilla.javascript.NativeCall
            if (r2 == 0) goto L3e
            java.lang.Object r1 = r1.get(r8, r1)
            java.lang.Object r2 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r1 == r2) goto L48
            if (r9 == 0) goto L3a
            org.mozilla.javascript.Scriptable r6 = org.mozilla.javascript.ScriptableObject.getTopLevelScope(r7)
        L3a:
            r4 = r1
            r1 = r6
            r6 = r4
            goto L65
        L3e:
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty(r1, r8)
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r2 == r3) goto L48
        L46:
            r6 = r2
            goto L65
        L48:
            org.mozilla.javascript.Scriptable r1 = r7.getParentScope()
            if (r1 != 0) goto L75
            java.lang.Object r6 = topScopeName(r5, r7, r8)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r6 != r1) goto L64
            if (r0 == 0) goto L5f
            if (r9 != 0) goto L5f
            java.lang.Object r6 = r0.get(r8, r0)
            goto L64
        L5f:
            java.lang.RuntimeException r5 = notFoundError(r7, r8)
            throw r5
        L64:
            r1 = r7
        L65:
            if (r9 == 0) goto L74
            boolean r7 = r6 instanceof org.mozilla.javascript.Callable
            if (r7 == 0) goto L6f
            storeScriptable(r5, r1)
            return r6
        L6f:
            java.lang.RuntimeException r5 = notFunctionError(r6, r8)
            throw r5
        L74:
            return r6
        L75:
            r4 = r1
            r1 = r7
            r7 = r4
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.nameOrFunction(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.String, boolean):java.lang.Object");
    }

    private static Object topScopeName(Context context, Scriptable scriptable, String str) {
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.getProperty(scriptable, str);
    }

    public static Scriptable bind(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        XMLObject xMLObject = null;
        if (parentScope != null) {
            XMLObject xMLObject2 = null;
            while (true) {
                if (scriptable instanceof NativeWith) {
                    Scriptable prototype = scriptable.getPrototype();
                    if (prototype instanceof XMLObject) {
                        XMLObject xMLObject3 = (XMLObject) prototype;
                        if (xMLObject3.has(context, str)) {
                            return xMLObject3;
                        }
                        if (xMLObject2 == null) {
                            xMLObject2 = xMLObject3;
                        }
                    } else if (ScriptableObject.hasProperty(prototype, str)) {
                        return prototype;
                    }
                    Scriptable parentScope2 = parentScope.getParentScope();
                    if (parentScope2 == null) {
                        break;
                    }
                    Scriptable scriptable2 = parentScope;
                    parentScope = parentScope2;
                    scriptable = scriptable2;
                } else {
                    while (!ScriptableObject.hasProperty(scriptable, str)) {
                        Scriptable parentScope3 = parentScope.getParentScope();
                        if (parentScope3 != null) {
                            Scriptable scriptable3 = parentScope;
                            parentScope = parentScope3;
                            scriptable = scriptable3;
                        }
                    }
                    return scriptable;
                }
            }
            scriptable = parentScope;
            xMLObject = xMLObject2;
        }
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.hasProperty(scriptable, str) ? scriptable : xMLObject;
    }

    public static Object setName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
            return obj;
        }
        if (context.hasFeature(11) || context.hasFeature(8)) {
            Context.reportWarning(getMessage1("msg.assn.create.strict", str));
        }
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable2);
        if (context.useDynamicScope) {
            topLevelScope = checkDynamicScope(context.topCallScope, topLevelScope);
        }
        topLevelScope.put(str, topLevelScope, obj);
        return obj;
    }

    public static Object strictSetName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
            return obj;
        }
        throw constructError("ReferenceError", "Assignment to undefined \"" + str + "\" in strict mode");
    }

    public static Object setConst(Scriptable scriptable, Object obj, Context context, String str) {
        if (scriptable instanceof XMLObject) {
            scriptable.put(str, scriptable, obj);
            return obj;
        }
        ScriptableObject.putConstProperty(scriptable, str, obj);
        return obj;
    }

    private static class IdEnumeration implements Serializable {
        private static final long serialVersionUID = 1;
        Object currentId;
        boolean enumNumbers;
        int enumType;
        Object[] ids;
        int index;
        Scriptable iterator;
        Scriptable obj;
        ObjToIntMap used;

        private IdEnumeration() {
        }
    }

    public static Scriptable toIterator(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z) {
        if (!ScriptableObject.hasProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME)) {
            return null;
        }
        Object property = ScriptableObject.getProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME);
        if (!(property instanceof Callable)) {
            throw typeError0("msg.invalid.iterator");
        }
        Object objCall = ((Callable) property).call(context, scriptable, scriptable2, new Object[]{z ? Boolean.TRUE : Boolean.FALSE});
        if (!(objCall instanceof Scriptable)) {
            throw typeError0("msg.iterator.primitive");
        }
        return (Scriptable) objCall;
    }

    @Deprecated
    public static Object enumInit(Object obj, Context context, boolean z) {
        return enumInit(obj, context, z ? 1 : 0);
    }

    @Deprecated
    public static Object enumInit(Object obj, Context context, int i) {
        return enumInit(obj, context, getTopCallScope(context), i);
    }

    public static Object enumInit(Object obj, Context context, Scriptable scriptable, int i) {
        IdEnumeration idEnumeration = new IdEnumeration();
        idEnumeration.obj = toObjectOrNull(context, obj, scriptable);
        if (i == 6) {
            idEnumeration.enumType = i;
            idEnumeration.iterator = null;
            return enumInitInOrder(context, idEnumeration);
        }
        if (idEnumeration.obj != null) {
            idEnumeration.enumType = i;
            idEnumeration.iterator = null;
            if (i != 3 && i != 4 && i != 5) {
                idEnumeration.iterator = toIterator(context, idEnumeration.obj.getParentScope(), idEnumeration.obj, i == 0);
            }
            if (idEnumeration.iterator == null) {
                enumChangeObject(idEnumeration);
            }
        }
        return idEnumeration;
    }

    private static Object enumInitInOrder(Context context, IdEnumeration idEnumeration) {
        if (!(idEnumeration.obj instanceof ScriptableObject)) {
            throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
        }
        ScriptableObject scriptableObject = (ScriptableObject) idEnumeration.obj;
        if (!ScriptableObject.hasProperty(scriptableObject, SymbolKey.ITERATOR)) {
            throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
        }
        Object property = ScriptableObject.getProperty(scriptableObject, SymbolKey.ITERATOR);
        if (!(property instanceof Callable)) {
            throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
        }
        Object objCall = ((Callable) property).call(context, idEnumeration.obj.getParentScope(), idEnumeration.obj, new Object[0]);
        if (!(objCall instanceof Scriptable)) {
            throw typeError1("msg.not.iterable", toString(idEnumeration.obj));
        }
        idEnumeration.iterator = (Scriptable) objCall;
        return idEnumeration;
    }

    public static void setEnumNumbers(Object obj, boolean z) {
        ((IdEnumeration) obj).enumNumbers = z;
    }

    public static Boolean enumNext(Object obj) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (idEnumeration.iterator != null) {
            if (idEnumeration.enumType == 6) {
                return enumNextInOrder(idEnumeration);
            }
            Object property = ScriptableObject.getProperty(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
            if (!(property instanceof Callable)) {
                return Boolean.FALSE;
            }
            try {
                idEnumeration.currentId = ((Callable) property).call(Context.getContext(), idEnumeration.iterator.getParentScope(), idEnumeration.iterator, emptyArgs);
                return Boolean.TRUE;
            } catch (JavaScriptException e2) {
                if (e2.getValue() instanceof NativeIterator.StopIteration) {
                    return Boolean.FALSE;
                }
                throw e2;
            }
        }
        while (idEnumeration.obj != null) {
            if (idEnumeration.index == idEnumeration.ids.length) {
                idEnumeration.obj = idEnumeration.obj.getPrototype();
                enumChangeObject(idEnumeration);
            } else {
                Object[] objArr = idEnumeration.ids;
                int i = idEnumeration.index;
                idEnumeration.index = i + 1;
                Object obj2 = objArr[i];
                if (idEnumeration.used == null || !idEnumeration.used.has(obj2)) {
                    if (obj2 instanceof Symbol) {
                        continue;
                    } else if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (idEnumeration.obj.has(str, idEnumeration.obj)) {
                            idEnumeration.currentId = str;
                            return Boolean.TRUE;
                        }
                    } else {
                        int iIntValue = ((Number) obj2).intValue();
                        if (idEnumeration.obj.has(iIntValue, idEnumeration.obj)) {
                            idEnumeration.currentId = idEnumeration.enumNumbers ? Integer.valueOf(iIntValue) : String.valueOf(iIntValue);
                            return Boolean.TRUE;
                        }
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    private static Boolean enumNextInOrder(IdEnumeration idEnumeration) {
        Object property = ScriptableObject.getProperty(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
        if (!(property instanceof Callable)) {
            throw notFunctionError(idEnumeration.iterator, ES6Iterator.NEXT_METHOD);
        }
        Context context = Context.getContext();
        Scriptable parentScope = idEnumeration.iterator.getParentScope();
        Scriptable object = toObject(context, parentScope, ((Callable) property).call(context, parentScope, idEnumeration.iterator, emptyArgs));
        Object property2 = ScriptableObject.getProperty(object, ES6Iterator.DONE_PROPERTY);
        if (property2 != ScriptableObject.NOT_FOUND && toBoolean(property2)) {
            return Boolean.FALSE;
        }
        idEnumeration.currentId = ScriptableObject.getProperty(object, "value");
        return Boolean.TRUE;
    }

    public static Object enumId(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (idEnumeration.iterator != null) {
            return idEnumeration.currentId;
        }
        int i = idEnumeration.enumType;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                throw Kit.codeBug();
                            }
                        }
                    }
                }
                return context.newArray(ScriptableObject.getTopLevelScope(idEnumeration.obj), new Object[]{idEnumeration.currentId, enumValue(obj, context)});
            }
            return enumValue(obj, context);
        }
        return idEnumeration.currentId;
    }

    public static Object enumValue(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (isSymbol(idEnumeration.currentId)) {
            return ScriptableObject.ensureSymbolScriptable(idEnumeration.obj).get((Symbol) idEnumeration.currentId, idEnumeration.obj);
        }
        String stringIdOrIndex = toStringIdOrIndex(context, idEnumeration.currentId);
        if (stringIdOrIndex == null) {
            return idEnumeration.obj.get(lastIndexResult(context), idEnumeration.obj);
        }
        return idEnumeration.obj.get(stringIdOrIndex, idEnumeration.obj);
    }

    private static void enumChangeObject(IdEnumeration idEnumeration) {
        Object[] ids = null;
        while (idEnumeration.obj != null) {
            ids = idEnumeration.obj.getIds();
            if (ids.length != 0) {
                break;
            } else {
                idEnumeration.obj = idEnumeration.obj.getPrototype();
            }
        }
        if (idEnumeration.obj != null && idEnumeration.ids != null) {
            Object[] objArr = idEnumeration.ids;
            int length = objArr.length;
            if (idEnumeration.used == null) {
                idEnumeration.used = new ObjToIntMap(length);
            }
            for (int i = 0; i != length; i++) {
                idEnumeration.used.intern(objArr[i]);
            }
        }
        idEnumeration.ids = ids;
        idEnumeration.index = 0;
    }

    public static Callable getNameFunctionAndThis(String str, Context context, Scriptable scriptable) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope == null) {
            Object obj = topScopeName(context, scriptable, str);
            if (!(obj instanceof Callable)) {
                if (obj == Scriptable.NOT_FOUND) {
                    throw notFoundError(scriptable, str);
                }
                throw notFunctionError(obj, str);
            }
            storeScriptable(context, scriptable);
            return (Callable) obj;
        }
        return (Callable) nameOrFunction(context, scriptable, parentScope, str, true);
    }

    @Deprecated
    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context) {
        return getElemFunctionAndThis(obj, obj2, context, getTopCallScope(context));
    }

    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull;
        Object property;
        if (isSymbol(obj2)) {
            objectOrNull = toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(obj, String.valueOf(obj2));
            }
            property = ScriptableObject.getProperty(objectOrNull, (Symbol) obj2);
        } else {
            String stringIdOrIndex = toStringIdOrIndex(context, obj2);
            if (stringIdOrIndex != null) {
                return getPropFunctionAndThis(obj, stringIdOrIndex, context, scriptable);
            }
            int iLastIndexResult = lastIndexResult(context);
            objectOrNull = toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                throw undefCallError(obj, String.valueOf(obj2));
            }
            property = ScriptableObject.getProperty(objectOrNull, iLastIndexResult);
        }
        if (!(property instanceof Callable)) {
            throw notFunctionError(property, obj2);
        }
        storeScriptable(context, objectOrNull);
        return (Callable) property;
    }

    @Deprecated
    public static Callable getPropFunctionAndThis(Object obj, String str, Context context) {
        return getPropFunctionAndThis(obj, str, context, getTopCallScope(context));
    }

    public static Callable getPropFunctionAndThis(Object obj, String str, Context context, Scriptable scriptable) {
        return getPropFunctionAndThisHelper(obj, str, context, toObjectOrNull(context, obj, scriptable));
    }

    private static Callable getPropFunctionAndThisHelper(Object obj, String str, Context context, Scriptable scriptable) {
        if (scriptable == null) {
            throw undefCallError(obj, str);
        }
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (!(property instanceof Callable)) {
            Object property2 = ScriptableObject.getProperty(scriptable, "__noSuchMethod__");
            if (property2 instanceof Callable) {
                property = new NoSuchMethodShim((Callable) property2, str);
            }
        }
        if (!(property instanceof Callable)) {
            throw notFunctionError(scriptable, property, str);
        }
        storeScriptable(context, scriptable);
        return (Callable) property;
    }

    public static Callable getValueFunctionAndThis(Object obj, Context context) {
        if (!(obj instanceof Callable)) {
            throw notFunctionError(obj);
        }
        Callable callable = (Callable) obj;
        Scriptable parentScope = callable instanceof Scriptable ? ((Scriptable) callable).getParentScope() : null;
        if (parentScope == null) {
            if (context.topCallScope == null) {
                throw new IllegalStateException();
            }
            parentScope = context.topCallScope;
        }
        if (parentScope.getParentScope() != null && !(parentScope instanceof NativeWith) && (parentScope instanceof NativeCall)) {
            parentScope = ScriptableObject.getTopLevelScope(parentScope);
        }
        storeScriptable(context, parentScope);
        return callable;
    }

    public static Ref callRef(Callable callable, Scriptable scriptable, Object[] objArr, Context context) {
        if (callable instanceof RefCallable) {
            RefCallable refCallable = (RefCallable) callable;
            Ref refRefCall = refCallable.refCall(context, scriptable, objArr);
            if (refRefCall != null) {
                return refRefCall;
            }
            throw new IllegalStateException(refCallable.getClass().getName() + ".refCall() returned null");
        }
        throw constructError("ReferenceError", getMessage1("msg.no.ref.from.function", toString(callable)));
    }

    public static Scriptable newObject(Object obj, Context context, Scriptable scriptable, Object[] objArr) {
        if (!(obj instanceof Function)) {
            throw notFunctionError(obj);
        }
        return ((Function) obj).construct(context, scriptable, objArr);
    }

    public static Object callSpecial(Context context, Callable callable, Scriptable scriptable, Object[] objArr, Scriptable scriptable2, Scriptable scriptable3, int i, String str, int i2) {
        Context context2;
        Object[] objArr2;
        Scriptable scriptable4;
        if (i != 1) {
            context2 = context;
            objArr2 = objArr;
            scriptable4 = scriptable2;
            if (i == 2) {
                if (NativeWith.isWithFunction(callable)) {
                    throw Context.reportRuntimeError1("msg.only.from.new", "With");
                }
            } else {
                throw Kit.codeBug();
            }
        } else {
            if (scriptable.getParentScope() == null && NativeGlobal.isEvalFunction(callable)) {
                return evalSpecial(context, scriptable2, scriptable3, objArr, str, i2);
            }
            context2 = context;
            objArr2 = objArr;
            scriptable4 = scriptable2;
        }
        return callable.call(context2, scriptable4, scriptable, objArr2);
    }

    public static Object newSpecial(Context context, Object obj, Object[] objArr, Scriptable scriptable, int i) {
        if (i == 1) {
            if (NativeGlobal.isEvalFunction(obj)) {
                throw typeError1("msg.not.ctor", "eval");
            }
        } else if (i == 2) {
            if (NativeWith.isWithFunction(obj)) {
                return NativeWith.newWithSpecial(context, scriptable, objArr);
            }
        } else {
            throw Kit.codeBug();
        }
        return newObject(obj, context, scriptable, objArr);
    }

    public static Object applyOrCall(boolean z, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable topCallScope;
        Object[] applyArguments;
        int length = objArr.length;
        Callable callable = getCallable(scriptable2);
        if (length != 0) {
            topCallScope = (!context.hasFeature(15) && objArr[0] == Undefined.instance) ? Undefined.SCRIPTABLE_UNDEFINED : toObjectOrNull(context, objArr[0], scriptable);
        } else {
            topCallScope = null;
        }
        if (topCallScope == null && context.hasFeature(15)) {
            topCallScope = getTopCallScope(context);
        }
        if (z) {
            if (length <= 1) {
                applyArguments = emptyArgs;
            } else {
                applyArguments = getApplyArguments(context, objArr[1]);
            }
        } else if (length <= 1) {
            applyArguments = emptyArgs;
        } else {
            int i = length - 1;
            applyArguments = new Object[i];
            System.arraycopy(objArr, 1, applyArguments, 0, i);
        }
        return callable.call(context, scriptable, topCallScope, applyArguments);
    }

    private static boolean isArrayLike(Scriptable scriptable) {
        if (scriptable != null) {
            return (scriptable instanceof NativeArray) || (scriptable instanceof Arguments) || ScriptableObject.hasProperty(scriptable, Range.ATTR_LENGTH);
        }
        return false;
    }

    static Object[] getApplyArguments(Context context, Object obj) {
        if (obj == null || obj == Undefined.instance) {
            return emptyArgs;
        }
        if (obj instanceof Scriptable) {
            Scriptable scriptable = (Scriptable) obj;
            if (isArrayLike(scriptable)) {
                return context.getElements(scriptable);
            }
        }
        if (obj instanceof ScriptableObject) {
            return emptyArgs;
        }
        throw typeError0("msg.arg.isnt.array");
    }

    static Callable getCallable(Scriptable scriptable) {
        if (scriptable instanceof Callable) {
            return (Callable) scriptable;
        }
        Object defaultValue = scriptable.getDefaultValue(FunctionClass);
        if (!(defaultValue instanceof Callable)) {
            throw notFunctionError(defaultValue, scriptable);
        }
        return (Callable) defaultValue;
    }

    public static Object evalSpecial(Context context, Scriptable scriptable, Object obj, Object[] objArr, String str, int i) {
        if (objArr.length < 1) {
            return Undefined.instance;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof CharSequence)) {
            if (context.hasFeature(11) || context.hasFeature(9)) {
                throw Context.reportRuntimeError0("msg.eval.nonstring.strict");
            }
            Context.reportWarning(getMessage0("msg.eval.nonstring"));
            return obj2;
        }
        if (str == null) {
            int[] iArr = new int[1];
            String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
            if (sourcePositionFromStack != null) {
                i = iArr[0];
                str = sourcePositionFromStack;
            } else {
                str = "";
            }
        }
        String strMakeUrlForGeneratedScript = makeUrlForGeneratedScript(true, str, i);
        ErrorReporter errorReporterForEval = DefaultErrorReporter.forEval(context.getErrorReporter());
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter == null) {
            throw new JavaScriptException("Interpreter not present", str, i);
        }
        Script scriptCompileString = context.compileString(obj2.toString(), evaluatorCreateInterpreter, errorReporterForEval, strMakeUrlForGeneratedScript, 1, null);
        evaluatorCreateInterpreter.setEvalScriptFlag(scriptCompileString);
        return ((Callable) scriptCompileString).call(context, scriptable, (Scriptable) obj, emptyArgs);
    }

    public static String typeof(Object obj) {
        if (obj == null) {
            return "object";
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof ScriptableObject) {
            return ((ScriptableObject) obj).getTypeOf();
        }
        if (obj instanceof Scriptable) {
            return obj instanceof Callable ? "function" : "object";
        }
        if (obj instanceof CharSequence) {
            return "string";
        }
        if (obj instanceof Number) {
            return CTVariableUtils.NUMBER;
        }
        if (obj instanceof Boolean) {
            return "boolean";
        }
        throw errorWithClassName("msg.invalid.type", obj);
    }

    public static String typeofName(Scriptable scriptable, String str) {
        Context context = Context.getContext();
        Scriptable scriptableBind = bind(context, scriptable, str);
        if (scriptableBind == null) {
            return "undefined";
        }
        return typeof(getObjectProp(scriptableBind, str, context));
    }

    public static Object add(Object obj, Object obj2, Context context) {
        Object objAddValues;
        Object objAddValues2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return wrapNumber(((Number) obj).doubleValue() + ((Number) obj2).doubleValue());
        }
        if ((obj instanceof XMLObject) && (objAddValues2 = ((XMLObject) obj).addValues(context, true, obj2)) != Scriptable.NOT_FOUND) {
            return objAddValues2;
        }
        if ((obj2 instanceof XMLObject) && (objAddValues = ((XMLObject) obj2).addValues(context, false, obj)) != Scriptable.NOT_FOUND) {
            return objAddValues;
        }
        if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
            throw typeError0("msg.not.a.number");
        }
        if (obj instanceof Scriptable) {
            obj = ((Scriptable) obj).getDefaultValue(null);
        }
        if (obj2 instanceof Scriptable) {
            obj2 = ((Scriptable) obj2).getDefaultValue(null);
        }
        if (!(obj instanceof CharSequence) && !(obj2 instanceof CharSequence)) {
            if ((obj instanceof Number) && (obj2 instanceof Number)) {
                return wrapNumber(((Number) obj).doubleValue() + ((Number) obj2).doubleValue());
            }
            return wrapNumber(toNumber(obj) + toNumber(obj2));
        }
        return new ConsString(toCharSequence(obj), toCharSequence(obj2));
    }

    public static CharSequence add(CharSequence charSequence, Object obj) {
        return new ConsString(charSequence, toCharSequence(obj));
    }

    public static CharSequence add(Object obj, CharSequence charSequence) {
        return new ConsString(toCharSequence(obj), charSequence);
    }

    @Deprecated
    public static Object nameIncrDecr(Scriptable scriptable, String str, int i) {
        return nameIncrDecr(scriptable, str, Context.getContext(), i);
    }

    public static Object nameIncrDecr(Scriptable scriptable, String str, Context context, int i) {
        do {
            if (context.useDynamicScope && scriptable.getParentScope() == null) {
                scriptable = checkDynamicScope(context.topCallScope, scriptable);
            }
            Scriptable prototype = scriptable;
            do {
                if ((prototype instanceof NativeWith) && (prototype.getPrototype() instanceof XMLObject)) {
                    break;
                }
                Object obj = prototype.get(str, scriptable);
                if (obj == Scriptable.NOT_FOUND) {
                    prototype = prototype.getPrototype();
                } else {
                    return doScriptableIncrDecr(prototype, str, scriptable, obj, i);
                }
            } while (prototype != null);
            scriptable = scriptable.getParentScope();
        } while (scriptable != null);
        throw notFoundError(scriptable, str);
    }

    @Deprecated
    public static Object propIncrDecr(Object obj, String str, Context context, int i) {
        return propIncrDecr(obj, str, context, getTopCallScope(context), i);
    }

    public static Object propIncrDecr(Object obj, String str, Context context, Scriptable scriptable, int i) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        Scriptable prototype = objectOrNull;
        do {
            Object obj2 = prototype.get(str, objectOrNull);
            if (obj2 == Scriptable.NOT_FOUND) {
                prototype = prototype.getPrototype();
            } else {
                return doScriptableIncrDecr(prototype, str, objectOrNull, obj2, i);
            }
        } while (prototype != null);
        Double d2 = NaNobj;
        objectOrNull.put(str, objectOrNull, d2);
        return d2;
    }

    private static Object doScriptableIncrDecr(Scriptable scriptable, String str, Scriptable scriptable2, Object obj, int i) {
        double number;
        boolean z = (i & 2) != 0;
        if (obj instanceof Number) {
            number = ((Number) obj).doubleValue();
        } else {
            number = toNumber(obj);
            if (z) {
                obj = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        scriptable.put(str, scriptable2, numberWrapNumber);
        return z ? obj : numberWrapNumber;
    }

    @Deprecated
    public static Object elemIncrDecr(Object obj, Object obj2, Context context, int i) {
        return elemIncrDecr(obj, obj2, context, getTopCallScope(context), i);
    }

    public static Object elemIncrDecr(Object obj, Object obj2, Context context, Scriptable scriptable, int i) {
        double number;
        Object objectElem = getObjectElem(obj, obj2, context, scriptable);
        boolean z = (i & 2) != 0;
        if (objectElem instanceof Number) {
            number = ((Number) objectElem).doubleValue();
        } else {
            number = toNumber(objectElem);
            if (z) {
                objectElem = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        setObjectElem(obj, obj2, numberWrapNumber, context, scriptable);
        return z ? objectElem : numberWrapNumber;
    }

    @Deprecated
    public static Object refIncrDecr(Ref ref, Context context, int i) {
        return refIncrDecr(ref, context, getTopCallScope(context), i);
    }

    public static Object refIncrDecr(Ref ref, Context context, Scriptable scriptable, int i) {
        double number;
        Object objWrapNumber = ref.get(context);
        boolean z = (i & 2) != 0;
        if (objWrapNumber instanceof Number) {
            number = ((Number) objWrapNumber).doubleValue();
        } else {
            number = toNumber(objWrapNumber);
            if (z) {
                objWrapNumber = wrapNumber(number);
            }
        }
        Number numberWrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        ref.set(context, scriptable, numberWrapNumber);
        return z ? objWrapNumber : numberWrapNumber;
    }

    public static Object toPrimitive(Object obj) {
        return toPrimitive(obj, null);
    }

    public static Object toPrimitive(Object obj, Class<?> cls) {
        if (!(obj instanceof Scriptable)) {
            return obj;
        }
        Object defaultValue = ((Scriptable) obj).getDefaultValue(cls);
        if (!(defaultValue instanceof Scriptable) || isSymbol(defaultValue)) {
            return defaultValue;
        }
        throw typeError0("msg.bad.default.value");
    }

    public static boolean eq(Object obj, Object obj2) {
        Object objEquivalentValues;
        Object objEquivalentValues2;
        Object objEquivalentValues3;
        Object objEquivalentValues4;
        Object objEquivalentValues5;
        if (obj == null || obj == Undefined.instance) {
            if (obj2 == null || obj2 == Undefined.instance) {
                return true;
            }
            if (!(obj2 instanceof ScriptableObject) || (objEquivalentValues = ((ScriptableObject) obj2).equivalentValues(obj)) == Scriptable.NOT_FOUND) {
                return false;
            }
            return ((Boolean) objEquivalentValues).booleanValue();
        }
        if (obj instanceof Number) {
            return eqNumber(((Number) obj).doubleValue(), obj2);
        }
        if (obj == obj2) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return eqString((CharSequence) obj, obj2);
        }
        if (obj instanceof Boolean) {
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            if (obj2 instanceof Boolean) {
                return zBooleanValue == ((Boolean) obj2).booleanValue();
            }
            if ((obj2 instanceof ScriptableObject) && (objEquivalentValues5 = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
                return ((Boolean) objEquivalentValues5).booleanValue();
            }
            return eqNumber(zBooleanValue ? 1.0d : 0.0d, obj2);
        }
        if (obj instanceof Scriptable) {
            if (obj2 instanceof Scriptable) {
                if ((obj instanceof ScriptableObject) && (objEquivalentValues4 = ((ScriptableObject) obj).equivalentValues(obj2)) != Scriptable.NOT_FOUND) {
                    return ((Boolean) objEquivalentValues4).booleanValue();
                }
                if ((obj2 instanceof ScriptableObject) && (objEquivalentValues3 = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
                    return ((Boolean) objEquivalentValues3).booleanValue();
                }
                if (!(obj instanceof Wrapper) || !(obj2 instanceof Wrapper)) {
                    return false;
                }
                Object objUnwrap = ((Wrapper) obj).unwrap();
                Object objUnwrap2 = ((Wrapper) obj2).unwrap();
                return objUnwrap == objUnwrap2 || (isPrimitive(objUnwrap) && isPrimitive(objUnwrap2) && eq(objUnwrap, objUnwrap2));
            }
            if (obj2 instanceof Boolean) {
                if ((obj instanceof ScriptableObject) && (objEquivalentValues2 = ((ScriptableObject) obj).equivalentValues(obj2)) != Scriptable.NOT_FOUND) {
                    return ((Boolean) objEquivalentValues2).booleanValue();
                }
                return eqNumber(((Boolean) obj2).booleanValue() ? 1.0d : 0.0d, obj);
            }
            if (obj2 instanceof Number) {
                return eqNumber(((Number) obj2).doubleValue(), obj);
            }
            if (obj2 instanceof CharSequence) {
                return eqString((CharSequence) obj2, obj);
            }
            return false;
        }
        warnAboutNonJSObject(obj);
        return obj == obj2;
    }

    public static boolean same(Object obj, Object obj2) {
        if (!typeof(obj).equals(typeof(obj2))) {
            return false;
        }
        if (obj instanceof Number) {
            if (isNaN(obj) && isNaN(obj2)) {
                return true;
            }
            return obj.equals(obj2);
        }
        return eq(obj, obj2);
    }

    public static boolean isNaN(Object obj) {
        if (obj == NaNobj) {
            return true;
        }
        if (obj instanceof Double) {
            Double d2 = (Double) obj;
            return d2.doubleValue() == NaN || Double.isNaN(d2.doubleValue());
        }
        if (!(obj instanceof Float)) {
            return false;
        }
        Float f2 = (Float) obj;
        return ((double) f2.floatValue()) == NaN || Float.isNaN(f2.floatValue());
    }

    public static boolean isPrimitive(Object obj) {
        return obj == null || obj == Undefined.instance || (obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean eqNumber(double r5, java.lang.Object r7) {
        /*
        L0:
            r0 = 0
            if (r7 == 0) goto L6b
            java.lang.Object r1 = org.mozilla.javascript.Undefined.instance
            if (r7 != r1) goto L8
            goto L6b
        L8:
            boolean r1 = r7 instanceof java.lang.Number
            r2 = 1
            if (r1 == 0) goto L19
            java.lang.Number r7 = (java.lang.Number) r7
            double r3 = r7.doubleValue()
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 != 0) goto L18
            return r2
        L18:
            return r0
        L19:
            boolean r1 = r7 instanceof java.lang.CharSequence
            if (r1 == 0) goto L27
            double r3 = toNumber(r7)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 != 0) goto L26
            return r2
        L26:
            return r0
        L27:
            boolean r1 = r7 instanceof java.lang.Boolean
            if (r1 == 0) goto L3e
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L36
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L38
        L36:
            r3 = 0
        L38:
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 != 0) goto L3d
            return r2
        L3d:
            return r0
        L3e:
            boolean r1 = isSymbol(r7)
            if (r1 == 0) goto L45
            return r0
        L45:
            boolean r1 = r7 instanceof org.mozilla.javascript.Scriptable
            if (r1 == 0) goto L68
            boolean r0 = r7 instanceof org.mozilla.javascript.ScriptableObject
            if (r0 == 0) goto L63
            java.lang.Number r0 = wrapNumber(r5)
            r1 = r7
            org.mozilla.javascript.ScriptableObject r1 = (org.mozilla.javascript.ScriptableObject) r1
            java.lang.Object r0 = r1.equivalentValues(r0)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r0 == r1) goto L63
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r5 = r0.booleanValue()
            return r5
        L63:
            java.lang.Object r7 = toPrimitive(r7)
            goto L0
        L68:
            warnAboutNonJSObject(r7)
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.eqNumber(double, java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean eqString(java.lang.CharSequence r5, java.lang.Object r6) {
        /*
        L0:
            r0 = 0
            if (r6 == 0) goto L8f
            java.lang.Object r1 = org.mozilla.javascript.Undefined.instance
            if (r6 != r1) goto L9
            goto L8f
        L9:
            boolean r1 = r6 instanceof java.lang.CharSequence
            r2 = 1
            if (r1 == 0) goto L2a
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r1 = r5.length()
            int r3 = r6.length()
            if (r1 != r3) goto L29
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = r6.toString()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L29
            return r2
        L29:
            return r0
        L2a:
            boolean r1 = r6 instanceof java.lang.Number
            if (r1 == 0) goto L42
            java.lang.String r5 = r5.toString()
            double r3 = toNumber(r5)
            java.lang.Number r6 = (java.lang.Number) r6
            double r5 = r6.doubleValue()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L41
            return r2
        L41:
            return r0
        L42:
            boolean r1 = r6 instanceof java.lang.Boolean
            if (r1 == 0) goto L61
            java.lang.String r5 = r5.toString()
            double r3 = toNumber(r5)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 == 0) goto L59
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L5b
        L59:
            r5 = 0
        L5b:
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L60
            return r2
        L60:
            return r0
        L61:
            boolean r1 = isSymbol(r6)
            if (r1 == 0) goto L68
            return r0
        L68:
            boolean r1 = r6 instanceof org.mozilla.javascript.Scriptable
            if (r1 == 0) goto L8c
            boolean r0 = r6 instanceof org.mozilla.javascript.ScriptableObject
            if (r0 == 0) goto L86
            r0 = r6
            org.mozilla.javascript.ScriptableObject r0 = (org.mozilla.javascript.ScriptableObject) r0
            java.lang.String r1 = r5.toString()
            java.lang.Object r0 = r0.equivalentValues(r1)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r0 == r1) goto L86
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r5 = r0.booleanValue()
            return r5
        L86:
            java.lang.Object r6 = toPrimitive(r6)
            goto L0
        L8c:
            warnAboutNonJSObject(r6)
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.eqString(java.lang.CharSequence, java.lang.Object):boolean");
    }

    public static boolean shallowEq(Object obj, Object obj2) {
        if (obj == obj2) {
            if (!(obj instanceof Number)) {
                return true;
            }
            double dDoubleValue = ((Number) obj).doubleValue();
            return dDoubleValue == dDoubleValue;
        }
        if (obj == null || obj == Undefined.instance || obj == Undefined.SCRIPTABLE_UNDEFINED) {
            return (obj == Undefined.instance && obj2 == Undefined.SCRIPTABLE_UNDEFINED) || (obj == Undefined.SCRIPTABLE_UNDEFINED && obj2 == Undefined.instance);
        }
        if (obj instanceof Number) {
            return (obj2 instanceof Number) && ((Number) obj).doubleValue() == ((Number) obj2).doubleValue();
        }
        if (obj instanceof CharSequence) {
            if (obj2 instanceof CharSequence) {
                return obj.toString().equals(obj2.toString());
            }
        } else if (obj instanceof Boolean) {
            if (obj2 instanceof Boolean) {
                return obj.equals(obj2);
            }
        } else if (obj instanceof Scriptable) {
            if ((obj instanceof Wrapper) && (obj2 instanceof Wrapper) && ((Wrapper) obj).unwrap() == ((Wrapper) obj2).unwrap()) {
                return true;
            }
        } else {
            warnAboutNonJSObject(obj);
            return obj == obj2;
        }
        return false;
    }

    public static boolean instanceOf(Object obj, Object obj2, Context context) {
        if (!(obj2 instanceof Scriptable)) {
            throw typeError0("msg.instanceof.not.object");
        }
        if (obj instanceof Scriptable) {
            return ((Scriptable) obj2).hasInstance((Scriptable) obj);
        }
        return false;
    }

    public static boolean jsDelegatesTo(Scriptable scriptable, Scriptable scriptable2) {
        for (Scriptable prototype = scriptable.getPrototype(); prototype != null; prototype = prototype.getPrototype()) {
            if (prototype.equals(scriptable2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean in(Object obj, Object obj2, Context context) {
        if (!(obj2 instanceof Scriptable)) {
            throw typeError0("msg.in.not.object");
        }
        return hasObjectElem((Scriptable) obj2, obj, context);
    }

    public static boolean cmp_LT(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
                throw typeError0("msg.compare.symbol");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) < 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number < number2;
    }

    public static boolean cmp_LE(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if ((obj instanceof Symbol) || (obj2 instanceof Symbol)) {
                throw typeError0("msg.compare.symbol");
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) <= 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number <= number2;
    }

    public static ScriptableObject getGlobal(Context context) {
        Class<?> clsClassOrNull = Kit.classOrNull("org.mozilla.javascript.tools.shell.Global");
        if (clsClassOrNull != null) {
            try {
                return (ScriptableObject) clsClassOrNull.getConstructor(ContextClass).newInstance(context);
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
        return new ImporterTopLevel(context);
    }

    public static boolean hasTopCall(Context context) {
        return context.topCallScope != null;
    }

    public static Scriptable getTopCallScope(Context context) {
        Scriptable scriptable = context.topCallScope;
        if (scriptable != null) {
            return scriptable;
        }
        throw new IllegalStateException();
    }

    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return doTopCall(callable, context, scriptable, scriptable2, objArr, context.isTopLevelStrict);
    }

    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, boolean z) {
        if (scriptable == null) {
            throw new IllegalArgumentException();
        }
        if (context.topCallScope != null) {
            throw new IllegalStateException();
        }
        context.topCallScope = ScriptableObject.getTopLevelScope(scriptable);
        context.useDynamicScope = context.hasFeature(7);
        boolean z2 = context.isTopLevelStrict;
        context.isTopLevelStrict = z;
        try {
            Object objDoTopCall = context.getFactory().doTopCall(callable, context, scriptable, scriptable2, objArr);
            context.topCallScope = null;
            context.cachedXMLLib = null;
            context.isTopLevelStrict = z2;
            if (context.currentActivationCall == null) {
                return objDoTopCall;
            }
            throw new IllegalStateException();
        } catch (Throwable th) {
            context.topCallScope = null;
            context.cachedXMLLib = null;
            context.isTopLevelStrict = z2;
            if (context.currentActivationCall != null) {
                throw new IllegalStateException();
            }
            throw th;
        }
    }

    static Scriptable checkDynamicScope(Scriptable scriptable, Scriptable scriptable2) {
        if (scriptable != scriptable2) {
            Scriptable prototype = scriptable;
            do {
                prototype = prototype.getPrototype();
                if (prototype == scriptable2) {
                }
            } while (prototype != null);
            return scriptable2;
        }
        return scriptable;
    }

    public static void addInstructionCount(Context context, int i) {
        context.instructionCount += i;
        if (context.instructionCount > context.instructionThreshold) {
            context.observeInstructionCount(context.instructionCount);
            context.instructionCount = 0;
        }
    }

    public static void initScript(NativeFunction nativeFunction, Scriptable scriptable, Context context, Scriptable scriptable2, boolean z) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        int paramAndVarCount = nativeFunction.getParamAndVarCount();
        if (paramAndVarCount == 0) {
            return;
        }
        Scriptable parentScope = scriptable2;
        while (parentScope instanceof NativeWith) {
            parentScope = parentScope.getParentScope();
        }
        while (true) {
            int i = paramAndVarCount - 1;
            if (paramAndVarCount == 0) {
                return;
            }
            String paramOrVarName = nativeFunction.getParamOrVarName(i);
            boolean paramOrVarConst = nativeFunction.getParamOrVarConst(i);
            if (ScriptableObject.hasProperty(scriptable2, paramOrVarName)) {
                ScriptableObject.redefineProperty(scriptable2, paramOrVarName, paramOrVarConst);
            } else if (paramOrVarConst) {
                ScriptableObject.defineConstProperty(parentScope, paramOrVarName);
            } else if (!z) {
                ScriptableObject.defineProperty(parentScope, paramOrVarName, Undefined.instance, 4);
            } else {
                parentScope.put(paramOrVarName, parentScope, Undefined.instance);
            }
            paramAndVarCount = i;
        }
    }

    @Deprecated
    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr) {
        return createFunctionActivation(nativeFunction, scriptable, objArr, false);
    }

    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z) {
        return new NativeCall(nativeFunction, scriptable, objArr, false, z);
    }

    public static Scriptable createArrowFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z) {
        return new NativeCall(nativeFunction, scriptable, objArr, true, z);
    }

    public static void enterActivationFunction(Context context, Scriptable scriptable) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        NativeCall nativeCall = (NativeCall) scriptable;
        nativeCall.parentActivationCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall;
        nativeCall.defineAttributesForArguments();
    }

    public static void exitActivationFunction(Context context) {
        NativeCall nativeCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall.parentActivationCall;
        nativeCall.parentActivationCall = null;
    }

    static NativeCall findFunctionActivation(Context context, Function function) {
        for (NativeCall nativeCall = context.currentActivationCall; nativeCall != null; nativeCall = nativeCall.parentActivationCall) {
            if (nativeCall.function == function) {
                return nativeCall;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.mozilla.javascript.Scriptable newCatchScope(java.lang.Throwable r11, org.mozilla.javascript.Scriptable r12, java.lang.String r13, org.mozilla.javascript.Context r14, org.mozilla.javascript.Scriptable r15) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.newCatchScope(java.lang.Throwable, org.mozilla.javascript.Scriptable, java.lang.String, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable):org.mozilla.javascript.Scriptable");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.mozilla.javascript.Scriptable wrapException(java.lang.Throwable r11, org.mozilla.javascript.Scriptable r12, org.mozilla.javascript.Context r13) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.wrapException(java.lang.Throwable, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Context):org.mozilla.javascript.Scriptable");
    }

    private static boolean isVisible(Context context, Object obj) {
        ClassShutter classShutter = context.getClassShutter();
        return classShutter == null || classShutter.visibleToScripts(obj.getClass().getName());
    }

    public static Scriptable enterWith(Object obj, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw typeError1("msg.undef.with", toString(obj));
        }
        if (objectOrNull instanceof XMLObject) {
            return ((XMLObject) objectOrNull).enterWith(scriptable);
        }
        return new NativeWith(scriptable, objectOrNull);
    }

    public static Scriptable leaveWith(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static Scriptable enterDotQuery(Object obj, Scriptable scriptable) {
        if (!(obj instanceof XMLObject)) {
            throw notXmlError(obj);
        }
        return ((XMLObject) obj).enterDotQuery(scriptable);
    }

    public static Object updateDotQuery(boolean z, Scriptable scriptable) {
        return ((NativeWith) scriptable).updateDotQuery(z);
    }

    public static Scriptable leaveDotQuery(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static void setFunctionProtoAndParent(BaseFunction baseFunction, Scriptable scriptable) {
        baseFunction.setParentScope(scriptable);
        baseFunction.setPrototype(ScriptableObject.getFunctionPrototype(scriptable));
    }

    public static void setObjectProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(ScriptableObject.getClassPrototype(topLevelScope, scriptableObject.getClassName()));
    }

    public static void setBuiltinProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable, TopLevel.Builtins builtins) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(TopLevel.getBuiltinPrototype(topLevelScope, builtins));
    }

    public static void initFunction(Context context, Scriptable scriptable, NativeFunction nativeFunction, int i, boolean z) {
        if (i == 1) {
            String functionName = nativeFunction.getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                return;
            }
            if (!z) {
                ScriptableObject.defineProperty(scriptable, functionName, nativeFunction, 4);
                return;
            } else {
                scriptable.put(functionName, scriptable, nativeFunction);
                return;
            }
        }
        if (i == 3) {
            String functionName2 = nativeFunction.getFunctionName();
            if (functionName2 == null || functionName2.length() == 0) {
                return;
            }
            while (scriptable instanceof NativeWith) {
                scriptable = scriptable.getParentScope();
            }
            scriptable.put(functionName2, scriptable, nativeFunction);
            return;
        }
        throw Kit.codeBug();
    }

    public static Scriptable newArrayLiteral(Object[] objArr, int[] iArr, Context context, Scriptable scriptable) {
        int length = objArr.length;
        int i = 0;
        int length2 = iArr != null ? iArr.length : 0;
        int i2 = length + length2;
        if (i2 > 1 && length2 * 2 < i2) {
            if (length2 != 0) {
                Object[] objArr2 = new Object[i2];
                int i3 = 0;
                int i4 = 0;
                while (i != i2) {
                    if (i3 != length2 && iArr[i3] == i) {
                        objArr2[i] = Scriptable.NOT_FOUND;
                        i3++;
                    } else {
                        objArr2[i] = objArr[i4];
                        i4++;
                    }
                    i++;
                }
                objArr = objArr2;
            }
            return context.newArray(scriptable, objArr);
        }
        Scriptable scriptableNewArray = context.newArray(scriptable, i2);
        int i5 = 0;
        int i6 = 0;
        while (i != i2) {
            if (i5 == length2 || iArr[i5] != i) {
                scriptableNewArray.put(i, scriptableNewArray, objArr[i6]);
                i6++;
            } else {
                i5++;
            }
            i++;
        }
        return scriptableNewArray;
    }

    @Deprecated
    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, Context context, Scriptable scriptable) {
        return newObjectLiteral(objArr, objArr2, null, context, scriptable);
    }

    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, int[] iArr, Context context, Scriptable scriptable) {
        Scriptable scriptableNewObject = context.newObject(scriptable);
        int length = objArr.length;
        for (int i = 0; i != length; i++) {
            Object obj = objArr[i];
            int i2 = iArr == null ? 0 : iArr[i];
            Object obj2 = objArr2[i];
            if (!(obj instanceof String)) {
                scriptableNewObject.put(((Integer) obj).intValue(), scriptableNewObject, obj2);
            } else if (i2 == 0) {
                String str = (String) obj;
                if (isSpecialProperty(str)) {
                    specialRef(scriptableNewObject, str, context, scriptable).set(context, scriptable, obj2);
                } else {
                    scriptableNewObject.put(str, scriptableNewObject, obj2);
                }
            } else {
                ((ScriptableObject) scriptableNewObject).setGetterOrSetter((String) obj, 0, (Callable) obj2, i2 == 1);
            }
        }
        return scriptableNewObject;
    }

    public static boolean isArrayObject(Object obj) {
        return (obj instanceof NativeArray) || (obj instanceof Arguments);
    }

    public static Object[] getArrayElements(Scriptable scriptable) {
        long lengthProperty = NativeArray.getLengthProperty(Context.getContext(), scriptable);
        if (lengthProperty > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException();
        }
        int i = (int) lengthProperty;
        if (i == 0) {
            return emptyArgs;
        }
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            Object property = ScriptableObject.getProperty(scriptable, i2);
            if (property == Scriptable.NOT_FOUND) {
                property = Undefined.instance;
            }
            objArr[i2] = property;
        }
        return objArr;
    }

    static void checkDeprecated(Context context, String str) {
        int languageVersion = context.getLanguageVersion();
        if (languageVersion >= 140 || languageVersion == 0) {
            String message1 = getMessage1("msg.deprec.ctor", str);
            if (languageVersion == 0) {
                Context.reportWarning(message1);
                return;
            }
            throw Context.reportRuntimeError(message1);
        }
    }

    public static String getMessage0(String str) {
        return getMessage(str, null);
    }

    public static String getMessage1(String str, Object obj) {
        return getMessage(str, new Object[]{obj});
    }

    public static String getMessage2(String str, Object obj, Object obj2) {
        return getMessage(str, new Object[]{obj, obj2});
    }

    public static String getMessage3(String str, Object obj, Object obj2, Object obj3) {
        return getMessage(str, new Object[]{obj, obj2, obj3});
    }

    public static String getMessage4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return getMessage(str, new Object[]{obj, obj2, obj3, obj4});
    }

    public static String getMessage(String str, Object[] objArr) {
        return messageProvider.getMessage(str, objArr);
    }

    private static class DefaultMessageProvider implements MessageProvider {
        private DefaultMessageProvider() {
        }

        @Override // org.mozilla.javascript.ScriptRuntime.MessageProvider
        public String getMessage(String str, Object[] objArr) {
            Context currentContext = Context.getCurrentContext();
            try {
                return new MessageFormat(ResourceBundle.getBundle("org.mozilla.javascript.resources.Messages", currentContext != null ? currentContext.getLocale() : Locale.getDefault()).getString(str)).format(objArr);
            } catch (MissingResourceException unused) {
                throw new RuntimeException("no message resource found for message property " + str);
            }
        }
    }

    public static EcmaError constructError(String str, String str2) {
        int[] iArr = new int[1];
        return constructError(str, str2, Context.getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static EcmaError constructError(String str, String str2, int i) {
        int[] iArr = new int[1];
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        int i2 = iArr[0];
        if (i2 != 0) {
            iArr[0] = i2 + i;
        }
        return constructError(str, str2, sourcePositionFromStack, iArr[0], null, 0);
    }

    public static EcmaError constructError(String str, String str2, String str3, int i, String str4, int i2) {
        return new EcmaError(str, str2, str3, i, str4, i2);
    }

    public static EcmaError rangeError(String str) {
        return constructError("RangeError", str);
    }

    public static EcmaError typeError(String str) {
        return constructError("TypeError", str);
    }

    public static EcmaError typeError0(String str) {
        return typeError(getMessage0(str));
    }

    public static EcmaError typeError1(String str, Object obj) {
        return typeError(getMessage1(str, obj));
    }

    public static EcmaError typeError2(String str, Object obj, Object obj2) {
        return typeError(getMessage2(str, obj, obj2));
    }

    public static EcmaError typeError3(String str, String str2, String str3, String str4) {
        return typeError(getMessage3(str, str2, str3, str4));
    }

    public static RuntimeException undefReadError(Object obj, Object obj2) {
        return typeError2("msg.undef.prop.read", toString(obj), toString(obj2));
    }

    public static RuntimeException undefCallError(Object obj, Object obj2) {
        return typeError2("msg.undef.method.call", toString(obj), toString(obj2));
    }

    public static RuntimeException undefWriteError(Object obj, Object obj2, Object obj3) {
        return typeError3("msg.undef.prop.write", toString(obj), toString(obj2), toString(obj3));
    }

    private static RuntimeException undefDeleteError(Object obj, Object obj2) {
        throw typeError2("msg.undef.prop.delete", toString(obj), toString(obj2));
    }

    public static RuntimeException notFoundError(Scriptable scriptable, String str) {
        throw constructError("ReferenceError", getMessage1("msg.is.not.defined", str));
    }

    public static RuntimeException notFunctionError(Object obj) {
        return notFunctionError(obj, obj);
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2) {
        String string;
        if (obj2 == null) {
            string = Constants.NULL_VERSION_ID;
        } else {
            string = obj2.toString();
        }
        if (obj == Scriptable.NOT_FOUND) {
            return typeError1("msg.function.not.found", string);
        }
        return typeError2("msg.isnt.function", string, typeof(obj));
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2, String str) {
        int iIndexOf;
        String string = toString(obj);
        if ((obj instanceof NativeFunction) && (iIndexOf = string.indexOf(123, string.indexOf(41))) > -1) {
            string = string.substring(0, iIndexOf + 1) + "...}";
        }
        if (obj2 == Scriptable.NOT_FOUND) {
            return typeError2("msg.function.not.found.in", str, string);
        }
        return typeError3("msg.isnt.function.in", str, string, typeof(obj2));
    }

    private static RuntimeException notXmlError(Object obj) {
        throw typeError1("msg.isnt.xml.object", toString(obj));
    }

    private static void warnAboutNonJSObject(Object obj) {
        if ("true".equals(getMessage0("params.omit.non.js.object.warning"))) {
            return;
        }
        String message2 = getMessage2("msg.non.js.object.warning", obj, obj.getClass().getName());
        Context.reportWarning(message2);
        System.err.println(message2);
    }

    public static RegExpProxy getRegExpProxy(Context context) {
        return context.getRegExpProxy();
    }

    public static void setRegExpProxy(Context context, RegExpProxy regExpProxy) {
        if (regExpProxy == null) {
            throw new IllegalArgumentException();
        }
        context.regExpProxy = regExpProxy;
    }

    public static RegExpProxy checkRegExpProxy(Context context) {
        RegExpProxy regExpProxy = getRegExpProxy(context);
        if (regExpProxy != null) {
            return regExpProxy;
        }
        throw Context.reportRuntimeError0("msg.no.regexp");
    }

    public static Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return context.getRegExpProxy().wrapRegExp(context, scriptable, obj);
    }

    private static XMLLib currentXMLLib(Context context) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        XMLLib xMLLib = context.cachedXMLLib;
        if (xMLLib != null) {
            return xMLLib;
        }
        XMLLib xMLLibExtractFromScope = XMLLib.extractFromScope(context.topCallScope);
        if (xMLLibExtractFromScope == null) {
            throw new IllegalStateException();
        }
        context.cachedXMLLib = xMLLibExtractFromScope;
        return xMLLibExtractFromScope;
    }

    public static String escapeAttributeValue(Object obj, Context context) {
        return currentXMLLib(context).escapeAttributeValue(obj);
    }

    public static String escapeTextValue(Object obj, Context context) {
        return currentXMLLib(context).escapeTextValue(obj);
    }

    public static Ref memberRef(Object obj, Object obj2, Context context, int i) {
        if (!(obj instanceof XMLObject)) {
            throw notXmlError(obj);
        }
        return ((XMLObject) obj).memberRef(context, obj2, i);
    }

    public static Ref memberRef(Object obj, Object obj2, Object obj3, Context context, int i) {
        if (!(obj instanceof XMLObject)) {
            throw notXmlError(obj);
        }
        return ((XMLObject) obj).memberRef(context, obj2, obj3, i);
    }

    public static Ref nameRef(Object obj, Context context, Scriptable scriptable, int i) {
        return currentXMLLib(context).nameRef(context, obj, scriptable, i);
    }

    public static Ref nameRef(Object obj, Object obj2, Context context, Scriptable scriptable, int i) {
        return currentXMLLib(context).nameRef(context, obj, obj2, scriptable, i);
    }

    private static void storeIndexResult(Context context, int i) {
        context.scratchIndex = i;
    }

    static int lastIndexResult(Context context) {
        return context.scratchIndex;
    }

    public static void storeUint32Result(Context context, long j) {
        if ((j >>> 32) != 0) {
            throw new IllegalArgumentException();
        }
        context.scratchUint32 = j;
    }

    public static long lastUint32Result(Context context) {
        long j = context.scratchUint32;
        if ((j >>> 32) == 0) {
            return j;
        }
        throw new IllegalStateException();
    }

    private static void storeScriptable(Context context, Scriptable scriptable) {
        if (context.scratchScriptable != null) {
            throw new IllegalStateException();
        }
        context.scratchScriptable = scriptable;
    }

    public static Scriptable lastStoredScriptable(Context context) {
        Scriptable scriptable = context.scratchScriptable;
        context.scratchScriptable = null;
        return scriptable;
    }

    static String makeUrlForGeneratedScript(boolean z, String str, int i) {
        if (z) {
            return str + CsvReader.Letters.POUND + i + "(eval)";
        }
        return str + CsvReader.Letters.POUND + i + "(Function)";
    }

    static boolean isGeneratedScript(String str) {
        return str.indexOf("(eval)") >= 0 || str.indexOf("(Function)") >= 0;
    }

    static boolean isSymbol(Object obj) {
        return ((obj instanceof NativeSymbol) && ((NativeSymbol) obj).isSymbol()) || (obj instanceof SymbolKey);
    }

    private static RuntimeException errorWithClassName(String str, Object obj) {
        return Context.reportRuntimeError1(str, obj.getClass().getName());
    }

    public static JavaScriptException throwError(Context context, Scriptable scriptable, String str) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(newBuiltinObject(context, scriptable, TopLevel.Builtins.Error, new Object[]{str, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }

    public static JavaScriptException throwCustomError(Context context, Scriptable scriptable, String str, String str2) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(context.newObject(scriptable, str, new Object[]{str2, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }
}
