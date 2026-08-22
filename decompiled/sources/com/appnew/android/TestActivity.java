package com.appnew.android;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TestActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/appnew/android/TestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "pdfView", "Lcom/github/barteksc/pdfviewer/PDFView;", "getPdfView", "()Lcom/github/barteksc/pdfviewer/PDFView;", "setPdfView", "(Lcom/github/barteksc/pdfviewer/PDFView;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TestActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public PDFView pdfView;

    public final PDFView getPdfView() {
        PDFView pDFView = this.pdfView;
        if (pDFView != null) {
            return pDFView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pdfView");
        return null;
    }

    public final void setPdfView(PDFView pDFView) {
        Intrinsics.checkNotNullParameter(pDFView, "<set-?>");
        this.pdfView = pDFView;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable$default(this, null, null, 3, null);
        setContentView(com.eduteria.app.app.R.layout.activity_test);
        setPdfView((PDFView) findViewById(com.eduteria.app.app.R.id.pdfView));
    }
}
