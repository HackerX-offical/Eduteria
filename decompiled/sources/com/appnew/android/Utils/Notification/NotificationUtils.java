package com.appnew.android.Utils.Notification;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.core.app.NotificationCompat;
import com.eduteria.app.app.R;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes6.dex */
public class NotificationUtils {
    private static String TAG = "NotificationUtils";
    private Context mContext;

    public NotificationUtils(Context mContext) {
        this.mContext = mContext;
    }

    public static boolean isAppIsInBackground(Context context) {
        boolean z = true;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100) {
                for (String str : runningAppProcessInfo.pkgList) {
                    if (str.equals(context.getPackageName())) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public static void clearNotifications(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancelAll();
    }

    public static long getTimeMilliSec(String timeStamp) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timeStamp).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public void showNotificationMessage(String title, String message, String timeStamp, Intent intent) {
        showNotificationMessage(title, message, timeStamp, intent, null);
    }

    public void showNotificationMessage(final String title, final String message, final String timeStamp, Intent intent, String imageUrl) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(this.mContext, 0, intent, Build.VERSION.SDK_INT >= 31 ? GroupFlagsKt.HasAuxSlotFlag : 268435456);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.mContext);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        if (!TextUtils.isEmpty(imageUrl)) {
            if (imageUrl == null || imageUrl.length() <= 4 || !Patterns.WEB_URL.matcher(imageUrl).matches()) {
                return;
            }
            Bitmap bitmapFromURL = getBitmapFromURL(imageUrl);
            if (bitmapFromURL != null) {
                showBigNotification(bitmapFromURL, builder, R.mipmap.both, title, message, timeStamp, activity, defaultUri);
                return;
            } else {
                showSmallNotification(builder, R.mipmap.both, title, message, timeStamp, activity, defaultUri);
                return;
            }
        }
        showSmallNotification(builder, R.mipmap.both, title, message, timeStamp, activity, defaultUri);
        playNotificationSound();
    }

    private void showSmallNotification(NotificationCompat.Builder mBuilder, int icon, String title, String message, String timeStamp, PendingIntent resultPendingIntent, Uri alarmSound) {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.addLine(message);
        ((NotificationManager) this.mContext.getSystemService("notification")).notify(100, mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0L).setAutoCancel(true).setContentTitle(title).setContentIntent(resultPendingIntent).setSound(alarmSound).setStyle(inboxStyle).setWhen(getTimeMilliSec(timeStamp)).setSmallIcon(R.mipmap.both).setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), icon)).setContentText(message).build());
    }

    private void showBigNotification(Bitmap bitmap, NotificationCompat.Builder mBuilder, int icon, String title, String message, String timeStamp, PendingIntent resultPendingIntent, Uri alarmSound) {
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.setBigContentTitle(title);
        bigPictureStyle.setSummaryText(Html.fromHtml(message).toString());
        bigPictureStyle.bigPicture(bitmap);
        ((NotificationManager) this.mContext.getSystemService("notification")).notify(101, mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0L).setAutoCancel(true).setContentTitle(title).setContentIntent(resultPendingIntent).setSound(alarmSound).setStyle(bigPictureStyle).setWhen(getTimeMilliSec(timeStamp)).setSmallIcon(R.mipmap.both).setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), icon)).setContentText(message).build());
    }

    public Bitmap getBitmapFromURL(String strURL) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strURL).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void playNotificationSound() {
        try {
            RingtoneManager.getRingtone(this.mContext, RingtoneManager.getDefaultUri(2)).play();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
