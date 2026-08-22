package com.easebuzz.payment.kit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes7.dex */
public class PWECacheImageManager {
    protected static void saveImage(Context context, String str, Bitmap bitmap) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    File file = new File(context.getCacheDir(), "pweImages");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(file, str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static Bitmap getImage(Context context, String str) {
        File file = new File(context.getCacheDir() + "/pweImages/" + str);
        try {
            if (file.exists()) {
                return BitmapFactory.decodeStream(new FileInputStream(file));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    protected static void saveDefaultIconIntoCache(Context context, String str, int i, ImageView imageView) throws Throwable {
        try {
            String str2 = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r2.length - 1];
            Bitmap image = getImage(context, str2);
            if (image == null) {
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i);
                saveImage(context, str2, bitmapDecodeResource);
                imageView.setImageBitmap(bitmapDecodeResource);
                return;
            }
            imageView.setImageBitmap(image);
        } catch (Exception e2) {
            e2.printStackTrace();
            imageView.setImageResource(i);
        }
    }
}
