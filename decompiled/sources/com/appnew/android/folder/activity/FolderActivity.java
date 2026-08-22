package com.appnew.android.folder.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Notification.Notification;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityFolderBinding;
import com.appnew.android.folder.fragments.FolderFragment;
import com.appnew.android.home.Constants;
import com.appnew.android.player.LiveStreamingYoutube;
import com.appnew.android.player.Liveawsactivity;
import com.appnew.android.player.VODPlayerActivity;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodulessc.TestBaseActivitySSCPattern;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: FolderActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0014J\b\u0010t\u001a\u00020qH\u0002J\u001c\u0010~\u001a\u0004\u0018\u00010*2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020*H\u0002J\u000f\u0010\u0082\u0001\u001a\u00020q2\u0006\u0010\\\u001a\u00020]J\u0018\u0010\u0083\u0001\u001a\u00020q2\u0006\u0010\\\u001a\u00020]2\u0007\u0010\u0084\u0001\u001a\u00020%J\t\u0010\u0085\u0001\u001a\u00020qH\u0015J0\u0010\u0086\u0001\u001a\u00020q2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020*2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010*2\u0007\u0010\u008b\u0001\u001a\u00020HH\u0016J\t\u0010\u008c\u0001\u001a\u00020qH\u0002J0\u0010\u008d\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020*2\u0007\u0010\u0090\u0001\u001a\u00020*2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J4\u0010\u0093\u0001\u001a\u00020q2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010*2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010*2\u0007\u0010\u0096\u0001\u001a\u00020%H\u0016J*\u0010\u0097\u0001\u001a\u00020q2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010*2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010*2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010*H\u0016J\t\u0010\u0098\u0001\u001a\u00020qH\u0014J\t\u0010\u0099\u0001\u001a\u00020qH\u0003R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u001a\u00102\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\u001a\u00105\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R\u001a\u00108\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\u001a\u0010;\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001a\u0010>\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R\u001a\u0010A\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010,\"\u0004\bC\u0010.R\u001a\u0010D\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R\u001a\u0010G\u001a\u00020HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010&\"\u0004\bO\u0010(R\u000e\u0010P\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010\\\u001a\u00020]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010J\"\u0004\bj\u0010LR\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010n\u001a\u00020HX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bo\u0010JR\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020w0vX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010x\u001a\b\u0012\u0004\u0012\u00020y0vX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}¨\u0006\u009a\u0001"}, d2 = {"Lcom/appnew/android/folder/activity/FolderActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/LiveClass/interface_/OnDataSendListener;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityFolderBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityFolderBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityFolderBinding;)V", "singleStudyModel", "Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "getSingleStudyModel", "()Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "setSingleStudyModel", "(Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;)V", "examPrepItem", "Lcom/appnew/android/Model/Courses/ExamPrepItem;", "getExamPrepItem", "()Lcom/appnew/android/Model/Courses/ExamPrepItem;", "setExamPrepItem", "(Lcom/appnew/android/Model/Courses/ExamPrepItem;)V", "lists", "Lcom/appnew/android/Model/Courses/Lists;", "getLists", "()Lcom/appnew/android/Model/Courses/Lists;", "setLists", "(Lcom/appnew/android/Model/Courses/Lists;)V", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "isCombo", "", "()Z", "setCombo", "(Z)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "content_type", "getContent_type", "setContent_type", Const.TEST_TYPE, "getTest_type", "setTest_type", "tileIdAPI", "getTileIdAPI", "setTileIdAPI", "tileTypeAPI", "getTileTypeAPI", "setTileTypeAPI", "revertAPI", "getRevertAPI", "setRevertAPI", "mainCourseId", "getMainCourseId", "setMainCourseId", "parentCourseId", "getParentCourseId", "setParentCourseId", Const.FOLDER_ID, "getFolder_id", "setFolder_id", "hitCount", "", "getHitCount", "()I", "setHitCount", "(I)V", "firstTime", "getFirstTime", "setFirstTime", Const.RATINGS, "courseId", "ratingMessage", "rating_type", "liveClassFeedback", "liveTestFeedback", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "requestCode", "getRequestCode", "setRequestCode", "feedbackDialog", "Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;", "isBottomSheetOpen", "REQUEST_CODE_MULTIPLE_PIKER", "getREQUEST_CODE_MULTIPLE_PIKER", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleBackPressed", "cropImage", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/canhub/cropper/CropImageContractOptions;", "someActivityResultLauncher", "Landroid/content/Intent;", "getSomeActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setSomeActivityResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "copyFileToInternalStorage", "uri", "Landroid/net/Uri;", "newDirName", "addFragment", "replaceFragment", "isAddToBackStack", "onDestroy", "onDataSent", "isLive", "", "particularId", "attemptOrReAttempt", "testOrVideo", "openFeedbackBottomSheet", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "onResume", "initListeners", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderActivity extends AppCompatActivity implements OnDataSendListener, NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public Activity activity;
    public ActivityFolderBinding binding;
    private Utils.FeedbackBottomSheetDialog feedbackDialog;
    private boolean firstTime;
    public Fragment fragment;
    private boolean isBottomSheetOpen;
    private boolean isCombo;
    private NetworkCall networkCall;
    private int rating_type;
    public UtkashRoom utkashRoom;
    private CourseDetail singleStudyModel = new CourseDetail();
    private ExamPrepItem examPrepItem = new ExamPrepItem();
    private Lists lists = new Lists();
    private String title = "";
    private String content_type = "";
    private String test_type = "";
    private String tileIdAPI = "";
    private String tileTypeAPI = "";
    private String revertAPI = "";
    private String mainCourseId = "";
    private String parentCourseId = "";
    private String folder_id = "0";
    private int hitCount = 1;
    private String rating = "";
    private String courseId = "";
    private String ratingMessage = "";
    private String liveClassFeedback = "";
    private String liveTestFeedback = "";
    private int requestCode = -1;
    private final int REQUEST_CODE_MULTIPLE_PIKER = 1203;
    private final ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.folder.activity.FolderActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            FolderActivity.cropImage$lambda$3((CropImageView.CropResult) obj);
        }
    });
    private ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.folder.activity.FolderActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            FolderActivity.someActivityResultLauncher$lambda$6(this.f$0, (ActivityResult) obj);
        }
    });

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public final ActivityFolderBinding getBinding() {
        ActivityFolderBinding activityFolderBinding = this.binding;
        if (activityFolderBinding != null) {
            return activityFolderBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityFolderBinding activityFolderBinding) {
        Intrinsics.checkNotNullParameter(activityFolderBinding, "<set-?>");
        this.binding = activityFolderBinding;
    }

    public final CourseDetail getSingleStudyModel() {
        return this.singleStudyModel;
    }

    public final void setSingleStudyModel(CourseDetail courseDetail) {
        Intrinsics.checkNotNullParameter(courseDetail, "<set-?>");
        this.singleStudyModel = courseDetail;
    }

    public final ExamPrepItem getExamPrepItem() {
        return this.examPrepItem;
    }

    public final void setExamPrepItem(ExamPrepItem examPrepItem) {
        Intrinsics.checkNotNullParameter(examPrepItem, "<set-?>");
        this.examPrepItem = examPrepItem;
    }

    public final Lists getLists() {
        return this.lists;
    }

    public final void setLists(Lists lists) {
        Intrinsics.checkNotNullParameter(lists, "<set-?>");
        this.lists = lists;
    }

    public final UtkashRoom getUtkashRoom() {
        UtkashRoom utkashRoom = this.utkashRoom;
        if (utkashRoom != null) {
            return utkashRoom;
        }
        Intrinsics.throwUninitializedPropertyAccessException("utkashRoom");
        return null;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    /* JADX INFO: renamed from: isCombo, reason: from getter */
    public final boolean getIsCombo() {
        return this.isCombo;
    }

    public final void setCombo(boolean z) {
        this.isCombo = z;
    }

    @Override // android.app.Activity
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getContent_type() {
        return this.content_type;
    }

    public final void setContent_type(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content_type = str;
    }

    public final String getTest_type() {
        return this.test_type;
    }

    public final void setTest_type(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.test_type = str;
    }

    public final String getTileIdAPI() {
        return this.tileIdAPI;
    }

    public final void setTileIdAPI(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tileIdAPI = str;
    }

    public final String getTileTypeAPI() {
        return this.tileTypeAPI;
    }

    public final void setTileTypeAPI(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tileTypeAPI = str;
    }

    public final String getRevertAPI() {
        return this.revertAPI;
    }

    public final void setRevertAPI(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.revertAPI = str;
    }

    public final String getMainCourseId() {
        return this.mainCourseId;
    }

    public final void setMainCourseId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainCourseId = str;
    }

    public final String getParentCourseId() {
        return this.parentCourseId;
    }

    public final void setParentCourseId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parentCourseId = str;
    }

    public final String getFolder_id() {
        return this.folder_id;
    }

    public final void setFolder_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.folder_id = str;
    }

    public final int getHitCount() {
        return this.hitCount;
    }

    public final void setHitCount(int i) {
        this.hitCount = i;
    }

    public final boolean getFirstTime() {
        return this.firstTime;
    }

    public final void setFirstTime(boolean z) {
        this.firstTime = z;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final Fragment getFragment() {
        Fragment fragment = this.fragment;
        if (fragment != null) {
            return fragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        return null;
    }

    public final void setFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.fragment = fragment;
    }

    public final Activity getActivity() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    public final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.activity = activity;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(int i) {
        this.requestCode = i;
    }

    public final int getREQUEST_CODE_MULTIPLE_PIKER() {
        return this.REQUEST_CODE_MULTIPLE_PIKER;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(ActivityFolderBinding.inflate(getLayoutInflater()));
        FolderActivity folderActivity = this;
        Helper.enableScreenShot(folderActivity);
        setContentView(getBinding().getRoot());
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            RelativeLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            Toolbar toolbar = getBinding().toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, window, root, toolbar);
        }
        setActivity(folderActivity);
        getBinding().title.setSelected(true);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.appnew.android.folder.activity.FolderActivity.onCreate.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                FolderActivity.this.handleBackPressed();
            }
        });
        initListeners();
        FolderActivity folderActivity2 = this;
        this.networkCall = new NetworkCall(this, folderActivity2);
        this.liveTestFeedback = SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK);
        this.liveClassFeedback = SharedPreference.getInstance().getString(Const.LIVE_CLASS_FEEDBACK);
        if (StringsKt.equals(BuildConfig.FLAVOR, "rankersGurukuls", true)) {
            ImageView imageView = getBinding().whatsappIcon;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            RelativeLayout relativeLayout = getBinding().notificationLL;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        } else {
            ImageView imageView2 = getBinding().whatsappIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = getBinding().notificationLL;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
        }
        ImageView imageView3 = getBinding().whatsappIcon;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.folder.activity.FolderActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FolderActivity.onCreate$lambda$0(this.f$0, view);
                }
            });
        }
        RelativeLayout relativeLayout3 = getBinding().notificationLL;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.folder.activity.FolderActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FolderActivity.onCreate$lambda$1(this.f$0);
                }
            }));
        }
        Intent intent = getIntent();
        if (intent != null) {
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SINGLE_STUDY_DATA))) {
                this.singleStudyModel = (CourseDetail) new Gson().fromJson(SharedPreference.getInstance().getString(Const.SINGLE_STUDY_DATA), CourseDetail.class);
            } else {
                this.singleStudyModel = new CourseDetail();
            }
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.EXAMPREP))) {
                this.examPrepItem = (ExamPrepItem) new Gson().fromJson(SharedPreference.getInstance().getString(Const.EXAMPREP), ExamPrepItem.class);
            } else {
                this.examPrepItem = new ExamPrepItem();
            }
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString("list"))) {
                this.lists = (Lists) new Gson().fromJson(SharedPreference.getInstance().getString("list"), Lists.class);
            } else {
                this.lists = new Lists();
            }
            this.isCombo = intent.getBooleanExtra(Const.IS_COMBO, false);
            String stringExtra = intent.getStringExtra("title");
            Intrinsics.checkNotNull(stringExtra);
            this.title = stringExtra;
            String stringExtra2 = intent.getStringExtra("content_type");
            Intrinsics.checkNotNull(stringExtra2);
            this.content_type = stringExtra2;
            String stringExtra3 = intent.getStringExtra("tile_id");
            Intrinsics.checkNotNull(stringExtra3);
            this.tileIdAPI = stringExtra3;
            String stringExtra4 = intent.getStringExtra(Const.TILE_TYPE);
            Intrinsics.checkNotNull(stringExtra4);
            this.tileTypeAPI = stringExtra4;
            String stringExtra5 = intent.getStringExtra(Const.REVERT_API);
            Intrinsics.checkNotNull(stringExtra5);
            this.revertAPI = stringExtra5;
            String stringExtra6 = intent.getStringExtra("firstTime");
            Intrinsics.checkNotNull(stringExtra6);
            this.firstTime = StringsKt.equals(stringExtra6, "1", true);
        }
        this.content_type = "content" + this.tileIdAPI;
        setUtkashRoom(UtkashRoom.getAppDatabase(folderActivity2));
        getUtkashRoom().getFolderDetails().deleteData();
        addFragment(FolderFragment.INSTANCE.newInstance(this.isCombo, this.title, this.content_type, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, "0", this.firstTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(FolderActivity folderActivity, View view) {
        Helper.openWhatsapp(folderActivity.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(FolderActivity folderActivity) {
        if (!Helper.isNetworkConnected(folderActivity.getActivity())) {
            Helper.showInternetToast(folderActivity.getActivity());
        }
        Helper.gotoActivity(folderActivity.getActivity(), (Class<?>) Notification.class);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
        getUtkashRoom().getFolderDetails().deleteDataParticular(String.valueOf(this.hitCount));
        this.hitCount--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropImage$lambda$3(CropImageView.CropResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isSuccessful()) {
            return;
        }
        Log.d("TAGCropImage", "CropImage: " + result.getError());
    }

    public final ActivityResultLauncher<Intent> getSomeActivityResultLauncher() {
        return this.someActivityResultLauncher;
    }

    public final void setSomeActivityResultLauncher(ActivityResultLauncher<Intent> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "<set-?>");
        this.someActivityResultLauncher = activityResultLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void someActivityResultLauncher$lambda$6(FolderActivity folderActivity, ActivityResult result) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(result, "result");
        if (folderActivity.requestCode == 10000 && result.getResultCode() == -1) {
            try {
                File file = new File(String.valueOf(folderActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
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
                Uri uriForFile = FileProvider.getUriForFile(folderActivity, "com.eduteria.app.app.provider", file);
                ActivityResultLauncher<CropImageContractOptions> activityResultLauncher = folderActivity.cropImage;
                CropImageOptions cropImageOptions = Helper.cropImageOptions(folderActivity);
                Intrinsics.checkNotNullExpressionValue(cropImageOptions, "cropImageOptions(...)");
                activityResultLauncher.launch(new CropImageContractOptions(uriForFile, cropImageOptions));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (folderActivity.requestCode == 20000 && result.getResultCode() == -1) {
            try {
                Intent data = result.getData();
                Intrinsics.checkNotNull(data);
                Uri data2 = data.getData();
                ActivityResultLauncher<CropImageContractOptions> activityResultLauncher2 = folderActivity.cropImage;
                CropImageOptions cropImageOptions2 = Helper.cropImageOptions(folderActivity);
                Intrinsics.checkNotNullExpressionValue(cropImageOptions2, "cropImageOptions(...)");
                activityResultLauncher2.launch(new CropImageContractOptions(data2, cropImageOptions2));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        Fragment fragmentFindFragmentById = folderActivity.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        SingleStudy singleStudy = fragmentFindFragmentById instanceof SingleStudy ? (SingleStudy) fragmentFindFragmentById : null;
        if (singleStudy != null) {
            singleStudy.onActivityResult(folderActivity.requestCode, result.getResultCode(), result.getData());
        }
        try {
            if (folderActivity.requestCode == folderActivity.REQUEST_CODE_MULTIPLE_PIKER && result.getResultCode() == -1 && result.getData() != null) {
                Intent data3 = result.getData();
                Intrinsics.checkNotNull(data3);
                Uri data4 = data3.getData();
                Intrinsics.checkNotNull(data4);
                String strCopyFileToInternalStorage = folderActivity.copyFileToInternalStorage(data4, "SubjectiveTestPDF");
                Intrinsics.checkNotNull(strCopyFileToInternalStorage);
                List<String> listSplit = new Regex(MqttTopic.TOPIC_LEVEL_SEPARATOR).split(strCopyFileToInternalStorage, 0);
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
                Helper.GoToWebViewPDFActivity(folderActivity, Constants.SUB_TEST_ID, strCopyFileToInternalStorage, false, ((String[]) listEmptyList.toArray(new String[0]))[r12.length - 1], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + Constants.SUB_TEST_ID, true, "CourseActivity", true);
            }
        } catch (Exception e4) {
            Toast.makeText(folderActivity, "Unable to upload this file", 0).show();
            e4.printStackTrace();
        }
    }

    private final String copyFileToInternalStorage(Uri uri, String newDirName) {
        File file;
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
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
        } catch (Exception unused) {
        }
        return file.getPath();
    }

    public final void addFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        setFragment(fragment);
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
    }

    public final void replaceFragment(Fragment fragment, boolean isAddToBackStack) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        setFragment(fragment);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment);
        if (isAddToBackStack) {
            fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        QuizActivity.setOnDataSendListener(null);
        TestBaseActivity.setOnDataSendListener(null);
        TestBaseActivitySSCPattern.INSTANCE.setOnDataSendListener(null);
        LiveStreamingYoutube.INSTANCE.setOnDataSendListener(null);
        VODPlayerActivity.setOnDataSendListener(null);
        Liveawsactivity.setOnDataSendListener(null);
        getUtkashRoom().getFolderDetails().deleteData();
    }

    @Override // com.appnew.android.LiveClass.interface_.OnDataSendListener
    public void onDataSent(long isLive, String particularId, String attemptOrReAttempt, int testOrVideo) {
        Intrinsics.checkNotNullParameter(particularId, "particularId");
        Log.e("TAG_APP", "onDataSent:FolderActivity ratingType " + testOrVideo + " " + isLive + ", particularId = " + particularId + " attemptOrReAttempt = " + attemptOrReAttempt);
        this.courseId = particularId;
        this.rating_type = testOrVideo;
        if ((TextUtils.isEmpty(this.liveTestFeedback) || !StringsKt.equals(this.liveTestFeedback, "1", true) || TextUtils.isEmpty(attemptOrReAttempt) || !StringsKt.equals$default(attemptOrReAttempt, Const.ATTEMPT, false, 2, null)) && (TextUtils.isEmpty(this.liveClassFeedback) || !StringsKt.equals(this.liveClassFeedback, "1", true))) {
            return;
        }
        openFeedbackBottomSheet();
    }

    private final void openFeedbackBottomSheet() {
        if (this.isBottomSheetOpen) {
            return;
        }
        this.isBottomSheetOpen = true;
        this.feedbackDialog = new Utils.FeedbackBottomSheetDialog(this, new Utils.FeedbackBottomSheetDialog.Listener() { // from class: com.appnew.android.folder.activity.FolderActivity.openFeedbackBottomSheet.1
            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onClose() {
                Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = FolderActivity.this.feedbackDialog;
                if (feedbackBottomSheetDialog != null) {
                    feedbackBottomSheetDialog.dismiss();
                }
                FolderActivity.this.isBottomSheetOpen = false;
            }

            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onSubmit() {
                String string;
                String string2;
                Editable text;
                String string3;
                Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = FolderActivity.this.feedbackDialog;
                RatingBar ratingBar = feedbackBottomSheetDialog != null ? (RatingBar) feedbackBottomSheetDialog.findViewById(R.id.ratingBar) : null;
                Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog2 = FolderActivity.this.feedbackDialog;
                EditText editText = feedbackBottomSheetDialog2 != null ? (EditText) feedbackBottomSheetDialog2.findViewById(R.id.ratingComment) : null;
                FolderActivity folderActivity = FolderActivity.this;
                if (ratingBar == null || (string = Float.valueOf(ratingBar.getRating()).toString()) == null) {
                    string = "0";
                }
                folderActivity.rating = string;
                FolderActivity folderActivity2 = FolderActivity.this;
                if (editText == null || (text = editText.getText()) == null || (string3 = text.toString()) == null || (string2 = StringsKt.trim((CharSequence) string3).toString()) == null) {
                    string2 = "";
                }
                folderActivity2.ratingMessage = string2;
                Float fValueOf = ratingBar != null ? Float.valueOf(ratingBar.getRating()) : null;
                Intrinsics.checkNotNull(fValueOf);
                if (fValueOf.floatValue() > 0.0f) {
                    if (FolderActivity.this.ratingMessage.length() == 0) {
                        Toast.makeText(FolderActivity.this, "Please write feedback!", 0).show();
                        return;
                    }
                    NetworkCall networkCall = FolderActivity.this.getNetworkCall();
                    if (networkCall != null) {
                        networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", false, false);
                    }
                    Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog3 = FolderActivity.this.feedbackDialog;
                    if (feedbackBottomSheetDialog3 != null) {
                        feedbackBottomSheetDialog3.dismiss();
                    }
                    FolderActivity.this.isBottomSheetOpen = false;
                    return;
                }
                Toast.makeText(FolderActivity.this, "Please provide rating!", 0).show();
            }
        });
        Utils utils = Utils.INSTANCE;
        Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = this.feedbackDialog;
        Intrinsics.checkNotNull(feedbackBottomSheetDialog);
        utils.bottomSheet(new Utils.FeedbackBottomSheetDialog[]{feedbackBottomSheetDialog});
        Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog2 = this.feedbackDialog;
        if (feedbackBottomSheetDialog2 != null) {
            feedbackBottomSheetDialog2.show();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.POST_COURSE_REVIEW)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.courseId);
        encryptionData.setRating(this.rating);
        encryptionData.setMessage(this.ratingMessage);
        encryptionData.setRating_type(Integer.valueOf(this.rating_type));
        return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        if (Intrinsics.areEqual(apitype, API.POST_COURSE_REVIEW)) {
            Utils.INSTANCE.showGreetingDialog(this, "Thank’s for your valuable feedback !");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        initListeners();
    }

    private final void initListeners() {
        FolderActivity folderActivity = this;
        QuizActivity.setOnDataSendListener(folderActivity);
        TestBaseActivity.setOnDataSendListener(folderActivity);
        TestBaseActivitySSCPattern.INSTANCE.setOnDataSendListener(folderActivity);
        LiveStreamingYoutube.INSTANCE.setOnDataSendListener(folderActivity);
        VODPlayerActivity.setOnDataSendListener(folderActivity);
        Liveawsactivity.setOnDataSendListener(folderActivity);
    }
}
