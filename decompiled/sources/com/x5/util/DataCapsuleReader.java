package com.x5.util;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes9.dex */
public class DataCapsuleReader {
    private static Hashtable<String, DataCapsuleReader> readerCache = new Hashtable<>();
    private String[] bareLabels;
    private Class capsuleClass;
    private String[] labels;
    private String[] methodNames;
    private Method[] methods;

    public static DataCapsuleReader getReader(DataCapsule[] dataCapsuleArr) {
        DataCapsuleReader readerFromCache = getReaderFromCache(dataCapsuleArr);
        if (readerFromCache != null) {
            return readerFromCache;
        }
        DataCapsuleReader dataCapsuleReader = new DataCapsuleReader(dataCapsuleArr);
        readerCache.put(dataCapsuleReader.getDataClassName(), dataCapsuleReader);
        return dataCapsuleReader;
    }

    public static DataCapsuleReader getReader(DataCapsule dataCapsule) {
        if (dataCapsule == null) {
            return null;
        }
        DataCapsuleReader readerFromCache = getReaderFromCache(dataCapsule);
        if (readerFromCache != null) {
            return readerFromCache;
        }
        DataCapsuleReader dataCapsuleReader = new DataCapsuleReader(new DataCapsule[]{dataCapsule});
        readerCache.put(dataCapsuleReader.getDataClassName(), dataCapsuleReader);
        return dataCapsuleReader;
    }

    private static DataCapsuleReader getReaderFromCache(DataCapsule[] dataCapsuleArr) {
        for (DataCapsule dataCapsule : dataCapsuleArr) {
            if (dataCapsule != null) {
                return readerCache.get(dataCapsule.getClass().getName());
            }
        }
        return null;
    }

    private static DataCapsuleReader getReaderFromCache(DataCapsule dataCapsule) {
        return readerCache.get(dataCapsule.getClass().getName());
    }

    public DataCapsuleReader(DataCapsule[] dataCapsuleArr) {
        extractLegend(dataCapsuleArr);
    }

    private void extractLegend(DataCapsule[] dataCapsuleArr) {
        for (DataCapsule dataCapsule : dataCapsuleArr) {
            if (dataCapsule != null) {
                this.capsuleClass = dataCapsule.getClass();
                extractLegend(dataCapsule);
                return;
            }
        }
    }

    private void extractLegend(DataCapsule dataCapsule) {
        String[] exports = dataCapsule.getExports();
        String exportPrefix = dataCapsule.getExportPrefix();
        this.labels = new String[exports.length];
        this.bareLabels = new String[exports.length];
        this.methodNames = new String[exports.length];
        for (int i = 0; i < exports.length; i++) {
            parseExportMap(i, exportPrefix, exports[i]);
        }
    }

    private void parseExportMap(int i, String str, String str2) {
        String strTransmogrify;
        int iIndexOf = str2.indexOf(32);
        if (iIndexOf > -1) {
            strTransmogrify = str2.substring(iIndexOf + 1).trim();
            str2 = str2.substring(0, iIndexOf);
        } else {
            strTransmogrify = transmogrify(str2);
        }
        this.labels[i] = str != null ? str + "_" + strTransmogrify : strTransmogrify;
        this.bareLabels[i] = strTransmogrify;
        this.methodNames[i] = str2;
    }

    private static String transmogrify(String str) {
        return ObjectDataMap.splitCamelCase(str).replaceFirst("^get_", "");
    }

    public String[] getColumnLabels(String str) {
        if (str == null) {
            return getColumnLabels();
        }
        int length = this.bareLabels.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = str + InstructionFileId.DOT + this.labels[i];
        }
        return strArr;
    }

    public String[] getColumnLabels() {
        return this.labels;
    }

    public void overrideColumnLabels(String[] strArr) {
        this.labels = strArr;
    }

    public Object[] extractData(DataCapsule dataCapsule) {
        if (this.methods == null) {
            this.methods = grokMethods(dataCapsule);
        }
        Object[] objArr = new Object[this.methods.length];
        int i = 0;
        while (true) {
            Method[] methodArr = this.methods;
            if (i >= methodArr.length) {
                return objArr;
            }
            Method method = methodArr[i];
            if (method != null) {
                try {
                    objArr[i] = method.invoke(dataCapsule, null);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace(System.err);
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace(System.err);
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace(System.err);
                }
            }
            i++;
        }
    }

    public String getDataClassName() {
        return this.capsuleClass.getName();
    }

    private Method[] grokMethods(DataCapsule dataCapsule) {
        int length = this.methodNames.length;
        Method[] methodArr = new Method[length];
        for (int i = 0; i < length; i++) {
            try {
                methodArr[i] = this.capsuleClass.getMethod(this.methodNames[i], null);
            } catch (NoSuchMethodException e2) {
                System.err.println("Class " + this.capsuleClass.getName() + " does not provide method " + this.methodNames[i] + "() as described in getExports() !!");
                e2.printStackTrace(System.err);
            }
        }
        return methodArr;
    }

    private Method[] grokSimpleMethods(DataCapsule dataCapsule) {
        Method[] methods = this.capsuleClass.getMethods();
        boolean[] zArr = new boolean[methods.length];
        int i = 0;
        for (int i2 = 0; i2 < methods.length; i2++) {
            Method method = methods[i2];
            if (method.getReturnType() == String.class && method.getParameterTypes() == null) {
                method.getName();
                zArr[i2] = true;
                i++;
            }
        }
        Method[] methodArr = new Method[i];
        for (int length = methods.length - 1; length >= 0 && i > 0; length--) {
            if (zArr[length]) {
                i--;
                methodArr[i] = methods[length];
            }
        }
        return methodArr;
    }
}
