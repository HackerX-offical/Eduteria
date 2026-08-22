package com.x5.util;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class ObjectDataMap implements Map {
    private Object object;
    private static final Map<String, Object> EMPTY_MAP = new HashMap();
    private static final HashSet<Class<?>> WRAPPER_TYPES = getWrapperTypes();
    private static final Class[] NO_ARGS = new Class[0];
    private Map<String, Object> pickle = null;
    private boolean isBean = false;

    @Override // java.util.Map
    public void clear() {
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return null;
    }

    private static HashSet<Class<?>> getWrapperTypes() {
        HashSet<Class<?>> hashSet = new HashSet<>();
        hashSet.add(Boolean.class);
        hashSet.add(Character.class);
        hashSet.add(Byte.class);
        hashSet.add(Short.class);
        hashSet.add(Integer.class);
        hashSet.add(Long.class);
        hashSet.add(Float.class);
        hashSet.add(Double.class);
        hashSet.add(Void.class);
        return hashSet;
    }

    public static boolean isWrapperType(Class<?> cls) {
        return WRAPPER_TYPES.contains(cls);
    }

    public ObjectDataMap(Object obj) {
        this.object = obj;
    }

    private void init() {
        if (this.pickle == null) {
            Map<String, Object> mapMapify = mapify(this.object);
            this.pickle = mapMapify;
            if (mapMapify == null) {
                this.pickle = EMPTY_MAP;
            }
        }
    }

    public static ObjectDataMap wrapBean(Object obj) {
        if (obj == null) {
            return null;
        }
        ObjectDataMap objectDataMap = new ObjectDataMap(obj);
        objectDataMap.isBean = true;
        return objectDataMap;
    }

    public static String getAsString(Object obj) {
        Method method;
        try {
            method = obj.getClass().getMethod(InAppPurchaseConstants.METHOD_TO_STRING, NO_ARGS);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method.getDeclaringClass().equals(Object.class)) {
            return "OBJECT:" + obj.getClass().getName();
        }
        return obj.toString();
    }

    private Map<String, Object> mapify(Object obj) {
        Map<String, Object> mapMapifyPOJO;
        if (obj instanceof DataCapsule) {
            return mapifyCapsule((DataCapsule) obj);
        }
        if (this.isBean) {
            mapMapifyPOJO = null;
        } else {
            mapMapifyPOJO = mapifyPOJO(obj);
            if (mapMapifyPOJO != null && !mapMapifyPOJO.isEmpty()) {
                return mapMapifyPOJO;
            }
            this.isBean = true;
        }
        try {
            if (this.isBean) {
                try {
                    Class.forName("java.beans.Introspector");
                    return StandardIntrospector.mapifyBean(obj);
                } catch (ClassNotFoundException unused) {
                    Class.forName("com.madrobot.beans.Introspector");
                    return MadRobotIntrospector.mapifyBean(obj);
                }
            }
        } catch (IntrospectionException | ClassNotFoundException unused2) {
        }
        return mapMapifyPOJO;
    }

    public Map<String, Object> mapifyPOJO(Object obj) {
        Object obj2;
        HashMap map = null;
        for (Field field : obj.getClass().getDeclaredFields()) {
            String name = field.getName();
            Class<?> type = field.getType();
            int modifiers = field.getModifiers();
            if (!Modifier.isPrivate(modifiers) && !Modifier.isProtected(modifiers)) {
                field.setAccessible(true);
            }
            try {
                obj2 = field.get(obj);
            } catch (IllegalAccessException unused) {
                obj2 = null;
            }
            if (obj2 != null) {
                if (map == null) {
                    map = new HashMap();
                }
                storeValue(map, type, splitCamelCase(name), obj2, this.isBean);
            }
        }
        return map;
    }

    private Map<String, Object> mapifyCapsule(DataCapsule dataCapsule) {
        DataCapsuleReader reader = DataCapsuleReader.getReader(dataCapsule);
        String[] columnLabels = reader.getColumnLabels(null);
        Object[] objArrExtractData = reader.extractData(dataCapsule);
        this.pickle = new HashMap();
        for (int i = 0; i < columnLabels.length; i++) {
            Object obj = objArrExtractData[i];
            if (obj != null) {
                if (obj instanceof String) {
                    this.pickle.put(columnLabels[i], obj);
                } else if (obj instanceof DataCapsule) {
                    this.pickle.put(columnLabels[i], new ObjectDataMap(obj));
                } else {
                    this.pickle.put(columnLabels[i], obj.toString());
                }
            }
        }
        return this.pickle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void storeValue(Map<String, Object> map, Class cls, String str, Object obj, boolean z) {
        if (cls.isArray() || (obj instanceof List)) {
            map.put(str, obj);
            return;
        }
        if (cls == String.class) {
            map.put(str, obj);
            return;
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                map.put(str, "TRUE");
            }
        } else if (cls.isPrimitive() || isWrapperType(cls)) {
            map.put(str, obj.toString());
        } else {
            map.put(str, z ? wrapBean(obj) : new ObjectDataMap(obj));
        }
    }

    public static String splitCamelCase(String str) {
        return str.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"), "_").toLowerCase();
    }

    @Override // java.util.Map
    public int size() {
        init();
        return this.pickle.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        init();
        return this.pickle.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        init();
        return this.pickle.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        init();
        return this.pickle.containsValue(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        init();
        return this.pickle.get(obj);
    }

    @Override // java.util.Map
    public Set keySet() {
        init();
        return this.pickle.keySet();
    }

    @Override // java.util.Map
    public Collection values() {
        init();
        return this.pickle.values();
    }

    @Override // java.util.Map
    public Set entrySet() {
        init();
        return this.pickle.entrySet();
    }

    private static class IntrospectionException extends Exception {
        private static final long serialVersionUID = 8890979383599687484L;

        private IntrospectionException() {
        }
    }

    private static class StandardIntrospector {
        private StandardIntrospector() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Map<String, Object> mapifyBean(Object obj) throws IntrospectionException {
            try {
                PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
                if (propertyDescriptors == null) {
                    return null;
                }
                HashMap map = null;
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    Class propertyType = propertyDescriptor.getPropertyType();
                    try {
                        Object objInvoke = propertyDescriptor.getReadMethod().invoke(obj, null);
                        if (objInvoke != null) {
                            String strSplitCamelCase = ObjectDataMap.splitCamelCase(propertyDescriptor.getName());
                            if (objInvoke instanceof Boolean) {
                                strSplitCamelCase = "is_" + strSplitCamelCase;
                            }
                            if (map == null) {
                                map = new HashMap();
                            }
                            ObjectDataMap.storeValue(map, propertyType, strSplitCamelCase, objInvoke, true);
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused) {
                    }
                }
                return map;
            } catch (java.beans.IntrospectionException unused2) {
                throw new IntrospectionException();
            }
        }
    }

    private static class MadRobotIntrospector {
        private MadRobotIntrospector() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Map<String, Object> mapifyBean(Object obj) throws IntrospectionException {
            try {
                com.madrobot.beans.PropertyDescriptor[] propertyDescriptors = com.madrobot.beans.Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
                if (propertyDescriptors == null) {
                    return null;
                }
                HashMap map = null;
                for (com.madrobot.beans.PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    Class propertyType = propertyDescriptor.getPropertyType();
                    try {
                        Object objInvoke = propertyDescriptor.getReadMethod().invoke(obj, null);
                        if (objInvoke != null) {
                            String strSplitCamelCase = ObjectDataMap.splitCamelCase(propertyDescriptor.getName());
                            if (objInvoke instanceof Boolean) {
                                strSplitCamelCase = "is_" + strSplitCamelCase;
                            }
                            if (map == null) {
                                map = new HashMap();
                            }
                            ObjectDataMap.storeValue(map, propertyType, strSplitCamelCase, objInvoke, true);
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused) {
                    }
                }
                return map;
            } catch (com.madrobot.beans.IntrospectionException unused2) {
                throw new IntrospectionException();
            }
        }
    }

    public String toString() {
        return getAsString(this.object);
    }

    public Object unwrap() {
        return this.object;
    }
}
