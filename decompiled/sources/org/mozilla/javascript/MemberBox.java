package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes10.dex */
final class MemberBox implements Serializable {
    private static final Class<?>[] primitives = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Double.TYPE, Float.TYPE, Integer.TYPE, Long.TYPE, Short.TYPE, Void.TYPE};
    static final long serialVersionUID = 6358550398665688245L;
    transient Class<?>[] argTypes;
    transient Object delegateTo;
    private transient Member memberObject;
    transient boolean vararg;

    MemberBox(Method method) {
        init(method);
    }

    MemberBox(Constructor<?> constructor) {
        init(constructor);
    }

    private void init(Method method) {
        this.memberObject = method;
        this.argTypes = method.getParameterTypes();
        this.vararg = method.isVarArgs();
    }

    private void init(Constructor<?> constructor) {
        this.memberObject = constructor;
        this.argTypes = constructor.getParameterTypes();
        this.vararg = constructor.isVarArgs();
    }

    Method method() {
        return (Method) this.memberObject;
    }

    Constructor<?> ctor() {
        return (Constructor) this.memberObject;
    }

    Member member() {
        return this.memberObject;
    }

    boolean isMethod() {
        return this.memberObject instanceof Method;
    }

    boolean isCtor() {
        return this.memberObject instanceof Constructor;
    }

    boolean isStatic() {
        return Modifier.isStatic(this.memberObject.getModifiers());
    }

    String getName() {
        return this.memberObject.getName();
    }

    Class<?> getDeclaringClass() {
        return this.memberObject.getDeclaringClass();
    }

    String toJavaDeclaration() {
        StringBuilder sb = new StringBuilder();
        if (isMethod()) {
            Method method = method();
            sb.append(method.getReturnType());
            sb.append(' ');
            sb.append(method.getName());
        } else {
            String name = ctor().getDeclaringClass().getName();
            int iLastIndexOf = name.lastIndexOf(46);
            if (iLastIndexOf >= 0) {
                name = name.substring(iLastIndexOf + 1);
            }
            sb.append(name);
        }
        sb.append(JavaMembers.liveConnectSignature(this.argTypes));
        return sb.toString();
    }

    public String toString() {
        return this.memberObject.toString();
    }

    Object invoke(Object obj, Object[] objArr) {
        Method method = method();
        try {
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException e2) {
                Method methodSearchAccessibleMethod = searchAccessibleMethod(method, this.argTypes);
                if (methodSearchAccessibleMethod != null) {
                    this.memberObject = methodSearchAccessibleMethod;
                    method = methodSearchAccessibleMethod;
                } else if (!VMBridge.instance.tryToMakeAccessible(method)) {
                    throw Context.throwAsScriptRuntimeEx(e2);
                }
                return method.invoke(obj, objArr);
            }
        } catch (InvocationTargetException e3) {
            e = e3;
            do {
                e = ((InvocationTargetException) e).getTargetException();
            } while (e instanceof InvocationTargetException);
            if (e instanceof ContinuationPending) {
                throw ((ContinuationPending) e);
            }
            throw Context.throwAsScriptRuntimeEx(e);
        } catch (Exception e4) {
            throw Context.throwAsScriptRuntimeEx(e4);
        }
    }

    Object newInstance(Object[] objArr) {
        Constructor<?> constructorCtor = ctor();
        try {
            try {
                return constructorCtor.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                if (!VMBridge.instance.tryToMakeAccessible(constructorCtor)) {
                    throw Context.throwAsScriptRuntimeEx(e2);
                }
                return constructorCtor.newInstance(objArr);
            }
        } catch (Exception e3) {
            throw Context.throwAsScriptRuntimeEx(e3);
        }
    }

    private static Method searchAccessibleMethod(Method method, Class<?>[] clsArr) {
        int modifiers = method.getModifiers();
        if (!Modifier.isPublic(modifiers) || Modifier.isStatic(modifiers)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return null;
        }
        String name = method.getName();
        Class<?>[] interfaces = declaringClass.getInterfaces();
        int length = interfaces.length;
        for (int i = 0; i != length; i++) {
            Class<?> cls = interfaces[i];
            if (Modifier.isPublic(cls.getModifiers())) {
                try {
                    return cls.getMethod(name, clsArr);
                } catch (NoSuchMethodException | SecurityException unused) {
                    continue;
                }
            }
        }
        while (true) {
            declaringClass = declaringClass.getSuperclass();
            if (declaringClass == null) {
                return null;
            }
            if (Modifier.isPublic(declaringClass.getModifiers())) {
                try {
                    Method method2 = declaringClass.getMethod(name, clsArr);
                    int modifiers2 = method2.getModifiers();
                    if (Modifier.isPublic(modifiers2) && !Modifier.isStatic(modifiers2)) {
                        return method2;
                    }
                } catch (NoSuchMethodException | SecurityException unused2) {
                    continue;
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Member member = readMember(objectInputStream);
        if (member instanceof Method) {
            init((Method) member);
        } else {
            init((Constructor<?>) member);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        writeMember(objectOutputStream, this.memberObject);
    }

    private static void writeMember(ObjectOutputStream objectOutputStream, Member member) throws IOException {
        if (member == null) {
            objectOutputStream.writeBoolean(false);
            return;
        }
        objectOutputStream.writeBoolean(true);
        boolean z = member instanceof Method;
        if (!z && !(member instanceof Constructor)) {
            throw new IllegalArgumentException("not Method or Constructor");
        }
        objectOutputStream.writeBoolean(z);
        objectOutputStream.writeObject(member.getName());
        objectOutputStream.writeObject(member.getDeclaringClass());
        if (z) {
            writeParameters(objectOutputStream, ((Method) member).getParameterTypes());
        } else {
            writeParameters(objectOutputStream, ((Constructor) member).getParameterTypes());
        }
    }

    private static Member readMember(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        if (!objectInputStream.readBoolean()) {
            return null;
        }
        boolean z = objectInputStream.readBoolean();
        String str = (String) objectInputStream.readObject();
        Class cls = (Class) objectInputStream.readObject();
        Class<?>[] parameters = readParameters(objectInputStream);
        try {
            if (z) {
                return cls.getMethod(str, parameters);
            }
            return cls.getConstructor(parameters);
        } catch (NoSuchMethodException e2) {
            throw new IOException("Cannot find member: " + e2);
        }
    }

    private static void writeParameters(ObjectOutputStream objectOutputStream, Class<?>[] clsArr) throws IOException {
        objectOutputStream.writeShort(clsArr.length);
        for (Class<?> cls : clsArr) {
            boolean zIsPrimitive = cls.isPrimitive();
            objectOutputStream.writeBoolean(zIsPrimitive);
            if (zIsPrimitive) {
                int i = 0;
                while (true) {
                    Class<?>[] clsArr2 = primitives;
                    if (i < clsArr2.length) {
                        if (cls.equals(clsArr2[i])) {
                            objectOutputStream.writeByte(i);
                            break;
                        }
                        i++;
                    } else {
                        throw new IllegalArgumentException("Primitive " + cls + " not found");
                    }
                }
            } else {
                objectOutputStream.writeObject(cls);
            }
        }
    }

    private static Class<?>[] readParameters(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int i = objectInputStream.readShort();
        Class<?>[] clsArr = new Class[i];
        for (int i2 = 0; i2 < i; i2++) {
            if (!objectInputStream.readBoolean()) {
                clsArr[i2] = (Class) objectInputStream.readObject();
            } else {
                clsArr[i2] = primitives[objectInputStream.readByte()];
            }
        }
        return clsArr;
    }
}
