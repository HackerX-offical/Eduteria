package org.mozilla.javascript;

import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class NativeIterator extends IdScriptableObject {
    public static final String ITERATOR_PROPERTY_NAME = "__iterator__";
    private static final Object ITERATOR_TAG = "Iterator";
    private static final int Id___iterator__ = 3;
    private static final int Id_constructor = 1;
    private static final int Id_next = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final String STOP_ITERATION = "StopIteration";
    private static final long serialVersionUID = -4136968203581667681L;
    private Object objectIterator;

    static void init(ScriptableObject scriptableObject, boolean z) {
        new NativeIterator().exportAsJSClass(3, scriptableObject, z);
        NativeGenerator.init(scriptableObject, z);
        StopIteration stopIteration = new StopIteration();
        stopIteration.setPrototype(getObjectPrototype(scriptableObject));
        stopIteration.setParentScope(scriptableObject);
        if (z) {
            stopIteration.sealObject();
        }
        ScriptableObject.defineProperty(scriptableObject, STOP_ITERATION, stopIteration, 2);
        scriptableObject.associateValue(ITERATOR_TAG, stopIteration);
    }

    private NativeIterator() {
    }

    private NativeIterator(Object obj) {
        this.objectIterator = obj;
    }

    public static Object getStopIterationObject(Scriptable scriptable) {
        return ScriptableObject.getTopScopeValue(ScriptableObject.getTopLevelScope(scriptable), ITERATOR_TAG);
    }

    static class StopIteration extends NativeObject {
        private static final long serialVersionUID = 2485151085722377663L;

        StopIteration() {
        }

        @Override // org.mozilla.javascript.NativeObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
        public String getClassName() {
            return NativeIterator.STOP_ITERATION;
        }

        @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
        public boolean hasInstance(Scriptable scriptable) {
            return scriptable instanceof StopIteration;
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Iterator";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 2;
        int i3 = 1;
        if (i == 1) {
            str = "constructor";
        } else {
            if (i != 2) {
                if (i == 3) {
                    str2 = ITERATOR_PROPERTY_NAME;
                    initPrototypeMethod(ITERATOR_TAG, i, str2, i3);
                }
                throw new IllegalArgumentException(String.valueOf(i));
            }
            i2 = 0;
            str = ES6Iterator.NEXT_METHOD;
        }
        String str3 = str;
        i3 = i2;
        str2 = str3;
        initPrototypeMethod(ITERATOR_TAG, i, str2, i3);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ITERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            return jsConstructor(context, scriptable, scriptable2, objArr);
        }
        if (!(scriptable2 instanceof NativeIterator)) {
            throw incompatibleCallError(idFunctionObject);
        }
        NativeIterator nativeIterator = (NativeIterator) scriptable2;
        if (iMethodId == 2) {
            return nativeIterator.next(context, scriptable);
        }
        if (iMethodId == 3) {
            return scriptable2;
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    private static Object jsConstructor(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        boolean z = false;
        if (objArr.length == 0 || (obj = objArr[0]) == null || obj == Undefined.instance) {
            throw ScriptRuntime.typeError1("msg.no.properties", ScriptRuntime.toString(objArr.length == 0 ? Undefined.instance : objArr[0]));
        }
        Scriptable object = ScriptRuntime.toObject(context, scriptable, objArr[0]);
        if (objArr.length > 1 && ScriptRuntime.toBoolean(objArr[1])) {
            z = true;
        }
        if (scriptable2 != null) {
            Iterator<?> javaIterator = VMBridge.instance.getJavaIterator(context, scriptable, object);
            if (javaIterator != null) {
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
                return context.getWrapFactory().wrap(context, topLevelScope, new WrappedJavaIterator(javaIterator, topLevelScope), WrappedJavaIterator.class);
            }
            Scriptable iterator = ScriptRuntime.toIterator(context, scriptable, object, z);
            if (iterator != null) {
                return iterator;
            }
        }
        Object objEnumInit = ScriptRuntime.enumInit(object, context, scriptable, z ? 3 : 5);
        ScriptRuntime.setEnumNumbers(objEnumInit, true);
        NativeIterator nativeIterator = new NativeIterator(objEnumInit);
        nativeIterator.setPrototype(ScriptableObject.getClassPrototype(scriptable, nativeIterator.getClassName()));
        nativeIterator.setParentScope(scriptable);
        return nativeIterator;
    }

    private Object next(Context context, Scriptable scriptable) {
        if (!ScriptRuntime.enumNext(this.objectIterator).booleanValue()) {
            throw new JavaScriptException(getStopIterationObject(scriptable), null, 0);
        }
        return ScriptRuntime.enumId(this.objectIterator, context);
    }

    public static class WrappedJavaIterator {
        private Iterator<?> iterator;
        private Scriptable scope;

        public Object __iterator__(boolean z) {
            return this;
        }

        WrappedJavaIterator(Iterator<?> it, Scriptable scriptable) {
            this.iterator = it;
            this.scope = scriptable;
        }

        public Object next() {
            if (!this.iterator.hasNext()) {
                throw new JavaScriptException(NativeIterator.getStopIterationObject(this.scope), null, 0);
            }
            return this.iterator.next();
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 4) {
            str2 = ES6Iterator.NEXT_METHOD;
            i = 2;
        } else if (length == 11) {
            str2 = "constructor";
            i = 1;
        } else if (length == 12) {
            str2 = ITERATOR_PROPERTY_NAME;
            i = 3;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
