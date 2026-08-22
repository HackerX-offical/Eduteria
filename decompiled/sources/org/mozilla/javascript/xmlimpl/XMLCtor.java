package org.mozilla.javascript.xmlimpl;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

/* JADX INFO: loaded from: classes10.dex */
class XMLCtor extends IdFunctionObject {
    private static final int Id_defaultSettings = 1;
    private static final int Id_ignoreComments = 1;
    private static final int Id_ignoreProcessingInstructions = 2;
    private static final int Id_ignoreWhitespace = 3;
    private static final int Id_prettyIndent = 4;
    private static final int Id_prettyPrinting = 5;
    private static final int Id_setSettings = 3;
    private static final int Id_settings = 2;
    private static final int MAX_FUNCTION_ID = 3;
    private static final int MAX_INSTANCE_ID = 5;
    private static final Object XMLCTOR_TAG = "XMLCtor";
    static final long serialVersionUID = -8708195078359817341L;
    private XmlProcessor options;

    XMLCtor(XML xml, Object obj, int i, int i2) {
        super(xml, obj, i, i2);
        this.options = xml.getProcessor();
        activatePrototypeMap(3);
    }

    private void writeSetting(Scriptable scriptable) {
        for (int i = 1; i <= 5; i++) {
            int maxInstanceId = super.getMaxInstanceId() + i;
            ScriptableObject.putProperty(scriptable, getInstanceIdName(maxInstanceId), getInstanceIdValue(maxInstanceId));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0038 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void readSettings(org.mozilla.javascript.Scriptable r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = r0
        L2:
            r2 = 5
            if (r1 > r2) goto L3b
            int r3 = super.getMaxInstanceId()
            int r3 = r3 + r1
            java.lang.String r4 = r6.getInstanceIdName(r3)
            java.lang.Object r4 = org.mozilla.javascript.ScriptableObject.getProperty(r7, r4)
            java.lang.Object r5 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r4 != r5) goto L17
            goto L38
        L17:
            if (r1 == r0) goto L30
            r5 = 2
            if (r1 == r5) goto L30
            r5 = 3
            if (r1 == r5) goto L30
            r5 = 4
            if (r1 == r5) goto L2b
            if (r1 != r2) goto L25
            goto L30
        L25:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L2b:
            boolean r2 = r4 instanceof java.lang.Number
            if (r2 != 0) goto L35
            goto L38
        L30:
            boolean r2 = r4 instanceof java.lang.Boolean
            if (r2 != 0) goto L35
            goto L38
        L35:
            r6.setInstanceIdValue(r3, r4)
        L38:
            int r1 = r1 + 1
            goto L2
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.xmlimpl.XMLCtor.readSettings(org.mozilla.javascript.Scriptable):void");
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return super.getMaxInstanceId() + 5;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int findInstanceIdInfo(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.length()
            r1 = 12
            r2 = 5
            r3 = 1
            r4 = 2
            r5 = 3
            r6 = 4
            r7 = 0
            if (r0 == r1) goto L3a
            r1 = 14
            if (r0 == r1) goto L23
            r1 = 16
            if (r0 == r1) goto L1f
            r1 = 28
            if (r0 == r1) goto L1b
            goto L37
        L1b:
            java.lang.String r0 = "ignoreProcessingInstructions"
            r1 = r4
            goto L3d
        L1f:
            java.lang.String r0 = "ignoreWhitespace"
            r1 = r5
            goto L3d
        L23:
            char r0 = r9.charAt(r7)
            r1 = 105(0x69, float:1.47E-43)
            if (r0 != r1) goto L2f
            java.lang.String r0 = "ignoreComments"
            r1 = r3
            goto L3d
        L2f:
            r1 = 112(0x70, float:1.57E-43)
            if (r0 != r1) goto L37
            java.lang.String r0 = "prettyPrinting"
            r1 = r2
            goto L3d
        L37:
            r0 = 0
            r1 = r7
            goto L3d
        L3a:
            java.lang.String r0 = "prettyIndent"
            r1 = r6
        L3d:
            if (r0 == 0) goto L48
            if (r0 == r9) goto L48
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L48
            goto L49
        L48:
            r7 = r1
        L49:
            if (r7 != 0) goto L50
            int r9 = super.findInstanceIdInfo(r9)
            return r9
        L50:
            if (r7 == r3) goto L61
            if (r7 == r4) goto L61
            if (r7 == r5) goto L61
            if (r7 == r6) goto L61
            if (r7 != r2) goto L5b
            goto L61
        L5b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L61:
            int r9 = super.getMaxInstanceId()
            int r9 = r9 + r7
            r0 = 6
            int r9 = instanceIdInfo(r0, r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.xmlimpl.XMLCtor.findInstanceIdInfo(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            return "ignoreComments";
        }
        if (maxInstanceId == 2) {
            return "ignoreProcessingInstructions";
        }
        if (maxInstanceId == 3) {
            return "ignoreWhitespace";
        }
        if (maxInstanceId == 4) {
            return "prettyIndent";
        }
        if (maxInstanceId == 5) {
            return "prettyPrinting";
        }
        return super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            return ScriptRuntime.wrapBoolean(this.options.isIgnoreComments());
        }
        if (maxInstanceId == 2) {
            return ScriptRuntime.wrapBoolean(this.options.isIgnoreProcessingInstructions());
        }
        if (maxInstanceId == 3) {
            return ScriptRuntime.wrapBoolean(this.options.isIgnoreWhitespace());
        }
        if (maxInstanceId == 4) {
            return ScriptRuntime.wrapInt(this.options.getPrettyIndent());
        }
        if (maxInstanceId == 5) {
            return ScriptRuntime.wrapBoolean(this.options.isPrettyPrinting());
        }
        return super.getInstanceIdValue(i);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            this.options.setIgnoreComments(ScriptRuntime.toBoolean(obj));
            return;
        }
        if (maxInstanceId == 2) {
            this.options.setIgnoreProcessingInstructions(ScriptRuntime.toBoolean(obj));
            return;
        }
        if (maxInstanceId == 3) {
            this.options.setIgnoreWhitespace(ScriptRuntime.toBoolean(obj));
            return;
        }
        if (maxInstanceId == 4) {
            this.options.setPrettyIndent(ScriptRuntime.toInt32(obj));
        } else if (maxInstanceId == 5) {
            this.options.setPrettyPrinting(ScriptRuntime.toBoolean(obj));
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 8) {
            str2 = "settings";
            i = 2;
        } else if (length == 11) {
            str2 = "setSettings";
            i = 3;
        } else if (length == 15) {
            str2 = "defaultSettings";
            i = 1;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        if (i == 1) {
            str = "defaultSettings";
        } else {
            if (i != 2) {
                if (i == 3) {
                    str2 = "setSettings";
                    initPrototypeMethod(XMLCTOR_TAG, i, str2, i2);
                }
                throw new IllegalArgumentException(String.valueOf(i));
            }
            str = "settings";
        }
        String str3 = str;
        i2 = 0;
        str2 = str3;
        initPrototypeMethod(XMLCTOR_TAG, i, str2, i2);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        if (!idFunctionObject.hasTag(XMLCTOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            this.options.setDefault();
            Scriptable scriptableNewObject = context.newObject(scriptable);
            writeSetting(scriptableNewObject);
            return scriptableNewObject;
        }
        if (iMethodId == 2) {
            Scriptable scriptableNewObject2 = context.newObject(scriptable);
            writeSetting(scriptableNewObject2);
            return scriptableNewObject2;
        }
        if (iMethodId == 3) {
            if (objArr.length == 0 || (obj = objArr[0]) == null || obj == Undefined.instance) {
                this.options.setDefault();
            } else {
                Object obj2 = objArr[0];
                if (obj2 instanceof Scriptable) {
                    readSettings((Scriptable) obj2);
                }
            }
            return Undefined.instance;
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return (scriptable instanceof XML) || (scriptable instanceof XMLList);
    }
}
