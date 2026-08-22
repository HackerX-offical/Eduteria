package com.appnew.android.Utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.eduteria.app.app.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class DrmLogPrinter {
    private static final String TAG = "PlayerErrorLogger";

    public static void TimeTable(Context context, String errorMessage, String message, String videoID) {
        try {
            if (SharedPreference.getInstance().getLoggedInUser().getName().equalsIgnoreCase("appsquadz")) {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), (context.getResources().getString(R.string.app_name).replace(" ", "_") + "_Video_Id=" + videoID + "_Date=" + new SimpleDateFormat("dd-MM-yyyy", Locale.US).format(new Date())) + ".txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                fileOutputStream.write((errorMessage + "\n" + message + "\n").getBytes());
                fileOutputStream.close();
                Log.d(TAG, "Error logged to file: " + file.getAbsolutePath());
            }
        } catch (IOException e2) {
            Log.e(TAG, "Failed to log error to file", e2);
        }
    }
}
