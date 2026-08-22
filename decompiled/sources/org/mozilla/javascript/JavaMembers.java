package org.mozilla.javascript;

import com.csvreader.CsvReader;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes10.dex */
class JavaMembers {
    private Class<?> cl;
    NativeJavaMethod ctors;
    private Map<String, FieldAndMethods> fieldAndMethods;
    private Map<String, Object> members;
    private Map<String, FieldAndMethods> staticFieldAndMethods;
    private Map<String, Object> staticMembers;

    JavaMembers(Scriptable scriptable, Class<?> cls) {
        this(scriptable, cls, false);
    }

    JavaMembers(Scriptable scriptable, Class<?> cls, boolean z) {
        try {
            Context contextEnterContext = ContextFactory.getGlobal().enterContext();
            ClassShutter classShutter = contextEnterContext.getClassShutter();
            if (classShutter != null && !classShutter.visibleToScripts(cls.getName())) {
                throw Context.reportRuntimeError1("msg.access.prohibited", cls.getName());
            }
            this.members = new HashMap();
            this.staticMembers = new HashMap();
            this.cl = cls;
            reflect(scriptable, z, contextEnterContext.hasFeature(13));
        } finally {
            Context.exit();
        }
    }

    boolean has(String str, boolean z) {
        return ((z ? this.staticMembers : this.members).get(str) == null && findExplicitFunction(str, z) == null) ? false : true;
    }

    Object get(Scriptable scriptable, String str, Object obj, boolean z) {
        Object objInvoke;
        Class<?> type;
        Object explicitFunction = (z ? this.staticMembers : this.members).get(str);
        if (!z && explicitFunction == null) {
            explicitFunction = this.staticMembers.get(str);
        }
        if (explicitFunction == null && (explicitFunction = getExplicitFunction(scriptable, str, obj, z)) == null) {
            return Scriptable.NOT_FOUND;
        }
        if (explicitFunction instanceof Scriptable) {
            return explicitFunction;
        }
        Context context = Context.getContext();
        try {
            if (explicitFunction instanceof BeanProperty) {
                BeanProperty beanProperty = (BeanProperty) explicitFunction;
                if (beanProperty.getter == null) {
                    return Scriptable.NOT_FOUND;
                }
                objInvoke = beanProperty.getter.invoke(obj, Context.emptyArgs);
                type = beanProperty.getter.method().getReturnType();
            } else {
                Field field = (Field) explicitFunction;
                if (z) {
                    obj = null;
                }
                objInvoke = field.get(obj);
                type = field.getType();
            }
            return context.getWrapFactory().wrap(context, ScriptableObject.getTopLevelScope(scriptable), objInvoke, type);
        } catch (Exception e2) {
            throw Context.throwAsScriptRuntimeEx(e2);
        }
    }

    void put(Scriptable scriptable, String str, Object obj, Object obj2, boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        Object obj3 = map.get(str);
        if (!z && obj3 == null) {
            obj3 = this.staticMembers.get(str);
        }
        if (obj3 == null) {
            throw reportMemberNotFound(str);
        }
        if (obj3 instanceof FieldAndMethods) {
            obj3 = ((FieldAndMethods) map.get(str)).field;
        }
        if (obj3 instanceof BeanProperty) {
            BeanProperty beanProperty = (BeanProperty) obj3;
            if (beanProperty.setter == null) {
                throw reportMemberNotFound(str);
            }
            if (beanProperty.setters == null || obj2 == null) {
                try {
                    beanProperty.setter.invoke(obj, new Object[]{Context.jsToJava(obj2, beanProperty.setter.argTypes[0])});
                    return;
                } catch (Exception e2) {
                    throw Context.throwAsScriptRuntimeEx(e2);
                }
            }
            beanProperty.setters.call(Context.getContext(), ScriptableObject.getTopLevelScope(scriptable), scriptable, new Object[]{obj2});
            return;
        }
        if (!(obj3 instanceof Field)) {
            throw Context.reportRuntimeError1(obj3 == null ? "msg.java.internal.private" : "msg.java.method.assign", str);
        }
        Field field = (Field) obj3;
        try {
            field.set(obj, Context.jsToJava(obj2, field.getType()));
        } catch (IllegalAccessException e3) {
            if ((field.getModifiers() & 16) == 0) {
                throw Context.throwAsScriptRuntimeEx(e3);
            }
        } catch (IllegalArgumentException unused) {
            throw Context.reportRuntimeError3("msg.java.internal.field.type", obj2.getClass().getName(), field, obj.getClass().getName());
        }
    }

    Object[] getIds(boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        return map.keySet().toArray(new Object[map.size()]);
    }

    static String javaSignature(Class<?> cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        int i = 0;
        do {
            i++;
            cls = cls.getComponentType();
        } while (cls.isArray());
        String name = cls.getName();
        if (i == 1) {
            return name.concat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        StringBuilder sb = new StringBuilder(name.length() + (HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.length() * i));
        sb.append(name);
        while (i != 0) {
            i--;
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    static String liveConnectSignature(Class<?>[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i != length; i++) {
            if (i != 0) {
                sb.append(CsvReader.Letters.COMMA);
            }
            sb.append(javaSignature(clsArr[i]));
        }
        sb.append(')');
        return sb.toString();
    }

    private MemberBox findExplicitFunction(String str, boolean z) {
        MemberBox[] memberBoxArr;
        int iIndexOf = str.indexOf(40);
        if (iIndexOf < 0) {
            return null;
        }
        Map<String, Object> map = z ? this.staticMembers : this.members;
        if (z && iIndexOf == 0) {
            memberBoxArr = this.ctors.methods;
        } else {
            String strSubstring = str.substring(0, iIndexOf);
            Object obj = map.get(strSubstring);
            if (!z && obj == null) {
                obj = this.staticMembers.get(strSubstring);
            }
            memberBoxArr = obj instanceof NativeJavaMethod ? ((NativeJavaMethod) obj).methods : null;
        }
        if (memberBoxArr != null) {
            for (MemberBox memberBox : memberBoxArr) {
                String strLiveConnectSignature = liveConnectSignature(memberBox.argTypes);
                if (strLiveConnectSignature.length() + iIndexOf == str.length() && str.regionMatches(iIndexOf, strLiveConnectSignature, 0, strLiveConnectSignature.length())) {
                    return memberBox;
                }
            }
        }
        return null;
    }

    private Object getExplicitFunction(Scriptable scriptable, String str, Object obj, boolean z) {
        Map<String, Object> map = z ? this.staticMembers : this.members;
        MemberBox memberBoxFindExplicitFunction = findExplicitFunction(str, z);
        if (memberBoxFindExplicitFunction == null) {
            return null;
        }
        Scriptable functionPrototype = ScriptableObject.getFunctionPrototype(scriptable);
        if (memberBoxFindExplicitFunction.isCtor()) {
            NativeJavaConstructor nativeJavaConstructor = new NativeJavaConstructor(memberBoxFindExplicitFunction);
            nativeJavaConstructor.setPrototype(functionPrototype);
            map.put(str, nativeJavaConstructor);
            return nativeJavaConstructor;
        }
        Object obj2 = map.get(memberBoxFindExplicitFunction.getName());
        if (!(obj2 instanceof NativeJavaMethod) || ((NativeJavaMethod) obj2).methods.length <= 1) {
            return obj2;
        }
        NativeJavaMethod nativeJavaMethod = new NativeJavaMethod(memberBoxFindExplicitFunction, str);
        nativeJavaMethod.setPrototype(functionPrototype);
        map.put(str, nativeJavaMethod);
        return nativeJavaMethod;
    }

    private static Method[] discoverAccessibleMethods(Class<?> cls, boolean z, boolean z2) {
        HashMap map = new HashMap();
        discoverAccessibleMethods(cls, map, z, z2);
        return (Method[]) map.values().toArray(new Method[map.size()]);
    }

    private static void discoverAccessibleMethods(Class<?> cls, Map<MethodSignature, Method> map, boolean z, boolean z2) {
        if (Modifier.isPublic(cls.getModifiers()) || z2) {
            try {
                if (!z && !z2) {
                    for (Method method : cls.getMethods()) {
                        MethodSignature methodSignature = new MethodSignature(method);
                        if (!map.containsKey(methodSignature)) {
                            map.put(methodSignature, method);
                        }
                    }
                    return;
                }
                while (cls != null) {
                    try {
                        for (Method method2 : cls.getDeclaredMethods()) {
                            int modifiers = method2.getModifiers();
                            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers) || z2) {
                                MethodSignature methodSignature2 = new MethodSignature(method2);
                                if (!map.containsKey(methodSignature2)) {
                                    if (z2 && !method2.isAccessible()) {
                                        method2.setAccessible(true);
                                    }
                                    map.put(methodSignature2, method2);
                                }
                            }
                        }
                        for (Class<?> cls2 : cls.getInterfaces()) {
                            discoverAccessibleMethods(cls2, map, z, z2);
                        }
                        cls = cls.getSuperclass();
                    } catch (SecurityException unused) {
                        for (Method method3 : cls.getMethods()) {
                            MethodSignature methodSignature3 = new MethodSignature(method3);
                            if (!map.containsKey(methodSignature3)) {
                                map.put(methodSignature3, method3);
                            }
                        }
                        return;
                    }
                }
                return;
            } catch (SecurityException unused2) {
                Context.reportWarning("Could not discover accessible methods of class " + cls.getName() + " due to lack of privileges, attemping superclasses/interfaces.");
            }
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            discoverAccessibleMethods(cls3, map, z, z2);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            discoverAccessibleMethods(superclass, map, z, z2);
        }
    }

    private static final class MethodSignature {
        private final Class<?>[] args;
        private final String name;

        private MethodSignature(String str, Class<?>[] clsArr) {
            this.name = str;
            this.args = clsArr;
        }

        MethodSignature(Method method) {
            this(method.getName(), method.getParameterTypes());
        }

        public boolean equals(Object obj) {
            if (obj instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) obj;
                if (methodSignature.name.equals(this.name) && Arrays.equals(this.args, methodSignature.args)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode() ^ this.args.length;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0246  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void reflect(org.mozilla.javascript.Scriptable r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaMembers.reflect(org.mozilla.javascript.Scriptable, boolean, boolean):void");
    }

    private Constructor<?>[] getAccessibleConstructors(boolean z) {
        if (z && this.cl != ScriptRuntime.ClassClass) {
            try {
                Constructor<?>[] declaredConstructors = this.cl.getDeclaredConstructors();
                AccessibleObject.setAccessible(declaredConstructors, true);
                return declaredConstructors;
            } catch (SecurityException unused) {
                Context.reportWarning("Could not access constructor  of class " + this.cl.getName() + " due to lack of privileges.");
            }
        }
        return this.cl.getConstructors();
    }

    private Field[] getAccessibleFields(boolean z, boolean z2) {
        if (z2 || z) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Class<?> superclass = this.cl; superclass != null; superclass = superclass.getSuperclass()) {
                    for (Field field : superclass.getDeclaredFields()) {
                        int modifiers = field.getModifiers();
                        if (z2 || Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                            if (!field.isAccessible()) {
                                field.setAccessible(true);
                            }
                            arrayList.add(field);
                        }
                    }
                }
                return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
            } catch (SecurityException unused) {
            }
        }
        return this.cl.getFields();
    }

    private MemberBox findGetter(boolean z, Map<String, Object> map, String str, String str2) {
        String strConcat = str.concat(str2);
        if (!map.containsKey(strConcat)) {
            return null;
        }
        Object obj = map.get(strConcat);
        if (obj instanceof NativeJavaMethod) {
            return extractGetMethod(((NativeJavaMethod) obj).methods, z);
        }
        return null;
    }

    private static MemberBox extractGetMethod(MemberBox[] memberBoxArr, boolean z) {
        for (MemberBox memberBox : memberBoxArr) {
            if (memberBox.argTypes.length == 0 && (!z || memberBox.isStatic())) {
                if (memberBox.method().getReturnType() != Void.TYPE) {
                    return memberBox;
                }
                return null;
            }
        }
        return null;
    }

    private static MemberBox extractSetMethod(Class<?> cls, MemberBox[] memberBoxArr, boolean z) {
        for (int i = 1; i <= 2; i++) {
            for (MemberBox memberBox : memberBoxArr) {
                if (!z || memberBox.isStatic()) {
                    Class<?>[] clsArr = memberBox.argTypes;
                    if (clsArr.length != 1) {
                        continue;
                    } else if (i == 1) {
                        if (clsArr[0] == cls) {
                            return memberBox;
                        }
                    } else {
                        if (i != 2) {
                            Kit.codeBug();
                        }
                        if (clsArr[0].isAssignableFrom(cls)) {
                            return memberBox;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static MemberBox extractSetMethod(MemberBox[] memberBoxArr, boolean z) {
        for (MemberBox memberBox : memberBoxArr) {
            if ((!z || memberBox.isStatic()) && memberBox.method().getReturnType() == Void.TYPE && memberBox.argTypes.length == 1) {
                return memberBox;
            }
        }
        return null;
    }

    Map<String, FieldAndMethods> getFieldAndMethodsObjects(Scriptable scriptable, Object obj, boolean z) {
        Map<String, FieldAndMethods> map = z ? this.staticFieldAndMethods : this.fieldAndMethods;
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap(map.size());
        for (FieldAndMethods fieldAndMethods : map.values()) {
            FieldAndMethods fieldAndMethods2 = new FieldAndMethods(scriptable, fieldAndMethods.methods, fieldAndMethods.field);
            fieldAndMethods2.javaObject = obj;
            map2.put(fieldAndMethods.field.getName(), fieldAndMethods2);
        }
        return map2;
    }

    static JavaMembers lookupClass(Scriptable scriptable, Class<?> cls, Class<?> cls2, boolean z) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<Class<?>, JavaMembers> classCacheMap = classCache.getClassCacheMap();
        Class<?> cls3 = cls;
        while (true) {
            JavaMembers javaMembers = classCacheMap.get(cls3);
            if (javaMembers != null) {
                if (cls3 != cls) {
                    classCacheMap.put(cls, javaMembers);
                }
                return javaMembers;
            }
            try {
                JavaMembers javaMembers2 = new JavaMembers(classCache.getAssociatedScope(), cls3, z);
                if (classCache.isCachingEnabled()) {
                    classCacheMap.put(cls3, javaMembers2);
                    if (cls3 != cls) {
                        classCacheMap.put(cls, javaMembers2);
                    }
                }
                return javaMembers2;
            } catch (SecurityException e2) {
                if (cls2 == null || !cls2.isInterface()) {
                    Class<?> superclass = cls3.getSuperclass();
                    if (superclass == null) {
                        if (cls3.isInterface()) {
                            superclass = ScriptRuntime.ObjectClass;
                        } else {
                            throw e2;
                        }
                    }
                    cls3 = superclass;
                } else {
                    cls3 = cls2;
                    cls2 = null;
                }
            }
        }
    }

    RuntimeException reportMemberNotFound(String str) {
        return Context.reportRuntimeError2("msg.java.member.not.found", this.cl.getName(), str);
    }
}
