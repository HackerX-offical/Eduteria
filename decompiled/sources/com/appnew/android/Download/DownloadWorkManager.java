package com.appnew.android.Download;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.bumptech.glide.Glide;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadWorkManager extends Worker {
    Context context;

    public DownloadWorkManager(Context context1, WorkerParameters workerParams) {
        super(context1, workerParams);
        this.context = context1;
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        try {
            JSONObject jSONObject = new JSONObject(SharedPreference.getInstance().getString(Const.SPLASH_DATA));
            if (jSONObject.has(Const.APP_ICON)) {
                saveImageToStorage(Helper.getEndPoint(jSONObject.get(Const.APP_ICON).toString()), jSONObject.get(Const.APP_ICON).toString());
            }
            if (jSONObject.has("login_logo")) {
                saveImageToStorage(Helper.getEndPoint(jSONObject.get("login_logo").toString()), jSONObject.get("login_logo").toString());
            }
            if (jSONObject.has("header_logo")) {
                saveImageToStorage(Helper.getEndPoint(jSONObject.get("header_logo").toString()), jSONObject.get("header_logo").toString());
            }
        } catch (JSONException unused) {
        }
        return ListenableWorker.Result.success();
    }

    private Bitmap downloadImage(String url) {
        try {
            return Glide.with(getApplicationContext()).asBitmap().load(url).submit().get();
        } catch (Exception unused) {
            return null;
        }
    }

    private void saveImageToStorage(String endPoint, String url) {
        Bitmap bitmapDownloadImage = downloadImage(url);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/EDUTERIA_doc_folder/");
        if (!file.exists()) {
            file.mkdirs();
        }
        new File(this.context.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + endPoint).delete();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.context.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + endPoint);
            try {
                bitmapDownloadImage.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void saveImageToStorage(byte[] imageData) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyApp");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, "IMG_" + System.currentTimeMillis() + ".jpg"));
            try {
                fileOutputStream.write(imageData);
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
