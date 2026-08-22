package com.appnew.android.Profile;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.UserHistory.ContactUsPage;
import com.appnew.android.UserHistory.UserHistoryActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.ChooseLanguageInApp;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.databinding.ActivityProfileTheme8Binding;
import com.appnew.android.helpChat.HelpQueryActivity;
import com.appnew.android.helpChat.HelpSupportActivity;
import com.appnew.android.helpChat.model.HelpSupportChatModel;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tv9news.utils.helpers.AnalyticEvents;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: ProfileActivityTheme8.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J\b\u0010M\u001a\u00020JH\u0002J\b\u0010N\u001a\u00020JH\u0002J\u0018\u0010X\u001a\u00020J2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010\u0012H\u0016J0\u0010[\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010\b2\b\u0010^\u001a\u0004\u0018\u00010\b2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J.\u0010a\u001a\u00020J2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010]\u001a\u0004\u0018\u00010\b2\b\u0010^\u001a\u0004\u0018\u00010\b2\u0006\u0010d\u001a\u00020eH\u0016J&\u0010f\u001a\u00020J2\b\u0010b\u001a\u0004\u0018\u00010\b2\b\u0010]\u001a\u0004\u0018\u00010\b2\b\u0010^\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010g\u001a\u00020JH\u0002J\u0012\u0010h\u001a\u00020J2\b\u0010i\u001a\u0004\u0018\u00010\bH\u0016J$\u0010j\u001a\u00020J2\b\u0010k\u001a\u0004\u0018\u00010l2\b\u0010m\u001a\u0004\u0018\u00010\b2\b\u0010n\u001a\u0004\u0018\u00010\bJ\u0006\u0010o\u001a\u00020JR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u001a\u0010!\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u00104\u001a\n 6*\u0004\u0018\u00010505X\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\n 6*\u0004\u0018\u00010=0=X\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020DX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020Q0PX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010R\u001a\b\u0012\u0004\u0012\u00020S0PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006p"}, d2 = {"Lcom/appnew/android/Profile/ProfileActivityTheme8;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/AmazonUpload/AmazonCallBack;", "Lcom/appnew/android/Utils/imagecropper/TakeImageClass$imagefromcropper;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "str_imgTypeClick", "", "getStr_imgTypeClick", "()Ljava/lang/String;", "setStr_imgTypeClick", "(Ljava/lang/String;)V", "REQUEST_CODE_PERMISSION_MULTIPLE", "", "getREQUEST_CODE_PERMISSION_MULTIPLE", "()I", "myPermissionConstantsArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Utils/AppPermissionsRunTime$MyPermissionConstants;", "getMyPermissionConstantsArrayList", "()Ljava/util/ArrayList;", "setMyPermissionConstantsArrayList", "(Ljava/util/ArrayList;)V", "profilepic", "_bindng", "Lcom/appnew/android/databinding/ActivityProfileTheme8Binding;", "get_bindng", "()Lcom/appnew/android/databinding/ActivityProfileTheme8Binding;", "set_bindng", "(Lcom/appnew/android/databinding/ActivityProfileTheme8Binding;)V", "binding", "getBinding", "data", "Lcom/appnew/android/pojo/Userinfo/Data;", "getData", "()Lcom/appnew/android/pojo/Userinfo/Data;", "setData", "(Lcom/appnew/android/pojo/Userinfo/Data;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "leftMenu", "Lcom/appnew/android/Model/LeftMenu;", "getLeftMenu", "()Lcom/appnew/android/Model/LeftMenu;", "setLeftMenu", "(Lcom/appnew/android/Model/LeftMenu;)V", "requestCode", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "kotlin.jvm.PlatformType", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "Lcom/appnew/android/Room/UtkashRoom;", "themeSettings", "Lcom/appnew/android/table/ThemeSettings;", "getThemeSettings", "()Lcom/appnew/android/table/ThemeSettings;", "setThemeSettings", "(Lcom/appnew/android/table/ThemeSettings;)V", "Lcom/appnew/android/table/ThemeSettings;", "s3IU", "Lcom/appnew/android/Utils/AmazonUpload/s3ImageUploading;", "getS3IU", "()Lcom/appnew/android/Utils/AmazonUpload/s3ImageUploading;", "setS3IU", "(Lcom/appnew/android/Utils/AmazonUpload/s3ImageUploading;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "checkStoragePermission", "imgClick", "cropImage", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/canhub/cropper/CropImageContractOptions;", "someActivityResultLauncher", "Landroid/content/Intent;", "getSomeActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setSomeActivityResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "onS3UploadData", Const.IMAGES, "Lcom/appnew/android/Model/MediaFile;", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "getmyQuires", "imagePath", "str", "getLogoutDialog", "ctx", "Landroid/app/Activity;", "title", "message", "UserLogout", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileActivityTheme8 extends AppCompatActivity implements AmazonCallBack, TakeImageClass.imagefromcropper, NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private ActivityProfileTheme8Binding _bindng;
    private final ActivityResultLauncher<CropImageContractOptions> cropImage;
    public Data data;
    public LeftMenu leftMenu;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    private NetworkCall networkCall;
    private String profilepic;
    public s3ImageUploading s3IU;
    private ActivityResultLauncher<Intent> someActivityResultLauncher;
    private ThemeSettings themeSettings;
    private UtkashRoom utkashRoom;
    private String str_imgTypeClick = "";
    private final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private int requestCode = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLogoutDialog$lambda$18() {
    }

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    public ProfileActivityTheme8() {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda10
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProfileActivityTheme8.cropImage$lambda$15(this.f$0, (CropImageView.CropResult) obj);
            }
        });
        this.someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda11
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ProfileActivityTheme8.someActivityResultLauncher$lambda$16(this.f$0, (ActivityResult) obj);
            }
        });
    }

    public final String getStr_imgTypeClick() {
        return this.str_imgTypeClick;
    }

    public final void setStr_imgTypeClick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.str_imgTypeClick = str;
    }

    public final int getREQUEST_CODE_PERMISSION_MULTIPLE() {
        return this.REQUEST_CODE_PERMISSION_MULTIPLE;
    }

    public final ArrayList<AppPermissionsRunTime.MyPermissionConstants> getMyPermissionConstantsArrayList() {
        ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList = this.myPermissionConstantsArrayList;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("myPermissionConstantsArrayList");
        return null;
    }

    public final void setMyPermissionConstantsArrayList(ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.myPermissionConstantsArrayList = arrayList;
    }

    public final ActivityProfileTheme8Binding get_bindng() {
        return this._bindng;
    }

    public final void set_bindng(ActivityProfileTheme8Binding activityProfileTheme8Binding) {
        this._bindng = activityProfileTheme8Binding;
    }

    public final ActivityProfileTheme8Binding getBinding() {
        ActivityProfileTheme8Binding activityProfileTheme8Binding = this._bindng;
        Intrinsics.checkNotNull(activityProfileTheme8Binding);
        return activityProfileTheme8Binding;
    }

    public final Data getData() {
        Data data = this.data;
        if (data != null) {
            return data;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(Data data) {
        Intrinsics.checkNotNullParameter(data, "<set-?>");
        this.data = data;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final LeftMenu getLeftMenu() {
        LeftMenu leftMenu = this.leftMenu;
        if (leftMenu != null) {
            return leftMenu;
        }
        Intrinsics.throwUninitializedPropertyAccessException("leftMenu");
        return null;
    }

    public final void setLeftMenu(LeftMenu leftMenu) {
        Intrinsics.checkNotNullParameter(leftMenu, "<set-?>");
        this.leftMenu = leftMenu;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        this.utkashRoom = utkashRoom;
    }

    public final ThemeSettings getThemeSettings() {
        return this.themeSettings;
    }

    public final void setThemeSettings(ThemeSettings themeSettings) {
        this.themeSettings = themeSettings;
    }

    public final s3ImageUploading getS3IU() {
        s3ImageUploading s3imageuploading = this.s3IU;
        if (s3imageuploading != null) {
            return s3imageuploading;
        }
        Intrinsics.throwUninitializedPropertyAccessException("s3IU");
        return null;
    }

    public final void setS3IU(s3ImageUploading s3imageuploading) {
        Intrinsics.checkNotNullParameter(s3imageuploading, "<set-?>");
        this.s3IU = s3imageuploading;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this._bindng = ActivityProfileTheme8Binding.inflate(getLayoutInflater());
        setContentView(getBinding().getRoot());
        this.networkCall = new NetworkCall(this, this);
        setData(SharedPreference.getInstance().getLoggedInUser());
        setLeftMenu((LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class));
        if (getLeftMenu().getUser_preference().equals("1")) {
            getBinding().profileExamSelectionLL.setVisibility(8);
        }
        if (getLeftMenu().getUser_wallet().equals("1")) {
            getBinding().profileMmeMoneyCv.setVisibility(8);
        }
        getBinding().myNotesCv.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivityTheme8.onCreate$lambda$0(this.f$0, view);
            }
        });
        getBinding().profileMmeMoneyCv.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivityTheme8.onCreate$lambda$1(this.f$0, view);
            }
        });
        getBinding().myCourseCv.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivityTheme8.onCreate$lambda$2(this.f$0, view);
            }
        });
        getBinding().profileMyActivityCv.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivityTheme8.onCreate$lambda$3(this.f$0, view);
            }
        });
        getBinding().myOrderCv.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivityTheme8.onCreate$lambda$4(this.f$0, view);
            }
        });
        String profilePicture = getData().getProfilePicture();
        if (profilePicture != null && !StringsKt.isBlank(profilePicture)) {
            this.profilepic = getData().getProfilePicture();
            Glide.with((FragmentActivity) this).load(this.profilepic).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(getBinding().profileImage);
        }
        getBinding().imageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileActivityTheme8.onCreate$lambda$5(this.f$0);
            }
        }));
        getBinding().changeLang.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileActivityTheme8.onCreate$lambda$6(this.f$0);
            }
        }));
        getBinding().helpLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileActivityTheme8.onCreate$lambda$7(this.f$0);
            }
        }));
        getBinding().shareAppLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileActivityTheme8.onCreate$lambda$8(this.f$0);
            }
        }));
        getBinding().profileUploadImage.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileActivityTheme8.onCreate$lambda$9(this.f$0);
            }
        }));
        getBinding().profileName.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileActivityTheme8.onCreate$lambda$10(this.f$0);
            }
        }));
        getBinding().profileExamSelectionLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileActivityTheme8.onCreate$lambda$11(this.f$0);
            }
        }));
        getBinding().policyLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProfileActivityTheme8.onCreate$lambda$12(this.f$0);
            }
        }));
        Button button = getBinding().btnLogout;
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileActivityTheme8.onCreate$lambda$13(this.f$0, view);
            }
        });
        if (getData().getProfilePicture() != null) {
            this.profilepic = getData().getProfilePicture();
            Glide.with((FragmentActivity) this).load(this.profilepic).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(getBinding().profileImage);
        }
        if (getData().getName() != null) {
            getBinding().profileName.setText(getData().getName());
        }
        if (getData().getEmail() != null) {
            getBinding().emailTV.setText(getData().getEmail());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ProfileActivityTheme8 profileActivityTheme8, View view) {
        Helper.showToast(profileActivityTheme8, "This functionality will be available soon", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ProfileActivityTheme8 profileActivityTheme8, View view) {
        Helper.showToast(profileActivityTheme8, "This functionality will be available soon", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ProfileActivityTheme8 profileActivityTheme8, View view) {
        Helper.gotoActivity(profileActivityTheme8, (Class<?>) MyLibraryActivty.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(ProfileActivityTheme8 profileActivityTheme8, View view) {
        profileActivityTheme8.startActivity(new Intent(profileActivityTheme8, (Class<?>) UserHistoryActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(ProfileActivityTheme8 profileActivityTheme8, View view) {
        profileActivityTheme8.startActivity(new Intent(profileActivityTheme8, (Class<?>) PurchaseHistory.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5(ProfileActivityTheme8 profileActivityTheme8) {
        profileActivityTheme8.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$6(ProfileActivityTheme8 profileActivityTheme8) {
        profileActivityTheme8.startActivity(new Intent(profileActivityTheme8, (Class<?>) ChooseLanguageInApp.class));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$7(ProfileActivityTheme8 profileActivityTheme8) {
        Helper.gotoActivity(profileActivityTheme8, (Class<?>) ContactUsPage.class);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$8(ProfileActivityTheme8 profileActivityTheme8) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            intent.putExtra("android.intent.extra.SUBJECT", profileActivityTheme8.getResources().getString(R.string.app_name));
            intent.putExtra("android.intent.extra.TEXT", (StringsKt.trimIndent("\n          \n                         I recommend you to learn from next-gen Smart courses. Uncover a whole new way of learning with " + profileActivityTheme8.getResources().getString(R.string.app_name) + ". Learn, practice & create custom tests and much more. Download \n                         ") + "https://play.google.com/store/apps/details?id=com.eduteria.app.app") + " and start learning now");
            profileActivityTheme8.startActivity(Intent.createChooser(intent, "choose one"));
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9(ProfileActivityTheme8 profileActivityTheme8) {
        profileActivityTheme8.checkStoragePermission();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10(ProfileActivityTheme8 profileActivityTheme8) {
        profileActivityTheme8.startActivity(new Intent(profileActivityTheme8, (Class<?>) ProfileActivity.class));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$11(ProfileActivityTheme8 profileActivityTheme8) {
        Helper.gotoActivity(new Intent(profileActivityTheme8, (Class<?>) IntroActivity.class), profileActivityTheme8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$12(ProfileActivityTheme8 profileActivityTheme8) {
        Intent intent = new Intent(profileActivityTheme8, (Class<?>) WebViewActivty.class);
        intent.putExtra("type", Const.PRIVACY);
        intent.putExtra("url", API.PRIVACY_POLICY_URL);
        Helper.gotoActivity(intent, profileActivityTheme8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$13(ProfileActivityTheme8 profileActivityTheme8, View view) {
        if (StringsKt.equals(SharedPreference.getInstance().getLoggedInUser().getId(), "0", true)) {
            Helper.GuestSignOutUser(profileActivityTheme8);
        } else {
            profileActivityTheme8.getLogoutDialog(profileActivityTheme8, profileActivityTheme8.getResources().getString(R.string.logout_title), profileActivityTheme8.getResources().getString(R.string.logout_confirmation_message));
        }
    }

    private final void checkStoragePermission() {
        setMyPermissionConstantsArrayList(new ArrayList<>());
        getMyPermissionConstantsArrayList().add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_READ_EXTERNAL_STORAGE);
        getMyPermissionConstantsArrayList().add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_WRITE_EXTERNAL_STORAGE);
        getMyPermissionConstantsArrayList().add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_CAMERA);
        if (AppPermissionsRunTime.checkPermission(this, getMyPermissionConstantsArrayList(), this.REQUEST_CODE_PERMISSION_MULTIPLE)) {
            imgClick();
        }
    }

    private final void imgClick() {
        final CharSequence[] charSequenceArr = {getResources().getString(R.string.take_photo), getResources().getString(R.string.choose_from_gallery), getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.add_photo));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ProfileActivityTheme8.imgClick$lambda$14(charSequenceArr, this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imgClick$lambda$14(CharSequence[] charSequenceArr, ProfileActivityTheme8 profileActivityTheme8, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (Intrinsics.areEqual(charSequenceArr[i], profileActivityTheme8.getResources().getString(R.string.take_photo))) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(profileActivityTheme8, "com.eduteria.app.app.provider", new File(profileActivityTheme8.getFilesDir(), "temp_image.jpg"));
                profileActivityTheme8.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                profileActivityTheme8.someActivityResultLauncher.launch(intent);
                profileActivityTheme8.requestCode = 10000;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (Intrinsics.areEqual(charSequenceArr[i], profileActivityTheme8.getResources().getString(R.string.choose_from_gallery))) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Uri uriForFile2 = FileProvider.getUriForFile(profileActivityTheme8, "com.eduteria.app.app.provider", new File(profileActivityTheme8.getFilesDir(), "temp_gallery.jpg"));
            profileActivityTheme8.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            profileActivityTheme8.someActivityResultLauncher.launch(intent2);
            profileActivityTheme8.requestCode = 20000;
            return;
        }
        if (Intrinsics.areEqual(charSequenceArr[i], profileActivityTheme8.getResources().getString(R.string.cancel))) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropImage$lambda$15(ProfileActivityTheme8 profileActivityTheme8, CropImageView.CropResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!result.isSuccessful()) {
            Log.d("TAGCropImage", "CropImage: " + result.getError());
            return;
        }
        if (StringsKt.equals(profileActivityTheme8.str_imgTypeClick, "PhotoCameraRequest", true)) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(profileActivityTheme8.getContentResolver(), result.getUriContent());
                String str = profileActivityTheme8.getFilesDir() + "/Utkarsh/ProfileImage/";
                new File(str).mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str + File.separator + (SharedPreference.getInstance().getLoggedInUser().getId() + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                profileActivityTheme8.setS3IU(new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", profileActivityTheme8, profileActivityTheme8, null));
                ArrayList arrayList = new ArrayList();
                MediaFile mediaFile = new MediaFile();
                mediaFile.setFile_type("image");
                mediaFile.setImage(bitmap);
                arrayList.add(mediaFile);
                profileActivityTheme8.getS3IU().execute(arrayList);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                Unit unit = Unit.INSTANCE;
                return;
            }
        }
        if (StringsKt.equals(profileActivityTheme8.str_imgTypeClick, "PhotoGalleryRequest", true)) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(profileActivityTheme8.getContentResolver(), result.getUriContent());
                String str2 = profileActivityTheme8.getFilesDir() + "/utkarsh/ProfileImage/";
                new File(str2).mkdirs();
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str2 + File.separator + (SharedPreference.getInstance().getLoggedInUser().getId() + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream2);
                fileOutputStream2.flush();
                fileOutputStream2.close();
                profileActivityTheme8.setS3IU(new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", profileActivityTheme8, profileActivityTheme8, null));
                ArrayList arrayList2 = new ArrayList();
                MediaFile mediaFile2 = new MediaFile();
                mediaFile2.setFile_type("image");
                mediaFile2.setImage(bitmap2);
                arrayList2.add(mediaFile2);
                profileActivityTheme8.getS3IU().execute(arrayList2);
            } catch (IOException e3) {
                e3.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final ActivityResultLauncher<Intent> getSomeActivityResultLauncher() {
        return this.someActivityResultLauncher;
    }

    public final void setSomeActivityResultLauncher(ActivityResultLauncher<Intent> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "<set-?>");
        this.someActivityResultLauncher = activityResultLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void someActivityResultLauncher$lambda$16(ProfileActivityTheme8 profileActivityTheme8, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            int i = profileActivityTheme8.requestCode;
            if (i != 10000) {
                if (i == 20000) {
                    try {
                        Intent data = result.getData();
                        Intrinsics.checkNotNull(data);
                        Uri data2 = data.getData();
                        ActivityResultLauncher<CropImageContractOptions> activityResultLauncher = profileActivityTheme8.cropImage;
                        CropImageOptions cropImageOptions = Helper.cropImageOptions(profileActivityTheme8);
                        Intrinsics.checkNotNullExpressionValue(cropImageOptions, "cropImageOptions(...)");
                        activityResultLauncher.launch(new CropImageContractOptions(data2, cropImageOptions));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                File file = new File(profileActivityTheme8.getFilesDir().toString());
                Iterator it = ArrayIteratorKt.iterator(file.listFiles());
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    File file2 = (File) it.next();
                    if (Intrinsics.areEqual(file2.getName(), "temp_image.jpg")) {
                        file = file2;
                        break;
                    }
                }
                Uri uriForFile = FileProvider.getUriForFile(profileActivityTheme8, "com.eduteria.app.app.provider", file);
                ActivityResultLauncher<CropImageContractOptions> activityResultLauncher2 = profileActivityTheme8.cropImage;
                CropImageOptions cropImageOptions2 = Helper.cropImageOptions(profileActivityTheme8);
                Intrinsics.checkNotNullExpressionValue(cropImageOptions2, "cropImageOptions(...)");
                activityResultLauncher2.launch(new CropImageContractOptions(uriForFile, cropImageOptions2));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        if (images == null || images.isEmpty()) {
            return;
        }
        this.profilepic = images.get(0).getFile();
        Glide.with((FragmentActivity) this).load(images.get(0).getFile()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(getBinding().profileImage);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (apitype == null) {
            return null;
        }
        int iHashCode = apitype.hashCode();
        if (iHashCode == -405213177) {
            if (!apitype.equals(API.GET_MY_QUIRES)) {
                return null;
            }
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setPage("1");
            encryptionData.setCourse_id("0");
            String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
            Intrinsics.checkNotNull(service);
            return service.getMyHelpQuires(strEncrypt);
        }
        if (iHashCode == 17608548) {
            if (!apitype.equals(API.user_logout)) {
                return null;
            }
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
            String strEncrypt2 = AES.encrypt(new Gson().toJson(encryptionData2));
            Intrinsics.checkNotNull(service);
            return service.getUserLogout(strEncrypt2);
        }
        if (iHashCode != 1630777357 || !apitype.equals(API.update_profile)) {
            return null;
        }
        EncryptionData encryptionData3 = new EncryptionData();
        encryptionData3.setProfile_picture(this.profilepic);
        String strEncrypt3 = AES.encrypt(new Gson().toJson(encryptionData3));
        Intrinsics.checkNotNull(service);
        return service.updateprofile(strEncrypt3);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        if (apitype != null) {
            int iHashCode = apitype.hashCode();
            if (iHashCode == -405213177) {
                if (apitype.equals(API.GET_MY_QUIRES)) {
                    if (Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                        JSONArray jSONArray = jsonstring.getJSONArray("data");
                        Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                        if (((ArrayList) new Gson().fromJson(jSONArray.toString(), new TypeToken<ArrayList<HelpSupportChatModel.DataBean>>() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$SuccessCallBack$list$1
                        }.getType())).size() > 0) {
                            Intent intent = new Intent(this, (Class<?>) HelpQueryActivity.class);
                            intent.putExtra("isCourse", false);
                            intent.putExtra("courseDetail", new CourseDetail());
                            startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(this, (Class<?>) HelpSupportActivity.class);
                        intent2.putExtra("isCourse", false);
                        intent2.putExtra("courseDetail", new CourseDetail());
                        startActivity(intent2);
                        return;
                    }
                    Intent intent3 = new Intent(this, (Class<?>) HelpSupportActivity.class);
                    intent3.putExtra("isCourse", false);
                    intent3.putExtra("courseDetail", new CourseDetail());
                    startActivity(intent3);
                    return;
                }
                return;
            }
            if (iHashCode == 17608548) {
                if (apitype.equals(API.user_logout)) {
                    Intrinsics.checkNotNull(jsonstring);
                    if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                        Helper.SignOutUser(this);
                        return;
                    }
                    return;
                }
                return;
            }
            if (iHashCode == 1630777357 && apitype.equals(API.update_profile)) {
                try {
                    Intrinsics.checkNotNull(jsonstring);
                    if (jsonstring.getBoolean("status")) {
                        getData().setProfilePicture(this.profilepic);
                        SharedPreference.getInstance().setLoggedInUserr(getData());
                        AnalyticEvents.INSTANCE.addUpdateCleverTapUser(this, true);
                        Toast.makeText(this, getResources().getString(R.string.profile_updated), 0).show();
                        finish();
                        return;
                    }
                    Toast.makeText(this, jsonstring.getString("message"), 0).show();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (apitype != null) {
            int iHashCode = apitype.hashCode();
            if (iHashCode != -787266248) {
                if (iHashCode != -319596559) {
                    if (iHashCode != 1630777357 || !apitype.equals(API.update_profile)) {
                        return;
                    }
                } else if (!apitype.equals(API.API_STATE)) {
                    return;
                }
            } else if (!apitype.equals(API.API_CITY)) {
                return;
            }
            Toast.makeText(this, jsonstring, 0).show();
        }
    }

    private final void getmyQuires() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.GET_MY_QUIRES, "", true, false);
    }

    public final void getLogoutDialog(Activity ctx, String title, String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda8
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                ProfileActivityTheme8.getLogoutDialog$lambda$17(this.f$0);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Profile.ProfileActivityTheme8$$ExternalSyntheticLambda9
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                ProfileActivityTheme8.getLogoutDialog$lambda$18();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLogoutDialog$lambda$17(ProfileActivityTheme8 profileActivityTheme8) {
        ProfileActivityTheme8 profileActivityTheme82 = profileActivityTheme8;
        if (Helper.isConnected(profileActivityTheme82)) {
            profileActivityTheme8.UserLogout();
        } else {
            Toast.makeText(profileActivityTheme82, "No Internet connection", 0).show();
        }
    }

    public final void UserLogout() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.user_logout, "", true, false);
    }
}
