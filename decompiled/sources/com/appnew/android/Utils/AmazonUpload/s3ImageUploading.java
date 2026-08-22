package com.appnew.android.Utils.AmazonUpload;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.appnew.android.Model.MediaFile;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class s3ImageUploading extends AsyncTask<ArrayList<MediaFile>, Integer, ArrayList<MediaFile>> {
    private static final String TAG = "s3ImageUploading";
    public static ProgressDialog progressBar;
    public static String test_file_name;
    String MY_OBJECT_KEY;
    AmazonCallBack amazonCallBack;
    String amazonFileUploadLocationOriginal;
    String chatnode;
    Long contentLength;
    Context context;
    private CognitoCachingCredentialsProvider credentialsProvider;
    ArrayList<MediaFile> imagearrayStr;
    Boolean isLoader;
    String message;
    private ProgressCallBack progressCallBack;

    public s3ImageUploading(String amazonFileUploadLocationOriginal, Context context, AmazonCallBack amazonCallBack, ProgressBar progressBars) {
        this.credentialsProvider = null;
        this.chatnode = "";
        this.message = "";
        this.amazonFileUploadLocationOriginal = amazonFileUploadLocationOriginal;
        this.amazonCallBack = amazonCallBack;
        this.context = context;
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressBar = progressDialog;
        progressDialog.setCancelable(false);
        progressBar.setMessage("Uploading...");
        progressBar.setProgressStyle(1);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_bar_download));
        this.credentialsProvider = new CognitoCachingCredentialsProvider(context, "ap-south-1:d6df173c-d6b5-48b5-87dd-266300ae6b7e", Regions.AP_SOUTH_1);
    }

    public s3ImageUploading(String chatnode, String amazonFileUploadLocationOriginal, Context context, AmazonCallBack amazonCallBack, ProgressBar progressBars) {
        this.credentialsProvider = null;
        this.message = "";
        this.amazonFileUploadLocationOriginal = amazonFileUploadLocationOriginal;
        this.amazonCallBack = amazonCallBack;
        this.context = context;
        this.chatnode = chatnode;
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressBar = progressDialog;
        progressDialog.setCancelable(false);
        progressBar.setMessage("Uploading...");
        progressBar.setProgressStyle(1);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_bar_download));
        this.credentialsProvider = new CognitoCachingCredentialsProvider(context, "ap-south-1:d6df173c-d6b5-48b5-87dd-266300ae6b7e", Regions.AP_SOUTH_1);
    }

    public s3ImageUploading(String chatnode, String amazonFileUploadLocationOriginal, Context context, AmazonCallBack amazonCallBack, ProgressBar progressBars, Boolean isLoader, ProgressCallBack progressCallBack) {
        this.credentialsProvider = null;
        this.message = "";
        this.amazonFileUploadLocationOriginal = amazonFileUploadLocationOriginal;
        this.amazonCallBack = amazonCallBack;
        this.context = context;
        this.chatnode = chatnode;
        this.isLoader = isLoader;
        this.progressCallBack = progressCallBack;
        this.credentialsProvider = new CognitoCachingCredentialsProvider(context, "ap-south-1:d6df173c-d6b5-48b5-87dd-266300ae6b7e", Regions.AP_SOUTH_1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... values) {
        super.onProgressUpdate((Object[]) values);
        try {
            progressBar.setIndeterminate(false);
            progressBar.setMax(100);
            progressBar.setProgress(values[0].intValue());
        } catch (Exception unused) {
        }
        for (Integer num : values) {
            ProgressCallBack progressCallBack = this.progressCallBack;
            if (progressCallBack != null) {
                progressCallBack.onProgress(num);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.imagearrayStr = new ArrayList<>();
        try {
            progressBar.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x029c A[Catch: Exception -> 0x059c, TryCatch #0 {Exception -> 0x059c, blocks: (B:3:0x000a, B:5:0x0021, B:6:0x0027, B:8:0x002d, B:14:0x0056, B:18:0x007a, B:49:0x0236, B:51:0x0240, B:53:0x024a, B:55:0x0254, B:57:0x025e, B:59:0x0268, B:61:0x0272, B:63:0x027a, B:67:0x0287, B:69:0x02a4, B:72:0x02c7, B:79:0x032c, B:81:0x0336, B:83:0x0377, B:98:0x050b, B:91:0x03f5, B:93:0x0440, B:96:0x0462, B:97:0x04b4, B:82:0x036e, B:73:0x02df, B:75:0x02e7, B:76:0x030d, B:78:0x0315, B:68:0x029c, B:20:0x00a0, B:24:0x00af, B:25:0x00cd, B:28:0x00db, B:30:0x00e3, B:31:0x0118, B:33:0x0124, B:34:0x0157, B:36:0x0161, B:37:0x0173, B:39:0x017d, B:40:0x01b0, B:42:0x01ba, B:43:0x01ec, B:45:0x01f6, B:46:0x01fb, B:48:0x0205, B:99:0x051a, B:100:0x0535, B:120:0x0590, B:102:0x0539, B:110:0x055b, B:105:0x0540, B:107:0x0546, B:108:0x0555, B:111:0x0564, B:113:0x056d, B:114:0x0576, B:119:0x0586, B:117:0x057d), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c7 A[Catch: Exception -> 0x059c, TRY_ENTER, TryCatch #0 {Exception -> 0x059c, blocks: (B:3:0x000a, B:5:0x0021, B:6:0x0027, B:8:0x002d, B:14:0x0056, B:18:0x007a, B:49:0x0236, B:51:0x0240, B:53:0x024a, B:55:0x0254, B:57:0x025e, B:59:0x0268, B:61:0x0272, B:63:0x027a, B:67:0x0287, B:69:0x02a4, B:72:0x02c7, B:79:0x032c, B:81:0x0336, B:83:0x0377, B:98:0x050b, B:91:0x03f5, B:93:0x0440, B:96:0x0462, B:97:0x04b4, B:82:0x036e, B:73:0x02df, B:75:0x02e7, B:76:0x030d, B:78:0x0315, B:68:0x029c, B:20:0x00a0, B:24:0x00af, B:25:0x00cd, B:28:0x00db, B:30:0x00e3, B:31:0x0118, B:33:0x0124, B:34:0x0157, B:36:0x0161, B:37:0x0173, B:39:0x017d, B:40:0x01b0, B:42:0x01ba, B:43:0x01ec, B:45:0x01f6, B:46:0x01fb, B:48:0x0205, B:99:0x051a, B:100:0x0535, B:120:0x0590, B:102:0x0539, B:110:0x055b, B:105:0x0540, B:107:0x0546, B:108:0x0555, B:111:0x0564, B:113:0x056d, B:114:0x0576, B:119:0x0586, B:117:0x057d), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02df A[Catch: Exception -> 0x059c, TryCatch #0 {Exception -> 0x059c, blocks: (B:3:0x000a, B:5:0x0021, B:6:0x0027, B:8:0x002d, B:14:0x0056, B:18:0x007a, B:49:0x0236, B:51:0x0240, B:53:0x024a, B:55:0x0254, B:57:0x025e, B:59:0x0268, B:61:0x0272, B:63:0x027a, B:67:0x0287, B:69:0x02a4, B:72:0x02c7, B:79:0x032c, B:81:0x0336, B:83:0x0377, B:98:0x050b, B:91:0x03f5, B:93:0x0440, B:96:0x0462, B:97:0x04b4, B:82:0x036e, B:73:0x02df, B:75:0x02e7, B:76:0x030d, B:78:0x0315, B:68:0x029c, B:20:0x00a0, B:24:0x00af, B:25:0x00cd, B:28:0x00db, B:30:0x00e3, B:31:0x0118, B:33:0x0124, B:34:0x0157, B:36:0x0161, B:37:0x0173, B:39:0x017d, B:40:0x01b0, B:42:0x01ba, B:43:0x01ec, B:45:0x01f6, B:46:0x01fb, B:48:0x0205, B:99:0x051a, B:100:0x0535, B:120:0x0590, B:102:0x0539, B:110:0x055b, B:105:0x0540, B:107:0x0546, B:108:0x0555, B:111:0x0564, B:113:0x056d, B:114:0x0576, B:119:0x0586, B:117:0x057d), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0336 A[Catch: Exception -> 0x059c, TryCatch #0 {Exception -> 0x059c, blocks: (B:3:0x000a, B:5:0x0021, B:6:0x0027, B:8:0x002d, B:14:0x0056, B:18:0x007a, B:49:0x0236, B:51:0x0240, B:53:0x024a, B:55:0x0254, B:57:0x025e, B:59:0x0268, B:61:0x0272, B:63:0x027a, B:67:0x0287, B:69:0x02a4, B:72:0x02c7, B:79:0x032c, B:81:0x0336, B:83:0x0377, B:98:0x050b, B:91:0x03f5, B:93:0x0440, B:96:0x0462, B:97:0x04b4, B:82:0x036e, B:73:0x02df, B:75:0x02e7, B:76:0x030d, B:78:0x0315, B:68:0x029c, B:20:0x00a0, B:24:0x00af, B:25:0x00cd, B:28:0x00db, B:30:0x00e3, B:31:0x0118, B:33:0x0124, B:34:0x0157, B:36:0x0161, B:37:0x0173, B:39:0x017d, B:40:0x01b0, B:42:0x01ba, B:43:0x01ec, B:45:0x01f6, B:46:0x01fb, B:48:0x0205, B:99:0x051a, B:100:0x0535, B:120:0x0590, B:102:0x0539, B:110:0x055b, B:105:0x0540, B:107:0x0546, B:108:0x0555, B:111:0x0564, B:113:0x056d, B:114:0x0576, B:119:0x0586, B:117:0x057d), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x036e A[Catch: Exception -> 0x059c, TryCatch #0 {Exception -> 0x059c, blocks: (B:3:0x000a, B:5:0x0021, B:6:0x0027, B:8:0x002d, B:14:0x0056, B:18:0x007a, B:49:0x0236, B:51:0x0240, B:53:0x024a, B:55:0x0254, B:57:0x025e, B:59:0x0268, B:61:0x0272, B:63:0x027a, B:67:0x0287, B:69:0x02a4, B:72:0x02c7, B:79:0x032c, B:81:0x0336, B:83:0x0377, B:98:0x050b, B:91:0x03f5, B:93:0x0440, B:96:0x0462, B:97:0x04b4, B:82:0x036e, B:73:0x02df, B:75:0x02e7, B:76:0x030d, B:78:0x0315, B:68:0x029c, B:20:0x00a0, B:24:0x00af, B:25:0x00cd, B:28:0x00db, B:30:0x00e3, B:31:0x0118, B:33:0x0124, B:34:0x0157, B:36:0x0161, B:37:0x0173, B:39:0x017d, B:40:0x01b0, B:42:0x01ba, B:43:0x01ec, B:45:0x01f6, B:46:0x01fb, B:48:0x0205, B:99:0x051a, B:100:0x0535, B:120:0x0590, B:102:0x0539, B:110:0x055b, B:105:0x0540, B:107:0x0546, B:108:0x0555, B:111:0x0564, B:113:0x056d, B:114:0x0576, B:119:0x0586, B:117:0x057d), top: B:132:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0440 A[Catch: Exception -> 0x059c, TRY_LEAVE, TryCatch #0 {Exception -> 0x059c, blocks: (B:3:0x000a, B:5:0x0021, B:6:0x0027, B:8:0x002d, B:14:0x0056, B:18:0x007a, B:49:0x0236, B:51:0x0240, B:53:0x024a, B:55:0x0254, B:57:0x025e, B:59:0x0268, B:61:0x0272, B:63:0x027a, B:67:0x0287, B:69:0x02a4, B:72:0x02c7, B:79:0x032c, B:81:0x0336, B:83:0x0377, B:98:0x050b, B:91:0x03f5, B:93:0x0440, B:96:0x0462, B:97:0x04b4, B:82:0x036e, B:73:0x02df, B:75:0x02e7, B:76:0x030d, B:78:0x0315, B:68:0x029c, B:20:0x00a0, B:24:0x00af, B:25:0x00cd, B:28:0x00db, B:30:0x00e3, B:31:0x0118, B:33:0x0124, B:34:0x0157, B:36:0x0161, B:37:0x0173, B:39:0x017d, B:40:0x01b0, B:42:0x01ba, B:43:0x01ec, B:45:0x01f6, B:46:0x01fb, B:48:0x0205, B:99:0x051a, B:100:0x0535, B:120:0x0590, B:102:0x0539, B:110:0x055b, B:105:0x0540, B:107:0x0546, B:108:0x0555, B:111:0x0564, B:113:0x056d, B:114:0x0576, B:119:0x0586, B:117:0x057d), top: B:132:0x000a }] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<com.appnew.android.Model.MediaFile> doInBackground(java.util.ArrayList<com.appnew.android.Model.MediaFile>... r27) {
        /*
            Method dump skipped, instruction units count: 1494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.AmazonUpload.s3ImageUploading.doInBackground(java.util.ArrayList[]):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(ArrayList<MediaFile> images) {
        super.onPostExecute(images);
        try {
            progressBar.dismiss();
        } catch (Exception unused) {
        }
        if (images.size() != 0) {
            this.amazonCallBack.onS3UploadData(images);
            return;
        }
        String str = this.message;
        if (str != null && !str.equalsIgnoreCase("")) {
            Toast toastMakeText = Toast.makeText(this.context, "" + this.message, 1);
            toastMakeText.setGravity(17, 0, 0);
            toastMakeText.show();
        } else {
            Toast toastMakeText2 = Toast.makeText(this.context, R.string.profile_image_error, 1);
            toastMakeText2.setGravity(17, 0, 0);
            toastMakeText2.show();
        }
    }
}
