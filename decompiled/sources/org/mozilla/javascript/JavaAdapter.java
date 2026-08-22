package org.mozilla.javascript;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.mozilla.classfile.ByteCode;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.ObjToIntMap;

/* JADX INFO: loaded from: classes10.dex */
public final class JavaAdapter implements IdFunctionCall {
    private static final Object FTAG = "JavaAdapter";
    private static final int Id_JavaAdapter = 1;

    static class JavaAdapterSignature {
        Class<?>[] interfaces;
        ObjToIntMap names;
        Class<?> superClass;

        JavaAdapterSignature(Class<?> cls, Class<?>[] clsArr, ObjToIntMap objToIntMap) {
            this.superClass = cls;
            this.interfaces = clsArr;
            this.names = objToIntMap;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof JavaAdapterSignature)) {
                return false;
            }
            JavaAdapterSignature javaAdapterSignature = (JavaAdapterSignature) obj;
            if (this.superClass != javaAdapterSignature.superClass) {
                return false;
            }
            Class<?>[] clsArr = this.interfaces;
            Class<?>[] clsArr2 = javaAdapterSignature.interfaces;
            if (clsArr != clsArr2) {
                if (clsArr.length == clsArr2.length) {
                    int i = 0;
                    while (true) {
                        Class<?>[] clsArr3 = this.interfaces;
                        if (i >= clsArr3.length) {
                            break;
                        }
                        if (clsArr3[i] != javaAdapterSignature.interfaces[i]) {
                            return false;
                        }
                        i++;
                    }
                } else {
                    return false;
                }
            }
            if (this.names.size() != javaAdapterSignature.names.size()) {
                return false;
            }
            ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(this.names);
            iterator.start();
            while (!iterator.done()) {
                String str = (String) iterator.getKey();
                int value = iterator.getValue();
                if (value != javaAdapterSignature.names.get(str, value + 1)) {
                    return false;
                }
                iterator.next();
            }
            return true;
        }

        public int hashCode() {
            return (this.superClass.hashCode() + Arrays.hashCode(this.interfaces)) ^ this.names.size();
        }
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        IdFunctionObject idFunctionObject = new IdFunctionObject(new JavaAdapter(), FTAG, 1, "JavaAdapter", 1, scriptable);
        idFunctionObject.markAsConstructor(null);
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_createAdapter(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }

    public static Object convertResult(Object obj, Class<?> cls) {
        if (obj != Undefined.instance || cls == ScriptRuntime.ObjectClass || cls == ScriptRuntime.StringClass) {
            return Context.jsToJava(obj, cls);
        }
        return null;
    }

    public static Scriptable createAdapterWrapper(Scriptable scriptable, Object obj) {
        NativeJavaObject nativeJavaObject = new NativeJavaObject(ScriptableObject.getTopLevelScope(scriptable), obj, null, true);
        nativeJavaObject.setPrototype(scriptable);
        return nativeJavaObject;
    }

    public static Object getAdapterSelf(Class<?> cls, Object obj) throws IllegalAccessException, NoSuchFieldException {
        return cls.getDeclaredField("self").get(obj);
    }

    static Object js_createAdapter(Context context, Scriptable scriptable, Object[] objArr) {
        Object objNewInstance;
        int length = objArr.length;
        if (length == 0) {
            throw ScriptRuntime.typeError0("msg.adapter.zero.args");
        }
        int i = 0;
        while (i < length - 1) {
            Object obj = objArr[i];
            if (obj instanceof NativeObject) {
                break;
            }
            if (!(obj instanceof NativeJavaClass)) {
                throw ScriptRuntime.typeError2("msg.not.java.class.arg", String.valueOf(i), ScriptRuntime.toString(obj));
            }
            i++;
        }
        Class[] clsArr = new Class[i];
        Class<?> cls = null;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Class<?> classObject = ((NativeJavaClass) objArr[i3]).getClassObject();
            if (classObject.isInterface()) {
                clsArr[i2] = classObject;
                i2++;
            } else {
                if (cls != null) {
                    throw ScriptRuntime.typeError2("msg.only.one.super", cls.getName(), classObject.getName());
                }
                cls = classObject;
            }
        }
        if (cls == null) {
            cls = ScriptRuntime.ObjectClass;
        }
        Class[] clsArr2 = new Class[i2];
        System.arraycopy(clsArr, 0, clsArr2, 0, i2);
        Scriptable scriptableEnsureScriptable = ScriptableObject.ensureScriptable(objArr[i]);
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr2, scriptableEnsureScriptable);
        int i4 = length - i;
        int i5 = i4 - 1;
        try {
            if (i5 > 0) {
                Object[] objArr2 = new Object[i4 + 1];
                objArr2[0] = scriptableEnsureScriptable;
                objArr2[1] = context.getFactory();
                System.arraycopy(objArr, i + 1, objArr2, 2, i5);
                NativeJavaMethod nativeJavaMethod = new NativeJavaClass(scriptable, adapterClass, true).members.ctors;
                int iFindCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr2);
                if (iFindCachedFunction < 0) {
                    throw Context.reportRuntimeError2("msg.no.java.ctor", adapterClass.getName(), NativeJavaMethod.scriptSignature(objArr));
                }
                objNewInstance = NativeJavaClass.constructInternal(objArr2, nativeJavaMethod.methods[iFindCachedFunction]);
            } else {
                objNewInstance = adapterClass.getConstructor(ScriptRuntime.ScriptableClass, ScriptRuntime.ContextFactoryClass).newInstance(scriptableEnsureScriptable, context.getFactory());
            }
            Object adapterSelf = getAdapterSelf(adapterClass, objNewInstance);
            if (adapterSelf instanceof Wrapper) {
                Object objUnwrap = ((Wrapper) adapterSelf).unwrap();
                if (objUnwrap instanceof Scriptable) {
                    if (objUnwrap instanceof ScriptableObject) {
                        ScriptRuntime.setObjectProtoAndParent((ScriptableObject) objUnwrap, scriptable);
                    }
                    return objUnwrap;
                }
            }
            return adapterSelf;
        } catch (Exception e2) {
            throw Context.throwAsScriptRuntimeEx(e2);
        }
    }

    public static void writeAdapterObject(Object obj, ObjectOutputStream objectOutputStream) throws IOException {
        Class<?> cls = obj.getClass();
        objectOutputStream.writeObject(cls.getSuperclass().getName());
        Class<?>[] interfaces = cls.getInterfaces();
        String[] strArr = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            strArr[i] = interfaces[i].getName();
        }
        objectOutputStream.writeObject(strArr);
        try {
            objectOutputStream.writeObject(cls.getField("delegee").get(obj));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            throw new IOException();
        }
    }

    public static Object readAdapterObject(Scriptable scriptable, ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Context currentContext = Context.getCurrentContext();
        ContextFactory factory = currentContext != null ? currentContext.getFactory() : null;
        Class<?> cls = Class.forName((String) objectInputStream.readObject());
        String[] strArr = (String[]) objectInputStream.readObject();
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i]);
        }
        Scriptable scriptable2 = (Scriptable) objectInputStream.readObject();
        try {
            return getAdapterClass(scriptable, cls, clsArr, scriptable2).getConstructor(ScriptRuntime.ContextFactoryClass, ScriptRuntime.ScriptableClass, ScriptRuntime.ScriptableClass).newInstance(factory, scriptable2, scriptable);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            throw new ClassNotFoundException("adapter");
        }
    }

    private static ObjToIntMap getObjectFunctionNames(Scriptable scriptable) {
        Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable);
        ObjToIntMap objToIntMap = new ObjToIntMap(propertyIds.length);
        for (int i = 0; i != propertyIds.length; i++) {
            Object obj = propertyIds[i];
            if (obj instanceof String) {
                String str = (String) obj;
                Object property = ScriptableObject.getProperty(scriptable, str);
                if (property instanceof Function) {
                    int int32 = ScriptRuntime.toInt32(ScriptableObject.getProperty((Function) property, Range.ATTR_LENGTH));
                    if (int32 < 0) {
                        int32 = 0;
                    }
                    objToIntMap.put(str, int32);
                }
            }
        }
        return objToIntMap;
    }

    private static Class<?> getAdapterClass(Scriptable scriptable, Class<?> cls, Class<?>[] clsArr, Scriptable scriptable2) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<JavaAdapterSignature, Class<?>> interfaceAdapterCacheMap = classCache.getInterfaceAdapterCacheMap();
        ObjToIntMap objectFunctionNames = getObjectFunctionNames(scriptable2);
        JavaAdapterSignature javaAdapterSignature = new JavaAdapterSignature(cls, clsArr, objectFunctionNames);
        Class<?> cls2 = interfaceAdapterCacheMap.get(javaAdapterSignature);
        if (cls2 != null) {
            return cls2;
        }
        String str = "adapter" + classCache.newClassSerialNumber();
        Class<?> clsLoadAdapterClass = loadAdapterClass(str, createAdapterCode(objectFunctionNames, str, cls, clsArr, null));
        if (classCache.isCachingEnabled()) {
            interfaceAdapterCacheMap.put(javaAdapterSignature, clsLoadAdapterClass);
        }
        return clsLoadAdapterClass;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] createAdapterCode(org.mozilla.javascript.ObjToIntMap r18, java.lang.String r19, java.lang.Class<?> r20, java.lang.Class<?>[] r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaAdapter.createAdapterCode(org.mozilla.javascript.ObjToIntMap, java.lang.String, java.lang.Class, java.lang.Class[], java.lang.String):byte[]");
    }

    static Method[] getOverridableMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            appendOverridableMethods(superclass, arrayList, hashSet);
        }
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                appendOverridableMethods(cls2, arrayList, hashSet);
            }
            cls = cls.getSuperclass();
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    private static void appendOverridableMethods(Class<?> cls, ArrayList<Method> arrayList, HashSet<String> hashSet) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            StringBuilder sbAppend = new StringBuilder().append(declaredMethods[i].getName());
            Method method = declaredMethods[i];
            String string = sbAppend.append(getMethodSignature(method, method.getParameterTypes())).toString();
            if (!hashSet.contains(string)) {
                int modifiers = declaredMethods[i].getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (Modifier.isFinal(modifiers)) {
                        hashSet.add(string);
                    } else if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                        arrayList.add(declaredMethods[i]);
                        hashSet.add(string);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.Class<?> loadAdapterClass(java.lang.String r4, byte[] r5) {
        /*
            java.lang.Class r0 = org.mozilla.javascript.SecurityController.getStaticSecurityDomainClass()
            java.lang.Class<java.security.CodeSource> r1 = java.security.CodeSource.class
            r2 = 0
            if (r0 == r1) goto L10
            java.lang.Class<java.security.ProtectionDomain> r1 = java.security.ProtectionDomain.class
            if (r0 != r1) goto Le
            goto L10
        Le:
            r1 = r2
            goto L28
        L10:
            java.security.ProtectionDomain r1 = org.mozilla.javascript.SecurityUtilities.getScriptProtectionDomain()
            if (r1 != 0) goto L1c
            java.lang.Class<org.mozilla.javascript.JavaAdapter> r1 = org.mozilla.javascript.JavaAdapter.class
            java.security.ProtectionDomain r1 = r1.getProtectionDomain()
        L1c:
            java.lang.Class<java.security.CodeSource> r3 = java.security.CodeSource.class
            if (r0 != r3) goto L28
            if (r1 != 0) goto L23
            goto Le
        L23:
            java.security.CodeSource r0 = r1.getCodeSource()
            r1 = r0
        L28:
            org.mozilla.javascript.GeneratedClassLoader r0 = org.mozilla.javascript.SecurityController.createLoader(r2, r1)
            java.lang.Class r4 = r0.defineClass(r4, r5)
            r0.linkClass(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaAdapter.loadAdapterClass(java.lang.String, byte[]):java.lang.Class");
    }

    public static Function getFunction(Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            return null;
        }
        if (!(property instanceof Function)) {
            throw ScriptRuntime.notFunctionError(property, str);
        }
        return (Function) property;
    }

    public static Object callMethod(ContextFactory contextFactory, final Scriptable scriptable, final Function function, final Object[] objArr, final long j) {
        if (function == null) {
            return null;
        }
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        final Scriptable parentScope = function.getParentScope();
        if (j == 0) {
            return Context.call(contextFactory, function, parentScope, scriptable, objArr);
        }
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null) {
            return doCall(currentContext, parentScope, scriptable, function, objArr, j);
        }
        return contextFactory.call(new ContextAction() { // from class: org.mozilla.javascript.JavaAdapter.1
            @Override // org.mozilla.javascript.ContextAction
            public Object run(Context context) {
                return JavaAdapter.doCall(context, parentScope, scriptable, function, objArr, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object doCall(Context context, Scriptable scriptable, Scriptable scriptable2, Function function, Object[] objArr, long j) {
        for (int i = 0; i != objArr.length; i++) {
            if (0 != (((long) (1 << i)) & j)) {
                Object obj = objArr[i];
                if (!(obj instanceof Scriptable)) {
                    objArr[i] = context.getWrapFactory().wrap(context, scriptable, obj, null);
                }
            }
        }
        return function.call(context, scriptable, scriptable2, objArr);
    }

    public static Scriptable runScript(final Script script) {
        return (Scriptable) ContextFactory.getGlobal().call(new ContextAction() { // from class: org.mozilla.javascript.JavaAdapter.2
            @Override // org.mozilla.javascript.ContextAction
            public Object run(Context context) {
                ScriptableObject global = ScriptRuntime.getGlobal(context);
                script.exec(context, global);
                return global;
            }
        });
    }

    private static void generateCtor(ClassFileWriter classFileWriter, String str, String str2, Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        short sGeneratePushParam = 3;
        if (parameterTypes.length == 0) {
            classFileWriter.startMethod("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", (short) 1);
            classFileWriter.add(42);
            classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, str2, "<init>", "()V");
        } else {
            StringBuilder sb = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
            int length = sb.length();
            for (Class<?> cls : parameterTypes) {
                appendTypeString(sb, cls);
            }
            sb.append(")V");
            classFileWriter.startMethod("<init>", sb.toString(), (short) 1);
            classFileWriter.add(42);
            for (Class<?> cls2 : parameterTypes) {
                sGeneratePushParam = (short) (sGeneratePushParam + generatePushParam(classFileWriter, sGeneratePushParam, cls2));
            }
            sb.delete(1, length);
            classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, str2, "<init>", sb.toString());
        }
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(ByteCode.PUTFIELD, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(42);
        classFileWriter.add(44);
        classFileWriter.add(ByteCode.PUTFIELD, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(42);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(ByteCode.PUTFIELD, str, "self", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(ByteCode.RETURN);
        classFileWriter.stopMethod(sGeneratePushParam);
    }

    private static void generateSerialCtor(ClassFileWriter classFileWriter, String str, String str2) {
        classFileWriter.startMethod("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", (short) 1);
        classFileWriter.add(42);
        classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, str2, "<init>", "()V");
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(ByteCode.PUTFIELD, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.add(42);
        classFileWriter.add(44);
        classFileWriter.add(ByteCode.PUTFIELD, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(42);
        classFileWriter.add(45);
        classFileWriter.add(ByteCode.PUTFIELD, str, "self", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(ByteCode.RETURN);
        classFileWriter.stopMethod((short) 4);
    }

    private static void generateEmptyCtor(ClassFileWriter classFileWriter, String str, String str2, String str3) {
        classFileWriter.startMethod("<init>", "()V", (short) 1);
        classFileWriter.add(42);
        classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, str2, "<init>", "()V");
        classFileWriter.add(42);
        classFileWriter.add(1);
        classFileWriter.add(ByteCode.PUTFIELD, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.add(ByteCode.NEW, str3);
        classFileWriter.add(89);
        classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, str3, "<init>", "()V");
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/JavaAdapter", "runScript", "(Lorg/mozilla/javascript/Script;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(76);
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(ByteCode.PUTFIELD, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(42);
        classFileWriter.add(43);
        classFileWriter.add(42);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(ByteCode.PUTFIELD, str, "self", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(ByteCode.RETURN);
        classFileWriter.stopMethod((short) 2);
    }

    static void generatePushWrappedArgs(ClassFileWriter classFileWriter, Class<?>[] clsArr, int i) {
        classFileWriter.addPush(i);
        classFileWriter.add(189, "java/lang/Object");
        int iGenerateWrapArg = 1;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            classFileWriter.add(89);
            classFileWriter.addPush(i2);
            iGenerateWrapArg += generateWrapArg(classFileWriter, iGenerateWrapArg, clsArr[i2]);
            classFileWriter.add(83);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int generateWrapArg(org.mozilla.classfile.ClassFileWriter r7, int r8, java.lang.Class<?> r9) {
        /*
            boolean r0 = r9.isPrimitive()
            r1 = 1
            if (r0 != 0) goto Ld
            r9 = 25
            r7.add(r9, r8)
            return r1
        Ld:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            java.lang.String r2 = "<init>"
            r3 = 183(0xb7, float:2.56E-43)
            r4 = 89
            r5 = 187(0xbb, float:2.62E-43)
            r6 = 21
            if (r9 != r0) goto L2c
            java.lang.String r9 = "java/lang/Boolean"
            r7.add(r5, r9)
            r7.add(r4)
            r7.add(r6, r8)
            java.lang.String r8 = "(Z)V"
            r7.addInvoke(r3, r9, r2, r8)
            return r1
        L2c:
            java.lang.Class r0 = java.lang.Character.TYPE
            if (r9 != r0) goto L3f
            r7.add(r6, r8)
            java.lang.String r8 = "valueOf"
            java.lang.String r9 = "(C)Ljava/lang/String;"
            r0 = 184(0xb8, float:2.58E-43)
            java.lang.String r2 = "java/lang/String"
            r7.addInvoke(r0, r2, r8, r9)
            return r1
        L3f:
            java.lang.String r0 = "java/lang/Double"
            r7.add(r5, r0)
            r7.add(r4)
            java.lang.String r9 = r9.getName()
            r4 = 0
            char r9 = r9.charAt(r4)
            r4 = 98
            if (r9 == r4) goto L87
            r4 = 100
            r5 = 2
            if (r9 == r4) goto L80
            r4 = 102(0x66, float:1.43E-43)
            if (r9 == r4) goto L75
            r4 = 105(0x69, float:1.47E-43)
            if (r9 == r4) goto L87
            r4 = 108(0x6c, float:1.51E-43)
            if (r9 == r4) goto L6a
            r4 = 115(0x73, float:1.61E-43)
            if (r9 == r4) goto L87
            goto L8f
        L6a:
            r9 = 22
            r7.add(r9, r8)
            r8 = 138(0x8a, float:1.93E-43)
            r7.add(r8)
            goto L85
        L75:
            r9 = 23
            r7.add(r9, r8)
            r8 = 141(0x8d, float:1.98E-43)
            r7.add(r8)
            goto L8f
        L80:
            r9 = 24
            r7.add(r9, r8)
        L85:
            r1 = r5
            goto L8f
        L87:
            r7.add(r6, r8)
            r8 = 135(0x87, float:1.89E-43)
            r7.add(r8)
        L8f:
            java.lang.String r8 = "(D)V"
            r7.addInvoke(r3, r0, r2, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaAdapter.generateWrapArg(org.mozilla.classfile.ClassFileWriter, int, java.lang.Class):int");
    }

    static void generateReturnResult(ClassFileWriter classFileWriter, Class<?> cls, boolean z) {
        if (cls == Void.TYPE) {
            classFileWriter.add(87);
            classFileWriter.add(ByteCode.RETURN);
            return;
        }
        if (cls == Boolean.TYPE) {
            classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/Context", "toBoolean", "(Ljava/lang/Object;)Z");
            classFileWriter.add(172);
            return;
        }
        if (cls == Character.TYPE) {
            classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/Context", InAppPurchaseConstants.METHOD_TO_STRING, "(Ljava/lang/Object;)Ljava/lang/String;");
            classFileWriter.add(3);
            classFileWriter.addInvoke(ByteCode.INVOKEVIRTUAL, "java/lang/String", "charAt", "(I)C");
            classFileWriter.add(172);
            return;
        }
        if (cls.isPrimitive()) {
            classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/Context", "toNumber", "(Ljava/lang/Object;)D");
            char cCharAt = cls.getName().charAt(0);
            if (cCharAt != 'b') {
                if (cCharAt == 'd') {
                    classFileWriter.add(ByteCode.DRETURN);
                    return;
                }
                if (cCharAt == 'f') {
                    classFileWriter.add(144);
                    classFileWriter.add(ByteCode.FRETURN);
                    return;
                } else if (cCharAt != 'i') {
                    if (cCharAt == 'l') {
                        classFileWriter.add(143);
                        classFileWriter.add(ByteCode.LRETURN);
                        return;
                    } else if (cCharAt != 's') {
                        throw new RuntimeException("Unexpected return type " + cls.toString());
                    }
                }
            }
            classFileWriter.add(142);
            classFileWriter.add(172);
            return;
        }
        String name = cls.getName();
        if (z) {
            classFileWriter.addLoadConstant(name);
            classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
            classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
        }
        classFileWriter.add(192, name);
        classFileWriter.add(ByteCode.ARETURN);
    }

    private static void generateMethod(ClassFileWriter classFileWriter, String str, String str2, Class<?>[] clsArr, Class<?> cls, boolean z) {
        StringBuilder sb = new StringBuilder();
        int iAppendMethodSignature = appendMethodSignature(clsArr, cls, sb);
        classFileWriter.startMethod(str2, sb.toString(), (short) 1);
        classFileWriter.add(42);
        classFileWriter.add(180, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.add(42);
        classFileWriter.add(180, str, "self", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.add(42);
        classFileWriter.add(180, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.addPush(str2);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
        generatePushWrappedArgs(classFileWriter, clsArr, clsArr.length);
        if (clsArr.length > 64) {
            throw Context.reportRuntimeError0("JavaAdapter can not subclass methods with more then 64 arguments.");
        }
        long j = 0;
        for (int i = 0; i != clsArr.length; i++) {
            if (!clsArr[i].isPrimitive()) {
                j |= (long) (1 << i);
            }
        }
        classFileWriter.addPush(j);
        classFileWriter.addInvoke(ByteCode.INVOKESTATIC, "org/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
        generateReturnResult(classFileWriter, cls, z);
        classFileWriter.stopMethod((short) iAppendMethodSignature);
    }

    private static int generatePushParam(ClassFileWriter classFileWriter, int i, Class<?> cls) {
        if (!cls.isPrimitive()) {
            classFileWriter.addALoad(i);
            return 1;
        }
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt != 'f') {
            if (cCharAt != 'i') {
                if (cCharAt == 'l') {
                    classFileWriter.addLLoad(i);
                    return 2;
                }
                if (cCharAt != 's' && cCharAt != 'z') {
                    switch (cCharAt) {
                        case 'b':
                        case 'c':
                            break;
                        case 'd':
                            classFileWriter.addDLoad(i);
                            return 2;
                        default:
                            throw Kit.codeBug();
                    }
                }
            }
            classFileWriter.addILoad(i);
            return 1;
        }
        classFileWriter.addFLoad(i);
        return 1;
    }

    private static void generatePopResult(ClassFileWriter classFileWriter, Class<?> cls) {
        if (cls.isPrimitive()) {
            char cCharAt = cls.getName().charAt(0);
            if (cCharAt != 'f') {
                if (cCharAt != 'i') {
                    if (cCharAt == 'l') {
                        classFileWriter.add(ByteCode.LRETURN);
                        return;
                    } else if (cCharAt != 's' && cCharAt != 'z') {
                        switch (cCharAt) {
                            case 'd':
                                classFileWriter.add(ByteCode.DRETURN);
                                break;
                        }
                        return;
                    }
                }
                classFileWriter.add(172);
                return;
            }
            classFileWriter.add(ByteCode.FRETURN);
            return;
        }
        classFileWriter.add(ByteCode.ARETURN);
    }

    private static void generateSuper(ClassFileWriter classFileWriter, String str, String str2, String str3, String str4, Class<?>[] clsArr, Class<?> cls) {
        classFileWriter.startMethod("super$" + str3, str4, (short) 1);
        classFileWriter.add(25, 0);
        int iGeneratePushParam = 1;
        for (Class<?> cls2 : clsArr) {
            iGeneratePushParam += generatePushParam(classFileWriter, iGeneratePushParam, cls2);
        }
        classFileWriter.addInvoke(ByteCode.INVOKESPECIAL, str2, str3, str4);
        if (!cls.equals(Void.TYPE)) {
            generatePopResult(classFileWriter, cls);
        } else {
            classFileWriter.add(ByteCode.RETURN);
        }
        classFileWriter.stopMethod((short) (iGeneratePushParam + 1));
    }

    private static String getMethodSignature(Method method, Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        appendMethodSignature(clsArr, method.getReturnType(), sb);
        return sb.toString();
    }

    static int appendMethodSignature(Class<?>[] clsArr, Class<?> cls, StringBuilder sb) {
        sb.append('(');
        int length = clsArr.length + 1;
        for (Class<?> cls2 : clsArr) {
            appendTypeString(sb, cls2);
            if (cls2 == Long.TYPE || cls2 == Double.TYPE) {
                length++;
            }
        }
        sb.append(')');
        appendTypeString(sb, cls);
        return length;
    }

    private static StringBuilder appendTypeString(StringBuilder sb, Class<?> cls) {
        char upperCase;
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls == Boolean.TYPE) {
                upperCase = Matrix.MATRIX_TYPE_ZERO;
            } else {
                upperCase = cls == Long.TYPE ? 'J' : Character.toUpperCase(cls.getName().charAt(0));
            }
            sb.append(upperCase);
            return sb;
        }
        sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
        sb.append(cls.getName().replace('.', '/'));
        sb.append(';');
        return sb;
    }

    static int[] getArgsToConvert(Class<?>[] clsArr) {
        int i = 0;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            if (!clsArr[i2].isPrimitive()) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 != clsArr.length; i4++) {
            if (!clsArr[i4].isPrimitive()) {
                iArr[i3] = i4;
                i3++;
            }
        }
        return iArr;
    }
}
