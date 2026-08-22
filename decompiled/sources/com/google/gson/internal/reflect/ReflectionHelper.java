package com.google.gson.internal.reflect;

import com.csvreader.CsvReader;
import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class ReflectionHelper {
    private ReflectionHelper() {
    }

    public static void makeAccessible(Field field) throws JsonIOException {
        try {
            field.setAccessible(true);
        } catch (Exception e2) {
            throw new JsonIOException("Failed making field '" + field.getDeclaringClass().getName() + MqttTopic.MULTI_LEVEL_WILDCARD + field.getName() + "' accessible; either change its visibility or write a custom TypeAdapter for its declaring type", e2);
        }
    }

    private static String constructorToString(Constructor<?> constructor) {
        StringBuilder sbAppend = new StringBuilder(constructor.getDeclaringClass().getName()).append(CsvReader.Letters.POUND).append(constructor.getDeclaringClass().getSimpleName()).append('(');
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            if (i > 0) {
                sbAppend.append(", ");
            }
            sbAppend.append(parameterTypes[i].getSimpleName());
        }
        return sbAppend.append(')').toString();
    }

    public static String tryMakeAccessible(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e2) {
            return "Failed making constructor '" + constructorToString(constructor) + "' accessible; either change its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e2.getMessage();
        }
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.9.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }
}
