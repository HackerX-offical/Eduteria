package com.google.android.play.core.splitinstall;

import android.content.Context;
import java.io.File;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public class SplitInstallHelper {
    private static final com.google.android.play.core.splitinstall.internal.zzu zza = new com.google.android.play.core.splitinstall.internal.zzu("SplitInstallHelper");

    private SplitInstallHelper() {
    }

    public static void loadLibrary(Context context, String str) throws UnsatisfiedLinkError {
        synchronized (zzn.class) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e2) {
                String str2 = context.getApplicationInfo().nativeLibraryDir + MqttTopic.TOPIC_LEVEL_SEPARATOR + System.mapLibraryName(str);
                if (!new File(str2).exists()) {
                    throw e2;
                }
                System.load(str2);
            }
        }
    }

    public static void updateAppInfo(Context context) {
    }
}
