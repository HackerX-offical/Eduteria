package com.appnew.android.socket.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.pdf.PdfRenderer;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.databinding.ActivityGroupChat2Binding;
import com.appnew.android.socket.SocketManager;
import com.appnew.android.socket.activity.GroupChatActivity;
import com.appnew.android.socket.adapter.GroupChatAdapter2;
import com.appnew.android.socket.extension.SocketKt;
import com.appnew.android.socket.models.ChatModel;
import com.appnew.android.socket.models.GroupMessage;
import com.appnew.android.socket.models.GroupModel;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.facebook.appevents.iap.InAppPurchaseConstants;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: GroupChatActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\b\u0010J\u001a\u00020GH\u0002J\u0012\u0010T\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\b\u0010Y\u001a\u00020\u0007H\u0002J\u000e\u0010Z\u001a\u00020G2\u0006\u0010[\u001a\u00020\u0010J\u000e\u0010\\\u001a\u00020G2\u0006\u0010[\u001a\u00020\u0010J\u000e\u0010^\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0010J\u000e\u0010_\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0010J\u000e\u0010`\u001a\u00020G2\u0006\u0010[\u001a\u00020\u0010J\b\u0010a\u001a\u00020GH\u0002J\u0006\u0010b\u001a\u00020GJ\u0010\u0010l\u001a\u00020\u00132\b\u0010m\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010n\u001a\u00020G2\u0006\u0010o\u001a\u00020\u001aJ\u001a\u0010p\u001a\u00020\u001a2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020\u001aH\u0002J\u0018\u0010t\u001a\u00020G2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010\u000fH\u0016J\u0012\u0010w\u001a\u00020G2\b\u0010x\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010y\u001a\u00020GH\u0014J\b\u0010z\u001a\u00020GH\u0014J\u000e\u0010{\u001a\u00020G2\u0006\u0010|\u001a\u00020\u001aJ\b\u0010}\u001a\u00020GH\u0016J\b\u0010~\u001a\u00020GH\u0014J\b\u0010\u007f\u001a\u00020GH\u0002J\t\u0010\u0080\u0001\u001a\u00020GH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J3\u0010\u0082\u0001\u001a\u00020G2\u0006\u0010A\u001a\u00020\"2\u0010\u0010\u0083\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016¢\u0006\u0003\u0010\u0087\u0001J\t\u0010\u0088\u0001\u001a\u00020GH\u0002J\t\u0010\u0089\u0001\u001a\u00020GH\u0002J\u0010\u0010\u008a\u0001\u001a\u00020G2\u0007\u0010\u008b\u0001\u001a\u000206J\t\u0010\u008c\u0001\u001a\u00020GH\u0002J\u0007\u0010\u008d\u0001\u001a\u00020GJ\u0007\u0010\u008e\u0001\u001a\u00020GJ\u0007\u0010\u008f\u0001\u001a\u00020GJ\t\u0010\u0090\u0001\u001a\u00020GH\u0014J\t\u0010\u0091\u0001\u001a\u00020GH\u0002J\u0012\u0010\u0092\u0001\u001a\u00020G2\u0007\u0010\u0093\u0001\u001a\u00020\u001aH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001a\u0010K\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0014\"\u0004\bM\u0010\u0016R\u001a\u0010N\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0014\"\u0004\bP\u0010\u0016R\u0010\u0010Q\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020e0dX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010f\u001a\b\u0012\u0004\u0012\u00020g0dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k¨\u0006\u0094\u0001"}, d2 = {"Lcom/appnew/android/socket/activity/GroupChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/AmazonUpload/AmazonCallBack;", "Lcom/appnew/android/Utils/imagecropper/TakeImageClass$imagefromcropper;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityGroupChat2Binding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityGroupChat2Binding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityGroupChat2Binding;)V", "groupChatAdapter2", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2;", "chatList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/chatPojo;", "Lkotlin/collections/ArrayList;", "isChatPin", "", "()Z", "setChatPin", "(Z)V", "s3IU", "Lcom/appnew/android/Utils/AmazonUpload/s3ImageUploading;", "str_imgTypeClick", "", "Chat_node", "courseId", "dialog", "Landroid/app/Dialog;", "handler", "Landroid/os/Handler;", "seconds", "", "running", "wasRunning", "time", "fileName", "mediaPlayer", "Landroid/media/MediaPlayer;", "getMediaPlayer", "()Landroid/media/MediaPlayer;", "setMediaPlayer", "(Landroid/media/MediaPlayer;)V", "recorder", "Landroid/media/MediaRecorder;", "recordtime", "Landroid/widget/TextView;", "getRecordtime", "()Landroid/widget/TextView;", "setRecordtime", "(Landroid/widget/TextView;)V", "play", "Landroid/widget/Button;", "getPlay", "()Landroid/widget/Button;", "setPlay", "(Landroid/widget/Button;)V", "timer", "Ljava/util/Timer;", "socketManager", "Lcom/appnew/android/socket/SocketManager;", "chatModel", "Lcom/appnew/android/socket/models/ChatModel;", "requestCode", "downloadPdfReceiver", "Landroid/content/BroadcastReceiver;", "getDownloadPdfReceiver", "()Landroid/content/BroadcastReceiver;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "connectSocket", "hasAudioEnabled", "getHasAudioEnabled", "setHasAudioEnabled", "hasAttachmentEnabled", "getHasAttachmentEnabled", "setHasAttachmentEnabled", "pinnedChatMessage", "isAudioRecording", "isAudioPlaying", InAppPurchaseConstants.METHOD_SET_LISTENER, "hasUserScrolled", "hasNextData", "lastClickTime", "", "setData", "setPin", "chatPojo", "setUnPin", "chatPojoCurrent", "editChat", "copyChat", "deleteChat", "checkStoragePermission2", "openChooser", "cropImage", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/canhub/cropper/CropImageContractOptions;", "someActivityResultLauncher", "Landroid/content/Intent;", "getSomeActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setSomeActivityResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "isValidPDF", "downloadedFilePath", "setupDoc", "selectedURI", "copyFileToInternalStorage", "uri", "Landroid/net/Uri;", "newDirName", "onS3UploadData", Const.IMAGES, "Lcom/appnew/android/Model/MediaFile;", "imagePath", "str", "onResume", "onRestart", "changeThemeColor", "color", "onBackPressed", "onDestroy", "checkStoragePermission", "imgClick", "stopWatch", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "runTimer", "stopRecording", "onRecordBtnClicked", "record", "startRecording", "starttimer", "stoptimer", "sendaudio", "onPause", "pauseAudio", "updateRecyclerView", "messageId", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupChatActivity extends AppCompatActivity implements AmazonCallBack, TakeImageClass.imagefromcropper {
    public static final int $stable = 8;
    public ActivityGroupChat2Binding binding;
    private ChatModel chatModel;
    private chatPojo chatPojoCurrent;
    private Dialog dialog;
    private String fileName;
    private GroupChatAdapter2 groupChatAdapter2;
    private Handler handler;
    private boolean hasUserScrolled;
    private boolean isAudioPlaying;
    private boolean isChatPin;
    private long lastClickTime;
    private MediaPlayer mediaPlayer;
    private chatPojo pinnedChatMessage;
    private Button play;
    private MediaRecorder recorder;
    private TextView recordtime;
    private boolean running;
    private s3ImageUploading s3IU;
    private int seconds;
    private SocketManager socketManager;
    private Timer timer;
    private boolean wasRunning;
    private final ArrayList<chatPojo> chatList = new ArrayList<>();
    private String str_imgTypeClick = "";
    private String Chat_node = "";
    private String courseId = "";
    private String time = "";
    private int requestCode = -1;
    private final BroadcastReceiver downloadPdfReceiver = new GroupChatActivity$downloadPdfReceiver$1(this);
    private boolean hasAudioEnabled = true;
    private boolean hasAttachmentEnabled = true;
    private boolean isAudioRecording = true;
    private boolean hasNextData = true;
    private final ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda14
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            GroupChatActivity.cropImage$lambda$59(this.f$0, (CropImageView.CropResult) obj);
        }
    });
    private ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda15
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            GroupChatActivity.someActivityResultLauncher$lambda$60(this.f$0, (ActivityResult) obj);
        }
    });

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    public final ActivityGroupChat2Binding getBinding() {
        ActivityGroupChat2Binding activityGroupChat2Binding = this.binding;
        if (activityGroupChat2Binding != null) {
            return activityGroupChat2Binding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityGroupChat2Binding activityGroupChat2Binding) {
        Intrinsics.checkNotNullParameter(activityGroupChat2Binding, "<set-?>");
        this.binding = activityGroupChat2Binding;
    }

    /* JADX INFO: renamed from: isChatPin, reason: from getter */
    public final boolean getIsChatPin() {
        return this.isChatPin;
    }

    public final void setChatPin(boolean z) {
        this.isChatPin = z;
    }

    public final MediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    public final void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public final TextView getRecordtime() {
        return this.recordtime;
    }

    public final void setRecordtime(TextView textView) {
        this.recordtime = textView;
    }

    public final Button getPlay() {
        return this.play;
    }

    public final void setPlay(Button button) {
        this.play = button;
    }

    public final BroadcastReceiver getDownloadPdfReceiver() {
        return this.downloadPdfReceiver;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws JSONException {
        super.onCreate(savedInstanceState);
        GroupChatActivity groupChatActivity = this;
        Helper.setSystemBarLight(groupChatActivity);
        Helper.enableScreenShot(groupChatActivity);
        setBinding(ActivityGroupChat2Binding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        getBinding().toolbarTitleTV.setSelected(true);
        GroupChatActivity groupChatActivity2 = this;
        LocalBroadcastManager.getInstance(groupChatActivity2).registerReceiver(this.downloadPdfReceiver, new IntentFilter("DownloadPdf"));
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("data")) {
                Serializable serializableExtra = intent.getSerializableExtra("data");
                Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.appnew.android.socket.models.ChatModel");
                this.chatModel = (ChatModel) serializableExtra;
            }
            if (intent.hasExtra("courseId")) {
                String stringExtra = intent.getStringExtra("courseId");
                Intrinsics.checkNotNull(stringExtra);
                this.courseId = stringExtra;
            }
        }
        ChatModel chatModel = this.chatModel;
        if (chatModel != null && this.socketManager == null) {
            if (chatModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatModel");
                chatModel = null;
            }
            String group_id = chatModel.getGroup_id();
            Intrinsics.checkNotNull(group_id);
            this.Chat_node = group_id;
            setData();
            connectSocket();
            setListener(savedInstanceState);
        }
        Dexter.withContext(groupChatActivity2).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.socket.activity.GroupChatActivity.onCreate.2
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport p0) {
                System.out.println((Object) "Premission Granted");
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> p0, PermissionToken p1) {
                Intrinsics.checkNotNull(p1);
                p1.continuePermissionRequest();
            }
        });
    }

    private final void connectSocket() throws JSONException {
        final SocketManager socketManager = new SocketManager();
        this.socketManager = socketManager;
        ChatModel chatModel = this.chatModel;
        if (chatModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatModel");
            chatModel = null;
        }
        String socket_url = chatModel.getSocket_url();
        Intrinsics.checkNotNull(socket_url);
        socketManager.connect(socket_url);
        socketManager.joinRoom(this.Chat_node);
        SocketManager.fetchMessageHistory$default(socketManager, this.Chat_node, null, 2, null);
        socketManager.onMessageReceived("message", new Function1() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupChatActivity.connectSocket$lambda$40$lambda$4(this.f$0, (JSONObject) obj);
            }
        });
        SocketManager.listenForPinUnpin$default(socketManager, null, new Function1() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupChatActivity.connectSocket$lambda$40$lambda$9(this.f$0, socketManager, (JSONObject) obj);
            }
        }, 1, null);
        SocketManager.listenForChatDelete$default(socketManager, null, new Function1() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupChatActivity.connectSocket$lambda$40$lambda$14(this.f$0, (String) obj);
            }
        }, 1, null);
        SocketManager.listenForEditChat$default(socketManager, null, new Function1() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupChatActivity.connectSocket$lambda$40$lambda$18(this.f$0, (JSONObject) obj);
            }
        }, 1, null);
        SocketManager.listenOnce$default(socketManager, null, new Function1() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupChatActivity.connectSocket$lambda$40$lambda$34(this.f$0, (JSONArray) obj);
            }
        }, 1, null);
        SocketManager.listenForRoomEvents$default(socketManager, null, new Function1() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupChatActivity.connectSocket$lambda$40$lambda$38(this.f$0, socketManager, (JSONObject) obj);
            }
        }, 1, null);
        SocketManager.listenForBlockEvent$default(socketManager, null, new Function1() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GroupChatActivity.connectSocket$lambda$40$lambda$39(this.f$0, (String) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSocket$lambda$40$lambda$4(final GroupChatActivity groupChatActivity, JSONObject message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0) {
            chatPojo chatpojo = (chatPojo) new Gson().fromJson(message.toString(), chatPojo.class);
            chatpojo.setViewType(Const.CHAT);
            groupChatActivity.chatList.add(chatpojo);
            groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    GroupChatActivity.connectSocket$lambda$40$lambda$4$lambda$3(this.f$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$4$lambda$3(final GroupChatActivity groupChatActivity) {
        final ActivityGroupChat2Binding binding = groupChatActivity.getBinding();
        if (groupChatActivity.chatList.size() == 1) {
            ProgressBar progressBar = binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
            progressBar.setVisibility(8);
            RelativeLayout noDataFoundRL = binding.ndf.noDataFoundRL;
            Intrinsics.checkNotNullExpressionValue(noDataFoundRL, "noDataFoundRL");
            noDataFoundRL.setVisibility(8);
            RecyclerView chatRecycler = binding.chatRecycler;
            Intrinsics.checkNotNullExpressionValue(chatRecycler, "chatRecycler");
            chatRecycler.setVisibility(0);
            groupChatActivity.chatList.add(0, new chatPojo("date", DateTime.now().getMillis()));
            GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
            if (groupChatAdapter2 != null) {
                Intrinsics.checkNotNull(groupChatAdapter2);
                groupChatAdapter2.submitList(groupChatActivity.chatList);
                return;
            }
            return;
        }
        binding.chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.connectSocket$lambda$40$lambda$4$lambda$3$lambda$2$lambda$1(this.f$0, binding);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$4$lambda$3$lambda$2$lambda$1(GroupChatActivity groupChatActivity, ActivityGroupChat2Binding activityGroupChat2Binding) {
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.notifyDataSetChanged();
        }
        activityGroupChat2Binding.chatRecycler.smoothScrollToPosition(groupChatActivity.chatList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSocket$lambda$40$lambda$9(final GroupChatActivity groupChatActivity, final SocketManager socketManager, JSONObject message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0 && !groupChatActivity.chatList.isEmpty()) {
            Iterator<T> it = groupChatActivity.chatList.iterator();
            final int i = 0;
            final int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i3 = i2 + 1;
                chatPojo chatpojo = (chatPojo) it.next();
                if (Intrinsics.areEqual(chatpojo.getPin(), "1")) {
                    chatpojo.setPin("0");
                    groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda31
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupChatActivity.connectSocket$lambda$40$lambda$9$lambda$6(this.f$0, i2);
                        }
                    });
                    break;
                }
                i2 = i3;
            }
            Iterator<T> it2 = groupChatActivity.chatList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                int i4 = i + 1;
                chatPojo chatpojo2 = (chatPojo) it2.next();
                final chatPojo chatpojo3 = (chatPojo) new Gson().fromJson(message.toString(), chatPojo.class);
                if (Intrinsics.areEqual(chatpojo2.getId(), chatpojo3.getId())) {
                    chatpojo2.setPin(chatpojo3.getPin());
                    groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda32
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupChatActivity.connectSocket$lambda$40$lambda$9$lambda$8(this.f$0, chatpojo3, socketManager, i);
                        }
                    });
                    break;
                }
                i = i4;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$9$lambda$6(final GroupChatActivity groupChatActivity, final int i) {
        groupChatActivity.getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.connectSocket$lambda$40$lambda$9$lambda$6$lambda$5(this.f$0, i);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$9$lambda$6$lambda$5(GroupChatActivity groupChatActivity, int i) {
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void connectSocket$lambda$40$lambda$9$lambda$8(final com.appnew.android.socket.activity.GroupChatActivity r4, com.appnew.android.Model.chatPojo r5, com.appnew.android.socket.SocketManager r6, final int r7) {
        /*
            com.appnew.android.databinding.ActivityGroupChat2Binding r0 = r4.getBinding()
            androidx.recyclerview.widget.RecyclerView r0 = r0.chatRecycler
            com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda9 r1 = new com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda9
            r1.<init>()
            r2 = 200(0xc8, double:9.9E-322)
            r0.postDelayed(r1, r2)
            r4.pinnedChatMessage = r5
            r6.setPinnedMessage(r4, r5)
            com.appnew.android.databinding.ActivityGroupChat2Binding r5 = r4.getBinding()
            android.widget.RelativeLayout r5 = r5.pinnedLayout
            java.lang.String r6 = "pinnedLayout"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            android.view.View r5 = (android.view.View) r5
            com.appnew.android.Model.chatPojo r4 = r4.pinnedChatMessage
            r6 = 0
            if (r4 == 0) goto L38
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r4 = r4.getPin()
            java.lang.String r7 = "1"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r4 == 0) goto L38
            r4 = 1
            goto L39
        L38:
            r4 = r6
        L39:
            if (r4 == 0) goto L3c
            goto L3e
        L3c:
            r6 = 8
        L3e:
            r5.setVisibility(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.socket.activity.GroupChatActivity.connectSocket$lambda$40$lambda$9$lambda$8(com.appnew.android.socket.activity.GroupChatActivity, com.appnew.android.Model.chatPojo, com.appnew.android.socket.SocketManager, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$9$lambda$8$lambda$7(GroupChatActivity groupChatActivity, int i) {
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSocket$lambda$40$lambda$14(final GroupChatActivity groupChatActivity, final String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0 && !groupChatActivity.chatList.isEmpty()) {
            int i = 0;
            for (Object obj : groupChatActivity.chatList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final chatPojo chatpojo = (chatPojo) obj;
                if (Intrinsics.areEqual(chatpojo.getId(), message)) {
                    groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda13
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupChatActivity.connectSocket$lambda$40$lambda$14$lambda$13$lambda$12(this.f$0, chatpojo, message);
                        }
                    });
                }
                i = i2;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$14$lambda$13$lambda$12(final GroupChatActivity groupChatActivity, final chatPojo chatpojo, final String str) {
        groupChatActivity.getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.connectSocket$lambda$40$lambda$14$lambda$13$lambda$12$lambda$11(this.f$0, chatpojo, str);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$14$lambda$13$lambda$12$lambda$11(GroupChatActivity groupChatActivity, chatPojo chatpojo, String str) {
        GroupChatAdapter2 groupChatAdapter2;
        if (groupChatActivity.groupChatAdapter2 != null) {
            if (Intrinsics.areEqual(chatpojo.getType(), "audio") && (groupChatAdapter2 = groupChatActivity.groupChatAdapter2) != null) {
                groupChatAdapter2.releaseMediaPlayer();
            }
            groupChatActivity.updateRecyclerView(str);
            if (groupChatActivity.chatList.size() == 1) {
                groupChatActivity.chatList.clear();
                ActivityGroupChat2Binding binding = groupChatActivity.getBinding();
                ProgressBar progressBar = binding.progressBar;
                Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                progressBar.setVisibility(8);
                RelativeLayout noDataFoundRL = binding.ndf.noDataFoundRL;
                Intrinsics.checkNotNullExpressionValue(noDataFoundRL, "noDataFoundRL");
                noDataFoundRL.setVisibility(0);
                RecyclerView chatRecycler = binding.chatRecycler;
                Intrinsics.checkNotNullExpressionValue(chatRecycler, "chatRecycler");
                chatRecycler.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSocket$lambda$40$lambda$18(final GroupChatActivity groupChatActivity, JSONObject message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0 && !groupChatActivity.chatList.isEmpty()) {
            final int i = 0;
            for (Object obj : groupChatActivity.chatList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final chatPojo chatpojo = (chatPojo) new Gson().fromJson(message.toString(), chatPojo.class);
                if (Intrinsics.areEqual(((chatPojo) obj).getId(), chatpojo.getId())) {
                    groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda21
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupChatActivity.connectSocket$lambda$40$lambda$18$lambda$17$lambda$16(this.f$0, i, chatpojo);
                        }
                    });
                }
                i = i2;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$18$lambda$17$lambda$16(final GroupChatActivity groupChatActivity, final int i, final chatPojo chatpojo) {
        groupChatActivity.getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.connectSocket$lambda$40$lambda$18$lambda$17$lambda$16$lambda$15(this.f$0, i, chatpojo);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$18$lambda$17$lambda$16$lambda$15(GroupChatActivity groupChatActivity, int i, chatPojo chatpojo) {
        groupChatActivity.chatList.get(i).setMessage(chatpojo.getMessage());
        groupChatActivity.chatList.get(i).setIs_edited(chatpojo.getIs_edited());
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSocket$lambda$40$lambda$34(final GroupChatActivity groupChatActivity, JSONArray message) {
        Intrinsics.checkNotNullParameter(message, "message");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (message.length() > 0) {
            groupChatActivity.hasNextData = true;
            int length = message.length();
            for (int i2 = 0; i2 < length; i2++) {
                chatPojo chatpojo = (chatPojo) new Gson().fromJson(message.optJSONObject(i2).optString("message"), chatPojo.class);
                chatpojo.setViewType(Const.CHAT);
                arrayList.add(chatpojo);
            }
            if (arrayList.size() > 0) {
                CollectionsKt.reverse(arrayList);
                DateTime dateTime = new DateTime(((chatPojo) arrayList.get(0)).getDate());
                if (groupChatActivity.hasUserScrolled) {
                    groupChatActivity.hasUserScrolled = false;
                    groupChatActivity.chatList.remove(0);
                    final ArrayList arrayList2 = new ArrayList();
                    int i3 = 0;
                    for (Object obj : arrayList) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        chatPojo chatpojo2 = (chatPojo) obj;
                        if (!Intrinsics.areEqual(dateTime.dayOfMonth(), new DateTime(chatpojo2.getDate()).dayOfMonth())) {
                            arrayList2.add(new chatPojo("date", ((chatPojo) arrayList.get(i3)).getDate()));
                            dateTime = new DateTime(chatpojo2.getDate());
                        } else {
                            arrayList2.add(chatpojo2);
                        }
                        i3 = i4;
                    }
                    groupChatActivity.chatList.addAll(0, arrayList2);
                    groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda38
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$21(this.f$0, arrayList2);
                        }
                    });
                } else {
                    groupChatActivity.chatList.clear();
                    for (Object obj2 : arrayList) {
                        int i5 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        chatPojo chatpojo3 = (chatPojo) obj2;
                        if (!Intrinsics.areEqual(dateTime.dayOfMonth(), new DateTime(chatpojo3.getDate()).dayOfMonth())) {
                            groupChatActivity.chatList.add(new chatPojo("date", ((chatPojo) arrayList.get(i)).getDate()));
                            dateTime = new DateTime(chatpojo3.getDate());
                            groupChatActivity.chatList.add(chatpojo3);
                        } else {
                            groupChatActivity.chatList.add(chatpojo3);
                        }
                        i = i5;
                    }
                    groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda39
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$25(this.f$0);
                        }
                    });
                }
            } else if (groupChatActivity.hasUserScrolled) {
                groupChatActivity.hasUserScrolled = false;
                if (groupChatActivity.chatList.size() > 1) {
                    if (Intrinsics.areEqual(groupChatActivity.chatList.get(0).getViewType(), "loader")) {
                        groupChatActivity.chatList.remove(0);
                    } else if (Intrinsics.areEqual(groupChatActivity.chatList.get(0).getViewType(), Const.CHAT)) {
                        groupChatActivity.chatList.add(new chatPojo("date", groupChatActivity.chatList.get(0).getDate()));
                    }
                    groupChatActivity.getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda40
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$26(this.f$0);
                        }
                    }, 200L);
                }
            } else {
                groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda41
                    @Override // java.lang.Runnable
                    public final void run() {
                        GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$28(this.f$0);
                    }
                });
            }
        } else {
            if (groupChatActivity.hasUserScrolled) {
                groupChatActivity.hasUserScrolled = false;
                groupChatActivity.hasNextData = false;
            }
            if (groupChatActivity.chatList.size() > 1) {
                if (!Intrinsics.areEqual(groupChatActivity.chatList.get(0).getViewType(), "date")) {
                    groupChatActivity.chatList.remove(0);
                    groupChatActivity.chatList.add(0, new chatPojo("date", groupChatActivity.chatList.get(0).getDate()));
                    groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda42
                        @Override // java.lang.Runnable
                        public final void run() {
                            GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$31(this.f$0);
                        }
                    });
                }
            } else {
                groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda43
                    @Override // java.lang.Runnable
                    public final void run() {
                        GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$33(this.f$0);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$21(final GroupChatActivity groupChatActivity, final ArrayList arrayList) {
        groupChatActivity.getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$21$lambda$20(this.f$0, arrayList);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$21$lambda$20(GroupChatActivity groupChatActivity, ArrayList arrayList) {
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.notifyItemRangeInserted(0, arrayList.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$25(final GroupChatActivity groupChatActivity) {
        final ActivityGroupChat2Binding binding = groupChatActivity.getBinding();
        binding.chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$25$lambda$24$lambda$23(this.f$0, binding);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$25$lambda$24$lambda$23(GroupChatActivity groupChatActivity, ActivityGroupChat2Binding activityGroupChat2Binding) {
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.submitList(groupChatActivity.chatList);
        }
        ProgressBar progressBar = activityGroupChat2Binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        RelativeLayout noDataFoundRL = activityGroupChat2Binding.ndf.noDataFoundRL;
        Intrinsics.checkNotNullExpressionValue(noDataFoundRL, "noDataFoundRL");
        noDataFoundRL.setVisibility(8);
        RecyclerView chatRecycler = activityGroupChat2Binding.chatRecycler;
        Intrinsics.checkNotNullExpressionValue(chatRecycler, "chatRecycler");
        chatRecycler.setVisibility(0);
        activityGroupChat2Binding.chatRecycler.smoothScrollToPosition(groupChatActivity.chatList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$26(GroupChatActivity groupChatActivity) {
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        Intrinsics.checkNotNull(groupChatAdapter2);
        groupChatAdapter2.notifyItemRemoved(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$28(GroupChatActivity groupChatActivity) {
        ActivityGroupChat2Binding binding = groupChatActivity.getBinding();
        ProgressBar progressBar = binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        RelativeLayout noDataFoundRL = binding.ndf.noDataFoundRL;
        Intrinsics.checkNotNullExpressionValue(noDataFoundRL, "noDataFoundRL");
        noDataFoundRL.setVisibility(0);
        RecyclerView chatRecycler = binding.chatRecycler;
        Intrinsics.checkNotNullExpressionValue(chatRecycler, "chatRecycler");
        chatRecycler.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$31(final GroupChatActivity groupChatActivity) {
        groupChatActivity.getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$31$lambda$30(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$31$lambda$30(final GroupChatActivity groupChatActivity) {
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.notifyDataSetChanged();
            groupChatActivity.getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    GroupChatActivity.connectSocket$lambda$40$lambda$34$lambda$31$lambda$30$lambda$29(this.f$0);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$31$lambda$30$lambda$29(GroupChatActivity groupChatActivity) {
        groupChatActivity.getBinding().chatRecycler.smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$34$lambda$33(GroupChatActivity groupChatActivity) {
        ActivityGroupChat2Binding binding = groupChatActivity.getBinding();
        ProgressBar progressBar = binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        RelativeLayout noDataFoundRL = binding.ndf.noDataFoundRL;
        Intrinsics.checkNotNullExpressionValue(noDataFoundRL, "noDataFoundRL");
        noDataFoundRL.setVisibility(0);
        RecyclerView chatRecycler = binding.chatRecycler;
        Intrinsics.checkNotNullExpressionValue(chatRecycler, "chatRecycler");
        chatRecycler.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSocket$lambda$40$lambda$38(final GroupChatActivity groupChatActivity, final SocketManager socketManager, JSONObject message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.has("groups") && message.optJSONObject("groups") != null) {
            Gson gson = new Gson();
            JSONObject jSONObjectOptJSONObject = message.optJSONObject("groups");
            Intrinsics.checkNotNull(jSONObjectOptJSONObject);
            final GroupModel groupModel = (GroupModel) gson.fromJson(jSONObjectOptJSONObject.toString(), GroupModel.class);
            final ActivityGroupChat2Binding binding = groupChatActivity.getBinding();
            groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    GroupChatActivity.connectSocket$lambda$40$lambda$38$lambda$37$lambda$36$lambda$35(binding, groupModel, groupChatActivity, socketManager);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectSocket$lambda$40$lambda$38$lambda$37$lambda$36$lambda$35(ActivityGroupChat2Binding activityGroupChat2Binding, GroupModel groupModel, GroupChatActivity groupChatActivity, SocketManager socketManager) {
        LinearLayout endLayout = activityGroupChat2Binding.endLayout;
        Intrinsics.checkNotNullExpressionValue(endLayout, "endLayout");
        endLayout.setVisibility(Intrinsics.areEqual(groupModel.is_attachment(), "1") ? 0 : 8);
        ImageView attachment = activityGroupChat2Binding.attachment;
        Intrinsics.checkNotNullExpressionValue(attachment, "attachment");
        attachment.setVisibility(Intrinsics.areEqual(groupModel.is_attachment(), "1") ? 0 : 8);
        groupChatActivity.hasAttachmentEnabled = Intrinsics.areEqual(groupModel.is_attachment(), "1");
        ImageView voice = activityGroupChat2Binding.voice;
        Intrinsics.checkNotNullExpressionValue(voice, "voice");
        voice.setVisibility(Intrinsics.areEqual(groupModel.is_audio(), "1") ? 0 : 8);
        ImageView send = activityGroupChat2Binding.send;
        Intrinsics.checkNotNullExpressionValue(send, "send");
        send.setVisibility(!Intrinsics.areEqual(groupModel.is_audio(), "1") ? 0 : 8);
        groupChatActivity.hasAudioEnabled = Intrinsics.areEqual(groupModel.is_audio(), "1");
        if (groupModel.getGroupMessage() != null) {
            ArrayList<GroupMessage> groupMessage = groupModel.getGroupMessage();
            Intrinsics.checkNotNull(groupMessage);
            if (groupMessage.isEmpty()) {
                return;
            }
            ArrayList<GroupMessage> groupMessage2 = groupModel.getGroupMessage();
            Intrinsics.checkNotNull(groupMessage2);
            chatPojo message = groupMessage2.get(0).getMessage();
            groupChatActivity.pinnedChatMessage = message;
            socketManager.setPinnedMessage(groupChatActivity, message);
            RelativeLayout pinnedLayout = activityGroupChat2Binding.pinnedLayout;
            Intrinsics.checkNotNullExpressionValue(pinnedLayout, "pinnedLayout");
            pinnedLayout.setVisibility(groupChatActivity.pinnedChatMessage != null ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSocket$lambda$40$lambda$39(GroupChatActivity groupChatActivity, String blockEvents) {
        Intrinsics.checkNotNullParameter(blockEvents, "blockEvents");
        System.out.println((Object) blockEvents);
        groupChatActivity.finish();
        return Unit.INSTANCE;
    }

    public final boolean getHasAudioEnabled() {
        return this.hasAudioEnabled;
    }

    public final void setHasAudioEnabled(boolean z) {
        this.hasAudioEnabled = z;
    }

    public final boolean getHasAttachmentEnabled() {
        return this.hasAttachmentEnabled;
    }

    public final void setHasAttachmentEnabled(boolean z) {
        this.hasAttachmentEnabled = z;
    }

    private final ActivityGroupChat2Binding setListener(final Bundle savedInstanceState) {
        final ActivityGroupChat2Binding binding = getBinding();
        binding.attachment.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$41(this.f$0);
            }
        }));
        binding.pinnedLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$42(this.f$0);
            }
        }));
        binding.send.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$43(this.f$0, binding);
            }
        }));
        binding.pauseAudio.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$44(this.f$0, binding);
            }
        }));
        binding.cancelRecording.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$45(this.f$0, binding);
            }
        }));
        binding.sendRecording.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$46(this.f$0, binding);
            }
        }));
        binding.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$47(this.f$0);
            }
        }));
        binding.camera.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$48(this.f$0);
            }
        }));
        binding.voice.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$49(this.f$0, savedInstanceState);
            }
        }));
        binding.attachment.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$50(this.f$0);
            }
        }));
        binding.emoji.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$52(binding, this);
            }
        }));
        binding.cancel.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.setListener$lambda$54$lambda$53(binding);
            }
        }));
        binding.etMessage.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.socket.activity.GroupChatActivity$setListener$1$13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (this.this$0.getHasAudioEnabled()) {
                    ImageView send = binding.send;
                    Intrinsics.checkNotNullExpressionValue(send, "send");
                    send.setVisibility(String.valueOf(s).length() > 0 ? 0 : 8);
                    ImageView voice = binding.voice;
                    Intrinsics.checkNotNullExpressionValue(voice, "voice");
                    voice.setVisibility(String.valueOf(s).length() == 0 ? 0 : 8);
                }
                if (this.this$0.getHasAttachmentEnabled()) {
                    ImageView camera = binding.camera;
                    Intrinsics.checkNotNullExpressionValue(camera, "camera");
                    camera.setVisibility(String.valueOf(s).length() == 0 ? 0 : 8);
                }
                if (String.valueOf(s).length() > 210) {
                    ViewGroup.LayoutParams layoutParams = binding.bottomLayout.getLayoutParams();
                    layoutParams.height = SocketKt.dpToPixels(this.this$0, 120);
                    binding.bottomLayout.setLayoutParams(layoutParams);
                    binding.etMessage.setScrollContainer(true);
                    ViewGroup.LayoutParams layoutParams2 = binding.space.getLayoutParams();
                    layoutParams2.height = SocketKt.dpToPixels(this.this$0, 100);
                    binding.space.setLayoutParams(layoutParams2);
                    return;
                }
                if (String.valueOf(s).length() > 140) {
                    ViewGroup.LayoutParams layoutParams3 = binding.bottomLayout.getLayoutParams();
                    layoutParams3.height = SocketKt.dpToPixels(this.this$0, 100);
                    binding.bottomLayout.setLayoutParams(layoutParams3);
                    binding.etMessage.setScrollContainer(true);
                    ViewGroup.LayoutParams layoutParams4 = binding.space.getLayoutParams();
                    layoutParams4.height = SocketKt.dpToPixels(this.this$0, 80);
                    binding.space.setLayoutParams(layoutParams4);
                    return;
                }
                if (String.valueOf(s).length() > 70) {
                    ViewGroup.LayoutParams layoutParams5 = binding.bottomLayout.getLayoutParams();
                    layoutParams5.height = SocketKt.dpToPixels(this.this$0, 85);
                    binding.bottomLayout.setLayoutParams(layoutParams5);
                    binding.etMessage.setScrollContainer(false);
                    ViewGroup.LayoutParams layoutParams6 = binding.space.getLayoutParams();
                    layoutParams6.height = SocketKt.dpToPixels(this.this$0, 65);
                    binding.space.setLayoutParams(layoutParams6);
                    return;
                }
                if (String.valueOf(s).length() < 70) {
                    ViewGroup.LayoutParams layoutParams7 = binding.bottomLayout.getLayoutParams();
                    layoutParams7.height = SocketKt.dpToPixels(this.this$0, 70);
                    binding.bottomLayout.setLayoutParams(layoutParams7);
                    binding.etMessage.setScrollContainer(false);
                    ViewGroup.LayoutParams layoutParams8 = binding.space.getLayoutParams();
                    layoutParams8.height = SocketKt.dpToPixels(this.this$0, 50);
                    binding.space.setLayoutParams(layoutParams8);
                }
            }
        });
        binding.chatRecycler.addOnScrollListener(new GroupChatActivity$setListener$1$14(this, binding));
        return binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$41(GroupChatActivity groupChatActivity) {
        GroupChatActivity groupChatActivity2 = groupChatActivity;
        if (Helper.isNetworkConnected(groupChatActivity2)) {
            groupChatActivity.checkStoragePermission2();
        } else {
            Toast.makeText(groupChatActivity2, groupChatActivity.getResources().getString(R.string.no_internet_connection), 0).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$42(GroupChatActivity groupChatActivity) {
        ArrayList arrayList = new ArrayList();
        chatPojo chatpojo = groupChatActivity.pinnedChatMessage;
        Intrinsics.checkNotNull(chatpojo);
        chatpojo.setViewType(Const.CHAT);
        chatPojo chatpojo2 = groupChatActivity.pinnedChatMessage;
        Intrinsics.checkNotNull(chatpojo2);
        arrayList.add(chatpojo2);
        chatPojo chatpojo3 = groupChatActivity.pinnedChatMessage;
        Intrinsics.checkNotNull(chatpojo3);
        String type = chatpojo3.getType();
        if (Intrinsics.areEqual(type, Const.PDF)) {
            Intent intent = new Intent(groupChatActivity, (Class<?>) PdfDetailScreen.class);
            chatPojo chatpojo4 = groupChatActivity.pinnedChatMessage;
            Intrinsics.checkNotNull(chatpojo4);
            intent.putExtra("url", chatpojo4.getMessage());
            intent.putExtra("from", "ChatAdapter");
            groupChatActivity.startActivity(intent);
        } else if (Intrinsics.areEqual(type, "image")) {
            Intent intent2 = new Intent(groupChatActivity, (Class<?>) ChatImageViewActivity.class);
            chatPojo chatpojo5 = groupChatActivity.pinnedChatMessage;
            Intrinsics.checkNotNull(chatpojo5);
            intent2.putExtra("url", chatpojo5.getMessage());
            groupChatActivity.startActivity(intent2);
        } else {
            Intent intent3 = new Intent(groupChatActivity, (Class<?>) PinnedChatActivity.class);
            intent3.putExtra("data", arrayList);
            ChatModel chatModel = groupChatActivity.chatModel;
            if (chatModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatModel");
                chatModel = null;
            }
            intent3.putExtra("chat_model", chatModel);
            groupChatActivity.startActivity(intent3);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$43(GroupChatActivity groupChatActivity, ActivityGroupChat2Binding activityGroupChat2Binding) throws JSONException {
        chatPojo chatpojo;
        chatPojo chatpojo2 = new chatPojo("", groupChatActivity.getBinding().etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "text", groupChatActivity.courseId, Const.CHAT, "0", MakeMyExam.userId, "0");
        RelativeLayout editLayout = activityGroupChat2Binding.editLayout;
        Intrinsics.checkNotNullExpressionValue(editLayout, "editLayout");
        SocketManager socketManager = null;
        if (editLayout.getVisibility() == 0 && (chatpojo = groupChatActivity.chatPojoCurrent) != null) {
            Intrinsics.checkNotNull(chatpojo);
            chatpojo2.setId(chatpojo.getId());
            chatPojo chatpojo3 = groupChatActivity.chatPojoCurrent;
            Intrinsics.checkNotNull(chatpojo3);
            chatpojo2.setDate(chatpojo3.getDate());
            String message = chatpojo2.getMessage();
            chatPojo chatpojo4 = groupChatActivity.chatPojoCurrent;
            Intrinsics.checkNotNull(chatpojo4);
            if (Intrinsics.areEqual(message, chatpojo4.getMessage())) {
                chatpojo2.setIs_edited("0");
            } else {
                chatpojo2.setIs_edited("1");
            }
            SocketManager socketManager2 = groupChatActivity.socketManager;
            if (socketManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socketManager");
                socketManager2 = null;
            }
            String str = groupChatActivity.Chat_node;
            chatPojo chatpojo5 = groupChatActivity.chatPojoCurrent;
            Intrinsics.checkNotNull(chatpojo5);
            String id = chatpojo5.getId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            String json = new Gson().toJson(chatpojo2);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            socketManager2.editChat(str, id, json);
            groupChatActivity.chatPojoCurrent = null;
            RelativeLayout editLayout2 = activityGroupChat2Binding.editLayout;
            Intrinsics.checkNotNullExpressionValue(editLayout2, "editLayout");
            editLayout2.setVisibility(8);
        } else {
            SocketManager socketManager3 = groupChatActivity.socketManager;
            if (socketManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socketManager");
            } else {
                socketManager = socketManager3;
            }
            String str2 = groupChatActivity.Chat_node;
            String json2 = new Gson().toJson(chatpojo2);
            Intrinsics.checkNotNullExpressionValue(json2, "toJson(...)");
            socketManager.sendMessage(str2, json2);
        }
        groupChatActivity.getBinding().etMessage.getText().clear();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$44(GroupChatActivity groupChatActivity, ActivityGroupChat2Binding activityGroupChat2Binding) {
        if (groupChatActivity.isAudioRecording) {
            groupChatActivity.isAudioRecording = false;
            groupChatActivity.running = false;
            groupChatActivity.stopRecording();
            activityGroupChat2Binding.pauseAudio.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        } else if (!groupChatActivity.isAudioPlaying) {
            if (groupChatActivity.seconds == 0) {
                Toast.makeText(groupChatActivity, groupChatActivity.getResources().getString(R.string.please_record_audio), 0).show();
            } else {
                MediaPlayer mediaPlayerCreate = MediaPlayer.create(groupChatActivity, Uri.parse(groupChatActivity.fileName));
                groupChatActivity.mediaPlayer = mediaPlayerCreate;
                if (mediaPlayerCreate != null) {
                    mediaPlayerCreate.start();
                }
                Button button = groupChatActivity.play;
                if (button != null) {
                    button.setText(groupChatActivity.getResources().getString(R.string.pause));
                }
                groupChatActivity.starttimer();
            }
            activityGroupChat2Binding.pauseAudio.setImageResource(R.drawable.ic_baseline_pause_24);
            groupChatActivity.isAudioPlaying = true;
        } else {
            groupChatActivity.isAudioPlaying = false;
            groupChatActivity.stoptimer();
            Button button2 = groupChatActivity.play;
            if (button2 != null) {
                button2.setText(groupChatActivity.getResources().getString(R.string.play));
            }
            MediaPlayer mediaPlayer = groupChatActivity.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            mediaPlayer.pause();
            activityGroupChat2Binding.pauseAudio.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$45(GroupChatActivity groupChatActivity, ActivityGroupChat2Binding activityGroupChat2Binding) {
        groupChatActivity.stopRecording();
        MediaPlayer mediaPlayer = groupChatActivity.mediaPlayer;
        if (mediaPlayer != null) {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = groupChatActivity.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
            }
        }
        groupChatActivity.seconds = 0;
        groupChatActivity.running = false;
        groupChatActivity.fileName = "";
        Handler handler = groupChatActivity.handler;
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacksAndMessages(null);
        LinearLayout audioMainLL = activityGroupChat2Binding.audioMainLL;
        Intrinsics.checkNotNullExpressionValue(audioMainLL, "audioMainLL");
        audioMainLL.setVisibility(8);
        LinearLayout textLayout = activityGroupChat2Binding.textLayout;
        Intrinsics.checkNotNullExpressionValue(textLayout, "textLayout");
        textLayout.setVisibility(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$46(GroupChatActivity groupChatActivity, ActivityGroupChat2Binding activityGroupChat2Binding) {
        GroupChatActivity groupChatActivity2 = groupChatActivity;
        if (Helper.isNetworkConnected(groupChatActivity2)) {
            String str = groupChatActivity.fileName;
            if (str == "" || str == null) {
                Toast.makeText(groupChatActivity2, groupChatActivity.getResources().getString(R.string.please_record_audio), 0).show();
            } else {
                MediaPlayer mediaPlayer = groupChatActivity.mediaPlayer;
                if (mediaPlayer != null) {
                    Intrinsics.checkNotNull(mediaPlayer);
                    if (mediaPlayer.isPlaying()) {
                        MediaPlayer mediaPlayer2 = groupChatActivity.mediaPlayer;
                        Intrinsics.checkNotNull(mediaPlayer2);
                        mediaPlayer2.pause();
                    }
                }
                groupChatActivity.seconds = 0;
                groupChatActivity.running = false;
                groupChatActivity.sendaudio();
                Handler handler = groupChatActivity.handler;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacksAndMessages(null);
            }
            LinearLayout audioMainLL = activityGroupChat2Binding.audioMainLL;
            Intrinsics.checkNotNullExpressionValue(audioMainLL, "audioMainLL");
            audioMainLL.setVisibility(8);
            LinearLayout textLayout = activityGroupChat2Binding.textLayout;
            Intrinsics.checkNotNullExpressionValue(textLayout, "textLayout");
            textLayout.setVisibility(0);
        } else {
            Toast.makeText(groupChatActivity2, groupChatActivity.getResources().getString(R.string.no_internet_connection), 0).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$47(GroupChatActivity groupChatActivity) throws JSONException {
        groupChatActivity.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$48(GroupChatActivity groupChatActivity) {
        GroupChatActivity groupChatActivity2 = groupChatActivity;
        if (Helper.isNetworkConnected(groupChatActivity2)) {
            groupChatActivity.checkStoragePermission();
        } else {
            Helper.showInternetToast(groupChatActivity2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$49(GroupChatActivity groupChatActivity, Bundle bundle) {
        GroupChatActivity groupChatActivity2 = groupChatActivity;
        if (Helper.isNetworkConnected(groupChatActivity2)) {
            Object systemService = groupChatActivity.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(VibrationEffect.createOneShot(100L, -1));
            groupChatActivity.stopWatch(bundle);
        } else {
            Helper.showInternetToast(groupChatActivity2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$50(GroupChatActivity groupChatActivity) {
        GroupChatActivity groupChatActivity2 = groupChatActivity;
        if (Helper.isNetworkConnected(groupChatActivity2)) {
            groupChatActivity.checkStoragePermission2();
        } else {
            Helper.showInternetToast(groupChatActivity2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$52(final ActivityGroupChat2Binding activityGroupChat2Binding, GroupChatActivity groupChatActivity) {
        activityGroupChat2Binding.etMessage.requestFocus();
        Object systemService = groupChatActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        final InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        inputMethodManager.showSoftInput(activityGroupChat2Binding.etMessage, 1);
        activityGroupChat2Binding.etMessage.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.setListener$lambda$54$lambda$52$lambda$51(inputMethodManager, activityGroupChat2Binding);
            }
        }, 300L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListener$lambda$54$lambda$52$lambda$51(InputMethodManager inputMethodManager, ActivityGroupChat2Binding activityGroupChat2Binding) {
        inputMethodManager.showSoftInput(activityGroupChat2Binding.etMessage, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setListener$lambda$54$lambda$53(ActivityGroupChat2Binding activityGroupChat2Binding) {
        RelativeLayout editLayout = activityGroupChat2Binding.editLayout;
        Intrinsics.checkNotNullExpressionValue(editLayout, "editLayout");
        editLayout.setVisibility(8);
        activityGroupChat2Binding.etMessage.getText().clear();
        return Unit.INSTANCE;
    }

    private final ActivityGroupChat2Binding setData() {
        ChatModel chatModel;
        ActivityGroupChat2Binding binding = getBinding();
        GroupChatActivity groupChatActivity = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(groupChatActivity);
        linearLayoutManager.setAutoMeasureEnabled(false);
        linearLayoutManager.setStackFromEnd(true);
        binding.chatRecycler.setLayoutManager(linearLayoutManager);
        ChatModel chatModel2 = this.chatModel;
        ChatModel chatModel3 = null;
        if (chatModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatModel");
            chatModel2 = null;
        }
        String strValueOf = String.valueOf(chatModel2.is_out_app());
        ChatModel chatModel4 = this.chatModel;
        if (chatModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatModel");
            chatModel = null;
        } else {
            chatModel = chatModel4;
        }
        this.groupChatAdapter2 = new GroupChatAdapter2(groupChatActivity, strValueOf, chatModel, this.chatList, null, 16, null);
        binding.chatRecycler.setAdapter(this.groupChatAdapter2);
        TextView textView = binding.toolbarTitleTV;
        ChatModel chatModel5 = this.chatModel;
        if (chatModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatModel");
            chatModel5 = null;
        }
        textView.setText(chatModel5.getGroup_name());
        LinearLayout bottomLayout = binding.bottomLayout;
        Intrinsics.checkNotNullExpressionValue(bottomLayout, "bottomLayout");
        LinearLayout linearLayout = bottomLayout;
        ChatModel chatModel6 = this.chatModel;
        if (chatModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatModel");
        } else {
            chatModel3 = chatModel6;
        }
        linearLayout.setVisibility(Intrinsics.areEqual(chatModel3.is_send_message(), "1") ? 0 : 8);
        return binding;
    }

    public final void setPin(chatPojo chatPojo) {
        Intrinsics.checkNotNullParameter(chatPojo, "chatPojo");
        chatPojo.setPin("1");
        SocketManager socketManager = this.socketManager;
        if (socketManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketManager");
            socketManager = null;
        }
        String str = this.Chat_node;
        String id = chatPojo.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        String json = new Gson().toJson(chatPojo);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        socketManager.setPinUnPin(str, id, json);
    }

    public final void setUnPin(chatPojo chatPojo) {
        Intrinsics.checkNotNullParameter(chatPojo, "chatPojo");
        chatPojo.setPin("0");
        SocketManager socketManager = this.socketManager;
        if (socketManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketManager");
            socketManager = null;
        }
        String str = this.Chat_node;
        String id = chatPojo.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        String json = new Gson().toJson(chatPojo);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        socketManager.setPinUnPin(str, id, json);
    }

    public final ActivityGroupChat2Binding editChat(chatPojo chatPojo) {
        Intrinsics.checkNotNullParameter(chatPojo, "chatPojo");
        final ActivityGroupChat2Binding binding = getBinding();
        this.chatPojoCurrent = chatPojo;
        binding.etMessage.setText(chatPojo.getMessage());
        RelativeLayout editLayout = binding.editLayout;
        Intrinsics.checkNotNullExpressionValue(editLayout, "editLayout");
        editLayout.setVisibility(0);
        binding.etMessage.requestFocus();
        binding.etMessage.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                GroupChatActivity.editChat$lambda$57$lambda$56(this.f$0, binding);
            }
        }, 200L);
        return binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void editChat$lambda$57$lambda$56(GroupChatActivity groupChatActivity, ActivityGroupChat2Binding activityGroupChat2Binding) {
        EditText etMessage = activityGroupChat2Binding.etMessage;
        Intrinsics.checkNotNullExpressionValue(etMessage, "etMessage");
        SocketKt.showSoftKeyBoard(groupChatActivity, etMessage);
        activityGroupChat2Binding.etMessage.setSelection(activityGroupChat2Binding.etMessage.length());
    }

    public final ActivityGroupChat2Binding copyChat(chatPojo chatPojo) {
        Intrinsics.checkNotNullParameter(chatPojo, "chatPojo");
        ActivityGroupChat2Binding binding = getBinding();
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("label", chatPojo.getMessage());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        return binding;
    }

    public final void deleteChat(chatPojo chatPojo) {
        Intrinsics.checkNotNullParameter(chatPojo, "chatPojo");
        SocketManager socketManager = this.socketManager;
        if (socketManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketManager");
            socketManager = null;
        }
        String str = this.Chat_node;
        String id = chatPojo.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        socketManager.deleteChat(str, id);
    }

    private final void checkStoragePermission2() {
        GroupChatAdapter2 groupChatAdapter2 = this.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.pauseAudio();
        }
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.socket.activity.GroupChatActivity.checkStoragePermission2.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Intrinsics.checkNotNullParameter(report, "report");
                GroupChatActivity.this.openChooser();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(token, "token");
                token.continuePermissionRequest();
            }
        }).check();
    }

    public final void openChooser() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/pdf");
            intent.addFlags(1);
            this.someActivityResultLauncher.launch(intent);
            this.requestCode = 101;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropImage$lambda$59(GroupChatActivity groupChatActivity, CropImageView.CropResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!result.isSuccessful()) {
            Log.d("TAGCropImage", "CropImage: " + result.getError());
            return;
        }
        if (StringsKt.equals(groupChatActivity.str_imgTypeClick, "PhotoCameraRequest", true)) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(groupChatActivity.getContentResolver(), result.getUriContent());
                new File(groupChatActivity.getFilesDir() + "/Utkarsh/Profile/").mkdirs();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                String str = groupChatActivity.Chat_node;
                groupChatActivity.s3IU = new s3ImageUploading(str, "vc-10000386-38616500102/application/chat_system/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, groupChatActivity, groupChatActivity, null);
                ArrayList arrayList = new ArrayList();
                MediaFile mediaFile = new MediaFile();
                mediaFile.setFile_type("image");
                mediaFile.setImage(bitmapDecodeStream);
                arrayList.add(mediaFile);
                s3ImageUploading s3imageuploading = groupChatActivity.s3IU;
                Intrinsics.checkNotNull(s3imageuploading);
                s3imageuploading.execute(arrayList);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                Unit unit = Unit.INSTANCE;
                return;
            }
        }
        if (StringsKt.equals(groupChatActivity.str_imgTypeClick, "PhotoGalleryRequest", true)) {
            try {
                Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(groupChatActivity.getContentResolver(), result.getUriContent());
                String str2 = groupChatActivity.getFilesDir() + "/utkarsh/ProfileImage/";
                new File(str2).mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2 + File.separator + (MakeMyExam.userId + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                String str3 = groupChatActivity.Chat_node;
                groupChatActivity.s3IU = new s3ImageUploading(str3, "vc-10000386-38616500102/application/chat_system/" + str3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, groupChatActivity, groupChatActivity, null);
                ArrayList arrayList2 = new ArrayList();
                MediaFile mediaFile2 = new MediaFile();
                mediaFile2.setFile_type("image");
                mediaFile2.setImage(bitmap2);
                arrayList2.add(mediaFile2);
                s3ImageUploading s3imageuploading2 = groupChatActivity.s3IU;
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
    public static final void someActivityResultLauncher$lambda$60(GroupChatActivity groupChatActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            int i = groupChatActivity.requestCode;
            if (i == 10000) {
                try {
                    File file = new File(String.valueOf(groupChatActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
                    File[] fileArrListFiles = file.listFiles();
                    Intrinsics.checkNotNull(fileArrListFiles);
                    int length = fileArrListFiles.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        File file2 = fileArrListFiles[i2];
                        if (Intrinsics.areEqual(file2.getName(), "temp_image.jpg")) {
                            file = file2;
                            break;
                        }
                        i2++;
                    }
                    Uri uriForFile = FileProvider.getUriForFile(groupChatActivity, "com.eduteria.app.app.provider", file);
                    ActivityResultLauncher<CropImageContractOptions> activityResultLauncher = groupChatActivity.cropImage;
                    CropImageOptions cropImageOptions = Helper.cropImageOptions(groupChatActivity);
                    Intrinsics.checkNotNullExpressionValue(cropImageOptions, "cropImageOptions(...)");
                    activityResultLauncher.launch(new CropImageContractOptions(uriForFile, cropImageOptions));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (i == 20000) {
                try {
                    Intent data = result.getData();
                    Intrinsics.checkNotNull(data);
                    Uri data2 = data.getData();
                    ActivityResultLauncher<CropImageContractOptions> activityResultLauncher2 = groupChatActivity.cropImage;
                    CropImageOptions cropImageOptions2 = Helper.cropImageOptions(groupChatActivity);
                    Intrinsics.checkNotNullExpressionValue(cropImageOptions2, "cropImageOptions(...)");
                    activityResultLauncher2.launch(new CropImageContractOptions(data2, cropImageOptions2));
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (i != 101 || result.getData() == null) {
                return;
            }
            Intent data3 = result.getData();
            Intrinsics.checkNotNull(data3);
            Uri data4 = data3.getData();
            String string = groupChatActivity.getResources().getString(R.string.pdf_path_last_segment);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            groupChatActivity.setupDoc(groupChatActivity.copyFileToInternalStorage(data4, string));
        }
    }

    public final boolean isValidPDF(String downloadedFilePath) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(downloadedFilePath), 268435456);
            new PdfRenderer(parcelFileDescriptorOpen).close();
            parcelFileDescriptorOpen.close();
            Log.d("downloadedFilePath", "The PDF file is valid.");
            return true;
        } catch (Exception e2) {
            Log.d("downloadedFilePath", "eroor: " + e2.getMessage());
            return false;
        }
    }

    public final void setupDoc(String selectedURI) {
        List listEmptyList;
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
        if (!isValidPDF(selectedURI)) {
            Toast.makeText(this, getResources().getString(R.string.corrupt_file_error), 0).show();
            return;
        }
        String string4 = getResources().getString(R.string.pdf_extension);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) string4, false, 2, (Object) null)) {
            mediaFile.setImage(BitmapFactory.decodeResource(getResources(), R.mipmap.pdf));
            mediaFile.setFile_type(Const.PDF);
        }
        String str2 = this.Chat_node;
        this.s3IU = new s3ImageUploading(str2, "vc-10000386-38616500102/application/chat_system/" + str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
        List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(str, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        mediaFile.setFile_name(StringsKt.replace$default(strArr[strArr.length - 1], " ", "_", false, 4, (Object) null));
        mediaFile.setFile(selectedURI);
        mediaFile.setFile_type(Const.PDF);
        arrayList.add(mediaFile);
        s3ImageUploading s3imageuploading = this.s3IU;
        Intrinsics.checkNotNull(s3imageuploading);
        s3imageuploading.execute(arrayList);
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
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String strReplace$default = StringsKt.replace$default(string, "%", "", false, 4, (Object) null);
        String.valueOf(cursorQuery.getLong(columnIndex2));
        if (!Intrinsics.areEqual(newDirName, "")) {
            File file2 = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName + MqttTopic.TOPIC_LEVEL_SEPARATOR + StringsKt.replace$default(strReplace$default, "%", "", false, 4, (Object) null));
        } else {
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + StringsKt.replace$default(strReplace$default, "%", "", false, 4, (Object) null));
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

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        String str;
        ArrayList<MediaFile> arrayList = images;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        String file = images.get(0).getFile();
        Intrinsics.checkNotNullExpressionValue(file, "getFile(...)");
        SocketManager socketManager = null;
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
            chatPojo chatpojo = new chatPojo(MakeMyExam.userId, images.get(0).getFile(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", str2, this.courseId, Const.CHAT, "0", MakeMyExam.userId, "0");
            SocketManager socketManager2 = this.socketManager;
            if (socketManager2 != null) {
                if (socketManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("socketManager");
                    socketManager2 = null;
                }
                if (socketManager2.isConnected()) {
                    SocketManager socketManager3 = this.socketManager;
                    if (socketManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("socketManager");
                    } else {
                        socketManager = socketManager3;
                    }
                    String str4 = this.Chat_node;
                    String json = new Gson().toJson(chatpojo);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                    socketManager.sendMessage(str4, json);
                }
            }
            Helper.hideKeyboard(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") == null || TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            return;
        }
        String string = SharedPreference.getInstance().getString("theme_color_hai_bhai");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        changeThemeColor(string);
    }

    @Override // android.app.Activity
    protected void onRestart() throws JSONException {
        SocketManager socketManager = this.socketManager;
        if (socketManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketManager");
            socketManager = null;
        }
        if (!socketManager.isConnected()) {
            connectSocket();
        }
        super.onRestart();
    }

    public final void changeThemeColor(String color) {
        List listEmptyList;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(color, "color");
        String str = color;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            List<String> listSplit = new Regex(":").split(str, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (listEmptyList.toArray(new String[0]).length > 1) {
                SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(67108864);
                List<String> listSplit2 = new Regex(":").split(str, 0);
                if (!listSplit2.isEmpty()) {
                    ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                    while (listIterator2.hasPrevious()) {
                        if (listIterator2.previous().length() != 0) {
                            listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                            break;
                        }
                    }
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                window.setStatusBarColor(Color.parseColor(((String[]) listEmptyList2.toArray(new String[0]))[0]));
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() throws JSONException {
        pauseAudio();
        super.onBackPressed();
        SocketManager socketManager = this.socketManager;
        if (socketManager == null || this.chatModel == null) {
            return;
        }
        if (socketManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketManager");
            socketManager = null;
        }
        socketManager.leaveRoom(this.Chat_node);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        pauseAudio();
        super.onDestroy();
        SocketManager socketManager = this.socketManager;
        if (socketManager != null) {
            if (socketManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socketManager");
                socketManager = null;
            }
            socketManager.disconnect();
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.downloadPdfReceiver);
    }

    private final void checkStoragePermission() {
        GroupChatAdapter2 groupChatAdapter2 = this.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.pauseAudio();
        }
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.socket.activity.GroupChatActivity.checkStoragePermission.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Intrinsics.checkNotNullParameter(report, "report");
                GroupChatActivity.this.imgClick();
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
    public final void imgClick() {
        final CharSequence[] charSequenceArr = {getResources().getString(R.string.take_photo), getResources().getString(R.string.choose_from_gallery), getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.add_photo));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda36
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupChatActivity.imgClick$lambda$66(charSequenceArr, this, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void imgClick$lambda$66(CharSequence[] charSequenceArr, GroupChatActivity groupChatActivity, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (Intrinsics.areEqual(charSequenceArr[i], groupChatActivity.getResources().getString(R.string.take_photo))) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(groupChatActivity, "com.eduteria.app.app.provider", new File(groupChatActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_image.jpg"));
                groupChatActivity.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                groupChatActivity.someActivityResultLauncher.launch(intent);
                groupChatActivity.requestCode = 10000;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(charSequenceArr[i], groupChatActivity.getResources().getString(R.string.choose_from_gallery))) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Uri uriForFile2 = FileProvider.getUriForFile(groupChatActivity, "com.eduteria.app.app.provider", new File(groupChatActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_gallery.jpg"));
            groupChatActivity.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            groupChatActivity.someActivityResultLauncher.launch(intent2);
            groupChatActivity.requestCode = 20000;
            return;
        }
        if (Intrinsics.areEqual(charSequenceArr[i], groupChatActivity.getResources().getString(R.string.cancel))) {
            dialog.dismiss();
        }
    }

    private final ActivityGroupChat2Binding stopWatch(Bundle savedInstanceState) {
        final ActivityGroupChat2Binding binding = getBinding();
        if (savedInstanceState != null) {
            this.seconds = savedInstanceState.getInt("seconds");
            this.running = savedInstanceState.getBoolean("running");
            this.wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        LinearLayout textLayout = binding.textLayout;
        Intrinsics.checkNotNullExpressionValue(textLayout, "textLayout");
        textLayout.setVisibility(8);
        LinearLayout audioMainLL = binding.audioMainLL;
        Intrinsics.checkNotNullExpressionValue(audioMainLL, "audioMainLL");
        audioMainLL.setVisibility(0);
        Handler handler = new Handler();
        this.handler = handler;
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$stopWatch$1$1
            @Override // java.lang.Runnable
            public void run() {
                int i = this.this$0.seconds / 3600;
                int i2 = (this.this$0.seconds % 3600) / 60;
                int i3 = this.this$0.seconds % 60;
                GroupChatActivity groupChatActivity = this.this$0;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.getDefault(), "%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                groupChatActivity.time = str;
                binding.audioRecordTime.setText(this.this$0.time);
                if (this.this$0.running) {
                    this.this$0.seconds++;
                }
                Handler handler2 = this.this$0.handler;
                Intrinsics.checkNotNull(handler2);
                handler2.postDelayed(this, 1000L);
            }
        });
        if (ActivityCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 10);
        } else {
            this.seconds = 0;
            this.running = true;
            startRecording();
        }
        getBinding().pauseAudio.setImageResource(R.drawable.ic_baseline_pause_24);
        this.isAudioRecording = true;
        this.isAudioPlaying = false;
        return binding;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            if (!(grantResults.length == 0) && grantResults[0] == 0) {
                this.seconds = 0;
                this.running = true;
                startRecording();
                return;
            }
            ActivityGroupChat2Binding binding = getBinding();
            LinearLayout textLayout = binding.textLayout;
            Intrinsics.checkNotNullExpressionValue(textLayout, "textLayout");
            textLayout.setVisibility(0);
            LinearLayout audioMainLL = binding.audioMainLL;
            Intrinsics.checkNotNullExpressionValue(audioMainLL, "audioMainLL");
            audioMainLL.setVisibility(8);
            this.isAudioRecording = false;
        }
    }

    private final void runTimer() {
        GroupChatAdapter2 groupChatAdapter2 = this.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.pauseAudio();
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
        final Button button = (Button) dialog5.findViewById(R.id.record);
        Dialog dialog6 = this.dialog;
        Intrinsics.checkNotNull(dialog6);
        this.recordtime = (TextView) dialog6.findViewById(R.id.timerno);
        Dialog dialog7 = this.dialog;
        Intrinsics.checkNotNull(dialog7);
        this.play = (Button) dialog7.findViewById(R.id.play);
        Dialog dialog8 = this.dialog;
        Intrinsics.checkNotNull(dialog8);
        Button button2 = (Button) dialog8.findViewById(R.id.send);
        Dialog dialog9 = this.dialog;
        Intrinsics.checkNotNull(dialog9);
        Button button3 = (Button) dialog9.findViewById(R.id.cancel);
        Handler handler = new Handler();
        this.handler = handler;
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity.runTimer.1
            @Override // java.lang.Runnable
            public void run() {
                int i = GroupChatActivity.this.seconds / 3600;
                int i2 = (GroupChatActivity.this.seconds % 3600) / 60;
                int i3 = GroupChatActivity.this.seconds % 60;
                GroupChatActivity groupChatActivity = GroupChatActivity.this;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.getDefault(), "%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                groupChatActivity.time = str;
                TextView recordtime = GroupChatActivity.this.getRecordtime();
                if (recordtime != null) {
                    recordtime.setText(GroupChatActivity.this.time);
                }
                if (GroupChatActivity.this.running) {
                    GroupChatActivity.this.seconds++;
                }
                Handler handler2 = GroupChatActivity.this.handler;
                Intrinsics.checkNotNull(handler2);
                handler2.postDelayed(this, 1000L);
            }
        });
        button.setText(getResources().getString(R.string.record));
        button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.runTimer$lambda$69(this.f$0);
            }
        }));
        button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.runTimer$lambda$70(button, this);
            }
        }));
        Button button4 = this.play;
        if (button4 != null) {
            button4.setText(getResources().getString(R.string.play));
        }
        Button button5 = this.play;
        if (button5 != null) {
            button5.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GroupChatActivity.runTimer$lambda$71(button, this);
                }
            }));
        }
        button3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GroupChatActivity.runTimer$lambda$72(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$69(GroupChatActivity groupChatActivity) {
        GroupChatActivity groupChatActivity2 = groupChatActivity;
        if (Helper.isNetworkConnected(groupChatActivity2)) {
            String str = groupChatActivity.fileName;
            if (str == "" || str == null) {
                Toast.makeText(groupChatActivity2, groupChatActivity.getResources().getString(R.string.please_record_audio), 0).show();
            } else {
                MediaPlayer mediaPlayer = groupChatActivity.mediaPlayer;
                if (mediaPlayer != null) {
                    Intrinsics.checkNotNull(mediaPlayer);
                    if (mediaPlayer.isPlaying()) {
                        MediaPlayer mediaPlayer2 = groupChatActivity.mediaPlayer;
                        Intrinsics.checkNotNull(mediaPlayer2);
                        mediaPlayer2.pause();
                    }
                }
                groupChatActivity.seconds = 0;
                groupChatActivity.running = false;
                groupChatActivity.sendaudio();
                Handler handler = groupChatActivity.handler;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacksAndMessages(null);
                Dialog dialog = groupChatActivity.dialog;
                Intrinsics.checkNotNull(dialog);
                dialog.dismiss();
            }
        } else {
            Toast.makeText(groupChatActivity2, groupChatActivity.getResources().getString(R.string.no_internet_connection), 0).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$70(Button button, GroupChatActivity groupChatActivity) {
        if (Intrinsics.areEqual(button.getText(), "Record")) {
            Intrinsics.checkNotNull(button);
            groupChatActivity.onRecordBtnClicked(button);
        } else if (Intrinsics.areEqual(button.getText(), "Stop")) {
            button.setText(groupChatActivity.getResources().getString(R.string.record));
            groupChatActivity.running = false;
            groupChatActivity.stopRecording();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$71(Button button, GroupChatActivity groupChatActivity) {
        if (!Intrinsics.areEqual(button.getText(), "Stop")) {
            Button button2 = groupChatActivity.play;
            if (Intrinsics.areEqual(button2 != null ? button2.getText() : null, "Play")) {
                if (groupChatActivity.seconds == 0) {
                    Toast.makeText(groupChatActivity, groupChatActivity.getResources().getString(R.string.please_record_audio), 0).show();
                } else {
                    MediaPlayer mediaPlayerCreate = MediaPlayer.create(groupChatActivity, Uri.parse(groupChatActivity.fileName));
                    groupChatActivity.mediaPlayer = mediaPlayerCreate;
                    if (mediaPlayerCreate != null) {
                        mediaPlayerCreate.start();
                    }
                    Button button3 = groupChatActivity.play;
                    if (button3 != null) {
                        button3.setText(groupChatActivity.getResources().getString(R.string.pause));
                    }
                    groupChatActivity.starttimer();
                }
            } else {
                Button button4 = groupChatActivity.play;
                if (Intrinsics.areEqual(button4 != null ? button4.getText() : null, "Pause")) {
                    groupChatActivity.stoptimer();
                    Button button5 = groupChatActivity.play;
                    if (button5 != null) {
                        button5.setText(groupChatActivity.getResources().getString(R.string.play));
                    }
                    MediaPlayer mediaPlayer = groupChatActivity.mediaPlayer;
                    Intrinsics.checkNotNull(mediaPlayer);
                    mediaPlayer.pause();
                }
            }
        } else {
            Helper.showToast(groupChatActivity, groupChatActivity.getResources().getString(R.string.you_can_not_play_the_audio_while_record), 0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runTimer$lambda$72(GroupChatActivity groupChatActivity) {
        groupChatActivity.stopRecording();
        MediaPlayer mediaPlayer = groupChatActivity.mediaPlayer;
        if (mediaPlayer != null) {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = groupChatActivity.mediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.pause();
            }
        }
        groupChatActivity.seconds = 0;
        groupChatActivity.running = false;
        groupChatActivity.fileName = "";
        Dialog dialog = groupChatActivity.dialog;
        Intrinsics.checkNotNull(dialog);
        dialog.dismiss();
        Handler handler = groupChatActivity.handler;
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacksAndMessages(null);
        return Unit.INSTANCE;
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
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 10);
            return;
        }
        this.seconds = 0;
        this.running = true;
        record.setText(getResources().getString(R.string.stop));
        startRecording();
    }

    private final void startRecording() {
        Object systemService = getApplicationContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        audioManager.setMode(0);
        audioManager.setMicrophoneMute(false);
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
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        MediaRecorder mediaRecorder9 = this.recorder;
        Intrinsics.checkNotNull(mediaRecorder9);
        mediaRecorder9.start();
    }

    /* JADX INFO: renamed from: com.appnew.android.socket.activity.GroupChatActivity$starttimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GroupChatActivity.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/socket/activity/GroupChatActivity$starttimer$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C06471 extends TimerTask {
        C06471() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = GroupChatActivity.this.getMediaPlayer();
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                return;
            }
            GroupChatActivity.this.stoptimer();
            final GroupChatActivity groupChatActivity = GroupChatActivity.this;
            groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$starttimer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GroupChatActivity.C06471.run$lambda$0(groupChatActivity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(GroupChatActivity groupChatActivity) {
            groupChatActivity.getBinding().pauseAudio.setImageResource(R.drawable.ic_baseline_play_arrow_24);
            groupChatActivity.isAudioPlaying = false;
        }
    }

    public final void starttimer() {
        Timer timer = new Timer();
        this.timer = timer;
        Intrinsics.checkNotNull(timer);
        timer.schedule(new C06471(), 0L, 1000L);
    }

    public final void stoptimer() {
        Timer timer = this.timer;
        if (timer != null) {
            Intrinsics.checkNotNull(timer);
            timer.cancel();
            this.timer = null;
        }
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        pauseAudio();
        super.onPause();
    }

    private final void pauseAudio() {
        GroupChatAdapter2 groupChatAdapter2 = this.groupChatAdapter2;
        if (groupChatAdapter2 == null || groupChatAdapter2 == null) {
            return;
        }
        groupChatAdapter2.releaseMediaPlayer();
    }

    private final void updateRecyclerView(String messageId) {
        Iterator<chatPojo> it = this.chatList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), messageId)) {
                break;
            } else {
                i++;
            }
        }
        Log.e("TAG_APP", "updateRecyclerView: " + i + ", " + messageId);
        if (i != -1 && i < this.chatList.size()) {
            GroupChatAdapter2 groupChatAdapter2 = this.groupChatAdapter2;
            if (Intrinsics.areEqual(groupChatAdapter2 != null ? groupChatAdapter2.getCurrentlyPlayingId() : null, messageId)) {
                try {
                    GroupChatAdapter2 groupChatAdapter22 = this.groupChatAdapter2;
                    if (groupChatAdapter22 != null) {
                        groupChatAdapter22.releaseMediaPlayer();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.chatList.remove(i);
            GroupChatAdapter2 groupChatAdapter23 = this.groupChatAdapter2;
            if (groupChatAdapter23 != null) {
                groupChatAdapter23.notifyItemRemoved(i);
            }
            getBinding().chatRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    GroupChatActivity.updateRecyclerView$lambda$75(this.f$0);
                }
            }, 200L);
            return;
        }
        Log.w("ChatDelete", "Message not found or already removed: " + messageId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRecyclerView$lambda$75(GroupChatActivity groupChatActivity) {
        GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
        if (groupChatAdapter2 != null) {
            groupChatAdapter2.notifyDataSetChanged();
        }
    }
}
