package com.google.firebase.storage.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class Slashes {
    public static String preserveSlashEncode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return slashize(Uri.encode(str));
    }

    public static String slashize(String str) {
        Preconditions.checkNotNull(str);
        return str.replace("%2F", MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static String normalizeSlashes(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR) && !str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR) && !str.contains("//")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR, -1)) {
            if (!TextUtils.isEmpty(str2)) {
                if (sb.length() > 0) {
                    sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR).append(str2);
                } else {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }
}
