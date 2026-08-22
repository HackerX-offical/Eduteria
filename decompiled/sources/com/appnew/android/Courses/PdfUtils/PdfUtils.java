package com.appnew.android.Courses.PdfUtils;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.os.Build;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import com.appnew.android.Courses.PdfUtils.PdfUtils;
import com.eduteria.app.app.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

/* JADX INFO: compiled from: PdfUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015J(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J&\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J(\u0010$\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/appnew/android/Courses/PdfUtils/PdfUtils;", "", "<init>", "()V", "State", "", "getState", "()Z", "setState", "(Z)V", "checkPermissionsAndDownload", "", "activity", "Landroid/app/Activity;", "pdfUrl", "", "pdfView", "Lcom/github/barteksc/pdfviewer/PDFView;", "progressBar", "Landroid/widget/ProgressBar;", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "checkAndDownloadPdf", "currentDownloadCall", "Lokhttp3/Call;", "getCurrentDownloadCall", "()Lokhttp3/Call;", "setCurrentDownloadCall", "(Lokhttp3/Call;)V", "downloadAndSavePdf", "getPdfPageCount", "", "getGetPdfPageCount", "()I", "setGetPdfPageCount", "(I)V", "displayPdf", "file", "Ljava/io/File;", "getFileNameFromUrl", "url", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PdfUtils {
    private static Call currentDownloadCall;
    private static int getPdfPageCount;
    public static final PdfUtils INSTANCE = new PdfUtils();
    private static boolean State = true;
    public static final int $stable = 8;

    private PdfUtils() {
    }

    public final boolean getState() {
        return State;
    }

    public final void setState(boolean z) {
        State = z;
    }

    public final void checkPermissionsAndDownload(Activity activity, String pdfUrl, PDFView pdfView, ProgressBar progressBar, ActivityResultLauncher<String> permissionLauncher) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pdfView, "pdfView");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(permissionLauncher, "permissionLauncher");
        if (pdfUrl == null) {
            Toast.makeText(activity, "Invalid PDF URL!", 0).show();
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            if (activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                checkAndDownloadPdf(activity, pdfUrl, pdfView, progressBar);
                return;
            } else {
                permissionLauncher.launch("android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            }
        }
        checkAndDownloadPdf(activity, pdfUrl, pdfView, progressBar);
    }

    public final void checkAndDownloadPdf(Activity activity, String pdfUrl, PDFView pdfView, ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pdfView, "pdfView");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        if (pdfUrl == null) {
            Toast.makeText(activity, "Invalid PDF URL!", 0).show();
            return;
        }
        String fileNameFromUrl = getFileNameFromUrl(pdfUrl);
        File file = new File(activity.getFilesDir(), "PDFs");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, fileNameFromUrl);
        if (file2.exists() && file2.length() > 0) {
            displayPdf(activity, pdfView, file2, progressBar);
        } else {
            downloadAndSavePdf(activity, pdfUrl, pdfView, progressBar);
        }
    }

    public final Call getCurrentDownloadCall() {
        return currentDownloadCall;
    }

    public final void setCurrentDownloadCall(Call call) {
        currentDownloadCall = call;
    }

    public final void downloadAndSavePdf(Activity activity, String pdfUrl, PDFView pdfView, ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pdfUrl, "pdfUrl");
        Intrinsics.checkNotNullParameter(pdfView, "pdfView");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        progressBar.setVisibility(0);
        progressBar.getIndeterminateDrawable().setColorFilter(activity.getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        Request requestBuild = new Request.Builder().url(pdfUrl).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        String fileNameFromUrl = getFileNameFromUrl(pdfUrl);
        File file = new File(activity.getFilesDir(), "PDFs");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, fileNameFromUrl);
        Call call = currentDownloadCall;
        if (call != null) {
            call.cancel();
        }
        Call callNewCall = okHttpClient.newCall(requestBuild);
        currentDownloadCall = callNewCall;
        if (callNewCall != null) {
            callNewCall.enqueue(new AnonymousClass1(file2, activity, progressBar, pdfView));
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Courses.PdfUtils.PdfUtils$downloadAndSavePdf$1, reason: invalid class name */
    /* JADX INFO: compiled from: PdfUtils.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/appnew/android/Courses/PdfUtils/PdfUtils$downloadAndSavePdf$1", "Lokhttp3/Callback;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", SaslNonza.Response.ELEMENT, "Lokhttp3/Response;", "onFailure", "e", "Ljava/io/IOException;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements Callback {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ File $file;
        final /* synthetic */ PDFView $pdfView;
        final /* synthetic */ ProgressBar $progressBar;

        AnonymousClass1(File file, Activity activity, ProgressBar progressBar, PDFView pDFView) {
            this.$file = file;
            this.$activity = activity;
            this.$progressBar = progressBar;
            this.$pdfView = pDFView;
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody != null) {
                final File file = this.$file;
                final Activity activity = this.$activity;
                final ProgressBar progressBar = this.$progressBar;
                final PDFView pDFView = this.$pdfView;
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ByteStreamsKt.copyTo$default(responseBodyBody.byteStream(), fileOutputStream, 0, 2, null);
                    fileOutputStream.close();
                    activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.PdfUtils.PdfUtils$downloadAndSavePdf$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            PdfUtils.AnonymousClass1.onResponse$lambda$2$lambda$0(progressBar, activity, pDFView, file);
                        }
                    });
                    return;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.PdfUtils.PdfUtils$downloadAndSavePdf$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            PdfUtils.AnonymousClass1.onResponse$lambda$2$lambda$1(progressBar, activity, file);
                        }
                    });
                    return;
                }
            }
            final Activity activity2 = this.$activity;
            final ProgressBar progressBar2 = this.$progressBar;
            activity2.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.PdfUtils.PdfUtils$downloadAndSavePdf$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PdfUtils.AnonymousClass1.onResponse$lambda$4$lambda$3(progressBar2, activity2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResponse$lambda$2$lambda$0(ProgressBar progressBar, Activity activity, PDFView pDFView, File file) {
            progressBar.setVisibility(8);
            PdfUtils.INSTANCE.displayPdf(activity, pDFView, file, progressBar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResponse$lambda$2$lambda$1(ProgressBar progressBar, Activity activity, File file) {
            progressBar.setVisibility(8);
            Activity activity2 = activity;
            Toast.makeText(activity2, "Error saving the PDF.", 0).show();
            if (!file.exists() || file.delete()) {
                return;
            }
            Toast.makeText(activity2, "Failed to delete corrupted PDF.", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResponse$lambda$4$lambda$3(ProgressBar progressBar, Activity activity) {
            progressBar.setVisibility(8);
            Toast.makeText(activity, "Empty PDF response!", 0).show();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e2) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e2, "e");
            e2.printStackTrace();
            final Activity activity = this.$activity;
            final ProgressBar progressBar = this.$progressBar;
            activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.PdfUtils.PdfUtils$downloadAndSavePdf$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PdfUtils.AnonymousClass1.onFailure$lambda$5(progressBar, activity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onFailure$lambda$5(ProgressBar progressBar, Activity activity) {
            progressBar.setVisibility(8);
            Toast.makeText(activity, "Download failed! Check Internet", 0).show();
        }
    }

    public final int getGetPdfPageCount() {
        return getPdfPageCount;
    }

    public final void setGetPdfPageCount(int i) {
        getPdfPageCount = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayPdf(Activity activity, final PDFView pdfView, File file, final ProgressBar progressBar) {
        try {
            if (activity.isDestroyed()) {
                return;
            }
            pdfView.recycle();
            pdfView.invalidate();
            pdfView.fromFile(file).enableAnnotationRendering(true).fitEachPage(true).enableSwipe(true).swipeHorizontal(false).enableDoubletap(true).enableAntialiasing(true).defaultPage(0).onLoad(new OnLoadCompleteListener() { // from class: com.appnew.android.Courses.PdfUtils.PdfUtils$$ExternalSyntheticLambda0
                @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
                public final void loadComplete(int i) {
                    PdfUtils.displayPdf$lambda$0(pdfView, progressBar, i);
                }
            }).load();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayPdf$lambda$0(PDFView pDFView, ProgressBar progressBar, int i) {
        getPdfPageCount = pDFView.getPageCount();
        progressBar.setVisibility(8);
    }

    public final String getFileNameFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String path = new URL(url).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(path, MqttTopic.TOPIC_LEVEL_SEPARATOR, (String) null, 2, (Object) null);
        if (strSubstringAfterLast$default.length() > 100) {
            strSubstringAfterLast$default = StringsKt.take(strSubstringAfterLast$default, 100);
        }
        return String.valueOf(url.hashCode()) + "_" + strSubstringAfterLast$default;
    }
}
