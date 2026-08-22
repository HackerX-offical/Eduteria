package com.clevertap.android.sdk.variables;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.variables.annotations.Variable;
import com.clevertap.android.sdk.variables.callbacks.VariableCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class Parser {
    private final CTVariables ctVariables;

    private static void log(String str) {
        Logger.v("variables", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str, Throwable th) {
        Logger.v("variables", str, th);
    }

    public Parser(CTVariables cTVariables) {
        this.ctVariables = cTVariables;
    }

    public void parseVariables(Object... objArr) {
        try {
            for (Object obj : objArr) {
                parseVariablesHelper(obj, obj.getClass());
            }
        } catch (Throwable th) {
            log("Error parsing variables", th);
        }
    }

    public void parseVariablesForClasses(Class<?>... clsArr) {
        try {
            for (Class<?> cls : clsArr) {
                parseVariablesHelper(null, cls);
            }
        } catch (Throwable th) {
            log("Error parsing variables", th);
        }
    }

    void parseVariablesHelper(Object obj, Class<?> cls) {
        Object obj2;
        String strGroup;
        String name;
        try {
            Field[] fields = cls.getFields();
            int length = fields.length;
            int i = 0;
            while (i < length) {
                Field field = fields[i];
                if (field.isAnnotationPresent(Variable.class)) {
                    Variable variable = (Variable) field.getAnnotation(Variable.class);
                    if (variable == null) {
                        strGroup = "";
                        name = "";
                    } else {
                        strGroup = variable.group();
                        name = variable.name();
                    }
                    if (TextUtils.isEmpty(name)) {
                        name = field.getName();
                    }
                    if (!TextUtils.isEmpty(strGroup)) {
                        name = strGroup + InstructionFileId.DOT + name;
                    }
                    String str = name;
                    Class<?> type = field.getType();
                    String string = type.toString();
                    if (string.equals("int")) {
                        Object obj3 = obj;
                        defineVariable(obj3, str, Integer.valueOf(field.getInt(obj)), CTVariableUtils.NUMBER, field);
                        obj = obj3;
                    } else if (string.equals("byte")) {
                        Object obj4 = obj;
                        defineVariable(obj4, str, Byte.valueOf(field.getByte(obj)), CTVariableUtils.NUMBER, field);
                        obj = obj4;
                    } else if (string.equals("short")) {
                        Object obj5 = obj;
                        defineVariable(obj5, str, Short.valueOf(field.getShort(obj)), CTVariableUtils.NUMBER, field);
                        obj = obj5;
                    } else if (string.equals("long")) {
                        Object obj6 = obj;
                        defineVariable(obj6, str, Long.valueOf(field.getLong(obj)), CTVariableUtils.NUMBER, field);
                        obj = obj6;
                    } else if (string.equals("char")) {
                        Object obj7 = obj;
                        defineVariable(obj7, str, Character.valueOf(field.getChar(obj)), CTVariableUtils.NUMBER, field);
                        obj = obj7;
                    } else if (string.equals(TypedValues.Custom.S_FLOAT)) {
                        Object obj8 = obj;
                        defineVariable(obj8, str, Float.valueOf(field.getFloat(obj)), CTVariableUtils.NUMBER, field);
                        obj = obj8;
                    } else if (string.equals("double")) {
                        Object obj9 = obj;
                        defineVariable(obj9, str, Double.valueOf(field.getDouble(obj)), CTVariableUtils.NUMBER, field);
                        obj = obj9;
                    } else if (string.equals("boolean")) {
                        obj2 = obj;
                        defineVariable(obj2, str, Boolean.valueOf(field.getBoolean(obj)), "boolean", field);
                    } else {
                        obj2 = obj;
                        if (type.isPrimitive()) {
                            log("Variable " + str + " is an unsupported primitive type.");
                        } else if (type.isArray()) {
                            log("Variable " + str + " is an unsupported type of Array.");
                        } else if (Map.class.isAssignableFrom(type)) {
                            defineVariable(obj2, str, field.get(obj2), "group", field);
                        } else {
                            Object obj10 = field.get(obj2);
                            defineVariable(obj2, str, obj10 == null ? null : obj10.toString(), "string", field);
                        }
                    }
                    obj2 = obj;
                } else {
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
        } catch (Throwable th) {
            log("Error parsing variables:", th);
            th.printStackTrace();
        }
    }

    <T> void defineVariable(Object obj, String str, T t, String str2, final Field field) {
        final Var varDefine = Var.define(str, t, str2, this.ctVariables);
        if (varDefine == null) {
            log("Something went wrong, variable '" + str + "' is null, returning");
            return;
        }
        final boolean z = obj != null;
        final WeakReference weakReference = new WeakReference(obj);
        varDefine.addValueChangedCallback(new VariableCallback<T>() { // from class: com.clevertap.android.sdk.variables.Parser.1
            @Override // com.clevertap.android.sdk.variables.callbacks.VariableCallback
            public void onValueChanged(Var<T> var) {
                Field field2;
                Object obj2 = weakReference.get();
                if ((z && obj2 == null) || (field2 = field) == null) {
                    varDefine.removeValueChangedHandler(this);
                    return;
                }
                try {
                    boolean zIsAccessible = field2.isAccessible();
                    if (!zIsAccessible) {
                        field.setAccessible(true);
                    }
                    field.set(obj2, varDefine.value());
                    if (zIsAccessible) {
                        return;
                    }
                    field.setAccessible(false);
                } catch (IllegalAccessException e2) {
                    Parser.log("Error setting value for field " + varDefine.name(), e2);
                } catch (IllegalArgumentException e3) {
                    Parser.log("Invalid value " + varDefine.value() + " for field " + varDefine.name(), e3);
                }
            }
        });
    }
}
