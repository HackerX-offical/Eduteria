package org.mozilla.javascript;

import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

/* JADX INFO: loaded from: classes10.dex */
final class Arguments extends IdScriptableObject {
    private static final String FTAG = "Arguments";
    private static final int Id_callee = 1;
    private static final int Id_caller = 3;
    private static final int Id_length = 2;
    private static final int MAX_INSTANCE_ID = 3;
    private static BaseFunction iteratorMethod = new BaseFunction() { // from class: org.mozilla.javascript.Arguments.1
        @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return new NativeArrayIterator(scriptable, scriptable2);
        }
    };
    static final long serialVersionUID = 4275508002492040609L;
    private NativeCall activation;
    private Object[] args;
    private Object calleeObj;
    private Object callerObj;
    private Object lengthObj;
    private int callerAttr = 2;
    private int calleeAttr = 2;
    private int lengthAttr = 2;

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 3;
    }

    public Arguments(NativeCall nativeCall) {
        this.activation = nativeCall;
        Scriptable parentScope = nativeCall.getParentScope();
        setParentScope(parentScope);
        setPrototype(ScriptableObject.getObjectPrototype(parentScope));
        Object[] objArr = nativeCall.originalArgs;
        this.args = objArr;
        this.lengthObj = Integer.valueOf(objArr.length);
        NativeFunction nativeFunction = nativeCall.function;
        this.calleeObj = nativeFunction;
        int languageVersion = nativeFunction.getLanguageVersion();
        if (languageVersion <= 130 && languageVersion != 0) {
            this.callerObj = null;
        } else {
            this.callerObj = NOT_FOUND;
        }
        defineProperty(SymbolKey.ITERATOR, iteratorMethod, 2);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return FTAG;
    }

    private Object arg(int i) {
        if (i >= 0) {
            Object[] objArr = this.args;
            if (objArr.length > i) {
                return objArr[i];
            }
        }
        return NOT_FOUND;
    }

    private void putIntoActivation(int i, Object obj) {
        String paramOrVarName = this.activation.function.getParamOrVarName(i);
        Scriptable scriptable = this.activation;
        scriptable.put(paramOrVarName, scriptable, obj);
    }

    private Object getFromActivation(int i) {
        String paramOrVarName = this.activation.function.getParamOrVarName(i);
        Scriptable scriptable = this.activation;
        return scriptable.get(paramOrVarName, scriptable);
    }

    private void replaceArg(int i, Object obj) {
        if (sharedWithActivation(i)) {
            putIntoActivation(i, obj);
        }
        synchronized (this) {
            if (this.args == this.activation.originalArgs) {
                this.args = (Object[]) this.args.clone();
            }
            this.args[i] = obj;
        }
    }

    private void removeArg(int i) {
        synchronized (this) {
            if (this.args[i] != NOT_FOUND) {
                if (this.args == this.activation.originalArgs) {
                    this.args = (Object[]) this.args.clone();
                }
                this.args[i] = NOT_FOUND;
            }
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (arg(i) != NOT_FOUND) {
            return true;
        }
        return super.has(i, scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        Object objArg = arg(i);
        if (objArg == NOT_FOUND) {
            return super.get(i, scriptable);
        }
        return sharedWithActivation(i) ? getFromActivation(i) : objArg;
    }

    private boolean sharedWithActivation(int i) {
        NativeFunction nativeFunction;
        int paramCount;
        if (Context.getContext().isStrictMode() || i >= (paramCount = (nativeFunction = this.activation.function).getParamCount())) {
            return false;
        }
        if (i < paramCount - 1) {
            String paramOrVarName = nativeFunction.getParamOrVarName(i);
            for (int i2 = i + 1; i2 < paramCount; i2++) {
                if (paramOrVarName.equals(nativeFunction.getParamOrVarName(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (arg(i) == NOT_FOUND) {
            super.put(i, scriptable, obj);
        } else {
            replaceArg(i, obj);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i >= 0 && i < this.args.length) {
            removeArg(i);
        }
        super.delete(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findInstanceIdInfo(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.length()
            r1 = 6
            r2 = 2
            r3 = 3
            r4 = 1
            r5 = 0
            if (r0 != r1) goto L28
            r0 = 5
            char r0 = r7.charAt(r0)
            r1 = 101(0x65, float:1.42E-43)
            if (r0 != r1) goto L18
            java.lang.String r0 = "callee"
            r1 = r4
            goto L2a
        L18:
            r1 = 104(0x68, float:1.46E-43)
            if (r0 != r1) goto L20
            java.lang.String r0 = "length"
            r1 = r2
            goto L2a
        L20:
            r1 = 114(0x72, float:1.6E-43)
            if (r0 != r1) goto L28
            java.lang.String r0 = "caller"
            r1 = r3
            goto L2a
        L28:
            r0 = 0
            r1 = r5
        L2a:
            if (r0 == 0) goto L35
            if (r0 == r7) goto L35
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L35
            goto L36
        L35:
            r5 = r1
        L36:
            org.mozilla.javascript.Context r0 = org.mozilla.javascript.Context.getContext()
            boolean r0 = r0.isStrictMode()
            if (r0 == 0) goto L49
            if (r5 == r4) goto L44
            if (r5 != r3) goto L49
        L44:
            int r7 = super.findInstanceIdInfo(r7)
            return r7
        L49:
            if (r5 != 0) goto L50
            int r7 = super.findInstanceIdInfo(r7)
            return r7
        L50:
            if (r5 == r4) goto L62
            if (r5 == r2) goto L5f
            if (r5 != r3) goto L59
            int r7 = r6.callerAttr
            goto L64
        L59:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L5f:
            int r7 = r6.lengthAttr
            goto L64
        L62:
            int r7 = r6.calleeAttr
        L64:
            int r7 = instanceIdInfo(r7, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Arguments.findInstanceIdInfo(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        if (i == 1) {
            return "callee";
        }
        if (i == 2) {
            return Range.ATTR_LENGTH;
        }
        if (i != 3) {
            return null;
        }
        return "caller";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        Scriptable scriptable;
        if (i == 1) {
            return this.calleeObj;
        }
        if (i == 2) {
            return this.lengthObj;
        }
        if (i == 3) {
            Object obj = this.callerObj;
            if (obj == UniqueTag.NULL_VALUE) {
                return null;
            }
            return (obj != null || (scriptable = this.activation.parentActivationCall) == null) ? obj : scriptable.get("arguments", scriptable);
        }
        return super.getInstanceIdValue(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            this.calleeObj = obj;
            return;
        }
        if (i == 2) {
            this.lengthObj = obj;
        } else {
            if (i != 3) {
                super.setInstanceIdValue(i, obj);
                return;
            }
            if (obj == null) {
                obj = UniqueTag.NULL_VALUE;
            }
            this.callerObj = obj;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.calleeAttr = i2;
            return;
        }
        if (i == 2) {
            this.lengthAttr = i2;
        } else if (i == 3) {
            this.callerAttr = i2;
        } else {
            super.setInstanceIdAttributes(i, i2);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    Object[] getIds(boolean z, boolean z2) {
        int iIntValue;
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = this.args;
        if (objArr.length != 0) {
            int length = objArr.length;
            boolean[] zArr = new boolean[length];
            int length2 = objArr.length;
            for (int i = 0; i != ids.length; i++) {
                Object obj = ids[i];
                if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue()) >= 0 && iIntValue < this.args.length && !zArr[iIntValue]) {
                    zArr[iIntValue] = true;
                    length2--;
                }
            }
            if (!z) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (!zArr[i2] && super.has(i2, this)) {
                        zArr[i2] = true;
                        length2--;
                    }
                }
            }
            if (length2 != 0) {
                Object[] objArr2 = new Object[ids.length + length2];
                System.arraycopy(ids, 0, objArr2, length2, ids.length);
                int i3 = 0;
                for (int i4 = 0; i4 != this.args.length; i4++) {
                    if (!zArr[i4]) {
                        objArr2[i3] = Integer.valueOf(i4);
                        i3++;
                    }
                }
                if (i3 != length2) {
                    Kit.codeBug();
                }
                return objArr2;
            }
        }
        return ids;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    protected ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        if (obj instanceof Scriptable) {
            return super.getOwnPropertyDescriptor(context, obj);
        }
        double number = ScriptRuntime.toNumber(obj);
        int i = (int) number;
        if (number != i) {
            return super.getOwnPropertyDescriptor(context, obj);
        }
        Object objArg = arg(i);
        if (objArg == NOT_FOUND) {
            return super.getOwnPropertyDescriptor(context, obj);
        }
        if (sharedWithActivation(i)) {
            objArg = getFromActivation(i);
        }
        if (super.has(i, this)) {
            ScriptableObject ownPropertyDescriptor = super.getOwnPropertyDescriptor(context, obj);
            ownPropertyDescriptor.put("value", ownPropertyDescriptor, objArg);
            return ownPropertyDescriptor;
        }
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        return buildDataDescriptor(parentScope, objArg, 0);
    }

    @Override // org.mozilla.javascript.ScriptableObject
    protected void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        super.defineOwnProperty(context, obj, scriptableObject, z);
        double number = ScriptRuntime.toNumber(obj);
        int i = (int) number;
        if (number == i && arg(i) != NOT_FOUND) {
            if (isAccessorDescriptor(scriptableObject)) {
                removeArg(i);
                return;
            }
            Object property = getProperty(scriptableObject, "value");
            if (property == NOT_FOUND) {
                return;
            }
            replaceArg(i, property);
            if (isFalse(getProperty(scriptableObject, "writable"))) {
                removeArg(i);
            }
        }
    }

    void defineAttributesForStrictMode() {
        if (Context.getContext().isStrictMode()) {
            setGetterOrSetter("caller", 0, new ThrowTypeError("caller"), true);
            setGetterOrSetter("caller", 0, new ThrowTypeError("caller"), false);
            setGetterOrSetter("callee", 0, new ThrowTypeError("callee"), true);
            setGetterOrSetter("callee", 0, new ThrowTypeError("callee"), false);
            setAttributes("caller", 6);
            setAttributes("callee", 6);
            this.callerObj = null;
            this.calleeObj = null;
        }
    }

    private static class ThrowTypeError extends BaseFunction {
        private String propertyName;

        ThrowTypeError(String str) {
            this.propertyName = str;
        }

        @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            throw ScriptRuntime.typeError1("msg.arguments.not.access.strict", this.propertyName);
        }
    }
}
