package org.mozilla.javascript;

import org.mozilla.javascript.debug.DebuggableScript;

/* JADX INFO: loaded from: classes10.dex */
final class InterpretedFunction extends NativeFunction implements Script {
    static final long serialVersionUID = 541475680333911468L;
    InterpreterData idata;
    SecurityController securityController;
    Object securityDomain;

    private InterpretedFunction(InterpreterData interpreterData, Object obj) {
        Object dynamicSecurityDomain;
        this.idata = interpreterData;
        SecurityController securityController = Context.getContext().getSecurityController();
        if (securityController != null) {
            dynamicSecurityDomain = securityController.getDynamicSecurityDomain(obj);
        } else {
            if (obj != null) {
                throw new IllegalArgumentException();
            }
            dynamicSecurityDomain = null;
        }
        this.securityController = securityController;
        this.securityDomain = dynamicSecurityDomain;
    }

    private InterpretedFunction(InterpretedFunction interpretedFunction, int i) {
        this.idata = interpretedFunction.idata.itsNestedFunctions[i];
        this.securityController = interpretedFunction.securityController;
        this.securityDomain = interpretedFunction.securityDomain;
    }

    static InterpretedFunction createScript(InterpreterData interpreterData, Object obj) {
        return new InterpretedFunction(interpreterData, obj);
    }

    static InterpretedFunction createFunction(Context context, Scriptable scriptable, InterpreterData interpreterData, Object obj) {
        InterpretedFunction interpretedFunction = new InterpretedFunction(interpreterData, obj);
        interpretedFunction.initScriptFunction(context, scriptable);
        return interpretedFunction;
    }

    static InterpretedFunction createFunction(Context context, Scriptable scriptable, InterpretedFunction interpretedFunction, int i) {
        InterpretedFunction interpretedFunction2 = new InterpretedFunction(interpretedFunction, i);
        interpretedFunction2.initScriptFunction(context, scriptable);
        return interpretedFunction2;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return this.idata.itsName == null ? "" : this.idata.itsName;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!ScriptRuntime.hasTopCall(context)) {
            return ScriptRuntime.doTopCall(this, context, scriptable, scriptable2, objArr, this.idata.isStrict);
        }
        return Interpreter.interpret(this, context, scriptable, scriptable2, objArr);
    }

    @Override // org.mozilla.javascript.Script
    public Object exec(Context context, Scriptable scriptable) {
        if (!isScript()) {
            throw new IllegalStateException();
        }
        if (!ScriptRuntime.hasTopCall(context)) {
            return ScriptRuntime.doTopCall(this, context, scriptable, scriptable, ScriptRuntime.emptyArgs, this.idata.isStrict);
        }
        return Interpreter.interpret(this, context, scriptable, scriptable, ScriptRuntime.emptyArgs);
    }

    public boolean isScript() {
        return this.idata.itsFunctionType == 0;
    }

    @Override // org.mozilla.javascript.NativeFunction
    public String getEncodedSource() {
        return Interpreter.getEncodedSource(this.idata);
    }

    @Override // org.mozilla.javascript.NativeFunction
    public DebuggableScript getDebuggableView() {
        return this.idata;
    }

    @Override // org.mozilla.javascript.NativeFunction
    public Object resumeGenerator(Context context, Scriptable scriptable, int i, Object obj, Object obj2) {
        return Interpreter.resumeGenerator(context, scriptable, i, obj, obj2);
    }

    @Override // org.mozilla.javascript.NativeFunction
    protected int getLanguageVersion() {
        return this.idata.languageVersion;
    }

    @Override // org.mozilla.javascript.NativeFunction
    protected int getParamCount() {
        return this.idata.argCount;
    }

    @Override // org.mozilla.javascript.NativeFunction
    protected int getParamAndVarCount() {
        return this.idata.argNames.length;
    }

    @Override // org.mozilla.javascript.NativeFunction
    protected String getParamOrVarName(int i) {
        return this.idata.argNames[i];
    }

    @Override // org.mozilla.javascript.NativeFunction
    protected boolean getParamOrVarConst(int i) {
        return this.idata.argIsConst[i];
    }
}
