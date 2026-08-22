package org.mozilla.javascript;

/* JADX INFO: loaded from: classes10.dex */
public class NativeJavaTopPackage extends NativeJavaPackage implements Function, IdFunctionCall {
    private static final int Id_getClass = 1;
    static final long serialVersionUID = -1455787259477709999L;
    private static final String[][] commonPackages = {new String[]{"java", "lang", "reflect"}, new String[]{"java", "io"}, new String[]{"java", "math"}, new String[]{"java", "net"}, new String[]{"java", "util", "zip"}, new String[]{"java", "text", "resources"}, new String[]{"java", "applet"}, new String[]{"javax", "swing"}};
    private static final Object FTAG = "JavaTopPackage";

    NativeJavaTopPackage(ClassLoader classLoader) {
        super(true, "", classLoader);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // org.mozilla.javascript.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mozilla.javascript.Scriptable construct(org.mozilla.javascript.Context r3, org.mozilla.javascript.Scriptable r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            int r3 = r5.length
            r0 = 0
            if (r3 == 0) goto L18
            r3 = 0
            r3 = r5[r3]
            boolean r5 = r3 instanceof org.mozilla.javascript.Wrapper
            if (r5 == 0) goto L11
            org.mozilla.javascript.Wrapper r3 = (org.mozilla.javascript.Wrapper) r3
            java.lang.Object r3 = r3.unwrap()
        L11:
            boolean r5 = r3 instanceof java.lang.ClassLoader
            if (r5 == 0) goto L18
            java.lang.ClassLoader r3 = (java.lang.ClassLoader) r3
            goto L19
        L18:
            r3 = r0
        L19:
            if (r3 != 0) goto L21
            java.lang.String r3 = "msg.not.classloader"
            org.mozilla.javascript.Context.reportRuntimeError0(r3)
            return r0
        L21:
            org.mozilla.javascript.NativeJavaPackage r5 = new org.mozilla.javascript.NativeJavaPackage
            r0 = 1
            java.lang.String r1 = ""
            r5.<init>(r0, r1, r3)
            org.mozilla.javascript.ScriptRuntime.setObjectProtoAndParent(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaTopPackage.construct(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[]):org.mozilla.javascript.Scriptable");
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeJavaTopPackage nativeJavaTopPackage = new NativeJavaTopPackage(context.getApplicationClassLoader());
        nativeJavaTopPackage.setPrototype(getObjectPrototype(scriptable));
        nativeJavaTopPackage.setParentScope(scriptable);
        for (int i = 0; i != commonPackages.length; i++) {
            int i2 = 0;
            NativeJavaPackage nativeJavaPackage = nativeJavaTopPackage;
            while (true) {
                String[] strArr = commonPackages[i];
                if (i2 != strArr.length) {
                    NativeJavaPackage nativeJavaPackageForcePackage = nativeJavaPackage.forcePackage(strArr[i2], scriptable);
                    i2++;
                    nativeJavaPackage = nativeJavaPackageForcePackage;
                }
            }
        }
        IdFunctionObject idFunctionObject = new IdFunctionObject(nativeJavaTopPackage, FTAG, 1, "getClass", 1, scriptable);
        String[] topPackageNames = ScriptRuntime.getTopPackageNames();
        Object[] objArr = new NativeJavaPackage[topPackageNames.length];
        for (int i3 = 0; i3 < topPackageNames.length; i3++) {
            objArr[i3] = (NativeJavaPackage) nativeJavaTopPackage.get(topPackageNames[i3], nativeJavaTopPackage);
        }
        ScriptableObject scriptableObject = (ScriptableObject) scriptable;
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
        scriptableObject.defineProperty("Packages", nativeJavaTopPackage, 2);
        for (int i4 = 0; i4 < topPackageNames.length; i4++) {
            scriptableObject.defineProperty(topPackageNames[i4], objArr[i4], 2);
        }
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_getClass(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }

    private Scriptable js_getClass(Context context, Scriptable scriptable, Object[] objArr) {
        String strSubstring;
        if (objArr.length > 0) {
            int i = 0;
            Object obj = objArr[0];
            if (obj instanceof Wrapper) {
                String name = ((Wrapper) obj).unwrap().getClass().getName();
                Scriptable scriptable2 = this;
                while (true) {
                    int iIndexOf = name.indexOf(46, i);
                    if (iIndexOf == -1) {
                        strSubstring = name.substring(i);
                    } else {
                        strSubstring = name.substring(i, iIndexOf);
                    }
                    Object obj2 = scriptable2.get(strSubstring, scriptable2);
                    if (!(obj2 instanceof Scriptable)) {
                        break;
                    }
                    scriptable2 = (Scriptable) obj2;
                    if (iIndexOf == -1) {
                        return scriptable2;
                    }
                    i = iIndexOf + 1;
                }
            }
        }
        throw Context.reportRuntimeError0("msg.not.java.obj");
    }
}
