package com.appnew.android.Utils;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes6.dex */
public class CustomDownloadManager {
    private DownloadManager downloadManager;
    private long lastDownload = -1;
    BroadcastReceiver onComplete = new BroadcastReceiver() { // from class: com.appnew.android.Utils.CustomDownloadManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context ctxt, Intent intent) {
        }
    };
    BroadcastReceiver onNotificationClick = new BroadcastReceiver() { // from class: com.appnew.android.Utils.CustomDownloadManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context ctxt, Intent intent) {
            Toast.makeText(ctxt, "Ummmm...hi!", 1).show();
        }
    };

    public void init(Context context) {
        this.downloadManager = (DownloadManager) context.getSystemService("download");
        ContextCompat.registerReceiver(context, this.onComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
        ContextCompat.registerReceiver(context, this.onNotificationClick, new IntentFilter("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED"), 4);
    }

    public void startDownload(String downloadUrl) {
        Uri uri = Uri.parse(downloadUrl);
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdirs();
        this.lastDownload = this.downloadManager.enqueue(new DownloadManager.Request(uri).setAllowedNetworkTypes(3).setAllowedOverRoaming(false).setTitle("Demo").setDescription("Something useful. No, really.").setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "test.mp4"));
    }
}
