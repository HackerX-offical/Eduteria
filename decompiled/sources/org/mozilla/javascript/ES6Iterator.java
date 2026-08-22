package org.mozilla.javascript;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ES6Iterator extends IdScriptableObject {
    public static final String DONE_PROPERTY = "done";
    private static final int Id_iterator = 2;
    private static final int Id_next = 1;
    private static final int Id_toStringTag = 3;
    private static final int MAX_PROTOTYPE_ID = 3;
    public static final String NEXT_METHOD = "next";
    public static final String VALUE_PROPERTY = "value";
    protected boolean exhausted = false;

    protected abstract String getTag();

    protected abstract boolean isDone(Context context, Scriptable scriptable);

    protected abstract Object nextValue(Context context, Scriptable scriptable);

    static void init(ScriptableObject scriptableObject, boolean z, IdScriptableObject idScriptableObject, String str) {
        if (scriptableObject != null) {
            idScriptableObject.setParentScope(scriptableObject);
            idScriptableObject.setPrototype(getObjectPrototype(scriptableObject));
        }
        idScriptableObject.activatePrototypeMap(3);
        if (z) {
            idScriptableObject.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(str, idScriptableObject);
        }
    }

    ES6Iterator() {
    }

    ES6Iterator(Scriptable scriptable) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((IdScriptableObject) ScriptableObject.getTopScopeValue(topLevelScope, getTag()));
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        if (i == 1) {
            initPrototypeMethod(getTag(), i, NEXT_METHOD, 0);
        } else if (i == 2) {
            initPrototypeMethod(getTag(), i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
        } else {
            if (i == 3) {
                initPrototypeValue(3, SymbolKey.TO_STRING_TAG, getClassName(), 3);
                return;
            }
            throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getTag())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (!(scriptable2 instanceof ES6Iterator)) {
            throw incompatibleCallError(idFunctionObject);
        }
        ES6Iterator eS6Iterator = (ES6Iterator) scriptable2;
        if (iMethodId == 1) {
            return eS6Iterator.next(context, scriptable);
        }
        if (iMethodId == 2) {
            return eS6Iterator;
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        if (SymbolKey.ITERATOR.equals(symbol)) {
            return 2;
        }
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 3 : 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        return NEXT_METHOD.equals(str) ? 1 : 0;
    }

    protected Object next(Context context, Scriptable scriptable) {
        Object objNextValue = Undefined.instance;
        boolean z = isDone(context, scriptable) || this.exhausted;
        if (!z) {
            objNextValue = nextValue(context, scriptable);
        } else {
            this.exhausted = true;
        }
        return makeIteratorResult(context, scriptable, z, objNextValue);
    }

    private Scriptable makeIteratorResult(Context context, Scriptable scriptable, boolean z, Object obj) {
        Scriptable scriptableNewObject = context.newObject(scriptable);
        ScriptableObject.putProperty(scriptableNewObject, "value", obj);
        ScriptableObject.putProperty(scriptableNewObject, DONE_PROPERTY, Boolean.valueOf(z));
        return scriptableNewObject;
    }
}
