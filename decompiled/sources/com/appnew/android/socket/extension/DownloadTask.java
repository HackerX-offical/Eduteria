package com.appnew.android.socket.extension;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.appnew.android.Utils.Helper;
import com.eduteria.app.app.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Socket.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0012\u001a\u00020\u0013H\u0014J%\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0016\"\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0014J'\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0016\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/socket/extension/DownloadTask;", "Landroid/os/AsyncTask;", "", "", "context", "Landroid/content/Context;", "name", "cvrDownLoad", "Landroid/widget/RelativeLayout;", "isGroupChat", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/RelativeLayout;Z)V", "getName", "()Ljava/lang/String;", "getCvrDownLoad", "()Landroid/widget/RelativeLayout;", "()Z", "onPreExecute", "", "onProgressUpdate", "progress", "", "([Ljava/lang/Integer;)V", "onPostExecute", "result", "doInBackground", "sUrl", "([Ljava/lang/String;)Ljava/lang/String;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DownloadTask extends AsyncTask<String, Integer, String> {
    private final Context context;
    private final RelativeLayout cvrDownLoad;
    private final boolean isGroupChat;
    private final String name;

    public final RelativeLayout getCvrDownLoad() {
        return this.cvrDownLoad;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: isGroupChat, reason: from getter */
    public final boolean getIsGroupChat() {
        return this.isGroupChat;
    }

    public DownloadTask(Context context, String name, RelativeLayout cvrDownLoad, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(cvrDownLoad, "cvrDownLoad");
        this.context = context;
        this.name = name;
        this.cvrDownLoad = cvrDownLoad;
        this.isGroupChat = z;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        Helper.progressBar.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        super.onProgressUpdate(Arrays.copyOf(progress, progress.length));
        try {
            Helper.progressBar.setCancelable(false);
            Helper.progressBar.setMessage("Downloading...");
            Helper.progressBar.setProgressStyle(1);
            Helper.progressBar.setProgress(0);
            Helper.progressBar.setMax(100);
            Helper.progressBar.setIndeterminate(false);
            Helper.progressBar.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.progress_bar_download));
        } catch (IllegalArgumentException e2) {
            Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e2.getMessage());
        } catch (Exception e3) {
            Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(String result) {
        Helper.progressBar.dismiss();
        if (result != null) {
            Context context = this.context;
            Toast.makeText(context, context.getResources().getString(R.string.download_error) + result, 1).show();
            return;
        }
        Context context2 = this.context;
        Toast.makeText(context2, context2.getResources().getString(R.string.file_downloaded), 0).show();
        this.cvrDownLoad.setVisibility(8);
        if (this.isGroupChat) {
            return;
        }
        try {
            Intent intent = new Intent("DownloadPdf");
            intent.putExtra("chatId", this.name);
            LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0095, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0098, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009b, code lost:
    
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009d, code lost:
    
        r2.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String doInBackground(java.lang.String... r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.socket.extension.DownloadTask.doInBackground(java.lang.String[]):java.lang.String");
    }
}
