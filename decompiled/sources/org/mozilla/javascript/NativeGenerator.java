package org.mozilla.javascript;

/* JADX INFO: loaded from: classes10.dex */
public final class NativeGenerator extends IdScriptableObject {
    public static final int GENERATOR_CLOSE = 2;
    public static final int GENERATOR_SEND = 0;
    private static final Object GENERATOR_TAG = "Generator";
    public static final int GENERATOR_THROW = 1;
    private static final int Id___iterator__ = 5;
    private static final int Id_close = 1;
    private static final int Id_next = 2;
    private static final int Id_send = 3;
    private static final int Id_throw = 4;
    private static final int MAX_PROTOTYPE_ID = 5;
    private static final long serialVersionUID = 1645892441041347273L;
    private boolean firstTime = true;
    private NativeFunction function;
    private int lineNumber;
    private String lineSource;
    private boolean locked;
    private Object savedState;

    public static class GeneratorClosedException extends RuntimeException {
        private static final long serialVersionUID = 2561315658662379681L;
    }

    static NativeGenerator init(ScriptableObject scriptableObject, boolean z) {
        NativeGenerator nativeGenerator = new NativeGenerator();
        if (scriptableObject != null) {
            nativeGenerator.setParentScope(scriptableObject);
            nativeGenerator.setPrototype(getObjectPrototype(scriptableObject));
        }
        nativeGenerator.activatePrototypeMap(5);
        if (z) {
            nativeGenerator.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(GENERATOR_TAG, nativeGenerator);
        }
        return nativeGenerator;
    }

    private NativeGenerator() {
    }

    public NativeGenerator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((NativeGenerator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Generator";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        if (i == 1) {
            str = "close";
        } else if (i != 2) {
            if (i == 3) {
                str = "send";
            } else if (i == 4) {
                str = "throw";
            } else if (i == 5) {
                str = NativeIterator.ITERATOR_PROPERTY_NAME;
            } else {
                throw new IllegalArgumentException(String.valueOf(i));
            }
            i2 = 0;
        } else {
            str = ES6Iterator.NEXT_METHOD;
        }
        initPrototypeMethod(GENERATOR_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(GENERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (!(scriptable2 instanceof NativeGenerator)) {
            throw incompatibleCallError(idFunctionObject);
        }
        NativeGenerator nativeGenerator = (NativeGenerator) scriptable2;
        if (iMethodId == 1) {
            return nativeGenerator.resume(context, scriptable, 2, new GeneratorClosedException());
        }
        if (iMethodId == 2) {
            nativeGenerator.firstTime = false;
            return nativeGenerator.resume(context, scriptable, 0, Undefined.instance);
        }
        if (iMethodId != 3) {
            if (iMethodId == 4) {
                return nativeGenerator.resume(context, scriptable, 1, objArr.length > 0 ? objArr[0] : Undefined.instance);
            }
            if (iMethodId == 5) {
                return scriptable2;
            }
            throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (nativeGenerator.firstTime && !obj.equals(Undefined.instance)) {
            throw ScriptRuntime.typeError0("msg.send.newborn");
        }
        return nativeGenerator.resume(context, scriptable, 0, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object resume(org.mozilla.javascript.Context r12, org.mozilla.javascript.Scriptable r13, int r14, java.lang.Object r15) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.savedState
            r1 = 1
            r2 = 2
            if (r0 != 0) goto L1c
            if (r14 != r2) goto Lb
            java.lang.Object r12 = org.mozilla.javascript.Undefined.instance
            return r12
        Lb:
            if (r14 != r1) goto Le
            goto L12
        Le:
            java.lang.Object r15 = org.mozilla.javascript.NativeIterator.getStopIterationObject(r13)
        L12:
            org.mozilla.javascript.JavaScriptException r12 = new org.mozilla.javascript.JavaScriptException
            java.lang.String r13 = r11.lineSource
            int r14 = r11.lineNumber
            r12.<init>(r15, r13, r14)
            throw r12
        L1c:
            r3 = 0
            r4 = 0
            monitor-enter(r11)     // Catch: java.lang.Throwable -> L50 org.mozilla.javascript.RhinoException -> L54 org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L66
            boolean r0 = r11.locked     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L3f
            r11.locked = r1     // Catch: java.lang.Throwable -> L47
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L47
            org.mozilla.javascript.NativeFunction r5 = r11.function     // Catch: java.lang.Throwable -> L50 org.mozilla.javascript.RhinoException -> L54 org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L66
            java.lang.Object r9 = r11.savedState     // Catch: java.lang.Throwable -> L50 org.mozilla.javascript.RhinoException -> L54 org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L66
            r6 = r12
            r7 = r13
            r8 = r14
            r10 = r15
            java.lang.Object r12 = r5.resumeGenerator(r6, r7, r8, r9, r10)     // Catch: org.mozilla.javascript.RhinoException -> L4c org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L67 java.lang.Throwable -> L76
            monitor-enter(r11)
            r11.locked = r3     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L3b
            if (r8 != r2) goto L3a
            r11.savedState = r4
        L3a:
            return r12
        L3b:
            r0 = move-exception
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L3b
            throw r12
        L3f:
            r8 = r14
            java.lang.String r12 = "msg.already.exec.gen"
            org.mozilla.javascript.EcmaError r12 = org.mozilla.javascript.ScriptRuntime.typeError0(r12)     // Catch: java.lang.Throwable -> L4e
            throw r12     // Catch: java.lang.Throwable -> L4e
        L47:
            r0 = move-exception
            r8 = r14
        L49:
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L4e
            throw r12     // Catch: org.mozilla.javascript.RhinoException -> L4c org.mozilla.javascript.NativeGenerator.GeneratorClosedException -> L67 java.lang.Throwable -> L76
        L4c:
            r0 = move-exception
            goto L56
        L4e:
            r0 = move-exception
            goto L49
        L50:
            r0 = move-exception
            r8 = r14
        L52:
            r12 = r0
            goto L78
        L54:
            r0 = move-exception
            r8 = r14
        L56:
            r12 = r0
            int r13 = r12.lineNumber()     // Catch: java.lang.Throwable -> L76
            r11.lineNumber = r13     // Catch: java.lang.Throwable -> L76
            java.lang.String r13 = r12.lineSource()     // Catch: java.lang.Throwable -> L76
            r11.lineSource = r13     // Catch: java.lang.Throwable -> L76
            r11.savedState = r4     // Catch: java.lang.Throwable -> L76
            throw r12     // Catch: java.lang.Throwable -> L76
        L66:
            r8 = r14
        L67:
            java.lang.Object r12 = org.mozilla.javascript.Undefined.instance     // Catch: java.lang.Throwable -> L76
            monitor-enter(r11)
            r11.locked = r3     // Catch: java.lang.Throwable -> L72
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L72
            if (r8 != r2) goto L71
            r11.savedState = r4
        L71:
            return r12
        L72:
            r0 = move-exception
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L72
            throw r12
        L76:
            r0 = move-exception
            goto L52
        L78:
            monitor-enter(r11)
            r11.locked = r3     // Catch: java.lang.Throwable -> L81
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L81
            if (r8 != r2) goto L80
            r11.savedState = r4
        L80:
            throw r12
        L81:
            r0 = move-exception
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L81
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGenerator.resume(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findPrototypeId(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.length()
            r1 = 0
            r2 = 4
            if (r0 != r2) goto L1c
            char r0 = r5.charAt(r1)
            r2 = 110(0x6e, float:1.54E-43)
            if (r0 != r2) goto L14
            java.lang.String r0 = "next"
            r2 = 2
            goto L3c
        L14:
            r2 = 115(0x73, float:1.61E-43)
            if (r0 != r2) goto L3a
            java.lang.String r0 = "send"
            r2 = 3
            goto L3c
        L1c:
            r3 = 5
            if (r0 != r3) goto L32
            char r0 = r5.charAt(r1)
            r3 = 99
            if (r0 != r3) goto L2b
            java.lang.String r0 = "close"
            r2 = 1
            goto L3c
        L2b:
            r3 = 116(0x74, float:1.63E-43)
            if (r0 != r3) goto L3a
            java.lang.String r0 = "throw"
            goto L3c
        L32:
            r2 = 12
            if (r0 != r2) goto L3a
            java.lang.String r0 = "__iterator__"
            r2 = r3
            goto L3c
        L3a:
            r0 = 0
            r2 = r1
        L3c:
            if (r0 == 0) goto L47
            if (r0 == r5) goto L47
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L47
            return r1
        L47:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGenerator.findPrototypeId(java.lang.String):int");
    }
}
