package com.appnew.android;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Utils.Helper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PopupFormActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0005H\u0002J\"\u0010.\u001a\u00020(2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u000101H\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020103¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/appnew/android/PopupFormActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "REQUEST_CODE_CAMERA_Profile", "", "getREQUEST_CODE_CAMERA_Profile", "()I", "REQUEST_CODE_CAMERA_ADHAR", "getREQUEST_CODE_CAMERA_ADHAR", "REQUEST_CODE_Profile_Gallery", "getREQUEST_CODE_Profile_Gallery", "REQUEST_CODE_Aadhar_Gallery", "getREQUEST_CODE_Aadhar_Gallery", "img_btn", "Landroid/widget/Button;", "getImg_btn", "()Landroid/widget/Button;", "setImg_btn", "(Landroid/widget/Button;)V", "img_adhr_btn", "getImg_adhr_btn", "setImg_adhr_btn", "profileIV", "Landroid/widget/ImageView;", "getProfileIV", "()Landroid/widget/ImageView;", "setProfileIV", "(Landroid/widget/ImageView;)V", "adharIV", "getAdharIV", "setAdharIV", "requestCode", "getRequestCode", "setRequestCode", "(I)V", "btnOpenDialog", "getBtnOpenDialog", "setBtnOpenDialog", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openDialog", "imgClick", "status", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "otpLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "getOtpLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupFormActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private ImageView adharIV;
    public Button btnOpenDialog;
    private Button img_adhr_btn;
    private Button img_btn;
    private ImageView profileIV;
    private final int REQUEST_CODE_CAMERA_Profile = 200;
    private final int REQUEST_CODE_CAMERA_ADHAR = 201;
    private final int REQUEST_CODE_Profile_Gallery = 100;
    private final int REQUEST_CODE_Aadhar_Gallery = 101;
    private int requestCode = -1;
    private final ActivityResultLauncher<Intent> otpLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.PopupFormActivity$$ExternalSyntheticLambda5
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            PopupFormActivity.otpLauncher$lambda$6(this.f$0, (ActivityResult) obj);
        }
    });

    public final int getREQUEST_CODE_CAMERA_Profile() {
        return this.REQUEST_CODE_CAMERA_Profile;
    }

    public final int getREQUEST_CODE_CAMERA_ADHAR() {
        return this.REQUEST_CODE_CAMERA_ADHAR;
    }

    public final int getREQUEST_CODE_Profile_Gallery() {
        return this.REQUEST_CODE_Profile_Gallery;
    }

    public final int getREQUEST_CODE_Aadhar_Gallery() {
        return this.REQUEST_CODE_Aadhar_Gallery;
    }

    public final Button getImg_btn() {
        return this.img_btn;
    }

    public final void setImg_btn(Button button) {
        this.img_btn = button;
    }

    public final Button getImg_adhr_btn() {
        return this.img_adhr_btn;
    }

    public final void setImg_adhr_btn(Button button) {
        this.img_adhr_btn = button;
    }

    public final ImageView getProfileIV() {
        return this.profileIV;
    }

    public final void setProfileIV(ImageView imageView) {
        this.profileIV = imageView;
    }

    public final ImageView getAdharIV() {
        return this.adharIV;
    }

    public final void setAdharIV(ImageView imageView) {
        this.adharIV = imageView;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(int i) {
        this.requestCode = i;
    }

    public final Button getBtnOpenDialog() {
        Button button = this.btnOpenDialog;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnOpenDialog");
        return null;
    }

    public final void setBtnOpenDialog(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.btnOpenDialog = button;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PopupFormActivity popupFormActivity = this;
        Helper.setSystemBarLight(popupFormActivity);
        setContentView(com.eduteria.app.app.R.layout.activity_popup_form);
        Helper.enableScreenShot(popupFormActivity);
        setBtnOpenDialog((Button) findViewById(com.eduteria.app.app.R.id.btnOpenDialog));
        getBtnOpenDialog().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PopupFormActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.openDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openDialog() {
        final Dialog dialog = new Dialog(this, android.R.style.Theme.Light);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(com.eduteria.app.app.R.layout.dialog_form);
        this.adharIV = (ImageView) dialog.findViewById(com.eduteria.app.app.R.id.adharIV);
        this.profileIV = (ImageView) dialog.findViewById(com.eduteria.app.app.R.id.profileIV);
        this.img_btn = (Button) dialog.findViewById(com.eduteria.app.app.R.id.img_btn);
        this.img_adhr_btn = (Button) dialog.findViewById(com.eduteria.app.app.R.id.img_adhr_btn);
        View viewFindViewById = dialog.findViewById(com.eduteria.app.app.R.id.cancel_button);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) viewFindViewById).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PopupFormActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        Button button = this.img_btn;
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PopupFormActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.imgClick(1);
            }
        });
        Button button2 = this.img_adhr_btn;
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PopupFormActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.imgClick(0);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void imgClick(final int status) {
        if (Integer.valueOf(status).equals(1)) {
            this.otpLauncher.launch(new Intent("android.media.action.IMAGE_CAPTURE"));
            this.requestCode = this.REQUEST_CODE_CAMERA_Profile;
            return;
        }
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(com.eduteria.app.app.R.string.add_photo));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.PopupFormActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PopupFormActivity.imgClick$lambda$4(charSequenceArr, status, this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imgClick$lambda$4(CharSequence[] charSequenceArr, int i, PopupFormActivity popupFormActivity, DialogInterface dialogInterface, int i2) {
        if (Intrinsics.areEqual(charSequenceArr[i2], "Take Photo")) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                if (Integer.valueOf(i).equals(1)) {
                    popupFormActivity.otpLauncher.launch(intent);
                    popupFormActivity.requestCode = popupFormActivity.REQUEST_CODE_CAMERA_Profile;
                    return;
                } else {
                    popupFormActivity.otpLauncher.launch(intent);
                    popupFormActivity.requestCode = popupFormActivity.REQUEST_CODE_CAMERA_ADHAR;
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (Intrinsics.areEqual(charSequenceArr[i2], "Choose from Gallery")) {
            Intent intent2 = new Intent("android.intent.action.PICK");
            intent2.setType("image/*");
            if (Integer.valueOf(i).equals(1)) {
                popupFormActivity.otpLauncher.launch(intent2);
                popupFormActivity.requestCode = popupFormActivity.REQUEST_CODE_Profile_Gallery;
                return;
            } else {
                popupFormActivity.otpLauncher.launch(intent2);
                popupFormActivity.requestCode = popupFormActivity.REQUEST_CODE_Aadhar_Gallery;
                return;
            }
        }
        if (Intrinsics.areEqual(charSequenceArr[i2], "Cancel")) {
            dialogInterface.dismiss();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == this.REQUEST_CODE_Profile_Gallery) {
            ImageView imageView = this.profileIV;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(0);
            ImageView imageView2 = this.profileIV;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageURI(data != null ? data.getData() : null);
        }
        if (resultCode == -1 && requestCode == this.REQUEST_CODE_Aadhar_Gallery) {
            ImageView imageView3 = this.adharIV;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setVisibility(0);
            ImageView imageView4 = this.adharIV;
            Intrinsics.checkNotNull(imageView4);
            imageView4.setImageURI(data != null ? data.getData() : null);
        }
        if (resultCode == -1 && requestCode == this.REQUEST_CODE_CAMERA_Profile && data != null) {
            ImageView imageView5 = this.profileIV;
            Intrinsics.checkNotNull(imageView5);
            imageView5.setVisibility(0);
            ImageView imageView6 = this.profileIV;
            Intrinsics.checkNotNull(imageView6);
            Bundle extras = data.getExtras();
            Intrinsics.checkNotNull(extras);
            Object obj = extras.get("data");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Bitmap");
            imageView6.setImageBitmap((Bitmap) obj);
        }
        if (resultCode == -1 && requestCode == this.REQUEST_CODE_CAMERA_ADHAR && data != null) {
            ImageView imageView7 = this.adharIV;
            Intrinsics.checkNotNull(imageView7);
            imageView7.setVisibility(0);
            ImageView imageView8 = this.adharIV;
            Intrinsics.checkNotNull(imageView8);
            Bundle extras2 = data.getExtras();
            Intrinsics.checkNotNull(extras2);
            Object obj2 = extras2.get("data");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.graphics.Bitmap");
            imageView8.setImageBitmap((Bitmap) obj2);
        }
    }

    public final ActivityResultLauncher<Intent> getOtpLauncher() {
        return this.otpLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void otpLauncher$lambda$6(PopupFormActivity popupFormActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() != -1 || it.getData() == null) {
            return;
        }
        if (it.getResultCode() == -1 && popupFormActivity.requestCode == popupFormActivity.REQUEST_CODE_Profile_Gallery) {
            ImageView imageView = popupFormActivity.profileIV;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(0);
            ImageView imageView2 = popupFormActivity.profileIV;
            Intrinsics.checkNotNull(imageView2);
            Intent data = it.getData();
            Intrinsics.checkNotNull(data);
            imageView2.setImageURI(data.getData());
        }
        if (it.getResultCode() == -1 && popupFormActivity.requestCode == popupFormActivity.REQUEST_CODE_Aadhar_Gallery) {
            ImageView imageView3 = popupFormActivity.adharIV;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setVisibility(0);
            ImageView imageView4 = popupFormActivity.adharIV;
            Intrinsics.checkNotNull(imageView4);
            Intent data2 = it.getData();
            Intrinsics.checkNotNull(data2);
            imageView4.setImageURI(data2.getData());
        }
        if (it.getResultCode() == -1 && popupFormActivity.requestCode == popupFormActivity.REQUEST_CODE_CAMERA_Profile && it.getData() != null) {
            ImageView imageView5 = popupFormActivity.profileIV;
            Intrinsics.checkNotNull(imageView5);
            imageView5.setVisibility(0);
            ImageView imageView6 = popupFormActivity.profileIV;
            Intrinsics.checkNotNull(imageView6);
            Intent data3 = it.getData();
            Intrinsics.checkNotNull(data3);
            Bundle extras = data3.getExtras();
            Intrinsics.checkNotNull(extras);
            Object obj = extras.get("data");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Bitmap");
            imageView6.setImageBitmap((Bitmap) obj);
        }
        if (it.getResultCode() == -1 && popupFormActivity.requestCode == popupFormActivity.REQUEST_CODE_CAMERA_ADHAR && it.getData() != null) {
            ImageView imageView7 = popupFormActivity.adharIV;
            Intrinsics.checkNotNull(imageView7);
            imageView7.setVisibility(0);
            ImageView imageView8 = popupFormActivity.adharIV;
            Intrinsics.checkNotNull(imageView8);
            Intent data4 = it.getData();
            Intrinsics.checkNotNull(data4);
            Bundle extras2 = data4.getExtras();
            Intrinsics.checkNotNull(extras2);
            Object obj2 = extras2.get("data");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.graphics.Bitmap");
            imageView8.setImageBitmap((Bitmap) obj2);
        }
    }
}
