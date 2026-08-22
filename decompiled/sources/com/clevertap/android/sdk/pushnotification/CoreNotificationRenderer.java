package com.clevertap.android.sdk.pushnotification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.interfaces.AudibleNotification;
import com.clevertap.android.sdk.network.DownloadedBitmap;
import com.clevertap.android.sdk.network.DownloadedBitmapFactory;
import com.clevertap.android.sdk.utils.Clock;
import cz.msebera.android.httpclient.HttpHost;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes7.dex */
public class CoreNotificationRenderer implements INotificationRenderer, AudibleNotification {
    private String notifMessage;
    private String notifTitle;
    private int smallIcon;

    @Override // com.clevertap.android.sdk.pushnotification.INotificationRenderer
    public Object getCollapseKey(Bundle bundle) {
        return bundle.get(Constants.WZRK_COLLAPSE);
    }

    @Override // com.clevertap.android.sdk.pushnotification.INotificationRenderer
    public String getMessage(Bundle bundle) {
        String string = bundle.getString(Constants.NOTIF_MSG);
        this.notifMessage = string;
        return string;
    }

    @Override // com.clevertap.android.sdk.pushnotification.INotificationRenderer
    public String getTitle(Bundle bundle, Context context) {
        String string = bundle.getString(Constants.NOTIF_TITLE, "");
        if (string.isEmpty()) {
            string = context.getApplicationInfo().name;
        }
        this.notifTitle = string;
        return string;
    }

    private Uri getNotificationGifUri(String str, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        return Utils.getNotificationGifURI(str, context, cleverTapInstanceConfig, Clock.SYSTEM);
    }

    private DownloadedBitmap getNotificationImageBitmap(String str, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        if (str == null || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            return DownloadedBitmapFactory.INSTANCE.nullBitmapWithStatus(DownloadedBitmap.Status.NO_IMAGE);
        }
        DownloadedBitmap downloadedBitmapNullBitmapWithStatus = DownloadedBitmapFactory.INSTANCE.nullBitmapWithStatus(DownloadedBitmap.Status.INIT_ERROR);
        try {
            downloadedBitmapNullBitmapWithStatus = Utils.getNotificationBitmapWithTimeout(str, false, context, cleverTapInstanceConfig, 5000L);
            if (downloadedBitmapNullBitmapWithStatus.getBitmap() != null) {
                cleverTapInstanceConfig.getLogger().verbose("Fetched big picture in " + downloadedBitmapNullBitmapWithStatus.getDownloadTime() + " millis");
            }
            return downloadedBitmapNullBitmapWithStatus;
        } catch (Throwable th) {
            cleverTapInstanceConfig.getLogger().verbose(cleverTapInstanceConfig.getAccountId(), "Falling back to big text notification, couldn't fetch big picture", th);
            return downloadedBitmapNullBitmapWithStatus;
        }
    }

    private void addContentDescriptionIfNeeded(NotificationCompat.Style style, Bundle bundle, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !(style instanceof NotificationCompat.BigPictureStyle)) {
            return;
        }
        ((NotificationCompat.BigPictureStyle) style).setContentDescription(bundle.getString(Constants.WZRK_BIG_PICTURE_ALT_TEXT_KEY, context.getString(R.string.ct_notification_big_picture_alt_text)));
    }

    private NotificationCompat.Style generateStyle(Bundle bundle, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        Uri notificationGifUri;
        String string = bundle.getString(Constants.WZRK_BIG_PICTURE);
        String string2 = bundle.getString(Constants.WZRK_GIF);
        String string3 = bundle.getString(Constants.WZRK_MSG_SUMMARY, this.notifMessage);
        try {
            if (Build.VERSION.SDK_INT >= 34 && string2 != null && string2.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && (notificationGifUri = getNotificationGifUri(string2, context, cleverTapInstanceConfig)) != null) {
                NotificationCompat.BigPictureStyle bigPictureStyleBigPicture = new NotificationCompat.BigPictureStyle().setSummaryText(string3).bigPicture(Icon.createWithContentUri(notificationGifUri));
                addContentDescriptionIfNeeded(bigPictureStyleBigPicture, bundle, context);
                bundle.putString(Constants.WZRK_BPDS, DownloadedBitmap.Status.GIF_SUCCESS.getStatusValue());
                return bigPictureStyleBigPicture;
            }
        } catch (Exception e2) {
            cleverTapInstanceConfig.getLogger().verbose(cleverTapInstanceConfig.getAccountId(), "Failed to load GIF, falling back to static big-picture", e2);
        }
        DownloadedBitmap notificationImageBitmap = getNotificationImageBitmap(string, context, cleverTapInstanceConfig);
        bundle.putString(Constants.WZRK_BPDS, notificationImageBitmap.getStatus().getStatusValue());
        try {
            Bitmap bitmap = notificationImageBitmap.getBitmap();
            if (bitmap != null) {
                NotificationCompat.BigPictureStyle bigPictureStyleBigPicture2 = new NotificationCompat.BigPictureStyle().setSummaryText(string3).bigPicture(bitmap);
                addContentDescriptionIfNeeded(bigPictureStyleBigPicture2, bundle, context);
                return bigPictureStyleBigPicture2;
            }
        } catch (Exception e3) {
            cleverTapInstanceConfig.getLogger().verbose(cleverTapInstanceConfig.getAccountId(), "Failed to load Big Picture, falling back to text notification", e3);
        }
        return new NotificationCompat.BigTextStyle().bigText(this.notifMessage);
    }

    @Override // com.clevertap.android.sdk.pushnotification.INotificationRenderer
    public NotificationCompat.Builder renderNotification(Bundle bundle, Context context, NotificationCompat.Builder builder, CleverTapInstanceConfig cleverTapInstanceConfig, int i) {
        NotificationCompat.Style styleGenerateStyle = generateStyle(bundle, context, cleverTapInstanceConfig);
        addActions(bundle, context, builder, cleverTapInstanceConfig, i);
        return finalizeBuilder(builder, bundle, context, cleverTapInstanceConfig, styleGenerateStyle);
    }

    public void addActions(Bundle bundle, Context context, NotificationCompat.Builder builder, CleverTapInstanceConfig cleverTapInstanceConfig, int i) {
        String string = bundle.getString(Constants.WZRK_ACTIONS);
        if (string != null) {
            try {
                setActionButtons(context, bundle, i, builder, new JSONArray(string));
            } catch (Throwable th) {
                cleverTapInstanceConfig.getLogger().debug(cleverTapInstanceConfig.getAccountId(), "error parsing notification actions: " + th.getLocalizedMessage());
            }
        }
    }

    private NotificationCompat.Builder finalizeBuilder(NotificationCompat.Builder builder, Bundle bundle, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, NotificationCompat.Style style) {
        if (bundle.containsKey(Constants.WZRK_SUBTITLE)) {
            builder.setSubText(bundle.getString(Constants.WZRK_SUBTITLE));
        }
        if (bundle.containsKey(Constants.WZRK_COLOR)) {
            builder.setColor(Color.parseColor(bundle.getString(Constants.WZRK_COLOR)));
            builder.setColorized(true);
        }
        String string = bundle.getString(Constants.WZRK_DISMISS);
        if (string != null) {
            try {
                builder.setTimeoutAfter(Long.parseLong(string) * 1000);
            } catch (NumberFormatException e2) {
                cleverTapInstanceConfig.getLogger().verbose(cleverTapInstanceConfig.getAccountId(), "Failed to parse timeout dismiss value", e2);
            }
        }
        if (Build.VERSION.SDK_INT >= 34) {
            builder.setOngoing("true".equalsIgnoreCase(bundle.getString(Constants.WZRK_STICKY)));
        }
        builder.setContentTitle(this.notifTitle).setContentText(this.notifMessage).setContentIntent(LaunchPendingIntentFactory.getLaunchPendingIntent(bundle, context)).setAutoCancel(true).setStyle(style).setSmallIcon(this.smallIcon);
        String string2 = bundle.getString(Constants.NOTIF_ICON);
        if (!"true".equalsIgnoreCase(bundle.getString(Constants.NOTIF_HIDE_APP_LARGE_ICON))) {
            builder.setLargeIcon(Utils.getNotificationBitmapWithTimeout(string2, true, context, cleverTapInstanceConfig, 2000L).getBitmap());
        }
        return builder;
    }

    @Override // com.clevertap.android.sdk.pushnotification.INotificationRenderer
    public void setSmallIcon(int i, Context context) {
        this.smallIcon = i;
    }

    @Override // com.clevertap.android.sdk.pushnotification.INotificationRenderer
    public String getActionButtonIconKey() {
        return Constants.NOTIF_ICON;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    @Override // com.clevertap.android.sdk.interfaces.AudibleNotification
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.core.app.NotificationCompat.Builder setSound(android.content.Context r4, android.os.Bundle r5, androidx.core.app.NotificationCompat.Builder r6, com.clevertap.android.sdk.CleverTapInstanceConfig r7) {
        /*
            r3 = this;
            java.lang.String r0 = "wzrk_sound"
            java.lang.String r1 = "android.resource://"
            boolean r2 = r5.containsKey(r0)     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L85
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Throwable -> L86
            boolean r0 = r5 instanceof java.lang.Boolean     // Catch: java.lang.Throwable -> L86
            r2 = 2
            if (r0 == 0) goto L22
            r0 = r5
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L86
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L22
            android.net.Uri r4 = android.media.RingtoneManager.getDefaultUri(r2)     // Catch: java.lang.Throwable -> L86
            goto L80
        L22:
            boolean r0 = r5 instanceof java.lang.String     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L7f
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = "true"
            boolean r0 = r5.equals(r0)     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L36
            android.net.Uri r4 = android.media.RingtoneManager.getDefaultUri(r2)     // Catch: java.lang.Throwable -> L86
            goto L80
        L36:
            boolean r0 = r5.isEmpty()     // Catch: java.lang.Throwable -> L86
            if (r0 != 0) goto L7f
            java.lang.String r0 = ".mp3"
            boolean r0 = r5.contains(r0)     // Catch: java.lang.Throwable -> L86
            if (r0 != 0) goto L54
            java.lang.String r0 = ".ogg"
            boolean r0 = r5.contains(r0)     // Catch: java.lang.Throwable -> L86
            if (r0 != 0) goto L54
            java.lang.String r0 = ".wav"
            boolean r0 = r5.contains(r0)     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L5f
        L54:
            int r0 = r5.length()     // Catch: java.lang.Throwable -> L86
            int r0 = r0 + (-4)
            r2 = 0
            java.lang.String r5 = r5.substring(r2, r0)     // Catch: java.lang.Throwable -> L86
        L5f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r4 = r0.append(r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = "/raw/"
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L86
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L86
            goto L80
        L7f:
            r4 = 0
        L80:
            if (r4 == 0) goto L85
            r6.setSound(r4)     // Catch: java.lang.Throwable -> L86
        L85:
            return r6
        L86:
            r4 = move-exception
            com.clevertap.android.sdk.Logger r5 = r7.getLogger()
            java.lang.String r7 = r7.getAccountId()
            java.lang.String r0 = "Could not process sound parameter"
            r5.debug(r7, r0, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.CoreNotificationRenderer.setSound(android.content.Context, android.os.Bundle, androidx.core.app.NotificationCompat$Builder, com.clevertap.android.sdk.CleverTapInstanceConfig):androidx.core.app.NotificationCompat$Builder");
    }
}
