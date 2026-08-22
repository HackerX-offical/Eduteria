package org.mozilla.javascript;

import org.mozilla.javascript.debug.DebuggableScript;

/* JADX INFO: loaded from: classes10.dex */
public abstract class NativeFunction extends BaseFunction {
    static final long serialVersionUID = 8713897114082216401L;

    public DebuggableScript getDebuggableView() {
        return null;
    }

    public String getEncodedSource() {
        return null;
    }

    protected abstract int getLanguageVersion();

    protected abstract int getParamAndVarCount();

    protected abstract int getParamCount();

    protected boolean getParamOrVarConst(int i) {
        return false;
    }

    protected abstract String getParamOrVarName(int i);

    public final void initScriptFunction(Context context, Scriptable scriptable) {
        ScriptRuntime.setFunctionProtoAndParent(this, scriptable);
    }

    @Override // org.mozilla.javascript.BaseFunction
    final String decompile(int i, int i2) {
        String encodedSource = getEncodedSource();
        if (encodedSource == null) {
            return super.decompile(i, i2);
        }
        UintMap uintMap = new UintMap(1);
        uintMap.put(1, i);
        return Decompiler.decompile(encodedSource, i2, uintMap);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getLength() {
        NativeCall nativeCallFindFunctionActivation;
        return (getLanguageVersion() == 120 && (nativeCallFindFunctionActivation = ScriptRuntime.findFunctionActivation(Context.getContext(), this)) != null) ? nativeCallFindFunctionActivation.originalArgs.length : getParamCount();
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        return getParamCount();
    }

    @Deprecated
    public String jsGet_name() {
        return getFunctionName();
    }

    public Object resumeGenerator(Context context, Scriptable scriptable, int i, Object obj, Object obj2) {
        throw new EvaluatorException("resumeGenerator() not implemented");
    }
}
