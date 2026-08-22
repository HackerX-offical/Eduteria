package com.appnew.android.folder.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter;
import com.appnew.android.Dao.FolderDao;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.Video;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.FragmentFolderBinding;
import com.appnew.android.folder.SearchKt;
import com.appnew.android.folder.activity.FolderActivity;
import com.appnew.android.folder.adapter.FolderAdapter;
import com.appnew.android.folder.model.FolderModel;
import com.appnew.android.home.Constants;
import com.appnew.android.table.FolderEntity;
import com.appnew.android.table.VideosDownload;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: FolderFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 £\u00012\u00020\u00012\u00020\u0002:\u0002£\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0085\u0001\u001a\u00030\u0086\u00012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\u0013\u0010\u0089\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u008a\u0001\u001a\u00020IH\u0002J,\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\n\u0010\u0091\u0001\u001a\u00030\u0086\u0001H\u0003J\n\u0010\u0092\u0001\u001a\u00030\u0086\u0001H\u0017J\n\u0010\u0093\u0001\u001a\u00030\u0086\u0001H\u0002J2\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020N0\u0095\u00012\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010N2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010N2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\n\u0010\u009c\u0001\u001a\u00030\u0086\u0001H\u0016J4\u0010\u009d\u0001\u001a\u00030\u0086\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010d2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010N2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010N2\u0007\u0010\u009f\u0001\u001a\u00020IH\u0016J\n\u0010 \u0001\u001a\u00030\u0086\u0001H\u0002J+\u0010¡\u0001\u001a\u00030\u0086\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010N2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010N2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010NH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0017\u00109\u001a\b\u0012\u0004\u0012\u0002020:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R!\u0010=\u001a\u0012\u0012\u0004\u0012\u0002040>j\b\u0012\u0004\u0012\u000204`?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u0002020:¢\u0006\b\n\u0000\u001a\u0004\bE\u0010<R!\u0010F\u001a\u0012\u0012\u0004\u0012\u0002040>j\b\u0012\u0004\u0012\u000204`?¢\u0006\b\n\u0000\u001a\u0004\bG\u0010AR\u001a\u0010H\u001a\u00020IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\u001a\u0010V\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010P\"\u0004\bX\u0010RR\u001a\u0010Y\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010P\"\u0004\b[\u0010RR\u001a\u0010\\\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010P\"\u0004\b^\u0010RR\u001a\u0010_\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010P\"\u0004\ba\u0010RR\u000e\u0010b\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010c\u001a\u00020dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010J\"\u0004\bj\u0010LR\u001a\u0010k\u001a\u00020IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010J\"\u0004\bm\u0010LR\u001a\u0010n\u001a\u00020IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010J\"\u0004\bo\u0010LR\u000e\u0010p\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010q\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001a\u0010v\u001a\u00020IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010J\"\u0004\bx\u0010LR\u001a\u0010y\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010P\"\u0004\b{\u0010RR\u001a\u0010|\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010s\"\u0004\b~\u0010uR\u001c\u0010\u007f\u001a\u00020CX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010s\"\u0005\b\u0081\u0001\u0010uR\u001d\u0010\u0082\u0001\u001a\u00020CX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010s\"\u0005\b\u0084\u0001\u0010uR\u0010\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¢\u0001\u001a\u00030\u009b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lcom/appnew/android/folder/fragments/FolderFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "singleStudyModel", "Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "getSingleStudyModel", "()Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "setSingleStudyModel", "(Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;)V", "examPrepItem", "Lcom/appnew/android/Model/Courses/ExamPrepItem;", "getExamPrepItem", "()Lcom/appnew/android/Model/Courses/ExamPrepItem;", "setExamPrepItem", "(Lcom/appnew/android/Model/Courses/ExamPrepItem;)V", "lists", "Lcom/appnew/android/Model/Courses/Lists;", "getLists", "()Lcom/appnew/android/Model/Courses/Lists;", "setLists", "(Lcom/appnew/android/Model/Courses/Lists;)V", "binding", "Lcom/appnew/android/databinding/FragmentFolderBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentFolderBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentFolderBinding;)V", "roomDb", "Lcom/appnew/android/Room/UtkashRoom;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "folderAdapter", "Lcom/appnew/android/folder/adapter/FolderAdapter;", "getFolderAdapter", "()Lcom/appnew/android/folder/adapter/FolderAdapter;", "setFolderAdapter", "(Lcom/appnew/android/folder/adapter/FolderAdapter;)V", "examPrepLayer3Adapter", "Lcom/appnew/android/Courses/Adapter/ExamPrepLayer3Adapter;", "getExamPrepLayer3Adapter", "()Lcom/appnew/android/Courses/Adapter/ExamPrepLayer3Adapter;", "setExamPrepLayer3Adapter", "(Lcom/appnew/android/Courses/Adapter/ExamPrepLayer3Adapter;)V", "folderModel", "Lcom/appnew/android/folder/model/FolderModel;", "video", "Lcom/appnew/android/Model/Video;", "getVideo", "()Lcom/appnew/android/Model/Video;", "setVideo", "(Lcom/appnew/android/Model/Video;)V", "folderLists", "", "getFolderLists", "()Ljava/util/List;", "videoArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getVideoArrayList", "()Ljava/util/ArrayList;", "oldArraySize", "", "folderListsForApiSearch", "getFolderListsForApiSearch", "videoArrayListForApiSearch", "getVideoArrayListForApiSearch", "isCombo", "", "()Z", "setCombo", "(Z)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "contentType", "getContentType", "setContentType", "testType", "getTestType", "setTestType", "tileIdAPI", "getTileIdAPI", "setTileIdAPI", "tileTypeAPI", "getTileTypeAPI", "setTileTypeAPI", "revertAPI", "getRevertAPI", "setRevertAPI", "folderId", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "isPaginationAvailable", "setPaginationAvailable", "status", "getStatus", "setStatus", "isApiHitForSearch", "setApiHitForSearch", "isContentExit", "mPage", "getMPage", "()I", "setMPage", "(I)V", "firstTime", "getFirstTime", "setFirstTime", "searchStringMain", "getSearchStringMain", "setSearchStringMain", "lastScrollY", "getLastScrollY", "setLastScrollY", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "lastOffset", "getLastOffset", "setLastOffset", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "fetchData", "show", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "onResume", "loadFolderAndVideoData", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "videoDownloadReceiver", "Landroid/content/BroadcastReceiver;", "onDestroy", "SuccessCallBack", "jsonstring", "showprogress", "setFolderData", "ErrorCallBack", "audioServiceReceiver", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderFragment extends Fragment implements NetworkCall.MyNetworkCallBack {
    private FragmentFolderBinding binding;
    public JSONObject data;
    private ExamPrepLayer3Adapter examPrepLayer3Adapter;
    private boolean firstTime;
    private FolderAdapter folderAdapter;
    private FolderModel folderModel;
    private boolean isApiHitForSearch;
    private boolean isCombo;
    private boolean isContentExit;
    private int lastOffset;
    private int lastScrollY;
    private int lastVisibleItemPosition;
    public NetworkCall networkCall;
    private int oldArraySize;
    private UtkashRoom roomDb;
    private boolean status;
    public Video video;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private CourseDetail singleStudyModel = new CourseDetail();
    private ExamPrepItem examPrepItem = new ExamPrepItem();
    private Lists lists = new Lists();
    private final List<FolderModel> folderLists = new ArrayList();
    private final ArrayList<Video> videoArrayList = new ArrayList<>();
    private final List<FolderModel> folderListsForApiSearch = new ArrayList();
    private final ArrayList<Video> videoArrayListForApiSearch = new ArrayList<>();
    private String title = "";
    private String contentType = "";
    private String testType = "";
    private String tileIdAPI = "";
    private String tileTypeAPI = "";
    private String revertAPI = "";
    private String folderId = "";
    private boolean isPaginationAvailable = true;
    private int mPage = 1;
    private String searchStringMain = "";
    private final BroadcastReceiver videoDownloadReceiver = new BroadcastReceiver() { // from class: com.appnew.android.folder.fragments.FolderFragment$videoDownloadReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            int intExtra = intent.getIntExtra("result", -1);
            String stringExtra = intent.getStringExtra("resourceId");
            if (intExtra != 1 || this.this$0.getExamPrepLayer3Adapter() == null || Intrinsics.areEqual(stringExtra, "")) {
                return;
            }
            Iterator<Video> it = this.this$0.getVideoArrayList().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Video next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Video video = next;
                if (StringsKt.equals(video.getId(), stringExtra, true)) {
                    video.setVideo_download(true);
                    video.setVideo_status("Downloaded");
                    ExamPrepLayer3Adapter examPrepLayer3Adapter = this.this$0.getExamPrepLayer3Adapter();
                    Intrinsics.checkNotNull(examPrepLayer3Adapter);
                    examPrepLayer3Adapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    };
    private final BroadcastReceiver audioServiceReceiver = new BroadcastReceiver() { // from class: com.appnew.android.folder.fragments.FolderFragment$audioServiceReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            intent.getStringExtra("resourceId");
            if (booleanExtra) {
                ExamPrepLayer3Adapter examPrepLayer3Adapter = this.this$0.getExamPrepLayer3Adapter();
                Intrinsics.checkNotNull(examPrepLayer3Adapter);
                examPrepLayer3Adapter.notifyDataSetChanged();
            }
        }
    };

    @JvmStatic
    public static final Fragment newInstance(boolean z, String str, String str2, String str3, String str4, String str5, String str6, boolean z2) {
        return INSTANCE.newInstance(z, str, str2, str3, str4, str5, str6, z2);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
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

    public final FragmentFolderBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(FragmentFolderBinding fragmentFolderBinding) {
        this.binding = fragmentFolderBinding;
    }

    public final NetworkCall getNetworkCall() {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            return networkCall;
        }
        Intrinsics.throwUninitializedPropertyAccessException("networkCall");
        return null;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        Intrinsics.checkNotNullParameter(networkCall, "<set-?>");
        this.networkCall = networkCall;
    }

    public final FolderAdapter getFolderAdapter() {
        return this.folderAdapter;
    }

    public final void setFolderAdapter(FolderAdapter folderAdapter) {
        this.folderAdapter = folderAdapter;
    }

    public final ExamPrepLayer3Adapter getExamPrepLayer3Adapter() {
        return this.examPrepLayer3Adapter;
    }

    public final void setExamPrepLayer3Adapter(ExamPrepLayer3Adapter examPrepLayer3Adapter) {
        this.examPrepLayer3Adapter = examPrepLayer3Adapter;
    }

    public final Video getVideo() {
        Video video = this.video;
        if (video != null) {
            return video;
        }
        Intrinsics.throwUninitializedPropertyAccessException("video");
        return null;
    }

    public final void setVideo(Video video) {
        Intrinsics.checkNotNullParameter(video, "<set-?>");
        this.video = video;
    }

    public final List<FolderModel> getFolderLists() {
        return this.folderLists;
    }

    public final ArrayList<Video> getVideoArrayList() {
        return this.videoArrayList;
    }

    public final List<FolderModel> getFolderListsForApiSearch() {
        return this.folderListsForApiSearch;
    }

    public final ArrayList<Video> getVideoArrayListForApiSearch() {
        return this.videoArrayListForApiSearch;
    }

    /* JADX INFO: renamed from: isCombo, reason: from getter */
    public final boolean getIsCombo() {
        return this.isCombo;
    }

    public final void setCombo(boolean z) {
        this.isCombo = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final void setContentType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentType = str;
    }

    public final String getTestType() {
        return this.testType;
    }

    public final void setTestType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testType = str;
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

    public final JSONObject getData() {
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            return jSONObject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.data = jSONObject;
    }

    /* JADX INFO: renamed from: isPaginationAvailable, reason: from getter */
    public final boolean getIsPaginationAvailable() {
        return this.isPaginationAvailable;
    }

    public final void setPaginationAvailable(boolean z) {
        this.isPaginationAvailable = z;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    /* JADX INFO: renamed from: isApiHitForSearch, reason: from getter */
    public final boolean getIsApiHitForSearch() {
        return this.isApiHitForSearch;
    }

    public final void setApiHitForSearch(boolean z) {
        this.isApiHitForSearch = z;
    }

    public final int getMPage() {
        return this.mPage;
    }

    public final void setMPage(int i) {
        this.mPage = i;
    }

    public final boolean getFirstTime() {
        return this.firstTime;
    }

    public final void setFirstTime(boolean z) {
        this.firstTime = z;
    }

    public final String getSearchStringMain() {
        return this.searchStringMain;
    }

    public final void setSearchStringMain(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchStringMain = str;
    }

    public final int getLastScrollY() {
        return this.lastScrollY;
    }

    public final void setLastScrollY(int i) {
        this.lastScrollY = i;
    }

    public final int getLastVisibleItemPosition() {
        return this.lastVisibleItemPosition;
    }

    public final void setLastVisibleItemPosition(int i) {
        this.lastVisibleItemPosition = i;
    }

    public final int getLastOffset() {
        return this.lastOffset;
    }

    public final void setLastOffset(int i) {
        this.lastOffset = i;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (getActivity() instanceof FolderActivity) {
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.folder.activity.FolderActivity");
                this.singleStudyModel = ((FolderActivity) activity).getSingleStudyModel();
                FragmentActivity activity2 = getActivity();
                Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.folder.activity.FolderActivity");
                this.examPrepItem = ((FolderActivity) activity2).getExamPrepItem();
                FragmentActivity activity3 = getActivity();
                Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.appnew.android.folder.activity.FolderActivity");
                this.lists = ((FolderActivity) activity3).getLists();
            } else {
                this.singleStudyModel = new CourseDetail();
                this.examPrepItem = new ExamPrepItem();
                this.lists = new Lists();
            }
            this.isCombo = arguments.getBoolean("isCombo");
            String string = arguments.getString("title");
            Intrinsics.checkNotNull(string);
            this.title = string;
            String string2 = arguments.getString("content_type");
            Intrinsics.checkNotNull(string2);
            this.contentType = string2;
            String string3 = arguments.getString("tileIdAPI");
            Intrinsics.checkNotNull(string3);
            this.tileIdAPI = string3;
            String string4 = arguments.getString("tileTypeAPI");
            Intrinsics.checkNotNull(string4);
            this.tileTypeAPI = string4;
            String string5 = arguments.getString("revertAPI");
            Intrinsics.checkNotNull(string5);
            this.revertAPI = string5;
            String string6 = arguments.getString(Const.FOLDER_ID);
            Intrinsics.checkNotNull(string6);
            this.folderId = string6;
            this.firstTime = arguments.getBoolean("firstTime");
        }
        this.roomDb = UtkashRoom.getAppDatabase(getContext());
        setNetworkCall(new NetworkCall(this, getContext()));
    }

    private final void fetchData(boolean show) {
        if (this.networkCall != null) {
            getNetworkCall().NetworkAPICall(API.get_folder_list, "", show, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.binding = FragmentFolderBinding.inflate(getLayoutInflater(), container, false);
        initViews();
        FragmentFolderBinding fragmentFolderBinding = this.binding;
        Intrinsics.checkNotNull(fragmentFolderBinding);
        RelativeLayout root = fragmentFolderBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initViews() {
        Data data;
        CourseDetailData courseDetail;
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.videoDownloadReceiver, new IntentFilter(VideoDownloadService.VIDEO_DOWNLOAD_ACTION));
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.audioServiceReceiver, new IntentFilter(AudioPlayerService.AUDIO_PLAYER_ACTION));
        final FragmentFolderBinding fragmentFolderBinding = this.binding;
        Intrinsics.checkNotNull(fragmentFolderBinding);
        RecyclerView recyclerView = fragmentFolderBinding.folderRecycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView recyclerView2 = fragmentFolderBinding.fileRecycler;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        FragmentActivity activity = getActivity();
        CourseDetail courseDetail2 = this.singleStudyModel;
        ArrayList<Video> arrayList = this.videoArrayList;
        String str = this.tileIdAPI;
        ExamPrepLayer3Adapter examPrepLayer3Adapter = new ExamPrepLayer3Adapter(activity, courseDetail2, arrayList, str, this.tileTypeAPI, this.revertAPI, str, (courseDetail2 == null || (data = courseDetail2.getData()) == null || (courseDetail = data.getCourseDetail()) == null) ? null : courseDetail.getIsPurchased());
        this.examPrepLayer3Adapter = examPrepLayer3Adapter;
        examPrepLayer3Adapter.setFolderData(this.folderId, this.contentType);
        FragmentFolderBinding fragmentFolderBinding2 = this.binding;
        Intrinsics.checkNotNull(fragmentFolderBinding2);
        fragmentFolderBinding2.fileRecycler.setAdapter(this.examPrepLayer3Adapter);
        if (getActivity() instanceof FolderActivity) {
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.folder.activity.FolderActivity");
            ((FolderActivity) activity2).getBinding().homeBackIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.folder.fragments.FolderFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FolderFragment.initViews$lambda$9$lambda$4(this.f$0);
                }
            }));
        }
        FragmentFolderBinding fragmentFolderBinding3 = this.binding;
        Intrinsics.checkNotNull(fragmentFolderBinding3);
        fragmentFolderBinding3.pullToRefresh.setEnabled(false);
        FragmentFolderBinding fragmentFolderBinding4 = this.binding;
        Intrinsics.checkNotNull(fragmentFolderBinding4);
        fragmentFolderBinding4.pullToRefresh.setRefreshing(false);
        fragmentFolderBinding.nesterScollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.folder.fragments.FolderFragment$$ExternalSyntheticLambda1
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                FolderFragment.initViews$lambda$9$lambda$5(this.f$0, fragmentFolderBinding, nestedScrollView, i, i2, i3, i4);
            }
        });
        EditText search = fragmentFolderBinding.search;
        Intrinsics.checkNotNullExpressionValue(search, "search");
        SearchKt.inputEventListener(search, new Function1() { // from class: com.appnew.android.folder.fragments.FolderFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FolderFragment.initViews$lambda$9$lambda$8(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViews$lambda$9$lambda$4(final FolderFragment folderFragment) {
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.folder.fragments.FolderFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                FolderFragment.initViews$lambda$9$lambda$4$lambda$3(this.f$0);
            }
        }, 500L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$9$lambda$4$lambda$3(FolderFragment folderFragment) {
        FragmentActivity activity = folderFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.folder.activity.FolderActivity");
        ((FolderActivity) activity).onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$9$lambda$5(FolderFragment folderFragment, FragmentFolderBinding fragmentFolderBinding, NestedScrollView v, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(v, "v");
        folderFragment.lastScrollY = i2;
        FragmentFolderBinding fragmentFolderBinding2 = folderFragment.binding;
        Intrinsics.checkNotNull(fragmentFolderBinding2);
        RecyclerView.LayoutManager layoutManager = fragmentFolderBinding2.fileRecycler.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        folderFragment.lastVisibleItemPosition = iFindFirstVisibleItemPosition;
        View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
        folderFragment.lastOffset = viewFindViewByPosition != null ? viewFindViewByPosition.getTop() : 0;
        if (v.getChildAt(v.getChildCount() - 1) == null || i2 < v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight() || i2 <= i4 || fragmentFolderBinding.progressBar.isShown() || !folderFragment.isPaginationAvailable) {
            return;
        }
        fragmentFolderBinding.progressBar.setVisibility(0);
        folderFragment.mPage++;
        folderFragment.status = true;
        folderFragment.isApiHitForSearch = folderFragment.searchStringMain.length() > 0;
        folderFragment.fetchData(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViews$lambda$9$lambda$8(FolderFragment folderFragment, String result) {
        int i;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(result, "result");
        FolderAdapter folderAdapter = null;
        if (result.length() > 0) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (FolderModel folderModel : folderFragment.folderLists) {
                String lowerCase = folderModel.getTitle().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = result.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    arrayList2.add(folderModel);
                }
            }
            Iterator<Video> it = folderFragment.videoArrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Video next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Video video = next;
                String title = video.getTitle();
                Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
                String lowerCase3 = title.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                String lowerCase4 = result.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase4, false, 2, (Object) null)) {
                    arrayList3.add(video);
                }
            }
            if (arrayList2.isEmpty()) {
                i = 2;
            } else {
                Context context = folderFragment.getContext();
                if (context != null) {
                    FragmentActivity fragmentActivityRequireActivity = folderFragment.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                    CourseDetail courseDetail = folderFragment.singleStudyModel;
                    Intrinsics.checkNotNull(courseDetail);
                    ExamPrepItem examPrepItem = folderFragment.examPrepItem;
                    Intrinsics.checkNotNull(examPrepItem);
                    Lists lists = folderFragment.lists;
                    Intrinsics.checkNotNull(lists);
                    i = 2;
                    folderAdapter = new FolderAdapter(context, fragmentActivityRequireActivity, arrayList2, courseDetail, examPrepItem, lists, folderFragment.isCombo, folderFragment.title, folderFragment.contentType, folderFragment.tileIdAPI, folderFragment.tileTypeAPI, folderFragment.revertAPI);
                } else {
                    i = 2;
                }
                folderFragment.folderAdapter = folderAdapter;
                FragmentFolderBinding fragmentFolderBinding = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding);
                fragmentFolderBinding.folderRecycler.setAdapter(folderFragment.folderAdapter);
            }
            if (arrayList3.isEmpty()) {
                arrayList = arrayList3;
            } else {
                FragmentActivity activity = folderFragment.getActivity();
                CourseDetail courseDetail2 = folderFragment.singleStudyModel;
                String str = folderFragment.tileIdAPI;
                String str2 = folderFragment.tileTypeAPI;
                String str3 = folderFragment.revertAPI;
                Intrinsics.checkNotNull(courseDetail2);
                arrayList = arrayList3;
                ExamPrepLayer3Adapter examPrepLayer3Adapter = new ExamPrepLayer3Adapter(activity, courseDetail2, arrayList, str, str2, str3, str, courseDetail2.getData().getCourseDetail().getIsPurchased());
                folderFragment.examPrepLayer3Adapter = examPrepLayer3Adapter;
                examPrepLayer3Adapter.setFolderData(folderFragment.folderId, folderFragment.contentType);
                FragmentFolderBinding fragmentFolderBinding2 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding2);
                fragmentFolderBinding2.fileRecycler.setAdapter(folderFragment.examPrepLayer3Adapter);
            }
            if (arrayList2.isEmpty() && arrayList.isEmpty()) {
                FragmentFolderBinding fragmentFolderBinding3 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding3);
                fragmentFolderBinding3.folderRecycler.setVisibility(8);
                FragmentFolderBinding fragmentFolderBinding4 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding4);
                fragmentFolderBinding4.fileRecycler.setVisibility(8);
            }
            if (folderFragment.isPaginationAvailable && result.length() > i) {
                folderFragment.videoArrayListForApiSearch.clear();
                folderFragment.folderListsForApiSearch.clear();
                folderFragment.searchStringMain = result;
                folderFragment.mPage = 1;
                folderFragment.status = false;
                folderFragment.isApiHitForSearch = true;
                folderFragment.fetchData(false);
            }
        } else {
            folderFragment.searchStringMain = "";
            folderFragment.mPage = 1;
            folderFragment.status = false;
            folderFragment.isApiHitForSearch = false;
            if (folderFragment.folderLists.size() > 0) {
                FragmentFolderBinding fragmentFolderBinding5 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding5);
                fragmentFolderBinding5.folderRecycler.setVisibility(0);
                FragmentFolderBinding fragmentFolderBinding6 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding6);
                fragmentFolderBinding6.noData.noDataFoundRL.setVisibility(8);
                Context context2 = folderFragment.getContext();
                if (context2 != null) {
                    FragmentActivity fragmentActivityRequireActivity2 = folderFragment.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
                    List<FolderModel> list = folderFragment.folderLists;
                    CourseDetail courseDetail3 = folderFragment.singleStudyModel;
                    Intrinsics.checkNotNull(courseDetail3);
                    ExamPrepItem examPrepItem2 = folderFragment.examPrepItem;
                    Intrinsics.checkNotNull(examPrepItem2);
                    Lists lists2 = folderFragment.lists;
                    Intrinsics.checkNotNull(lists2);
                    folderAdapter = new FolderAdapter(context2, fragmentActivityRequireActivity2, list, courseDetail3, examPrepItem2, lists2, folderFragment.isCombo, folderFragment.title, folderFragment.contentType, folderFragment.tileIdAPI, folderFragment.tileTypeAPI, folderFragment.revertAPI);
                }
                folderFragment.folderAdapter = folderAdapter;
                FragmentFolderBinding fragmentFolderBinding7 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding7);
                fragmentFolderBinding7.folderRecycler.setAdapter(folderFragment.folderAdapter);
            }
            if (folderFragment.videoArrayList.size() > 0) {
                FragmentFolderBinding fragmentFolderBinding8 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding8);
                fragmentFolderBinding8.fileRecycler.setVisibility(0);
                FragmentFolderBinding fragmentFolderBinding9 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding9);
                fragmentFolderBinding9.noData.noDataFoundRL.setVisibility(8);
                FragmentActivity activity2 = folderFragment.getActivity();
                CourseDetail courseDetail4 = folderFragment.singleStudyModel;
                ArrayList<Video> arrayList4 = folderFragment.videoArrayList;
                String str4 = folderFragment.tileIdAPI;
                String str5 = folderFragment.tileTypeAPI;
                String str6 = folderFragment.revertAPI;
                Intrinsics.checkNotNull(courseDetail4);
                ExamPrepLayer3Adapter examPrepLayer3Adapter2 = new ExamPrepLayer3Adapter(activity2, courseDetail4, arrayList4, str4, str5, str6, str4, courseDetail4.getData().getCourseDetail().getIsPurchased());
                folderFragment.examPrepLayer3Adapter = examPrepLayer3Adapter2;
                examPrepLayer3Adapter2.setFolderData(folderFragment.folderId, folderFragment.contentType);
                FragmentFolderBinding fragmentFolderBinding10 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding10);
                fragmentFolderBinding10.fileRecycler.setAdapter(folderFragment.examPrepLayer3Adapter);
            }
            if (folderFragment.videoArrayList.size() == 0 && folderFragment.folderLists.size() == 0) {
                FragmentFolderBinding fragmentFolderBinding11 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding11);
                fragmentFolderBinding11.fileRecycler.setVisibility(8);
                FragmentFolderBinding fragmentFolderBinding12 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding12);
                fragmentFolderBinding12.folderRecycler.setVisibility(8);
                FragmentFolderBinding fragmentFolderBinding13 = folderFragment.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding13);
                fragmentFolderBinding13.noData.noDataFoundRL.setVisibility(0);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof FolderActivity) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.folder.activity.FolderActivity");
            ((FolderActivity) activity).getBinding().title.setText(this.title);
        }
        FragmentFolderBinding fragmentFolderBinding = this.binding;
        Intrinsics.checkNotNull(fragmentFolderBinding);
        fragmentFolderBinding.search.getText().clear();
        SharedPreference sharedPreference = SharedPreference.getInstance();
        boolean z = Intrinsics.areEqual(Constants.REFRESHPAGE, "true") || sharedPreference.getBoolean(Const.TEST_RESUME_STATE) || sharedPreference.getBoolean(Const.MARK_AS_READ);
        if (this.firstTime || z) {
            this.firstTime = false;
            Constants.REFRESHPAGE = "false";
            sharedPreference.putBoolean(Const.TEST_RESUME_STATE, false);
            sharedPreference.putBoolean(Const.MARK_AS_READ, false);
            this.mPage = 1;
            this.status = false;
            this.isApiHitForSearch = false;
            fetchData(true);
            return;
        }
        if (this.videoArrayList.isEmpty() && this.folderLists.isEmpty()) {
            if (getActivity() instanceof FolderActivity) {
                UtkashRoom utkashRoom = this.roomDb;
                if (utkashRoom == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                    utkashRoom = null;
                }
                FolderDao folderDetails = utkashRoom.getFolderDetails();
                FragmentActivity activity2 = getActivity();
                Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.folder.activity.FolderActivity");
                if (folderDetails.hasFolderData(String.valueOf(((FolderActivity) activity2).getHitCount()))) {
                    loadFolderAndVideoData();
                    return;
                }
            }
            this.mPage = 1;
            this.status = false;
            fetchData(true);
        }
    }

    private final void loadFolderAndVideoData() {
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.folder.fragments.FolderFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                FolderFragment.loadFolderAndVideoData$lambda$11(this.f$0);
            }
        }, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadFolderAndVideoData$lambda$11(FolderFragment folderFragment) {
        UtkashRoom utkashRoom = folderFragment.roomDb;
        FolderAdapter folderAdapter = null;
        if (utkashRoom == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roomDb");
            utkashRoom = null;
        }
        if (utkashRoom.getFolderDetails().getAllUser().size() > 0) {
            UtkashRoom utkashRoom2 = folderFragment.roomDb;
            if (utkashRoom2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                utkashRoom2 = null;
            }
            List<FolderEntity> allUser = utkashRoom2.getFolderDetails().getAllUser();
            UtkashRoom utkashRoom3 = folderFragment.roomDb;
            if (utkashRoom3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                utkashRoom3 = null;
            }
            folderFragment.setData(new JSONObject(allUser.get(utkashRoom3.getFolderDetails().getAllUser().size() - 1).getData()));
            folderFragment.folderLists.clear();
            folderFragment.videoArrayList.clear();
            if (folderFragment.getData().has("folder_result")) {
                JSONArray jSONArrayOptJSONArray = folderFragment.getData().optJSONArray("folder_result");
                Intrinsics.checkNotNull(jSONArrayOptJSONArray);
                if (jSONArrayOptJSONArray.length() > 0) {
                    int length = jSONArrayOptJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        folderFragment.isContentExit = false;
                        FolderModel folderModel = (FolderModel) new Gson().fromJson(jSONArrayOptJSONArray.opt(i).toString(), FolderModel.class);
                        folderFragment.folderModel = folderModel;
                        List<FolderModel> list = folderFragment.folderLists;
                        if (folderModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("folderModel");
                            folderModel = null;
                        }
                        list.add(folderModel);
                    }
                }
            }
            if (folderFragment.getData().has("file_result")) {
                JSONArray jSONArrayOptJSONArray2 = folderFragment.getData().optJSONArray("file_result");
                Intrinsics.checkNotNull(jSONArrayOptJSONArray2);
                if (jSONArrayOptJSONArray2.length() > 0) {
                    int length2 = jSONArrayOptJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        folderFragment.isContentExit = true;
                        folderFragment.setVideo((Video) new Gson().fromJson(jSONArrayOptJSONArray2.opt(i2).toString(), Video.class));
                        folderFragment.videoArrayList.add(folderFragment.getVideo());
                    }
                    Iterator<Video> it = folderFragment.videoArrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        Video next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        Video video = next;
                        UtkashRoom utkashRoom4 = folderFragment.roomDb;
                        if (utkashRoom4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                            utkashRoom4 = null;
                        }
                        if (utkashRoom4.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
                            UtkashRoom utkashRoom5 = folderFragment.roomDb;
                            if (utkashRoom5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                                utkashRoom5 = null;
                            }
                            VideosDownload videosDownload = utkashRoom5.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
                            Intrinsics.checkNotNullExpressionValue(videosDownload, "getvideo_byuserid(...)");
                            video.setVideo_download(StringsKt.equals(videosDownload.getIs_complete(), "1", true));
                            video.setVideo_status(videosDownload.getVideo_status());
                        }
                    }
                }
            }
        }
        if (folderFragment.folderLists.size() > 0) {
            FragmentFolderBinding fragmentFolderBinding = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding);
            fragmentFolderBinding.folderRecycler.setVisibility(0);
            FragmentFolderBinding fragmentFolderBinding2 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding2);
            fragmentFolderBinding2.noData.noDataFoundRL.setVisibility(8);
            Context context = folderFragment.getContext();
            if (context != null) {
                FragmentActivity fragmentActivityRequireActivity = folderFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                List<FolderModel> list2 = folderFragment.folderLists;
                CourseDetail courseDetail = folderFragment.singleStudyModel;
                Intrinsics.checkNotNull(courseDetail);
                ExamPrepItem examPrepItem = folderFragment.examPrepItem;
                Intrinsics.checkNotNull(examPrepItem);
                Lists lists = folderFragment.lists;
                Intrinsics.checkNotNull(lists);
                folderAdapter = new FolderAdapter(context, fragmentActivityRequireActivity, list2, courseDetail, examPrepItem, lists, folderFragment.isCombo, folderFragment.title, folderFragment.contentType, folderFragment.tileIdAPI, folderFragment.tileTypeAPI, folderFragment.revertAPI);
            }
            folderFragment.folderAdapter = folderAdapter;
            FragmentFolderBinding fragmentFolderBinding3 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding3);
            fragmentFolderBinding3.folderRecycler.setAdapter(folderFragment.folderAdapter);
        }
        if (folderFragment.videoArrayList.size() > 0) {
            FragmentFolderBinding fragmentFolderBinding4 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding4);
            fragmentFolderBinding4.fileRecycler.setVisibility(0);
            FragmentFolderBinding fragmentFolderBinding5 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding5);
            fragmentFolderBinding5.noData.noDataFoundRL.setVisibility(8);
            ExamPrepLayer3Adapter examPrepLayer3Adapter = folderFragment.examPrepLayer3Adapter;
            Intrinsics.checkNotNull(examPrepLayer3Adapter);
            examPrepLayer3Adapter.notifyDataSetChanged();
        }
        if (folderFragment.folderLists.size() > 0) {
            FragmentFolderBinding fragmentFolderBinding6 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding6);
            fragmentFolderBinding6.folderRecycler.setVisibility(0);
            FragmentFolderBinding fragmentFolderBinding7 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding7);
            fragmentFolderBinding7.noData.noDataFoundRL.setVisibility(8);
        } else {
            FragmentFolderBinding fragmentFolderBinding8 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding8);
            fragmentFolderBinding8.folderRecycler.setVisibility(8);
        }
        if (folderFragment.videoArrayList.size() > 0) {
            FragmentFolderBinding fragmentFolderBinding9 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding9);
            fragmentFolderBinding9.fileRecycler.setVisibility(0);
            FragmentFolderBinding fragmentFolderBinding10 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding10);
            fragmentFolderBinding10.noData.noDataFoundRL.setVisibility(8);
        } else {
            FragmentFolderBinding fragmentFolderBinding11 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding11);
            fragmentFolderBinding11.fileRecycler.setVisibility(8);
        }
        if (folderFragment.folderLists.size() == 0 && folderFragment.videoArrayList.size() == 0) {
            FragmentFolderBinding fragmentFolderBinding12 = folderFragment.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding12);
            fragmentFolderBinding12.noData.noDataFoundRL.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: FolderFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¨\u0006\u0010"}, d2 = {"Lcom/appnew/android/folder/fragments/FolderFragment$Companion;", "", "<init>", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "isCombo", "", "title", "", "content_type", "tileIdAPI", "tileTypeAPI", "revertAPI", Const.FOLDER_ID, "firstTime", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Fragment newInstance(boolean isCombo, String title, String content_type, String tileIdAPI, String tileTypeAPI, String revertAPI, String folder_id, boolean firstTime) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(content_type, "content_type");
            Intrinsics.checkNotNullParameter(tileIdAPI, "tileIdAPI");
            Intrinsics.checkNotNullParameter(tileTypeAPI, "tileTypeAPI");
            Intrinsics.checkNotNullParameter(revertAPI, "revertAPI");
            Intrinsics.checkNotNullParameter(folder_id, "folder_id");
            FolderFragment folderFragment = new FolderFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isCombo", isCombo);
            bundle.putString("title", title);
            bundle.putString("content_type", content_type);
            bundle.putString("tileIdAPI", tileIdAPI);
            bundle.putString("tileTypeAPI", tileTypeAPI);
            bundle.putString("revertAPI", revertAPI);
            bundle.putString(Const.FOLDER_ID, folder_id);
            bundle.putBoolean("firstTime", firstTime);
            folderFragment.setArguments(bundle);
            return folderFragment;
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        CourseDetailData courseDetail;
        EncryptionData encryptionData = new EncryptionData();
        Data data = this.singleStudyModel.getData();
        encryptionData.setCourse_id((data == null || (courseDetail = data.getCourseDetail()) == null) ? null : courseDetail.getId());
        encryptionData.setTile_id(this.tileIdAPI);
        encryptionData.setFolder_id(this.folderId);
        encryptionData.setPage(String.valueOf(this.mPage));
        encryptionData.setType(this.contentType);
        encryptionData.setRevert_api(this.revertAPI);
        encryptionData.setKeyWord(this.searchStringMain);
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNull(service);
        return service.get_folder_list(strEncrypt);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(this.videoDownloadReceiver);
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(this.audioServiceReceiver);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        int i;
        FolderAdapter folderAdapter;
        FolderAdapter folderAdapter2;
        int size;
        if (Intrinsics.areEqual(apitype, API.get_folder_list)) {
            Intrinsics.checkNotNull(jsonstring);
            boolean z = false;
            if (jsonstring.optBoolean("status")) {
                FragmentFolderBinding fragmentFolderBinding = this.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding);
                fragmentFolderBinding.pullToRefresh.setRefreshing(false);
                JSONObject jSONObjectOptJSONObject = jsonstring.optJSONObject("data");
                Intrinsics.checkNotNull(jSONObjectOptJSONObject);
                setData(jSONObjectOptJSONObject);
                if (this.status) {
                    FragmentFolderBinding fragmentFolderBinding2 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding2);
                    if (fragmentFolderBinding2.progressBar.isShown()) {
                        FragmentFolderBinding fragmentFolderBinding3 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding3);
                        fragmentFolderBinding3.progressBar.setVisibility(8);
                    }
                    this.isPaginationAvailable = true;
                    if (getData().has("file_result")) {
                        JSONArray jSONArrayOptJSONArray = getData().optJSONArray("file_result");
                        Intrinsics.checkNotNull(jSONArrayOptJSONArray);
                        if (jSONArrayOptJSONArray.length() == 0) {
                            this.mPage--;
                            return;
                        }
                        if (this.isApiHitForSearch) {
                            size = this.videoArrayListForApiSearch.size();
                        } else {
                            size = this.videoArrayList.size();
                        }
                        this.oldArraySize = size;
                        if (jSONArrayOptJSONArray.length() > 0) {
                            int length = jSONArrayOptJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                this.isContentExit = true;
                                setVideo((Video) new Gson().fromJson(jSONArrayOptJSONArray.opt(i2).toString(), Video.class));
                                if (this.isApiHitForSearch) {
                                    this.videoArrayListForApiSearch.add(getVideo());
                                } else {
                                    this.videoArrayList.add(getVideo());
                                }
                            }
                        }
                        setFolderData();
                        return;
                    }
                    return;
                }
                if (!this.isApiHitForSearch) {
                    if (getActivity() instanceof FolderActivity) {
                        FolderEntity folderEntity = new FolderEntity();
                        FragmentActivity activity = getActivity();
                        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.folder.activity.FolderActivity");
                        folderEntity.setHitCount(String.valueOf(((FolderActivity) activity).getHitCount()));
                        folderEntity.setData(getData().toString());
                        this.isPaginationAvailable = true;
                        UtkashRoom utkashRoom = this.roomDb;
                        if (utkashRoom == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                            utkashRoom = null;
                        }
                        utkashRoom.getFolderDetails().addFolderData(folderEntity);
                    }
                    this.folderLists.clear();
                    this.videoArrayList.clear();
                    if (getData().has("folder_result")) {
                        JSONArray jSONArrayOptJSONArray2 = getData().optJSONArray("folder_result");
                        Intrinsics.checkNotNull(jSONArrayOptJSONArray2);
                        if (jSONArrayOptJSONArray2.length() > 0) {
                            int length2 = jSONArrayOptJSONArray2.length();
                            int i3 = 0;
                            while (i3 < length2) {
                                this.isContentExit = z;
                                FolderModel folderModel = (FolderModel) new Gson().fromJson(jSONArrayOptJSONArray2.opt(i3).toString(), FolderModel.class);
                                this.folderModel = folderModel;
                                List<FolderModel> list = this.folderLists;
                                if (folderModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("folderModel");
                                    folderModel = null;
                                }
                                list.add(folderModel);
                                i3++;
                                z = false;
                            }
                        }
                    }
                    if (getData().has("file_result")) {
                        JSONArray jSONArrayOptJSONArray3 = getData().optJSONArray("file_result");
                        Intrinsics.checkNotNull(jSONArrayOptJSONArray3);
                        if (jSONArrayOptJSONArray3.length() > 0) {
                            int length3 = jSONArrayOptJSONArray3.length();
                            for (int i4 = 0; i4 < length3; i4++) {
                                this.isContentExit = true;
                                setVideo((Video) new Gson().fromJson(jSONArrayOptJSONArray3.opt(i4).toString(), Video.class));
                                this.videoArrayList.add(getVideo());
                            }
                            Iterator<Video> it = this.videoArrayList.iterator();
                            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                            while (it.hasNext()) {
                                Video next = it.next();
                                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                Video video = next;
                                UtkashRoom utkashRoom2 = this.roomDb;
                                if (utkashRoom2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                                    utkashRoom2 = null;
                                }
                                if (utkashRoom2.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
                                    UtkashRoom utkashRoom3 = this.roomDb;
                                    if (utkashRoom3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                                        utkashRoom3 = null;
                                    }
                                    VideosDownload videosDownload = utkashRoom3.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
                                    Intrinsics.checkNotNullExpressionValue(videosDownload, "getvideo_byuserid(...)");
                                    video.setVideo_download(StringsKt.equals(videosDownload.getIs_complete(), "1", true));
                                    video.setVideo_status(videosDownload.getVideo_status());
                                }
                            }
                        }
                    }
                    if (this.folderLists.size() > 0) {
                        FragmentFolderBinding fragmentFolderBinding4 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding4);
                        fragmentFolderBinding4.folderRecycler.setVisibility(0);
                        FragmentFolderBinding fragmentFolderBinding5 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding5);
                        fragmentFolderBinding5.noData.noDataFoundRL.setVisibility(8);
                        Context context = getContext();
                        if (context != null) {
                            FragmentActivity fragmentActivityRequireActivity = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                            FragmentActivity fragmentActivity = fragmentActivityRequireActivity;
                            List<FolderModel> list2 = this.folderLists;
                            CourseDetail courseDetail = this.singleStudyModel;
                            Intrinsics.checkNotNull(courseDetail);
                            ExamPrepItem examPrepItem = this.examPrepItem;
                            Intrinsics.checkNotNull(examPrepItem);
                            Lists lists = this.lists;
                            Intrinsics.checkNotNull(lists);
                            folderAdapter2 = new FolderAdapter(context, fragmentActivity, list2, courseDetail, examPrepItem, lists, this.isCombo, this.title, this.contentType, this.tileIdAPI, this.tileTypeAPI, this.revertAPI);
                        } else {
                            folderAdapter2 = null;
                        }
                        this.folderAdapter = folderAdapter2;
                        FragmentFolderBinding fragmentFolderBinding6 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding6);
                        fragmentFolderBinding6.folderRecycler.setAdapter(this.folderAdapter);
                    }
                    if (this.videoArrayList.size() > 0) {
                        FragmentFolderBinding fragmentFolderBinding7 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding7);
                        fragmentFolderBinding7.fileRecycler.setVisibility(0);
                        FragmentFolderBinding fragmentFolderBinding8 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding8);
                        fragmentFolderBinding8.noData.noDataFoundRL.setVisibility(8);
                        ExamPrepLayer3Adapter examPrepLayer3Adapter = this.examPrepLayer3Adapter;
                        Intrinsics.checkNotNull(examPrepLayer3Adapter);
                        examPrepLayer3Adapter.notifyDataSetChanged();
                        FragmentFolderBinding fragmentFolderBinding9 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding9);
                        fragmentFolderBinding9.fileRecycler.post(new Runnable() { // from class: com.appnew.android.folder.fragments.FolderFragment$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                FolderFragment.SuccessCallBack$lambda$13(this.f$0);
                            }
                        });
                    }
                    if (this.folderLists.size() > 0) {
                        FragmentFolderBinding fragmentFolderBinding10 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding10);
                        fragmentFolderBinding10.folderRecycler.setVisibility(0);
                        FragmentFolderBinding fragmentFolderBinding11 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding11);
                        fragmentFolderBinding11.noData.noDataFoundRL.setVisibility(8);
                    } else {
                        FragmentFolderBinding fragmentFolderBinding12 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding12);
                        fragmentFolderBinding12.folderRecycler.setVisibility(8);
                    }
                    if (this.videoArrayList.size() > 0) {
                        FragmentFolderBinding fragmentFolderBinding13 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding13);
                        fragmentFolderBinding13.fileRecycler.setVisibility(0);
                        FragmentFolderBinding fragmentFolderBinding14 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding14);
                        fragmentFolderBinding14.noData.noDataFoundRL.setVisibility(8);
                    } else {
                        FragmentFolderBinding fragmentFolderBinding15 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding15);
                        fragmentFolderBinding15.fileRecycler.setVisibility(8);
                    }
                    if (this.folderLists.size() == 0 && this.videoArrayList.size() == 0) {
                        FragmentFolderBinding fragmentFolderBinding16 = this.binding;
                        Intrinsics.checkNotNull(fragmentFolderBinding16);
                        fragmentFolderBinding16.noData.noDataFoundRL.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.folderListsForApiSearch.clear();
                this.videoArrayListForApiSearch.clear();
                if (getData().has("folder_result")) {
                    JSONArray jSONArrayOptJSONArray4 = getData().optJSONArray("folder_result");
                    Intrinsics.checkNotNull(jSONArrayOptJSONArray4);
                    if (jSONArrayOptJSONArray4.length() > 0) {
                        int length4 = jSONArrayOptJSONArray4.length();
                        for (int i5 = 0; i5 < length4; i5++) {
                            this.isContentExit = false;
                            FolderModel folderModel2 = (FolderModel) new Gson().fromJson(jSONArrayOptJSONArray4.opt(i5).toString(), FolderModel.class);
                            this.folderModel = folderModel2;
                            List<FolderModel> list3 = this.folderListsForApiSearch;
                            if (folderModel2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("folderModel");
                                folderModel2 = null;
                            }
                            list3.add(folderModel2);
                        }
                    }
                }
                if (getData().has("file_result")) {
                    JSONArray jSONArrayOptJSONArray5 = getData().optJSONArray("file_result");
                    Intrinsics.checkNotNull(jSONArrayOptJSONArray5);
                    if (jSONArrayOptJSONArray5.length() > 0) {
                        int length5 = jSONArrayOptJSONArray5.length();
                        for (int i6 = 0; i6 < length5; i6++) {
                            this.isContentExit = true;
                            setVideo((Video) new Gson().fromJson(jSONArrayOptJSONArray5.opt(i6).toString(), Video.class));
                            this.videoArrayListForApiSearch.add(getVideo());
                        }
                        Iterator<Video> it2 = this.videoArrayListForApiSearch.iterator();
                        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Video next2 = it2.next();
                            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                            Video video2 = next2;
                            UtkashRoom utkashRoom4 = this.roomDb;
                            if (utkashRoom4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                                utkashRoom4 = null;
                            }
                            if (utkashRoom4.getvideoDownloadao().isvideo_exit(video2.getId(), MakeMyExam.userId)) {
                                UtkashRoom utkashRoom5 = this.roomDb;
                                if (utkashRoom5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("roomDb");
                                    utkashRoom5 = null;
                                }
                                VideosDownload videosDownload2 = utkashRoom5.getvideoDownloadao().getvideo_byuserid(video2.getId(), MakeMyExam.userId);
                                Intrinsics.checkNotNullExpressionValue(videosDownload2, "getvideo_byuserid(...)");
                                video2.setVideo_download(StringsKt.equals(videosDownload2.getIs_complete(), "1", true));
                                video2.setVideo_status(videosDownload2.getVideo_status());
                            }
                        }
                    }
                }
                if (this.folderListsForApiSearch.size() > 0) {
                    FragmentFolderBinding fragmentFolderBinding17 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding17);
                    fragmentFolderBinding17.folderRecycler.setVisibility(0);
                    FragmentFolderBinding fragmentFolderBinding18 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding18);
                    fragmentFolderBinding18.noData.noDataFoundRL.setVisibility(8);
                    Context context2 = getContext();
                    if (context2 != null) {
                        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
                        FragmentActivity fragmentActivity2 = fragmentActivityRequireActivity2;
                        List<FolderModel> list4 = this.folderListsForApiSearch;
                        CourseDetail courseDetail2 = this.singleStudyModel;
                        Intrinsics.checkNotNull(courseDetail2);
                        ExamPrepItem examPrepItem2 = this.examPrepItem;
                        Intrinsics.checkNotNull(examPrepItem2);
                        Lists lists2 = this.lists;
                        Intrinsics.checkNotNull(lists2);
                        folderAdapter = new FolderAdapter(context2, fragmentActivity2, list4, courseDetail2, examPrepItem2, lists2, this.isCombo, this.title, this.contentType, this.tileIdAPI, this.tileTypeAPI, this.revertAPI);
                    } else {
                        folderAdapter = null;
                    }
                    this.folderAdapter = folderAdapter;
                    FragmentFolderBinding fragmentFolderBinding19 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding19);
                    fragmentFolderBinding19.folderRecycler.setAdapter(this.folderAdapter);
                }
                if (this.videoArrayListForApiSearch.size() > 0) {
                    FragmentFolderBinding fragmentFolderBinding20 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding20);
                    fragmentFolderBinding20.fileRecycler.setVisibility(0);
                    FragmentFolderBinding fragmentFolderBinding21 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding21);
                    fragmentFolderBinding21.noData.noDataFoundRL.setVisibility(8);
                    FragmentActivity activity2 = getActivity();
                    CourseDetail courseDetail3 = this.singleStudyModel;
                    ArrayList<Video> arrayList = this.videoArrayListForApiSearch;
                    String str = this.tileIdAPI;
                    String str2 = this.tileTypeAPI;
                    String str3 = this.revertAPI;
                    Intrinsics.checkNotNull(courseDetail3);
                    ExamPrepLayer3Adapter examPrepLayer3Adapter2 = new ExamPrepLayer3Adapter(activity2, courseDetail3, arrayList, str, str2, str3, str, courseDetail3.getData().getCourseDetail().getIsPurchased());
                    this.examPrepLayer3Adapter = examPrepLayer3Adapter2;
                    examPrepLayer3Adapter2.setFolderData(this.folderId, this.contentType);
                    FragmentFolderBinding fragmentFolderBinding22 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding22);
                    fragmentFolderBinding22.fileRecycler.setAdapter(this.examPrepLayer3Adapter);
                }
                if (this.folderListsForApiSearch.size() > 0) {
                    FragmentFolderBinding fragmentFolderBinding23 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding23);
                    fragmentFolderBinding23.folderRecycler.setVisibility(0);
                    FragmentFolderBinding fragmentFolderBinding24 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding24);
                    fragmentFolderBinding24.noData.noDataFoundRL.setVisibility(8);
                } else {
                    FragmentFolderBinding fragmentFolderBinding25 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding25);
                    fragmentFolderBinding25.folderRecycler.setVisibility(8);
                }
                if (this.videoArrayListForApiSearch.size() > 0) {
                    FragmentFolderBinding fragmentFolderBinding26 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding26);
                    fragmentFolderBinding26.fileRecycler.setVisibility(0);
                    FragmentFolderBinding fragmentFolderBinding27 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding27);
                    fragmentFolderBinding27.noData.noDataFoundRL.setVisibility(8);
                } else {
                    FragmentFolderBinding fragmentFolderBinding28 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding28);
                    fragmentFolderBinding28.fileRecycler.setVisibility(8);
                }
                if (this.folderListsForApiSearch.size() == 0 && this.videoArrayListForApiSearch.size() == 0 && !TextUtils.isEmpty(this.searchStringMain)) {
                    FragmentFolderBinding fragmentFolderBinding29 = this.binding;
                    Intrinsics.checkNotNull(fragmentFolderBinding29);
                    fragmentFolderBinding29.noData.noDataFoundRL.setVisibility(0);
                    return;
                }
                return;
            }
            FragmentFolderBinding fragmentFolderBinding30 = this.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding30);
            fragmentFolderBinding30.pullToRefresh.setRefreshing(false);
            this.isPaginationAvailable = false;
            Context context3 = getContext();
            String strOptString = jsonstring.optString("auth_code");
            if (strOptString == null) {
                strOptString = "";
            }
            RetrofitResponse.GetApiData(context3, strOptString, jsonstring.getString("message"), false);
            FragmentFolderBinding fragmentFolderBinding31 = this.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding31);
            if (fragmentFolderBinding31.progressBar.isShown()) {
                FragmentFolderBinding fragmentFolderBinding32 = this.binding;
                Intrinsics.checkNotNull(fragmentFolderBinding32);
                i = 8;
                fragmentFolderBinding32.progressBar.setVisibility(8);
            } else {
                i = 8;
            }
            this.isPaginationAvailable = false;
            FragmentFolderBinding fragmentFolderBinding33 = this.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding33);
            fragmentFolderBinding33.fileRecycler.setVisibility(i);
            FragmentFolderBinding fragmentFolderBinding34 = this.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding34);
            fragmentFolderBinding34.folderRecycler.setVisibility(i);
            FragmentFolderBinding fragmentFolderBinding35 = this.binding;
            Intrinsics.checkNotNull(fragmentFolderBinding35);
            fragmentFolderBinding35.noData.noDataFoundRL.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$13(FolderFragment folderFragment) {
        FragmentFolderBinding fragmentFolderBinding = folderFragment.binding;
        Intrinsics.checkNotNull(fragmentFolderBinding);
        RecyclerView.LayoutManager layoutManager = fragmentFolderBinding.fileRecycler.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(folderFragment.lastVisibleItemPosition, folderFragment.lastOffset);
    }

    private final void setFolderData() {
        ExamPrepLayer3Adapter examPrepLayer3Adapter = this.examPrepLayer3Adapter;
        if (examPrepLayer3Adapter != null) {
            examPrepLayer3Adapter.notifyDataSetChanged();
        }
    }
}
