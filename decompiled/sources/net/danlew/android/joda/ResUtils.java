package net.danlew.android.joda;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes10.dex */
public class ResUtils {
    private static final String TZDATA_PREFIX = "joda_";
    private static Map<Class<?>, Map<String, Integer>> sIdentifierCache = new ConcurrentHashMap();

    private static String convertPathToResource(String str) {
        File file = new File(str);
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(file.getName());
            file = file.getParentFile();
        } while (file != null);
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("_");
            }
            stringBuffer.append((String) arrayList.get(size));
        }
        return stringBuffer.toString().replace('-', '_').replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "plus").toLowerCase(Locale.US);
    }

    public static String getTzResource(String str) {
        return TZDATA_PREFIX + convertPathToResource(str);
    }

    public static String getZoneInfoMapResource() {
        return TZDATA_PREFIX + convertPathToResource("ZoneInfoMap");
    }

    public static int getIdentifier(Class<?> cls, String str) {
        Map<String, Integer> concurrentHashMap;
        if (!sIdentifierCache.containsKey(cls)) {
            concurrentHashMap = new ConcurrentHashMap<>();
            sIdentifierCache.put(cls, concurrentHashMap);
        } else {
            concurrentHashMap = sIdentifierCache.get(cls);
        }
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).intValue();
        }
        try {
            int i = cls.getField(str).getInt(null);
            if (i != 0) {
                concurrentHashMap.put(str, Integer.valueOf(i));
            }
            return i;
        } catch (Exception e2) {
            Log.e("JodaTimeAndroid", "Failed to retrieve identifier: type=" + cls + " name=" + str, e2);
            return 0;
        }
    }
}
