package org.mozilla.javascript.xmlimpl;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xmlimpl.XmlNode;

/* JADX INFO: loaded from: classes10.dex */
class Namespace extends IdScriptableObject {
    private static final int Id_constructor = 1;
    private static final int Id_prefix = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_uri = 2;
    private static final int MAX_INSTANCE_ID = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final Object NAMESPACE_TAG = "Namespace";
    static final long serialVersionUID = -5765755238131301744L;
    private XmlNode.Namespace ns;
    private Namespace prototype;

    private Namespace() {
    }

    static Namespace create(Scriptable scriptable, Namespace namespace, XmlNode.Namespace namespace2) {
        Namespace namespace3 = new Namespace();
        namespace3.setParentScope(scriptable);
        namespace3.prototype = namespace;
        namespace3.setPrototype(namespace);
        namespace3.ns = namespace2;
        return namespace3;
    }

    final XmlNode.Namespace getDelegate() {
        return this.ns;
    }

    public void exportAsJSClass(boolean z) {
        exportAsJSClass(3, getParentScope(), z);
    }

    public String uri() {
        return this.ns.getUri();
    }

    public String prefix() {
        return this.ns.getPrefix();
    }

    public String toString() {
        return uri();
    }

    public String toLocaleString() {
        return toString();
    }

    private boolean equals(Namespace namespace) {
        return uri().equals(namespace.uri());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Namespace) {
            return equals((Namespace) obj);
        }
        return false;
    }

    public int hashCode() {
        return uri().hashCode();
    }

    @Override // org.mozilla.javascript.ScriptableObject
    protected Object equivalentValues(Object obj) {
        return !(obj instanceof Namespace) ? Scriptable.NOT_FOUND : equals((Namespace) obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Namespace";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return uri();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return super.getMaxInstanceId() + 2;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 3) {
            str2 = "uri";
            i = 2;
        } else if (length == 6) {
            str2 = "prefix";
            i = 1;
        } else {
            str2 = null;
            i = 0;
        }
        int i2 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException();
        }
        return instanceIdInfo(5, super.getMaxInstanceId() + i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            return "prefix";
        }
        if (maxInstanceId == 2) {
            return "uri";
        }
        return super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            return this.ns.getPrefix() == null ? Undefined.instance : this.ns.getPrefix();
        }
        if (maxInstanceId == 2) {
            return this.ns.getUri();
        }
        return super.getInstanceIdValue(i);
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
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.xmlimpl.Namespace.findPrototypeId(java.lang.String):int");
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2;
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
            str = "constructor";
            i2 = 2;
        }
        initPrototypeMethod(NAMESPACE_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(NAMESPACE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            return jsConstructor(context, scriptable2 == null, objArr);
        }
        if (iMethodId == 2) {
            return realThis(scriptable2, idFunctionObject).toString();
        }
        if (iMethodId == 3) {
            return realThis(scriptable2, idFunctionObject).js_toSource();
        }
        throw new IllegalArgumentException(String.valueOf(iMethodId));
    }

    private Namespace realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof Namespace)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (Namespace) scriptable;
    }

    Namespace newNamespace(String str) {
        Namespace namespace = this.prototype;
        if (namespace == null) {
            namespace = this;
        }
        return create(getParentScope(), namespace, XmlNode.Namespace.create(str));
    }

    Namespace newNamespace(String str, String str2) {
        if (str == null) {
            return newNamespace(str2);
        }
        Namespace namespace = this.prototype;
        if (namespace == null) {
            namespace = this;
        }
        return create(getParentScope(), namespace, XmlNode.Namespace.create(str, str2));
    }

    Namespace constructNamespace(Object obj) {
        String string;
        String strPrefix;
        if (obj instanceof Namespace) {
            Namespace namespace = (Namespace) obj;
            strPrefix = namespace.prefix();
            string = namespace.uri();
        } else if (obj instanceof QName) {
            QName qName = (QName) obj;
            String strUri = qName.uri();
            if (strUri != null) {
                strPrefix = qName.prefix();
                string = strUri;
            } else {
                string = qName.toString();
            }
        } else {
            string = ScriptRuntime.toString(obj);
            strPrefix = string.length() == 0 ? "" : null;
        }
        return newNamespace(strPrefix, string);
    }

    Namespace castToNamespace(Object obj) {
        if (obj instanceof Namespace) {
            return (Namespace) obj;
        }
        return constructNamespace(obj);
    }

    private Namespace constructNamespace(Object obj, Object obj2) {
        String string;
        if (obj2 instanceof QName) {
            QName qName = (QName) obj2;
            string = qName.uri();
            if (string == null) {
                string = qName.toString();
            }
        } else {
            string = ScriptRuntime.toString(obj2);
        }
        String string2 = "";
        if (string.length() == 0) {
            if (obj != Undefined.instance) {
                string2 = ScriptRuntime.toString(obj);
                if (string2.length() != 0) {
                    throw ScriptRuntime.typeError("Illegal prefix '" + string2 + "' for 'no namespace'.");
                }
            }
        } else if (obj != Undefined.instance && XMLName.accept(obj)) {
            string2 = ScriptRuntime.toString(obj);
        }
        return newNamespace(string2, string);
    }

    private Namespace constructNamespace() {
        return newNamespace("", "");
    }

    private Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (!z && objArr.length == 1) {
            return castToNamespace(objArr[0]);
        }
        if (objArr.length == 0) {
            return constructNamespace();
        }
        if (objArr.length == 1) {
            return constructNamespace(objArr[0]);
        }
        return constructNamespace(objArr[0], objArr[1]);
    }

    private String js_toSource() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        toSourceImpl(this.ns.getPrefix(), this.ns.getUri(), sb);
        sb.append(')');
        return sb.toString();
    }

    static void toSourceImpl(String str, String str2, StringBuilder sb) {
        sb.append("new Namespace(");
        if (str2.length() == 0) {
            if (!"".equals(str)) {
                throw new IllegalArgumentException(str);
            }
        } else {
            sb.append('\'');
            if (str != null) {
                sb.append(ScriptRuntime.escapeString(str, '\''));
                sb.append("', '");
            }
            sb.append(ScriptRuntime.escapeString(str2, '\''));
            sb.append('\'');
        }
        sb.append(')');
    }
}
