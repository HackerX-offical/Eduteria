package com.appnew.android.Utils.imagecropper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.UtkarshFileProvider;
import com.eduteria.app.app.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

/* JADX INFO: loaded from: classes6.dex */
public class TakeImageClass {
    public static final int REQUEST_CODE_CROP_IMAGE = 3;
    public static final int REQUEST_CODE_GALLERY = 1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 2;
    public static final String TAG = "MainActivity";
    public static String TEMP_PHOTO_FILE_NAME = "";
    public static String sImagePath;
    public imagefromcropper imagecropInterface;
    private Activity mActivity;
    private File mFileTemp;
    private Uri mImageCaptureUri;

    public interface imagefromcropper {
        void imagePath(String str);
    }

    public TakeImageClass(Activity activity, imagefromcropper imagecropInterface) {
        this.imagecropInterface = imagecropInterface;
        this.mActivity = activity;
        String externalStorageState = Environment.getExternalStorageState();
        if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getId() != null) {
            TEMP_PHOTO_FILE_NAME = SharedPreference.getInstance().getLoggedInUser().getId() + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
        } else {
            TEMP_PHOTO_FILE_NAME = Calendar.getInstance().getTimeInMillis() + ".jpg";
        }
        sImagePath = null;
        if ("mounted".equals(externalStorageState)) {
            this.mFileTemp = new File(Environment.getExternalStorageDirectory(), TEMP_PHOTO_FILE_NAME);
        } else {
            this.mFileTemp = new File(activity.getFilesDir(), TEMP_PHOTO_FILE_NAME);
        }
    }

    public static void copyStream(InputStream input, OutputStream output) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = input.read(bArr);
            if (i == -1) {
                return;
            } else {
                output.write(bArr, 0, i);
            }
        }
    }

    private static Uri getUriForFile(Context context, File file) {
        try {
            context.getPackageName();
            return UtkarshFileProvider.getUriForFile(context, "com.utkarshnew.android.Utils.UtkarshFileProvider", file);
        } catch (IllegalArgumentException unused) {
            throw new SecurityException();
        }
    }

    public void takePicture() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            this.mImageCaptureUri = null;
            if ("mounted".equals(Environment.getExternalStorageState())) {
                Uri uriForFile = UtkarshFileProvider.getUriForFile(this.mActivity, "com.utkarshnew.android.Utils.UtkarshFileProvider", this.mFileTemp);
                this.mImageCaptureUri = uriForFile;
                intent.putExtra("output", uriForFile);
                intent.putExtra(CropImage.RETURN_DATA, true);
                intent.addFlags(1);
                Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent2.setData(UtkarshFileProvider.getUriForFile(this.mActivity, "com.utkarshnew.android.Utils.UtkarshFileProvider", this.mFileTemp));
                this.mActivity.sendBroadcast(intent2);
                return;
            }
            Toast.makeText(this.mActivity, "SD Card Is Not Available, can not capture the Image", 1).show();
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void takePictureForKitkat() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            this.mImageCaptureUri = null;
            if ("mounted".equals(Environment.getExternalStorageState())) {
                Uri uriForFile = getUriForFile(this.mActivity, this.mFileTemp);
                this.mImageCaptureUri = uriForFile;
                intent.putExtra("output", uriForFile);
                intent.putExtra(CropImage.RETURN_DATA, true);
                intent.addFlags(1);
                Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent2.setData(getUriForFile(this.mActivity, this.mFileTemp));
                this.mActivity.sendBroadcast(intent2);
                return;
            }
            Toast.makeText(this.mActivity, "SD Card Is Not Avialable Can Not Capture the Image", 1).show();
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void openGallery() {
        try {
            new Intent("android.intent.action.GET_CONTENT").setType("image/*");
        } catch (Exception unused) {
        }
    }

    private void startCropImage(int orientationInDegree) {
        Intent intent = new Intent(this.mActivity, (Class<?>) CropImage.class);
        intent.putExtra(CropImage.IMAGE_PATH, this.mFileTemp.getPath());
        intent.putExtra(CropImage.ASPECT_X, 300);
        intent.putExtra(CropImage.ASPECT_Y, 300);
        intent.putExtra(CropImage.SCALE, false);
        intent.putExtra(CropImage.ORIENTATION_IN_DEGREES, orientationInDegree);
    }

    private String getRealPathFromURI(Uri contentURI) {
        Cursor cursorQuery = this.mActivity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursorQuery == null) {
            return contentURI.getPath();
        }
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
        cursorQuery.close();
        return string;
    }

    public int getCameraPhotoOrientation(Context context) {
        try {
            File file = new File(this.mFileTemp.getPath());
            Uri uri = this.mImageCaptureUri;
            if (uri != null && !uri.getPath().isEmpty()) {
                context.getContentResolver().notifyChange(this.mImageCaptureUri, null);
            }
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String stringExtra;
        if (resultCode != -1) {
            return;
        }
        if (requestCode == 1) {
            try {
                InputStream inputStreamOpenInputStream = this.mActivity.getContentResolver().openInputStream(data.getData());
                FileOutputStream fileOutputStream = new FileOutputStream(this.mFileTemp);
                copyStream(inputStreamOpenInputStream, fileOutputStream);
                fileOutputStream.close();
                inputStreamOpenInputStream.close();
                startCropImage(0);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (requestCode == 2) {
            startCropImage(getCameraPhotoOrientation(this.mActivity));
        } else if (requestCode == 3 && (stringExtra = data.getStringExtra(CropImage.IMAGE_PATH)) != null) {
            sImagePath = this.mFileTemp.getPath();
            this.imagecropInterface.imagePath(stringExtra);
        }
    }

    public void getImagePickerDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeDialog(ctx, title, message, ctx.getResources().getString(R.string.camera), ctx.getResources().getString(R.string.gallery), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Utils.imagecropper.TakeImageClass.1
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                TakeImageClass.this.takePicture();
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Utils.imagecropper.TakeImageClass.2
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public void onCancelClick() {
                TakeImageClass.this.openGallery();
            }
        });
    }
}
