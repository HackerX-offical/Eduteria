package com.appnew.android.socket.extension;

import android.R;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.Utils.Helper;
import com.appnew.android.socket.activity.GroupChatActivity;
import com.appnew.android.socket.adapter.GroupChatAdapter2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.json.JSONObject;

/* JADX INFO: compiled from: Socket.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\f\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014*\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015\u001a\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f\u001a6\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0015\u001a.\u0010)\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0015¨\u0006-"}, d2 = {"notifyItemChanged", "", "Lcom/appnew/android/socket/activity/GroupChatActivity;", "message", "Lorg/json/JSONObject;", "chatList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/chatPojo;", "Lkotlin/collections/ArrayList;", "groupChatAdapter2", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2;", "dpToPixels", "", "Landroid/content/Context;", "dp", "showSoftKeyBoard", "Landroid/app/Activity;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "isFileExist", "Lkotlin/Pair;", "", "Ljava/io/File;", "fileName", "", "isLeft", "in_app_download", "generateImageFromPdf", "Landroid/graphics/Bitmap;", "context", "pdfUri", "Landroid/net/Uri;", "downloadFileFromURL", "activity", "postFile", "Lcom/appnew/android/Model/PostFile;", "chatPojo", "cvrDownLoadLeft", "Landroid/widget/RelativeLayout;", "inAppDownload", "isGroupChat", "startDownload", "url", "name", "cvrDownLoad", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SocketKt {
    public static /* synthetic */ void notifyItemChanged$default(GroupChatActivity groupChatActivity, JSONObject jSONObject, ArrayList arrayList, GroupChatAdapter2 groupChatAdapter2, int i, Object obj) {
        if ((i & 4) != 0) {
            groupChatAdapter2 = null;
        }
        notifyItemChanged(groupChatActivity, jSONObject, arrayList, groupChatAdapter2);
    }

    public static final void notifyItemChanged(final GroupChatActivity groupChatActivity, JSONObject message, ArrayList<chatPojo> chatList, final GroupChatAdapter2 groupChatAdapter2) {
        Intrinsics.checkNotNullParameter(groupChatActivity, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(chatList, "chatList");
        if (message.length() <= 0 || chatList.isEmpty()) {
            return;
        }
        final int i = 0;
        for (Object obj : chatList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((chatPojo) obj).getId(), ((chatPojo) new Gson().fromJson(message.toString(), chatPojo.class)).getId())) {
                groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.extension.SocketKt$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        SocketKt.notifyItemChanged$lambda$2$lambda$1(groupChatActivity, groupChatAdapter2, i);
                    }
                });
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyItemChanged$lambda$2$lambda$1(GroupChatActivity groupChatActivity, final GroupChatAdapter2 groupChatAdapter2, final int i) {
        groupChatActivity.getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.extension.SocketKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SocketKt.notifyItemChanged$lambda$2$lambda$1$lambda$0(groupChatAdapter2, i);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyItemChanged$lambda$2$lambda$1$lambda$0(GroupChatAdapter2 groupChatAdapter2, int i) {
        if (groupChatAdapter2 != null) {
            groupChatAdapter2.notifyItemChanged(i);
        }
    }

    public static final int dpToPixels(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    public static final void showSoftKeyBoard(Activity activity, View view) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Object systemService = activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view, 0);
    }

    public static final Pair<Boolean, File> isFileExist(Activity activity, String fileName, boolean z, boolean z2) {
        File file;
        boolean zExists;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        new File("");
        if (z) {
            if (z2) {
                File file2 = new File(String.valueOf(activity.getFilesDir()));
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(activity.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
                zExists = file.exists();
            } else {
                File file3 = new File(Environment.getExternalStorageDirectory().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + Environment.DIRECTORY_DOWNLOADS + "/EDUTERIA_doc_folder");
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                file = new File(file3.getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
                zExists = file.exists();
            }
        } else if (z2) {
            File file4 = new File(String.valueOf(activity.getFilesDir()));
            if (!file4.exists()) {
                file4.mkdirs();
            }
            file = new File(activity.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
            zExists = file.exists();
        } else {
            File file5 = new File(Environment.getExternalStorageDirectory().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + Environment.DIRECTORY_DOWNLOADS + "/EDUTERIA_doc_folder");
            if (!file5.exists()) {
                file5.mkdirs();
            }
            file = new File(file5.getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
            zExists = file.exists();
        }
        return new Pair<>(Boolean.valueOf(zExists), file);
    }

    public static final Bitmap generateImageFromPdf(Context context, Uri pdfUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pdfUri, "pdfUri");
        Bitmap bitmap = null;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(pdfUri, StreamManagement.AckRequest.ELEMENT);
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                PdfRenderer pdfRenderer = new PdfRenderer(parcelFileDescriptorOpenFileDescriptor);
                if (pdfRenderer.getPageCount() > 0) {
                    PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(0);
                    Intrinsics.checkNotNullExpressionValue(pageOpenPage, "openPage(...)");
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(pageOpenPage.getWidth(), pageOpenPage.getHeight(), Bitmap.Config.ARGB_8888);
                    try {
                        new Canvas(bitmapCreateBitmap).drawColor(-1);
                        Intrinsics.checkNotNull(bitmapCreateBitmap);
                        pageOpenPage.render(bitmapCreateBitmap, null, null, 1);
                        pageOpenPage.close();
                        bitmap = bitmapCreateBitmap;
                    } catch (Exception e2) {
                        e = e2;
                        bitmap = bitmapCreateBitmap;
                        e.printStackTrace();
                        Log.e("GenerateImageFromPdf", "Error: " + e.getMessage());
                        return bitmap;
                    }
                }
                pdfRenderer.close();
            }
            return bitmap;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static final void downloadFileFromURL(final Activity activity, PostFile postFile, final chatPojo chatPojo, RelativeLayout cvrDownLoadLeft, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(postFile, "postFile");
        Intrinsics.checkNotNullParameter(chatPojo, "chatPojo");
        Intrinsics.checkNotNullParameter(cvrDownLoadLeft, "cvrDownLoadLeft");
        if (z) {
            String link = postFile.getLink();
            Intrinsics.checkNotNullExpressionValue(link, "getLink(...)");
            String file_info = postFile.getFile_info();
            Intrinsics.checkNotNullExpressionValue(file_info, "getFile_info(...)");
            startDownload(activity, link, file_info, cvrDownLoadLeft, z2);
            return;
        }
        Helper.progressBar = new ProgressDialog(new ContextThemeWrapper(activity, R.style.Theme.Holo.Light.Dialog));
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + Environment.DIRECTORY_DOWNLOADS + "/EDUTERIA_doc_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file.getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + postFile.getFile_info());
            if (!file2.exists()) {
                Object systemService = activity.getSystemService("download");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
                final DownloadManager downloadManager = (DownloadManager) systemService;
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(postFile.getLink()));
                request.setAllowedNetworkTypes(3).setNotificationVisibility(1).setTitle(activity.getResources().getString(com.eduteria.app.app.R.string.app_name)).setAllowedOverRoaming(true);
                File file3 = new File(Environment.getExternalStorageDirectory().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + Environment.DIRECTORY_DOWNLOADS + "/EDUTERIA_doc_folder");
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                request.setDestinationUri(Uri.fromFile(file2));
                request.allowScanningByMediaScanner();
                final Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = downloadManager.enqueue(request);
                Helper.progressBar = new ProgressDialog(new ContextThemeWrapper(activity, R.style.Theme.Holo.Light.Dialog));
                Helper.progressBar.setCancelable(false);
                Helper.progressBar.setMessage("Downloading...");
                Helper.progressBar.setProgressStyle(1);
                Helper.progressBar.setProgress(0);
                Helper.progressBar.setMax(100);
                Helper.progressBar.setIndeterminate(false);
                Helper.progressBar.setProgressDrawable(activity.getResources().getDrawable(com.eduteria.app.app.R.drawable.progress_bar_download));
                Helper.progressBar.setButton(-2, "Cancel", new DialogInterface.OnClickListener() { // from class: com.appnew.android.socket.extension.SocketKt$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SocketKt.downloadFileFromURL$lambda$4(downloadManager, longRef, dialogInterface, i);
                    }
                });
                try {
                    Helper.progressBar.show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                new Thread(new Runnable() { // from class: com.appnew.android.socket.extension.SocketKt$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        SocketKt.downloadFileFromURL$lambda$7(activity, longRef, chatPojo);
                    }
                }).start();
                Unit unit = Unit.INSTANCE;
                return;
            }
            try {
                Intent intent = new Intent("DownloadPdf");
                intent.putExtra("chatId", chatPojo.getId());
                Boolean.valueOf(LocalBroadcastManager.getInstance(activity).sendBroadcast(intent));
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
                return;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            Unit unit3 = Unit.INSTANCE;
        }
        e4.printStackTrace();
        Unit unit32 = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFileFromURL$lambda$4(DownloadManager downloadManager, Ref.LongRef longRef, DialogInterface dialogInterface, int i) {
        if (downloadManager != null) {
            long j = longRef.element;
            downloadManager.remove(longRef.element);
        }
        try {
            dialogInterface.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFileFromURL$lambda$7(final Activity activity, Ref.LongRef longRef, final chatPojo chatpojo) {
        try {
            try {
                try {
                    try {
                        Object systemService = activity.getSystemService("download");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
                        DownloadManager downloadManager = (DownloadManager) systemService;
                        boolean z = true;
                        while (z) {
                            DownloadManager.Query query = new DownloadManager.Query();
                            query.setFilterById(longRef.element);
                            Cursor cursorQuery = downloadManager.query(query);
                            cursorQuery.moveToFirst();
                            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("bytes_so_far"));
                            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("total_size"));
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex("status")) == 8) {
                                z = false;
                            }
                            final int i3 = (int) ((((long) i) * 100) / ((long) i2));
                            activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.extension.SocketKt$$ExternalSyntheticLambda4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SocketKt.downloadFileFromURL$lambda$7$lambda$5(i3);
                                }
                            });
                            cursorQuery.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            if (Helper.progressBar == null || !Helper.progressBar.isShowing()) {
                                return;
                            }
                            Helper.progressBar.dismiss();
                        } catch (Exception unused) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.extension.SocketKt$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            SocketKt.downloadFileFromURL$lambda$7$lambda$6(chatpojo, activity);
                        }
                    });
                }
            } catch (Throwable unused2) {
                if (Helper.progressBar != null && Helper.progressBar.isShowing()) {
                    Helper.progressBar.dismiss();
                }
                activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.extension.SocketKt$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        SocketKt.downloadFileFromURL$lambda$7$lambda$6(chatpojo, activity);
                    }
                });
            }
        } finally {
            activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.extension.SocketKt$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    SocketKt.downloadFileFromURL$lambda$7$lambda$6(chatpojo, activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFileFromURL$lambda$7$lambda$5(int i) {
        Helper.progressBar.setProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFileFromURL$lambda$7$lambda$6(chatPojo chatpojo, Activity activity) {
        try {
            if (Helper.progressBar != null && Helper.progressBar.isShowing()) {
                Helper.progressBar.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            Intent intent = new Intent("DownloadPdf");
            intent.putExtra("chatId", chatpojo.getId());
            LocalBroadcastManager.getInstance(activity).sendBroadcast(intent);
        } catch (Exception e3) {
            Log.d("showFiles", "showFiles: " + e3.getMessage());
        }
    }

    public static final void startDownload(Activity activity, String url, String name, RelativeLayout cvrDownLoad, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(cvrDownLoad, "cvrDownLoad");
        Helper.progressBar = new ProgressDialog(new ContextThemeWrapper(activity, R.style.Theme.Holo.Light.Dialog));
        new DownloadTask(activity, name, cvrDownLoad, z).execute(url);
    }
}
