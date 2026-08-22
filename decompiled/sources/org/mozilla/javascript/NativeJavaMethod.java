package org.mozilla.javascript;

import com.amazonaws.services.s3.internal.Constants;
import com.clevertap.android.sdk.variables.CTVariableUtils;
import com.csvreader.CsvReader;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class NativeJavaMethod extends BaseFunction {
    private static final int PREFERENCE_AMBIGUOUS = 3;
    private static final int PREFERENCE_EQUAL = 0;
    private static final int PREFERENCE_FIRST_ARG = 1;
    private static final int PREFERENCE_SECOND_ARG = 2;
    private static final boolean debug = false;
    static final long serialVersionUID = -3440381785576412928L;
    private String functionName;
    MemberBox[] methods;
    private transient CopyOnWriteArrayList<ResolvedOverload> overloadCache;

    private static void printDebug(String str, MemberBox memberBox, Object[] objArr) {
    }

    NativeJavaMethod(MemberBox[] memberBoxArr) {
        this.functionName = memberBoxArr[0].getName();
        this.methods = memberBoxArr;
    }

    NativeJavaMethod(MemberBox[] memberBoxArr, String str) {
        this.functionName = str;
        this.methods = memberBoxArr;
    }

    NativeJavaMethod(MemberBox memberBox, String str) {
        this.functionName = str;
        this.methods = new MemberBox[]{memberBox};
    }

    public NativeJavaMethod(Method method, String str) {
        this(new MemberBox(method), str);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return this.functionName;
    }

    static String scriptSignature(Object[] objArr) {
        String strJavaSignature;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strJavaSignature = Constants.NULL_VERSION_ID;
            } else if (obj instanceof Boolean) {
                strJavaSignature = "boolean";
            } else if (obj instanceof String) {
                strJavaSignature = "string";
            } else if (obj instanceof Number) {
                strJavaSignature = CTVariableUtils.NUMBER;
            } else if (obj instanceof Scriptable) {
                if (obj instanceof Undefined) {
                    strJavaSignature = "undefined";
                } else if (obj instanceof Wrapper) {
                    strJavaSignature = ((Wrapper) obj).unwrap().getClass().getName();
                } else if (obj instanceof Function) {
                    strJavaSignature = "function";
                } else {
                    strJavaSignature = "object";
                }
            } else {
                strJavaSignature = JavaMembers.javaSignature(obj.getClass());
            }
            if (i != 0) {
                sb.append(CsvReader.Letters.COMMA);
            }
            sb.append(strJavaSignature);
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.BaseFunction
    String decompile(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() {");
        }
        sb.append("/*\n");
        sb.append(toString());
        sb.append(z ? "*/\n" : "*/}\n");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.methods.length;
        for (int i = 0; i != length; i++) {
            if (this.methods[i].isMethod()) {
                Method method = this.methods[i].method();
                sb.append(JavaMembers.javaSignature(method.getReturnType()));
                sb.append(' ');
                sb.append(method.getName());
            } else {
                sb.append(this.methods[i].getName());
            }
            sb.append(JavaMembers.liveConnectSignature(this.methods[i].argTypes));
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] objArr2;
        Object obj;
        Object objJsToJava;
        if (this.methods.length == 0) {
            throw new RuntimeException("No methods defined for call");
        }
        int iFindCachedFunction = findCachedFunction(context, objArr);
        int i = 0;
        if (iFindCachedFunction < 0) {
            throw Context.reportRuntimeError1("msg.java.no_such_method", this.methods[0].method().getDeclaringClass().getName() + '.' + getFunctionName() + '(' + scriptSignature(objArr) + ')');
        }
        MemberBox memberBox = this.methods[iFindCachedFunction];
        Class<?>[] clsArr = memberBox.argTypes;
        if (memberBox.vararg) {
            objArr2 = new Object[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
                objArr2[i2] = Context.jsToJava(objArr[i2], clsArr[i2]);
            }
            if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || (objArr[objArr.length - 1] instanceof NativeArray) || (objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                objJsToJava = Context.jsToJava(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            } else {
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                Object objNewInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i < Array.getLength(objNewInstance)) {
                    Array.set(objNewInstance, i, Context.jsToJava(objArr[(clsArr.length - 1) + i], componentType));
                    i++;
                }
                objJsToJava = objNewInstance;
            }
            objArr2[clsArr.length - 1] = objJsToJava;
        } else {
            objArr2 = objArr;
            while (i < objArr2.length) {
                Object obj2 = objArr2[i];
                Object objJsToJava2 = Context.jsToJava(obj2, clsArr[i]);
                if (objJsToJava2 != obj2) {
                    if (objArr == objArr2) {
                        objArr2 = (Object[]) objArr2.clone();
                    }
                    objArr2[i] = objJsToJava2;
                }
                i++;
            }
        }
        if (!memberBox.isStatic()) {
            Class<?> declaringClass = memberBox.getDeclaringClass();
            for (Scriptable prototype = scriptable2; prototype != null; prototype = prototype.getPrototype()) {
                if (prototype instanceof Wrapper) {
                    Object objUnwrap = ((Wrapper) prototype).unwrap();
                    if (declaringClass.isInstance(objUnwrap)) {
                        obj = objUnwrap;
                    }
                }
            }
            throw Context.reportRuntimeError3("msg.nonjava.method", getFunctionName(), ScriptRuntime.toString(scriptable2), declaringClass.getName());
        }
        obj = null;
        Object objInvoke = memberBox.invoke(obj, objArr2);
        Class<?> returnType = memberBox.method().getReturnType();
        Object objWrap = context.getWrapFactory().wrap(context, scriptable, objInvoke, returnType);
        return (objWrap == null && returnType == Void.TYPE) ? Undefined.instance : objWrap;
    }

    int findCachedFunction(Context context, Object[] objArr) {
        MemberBox[] memberBoxArr = this.methods;
        if (memberBoxArr.length > 1) {
            CopyOnWriteArrayList<ResolvedOverload> copyOnWriteArrayList = this.overloadCache;
            if (copyOnWriteArrayList != null) {
                for (ResolvedOverload resolvedOverload : copyOnWriteArrayList) {
                    if (resolvedOverload.matches(objArr)) {
                        return resolvedOverload.index;
                    }
                }
            } else {
                this.overloadCache = new CopyOnWriteArrayList<>();
            }
            int iFindFunction = findFunction(context, this.methods, objArr);
            if (this.overloadCache.size() >= this.methods.length * 2) {
                return iFindFunction;
            }
            synchronized (this.overloadCache) {
                ResolvedOverload resolvedOverload2 = new ResolvedOverload(objArr, iFindFunction);
                if (!this.overloadCache.contains(resolvedOverload2)) {
                    this.overloadCache.add(0, resolvedOverload2);
                }
            }
            return iFindFunction;
        }
        return findFunction(context, memberBoxArr, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ec, code lost:
    
        r3 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ee, code lost:
    
        if (r12 != r3) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f0, code lost:
    
        r7 = r6;
        r8 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f4, code lost:
    
        if (r13 != r3) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f9, code lost:
    
        if (r2 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00fb, code lost:
    
        r17 = 1;
        r2 = new int[r19.length - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0103, code lost:
    
        r17 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0105, code lost:
    
        r2[r8] = r6;
        r8 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int findFunction(org.mozilla.javascript.Context r18, org.mozilla.javascript.MemberBox[] r19, java.lang.Object[] r20) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaMethod.findFunction(org.mozilla.javascript.Context, org.mozilla.javascript.MemberBox[], java.lang.Object[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int preferSignature(java.lang.Object[] r9, java.lang.Class<?>[] r10, boolean r11, java.lang.Class<?>[] r12, boolean r13) {
        /*
            r0 = 0
            r1 = r0
        L2:
            int r2 = r9.length
            if (r0 >= r2) goto L4c
            r2 = 1
            if (r11 == 0) goto L10
            int r3 = r10.length
            if (r0 < r3) goto L10
            int r3 = r10.length
            int r3 = r3 - r2
            r3 = r10[r3]
            goto L12
        L10:
            r3 = r10[r0]
        L12:
            if (r13 == 0) goto L1c
            int r4 = r12.length
            if (r0 < r4) goto L1c
            int r4 = r12.length
            int r4 = r4 - r2
            r4 = r12[r4]
            goto L1e
        L1c:
            r4 = r12[r0]
        L1e:
            if (r3 != r4) goto L21
            goto L49
        L21:
            r5 = r9[r0]
            int r6 = org.mozilla.javascript.NativeJavaObject.getConversionWeight(r5, r3)
            int r5 = org.mozilla.javascript.NativeJavaObject.getConversionWeight(r5, r4)
            r7 = 3
            if (r6 >= r5) goto L2f
            goto L45
        L2f:
            r8 = 2
            if (r6 <= r5) goto L34
        L32:
            r2 = r8
            goto L45
        L34:
            if (r6 != 0) goto L44
            boolean r5 = r3.isAssignableFrom(r4)
            if (r5 == 0) goto L3d
            goto L32
        L3d:
            boolean r3 = r4.isAssignableFrom(r3)
            if (r3 == 0) goto L44
            goto L45
        L44:
            r2 = r7
        L45:
            r1 = r1 | r2
            if (r1 != r7) goto L49
            return r1
        L49:
            int r0 = r0 + 1
            goto L2
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaMethod.preferSignature(java.lang.Object[], java.lang.Class[], boolean, java.lang.Class[], boolean):int");
    }
}
