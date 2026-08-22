package org.mozilla.javascript;

import com.facebook.appevents.iap.InAppPurchaseConstants;

/* JADX INFO: loaded from: classes10.dex */
final class NativeBoolean extends IdScriptableObject {
    private static final Object BOOLEAN_TAG = "Boolean";
    private static final int Id_constructor = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 4;
    private static final int MAX_PROTOTYPE_ID = 4;
    static final long serialVersionUID = -3716996899943880933L;
    private boolean booleanValue;

    static void init(Scriptable scriptable, boolean z) {
        new NativeBoolean(false).exportAsJSClass(4, scriptable, z);
    }

    NativeBoolean(boolean z) {
        this.booleanValue = z;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Boolean";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == ScriptRuntime.BooleanClass) {
            return ScriptRuntime.wrapBoolean(this.booleanValue);
        }
        return super.getDefaultValue(cls);
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
            } else if (i == 4) {
                str = "valueOf";
            } else {
                throw new IllegalArgumentException(String.valueOf(i));
            }
        } else {
            i2 = 1;
            str = "constructor";
        }
        initPrototypeMethod(BOOLEAN_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(BOOLEAN_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            boolean z = false;
            if (objArr.length != 0) {
                Object obj = objArr[0];
                z = ((obj instanceof ScriptableObject) && ((ScriptableObject) obj).avoidObjectDetection()) ? true : ScriptRuntime.toBoolean(objArr[0]);
            }
            if (scriptable2 == null) {
                return new NativeBoolean(z);
            }
            return ScriptRuntime.wrapBoolean(z);
        }
        if (!(scriptable2 instanceof NativeBoolean)) {
            throw incompatibleCallError(idFunctionObject);
        }
        boolean z2 = ((NativeBoolean) scriptable2).booleanValue;
        if (iMethodId == 2) {
            return z2 ? "true" : "false";
        }
        if (iMethodId == 3) {
            return z2 ? "(new Boolean(true))" : "(new Boolean(false))";
        }
        if (iMethodId == 4) {
            return ScriptRuntime.wrapBoolean(z2);
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findPrototypeId(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.length()
            r1 = 7
            r2 = 0
            if (r0 != r1) goto Lc
            java.lang.String r0 = "valueOf"
            r1 = 4
            goto L2e
        Lc:
            r1 = 8
            if (r0 != r1) goto L24
            r1 = 3
            char r0 = r5.charAt(r1)
            r3 = 111(0x6f, float:1.56E-43)
            if (r0 != r3) goto L1c
            java.lang.String r0 = "toSource"
            goto L2e
        L1c:
            r1 = 116(0x74, float:1.63E-43)
            if (r0 != r1) goto L2c
            java.lang.String r0 = "toString"
            r1 = 2
            goto L2e
        L24:
            r1 = 11
            if (r0 != r1) goto L2c
            java.lang.String r0 = "constructor"
            r1 = 1
            goto L2e
        L2c:
            r0 = 0
            r1 = r2
        L2e:
            if (r0 == 0) goto L39
            if (r0 == r5) goto L39
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L39
            return r2
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeBoolean.findPrototypeId(java.lang.String):int");
    }
}
