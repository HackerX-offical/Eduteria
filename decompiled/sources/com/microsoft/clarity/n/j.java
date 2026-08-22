package com.microsoft.clarity.n;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Class<?>> f1093a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<Pair<String, String>, Method> f1094b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<Pair<String, String>, Field> f1095c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Object> f1096d = new HashMap<>();

    public static final class a {
        public static Class a(String name) throws ClassNotFoundException {
            Intrinsics.checkNotNullParameter(name, "name");
            if (j.f1093a.get(name) == null) {
                HashMap map = j.f1093a;
                Class<?> cls = Class.forName(name);
                Intrinsics.checkNotNullExpressionValue(cls, "forName(name)");
                map.put(name, cls);
            }
            Object obj = j.f1093a.get(name);
            Intrinsics.checkNotNull(obj);
            return (Class) obj;
        }

        public static Object a(ClassLoader classLoader, Class[] interfaces, Function0 invocationHandlerFactory) {
            Intrinsics.checkNotNullParameter(interfaces, "interfaces");
            Intrinsics.checkNotNullParameter(invocationHandlerFactory, "invocationHandlerFactory");
            Object objNewProxyInstance = Proxy.newProxyInstance(classLoader, interfaces, (InvocationHandler) invocationHandlerFactory.invoke());
            Intrinsics.checkNotNullExpressionValue(objNewProxyInstance, "newProxyInstance(\n      …erFactory()\n            )");
            return objNewProxyInstance;
        }

        public static Object a(String key, ClassLoader classLoader, Class[] interfaces, com.microsoft.clarity.g.c invocationHandlerFactory) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(interfaces, "interfaces");
            Intrinsics.checkNotNullParameter(invocationHandlerFactory, "invocationHandlerFactory");
            if (j.f1096d.get(key) == null) {
                j.f1096d.put(key, a(classLoader, interfaces, invocationHandlerFactory));
            }
            Object obj = j.f1096d.get(key);
            Intrinsics.checkNotNull(obj);
            return obj;
        }

        public static Method a(String cls, String method, Class... parameterTypes) {
            Intrinsics.checkNotNullParameter(cls, "cls");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
            try {
                Pair pair = new Pair(cls, method);
                if (j.f1094b.get(pair) == null) {
                    HashMap map = j.f1094b;
                    Method declaredMethod = a(cls).getDeclaredMethod(method, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
                    Intrinsics.checkNotNullExpressionValue(declaredMethod, "getClass(cls).getDeclare…(method, *parameterTypes)");
                    map.put(pair, declaredMethod);
                    Object obj = j.f1094b.get(pair);
                    Intrinsics.checkNotNull(obj);
                    ((Method) obj).setAccessible(true);
                }
                Object obj2 = j.f1094b.get(pair);
                Intrinsics.checkNotNull(obj2);
                return (Method) obj2;
            } catch (Exception unused) {
                return null;
            }
        }

        public static Field b(String cls) {
            Intrinsics.checkNotNullParameter(cls, "cls");
            Intrinsics.checkNotNullParameter("mProvider", FormField.ELEMENT);
            Pair pair = new Pair(cls, "mProvider");
            if (j.f1095c.get(pair) == null) {
                HashMap map = j.f1095c;
                Field declaredField = a(cls).getDeclaredField("mProvider");
                Intrinsics.checkNotNullExpressionValue(declaredField, "getClass(cls).getDeclaredField(field)");
                map.put(pair, declaredField);
                Object obj = j.f1095c.get(pair);
                Intrinsics.checkNotNull(obj);
                ((Field) obj).setAccessible(true);
            }
            Object obj2 = j.f1095c.get(pair);
            Intrinsics.checkNotNull(obj2);
            return (Field) obj2;
        }
    }
}
