package androidx.window.reflection;

import android.util.Log;
import com.csvreader.CsvReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: ReflectionUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0000¢\u0006\u0002\b\tJ#\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0001¢\u0006\u0002\b\u000eJ\u001d\u0010\u0017\u001a\u00020\u0005*\u00020\u00132\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0000¢\u0006\u0002\b\u001aJ\u001d\u0010\u0017\u001a\u00020\u0005*\u00020\u00132\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\bH\u0000¢\u0006\u0002\b\u001aJ%\u0010\u001b\u001a\u00020\u00052\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\b2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\bH\u0000¢\u0006\u0002\b\u001eR\u001c\u0010\u000f\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000f\u001a\u00020\u0005*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0014R\u0018\u0010\u000f\u001a\u00020\u0005*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0016¨\u0006\u001f"}, d2 = {"Landroidx/window/reflection/ReflectionUtils;", "", "<init>", "()V", "checkIsPresent", "", "classLoader", "Lkotlin/Function0;", "Ljava/lang/Class;", "checkIsPresent$window_release", "validateReflection", "errorMessage", "", BlockContactsIQ.ELEMENT, "validateReflection$window_release", "isPublic", "Ljava/lang/reflect/Constructor;", "isPublic$window_release", "(Ljava/lang/reflect/Constructor;)Z", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Z", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)Z", "doesReturn", "clazz", "Lkotlin/reflect/KClass;", "doesReturn$window_release", "validateImplementation", "implementation", "requirements", "validateImplementation$window_release", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReflectionUtils {
    public static final ReflectionUtils INSTANCE = new ReflectionUtils();

    private ReflectionUtils() {
    }

    public final boolean checkIsPresent$window_release(Function0<? extends Class<?>> classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        try {
            classLoader.invoke();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean validateReflection$window_release(String errorMessage, Function0<Boolean> block) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            boolean zBooleanValue = block.invoke().booleanValue();
            if (!zBooleanValue) {
                Log.e("ReflectionGuard", errorMessage);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            Log.e("ReflectionGuard", "ClassNotFound: " + errorMessage);
            return false;
        } catch (NoSuchFieldException unused2) {
            Log.e("ReflectionGuard", "NoSuchField: " + errorMessage);
            return false;
        } catch (NoSuchMethodException unused3) {
            Log.e("ReflectionGuard", "NoSuchMethod: " + errorMessage);
            return false;
        }
    }

    public final boolean isPublic$window_release(Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "<this>");
        return Modifier.isPublic(constructor.getModifiers());
    }

    public final boolean isPublic$window_release(Method method) {
        Intrinsics.checkNotNullParameter(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }

    public final boolean isPublic$window_release(Field field) {
        Intrinsics.checkNotNullParameter(field, "<this>");
        return Modifier.isPublic(field.getModifiers());
    }

    public final boolean doesReturn$window_release(Method method, KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(method, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return doesReturn$window_release(method, JvmClassMappingKt.getJavaClass((KClass) clazz));
    }

    public final boolean doesReturn$window_release(Method method, Class<?> clazz) {
        Intrinsics.checkNotNullParameter(method, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return method.getReturnType().equals(clazz);
    }

    public final boolean validateImplementation$window_release(final Class<?> implementation, Class<?> requirements) {
        Intrinsics.checkNotNullParameter(implementation, "implementation");
        Intrinsics.checkNotNullParameter(requirements, "requirements");
        Method[] methods = requirements.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
        for (final Method method : methods) {
            if (!validateReflection$window_release(implementation.getName() + CsvReader.Letters.POUND + method.getName() + " is not valid", new Function0() { // from class: androidx.window.reflection.ReflectionUtils$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(ReflectionUtils.validateImplementation$lambda$1$lambda$0(implementation, method));
                }
            })) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean validateImplementation$lambda$1$lambda$0(Class cls, Method method) throws NoSuchMethodException {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method method2 = cls.getMethod(name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        ReflectionUtils reflectionUtils = INSTANCE;
        Intrinsics.checkNotNull(method2);
        if (!reflectionUtils.isPublic$window_release(method2)) {
            return false;
        }
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return reflectionUtils.doesReturn$window_release(method2, returnType);
    }
}
