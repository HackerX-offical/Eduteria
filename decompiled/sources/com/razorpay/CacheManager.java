package com.razorpay;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
class CacheManager {
    static File cacheDir;

    CacheManager() {
    }

    static void init(Context context) {
        cacheDir = context.getCacheDir();
    }

    static boolean hasExpired(String str) {
        if (str.equalsIgnoreCase("rzp_payment_preferences")) {
            File file = new File(cacheDir.getPath(), str);
            if (!file.exists()) {
                return true;
            }
            try {
                if (!file.getAbsolutePath().equalsIgnoreCase(file.getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str)) {
                    return true;
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                CacheEntry cacheEntry = (CacheEntry) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
                return hasExpired(cacheEntry.expiryTime);
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
            }
        }
        return true;
    }

    private static boolean hasExpired(long j) {
        return j <= 0 || System.currentTimeMillis() > j;
    }

    static void put(String str, String str2, long j) {
        if (str.equalsIgnoreCase("rzp_payment_preferences")) {
            File file = new File(cacheDir.getPath(), str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    AnalyticsUtil.reportError(e2.getMessage(), "S1", e2.getMessage());
                }
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                CacheEntry cacheEntry = new CacheEntry(str2, j + System.currentTimeMillis());
                objectOutputStream.writeObject(cacheEntry);
                objectOutputStream.close();
                fileOutputStream.close();
                String.format("%s stored successfully in cache with expiry time of %d", str, Long.valueOf(cacheEntry.expiryTime));
            } catch (Exception e3) {
                AnalyticsUtil.reportError(e3.getMessage(), "S1", e3.getMessage());
            }
        }
    }

    static void expireKey(String str) {
        put(str, "", -1L);
    }

    static String get(String str) {
        if (str.equalsIgnoreCase("rzp_payment_preferences")) {
            File file = new File(cacheDir.getPath(), str);
            if (!file.exists()) {
                return null;
            }
            try {
                if (!file.getAbsolutePath().equalsIgnoreCase(file.getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str)) {
                    return null;
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                CacheEntry cacheEntry = (CacheEntry) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
                if (hasExpired(cacheEntry.expiryTime)) {
                    purge(str);
                    return null;
                }
                String.format("%s fetched successfully from cache", str);
                return cacheEntry.data;
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
            }
        }
        return null;
    }

    static void purge(String str) {
        if (str.equalsIgnoreCase("rzp_payment_preferences")) {
            new File(cacheDir.getPath(), str).delete();
        }
    }
}
