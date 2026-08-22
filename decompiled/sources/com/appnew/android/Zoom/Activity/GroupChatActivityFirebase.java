package com.appnew.android.Zoom.Activity;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.DoubtChatPojo;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.ZoomModel.DoubtData;
import com.appnew.android.Model.ZoomModel.ReplyModel;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.RealPathUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.Zoom.Activity.GroupChatActivityFirebase;
import com.appnew.android.Zoom.Adapter.GroupChatAdapter;
import com.appnew.android.databinding.ActivityGroupChatBinding;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: GroupChatActivityFirebase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0015J\b\u0010a\u001a\u00020^H\u0002J\u0012\u0010b\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0010\u0010c\u001a\u00020^2\u0006\u0010d\u001a\u00020\nH\u0002J\u0010\u0010e\u001a\u00020^2\u0006\u0010d\u001a\u00020\nH\u0002J,\u0010f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010\b2\b\u0010i\u001a\u0004\u0018\u00010\b2\u0006\u0010j\u001a\u00020kH\u0016J,\u0010l\u001a\u00020^2\u0006\u0010m\u001a\u00020n2\b\u0010h\u001a\u0004\u0018\u00010\b2\b\u0010i\u001a\u0004\u0018\u00010\b2\u0006\u0010o\u001a\u00020\nH\u0016J&\u0010p\u001a\u00020^2\b\u0010m\u001a\u0004\u0018\u00010\b2\b\u0010h\u001a\u0004\u0018\u00010\b2\b\u0010i\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010s\u001a\u00020^H\u0002J\u0012\u0010t\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\b\u0010u\u001a\u00020^H\u0002J\u0006\u0010v\u001a\u00020^J\u0006\u0010w\u001a\u00020^J\b\u0010x\u001a\u00020^H\u0002J\u000e\u0010y\u001a\u00020^2\u0006\u0010z\u001a\u00020,J\b\u0010{\u001a\u00020^H\u0002J\u0006\u0010|\u001a\u00020^J\b\u0010}\u001a\u00020^H\u0002J\b\u0010~\u001a\u00020^H\u0002J\b\u0010\u007f\u001a\u00020^H\u0002J3\u0010\u0080\u0001\u001a\u00020^2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u0081\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\b0\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016¢\u0006\u0003\u0010\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020^H\u0002J\u001e\u0010\u0090\u0001\u001a\u00020\b2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\bH\u0002J\u0010\u0010\u0094\u0001\u001a\u00020^2\u0007\u0010\u0095\u0001\u001a\u00020\bJ\u001b\u0010\u0096\u0001\u001a\u00020^2\u0010\u0010\u0097\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010\u0013H\u0016J\u0014\u0010\u0099\u0001\u001a\u00020^2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u000f\"\u0004\bS\u0010\u0011R\u001c\u0010T\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000f\"\u0004\bV\u0010\u0011R\u000e\u0010W\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0087\u0001\u001a\n\u0012\u0005\u0012\u00030\u0089\u00010\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u008a\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u0088\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/appnew/android/Zoom/Activity/GroupChatActivityFirebase;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/Utils/AmazonUpload/AmazonCallBack;", "Lcom/appnew/android/Utils/imagecropper/TakeImageClass$imagefromcropper;", "<init>", "()V", "doubtId", "", "isintractavailable", "", "requestCode", "", "str_imgTypeClick", "getStr_imgTypeClick", "()Ljava/lang/String;", "setStr_imgTypeClick", "(Ljava/lang/String;)V", "myPermissionConstantsArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Utils/AppPermissionsRunTime$MyPermissionConstants;", "getMyPermissionConstantsArrayList", "()Ljava/util/ArrayList;", "setMyPermissionConstantsArrayList", "(Ljava/util/ArrayList;)V", "REQUEST_CODE_PERMISSION_MULTIPLE", "getREQUEST_CODE_PERMISSION_MULTIPLE", "()I", "multiplePermissionCounter", "s3IU", "Lcom/appnew/android/Utils/AmazonUpload/s3ImageUploading;", "PERMISSION_TYPE", "timer", "Ljava/util/Timer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "getMediaPlayer", "()Landroid/media/MediaPlayer;", "setMediaPlayer", "(Landroid/media/MediaPlayer;)V", "fileName", "recorder", "Landroid/media/MediaRecorder;", "play", "Landroid/widget/Button;", "getPlay", "()Landroid/widget/Button;", "setPlay", "(Landroid/widget/Button;)V", "handler", "Landroid/os/Handler;", "binding", "Lcom/appnew/android/databinding/ActivityGroupChatBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityGroupChatBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityGroupChatBinding;)V", "groupChatAdapter", "Lcom/appnew/android/Zoom/Adapter/GroupChatAdapter;", "getGroupChatAdapter", "()Lcom/appnew/android/Zoom/Adapter/GroupChatAdapter;", "setGroupChatAdapter", "(Lcom/appnew/android/Zoom/Adapter/GroupChatAdapter;)V", "doubtData", "Lcom/appnew/android/Model/ZoomModel/DoubtData;", "getDoubtData", "()Lcom/appnew/android/Model/ZoomModel/DoubtData;", "setDoubtData", "(Lcom/appnew/android/Model/ZoomModel/DoubtData;)V", "replyModel", "Lcom/appnew/android/Model/ZoomModel/ReplyModel;", "getReplyModel", "()Lcom/appnew/android/Model/ZoomModel/ReplyModel;", "setReplyModel", "(Lcom/appnew/android/Model/ZoomModel/ReplyModel;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "doubtType", "getDoubtType", "setDoubtType", "Chat_node", "getChat_node", "setChat_node", "STORAGE_PERMISSION_TYPE", "seconds", "running", "isLoaderShowing", "dialog", "Landroid/app/Dialog;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setRecyclerView", "setClicks", "sendChat", "showProgress", "resolveStatus", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "mFirebaseDatabaseReference", "Lcom/google/firebase/database/DatabaseReference;", "setChatFirebaseData", "stopWatch", "runTimer", "starttimer", "stoptimer", "stopRecording", "onRecordBtnClicked", "record", "startRecording", "sendaudio", "checkStoragePermission2", "OpenChooser", "checkStoragePermission", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "imgClick", "cropImage", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/canhub/cropper/CropImageContractOptions;", "someActivityResultLauncher", "Landroid/content/Intent;", "getSomeActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setSomeActivityResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "copyFileToInternalStorage", "uri", "Landroid/net/Uri;", "newDirName", "setupDoc", "selectedURI", "onS3UploadData", Const.IMAGES, "Lcom/appnew/android/Model/MediaFile;", "imagePath", "str", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupChatActivityFirebase extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, AmazonCallBack, TakeImageClass.imagefromcropper {
    public static final int $stable = 8;
    private String Chat_node;
    private int PERMISSION_TYPE;
    private int STORAGE_PERMISSION_TYPE;
    public ActivityGroupChatBinding binding;
    private Dialog dialog;
    private DoubtData doubtData;
    private String doubtId;
    private String doubtType;
    private String fileName;
    public GroupChatAdapter groupChatAdapter;
    private Handler handler;
    private boolean isintractavailable;
    private DatabaseReference mFirebaseDatabaseReference;
    private MediaPlayer mediaPlayer;
    private int multiplePermissionCounter;
    private ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    private NetworkCall networkCall;
    private Button play;
    private MediaRecorder recorder;
    private ReplyModel replyModel;
    private boolean running;
    private s3ImageUploading s3IU;
    private int seconds;
    private Timer timer;
    private int requestCode = -1;
    private String str_imgTypeClick = "";
    private final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private boolean isLoaderShowing = true;
    private final ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda10
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            GroupChatActivityFirebase.cropImage$lambda$11(this.f$0, (CropImageView.CropResult) obj);
        }
    });
    private ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda11
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            GroupChatActivityFirebase.someActivityResultLauncher$lambda$12(this.f$0, (ActivityResult) obj);
        }
    });

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    public final String getStr_imgTypeClick() {
        return this.str_imgTypeClick;
    }

    public final void setStr_imgTypeClick(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.str_imgTypeClick = str;
    }

    public final ArrayList<AppPermissionsRunTime.MyPermissionConstants> getMyPermissionConstantsArrayList() {
        return this.myPermissionConstantsArrayList;
    }

    public final void setMyPermissionConstantsArrayList(ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList) {
        this.myPermissionConstantsArrayList = arrayList;
    }

    public final int getREQUEST_CODE_PERMISSION_MULTIPLE() {
        return this.REQUEST_CODE_PERMISSION_MULTIPLE;
    }

    public final MediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    public final void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public final Button getPlay() {
        return this.play;
    }

    public final void setPlay(Button button) {
        this.play = button;
    }

    public final ActivityGroupChatBinding getBinding() {
        ActivityGroupChatBinding activityGroupChatBinding = this.binding;
        if (activityGroupChatBinding != null) {
            return activityGroupChatBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityGroupChatBinding activityGroupChatBinding) {
        Intrinsics.checkNotNullParameter(activityGroupChatBinding, "<set-?>");
        this.binding = activityGroupChatBinding;
    }

    public final GroupChatAdapter getGroupChatAdapter() {
        GroupChatAdapter groupChatAdapter = this.groupChatAdapter;
        if (groupChatAdapter != null) {
            return groupChatAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("groupChatAdapter");
        return null;
    }

    public final void setGroupChatAdapter(GroupChatAdapter groupChatAdapter) {
        Intrinsics.checkNotNullParameter(groupChatAdapter, "<set-?>");
        this.groupChatAdapter = groupChatAdapter;
    }

    public final DoubtData getDoubtData() {
        return this.doubtData;
    }

    public final void setDoubtData(DoubtData doubtData) {
        this.doubtData = doubtData;
    }

    public final ReplyModel getReplyModel() {
        return this.replyModel;
    }

    public final void setReplyModel(ReplyModel replyModel) {
        this.replyModel = replyModel;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final String getDoubtType() {
        return this.doubtType;
    }

    public final void setDoubtType(String str) {
        this.doubtType = str;
    }

    public final String getChat_node() {
        return this.Chat_node;
    }

    public final void setChat_node(String str) {
        this.Chat_node = str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GroupChatActivityFirebase groupChatActivityFirebase = this;
        Helper.setSystemBarLight(groupChatActivityFirebase);
        setBinding(ActivityGroupChatBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().root);
        Helper.enableScreenShot(groupChatActivityFirebase);
        GroupChatActivityFirebase groupChatActivityFirebase2 = this;
        this.networkCall = new NetworkCall(this, groupChatActivityFirebase2);
        Helper.showProgressDialog(groupChatActivityFirebase2);
        if (getIntent() != null) {
            if (StringsKt.equals(getIntent().getStringExtra("Chat_type"), "0", true)) {
                getBinding().toolbarTitleTV.setText(getResources().getString(R.string.group_chat));
                this.Chat_node = getIntent().getStringExtra("Chat_node");
                getBinding().etMessage.setHint("Message...");
                getBinding().chatAddButton.setVisibility(0);
                getBinding().fileUpload.setVisibility(0);
            } else {
                getBinding().toolbarTitleTV.setText(getResources().getString(R.string.doubt_chat));
                this.doubtData = (DoubtData) getIntent().getSerializableExtra("data");
                this.doubtType = getIntent().getStringExtra("doubtType");
                this.Chat_node = getIntent().getStringExtra("Chat_node");
                this.doubtId = getIntent().getStringExtra("doubtId");
                if (StringsKt.equals(this.doubtType, "SME", true)) {
                    getBinding().main.setVisibility(8);
                    getBinding().doubtResolved.setVisibility(8);
                    getBinding().linearLayoutChat.setVisibility(0);
                    getBinding().doubtUnResolved.setVisibility(8);
                } else {
                    getBinding().main.setVisibility(0);
                    TextView textView = getBinding().doubtSubject;
                    DoubtData doubtData = this.doubtData;
                    textView.setText(doubtData != null ? doubtData.getSubject_name() : null);
                    TextView textView2 = getBinding().doubtMessage;
                    String string = getResources().getString(R.string.your_doubt);
                    DoubtData doubtData2 = this.doubtData;
                    textView2.setText(string + (doubtData2 != null ? doubtData2.getDoubt_message() : null));
                    if (StringsKt.equals$default(this.doubtType, "all_doubt", false, 2, null)) {
                        getBinding().linearLayoutChat.setVisibility(8);
                        getBinding().doubtResolved.setVisibility(8);
                        getBinding().doubtUnResolved.setVisibility(8);
                    } else if (StringsKt.equals(this.doubtType, "SME", true)) {
                        getBinding().doubtResolved.setVisibility(8);
                        getBinding().linearLayoutChat.setVisibility(0);
                        getBinding().doubtUnResolved.setVisibility(8);
                    } else {
                        DoubtData doubtData3 = this.doubtData;
                        if (StringsKt.equals$default(doubtData3 != null ? doubtData3.getIs_complete() : null, "1", false, 2, null)) {
                            getBinding().doubtResolved.setVisibility(8);
                            getBinding().linearLayoutChat.setVisibility(8);
                            getBinding().doubtUnResolved.setVisibility(0);
                        } else {
                            DoubtData doubtData4 = this.doubtData;
                            if (StringsKt.equals$default(doubtData4 != null ? doubtData4.getIs_complete() : null, "0", false, 2, null)) {
                                getBinding().doubtResolved.setVisibility(0);
                                getBinding().linearLayoutChat.setVisibility(0);
                                getBinding().doubtUnResolved.setVisibility(8);
                            }
                        }
                    }
                }
            }
        }
        getBinding().doubtMessage.setMovementMethod(new ScrollingMovementMethod());
        setRecyclerView();
        setChatFirebaseData();
        setClicks(savedInstanceState);
    }

    private final void setRecyclerView() {
        GroupChatActivityFirebase groupChatActivityFirebase = this;
        getBinding().doubtReplyRecycler.setLayoutManager(new LinearLayoutManager(groupChatActivityFirebase));
        setGroupChatAdapter(new GroupChatAdapter(groupChatActivityFirebase, new ArrayList()));
        getBinding().doubtReplyRecycler.setAdapter(getGroupChatAdapter());
    }

    private final void setClicks(final Bundle savedInstanceState) {
        getBinding().doubtChatBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivityFirebase.setClicks$lambda$0(this.f$0);
            }
        }));
        getBinding().ivSend.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivityFirebase.setClicks$lambda$1(this.f$0);
            }
        }));
        ImageView imageView = getBinding().chatAddButton;
        if (imageView != null) {
            imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GroupChatActivityFirebase.setClicks$lambda$2(this.f$0);
                }
            }));
        }
        Button button = getBinding().startaudio;
        if (button != null) {
            button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GroupChatActivityFirebase.setClicks$lambda$3(this.f$0, savedInstanceState);
                }
            }));
        }
        ImageView imageView2 = getBinding().fileUpload;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupChatActivityFirebase.setClicks$lambda$4(this.f$0, view);
                }
            });
        }
        getBinding().doubtResolved.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivityFirebase.setClicks$lambda$5(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$0(GroupChatActivityFirebase groupChatActivityFirebase) {
        groupChatActivityFirebase.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$1(GroupChatActivityFirebase groupChatActivityFirebase) {
        if (groupChatActivityFirebase.getBinding().etMessage.getText().toString().length() == 0 || groupChatActivityFirebase.getBinding().etMessage.getText().toString().equals("") || StringsKt.replace$default(groupChatActivityFirebase.getBinding().etMessage.getText().toString(), " ", "", false, 4, (Object) null).length() == 0) {
            GroupChatActivityFirebase groupChatActivityFirebase2 = groupChatActivityFirebase;
            String string = groupChatActivityFirebase.getResources().getString(R.string.type_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            XtensionFunctionKt.showSmallLengthToast(groupChatActivityFirebase2, string);
        } else {
            GroupChatActivityFirebase groupChatActivityFirebase3 = groupChatActivityFirebase;
            if (Helper.isNetworkConnected(groupChatActivityFirebase3)) {
                if (!Intrinsics.areEqual(groupChatActivityFirebase.getBinding().etMessage.getText().toString(), "")) {
                    groupChatActivityFirebase.sendChat(false);
                }
            } else {
                Helper.showInternetToast(groupChatActivityFirebase3);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$2(GroupChatActivityFirebase groupChatActivityFirebase) {
        GroupChatActivityFirebase groupChatActivityFirebase2 = groupChatActivityFirebase;
        if (Helper.isNetworkConnected(groupChatActivityFirebase2)) {
            groupChatActivityFirebase.checkStoragePermission();
        } else {
            Helper.showInternetToast(groupChatActivityFirebase2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$3(GroupChatActivityFirebase groupChatActivityFirebase, Bundle bundle) {
        GroupChatActivityFirebase groupChatActivityFirebase2 = groupChatActivityFirebase;
        if (Helper.isNetworkConnected(groupChatActivityFirebase2)) {
            groupChatActivityFirebase.stopWatch(bundle);
        } else {
            Helper.showInternetToast(groupChatActivityFirebase2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$4(GroupChatActivityFirebase groupChatActivityFirebase, View view) {
        GroupChatActivityFirebase groupChatActivityFirebase2 = groupChatActivityFirebase;
        if (Helper.isNetworkConnected(groupChatActivityFirebase2)) {
            groupChatActivityFirebase.STORAGE_PERMISSION_TYPE = 3;
            groupChatActivityFirebase.checkStoragePermission2();
        } else {
            Toast.makeText(groupChatActivityFirebase2, groupChatActivityFirebase.getResources().getString(R.string.no_internet_connection), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$5(GroupChatActivityFirebase groupChatActivityFirebase) {
        GroupChatActivityFirebase groupChatActivityFirebase2 = groupChatActivityFirebase;
        if (Helper.isNetworkConnected(groupChatActivityFirebase2)) {
            groupChatActivityFirebase.resolveStatus(false);
        } else {
            Helper.showInternetToast(groupChatActivityFirebase2);
        }
        return Unit.INSTANCE;
    }

    private final void sendChat(boolean showProgress) {
        DatabaseReference databaseReferencePush;
        DoubtChatPojo doubtChatPojo = new DoubtChatPojo(MakeMyExam.userId, getBinding().etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "text", this.doubtId);
        DatabaseReference databaseReference = this.mFirebaseDatabaseReference;
        if (databaseReference != null && (databaseReferencePush = databaseReference.push()) != null) {
            databaseReferencePush.setValue(doubtChatPojo);
        }
        getBinding().etMessage.getText().clear();
        Helper.hideKeyboard(this);
    }

    private final void resolveStatus(boolean showProgress) {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_DOUBT_RESOLVE_STATUS, "", showProgress, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_REPLY)) {
            EncryptionData encryptionData = new EncryptionData();
            DoubtData doubtData = this.doubtData;
            encryptionData.setDoubt_id(doubtData != null ? doubtData.getDoubt_id() : null);
            encryptionData.setMessage(getBinding().etMessage.getText().toString());
            return service.doubtReply(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.API_GET_DOUBT_RESOLVE_STATUS)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        DoubtData doubtData2 = this.doubtData;
        encryptionData2.setDoubt_id(doubtData2 != null ? doubtData2.getDoubt_id() : null);
        return service.doubtResolveStatus(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        ArrayList<ReplyModel> reply;
        String doubt_id;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_REPLY)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    this.replyModel = new ReplyModel("0", getBinding().etMessage.getText().toString(), jsonstring.optString("time"));
                    DoubtData doubtData = this.doubtData;
                    if (doubtData != null && (reply = doubtData.getReply()) != null) {
                        DoubtData doubtData2 = this.doubtData;
                        Intrinsics.checkNotNull(doubtData2);
                        reply.add(doubtData2.getReply().size(), this.replyModel);
                    }
                    RecyclerView recyclerView = getBinding().doubtReplyRecycler;
                    Intrinsics.checkNotNull(this.doubtData);
                    recyclerView.scrollToPosition(r5.getReply().size() - 1);
                    getBinding().etMessage.getText().clear();
                    return;
                }
                String string = jsonstring.getString("message");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_RESOLVE_STATUS)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    String string2 = jsonstring.getString("message");
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    XtensionFunctionKt.showSmallLengthToast(this, string2);
                    getBinding().doubtResolved.setVisibility(8);
                    getBinding().linearLayoutChat.setVisibility(8);
                    getBinding().doubtUnResolved.setVisibility(0);
                    SharedPreference sharedPreference = SharedPreference.getInstance();
                    DoubtData doubtData3 = this.doubtData;
                    if (doubtData3 == null || (doubt_id = doubtData3.getDoubt_id()) == null) {
                        doubt_id = "";
                    }
                    sharedPreference.putString("doubtResetId", doubt_id);
                    return;
                }
                String string3 = jsonstring.getString("message");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string3);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (!Intrinsics.areEqual(apitype, API.API_GET_DOUBT_REPLY) || AllDoubtsFragmentKt.getPaginationLoader() == null) {
            return;
        }
        ProgressBar paginationLoader = AllDoubtsFragmentKt.getPaginationLoader();
        Intrinsics.checkNotNull(paginationLoader);
        if (paginationLoader.isShown()) {
            ProgressBar paginationLoader2 = AllDoubtsFragmentKt.getPaginationLoader();
            Intrinsics.checkNotNull(paginationLoader2);
            paginationLoader2.setVisibility(8);
        }
    }

    private final void setChatFirebaseData() {
        try {
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/chat_data");
            this.mFirebaseDatabaseReference = databaseReferenceChild;
            if (databaseReferenceChild != null) {
                databaseReferenceChild.addValueEventListener(new ValueEventListener() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase.setChatFirebaseData.1
                    @Override // com.google.firebase.database.ValueEventListener
                    public void onCancelled(DatabaseError databaseError) {
                        Intrinsics.checkNotNullParameter(databaseError, "databaseError");
                    }

                    @Override // com.google.firebase.database.ValueEventListener
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                        if (GroupChatActivityFirebase.this.isLoaderShowing) {
                            Helper.dismissProgressDialog();
                            GroupChatActivityFirebase.this.isLoaderShowing = false;
                        }
                        if (dataSnapshot.getValue() != null) {
                            GroupChatActivityFirebase.this.getGroupChatAdapter().clearList();
                            Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                            while (it.hasNext()) {
                                GroupChatActivityFirebase.this.getGroupChatAdapter().updateList((DoubtChatPojo) it.next().getValue(DoubtChatPojo.class));
                            }
                            GroupChatActivityFirebase.this.getBinding().doubtReplyRecycler.scrollToPosition(GroupChatActivityFirebase.this.getGroupChatAdapter().getItemCount() - 1);
                        }
                    }
                });
            }
            DatabaseReference databaseReference = this.mFirebaseDatabaseReference;
            if (databaseReference != null) {
                databaseReference.limitToLast(500);
            }
        } catch (Exception unused) {
        }
    }

    private final void stopWatch(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.seconds = savedInstanceState.getInt("seconds");
            this.running = savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    private final void runTimer() {
        if (getGroupChatAdapter() != null) {
            getGroupChatAdapter().pauseAudio();
        }
        Dialog dialog = new Dialog(this);
        this.dialog = dialog;
        Intrinsics.checkNotNull(dialog);
        dialog.setContentView(R.layout.custom_dialog_new);
        Dialog dialog2 = this.dialog;
        Intrinsics.checkNotNull(dialog2);
        dialog2.setCanceledOnTouchOutside(false);
        Dialog dialog3 = this.dialog;
        Intrinsics.checkNotNull(dialog3);
        dialog3.setCancelable(false);
        Dialog dialog4 = this.dialog;
        Intrinsics.checkNotNull(dialog4);
        dialog4.show();
        Dialog dialog5 = this.dialog;
        Intrinsics.checkNotNull(dialog5);
        View viewFindViewById = dialog5.findViewById(R.id.record);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final Button button = (Button) viewFindViewById;
        Dialog dialog6 = this.dialog;
        Intrinsics.checkNotNull(dialog6);
        View viewFindViewById2 = dialog6.findViewById(R.id.timerno);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById2;
        Dialog dialog7 = this.dialog;
        Intrinsics.checkNotNull(dialog7);
        this.play = (Button) dialog7.findViewById(R.id.play);
        Dialog dialog8 = this.dialog;
        Intrinsics.checkNotNull(dialog8);
        View viewFindViewById3 = dialog8.findViewById(R.id.send);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        Dialog dialog9 = this.dialog;
        Intrinsics.checkNotNull(dialog9);
        View viewFindViewById4 = dialog9.findViewById(R.id.cancel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        Button button2 = (Button) viewFindViewById4;
        Handler handler = new Handler();
        this.handler = handler;
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase.runTimer.1
            @Override // java.lang.Runnable
            public void run() {
                int i = GroupChatActivityFirebase.this.seconds / 3600;
                int i2 = (GroupChatActivityFirebase.this.seconds % 3600) / 60;
                int i3 = GroupChatActivityFirebase.this.seconds % 60;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.getDefault(), "%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                textView.setText(str);
                if (GroupChatActivityFirebase.this.running) {
                    GroupChatActivityFirebase.this.seconds++;
                }
                Handler handler2 = GroupChatActivityFirebase.this.handler;
                Intrinsics.checkNotNull(handler2);
                handler2.postDelayed(this, 1000L);
            }
        });
        button.setText(getResources().getString(R.string.record));
        ((Button) viewFindViewById3).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivityFirebase.runTimer$lambda$6(this.f$0);
            }
        }));
        button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivityFirebase.runTimer$lambda$7(button, this);
            }
        }));
        Button button3 = this.play;
        if (button3 != null) {
            button3.setText(getResources().getString(R.string.play));
        }
        Button button4 = this.play;
        if (button4 != null) {
            button4.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GroupChatActivityFirebase.runTimer$lambda$8(button, this);
                }
            }));
        }
        button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivityFirebase.runTimer$lambda$9(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$6(GroupChatActivityFirebase groupChatActivityFirebase) {
        GroupChatActivityFirebase groupChatActivityFirebase2 = groupChatActivityFirebase;
        if (Helper.isNetworkConnected(groupChatActivityFirebase2)) {
            String str = groupChatActivityFirebase.fileName;
            if (str == "" || str == null) {
                Toast.makeText(groupChatActivityFirebase2, groupChatActivityFirebase.getResources().getString(R.string.please_record_audio), 0).show();
            } else {
                MediaPlayer mediaPlayer = groupChatActivityFirebase.mediaPlayer;
                if (mediaPlayer != null) {
                    Intrinsics.checkNotNull(mediaPlayer);
                    if (mediaPlayer.isPlaying()) {
                        MediaPlayer mediaPlayer2 = groupChatActivityFirebase.mediaPlayer;
                        Intrinsics.checkNotNull(mediaPlayer2);
                        mediaPlayer2.pause();
                    }
                }
                groupChatActivityFirebase.seconds = 0;
                groupChatActivityFirebase.running = false;
                groupChatActivityFirebase.sendaudio();
                Handler handler = groupChatActivityFirebase.handler;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacksAndMessages(null);
                Dialog dialog = groupChatActivityFirebase.dialog;
                Intrinsics.checkNotNull(dialog);
                dialog.dismiss();
            }
        } else {
            Toast.makeText(groupChatActivityFirebase2, groupChatActivityFirebase.getResources().getString(R.string.no_internet_connection), 0).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$7(Button button, GroupChatActivityFirebase groupChatActivityFirebase) {
        if (Intrinsics.areEqual(button.getText(), "Record")) {
            groupChatActivityFirebase.onRecordBtnClicked(button);
        } else if (Intrinsics.areEqual(button.getText(), "Stop")) {
            button.setText(groupChatActivityFirebase.getResources().getString(R.string.record));
            groupChatActivityFirebase.running = false;
            groupChatActivityFirebase.stopRecording();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$8(Button button, GroupChatActivityFirebase groupChatActivityFirebase) {
        if (!Intrinsics.areEqual(button.getText(), "Stop")) {
            Button button2 = groupChatActivityFirebase.play;
            if (Intrinsics.areEqual(button2 != null ? button2.getText() : null, "Play")) {
                if (groupChatActivityFirebase.seconds == 0) {
                    Toast.makeText(groupChatActivityFirebase, groupChatActivityFirebase.getResources().getString(R.string.please_record_audio), 0).show();
                } else {
                    MediaPlayer mediaPlayerCreate = MediaPlayer.create(groupChatActivityFirebase, Uri.parse(groupChatActivityFirebase.fileName));
                    groupChatActivityFirebase.mediaPlayer = mediaPlayerCreate;
                    if (mediaPlayerCreate != null) {
                        mediaPlayerCreate.start();
                    }
                    Button button3 = groupChatActivityFirebase.play;
                    if (button3 != null) {
                        button3.setText(groupChatActivityFirebase.getResources().getString(R.string.pause));
                    }
                    groupChatActivityFirebase.starttimer();
                }
            } else {
                Button button4 = groupChatActivityFirebase.play;
                if (Intrinsics.areEqual(button4 != null ? button4.getText() : null, "Pause")) {
                    groupChatActivityFirebase.stoptimer();
                    Button button5 = groupChatActivityFirebase.play;
                    if (button5 != null) {
                        button5.setText(groupChatActivityFirebase.getResources().getString(R.string.play));
                    }
                    MediaPlayer mediaPlayer = groupChatActivityFirebase.mediaPlayer;
                    if (mediaPlayer != null) {
                        mediaPlayer.pause();
                    }
                }
            }
        } else {
            Helper.showToast(groupChatActivityFirebase, groupChatActivityFirebase.getResources().getString(R.string.you_can_not_play_the_audio_while_record), 0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$9(GroupChatActivityFirebase groupChatActivityFirebase) {
        groupChatActivityFirebase.stopRecording();
        MediaPlayer mediaPlayer = groupChatActivityFirebase.mediaPlayer;
        if (mediaPlayer != null) {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = groupChatActivityFirebase.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
            }
        }
        groupChatActivityFirebase.seconds = 0;
        groupChatActivityFirebase.running = false;
        groupChatActivityFirebase.fileName = "";
        Dialog dialog = groupChatActivityFirebase.dialog;
        Intrinsics.checkNotNull(dialog);
        dialog.dismiss();
        Handler handler = groupChatActivityFirebase.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$starttimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GroupChatActivityFirebase.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/Zoom/Activity/GroupChatActivityFirebase$starttimer$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C05591 extends TimerTask {
        C05591() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = GroupChatActivityFirebase.this.getMediaPlayer();
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                return;
            }
            GroupChatActivityFirebase.this.stoptimer();
            final GroupChatActivityFirebase groupChatActivityFirebase = GroupChatActivityFirebase.this;
            groupChatActivityFirebase.runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$starttimer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GroupChatActivityFirebase.C05591.run$lambda$0(groupChatActivityFirebase);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(GroupChatActivityFirebase groupChatActivityFirebase) {
            Button play = groupChatActivityFirebase.getPlay();
            if (play != null) {
                play.setText(groupChatActivityFirebase.getResources().getString(R.string.play));
            }
        }
    }

    public final void starttimer() {
        Timer timer = new Timer();
        this.timer = timer;
        Intrinsics.checkNotNull(timer);
        timer.schedule(new C05591(), 0L, 1000L);
    }

    public final void stoptimer() {
        Timer timer = this.timer;
        if (timer != null) {
            Intrinsics.checkNotNull(timer);
            timer.cancel();
            this.timer = null;
        }
    }

    private final void stopRecording() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.stop();
            MediaRecorder mediaRecorder2 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.reset();
            MediaRecorder mediaRecorder3 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder3);
            mediaRecorder3.release();
            this.recorder = null;
        }
    }

    public final void onRecordBtnClicked(Button record) {
        Intrinsics.checkNotNullParameter(record, "record");
        if (ActivityCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            this.PERMISSION_TYPE = 3;
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 10);
        } else {
            this.seconds = 0;
            this.running = true;
            record.setText("Stop");
            startRecording();
        }
    }

    private final void startRecording() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.stop();
            MediaRecorder mediaRecorder2 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.reset();
            MediaRecorder mediaRecorder3 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder3);
            mediaRecorder3.release();
            this.recorder = null;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        File externalCacheDir = getExternalCacheDir();
        Intrinsics.checkNotNull(externalCacheDir);
        this.fileName = externalCacheDir.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + string + ".mp3";
        MediaRecorder mediaRecorder4 = new MediaRecorder();
        this.recorder = mediaRecorder4;
        Intrinsics.checkNotNull(mediaRecorder4);
        mediaRecorder4.setAudioSource(1);
        MediaRecorder mediaRecorder5 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder5);
        mediaRecorder5.setOutputFormat(6);
        MediaRecorder mediaRecorder6 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder6);
        mediaRecorder6.setOutputFile(this.fileName);
        MediaRecorder mediaRecorder7 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder7);
        mediaRecorder7.setAudioEncoder(3);
        try {
            MediaRecorder mediaRecorder8 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder8);
            mediaRecorder8.prepare();
        } catch (IOException unused) {
        }
        MediaRecorder mediaRecorder9 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder9);
        mediaRecorder9.start();
    }

    public final void sendaudio() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            Intrinsics.checkNotNull(mediaRecorder);
            mediaRecorder.stop();
            MediaRecorder mediaRecorder2 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder2);
            mediaRecorder2.reset();
            MediaRecorder mediaRecorder3 = this.recorder;
            Intrinsics.checkNotNull(mediaRecorder3);
            mediaRecorder3.release();
            this.recorder = null;
        }
        String str = this.Chat_node;
        this.s3IU = new s3ImageUploading(str, "vc-10000386-38616500102/application/chat_system/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
        ArrayList arrayList = new ArrayList();
        MediaFile mediaFile = new MediaFile();
        mediaFile.setFile_type("audio");
        mediaFile.setFile(this.fileName);
        arrayList.add(mediaFile);
        s3ImageUploading s3imageuploading = this.s3IU;
        Intrinsics.checkNotNull(s3imageuploading);
        s3imageuploading.execute(arrayList);
        this.fileName = "";
    }

    private final void checkStoragePermission2() {
        if (getGroupChatAdapter() != null) {
            getGroupChatAdapter().pauseAudio();
        }
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase.checkStoragePermission2.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Intrinsics.checkNotNullParameter(report, "report");
                GroupChatActivityFirebase.this.OpenChooser();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(token, "token");
                token.continuePermissionRequest();
            }
        }).check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void OpenChooser() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/pdf");
            this.someActivityResultLauncher.launch(intent);
            this.requestCode = 101;
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private final void checkStoragePermission() {
        if (getGroupChatAdapter() != null) {
            getGroupChatAdapter().pauseAudio();
        }
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase.checkStoragePermission.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Intrinsics.checkNotNullParameter(report, "report");
                GroupChatActivityFirebase.this.imgClick();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(token, "token");
                token.continuePermissionRequest();
            }
        }).check();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == this.REQUEST_CODE_PERMISSION_MULTIPLE) {
            for (int i : grantResults) {
                if (i != 0) {
                    int i2 = this.multiplePermissionCounter + 1;
                    this.multiplePermissionCounter = i2;
                    if (i2 >= 2) {
                        Helper.aDialogOnPermissionDenied(this);
                        return;
                    } else {
                        AppPermissionsRunTime.checkPermission(this, this.myPermissionConstantsArrayList, this.REQUEST_CODE_PERMISSION_MULTIPLE);
                        return;
                    }
                }
            }
            int i3 = this.PERMISSION_TYPE;
            if (i3 == 1 || i3 != 2) {
                return;
            }
            OpenChooser();
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void imgClick() {
        final CharSequence[] charSequenceArr = {getResources().getString(R.string.take_photo), getResources().getString(R.string.choose_from_gallery), getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.add_photo));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.GroupChatActivityFirebase$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupChatActivityFirebase.imgClick$lambda$10(charSequenceArr, this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imgClick$lambda$10(CharSequence[] charSequenceArr, GroupChatActivityFirebase groupChatActivityFirebase, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (Intrinsics.areEqual(charSequenceArr[i], groupChatActivityFirebase.getResources().getString(R.string.take_photo))) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(groupChatActivityFirebase, "com.eduteria.app.app.provider", new File(groupChatActivityFirebase.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_image.jpg"));
                groupChatActivityFirebase.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                groupChatActivityFirebase.someActivityResultLauncher.launch(intent);
                groupChatActivityFirebase.requestCode = 10000;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (Intrinsics.areEqual(charSequenceArr[i], groupChatActivityFirebase.getResources().getString(R.string.choose_from_gallery))) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Uri uriForFile2 = FileProvider.getUriForFile(groupChatActivityFirebase, "com.eduteria.app.app.provider", new File(groupChatActivityFirebase.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_gallery.jpg"));
            groupChatActivityFirebase.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            groupChatActivityFirebase.someActivityResultLauncher.launch(intent2);
            groupChatActivityFirebase.requestCode = 20000;
            return;
        }
        if (Intrinsics.areEqual(charSequenceArr[i], groupChatActivityFirebase.getResources().getString(R.string.cancel))) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropImage$lambda$11(GroupChatActivityFirebase groupChatActivityFirebase, CropImageView.CropResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!result.isSuccessful()) {
            Log.d("TAGCropImage", "CropImage: " + result.getError());
            return;
        }
        if (StringsKt.equals(groupChatActivityFirebase.str_imgTypeClick, "PhotoCameraRequest", true)) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(groupChatActivityFirebase.getContentResolver(), result.getUriContent());
                new File(groupChatActivityFirebase.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/Utkarsh/Profile/").mkdirs();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                String str = groupChatActivityFirebase.Chat_node;
                groupChatActivityFirebase.s3IU = new s3ImageUploading(str, "vc-10000386-38616500102/application/chat_system/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, groupChatActivityFirebase, groupChatActivityFirebase, null);
                ArrayList arrayList = new ArrayList();
                MediaFile mediaFile = new MediaFile();
                mediaFile.setFile_type("image");
                mediaFile.setImage(bitmapDecodeStream);
                arrayList.add(mediaFile);
                s3ImageUploading s3imageuploading = groupChatActivityFirebase.s3IU;
                Intrinsics.checkNotNull(s3imageuploading);
                s3imageuploading.execute(arrayList);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                Unit unit = Unit.INSTANCE;
                return;
            }
        }
        if (StringsKt.equals(groupChatActivityFirebase.str_imgTypeClick, "PhotoGalleryRequest", true)) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(groupChatActivityFirebase.getContentResolver(), result.getUriContent());
                String str2 = groupChatActivityFirebase.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/utkarsh/ProfileImage/";
                new File(str2).mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2 + File.separator + (MakeMyExam.userId + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                String str3 = groupChatActivityFirebase.Chat_node;
                groupChatActivityFirebase.s3IU = new s3ImageUploading(str3, "vc-10000386-38616500102/application/chat_system/" + str3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, groupChatActivityFirebase, groupChatActivityFirebase, null);
                ArrayList arrayList2 = new ArrayList();
                MediaFile mediaFile2 = new MediaFile();
                mediaFile2.setFile_type("image");
                mediaFile2.setImage(bitmap2);
                arrayList2.add(mediaFile2);
                s3ImageUploading s3imageuploading2 = groupChatActivityFirebase.s3IU;
                Intrinsics.checkNotNull(s3imageuploading2);
                s3imageuploading2.execute(arrayList2);
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
    public static final void someActivityResultLauncher$lambda$12(GroupChatActivityFirebase groupChatActivityFirebase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            if (groupChatActivityFirebase.requestCode == 10000 && result.getResultCode() == -1) {
                try {
                    File file = new File(String.valueOf(groupChatActivityFirebase.getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
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
                    Uri uriForFile = FileProvider.getUriForFile(groupChatActivityFirebase, "com.eduteria.app.app.provider", file);
                    ActivityResultLauncher<CropImageContractOptions> activityResultLauncher = groupChatActivityFirebase.cropImage;
                    CropImageOptions cropImageOptions = Helper.cropImageOptions(groupChatActivityFirebase);
                    Intrinsics.checkNotNullExpressionValue(cropImageOptions, "cropImageOptions(...)");
                    activityResultLauncher.launch(new CropImageContractOptions(uriForFile, cropImageOptions));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (groupChatActivityFirebase.requestCode == 20000 && result.getResultCode() == -1) {
                try {
                    Intent data = result.getData();
                    Intrinsics.checkNotNull(data);
                    Uri data2 = data.getData();
                    ActivityResultLauncher<CropImageContractOptions> activityResultLauncher2 = groupChatActivityFirebase.cropImage;
                    CropImageOptions cropImageOptions2 = Helper.cropImageOptions(groupChatActivityFirebase);
                    Intrinsics.checkNotNullExpressionValue(cropImageOptions2, "cropImageOptions(...)");
                    activityResultLauncher2.launch(new CropImageContractOptions(data2, cropImageOptions2));
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (groupChatActivityFirebase.requestCode == 101 && result.getResultCode() == -1 && result.getData() != null) {
                if (Build.VERSION.SDK_INT >= 30) {
                    Intent data3 = result.getData();
                    Intrinsics.checkNotNull(data3);
                    Uri data4 = data3.getData();
                    String string = groupChatActivityFirebase.getString(R.string.pdf_path_last_segment);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    groupChatActivityFirebase.setupDoc(groupChatActivityFirebase.copyFileToInternalStorage(data4, string));
                    return;
                }
                Intent data5 = result.getData();
                Intrinsics.checkNotNull(data5);
                String path = RealPathUtil.getPath(groupChatActivityFirebase, data5.getData());
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                groupChatActivityFirebase.setupDoc(path);
            }
        }
    }

    private final String copyFileToInternalStorage(Uri uri, String newDirName) {
        File file;
        ContentResolver contentResolver = getContentResolver();
        Intrinsics.checkNotNull(uri);
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        Intrinsics.checkNotNull(cursorQuery);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (!Intrinsics.areEqual(newDirName, "")) {
            File file2 = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        } else {
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        }
        try {
            if (!file.exists()) {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    Intrinsics.checkNotNull(inputStreamOpenInputStream);
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                inputStreamOpenInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path;
    }

    public final void setupDoc(String selectedURI) {
        Intrinsics.checkNotNullParameter(selectedURI, "selectedURI");
        MediaFile mediaFile = new MediaFile();
        ArrayList arrayList = new ArrayList();
        String str = selectedURI;
        if (!TextUtils.isEmpty(str)) {
            String string = getResources().getString(R.string.pdf_extension);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) string, false, 2, (Object) null)) {
                String string2 = getResources().getString(R.string.doc_extension);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                if (!StringsKt.contains$default((CharSequence) str, (CharSequence) string2, false, 2, (Object) null)) {
                    String string3 = getResources().getString(R.string.xls_extension);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    if (!StringsKt.contains$default((CharSequence) str, (CharSequence) string3, false, 2, (Object) null)) {
                        Toast.makeText(this, getResources().getString(R.string.file_format_error), 0).show();
                        return;
                    }
                }
            }
        }
        String string4 = getResources().getString(R.string.pdf_extension);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) string4, false, 2, (Object) null)) {
            mediaFile.setImage(BitmapFactory.decodeResource(getResources(), R.mipmap.pdf));
            mediaFile.setFile_type(Const.PDF);
        }
        String str2 = this.Chat_node;
        this.s3IU = new s3ImageUploading(str2, "vc-10000386-38616500102/application/chat_system/" + str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
        String[] strArr = (String[]) new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(str, 0).toArray(new String[0]);
        mediaFile.setFile_name(strArr[strArr.length - 1]);
        mediaFile.setFile(selectedURI);
        mediaFile.setFile_type(Const.PDF);
        arrayList.add(mediaFile);
        s3ImageUploading s3imageuploading = this.s3IU;
        Intrinsics.checkNotNull(s3imageuploading);
        s3imageuploading.execute(arrayList);
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        String str;
        DatabaseReference databaseReferencePush;
        if (images == null || images.isEmpty()) {
            return;
        }
        String file = images.get(0).getFile();
        Intrinsics.checkNotNullExpressionValue(file, "getFile(...)");
        if (StringsKt.contains$default((CharSequence) file, (CharSequence) ".pdf", false, 2, (Object) null)) {
            str = Const.PDF;
        } else {
            String file2 = images.get(0).getFile();
            Intrinsics.checkNotNullExpressionValue(file2, "getFile(...)");
            if (StringsKt.contains$default((CharSequence) file2, (CharSequence) ".mp3", false, 2, (Object) null)) {
                str = "audio";
            } else {
                str = "image";
            }
        }
        String str2 = str;
        try {
            String file3 = images.get(0).getFile();
            Intrinsics.checkNotNullExpressionValue(file3, "getFile(...)");
            String str3 = file3;
            int length = str3.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str3.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (Intrinsics.areEqual(str3.subSequence(i, length + 1).toString(), "")) {
                return;
            }
            DoubtChatPojo doubtChatPojo = new DoubtChatPojo(MakeMyExam.userId, images.get(0).getFile(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", str2, this.doubtId);
            DatabaseReference databaseReference = this.mFirebaseDatabaseReference;
            if (databaseReference != null && (databaseReferencePush = databaseReference.push()) != null) {
                databaseReferencePush.setValue(doubtChatPojo);
            }
            Helper.hideKeyboard(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
