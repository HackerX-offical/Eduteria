package com.google.firebase.database.connection;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ConnectionUtils {
    public static List<String> stringToPath(String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR, -1);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!strArrSplit[i].isEmpty()) {
                arrayList.add(strArrSplit[i]);
            }
        }
        return arrayList;
    }

    public static String pathToString(List<String> list) {
        if (list.isEmpty()) {
            return MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (!z) {
                sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            }
            sb.append(str);
            z = false;
        }
        return sb.toString();
    }

    public static Long longFromObject(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static void hardAssert(boolean z) {
        hardAssert(z, "", new Object[0]);
    }

    public static void hardAssert(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new AssertionError("hardAssert failed: " + String.format(str, objArr));
        }
    }
}
