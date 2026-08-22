package com.appnew.android.NewResult.Fragment;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.mikephil.charting.charts.Chart;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DemoBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J+\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0004J\u001c\u0010$\u001a\u00020\u00172\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010'\u001a\u00020\u0007H\u0004J\b\u0010$\u001a\u00020\u0017H$R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0084\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0084\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006)"}, d2 = {"Lcom/appnew/android/NewResult/Fragment/DemoBase;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback;", "<init>", "()V", "months", "", "", "getMonths", "()[Ljava/lang/String;", "[Ljava/lang/String;", "parties", "getParties", "tfRegular", "Landroid/graphics/Typeface;", "getTfRegular", "()Landroid/graphics/Typeface;", "setTfRegular", "(Landroid/graphics/Typeface;)V", "tfLight", "getTfLight", "setTfLight", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestStoragePermission", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "saveToGallery", "chart", "Lcom/github/mikephil/charting/charts/Chart;", "name", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DemoBase extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final int PERMISSION_STORAGE = 0;
    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"};
    private final String[] parties = {"Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H", "Party I", "Party J", "Party K"};
    private Typeface tfLight;
    private Typeface tfRegular;
    public static final int $stable = 8;

    protected abstract void saveToGallery();

    protected final String[] getMonths() {
        return this.months;
    }

    protected final String[] getParties() {
        return this.parties;
    }

    protected final Typeface getTfRegular() {
        return this.tfRegular;
    }

    protected final void setTfRegular(Typeface typeface) {
        this.tfRegular = typeface;
    }

    protected final Typeface getTfLight() {
        return this.tfLight;
    }

    protected final void setTfLight(Typeface typeface) {
        this.tfLight = typeface;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.tfRegular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        this.tfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (grantResults.length == 1 && grantResults[0] == 0) {
                saveToGallery();
            } else {
                Toast.makeText(this, "Saving FAILED!", 0).show();
            }
        }
    }

    protected final void requestStoragePermission(View view) {
        DemoBase demoBase = this;
        if (ActivityCompat.shouldShowRequestPermissionRationale(demoBase, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Intrinsics.checkNotNull(view);
            Snackbar.make(view, "Write permission is required to save image to gallery", -2).setAction("OK", new View.OnClickListener() { // from class: com.appnew.android.NewResult.Fragment.DemoBase$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DemoBase.requestStoragePermission$lambda$0(view2);
                }
            }).show();
        } else {
            Toast.makeText(getApplicationContext(), "Permission Required!", 0).show();
            ActivityCompat.requestPermissions(demoBase, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestStoragePermission$lambda$0(View view) {
        ActivityCompat.requestPermissions(new Activity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
    }

    protected final void saveToGallery(Chart<?> chart, String name) {
        Intrinsics.checkNotNullParameter(chart, "chart");
        Intrinsics.checkNotNullParameter(name, "name");
        if (chart.saveToGallery(name + "_" + System.currentTimeMillis(), 70)) {
            Toast.makeText(this, "Saving SUCCESSFUL!", 0).show();
        } else {
            Toast.makeText(this, "Saving FAILED!", 0).show();
        }
    }
}
