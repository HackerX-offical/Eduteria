package com.appnew.android.DownloadServices;

import android.R;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.StatFs;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.table.VideosDownload;
import com.clevertap.android.sdk.Constants;
import com.google.gson.Gson;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class VideoDownloadService extends CustomIntentService {
    private static final int AES_BLOCK_SIZE = 16;
    public static final String CANCEL = "cancel";
    public static final String CANCEL_ALL = "cancelAll";
    public static final String CURRENT_PERCENT_DOWNLOADED = "current_percentage";
    public static final String CURRENT_PROGRESS_TEXT = "current_progress_text";
    public static final String DOWNLOADED_AUDIOS = "/.Audios/";
    public static final String DOWNLOADED_VIDEOS = "/.Videos/";
    public static final String DOWNLOADING_VIDEOS = "/.processing/";
    public static final String DOWNLOAD_SERVICE_ID = "download_service_id";
    public static final int EXCEPTION_OCCURRED = -110;
    public static final String FILEDOWNLOADSTATUS = "resume_status";
    public static final String FILEPATH = "filepath";
    public static final String FILE_SIZE = "size";
    public static String LOCAL_ENCRYPTION_KEY = "abcdefgh123456yz";
    public static final String MESSAGE = "message";
    public static final int NOT_AVAILABLE_ON_SERVER = -111;
    public static final int NOT_ENOUGH_MEMORY = -198;
    public static final int ONTASK = 1090;
    public static final String PAUSE = "pause";
    public static final String RESULT = "result";
    public static final String RES_ID = "resourceId";
    public static final String URL = "urlpath";
    public static final String VIDEO_DOWNLOAD_ACTION = "video_download_service_receiver";
    public static final int VIDEO_DOWNLOAD_CANCELLED = 3;
    public static final int VIDEO_DOWNLOAD_PAUSED = 2;
    public static final int VIDEO_DOWNLOAD_PAUSED_NO_INTERNET = 5;
    public static final String VIDEO_DOWNLOAD_PROGRESS = "video_download_progress";
    public static final int VIDEO_DOWNLOAD_RESUMED = 4;
    public static final int VIDEO_DOWNLOAD_STARTED = 6;
    public static final int VIDEO_DOWNLOAD_SUCCESSFUL = 1;
    public static final int VIDEO_FILE_EXIST = -101;
    public static String action = "";
    public static boolean isServiceRunning = false;
    public static int pos = 0;
    public static String video_id = "";
    private String TAG;
    CipherOutputStream cipherOutputStream;
    private String downloadServiceId;
    private String downloadType;
    File downloadingFile;
    private Cipher ecipher;
    OutputStream fileOutput;
    String filePath;
    private long file_size;
    private Gson gson;
    InputStream inputStream;
    String lengthInMb;
    private long lengthLong;
    NotificationManager mNotificationManager;
    UtkashRoom myDBClass;
    String notification_name;
    boolean onPauseCalled;
    private String originalFileLengthString;
    private Cipher pausedEcipher;
    private Key pausedKey;
    int percentage;
    int prevPercentage;
    private Key secretKey;
    private Thread thread;
    private long total;
    String urlPath;
    String video_time;

    public VideoDownloadService() {
        super("VideoDownloadService");
        this.downloadServiceId = "";
        this.originalFileLengthString = "";
        this.filePath = "";
        this.notification_name = "";
        this.onPauseCalled = false;
        this.video_time = "";
        this.downloadType = "0";
        this.TAG = getClass().getSimpleName();
    }

    @Override // com.appnew.android.DownloadServices.CustomIntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        isServiceRunning = true;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        this.mNotificationManager = notificationManager;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        getIntentsData(intent);
        NotificationCompat.Builder ticker = new NotificationCompat.Builder(getApplicationContext(), getPackageName()).setContentTitle(this.notification_name).setOngoing(true).setAutoCancel(true).setSmallIcon(R.drawable.stat_sys_download).setStyle(new NotificationCompat.BigTextStyle().bigText("")).setPriority(2).setContentText("Preparing...").setTicker("Preparing...");
        String string = getApplicationContext().getResources().getString(com.eduteria.app.app.R.string.download_channel_id);
        NotificationChannel notificationChannel = new NotificationChannel(string, "Channel human readable title", 3);
        notificationChannel.setSound(null, null);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        NotificationManager notificationManager2 = this.mNotificationManager;
        if (notificationManager2 != null) {
            notificationManager2.createNotificationChannel(notificationChannel);
        }
        ticker.setChannelId(string);
        this.myDBClass = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        ticker.setProgress(100, 0, true);
        if (Build.VERSION.SDK_INT < 33) {
            startForeground(11111, ticker.build());
        } else {
            startForeground(11111, ticker.build());
        }
        video_id = this.downloadServiceId;
        if (this.downloadType.equalsIgnoreCase("1")) {
            if (this.myDBClass.getvideoDownloadao().isvideo_exit_for_audio(video_id, MakeMyExam.userId) && !this.myDBClass.getvideoDownloadao().getvideo_byuserid_for_audio(video_id, MakeMyExam.userId).getVideo_status().equalsIgnoreCase("Downloading Pause") && intent.getStringExtra("status") != null) {
                this.myDBClass.getvideoDownloadao().update_progress_for_audio(this.downloadServiceId, "0", "Downloading Running", MakeMyExam.userId);
                publishResults("", 6, "");
            }
        } else if (this.downloadType.equalsIgnoreCase("2")) {
            if (this.myDBClass.getvideoDownloadao().isvideo_exit_for_youtube(video_id, MakeMyExam.userId) && !this.myDBClass.getvideoDownloadao().getvideo_byuserid_for_youtube(video_id, MakeMyExam.userId).getVideo_status().equalsIgnoreCase("Downloading Pause") && intent.getStringExtra("status") != null) {
                this.myDBClass.getvideoDownloadao().update_progress_for_youtube(this.downloadServiceId, "0", "Downloading Running", MakeMyExam.userId);
                publishResults("", 6, "");
            }
        } else if (this.myDBClass.getvideoDownloadao().isvideo_exit(video_id, MakeMyExam.userId) && !this.myDBClass.getvideoDownloadao().getvideo_byuserid(video_id, MakeMyExam.userId).getVideo_status().equalsIgnoreCase("Downloading Pause") && intent.getStringExtra("status") != null) {
            this.myDBClass.getvideoDownloadao().update_progress(this.downloadServiceId, "0", "Downloading Running", MakeMyExam.userId);
            publishResults("", 6, "");
        }
        action = "";
        if (this.downloadType.equalsIgnoreCase("1")) {
            downloadAudio(intent, ticker);
        } else if (this.downloadType.equalsIgnoreCase("2")) {
            downloadYoutube(intent, ticker);
        } else {
            downloadVideo(intent, ticker);
        }
    }

    private void getIntentsData(Intent intent) {
        this.downloadServiceId = intent.getStringExtra(DOWNLOAD_SERVICE_ID);
        this.filePath = intent.getStringExtra("name");
        pos = intent.getIntExtra(Constants.INAPP_POSITION, 0);
        this.urlPath = intent.getStringExtra(URL);
        this.notification_name = intent.getStringExtra(FILEPATH);
        if (intent.getStringExtra("downloadType") != null) {
            this.downloadType = intent.getStringExtra("downloadType");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:230:0x059b A[Catch: all -> 0x0685, TryCatch #2 {all -> 0x0685, blocks: (B:201:0x0538, B:203:0x053c, B:205:0x0540, B:206:0x0548, B:208:0x054c, B:209:0x054f, B:211:0x0553, B:212:0x0558, B:215:0x056d, B:217:0x0571, B:219:0x0575, B:220:0x057d, B:222:0x0581, B:223:0x0584, B:225:0x0588, B:227:0x058f, B:230:0x059b, B:232:0x059f, B:234:0x05a3, B:236:0x05a7, B:237:0x05af, B:239:0x05b3, B:240:0x05b6, B:242:0x05ba, B:243:0x05bf, B:245:0x05e2, B:247:0x05ea, B:248:0x05ef, B:252:0x0629, B:254:0x0640, B:251:0x0625, B:255:0x0646, B:257:0x0664, B:229:0x0594, B:214:0x0568), top: B:304:0x0538, inners: #4, #13, #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x066b A[Catch: Exception -> 0x0680, TRY_ENTER, TryCatch #11 {Exception -> 0x0680, blocks: (B:186:0x0516, B:188:0x051a, B:189:0x0522, B:191:0x0526, B:192:0x0529, B:259:0x066b, B:261:0x066f, B:262:0x0677, B:264:0x067b), top: B:320:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0571 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0689 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x053c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void downloadVideo(android.content.Intent r34, androidx.core.app.NotificationCompat.Builder r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1779
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.DownloadServices.VideoDownloadService.downloadVideo(android.content.Intent, androidx.core.app.NotificationCompat$Builder):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0542 A[Catch: Exception -> 0x06a7, TRY_ENTER, TryCatch #16 {Exception -> 0x06a7, blocks: (B:212:0x0542, B:214:0x0546, B:215:0x054e, B:217:0x0552, B:218:0x0555, B:284:0x0692, B:286:0x0696, B:287:0x069e, B:289:0x06a2), top: B:353:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x05c6 A[Catch: all -> 0x055c, TryCatch #21 {all -> 0x055c, blocks: (B:7:0x00a6, B:9:0x00b3, B:226:0x0563, B:228:0x0567, B:230:0x056b, B:231:0x0573, B:233:0x0577, B:234:0x057a, B:236:0x057e, B:237:0x0583, B:240:0x0598, B:242:0x059c, B:244:0x05a0, B:245:0x05a8, B:247:0x05ac, B:248:0x05af, B:250:0x05b3, B:252:0x05ba, B:255:0x05c6, B:257:0x05ca, B:259:0x05ce, B:261:0x05d2, B:262:0x05da, B:264:0x05de, B:265:0x05e1, B:267:0x05e5, B:268:0x05ea, B:270:0x060d, B:272:0x0615, B:273:0x061a, B:277:0x0650, B:279:0x0667, B:276:0x064c, B:280:0x066d, B:282:0x068b, B:254:0x05bf, B:239:0x0593, B:210:0x052d), top: B:344:0x00a6, inners: #1, #2, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0692 A[Catch: Exception -> 0x06a7, TRY_ENTER, TryCatch #16 {Exception -> 0x06a7, blocks: (B:212:0x0542, B:214:0x0546, B:215:0x054e, B:217:0x0552, B:218:0x0555, B:284:0x0692, B:286:0x0696, B:287:0x069e, B:289:0x06a2), top: B:353:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0567 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x059c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x06ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:373:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:374:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v32, types: [androidx.core.app.NotificationCompat$Builder] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.appnew.android.DownloadServices.VideoDownloadService] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void downloadAudio(android.content.Intent r33, androidx.core.app.NotificationCompat.Builder r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1816
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.DownloadServices.VideoDownloadService.downloadAudio(android.content.Intent, androidx.core.app.NotificationCompat$Builder):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:230:0x059b A[Catch: all -> 0x0685, TryCatch #2 {all -> 0x0685, blocks: (B:201:0x0538, B:203:0x053c, B:205:0x0540, B:206:0x0548, B:208:0x054c, B:209:0x054f, B:211:0x0553, B:212:0x0558, B:215:0x056d, B:217:0x0571, B:219:0x0575, B:220:0x057d, B:222:0x0581, B:223:0x0584, B:225:0x0588, B:227:0x058f, B:230:0x059b, B:232:0x059f, B:234:0x05a3, B:236:0x05a7, B:237:0x05af, B:239:0x05b3, B:240:0x05b6, B:242:0x05ba, B:243:0x05bf, B:245:0x05e2, B:247:0x05ea, B:248:0x05ef, B:252:0x0629, B:254:0x0640, B:251:0x0625, B:255:0x0646, B:257:0x0664, B:229:0x0594, B:214:0x0568), top: B:304:0x0538, inners: #4, #13, #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x066b A[Catch: Exception -> 0x0680, TRY_ENTER, TryCatch #11 {Exception -> 0x0680, blocks: (B:186:0x0516, B:188:0x051a, B:189:0x0522, B:191:0x0526, B:192:0x0529, B:259:0x066b, B:261:0x066f, B:262:0x0677, B:264:0x067b), top: B:320:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0571 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0689 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x053c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void downloadYoutube(android.content.Intent r34, androidx.core.app.NotificationCompat.Builder r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1779
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.DownloadServices.VideoDownloadService.downloadYoutube(android.content.Intent, androidx.core.app.NotificationCompat$Builder):void");
    }

    @Override // com.appnew.android.DownloadServices.CustomIntentService
    protected boolean cancelDownload(String downloadServiceId) {
        if (!this.downloadServiceId.equals(downloadServiceId)) {
            return false;
        }
        action = CANCEL;
        return true;
    }

    @Override // com.appnew.android.DownloadServices.CustomIntentService
    protected void cancelAllDownload() {
        action = CANCEL_ALL;
    }

    @Override // com.appnew.android.DownloadServices.CustomIntentService
    protected boolean pauseDownload(String downloadServiceId) {
        if (!this.downloadServiceId.equals(downloadServiceId)) {
            return false;
        }
        action = PAUSE;
        return true;
    }

    private void notifyDownloadState(String title, String message) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this, getPackageName()).setSmallIcon((message == null || message.isEmpty() || !message.contains("Successfully")) ? R.drawable.ic_dialog_alert : com.eduteria.app.app.R.drawable.ic_launcher_background).setColor(getResources().getColor(com.eduteria.app.app.R.color.colorAccent)).setColorized(true).setStyle(new NotificationCompat.BigTextStyle().bigText(message)).setContentTitle(title).setContentText(message).setPriority(2).setAutoCancel(true);
        String string = getApplicationContext().getResources().getString(com.eduteria.app.app.R.string.download_channel_id);
        notificationManager.createNotificationChannel(new NotificationChannel(string, getApplicationContext().getResources().getString(com.eduteria.app.app.R.string.download_video_service_channel), 3));
        autoCancel.setChannelId(string);
        if (notificationManager != null) {
            notificationManager.notify(NotificationID.getID(), autoCancel.build());
        }
    }

    static class NotificationID {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final AtomicInteger f305c = new AtomicInteger(0);

        NotificationID() {
        }

        public static int getID() {
            return f305c.incrementAndGet();
        }
    }

    private boolean isMemoryAvailable(final long fileSize) {
        this.file_size = fileSize;
        return getAvailableExternalMemorySize() > fileSize;
    }

    private String fileSize(double length) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (length > 1048576.0d) {
            return decimalFormat.format(length / 1048576.0d) + " MB";
        }
        if (length > 1024.0d) {
            return decimalFormat.format(length / 1024.0d) + " KB";
        }
        return decimalFormat.format(length) + " B";
    }

    private long getAvailableExternalMemorySize() {
        StatFs statFs = new StatFs(getExternalFilesDir(null).getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    private void publishDownloadProgress(String resId, String progressText, int currentProgress) {
        Intent intent = new Intent(VIDEO_DOWNLOAD_PROGRESS);
        intent.putExtra("resourceId", resId);
        intent.putExtra(Constants.INAPP_POSITION, pos);
        intent.putExtra(CURRENT_PROGRESS_TEXT, progressText);
        intent.putExtra("size", this.file_size + "");
        intent.putExtra(CURRENT_PERCENT_DOWNLOADED, currentProgress);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void publishResults(String outputPath, String resId, int result, String message) {
        if (result != 4 && result != 6) {
            stopForeground(true);
        }
        if (1 == result) {
            if (!this.downloadType.equalsIgnoreCase("1")) {
                if (this.downloadType.equalsIgnoreCase("2")) {
                    this.myDBClass.getvideoDownloadao().update_videostatus_for_youtube(this.downloadServiceId, "1", "Downloaded", this.percentage);
                } else {
                    this.myDBClass.getvideoDownloadao().update_videostatus(this.downloadServiceId, "1", "Downloaded", this.percentage);
                }
            } else {
                this.myDBClass.getvideoDownloadao().update_videostatus_for_audio(this.downloadServiceId, "1", "Downloaded", this.percentage);
            }
        } else if (result == -110 || result == 3 || result == -111 || result == -198) {
            if (!this.downloadType.equalsIgnoreCase("1")) {
                if (this.downloadType.equalsIgnoreCase("2")) {
                    this.myDBClass.getvideoDownloadao().delete_viavideoid_for_youtube(this.downloadServiceId, MakeMyExam.userId);
                } else {
                    this.myDBClass.getvideoDownloadao().delete_viavideoid(this.downloadServiceId, MakeMyExam.userId);
                }
            } else {
                this.myDBClass.getvideoDownloadao().delete_viavideoid_for_audio(this.downloadServiceId, MakeMyExam.userId);
            }
        } else if (-101 != result) {
            if (result == 2) {
                if (!this.downloadType.equalsIgnoreCase("1")) {
                    if (this.downloadType.equalsIgnoreCase("2")) {
                        this.myDBClass.getvideoDownloadao().update_videofilelenght_for_youtube(this.downloadServiceId, this.originalFileLengthString, Long.valueOf(this.total), this.lengthInMb, this.percentage, "0", "Downloading Pause", this.video_time, this.urlPath);
                    } else {
                        this.myDBClass.getvideoDownloadao().update_videofilelenght(this.downloadServiceId, this.originalFileLengthString, Long.valueOf(this.total), this.lengthInMb, this.percentage, "0", "Downloading Pause", this.video_time, this.urlPath);
                    }
                } else {
                    this.myDBClass.getvideoDownloadao().update_videofilelenght_for_audio(this.downloadServiceId, this.originalFileLengthString, Long.valueOf(this.total), this.lengthInMb, this.percentage, "0", "Downloading Pause", this.video_time, this.urlPath);
                }
            } else if (result == 1090) {
                UtkashRoom.destroyInstance();
            }
        }
        Intent intent = new Intent(VIDEO_DOWNLOAD_ACTION);
        intent.putExtra(FILEPATH, outputPath);
        intent.putExtra("result", result);
        intent.putExtra("message", message);
        intent.putExtra("size", this.file_size + "");
        intent.putExtra("resourceId", this.downloadServiceId);
        intent.putExtra("downloadType", this.downloadType);
        intent.putExtra("percentage", this.percentage);
        intent.putExtra("video_time", this.video_time);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void publishResults(String outputPath, int result, String message) {
        publishResults(outputPath, "", result, message);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        this.onPauseCalled = true;
        action = PAUSE;
        try {
            if (isServiceRunning) {
                this.pausedKey = this.secretKey;
                if (this.myDBClass != null) {
                    if (this.downloadType.equalsIgnoreCase("1")) {
                        this.myDBClass.getvideoDownloadao().update_videofilelenght_for_audio(this.downloadServiceId, this.originalFileLengthString, Long.valueOf(this.total), this.lengthInMb, this.percentage, "0", "Downloading Pause", this.video_time, this.urlPath);
                    } else if (this.downloadType.equalsIgnoreCase("2")) {
                        this.myDBClass.getvideoDownloadao().update_videofilelenght_for_youtube(this.downloadServiceId, this.originalFileLengthString, Long.valueOf(this.total), this.lengthInMb, this.percentage, "0", "Downloading Pause", this.video_time, this.urlPath);
                    } else {
                        this.myDBClass.getvideoDownloadao().update_videofilelenght(this.downloadServiceId, this.originalFileLengthString, Long.valueOf(this.total), this.lengthInMb, this.percentage, "0", "Downloading Pause", this.video_time, this.urlPath);
                    }
                }
            }
            for (VideosDownload videosDownload : this.myDBClass.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId)) {
                if (videosDownload.getVideo_status().equalsIgnoreCase("Downloading Running")) {
                    if (this.downloadType.equalsIgnoreCase("1")) {
                        this.myDBClass.getvideoDownloadao().update_videostatus_for_audio(videosDownload.getVideo_id(), "Downloading Pause", MakeMyExam.userId);
                    } else if (this.downloadType.equalsIgnoreCase("2")) {
                        this.myDBClass.getvideoDownloadao().update_videostatus_for_youtube(videosDownload.getVideo_id(), "Downloading Pause", MakeMyExam.userId);
                    } else {
                        this.myDBClass.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), "Downloading Pause", MakeMyExam.userId);
                    }
                }
            }
            OutputStream outputStream = this.fileOutput;
            if (outputStream != null) {
                outputStream.flush();
                this.fileOutput.close();
            }
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            CipherOutputStream cipherOutputStream = this.cipherOutputStream;
            if (cipherOutputStream != null) {
                cipherOutputStream.close();
            }
            NotificationManager notificationManager = this.mNotificationManager;
            if (notificationManager != null) {
                notificationManager.cancel(11111);
            }
            notifyDownloadState(this.notification_name, "Download has been paused by user");
            publishResults(this.downloadingFile.getAbsolutePath(), ONTASK, "");
            isServiceRunning = false;
            video_id = "";
            this.onPauseCalled = false;
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.DownloadServices.CustomIntentService, android.app.Service
    public void onDestroy() {
        isServiceRunning = false;
        video_id = "";
        super.onDestroy();
    }

    private static IvParameterSpec calculateIVForOffset(final IvParameterSpec iv, final long blockOffset) {
        byte[] byteArray = new BigInteger(1, iv.getIV()).add(BigInteger.valueOf(blockOffset / 16)).toByteArray();
        if (byteArray.length >= 16) {
            return new IvParameterSpec(byteArray, byteArray.length - 16, 16);
        }
        byte[] bArr = new byte[16];
        System.arraycopy(byteArray, 0, bArr, 16 - byteArray.length, byteArray.length);
        return new IvParameterSpec(bArr);
    }

    public String getErrorMessage(int responseCode) {
        if (responseCode == -3) {
            return "Sorry, we are facing some problems regarding payment.\nPlease try again later.";
        }
        if (responseCode == -2) {
            return "Something went wrong! Please try again.";
        }
        if (responseCode == -1) {
            return "Problem while connecting! please check your Internet connection.";
        }
        if (responseCode == 401 || responseCode == 404) {
            return "Session timed out. Kindly login again.";
        }
        if (responseCode == 408) {
            return "Problem while connecting! please check your Internet connection.";
        }
        if (responseCode == 500) {
            return "Server error! please try after some time.";
        }
        if (responseCode == 503) {
            return "Server under maintenance! please try after some time.";
        }
        if (responseCode == 504) {
            return "Server error! please try after some time.";
        }
        return "Something went wrong, please try again after some time.";
    }
}
