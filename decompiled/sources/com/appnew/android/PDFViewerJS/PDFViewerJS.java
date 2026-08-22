package com.appnew.android.PDFViewerJS;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityPdfviewerJsBinding;
import com.eduteria.app.app.R;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;

/* JADX INFO: compiled from: PDFViewerJS.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0014J\b\u0010F\u001a\u00020CH\u0002J\b\u0010G\u001a\u00020CH\u0002J\u0010\u0010H\u001a\u00020C2\u0006\u0010I\u001a\u00020\u0007H\u0002J\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0007J\u0006\u0010J\u001a\u00020KJ$\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020\u00072\b\b\u0002\u0010P\u001a\u00020\u0007H\u0002J\u0006\u0010Q\u001a\u00020CJ\"\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J\b\u0010X\u001a\u00020CH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u00100\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u001a\u00103\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R\u001a\u00106\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R\u001c\u00109\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R\u001a\u0010<\u001a\u00020=X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006Z"}, d2 = {"Lcom/appnew/android/PDFViewerJS/PDFViewerJS;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityPdfviewerJsBinding;", "mode", "", "toolbarTitleTV", "Landroid/widget/TextView;", "getToolbarTitleTV", "()Landroid/widget/TextView;", "setToolbarTitleTV", "(Landroid/widget/TextView;)V", "main_toolbar", "Landroidx/appcompat/widget/Toolbar;", "getMain_toolbar", "()Landroidx/appcompat/widget/Toolbar;", "setMain_toolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "image_back", "Landroid/widget/ImageView;", "getImage_back", "()Landroid/widget/ImageView;", "setImage_back", "(Landroid/widget/ImageView;)V", "download_btn", "Landroid/widget/Button;", "getDownload_btn", "()Landroid/widget/Button;", "setDownload_btn", "(Landroid/widget/Button;)V", "shareFloatingActionButton", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "getShareFloatingActionButton", "()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "setShareFloatingActionButton", "(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V", "progress", "Lcom/appnew/android/Utils/Progress;", "file_type", "getFile_type", "()Ljava/lang/String;", "setFile_type", "(Ljava/lang/String;)V", Const.VIDEO_ID, "getVideo_id", "setVideo_id", "link", "getLink", "setLink", "pdf_name", "getPdf_name", "setPdf_name", "pdf_id", "getPdf_id", "setPdf_id", "course_id", "getCourse_id", "setCourse_id", "mProgressDialog", "Landroid/app/ProgressDialog;", "getMProgressDialog", "()Landroid/app/ProgressDialog;", "setMProgressDialog", "(Landroid/app/ProgressDialog;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "sharePdf", "viewPdf", "checkPdf", "pdfId", "getFileExist", "Ljava/io/File;", "fileName", "loadPdfWithJumpToPage", "pdfUrl", "buttonColor", "textColor", "openChooser", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "DownloadTask", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFViewerJS extends AppCompatActivity {
    public static final int $stable = 8;
    private ActivityPdfviewerJsBinding binding;
    public Button download_btn;
    public ImageView image_back;
    public String link;
    public ProgressDialog mProgressDialog;
    private Toolbar main_toolbar;
    public String pdf_name;
    private final Progress progress;
    public FloatingActionButton shareFloatingActionButton;
    public TextView toolbarTitleTV;
    private String mode = "online";
    private String file_type = "";
    private String video_id = "";
    private String pdf_id = "";
    private String course_id = "";

    public final TextView getToolbarTitleTV() {
        TextView textView = this.toolbarTitleTV;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("toolbarTitleTV");
        return null;
    }

    public final void setToolbarTitleTV(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.toolbarTitleTV = textView;
    }

    public final Toolbar getMain_toolbar() {
        return this.main_toolbar;
    }

    public final void setMain_toolbar(Toolbar toolbar) {
        this.main_toolbar = toolbar;
    }

    public final ImageView getImage_back() {
        ImageView imageView = this.image_back;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("image_back");
        return null;
    }

    public final void setImage_back(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.image_back = imageView;
    }

    public final Button getDownload_btn() {
        Button button = this.download_btn;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("download_btn");
        return null;
    }

    public final void setDownload_btn(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.download_btn = button;
    }

    public final FloatingActionButton getShareFloatingActionButton() {
        FloatingActionButton floatingActionButton = this.shareFloatingActionButton;
        if (floatingActionButton != null) {
            return floatingActionButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareFloatingActionButton");
        return null;
    }

    public final void setShareFloatingActionButton(FloatingActionButton floatingActionButton) {
        Intrinsics.checkNotNullParameter(floatingActionButton, "<set-?>");
        this.shareFloatingActionButton = floatingActionButton;
    }

    public final String getFile_type() {
        return this.file_type;
    }

    public final void setFile_type(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.file_type = str;
    }

    public final String getVideo_id() {
        return this.video_id;
    }

    public final void setVideo_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.video_id = str;
    }

    public final String getLink() {
        String str = this.link;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("link");
        return null;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    public final String getPdf_name() {
        String str = this.pdf_name;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pdf_name");
        return null;
    }

    public final void setPdf_name(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pdf_name = str;
    }

    public final String getPdf_id() {
        return this.pdf_id;
    }

    public final void setPdf_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pdf_id = str;
    }

    public final String getCourse_id() {
        return this.course_id;
    }

    public final void setCourse_id(String str) {
        this.course_id = str;
    }

    public final ProgressDialog getMProgressDialog() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            return progressDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mProgressDialog");
        return null;
    }

    public final void setMProgressDialog(ProgressDialog progressDialog) {
        Intrinsics.checkNotNullParameter(progressDialog, "<set-?>");
        this.mProgressDialog = progressDialog;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        super.onCreate(savedInstanceState);
        ActivityPdfviewerJsBinding activityPdfviewerJsBindingInflate = ActivityPdfviewerJsBinding.inflate(getLayoutInflater());
        this.binding = activityPdfviewerJsBindingInflate;
        if (activityPdfviewerJsBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPdfviewerJsBindingInflate = null;
        }
        setContentView(activityPdfviewerJsBindingInflate.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new OnApplyWindowInsetsListener() { // from class: com.appnew.android.PDFViewerJS.PDFViewerJS$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return PDFViewerJS.onCreate$lambda$0(view, windowInsetsCompat);
            }
        });
        setMProgressDialog(new ProgressDialog(this));
        getMProgressDialog().setMessage("Download Pdf");
        getMProgressDialog().setIndeterminate(true);
        getMProgressDialog().setProgressStyle(1);
        getMProgressDialog().setCancelable(false);
        setDownload_btn((Button) findViewById(R.id.procceed_btn));
        setShareFloatingActionButton((FloatingActionButton) findViewById(R.id.shareFloatingActionButton));
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            setToolbarTitleTV((TextView) findViewById(R.id.toolbarTitleTV));
            this.main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            getToolbarTitleTV().setSelected(true);
            setImage_back((ImageView) findViewById(R.id.image_back));
            getImage_back().setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.PDFViewerJS.PDFViewerJS$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PDFViewerJS.onCreate$lambda$1(this.f$0);
                }
            }));
            if (getIntent().getStringExtra("file_type") == null) {
                stringExtra = "";
            } else {
                stringExtra = getIntent().getStringExtra("file_type");
                Intrinsics.checkNotNull(stringExtra);
            }
            this.file_type = stringExtra;
            getToolbarTitleTV().setText(getIntent().getStringExtra("type"));
            this.video_id = String.valueOf(getIntent().getStringExtra("course_id"));
            setLink(String.valueOf(getIntent().getStringExtra("url")));
            setPdf_name(String.valueOf(getIntent().getStringExtra("pdf_name")));
            this.pdf_id = String.valueOf(getIntent().getStringExtra("title"));
            if (getIntent().getStringExtra("mode") != null) {
                this.mode = String.valueOf(getIntent().getStringExtra("mode"));
            }
            getToolbarTitleTV().setText(getPdf_name());
            if (StringsKt.equals(this.mode, OfflineMessageRequest.ELEMENT, true)) {
                getDownload_btn().setVisibility(8);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        viewPdf();
        checkPdf(this.pdf_id);
        getDownload_btn().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PDFViewerJS.PDFViewerJS$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PDFViewerJS.onCreate$lambda$3(this.f$0, view);
            }
        });
        getShareFloatingActionButton().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PDFViewerJS.PDFViewerJS$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.sharePdf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$0(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(PDFViewerJS pDFViewerJS) {
        pDFViewerJS.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(final PDFViewerJS pDFViewerJS, View view) {
        PDFViewerJS pDFViewerJS2 = pDFViewerJS;
        if (Helper.isNetworkConnected(pDFViewerJS2)) {
            if (pDFViewerJS.getDownload_btn().getText().equals("View PDF")) {
                pDFViewerJS.mode = OfflineMessageRequest.ELEMENT;
                pDFViewerJS.setIntent(new Intent(pDFViewerJS2, (Class<?>) DownloadActivity.class));
                pDFViewerJS.getIntent().putExtra("mode", pDFViewerJS.mode);
                pDFViewerJS.startActivity(pDFViewerJS.getIntent());
                return;
            }
            if (pDFViewerJS.getFileExist().exists()) {
                String str = pDFViewerJS.pdf_id + ".pdf";
                if (StringsKt.equals(SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS), "1", true)) {
                    new File(pDFViewerJS.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str).delete();
                } else {
                    new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str).delete();
                }
            } else {
                Log.e("SATYA", "onCreate: Inside else");
            }
            final DownloadTask downloadTask = new DownloadTask(pDFViewerJS, pDFViewerJS2);
            downloadTask.execute(pDFViewerJS.getLink());
            pDFViewerJS.getDownload_btn().setClickable(false);
            pDFViewerJS.getMProgressDialog().setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.PDFViewerJS.PDFViewerJS$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    PDFViewerJS.onCreate$lambda$3$lambda$2(this.f$0, downloadTask, dialogInterface);
                }
            });
            return;
        }
        Toast.makeText(pDFViewerJS2, pDFViewerJS.getResources().getString(R.string.no_internet_connection), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$2(PDFViewerJS pDFViewerJS, DownloadTask downloadTask, DialogInterface dialogInterface) {
        pDFViewerJS.getDownload_btn().setClickable(true);
        downloadTask.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sharePdf() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.pdf_id);
        if (file.exists()) {
            Uri uriForFile = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("application/pdf");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            intent.addFlags(1);
            intent.setPackage("com.whatsapp");
            try {
                startActivity(Intent.createChooser(intent, "Share PDF using"));
            } catch (ActivityNotFoundException unused) {
            }
        }
    }

    private final void viewPdf() {
        String.valueOf(Log.e("URL.Js", getLink()));
        ActivityPdfviewerJsBinding activityPdfviewerJsBinding = this.binding;
        if (activityPdfviewerJsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPdfviewerJsBinding = null;
        }
        WebView webView = activityPdfviewerJsBinding.webView;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.setWebViewClient(new WebViewClient());
        if (Intrinsics.areEqual(this.mode, "online")) {
            loadPdfWithJumpToPage$default(this, getLink(), null, null, 6, null);
        } else {
            getShareFloatingActionButton().setVisibility(0);
            getFileExist(getLink());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkPdf(String pdfId) {
        if (this.mode.equals("online") && UtkashRoom.getAppDatabase(this).getPDFDataDao().pdfData(this.pdf_id)) {
            getDownload_btn().setText("View PDF");
            getShareFloatingActionButton().setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: PDFViewerJS.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J%\u0010\n\u001a\u00020\t2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\f\"\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0014J'\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\f\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/appnew/android/PDFViewerJS/PDFViewerJS$DownloadTask;", "Landroid/os/AsyncTask;", "", "", "context", "Landroid/content/Context;", "<init>", "(Lcom/appnew/android/PDFViewerJS/PDFViewerJS;Landroid/content/Context;)V", "onPreExecute", "", "onProgressUpdate", "values", "", "([Ljava/lang/Integer;)V", "onPostExecute", "result", "doInBackground", NativeProtocol.WEB_DIALOG_PARAMS, "([Ljava/lang/String;)Ljava/lang/String;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DownloadTask extends AsyncTask<String, Integer, String> {
        private final Context context;
        final /* synthetic */ PDFViewerJS this$0;

        public DownloadTask(PDFViewerJS pDFViewerJS, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = pDFViewerJS;
            this.context = context;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.this$0.getMProgressDialog().show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... values) {
            Intrinsics.checkNotNullParameter(values, "values");
            super.onProgressUpdate(Arrays.copyOf(values, values.length));
            this.this$0.getMProgressDialog().setIndeterminate(false);
            this.this$0.getMProgressDialog().setMax(100);
            this.this$0.getMProgressDialog().setProgress(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            this.this$0.getDownload_btn().setClickable(true);
            this.this$0.getMProgressDialog().dismiss();
            if (result != null) {
                Toast.makeText(this.context, this.this$0.getResources().getString(R.string.download_error) + result, 1).show();
                return;
            }
            PDFViewerJS pDFViewerJS = this.this$0;
            pDFViewerJS.checkPdf(pDFViewerJS.getPdf_id());
            if (this.this$0.getIntent().hasExtra("cat_type") && StringsKt.equals(this.this$0.getIntent().getStringExtra("cat_type"), "3", true)) {
                Toast.makeText(this.context, "Your admit card has been downloaded successfully.", 0).show();
            } else {
                Toast.makeText(this.context, this.this$0.getResources().getString(R.string.file_downloaded), 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0154, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0157, code lost:
        
            r5.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x015a, code lost:
        
            if (r2 == 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x015c, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x015f, code lost:
        
            r21.this$0.getDownload_btn().setClickable(true);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:100:0x021d  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x01f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:135:0x01a4 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:136:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x014e A[Catch: all -> 0x01bc, Exception -> 0x01c3, TRY_LEAVE, TryCatch #16 {Exception -> 0x01c3, all -> 0x01bc, blocks: (B:27:0x013c, B:28:0x0145, B:30:0x014e, B:43:0x0174, B:45:0x017a), top: B:133:0x013c }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01f5 A[Catch: IOException -> 0x0201, TryCatch #15 {IOException -> 0x0201, blocks: (B:86:0x01f0, B:88:0x01f5, B:89:0x01f8), top: B:116:0x01f0 }] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0203  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x020f A[Catch: IOException -> 0x021b, TryCatch #20 {IOException -> 0x021b, blocks: (B:95:0x020a, B:97:0x020f, B:98:0x0212), top: B:118:0x020a }] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v16, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v9 */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r22) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 545
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.PDFViewerJS.PDFViewerJS.DownloadTask.doInBackground(java.lang.String[]):java.lang.String");
        }
    }

    public final File getFileExist(String fileName) {
        PDFViewerJS pDFViewerJS;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String str = this.pdf_id + ".pdf";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(Uri.fromFile(new File(file, this.pdf_id)));
            byte[] bytes = inputStreamOpenInputStream != null ? ByteStreamsKt.readBytes(inputStreamOpenInputStream) : null;
            if (bytes != null) {
                pDFViewerJS = this;
                try {
                    loadPdfWithJumpToPage$default(pDFViewerJS, "data:application/pdf;base64," + Base64.encodeToString(bytes, 2), null, null, 6, null);
                } catch (Exception e2) {
                    e = e2;
                    Toast.makeText(pDFViewerJS, e.toString(), 0).show();
                    finish();
                }
            }
        } catch (Exception e3) {
            e = e3;
            pDFViewerJS = this;
        }
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS), "1", true)) {
            return new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str);
        }
        return new File(file + str);
    }

    public final File getFileExist() {
        String str = this.pdf_id + ".pdf";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS), "1", true)) {
            return new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str);
        }
        return new File(file + str);
    }

    static /* synthetic */ ActivityPdfviewerJsBinding loadPdfWithJumpToPage$default(PDFViewerJS pDFViewerJS, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "#2545fc";
        }
        if ((i & 4) != 0) {
            str3 = "#FFFFFF";
        }
        return pDFViewerJS.loadPdfWithJumpToPage(str, str2, str3);
    }

    private final ActivityPdfviewerJsBinding loadPdfWithJumpToPage(String pdfUrl, String buttonColor, String textColor) {
        ActivityPdfviewerJsBinding activityPdfviewerJsBinding = this.binding;
        if (activityPdfviewerJsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPdfviewerJsBinding = null;
        }
        activityPdfviewerJsBinding.webView.loadDataWithBaseURL(null, StringsKt.trimIndent("\n    <html>\n    <head>\n        <title>PDF Viewer</title>\n        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdf.js/2.10.377/pdf.min.js\"></script>\n        <style>\n            body { margin: 0; padding: 0; background-color: #f4f4f4; }\n            #controls {\n                position: fixed; \n                top: 10px; \n                left: 10px; \n                right: 10px; \n                z-index: 10; \n                display: flex; \n                gap: 10px; \n                background: rgba(255, 255, 255, 0.8); \n                padding: 5px; \n                border-radius: 10px; \n                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2); \n                height: 40px; \n                align-items: center; \n            }\n            #zoom-container {\n                width: 100%; \n                max-width: 800px; / Set a max width for better layout /\n                overflow: hidden; / Prevents overflow due to scaling /\n                transition: transform 0.2s; / Smooth zoom effect /\n            }\n            #pdf-container { \n                overflow: auto; \n                height: calc(100vh - 70px); \n                display: flex; \n                flex-direction: column;\n                align-items: center; \n                margin-top: 70px; \n                padding: 10px; \n            }\n            .pdf-page {\n                width: 100%; \n                max-width: 800px; / Set a max width for better layout /\n                display: flex; \n                flex-direction: column;\n                justify-content: center;\n                padding: 10px; \n                margin: 5px 0; \n                background: white; \n                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);\n                border-radius: 8px;\n                position: relative; \n            }\n            canvas { \n                width: 100%; \n                height: auto; \n            }\n            .page-number {\n                text-align: center; \n                margin-top: 10px; \n                font-size: 14px; \n                color: #555; \n                position: relative; \n            }\n            #page-count {\n                font-size: 16px; \n            }\n            #page-number {\n                width: 130px; \n                padding: 10px; \n                font-size: 16px; \n                border: 1px solid #007bff; \n                border-radius: 5px; \n                outline: none; \n                transition: border-color 0.3s;\n            }\n            #page-number:focus {\n                border-color: #0056b3; \n            }\n            #jump-button {\n                padding: 10px 26px; \n                font-size: 16px; \n                background-color: #007bff; \n                border: none; \n                color: white; \n                border-radius: 5px; \n                cursor: pointer; \n                white-space: nowrap; \n                transition: background-color 0.3s, transform 0.3s;\n            }\n            #jump-button:hover {\n                background-color: #0056b3; \n                transform: scale(1.05); \n            }\n            #loading {\n                position: fixed;\n                top: 50%;\n                left: 50%;\n                transform: translate(-50%, -50%);\n                display: none;\n                z-index: 100;\n            }\n            .spinner {\n                border: 4px solid rgba(0, 0, 0, 0.1);\n                border-left-color: #007bff;\n                border-radius: 50%;\n                width: 40px;\n                height: 40px;\n                animation: spin 1s linear infinite;\n            }\n            @keyframes spin {\n                to {\n                    transform: rotate(360deg);\n                }\n            }\n        </style>\n    </head>\n    <body>\n    <div id=\"getTime\"></div>\n        <div id=\"loading\">\n            <div class=\"spinner\"></div>\n        </div>\n        <div id=\"controls\">\n            <div id=\"total-pages\">Total Pages: <span id=\"page-count\">0</span></div>\n            <input type=\"number\" id=\"page-number\" min=\"1\" placeholder=\"Page number\" />\n            <button id=\"jump-button\">Jump to Page</button>\n        </div>\n        <div id=\"zoom-container\">\n            <div id=\"pdf-container\"></div>\n        </div>\n        <script>\n           const url = '" + pdfUrl + "';\nconst buttonColor = '" + buttonColor + "'; \nconst textColor = '" + textColor + "'; \nlet pdfDoc = null;\nlet currentScale = 1.0; \nconst pdfContainer = document.getElementById('pdf-container');\nconst zoomContainer = document.getElementById('zoom-container');\nconst canvases = []; \nlet loadedPages = 0; // Track loaded pages\nconst pagesPerLoad = 5; // Number of pages to load at once\nlet cTime = 0;\nsetInterval(() => {\n    document.getElementById('getTime').innerText = cTime++;\n}, 1000);\n\n\n\n\nconst renderPage = (num) => {\n    return pdfDoc.getPage(num).then(page => {\n        const viewport = page.getViewport({ scale: 1 });\n        const pageDiv = document.createElement('div');\n        pageDiv.className = 'pdf-page';\n        const canvas = document.createElement('canvas');\n        const context = canvas.getContext('2d');\n        canvas.height = viewport.height;\n        canvas.width = viewport.width;\n\n        canvases[num - 1] = { canvas, originalWidth: viewport.width, originalHeight: viewport.height };\n\n        const renderContext = {\n            canvasContext: context,\n            viewport: viewport\n        };\n\n        return page.render(renderContext).promise.then(() => {\n            pageDiv.appendChild(canvas);\n            \n            // Add page number at the bottom\n            const pageNumberDiv = document.createElement('div');\n            pageNumberDiv.className = 'page-number';\n            pageNumberDiv.innerText = 'Page ' + num;\n            pageDiv.appendChild(pageNumberDiv);\n            \n            pdfContainer.appendChild(pageDiv);\n            fitToScreen(canvas);\n        });\n    });\n};\n\nconst loadPDF = (url) => {\n    // Show loading spinner\n    document.getElementById('loading').style.display = 'block';\n\n    pdfjsLib.getDocument(url).promise\n        .then(pdf => {\n            pdfDoc = pdf;\n            const numPages = pdf.numPages;\n            document.getElementById('page-number').max = numPages;\n            document.getElementById('page-count').innerText = numPages;\n            loadPagesInOrder(1, pagesPerLoad); // Load initial 5 pages\n        })\n        .catch(err => {\n            console.error('Error loading PDF: ', err);\n            alert('Failed to load PDF. Please check the URL or try again.');\n        })\n        .finally(() => {\n            // Hide loading spinner\n            document.getElementById('loading').style.display = 'none';\n        });\n};\n\nconst loadPagesInOrder = (startPage, numPages) => {\n    const endPage = Math.min(startPage + numPages - 1, pdfDoc.numPages);\n    for (let i = startPage; i <= endPage; i++) {\n        renderPage(i);\n    }\n    loadedPages += numPages; // Update loaded pages count\n};\n\npdfContainer.addEventListener('scroll', () => {\n    const scrollTop = pdfContainer.scrollTop;\n    const containerHeight = pdfContainer.clientHeight;\n    const scrollHeight = pdfContainer.scrollHeight;\n\n    // Load next set of pages if scrolled to bottom\n    if (scrollTop + containerHeight >= scrollHeight - 20 && loadedPages < pdfDoc.numPages) {\n        loadPagesInOrder(loadedPages + 1, pagesPerLoad); // Load next 5 pages\n    }\n});\n\ndocument.getElementById('jump-button').addEventListener('click', () => {\n    const pageNum = parseInt(document.getElementById('page-number').value);\n    if (pageNum < 1 || pageNum > pdfDoc.numPages) {\n        alert('Please enter a valid page number (1 - ' + pdfDoc.numPages + ').');\n        return; \n    }\n    const targetPage = canvases[pageNum - 1].canvas; \n    targetPage.scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });\n});\n\nconst fitToScreen = (canvas) => {\n    const containerWidth = pdfContainer.clientWidth;\n    const originalWidth = canvas.width;\n    currentScale = containerWidth / originalWidth;\n    canvas.style.width = \"100%\"; // Set canvas width to 100%\n    canvas.style.height = 'auto'; \n};\n\nconst setButtonStyles = (bgColor, txtColor) => {\n    const button = document.getElementById('jump-button');\n    button.style.backgroundColor = bgColor;\n    button.style.color = txtColor; \n};\n\nsetButtonStyles(buttonColor, textColor);\n\nlet startDistance = 0;\nlet initialScale = 1.0;\n\npdfContainer.addEventListener('touchstart', (event) => {\n    if (event.touches.length === 2) {\n        startDistance = Math.hypot(\n            event.touches[0].clientX - event.touches[1].clientX,\n            event.touches[0].clientY - event.touches[1].clientY\n        );\n        initialScale = currentScale; \n    }\n});\n\npdfContainer.addEventListener('touchmove', (event) => {\n    if (event.touches.length === 2) {\n        event.preventDefault(); \n        const currentDistance = Math.hypot(\n            event.touches[0].clientX - event.touches[1].clientX,\n            event.touches[0].clientY - event.touches[1].clientY\n        );\n        const scaleChange = currentDistance / startDistance;\n        let newScale = initialScale * scaleChange;\n\n        // Ensure new scale does not go below 1 (100%)\n        newScale = Math.max(newScale, 1);\n\n        zoomContainer.style.transform = \"scale(\" + newScale + \")\"; // Set the scale\n    }\n});\n\n// Keyboard navigation\ndocument.addEventListener('keydown', (event) => {\n    if (event.key === 'ArrowRight') {\n        jumpToPage(loadedPages + 1); // Jump to the next page\n    } else if (event.key === 'ArrowLeft') {\n        jumpToPage(loadedPages - 1); // Jump to the previous page\n    }\n});\n\nconst jumpToPage = (pageNum) => {\n    if (pageNum >= 1 && pageNum <= pdfDoc.numPages) {\n        document.getElementById('page-number').value = pageNum;\n        const targetPage = canvases[pageNum - 1]?.canvas;\n        if (targetPage) {\n            targetPage.scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });\n        }\n    }\n};\n\nloadPDF(url);\n\n        </script>\n    </body>\n    </html>\n"), Mimetypes.MIMETYPE_HTML, "UTF-8", null);
        return activityPdfviewerJsBinding;
    }

    public final void openChooser() {
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("application/pdf");
            Intent intentCreateChooser = Intent.createChooser(intent, "Select PDF");
            Intrinsics.checkNotNullExpressionValue(intentCreateChooser, "createChooser(...)");
            startActivityForResult(intentCreateChooser, 101);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) throws FileNotFoundException {
        Uri data2;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 101 || resultCode != -1 || data == null || (data2 = data.getData()) == null) {
            return;
        }
        System.out.println((Object) data2.toString());
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(data2);
        byte[] bytes = inputStreamOpenInputStream != null ? ByteStreamsKt.readBytes(inputStreamOpenInputStream) : null;
        if (bytes != null) {
            loadPdfWithJumpToPage$default(this, "data:application/pdf;base64," + Base64.encodeToString(bytes, 2), null, null, 6, null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
