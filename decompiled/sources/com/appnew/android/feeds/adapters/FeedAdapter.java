package com.appnew.android.feeds.adapters;

import android.app.Activity;
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
import android.os.Handler;
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
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Dao.FeedsDao;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ArticleVmBinding;
import com.appnew.android.databinding.AudioPostBinding;
import com.appnew.android.databinding.BannerViewBinding;
import com.appnew.android.databinding.LinkViewBinding;
import com.appnew.android.databinding.LiveClassVmBinding;
import com.appnew.android.databinding.LiveTestVmBinding;
import com.appnew.android.databinding.NewCourseVmBinding;
import com.appnew.android.databinding.NewTestresultVmBinding;
import com.appnew.android.databinding.PostImageBinding;
import com.appnew.android.databinding.QuestionViewBinding;
import com.appnew.android.databinding.QuizViewBinding;
import com.appnew.android.databinding.VideoPostBinding;
import com.appnew.android.feeds.OptionItem;
import com.appnew.android.feeds.activity.FeedVideoPlayer;
import com.appnew.android.feeds.activity.FeedsActivity;
import com.appnew.android.feeds.activity.PinnedPostActivity;
import com.appnew.android.feeds.adapters.FeedAdapter;
import com.appnew.android.feeds.dataclass.BannerData;
import com.appnew.android.feeds.dataclass.Option;
import com.appnew.android.feeds.dataclass.comment.Data;
import com.appnew.android.feeds.fragments.FeedsFragment;
import com.appnew.android.table.PostDataTable;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
import org.jivesoftware.smack.packet.Message;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: FeedAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0018¨\u0001©\u0001ª\u0001«\u0001¬\u0001\u00ad\u0001®\u0001¯\u0001°\u0001±\u0001²\u0001³\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010c\u001a\u00020\u00022\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u001eH\u0016J\u0018\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u001eH\u0017J\u0010\u0010k\u001a\u00020h2\u0006\u0010l\u001a\u00020'H\u0002J\u0016\u0010m\u001a\u00020h2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u001eJ\u0016\u0010n\u001a\u00020h2\u0006\u0010P\u001a\u00020Q2\u0006\u0010o\u001a\u00020'J\u0010\u0010p\u001a\u00020\u001e2\u0006\u0010j\u001a\u00020\u001eH\u0016J\b\u0010q\u001a\u00020\u001eH\u0016J\u0010\u0010r\u001a\u00020h2\u0006\u0010s\u001a\u00020tH\u0002J\u0010\u0010u\u001a\u00020h2\u0006\u0010v\u001a\u00020\u001eH\u0002J,\u0010w\u001a\b\u0012\u0004\u0012\u00020'0x2\b\u0010y\u001a\u0004\u0018\u00010'2\b\u0010z\u001a\u0004\u0018\u00010'2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J/\u0010}\u001a\u00020h2\b\u0010~\u001a\u0004\u0018\u00010\u007f2\b\u0010y\u001a\u0004\u0018\u00010'2\b\u0010z\u001a\u0004\u0018\u00010'2\u0007\u0010\u0080\u0001\u001a\u000206H\u0016J\u001b\u0010\u0081\u0001\u001a\u00020h2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020hH\u0002J\u0013\u0010\u0087\u0001\u001a\u00020h2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0003J\u001c\u0010\u008a\u0001\u001a\u00020h2\u0007\u0010\u008b\u0001\u001a\u00020t2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J%\u0010\u008c\u0001\u001a\u00020t2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u001e2\u0007\u0010\u0090\u0001\u001a\u00020'H\u0007J'\u0010\u0091\u0001\u001a\u00020h2\b\u0010~\u001a\u0004\u0018\u00010'2\b\u0010y\u001a\u0004\u0018\u00010'2\b\u0010z\u001a\u0004\u0018\u00010'H\u0016J%\u0010\u0092\u0001\u001a\u00020h2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020\u001eH\u0016J\u0016\u0010\u0097\u0001\u001a\u00020h2\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0007\u0010\u0099\u0001\u001a\u00020hJ\u0011\u0010\u009a\u0001\u001a\u00020h2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001J\u0010\u0010\u009d\u0001\u001a\u00020h2\u0007\u0010\u009e\u0001\u001a\u00020\u007fJ\u0007\u0010\u009f\u0001\u001a\u00020hJ\u0011\u0010 \u0001\u001a\u00020h2\b\u0010¡\u0001\u001a\u00030\u0083\u0001J\u0011\u0010¢\u0001\u001a\u00020h2\b\u0010¡\u0001\u001a\u00030\u0083\u0001J\u0015\u0010£\u0001\u001a\u00030¤\u00012\t\u0010¥\u0001\u001a\u0004\u0018\u00010'H\u0017J\u0007\u0010¦\u0001\u001a\u00020hJ\u0007\u0010§\u0001\u001a\u00020hR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010 \"\u0004\bC\u0010\"R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020KX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0014\u0010N\u001a\u00020KX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bO\u0010MR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u0011¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b¨\u0006´\u0001"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/text/Html$ImageGetter;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/feeds/OptionItem;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "feedatalist", "Ljava/util/ArrayList;", "Lcom/appnew/android/feeds/dataclass/Data;", "getFeedatalist", "()Ljava/util/ArrayList;", "setFeedatalist", "(Ljava/util/ArrayList;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "item_pos", "", "getItem_pos", "()I", "setItem_pos", "(I)V", "lang", "getLang", "setLang", "comment_txt", "", "getComment_txt", "()Ljava/lang/String;", "setComment_txt", "(Ljava/lang/String;)V", "commentAdapter", "Lcom/appnew/android/feeds/adapters/CommentAdapter;", "getCommentAdapter", "()Lcom/appnew/android/feeds/adapters/CommentAdapter;", "setCommentAdapter", "(Lcom/appnew/android/feeds/adapters/CommentAdapter;)V", "option_index", "getOption_index", "setOption_index", "booleanlike", "", "getBooleanlike", "()Z", "setBooleanlike", "(Z)V", "no_data_found_RL", "Landroid/widget/RelativeLayout;", "getNo_data_found_RL", "()Landroid/widget/RelativeLayout;", "setNo_data_found_RL", "(Landroid/widget/RelativeLayout;)V", "currentPage", "getCurrentPage", "setCurrentPage", "timer", "Ljava/util/Timer;", "getTimer", "()Ljava/util/Timer;", "setTimer", "(Ljava/util/Timer;)V", "DELAY_MS", "", "getDELAY_MS", "()J", "PERIOD_MS", "getPERIOD_MS", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "comment_recyerler", "Landroidx/recyclerview/widget/RecyclerView;", "getComment_recyerler", "()Landroidx/recyclerview/widget/RecyclerView;", "setComment_recyerler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "commentlist", "Lcom/appnew/android/feeds/dataclass/comment/Data;", "getCommentlist", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "createBodyData", "type", "open_comment_layout", "makeLinks", "link", "getItemViewType", "getItemCount", "DisableShareIcon", "postComment", "Landroid/widget/LinearLayout;", "onCommentClick", "adapterPosition", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "showPopMenuForLangauge", "v", "Landroid/view/View;", "testBasicInst", "Lcom/appnew/android/testmodule/model/TestBasicInst;", "getintotestseries", "showPopUp", "instructionData", "Lcom/appnew/android/testmodule/model/InstructionData;", "addSectionView", "sectionListLL", "initSectionListView", "testSectionInst", "Lcom/appnew/android/testmodule/model/TestSectionInst;", "tag", "hide_inst_time", "ErrorCallBack", "itemSelect", "option", "Lcom/appnew/android/feeds/dataclass/Option;", FirebaseAnalytics.Param.INDEX, "feedlistpos", "addFeed", "datalist", "change_posiiton", "getCommentList", "dataJsonObject", "Lorg/json/JSONArray;", "addComment", "jsonObject1", "attempt_mcq", "viewAllclass", ViewHierarchyConstants.VIEW_KEY, "viewAllTest", "getDrawable", "Landroid/graphics/drawable/Drawable;", CmcdData.Factory.STREAMING_FORMAT_SS, "pinPost", "unPinPost", "NewCourseVm", "Banner_Vm", "NewTestResultVm", "NewLiveTestVm", "NewLiveclassVm", "ArticleVm", "LinkVM", "ImageVm", "VideoVm", "AudioVM", "QuestionVM", "QuizVM", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Html.ImageGetter, NetworkCall.MyNetworkCallBack, OptionItem {
    public static final int $stable = 8;
    private final long DELAY_MS;
    private final long PERIOD_MS;
    private boolean booleanlike;
    private CommentAdapter commentAdapter;
    private RecyclerView comment_recyerler;
    private String comment_txt;
    private final ArrayList<Data> commentlist;
    private Context context;
    private int currentPage;
    private ArrayList<com.appnew.android.feeds.dataclass.Data> feedatalist;
    public Fragment fragment;
    private int item_pos;
    private int lang;
    private NetworkCall networkCall;
    public RelativeLayout no_data_found_RL;
    private int option_index;
    private TextView textView;
    private Timer timer;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public FeedAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.feedatalist = new ArrayList<>();
        this.comment_txt = "";
        this.DELAY_MS = 500L;
        this.PERIOD_MS = 3000L;
        this.commentlist = new ArrayList<>();
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final ArrayList<com.appnew.android.feeds.dataclass.Data> getFeedatalist() {
        return this.feedatalist;
    }

    public final void setFeedatalist(ArrayList<com.appnew.android.feeds.dataclass.Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.feedatalist = arrayList;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final int getItem_pos() {
        return this.item_pos;
    }

    public final void setItem_pos(int i) {
        this.item_pos = i;
    }

    public final int getLang() {
        return this.lang;
    }

    public final void setLang(int i) {
        this.lang = i;
    }

    public final String getComment_txt() {
        return this.comment_txt;
    }

    public final void setComment_txt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.comment_txt = str;
    }

    public final CommentAdapter getCommentAdapter() {
        return this.commentAdapter;
    }

    public final void setCommentAdapter(CommentAdapter commentAdapter) {
        this.commentAdapter = commentAdapter;
    }

    public final int getOption_index() {
        return this.option_index;
    }

    public final void setOption_index(int i) {
        this.option_index = i;
    }

    public final boolean getBooleanlike() {
        return this.booleanlike;
    }

    public final void setBooleanlike(boolean z) {
        this.booleanlike = z;
    }

    public final RelativeLayout getNo_data_found_RL() {
        RelativeLayout relativeLayout = this.no_data_found_RL;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("no_data_found_RL");
        return null;
    }

    public final void setNo_data_found_RL(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.no_data_found_RL = relativeLayout;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public final Timer getTimer() {
        return this.timer;
    }

    public final void setTimer(Timer timer) {
        this.timer = timer;
    }

    public final long getDELAY_MS() {
        return this.DELAY_MS;
    }

    public final long getPERIOD_MS() {
        return this.PERIOD_MS;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final void setTextView(TextView textView) {
        this.textView = textView;
    }

    public final RecyclerView getComment_recyerler() {
        return this.comment_recyerler;
    }

    public final void setComment_recyerler(RecyclerView recyclerView) {
        this.comment_recyerler = recyclerView;
    }

    public final ArrayList<Data> getCommentlist() {
        return this.commentlist;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedAdapter(Fragment fragment, Context context) {
        this(context);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(context, "context");
        setFragment(fragment);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1:
                ArticleVmBinding articleVmBindingInflate = ArticleVmBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(articleVmBindingInflate, "inflate(...)");
                return new ArticleVm(this, articleVmBindingInflate);
            case 2:
                PostImageBinding postImageBindingInflate = PostImageBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(postImageBindingInflate, "inflate(...)");
                return new ImageVm(this, postImageBindingInflate);
            case 3:
                VideoPostBinding videoPostBindingInflate = VideoPostBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(videoPostBindingInflate, "inflate(...)");
                return new VideoVm(this, videoPostBindingInflate);
            case 4:
                AudioPostBinding audioPostBindingInflate = AudioPostBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(audioPostBindingInflate, "inflate(...)");
                return new AudioVM(this, audioPostBindingInflate);
            case 5:
                LinkViewBinding linkViewBindingInflate = LinkViewBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(linkViewBindingInflate, "inflate(...)");
                return new LinkVM(this, linkViewBindingInflate);
            case 6:
            case 8:
                QuestionViewBinding questionViewBindingInflate = QuestionViewBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(questionViewBindingInflate, "inflate(...)");
                return new QuestionVM(this, questionViewBindingInflate);
            case 7:
                QuizViewBinding quizViewBindingInflate = QuizViewBinding.inflate(LayoutInflater.from(parent.getContext()));
                Intrinsics.checkNotNullExpressionValue(quizViewBindingInflate, "inflate(...)");
                return new QuizVM(this, quizViewBindingInflate);
            default:
                switch (viewType) {
                    case 1089:
                        BannerViewBinding bannerViewBindingInflate = BannerViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                        Intrinsics.checkNotNullExpressionValue(bannerViewBindingInflate, "inflate(...)");
                        return new Banner_Vm(this, bannerViewBindingInflate);
                    case VideoDownloadService.ONTASK /* 1090 */:
                        NewCourseVmBinding newCourseVmBindingInflate = NewCourseVmBinding.inflate(LayoutInflater.from(parent.getContext()));
                        Intrinsics.checkNotNullExpressionValue(newCourseVmBindingInflate, "inflate(...)");
                        return new NewCourseVm(this, newCourseVmBindingInflate);
                    case 1091:
                        NewTestresultVmBinding newTestresultVmBindingInflate = NewTestresultVmBinding.inflate(LayoutInflater.from(parent.getContext()));
                        Intrinsics.checkNotNullExpressionValue(newTestresultVmBindingInflate, "inflate(...)");
                        return new NewTestResultVm(this, newTestresultVmBindingInflate);
                    case 1092:
                        LiveTestVmBinding liveTestVmBindingInflate = LiveTestVmBinding.inflate(LayoutInflater.from(parent.getContext()));
                        Intrinsics.checkNotNullExpressionValue(liveTestVmBindingInflate, "inflate(...)");
                        return new NewLiveTestVm(this, liveTestVmBindingInflate);
                    case 1093:
                        LiveClassVmBinding liveClassVmBindingInflate = LiveClassVmBinding.inflate(LayoutInflater.from(parent.getContext()));
                        Intrinsics.checkNotNullExpressionValue(liveClassVmBindingInflate, "inflate(...)");
                        return new NewLiveclassVm(this, liveClassVmBindingInflate);
                    default:
                        ArticleVmBinding articleVmBindingInflate2 = ArticleVmBinding.inflate(LayoutInflater.from(parent.getContext()));
                        Intrinsics.checkNotNullExpressionValue(articleVmBindingInflate2, "inflate(...)");
                        return new ArticleVm(this, articleVmBindingInflate2);
                }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 1:
                com.appnew.android.feeds.dataclass.Data data = this.feedatalist.get(position);
                Intrinsics.checkNotNullExpressionValue(data, "get(...)");
                ((ArticleVm) holder).bind(data);
                break;
            case 2:
                com.appnew.android.feeds.dataclass.Data data2 = this.feedatalist.get(position);
                Intrinsics.checkNotNullExpressionValue(data2, "get(...)");
                ((ImageVm) holder).bind(data2);
                break;
            case 3:
                com.appnew.android.feeds.dataclass.Data data3 = this.feedatalist.get(position);
                Intrinsics.checkNotNullExpressionValue(data3, "get(...)");
                ((VideoVm) holder).bind(data3);
                break;
            case 4:
                com.appnew.android.feeds.dataclass.Data data4 = this.feedatalist.get(position);
                Intrinsics.checkNotNullExpressionValue(data4, "get(...)");
                ((AudioVM) holder).bind(data4);
                break;
            case 5:
                com.appnew.android.feeds.dataclass.Data data5 = this.feedatalist.get(position);
                Intrinsics.checkNotNullExpressionValue(data5, "get(...)");
                ((LinkVM) holder).bind(data5);
                break;
            case 6:
            case 8:
                com.appnew.android.feeds.dataclass.Data data6 = this.feedatalist.get(position);
                Intrinsics.checkNotNullExpressionValue(data6, "get(...)");
                ((QuestionVM) holder).bind(data6);
                break;
            case 7:
                com.appnew.android.feeds.dataclass.Data data7 = this.feedatalist.get(position);
                Intrinsics.checkNotNullExpressionValue(data7, "get(...)");
                ((QuizVM) holder).bind(data7);
                break;
            default:
                switch (itemViewType) {
                    case 1089:
                        com.appnew.android.feeds.dataclass.Data data8 = this.feedatalist.get(position);
                        Intrinsics.checkNotNullExpressionValue(data8, "get(...)");
                        ((Banner_Vm) holder).bind(data8);
                        break;
                    case VideoDownloadService.ONTASK /* 1090 */:
                        com.appnew.android.feeds.dataclass.Data data9 = this.feedatalist.get(position);
                        Intrinsics.checkNotNullExpressionValue(data9, "get(...)");
                        ((NewCourseVm) holder).bind(data9);
                        break;
                    case 1091:
                        com.appnew.android.feeds.dataclass.Data data10 = this.feedatalist.get(position);
                        Intrinsics.checkNotNullExpressionValue(data10, "get(...)");
                        ((NewTestResultVm) holder).bind(data10);
                        break;
                    case 1092:
                        com.appnew.android.feeds.dataclass.Data data11 = this.feedatalist.get(position);
                        Intrinsics.checkNotNullExpressionValue(data11, "get(...)");
                        ((NewLiveTestVm) holder).bind(data11);
                        break;
                    case 1093:
                        com.appnew.android.feeds.dataclass.Data data12 = this.feedatalist.get(position);
                        Intrinsics.checkNotNullExpressionValue(data12, "get(...)");
                        ((NewLiveclassVm) holder).bind(data12);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void createBodyData(String type) {
        try {
            EncryptionData encryptionData = new EncryptionData();
            String json = "";
            switch (type.hashCode()) {
                case -314243511:
                    if (type.equals("GetComment")) {
                        encryptionData.setPost_id(this.feedatalist.get(this.item_pos).getId());
                        encryptionData.setParent_id("0");
                        json = new Gson().toJson(encryptionData);
                    }
                    break;
                case -171309688:
                    if (type.equals("Attempt Mcq")) {
                        encryptionData.setPost_id(this.feedatalist.get(this.item_pos).getId());
                        encryptionData.setIndex(String.valueOf(this.option_index + 1));
                        json = new Gson().toJson(encryptionData);
                    }
                    break;
                case 80245:
                    if (type.equals("Pin")) {
                        encryptionData.setPost_id(this.feedatalist.get(this.item_pos).getId());
                        encryptionData.setPost_pin("1");
                        json = new Gson().toJson(encryptionData);
                    }
                    break;
                case 2368439:
                    if (type.equals("Like")) {
                        encryptionData.setMy_like(Intrinsics.areEqual(this.feedatalist.get(this.item_pos).getMy_like(), "1") ? "0" : "1");
                        encryptionData.setPost_id(this.feedatalist.get(this.item_pos).getId());
                        json = new Gson().toJson(encryptionData);
                    }
                    break;
                case 81887292:
                    if (type.equals("Unpin")) {
                        encryptionData.setPost_id(this.feedatalist.get(this.item_pos).getId());
                        encryptionData.setPost_pin("0");
                        json = new Gson().toJson(encryptionData);
                    }
                    break;
                case 557130398:
                    if (type.equals("AddComment")) {
                        encryptionData.setId("");
                        encryptionData.setParent_id("0");
                        encryptionData.setPost_id(this.feedatalist.get(this.item_pos).getId());
                        encryptionData.setComment(this.comment_txt);
                        json = new Gson().toJson(encryptionData);
                    }
                    break;
            }
            String strEncrypt = AES.encrypt(json);
            if (this.fragment != null) {
                Fragment fragment = getFragment();
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                ((FeedsFragment) fragment).getFeedViewModel().getType().setValue(type);
                Fragment fragment2 = getFragment();
                Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                ((FeedsFragment) fragment2).getFeedViewModel().getAdapter_bodydata().setValue(strEncrypt);
                return;
            }
            Context context = this.context;
            if (context instanceof FeedsActivity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                ((FeedsActivity) context).getFeedViewModel().getType().setValue(type);
                Context context2 = this.context;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                ((FeedsActivity) context2).getFeedViewModel().getAdapter_bodydata().setValue(strEncrypt);
                return;
            }
            if (context instanceof PinnedPostActivity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                ((PinnedPostActivity) context).getFeedViewModel().getType().setValue(type);
                Context context3 = this.context;
                Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                ((PinnedPostActivity) context3).getFeedViewModel().getAdapter_bodydata().setValue(strEncrypt);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void open_comment_layout(final Context context, final int position) {
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
            View viewFindViewById2 = bottomSheetDialog.findViewById(R.id.no_data_found_RL);
            Intrinsics.checkNotNull(viewFindViewById2);
            setNo_data_found_RL((RelativeLayout) viewFindViewById2);
            BottomSheetBehavior.from(frameLayout).setState(3);
            BottomSheetBehavior.from(frameLayout).setDraggable(false);
            this.comment_recyerler = (RecyclerView) bottomSheetDialog.findViewById(R.id.comment_recyerler);
            final EditText editText = (EditText) bottomSheetDialog.findViewById(R.id.et_message);
            ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.iv_send);
            this.commentAdapter = new CommentAdapter(context, this.commentlist);
            if (this.commentlist.size() > 0) {
                getNo_data_found_RL().setVisibility(8);
            } else {
                getNo_data_found_RL().setVisibility(0);
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
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.open_comment_layout$lambda$2(this.f$0, editText, position, context, view);
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
    public static final void open_comment_layout$lambda$2(FeedAdapter feedAdapter, EditText editText, int i, Context context, View view) {
        Intrinsics.checkNotNull(editText);
        String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        feedAdapter.comment_txt = string;
        if (string.length() > 0 && !TextUtils.isEmpty(feedAdapter.comment_txt)) {
            feedAdapter.item_pos = i;
            editText.getText().clear();
            feedAdapter.createBodyData("AddComment");
            return;
        }
        Toast.makeText(context, "Comment Should not be blank", 0).show();
    }

    public final void makeLinks(TextView textView, String link) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(link, "link");
        SpannableString spannableString = new SpannableString(textView.getText());
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) textView.getText().toString(), link, 0, false, 6, (Object) null);
        spannableString.setSpan(new StyleSpan(1), 0, link.length() + iIndexOf$default, 33);
        spannableString.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.link_color)), iIndexOf$default, link.length() + iIndexOf$default, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.feedatalist.get(position).getPost_type().equals("1089")) {
            return 1089;
        }
        if (this.feedatalist.get(position).getPost_type().equals("1090")) {
            return VideoDownloadService.ONTASK;
        }
        if (this.feedatalist.get(position).getPost_type().equals("1091")) {
            return 1091;
        }
        if (this.feedatalist.get(position).getPost_type().equals("1092")) {
            return 1092;
        }
        if (this.feedatalist.get(position).getPost_type().equals("1093")) {
            return 1093;
        }
        if (this.feedatalist.get(position).getPost_type().equals("1")) {
            return 1;
        }
        if (this.feedatalist.get(position).getPost_type().equals("2")) {
            return 2;
        }
        if (this.feedatalist.get(position).getPost_type().equals("3")) {
            return 3;
        }
        if (this.feedatalist.get(position).getPost_type().equals("4")) {
            return 4;
        }
        if (this.feedatalist.get(position).getPost_type().equals("5")) {
            return 5;
        }
        if (this.feedatalist.get(position).getPost_type().equals("6")) {
            return 6;
        }
        if (this.feedatalist.get(position).getPost_type().equals("8")) {
            return 8;
        }
        return this.feedatalist.get(position).getPost_type().equals("7") ? 7 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.feedatalist.size();
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$NewCourseVm;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "newCourseVmBinding", "Lcom/appnew/android/databinding/NewCourseVmBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/NewCourseVmBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NewCourseVm extends RecyclerView.ViewHolder {
        private final NewCourseVmBinding newCourseVmBinding;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewCourseVm(FeedAdapter feedAdapter, NewCourseVmBinding newCourseVmBinding) {
            super(newCourseVmBinding.getRoot());
            Intrinsics.checkNotNullParameter(newCourseVmBinding, "newCourseVmBinding");
            this.this$0 = feedAdapter;
            this.newCourseVmBinding = newCourseVmBinding;
        }

        public final void bind(com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.newCourseVmBinding.setCoursedata(data);
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$Banner_Vm;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bannerViewBinding", "Lcom/appnew/android/databinding/BannerViewBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/BannerViewBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Banner_Vm extends RecyclerView.ViewHolder {
        private final BannerViewBinding bannerViewBinding;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Banner_Vm(FeedAdapter feedAdapter, BannerViewBinding bannerViewBinding) {
            super(bannerViewBinding.getRoot());
            Intrinsics.checkNotNullParameter(bannerViewBinding, "bannerViewBinding");
            this.this$0 = feedAdapter;
            this.bannerViewBinding = bannerViewBinding;
        }

        public final void bind(final com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.bannerViewBinding.setBannerdata(data);
            try {
                List<BannerData> bannerlist = data.getBannerlist();
                Intrinsics.checkNotNull(bannerlist);
                if (bannerlist.size() > 1) {
                    if (this.this$0.getTimer() != null) {
                        Timer timer = this.this$0.getTimer();
                        Intrinsics.checkNotNull(timer);
                        timer.cancel();
                        Timer timer2 = this.this$0.getTimer();
                        Intrinsics.checkNotNull(timer2);
                        timer2.purge();
                        this.this$0.setCurrentPage(0);
                    }
                    final Handler handler = new Handler();
                    final FeedAdapter feedAdapter = this.this$0;
                    final Runnable runnable = new Runnable() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$Banner_Vm$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            FeedAdapter.Banner_Vm.bind$lambda$0(feedAdapter, data, this);
                        }
                    };
                    this.this$0.setTimer(new Timer());
                    Timer timer3 = this.this$0.getTimer();
                    Intrinsics.checkNotNull(timer3);
                    timer3.schedule(new TimerTask() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$Banner_Vm$bind$1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            handler.post(runnable);
                        }
                    }, this.this$0.getDELAY_MS(), this.this$0.getPERIOD_MS());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(FeedAdapter feedAdapter, com.appnew.android.feeds.dataclass.Data data, Banner_Vm banner_Vm) {
            int currentPage = feedAdapter.getCurrentPage();
            List<BannerData> bannerlist = data.getBannerlist();
            Intrinsics.checkNotNull(bannerlist);
            if (currentPage == bannerlist.size()) {
                feedAdapter.setCurrentPage(0);
            }
            ViewPager viewPager = banner_Vm.bannerViewBinding.viewPager;
            int currentPage2 = feedAdapter.getCurrentPage();
            feedAdapter.setCurrentPage(currentPage2 + 1);
            viewPager.setCurrentItem(currentPage2, true);
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$NewTestResultVm;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "newlivetestresult", "Lcom/appnew/android/databinding/NewTestresultVmBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/NewTestresultVmBinding;)V", Bind.ELEMENT, "", "testResult", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NewTestResultVm extends RecyclerView.ViewHolder {
        private final NewTestresultVmBinding newlivetestresult;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewTestResultVm(FeedAdapter feedAdapter, NewTestresultVmBinding newlivetestresult) {
            super(newlivetestresult.getRoot());
            Intrinsics.checkNotNullParameter(newlivetestresult, "newlivetestresult");
            this.this$0 = feedAdapter;
            this.newlivetestresult = newlivetestresult;
        }

        public final void bind(com.appnew.android.feeds.dataclass.Data testResult) {
            Intrinsics.checkNotNullParameter(testResult, "testResult");
            this.newlivetestresult.setLivetestresult(testResult);
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$NewLiveTestVm;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveTestVmBinding", "Lcom/appnew/android/databinding/LiveTestVmBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/LiveTestVmBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NewLiveTestVm extends RecyclerView.ViewHolder {
        private LiveTestVmBinding liveTestVmBinding;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewLiveTestVm(FeedAdapter feedAdapter, LiveTestVmBinding liveTestVmBinding) {
            super(liveTestVmBinding.getRoot());
            Intrinsics.checkNotNullParameter(liveTestVmBinding, "liveTestVmBinding");
            this.this$0 = feedAdapter;
            this.liveTestVmBinding = liveTestVmBinding;
        }

        public final void bind(com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            LiveTestVmBinding liveTestVmBinding = this.liveTestVmBinding;
            FeedAdapter feedAdapter = this.this$0;
            liveTestVmBinding.setLivetest(data);
            liveTestVmBinding.setFeedadapter(feedAdapter);
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$NewLiveclassVm;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveClassVmBinding", "Lcom/appnew/android/databinding/LiveClassVmBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/LiveClassVmBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NewLiveclassVm extends RecyclerView.ViewHolder {
        private final LiveClassVmBinding liveClassVmBinding;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NewLiveclassVm(FeedAdapter feedAdapter, LiveClassVmBinding liveClassVmBinding) {
            super(liveClassVmBinding.getRoot());
            Intrinsics.checkNotNullParameter(liveClassVmBinding, "liveClassVmBinding");
            this.this$0 = feedAdapter;
            this.liveClassVmBinding = liveClassVmBinding;
        }

        public final void bind(com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            LiveClassVmBinding liveClassVmBinding = this.liveClassVmBinding;
            FeedAdapter feedAdapter = this.this$0;
            liveClassVmBinding.setLiveclass(data);
            liveClassVmBinding.setFeedadapter(feedAdapter);
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$ArticleVm;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "articleVm", "Lcom/appnew/android/databinding/ArticleVmBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/ArticleVmBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ArticleVm extends RecyclerView.ViewHolder {
        private final ArticleVmBinding articleVm;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArticleVm(FeedAdapter feedAdapter, ArticleVmBinding articleVm) {
            super(articleVm.getRoot());
            Intrinsics.checkNotNullParameter(articleVm, "articleVm");
            this.this$0 = feedAdapter;
            this.articleVm = articleVm;
        }

        public final void bind(final com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.articleVm.setArticlebind(data);
            if (StringsKt.equals(BuildConfig.FLAVOR, "DishaPublication", true)) {
                ImageView imageView = this.articleVm.shareImage;
                if (imageView != null) {
                    imageView.setImageDrawable(this.this$0.getContext().getDrawable(R.drawable.share_gray));
                }
                ImageView imageView2 = this.articleVm.shareImage;
                if (imageView2 != null) {
                    imageView2.setPadding(10, 10, 10, 10);
                }
            }
            if (data.getText().length() == 0) {
                this.articleVm.articleTxtTop.setVisibility(8);
            } else {
                this.articleVm.articleTxtTop.setVisibility(0);
                this.articleVm.articleTxtTop.setText(data.getText());
            }
            this.this$0.setTextView(this.articleVm.articleTxt);
            final Spanned spannedFromHtml = Html.fromHtml(data.getMeta_url(), 0, this.this$0, null);
            if (spannedFromHtml.length() > 200) {
                this.articleVm.readMore.setVisibility(0);
                if (data.getExpanded()) {
                    TextView textView = this.articleVm.articleTxt;
                    Intrinsics.checkNotNull(spannedFromHtml);
                    textView.setText(StringsKt.trim(spannedFromHtml));
                    this.articleVm.readMore.setText("Read Less");
                } else {
                    TextView textView2 = this.articleVm.articleTxt;
                    Intrinsics.checkNotNull(spannedFromHtml);
                    textView2.setText(spannedFromHtml.subSequence(0, 200).toString() + "...");
                    this.articleVm.readMore.setText("Read More");
                }
            } else {
                TextView textView3 = this.articleVm.articleTxt;
                Intrinsics.checkNotNull(spannedFromHtml);
                textView3.setText(StringsKt.trim(spannedFromHtml));
                this.articleVm.readMore.setVisibility(8);
            }
            this.articleVm.articleTxt.setMovementMethod(LinkMovementMethod.getInstance());
            FeedAdapter feedAdapter = this.this$0;
            LinearLayout whatsappShare = this.articleVm.whatsappShare;
            Intrinsics.checkNotNullExpressionValue(whatsappShare, "whatsappShare");
            feedAdapter.DisableShareIcon(whatsappShare);
            if (!Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.articleVm.postComment.setVisibility(4);
                this.articleVm.postCommentCount.setVisibility(4);
                this.articleVm.viewComment.setVisibility(4);
            }
            if (Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.articleVm.postComment.setVisibility(0);
                this.articleVm.postCommentCount.setVisibility(0);
                this.articleVm.viewComment.setVisibility(0);
            }
            TextView textView4 = this.articleVm.postComment;
            final FeedAdapter feedAdapter2 = this.this$0;
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ArticleVm$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.ArticleVm.bind$lambda$0(feedAdapter2, this, view);
                }
            });
            TextView textView5 = this.articleVm.like;
            final FeedAdapter feedAdapter3 = this.this$0;
            textView5.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ArticleVm$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.ArticleVm.bind$lambda$1(feedAdapter3, this);
                }
            }));
            ImageView imageView3 = this.articleVm.pinIV;
            final FeedAdapter feedAdapter4 = this.this$0;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ArticleVm$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.ArticleVm.bind$lambda$2(feedAdapter4, this, data, view);
                }
            });
            LinearLayout linearLayout = this.articleVm.whatsappShare;
            final FeedAdapter feedAdapter5 = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ArticleVm$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.ArticleVm.bind$lambda$3(feedAdapter5, this, view);
                }
            });
            TextView textView6 = this.articleVm.readMore;
            final FeedAdapter feedAdapter6 = this.this$0;
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ArticleVm$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.ArticleVm.bind$lambda$4(feedAdapter6, data, this, spannedFromHtml, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(FeedAdapter feedAdapter, ArticleVm articleVm, View view) {
            feedAdapter.onCommentClick(articleVm.getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$1(FeedAdapter feedAdapter, ArticleVm articleVm) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (!feedAdapter.getBooleanlike()) {
                    feedAdapter.setItem_pos(articleVm.getAdapterPosition());
                    feedAdapter.createBodyData("Like");
                }
            } else {
                Helper.showInternetToast(feedAdapter.getContext());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(FeedAdapter feedAdapter, ArticleVm articleVm, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                feedAdapter.setItem_pos(articleVm.getAdapterPosition());
                if (Intrinsics.areEqual(data.getMy_pinned(), "1")) {
                    articleVm.articleVm.pinIV.setImageResource(R.mipmap.unpinned);
                    feedAdapter.createBodyData("Unpin");
                    return;
                } else {
                    articleVm.articleVm.pinIV.setImageResource(R.mipmap.pinned);
                    feedAdapter.createBodyData("Pin");
                    return;
                }
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(FeedAdapter feedAdapter, ArticleVm articleVm, View view) {
            feedAdapter.setItem_pos(articleVm.getAdapterPosition());
            Context context = feedAdapter.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Helper.sharePost((Activity) context, feedAdapter.getFeedatalist().get(feedAdapter.getItem_pos()).getId(), "", "Article");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4(FeedAdapter feedAdapter, com.appnew.android.feeds.dataclass.Data data, ArticleVm articleVm, Spanned spanned, View view) {
            if (feedAdapter.fragment != null) {
                Fragment fragment = feedAdapter.getFragment();
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                ((FeedsFragment) fragment).openWebView(data.getMeta_url());
            } else {
                if (articleVm.articleVm.readMore.getText().equals("Read More")) {
                    TextView textView = articleVm.articleVm.articleTxt;
                    Intrinsics.checkNotNull(spanned);
                    textView.setText(StringsKt.trim(spanned));
                    data.setExpanded(true);
                    articleVm.articleVm.readMore.setText("Read Less");
                    return;
                }
                TextView textView2 = articleVm.articleVm.articleTxt;
                Intrinsics.checkNotNull(spanned);
                textView2.setText(spanned.subSequence(0, 200).toString() + "...");
                articleVm.articleVm.readMore.setText("Read More");
                data.setExpanded(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void DisableShareIcon(LinearLayout postComment) {
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.SHARE_CONTENT), "0", true)) {
            postComment.setVisibility(4);
        } else {
            postComment.setVisibility(0);
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$LinkVM;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "linkvm", "Lcom/appnew/android/databinding/LinkViewBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/LinkViewBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class LinkVM extends RecyclerView.ViewHolder {
        private final LinkViewBinding linkvm;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LinkVM(FeedAdapter feedAdapter, LinkViewBinding linkvm) {
            super(linkvm.getRoot());
            Intrinsics.checkNotNullParameter(linkvm, "linkvm");
            this.this$0 = feedAdapter;
            this.linkvm = linkvm;
        }

        public final void bind(final com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.linkvm.setLinkbind(data);
            if (StringsKt.equals(BuildConfig.FLAVOR, "DishaPublication", true)) {
                ImageView imageView = this.linkvm.shareImage;
                if (imageView != null) {
                    imageView.setImageDrawable(this.this$0.getContext().getDrawable(R.drawable.share_gray));
                }
                ImageView imageView2 = this.linkvm.shareImage;
                if (imageView2 != null) {
                    imageView2.setPadding(10, 10, 10, 10);
                }
            }
            if (data.getMeta_url().length() == 0) {
                this.linkvm.linkTxt.setEnabled(false);
                this.linkvm.linkTxt.setVisibility(4);
            } else if (this.this$0.getFeedatalist().get(getAdapterPosition()).getLink_type().equals("1") || this.this$0.getFeedatalist().get(getAdapterPosition()).getLink_type().equals("2")) {
                this.linkvm.linkTxt.setVisibility(8);
                this.linkvm.linkImage.setVisibility(8);
                this.linkvm.imageConstraintLayout.setVisibility(0);
            } else {
                this.linkvm.imageConstraintLayout.setVisibility(8);
                this.linkvm.linkImage.setVisibility(0);
                this.linkvm.linkTxt.setVisibility(0);
                this.linkvm.linkTxt.setText(data.getMeta_url());
                FeedAdapter feedAdapter = this.this$0;
                TextView linkTxt = this.linkvm.linkTxt;
                Intrinsics.checkNotNullExpressionValue(linkTxt, "linkTxt");
                feedAdapter.makeLinks(linkTxt, data.getMeta_url());
                this.linkvm.linkTxt.setEnabled(true);
            }
            TextView textView = this.linkvm.linkTxt;
            final FeedAdapter feedAdapter2 = this.this$0;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$LinkVM$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.LinkVM.bind$lambda$0(feedAdapter2, this, view);
                }
            });
            ImageView imageView3 = this.linkvm.playLink;
            final FeedAdapter feedAdapter3 = this.this$0;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$LinkVM$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.LinkVM.bind$lambda$1(feedAdapter3, this, view);
                }
            });
            LinearLayout linearLayout = this.linkvm.whatsappShare;
            final FeedAdapter feedAdapter4 = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$LinkVM$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.LinkVM.bind$lambda$2(feedAdapter4, this, view);
                }
            });
            TextView textView2 = this.linkvm.like;
            final FeedAdapter feedAdapter5 = this.this$0;
            textView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$LinkVM$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.LinkVM.bind$lambda$3(feedAdapter5, this);
                }
            }));
            ImageView imageView4 = this.linkvm.pinIV;
            final FeedAdapter feedAdapter6 = this.this$0;
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$LinkVM$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.LinkVM.bind$lambda$4(feedAdapter6, this, data, view);
                }
            });
            FeedAdapter feedAdapter7 = this.this$0;
            LinearLayout whatsappShare = this.linkvm.whatsappShare;
            Intrinsics.checkNotNullExpressionValue(whatsappShare, "whatsappShare");
            feedAdapter7.DisableShareIcon(whatsappShare);
            if (!Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.linkvm.postComment.setVisibility(4);
                this.linkvm.postCommentCount.setVisibility(4);
                this.linkvm.viewComment.setVisibility(4);
            }
            if (Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.linkvm.postComment.setVisibility(0);
                this.linkvm.postCommentCount.setVisibility(0);
                this.linkvm.viewComment.setVisibility(0);
            }
            TextView textView3 = this.linkvm.postComment;
            final FeedAdapter feedAdapter8 = this.this$0;
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$LinkVM$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.LinkVM.bind$lambda$5(feedAdapter8, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(FeedAdapter feedAdapter, LinkVM linkVM, View view) {
            if (feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getMeta_url().length() > 0) {
                if (feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getLink_type().equals("1") || feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getLink_type().equals("2")) {
                    Intent intent = new Intent(feedAdapter.getContext(), (Class<?>) FeedVideoPlayer.class);
                    intent.putExtra("url", feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getMeta_url());
                    intent.putExtra("des", feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getDescription());
                    intent.putExtra("view_type", "1");
                    intent.putExtra("isYoutube", feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getLink_type());
                    Context context = feedAdapter.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    Helper.gotoActivity(intent, (Activity) context);
                    return;
                }
                if (Helper.isValidUrl(feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getMeta_url())) {
                    com.appnew.android.feeds.dataclass.Data data = feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition());
                    Intrinsics.checkNotNullExpressionValue(data, "get(...)");
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(data.getMeta_url()));
                    Context context2 = feedAdapter.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                    Helper.gotoActivity(intent2, (Activity) context2);
                    return;
                }
                Context context3 = feedAdapter.getContext();
                Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type android.app.Activity");
                Toast.makeText((Activity) context3, "Invalid Url", 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(FeedAdapter feedAdapter, LinkVM linkVM, View view) {
            if (feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getMeta_url().length() > 0) {
                if (feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getLink_type().equals("1") || feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getLink_type().equals("2")) {
                    Intent intent = new Intent(feedAdapter.getContext(), (Class<?>) FeedVideoPlayer.class);
                    intent.putExtra("url", feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getMeta_url());
                    intent.putExtra("des", feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getDescription());
                    intent.putExtra("view_type", "1");
                    intent.putExtra("isYoutube", feedAdapter.getFeedatalist().get(linkVM.getAdapterPosition()).getLink_type());
                    Context context = feedAdapter.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    Helper.gotoActivity(intent, (Activity) context);
                    return;
                }
                return;
            }
            Toast.makeText(feedAdapter.getContext(), "No Youtube URL Found", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(FeedAdapter feedAdapter, LinkVM linkVM, View view) {
            feedAdapter.setItem_pos(linkVM.getAdapterPosition());
            Context context = feedAdapter.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Helper.sharePost((Activity) context, feedAdapter.getFeedatalist().get(feedAdapter.getItem_pos()).getId(), "", HttpHeaders.LINK);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$3(FeedAdapter feedAdapter, LinkVM linkVM) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (!feedAdapter.getBooleanlike()) {
                    feedAdapter.setItem_pos(linkVM.getAdapterPosition());
                    feedAdapter.createBodyData("Like");
                }
            } else {
                Helper.showInternetToast(feedAdapter.getContext());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4(FeedAdapter feedAdapter, LinkVM linkVM, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                feedAdapter.setItem_pos(linkVM.getAdapterPosition());
                if (Intrinsics.areEqual(data.getMy_pinned(), "1")) {
                    linkVM.linkvm.pinIV.setImageResource(R.mipmap.unpinned);
                    feedAdapter.createBodyData("Unpin");
                    return;
                } else {
                    linkVM.linkvm.pinIV.setImageResource(R.mipmap.pinned);
                    feedAdapter.createBodyData("Pin");
                    return;
                }
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$5(FeedAdapter feedAdapter, LinkVM linkVM, View view) {
            feedAdapter.onCommentClick(linkVM.getAdapterPosition());
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$ImageVm;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "imageVm", "Lcom/appnew/android/databinding/PostImageBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/PostImageBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ImageVm extends RecyclerView.ViewHolder {
        private final PostImageBinding imageVm;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageVm(FeedAdapter feedAdapter, PostImageBinding imageVm) {
            super(imageVm.getRoot());
            Intrinsics.checkNotNullParameter(imageVm, "imageVm");
            this.this$0 = feedAdapter;
            this.imageVm = imageVm;
        }

        public final void bind(final com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.imageVm.setImagebind(data);
            if (StringsKt.equals(BuildConfig.FLAVOR, "DishaPublication", true)) {
                ImageView imageView = this.imageVm.shareImage;
                if (imageView != null) {
                    imageView.setImageDrawable(this.this$0.getContext().getDrawable(R.drawable.share_gray));
                }
                ImageView imageView2 = this.imageVm.shareImage;
                if (imageView2 != null) {
                    imageView2.setPadding(10, 10, 10, 10);
                }
            }
            if (data.getDescription().length() == 0) {
                this.imageVm.imageText.setVisibility(8);
                this.imageVm.readMore.setVisibility(8);
            } else {
                this.imageVm.imageText.setVisibility(0);
                this.this$0.setTextView(this.imageVm.imageText);
                final Spanned spannedFromHtml = Html.fromHtml(data.getDescription(), 0, this.this$0, null);
                this.imageVm.imageText.setMovementMethod(LinkMovementMethod.getInstance());
                if (spannedFromHtml.length() > 200) {
                    this.imageVm.readMore.setVisibility(0);
                    if (data.getExpanded()) {
                        TextView textView = this.imageVm.imageText;
                        Intrinsics.checkNotNull(spannedFromHtml);
                        textView.setText(StringsKt.trim(spannedFromHtml));
                        this.imageVm.readMore.setText("Read Less");
                    } else {
                        TextView textView2 = this.imageVm.imageText;
                        Intrinsics.checkNotNull(spannedFromHtml);
                        textView2.setText(spannedFromHtml.subSequence(0, 200).toString() + "...");
                        this.imageVm.readMore.setText("Read More");
                    }
                } else {
                    TextView textView3 = this.imageVm.imageText;
                    Intrinsics.checkNotNull(spannedFromHtml);
                    textView3.setText(StringsKt.trim(spannedFromHtml));
                    this.imageVm.readMore.setVisibility(8);
                }
                this.imageVm.readMore.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ImageVm$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedAdapter.ImageVm.bind$lambda$0(this.f$0, spannedFromHtml, data, view);
                    }
                });
            }
            LinearLayout linearLayout = this.imageVm.whatsappShare;
            final FeedAdapter feedAdapter = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ImageVm$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.ImageVm.bind$lambda$1(feedAdapter, this, view);
                }
            });
            TextView textView4 = this.imageVm.like;
            final FeedAdapter feedAdapter2 = this.this$0;
            textView4.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ImageVm$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.ImageVm.bind$lambda$2(feedAdapter2, this);
                }
            }));
            ImageView imageView3 = this.imageVm.pinIV;
            final FeedAdapter feedAdapter3 = this.this$0;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ImageVm$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.ImageVm.bind$lambda$3(feedAdapter3, this, data, view);
                }
            });
            FeedAdapter feedAdapter4 = this.this$0;
            LinearLayout whatsappShare = this.imageVm.whatsappShare;
            Intrinsics.checkNotNullExpressionValue(whatsappShare, "whatsappShare");
            feedAdapter4.DisableShareIcon(whatsappShare);
            if (!Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.imageVm.postComment.setVisibility(4);
                this.imageVm.postCommentCount.setVisibility(4);
                this.imageVm.viewComment.setVisibility(4);
            }
            if (Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.imageVm.postComment.setVisibility(0);
                this.imageVm.postCommentCount.setVisibility(0);
                this.imageVm.viewComment.setVisibility(0);
            }
            TextView textView5 = this.imageVm.postComment;
            final FeedAdapter feedAdapter5 = this.this$0;
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$ImageVm$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.ImageVm.bind$lambda$4(feedAdapter5, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(ImageVm imageVm, Spanned spanned, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (imageVm.imageVm.readMore.getText().equals("Read More")) {
                TextView textView = imageVm.imageVm.imageText;
                Intrinsics.checkNotNull(spanned);
                textView.setText(StringsKt.trim(spanned));
                imageVm.imageVm.readMore.setText("Read Less");
                data.setExpanded(true);
                return;
            }
            TextView textView2 = imageVm.imageVm.imageText;
            Intrinsics.checkNotNull(spanned);
            textView2.setText(spanned.subSequence(0, 180).toString() + "...");
            imageVm.imageVm.readMore.setText("Read More");
            data.setExpanded(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(FeedAdapter feedAdapter, ImageVm imageVm, View view) {
            feedAdapter.setItem_pos(imageVm.getAdapterPosition());
            Context context = feedAdapter.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Helper.sharePost((Activity) context, feedAdapter.getFeedatalist().get(feedAdapter.getItem_pos()).getId(), "", "Image");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$2(FeedAdapter feedAdapter, ImageVm imageVm) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (!feedAdapter.getBooleanlike()) {
                    feedAdapter.setItem_pos(imageVm.getAdapterPosition());
                    feedAdapter.createBodyData("Like");
                }
            } else {
                Helper.showInternetToast(feedAdapter.getContext());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(FeedAdapter feedAdapter, ImageVm imageVm, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                feedAdapter.setItem_pos(imageVm.getAdapterPosition());
                if (Intrinsics.areEqual(data.getMy_pinned(), "1")) {
                    imageVm.imageVm.pinIV.setImageResource(R.mipmap.unpinned);
                    feedAdapter.createBodyData("Unpin");
                    return;
                } else {
                    imageVm.imageVm.pinIV.setImageResource(R.mipmap.pinned);
                    feedAdapter.createBodyData("Pin");
                    return;
                }
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4(FeedAdapter feedAdapter, ImageVm imageVm, View view) {
            feedAdapter.onCommentClick(imageVm.getAdapterPosition());
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$VideoVm;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "videoVm", "Lcom/appnew/android/databinding/VideoPostBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/VideoPostBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class VideoVm extends RecyclerView.ViewHolder {
        final /* synthetic */ FeedAdapter this$0;
        private final VideoPostBinding videoVm;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoVm(FeedAdapter feedAdapter, VideoPostBinding videoVm) {
            super(videoVm.getRoot());
            Intrinsics.checkNotNullParameter(videoVm, "videoVm");
            this.this$0 = feedAdapter;
            this.videoVm = videoVm;
        }

        public final void bind(final com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.videoVm.setVideopostbind(data);
            if (StringsKt.equals(BuildConfig.FLAVOR, "DishaPublication", true)) {
                ImageView imageView = this.videoVm.shareImage;
                if (imageView != null) {
                    imageView.setImageDrawable(this.this$0.getContext().getDrawable(R.drawable.share_gray));
                }
                ImageView imageView2 = this.videoVm.shareImage;
                if (imageView2 != null) {
                    imageView2.setPadding(10, 10, 10, 10);
                }
            }
            if (data.getDescription().length() == 0) {
                this.videoVm.videoText.setVisibility(8);
            } else {
                this.videoVm.videoText.setVisibility(0);
                this.videoVm.videoText.setText(data.getDescription());
                this.this$0.setTextView(this.videoVm.videoText);
                final Spanned spannedFromHtml = Html.fromHtml(data.getDescription(), 0, this.this$0, null);
                if (spannedFromHtml.length() > 200) {
                    this.videoVm.readMore.setVisibility(0);
                    if (data.getExpanded()) {
                        TextView textView = this.videoVm.videoText;
                        Intrinsics.checkNotNull(spannedFromHtml);
                        textView.setText(StringsKt.trim(spannedFromHtml));
                        this.videoVm.readMore.setText("Read Less");
                    } else {
                        TextView textView2 = this.videoVm.videoText;
                        Intrinsics.checkNotNull(spannedFromHtml);
                        textView2.setText(spannedFromHtml.subSequence(0, 200).toString() + "...");
                        this.videoVm.readMore.setText("Read More");
                    }
                } else {
                    TextView textView3 = this.videoVm.videoText;
                    Intrinsics.checkNotNull(spannedFromHtml);
                    textView3.setText(StringsKt.trim(spannedFromHtml));
                    this.videoVm.readMore.setVisibility(8);
                }
                this.videoVm.videoText.setMovementMethod(LinkMovementMethod.getInstance());
                this.videoVm.readMore.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$VideoVm$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedAdapter.VideoVm.bind$lambda$0(this.f$0, spannedFromHtml, data, view);
                    }
                });
            }
            LinearLayout linearLayout = this.videoVm.whatsappShare;
            final FeedAdapter feedAdapter = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$VideoVm$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.VideoVm.bind$lambda$1(feedAdapter, this, view);
                }
            });
            ImageView imageView3 = this.videoVm.playVideo;
            final FeedAdapter feedAdapter2 = this.this$0;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$VideoVm$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.VideoVm.bind$lambda$2(feedAdapter2, this, view);
                }
            });
            TextView textView4 = this.videoVm.like;
            final FeedAdapter feedAdapter3 = this.this$0;
            textView4.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$VideoVm$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.VideoVm.bind$lambda$3(feedAdapter3, this);
                }
            }));
            ImageView imageView4 = this.videoVm.pinIV;
            final FeedAdapter feedAdapter4 = this.this$0;
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$VideoVm$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.VideoVm.bind$lambda$4(feedAdapter4, this, data, view);
                }
            });
            FeedAdapter feedAdapter5 = this.this$0;
            LinearLayout whatsappShare = this.videoVm.whatsappShare;
            Intrinsics.checkNotNullExpressionValue(whatsappShare, "whatsappShare");
            feedAdapter5.DisableShareIcon(whatsappShare);
            if (!Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.videoVm.postComment.setVisibility(4);
                this.videoVm.postCommentCount.setVisibility(4);
                this.videoVm.viewComment.setVisibility(4);
            }
            if (Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.videoVm.postComment.setVisibility(0);
                this.videoVm.postCommentCount.setVisibility(0);
                this.videoVm.viewComment.setVisibility(0);
            }
            TextView textView5 = this.videoVm.postComment;
            final FeedAdapter feedAdapter6 = this.this$0;
            textView5.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$VideoVm$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.VideoVm.bind$lambda$5(feedAdapter6, this);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(VideoVm videoVm, Spanned spanned, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (videoVm.videoVm.readMore.getText().equals("Read More")) {
                TextView textView = videoVm.videoVm.videoText;
                Intrinsics.checkNotNull(spanned);
                textView.setText(StringsKt.trim(spanned));
                data.setExpanded(true);
                videoVm.videoVm.readMore.setText("Read Less");
                return;
            }
            TextView textView2 = videoVm.videoVm.videoText;
            Intrinsics.checkNotNull(spanned);
            textView2.setText(spanned.subSequence(0, 200).toString() + "...");
            videoVm.videoVm.readMore.setText("Read More");
            data.setExpanded(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(FeedAdapter feedAdapter, VideoVm videoVm, View view) {
            feedAdapter.setItem_pos(videoVm.getAdapterPosition());
            Context context = feedAdapter.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Helper.sharePost((Activity) context, feedAdapter.getFeedatalist().get(feedAdapter.getItem_pos()).getId(), "", "VideoPost");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(FeedAdapter feedAdapter, VideoVm videoVm, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (feedAdapter.getFeedatalist().get(videoVm.getAdapterPosition()).getMeta_url().length() > 0) {
                    Intent intent = new Intent(feedAdapter.getContext(), (Class<?>) FeedVideoPlayer.class);
                    intent.putExtra("url", feedAdapter.getFeedatalist().get(videoVm.getAdapterPosition()).getMeta_url());
                    intent.putExtra("des", feedAdapter.getFeedatalist().get(videoVm.getAdapterPosition()).getDescription());
                    intent.putExtra("view_type", feedAdapter.getFeedatalist().get(videoVm.getAdapterPosition()).getJson().getView_type());
                    intent.putExtra("isYoutube", "0");
                    Context context = feedAdapter.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    Helper.gotoActivity(intent, (Activity) context);
                    return;
                }
                Toast.makeText(feedAdapter.getContext(), "No Video Found", 0).show();
                return;
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$3(FeedAdapter feedAdapter, VideoVm videoVm) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (!feedAdapter.getBooleanlike()) {
                    feedAdapter.setItem_pos(videoVm.getAdapterPosition());
                    feedAdapter.createBodyData("Like");
                }
            } else {
                Helper.showInternetToast(feedAdapter.getContext());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4(FeedAdapter feedAdapter, VideoVm videoVm, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                feedAdapter.setItem_pos(videoVm.getAdapterPosition());
                if (Intrinsics.areEqual(data.getMy_pinned(), "1")) {
                    videoVm.videoVm.pinIV.setImageResource(R.mipmap.unpinned);
                    feedAdapter.createBodyData("Unpin");
                    return;
                } else {
                    videoVm.videoVm.pinIV.setImageResource(R.mipmap.pinned);
                    feedAdapter.createBodyData("Pin");
                    return;
                }
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$5(FeedAdapter feedAdapter, VideoVm videoVm) {
            feedAdapter.onCommentClick(videoVm.getAdapterPosition());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$AudioVM;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "audioVM", "Lcom/appnew/android/databinding/AudioPostBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/AudioPostBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AudioVM extends RecyclerView.ViewHolder {
        private final AudioPostBinding audioVM;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioVM(FeedAdapter feedAdapter, AudioPostBinding audioVM) {
            super(audioVM.getRoot());
            Intrinsics.checkNotNullParameter(audioVM, "audioVM");
            this.this$0 = feedAdapter;
            this.audioVM = audioVM;
        }

        public final void bind(final com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.audioVM.setAudiobind(data);
            if (StringsKt.equals(BuildConfig.FLAVOR, "DishaPublication", true)) {
                ImageView imageView = this.audioVM.shareImage;
                if (imageView != null) {
                    imageView.setImageDrawable(this.this$0.getContext().getDrawable(R.drawable.share_gray));
                }
                ImageView imageView2 = this.audioVM.shareImage;
                if (imageView2 != null) {
                    imageView2.setPadding(10, 10, 10, 10);
                }
            }
            if (data.getText().length() == 0) {
                this.audioVM.audioText.setVisibility(8);
            } else {
                this.audioVM.audioText.setVisibility(0);
                this.this$0.setTextView(this.audioVM.audioText);
                final Spanned spannedFromHtml = Html.fromHtml(data.getDescription(), 0, this.this$0, null);
                if (spannedFromHtml.length() > 200) {
                    if (data.getExpanded()) {
                        TextView textView = this.audioVM.audioText;
                        Intrinsics.checkNotNull(spannedFromHtml);
                        textView.setText(StringsKt.trim(spannedFromHtml));
                        this.audioVM.readMore.setText("Read Less");
                    } else {
                        TextView textView2 = this.audioVM.audioText;
                        Intrinsics.checkNotNull(spannedFromHtml);
                        textView2.setText(spannedFromHtml.subSequence(0, 200).toString() + "...");
                        this.audioVM.readMore.setText("Read More");
                    }
                    this.audioVM.readMore.setVisibility(0);
                } else {
                    TextView textView3 = this.audioVM.audioText;
                    Intrinsics.checkNotNull(spannedFromHtml);
                    textView3.setText(StringsKt.trim(spannedFromHtml));
                    this.audioVM.readMore.setVisibility(8);
                }
                this.audioVM.audioText.setMovementMethod(LinkMovementMethod.getInstance());
                this.audioVM.readMore.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$AudioVM$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedAdapter.AudioVM.bind$lambda$0(this.f$0, spannedFromHtml, data, view);
                    }
                });
            }
            LinearLayout linearLayout = this.audioVM.whatsappShare;
            final FeedAdapter feedAdapter = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$AudioVM$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.AudioVM.bind$lambda$1(feedAdapter, this, view);
                }
            });
            RelativeLayout relativeLayout = this.audioVM.auidoLayout;
            final FeedAdapter feedAdapter2 = this.this$0;
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$AudioVM$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.AudioVM.bind$lambda$2(feedAdapter2, this, view);
                }
            });
            ImageView imageView3 = this.audioVM.pinIV;
            final FeedAdapter feedAdapter3 = this.this$0;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$AudioVM$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.AudioVM.bind$lambda$3(feedAdapter3, this, data, view);
                }
            });
            TextView textView4 = this.audioVM.like;
            final FeedAdapter feedAdapter4 = this.this$0;
            textView4.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$AudioVM$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.AudioVM.bind$lambda$4(feedAdapter4, this);
                }
            }));
            FeedAdapter feedAdapter5 = this.this$0;
            LinearLayout whatsappShare = this.audioVM.whatsappShare;
            Intrinsics.checkNotNullExpressionValue(whatsappShare, "whatsappShare");
            feedAdapter5.DisableShareIcon(whatsappShare);
            if (!Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.audioVM.postComment.setVisibility(4);
                this.audioVM.postCommentCount.setVisibility(4);
                this.audioVM.viewComment.setVisibility(4);
            }
            if (Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.audioVM.postComment.setVisibility(0);
                this.audioVM.postCommentCount.setVisibility(0);
                this.audioVM.viewComment.setVisibility(0);
            }
            TextView textView5 = this.audioVM.postComment;
            final FeedAdapter feedAdapter6 = this.this$0;
            textView5.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$AudioVM$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.AudioVM.bind$lambda$5(feedAdapter6, this);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(AudioVM audioVM, Spanned spanned, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (audioVM.audioVM.readMore.getText().equals("Read More")) {
                TextView textView = audioVM.audioVM.audioText;
                Intrinsics.checkNotNull(spanned);
                textView.setText(StringsKt.trim(spanned));
                data.setExpanded(true);
                audioVM.audioVM.readMore.setText("Read Less");
                return;
            }
            TextView textView2 = audioVM.audioVM.audioText;
            Intrinsics.checkNotNull(spanned);
            textView2.setText(spanned.subSequence(0, 200).toString() + "...");
            audioVM.audioVM.readMore.setText("Read More");
            data.setExpanded(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(FeedAdapter feedAdapter, AudioVM audioVM, View view) {
            feedAdapter.setItem_pos(audioVM.getAdapterPosition());
            Context context = feedAdapter.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Helper.sharePost((Activity) context, feedAdapter.getFeedatalist().get(feedAdapter.getItem_pos()).getId(), "", "AudioPost");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(FeedAdapter feedAdapter, AudioVM audioVM, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (feedAdapter.getFeedatalist().get(audioVM.getAdapterPosition()).getMeta_url().length() > 0) {
                    Intent intent = new Intent(feedAdapter.getContext(), (Class<?>) FeedVideoPlayer.class);
                    intent.putExtra("url", feedAdapter.getFeedatalist().get(audioVM.getAdapterPosition()).getMeta_url());
                    intent.putExtra("des", feedAdapter.getFeedatalist().get(audioVM.getAdapterPosition()).getDescription());
                    intent.putExtra("view_type", feedAdapter.getFeedatalist().get(audioVM.getAdapterPosition()).getJson().getView_type());
                    intent.putExtra("isYoutube", "0");
                    Context context = feedAdapter.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    Helper.gotoActivity(intent, (Activity) context);
                    return;
                }
                Toast.makeText(feedAdapter.getContext(), "No Audio Found", 0).show();
                return;
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(FeedAdapter feedAdapter, AudioVM audioVM, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                feedAdapter.setItem_pos(audioVM.getAdapterPosition());
                if (Intrinsics.areEqual(data.getMy_pinned(), "1")) {
                    audioVM.audioVM.pinIV.setImageResource(R.mipmap.unpinned);
                    feedAdapter.createBodyData("Unpin");
                    return;
                } else {
                    audioVM.audioVM.pinIV.setImageResource(R.mipmap.pinned);
                    feedAdapter.createBodyData("Pin");
                    return;
                }
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$4(FeedAdapter feedAdapter, AudioVM audioVM) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (!feedAdapter.getBooleanlike()) {
                    feedAdapter.setItem_pos(audioVM.getAdapterPosition());
                    feedAdapter.createBodyData("Like");
                }
            } else {
                Helper.showInternetToast(feedAdapter.getContext());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$5(FeedAdapter feedAdapter, AudioVM audioVM) {
            feedAdapter.onCommentClick(audioVM.getAdapterPosition());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$QuestionVM;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "questionVM", "Lcom/appnew/android/databinding/QuestionViewBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/QuestionViewBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class QuestionVM extends RecyclerView.ViewHolder {
        private final QuestionViewBinding questionVM;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuestionVM(FeedAdapter feedAdapter, QuestionViewBinding questionVM) {
            super(questionVM.getRoot());
            Intrinsics.checkNotNullParameter(questionVM, "questionVM");
            this.this$0 = feedAdapter;
            this.questionVM = questionVM;
        }

        public final void bind(final com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.questionVM.setQuestionbind(data);
            LinearLayout linearLayout = this.questionVM.whatsappShare;
            final FeedAdapter feedAdapter = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuestionVM$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.QuestionVM.bind$lambda$0(feedAdapter, this, view);
                }
            });
            if (Intrinsics.areEqual(data.getPost_type(), "8")) {
                this.questionVM.recyerclerView.setVisibility(8);
                this.questionVM.recyerclerViewWebview.setVisibility(0);
                this.questionVM.setOptionwebadapter(new OptionWebAdapter(this.this$0.getContext(), data.getJson().getOptions(), this.this$0, getAdapterPosition(), data.getJson()));
            } else {
                RecyclerView recyerclerView = this.questionVM.recyerclerView;
                Intrinsics.checkNotNullExpressionValue(recyerclerView, "recyerclerView");
                recyerclerView.setVisibility(0);
                RecyclerView recyerclerViewWebview = this.questionVM.recyerclerViewWebview;
                Intrinsics.checkNotNullExpressionValue(recyerclerViewWebview, "recyerclerViewWebview");
                recyerclerViewWebview.setVisibility(8);
                this.questionVM.setOptionadapter(new OptionAdapter(this.this$0.getContext(), data.getJson().getOptions(), this.this$0, getAdapterPosition(), data.getJson()));
            }
            TextView textView = this.questionVM.like;
            final FeedAdapter feedAdapter2 = this.this$0;
            textView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuestionVM$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.QuestionVM.bind$lambda$1(feedAdapter2, this);
                }
            }));
            FeedAdapter feedAdapter3 = this.this$0;
            LinearLayout whatsappShare = this.questionVM.whatsappShare;
            Intrinsics.checkNotNullExpressionValue(whatsappShare, "whatsappShare");
            feedAdapter3.DisableShareIcon(whatsappShare);
            if (!Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.questionVM.postComment.setVisibility(4);
                this.questionVM.postCommentCount.setVisibility(4);
                this.questionVM.viewComment.setVisibility(4);
            }
            if (Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.questionVM.postComment.setVisibility(0);
                this.questionVM.postCommentCount.setVisibility(0);
                this.questionVM.viewComment.setVisibility(0);
            }
            TextView textView2 = this.questionVM.postComment;
            final FeedAdapter feedAdapter4 = this.this$0;
            textView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuestionVM$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.QuestionVM.bind$lambda$2(feedAdapter4, this);
                }
            }));
            ImageView imageView = this.questionVM.pinIV;
            final FeedAdapter feedAdapter5 = this.this$0;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuestionVM$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.QuestionVM.bind$lambda$3(feedAdapter5, this, data, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(FeedAdapter feedAdapter, QuestionVM questionVM, View view) {
            feedAdapter.setItem_pos(questionVM.getAdapterPosition());
            Context context = feedAdapter.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Helper.sharePost((Activity) context, feedAdapter.getFeedatalist().get(feedAdapter.getItem_pos()).getId(), "", "Post Qestion");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$1(FeedAdapter feedAdapter, QuestionVM questionVM) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (!feedAdapter.getBooleanlike()) {
                    feedAdapter.setItem_pos(questionVM.getAdapterPosition());
                    feedAdapter.createBodyData("Like");
                }
            } else {
                Helper.showInternetToast(feedAdapter.getContext());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$2(FeedAdapter feedAdapter, QuestionVM questionVM) {
            feedAdapter.onCommentClick(questionVM.getAdapterPosition());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(FeedAdapter feedAdapter, QuestionVM questionVM, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                feedAdapter.setItem_pos(questionVM.getAdapterPosition());
                if (Intrinsics.areEqual(data.getMy_pinned(), "1")) {
                    questionVM.questionVM.pinIV.setImageResource(R.mipmap.unpinned);
                    feedAdapter.createBodyData("Unpin");
                    return;
                } else {
                    questionVM.questionVM.pinIV.setImageResource(R.mipmap.pinned);
                    feedAdapter.createBodyData("Pin");
                    return;
                }
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }
    }

    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedAdapter$QuizVM;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "quizVM", "Lcom/appnew/android/databinding/QuizViewBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;Lcom/appnew/android/databinding/QuizViewBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class QuizVM extends RecyclerView.ViewHolder {
        private final QuizViewBinding quizVM;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuizVM(FeedAdapter feedAdapter, QuizViewBinding quizVM) {
            super(quizVM.getRoot());
            Intrinsics.checkNotNullParameter(quizVM, "quizVM");
            this.this$0 = feedAdapter;
            this.quizVM = quizVM;
        }

        public final void bind(final com.appnew.android.feeds.dataclass.Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.quizVM.setQuizbind(data);
            if (StringsKt.equals(BuildConfig.FLAVOR, "DishaPublication", true)) {
                ImageView imageView = this.quizVM.shareImage;
                if (imageView != null) {
                    imageView.setImageDrawable(this.this$0.getContext().getDrawable(R.drawable.share_gray));
                }
                ImageView imageView2 = this.quizVM.shareImage;
                if (imageView2 != null) {
                    imageView2.setPadding(10, 10, 10, 10);
                }
            }
            TextView textView = this.quizVM.like;
            final FeedAdapter feedAdapter = this.this$0;
            textView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuizVM$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.QuizVM.bind$lambda$0(feedAdapter, this);
                }
            }));
            LinearLayout linearLayout = this.quizVM.whatsappShare;
            final FeedAdapter feedAdapter2 = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuizVM$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.QuizVM.bind$lambda$1(feedAdapter2, this, view);
                }
            });
            ImageView imageView3 = this.quizVM.pinIV;
            final FeedAdapter feedAdapter3 = this.this$0;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuizVM$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.QuizVM.bind$lambda$2(feedAdapter3, this, data, view);
                }
            });
            Button button = this.quizVM.startQuiz;
            final FeedAdapter feedAdapter4 = this.this$0;
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuizVM$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.QuizVM.bind$lambda$3(data, feedAdapter4, this, view);
                }
            });
            FeedAdapter feedAdapter5 = this.this$0;
            LinearLayout whatsappShare = this.quizVM.whatsappShare;
            Intrinsics.checkNotNullExpressionValue(whatsappShare, "whatsappShare");
            feedAdapter5.DisableShareIcon(whatsappShare);
            if (!Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.quizVM.postComment.setVisibility(4);
                this.quizVM.postCommentCount.setVisibility(4);
                this.quizVM.viewComment.setVisibility(4);
            }
            if (Intrinsics.areEqual(this.this$0.getFeedatalist().get(getAdapterPosition()).getIs_comment_enable(), "1")) {
                this.quizVM.postComment.setVisibility(0);
                this.quizVM.postCommentCount.setVisibility(0);
                this.quizVM.viewComment.setVisibility(0);
            }
            TextView textView2 = this.quizVM.postComment;
            final FeedAdapter feedAdapter6 = this.this$0;
            textView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$QuizVM$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedAdapter.QuizVM.bind$lambda$4(feedAdapter6, this);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$0(FeedAdapter feedAdapter, QuizVM quizVM) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                if (!feedAdapter.getBooleanlike()) {
                    feedAdapter.setBooleanlike(true);
                    feedAdapter.setItem_pos(quizVM.getAdapterPosition());
                    feedAdapter.createBodyData("Like");
                }
            } else {
                Helper.showInternetToast(feedAdapter.getContext());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(FeedAdapter feedAdapter, QuizVM quizVM, View view) {
            feedAdapter.setItem_pos(quizVM.getAdapterPosition());
            Context context = feedAdapter.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Helper.sharePost((Activity) context, feedAdapter.getFeedatalist().get(feedAdapter.getItem_pos()).getId(), "", "Post Quiz");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(FeedAdapter feedAdapter, QuizVM quizVM, com.appnew.android.feeds.dataclass.Data data, View view) {
            if (Helper.isNetworkConnected(feedAdapter.getContext())) {
                feedAdapter.setItem_pos(quizVM.getAdapterPosition());
                if (Intrinsics.areEqual(data.getMy_pinned(), "1")) {
                    quizVM.quizVM.pinIV.setImageResource(R.mipmap.unpinned);
                    feedAdapter.createBodyData("Unpin");
                    return;
                } else {
                    quizVM.quizVM.pinIV.setImageResource(R.mipmap.pinned);
                    feedAdapter.createBodyData("Pin");
                    return;
                }
            }
            Helper.showInternetToast(feedAdapter.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(com.appnew.android.feeds.dataclass.Data data, FeedAdapter feedAdapter, QuizVM quizVM, View view) {
            if (data.getJson().getState() != null && StringsKt.equals$default(data.getJson().getState(), "1", false, 2, null)) {
                SharedPreference.getInstance().putString("id", "FEEDS");
                feedAdapter.setItem_pos(quizVM.getAdapterPosition());
                Intent intent = new Intent(feedAdapter.getContext(), (Class<?>) QuizActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                intent.putExtra("status", data.getMeta_url());
                intent.putExtra("name", data.getJson().getTest_series_name());
                intent.putExtra("first_attempt", data.getJson().getState());
                Context context = feedAdapter.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                Helper.gotoActivity(intent, (Activity) context);
                return;
            }
            feedAdapter.setItem_pos(quizVM.getAdapterPosition());
            NetworkCall networkCall = feedAdapter.getNetworkCall();
            Intrinsics.checkNotNull(networkCall);
            networkCall.NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$4(FeedAdapter feedAdapter, QuizVM quizVM) {
            feedAdapter.onCommentClick(quizVM.getAdapterPosition());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCommentClick(int adapterPosition) {
        if (Helper.isNetworkConnected(this.context)) {
            if (Intrinsics.areEqual(this.feedatalist.get(adapterPosition).getIs_comment_enable(), "1")) {
                this.item_pos = adapterPosition;
                this.commentlist.clear();
                createBodyData("GetComment");
                open_comment_layout(this.context, adapterPosition);
                return;
            }
            Toast.makeText(this.context, "Comment is disabled for this post", 0).show();
            return;
        }
        Helper.showInternetToast(this.context);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.API_GET_INFO_TEST_SERIES)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id("FEEDS");
            encryptionData.setTest_id(this.feedatalist.get(this.item_pos).getMeta_url());
            String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
            Intrinsics.checkNotNull(service);
            return service.API_GET_INFO_TEST_SERIES(strEncrypt);
        }
        if (Intrinsics.areEqual(apitype, API.API_GET_TEST_INSTRUCTION_DATA)) {
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setTest_id(this.feedatalist.get(this.item_pos).getMeta_url());
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
        PostDataTable postDataTableRetriveObject;
        Intrinsics.checkNotNull(jsonstring);
        String str = "time";
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
                        RetrofitResponse.GetApiData(this.context, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
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
                    Gson gson = new Gson();
                    if (this.fragment != null) {
                        Fragment fragment = getFragment();
                        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                        FeedsDao feedDao = ((FeedsFragment) fragment).getUtkashRoom().getFeedDao();
                        Context context = this.context;
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                        postDataTableRetriveObject = feedDao.retriveObject(((FeedsActivity) context).getMain_cat(), this.feedatalist.get(this.item_pos).getId());
                    } else {
                        Context context2 = this.context;
                        if (context2 instanceof FeedsActivity) {
                            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                            FeedsDao feedDao2 = ((FeedsActivity) context2).getUtkashRoom().getFeedDao();
                            Context context3 = this.context;
                            Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                            postDataTableRetriveObject = feedDao2.retriveObject(((FeedsActivity) context3).getMain_cat(), this.feedatalist.get(this.item_pos).getId());
                        } else if (context2 instanceof PinnedPostActivity) {
                            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                            FeedsDao feedDao3 = ((PinnedPostActivity) context2).getUtkashRoom().getFeedDao();
                            Context context4 = this.context;
                            Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                            postDataTableRetriveObject = feedDao3.retriveObject(((PinnedPostActivity) context4).getMain_cat(), this.feedatalist.get(this.item_pos).getId());
                        } else {
                            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                            FeedsDao feedDao4 = ((FeedsActivity) context2).getUtkashRoom().getFeedDao();
                            Context context5 = this.context;
                            Intrinsics.checkNotNull(context5, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                            postDataTableRetriveObject = feedDao4.retriveObject(((FeedsActivity) context5).getMain_cat(), this.feedatalist.get(this.item_pos).getId());
                        }
                    }
                    TestseriesBase testseriesBase = (TestseriesBase) gson.fromJson(jsonstring.toString(), TestseriesBase.class);
                    PostDataTable postDataTable = postDataTableRetriveObject;
                    if (testseriesBase.getData().getQuestions() != null && testseriesBase.getData().getQuestions().size() > 0) {
                        if (this.lang == 1) {
                            Intent intent = new Intent(this.context, (Class<?>) TestBaseActivity.class);
                            intent.putExtra("status", false);
                            intent.putExtra(Const.TEST_SERIES_ID, this.feedatalist.get(this.item_pos).getMeta_url());
                            intent.putExtra(Const.TEST_SERIES_Name, this.feedatalist.get(this.item_pos).getJson().getTest_series_name());
                            SharedPreference.getInstance().putString("test_series", jsonstring.toString());
                            intent.putExtra("course_id", "FEEDS");
                            intent.putExtra(Const.TOTAL_QUESTIONS, this.feedatalist.get(this.item_pos).getJson().getTotal_questions());
                            intent.putExtra("first_attempt", "1");
                            intent.putExtra("result_date", "");
                            intent.putExtra("test_submission", "1");
                            intent.putExtra("time", jOptLong);
                            intent.putExtra("enddate", "");
                            intent.putExtra(Const.LANG, this.lang);
                            intent.putExtra("post_json", new Gson().toJson(postDataTable));
                            Context context6 = this.context;
                            Intrinsics.checkNotNull(context6, "null cannot be cast to non-null type android.app.Activity");
                            Helper.gotoActivity_finish(intent, (Activity) context6);
                            return;
                        }
                        str = "time";
                        jOptLong = jOptLong;
                    }
                    if (testseriesBase.getData().getQuestionsHindi() != null && testseriesBase.getData().getQuestionsHindi().size() > 0) {
                        String str2 = str;
                        long j = jOptLong;
                        if (this.lang == 2) {
                            testseriesBase.getData().setQuestions(testseriesBase.getData().getQuestionsHindi());
                            Intent intent2 = new Intent(this.context, (Class<?>) TestBaseActivity.class);
                            intent2.putExtra("status", false);
                            intent2.putExtra(Const.TEST_SERIES_ID, this.feedatalist.get(this.item_pos).getMeta_url());
                            intent2.putExtra(Const.TEST_SERIES_Name, this.feedatalist.get(this.item_pos).getJson().getTest_series_name());
                            SharedPreference.getInstance().putString("test_series", jsonstring.toString());
                            intent2.putExtra("course_id", "FEEDS");
                            intent2.putExtra(Const.TOTAL_QUESTIONS, this.feedatalist.get(this.item_pos).getJson().getTotal_questions());
                            intent2.putExtra("first_attempt", "1");
                            intent2.putExtra("result_date", "");
                            intent2.putExtra("test_submission", "1");
                            intent2.putExtra(Const.LANG, this.lang);
                            intent2.putExtra(str2, j);
                            intent2.putExtra("enddate", "");
                            intent2.putExtra("post_json", new Gson().toJson(postDataTable));
                            Context context7 = this.context;
                            Intrinsics.checkNotNull(context7, "null cannot be cast to non-null type android.app.Activity");
                            Helper.gotoActivity_finish(intent2, (Activity) context7);
                            return;
                        }
                    }
                    Toast.makeText(this.context, "No Question Found", 0).show();
                    return;
                } catch (Exception unused) {
                    Toast.makeText(this.context, "Something went wrong.", 0).show();
                    return;
                }
            }
            if (StringsKt.equals(jsonstring.optString("auth_code"), Const.EXPIRY_AUTH_CODE, true)) {
                return;
            }
            RetrofitResponse.GetApiData(this.context, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
        }
    }

    public final void showPopMenuForLangauge(final View v, TestBasicInst testBasicInst) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(testBasicInst, "testBasicInst");
        PopupMenu popupMenu = new PopupMenu(this.context, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$$ExternalSyntheticLambda0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return FeedAdapter.showPopMenuForLangauge$lambda$3(v, this, menuItem);
            }
        });
        String lang_id = testBasicInst.getLang_id();
        Intrinsics.checkNotNullExpressionValue(lang_id, "getLang_id(...)");
        int length = new Regex(Constants.SEPARATOR_COMMA).split(lang_id, 0).toArray(new String[0]).length;
        for (int i = 0; i < length; i++) {
            String lang_id2 = testBasicInst.getLang_id();
            Intrinsics.checkNotNullExpressionValue(lang_id2, "getLang_id(...)");
            if (Intrinsics.areEqual(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id2, 0).toArray(new String[0]))[i], "1")) {
                popupMenu.getMenu().add(this.context.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else {
                String lang_id3 = testBasicInst.getLang_id();
                Intrinsics.checkNotNullExpressionValue(lang_id3, "getLang_id(...)");
                if (Intrinsics.areEqual(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id3, 0).toArray(new String[0]))[i], "2")) {
                    popupMenu.getMenu().add(this.context.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                }
            }
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPopMenuForLangauge$lambda$3(View view, FeedAdapter feedAdapter, MenuItem menuItem) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) view).setText(String.valueOf(menuItem.getTitle()));
        if (Intrinsics.areEqual(String.valueOf(menuItem.getTitle()), feedAdapter.context.getString(R.string.hindi))) {
            feedAdapter.lang = 2;
            return false;
        }
        if (!Intrinsics.areEqual(String.valueOf(menuItem.getTitle()), feedAdapter.context.getString(R.string.english))) {
            return false;
        }
        feedAdapter.lang = 1;
        return false;
    }

    private final void getintotestseries() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
    }

    private final void showPopUp(InstructionData instructionData) {
        Button button;
        Object systemService = this.context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.popup_basicinfo_quiz_career, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this.context, R.style.CustomAlertDialog);
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
        TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.marksTextValueTV);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.numQuesValueTV);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.sectionValueTV);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.languageSpinnerTV);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView5 = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.quizTimeValueTV);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView6 = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.remarksTV);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView7 = (TextView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.check_box);
        Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.widget.CheckBox");
        final CheckBox checkBox = (CheckBox) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.generalInstrValueTV);
        Intrinsics.checkNotNull(viewFindViewById9, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView8 = (TextView) viewFindViewById9;
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
        if (testBasic.getTest_assets() != null) {
            button = button2;
            if (StringsKt.equals(testBasic.getTest_assets().getHide_inst_time(), "0", true)) {
                linearLayout3.setVisibility(0);
            } else {
                linearLayout3.setVisibility(4);
            }
        } else {
            button = button2;
        }
        addSectionView(linearLayout, instructionData);
        if (SharedPreference.getInstance().getBoolean(Const.RE_ATTEMPT)) {
            textView7.setVisibility(8);
        } else {
            textView7.setVisibility(8);
        }
        if (testBasic.getLang_id().length() == 3) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedAdapter.showPopUp$lambda$4(this.f$0, textView5, testBasic, view);
                }
            });
        }
        String lang_id = testBasic.getLang_id();
        Intrinsics.checkNotNullExpressionValue(lang_id, "getLang_id(...)");
        if (Intrinsics.areEqual(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id, 0).toArray(new String[0]))[0], "1")) {
            textView5.setText(this.context.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            String lang_id2 = testBasic.getLang_id();
            Intrinsics.checkNotNullExpressionValue(lang_id2, "getLang_id(...)");
            this.lang = Integer.parseInt(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id2, 0).toArray(new String[0]))[0]);
        } else {
            String lang_id3 = testBasic.getLang_id();
            Intrinsics.checkNotNullExpressionValue(lang_id3, "getLang_id(...)");
            if (Intrinsics.areEqual(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id3, 0).toArray(new String[0]))[0], "2")) {
                textView5.setText(this.context.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                String lang_id4 = testBasic.getLang_id();
                Intrinsics.checkNotNullExpressionValue(lang_id4, "getLang_id(...)");
                this.lang = Integer.parseInt(((String[]) new Regex(Constants.SEPARATOR_COMMA).split(lang_id4, 0).toArray(new String[0]))[0]);
            }
        }
        textView.setText(testBasic.getTestSeriesName());
        textView3.setText(testBasic.getTotalQuestions());
        textView6.setText(testBasic.getTimeInMins());
        textView2.setText(testBasic.getTotalMarks());
        String description = testBasic.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "getDescription(...)");
        if (description.length() == 0) {
            linearLayout2.setVisibility(8);
        } else {
            linearLayout2.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        textView4.setText(new StringBuilder().append(instructionData.getTestSections().size()).toString());
        Button button3 = button;
        button3.setTag(testBasic);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedAdapter.showPopUp$lambda$5(testBasic, this, checkBox, dialog, view);
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.feeds.adapters.FeedAdapter$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return FeedAdapter.showPopUp$lambda$6(dialog, dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopUp$lambda$4(FeedAdapter feedAdapter, TextView textView, TestBasicInst testBasicInst, View view) {
        Intrinsics.checkNotNull(testBasicInst);
        feedAdapter.showPopMenuForLangauge(textView, testBasicInst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopUp$lambda$5(TestBasicInst testBasicInst, FeedAdapter feedAdapter, CheckBox checkBox, Dialog dialog, View view) {
        if (StringsKt.equals(testBasicInst.getTotalQuestions(), "0", true)) {
            Toast.makeText(feedAdapter.context, "Please add Question.", 0).show();
        } else if (checkBox.isChecked()) {
            dialog.dismiss();
            feedAdapter.getintotestseries();
        } else {
            Toast.makeText(feedAdapter.context, "Please check following instructions.", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPopUp$lambda$6(Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
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

    public final LinearLayout initSectionListView(TestSectionInst testSectionInst, int tag, String hide_inst_time) {
        String str;
        String totalNumOfAttempts;
        int intSafe;
        Intrinsics.checkNotNullParameter(testSectionInst, "testSectionInst");
        Intrinsics.checkNotNullParameter(hide_inst_time, "hide_inst_time");
        ArrayList arrayList = new ArrayList();
        View viewInflate = View.inflate(this.context, R.layout.layout_option_section_list_view, null);
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

    @Override // com.appnew.android.feeds.OptionItem
    public void itemSelect(Option option, int index, int feedlistpos) {
        Intrinsics.checkNotNullParameter(option, "option");
        this.option_index = index;
        this.item_pos = feedlistpos;
        createBodyData("Attempt Mcq");
    }

    public final void addFeed(ArrayList<com.appnew.android.feeds.dataclass.Data> datalist) {
        Intrinsics.checkNotNullParameter(datalist, "datalist");
        this.feedatalist = datalist;
        if (this.networkCall != null) {
            this.networkCall = new NetworkCall(this, this.context);
        }
    }

    public final void change_posiiton() {
        String total_likes = this.feedatalist.get(this.item_pos).getTotal_likes();
        if (this.feedatalist.get(this.item_pos).getMy_like().equals("1")) {
            this.feedatalist.get(this.item_pos).setMy_like("0");
            if (total_likes.length() != 0 && Integer.parseInt(total_likes) > 0) {
                this.feedatalist.get(this.item_pos).setTotal_likes(String.valueOf(Integer.parseInt(total_likes) - 1));
            }
        } else {
            if (total_likes.length() != 0) {
                this.feedatalist.get(this.item_pos).setTotal_likes(String.valueOf(Integer.parseInt(total_likes) + 1));
            }
            this.feedatalist.get(this.item_pos).setMy_like("1");
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05741(null), 3, null);
        notifyItemChanged(this.item_pos);
        this.booleanlike = false;
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.adapters.FeedAdapter$change_posiiton$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.adapters.FeedAdapter$change_posiiton$1", f = "FeedAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05741(Continuation<? super C05741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAdapter.this.new C05741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (FeedAdapter.this.fragment != null) {
                Fragment fragment = FeedAdapter.this.getFragment();
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                if (((FeedsFragment) fragment).getUtkashRoom().getFeedDao().isFeedExist(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId())) {
                    Fragment fragment2 = FeedAdapter.this.getFragment();
                    Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                    ((FeedsFragment) fragment2).getUtkashRoom().getFeedDao().updateMyLike(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId(), FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getMy_like(), FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getTotal_likes());
                }
            } else {
                Context context = FeedAdapter.this.getContext();
                if (context instanceof FeedsActivity) {
                    Context context2 = FeedAdapter.this.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                    if (((FeedsActivity) context2).getUtkashRoom().getFeedDao().isFeedExist(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId())) {
                        Context context3 = FeedAdapter.this.getContext();
                        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                        ((FeedsActivity) context3).getUtkashRoom().getFeedDao().updateMyLike(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId(), FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getMy_like(), FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getTotal_likes());
                    }
                } else if (context instanceof PinnedPostActivity) {
                    Context context4 = FeedAdapter.this.getContext();
                    Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                    if (((PinnedPostActivity) context4).getUtkashRoom().getFeedDao().isFeedExist(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId())) {
                        Context context5 = FeedAdapter.this.getContext();
                        Intrinsics.checkNotNull(context5, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                        ((PinnedPostActivity) context5).getUtkashRoom().getFeedDao().updateMyLike(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId(), FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getMy_like(), FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getTotal_likes());
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void getCommentList(JSONArray dataJsonObject) {
        Intrinsics.checkNotNullParameter(dataJsonObject, "dataJsonObject");
        this.commentlist.clear();
        int length = dataJsonObject.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = dataJsonObject.optJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
            this.commentlist.add((Data) new Gson().fromJson(jSONObjectOptJSONObject.toString(), Data.class));
        }
        if (this.commentlist.size() > 0) {
            getNo_data_found_RL().setVisibility(8);
        } else {
            getNo_data_found_RL().setVisibility(0);
        }
        CommentAdapter commentAdapter = this.commentAdapter;
        if (commentAdapter != null) {
            commentAdapter.notifydata(this.commentlist);
        }
    }

    public final void addComment(JSONObject jsonObject1) {
        Intrinsics.checkNotNullParameter(jsonObject1, "jsonObject1");
        this.commentlist.add((Data) new Gson().fromJson(jsonObject1.toString(), Data.class));
        if (this.commentlist.size() > 0) {
            getNo_data_found_RL().setVisibility(8);
        } else {
            getNo_data_found_RL().setVisibility(0);
        }
        CommentAdapter commentAdapter = this.commentAdapter;
        Intrinsics.checkNotNull(commentAdapter);
        commentAdapter.addToExistingList(this.commentlist);
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Helper.hideKeyboard((Activity) context);
        RecyclerView recyclerView = this.comment_recyerler;
        Intrinsics.checkNotNull(recyclerView);
        RecyclerView recyclerView2 = this.comment_recyerler;
        Intrinsics.checkNotNull(recyclerView2);
        Intrinsics.checkNotNull(recyclerView2.getAdapter());
        recyclerView.scrollToPosition(r0.getItemCount() - 1);
        notifyItemChanged(this.item_pos);
    }

    public final void attempt_mcq() {
        String attempt_count = this.feedatalist.get(this.item_pos).getJson().getOptions().get(this.option_index).getAttempt_count();
        String str = "0";
        if (attempt_count.equals("")) {
            attempt_count = "0";
        }
        this.feedatalist.get(this.item_pos).getJson().getOptions().get(this.option_index).setAttempt_count(String.valueOf(Integer.parseInt(attempt_count) + 1));
        this.feedatalist.get(this.item_pos).getJson().setAttempt_index(String.valueOf(this.option_index + 1));
        String total_attempt = this.feedatalist.get(this.item_pos).getJson().getTotal_attempt();
        if (total_attempt != null && total_attempt.length() != 0) {
            str = total_attempt;
        }
        this.feedatalist.get(this.item_pos).getJson().setTotal_attempt(String.valueOf(Integer.parseInt(str) + 1));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
        notifyItemChanged(this.item_pos);
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.adapters.FeedAdapter$attempt_mcq$1, reason: invalid class name */
    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.adapters.FeedAdapter$attempt_mcq$1", f = "FeedAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAdapter.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (FeedAdapter.this.fragment != null) {
                Fragment fragment = FeedAdapter.this.getFragment();
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                if (((FeedsFragment) fragment).getUtkashRoom().getFeedDao().isFeedExist(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId())) {
                    Fragment fragment2 = FeedAdapter.this.getFragment();
                    Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                    ((FeedsFragment) fragment2).getUtkashRoom().getFeedDao().updateMyjson(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId(), new Gson().toJson(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getJson()));
                }
            } else {
                Context context = FeedAdapter.this.getContext();
                if (context instanceof FeedsActivity) {
                    Context context2 = FeedAdapter.this.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                    if (((FeedsActivity) context2).getUtkashRoom().getFeedDao().isFeedExist(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId())) {
                        Context context3 = FeedAdapter.this.getContext();
                        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                        ((FeedsActivity) context3).getUtkashRoom().getFeedDao().updateMyjson(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId(), new Gson().toJson(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getJson()));
                    }
                } else if (context instanceof PinnedPostActivity) {
                    Context context4 = FeedAdapter.this.getContext();
                    Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                    if (((PinnedPostActivity) context4).getUtkashRoom().getFeedDao().isFeedExist(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId())) {
                        Context context5 = FeedAdapter.this.getContext();
                        Intrinsics.checkNotNull(context5, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                        ((PinnedPostActivity) context5).getUtkashRoom().getFeedDao().updateMyjson(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getId(), new Gson().toJson(FeedAdapter.this.getFeedatalist().get(FeedAdapter.this.getItem_pos()).getJson()));
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void viewAllclass(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Helper.gotoActivity_withour_intent((Activity) context, LiveClassActivity.class);
    }

    public final void viewAllTest(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Helper.gotoActivity_withour_intent((Activity) context, LivetestActivity.class);
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String s) {
        int i = this.context.getResources().getDisplayMetrics().widthPixels;
        LevelListDrawable levelListDrawable = new LevelListDrawable();
        Drawable drawable = this.context.getResources().getDrawable(R.mipmap.course_placeholder);
        levelListDrawable.addLevel(0, 0, drawable);
        levelListDrawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05751(s, levelListDrawable, i, 10, this, null), 3, null);
        return levelListDrawable;
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.adapters.FeedAdapter$getDrawable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.adapters.FeedAdapter$getDrawable$1", f = "FeedAdapter.kt", i = {}, l = {1844}, m = "invokeSuspend", n = {}, s = {})
    static final class C05751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LevelListDrawable $d;
        final /* synthetic */ int $dpWidth;
        final /* synthetic */ int $padding;
        final /* synthetic */ String $s;
        int label;
        final /* synthetic */ FeedAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05751(String str, LevelListDrawable levelListDrawable, int i, int i2, FeedAdapter feedAdapter, Continuation<? super C05751> continuation) {
            super(2, continuation);
            this.$s = str;
            this.$d = levelListDrawable;
            this.$dpWidth = i;
            this.$padding = i2;
            this.this$0 = feedAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05751(this.$s, this.$d, this.$dpWidth, this.$padding, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C01131(this.this$0, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.appnew.android.feeds.adapters.FeedAdapter$getDrawable$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FeedAdapter.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.feeds.adapters.FeedAdapter$getDrawable$1$1", f = "FeedAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FeedAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01131(FeedAdapter feedAdapter, Continuation<? super C01131> continuation) {
                super(2, continuation);
                this.this$0 = feedAdapter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01131(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                TextView textView = this.this$0.getTextView();
                Intrinsics.checkNotNull(textView);
                CharSequence text = textView.getText();
                TextView textView2 = this.this$0.getTextView();
                Intrinsics.checkNotNull(textView2);
                textView2.setText(text);
                return Unit.INSTANCE;
            }
        }
    }

    public final void pinPost() {
        String id = this.feedatalist.get(this.item_pos).getId();
        this.feedatalist.get(this.item_pos).setMy_pinned("1");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05761(id, null), 3, null);
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.adapters.FeedAdapter$pinPost$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.adapters.FeedAdapter$pinPost$1", f = "FeedAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05761(String str, Continuation<? super C05761> continuation) {
            super(2, continuation);
            this.$postId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAdapter.this.new C05761(this.$postId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (FeedAdapter.this.fragment != null) {
                Fragment fragment = FeedAdapter.this.getFragment();
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                if (((FeedsFragment) fragment).getUtkashRoom().getFeedDao().isFeedExist(this.$postId)) {
                    Fragment fragment2 = FeedAdapter.this.getFragment();
                    Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                    ((FeedsFragment) fragment2).getUtkashRoom().getFeedDao().updatePinnedPost("1", this.$postId);
                }
            } else {
                Context context = FeedAdapter.this.getContext();
                if (context instanceof FeedsActivity) {
                    Context context2 = FeedAdapter.this.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                    if (((FeedsActivity) context2).getUtkashRoom().getFeedDao().isFeedExist(this.$postId)) {
                        Context context3 = FeedAdapter.this.getContext();
                        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                        ((FeedsActivity) context3).getUtkashRoom().getFeedDao().updatePinnedPost("1", this.$postId);
                    }
                } else if (context instanceof PinnedPostActivity) {
                    Context context4 = FeedAdapter.this.getContext();
                    Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                    if (((PinnedPostActivity) context4).getUtkashRoom().getFeedDao().isFeedExist(this.$postId)) {
                        Context context5 = FeedAdapter.this.getContext();
                        Intrinsics.checkNotNull(context5, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                        ((PinnedPostActivity) context5).getUtkashRoom().getFeedDao().updatePinnedPost("1", this.$postId);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void unPinPost() {
        String id = this.feedatalist.get(this.item_pos).getId();
        this.feedatalist.get(this.item_pos).setMy_pinned("0");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05771(id, null), 3, null);
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.adapters.FeedAdapter$unPinPost$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.adapters.FeedAdapter$unPinPost$1", f = "FeedAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $postId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05771(String str, Continuation<? super C05771> continuation) {
            super(2, continuation);
            this.$postId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedAdapter.this.new C05771(this.$postId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (FeedAdapter.this.fragment != null) {
                Fragment fragment = FeedAdapter.this.getFragment();
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                if (((FeedsFragment) fragment).getUtkashRoom().getFeedDao().isFeedExist(this.$postId)) {
                    Fragment fragment2 = FeedAdapter.this.getFragment();
                    Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.appnew.android.feeds.fragments.FeedsFragment");
                    ((FeedsFragment) fragment2).getUtkashRoom().getFeedDao().updatePinnedPost("0", this.$postId);
                }
            } else {
                Context context = FeedAdapter.this.getContext();
                if (context instanceof FeedsActivity) {
                    Context context2 = FeedAdapter.this.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                    if (((FeedsActivity) context2).getUtkashRoom().getFeedDao().isFeedExist(this.$postId)) {
                        Context context3 = FeedAdapter.this.getContext();
                        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.feeds.activity.FeedsActivity");
                        ((FeedsActivity) context3).getUtkashRoom().getFeedDao().updatePinnedPost("0", this.$postId);
                    }
                } else if (context instanceof PinnedPostActivity) {
                    Context context4 = FeedAdapter.this.getContext();
                    Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                    if (((PinnedPostActivity) context4).getUtkashRoom().getFeedDao().isFeedExist(this.$postId)) {
                        Context context5 = FeedAdapter.this.getContext();
                        Intrinsics.checkNotNull(context5, "null cannot be cast to non-null type com.appnew.android.feeds.activity.PinnedPostActivity");
                        ((PinnedPostActivity) context5).getUtkashRoom().getFeedDao().updatePinnedPost("0", this.$postId);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
