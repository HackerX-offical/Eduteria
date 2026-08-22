package com.appnew.android.feeds.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Intro.Mastercat;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityFeedsBinding;
import com.appnew.android.feeds.adapters.FeedAdapter;
import com.appnew.android.feeds.adapters.MainCatAdapter;
import com.appnew.android.feeds.dataclass.BannerData;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.Datum;
import com.appnew.android.feeds.dataclass.Json;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.appnew.android.feeds.dataclass.PostType;
import com.appnew.android.feeds.dataclass.TestResult;
import com.appnew.android.feeds.viewmodel.FeedViewModel;
import com.appnew.android.feeds.viewmodelfactory.FeedViewModelProviderFactory;
import com.appnew.android.home.Constants;
import com.appnew.android.home.livetest.LiveTestData;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.appnew.android.table.PostDataTable;
import com.appnew.mvvmwithretrofit.repository.Repository;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.joda.time.DateTimeConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: FeedsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010ß\u0001\u001a\u00030à\u00012\n\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001H\u0014J\n\u0010ã\u0001\u001a\u00030à\u0001H\u0002J\n\u0010ä\u0001\u001a\u00030à\u0001H\u0002J\u0013\u0010å\u0001\u001a\u00030à\u00012\u0007\u0010æ\u0001\u001a\u00020\u0011H\u0002J\b\u0010ç\u0001\u001a\u00030à\u0001J\b\u0010è\u0001\u001a\u00030à\u0001J\u001b\u0010é\u0001\u001a\u00030à\u00012\u000f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030Ö\u00010ë\u0001H\u0002J\u001b\u0010ì\u0001\u001a\u00030à\u00012\u000f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030Ö\u00010ë\u0001H\u0002J\n\u0010í\u0001\u001a\u00030à\u0001H\u0002J\n\u0010î\u0001\u001a\u00030à\u0001H\u0002J\b\u0010ï\u0001\u001a\u00030à\u0001J\b\u0010ð\u0001\u001a\u00030à\u0001J\u0015\u0010ñ\u0001\u001a\u00020\u00112\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H\u0016J\n\u0010ô\u0001\u001a\u00030à\u0001H\u0016J\n\u0010õ\u0001\u001a\u00030à\u0001H\u0014J\n\u0010ö\u0001\u001a\u00030à\u0001H\u0014J\n\u0010÷\u0001\u001a\u00030Á\u0001H\u0003J6\u0010ø\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010ù\u00012\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010û\u0001\u001a\u0004\u0018\u00010\u00182\n\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001H\u0016J4\u0010þ\u0001\u001a\u00030à\u00012\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010û\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0080\u0002\u001a\u00020\u0011H\u0016J\n\u0010\u0081\u0002\u001a\u00030à\u0001H\u0002J+\u0010\u0082\u0002\u001a\u00030à\u00012\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u00182\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010û\u0001\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010#\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014R\u001a\u0010.\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001a\u0010:\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001cR\u001a\u0010=\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001a\"\u0004\b?\u0010\u001cR\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0012\"\u0004\bH\u0010\u0014R\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020PX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001a\"\u0004\bW\u0010\u001cR\u001a\u0010X\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u001a\"\u0004\bZ\u0010\u001cR\u001a\u0010[\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u001a\"\u0004\b]\u0010\u001cR\u001a\u0010^\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u001a\"\u0004\b`\u0010\u001cR\u001a\u0010a\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u001a\"\u0004\bc\u0010\u001cR\u001a\u0010d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u001a\"\u0004\bf\u0010\u001cR\u001a\u0010g\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0012\"\u0004\bh\u0010\u0014R\u001a\u0010i\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u001a\"\u0004\bk\u0010\u001cR\u001a\u0010l\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u001a\"\u0004\bn\u0010\u001cR\u001a\u0010o\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u001a\"\u0004\bq\u0010\u001cR\u001a\u0010r\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u001a\"\u0004\bt\u0010\u001cR\u001a\u0010u\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0012\"\u0004\bw\u0010\u0014R\u001a\u0010x\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u001a\"\u0004\bz\u0010\u001cR-\u0010{\u001a\u0012\u0012\u0004\u0012\u00020}0|j\b\u0012\u0004\u0012\u00020}`~X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R/\u0010\u0083\u0001\u001a\u0012\u0012\u0004\u0012\u00020}0|j\b\u0012\u0004\u0012\u00020}`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0080\u0001\"\u0006\b\u0085\u0001\u0010\u0082\u0001R \u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R1\u0010\u008c\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008d\u00010|j\t\u0012\u0005\u0012\u00030\u008d\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u0080\u0001\"\u0006\b\u008f\u0001\u0010\u0082\u0001R1\u0010\u0090\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0091\u00010|j\t\u0012\u0005\u0012\u00030\u0091\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0080\u0001\"\u0006\b\u0093\u0001\u0010\u0082\u0001R1\u0010\u0094\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008d\u00010|j\t\u0012\u0005\u0012\u00030\u008d\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0080\u0001\"\u0006\b\u0096\u0001\u0010\u0082\u0001R1\u0010\u0097\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008d\u00010|j\t\u0012\u0005\u0012\u00030\u008d\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0080\u0001\"\u0006\b\u0099\u0001\u0010\u0082\u0001R\u000f\u0010\u009a\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\u009b\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008d\u00010|j\t\u0012\u0005\u0012\u00030\u008d\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u0080\u0001\"\u0006\b\u009d\u0001\u0010\u0082\u0001R1\u0010\u009e\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u009f\u00010|j\t\u0012\u0005\u0012\u00030\u009f\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010\u0080\u0001\"\u0006\b¡\u0001\u0010\u0082\u0001R1\u0010¢\u0001\u001a\u0014\u0012\u0005\u0012\u00030£\u00010|j\t\u0012\u0005\u0012\u00030£\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010\u0080\u0001\"\u0006\b¥\u0001\u0010\u0082\u0001R1\u0010¦\u0001\u001a\u0014\u0012\u0005\u0012\u00030§\u00010|j\t\u0012\u0005\u0012\u00030§\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010\u0080\u0001\"\u0006\b©\u0001\u0010\u0082\u0001R1\u0010ª\u0001\u001a\u0014\u0012\u0005\u0012\u00030«\u00010|j\t\u0012\u0005\u0012\u00030«\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u0080\u0001\"\u0006\b\u00ad\u0001\u0010\u0082\u0001R1\u0010®\u0001\u001a\u0014\u0012\u0005\u0012\u00030¯\u00010|j\t\u0012\u0005\u0012\u00030¯\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0001\u0010\u0080\u0001\"\u0006\b±\u0001\u0010\u0082\u0001R&\u0010²\u0001\u001a\t\u0012\u0004\u0012\u00020}0³\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R1\u0010¸\u0001\u001a\u0014\u0012\u0005\u0012\u00030¹\u00010|j\t\u0012\u0005\u0012\u00030¹\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010\u0080\u0001\"\u0006\b»\u0001\u0010\u0082\u0001R1\u0010¼\u0001\u001a\u0014\u0012\u0005\u0012\u00030½\u00010|j\t\u0012\u0005\u0012\u00030½\u0001`~X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¾\u0001\u0010\u0080\u0001\"\u0006\b¿\u0001\u0010\u0082\u0001R\"\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R \u0010Æ\u0001\u001a\u00030Ç\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u001d\u0010Ì\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010(\"\u0005\bÎ\u0001\u0010*R\"\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R'\u0010Õ\u0001\u001a\n\u0012\u0005\u0012\u00030Ö\u00010³\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b×\u0001\u0010µ\u0001\"\u0006\bØ\u0001\u0010·\u0001R\"\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001¨\u0006\u0084\u0002"}, d2 = {"Lcom/appnew/android/feeds/activity/FeedsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "refreshCount", "", "backBtn", "Landroid/widget/Button;", "getBackBtn", "()Landroid/widget/Button;", "setBackBtn", "(Landroid/widget/Button;)V", "feedJsonObject", "Lorg/json/JSONObject;", "isPullToRefresh", "", "()Z", "setPullToRefresh", "(Z)V", "isPullToRefreshMessage", "setPullToRefreshMessage", "liveClassStatus", "", "getLiveClassStatus", "()Ljava/lang/String;", "setLiveClassStatus", "(Ljava/lang/String;)V", "liveTestStatus", "getLiveTestStatus", "setLiveTestStatus", "section_posiiton", "getSection_posiiton", "setSection_posiiton", "response_booelan", "getResponse_booelan", "setResponse_booelan", "limitdata", "getLimitdata", "()I", "setLimitdata", "(I)V", "type_subcatfilter", "getType_subcatfilter", "setType_subcatfilter", "type_posttypefilter", "getType_posttypefilter", "setType_posttypefilter", "subcatspinner", "Landroid/widget/TextView;", "getSubcatspinner", "()Landroid/widget/TextView;", "setSubcatspinner", "(Landroid/widget/TextView;)V", "posttypeytext", "getPosttypeytext", "setPosttypeytext", "posttypename", "getPosttypename", "setPosttypename", "posttypeid", "getPosttypeid", "setPosttypeid", "feedAdapter", "Lcom/appnew/android/feeds/adapters/FeedAdapter;", "getFeedAdapter", "()Lcom/appnew/android/feeds/adapters/FeedAdapter;", "setFeedAdapter", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;)V", "loading", "getLoading", "setLoading", "no_data_found_RL", "Landroid/widget/RelativeLayout;", "getNo_data_found_RL", "()Landroid/widget/RelativeLayout;", "setNo_data_found_RL", "(Landroid/widget/RelativeLayout;)V", "feedViewModel", "Lcom/appnew/android/feeds/viewmodel/FeedViewModel;", "getFeedViewModel", "()Lcom/appnew/android/feeds/viewmodel/FeedViewModel;", "setFeedViewModel", "(Lcom/appnew/android/feeds/viewmodel/FeedViewModel;)V", Const.CAT_ID, "getMain_cat", "setMain_cat", "main_cat_name", "getMain_cat_name", "setMain_cat_name", Const.SUB_CAT, "getSub_cat", "setSub_cat", "sub_cat_name", "getSub_cat_name", "setSub_cat_name", "sub_cat_filter", "getSub_cat_filter", "setSub_cat_filter", "sub_cat_name_filter", "getSub_cat_name_filter", "setSub_cat_name_filter", "is_filterbutton", "set_filterbutton", "master_cat", "getMaster_cat", "setMaster_cat", Const.POST_TYPE, "getPost_type", "setPost_type", "type", "getType", "setType", "temp", "getTemp", "setTemp", "show_all_post", "getShow_all_post", "setShow_all_post", "master_cat_name", "getMaster_cat_name", "setMaster_cat_name", "selected_master_cat", "Ljava/util/ArrayList;", "Lcom/appnew/android/table/MasteAllCatTable;", "Lkotlin/collections/ArrayList;", "getSelected_master_cat", "()Ljava/util/ArrayList;", "setSelected_master_cat", "(Ljava/util/ArrayList;)V", "selectedsub_all_cat", "getSelectedsub_all_cat", "setSelectedsub_all_cat", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "datalist", "Lcom/appnew/android/feeds/dataclass/Data;", "getDatalist", "setDatalist", "posttypelist", "Lcom/appnew/android/feeds/dataclass/PostType;", "getPosttypelist", "setPosttypelist", "posiitonwiselist", "getPosiitonwiselist", "setPosiitonwiselist", "pinnedPostList", "getPinnedPostList", "setPinnedPostList", "pinnedPost", "feedlist", "getFeedlist", "setFeedlist", "newCourseData", "Lcom/appnew/android/feeds/dataclass/NewCourseData;", "getNewCourseData", "setNewCourseData", "testResultList", "Lcom/appnew/android/feeds/dataclass/TestResult;", "getTestResultList", "setTestResultList", "liveTestData", "Lcom/appnew/android/home/livetest/LiveTestData;", "getLiveTestData", "setLiveTestData", "liveClassData", "Lcom/appnew/android/feeds/dataclass/Datum;", "getLiveClassData", "setLiveClassData", "bannert_list", "Lcom/appnew/android/feeds/dataclass/BannerData;", "getBannert_list", "setBannert_list", "masterAllCatTables", "", "getMasterAllCatTables", "()Ljava/util/List;", "setMasterAllCatTables", "(Ljava/util/List;)V", "mastercatlist", "Lcom/appnew/android/table/MasterCat;", "getMastercatlist", "setMastercatlist", "preferencesArrayList", "Lcom/appnew/android/pojo/Userinfo/Data$Preferences;", "getPreferencesArrayList", "setPreferencesArrayList", "popUp", "Landroid/widget/PopupWindow;", "getPopUp", "()Landroid/widget/PopupWindow;", "setPopUp", "(Landroid/widget/PopupWindow;)V", "locale_time", "", "getLocale_time", "()J", "setLocale_time", "(J)V", "page", "getPage", "setPage", "feedsBinding", "Lcom/appnew/android/databinding/ActivityFeedsBinding;", "getFeedsBinding", "()Lcom/appnew/android/databinding/ActivityFeedsBinding;", "setFeedsBinding", "(Lcom/appnew/android/databinding/ActivityFeedsBinding;)V", "feedParentData", "Lcom/appnew/android/table/PostDataTable;", "getFeedParentData", "setFeedParentData", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getPostData", "filterDailog", "local_data", "filter", "createApiBodyData", "setObservers", "updatePostData", "postData", "", "catregoryPost", "hitApiForLiveClass", "hitApiForLiveTest", "showProgressView", "hideProgressView", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "onBackPressed", "onPause", "onRestart", "popupWindowPart", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "showprogress", "manageData", "ErrorCallBack", "jsonstring", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private Button backBtn;
    private ArrayList<BannerData> bannert_list;
    private ArrayList<Data> datalist;
    private FeedAdapter feedAdapter;
    private JSONObject feedJsonObject;
    private List<PostDataTable> feedParentData;
    public FeedViewModel feedViewModel;
    private ArrayList<Data> feedlist;
    private ActivityFeedsBinding feedsBinding;
    private boolean isPullToRefresh;
    private boolean isPullToRefreshMessage;
    private boolean is_filterbutton;
    private int limitdata;
    private ArrayList<Datum> liveClassData;
    private ArrayList<LiveTestData> liveTestData;
    private long locale_time;
    private List<? extends MasteAllCatTable> masterAllCatTables;
    private ArrayList<MasterCat> mastercatlist;
    private NetworkCall networkCall;
    private ArrayList<NewCourseData> newCourseData;
    private RelativeLayout no_data_found_RL;
    private int page;
    private String pinnedPost;
    private ArrayList<Data> pinnedPostList;
    private PopupWindow popUp;
    private ArrayList<Data> posiitonwiselist;
    private ArrayList<PostType> posttypelist;
    private TextView posttypeytext;
    private ArrayList<Data.Preferences> preferencesArrayList;
    private int refreshCount;
    private boolean response_booelan;
    private boolean show_all_post;
    private TextView subcatspinner;
    private ArrayList<TestResult> testResultList;
    private boolean type_posttypefilter;
    private boolean type_subcatfilter;
    private UtkashRoom utkashRoom;
    private String liveClassStatus = "0";
    private String liveTestStatus = "0";
    private String section_posiiton = "0";
    private String posttypename = "All";
    private String posttypeid = "0";
    private boolean loading = true;
    private String main_cat = "";
    private String main_cat_name = "";
    private String sub_cat = "";
    private String sub_cat_name = "";
    private String sub_cat_filter = "";
    private String sub_cat_name_filter = "";
    private String master_cat = "";
    private String post_type = "";
    private String type = "";
    private String temp = "";
    private String master_cat_name = "";
    private ArrayList<MasteAllCatTable> selected_master_cat = new ArrayList<>();
    private ArrayList<MasteAllCatTable> selectedsub_all_cat = new ArrayList<>();

    public FeedsActivity() {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        Intrinsics.checkNotNullExpressionValue(appDatabase, "getAppDatabase(...)");
        this.utkashRoom = appDatabase;
        this.datalist = new ArrayList<>();
        this.posttypelist = new ArrayList<>();
        this.posiitonwiselist = new ArrayList<>();
        this.pinnedPostList = new ArrayList<>();
        this.pinnedPost = "0";
        this.feedlist = new ArrayList<>();
        this.newCourseData = new ArrayList<>();
        this.testResultList = new ArrayList<>();
        this.liveTestData = new ArrayList<>();
        this.liveClassData = new ArrayList<>();
        this.bannert_list = new ArrayList<>();
        this.masterAllCatTables = new ArrayList();
        this.mastercatlist = new ArrayList<>();
        this.preferencesArrayList = new ArrayList<>();
        this.page = 1;
        this.feedParentData = CollectionsKt.emptyList();
    }

    public final Button getBackBtn() {
        return this.backBtn;
    }

    public final void setBackBtn(Button button) {
        this.backBtn = button;
    }

    /* JADX INFO: renamed from: isPullToRefresh, reason: from getter */
    public final boolean getIsPullToRefresh() {
        return this.isPullToRefresh;
    }

    public final void setPullToRefresh(boolean z) {
        this.isPullToRefresh = z;
    }

    /* JADX INFO: renamed from: isPullToRefreshMessage, reason: from getter */
    public final boolean getIsPullToRefreshMessage() {
        return this.isPullToRefreshMessage;
    }

    public final void setPullToRefreshMessage(boolean z) {
        this.isPullToRefreshMessage = z;
    }

    public final String getLiveClassStatus() {
        return this.liveClassStatus;
    }

    public final void setLiveClassStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveClassStatus = str;
    }

    public final String getLiveTestStatus() {
        return this.liveTestStatus;
    }

    public final void setLiveTestStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveTestStatus = str;
    }

    public final String getSection_posiiton() {
        return this.section_posiiton;
    }

    public final void setSection_posiiton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.section_posiiton = str;
    }

    public final boolean getResponse_booelan() {
        return this.response_booelan;
    }

    public final void setResponse_booelan(boolean z) {
        this.response_booelan = z;
    }

    public final int getLimitdata() {
        return this.limitdata;
    }

    public final void setLimitdata(int i) {
        this.limitdata = i;
    }

    public final boolean getType_subcatfilter() {
        return this.type_subcatfilter;
    }

    public final void setType_subcatfilter(boolean z) {
        this.type_subcatfilter = z;
    }

    public final boolean getType_posttypefilter() {
        return this.type_posttypefilter;
    }

    public final void setType_posttypefilter(boolean z) {
        this.type_posttypefilter = z;
    }

    public final TextView getSubcatspinner() {
        return this.subcatspinner;
    }

    public final void setSubcatspinner(TextView textView) {
        this.subcatspinner = textView;
    }

    public final TextView getPosttypeytext() {
        return this.posttypeytext;
    }

    public final void setPosttypeytext(TextView textView) {
        this.posttypeytext = textView;
    }

    public final String getPosttypename() {
        return this.posttypename;
    }

    public final void setPosttypename(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.posttypename = str;
    }

    public final String getPosttypeid() {
        return this.posttypeid;
    }

    public final void setPosttypeid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.posttypeid = str;
    }

    public final FeedAdapter getFeedAdapter() {
        return this.feedAdapter;
    }

    public final void setFeedAdapter(FeedAdapter feedAdapter) {
        this.feedAdapter = feedAdapter;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final void setLoading(boolean z) {
        this.loading = z;
    }

    public final RelativeLayout getNo_data_found_RL() {
        return this.no_data_found_RL;
    }

    public final void setNo_data_found_RL(RelativeLayout relativeLayout) {
        this.no_data_found_RL = relativeLayout;
    }

    public final FeedViewModel getFeedViewModel() {
        FeedViewModel feedViewModel = this.feedViewModel;
        if (feedViewModel != null) {
            return feedViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
        return null;
    }

    public final void setFeedViewModel(FeedViewModel feedViewModel) {
        Intrinsics.checkNotNullParameter(feedViewModel, "<set-?>");
        this.feedViewModel = feedViewModel;
    }

    public final String getMain_cat() {
        return this.main_cat;
    }

    public final void setMain_cat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.main_cat = str;
    }

    public final String getMain_cat_name() {
        return this.main_cat_name;
    }

    public final void setMain_cat_name(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.main_cat_name = str;
    }

    public final String getSub_cat() {
        return this.sub_cat;
    }

    public final void setSub_cat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sub_cat = str;
    }

    public final String getSub_cat_name() {
        return this.sub_cat_name;
    }

    public final void setSub_cat_name(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sub_cat_name = str;
    }

    public final String getSub_cat_filter() {
        return this.sub_cat_filter;
    }

    public final void setSub_cat_filter(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sub_cat_filter = str;
    }

    public final String getSub_cat_name_filter() {
        return this.sub_cat_name_filter;
    }

    public final void setSub_cat_name_filter(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sub_cat_name_filter = str;
    }

    /* JADX INFO: renamed from: is_filterbutton, reason: from getter */
    public final boolean getIs_filterbutton() {
        return this.is_filterbutton;
    }

    public final void set_filterbutton(boolean z) {
        this.is_filterbutton = z;
    }

    public final String getMaster_cat() {
        return this.master_cat;
    }

    public final void setMaster_cat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.master_cat = str;
    }

    public final String getPost_type() {
        return this.post_type;
    }

    public final void setPost_type(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.post_type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getTemp() {
        return this.temp;
    }

    public final void setTemp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.temp = str;
    }

    public final boolean getShow_all_post() {
        return this.show_all_post;
    }

    public final void setShow_all_post(boolean z) {
        this.show_all_post = z;
    }

    public final String getMaster_cat_name() {
        return this.master_cat_name;
    }

    public final void setMaster_cat_name(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.master_cat_name = str;
    }

    public final ArrayList<MasteAllCatTable> getSelected_master_cat() {
        return this.selected_master_cat;
    }

    public final void setSelected_master_cat(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selected_master_cat = arrayList;
    }

    public final ArrayList<MasteAllCatTable> getSelectedsub_all_cat() {
        return this.selectedsub_all_cat;
    }

    public final void setSelectedsub_all_cat(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selectedsub_all_cat = arrayList;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    public final ArrayList<com.appnew.android.feeds.dataclass.Data> getDatalist() {
        return this.datalist;
    }

    public final void setDatalist(ArrayList<com.appnew.android.feeds.dataclass.Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.datalist = arrayList;
    }

    public final ArrayList<PostType> getPosttypelist() {
        return this.posttypelist;
    }

    public final void setPosttypelist(ArrayList<PostType> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.posttypelist = arrayList;
    }

    public final ArrayList<com.appnew.android.feeds.dataclass.Data> getPosiitonwiselist() {
        return this.posiitonwiselist;
    }

    public final void setPosiitonwiselist(ArrayList<com.appnew.android.feeds.dataclass.Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.posiitonwiselist = arrayList;
    }

    public final ArrayList<com.appnew.android.feeds.dataclass.Data> getPinnedPostList() {
        return this.pinnedPostList;
    }

    public final void setPinnedPostList(ArrayList<com.appnew.android.feeds.dataclass.Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.pinnedPostList = arrayList;
    }

    public final ArrayList<com.appnew.android.feeds.dataclass.Data> getFeedlist() {
        return this.feedlist;
    }

    public final void setFeedlist(ArrayList<com.appnew.android.feeds.dataclass.Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.feedlist = arrayList;
    }

    public final ArrayList<NewCourseData> getNewCourseData() {
        return this.newCourseData;
    }

    public final void setNewCourseData(ArrayList<NewCourseData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.newCourseData = arrayList;
    }

    public final ArrayList<TestResult> getTestResultList() {
        return this.testResultList;
    }

    public final void setTestResultList(ArrayList<TestResult> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.testResultList = arrayList;
    }

    public final ArrayList<LiveTestData> getLiveTestData() {
        return this.liveTestData;
    }

    public final void setLiveTestData(ArrayList<LiveTestData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.liveTestData = arrayList;
    }

    public final ArrayList<Datum> getLiveClassData() {
        return this.liveClassData;
    }

    public final void setLiveClassData(ArrayList<Datum> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.liveClassData = arrayList;
    }

    public final ArrayList<BannerData> getBannert_list() {
        return this.bannert_list;
    }

    public final void setBannert_list(ArrayList<BannerData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bannert_list = arrayList;
    }

    public final List<MasteAllCatTable> getMasterAllCatTables() {
        return this.masterAllCatTables;
    }

    public final void setMasterAllCatTables(List<? extends MasteAllCatTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.masterAllCatTables = list;
    }

    public final ArrayList<MasterCat> getMastercatlist() {
        return this.mastercatlist;
    }

    public final void setMastercatlist(ArrayList<MasterCat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mastercatlist = arrayList;
    }

    public final ArrayList<Data.Preferences> getPreferencesArrayList() {
        return this.preferencesArrayList;
    }

    public final void setPreferencesArrayList(ArrayList<Data.Preferences> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.preferencesArrayList = arrayList;
    }

    public final PopupWindow getPopUp() {
        return this.popUp;
    }

    public final void setPopUp(PopupWindow popupWindow) {
        this.popUp = popupWindow;
    }

    public final long getLocale_time() {
        return this.locale_time;
    }

    public final void setLocale_time(long j) {
        this.locale_time = j;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public final ActivityFeedsBinding getFeedsBinding() {
        return this.feedsBinding;
    }

    public final void setFeedsBinding(ActivityFeedsBinding activityFeedsBinding) {
        this.feedsBinding = activityFeedsBinding;
    }

    public final List<PostDataTable> getFeedParentData() {
        return this.feedParentData;
    }

    public final void setFeedParentData(List<PostDataTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.feedParentData = list;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        ImageView imageView;
        NestedScrollView nestedScrollView;
        RecyclerView recyclerView;
        ActivityFeedsBinding activityFeedsBinding;
        ImageView imageView2;
        TextView textView;
        SwipeRefreshLayout swipeRefreshLayout;
        ActivityFeedsBinding activityFeedsBinding2;
        View root;
        super.onCreate(savedInstanceState);
        MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        SharedPreference.getInstance().putBoolean("show_feeds", false);
        if (getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            this.show_all_post = extras.getBoolean("show_all_post");
        }
        Intrinsics.checkNotNull(aPIInterface);
        setFeedViewModel((FeedViewModel) new ViewModelProvider(this, new FeedViewModelProviderFactory(new Repository(aPIInterface), this.utkashRoom)).get(FeedViewModel.class));
        try {
            ActivityFeedsBinding activityFeedsBinding3 = (ActivityFeedsBinding) DataBindingUtil.setContentView(this, R.layout.activity_feeds);
            this.feedsBinding = activityFeedsBinding3;
            if (activityFeedsBinding3 != null) {
                if (activityFeedsBinding3 != null) {
                    activityFeedsBinding3.setFeedbind(getFeedViewModel());
                }
                activityFeedsBinding3.setLifecycleOwner(this);
            }
            if (Build.VERSION.SDK_INT == 36 && (activityFeedsBinding2 = this.feedsBinding) != null && (root = activityFeedsBinding2.getRoot()) != null) {
                Window window = getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
                ActivityFeedsBinding activityFeedsBinding4 = this.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding4);
                Toolbar feedsToolbar = activityFeedsBinding4.feedsToolbar;
                Intrinsics.checkNotNullExpressionValue(feedsToolbar, "feedsToolbar");
                EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, window, root, feedsToolbar);
            }
            Helper.enableScreenShot(this);
            this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) findViewById(R.id.backBtn);
            ActivityFeedsBinding activityFeedsBinding5 = this.feedsBinding;
            if (activityFeedsBinding5 != null && (swipeRefreshLayout = activityFeedsBinding5.pulltoReferesh) != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
            this.preferencesArrayList = SharedPreference.getInstance().getLoggedInUser().getPreferences();
            this.locale_time = SharedPreference.getInstance().getLong("time");
            getFeedViewModel().getProgressvalue().setValue("1");
            ActivityFeedsBinding activityFeedsBinding6 = this.feedsBinding;
            if (activityFeedsBinding6 != null && (textView = activityFeedsBinding6.toolbartitleTV) != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
            }
            if (Helper.isTrishulThemeNew() && (activityFeedsBinding = this.feedsBinding) != null && (imageView2 = activityFeedsBinding.imageBack) != null) {
                imageView2.setColorFilter(ContextCompat.getColor(this, R.color.white));
            }
            if (this.show_all_post) {
                ActivityFeedsBinding activityFeedsBinding7 = this.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding7);
                activityFeedsBinding7.titleinnerRL.setVisibility(8);
                getPostData();
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05703(null), 3, null);
            setObservers();
            ActivityFeedsBinding activityFeedsBinding8 = this.feedsBinding;
            if (activityFeedsBinding8 != null && (recyclerView = activityFeedsBinding8.feedRecyerlview) != null) {
                this.feedAdapter = new FeedAdapter(this);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(this.feedAdapter);
            }
            ActivityFeedsBinding activityFeedsBinding9 = this.feedsBinding;
            if (activityFeedsBinding9 != null && (nestedScrollView = activityFeedsBinding9.nestedScroll) != null) {
                nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda0
                    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                    public final void onScrollChange(NestedScrollView nestedScrollView2, int i, int i2, int i3, int i4) {
                        FeedsActivity.onCreate$lambda$3(this.f$0, nestedScrollView2, i, i2, i3, i4);
                    }
                });
            }
            ActivityFeedsBinding activityFeedsBinding10 = this.feedsBinding;
            if (activityFeedsBinding10 != null && (imageView = activityFeedsBinding10.pinedPost) != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedsActivity.onCreate$lambda$6(this.f$0, view);
                    }
                });
            }
            ActivityFeedsBinding activityFeedsBinding11 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding11);
            activityFeedsBinding11.filter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedsActivity.onCreate$lambda$7(this.f$0);
                }
            }));
            ActivityFeedsBinding activityFeedsBinding12 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding12);
            activityFeedsBinding12.imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsActivity.onCreate$lambda$8(this.f$0, view);
                }
            });
            Button button = this.backBtn;
            Intrinsics.checkNotNull(button);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.finish();
                }
            });
            ActivityFeedsBinding activityFeedsBinding13 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding13);
            activityFeedsBinding13.titleinnerRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsActivity.onCreate$lambda$10(this.f$0, view);
                }
            });
            ActivityFeedsBinding activityFeedsBinding14 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding14);
            activityFeedsBinding14.pulltoReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda18
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    FeedsActivity.onCreate$lambda$11(this.f$0);
                }
            });
        } catch (Exception e2) {
            getFeedViewModel().getProgressvalue().setValue("0");
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedsActivity$onCreate$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$onCreate$3", f = "FeedsActivity.kt", i = {0}, l = {241}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
    static final class C05703 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C05703(Continuation<? super C05703> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedsActivity.this.new C05703(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05703) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Exception exc;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    if (FeedsActivity.this.getUtkashRoom().getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                        FeedsActivity.this.manageData();
                    } else {
                        FeedsActivity feedsActivity = FeedsActivity.this;
                        FeedsActivity feedsActivity2 = FeedsActivity.this;
                        feedsActivity.setNetworkCall(new NetworkCall(feedsActivity2, feedsActivity2));
                        NetworkCall networkCall = FeedsActivity.this.getNetworkCall();
                        Intrinsics.checkNotNull(networkCall);
                        networkCall.NetworkAPICall(API.master_content, "", true, false);
                    }
                } catch (Exception e2) {
                    this.L$0 = e2;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(FeedsActivity.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    exc = e2;
                    exc.printStackTrace();
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            exc = (Exception) this.L$0;
            ResultKt.throwOnFailure(obj);
            exc.printStackTrace();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedsActivity$onCreate$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: FeedsActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$onCreate$3$1", f = "FeedsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FeedsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(FeedsActivity feedsActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = feedsActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
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
                this.this$0.getFeedViewModel().getProgressvalue().setValue("0");
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(FeedsActivity feedsActivity, NestedScrollView v, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (i2 == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight() && feedsActivity.loading && feedsActivity.limitdata <= feedsActivity.datalist.size() && Helper.isConnected(feedsActivity)) {
            feedsActivity.showProgressView();
            feedsActivity.page++;
            feedsActivity.createApiBodyData();
            feedsActivity.loading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(FeedsActivity feedsActivity, View view) {
        FeedsActivity feedsActivity2 = feedsActivity;
        if (Helper.isNetworkConnected(feedsActivity2)) {
            Intent intent = new Intent(feedsActivity2, (Class<?>) PinnedPostActivity.class);
            intent.putExtra("maincat", feedsActivity.main_cat);
            intent.putExtra("mastercatid", feedsActivity.master_cat);
            intent.putExtra("subcatid", feedsActivity.sub_cat);
            Helper.gotoActivity(intent, feedsActivity);
            return;
        }
        Helper.showInternetToast(feedsActivity2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$7(FeedsActivity feedsActivity) {
        FeedsActivity feedsActivity2 = feedsActivity;
        if (Helper.isNetworkConnected(feedsActivity2)) {
            feedsActivity.filterDailog();
        } else {
            Helper.showInternetToast(feedsActivity2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$8(FeedsActivity feedsActivity, View view) {
        SharedPreference.getInstance().putBoolean("show_feeds", false);
        if (Constants.RELOADDASHBOARD.equals("true")) {
            Constants.RELOADDASHBOARD = "false";
            if (StringsKt.equals("1", "6", true)) {
                feedsActivity.startActivity(new Intent(feedsActivity, (Class<?>) DashboardActivityTheme7.class).setFlags(268468224));
            } else if (StringsKt.equals("1", "7", true)) {
                feedsActivity.startActivity(new Intent(feedsActivity, (Class<?>) DashboardActivityTheme8.class).setFlags(268468224));
            } else if (StringsKt.equals("1", "1", true)) {
                feedsActivity.startActivity(new Intent(feedsActivity, (Class<?>) DashboardActivityTheme1.class).setFlags(268468224));
            } else if (StringsKt.equals("1", "2", true)) {
                feedsActivity.startActivity(new Intent(feedsActivity, (Class<?>) DashboardActivityTheme2.class).setFlags(268468224));
            } else if (StringsKt.equals("1", "5", true)) {
                feedsActivity.startActivity(new Intent(feedsActivity, (Class<?>) DashboardActivityTheme5.class).setFlags(268468224));
            }
            feedsActivity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
            return;
        }
        feedsActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$10(FeedsActivity feedsActivity, View view) {
        if (StringsKt.equals("1", "7", true) || StringsKt.equals(BuildConfig.FLAVOR, "KSRAnatomyClasses", true)) {
            return;
        }
        FeedsActivity feedsActivity2 = feedsActivity;
        if (!Helper.isNetworkConnected(feedsActivity2)) {
            Helper.showInternetToast(feedsActivity2);
            return;
        }
        PopupWindow popupWindow = feedsActivity.popUp;
        Intrinsics.checkNotNull(popupWindow);
        ActivityFeedsBinding activityFeedsBinding = feedsActivity.feedsBinding;
        Intrinsics.checkNotNull(activityFeedsBinding);
        popupWindow.showAsDropDown(activityFeedsBinding.titleinnerRL, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$11(FeedsActivity feedsActivity) {
        FeedsActivity feedsActivity2 = feedsActivity;
        if (Helper.isConnected(feedsActivity2)) {
            if (!feedsActivity.response_booelan) {
                feedsActivity.response_booelan = true;
                FeedAdapter feedAdapter = feedsActivity.feedAdapter;
                Intrinsics.checkNotNull(feedAdapter);
                if (feedAdapter.getTimer() != null) {
                    FeedAdapter feedAdapter2 = feedsActivity.feedAdapter;
                    Intrinsics.checkNotNull(feedAdapter2);
                    Timer timer = feedAdapter2.getTimer();
                    Intrinsics.checkNotNull(timer);
                    timer.cancel();
                    FeedAdapter feedAdapter3 = feedsActivity.feedAdapter;
                    Intrinsics.checkNotNull(feedAdapter3);
                    Timer timer2 = feedAdapter3.getTimer();
                    Intrinsics.checkNotNull(timer2);
                    timer2.purge();
                }
                feedsActivity.posttypename = "All";
                feedsActivity.posttypeid = "0";
                feedsActivity.isPullToRefresh = true;
                feedsActivity.isPullToRefreshMessage = true;
                ActivityFeedsBinding activityFeedsBinding = feedsActivity.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding);
                activityFeedsBinding.filter.setImageResource(R.mipmap.filter_icon);
                ActivityFeedsBinding activityFeedsBinding2 = feedsActivity.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding2);
                activityFeedsBinding2.pulltoReferesh.setRefreshing(false);
                feedsActivity.page = 1;
                feedsActivity.sub_cat_name = "All";
                feedsActivity.sub_cat = "0";
                feedsActivity.section_posiiton = "0";
                feedsActivity.loading = true;
                feedsActivity.datalist.clear();
                feedsActivity.feedlist.clear();
                feedsActivity.posiitonwiselist.clear();
                feedsActivity.pinnedPostList.clear();
                feedsActivity.createApiBodyData();
                return;
            }
            ActivityFeedsBinding activityFeedsBinding3 = feedsActivity.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding3);
            activityFeedsBinding3.pulltoReferesh.setRefreshing(false);
            return;
        }
        Toast.makeText(feedsActivity2, "No Internet Connection", 0).show();
    }

    private final void getPostData() {
        FeedsActivity feedsActivity = this;
        if (Helper.isConnected(feedsActivity)) {
            if (!this.response_booelan) {
                this.response_booelan = true;
                this.posttypename = "All";
                this.posttypeid = "0";
                ActivityFeedsBinding activityFeedsBinding = this.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding);
                activityFeedsBinding.filter.setImageResource(R.mipmap.filter_icon);
                ActivityFeedsBinding activityFeedsBinding2 = this.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding2);
                activityFeedsBinding2.pulltoReferesh.setRefreshing(false);
                this.main_cat = "0";
                this.master_cat = "0";
                this.sub_cat = "0";
                this.section_posiiton = "0";
                this.page = 1;
                this.post_type = "5";
                this.type = "2";
                this.temp = "2";
                this.sub_cat_name = "All";
                createApiBodyData();
                return;
            }
            ActivityFeedsBinding activityFeedsBinding3 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding3);
            activityFeedsBinding3.pulltoReferesh.setRefreshing(false);
            return;
        }
        Toast.makeText(feedsActivity, "No Internet Connection", 0).show();
    }

    private final void filterDailog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.videosheetDialogTheme);
        bottomSheetDialog.setContentView(R.layout.feed_filter);
        ((Window) Objects.requireNonNull(bottomSheetDialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.cancel);
        Button button = (Button) bottomSheetDialog.findViewById(R.id.filterdata);
        final RelativeLayout relativeLayout = (RelativeLayout) bottomSheetDialog.findViewById(R.id.subcat);
        final RelativeLayout relativeLayout2 = (RelativeLayout) bottomSheetDialog.findViewById(R.id.posttype);
        TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.txt2);
        this.posttypeytext = (TextView) bottomSheetDialog.findViewById(R.id.posttypeytext);
        TextView textView2 = (TextView) bottomSheetDialog.findViewById(R.id.subcatspinner);
        this.subcatspinner = textView2;
        Intrinsics.checkNotNull(textView2);
        textView2.setText(this.sub_cat_name);
        if (this.posttypelist.size() > 0) {
            if (this.posttypeid.equals("0")) {
                TextView textView3 = this.posttypeytext;
                Intrinsics.checkNotNull(textView3);
                textView3.setText(this.posttypelist.get(0).getTitle());
                this.posttypename = this.posttypelist.get(0).getTitle();
                this.posttypeid = this.posttypelist.get(0).getId();
            } else {
                TextView textView4 = this.posttypeytext;
                Intrinsics.checkNotNull(textView4);
                textView4.setText(this.posttypename);
            }
        }
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsActivity.filterDailog$lambda$12(this.f$0, relativeLayout, view);
            }
        });
        if (StringsKt.equals("1", "7", true) || StringsKt.equals(BuildConfig.FLAVOR, "KSRAnatomyClasses", true)) {
            relativeLayout.setVisibility(8);
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
        }
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsActivity.filterDailog$lambda$13(this.f$0, relativeLayout2, view);
            }
        });
        TextView textView5 = this.posttypeytext;
        Intrinsics.checkNotNull(textView5);
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsActivity.filterDailog$lambda$14(this.f$0, relativeLayout2, view);
            }
        });
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsActivity.filterDailog$lambda$15(this.f$0, bottomSheetDialog, view);
            }
        });
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsActivity.filterDailog$lambda$16(this.f$0, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FeedsActivity.filterDailog$lambda$17(this.f$0, dialogInterface);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$12(FeedsActivity feedsActivity, RelativeLayout relativeLayout, View view) {
        PopupMenu popupMenu = new PopupMenu(feedsActivity, relativeLayout, 3);
        popupMenu.getMenu().add("All");
        int size = feedsActivity.selectedsub_all_cat.size();
        for (int i = 0; i < size; i++) {
            popupMenu.getMenu().add(feedsActivity.selectedsub_all_cat.get(i).getName());
        }
        popupMenu.setOnMenuItemClickListener(feedsActivity);
        popupMenu.show();
        feedsActivity.type_subcatfilter = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$13(FeedsActivity feedsActivity, RelativeLayout relativeLayout, View view) {
        PopupMenu popupMenu = new PopupMenu(feedsActivity, relativeLayout, 3);
        int size = feedsActivity.posttypelist.size();
        for (int i = 0; i < size; i++) {
            popupMenu.getMenu().add(feedsActivity.posttypelist.get(i).getTitle());
        }
        popupMenu.setOnMenuItemClickListener(feedsActivity);
        popupMenu.show();
        feedsActivity.type_posttypefilter = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$14(FeedsActivity feedsActivity, RelativeLayout relativeLayout, View view) {
        PopupMenu popupMenu = new PopupMenu(feedsActivity, relativeLayout, 3);
        int size = feedsActivity.posttypelist.size();
        for (int i = 0; i < size; i++) {
            popupMenu.getMenu().add(feedsActivity.posttypelist.get(i).getTitle());
        }
        popupMenu.setOnMenuItemClickListener(feedsActivity);
        popupMenu.show();
        feedsActivity.type_posttypefilter = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$15(FeedsActivity feedsActivity, BottomSheetDialog bottomSheetDialog, View view) {
        feedsActivity.type_subcatfilter = false;
        feedsActivity.type_posttypefilter = false;
        feedsActivity.sub_cat_filter = "";
        feedsActivity.sub_cat_name_filter = "";
        feedsActivity.is_filterbutton = false;
        bottomSheetDialog.dismiss();
        bottomSheetDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$16(FeedsActivity feedsActivity, BottomSheetDialog bottomSheetDialog, View view) {
        feedsActivity.getFeedViewModel().getProgressvalue().setValue("1");
        FeedAdapter feedAdapter = feedsActivity.feedAdapter;
        Intrinsics.checkNotNull(feedAdapter);
        if (feedAdapter.getTimer() != null) {
            FeedAdapter feedAdapter2 = feedsActivity.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter2);
            Timer timer = feedAdapter2.getTimer();
            Intrinsics.checkNotNull(timer);
            timer.cancel();
            FeedAdapter feedAdapter3 = feedsActivity.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter3);
            Timer timer2 = feedAdapter3.getTimer();
            Intrinsics.checkNotNull(timer2);
            timer2.purge();
        }
        if (feedsActivity.sub_cat_filter.length() > 0) {
            feedsActivity.sub_cat = feedsActivity.sub_cat_filter;
            feedsActivity.sub_cat_name = feedsActivity.sub_cat_name_filter;
        }
        ActivityFeedsBinding activityFeedsBinding = feedsActivity.feedsBinding;
        Intrinsics.checkNotNull(activityFeedsBinding);
        ImageView imageView = activityFeedsBinding.filter;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageResource(R.mipmap.filter_icon_tick);
        feedsActivity.page = 1;
        feedsActivity.sub_cat_filter = "";
        feedsActivity.sub_cat_name_filter = "";
        feedsActivity.datalist.clear();
        feedsActivity.feedlist.clear();
        feedsActivity.posiitonwiselist.clear();
        feedsActivity.pinnedPostList.clear();
        feedsActivity.is_filterbutton = true;
        feedsActivity.createApiBodyData();
        bottomSheetDialog.dismiss();
        bottomSheetDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$17(FeedsActivity feedsActivity, DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        dialogInterface.cancel();
        feedsActivity.type_subcatfilter = false;
        feedsActivity.type_posttypefilter = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void local_data(boolean filter) {
        if (this.sub_cat.equals("0")) {
            if (filter) {
                this.feedParentData = this.utkashRoom.getFeedDao().retrievePostData_viaposttype_withoutsubcat(this.master_cat, this.main_cat, this.posttypeid);
            } else {
                this.feedParentData = this.utkashRoom.getFeedDao().retrievePostData_withoutsubcat(this.master_cat, this.main_cat);
            }
        } else if (filter) {
            this.feedParentData = this.utkashRoom.getFeedDao().retrievePostData_viaposttype(this.master_cat, this.main_cat, this.sub_cat, this.posttypeid);
        } else {
            this.feedParentData = this.utkashRoom.getFeedDao().retrievePostData(this.master_cat, this.main_cat, this.sub_cat);
        }
        if (!this.feedParentData.isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05671(null), 3, null);
            RelativeLayout relativeLayout = this.no_data_found_RL;
            Intrinsics.checkNotNull(relativeLayout);
            if (relativeLayout.getVisibility() == 0) {
                RelativeLayout relativeLayout2 = this.no_data_found_RL;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(8);
                ActivityFeedsBinding activityFeedsBinding = this.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding);
                activityFeedsBinding.pulltoReferesh.setVisibility(0);
            }
            String sectionposiiton = this.feedParentData.get(0).getSectionposiiton();
            this.section_posiiton = sectionposiiton;
            if (sectionposiiton.equals("")) {
                this.section_posiiton = "0";
            }
            List<PostDataTable> list = this.feedParentData;
            this.page = Integer.parseInt(list.get(list.size() - 1).getPage());
            List<PostDataTable> list2 = this.feedParentData;
            this.limitdata = Integer.parseInt(list2.get(list2.size() - 1).getLimit());
            Iterator<PostDataTable> it = this.feedParentData.iterator();
            while (it.hasNext()) {
                PostDataTable next = it.next();
                String created = next.getCreated();
                String id = next.getId();
                Object objFromJson = new Gson().fromJson(next.getJson(), new TypeToken<Json>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$local_data$data$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                Json json = (Json) objFromJson;
                String meta_url = next.getMeta_url();
                String link_type = next.getLink_type();
                String thumbnail = next.getThumbnail();
                String url = next.getUrl();
                String modified = next.getModified();
                String my_like = next.getMy_like();
                String name = next.getName();
                String post_type = next.getPost_type();
                String profile_picture = next.getProfile_picture();
                String status = next.getStatus();
                String sub_cat_id = next.getSub_cat_id();
                String text = next.getText();
                String total_comments = next.getTotal_comments();
                String total_likes = next.getTotal_likes();
                String user_id = next.getUser_id();
                Iterator<PostDataTable> it2 = it;
                List list3 = (List) new Gson().fromJson(next.getNewCourseData(), new TypeToken<List<? extends NewCourseData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$local_data$data$2
                }.getType());
                List list4 = (List) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$local_data$data$3
                }.getType());
                List list5 = (List) new Gson().fromJson(next.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$local_data$data$4
                }.getType());
                List list6 = (List) new Gson().fromJson(next.getTestResult(), new TypeToken<List<? extends TestResult>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$local_data$data$5
                }.getType());
                List list7 = (List) new Gson().fromJson(next.getBannerlist(), new TypeToken<List<? extends BannerData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$local_data$data$6
                }.getType());
                String iscommentenable = next.getIscommentenable();
                String my_pinned = next.getMy_pinned();
                String str = my_pinned == null ? "0" : my_pinned;
                String description = next.getDescription();
                String str2 = description == null ? "" : description;
                String parentId = next.getParentId();
                String masterCat = next.getMasterCat();
                String sub_cat_id2 = next.getSub_cat_id();
                String schedule_date = next.getSchedule_date();
                Intrinsics.checkNotNull(schedule_date);
                com.appnew.android.feeds.dataclass.Data data = new com.appnew.android.feeds.dataclass.Data(false, created, id, json, meta_url, link_type, thumbnail, url, modified, my_like, name, post_type, profile_picture, status, sub_cat_id, text, total_comments, total_likes, user_id, list3, list4, list5, list6, list7, iscommentenable, null, 0, str, str2, parentId, masterCat, sub_cat_id2, schedule_date, null, 100663296, 2, null);
                if (TextUtils.isEmpty(data.getSchedule_date()) || Long.parseLong(data.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                    this.datalist.add(data);
                }
                if (Intrinsics.areEqual(next.getLiveClassStatus(), "1")) {
                    this.liveClassData = (ArrayList) new Gson().fromJson(next.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity.local_data.2
                    }.getType());
                }
                if (Intrinsics.areEqual(next.getLiveTestStatus(), "1")) {
                    this.liveTestData = (ArrayList) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity.local_data.3
                    }.getType());
                }
                it = it2;
            }
        } else {
            this.page = 1;
        }
        if (this.datalist.size() > 0) {
            getFeedViewModel().getProgressvalue().setValue("0");
            FeedAdapter feedAdapter = this.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter);
            this.posiitonwiselist.clear();
            this.pinnedPostList.clear();
            this.feedlist.clear();
            Iterator<com.appnew.android.feeds.dataclass.Data> it3 = this.datalist.iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                com.appnew.android.feeds.dataclass.Data next2 = it3.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                com.appnew.android.feeds.dataclass.Data data2 = next2;
                if (data2.getPost_type().equals("1090") || data2.getPost_type().equals("1091") || data2.getPost_type().equals("1092") || data2.getPost_type().equals("1093")) {
                    this.posiitonwiselist.add(data2);
                } else {
                    this.feedlist.add(data2);
                }
            }
            this.datalist.clear();
            this.datalist.addAll(this.feedlist);
            this.feedlist.clear();
            if (this.datalist.size() > Integer.parseInt(this.section_posiiton)) {
                this.datalist.addAll(Integer.parseInt(this.section_posiiton) + 1, this.posiitonwiselist);
            } else {
                this.datalist.addAll(this.posiitonwiselist);
            }
            this.posiitonwiselist.clear();
            this.pinnedPostList.clear();
            feedAdapter.addFeed(this.datalist);
            feedAdapter.notifyDataSetChanged();
            return;
        }
        createApiBodyData();
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedsActivity$local_data$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$local_data$1", f = "FeedsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05671(Continuation<? super C05671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedsActivity.this.new C05671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FeedsActivity.this.getPosttypelist().clear();
            if (SharedPreference.getInstance().getString(Const.POST_TYPE) != null) {
                String string = SharedPreference.getInstance().getString(Const.POST_TYPE);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (string.length() > 0) {
                    JSONArray jSONArray = new JSONArray(SharedPreference.getInstance().getString(Const.POST_TYPE));
                    IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
                    FeedsActivity feedsActivity = FeedsActivity.this;
                    Iterator<Integer> it = intRangeUntil.iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(((IntIterator) it).nextInt());
                        Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                        feedsActivity.getPosttypelist().add((PostType) new Gson().fromJson(jSONObjectOptJSONObject.toString(), PostType.class));
                    }
                    FeedsActivity.this.getPosttypelist().add(0, new PostType("0", "All"));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void createApiBodyData() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage(String.valueOf(this.page));
        encryptionData.setMaster_cat(this.master_cat);
        encryptionData.setMain_cat(this.main_cat);
        encryptionData.setPost_type(this.posttypeid);
        encryptionData.setSub_cat(this.sub_cat);
        getFeedViewModel().getBodydata().setValue(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    public final void setObservers() {
        FeedsActivity feedsActivity = this;
        getFeedViewModel().getProgressvalue().observe(feedsActivity, new FeedsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsActivity.setObservers$lambda$19(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getBodydata().observe(feedsActivity, new FeedsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsActivity.setObservers$lambda$20(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getAdapter_bodydata().observe(feedsActivity, new FeedsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsActivity.setObservers$lambda$21(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getAdapter_response().observe(feedsActivity, new FeedsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsActivity.setObservers$lambda$29(this.f$0, (JSONObject) obj);
            }
        }));
        getFeedViewModel().getJsonObjectmutable().observe(feedsActivity, new FeedsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsActivity.setObservers$lambda$35(this.f$0, (JSONObject) obj);
            }
        }));
        getFeedViewModel().getMutableLiveClassData().observe(feedsActivity, new FeedsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsActivity.setObservers$lambda$36(this.f$0, (JSONObject) obj);
            }
        }));
        getFeedViewModel().getMutableLiveTestData().observe(feedsActivity, new FeedsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsActivity.setObservers$lambda$38(this.f$0, (JSONObject) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$19(FeedsActivity feedsActivity, String str) {
        if (str.equals("0")) {
            Helper.dismissProgressDialog();
        } else {
            Helper.showProgressDialog(feedsActivity);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$20(FeedsActivity feedsActivity, String str) {
        if (str != null) {
            feedsActivity.getFeedViewModel().getFeedData();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit setObservers$lambda$21(com.appnew.android.feeds.activity.FeedsActivity r1, java.lang.String r2) {
        /*
            if (r2 == 0) goto L77
            com.appnew.android.feeds.viewmodel.FeedViewModel r2 = r1.getFeedViewModel()
            androidx.lifecycle.MutableLiveData r2 = r2.getType()
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L77
            int r0 = r2.hashCode()
            switch(r0) {
                case -314243511: goto L67;
                case -171309688: goto L56;
                case 80245: goto L45;
                case 2368439: goto L34;
                case 81887292: goto L2b;
                case 557130398: goto L1a;
                default: goto L19;
            }
        L19:
            goto L77
        L1a:
            java.lang.String r0 = "AddComment"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L23
            goto L77
        L23:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
            goto L77
        L2b:
            java.lang.String r0 = "Unpin"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L4e
            goto L77
        L34:
            java.lang.String r0 = "Like"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3d
            goto L77
        L3d:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
            goto L77
        L45:
            java.lang.String r0 = "Pin"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L4e
            goto L77
        L4e:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
            goto L77
        L56:
            java.lang.String r0 = "Attempt Mcq"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5f
            goto L77
        L5f:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
            goto L77
        L67:
            java.lang.String r0 = "GetComment"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L70
            goto L77
        L70:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
        L77:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.activity.FeedsActivity.setObservers$lambda$21(com.appnew.android.feeds.activity.FeedsActivity, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc A[Catch: Exception -> 0x00e7, TryCatch #0 {Exception -> 0x00e7, blocks: (B:4:0x0006, B:6:0x0014, B:8:0x0024, B:12:0x0031, B:15:0x003b, B:17:0x0043, B:18:0x004b, B:21:0x0055, B:22:0x006c, B:25:0x0076, B:26:0x0080, B:29:0x0089, B:30:0x009f, B:33:0x00a8, B:34:0x00b1, B:37:0x00ba, B:38:0x00cc, B:40:0x00d7, B:42:0x00de), top: B:48:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit setObservers$lambda$29(com.appnew.android.feeds.activity.FeedsActivity r5, org.json.JSONObject r6) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.activity.FeedsActivity.setObservers$lambda$29(com.appnew.android.feeds.activity.FeedsActivity, org.json.JSONObject):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$35(FeedsActivity feedsActivity, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        int i;
        int i2;
        JSONObject jSONObject5;
        long jOptLong;
        JSONObject jSONObject6;
        if (jSONObject != null) {
            feedsActivity.hideProgressView();
            feedsActivity.response_booelan = false;
            if (Intrinsics.areEqual(jSONObject.optString("status"), "true")) {
                JSONObject jSONObject7 = jSONObject.getJSONObject("data");
                Intrinsics.checkNotNullExpressionValue(jSONObject7, "getJSONObject(...)");
                feedsActivity.feedJsonObject = jSONObject7;
                if (jSONObject7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                    jSONObject2 = null;
                } else {
                    jSONObject2 = jSONObject7;
                }
                JSONArray jSONArray = jSONObject2.getJSONArray(Const.posts);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                if (jSONArray.length() > 0) {
                    RelativeLayout relativeLayout = feedsActivity.no_data_found_RL;
                    Intrinsics.checkNotNull(relativeLayout);
                    if (relativeLayout.getVisibility() == 0) {
                        RelativeLayout relativeLayout2 = feedsActivity.no_data_found_RL;
                        Intrinsics.checkNotNull(relativeLayout2);
                        relativeLayout2.setVisibility(8);
                        ActivityFeedsBinding activityFeedsBinding = feedsActivity.feedsBinding;
                        Intrinsics.checkNotNull(activityFeedsBinding);
                        activityFeedsBinding.pulltoReferesh.setVisibility(0);
                    }
                    if (feedsActivity.isPullToRefresh) {
                        feedsActivity.limitdata = 0;
                    }
                    feedsActivity.limitdata += jSONObject.optInt(com.clevertap.android.sdk.Constants.KEY_LIMIT);
                    int i3 = feedsActivity.page;
                    boolean z = true;
                    if (i3 == 1) {
                        JSONObject jSONObject8 = feedsActivity.feedJsonObject;
                        if (jSONObject8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject8 = null;
                        }
                        if (jSONObject8.has(Const.POST_TYPE)) {
                            JSONObject jSONObject9 = feedsActivity.feedJsonObject;
                            if (jSONObject9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                                jSONObject9 = null;
                            }
                            JSONArray jSONArray2 = jSONObject9.getJSONArray(Const.POST_TYPE);
                            Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
                            SharedPreference.getInstance().putString(Const.POST_TYPE, jSONArray2.toString());
                            feedsActivity.posttypelist.clear();
                            Iterator<Integer> it = RangesKt.until(0, jSONArray2.length()).iterator();
                            while (it.hasNext()) {
                                JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(((IntIterator) it).nextInt());
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                                feedsActivity.posttypelist.add((PostType) new Gson().fromJson(jSONObjectOptJSONObject.toString(), PostType.class));
                                z = z;
                            }
                        }
                        feedsActivity.posttypelist.add(0, new PostType("", "All"));
                        if (feedsActivity.isPullToRefresh) {
                            if (feedsActivity.refreshCount >= 2) {
                                feedsActivity.utkashRoom.getFeedDao().deletePosts_via_id(feedsActivity.main_cat);
                            } else {
                                feedsActivity.utkashRoom.getFeedDao().deleteSubCatFeed(feedsActivity.main_cat, feedsActivity.sub_cat, "1092", "1093");
                            }
                        }
                        JSONObject jSONObject10 = feedsActivity.feedJsonObject;
                        if (jSONObject10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject10 = null;
                        }
                        if (jSONObject10.has("section_position")) {
                            JSONObject jSONObject11 = feedsActivity.feedJsonObject;
                            if (jSONObject11 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                                jSONObject11 = null;
                            }
                            feedsActivity.section_posiiton = jSONObject11.optString("section_position");
                        }
                        JSONObject jSONObject12 = feedsActivity.feedJsonObject;
                        if (jSONObject12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject12 = null;
                        }
                        JSONArray jSONArray3 = jSONObject12.getJSONArray(Const.banners);
                        Intrinsics.checkNotNullExpressionValue(jSONArray3, "getJSONArray(...)");
                        feedsActivity.bannert_list.clear();
                        feedsActivity.datalist.clear();
                        feedsActivity.newCourseData.clear();
                        feedsActivity.testResultList.clear();
                        feedsActivity.posiitonwiselist.clear();
                        feedsActivity.feedlist.clear();
                        if (jSONArray3.length() > 0) {
                            int length = jSONArray3.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArray3.optJSONObject(i4);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(...)");
                                feedsActivity.bannert_list.add((BannerData) new Gson().fromJson(jSONObjectOptJSONObject2.toString(), BannerData.class));
                            }
                            Json json = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                            feedsActivity.datalist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json, "", "", "", "", "", "", "", "1089", "", "", "", "", "", "", "", feedsActivity.newCourseData, feedsActivity.liveTestData, feedsActivity.liveClassData, feedsActivity.testResultList, feedsActivity.bannert_list, "0", feedsActivity.section_posiiton, feedsActivity.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                            if (!feedsActivity.is_filterbutton) {
                                PostDataTable postDataTable = new PostDataTable();
                                postDataTable.setCreated("");
                                postDataTable.setId("");
                                postDataTable.setParentId(feedsActivity.master_cat);
                                postDataTable.setMasterCat(feedsActivity.main_cat);
                                postDataTable.setSub_cat_id(feedsActivity.sub_cat);
                                postDataTable.setJson(new Gson().toJson(json));
                                postDataTable.setMeta_url("");
                                postDataTable.setLink_type("");
                                postDataTable.setThumbnail("");
                                postDataTable.setUrl("");
                                postDataTable.setModified("");
                                postDataTable.setMy_like("");
                                postDataTable.setName("");
                                postDataTable.setPost_type("1089");
                                postDataTable.setProfile_picture("");
                                postDataTable.setStatus("");
                                postDataTable.setText("");
                                postDataTable.setTotal_comments("");
                                postDataTable.setTotal_likes("");
                                postDataTable.setUser_id("");
                                postDataTable.setNewCourseData(new Gson().toJson(feedsActivity.newCourseData));
                                postDataTable.setLivetest(new Gson().toJson(feedsActivity.liveTestData));
                                postDataTable.setLiveclass(new Gson().toJson(feedsActivity.liveClassData));
                                postDataTable.setTestResult(new Gson().toJson(feedsActivity.testResultList));
                                postDataTable.setBannerlist(new Gson().toJson(feedsActivity.bannert_list));
                                postDataTable.setLiveClassStatus("0");
                                postDataTable.setLiveTestStatus("0");
                                postDataTable.setPage(String.valueOf(feedsActivity.page));
                                postDataTable.setIscommentenable("0");
                                postDataTable.setSectionposiiton(feedsActivity.section_posiiton);
                                postDataTable.setLimit(String.valueOf(feedsActivity.limitdata));
                                postDataTable.setMy_pinned(feedsActivity.pinnedPost);
                                feedsActivity.utkashRoom.getFeedDao().insertPost(postDataTable);
                            }
                        }
                        if (feedsActivity.is_filterbutton) {
                            int length2 = jSONArray.length();
                            int i5 = 0;
                            while (i5 < length2) {
                                JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i5);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject3, "optJSONObject(...)");
                                com.appnew.android.feeds.dataclass.Data data = (com.appnew.android.feeds.dataclass.Data) new Gson().fromJson(jSONObjectOptJSONObject3.toString(), com.appnew.android.feeds.dataclass.Data.class);
                                if (TextUtils.isEmpty(data.getSchedule_date())) {
                                    jSONObject6 = jSONObject7;
                                    Boolean.valueOf(feedsActivity.datalist.add(data));
                                } else {
                                    jSONObject6 = jSONObject7;
                                    if (Long.parseLong(data.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                                        feedsActivity.datalist.add(data);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                                i5++;
                                jSONObject7 = jSONObject6;
                            }
                            jSONObject4 = jSONObject7;
                        } else {
                            jSONObject4 = jSONObject7;
                            int length3 = jSONArray.length();
                            int i6 = 0;
                            while (i6 < length3) {
                                JSONObject jSONObjectOptJSONObject4 = jSONArray.optJSONObject(i6);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject4, "optJSONObject(...)");
                                com.appnew.android.feeds.dataclass.Data data2 = (com.appnew.android.feeds.dataclass.Data) new Gson().fromJson(jSONObjectOptJSONObject4.toString(), com.appnew.android.feeds.dataclass.Data.class);
                                if (TextUtils.isEmpty(data2.getSchedule_date())) {
                                    i = length3;
                                    i2 = i6;
                                    Boolean.valueOf(feedsActivity.datalist.add(data2));
                                } else {
                                    i = length3;
                                    i2 = i6;
                                    if (Long.parseLong(data2.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                                        feedsActivity.datalist.add(data2);
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                PostDataTable postDataTable2 = new PostDataTable();
                                postDataTable2.setCreated(data2.getCreated());
                                postDataTable2.setId(data2.getId());
                                postDataTable2.setJson(new Gson().toJson(data2.getJson()));
                                postDataTable2.setMeta_url(data2.getMeta_url());
                                postDataTable2.setLink_type(data2.getLink_type());
                                postDataTable2.setThumbnail(data2.getThumbnail());
                                String url = data2.getUrl();
                                if (url == null) {
                                    url = "";
                                }
                                postDataTable2.setUrl(url);
                                postDataTable2.setModified(data2.getModified());
                                postDataTable2.setMy_like(data2.getMy_like());
                                String name = data2.getName();
                                if (name == null) {
                                    name = "";
                                }
                                postDataTable2.setName(name);
                                postDataTable2.setPost_type(data2.getPost_type());
                                String profile_picture = data2.getProfile_picture();
                                if (profile_picture == null) {
                                    profile_picture = "";
                                }
                                postDataTable2.setProfile_picture(profile_picture);
                                postDataTable2.setStatus(data2.getStatus());
                                postDataTable2.setParentId(feedsActivity.master_cat);
                                postDataTable2.setMasterCat(feedsActivity.main_cat);
                                postDataTable2.setSub_cat_id(feedsActivity.sub_cat);
                                postDataTable2.setText(data2.getText());
                                postDataTable2.setTotal_comments(data2.getTotal_comments());
                                postDataTable2.setTotal_likes(data2.getTotal_likes());
                                postDataTable2.setUser_id(data2.getUser_id());
                                Gson gson = new Gson();
                                List<NewCourseData> newCourseData = data2.getNewCourseData();
                                if (newCourseData == null) {
                                    newCourseData = CollectionsKt.emptyList();
                                }
                                postDataTable2.setNewCourseData(gson.toJson(newCourseData));
                                postDataTable2.setLivetest(new Gson().toJson(data2.getLivetest()));
                                postDataTable2.setLiveclass(new Gson().toJson(data2.getLiveclass()));
                                Gson gson2 = new Gson();
                                List<TestResult> testResult = data2.getTestResult();
                                if (testResult == null) {
                                    testResult = CollectionsKt.emptyList();
                                }
                                postDataTable2.setTestResult(gson2.toJson(testResult));
                                Gson gson3 = new Gson();
                                List<BannerData> bannerlist = data2.getBannerlist();
                                if (bannerlist == null) {
                                    bannerlist = CollectionsKt.emptyList();
                                }
                                postDataTable2.setBannerlist(gson3.toJson(bannerlist));
                                postDataTable2.setLiveClassStatus("0");
                                postDataTable2.setLiveTestStatus("0");
                                postDataTable2.setPage(String.valueOf(feedsActivity.page));
                                postDataTable2.setIscommentenable(data2.getIs_comment_enable());
                                postDataTable2.setSectionposiiton(feedsActivity.section_posiiton);
                                postDataTable2.setLimit(String.valueOf(feedsActivity.limitdata));
                                postDataTable2.setMy_pinned(data2.getMy_pinned());
                                postDataTable2.setDescription(data2.getDescription());
                                postDataTable2.setSchedule_date(data2.getSchedule_date());
                                feedsActivity.utkashRoom.getFeedDao().insertPost(postDataTable2);
                                i6 = i2 + 1;
                                length3 = i;
                            }
                        }
                        JSONObject jSONObject13 = feedsActivity.feedJsonObject;
                        if (jSONObject13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject13 = null;
                        }
                        JSONArray jSONArray4 = jSONObject13.getJSONArray("new_courses");
                        Intrinsics.checkNotNullExpressionValue(jSONArray4, "getJSONArray(...)");
                        if (jSONArray4.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            int length4 = jSONArray4.length();
                            for (int i7 = 0; i7 < length4; i7++) {
                                JSONObject jSONObjectOptJSONObject5 = jSONArray4.optJSONObject(i7);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject5, "optJSONObject(...)");
                                feedsActivity.newCourseData.add((NewCourseData) new Gson().fromJson(jSONObjectOptJSONObject5.toString(), NewCourseData.class));
                            }
                            Json json2 = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                            feedsActivity.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json2, "", "", "", "", "", "", "", "1090", "", "", "", "", "", "", "", feedsActivity.newCourseData, feedsActivity.liveTestData, feedsActivity.liveClassData, feedsActivity.testResultList, arrayList, "0", feedsActivity.section_posiiton, feedsActivity.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                            if (!feedsActivity.is_filterbutton) {
                                PostDataTable postDataTable3 = new PostDataTable();
                                postDataTable3.setCreated("");
                                postDataTable3.setId("");
                                postDataTable3.setJson(new Gson().toJson(json2));
                                postDataTable3.setMeta_url("");
                                postDataTable3.setLink_type("");
                                postDataTable3.setThumbnail("");
                                postDataTable3.setUrl("");
                                postDataTable3.setModified("");
                                postDataTable3.setMy_like("");
                                postDataTable3.setName("");
                                postDataTable3.setPost_type("1090");
                                postDataTable3.setProfile_picture("");
                                postDataTable3.setStatus("");
                                postDataTable3.setParentId(feedsActivity.master_cat);
                                postDataTable3.setMasterCat(feedsActivity.main_cat);
                                postDataTable3.setSub_cat_id(feedsActivity.sub_cat);
                                postDataTable3.setText("");
                                postDataTable3.setTotal_comments("");
                                postDataTable3.setTotal_likes("");
                                postDataTable3.setUser_id("");
                                postDataTable3.setNewCourseData(new Gson().toJson(feedsActivity.newCourseData));
                                postDataTable3.setLivetest(new Gson().toJson(feedsActivity.liveTestData));
                                postDataTable3.setLiveclass(new Gson().toJson(feedsActivity.liveClassData));
                                postDataTable3.setTestResult(new Gson().toJson(feedsActivity.testResultList));
                                postDataTable3.setBannerlist(new Gson().toJson(arrayList));
                                postDataTable3.setLiveClassStatus("0");
                                postDataTable3.setLiveTestStatus("0");
                                postDataTable3.setPage(String.valueOf(feedsActivity.page));
                                postDataTable3.setIscommentenable("0");
                                postDataTable3.setSectionposiiton(feedsActivity.section_posiiton);
                                postDataTable3.setLimit(String.valueOf(feedsActivity.limitdata));
                                postDataTable3.setMy_pinned(feedsActivity.pinnedPost);
                                feedsActivity.utkashRoom.getFeedDao().insertPost(postDataTable3);
                            }
                        }
                        JSONObject jSONObject14 = feedsActivity.feedJsonObject;
                        if (jSONObject14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject5 = null;
                        } else {
                            jSONObject5 = jSONObject14;
                        }
                        JSONArray jSONArray5 = jSONObject5.getJSONArray("results");
                        Intrinsics.checkNotNullExpressionValue(jSONArray5, "getJSONArray(...)");
                        if (jSONArray5.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            int length5 = jSONArray5.length();
                            for (int i8 = 0; i8 < length5; i8++) {
                                JSONObject jSONObjectOptJSONObject6 = jSONArray5.optJSONObject(i8);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject6, "optJSONObject(...)");
                                feedsActivity.testResultList.add((TestResult) new Gson().fromJson(jSONObjectOptJSONObject6.toString(), TestResult.class));
                            }
                            Json json3 = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                            feedsActivity.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json3, "", "", "", "", "", "", "", "1091", "", "", "", "", "", "", "", arrayList3, feedsActivity.liveTestData, feedsActivity.liveClassData, feedsActivity.testResultList, arrayList2, "0", feedsActivity.section_posiiton, feedsActivity.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                            if (!feedsActivity.is_filterbutton) {
                                PostDataTable postDataTable4 = new PostDataTable();
                                postDataTable4.setCreated("");
                                postDataTable4.setId("");
                                postDataTable4.setJson(new Gson().toJson(json3));
                                postDataTable4.setMeta_url("");
                                postDataTable4.setLink_type("");
                                postDataTable4.setThumbnail("");
                                postDataTable4.setUrl("");
                                postDataTable4.setModified("");
                                postDataTable4.setMy_like("");
                                postDataTable4.setName("");
                                postDataTable4.setPost_type("1091");
                                postDataTable4.setParentId(feedsActivity.master_cat);
                                postDataTable4.setMasterCat(feedsActivity.main_cat);
                                postDataTable4.setSub_cat_id(feedsActivity.sub_cat);
                                postDataTable4.setProfile_picture("");
                                postDataTable4.setStatus("");
                                postDataTable4.setText("");
                                postDataTable4.setTotal_comments("");
                                postDataTable4.setTotal_likes("");
                                postDataTable4.setUser_id("");
                                postDataTable4.setNewCourseData(new Gson().toJson(arrayList3));
                                postDataTable4.setLivetest(new Gson().toJson(feedsActivity.liveTestData));
                                postDataTable4.setLiveclass(new Gson().toJson(feedsActivity.liveClassData));
                                postDataTable4.setTestResult(new Gson().toJson(feedsActivity.testResultList));
                                postDataTable4.setBannerlist(new Gson().toJson(arrayList2));
                                postDataTable4.setLiveClassStatus("0");
                                postDataTable4.setLiveTestStatus("0");
                                postDataTable4.setPage(String.valueOf(feedsActivity.page));
                                postDataTable4.setIscommentenable("0");
                                postDataTable4.setSectionposiiton(feedsActivity.section_posiiton);
                                postDataTable4.setLimit(String.valueOf(feedsActivity.limitdata));
                                postDataTable4.setMy_pinned(feedsActivity.pinnedPost);
                                postDataTable4.setSchedule_date("");
                                feedsActivity.utkashRoom.getFeedDao().insertPost(postDataTable4);
                            }
                        }
                        JSONObject jSONObject15 = jSONObject4;
                        long jOptLong2 = jSONObject15.optLong("time") * ((long) 1000);
                        if (!feedsActivity.liveClassData.isEmpty()) {
                            jOptLong = feedsActivity.liveClassData.get(r1.size() - 1).getCd_time();
                        } else if (feedsActivity.liveTestData.isEmpty()) {
                            jOptLong = jSONObject15.optLong("cd_time");
                        } else {
                            jOptLong = feedsActivity.liveTestData.get(r1.size() - 1).getCd_time();
                        }
                        long minutes = TimeUnit.MILLISECONDS.toMinutes(jOptLong2 - jOptLong);
                        if (feedsActivity.isPullToRefresh) {
                            feedsActivity.isPullToRefresh = false;
                            int i9 = feedsActivity.refreshCount;
                            if (i9 == 2 || minutes >= 10) {
                                feedsActivity.refreshCount = 0;
                                feedsActivity.hitApiForLiveClass();
                            } else {
                                feedsActivity.refreshCount = i9 + 1;
                                ArrayList arrayList4 = new ArrayList();
                                ArrayList arrayList5 = new ArrayList();
                                if (feedsActivity.posttypeid.equals("0")) {
                                    List<PostDataTable> listRetrievePostData = feedsActivity.utkashRoom.getFeedDao().retrievePostData(feedsActivity.master_cat, feedsActivity.main_cat, feedsActivity.sub_cat);
                                    Intrinsics.checkNotNull(listRetrievePostData);
                                    feedsActivity.updatePostData(listRetrievePostData);
                                } else {
                                    List<PostDataTable> listRetrievePostData_viaposttype = feedsActivity.utkashRoom.getFeedDao().retrievePostData_viaposttype(feedsActivity.master_cat, feedsActivity.main_cat, feedsActivity.sub_cat, feedsActivity.posttypeid);
                                    Intrinsics.checkNotNull(listRetrievePostData_viaposttype);
                                    feedsActivity.updatePostData(listRetrievePostData_viaposttype);
                                }
                                if (!feedsActivity.liveClassData.isEmpty()) {
                                    feedsActivity.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", new Json("", arrayList5, "", "", "", "", "", "", ""), "", "", "", "", "", "", "1093", "", "", "", "", "", "", "", "", feedsActivity.newCourseData, feedsActivity.liveTestData, feedsActivity.liveClassData, feedsActivity.testResultList, arrayList4, "0", feedsActivity.section_posiiton, feedsActivity.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                                }
                                if (!feedsActivity.liveTestData.isEmpty()) {
                                    feedsActivity.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", new Json("", arrayList5, "", "", "", "", "", "", ""), "", "", "", "", "", "", "1092", "", "", "", "", "", "", "", "", feedsActivity.newCourseData, feedsActivity.liveTestData, feedsActivity.liveClassData, feedsActivity.testResultList, arrayList4, "0", feedsActivity.section_posiiton, feedsActivity.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                                }
                                FeedAdapter feedAdapter = feedsActivity.feedAdapter;
                                Intrinsics.checkNotNull(feedAdapter);
                                if (feedsActivity.datalist.size() > Integer.parseInt(feedsActivity.section_posiiton)) {
                                    feedsActivity.datalist.addAll(Integer.parseInt(feedsActivity.section_posiiton) + 1, feedsActivity.posiitonwiselist);
                                } else {
                                    feedsActivity.datalist.addAll(feedsActivity.posiitonwiselist);
                                }
                                feedsActivity.posiitonwiselist.clear();
                                feedsActivity.feedlist.clear();
                                feedAdapter.addFeed(feedsActivity.datalist);
                                feedAdapter.notifyDataSetChanged();
                                Unit unit3 = Unit.INSTANCE;
                            }
                        } else if (!feedsActivity.is_filterbutton) {
                            feedsActivity.hitApiForLiveClass();
                        } else {
                            FeedAdapter feedAdapter2 = feedsActivity.feedAdapter;
                            Intrinsics.checkNotNull(feedAdapter2);
                            if (feedsActivity.datalist.size() > Integer.parseInt(feedsActivity.section_posiiton)) {
                                feedsActivity.datalist.addAll(Integer.parseInt(feedsActivity.section_posiiton) + 1, feedsActivity.posiitonwiselist);
                            } else {
                                feedsActivity.datalist.addAll(feedsActivity.posiitonwiselist);
                            }
                            feedAdapter2.addFeed(feedsActivity.datalist);
                            feedAdapter2.notifyDataSetChanged();
                            Unit unit4 = Unit.INSTANCE;
                        }
                        if (feedsActivity.datalist.size() == 0) {
                            RelativeLayout relativeLayout3 = feedsActivity.no_data_found_RL;
                            Intrinsics.checkNotNull(relativeLayout3);
                            relativeLayout3.setVisibility(0);
                            ActivityFeedsBinding activityFeedsBinding2 = feedsActivity.feedsBinding;
                            Intrinsics.checkNotNull(activityFeedsBinding2);
                            activityFeedsBinding2.pulltoReferesh.setVisibility(8);
                        } else if (feedsActivity.isPullToRefreshMessage) {
                            feedsActivity.isPullToRefreshMessage = false;
                            Toast.makeText(feedsActivity, "No More Post Found", 0).show();
                        }
                    } else if (i3 > 1) {
                        feedsActivity.loading = true;
                        int length6 = jSONArray.length();
                        for (int i10 = 0; i10 < length6; i10++) {
                            JSONObject jSONObjectOptJSONObject7 = jSONArray.optJSONObject(i10);
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject7, "optJSONObject(...)");
                            com.appnew.android.feeds.dataclass.Data data3 = (com.appnew.android.feeds.dataclass.Data) new Gson().fromJson(jSONObjectOptJSONObject7.toString(), com.appnew.android.feeds.dataclass.Data.class);
                            if (TextUtils.isEmpty(data3.getSchedule_date())) {
                                Boolean.valueOf(feedsActivity.datalist.add(data3));
                            } else {
                                if (Long.parseLong(data3.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                                    feedsActivity.datalist.add(data3);
                                }
                                Unit unit5 = Unit.INSTANCE;
                            }
                        }
                        FeedAdapter feedAdapter3 = feedsActivity.feedAdapter;
                        Intrinsics.checkNotNull(feedAdapter3);
                        int itemCount = feedAdapter3.getItemCount();
                        feedAdapter3.addFeed(feedsActivity.datalist);
                        feedAdapter3.notifyItemRangeChanged(itemCount + 1, feedAdapter3.getItemCount());
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FeedsActivity$setObservers$5$5(feedsActivity, jSONArray, null), 3, null);
                    }
                } else {
                    JSONObject jSONObject16 = feedsActivity.feedJsonObject;
                    if (jSONObject16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                        jSONObject16 = null;
                    }
                    if (jSONObject16.has(Const.POST_TYPE)) {
                        JSONObject jSONObject17 = feedsActivity.feedJsonObject;
                        if (jSONObject17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject3 = null;
                        } else {
                            jSONObject3 = jSONObject17;
                        }
                        JSONArray jSONArray6 = jSONObject3.getJSONArray(Const.POST_TYPE);
                        Intrinsics.checkNotNullExpressionValue(jSONArray6, "getJSONArray(...)");
                        SharedPreference.getInstance().putString(Const.POST_TYPE, jSONArray6.toString());
                        feedsActivity.posttypelist.clear();
                        Iterator<Integer> it2 = RangesKt.until(0, jSONArray6.length()).iterator();
                        while (it2.hasNext()) {
                            JSONObject jSONObjectOptJSONObject8 = jSONArray6.optJSONObject(((IntIterator) it2).nextInt());
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject8, "optJSONObject(...)");
                            feedsActivity.posttypelist.add((PostType) new Gson().fromJson(jSONObjectOptJSONObject8.toString(), PostType.class));
                        }
                    }
                    feedsActivity.posttypelist.add(0, new PostType("", "All"));
                    if (feedsActivity.datalist.size() == 0) {
                        RelativeLayout relativeLayout4 = feedsActivity.no_data_found_RL;
                        Intrinsics.checkNotNull(relativeLayout4);
                        relativeLayout4.setVisibility(0);
                        ActivityFeedsBinding activityFeedsBinding3 = feedsActivity.feedsBinding;
                        Intrinsics.checkNotNull(activityFeedsBinding3);
                        activityFeedsBinding3.pulltoReferesh.setVisibility(8);
                    } else {
                        Toast.makeText(feedsActivity, "No More Post found", 0).show();
                    }
                }
            } else {
                feedsActivity.limitdata = 0;
                if (feedsActivity.datalist.size() == 0) {
                    RelativeLayout relativeLayout5 = feedsActivity.no_data_found_RL;
                    Intrinsics.checkNotNull(relativeLayout5);
                    relativeLayout5.setVisibility(0);
                    ActivityFeedsBinding activityFeedsBinding4 = feedsActivity.feedsBinding;
                    Intrinsics.checkNotNull(activityFeedsBinding4);
                    activityFeedsBinding4.pulltoReferesh.setVisibility(8);
                }
                RetrofitResponse.GetApiData(feedsActivity, jSONObject.has("auth_code") ? jSONObject.getString("auth_code") : "", jSONObject.getString("message"), false);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$36(FeedsActivity feedsActivity, JSONObject jSONObject) throws JSONException {
        if (Intrinsics.areEqual(jSONObject.optString("status"), "true")) {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            if (jSONArray.length() > 0) {
                feedsActivity.liveClassData.clear();
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                    Datum datum = (Datum) new Gson().fromJson(jSONObjectOptJSONObject.toString(), Datum.class);
                    datum.setCd_time(jSONObject.optLong("cd_time"));
                    feedsActivity.liveClassData.add(datum);
                }
                Json json = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                feedsActivity.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json, "", "", "", "", "", "", "1093", "", "", "", "", "", "", "", "", feedsActivity.newCourseData, feedsActivity.liveTestData, feedsActivity.liveClassData, feedsActivity.testResultList, arrayList, "0", feedsActivity.section_posiiton, feedsActivity.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                if (!feedsActivity.is_filterbutton) {
                    PostDataTable postDataTable = new PostDataTable();
                    postDataTable.setCreated("");
                    postDataTable.setId("");
                    postDataTable.setJson(new Gson().toJson(json));
                    postDataTable.setMeta_url("");
                    postDataTable.setLink_type("");
                    postDataTable.setThumbnail("");
                    postDataTable.setUrl("");
                    postDataTable.setModified("");
                    postDataTable.setMy_like("");
                    postDataTable.setName("");
                    postDataTable.setPost_type("1093");
                    postDataTable.setProfile_picture("");
                    postDataTable.setStatus("");
                    postDataTable.setParentId(feedsActivity.master_cat);
                    postDataTable.setMasterCat(feedsActivity.main_cat);
                    postDataTable.setSub_cat_id(feedsActivity.sub_cat);
                    postDataTable.setText("");
                    postDataTable.setTotal_comments("");
                    postDataTable.setTotal_likes("");
                    postDataTable.setUser_id("");
                    postDataTable.setNewCourseData(new Gson().toJson(feedsActivity.newCourseData));
                    postDataTable.setLivetest(new Gson().toJson(feedsActivity.liveTestData));
                    postDataTable.setLiveclass(new Gson().toJson(feedsActivity.liveClassData));
                    postDataTable.setTestResult(new Gson().toJson(feedsActivity.testResultList));
                    postDataTable.setBannerlist(new Gson().toJson(arrayList));
                    postDataTable.setLiveClassStatus("1");
                    postDataTable.setLiveTestStatus("0");
                    postDataTable.setPage(String.valueOf(feedsActivity.page));
                    postDataTable.setIscommentenable("0");
                    postDataTable.setSectionposiiton(feedsActivity.section_posiiton);
                    postDataTable.setLimit(String.valueOf(feedsActivity.limitdata));
                    postDataTable.setMy_pinned(feedsActivity.pinnedPost);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FeedsActivity$setObservers$6$1(feedsActivity, postDataTable, null), 3, null);
                }
            }
        }
        feedsActivity.hitApiForLiveTest();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$38(FeedsActivity feedsActivity, JSONObject jSONObject) throws JSONException {
        if (Intrinsics.areEqual(jSONObject.optString("status"), "true")) {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            if (jSONArray.length() > 0) {
                feedsActivity.liveTestData.clear();
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                    LiveTestData liveTestData = (LiveTestData) new Gson().fromJson(jSONObjectOptJSONObject.toString(), LiveTestData.class);
                    liveTestData.setCd_time(jSONObject.optLong("cd_time"));
                    feedsActivity.liveTestData.add(liveTestData);
                }
                Json json = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                feedsActivity.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json, "", "", "", "", "", "", "1092", "", "", "", "", "", "", "", "", feedsActivity.newCourseData, feedsActivity.liveTestData, feedsActivity.liveClassData, feedsActivity.testResultList, arrayList, "0", feedsActivity.section_posiiton, feedsActivity.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                if (!feedsActivity.is_filterbutton) {
                    PostDataTable postDataTable = new PostDataTable();
                    postDataTable.setCreated("");
                    postDataTable.setId("");
                    postDataTable.setJson(new Gson().toJson(json));
                    postDataTable.setMeta_url("");
                    postDataTable.setLink_type("");
                    postDataTable.setThumbnail("");
                    postDataTable.setUrl("");
                    postDataTable.setModified("");
                    postDataTable.setMy_like("");
                    postDataTable.setName("");
                    postDataTable.setPost_type("1092");
                    postDataTable.setProfile_picture("");
                    postDataTable.setStatus("");
                    postDataTable.setParentId(feedsActivity.master_cat);
                    postDataTable.setMasterCat(feedsActivity.main_cat);
                    postDataTable.setSub_cat_id(feedsActivity.sub_cat);
                    postDataTable.setText("");
                    postDataTable.setTotal_comments("");
                    postDataTable.setTotal_likes("");
                    postDataTable.setUser_id("");
                    postDataTable.setNewCourseData(new Gson().toJson(feedsActivity.newCourseData));
                    postDataTable.setLivetest(new Gson().toJson(feedsActivity.liveTestData));
                    postDataTable.setLiveclass(new Gson().toJson(feedsActivity.liveClassData));
                    postDataTable.setTestResult(new Gson().toJson(feedsActivity.testResultList));
                    postDataTable.setBannerlist(new Gson().toJson(arrayList));
                    postDataTable.setLiveClassStatus("0");
                    postDataTable.setLiveTestStatus("1");
                    postDataTable.setPage(String.valueOf(feedsActivity.page));
                    postDataTable.setIscommentenable("0");
                    postDataTable.setSectionposiiton(feedsActivity.section_posiiton);
                    postDataTable.setLimit(String.valueOf(feedsActivity.limitdata));
                    postDataTable.setMy_pinned(feedsActivity.pinnedPost);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FeedsActivity$setObservers$7$1(feedsActivity, postDataTable, null), 3, null);
                }
            }
        }
        FeedAdapter feedAdapter = feedsActivity.feedAdapter;
        Intrinsics.checkNotNull(feedAdapter);
        if (feedsActivity.datalist.size() > Integer.parseInt(feedsActivity.section_posiiton)) {
            feedsActivity.datalist.addAll(Integer.parseInt(feedsActivity.section_posiiton) + 1, feedsActivity.posiitonwiselist);
        } else {
            feedsActivity.datalist.addAll(feedsActivity.posiitonwiselist);
        }
        feedAdapter.addFeed(feedsActivity.datalist);
        feedAdapter.notifyDataSetChanged();
        return Unit.INSTANCE;
    }

    private final void updatePostData(List<PostDataTable> postData) {
        if (postData.isEmpty()) {
            return;
        }
        this.page = Integer.parseInt(postData.get(postData.size() - 1).getPage());
        this.limitdata = Integer.parseInt(postData.get(postData.size() - 1).getLimit());
        if (this.liveTestData.isEmpty()) {
            Iterator<PostDataTable> it = postData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostDataTable next = it.next();
                if (next.getPost_type().equals("1092")) {
                    this.liveTestData = (ArrayList) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity.updatePostData.1
                    }.getType());
                    break;
                }
            }
        }
        if (this.liveClassData.isEmpty()) {
            for (PostDataTable postDataTable : postData) {
                if (postDataTable.getPost_type().equals("1093")) {
                    this.liveClassData = (ArrayList) new Gson().fromJson(postDataTable.getLiveclass(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity.updatePostData.2
                    }.getType());
                    return;
                }
            }
        }
    }

    private final void catregoryPost(List<PostDataTable> postData) {
        if (!postData.isEmpty()) {
            String sectionposiiton = postData.get(0).getSectionposiiton();
            this.section_posiiton = sectionposiiton;
            if (sectionposiiton.equals("")) {
                this.section_posiiton = "0";
            }
            this.page = Integer.parseInt(postData.get(postData.size() - 1).getPage());
            this.limitdata = Integer.parseInt(postData.get(postData.size() - 1).getLimit());
            Iterator<PostDataTable> it = postData.iterator();
            while (it.hasNext()) {
                PostDataTable next = it.next();
                String created = next.getCreated();
                String id = next.getId();
                Object objFromJson = new Gson().fromJson(next.getJson(), new TypeToken<Json>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$catregoryPost$data$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                Json json = (Json) objFromJson;
                String meta_url = next.getMeta_url();
                String link_type = next.getLink_type();
                String thumbnail = next.getThumbnail();
                String url = next.getUrl();
                String modified = next.getModified();
                String my_like = next.getMy_like();
                String name = next.getName();
                String post_type = next.getPost_type();
                String profile_picture = next.getProfile_picture();
                String status = next.getStatus();
                String sub_cat_id = next.getSub_cat_id();
                String text = next.getText();
                String total_comments = next.getTotal_comments();
                String total_likes = next.getTotal_likes();
                String user_id = next.getUser_id();
                Iterator<PostDataTable> it2 = it;
                List list = (List) new Gson().fromJson(next.getNewCourseData(), new TypeToken<List<? extends NewCourseData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$catregoryPost$data$2
                }.getType());
                List list2 = (List) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$catregoryPost$data$3
                }.getType());
                List list3 = (List) new Gson().fromJson(next.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$catregoryPost$data$4
                }.getType());
                List list4 = (List) new Gson().fromJson(next.getTestResult(), new TypeToken<List<? extends TestResult>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$catregoryPost$data$5
                }.getType());
                List list5 = (List) new Gson().fromJson(next.getBannerlist(), new TypeToken<List<? extends BannerData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$catregoryPost$data$6
                }.getType());
                String iscommentenable = next.getIscommentenable();
                String my_pinned = next.getMy_pinned();
                String str = my_pinned == null ? "0" : my_pinned;
                String description = next.getDescription();
                String str2 = description == null ? "" : description;
                String parentId = next.getParentId();
                String masterCat = next.getMasterCat();
                String sub_cat_id2 = next.getSub_cat_id();
                String schedule_date = next.getSchedule_date();
                Intrinsics.checkNotNull(schedule_date);
                com.appnew.android.feeds.dataclass.Data data = new com.appnew.android.feeds.dataclass.Data(false, created, id, json, meta_url, link_type, thumbnail, url, modified, my_like, name, post_type, profile_picture, status, sub_cat_id, text, total_comments, total_likes, user_id, list, list2, list3, list4, list5, iscommentenable, null, 0, str, str2, parentId, masterCat, sub_cat_id2, schedule_date, null, 100663296, 2, null);
                if (TextUtils.isEmpty(data.getSchedule_date()) || Long.parseLong(data.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                    this.datalist.add(data);
                }
                if (Intrinsics.areEqual(next.getLiveClassStatus(), "1")) {
                    this.liveClassData = (ArrayList) new Gson().fromJson(next.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity.catregoryPost.1
                    }.getType());
                }
                if (Intrinsics.areEqual(next.getLiveTestStatus(), "1")) {
                    this.liveTestData = (ArrayList) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity.catregoryPost.2
                    }.getType());
                }
                it = it2;
            }
            if (this.datalist.size() > 0) {
                getFeedViewModel().getProgressvalue().setValue("0");
                FeedAdapter feedAdapter = this.feedAdapter;
                Intrinsics.checkNotNull(feedAdapter);
                this.posiitonwiselist.clear();
                this.pinnedPostList.clear();
                this.feedlist.clear();
                Iterator<com.appnew.android.feeds.dataclass.Data> it3 = this.datalist.iterator();
                Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                while (it3.hasNext()) {
                    com.appnew.android.feeds.dataclass.Data next2 = it3.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    com.appnew.android.feeds.dataclass.Data data2 = next2;
                    if (data2.getPost_type().equals("1090") || data2.getPost_type().equals("1091") || data2.getPost_type().equals("1092") || data2.getPost_type().equals("1093")) {
                        this.posiitonwiselist.add(data2);
                    } else {
                        this.feedlist.add(data2);
                    }
                }
                this.datalist.clear();
                this.datalist.addAll(this.feedlist);
                this.feedlist.clear();
                if (this.datalist.size() > Integer.parseInt(this.section_posiiton)) {
                    this.datalist.addAll(Integer.parseInt(this.section_posiiton) + 1, this.posiitonwiselist);
                } else {
                    this.datalist.addAll(this.posiitonwiselist);
                }
                this.posiitonwiselist.clear();
                this.pinnedPostList.clear();
                feedAdapter.addFeed(this.datalist);
                feedAdapter.notifyDataSetChanged();
                return;
            }
            createApiBodyData();
            return;
        }
        createApiBodyData();
    }

    private final void hitApiForLiveClass() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("1");
        encryptionData.setType("1");
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        FeedViewModel feedViewModel = getFeedViewModel();
        Intrinsics.checkNotNull(strEncrypt);
        feedViewModel.getLiveClassData(strEncrypt);
    }

    private final void hitApiForLiveTest() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("1");
        encryptionData.setType("1");
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        FeedViewModel feedViewModel = getFeedViewModel();
        Intrinsics.checkNotNull(strEncrypt);
        feedViewModel.getLiveTestData(strEncrypt);
    }

    public final void showProgressView() {
        ActivityFeedsBinding activityFeedsBinding = this.feedsBinding;
        Intrinsics.checkNotNull(activityFeedsBinding);
        activityFeedsBinding.progressBar.setVisibility(0);
    }

    public final void hideProgressView() {
        ActivityFeedsBinding activityFeedsBinding = this.feedsBinding;
        Intrinsics.checkNotNull(activityFeedsBinding);
        if (activityFeedsBinding.progressBar.getVisibility() == 0) {
            ActivityFeedsBinding activityFeedsBinding2 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding2);
            activityFeedsBinding2.progressBar.setVisibility(4);
        }
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        if (this.type_posttypefilter) {
            Intrinsics.checkNotNull(item);
            CharSequence title = item.getTitle();
            Intrinsics.checkNotNull(title);
            if (!title.equals(this.posttypename)) {
                int size = this.posttypelist.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    CharSequence title2 = item.getTitle();
                    Intrinsics.checkNotNull(title2);
                    if (title2.equals(this.posttypelist.get(i).getTitle())) {
                        this.posttypename = this.posttypelist.get(i).getTitle();
                        this.posttypeid = this.posttypelist.get(i).getId();
                        TextView textView = this.posttypeytext;
                        Intrinsics.checkNotNull(textView);
                        textView.setText(this.posttypename);
                        this.type_posttypefilter = false;
                        break;
                    }
                    i++;
                }
            }
        } else if (this.type_subcatfilter) {
            Intrinsics.checkNotNull(item);
            CharSequence title3 = item.getTitle();
            Intrinsics.checkNotNull(title3);
            if (!title3.equals(this.sub_cat_name_filter)) {
                CharSequence title4 = item.getTitle();
                Intrinsics.checkNotNull(title4);
                if (title4.equals("All")) {
                    this.sub_cat_name_filter = "All";
                    this.sub_cat_filter = "0";
                    TextView textView2 = this.subcatspinner;
                    Intrinsics.checkNotNull(textView2);
                    textView2.setText(this.sub_cat_name_filter);
                    this.type_subcatfilter = false;
                } else {
                    int size2 = this.selectedsub_all_cat.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            break;
                        }
                        CharSequence title5 = item.getTitle();
                        Intrinsics.checkNotNull(title5);
                        if (title5.equals(this.selectedsub_all_cat.get(i2).getName())) {
                            this.sub_cat_name_filter = this.selectedsub_all_cat.get(i2).getName();
                            this.sub_cat_filter = this.selectedsub_all_cat.get(i2).getId();
                            TextView textView3 = this.subcatspinner;
                            Intrinsics.checkNotNull(textView3);
                            textView3.setText(this.sub_cat_name_filter);
                            this.type_subcatfilter = false;
                            break;
                        }
                        i2++;
                    }
                }
            }
        } else {
            Intrinsics.checkNotNull(item);
            CharSequence title6 = item.getTitle();
            Intrinsics.checkNotNull(title6);
            ActivityFeedsBinding activityFeedsBinding = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding);
            if (!title6.equals(activityFeedsBinding.toolbartitleTV.getText().toString())) {
                Iterator<MasteAllCatTable> it = this.selected_master_cat.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MasteAllCatTable next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    MasteAllCatTable masteAllCatTable = next;
                    if (masteAllCatTable.getName().equals(item.getTitle())) {
                        RelativeLayout relativeLayout = this.no_data_found_RL;
                        Intrinsics.checkNotNull(relativeLayout);
                        if (relativeLayout.getVisibility() == 0) {
                            RelativeLayout relativeLayout2 = this.no_data_found_RL;
                            Intrinsics.checkNotNull(relativeLayout2);
                            relativeLayout2.setVisibility(8);
                            ActivityFeedsBinding activityFeedsBinding2 = this.feedsBinding;
                            Intrinsics.checkNotNull(activityFeedsBinding2);
                            activityFeedsBinding2.pulltoReferesh.setVisibility(0);
                        }
                        this.loading = true;
                        this.main_cat = masteAllCatTable.getId();
                        this.selectedsub_all_cat.clear();
                        ArrayList arrayList = new ArrayList();
                        for (MasteAllCatTable masteAllCatTable2 : this.masterAllCatTables) {
                            Iterator<Data.Preferences> it2 = this.preferencesArrayList.iterator();
                            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                            while (it2.hasNext()) {
                                Data.Preferences next2 = it2.next();
                                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                                if (StringsKt.equals(masteAllCatTable2.getId(), next2.getSub_cat(), true)) {
                                    arrayList.add(masteAllCatTable2);
                                }
                            }
                        }
                        Iterator it3 = arrayList.iterator();
                        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                        while (it3.hasNext()) {
                            Object next3 = it3.next();
                            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                            MasteAllCatTable masteAllCatTable3 = (MasteAllCatTable) next3;
                            if (StringsKt.equals(this.main_cat, masteAllCatTable3.getParent_id(), true)) {
                                this.selectedsub_all_cat.add(masteAllCatTable3);
                            }
                        }
                        if (this.selectedsub_all_cat.size() > 0) {
                            this.sub_cat_name = this.selectedsub_all_cat.get(0).getName();
                            this.sub_cat = this.selectedsub_all_cat.get(0).getId();
                        }
                        this.posttypeid = "0";
                        this.posttypename = "All";
                        this.sub_cat_filter = "";
                        this.sub_cat_name_filter = "";
                        this.datalist.clear();
                        ActivityFeedsBinding activityFeedsBinding3 = this.feedsBinding;
                        Intrinsics.checkNotNull(activityFeedsBinding3);
                        activityFeedsBinding3.toolbartitleTV.setText(item.getTitle());
                        this.page = 1;
                        this.section_posiiton = "0";
                        this.limitdata = 0;
                        this.posiitonwiselist.clear();
                        this.pinnedPostList.clear();
                        FeedAdapter feedAdapter = this.feedAdapter;
                        Intrinsics.checkNotNull(feedAdapter);
                        if (feedAdapter.getTimer() != null) {
                            FeedAdapter feedAdapter2 = this.feedAdapter;
                            Intrinsics.checkNotNull(feedAdapter2);
                            Timer timer = feedAdapter2.getTimer();
                            Intrinsics.checkNotNull(timer);
                            timer.cancel();
                            FeedAdapter feedAdapter3 = this.feedAdapter;
                            Intrinsics.checkNotNull(feedAdapter3);
                            Timer timer2 = feedAdapter3.getTimer();
                            Intrinsics.checkNotNull(timer2);
                            timer2.purge();
                        }
                        getFeedViewModel().getProgressvalue().setValue("1");
                        if (this.posttypeid.equals("0")) {
                            List<PostDataTable> listRetrievePostData = this.utkashRoom.getFeedDao().retrievePostData(this.master_cat, this.main_cat, this.sub_cat);
                            Intrinsics.checkNotNull(listRetrievePostData);
                            catregoryPost(listRetrievePostData);
                        } else {
                            List<PostDataTable> listRetrievePostData_viaposttype = this.utkashRoom.getFeedDao().retrievePostData_viaposttype(this.master_cat, this.main_cat, this.sub_cat, this.posttypeid);
                            Intrinsics.checkNotNull(listRetrievePostData_viaposttype);
                            catregoryPost(listRetrievePostData_viaposttype);
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        FeedAdapter feedAdapter = this.feedAdapter;
        Intrinsics.checkNotNull(feedAdapter);
        if (feedAdapter.getTimer() != null) {
            FeedAdapter feedAdapter2 = this.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter2);
            Timer timer = feedAdapter2.getTimer();
            Intrinsics.checkNotNull(timer);
            timer.cancel();
            FeedAdapter feedAdapter3 = this.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter3);
            Timer timer2 = feedAdapter3.getTimer();
            Intrinsics.checkNotNull(timer2);
            timer2.purge();
        }
        SharedPreference.getInstance().putBoolean("show_feeds", false);
        if (Constants.RELOADDASHBOARD.equals("true")) {
            Constants.RELOADDASHBOARD = "false";
            if (StringsKt.equals("1", "6", true)) {
                startActivity(new Intent(this, (Class<?>) DashboardActivityTheme7.class).setFlags(268468224));
            } else if (StringsKt.equals("1", "7", true)) {
                startActivity(new Intent(this, (Class<?>) DashboardActivityTheme8.class));
            } else if (StringsKt.equals("1", "1", true)) {
                startActivity(new Intent(this, (Class<?>) DashboardActivityTheme1.class).setFlags(268468224));
            } else if (StringsKt.equals("1", "2", true)) {
                startActivity(new Intent(this, (Class<?>) DashboardActivityTheme2.class).setFlags(268468224));
            } else if (StringsKt.equals("1", "5", true)) {
                startActivity(new Intent(this, (Class<?>) DashboardActivityTheme5.class).setFlags(268468224));
            } else {
                finish();
            }
            overridePendingTransition(0, 0);
            return;
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (Constants.REFRESHFEED.equals("1")) {
            Constants.REFRESHFEED = "";
            FeedAdapter feedAdapter = this.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter);
            if (feedAdapter.getTimer() != null) {
                FeedAdapter feedAdapter2 = this.feedAdapter;
                Intrinsics.checkNotNull(feedAdapter2);
                Timer timer = feedAdapter2.getTimer();
                Intrinsics.checkNotNull(timer);
                timer.cancel();
                FeedAdapter feedAdapter3 = this.feedAdapter;
                Intrinsics.checkNotNull(feedAdapter3);
                Timer timer2 = feedAdapter3.getTimer();
                Intrinsics.checkNotNull(timer2);
                timer2.purge();
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05711(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedsActivity$onRestart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$onRestart$1", f = "FeedsActivity.kt", i = {}, l = {2116}, m = "invokeSuspend", n = {}, s = {})
    static final class C05711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05711(Continuation<? super C05711> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedsActivity.this.new C05711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FeedsActivity$onRestart$1$jobrerutn$1(FeedsActivity.this, null), 3, null).join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!FeedsActivity.this.getFeedParentData().isEmpty()) {
                FeedsActivity feedsActivity = FeedsActivity.this;
                feedsActivity.setSection_posiiton(feedsActivity.getFeedParentData().get(0).getSectionposiiton());
                if (FeedsActivity.this.getSection_posiiton().equals("")) {
                    FeedsActivity.this.setSection_posiiton("0");
                }
                FeedsActivity feedsActivity2 = FeedsActivity.this;
                feedsActivity2.setPage(Integer.parseInt(feedsActivity2.getFeedParentData().get(FeedsActivity.this.getFeedParentData().size() - 1).getPage()));
                FeedsActivity feedsActivity3 = FeedsActivity.this;
                feedsActivity3.setLimitdata(Integer.parseInt(feedsActivity3.getFeedParentData().get(FeedsActivity.this.getFeedParentData().size() - 1).getLimit()));
                FeedsActivity.this.getDatalist().clear();
                Iterator<PostDataTable> it = FeedsActivity.this.getFeedParentData().iterator();
                while (it.hasNext()) {
                    PostDataTable next = it.next();
                    String created = next.getCreated();
                    String id = next.getId();
                    Object objFromJson = new Gson().fromJson(next.getJson(), new TypeToken<Json>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$onRestart$1$data$1
                    }.getType());
                    Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                    Json json = (Json) objFromJson;
                    String meta_url = next.getMeta_url();
                    String link_type = next.getLink_type();
                    String thumbnail = next.getThumbnail();
                    String url = next.getUrl();
                    String modified = next.getModified();
                    String my_like = next.getMy_like();
                    String name = next.getName();
                    String post_type = next.getPost_type();
                    String profile_picture = next.getProfile_picture();
                    String status = next.getStatus();
                    String sub_cat_id = next.getSub_cat_id();
                    String text = next.getText();
                    String total_comments = next.getTotal_comments();
                    String total_likes = next.getTotal_likes();
                    String user_id = next.getUser_id();
                    boolean z2 = z;
                    Iterator<PostDataTable> it2 = it;
                    List list = (List) new Gson().fromJson(next.getNewCourseData(), new TypeToken<List<? extends NewCourseData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$onRestart$1$data$2
                    }.getType());
                    List list2 = (List) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$onRestart$1$data$3
                    }.getType());
                    List list3 = (List) new Gson().fromJson(next.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$onRestart$1$data$4
                    }.getType());
                    List list4 = (List) new Gson().fromJson(next.getTestResult(), new TypeToken<List<? extends TestResult>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$onRestart$1$data$5
                    }.getType());
                    List list5 = (List) new Gson().fromJson(next.getBannerlist(), new TypeToken<List<? extends BannerData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity$onRestart$1$data$6
                    }.getType());
                    String iscommentenable = next.getIscommentenable();
                    String my_pinned = next.getMy_pinned();
                    String str = my_pinned == null ? "0" : my_pinned;
                    String description = next.getDescription();
                    String str2 = description == null ? "" : description;
                    String parentId = next.getParentId();
                    String masterCat = next.getMasterCat();
                    String sub_cat_id2 = next.getSub_cat_id();
                    String schedule_date = next.getSchedule_date();
                    Intrinsics.checkNotNull(schedule_date);
                    com.appnew.android.feeds.dataclass.Data data = new com.appnew.android.feeds.dataclass.Data(false, created, id, json, meta_url, link_type, thumbnail, url, modified, my_like, name, post_type, profile_picture, status, sub_cat_id, text, total_comments, total_likes, user_id, list, list2, list3, list4, list5, iscommentenable, null, 0, str, str2, parentId, masterCat, sub_cat_id2, schedule_date, null, 100663296, 2, null);
                    if (TextUtils.isEmpty(data.getSchedule_date())) {
                        Boxing.boxBoolean(FeedsActivity.this.getDatalist().add(data));
                    } else if (Long.parseLong(data.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                        FeedsActivity.this.getDatalist().add(data);
                    }
                    if (Intrinsics.areEqual(next.getLiveClassStatus(), "1")) {
                        FeedsActivity.this.setLiveClassData((ArrayList) new Gson().fromJson(next.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity.onRestart.1.1
                        }.getType()));
                    }
                    if (Intrinsics.areEqual(next.getLiveTestStatus(), "1")) {
                        FeedsActivity.this.setLiveTestData((ArrayList) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.activity.FeedsActivity.onRestart.1.2
                        }.getType()));
                    }
                    it = it2;
                    z = z2;
                }
            }
            if (FeedsActivity.this.getDatalist().size() > 0) {
                FeedsActivity.this.getFeedViewModel().getProgressvalue().setValue("0");
                FeedAdapter feedAdapter = FeedsActivity.this.getFeedAdapter();
                Intrinsics.checkNotNull(feedAdapter);
                FeedsActivity feedsActivity4 = FeedsActivity.this;
                feedsActivity4.getPosiitonwiselist().clear();
                feedsActivity4.getPinnedPostList().clear();
                feedsActivity4.getFeedlist().clear();
                Iterator<com.appnew.android.feeds.dataclass.Data> it3 = feedsActivity4.getDatalist().iterator();
                Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                while (it3.hasNext()) {
                    com.appnew.android.feeds.dataclass.Data next2 = it3.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    com.appnew.android.feeds.dataclass.Data data2 = next2;
                    if (data2.getPost_type().equals("1090") || data2.getPost_type().equals("1091") || data2.getPost_type().equals("1092") || data2.getPost_type().equals("1093")) {
                        feedsActivity4.getPosiitonwiselist().add(data2);
                    } else {
                        feedsActivity4.getFeedlist().add(data2);
                    }
                }
                feedsActivity4.getDatalist().clear();
                feedsActivity4.getDatalist().addAll(feedsActivity4.getFeedlist());
                feedsActivity4.getFeedlist().clear();
                if (feedsActivity4.getDatalist().size() > Integer.parseInt(feedsActivity4.getSection_posiiton())) {
                    feedsActivity4.getDatalist().addAll(Integer.parseInt(feedsActivity4.getSection_posiiton()) + 1, feedsActivity4.getPosiitonwiselist());
                } else {
                    feedsActivity4.getDatalist().addAll(feedsActivity4.getPosiitonwiselist());
                }
                feedsActivity4.getPosiitonwiselist().clear();
                feedsActivity4.getPinnedPostList().clear();
                feedAdapter.addFeed(feedsActivity4.getDatalist());
                feedAdapter.notifyDataSetChanged();
            } else {
                FeedsActivity.this.createApiBodyData();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopupWindow popupWindowPart() {
        FeedsActivity feedsActivity = this;
        final PopupWindow popupWindow = new PopupWindow(feedsActivity);
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        View viewInflate = layoutInflater.inflate(R.layout.dialog_popup_feed, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.main_recyclerview);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.layput);
        CardView cardView = (CardView) viewInflate.findViewById(R.id.change_rl);
        TextView textView = (TextView) viewInflate.findViewById(R.id.change_prefence);
        cardView.setVisibility(0);
        MainCatAdapter mainCatAdapter = new MainCatAdapter(feedsActivity, this.selected_master_cat, this.mastercatlist);
        if (this.selected_master_cat.size() > 0 && this.selected_master_cat.size() == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, (int) ((50 * getResources().getDisplayMetrics().density) + 0.5f));
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setLayoutParams(layoutParams);
        } else if (this.selected_master_cat.size() > 0 && this.selected_master_cat.size() == 2) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, (int) ((100 * getResources().getDisplayMetrics().density) + 0.5f));
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setLayoutParams(layoutParams2);
        } else if (this.selected_master_cat.size() > 0 && this.selected_master_cat.size() >= 3) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, (int) ((150 * getResources().getDisplayMetrics().density) + 0.5f));
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setLayoutParams(layoutParams3);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsActivity.popupWindowPart$lambda$40(this.f$0, view);
            }
        });
        listView.setAdapter((ListAdapter) mainCatAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.appnew.android.feeds.activity.FeedsActivity$$ExternalSyntheticLambda20
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FeedsActivity.popupWindowPart$lambda$41(this.f$0, popupWindow, adapterView, view, i, j);
            }
        });
        try {
            Object systemService = viewInflate.getContext().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_rectangle));
            popupWindow.setWidth((((WindowManager) systemService).getDefaultDisplay().getWidth() * 4) / 6);
            popupWindow.showAtLocation(viewInflate, 17, 0, 0);
            popupWindow.setContentView(viewInflate);
            return popupWindow;
        } catch (Exception e2) {
            e2.printStackTrace();
            return popupWindow;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popupWindowPart$lambda$40(FeedsActivity feedsActivity, View view) {
        PopupWindow popupWindow = feedsActivity.popUp;
        Intrinsics.checkNotNull(popupWindow);
        popupWindow.dismiss();
        Helper.gotoActivity(new Intent(feedsActivity, (Class<?>) IntroActivity.class), feedsActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popupWindowPart$lambda$41(FeedsActivity feedsActivity, PopupWindow popupWindow, AdapterView adapterView, View view, int i, long j) {
        TextView textView;
        TextView textView2;
        if (feedsActivity.posttypelist.size() > 0) {
            FeedsActivity feedsActivity2 = feedsActivity;
            if (Helper.isNetworkConnected(feedsActivity2)) {
                MasteAllCatTable masteAllCatTable = feedsActivity.selected_master_cat.get(i);
                Intrinsics.checkNotNullExpressionValue(masteAllCatTable, "get(...)");
                MasteAllCatTable masteAllCatTable2 = masteAllCatTable;
                String name = masteAllCatTable2.getName();
                ActivityFeedsBinding activityFeedsBinding = feedsActivity.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding);
                if (!name.equals(activityFeedsBinding.toolbartitleTV.getText().toString())) {
                    Iterator<MasteAllCatTable> it = feedsActivity.selected_master_cat.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MasteAllCatTable next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        MasteAllCatTable masteAllCatTable3 = next;
                        if (masteAllCatTable3.getName().equals(masteAllCatTable2.getName())) {
                            SharedPreference.getInstance().putString("catName", masteAllCatTable3.getName());
                            SharedPreference.getInstance().putString("sub_cat_id", masteAllCatTable3.getId());
                            RelativeLayout relativeLayout = feedsActivity.no_data_found_RL;
                            Intrinsics.checkNotNull(relativeLayout);
                            if (relativeLayout.getVisibility() == 0) {
                                RelativeLayout relativeLayout2 = feedsActivity.no_data_found_RL;
                                Intrinsics.checkNotNull(relativeLayout2);
                                relativeLayout2.setVisibility(8);
                                ActivityFeedsBinding activityFeedsBinding2 = feedsActivity.feedsBinding;
                                Intrinsics.checkNotNull(activityFeedsBinding2);
                                activityFeedsBinding2.pulltoReferesh.setVisibility(0);
                            }
                            feedsActivity.loading = true;
                            feedsActivity.main_cat = masteAllCatTable3.getId();
                            feedsActivity.master_cat = masteAllCatTable3.getMaster_type();
                            feedsActivity.selectedsub_all_cat.clear();
                            ArrayList arrayList = new ArrayList();
                            for (MasteAllCatTable masteAllCatTable4 : feedsActivity.masterAllCatTables) {
                                Iterator<Data.Preferences> it2 = feedsActivity.preferencesArrayList.iterator();
                                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                                while (it2.hasNext()) {
                                    Data.Preferences next2 = it2.next();
                                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                                    if (StringsKt.equals(masteAllCatTable4.getId(), next2.getSub_cat(), true)) {
                                        arrayList.add(masteAllCatTable4);
                                    }
                                }
                            }
                            Iterator it3 = arrayList.iterator();
                            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                            while (it3.hasNext()) {
                                Object next3 = it3.next();
                                Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                                MasteAllCatTable masteAllCatTable5 = (MasteAllCatTable) next3;
                                if (StringsKt.equals(feedsActivity.main_cat, masteAllCatTable5.getParent_id(), true)) {
                                    feedsActivity.selectedsub_all_cat.add(masteAllCatTable5);
                                }
                            }
                            if (feedsActivity.selectedsub_all_cat.size() > 0) {
                                feedsActivity.sub_cat_name = "All";
                                feedsActivity.sub_cat = "0";
                            }
                            feedsActivity.posttypeid = "0";
                            feedsActivity.posttypename = "All";
                            feedsActivity.sub_cat_filter = "";
                            feedsActivity.is_filterbutton = false;
                            feedsActivity.sub_cat_name_filter = "";
                            feedsActivity.datalist.clear();
                            if (!StringsKt.equals(BuildConfig.FLAVOR, "KSRAnatomyClasses", true)) {
                                ActivityFeedsBinding activityFeedsBinding3 = feedsActivity.feedsBinding;
                                if (activityFeedsBinding3 != null && (textView2 = activityFeedsBinding3.toolbartitleTV) != null) {
                                    textView2.setText(masteAllCatTable2.getName());
                                }
                            } else {
                                ActivityFeedsBinding activityFeedsBinding4 = feedsActivity.feedsBinding;
                                if (activityFeedsBinding4 != null && (textView = activityFeedsBinding4.toolbartitleTV) != null) {
                                    textView.setText("Discussion Forum");
                                }
                            }
                            feedsActivity.page = 1;
                            feedsActivity.section_posiiton = "0";
                            feedsActivity.limitdata = 0;
                            feedsActivity.posiitonwiselist.clear();
                            feedsActivity.pinnedPostList.clear();
                            ActivityFeedsBinding activityFeedsBinding5 = feedsActivity.feedsBinding;
                            Intrinsics.checkNotNull(activityFeedsBinding5);
                            activityFeedsBinding5.filter.setImageResource(R.mipmap.filter_icon);
                            FeedAdapter feedAdapter = feedsActivity.feedAdapter;
                            Intrinsics.checkNotNull(feedAdapter);
                            if (feedAdapter.getTimer() != null) {
                                FeedAdapter feedAdapter2 = feedsActivity.feedAdapter;
                                Intrinsics.checkNotNull(feedAdapter2);
                                Timer timer = feedAdapter2.getTimer();
                                Intrinsics.checkNotNull(timer);
                                timer.cancel();
                                FeedAdapter feedAdapter3 = feedsActivity.feedAdapter;
                                Intrinsics.checkNotNull(feedAdapter3);
                                Timer timer2 = feedAdapter3.getTimer();
                                Intrinsics.checkNotNull(timer2);
                                timer2.purge();
                            }
                            feedsActivity.getFeedViewModel().getProgressvalue().setValue("1");
                            if (feedsActivity.posttypeid.equals("0")) {
                                List<PostDataTable> listRetrievePostData = feedsActivity.utkashRoom.getFeedDao().retrievePostData(feedsActivity.master_cat, feedsActivity.main_cat, feedsActivity.sub_cat);
                                Intrinsics.checkNotNull(listRetrievePostData);
                                feedsActivity.catregoryPost(listRetrievePostData);
                            } else {
                                List<PostDataTable> listRetrievePostData_viaposttype = feedsActivity.utkashRoom.getFeedDao().retrievePostData_viaposttype(feedsActivity.master_cat, feedsActivity.main_cat, feedsActivity.sub_cat, feedsActivity.posttypeid);
                                Intrinsics.checkNotNull(listRetrievePostData_viaposttype);
                                feedsActivity.catregoryPost(listRetrievePostData_viaposttype);
                            }
                        }
                    }
                }
            } else {
                Helper.showInternetToast(feedsActivity2);
            }
            popupWindow.dismiss();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(MakeMyExam.getUserId());
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNull(service);
        return service.master_content(strEncrypt);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        try {
            Intrinsics.checkNotNull(jsonObject);
            if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                JSONObject jSONObject = jsonObject.getJSONObject("data");
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                try {
                    this.utkashRoom.getcoursetypemaster().deletedata();
                    this.utkashRoom.getMasterAllCatDao().deletedata();
                    this.utkashRoom.getMastercatDao().deletedata();
                    if (jSONObject.has("all_cat") && (jSONArrayOptJSONArray2 = jSONObject.optJSONArray("all_cat")) != null && jSONArrayOptJSONArray2.length() > 0) {
                        int length = jSONArrayOptJSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            MasteAllCatTable masteAllCatTable = (MasteAllCatTable) new Gson().fromJson(jSONArrayOptJSONArray2.get(i).toString(), MasteAllCatTable.class);
                            masteAllCatTable.setUser_id(MakeMyExam.userId);
                            this.utkashRoom.getMasterAllCatDao().addUser(masteAllCatTable);
                        }
                    }
                    if (jSONObject.has("master_cat") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("master_cat")) != null && jSONArrayOptJSONArray.length() > 0) {
                        int length2 = jSONArrayOptJSONArray.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            MasterCat masterCat = (MasterCat) new Gson().fromJson(jSONArrayOptJSONArray.get(i2).toString(), MasterCat.class);
                            masterCat.setUser_id(MakeMyExam.userId);
                            this.utkashRoom.getMastercatDao().addUser(masterCat);
                            String id = masterCat.getId();
                            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                            String cat = masterCat.getCat();
                            Intrinsics.checkNotNullExpressionValue(cat, "getCat(...)");
                            new Mastercat(id, cat, false, false, 12, null);
                        }
                    }
                    manageData();
                    try {
                        if (this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_009")) {
                            this.utkashRoom.getapidao().update_api_version("ut_009", MakeMyExam.userId, String.valueOf(jsonObject.optLong("time")), String.valueOf(jsonObject.optLong("interval")), String.valueOf(jsonObject.optLong("cd_time")));
                            Unit unit = Unit.INSTANCE;
                        } else {
                            APITABLE apitable = new APITABLE();
                            apitable.setApicode("ut_009");
                            apitable.setApiname("master_content");
                            apitable.setInterval(String.valueOf(jsonObject.optLong("interval")));
                            apitable.setUser_id(MakeMyExam.userId);
                            apitable.setTimestamp(String.valueOf(jsonObject.optLong("time")));
                            apitable.setCdtimestamp(String.valueOf(jsonObject.optLong("cd_time")));
                            apitable.setVersion("0.000");
                            Long.valueOf(this.utkashRoom.getapidao().addUser(apitable));
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    Unit unit3 = Unit.INSTANCE;
                    return;
                }
            }
            RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
        } catch (Exception e4) {
            ErrorCallBack(e4.getMessage() + " : " + e4.getLocalizedMessage(), apitype, typeApi);
            e4.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedsActivity$manageData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$manageData$1", f = "FeedsActivity.kt", i = {}, l = {2663}, m = "invokeSuspend", n = {}, s = {})
    static final class C05691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05691(Continuation<? super C05691> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedsActivity.this.new C05691(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (((int) FeedsActivity.this.getLocale_time()) > 0 && ((int) (((MakeMyExam.time_server - FeedsActivity.this.getLocale_time()) / ((long) DateTimeConstants.MILLIS_PER_MINUTE)) % ((long) 60))) > 10) {
                    FeedsActivity.this.getUtkashRoom().getFeedDao().deletedata();
                }
                FeedsActivity feedsActivity = FeedsActivity.this;
                feedsActivity.setMasterAllCatTables(feedsActivity.getUtkashRoom().getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId));
                if (FeedsActivity.this.getPreferencesArrayList().size() > 0) {
                    ArrayList arrayList2 = new ArrayList(FeedsActivity.this.getUtkashRoom().getMastercatDao().getmastercat(MakeMyExam.userId));
                    ArrayList arrayList3 = new ArrayList();
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    for (MasteAllCatTable masteAllCatTable : FeedsActivity.this.getMasterAllCatTables()) {
                        Iterator<Data.Preferences> it = FeedsActivity.this.getPreferencesArrayList().iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            Data.Preferences next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            if (StringsKt.equals(masteAllCatTable.getId(), next.getSub_cat(), true)) {
                                arrayList3.add(masteAllCatTable);
                                String master_type = masteAllCatTable.getMaster_type();
                                Intrinsics.checkNotNullExpressionValue(master_type, "getMaster_type(...)");
                                hashSet2.add(master_type);
                            }
                        }
                    }
                    for (Object obj2 : arrayList2) {
                        Intrinsics.checkNotNullExpressionValue(obj2, "next(...)");
                        MasterCat masterCat = (MasterCat) obj2;
                        Iterator it2 = hashSet2.iterator();
                        while (it2.hasNext()) {
                            if (StringsKt.equals(masterCat.getId(), (String) it2.next(), true)) {
                                FeedsActivity.this.getMastercatlist().add(masterCat);
                            }
                        }
                    }
                    for (MasteAllCatTable masteAllCatTable2 : FeedsActivity.this.getMasterAllCatTables()) {
                        Iterator it3 = arrayList3.iterator();
                        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                        while (it3.hasNext()) {
                            Object next2 = it3.next();
                            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                            MasteAllCatTable masteAllCatTable3 = (MasteAllCatTable) next2;
                            if (Intrinsics.areEqual(masteAllCatTable2.getId(), masteAllCatTable3.getParent_id()) && StringsKt.equals(masteAllCatTable2.getParent_id(), "0", true) && StringsKt.equals(masteAllCatTable2.getMaster_type(), masteAllCatTable3.getMaster_type(), true)) {
                                hashSet.add(masteAllCatTable2);
                            }
                        }
                    }
                    for (Object obj3 : hashSet) {
                        Intrinsics.checkNotNullExpressionValue(obj3, "next(...)");
                        MasteAllCatTable masteAllCatTable4 = (MasteAllCatTable) obj3;
                        if (StringsKt.equals(masteAllCatTable4.getParent_id(), "0", true)) {
                            FeedsActivity.this.getSelected_master_cat().add(masteAllCatTable4);
                        }
                    }
                    if (FeedsActivity.this.getSelected_master_cat().size() > 0) {
                        if (StringsKt.equals("1", "7", true)) {
                            Iterator<MasterCat> it4 = FeedsActivity.this.getMastercatlist().iterator();
                            Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
                            while (true) {
                                if (!it4.hasNext()) {
                                    break;
                                }
                                MasterCat next3 = it4.next();
                                Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                                MasterCat masterCat2 = next3;
                                if (masterCat2.getId().equals(FeedsActivity.this.getSelected_master_cat().get(0).getMaster_type())) {
                                    FeedsActivity.this.setMain_cat_name(masterCat2.getCat());
                                    FeedsActivity feedsActivity2 = FeedsActivity.this;
                                    feedsActivity2.setMain_cat(feedsActivity2.getSelected_master_cat().get(0).getId());
                                    break;
                                }
                            }
                            SharedPreference.getInstance().putString("sub_cat_id", FeedsActivity.this.getMain_cat());
                            SharedPreference.getInstance().putString("catName", FeedsActivity.this.getMain_cat_name());
                            arrayList = arrayList3;
                        } else if (!TextUtils.isEmpty(SharedPreference.getInstance().getString("sub_cat_id"))) {
                            Iterator<MasteAllCatTable> it5 = FeedsActivity.this.getSelected_master_cat().iterator();
                            Intrinsics.checkNotNullExpressionValue(it5, "iterator(...)");
                            while (it5.hasNext()) {
                                MasteAllCatTable next4 = it5.next();
                                Intrinsics.checkNotNullExpressionValue(next4, "next(...)");
                                MasteAllCatTable masteAllCatTable5 = next4;
                                if (FeedsActivity.this.getMastercatlist().size() > 0) {
                                    Iterator<MasterCat> it6 = FeedsActivity.this.getMastercatlist().iterator();
                                    Intrinsics.checkNotNullExpressionValue(it6, "iterator(...)");
                                    while (it6.hasNext()) {
                                        MasterCat next5 = it6.next();
                                        Intrinsics.checkNotNullExpressionValue(next5, "next(...)");
                                        MasterCat masterCat3 = next5;
                                        ArrayList arrayList4 = arrayList3;
                                        if (StringsKt.equals(SharedPreference.getInstance().getString("sub_cat_id"), masteAllCatTable5.getId(), true) && masteAllCatTable5.getMaster_type().equals(masterCat3.getId())) {
                                            FeedsActivity.this.setMaster_cat(masterCat3.getId());
                                            FeedsActivity.this.setMaster_cat_name(masterCat3.getCat());
                                        }
                                        arrayList3 = arrayList4;
                                    }
                                }
                            }
                            arrayList = arrayList3;
                            Iterator<MasteAllCatTable> it7 = FeedsActivity.this.getSelected_master_cat().iterator();
                            Intrinsics.checkNotNullExpressionValue(it7, "iterator(...)");
                            while (true) {
                                if (!it7.hasNext()) {
                                    break;
                                }
                                MasteAllCatTable next6 = it7.next();
                                Intrinsics.checkNotNullExpressionValue(next6, "next(...)");
                                MasteAllCatTable masteAllCatTable6 = next6;
                                if (StringsKt.equals(masteAllCatTable6.getId(), SharedPreference.getInstance().getString("sub_cat_id"), true)) {
                                    FeedsActivity.this.setMain_cat_name(masteAllCatTable6.getName());
                                    FeedsActivity.this.setMain_cat(masteAllCatTable6.getId());
                                    break;
                                }
                            }
                        } else {
                            arrayList = arrayList3;
                            FeedsActivity feedsActivity3 = FeedsActivity.this;
                            feedsActivity3.setMain_cat_name(feedsActivity3.getSelected_master_cat().get(0).getName());
                            FeedsActivity feedsActivity4 = FeedsActivity.this;
                            feedsActivity4.setMain_cat(feedsActivity4.getSelected_master_cat().get(0).getId());
                            if (FeedsActivity.this.getMastercatlist().size() > 0) {
                                FeedsActivity feedsActivity5 = FeedsActivity.this;
                                feedsActivity5.setMaster_cat(feedsActivity5.getMastercatlist().get(0).getId());
                                FeedsActivity feedsActivity6 = FeedsActivity.this;
                                feedsActivity6.setMaster_cat_name(feedsActivity6.getMastercatlist().get(0).getCat());
                            }
                            SharedPreference.getInstance().putString("sub_cat_id", FeedsActivity.this.getMain_cat());
                            SharedPreference.getInstance().putString("catName", FeedsActivity.this.getMain_cat_name());
                        }
                        if (TextUtils.isEmpty(FeedsActivity.this.getMain_cat())) {
                            if (StringsKt.equals("1", "7", true)) {
                                Iterator<MasterCat> it8 = FeedsActivity.this.getMastercatlist().iterator();
                                Intrinsics.checkNotNullExpressionValue(it8, "iterator(...)");
                                while (true) {
                                    if (!it8.hasNext()) {
                                        break;
                                    }
                                    MasterCat next7 = it8.next();
                                    Intrinsics.checkNotNullExpressionValue(next7, "next(...)");
                                    MasterCat masterCat4 = next7;
                                    if (masterCat4.getId().equals(FeedsActivity.this.getSelected_master_cat().get(0).getMaster_type())) {
                                        FeedsActivity.this.setMain_cat_name(masterCat4.getCat());
                                        FeedsActivity feedsActivity7 = FeedsActivity.this;
                                        feedsActivity7.setMain_cat(feedsActivity7.getSelected_master_cat().get(0).getId());
                                        break;
                                    }
                                }
                            } else {
                                FeedsActivity feedsActivity8 = FeedsActivity.this;
                                feedsActivity8.setMain_cat_name(feedsActivity8.getSelected_master_cat().get(0).getName());
                                FeedsActivity feedsActivity9 = FeedsActivity.this;
                                feedsActivity9.setMain_cat(feedsActivity9.getSelected_master_cat().get(0).getId());
                            }
                            SharedPreference.getInstance().putString("sub_cat_id", FeedsActivity.this.getMain_cat());
                            SharedPreference.getInstance().putString("catName", FeedsActivity.this.getMain_cat_name());
                        }
                        Iterator it9 = arrayList.iterator();
                        Intrinsics.checkNotNullExpressionValue(it9, "iterator(...)");
                        while (it9.hasNext()) {
                            Object next8 = it9.next();
                            Intrinsics.checkNotNullExpressionValue(next8, "next(...)");
                            MasteAllCatTable masteAllCatTable7 = (MasteAllCatTable) next8;
                            if (StringsKt.equals(FeedsActivity.this.getMain_cat(), masteAllCatTable7.getParent_id(), true)) {
                                FeedsActivity.this.getSelectedsub_all_cat().add(masteAllCatTable7);
                            }
                        }
                        if (FeedsActivity.this.getSelectedsub_all_cat().size() > 0) {
                            FeedsActivity.this.setSub_cat_name("All");
                            FeedsActivity.this.setSub_cat("0");
                            this.label = 1;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new C01111(FeedsActivity.this, null), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedsActivity$manageData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FeedsActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedsActivity$manageData$1$1", f = "FeedsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FeedsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01111(FeedsActivity feedsActivity, Continuation<? super C01111> continuation) {
                super(2, continuation);
                this.this$0 = feedsActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01111(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                TextView textView;
                TextView textView2;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (!StringsKt.equals(BuildConfig.FLAVOR, "KSRAnatomyClasses", true)) {
                    ActivityFeedsBinding feedsBinding = this.this$0.getFeedsBinding();
                    if (feedsBinding != null && (textView2 = feedsBinding.toolbartitleTV) != null) {
                        textView2.setText(this.this$0.getMain_cat_name());
                    }
                } else {
                    ActivityFeedsBinding feedsBinding2 = this.this$0.getFeedsBinding();
                    if (feedsBinding2 != null && (textView = feedsBinding2.toolbartitleTV) != null) {
                        textView.setText("Discussion Forum");
                    }
                }
                FeedsActivity feedsActivity = this.this$0;
                feedsActivity.setPopUp(feedsActivity.popupWindowPart());
                this.this$0.local_data(false);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void manageData() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05691(null), 3, null);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
