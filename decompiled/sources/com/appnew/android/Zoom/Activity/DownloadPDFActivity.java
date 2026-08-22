package com.appnew.android.Zoom.Activity;

import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Zoom.Adapter.PDFAdapter;
import com.appnew.android.databinding.ActivityDownloadPdfactivityBinding;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: DownloadPDFActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/appnew/android/Zoom/Activity/DownloadPDFActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityDownloadPdfactivityBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityDownloadPdfactivityBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityDownloadPdfactivityBinding;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "pdfAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/PDFAdapter$ViewHolder;", "fileList", "Ljava/util/ArrayList;", "Ljava/io/File;", "Lkotlin/collections/ArrayList;", "getFileList", "()Ljava/util/ArrayList;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getFileExist", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadPDFActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public ActivityDownloadPdfactivityBinding binding;
    private final ArrayList<File> fileList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter<PDFAdapter.ViewHolder> pdfAdapter;

    public final ActivityDownloadPdfactivityBinding getBinding() {
        ActivityDownloadPdfactivityBinding activityDownloadPdfactivityBinding = this.binding;
        if (activityDownloadPdfactivityBinding != null) {
            return activityDownloadPdfactivityBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityDownloadPdfactivityBinding activityDownloadPdfactivityBinding) {
        Intrinsics.checkNotNullParameter(activityDownloadPdfactivityBinding, "<set-?>");
        this.binding = activityDownloadPdfactivityBinding;
    }

    public final ArrayList<File> getFileList() {
        return this.fileList;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DownloadPDFActivity downloadPDFActivity = this;
        Helper.setSystemBarLight(downloadPDFActivity);
        setBinding(ActivityDownloadPdfactivityBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(downloadPDFActivity);
        getBinding().downloadImageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.DownloadPDFActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DownloadPDFActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        Object fileExist = getFileExist();
        Intrinsics.checkNotNull(fileExist, "null cannot be cast to non-null type java.io.File");
        if (((File) fileExist).exists()) {
            File file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR);
            File[] fileArrListFiles = file.listFiles();
            if (file.list().length > 0) {
                int length = fileArrListFiles.length;
                for (int i = 0; i < length; i++) {
                    String name = fileArrListFiles[i].getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (StringsKt.endsWith$default(name, ".pdf", false, 2, (Object) null)) {
                        this.fileList.add(fileArrListFiles[i]);
                    }
                }
            }
        }
        if (this.fileList.size() > 0) {
            getBinding().noDataFoundRL.setVisibility(8);
            DownloadPDFActivity downloadPDFActivity2 = this;
            this.layoutManager = new LinearLayoutManager(downloadPDFActivity2);
            getBinding().pdfListRecycler.setLayoutManager(this.layoutManager);
            this.pdfAdapter = new PDFAdapter(this.fileList, downloadPDFActivity2);
            getBinding().pdfListRecycler.setAdapter(this.pdfAdapter);
            return;
        }
        getBinding().noDataFoundRL.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(DownloadPDFActivity downloadPDFActivity) {
        downloadPDFActivity.finish();
        return Unit.INSTANCE;
    }

    public final Object getFileExist() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (StringsKt.equals(BuildConfig.FLAVOR, "mahendra", true)) {
            return new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR);
        }
        return new File(file + "/.pdf");
    }
}
