package org.mozilla.javascript;

/* JADX INFO: loaded from: classes10.dex */
class SpecialRef extends Ref {
    private static final int SPECIAL_NONE = 0;
    private static final int SPECIAL_PARENT = 2;
    private static final int SPECIAL_PROTO = 1;
    static final long serialVersionUID = -7521596632456797847L;
    private String name;
    private Scriptable target;
    private int type;

    private SpecialRef(Scriptable scriptable, int i, String str) {
        this.target = scriptable;
        this.type = i;
        this.name = str;
    }

    static Ref createSpecial(Context context, Scriptable scriptable, Object obj, String str) {
        int i;
        Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw ScriptRuntime.undefReadError(obj, str);
        }
        if (str.equals("__proto__")) {
            i = 1;
        } else {
            if (!str.equals("__parent__")) {
                throw new IllegalArgumentException(str);
            }
            i = 2;
        }
        if (!context.hasFeature(5)) {
            i = 0;
        }
        return new SpecialRef(objectOrNull, i, str);
    }

    @Override // org.mozilla.javascript.Ref
    public Object get(Context context) {
        int i = this.type;
        if (i == 0) {
            return ScriptRuntime.getObjectProp(this.target, this.name, context);
        }
        if (i == 1) {
            return this.target.getPrototype();
        }
        if (i == 2) {
            return this.target.getParentScope();
        }
        throw Kit.codeBug();
    }

    @Override // org.mozilla.javascript.Ref
    @Deprecated
    public Object set(Context context, Object obj) {
        throw new IllegalStateException();
    }

    @Override // org.mozilla.javascript.Ref
    public Object set(Context context, Scriptable scriptable, Object obj) {
        int i = this.type;
        if (i == 0) {
            return ScriptRuntime.setObjectProp(this.target, this.name, obj, context);
        }
        if (i == 1 || i == 2) {
            Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, obj, scriptable);
            if (objectOrNull != null) {
                Scriptable parentScope = objectOrNull;
                while (parentScope != this.target) {
                    if (this.type == 1) {
                        parentScope = parentScope.getPrototype();
                    } else {
                        parentScope = parentScope.getParentScope();
                    }
                    if (parentScope == null) {
                    }
                }
                throw Context.reportRuntimeError1("msg.cyclic.value", this.name);
            }
            if (this.type == 1) {
                this.target.setPrototype(objectOrNull);
                return objectOrNull;
            }
            this.target.setParentScope(objectOrNull);
            return objectOrNull;
        }
        throw Kit.codeBug();
    }

    @Override // org.mozilla.javascript.Ref
    public boolean has(Context context) {
        if (this.type == 0) {
            return ScriptRuntime.hasObjectElem(this.target, this.name, context);
        }
        return true;
    }

    @Override // org.mozilla.javascript.Ref
    public boolean delete(Context context) {
        if (this.type == 0) {
            return ScriptRuntime.deleteObjectElem(this.target, this.name, context);
        }
        return false;
    }
}
