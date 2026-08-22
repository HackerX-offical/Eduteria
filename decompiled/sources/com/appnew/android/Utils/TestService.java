package com.appnew.android.Utils;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.appnew.android.BuildConfig;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Room.UtkashRoom;
import com.eduteria.app.app.R;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

/* JADX INFO: loaded from: classes6.dex */
public class TestService extends IntentService {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String action = "test_json";
    public static boolean is_uploading = false;
    public static volatile boolean shouldStop = false;
    String MY_OBJECT_KEY;
    String amazonFileUploadLocationOriginal;
    public String chatnode;
    Long contentLength;
    private CognitoCachingCredentialsProvider credentialsProvider;
    NotificationManager mNotificationManager;
    ArrayList<MediaFile> mediaFiles;
    public boolean response;
    public String test_file_name;

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 2;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        startMyOwnForeground();
        this.amazonFileUploadLocationOriginal = "vc-10000386-38616500102/166/admin_v1/test_management/question_bank/";
        this.credentialsProvider = new CognitoCachingCredentialsProvider(this, "ap-south-1:d6df173c-d6b5-48b5-87dd-266300ae6b7e", Regions.AP_SOUTH_1);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    private void startMyOwnForeground() {
        NotificationChannel notificationChannel = new NotificationChannel(BuildConfig.APPLICATION_ID, getApplicationContext().getResources().getString(R.string.app_name), 0);
        notificationChannel.setSound(null, null);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setLockscreenVisibility(0);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        startForeground(2, new NotificationCompat.Builder(this, BuildConfig.APPLICATION_ID).setOngoing(true).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("App is running in background").setPriority(1).setCategory(NotificationCompat.CATEGORY_SERVICE).build());
    }

    public TestService() {
        super("TestService");
        this.chatnode = "";
        this.test_file_name = "";
        this.response = false;
        this.credentialsProvider = null;
        this.mediaFiles = new ArrayList<>();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        try {
            try {
                is_uploading = true;
                this.chatnode = intent.getStringExtra("test_id");
                this.test_file_name = intent.getStringExtra("test_file_name");
                this.mediaFiles = (ArrayList) intent.getSerializableExtra("mediaFileArrayList");
                AmazonS3Client amazonS3Client = new AmazonS3Client(this.credentialsProvider);
                amazonS3Client.setEndpoint(Const.AMAZON_S3_END_POINT);
                if (this.mediaFiles.size() > 0) {
                    MediaFile mediaFile = this.mediaFiles.get(0);
                    if (mediaFile.getFile_type().equals("json")) {
                        this.MY_OBJECT_KEY = this.test_file_name;
                    }
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mediaFile.getFile_type().equals("json") ? Helper.FileToByteArray(mediaFile.getFile()) : null);
                    ObjectMetadata objectMetadata = new ObjectMetadata();
                    Long lValueOf = Long.valueOf(r0.length);
                    this.contentLength = lValueOf;
                    objectMetadata.setContentLength(lValueOf.longValue());
                    if (this.amazonFileUploadLocationOriginal.equalsIgnoreCase("vc-10000386-38616500102/166/admin_v1/test_management/question_bank/")) {
                        this.amazonFileUploadLocationOriginal += this.chatnode;
                    }
                    PutObjectRequest putObjectRequest = new PutObjectRequest(this.amazonFileUploadLocationOriginal, this.MY_OBJECT_KEY, byteArrayInputStream, objectMetadata);
                    putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
                    putObjectRequest.setProgressListener(new ProgressListener() { // from class: com.appnew.android.Utils.TestService.1
                        int total = 0;

                        @Override // com.amazonaws.services.s3.model.ProgressListener
                        public void progressChanged(ProgressEvent pv) {
                            Integer[] numArr = new Integer[2];
                            Integer.valueOf(Integer.parseInt(String.valueOf(TestService.this.contentLength)) * 100);
                            int bytesTransfered = this.total + pv.getBytesTransfered();
                            this.total = bytesTransfered;
                            if (bytesTransfered > 0) {
                                Integer.valueOf(bytesTransfered);
                            }
                        }
                    });
                    amazonS3Client.putObject(putObjectRequest);
                    if (this.amazonFileUploadLocationOriginal.equalsIgnoreCase("vc-10000386-38616500102/166/admin_v1/test_management/question_bank/" + this.chatnode)) {
                        this.response = true;
                        is_uploading = false;
                        if (new File(mediaFile.getFile()).exists()) {
                            new File(mediaFile.getFile()).delete();
                        }
                        shouldStop = true;
                    }
                    Intent intent2 = new Intent(action);
                    intent2.putExtra(SaslNonza.Response.ELEMENT, this.response);
                    LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
                }
                is_uploading = false;
                shouldStop = true;
                if (shouldStop) {
                    stopSelf();
                }
            } catch (Exception e2) {
                shouldStop = true;
                this.response = false;
                e2.printStackTrace();
                is_uploading = false;
                shouldStop = true;
                if (shouldStop) {
                    stopSelf();
                }
            }
        } catch (Throwable th) {
            is_uploading = false;
            shouldStop = true;
            if (shouldStop) {
                stopSelf();
            }
            throw th;
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        shouldStop = true;
        if (shouldStop) {
            stopSelf();
        }
        UtkashRoom.destroyInstance();
    }
}
