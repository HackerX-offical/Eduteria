package org.mozilla.javascript;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.paytm.pgsdk.Constants;
import java.io.Serializable;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes10.dex */
final class NativeError extends IdScriptableObject {
    private static final int ConstructorId_captureStackTrace = -1;
    public static final int DEFAULT_STACK_LIMIT = -1;
    private static final Method ERROR_DELEGATE_GET_STACK;
    private static final Method ERROR_DELEGATE_SET_STACK;
    private static final Object ERROR_TAG = Constants.EVENT_ACTION_ERROR;
    private static final int Id_constructor = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final String STACK_HIDE_KEY = "_stackHide";
    static final long serialVersionUID = -5338413581437645187L;
    private RhinoException stackProvider;

    NativeError() {
    }

    static {
        try {
            ERROR_DELEGATE_GET_STACK = NativeError.class.getMethod("getStackDelegated", Scriptable.class);
            ERROR_DELEGATE_SET_STACK = NativeError.class.getMethod("setStackDelegated", Scriptable.class, Object.class);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    static void init(Scriptable scriptable, boolean z) {
        NativeError nativeError = new NativeError();
        ScriptableObject.putProperty(nativeError, "name", Constants.EVENT_ACTION_ERROR);
        ScriptableObject.putProperty(nativeError, "message", "");
        ScriptableObject.putProperty(nativeError, "fileName", "");
        ScriptableObject.putProperty((Scriptable) nativeError, "lineNumber", (Object) 0);
        nativeError.setAttributes("name", 2);
        nativeError.setAttributes("message", 2);
        nativeError.exportAsJSClass(3, scriptable, z);
        NativeCallSite.init(nativeError, z);
    }

    static NativeError make(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr) {
        Scriptable scriptable2 = (Scriptable) idFunctionObject.get("prototype", idFunctionObject);
        NativeError nativeError = new NativeError();
        nativeError.setPrototype(scriptable2);
        nativeError.setParentScope(scriptable);
        int length = objArr.length;
        if (length >= 1) {
            if (objArr[0] != Undefined.instance) {
                ScriptableObject.putProperty(nativeError, "message", ScriptRuntime.toString(objArr[0]));
            }
            if (length >= 2) {
                ScriptableObject.putProperty(nativeError, "fileName", objArr[1]);
                if (length >= 3) {
                    ScriptableObject.putProperty(nativeError, "lineNumber", Integer.valueOf(ScriptRuntime.toInt32(objArr[2])));
                }
            }
        }
        return nativeError;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, ERROR_TAG, -1, "captureStackTrace", 2);
        ProtoProps protoProps = new ProtoProps();
        associateValue("_ErrorPrototypeProps", protoProps);
        idFunctionObject.defineProperty("stackTraceLimit", protoProps, ProtoProps.GET_STACK_LIMIT, ProtoProps.SET_STACK_LIMIT, 0);
        idFunctionObject.defineProperty("prepareStackTrace", protoProps, ProtoProps.GET_PREPARE_STACK, ProtoProps.SET_PREPARE_STACK, 0);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return Constants.EVENT_ACTION_ERROR;
    }

    public String toString() {
        Object objJs_toString = js_toString(this);
        return objJs_toString instanceof String ? (String) objJs_toString : super.toString();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        int i2;
        String str;
        if (i != 1) {
            i2 = 0;
            if (i == 2) {
                str = InAppPurchaseConstants.METHOD_TO_STRING;
            } else if (i == 3) {
                str = "toSource";
            } else {
                throw new IllegalArgumentException(String.valueOf(i));
            }
        } else {
            i2 = 1;
            str = "constructor";
        }
        initPrototypeMethod(ERROR_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ERROR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == -1) {
            js_captureStackTrace(context, scriptable2, objArr);
            return Undefined.instance;
        }
        if (iMethodId == 1) {
            return make(context, scriptable, idFunctionObject, objArr);
        }
        if (iMethodId == 2) {
            return js_toString(scriptable2);
        }
        if (iMethodId == 3) {
            return js_toSource(context, scriptable, scriptable2);
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    public void setStackProvider(RhinoException rhinoException) {
        if (this.stackProvider == null) {
            this.stackProvider = rhinoException;
            defineProperty("stack", this, ERROR_DELEGATE_GET_STACK, ERROR_DELEGATE_SET_STACK, 2);
        }
    }

    public Object getStackDelegated(Scriptable scriptable) {
        int stackTraceLimit;
        Function prepareStackTrace;
        Object objCallPrepareStack;
        if (this.stackProvider == null) {
            return NOT_FOUND;
        }
        ProtoProps protoProps = (ProtoProps) ((NativeError) getPrototype()).getAssociatedValue("_ErrorPrototypeProps");
        if (protoProps != null) {
            stackTraceLimit = protoProps.getStackTraceLimit();
            prepareStackTrace = protoProps.getPrepareStackTrace();
        } else {
            stackTraceLimit = -1;
            prepareStackTrace = null;
        }
        ScriptStackElement[] scriptStack = this.stackProvider.getScriptStack(stackTraceLimit, (String) getAssociatedValue(STACK_HIDE_KEY));
        if (prepareStackTrace == null) {
            objCallPrepareStack = RhinoException.formatStackTrace(scriptStack, this.stackProvider.details());
        } else {
            objCallPrepareStack = callPrepareStack(prepareStackTrace, scriptStack);
        }
        setStackDelegated(scriptable, objCallPrepareStack);
        return objCallPrepareStack;
    }

    public void setStackDelegated(Scriptable scriptable, Object obj) {
        scriptable.delete("stack");
        this.stackProvider = null;
        scriptable.put("stack", scriptable, obj);
    }

    private Object callPrepareStack(Function function, ScriptStackElement[] scriptStackElementArr) {
        Context currentContext = Context.getCurrentContext();
        Object[] objArr = new Object[scriptStackElementArr.length];
        for (int i = 0; i < scriptStackElementArr.length; i++) {
            NativeCallSite nativeCallSite = (NativeCallSite) currentContext.newObject(this, "CallSite");
            nativeCallSite.setElement(scriptStackElementArr[i]);
            objArr[i] = nativeCallSite;
        }
        return function.call(currentContext, function, this, new Object[]{this, currentContext.newArray(this, objArr)});
    }

    private static Object js_toString(Scriptable scriptable) {
        String string;
        String string2;
        Object property = ScriptableObject.getProperty(scriptable, "name");
        if (property == NOT_FOUND || property == Undefined.instance) {
            string = Constants.EVENT_ACTION_ERROR;
        } else {
            string = ScriptRuntime.toString(property);
        }
        Object property2 = ScriptableObject.getProperty(scriptable, "message");
        if (property2 == NOT_FOUND || property2 == Undefined.instance) {
            string2 = "";
        } else {
            string2 = ScriptRuntime.toString(property2);
        }
        return string.toString().length() == 0 ? string2 : string2.toString().length() == 0 ? string : string + ": " + string2;
    }

    private static String js_toSource(Context context, Scriptable scriptable, Scriptable scriptable2) {
        int int32;
        Object property = ScriptableObject.getProperty(scriptable2, "name");
        Object property2 = ScriptableObject.getProperty(scriptable2, "message");
        Object property3 = ScriptableObject.getProperty(scriptable2, "fileName");
        Object property4 = ScriptableObject.getProperty(scriptable2, "lineNumber");
        StringBuilder sb = new StringBuilder("(new ");
        if (property == NOT_FOUND) {
            property = Undefined.instance;
        }
        sb.append(ScriptRuntime.toString(property));
        sb.append("(");
        if (property2 != NOT_FOUND || property3 != NOT_FOUND || property4 != NOT_FOUND) {
            if (property2 == NOT_FOUND) {
                property2 = "";
            }
            sb.append(ScriptRuntime.uneval(context, scriptable, property2));
            if (property3 != NOT_FOUND || property4 != NOT_FOUND) {
                sb.append(", ");
                if (property3 == NOT_FOUND) {
                    property3 = "";
                }
                sb.append(ScriptRuntime.uneval(context, scriptable, property3));
                if (property4 != NOT_FOUND && (int32 = ScriptRuntime.toInt32(property4)) != 0) {
                    sb.append(", ");
                    sb.append(ScriptRuntime.toString(int32));
                }
            }
        }
        sb.append("))");
        return sb.toString();
    }

    private static void js_captureStackTrace(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        ScriptableObject scriptableObject = (ScriptableObject) ScriptRuntime.toObjectOrNull(context, objArr[0], scriptable);
        Scriptable scriptable2 = objArr.length > 1 ? (Function) ScriptRuntime.toObjectOrNull(context, objArr[1], scriptable) : null;
        NativeError nativeError = (NativeError) context.newObject(scriptable, Constants.EVENT_ACTION_ERROR);
        nativeError.setStackProvider(new EvaluatorException("[object Object]"));
        if (scriptable2 != null && (obj = scriptable2.get("name", scriptable2)) != null && !Undefined.instance.equals(obj)) {
            nativeError.associateValue(STACK_HIDE_KEY, Context.toString(obj));
        }
        scriptableObject.defineProperty("stack", nativeError, ERROR_DELEGATE_GET_STACK, ERROR_DELEGATE_SET_STACK, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findPrototypeId(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.length()
            r1 = 8
            r2 = 0
            if (r0 != r1) goto L1d
            r0 = 3
            char r1 = r5.charAt(r0)
            r3 = 111(0x6f, float:1.56E-43)
            if (r1 != r3) goto L15
            java.lang.String r1 = "toSource"
            goto L27
        L15:
            r0 = 116(0x74, float:1.63E-43)
            if (r1 != r0) goto L25
            java.lang.String r1 = "toString"
            r0 = 2
            goto L27
        L1d:
            r1 = 11
            if (r0 != r1) goto L25
            java.lang.String r1 = "constructor"
            r0 = 1
            goto L27
        L25:
            r1 = 0
            r0 = r2
        L27:
            if (r1 == 0) goto L32
            if (r1 == r5) goto L32
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L32
            return r2
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeError.findPrototypeId(java.lang.String):int");
    }

    private static final class ProtoProps implements Serializable {
        static final Method GET_PREPARE_STACK;
        static final Method GET_STACK_LIMIT;
        static final String KEY = "_ErrorPrototypeProps";
        static final Method SET_PREPARE_STACK;
        static final Method SET_STACK_LIMIT;
        private static final long serialVersionUID = 1907180507775337939L;
        private Function prepareStackTrace;
        private int stackTraceLimit;

        private ProtoProps() {
            this.stackTraceLimit = -1;
        }

        static {
            try {
                GET_STACK_LIMIT = ProtoProps.class.getMethod("getStackTraceLimit", Scriptable.class);
                SET_STACK_LIMIT = ProtoProps.class.getMethod("setStackTraceLimit", Scriptable.class, Object.class);
                GET_PREPARE_STACK = ProtoProps.class.getMethod("getPrepareStackTrace", Scriptable.class);
                SET_PREPARE_STACK = ProtoProps.class.getMethod("setPrepareStackTrace", Scriptable.class, Object.class);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
        }

        public Object getStackTraceLimit(Scriptable scriptable) {
            int i = this.stackTraceLimit;
            if (i >= 0) {
                return Integer.valueOf(i);
            }
            return Double.valueOf(Double.POSITIVE_INFINITY);
        }

        public int getStackTraceLimit() {
            return this.stackTraceLimit;
        }

        public void setStackTraceLimit(Scriptable scriptable, Object obj) {
            double number = Context.toNumber(obj);
            if (Double.isNaN(number) || Double.isInfinite(number)) {
                this.stackTraceLimit = -1;
            } else {
                this.stackTraceLimit = (int) number;
            }
        }

        public Object getPrepareStackTrace(Scriptable scriptable) {
            Function prepareStackTrace = getPrepareStackTrace();
            return prepareStackTrace == null ? Undefined.instance : prepareStackTrace;
        }

        public Function getPrepareStackTrace() {
            return this.prepareStackTrace;
        }

        public void setPrepareStackTrace(Scriptable scriptable, Object obj) {
            if (obj == null || Undefined.instance.equals(obj)) {
                this.prepareStackTrace = null;
            } else if (obj instanceof Function) {
                this.prepareStackTrace = (Function) obj;
            }
        }
    }
}
