package com.appnew.android.feeds.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityFeedDetailsBinding;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.feeds.OptionItem;
import com.appnew.android.feeds.adapters.CommentAdapter;
import com.appnew.android.feeds.adapters.OptionAdapter;
import com.appnew.android.feeds.adapters.OptionWebAdapter;
import com.appnew.android.feeds.dataclass.BannerData;
import com.appnew.android.feeds.dataclass.Json;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.appnew.android.feeds.dataclass.Option;
import com.appnew.android.feeds.dataclass.TestResult;
import com.appnew.android.feeds.dataclass.comment.Data;
import com.appnew.android.feeds.viewmodel.FeedDetailViewModel;
import com.appnew.android.feeds.viewmodelfactory.FeedDetailViewModelProviderFactory;
import com.appnew.android.table.PostDataTable;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.appnew.mvvmwithretrofit.repository.Repository;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jivesoftware.smack.packet.Bind;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: FeedDetails.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0015J\u0006\u0010S\u001a\u00020PJ\u0006\u0010T\u001a\u00020PJ\u0006\u0010U\u001a\u00020PJ\b\u0010V\u001a\u00020PH\u0002J\u000e\u0010W\u001a\u00020P2\u0006\u0010X\u001a\u000208J\u000e\u0010Y\u001a\u00020P2\u0006\u0010Z\u001a\u00020[J\u0010\u0010\\\u001a\u00020P2\u0006\u0010X\u001a\u000208H\u0002J\u0010\u0010]\u001a\u00020P2\u0006\u0010X\u001a\u000208H\u0002J\u0010\u0010^\u001a\u00020P2\u0006\u0010X\u001a\u000208H\u0003J\u0010\u0010_\u001a\u00020P2\u0006\u0010X\u001a\u000208H\u0003J\u0010\u0010`\u001a\u00020P2\u0006\u0010X\u001a\u000208H\u0002J\u0016\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u000206J\u0010\u0010e\u001a\u00020P2\u0006\u0010X\u001a\u000208H\u0002J\u0012\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u000106H\u0017J\u000e\u0010i\u001a\u00020P2\u0006\u0010X\u001a\u000208J \u0010j\u001a\u00020P2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u001c2\u0006\u0010n\u001a\u00020\u001cH\u0016J\u0010\u0010o\u001a\u00020P2\u0006\u0010p\u001a\u000206H\u0002J,\u0010q\u001a\b\u0012\u0004\u0012\u0002060r2\b\u0010s\u001a\u0004\u0018\u0001062\b\u0010t\u001a\u0004\u0018\u0001062\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J.\u0010w\u001a\u00020P2\b\u0010x\u001a\u0004\u0018\u00010y2\b\u0010s\u001a\u0004\u0018\u0001062\b\u0010t\u001a\u0004\u0018\u0001062\u0006\u0010z\u001a\u00020\"H\u0016J&\u0010{\u001a\u00020P2\b\u0010x\u001a\u0004\u0018\u0001062\b\u0010s\u001a\u0004\u0018\u0001062\b\u0010t\u001a\u0004\u0018\u000106H\u0016J\u0013\u0010\u0083\u0001\u001a\u00020P2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0003J\u001d\u0010\u0086\u0001\u001a\u00020P2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J\u001b\u0010\u0089\u0001\u001a\u00020P2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\t\u0010\u008e\u0001\u001a\u00020PH\u0002J&\u0010\u008f\u0001\u001a\u00030\u0088\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u001c2\u0007\u0010\u0093\u0001\u001a\u000206H\u0007R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R!\u0010@\u001a\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010*\"\u0004\bM\u0010,R\u000e\u0010N\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010|\u001a\b\u0012\u0004\u0012\u0002060}X\u0086\u000e¢\u0006\u0013\n\u0003\u0010\u0082\u0001\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0094\u0001"}, d2 = {"Lcom/appnew/android/feeds/activity/FeedDetails;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/text/Html$ImageGetter;", "Lcom/appnew/android/feeds/OptionItem;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "feedDetailsBinding", "Lcom/appnew/android/databinding/ActivityFeedDetailsBinding;", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "optiondata", "Lcom/appnew/android/feeds/dataclass/Json;", "getOptiondata", "()Lcom/appnew/android/feeds/dataclass/Json;", "setOptiondata", "(Lcom/appnew/android/feeds/dataclass/Json;)V", "lang", "", "getLang", "()I", "setLang", "(I)V", "booleanlike", "", "getBooleanlike", "()Z", "setBooleanlike", "(Z)V", "no_data_found_RL", "Landroid/widget/RelativeLayout;", "getNo_data_found_RL", "()Landroid/widget/RelativeLayout;", "setNo_data_found_RL", "(Landroid/widget/RelativeLayout;)V", "backBtn", "Landroid/widget/Button;", "getBackBtn", "()Landroid/widget/Button;", "setBackBtn", "(Landroid/widget/Button;)V", "is_postexist", "set_postexist", "postId", "", "postDataTable", "Lcom/appnew/android/table/PostDataTable;", "comment_txt", "feedDetailViewModel", "Lcom/appnew/android/feeds/viewmodel/FeedDetailViewModel;", "getFeedDetailViewModel", "()Lcom/appnew/android/feeds/viewmodel/FeedDetailViewModel;", "setFeedDetailViewModel", "(Lcom/appnew/android/feeds/viewmodel/FeedDetailViewModel;)V", "commentlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/feeds/dataclass/comment/Data;", "Lkotlin/collections/ArrayList;", "getCommentlist", "()Ljava/util/ArrayList;", "commentAdapter", "Lcom/appnew/android/feeds/adapters/CommentAdapter;", "comment_recyerler", "Landroidx/recyclerview/widget/RecyclerView;", "option_index", "no_data_found_Comment", "getNo_data_found_Comment", "setNo_data_found_Comment", "test_id", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createApiBodyData", "observer", "getPostData", "visibileViewType", Bind.ELEMENT, "data", "open_comment_layout", "context", "Landroid/content/Context;", "setaudio", "setvideo", "setQuiz", "setQuestion", "setLink", "makeLinks", "textView", "Landroid/widget/TextView;", "link", "setImage", "getDrawable", "Landroid/graphics/drawable/Drawable;", CmcdData.Factory.STREAMING_FORMAT_SS, "setArticle", "itemSelect", "option", "Lcom/appnew/android/feeds/dataclass/Option;", FirebaseAnalytics.Param.INDEX, "feedlistpos", "createBodyData", "type", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "langIds", "", "getLangIds", "()[Ljava/lang/String;", "setLangIds", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "showPopUp", "instructionData", "Lcom/appnew/android/testmodule/model/InstructionData;", "addSectionView", "sectionListLL", "Landroid/widget/LinearLayout;", "showPopMenuForLangauge", "v", "Landroid/view/View;", "testBasicInst", "Lcom/appnew/android/testmodule/model/TestBasicInst;", "getintotestseries", "initSectionListView", "testSectionInst", "Lcom/appnew/android/testmodule/model/TestSectionInst;", "tag", "hide_inst_time", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDetails extends AppCompatActivity implements Html.ImageGetter, OptionItem, NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private Button backBtn;
    private boolean booleanlike;
    private CommentAdapter commentAdapter;
    private RecyclerView comment_recyerler;
    private String comment_txt;
    private final ArrayList<Data> commentlist;
    public FeedDetailViewModel feedDetailViewModel;
    private ActivityFeedDetailsBinding feedDetailsBinding;
    private boolean is_postexist;
    private int lang;
    private String[] langIds;
    private NetworkCall networkCall;
    public RelativeLayout no_data_found_Comment;
    private RelativeLayout no_data_found_RL;
    private int option_index;
    private Json optiondata;
    private PostDataTable postDataTable;
    private String postId;
    private String test_id;
    private UtkashRoom utkashRoom;

    public FeedDetails() {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        Intrinsics.checkNotNullExpressionValue(appDatabase, "getAppDatabase(...)");
        this.utkashRoom = appDatabase;
        this.comment_txt = "";
        this.commentlist = new ArrayList<>();
        this.test_id = "";
        this.langIds = new String[]{"1"};
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final Json getOptiondata() {
        return this.optiondata;
    }

    public final void setOptiondata(Json json) {
        this.optiondata = json;
    }

    public final int getLang() {
        return this.lang;
    }

    public final void setLang(int i) {
        this.lang = i;
    }

    public final boolean getBooleanlike() {
        return this.booleanlike;
    }

    public final void setBooleanlike(boolean z) {
        this.booleanlike = z;
    }

    public final RelativeLayout getNo_data_found_RL() {
        return this.no_data_found_RL;
    }

    public final void setNo_data_found_RL(RelativeLayout relativeLayout) {
        this.no_data_found_RL = relativeLayout;
    }

    public final Button getBackBtn() {
        return this.backBtn;
    }

    public final void setBackBtn(Button button) {
        this.backBtn = button;
    }

    /* JADX INFO: renamed from: is_postexist, reason: from getter */
    public final boolean getIs_postexist() {
        return this.is_postexist;
    }

    public final void set_postexist(boolean z) {
        this.is_postexist = z;
    }

    public final FeedDetailViewModel getFeedDetailViewModel() {
        FeedDetailViewModel feedDetailViewModel = this.feedDetailViewModel;
        if (feedDetailViewModel != null) {
            return feedDetailViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feedDetailViewModel");
        return null;
    }

    public final void setFeedDetailViewModel(FeedDetailViewModel feedDetailViewModel) {
        Intrinsics.checkNotNullParameter(feedDetailViewModel, "<set-?>");
        this.feedDetailViewModel = feedDetailViewModel;
    }

    public final ArrayList<Data> getCommentlist() {
        return this.commentlist;
    }

    public final RelativeLayout getNo_data_found_Comment() {
        RelativeLayout relativeLayout = this.no_data_found_Comment;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("no_data_found_Comment");
        return null;
    }

    public final void setNo_data_found_Comment(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.no_data_found_Comment = relativeLayout;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FeedDetails feedDetails = this;
        Helper.enableScreenShot(feedDetails);
        APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        Intrinsics.checkNotNull(aPIInterface);
        setFeedDetailViewModel((FeedDetailViewModel) new ViewModelProvider(this, new FeedDetailViewModelProviderFactory(new Repository(aPIInterface), this.utkashRoom)).get(FeedDetailViewModel.class));
        ActivityFeedDetailsBinding activityFeedDetailsBinding = (ActivityFeedDetailsBinding) DataBindingUtil.setContentView(feedDetails, R.layout.activity_feed_details);
        this.feedDetailsBinding = activityFeedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding);
        activityFeedDetailsBinding.setFeeddetailVm(getFeedDetailViewModel());
        ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding2);
        FeedDetails feedDetails2 = this;
        activityFeedDetailsBinding2.setLifecycleOwner(feedDetails2);
        this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
        this.backBtn = (Button) findViewById(R.id.backBtn);
        Helper.enableScreenShot(feedDetails);
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        Button button = this.backBtn;
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.finish();
            }
        });
        observer();
        this.postId = getIntent().getStringExtra("postId");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FeedDetails$onCreate$2$1(this, null), 3, null);
        getPostData();
        getFeedDetailViewModel().getAdapter_bodydata().observe(feedDetails2, new FeedDetails$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedDetails.onCreate$lambda$2(this.f$0, (String) obj);
            }
        }));
        getFeedDetailViewModel().getAdapter_response().observe(feedDetails2, new FeedDetails$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedDetails.onCreate$lambda$4(this.f$0, (JSONObject) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Unit onCreate$lambda$2(FeedDetails feedDetails, String str) {
        String value;
        if (str != null && (value = feedDetails.getFeedDetailViewModel().getType().getValue()) != null) {
            switch (value.hashCode()) {
                case -314243511:
                    if (value.equals("GetComment")) {
                        feedDetails.getFeedDetailViewModel().getcourutine_adapter_post();
                    }
                    break;
                case -171309688:
                    if (value.equals("Attempt Mcq")) {
                        feedDetails.getFeedDetailViewModel().getcourutine_adapter_post();
                    }
                    break;
                case 80245:
                    if (value.equals("Pin")) {
                        feedDetails.getFeedDetailViewModel().getcourutine_adapter_post();
                    }
                    break;
                case 2368439:
                    if (value.equals("Like")) {
                        feedDetails.getFeedDetailViewModel().getcourutine_adapter_post();
                    }
                    break;
                case 81887292:
                    if (value.equals("Unpin")) {
                        feedDetails.getFeedDetailViewModel().getcourutine_adapter_post();
                    }
                    break;
                case 557130398:
                    if (value.equals("AddComment")) {
                        feedDetails.getFeedDetailViewModel().getcourutine_adapter_post();
                    }
                    break;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02d0 A[Catch: Exception -> 0x02e7, TryCatch #0 {Exception -> 0x02e7, blocks: (B:4:0x000d, B:6:0x001b, B:8:0x002b, B:12:0x003f, B:15:0x0049, B:17:0x006b, B:19:0x007a, B:18:0x0073, B:20:0x00b0, B:23:0x00ba, B:24:0x00ec, B:27:0x00f6, B:29:0x0112, B:31:0x0141, B:30:0x012a, B:32:0x0189, B:35:0x0193, B:36:0x01c5, B:39:0x01cf, B:42:0x01fc, B:44:0x0229, B:48:0x0234, B:49:0x0275, B:52:0x027e, B:54:0x0289, B:55:0x02af, B:57:0x02b7, B:59:0x02c6, B:61:0x02ca, B:58:0x02bf, B:62:0x02d0, B:64:0x02db, B:65:0x02df), top: B:71:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit onCreate$lambda$4(com.appnew.android.feeds.activity.FeedDetails r19, org.json.JSONObject r20) {
        /*
            Method dump skipped, instruction units count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.activity.FeedDetails.onCreate$lambda$4(com.appnew.android.feeds.activity.FeedDetails, org.json.JSONObject):kotlin.Unit");
    }

    public final void createApiBodyData() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPost_id(this.postId);
        getFeedDetailViewModel().getBodydata().setValue(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    public final void observer() {
        try {
            getFeedDetailViewModel().getProgressvalue().observe(this, new FeedDetails$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FeedDetails.observer$lambda$5(this.f$0, (String) obj);
                }
            }));
            getFeedDetailViewModel().getJsonObjectmutable().observe(this, new FeedDetails$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FeedDetails.observer$lambda$6(this.f$0, (JSONObject) obj);
                }
            }));
            getFeedDetailViewModel().getBodydata().observe(this, new FeedDetails$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FeedDetails.observer$lambda$7(this.f$0, (String) obj);
                }
            }));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observer$lambda$5(FeedDetails feedDetails, String str) {
        if (str.equals("0")) {
            Helper.dismissProgressDialog();
        } else {
            Helper.showProgressDialog(feedDetails);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observer$lambda$6(FeedDetails feedDetails, JSONObject jSONObject) {
        if (Intrinsics.areEqual(jSONObject.optString("status"), "true")) {
            JSONObject jSONObject2 = jSONObject != null ? jSONObject.getJSONObject("data") : null;
            JSONObject jSONObject3 = jSONObject2 != null ? jSONObject2.getJSONObject("data") : null;
            JSONObject jSONObject4 = new JSONObject(String.valueOf(jSONObject3));
            JSONArray jSONArray = jSONObject2 != null ? jSONObject2.getJSONArray("related_courses") : null;
            Intrinsics.checkNotNull(jSONArray);
            if (jSONArray.length() > 0) {
                ActivityFeedDetailsBinding activityFeedDetailsBinding = feedDetails.feedDetailsBinding;
                Intrinsics.checkNotNull(activityFeedDetailsBinding);
                TextView realted = activityFeedDetailsBinding.realted;
                Intrinsics.checkNotNullExpressionValue(realted, "realted");
                realted.setVisibility(0);
                Object objFromJson = new Gson().fromJson(jSONArray.toString(), new TypeToken<List<? extends NewCourseData>>() { // from class: com.appnew.android.feeds.activity.FeedDetails$observer$2$list$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                feedDetails.getFeedDetailViewModel().get_relatedCourse().setValue((List) objFromJson);
            }
            if (jSONObject4.has("id")) {
                com.appnew.android.feeds.dataclass.Data data = (com.appnew.android.feeds.dataclass.Data) new Gson().fromJson(String.valueOf(jSONObject3), com.appnew.android.feeds.dataclass.Data.class);
                PostDataTable postDataTable = new PostDataTable();
                feedDetails.postDataTable = postDataTable;
                Intrinsics.checkNotNull(postDataTable);
                postDataTable.setCreated(data.getSchedule_date());
                PostDataTable postDataTable2 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable2);
                postDataTable2.setId(data.getId());
                PostDataTable postDataTable3 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable3);
                postDataTable3.setMasterCat("");
                PostDataTable postDataTable4 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable4);
                postDataTable4.setJson(new Gson().toJson(data.getJson()));
                PostDataTable postDataTable5 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable5);
                postDataTable5.setMeta_url(data.getMeta_url());
                PostDataTable postDataTable6 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable6);
                postDataTable6.setThumbnail(data.getThumbnail());
                PostDataTable postDataTable7 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable7);
                String url = data.getUrl();
                if (url == null) {
                    url = "";
                }
                postDataTable7.setUrl(url);
                PostDataTable postDataTable8 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable8);
                postDataTable8.setModified(data.getModified());
                PostDataTable postDataTable9 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable9);
                postDataTable9.setMy_like(data.getMy_like());
                PostDataTable postDataTable10 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable10);
                String name = data.getName();
                if (name == null) {
                    name = "";
                }
                postDataTable10.setName(name);
                PostDataTable postDataTable11 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable11);
                postDataTable11.setPost_type(data.getPost_type());
                PostDataTable postDataTable12 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable12);
                String profile_picture = data.getProfile_picture();
                if (profile_picture == null) {
                    profile_picture = "";
                }
                postDataTable12.setProfile_picture(profile_picture);
                PostDataTable postDataTable13 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable13);
                postDataTable13.setStatus(data.getStatus());
                PostDataTable postDataTable14 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable14);
                postDataTable14.setSub_cat_id("");
                PostDataTable postDataTable15 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable15);
                postDataTable15.setText(data.getText());
                PostDataTable postDataTable16 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable16);
                postDataTable16.setTotal_comments(data.getTotal_comments());
                PostDataTable postDataTable17 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable17);
                postDataTable17.setTotal_likes(data.getTotal_likes());
                PostDataTable postDataTable18 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable18);
                postDataTable18.setUser_id(data.getUser_id());
                PostDataTable postDataTable19 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable19);
                Gson gson = new Gson();
                List<NewCourseData> newCourseData = data.getNewCourseData();
                if (newCourseData == null) {
                    newCourseData = CollectionsKt.emptyList();
                }
                postDataTable19.setNewCourseData(gson.toJson(newCourseData));
                PostDataTable postDataTable20 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable20);
                postDataTable20.setLivetest(new Gson().toJson(data.getLivetest()));
                PostDataTable postDataTable21 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable21);
                postDataTable21.setLiveclass(new Gson().toJson(data.getLiveclass()));
                PostDataTable postDataTable22 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable22);
                Gson gson2 = new Gson();
                List<TestResult> testResult = data.getTestResult();
                if (testResult == null) {
                    testResult = CollectionsKt.emptyList();
                }
                postDataTable22.setTestResult(gson2.toJson(testResult));
                PostDataTable postDataTable23 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable23);
                Gson gson3 = new Gson();
                List<BannerData> bannerlist = data.getBannerlist();
                if (bannerlist == null) {
                    bannerlist = CollectionsKt.emptyList();
                }
                postDataTable23.setBannerlist(gson3.toJson(bannerlist));
                PostDataTable postDataTable24 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable24);
                postDataTable24.setLiveClassStatus("0");
                PostDataTable postDataTable25 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable25);
                postDataTable25.setLiveTestStatus("0");
                PostDataTable postDataTable26 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable26);
                postDataTable26.setPage("");
                PostDataTable postDataTable27 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable27);
                postDataTable27.setIscommentenable(data.getIs_comment_enable());
                PostDataTable postDataTable28 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable28);
                postDataTable28.setSectionposiiton("");
                PostDataTable postDataTable29 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable29);
                postDataTable29.setLimit("");
                PostDataTable postDataTable30 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable30);
                String my_pinned = data.getMy_pinned();
                postDataTable30.setMy_pinned(my_pinned != null ? my_pinned : "0");
                PostDataTable postDataTable31 = feedDetails.postDataTable;
                Intrinsics.checkNotNull(postDataTable31);
                String description = data.getDescription();
                postDataTable31.setDescription(description != null ? description : "");
                feedDetails.visibileViewType();
            } else {
                RelativeLayout relativeLayout = feedDetails.no_data_found_RL;
                Intrinsics.checkNotNull(relativeLayout);
                relativeLayout.setVisibility(0);
                ActivityFeedDetailsBinding activityFeedDetailsBinding2 = feedDetails.feedDetailsBinding;
                Intrinsics.checkNotNull(activityFeedDetailsBinding2);
                NestedScrollView scrollNested = activityFeedDetailsBinding2.scrollNested;
                Intrinsics.checkNotNullExpressionValue(scrollNested, "scrollNested");
                scrollNested.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observer$lambda$7(FeedDetails feedDetails, String str) {
        if (str != null) {
            feedDetails.getFeedDetailViewModel().getPostData();
        }
        return Unit.INSTANCE;
    }

    public final void getPostData() {
        getFeedDetailViewModel().getProgressvalue().setValue("1");
        createApiBodyData();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void visibileViewType() {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.activity.FeedDetails.visibileViewType():void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void bind(final com.appnew.android.table.PostDataTable r4) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.activity.FeedDetails.bind(com.appnew.android.table.PostDataTable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$9(FeedDetails feedDetails, View view) {
        PostDataTable postDataTable = feedDetails.postDataTable;
        Intrinsics.checkNotNull(postDataTable);
        if (postDataTable.getIscommentenable().equals("1")) {
            feedDetails.commentlist.clear();
            feedDetails.createBodyData("GetComment");
            feedDetails.open_comment_layout(feedDetails);
            return;
        }
        Toast.makeText(feedDetails, "Comment is disabled for this post", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bind$lambda$10(FeedDetails feedDetails) {
        if (!feedDetails.booleanlike) {
            feedDetails.booleanlike = true;
            feedDetails.createBodyData("Like");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$12(FeedDetails feedDetails, View view) {
        Helper.sharePost(feedDetails, feedDetails.postId, "", "Post");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$13(PostDataTable postDataTable, FeedDetails feedDetails, View view) {
        if (Intrinsics.areEqual(postDataTable.getMy_pinned(), "1")) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding = feedDetails.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding);
            activityFeedDetailsBinding.pinIV.setImageResource(R.mipmap.unpinned);
            feedDetails.createBodyData("Unpin");
            return;
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding2 = feedDetails.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding2);
        activityFeedDetailsBinding2.pinIV.setImageResource(R.mipmap.pinned);
        feedDetails.createBodyData("Pin");
    }

    public final void open_comment_layout(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
            bottomSheetDialog.setContentView(R.layout.comment_layout);
            Window window = bottomSheetDialog.getWindow();
            Intrinsics.checkNotNull(window);
            window.getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            bottomSheetDialog.setCancelable(false);
            bottomSheetDialog.setCanceledOnTouchOutside(true);
            View viewFindViewById = bottomSheetDialog.findViewById(R.id.bottomlayout);
            Intrinsics.checkNotNull(viewFindViewById);
            FrameLayout frameLayout = (FrameLayout) viewFindViewById;
            BottomSheetBehavior.from(frameLayout).setState(3);
            BottomSheetBehavior.from(frameLayout).setDraggable(false);
            this.comment_recyerler = (RecyclerView) bottomSheetDialog.findViewById(R.id.comment_recyerler);
            final EditText editText = (EditText) bottomSheetDialog.findViewById(R.id.et_message);
            ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.iv_send);
            View viewFindViewById2 = bottomSheetDialog.findViewById(R.id.no_data_found_RL);
            Intrinsics.checkNotNull(viewFindViewById2);
            setNo_data_found_Comment((RelativeLayout) viewFindViewById2);
            this.commentAdapter = new CommentAdapter(context, this.commentlist);
            if (this.commentlist.size() > 0) {
                getNo_data_found_Comment().setVisibility(8);
            } else {
                getNo_data_found_Comment().setVisibility(0);
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
            RecyclerView recyclerView = this.comment_recyerler;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.commentAdapter);
                linearLayoutManager.setStackFromEnd(true);
                linearLayoutManager.setAutoMeasureEnabled(true);
                recyclerView.setLayoutManager(linearLayoutManager);
            }
            Intrinsics.checkNotNull(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedDetails.open_comment_layout$lambda$16(this.f$0, editText, context, view);
                }
            });
            if (bottomSheetDialog.isShowing()) {
                return;
            }
            bottomSheetDialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void open_comment_layout$lambda$16(FeedDetails feedDetails, EditText editText, Context context, View view) {
        Intrinsics.checkNotNull(editText);
        String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        feedDetails.comment_txt = string;
        if (string.length() > 0 && feedDetails.comment_txt.length() > 0) {
            editText.getText().clear();
            feedDetails.createBodyData("AddComment");
        } else {
            Toast.makeText(context, "Comment Should not be blank", 0).show();
        }
    }

    private final void setaudio(final PostDataTable data) {
        if (data.getDescription().length() == 0) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding);
            activityFeedDetailsBinding.audioText.setVisibility(8);
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding2);
            activityFeedDetailsBinding2.audioText.setVisibility(0);
            Spanned spannedFromHtml = Html.fromHtml(data.getDescription(), 0, this, null);
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            activityFeedDetailsBinding3.audioText.setText(spannedFromHtml);
            ActivityFeedDetailsBinding activityFeedDetailsBinding4 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding4);
            activityFeedDetailsBinding4.audioText.setMovementMethod(LinkMovementMethod.getInstance());
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding5 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding5);
        activityFeedDetailsBinding5.auidoLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetails.setaudio$lambda$17(data, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setaudio$lambda$17(PostDataTable postDataTable, FeedDetails feedDetails, View view) {
        if (postDataTable.getMeta_url().length() > 0) {
            Intent intent = new Intent(feedDetails, (Class<?>) FeedVideoPlayer.class);
            intent.putExtra("url", postDataTable.getMeta_url());
            intent.putExtra("des", postDataTable.getDescription());
            intent.putExtra("view_type", "");
            Helper.gotoActivity(intent, feedDetails);
            return;
        }
        Toast.makeText(feedDetails, "No Video Found", 0).show();
    }

    private final void setvideo(final PostDataTable data) {
        if (data.getDescription().length() == 0) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding);
            activityFeedDetailsBinding.videoText.setVisibility(8);
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding2);
            activityFeedDetailsBinding2.videoText.setVisibility(0);
            Spanned spannedFromHtml = Html.fromHtml(data.getDescription(), 0, this, null);
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            activityFeedDetailsBinding3.videoText.setText(spannedFromHtml);
            ActivityFeedDetailsBinding activityFeedDetailsBinding4 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding4);
            activityFeedDetailsBinding4.videoText.setMovementMethod(LinkMovementMethod.getInstance());
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding5 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding5);
        activityFeedDetailsBinding5.playVideo.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetails.setvideo$lambda$18(data, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setvideo$lambda$18(PostDataTable postDataTable, FeedDetails feedDetails, View view) {
        if (postDataTable.getMeta_url().length() > 0) {
            feedDetails.optiondata = (Json) new Gson().fromJson(postDataTable.getJson(), Json.class);
            Intent intent = new Intent(feedDetails, (Class<?>) FeedVideoPlayer.class);
            intent.putExtra("url", postDataTable.getMeta_url());
            intent.putExtra("des", postDataTable.getDescription());
            Json json = feedDetails.optiondata;
            Intrinsics.checkNotNull(json);
            intent.putExtra("view_type", json.getView_type());
            Helper.gotoActivity(intent, feedDetails);
            return;
        }
        Toast.makeText(feedDetails, "No Video Found", 0).show();
    }

    private final void setQuiz(final PostDataTable data) {
        Json json = (Json) new Gson().fromJson(data.getJson(), Json.class);
        this.optiondata = json;
        Intrinsics.checkNotNull(json);
        String test_series_name = json.getTest_series_name();
        Intrinsics.checkNotNull(test_series_name);
        if (test_series_name.length() == 0) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding);
            activityFeedDetailsBinding.testName.setVisibility(8);
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding2);
            activityFeedDetailsBinding2.testName.setVisibility(0);
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            TextView textView = activityFeedDetailsBinding3.testName;
            Json json2 = this.optiondata;
            Intrinsics.checkNotNull(json2);
            textView.setText(json2.getTest_series_name());
        }
        Json json3 = this.optiondata;
        Intrinsics.checkNotNull(json3);
        String state = json3.getState();
        Intrinsics.checkNotNull(state);
        if (state.equals("1")) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding4 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding4);
            activityFeedDetailsBinding4.startQuiz.setText("View Result");
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding5 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding5);
            activityFeedDetailsBinding5.startQuiz.setText("Start Quiz");
        }
        Json json4 = this.optiondata;
        Intrinsics.checkNotNull(json4);
        String time_in_mins = json4.getTime_in_mins();
        Intrinsics.checkNotNull(time_in_mins);
        if (time_in_mins.length() == 0) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding6 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding6);
            activityFeedDetailsBinding6.totalMin.setVisibility(8);
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding7 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding7);
            activityFeedDetailsBinding7.totalMin.setVisibility(0);
            ActivityFeedDetailsBinding activityFeedDetailsBinding8 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding8);
            TextView textView2 = activityFeedDetailsBinding8.totalMin;
            Json json5 = this.optiondata;
            Intrinsics.checkNotNull(json5);
            textView2.setText(json5.getTime_in_mins() + " Minutes");
        }
        Json json6 = this.optiondata;
        Intrinsics.checkNotNull(json6);
        String total_questions = json6.getTotal_questions();
        Intrinsics.checkNotNull(total_questions);
        if (total_questions.length() == 0) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding9 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding9);
            activityFeedDetailsBinding9.totalQuestion.setVisibility(8);
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding10 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding10);
            activityFeedDetailsBinding10.totalQuestion.setVisibility(0);
            ActivityFeedDetailsBinding activityFeedDetailsBinding11 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding11);
            TextView textView3 = activityFeedDetailsBinding11.totalQuestion;
            Json json7 = this.optiondata;
            Intrinsics.checkNotNull(json7);
            textView3.setText(json7.getTotal_questions() + " Questions");
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding12 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding12);
        activityFeedDetailsBinding12.startQuiz.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetails.setQuiz$lambda$19(this.f$0, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setQuiz$lambda$19(FeedDetails feedDetails, PostDataTable postDataTable, View view) {
        Json json = feedDetails.optiondata;
        Intrinsics.checkNotNull(json);
        if (json.getState() != null) {
            Json json2 = feedDetails.optiondata;
            Intrinsics.checkNotNull(json2);
            if (StringsKt.equals$default(json2.getState(), "1", false, 2, null)) {
                SharedPreference.getInstance().putString("id", "FEEDS");
                Intent intent = new Intent(feedDetails, (Class<?>) QuizActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                intent.putExtra("status", postDataTable.getMeta_url());
                Json json3 = feedDetails.optiondata;
                Intrinsics.checkNotNull(json3);
                intent.putExtra("name", json3.getTest_series_name());
                Json json4 = feedDetails.optiondata;
                Intrinsics.checkNotNull(json4);
                intent.putExtra("first_attempt", json4.getState());
                Helper.gotoActivity(intent, feedDetails);
                return;
            }
        }
        NetworkCall networkCall = new NetworkCall(feedDetails, feedDetails);
        feedDetails.networkCall = networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
    }

    private final void setQuestion(PostDataTable data) {
        Json json = (Json) new Gson().fromJson(data.getJson(), Json.class);
        ActivityFeedDetailsBinding activityFeedDetailsBinding = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding);
        TextView postAttempt = activityFeedDetailsBinding.postAttempt;
        Intrinsics.checkNotNullExpressionValue(postAttempt, "postAttempt");
        postAttempt.setVisibility(0);
        ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding2);
        TextView postAttempt2 = activityFeedDetailsBinding2.postAttempt;
        Intrinsics.checkNotNullExpressionValue(postAttempt2, "postAttempt");
        ExtensionFucationKt.attempts(postAttempt2, json.getTotal_attempt());
        if (data.getPost_type().equals("8")) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            RecyclerView recyclerView = activityFeedDetailsBinding3.recyerclerView;
            Intrinsics.checkNotNull(json);
            recyclerView.setAdapter(new OptionWebAdapter(this, json.getOptions(), this, 0, json));
            return;
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding4 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding4);
        RecyclerView recyclerView2 = activityFeedDetailsBinding4.recyerclerView;
        Intrinsics.checkNotNull(json);
        recyclerView2.setAdapter(new OptionAdapter(this, json.getOptions(), this, 0, json));
    }

    private final void setLink(final PostDataTable data) {
        if (data.getMeta_url().length() == 0) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding);
            activityFeedDetailsBinding.linkTxt.setEnabled(false);
            ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding2);
            activityFeedDetailsBinding2.linkTxt.setVisibility(4);
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            activityFeedDetailsBinding3.linkTxt.setEnabled(true);
            ActivityFeedDetailsBinding activityFeedDetailsBinding4 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding4);
            activityFeedDetailsBinding4.linkTxt.setVisibility(0);
            ActivityFeedDetailsBinding activityFeedDetailsBinding5 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding5);
            activityFeedDetailsBinding5.linkTxt.setText(data.getMeta_url());
            ActivityFeedDetailsBinding activityFeedDetailsBinding6 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding6);
            TextView linkTxt = activityFeedDetailsBinding6.linkTxt;
            Intrinsics.checkNotNullExpressionValue(linkTxt, "linkTxt");
            makeLinks(linkTxt, data.getMeta_url());
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding7 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding7);
        activityFeedDetailsBinding7.linkTxt.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetails.setLink$lambda$20(data, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLink$lambda$20(PostDataTable postDataTable, FeedDetails feedDetails, View view) {
        if (Helper.isValidUrl(postDataTable.getMeta_url())) {
            Helper.gotoActivity(new Intent("android.intent.action.VIEW", Uri.parse(postDataTable.getMeta_url())), feedDetails);
        } else {
            Toast.makeText(feedDetails, "Invalid Url", 0).show();
        }
    }

    public final void makeLinks(TextView textView, String link) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(link, "link");
        SpannableString spannableString = new SpannableString(textView.getText());
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) textView.getText().toString(), link, 0, false, 6, (Object) null);
        spannableString.setSpan(new StyleSpan(1), 0, link.length() + iIndexOf$default, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.link_color)), iIndexOf$default, link.length() + iIndexOf$default, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    private final void setImage(final PostDataTable data) {
        if (data.getDescription().length() == 0) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding);
            activityFeedDetailsBinding.imageText.setVisibility(8);
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding2);
            activityFeedDetailsBinding2.imageText.setVisibility(0);
            Spanned spannedFromHtml = Html.fromHtml(data.getDescription(), 0, this, null);
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            activityFeedDetailsBinding3.imageText.setText(spannedFromHtml);
            ActivityFeedDetailsBinding activityFeedDetailsBinding4 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding4);
            activityFeedDetailsBinding4.imageText.setMovementMethod(LinkMovementMethod.getInstance());
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding5 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding5);
        activityFeedDetailsBinding5.imageReadMore.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetails.setImage$lambda$21(this.f$0, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setImage$lambda$21(FeedDetails feedDetails, PostDataTable postDataTable, View view) {
        ActivityFeedDetailsBinding activityFeedDetailsBinding = feedDetails.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding);
        if (activityFeedDetailsBinding.imageReadMore.getText().equals("Read More")) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding2 = feedDetails.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding2);
            activityFeedDetailsBinding2.imageText.setText(postDataTable.getText());
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = feedDetails.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            activityFeedDetailsBinding3.imageReadMore.setText("Read Less");
            return;
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding4 = feedDetails.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding4);
        TextView textView = activityFeedDetailsBinding4.imageText;
        String strSubstring = postDataTable.getText().substring(0, 200);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        textView.setText(strSubstring + "...");
        ActivityFeedDetailsBinding activityFeedDetailsBinding5 = feedDetails.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding5);
        activityFeedDetailsBinding5.imageReadMore.setText("Read More");
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String s) {
        int i = getResources().getDisplayMetrics().widthPixels;
        LevelListDrawable levelListDrawable = new LevelListDrawable();
        Drawable drawable = getResources().getDrawable(R.mipmap.course_placeholder);
        levelListDrawable.addLevel(0, 0, drawable);
        levelListDrawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(s, levelListDrawable, i, 10, this, null), 3, null);
        return levelListDrawable;
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedDetails$getDrawable$1, reason: invalid class name */
    /* JADX INFO: compiled from: FeedDetails.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedDetails$getDrawable$1", f = "FeedDetails.kt", i = {}, l = {808}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LevelListDrawable $d;
        final /* synthetic */ int $dpWidth;
        final /* synthetic */ int $padding;
        final /* synthetic */ String $s;
        int label;
        final /* synthetic */ FeedDetails this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, LevelListDrawable levelListDrawable, int i, int i2, FeedDetails feedDetails, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$s = str;
            this.$d = levelListDrawable;
            this.$dpWidth = i;
            this.$padding = i2;
            this.this$0 = feedDetails;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$s, this.$d, this.$dpWidth, this.$padding, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(this.$s).openStream());
                    if (bitmapDecodeStream != null) {
                        this.$d.addLevel(1, 1, new BitmapDrawable(bitmapDecodeStream));
                        int i2 = this.$dpWidth;
                        int i3 = this.$padding;
                        int i4 = i2 - (i3 * i3);
                        this.$d.setBounds(0, 0, i4, (bitmapDecodeStream.getHeight() * i4) / bitmapDecodeStream.getWidth());
                        this.$d.setLevel(1);
                        this.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C01091(this.this$0, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedDetails$getDrawable$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FeedDetails.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedDetails$getDrawable$1$1", f = "FeedDetails.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FeedDetails this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01091(FeedDetails feedDetails, Continuation<? super C01091> continuation) {
                super(2, continuation);
                this.this$0 = feedDetails;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01091(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ActivityFeedDetailsBinding activityFeedDetailsBinding = this.this$0.feedDetailsBinding;
                    Intrinsics.checkNotNull(activityFeedDetailsBinding);
                    CharSequence text = activityFeedDetailsBinding.articleTxt.getText();
                    ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.this$0.feedDetailsBinding;
                    Intrinsics.checkNotNull(activityFeedDetailsBinding2);
                    activityFeedDetailsBinding2.articleTxt.setText(text);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void setArticle(PostDataTable data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getText().length() == 0) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding);
            activityFeedDetailsBinding.articleTxtTop.setVisibility(8);
        } else {
            ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding2);
            activityFeedDetailsBinding2.articleTxtTop.setVisibility(0);
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = this.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            activityFeedDetailsBinding3.articleTxtTop.setText(data.getText());
        }
        final Spanned spannedFromHtml = Html.fromHtml(data.getMeta_url(), 0, this, null);
        ActivityFeedDetailsBinding activityFeedDetailsBinding4 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding4);
        activityFeedDetailsBinding4.articleTxt.setText(spannedFromHtml);
        ActivityFeedDetailsBinding activityFeedDetailsBinding5 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding5);
        activityFeedDetailsBinding5.articleTxt.setMovementMethod(LinkMovementMethod.getInstance());
        ActivityFeedDetailsBinding activityFeedDetailsBinding6 = this.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding6);
        activityFeedDetailsBinding6.readMore.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetails.setArticle$lambda$22(this.f$0, spannedFromHtml, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setArticle$lambda$22(FeedDetails feedDetails, Spanned spanned, View view) {
        ActivityFeedDetailsBinding activityFeedDetailsBinding = feedDetails.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding);
        if (activityFeedDetailsBinding.readMore.getText().equals("Read More")) {
            ActivityFeedDetailsBinding activityFeedDetailsBinding2 = feedDetails.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding2);
            activityFeedDetailsBinding2.articleTxt.setText(spanned);
            ActivityFeedDetailsBinding activityFeedDetailsBinding3 = feedDetails.feedDetailsBinding;
            Intrinsics.checkNotNull(activityFeedDetailsBinding3);
            activityFeedDetailsBinding3.readMore.setText("Read Less");
            return;
        }
        ActivityFeedDetailsBinding activityFeedDetailsBinding4 = feedDetails.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding4);
        TextView textView = activityFeedDetailsBinding4.articleTxt;
        Intrinsics.checkNotNull(spanned);
        textView.setText(spanned.subSequence(0, 200).toString() + "...");
        ActivityFeedDetailsBinding activityFeedDetailsBinding5 = feedDetails.feedDetailsBinding;
        Intrinsics.checkNotNull(activityFeedDetailsBinding5);
        activityFeedDetailsBinding5.readMore.setText("Read More");
    }

    @Override // com.appnew.android.feeds.OptionItem
    public void itemSelect(Option option, int index, int feedlistpos) {
        Intrinsics.checkNotNullParameter(option, "option");
        this.option_index = index;
        createBodyData("Attempt Mcq");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void createBodyData(String type) {
        EncryptionData encryptionData = new EncryptionData();
        String json = "";
        switch (type.hashCode()) {
            case -314243511:
                if (type.equals("GetComment")) {
                    PostDataTable postDataTable = this.postDataTable;
                    Intrinsics.checkNotNull(postDataTable);
                    encryptionData.setPost_id(postDataTable.getId());
                    encryptionData.setParent_id("0");
                    json = new Gson().toJson(encryptionData);
                }
                break;
            case -171309688:
                if (type.equals("Attempt Mcq")) {
                    PostDataTable postDataTable2 = this.postDataTable;
                    Intrinsics.checkNotNull(postDataTable2);
                    encryptionData.setPost_id(postDataTable2.getId());
                    encryptionData.setIndex(String.valueOf(this.option_index + 1));
                    json = new Gson().toJson(encryptionData);
                }
                break;
            case 80245:
                if (type.equals("Pin")) {
                    PostDataTable postDataTable3 = this.postDataTable;
                    Intrinsics.checkNotNull(postDataTable3);
                    encryptionData.setPost_id(postDataTable3.getId());
                    encryptionData.setPost_pin("1");
                    json = new Gson().toJson(encryptionData);
                }
                break;
            case 2368439:
                if (type.equals("Like")) {
                    PostDataTable postDataTable4 = this.postDataTable;
                    Intrinsics.checkNotNull(postDataTable4);
                    encryptionData.setMy_like(postDataTable4.getMy_like().equals("1") ? "0" : "1");
                    PostDataTable postDataTable5 = this.postDataTable;
                    Intrinsics.checkNotNull(postDataTable5);
                    encryptionData.setPost_id(postDataTable5.getId());
                    json = new Gson().toJson(encryptionData);
                }
                break;
            case 81887292:
                if (type.equals("Unpin")) {
                    PostDataTable postDataTable6 = this.postDataTable;
                    Intrinsics.checkNotNull(postDataTable6);
                    encryptionData.setPost_id(postDataTable6.getId());
                    encryptionData.setPost_pin("0");
                    json = new Gson().toJson(encryptionData);
                }
                break;
            case 557130398:
                if (type.equals("AddComment")) {
                    encryptionData.setId("");
                    encryptionData.setParent_id("0");
                    PostDataTable postDataTable7 = this.postDataTable;
                    Intrinsics.checkNotNull(postDataTable7);
                    encryptionData.setPost_id(postDataTable7.getId());
                    encryptionData.setComment(this.comment_txt);
                    json = new Gson().toJson(encryptionData);
                }
                break;
        }
        String strEncrypt = AES.encrypt(json);
        getFeedDetailViewModel().getType().setValue(type);
        getFeedDetailViewModel().getAdapter_bodydata().setValue(strEncrypt);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.API_GET_INFO_TEST_SERIES)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id("FEEDS");
            PostDataTable postDataTable = this.postDataTable;
            Intrinsics.checkNotNull(postDataTable);
            encryptionData.setTest_id(postDataTable.getMeta_url());
            String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
            Intrinsics.checkNotNull(service);
            return service.API_GET_INFO_TEST_SERIES(strEncrypt);
        }
        if (Intrinsics.areEqual(apitype, API.API_GET_TEST_INSTRUCTION_DATA)) {
            EncryptionData encryptionData2 = new EncryptionData();
            PostDataTable postDataTable2 = this.postDataTable;
            Intrinsics.checkNotNull(postDataTable2);
            encryptionData2.setTest_id(postDataTable2.getMeta_url());
            encryptionData2.setCourse_id("FEEDS");
            String strEncrypt2 = AES.encrypt(new Gson().toJson(encryptionData2));
            Intrinsics.checkNotNull(service);
            return service.API_GET_TEST_INSTRUCTION_DATA(strEncrypt2);
        }
        Intrinsics.checkNotNull(null);
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNull(jsonstring);
        String strOptString = jsonstring.optString("time");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        MakeMyExam.setTime_server(Long.parseLong(strOptString) * ((long) 1000));
        if (Intrinsics.areEqual(apitype, API.API_GET_TEST_INSTRUCTION_DATA)) {
            try {
                if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                    InstructionData instructionData = (InstructionData) new Gson().fromJson(jsonstring.getJSONObject("data").toString(), InstructionData.class);
                    Intrinsics.checkNotNull(instructionData);
                    showPopUp(instructionData);
                    return;
                } else {
                    if (Intrinsics.areEqual(jsonstring.optString("status"), "false") && !StringsKt.equals(jsonstring.optString("auth_code"), Const.EXPIRY_AUTH_CODE, true)) {
                        RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                        return;
                    }
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.API_GET_INFO_TEST_SERIES)) {
            if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                long jOptLong = jsonstring.optLong("time");
                try {
                    TestseriesBase testseriesBase = (TestseriesBase) new Gson().fromJson(jsonstring.toString(), TestseriesBase.class);
                    String[] strArr = this.langIds;
                    if (strArr != null && strArr.length > 0) {
                        int i = this.lang;
                        if (i == 1) {
                            if (testseriesBase.getData().getQuestions() == null || testseriesBase.getData().getQuestions().isEmpty()) {
                                Toast.makeText(this, "All questions may not be available in English language.", 0).show();
                                return;
                            }
                        } else if (i == 2 && (testseriesBase.getData().getQuestionsHindi() == null || testseriesBase.getData().getQuestionsHindi().isEmpty())) {
                            Toast.makeText(this, "All questions may not be available in Hindi language.", 0).show();
                            return;
                        }
                        if (this.langIds.length > 1) {
                            boolean z = testseriesBase.getData().getQuestions() == null || testseriesBase.getData().getQuestions().isEmpty();
                            boolean z2 = testseriesBase.getData().getQuestionsHindi() == null || testseriesBase.getData().getQuestionsHindi().isEmpty();
                            if (z && z2) {
                                Toast.makeText(this, "All questions may not be available in both languages.", 0).show();
                                return;
                            }
                        }
                        if (testseriesBase.getData().getQuestions() == null || testseriesBase.getData().getQuestions().size() <= 0) {
                            str = "time";
                            str2 = Const.LANG;
                            str3 = "enddate";
                        } else {
                            if (this.lang == 1) {
                                Intent intent = new Intent(this, (Class<?>) TestBaseActivity.class);
                                intent.putExtra("status", false);
                                PostDataTable postDataTable = this.postDataTable;
                                Intrinsics.checkNotNull(postDataTable);
                                intent.putExtra(Const.TEST_SERIES_ID, postDataTable.getMeta_url());
                                ActivityFeedDetailsBinding activityFeedDetailsBinding = this.feedDetailsBinding;
                                Intrinsics.checkNotNull(activityFeedDetailsBinding);
                                intent.putExtra(Const.TEST_SERIES_Name, activityFeedDetailsBinding.testName.getText().toString());
                                SharedPreference.getInstance().putString("test_series", jsonstring.toString());
                                intent.putExtra("course_id", "FEEDS");
                                Json json = this.optiondata;
                                Intrinsics.checkNotNull(json);
                                intent.putExtra(Const.TOTAL_QUESTIONS, json.getTotal_questions());
                                intent.putExtra("first_attempt", "1");
                                intent.putExtra("result_date", "");
                                intent.putExtra("test_submission", "1");
                                intent.putExtra("time", jOptLong);
                                intent.putExtra("enddate", "");
                                intent.putExtra(Const.LANG, this.lang);
                                intent.putExtra("post_json", new Gson().toJson(this.postDataTable));
                                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");
                                Helper.gotoActivity_finish(intent, this);
                                return;
                            }
                            str = "time";
                            str2 = Const.LANG;
                            str3 = "enddate";
                            jOptLong = jOptLong;
                        }
                        if (testseriesBase.getData().getQuestionsHindi() != null && testseriesBase.getData().getQuestionsHindi().size() > 0) {
                            long j = jOptLong;
                            if (this.lang == 2) {
                                testseriesBase.getData().setQuestions(testseriesBase.getData().getQuestionsHindi());
                                String str4 = str2;
                                Intent intent2 = new Intent(this, (Class<?>) TestBaseActivity.class);
                                intent2.putExtra("status", false);
                                PostDataTable postDataTable2 = this.postDataTable;
                                Intrinsics.checkNotNull(postDataTable2);
                                intent2.putExtra(Const.TEST_SERIES_ID, postDataTable2.getMeta_url());
                                ActivityFeedDetailsBinding activityFeedDetailsBinding2 = this.feedDetailsBinding;
                                Intrinsics.checkNotNull(activityFeedDetailsBinding2);
                                intent2.putExtra(Const.TEST_SERIES_Name, activityFeedDetailsBinding2.testName.getText().toString());
                                SharedPreference.getInstance().putString("test_series", jsonstring.toString());
                                intent2.putExtra("course_id", "FEEDS");
                                Json json2 = this.optiondata;
                                Intrinsics.checkNotNull(json2);
                                intent2.putExtra(Const.TOTAL_QUESTIONS, json2.getTotal_questions());
                                intent2.putExtra("first_attempt", "1");
                                intent2.putExtra("result_date", "");
                                intent2.putExtra("test_submission", "1");
                                intent2.putExtra(str4, this.lang);
                                intent2.putExtra(str, j);
                                intent2.putExtra(str3, "");
                                intent2.putExtra("post_json", new Gson().toJson(this.postDataTable));
                                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");
                                Helper.gotoActivity_finish(intent2, this);
                                return;
                            }
                        }
                        Toast.makeText(this, "No Question Found", 0).show();
                        return;
                    }
                    Toast.makeText(this, "Language not found!", 0).show();
                    return;
                } catch (Exception unused) {
                    Toast.makeText(this, "Something went wrong.", 0).show();
                    return;
                }
            }
            if (StringsKt.equals(jsonstring.optString("auth_code"), Const.EXPIRY_AUTH_CODE, true)) {
                return;
            }
            RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final String[] getLangIds() {
        return this.langIds;
    }

    public final void setLangIds(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.langIds = strArr;
    }

    private final void showPopUp(InstructionData instructionData) {
        Button button;
        TextView textView;
        TextView textView2;
        List listEmptyList;
        Object systemService = getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_basicinfo_quiz_career, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(viewInflate);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -1);
        dialog.show();
        final TestBasicInst testBasic = instructionData.getTestBasic();
        View viewFindViewById = viewInflate.findViewById(R.id.quizTitleTV);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.marksTextValueTV);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.numQuesValueTV);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView5 = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.sectionValueTV);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView6 = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.languageSpinnerTV);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView7 = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.quizTimeValueTV);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView8 = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.remarksTV);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView9 = (TextView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.check_box);
        Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.widget.CheckBox");
        final CheckBox checkBox = (CheckBox) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.generalInstrValueTV);
        Intrinsics.checkNotNull(viewFindViewById9, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView10 = (TextView) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.startQuizBtn);
        Intrinsics.checkNotNull(viewFindViewById10, "null cannot be cast to non-null type android.widget.Button");
        Button button2 = (Button) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.sectionListLL);
        Intrinsics.checkNotNull(viewFindViewById11, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.general_layout);
        Intrinsics.checkNotNull(viewFindViewById12, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout2 = (LinearLayout) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.section_time);
        Intrinsics.checkNotNull(viewFindViewById13, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout3 = (LinearLayout) viewFindViewById13;
        if (TextUtils.isEmpty(testBasic.getLang_id())) {
            button = button2;
            textView = textView6;
            textView2 = textView10;
        } else {
            button = button2;
            String lang_id = testBasic.getLang_id();
            Intrinsics.checkNotNullExpressionValue(lang_id, "getLang_id(...)");
            textView = textView6;
            textView2 = textView10;
            List<String> listSplit = new Regex(Constants.SEPARATOR_COMMA).split(lang_id, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
                this.langIds = (String[]) listEmptyList.toArray(new String[0]);
            } else {
                listEmptyList = CollectionsKt.emptyList();
                this.langIds = (String[]) listEmptyList.toArray(new String[0]);
            }
        }
        if (testBasic.getTest_assets() != null) {
            if (StringsKt.equals(testBasic.getTest_assets().getHide_inst_time(), "0", true)) {
                linearLayout3.setVisibility(0);
            } else {
                linearLayout3.setVisibility(4);
            }
        }
        addSectionView(linearLayout, instructionData);
        if (SharedPreference.getInstance().getBoolean(Const.RE_ATTEMPT)) {
            textView9.setVisibility(8);
        } else {
            textView9.setVisibility(8);
        }
        if (testBasic.getLang_id().length() == 3) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedDetails.showPopUp$lambda$24(this.f$0, textView7, testBasic, view);
                }
            });
        }
        String lang_id2 = testBasic.getLang_id();
        Intrinsics.checkNotNullExpressionValue(lang_id2, "getLang_id(...)");
        if (Intrinsics.areEqual(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id2, 0).toArray(new String[0]))[0], "1")) {
            textView7.setText(getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            String lang_id3 = testBasic.getLang_id();
            Intrinsics.checkNotNullExpressionValue(lang_id3, "getLang_id(...)");
            this.lang = Integer.parseInt(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id3, 0).toArray(new String[0]))[0]);
        } else {
            String lang_id4 = testBasic.getLang_id();
            Intrinsics.checkNotNullExpressionValue(lang_id4, "getLang_id(...)");
            if (Intrinsics.areEqual(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id4, 0).toArray(new String[0]))[0], "2")) {
                textView7.setText(getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                String lang_id5 = testBasic.getLang_id();
                Intrinsics.checkNotNullExpressionValue(lang_id5, "getLang_id(...)");
                this.lang = Integer.parseInt(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id5, 0).toArray(new String[0]))[0]);
            }
        }
        textView3.setText(testBasic.getTestSeriesName());
        textView5.setText(testBasic.getTotalQuestions());
        textView8.setText(testBasic.getTimeInMins());
        textView4.setText(testBasic.getTotalMarks());
        String description = testBasic.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "getDescription(...)");
        if (description.length() == 0) {
            linearLayout2.setVisibility(8);
        } else {
            linearLayout2.setVisibility(0);
            textView2.setText(Html.fromHtml(testBasic.getDescription()));
        }
        TextView textView11 = textView;
        textView11.setText(new StringBuilder().append(instructionData.getTestSections().size()).toString());
        Button button3 = button;
        button3.setTag(testBasic);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetails.showPopUp$lambda$25(testBasic, this, checkBox, dialog, view);
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda20
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return FeedDetails.showPopUp$lambda$26(dialog, dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopUp$lambda$24(FeedDetails feedDetails, TextView textView, TestBasicInst testBasicInst, View view) {
        Intrinsics.checkNotNull(testBasicInst);
        feedDetails.showPopMenuForLangauge(textView, testBasicInst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopUp$lambda$25(TestBasicInst testBasicInst, FeedDetails feedDetails, CheckBox checkBox, Dialog dialog, View view) {
        if (StringsKt.equals(testBasicInst.getTotalQuestions(), "0", true)) {
            Toast.makeText(feedDetails, "Please add Question.", 0).show();
        } else if (checkBox.isChecked()) {
            dialog.dismiss();
            feedDetails.getintotestseries();
        } else {
            Toast.makeText(feedDetails, "Please check following instructions.", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPopUp$lambda$26(Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return true;
        }
        dialog.dismiss();
        return true;
    }

    private final void addSectionView(LinearLayout sectionListLL, InstructionData instructionData) {
        int i = 0;
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            Intrinsics.checkNotNull(testSectionInst);
            String hide_inst_time = instructionData.getTestBasic().getTest_assets() == null ? "" : instructionData.getTestBasic().getTest_assets().getHide_inst_time();
            Intrinsics.checkNotNull(hide_inst_time);
            sectionListLL.addView(initSectionListView(testSectionInst, i, hide_inst_time));
            i++;
        }
    }

    public final void showPopMenuForLangauge(final View v, TestBasicInst testBasicInst) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(testBasicInst, "testBasicInst");
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.feeds.activity.FeedDetails$$ExternalSyntheticLambda0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return FeedDetails.showPopMenuForLangauge$lambda$27(v, this, menuItem);
            }
        });
        String lang_id = testBasicInst.getLang_id();
        Intrinsics.checkNotNullExpressionValue(lang_id, "getLang_id(...)");
        int length = new Regex(Constants.SEPARATOR_COMMA).split(lang_id, 0).toArray(new String[0]).length;
        for (int i = 0; i < length; i++) {
            String lang_id2 = testBasicInst.getLang_id();
            Intrinsics.checkNotNullExpressionValue(lang_id2, "getLang_id(...)");
            if (Intrinsics.areEqual(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id2, 0).toArray(new String[0]))[i], "1")) {
                popupMenu.getMenu().add(getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else {
                String lang_id3 = testBasicInst.getLang_id();
                Intrinsics.checkNotNullExpressionValue(lang_id3, "getLang_id(...)");
                if (Intrinsics.areEqual(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id3, 0).toArray(new String[0]))[i], "2")) {
                    popupMenu.getMenu().add(getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                }
            }
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPopMenuForLangauge$lambda$27(View view, FeedDetails feedDetails, MenuItem menuItem) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) view).setText(String.valueOf(menuItem.getTitle()));
        if (Intrinsics.areEqual(String.valueOf(menuItem.getTitle()), feedDetails.getString(R.string.hindi))) {
            feedDetails.lang = 2;
            return false;
        }
        if (!Intrinsics.areEqual(String.valueOf(menuItem.getTitle()), feedDetails.getString(R.string.english))) {
            return false;
        }
        feedDetails.lang = 1;
        return false;
    }

    private final void getintotestseries() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
    }

    public final LinearLayout initSectionListView(TestSectionInst testSectionInst, int tag, String hide_inst_time) {
        String str;
        String totalNumOfAttempts;
        int intSafe;
        Intrinsics.checkNotNullParameter(testSectionInst, "testSectionInst");
        Intrinsics.checkNotNullParameter(hide_inst_time, "hide_inst_time");
        ArrayList arrayList = new ArrayList();
        View viewInflate = View.inflate(this, R.layout.layout_option_section_list_view, null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        View viewFindViewById = linearLayout.findViewById(R.id.secNameTV);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = linearLayout.findViewById(R.id.totQuesTV);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = linearLayout.findViewById(R.id.totNoAttmtsTV);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) viewFindViewById3;
        View viewFindViewById4 = linearLayout.findViewById(R.id.totTimeTV);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) viewFindViewById4;
        View viewFindViewById5 = linearLayout.findViewById(R.id.maxMarksTV);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView5 = (TextView) viewFindViewById5;
        View viewFindViewById6 = linearLayout.findViewById(R.id.markPerQuesTV);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView6 = (TextView) viewFindViewById6;
        View viewFindViewById7 = linearLayout.findViewById(R.id.negMarkPerQuesTV);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView7 = (TextView) viewFindViewById7;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        if (hide_inst_time.length() > 0) {
            if (StringsKt.equals(hide_inst_time, "0", true)) {
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(4);
            }
        }
        String sectionPart = testSectionInst.getSectionPart();
        if (sectionPart == null || sectionPart.length() == 0) {
            str = "";
        } else {
            str = " (" + testSectionInst.getSectionPart() + ")";
        }
        textView.setText(testSectionInst.getName() + str);
        textView2.setText(testSectionInst.getTotalQuestions());
        String totalNumOfAttempts2 = testSectionInst.getTotalNumOfAttempts();
        if (totalNumOfAttempts2 != null && totalNumOfAttempts2.length() != 0) {
            totalNumOfAttempts = testSectionInst.getTotalNumOfAttempts();
        }
        textView3.setText(totalNumOfAttempts);
        textView4.setText(testSectionInst.getSectionTiming());
        float floatSafe = Helper.parseFloatSafe(testSectionInst.getMarksPerQuestion());
        String totalNumOfAttempts3 = testSectionInst.getTotalNumOfAttempts();
        if (totalNumOfAttempts3 != null && totalNumOfAttempts3.length() != 0) {
            intSafe = Helper.parseIntSafe(testSectionInst.getTotalNumOfAttempts());
        } else {
            intSafe = Helper.parseIntSafe(testSectionInst.getTotalQuestions());
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(floatSafe * intSafe)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        textView5.setText(str2);
        textView6.setText(testSectionInst.getMarksPerQuestion());
        textView7.setText(String.valueOf(Helper.parseFloatSafe(testSectionInst.getNegativeMarks())));
        linearLayout.setTag(Integer.valueOf(tag));
        arrayList.add(linearLayout);
        return linearLayout;
    }
}
