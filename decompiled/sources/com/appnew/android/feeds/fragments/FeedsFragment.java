package com.appnew.android.feeds.fragments;

import android.content.DialogInterface;
import android.content.Intent;
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
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.FragmentFeedsBinding;
import com.appnew.android.feeds.activity.PinnedPostActivity;
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
import com.appnew.android.home.livetest.LiveTestData;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.appnew.android.table.PostDataTable;
import com.appnew.mvvmwithretrofit.repository.Repository;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FeedsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 é\u00012\u00020\u00012\u00020\u0002:\u0002é\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010Ê\u0001\u001a\u00030Ë\u00012\n\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001H\u0016J,\u0010Î\u0001\u001a\u00030Ï\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u00012\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u00012\n\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001H\u0016J\u0014\u0010Ô\u0001\u001a\u00030Ë\u00012\b\u0010Õ\u0001\u001a\u00030Ï\u0001H\u0002J\n\u0010Ö\u0001\u001a\u00030Ë\u0001H\u0002J\u0013\u0010×\u0001\u001a\u00030Ë\u00012\u0007\u0010Ø\u0001\u001a\u00020\"H\u0002J\b\u0010Ù\u0001\u001a\u00030Ë\u0001J\b\u0010Ú\u0001\u001a\u00030Ë\u0001J\u001b\u0010Û\u0001\u001a\u00030Ë\u00012\u000f\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030Ç\u00010Ý\u0001H\u0002J\u001b\u0010Þ\u0001\u001a\u00030Ë\u00012\u000f\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030Ç\u00010Ý\u0001H\u0002J\n\u0010ß\u0001\u001a\u00030Ë\u0001H\u0002J\n\u0010à\u0001\u001a\u00030Ë\u0001H\u0002J\b\u0010á\u0001\u001a\u00030Ë\u0001J\b\u0010â\u0001\u001a\u00030Ë\u0001J\u0015\u0010ã\u0001\u001a\u00020\"2\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u0001H\u0016J\n\u0010æ\u0001\u001a\u00030¸\u0001H\u0003J\u0011\u0010ç\u0001\u001a\u00030Ë\u00012\u0007\u0010è\u0001\u001a\u00020'R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u001a\u00102\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001a\u00105\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010#\"\u0004\b<\u0010%R\u001a\u0010=\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001a\u0010I\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010+R\u001a\u0010L\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010)\"\u0004\bN\u0010+R\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010#\"\u0004\bW\u0010%R\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010)\"\u0004\b`\u0010+R\u001a\u0010a\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010)\"\u0004\bc\u0010+R\u001a\u0010d\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010)\"\u0004\bf\u0010+R\u001a\u0010g\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010)\"\u0004\bi\u0010+R\u001a\u0010j\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010)\"\u0004\bl\u0010+R\u001a\u0010m\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010)\"\u0004\bo\u0010+R\u001a\u0010p\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010#\"\u0004\bq\u0010%R\u001a\u0010r\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010)\"\u0004\bt\u0010+R\u001a\u0010u\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010)\"\u0004\bw\u0010+R*\u0010x\u001a\u0012\u0012\u0004\u0012\u00020z0yj\b\u0012\u0004\u0012\u00020z`{X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR-\u0010\u0080\u0001\u001a\u0012\u0012\u0004\u0012\u00020z0yj\b\u0012\u0004\u0012\u00020z`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010}\"\u0005\b\u0082\u0001\u0010\u007fR/\u0010\u0083\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0084\u00010yj\t\u0012\u0005\u0012\u00030\u0084\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010}\"\u0005\b\u0086\u0001\u0010\u007fR/\u0010\u0087\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0088\u00010yj\t\u0012\u0005\u0012\u00030\u0088\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010}\"\u0005\b\u008a\u0001\u0010\u007fR/\u0010\u008b\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0084\u00010yj\t\u0012\u0005\u0012\u00030\u0084\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010}\"\u0005\b\u008d\u0001\u0010\u007fR/\u0010\u008e\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0084\u00010yj\t\u0012\u0005\u0012\u00030\u0084\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010}\"\u0005\b\u0090\u0001\u0010\u007fR\u000f\u0010\u0091\u0001\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0092\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0084\u00010yj\t\u0012\u0005\u0012\u00030\u0084\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010}\"\u0005\b\u0094\u0001\u0010\u007fR/\u0010\u0095\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u0096\u00010yj\t\u0012\u0005\u0012\u00030\u0096\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010}\"\u0005\b\u0098\u0001\u0010\u007fR/\u0010\u0099\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u009a\u00010yj\t\u0012\u0005\u0012\u00030\u009a\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010}\"\u0005\b\u009c\u0001\u0010\u007fR/\u0010\u009d\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u009e\u00010yj\t\u0012\u0005\u0012\u00030\u009e\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010}\"\u0005\b \u0001\u0010\u007fR/\u0010¡\u0001\u001a\u0014\u0012\u0005\u0012\u00030¢\u00010yj\t\u0012\u0005\u0012\u00030¢\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010}\"\u0005\b¤\u0001\u0010\u007fR/\u0010¥\u0001\u001a\u0014\u0012\u0005\u0012\u00030¦\u00010yj\t\u0012\u0005\u0012\u00030¦\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010}\"\u0005\b¨\u0001\u0010\u007fR&\u0010©\u0001\u001a\t\u0012\u0004\u0012\u00020z0ª\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R/\u0010¯\u0001\u001a\u0014\u0012\u0005\u0012\u00030°\u00010yj\t\u0012\u0005\u0012\u00030°\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010}\"\u0005\b²\u0001\u0010\u007fR/\u0010³\u0001\u001a\u0014\u0012\u0005\u0012\u00030´\u00010yj\t\u0012\u0005\u0012\u00030´\u0001`{X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010}\"\u0005\b¶\u0001\u0010\u007fR\"\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R \u0010½\u0001\u001a\u00030¾\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R\u001d\u0010Ã\u0001\u001a\u00020\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0001\u00107\"\u0005\bÅ\u0001\u00109R'\u0010Æ\u0001\u001a\n\u0012\u0005\u0012\u00030Ç\u00010ª\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0001\u0010¬\u0001\"\u0006\bÉ\u0001\u0010®\u0001¨\u0006ê\u0001"}, d2 = {"Lcom/appnew/android/feeds/fragments/FeedsFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "<init>", "()V", "feedsBinding", "Lcom/appnew/android/databinding/FragmentFeedsBinding;", "getFeedsBinding", "()Lcom/appnew/android/databinding/FragmentFeedsBinding;", "setFeedsBinding", "(Lcom/appnew/android/databinding/FragmentFeedsBinding;)V", "feedViewModel", "Lcom/appnew/android/feeds/viewmodel/FeedViewModel;", "getFeedViewModel", "()Lcom/appnew/android/feeds/viewmodel/FeedViewModel;", "setFeedViewModel", "(Lcom/appnew/android/feeds/viewmodel/FeedViewModel;)V", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "refreshCount", "", "backBtn", "Landroid/widget/Button;", "getBackBtn", "()Landroid/widget/Button;", "setBackBtn", "(Landroid/widget/Button;)V", "feedJsonObject", "Lorg/json/JSONObject;", "isPullToRefresh", "", "()Z", "setPullToRefresh", "(Z)V", "liveClassStatus", "", "getLiveClassStatus", "()Ljava/lang/String;", "setLiveClassStatus", "(Ljava/lang/String;)V", "liveTestStatus", "getLiveTestStatus", "setLiveTestStatus", "section_posiiton", "getSection_posiiton", "setSection_posiiton", "response_booelan", "getResponse_booelan", "setResponse_booelan", "limitdata", "getLimitdata", "()I", "setLimitdata", "(I)V", "type_subcatfilter", "getType_subcatfilter", "setType_subcatfilter", "type_posttypefilter", "getType_posttypefilter", "setType_posttypefilter", "subcatspinner", "Landroid/widget/TextView;", "getSubcatspinner", "()Landroid/widget/TextView;", "setSubcatspinner", "(Landroid/widget/TextView;)V", "posttypeytext", "getPosttypeytext", "setPosttypeytext", "posttypename", "getPosttypename", "setPosttypename", "posttypeid", "getPosttypeid", "setPosttypeid", "feedAdapter", "Lcom/appnew/android/feeds/adapters/FeedAdapter;", "getFeedAdapter", "()Lcom/appnew/android/feeds/adapters/FeedAdapter;", "setFeedAdapter", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;)V", "loading", "getLoading", "setLoading", "no_data_found_RL", "Landroid/widget/RelativeLayout;", "getNo_data_found_RL", "()Landroid/widget/RelativeLayout;", "setNo_data_found_RL", "(Landroid/widget/RelativeLayout;)V", Const.CAT_ID, "getMain_cat", "setMain_cat", "main_cat_name", "getMain_cat_name", "setMain_cat_name", Const.SUB_CAT, "getSub_cat", "setSub_cat", "sub_cat_name", "getSub_cat_name", "setSub_cat_name", "sub_cat_filter", "getSub_cat_filter", "setSub_cat_filter", "sub_cat_name_filter", "getSub_cat_name_filter", "setSub_cat_name_filter", "is_filterbutton", "set_filterbutton", "master_cat", "getMaster_cat", "setMaster_cat", "master_cat_name", "getMaster_cat_name", "setMaster_cat_name", "selected_master_cat", "Ljava/util/ArrayList;", "Lcom/appnew/android/table/MasteAllCatTable;", "Lkotlin/collections/ArrayList;", "getSelected_master_cat", "()Ljava/util/ArrayList;", "setSelected_master_cat", "(Ljava/util/ArrayList;)V", "selectedsub_all_cat", "getSelectedsub_all_cat", "setSelectedsub_all_cat", "datalist", "Lcom/appnew/android/feeds/dataclass/Data;", "getDatalist", "setDatalist", "posttypelist", "Lcom/appnew/android/feeds/dataclass/PostType;", "getPosttypelist", "setPosttypelist", "posiitonwiselist", "getPosiitonwiselist", "setPosiitonwiselist", "pinnedPostList", "getPinnedPostList", "setPinnedPostList", "pinnedPost", "feedlist", "getFeedlist", "setFeedlist", "newCourseData", "Lcom/appnew/android/feeds/dataclass/NewCourseData;", "getNewCourseData", "setNewCourseData", "testResultList", "Lcom/appnew/android/feeds/dataclass/TestResult;", "getTestResultList", "setTestResultList", "liveTestData", "Lcom/appnew/android/home/livetest/LiveTestData;", "getLiveTestData", "setLiveTestData", "liveClassData", "Lcom/appnew/android/feeds/dataclass/Datum;", "getLiveClassData", "setLiveClassData", "bannert_list", "Lcom/appnew/android/feeds/dataclass/BannerData;", "getBannert_list", "setBannert_list", "masterAllCatTables", "", "getMasterAllCatTables", "()Ljava/util/List;", "setMasterAllCatTables", "(Ljava/util/List;)V", "mastercatlist", "Lcom/appnew/android/table/MasterCat;", "getMastercatlist", "setMastercatlist", "preferencesArrayList", "Lcom/appnew/android/pojo/Userinfo/Data$Preferences;", "getPreferencesArrayList", "setPreferencesArrayList", "popUp", "Landroid/widget/PopupWindow;", "getPopUp", "()Landroid/widget/PopupWindow;", "setPopUp", "(Landroid/widget/PopupWindow;)V", "locale_time", "", "getLocale_time", "()J", "setLocale_time", "(J)V", "page", "getPage", "setPage", "feedParentData", "Lcom/appnew/android/table/PostDataTable;", "getFeedParentData", "setFeedParentData", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", ViewHierarchyConstants.VIEW_KEY, "filterDailog", "local_data", "filter", "createApiBodyData", "setObservers", "updatePostData", "postData", "", "catregoryPost", "hitApiForLiveClass", "hitApiForLiveTest", "showProgressView", "hideProgressView", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "popupWindowPart", "openWebView", "data", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedsFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {
    private Button backBtn;
    private ArrayList<BannerData> bannert_list;
    private ArrayList<Data> datalist;
    private FeedAdapter feedAdapter;
    private JSONObject feedJsonObject;
    private List<PostDataTable> feedParentData;
    public FeedViewModel feedViewModel;
    private ArrayList<Data> feedlist;
    private FragmentFeedsBinding feedsBinding;
    private boolean isPullToRefresh;
    private boolean is_filterbutton;
    private int limitdata;
    private ArrayList<Datum> liveClassData;
    private String liveClassStatus;
    private ArrayList<LiveTestData> liveTestData;
    private String liveTestStatus;
    private boolean loading;
    private long locale_time;
    private String main_cat;
    private String main_cat_name;
    private List<? extends MasteAllCatTable> masterAllCatTables;
    private String master_cat;
    private String master_cat_name;
    private ArrayList<MasterCat> mastercatlist;
    private ArrayList<NewCourseData> newCourseData;
    private RelativeLayout no_data_found_RL;
    private int page;
    private String pinnedPost;
    private ArrayList<Data> pinnedPostList;
    private PopupWindow popUp;
    private ArrayList<Data> posiitonwiselist;
    private String posttypeid;
    private ArrayList<PostType> posttypelist;
    private String posttypename;
    private TextView posttypeytext;
    private ArrayList<Data.Preferences> preferencesArrayList;
    private int refreshCount;
    private boolean response_booelan;
    private String section_posiiton;
    private ArrayList<MasteAllCatTable> selected_master_cat;
    private ArrayList<MasteAllCatTable> selectedsub_all_cat;
    private String sub_cat;
    private String sub_cat_filter;
    private String sub_cat_name;
    private String sub_cat_name_filter;
    private TextView subcatspinner;
    private ArrayList<TestResult> testResultList;
    private boolean type_posttypefilter;
    private boolean type_subcatfilter;
    private UtkashRoom utkashRoom;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final FeedsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public FeedsFragment() {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        Intrinsics.checkNotNullExpressionValue(appDatabase, "getAppDatabase(...)");
        this.utkashRoom = appDatabase;
        this.liveClassStatus = "0";
        this.liveTestStatus = "0";
        this.section_posiiton = "0";
        this.posttypename = "All";
        this.posttypeid = "0";
        this.loading = true;
        this.main_cat = "";
        this.main_cat_name = "";
        this.sub_cat = "";
        this.sub_cat_name = "";
        this.sub_cat_filter = "";
        this.sub_cat_name_filter = "";
        this.master_cat = "";
        this.master_cat_name = "";
        this.selected_master_cat = new ArrayList<>();
        this.selectedsub_all_cat = new ArrayList<>();
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

    public final FragmentFeedsBinding getFeedsBinding() {
        return this.feedsBinding;
    }

    public final void setFeedsBinding(FragmentFeedsBinding fragmentFeedsBinding) {
        this.feedsBinding = fragmentFeedsBinding;
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

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
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

    public final List<PostDataTable> getFeedParentData() {
        return this.feedParentData;
    }

    public final void setFeedParentData(List<PostDataTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.feedParentData = list;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        Intrinsics.checkNotNull(aPIInterface);
        setFeedViewModel((FeedViewModel) new ViewModelProvider(this, new FeedViewModelProviderFactory(new Repository(aPIInterface), this.utkashRoom)).get(FeedViewModel.class));
        FragmentFeedsBinding fragmentFeedsBinding = (FragmentFeedsBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_feeds, container, false);
        this.feedsBinding = fragmentFeedsBinding;
        if (fragmentFeedsBinding != null) {
            fragmentFeedsBinding.setFeedbind(getFeedViewModel());
        }
        Intrinsics.checkNotNull(fragmentFeedsBinding);
        fragmentFeedsBinding.setLifecycleOwner(requireActivity());
        FragmentFeedsBinding fragmentFeedsBinding2 = this.feedsBinding;
        Intrinsics.checkNotNull(fragmentFeedsBinding2);
        View root = fragmentFeedsBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        initViews(root);
        FragmentFeedsBinding fragmentFeedsBinding3 = this.feedsBinding;
        Intrinsics.checkNotNull(fragmentFeedsBinding3);
        View root2 = fragmentFeedsBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        return root2;
    }

    private final void initViews(View view) {
        ImageView imageView;
        NestedScrollView nestedScrollView;
        RecyclerView recyclerView;
        TextView textView;
        SwipeRefreshLayout swipeRefreshLayout;
        try {
            Helper.enableScreenShot(requireActivity());
            this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) view.findViewById(R.id.backBtn);
            FragmentFeedsBinding fragmentFeedsBinding = this.feedsBinding;
            if (fragmentFeedsBinding != null && (swipeRefreshLayout = fragmentFeedsBinding.pulltoReferesh) != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
            this.preferencesArrayList = SharedPreference.getInstance().getLoggedInUser().getPreferences();
            this.locale_time = SharedPreference.getInstance().getLong("time");
            getFeedViewModel().getProgressvalue().setValue("1");
            FragmentFeedsBinding fragmentFeedsBinding2 = this.feedsBinding;
            if (fragmentFeedsBinding2 != null && (textView = fragmentFeedsBinding2.toolbartitleTV) != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05781(null), 3, null);
            FragmentFeedsBinding fragmentFeedsBinding3 = this.feedsBinding;
            if (fragmentFeedsBinding3 != null && (recyclerView = fragmentFeedsBinding3.feedRecyerlview) != null) {
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                this.feedAdapter = new FeedAdapter(this, fragmentActivityRequireActivity);
                recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
                recyclerView.setAdapter(this.feedAdapter);
            }
            setObservers();
            FragmentFeedsBinding fragmentFeedsBinding4 = this.feedsBinding;
            if (fragmentFeedsBinding4 != null && (nestedScrollView = fragmentFeedsBinding4.nestedScroll) != null) {
                nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda6
                    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                    public final void onScrollChange(NestedScrollView nestedScrollView2, int i, int i2, int i3, int i4) {
                        FeedsFragment.initViews$lambda$2(this.f$0, nestedScrollView2, i, i2, i3, i4);
                    }
                });
            }
            FragmentFeedsBinding fragmentFeedsBinding5 = this.feedsBinding;
            if (fragmentFeedsBinding5 != null && (imageView = fragmentFeedsBinding5.pinedPost) != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FeedsFragment.initViews$lambda$5(this.f$0, view2);
                    }
                });
            }
            FragmentFeedsBinding fragmentFeedsBinding6 = this.feedsBinding;
            Intrinsics.checkNotNull(fragmentFeedsBinding6);
            fragmentFeedsBinding6.filter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FeedsFragment.initViews$lambda$6(this.f$0);
                }
            }));
            if (StringsKt.equals("1", "1", true)) {
                FragmentFeedsBinding fragmentFeedsBinding7 = this.feedsBinding;
                Intrinsics.checkNotNull(fragmentFeedsBinding7);
                fragmentFeedsBinding7.imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FeedsFragment.initViews$lambda$7(this.f$0, view2);
                    }
                });
            }
            Button button = this.backBtn;
            Intrinsics.checkNotNull(button);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedsFragment.initViews$lambda$8(this.f$0, view2);
                }
            });
            FragmentFeedsBinding fragmentFeedsBinding8 = this.feedsBinding;
            Intrinsics.checkNotNull(fragmentFeedsBinding8);
            fragmentFeedsBinding8.titleinnerRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedsFragment.initViews$lambda$9(this.f$0, view2);
                }
            });
            FragmentFeedsBinding fragmentFeedsBinding9 = this.feedsBinding;
            Intrinsics.checkNotNull(fragmentFeedsBinding9);
            fragmentFeedsBinding9.pulltoReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda13
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    FeedsFragment.initViews$lambda$10(this.f$0);
                }
            });
        } catch (Exception e2) {
            getFeedViewModel().getProgressvalue().setValue("0");
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.fragments.FeedsFragment$initViews$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.fragments.FeedsFragment$initViews$1", f = "FeedsFragment.kt", i = {1}, l = {349, 363}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
    static final class C05781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C05781(Continuation<? super C05781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedsFragment.this.new C05781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:122:0x0499, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.appnew.android.feeds.fragments.FeedsFragment.C05781.C01141(r17.this$0, null), r17) == r3) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x04b8, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.appnew.android.feeds.fragments.FeedsFragment.C05781.AnonymousClass2(r17.this$0, null), r17) != r3) goto L127;
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x04ba, code lost:
        
            return r3;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 1217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.fragments.FeedsFragment.C05781.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.appnew.android.feeds.fragments.FeedsFragment$initViews$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FeedsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.feeds.fragments.FeedsFragment$initViews$1$1", f = "FeedsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FeedsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01141(FeedsFragment feedsFragment, Continuation<? super C01141> continuation) {
                super(2, continuation);
                this.this$0 = feedsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01141(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    FragmentFeedsBinding feedsBinding = this.this$0.getFeedsBinding();
                    if (feedsBinding != null && (textView2 = feedsBinding.toolbartitleTV) != null) {
                        textView2.setText(this.this$0.getMain_cat_name());
                    }
                } else {
                    FragmentFeedsBinding feedsBinding2 = this.this$0.getFeedsBinding();
                    if (feedsBinding2 != null && (textView = feedsBinding2.toolbartitleTV) != null) {
                        textView.setText("Discussion Forum");
                    }
                }
                FeedsFragment feedsFragment = this.this$0;
                feedsFragment.setPopUp(feedsFragment.popupWindowPart());
                this.this$0.local_data(false);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.appnew.android.feeds.fragments.FeedsFragment$initViews$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: FeedsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.feeds.fragments.FeedsFragment$initViews$1$2", f = "FeedsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FeedsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(FeedsFragment feedsFragment, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = feedsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
    public static final void initViews$lambda$2(FeedsFragment feedsFragment, NestedScrollView v, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (i2 == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight() && feedsFragment.loading && feedsFragment.limitdata <= feedsFragment.datalist.size() && Helper.isConnected(feedsFragment.requireActivity())) {
            feedsFragment.showProgressView();
            feedsFragment.page++;
            feedsFragment.createApiBodyData();
            feedsFragment.loading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5(FeedsFragment feedsFragment, View view) {
        if (Helper.isNetworkConnected(feedsFragment.requireActivity())) {
            Intent intent = new Intent(feedsFragment.requireActivity(), (Class<?>) PinnedPostActivity.class);
            intent.putExtra("maincat", feedsFragment.main_cat);
            intent.putExtra("mastercatid", feedsFragment.master_cat);
            intent.putExtra("subcatid", feedsFragment.sub_cat);
            Helper.gotoActivity(intent, feedsFragment.requireActivity());
            return;
        }
        Helper.showInternetToast(feedsFragment.requireActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViews$lambda$6(FeedsFragment feedsFragment) {
        if (Helper.isNetworkConnected(feedsFragment.requireActivity())) {
            feedsFragment.filterDailog();
        } else {
            Helper.showInternetToast(feedsFragment.requireActivity());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7(FeedsFragment feedsFragment, View view) {
        FragmentActivity fragmentActivityRequireActivity = feedsFragment.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.appnew.android.Theme.DashboardActivityTheme1");
        if (((DashboardActivityTheme1) fragmentActivityRequireActivity).binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            FragmentActivity fragmentActivityRequireActivity2 = feedsFragment.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity2, "null cannot be cast to non-null type com.appnew.android.Theme.DashboardActivityTheme1");
            ((DashboardActivityTheme1) fragmentActivityRequireActivity2).binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            FragmentActivity fragmentActivityRequireActivity3 = feedsFragment.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity3, "null cannot be cast to non-null type com.appnew.android.Theme.DashboardActivityTheme1");
            ((DashboardActivityTheme1) fragmentActivityRequireActivity3).binding.drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8(FeedsFragment feedsFragment, View view) {
        feedsFragment.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$9(FeedsFragment feedsFragment, View view) {
        if (StringsKt.equals("1", "7", true) || StringsKt.equals(BuildConfig.FLAVOR, "KSRAnatomyClasses", true)) {
            return;
        }
        if (!Helper.isNetworkConnected(feedsFragment.requireActivity())) {
            Helper.showInternetToast(feedsFragment.requireActivity());
            return;
        }
        PopupWindow popupWindow = feedsFragment.popUp;
        Intrinsics.checkNotNull(popupWindow);
        FragmentFeedsBinding fragmentFeedsBinding = feedsFragment.feedsBinding;
        Intrinsics.checkNotNull(fragmentFeedsBinding);
        popupWindow.showAsDropDown(fragmentFeedsBinding.titleinnerRL, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10(FeedsFragment feedsFragment) {
        if (Helper.isConnected(feedsFragment.requireActivity())) {
            if (!feedsFragment.response_booelan) {
                feedsFragment.response_booelan = true;
                FeedAdapter feedAdapter = feedsFragment.feedAdapter;
                Intrinsics.checkNotNull(feedAdapter);
                if (feedAdapter.getTimer() != null) {
                    FeedAdapter feedAdapter2 = feedsFragment.feedAdapter;
                    Intrinsics.checkNotNull(feedAdapter2);
                    Timer timer = feedAdapter2.getTimer();
                    Intrinsics.checkNotNull(timer);
                    timer.cancel();
                    FeedAdapter feedAdapter3 = feedsFragment.feedAdapter;
                    Intrinsics.checkNotNull(feedAdapter3);
                    Timer timer2 = feedAdapter3.getTimer();
                    Intrinsics.checkNotNull(timer2);
                    timer2.purge();
                }
                feedsFragment.posttypename = "All";
                feedsFragment.posttypeid = "0";
                feedsFragment.isPullToRefresh = true;
                FragmentFeedsBinding fragmentFeedsBinding = feedsFragment.feedsBinding;
                Intrinsics.checkNotNull(fragmentFeedsBinding);
                fragmentFeedsBinding.filter.setImageResource(R.mipmap.filter_icon);
                FragmentFeedsBinding fragmentFeedsBinding2 = feedsFragment.feedsBinding;
                Intrinsics.checkNotNull(fragmentFeedsBinding2);
                fragmentFeedsBinding2.pulltoReferesh.setRefreshing(false);
                feedsFragment.page = 1;
                feedsFragment.sub_cat_name = "All";
                feedsFragment.sub_cat = "0";
                feedsFragment.section_posiiton = "0";
                feedsFragment.loading = true;
                feedsFragment.datalist.clear();
                feedsFragment.feedlist.clear();
                feedsFragment.posiitonwiselist.clear();
                feedsFragment.pinnedPostList.clear();
                feedsFragment.createApiBodyData();
                return;
            }
            FragmentFeedsBinding fragmentFeedsBinding3 = feedsFragment.feedsBinding;
            Intrinsics.checkNotNull(fragmentFeedsBinding3);
            fragmentFeedsBinding3.pulltoReferesh.setRefreshing(false);
            return;
        }
        Toast.makeText(feedsFragment.requireActivity(), "No Internet Connection", 0).show();
    }

    private final void filterDailog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireActivity(), R.style.videosheetDialogTheme);
        bottomSheetDialog.setContentView(R.layout.feed_filter);
        ((Window) Objects.requireNonNull(bottomSheetDialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
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
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsFragment.filterDailog$lambda$11(this.f$0, relativeLayout, view);
            }
        });
        if (StringsKt.equals("1", "7", true) || StringsKt.equals(BuildConfig.FLAVOR, "KSRAnatomyClasses", true)) {
            relativeLayout.setVisibility(8);
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
        }
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsFragment.filterDailog$lambda$12(this.f$0, relativeLayout2, view);
            }
        });
        TextView textView5 = this.posttypeytext;
        Intrinsics.checkNotNull(textView5);
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsFragment.filterDailog$lambda$13(this.f$0, relativeLayout2, view);
            }
        });
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsFragment.filterDailog$lambda$14(this.f$0, bottomSheetDialog, view);
            }
        });
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsFragment.filterDailog$lambda$15(this.f$0, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FeedsFragment.filterDailog$lambda$16(this.f$0, dialogInterface);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$11(FeedsFragment feedsFragment, RelativeLayout relativeLayout, View view) {
        PopupMenu popupMenu = new PopupMenu(feedsFragment.requireActivity(), relativeLayout, 3);
        popupMenu.getMenu().add("All");
        int size = feedsFragment.selectedsub_all_cat.size();
        for (int i = 0; i < size; i++) {
            popupMenu.getMenu().add(feedsFragment.selectedsub_all_cat.get(i).getName());
        }
        popupMenu.setOnMenuItemClickListener(feedsFragment);
        popupMenu.show();
        feedsFragment.type_subcatfilter = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$12(FeedsFragment feedsFragment, RelativeLayout relativeLayout, View view) {
        PopupMenu popupMenu = new PopupMenu(feedsFragment.requireActivity(), relativeLayout, 3);
        int size = feedsFragment.posttypelist.size();
        for (int i = 0; i < size; i++) {
            popupMenu.getMenu().add(feedsFragment.posttypelist.get(i).getTitle());
        }
        popupMenu.setOnMenuItemClickListener(feedsFragment);
        popupMenu.show();
        feedsFragment.type_posttypefilter = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$13(FeedsFragment feedsFragment, RelativeLayout relativeLayout, View view) {
        PopupMenu popupMenu = new PopupMenu(feedsFragment.requireActivity(), relativeLayout, 3);
        int size = feedsFragment.posttypelist.size();
        for (int i = 0; i < size; i++) {
            popupMenu.getMenu().add(feedsFragment.posttypelist.get(i).getTitle());
        }
        popupMenu.setOnMenuItemClickListener(feedsFragment);
        popupMenu.show();
        feedsFragment.type_posttypefilter = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$14(FeedsFragment feedsFragment, BottomSheetDialog bottomSheetDialog, View view) {
        feedsFragment.type_subcatfilter = false;
        feedsFragment.type_posttypefilter = false;
        feedsFragment.sub_cat_filter = "";
        feedsFragment.sub_cat_name_filter = "";
        feedsFragment.is_filterbutton = false;
        bottomSheetDialog.dismiss();
        bottomSheetDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$15(FeedsFragment feedsFragment, BottomSheetDialog bottomSheetDialog, View view) {
        feedsFragment.getFeedViewModel().getProgressvalue().setValue("1");
        FeedAdapter feedAdapter = feedsFragment.feedAdapter;
        Intrinsics.checkNotNull(feedAdapter);
        if (feedAdapter.getTimer() != null) {
            FeedAdapter feedAdapter2 = feedsFragment.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter2);
            Timer timer = feedAdapter2.getTimer();
            Intrinsics.checkNotNull(timer);
            timer.cancel();
            FeedAdapter feedAdapter3 = feedsFragment.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter3);
            Timer timer2 = feedAdapter3.getTimer();
            Intrinsics.checkNotNull(timer2);
            timer2.purge();
        }
        if (feedsFragment.sub_cat_filter.length() > 0) {
            feedsFragment.sub_cat = feedsFragment.sub_cat_filter;
            feedsFragment.sub_cat_name = feedsFragment.sub_cat_name_filter;
        }
        FragmentFeedsBinding fragmentFeedsBinding = feedsFragment.feedsBinding;
        Intrinsics.checkNotNull(fragmentFeedsBinding);
        ImageView imageView = fragmentFeedsBinding.filter;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageResource(R.mipmap.filter_icon_tick);
        feedsFragment.page = 1;
        feedsFragment.sub_cat_filter = "";
        feedsFragment.sub_cat_name_filter = "";
        feedsFragment.datalist.clear();
        feedsFragment.feedlist.clear();
        feedsFragment.posiitonwiselist.clear();
        feedsFragment.pinnedPostList.clear();
        feedsFragment.is_filterbutton = true;
        feedsFragment.createApiBodyData();
        bottomSheetDialog.dismiss();
        bottomSheetDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterDailog$lambda$16(FeedsFragment feedsFragment, DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        dialogInterface.cancel();
        feedsFragment.type_subcatfilter = false;
        feedsFragment.type_posttypefilter = false;
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
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05791(null), 3, null);
            RelativeLayout relativeLayout = this.no_data_found_RL;
            Intrinsics.checkNotNull(relativeLayout);
            if (relativeLayout.getVisibility() == 0) {
                RelativeLayout relativeLayout2 = this.no_data_found_RL;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(8);
                FragmentFeedsBinding fragmentFeedsBinding = this.feedsBinding;
                Intrinsics.checkNotNull(fragmentFeedsBinding);
                fragmentFeedsBinding.pulltoReferesh.setVisibility(0);
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
            for (PostDataTable postDataTable : this.feedParentData) {
                String created = postDataTable.getCreated();
                String id = postDataTable.getId();
                Object objFromJson = new Gson().fromJson(postDataTable.getJson(), new TypeToken<Json>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$local_data$data$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                Json json = (Json) objFromJson;
                String meta_url = postDataTable.getMeta_url();
                String thumbnail = postDataTable.getThumbnail();
                String url = postDataTable.getUrl();
                String modified = postDataTable.getModified();
                String my_like = postDataTable.getMy_like();
                String name = postDataTable.getName();
                String post_type = postDataTable.getPost_type();
                String profile_picture = postDataTable.getProfile_picture();
                String status = postDataTable.getStatus();
                String sub_cat_id = postDataTable.getSub_cat_id();
                String text = postDataTable.getText();
                String total_comments = postDataTable.getTotal_comments();
                String total_likes = postDataTable.getTotal_likes();
                String user_id = postDataTable.getUser_id();
                List list3 = (List) new Gson().fromJson(postDataTable.getNewCourseData(), new TypeToken<List<? extends NewCourseData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$local_data$data$2
                }.getType());
                List list4 = (List) new Gson().fromJson(postDataTable.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$local_data$data$3
                }.getType());
                List list5 = (List) new Gson().fromJson(postDataTable.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$local_data$data$4
                }.getType());
                List list6 = (List) new Gson().fromJson(postDataTable.getTestResult(), new TypeToken<List<? extends TestResult>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$local_data$data$5
                }.getType());
                List list7 = (List) new Gson().fromJson(postDataTable.getBannerlist(), new TypeToken<List<? extends BannerData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$local_data$data$6
                }.getType());
                String iscommentenable = postDataTable.getIscommentenable();
                String my_pinned = postDataTable.getMy_pinned();
                String str = my_pinned == null ? "0" : my_pinned;
                String description = postDataTable.getDescription();
                String str2 = description == null ? "" : description;
                String parentId = postDataTable.getParentId();
                String masterCat = postDataTable.getMasterCat();
                String sub_cat_id2 = postDataTable.getSub_cat_id();
                String schedule_date = postDataTable.getSchedule_date();
                Intrinsics.checkNotNull(schedule_date);
                com.appnew.android.feeds.dataclass.Data data = new com.appnew.android.feeds.dataclass.Data(false, created, id, json, meta_url, "", thumbnail, url, modified, my_like, name, post_type, profile_picture, status, sub_cat_id, text, total_comments, total_likes, user_id, list3, list4, list5, list6, list7, iscommentenable, null, 0, str, str2, parentId, masterCat, sub_cat_id2, schedule_date, null, 100663296, 2, null);
                if (TextUtils.isEmpty(data.getSchedule_date()) || Long.parseLong(data.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                    this.datalist.add(data);
                }
                if (Intrinsics.areEqual(postDataTable.getLiveClassStatus(), "1")) {
                    this.liveClassData = (ArrayList) new Gson().fromJson(postDataTable.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment.local_data.2
                    }.getType());
                }
                if (Intrinsics.areEqual(postDataTable.getLiveTestStatus(), "1")) {
                    this.liveTestData = (ArrayList) new Gson().fromJson(postDataTable.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment.local_data.3
                    }.getType());
                }
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
            Iterator<com.appnew.android.feeds.dataclass.Data> it = this.datalist.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                com.appnew.android.feeds.dataclass.Data next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                com.appnew.android.feeds.dataclass.Data data2 = next;
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

    /* JADX INFO: renamed from: com.appnew.android.feeds.fragments.FeedsFragment$local_data$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.fragments.FeedsFragment$local_data$1", f = "FeedsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05791(Continuation<? super C05791> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedsFragment.this.new C05791(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FeedsFragment.this.getPosttypelist().clear();
            if (SharedPreference.getInstance().getString(Const.POST_TYPE) != null) {
                String string = SharedPreference.getInstance().getString(Const.POST_TYPE);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (string.length() > 0) {
                    JSONArray jSONArray = new JSONArray(SharedPreference.getInstance().getString(Const.POST_TYPE));
                    IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
                    FeedsFragment feedsFragment = FeedsFragment.this;
                    Iterator<Integer> it = intRangeUntil.iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(((IntIterator) it).nextInt());
                        Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                        feedsFragment.getPosttypelist().add((PostType) new Gson().fromJson(jSONObjectOptJSONObject.toString(), PostType.class));
                    }
                    FeedsFragment.this.getPosttypelist().add(0, new PostType("0", "All"));
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
        getFeedViewModel().getProgressvalue().observe(requireActivity(), new FeedsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsFragment.setObservers$lambda$18(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getBodydata().observe(requireActivity(), new FeedsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsFragment.setObservers$lambda$19(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getAdapter_bodydata().observe(requireActivity(), new FeedsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsFragment.setObservers$lambda$20(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getAdapter_response().observe(requireActivity(), new FeedsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsFragment.setObservers$lambda$28(this.f$0, (JSONObject) obj);
            }
        }));
        getFeedViewModel().getJsonObjectmutable().observe(requireActivity(), new FeedsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsFragment.setObservers$lambda$34(this.f$0, (JSONObject) obj);
            }
        }));
        getFeedViewModel().getMutableLiveClassData().observe(requireActivity(), new FeedsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsFragment.setObservers$lambda$35(this.f$0, (JSONObject) obj);
            }
        }));
        getFeedViewModel().getMutableLiveTestData().observe(requireActivity(), new FeedsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedsFragment.setObservers$lambda$37(this.f$0, (JSONObject) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$18(FeedsFragment feedsFragment, String str) {
        if (str.equals("0")) {
            Helper.dismissProgressDialog();
        } else {
            Helper.showProgressDialog(feedsFragment.requireActivity());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$19(FeedsFragment feedsFragment, String str) {
        if (str != null) {
            feedsFragment.getFeedViewModel().getFeedData();
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
    public static final kotlin.Unit setObservers$lambda$20(com.appnew.android.feeds.fragments.FeedsFragment r1, java.lang.String r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.fragments.FeedsFragment.setObservers$lambda$20(com.appnew.android.feeds.fragments.FeedsFragment, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da A[Catch: Exception -> 0x00f6, TryCatch #0 {Exception -> 0x00f6, blocks: (B:4:0x0006, B:6:0x0014, B:8:0x0024, B:12:0x0033, B:15:0x003d, B:17:0x0045, B:18:0x004d, B:21:0x0057, B:22:0x0074, B:25:0x007e, B:26:0x0088, B:29:0x0091, B:30:0x00ad, B:33:0x00b6, B:34:0x00bf, B:37:0x00c8, B:38:0x00da, B:40:0x00e6, B:42:0x00ed), top: B:48:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit setObservers$lambda$28(com.appnew.android.feeds.fragments.FeedsFragment r6, org.json.JSONObject r7) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.fragments.FeedsFragment.setObservers$lambda$28(com.appnew.android.feeds.fragments.FeedsFragment, org.json.JSONObject):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$34(FeedsFragment feedsFragment, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        int i;
        int i2;
        JSONObject jSONObject4;
        long jOptLong;
        int i3;
        int i4;
        if (jSONObject != null) {
            feedsFragment.hideProgressView();
            feedsFragment.response_booelan = false;
            if (Intrinsics.areEqual(jSONObject.optString("status"), "true")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("data");
                Intrinsics.checkNotNullExpressionValue(jSONObject5, "getJSONObject(...)");
                feedsFragment.feedJsonObject = jSONObject5;
                if (jSONObject5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                    jSONObject2 = null;
                } else {
                    jSONObject2 = jSONObject5;
                }
                JSONArray jSONArray = jSONObject2.getJSONArray(Const.posts);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                if (jSONArray.length() > 0) {
                    RelativeLayout relativeLayout = feedsFragment.no_data_found_RL;
                    Intrinsics.checkNotNull(relativeLayout);
                    if (relativeLayout.getVisibility() == 0) {
                        RelativeLayout relativeLayout2 = feedsFragment.no_data_found_RL;
                        Intrinsics.checkNotNull(relativeLayout2);
                        relativeLayout2.setVisibility(8);
                        FragmentFeedsBinding fragmentFeedsBinding = feedsFragment.feedsBinding;
                        Intrinsics.checkNotNull(fragmentFeedsBinding);
                        fragmentFeedsBinding.pulltoReferesh.setVisibility(0);
                    }
                    if (feedsFragment.isPullToRefresh) {
                        feedsFragment.limitdata = 0;
                    }
                    feedsFragment.limitdata += jSONObject.optInt(Constants.KEY_LIMIT);
                    int i5 = feedsFragment.page;
                    if (i5 == 1) {
                        JSONObject jSONObject6 = feedsFragment.feedJsonObject;
                        if (jSONObject6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject6 = null;
                        }
                        if (jSONObject6.has(Const.POST_TYPE)) {
                            JSONObject jSONObject7 = feedsFragment.feedJsonObject;
                            if (jSONObject7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                                jSONObject7 = null;
                            }
                            JSONArray jSONArray2 = jSONObject7.getJSONArray(Const.POST_TYPE);
                            Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
                            SharedPreference.getInstance().putString(Const.POST_TYPE, jSONArray2.toString());
                            feedsFragment.posttypelist.clear();
                            Iterator<Integer> it = RangesKt.until(0, jSONArray2.length()).iterator();
                            while (it.hasNext()) {
                                JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(((IntIterator) it).nextInt());
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                                feedsFragment.posttypelist.add((PostType) new Gson().fromJson(jSONObjectOptJSONObject.toString(), PostType.class));
                            }
                        }
                        feedsFragment.posttypelist.add(0, new PostType("", "All"));
                        if (feedsFragment.isPullToRefresh) {
                            if (feedsFragment.refreshCount >= 2) {
                                feedsFragment.utkashRoom.getFeedDao().deletePosts_via_id(feedsFragment.main_cat);
                            } else {
                                feedsFragment.utkashRoom.getFeedDao().deleteSubCatFeed(feedsFragment.main_cat, feedsFragment.sub_cat, "1092", "1093");
                            }
                        }
                        JSONObject jSONObject8 = feedsFragment.feedJsonObject;
                        if (jSONObject8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject8 = null;
                        }
                        if (jSONObject8.has("section_position")) {
                            JSONObject jSONObject9 = feedsFragment.feedJsonObject;
                            if (jSONObject9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                                jSONObject9 = null;
                            }
                            feedsFragment.section_posiiton = jSONObject9.optString("section_position");
                        }
                        JSONObject jSONObject10 = feedsFragment.feedJsonObject;
                        if (jSONObject10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject10 = null;
                        }
                        JSONArray jSONArray3 = jSONObject10.getJSONArray(Const.banners);
                        Intrinsics.checkNotNullExpressionValue(jSONArray3, "getJSONArray(...)");
                        feedsFragment.bannert_list.clear();
                        feedsFragment.datalist.clear();
                        feedsFragment.newCourseData.clear();
                        feedsFragment.testResultList.clear();
                        feedsFragment.posiitonwiselist.clear();
                        feedsFragment.feedlist.clear();
                        if (jSONArray3.length() > 0) {
                            int length = jSONArray3.length();
                            for (int i6 = 0; i6 < length; i6++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArray3.optJSONObject(i6);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(...)");
                                feedsFragment.bannert_list.add((BannerData) new Gson().fromJson(jSONObjectOptJSONObject2.toString(), BannerData.class));
                            }
                            Json json = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                            feedsFragment.datalist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json, "", "", "", "", "", "", "", "1089", "", "", "", "", "", "", "", feedsFragment.newCourseData, feedsFragment.liveTestData, feedsFragment.liveClassData, feedsFragment.testResultList, feedsFragment.bannert_list, "0", feedsFragment.section_posiiton, feedsFragment.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                            if (!feedsFragment.is_filterbutton) {
                                PostDataTable postDataTable = new PostDataTable();
                                postDataTable.setCreated("");
                                postDataTable.setId("");
                                postDataTable.setParentId(feedsFragment.master_cat);
                                postDataTable.setMasterCat(feedsFragment.main_cat);
                                postDataTable.setSub_cat_id(feedsFragment.sub_cat);
                                postDataTable.setJson(new Gson().toJson(json));
                                postDataTable.setMeta_url("");
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
                                postDataTable.setNewCourseData(new Gson().toJson(feedsFragment.newCourseData));
                                postDataTable.setLivetest(new Gson().toJson(feedsFragment.liveTestData));
                                postDataTable.setLiveclass(new Gson().toJson(feedsFragment.liveClassData));
                                postDataTable.setTestResult(new Gson().toJson(feedsFragment.testResultList));
                                postDataTable.setBannerlist(new Gson().toJson(feedsFragment.bannert_list));
                                postDataTable.setLiveClassStatus("0");
                                postDataTable.setLiveTestStatus("0");
                                postDataTable.setPage(String.valueOf(feedsFragment.page));
                                postDataTable.setIscommentenable("0");
                                postDataTable.setSectionposiiton(feedsFragment.section_posiiton);
                                postDataTable.setLimit(String.valueOf(feedsFragment.limitdata));
                                postDataTable.setMy_pinned(feedsFragment.pinnedPost);
                                feedsFragment.utkashRoom.getFeedDao().insertPost(postDataTable);
                            }
                        }
                        if (feedsFragment.is_filterbutton) {
                            int length2 = jSONArray.length();
                            int i7 = 0;
                            while (i7 < length2) {
                                JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i7);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject3, "optJSONObject(...)");
                                com.appnew.android.feeds.dataclass.Data data = (com.appnew.android.feeds.dataclass.Data) new Gson().fromJson(jSONObjectOptJSONObject3.toString(), com.appnew.android.feeds.dataclass.Data.class);
                                if (TextUtils.isEmpty(data.getSchedule_date())) {
                                    i3 = length2;
                                    i4 = i7;
                                    Boolean.valueOf(feedsFragment.datalist.add(data));
                                } else {
                                    i3 = length2;
                                    i4 = i7;
                                    if (Long.parseLong(data.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                                        feedsFragment.datalist.add(data);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                                i7 = i4 + 1;
                                length2 = i3;
                            }
                        } else {
                            int length3 = jSONArray.length();
                            int i8 = 0;
                            while (i8 < length3) {
                                JSONObject jSONObjectOptJSONObject4 = jSONArray.optJSONObject(i8);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject4, "optJSONObject(...)");
                                com.appnew.android.feeds.dataclass.Data data2 = (com.appnew.android.feeds.dataclass.Data) new Gson().fromJson(jSONObjectOptJSONObject4.toString(), com.appnew.android.feeds.dataclass.Data.class);
                                if (TextUtils.isEmpty(data2.getSchedule_date())) {
                                    i = length3;
                                    i2 = i8;
                                    Boolean.valueOf(feedsFragment.datalist.add(data2));
                                } else {
                                    i = length3;
                                    i2 = i8;
                                    if (Long.parseLong(data2.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                                        feedsFragment.datalist.add(data2);
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                PostDataTable postDataTable2 = new PostDataTable();
                                postDataTable2.setCreated(data2.getCreated());
                                postDataTable2.setId(data2.getId());
                                postDataTable2.setJson(new Gson().toJson(data2.getJson()));
                                postDataTable2.setMeta_url(data2.getMeta_url());
                                postDataTable2.setThumbnail(data2.getThumbnail());
                                String url = data2.getUrl();
                                if (url == null) {
                                    url = "";
                                }
                                postDataTable2.setUrl(url);
                                postDataTable2.setModified(data2.getModified());
                                postDataTable2.setMy_like(data2.getMy_like());
                                String name = data2.getName();
                                Intrinsics.checkNotNull(name);
                                postDataTable2.setName(name);
                                postDataTable2.setPost_type(data2.getPost_type());
                                String profile_picture = data2.getProfile_picture();
                                Intrinsics.checkNotNull(profile_picture);
                                postDataTable2.setProfile_picture(profile_picture);
                                postDataTable2.setStatus(data2.getStatus());
                                postDataTable2.setParentId(feedsFragment.master_cat);
                                postDataTable2.setMasterCat(feedsFragment.main_cat);
                                postDataTable2.setSub_cat_id(feedsFragment.sub_cat);
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
                                postDataTable2.setPage(String.valueOf(feedsFragment.page));
                                postDataTable2.setIscommentenable(data2.getIs_comment_enable());
                                postDataTable2.setSectionposiiton(feedsFragment.section_posiiton);
                                postDataTable2.setLimit(String.valueOf(feedsFragment.limitdata));
                                postDataTable2.setMy_pinned(data2.getMy_pinned());
                                postDataTable2.setDescription(data2.getDescription());
                                postDataTable2.setSchedule_date(data2.getSchedule_date());
                                feedsFragment.utkashRoom.getFeedDao().insertPost(postDataTable2);
                                i8 = i2 + 1;
                                length3 = i;
                            }
                        }
                        JSONObject jSONObject11 = feedsFragment.feedJsonObject;
                        if (jSONObject11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject11 = null;
                        }
                        JSONArray jSONArray4 = jSONObject11.getJSONArray("new_courses");
                        Intrinsics.checkNotNullExpressionValue(jSONArray4, "getJSONArray(...)");
                        if (jSONArray4.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            int length4 = jSONArray4.length();
                            for (int i9 = 0; i9 < length4; i9++) {
                                JSONObject jSONObjectOptJSONObject5 = jSONArray4.optJSONObject(i9);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject5, "optJSONObject(...)");
                                feedsFragment.newCourseData.add((NewCourseData) new Gson().fromJson(jSONObjectOptJSONObject5.toString(), NewCourseData.class));
                            }
                            Json json2 = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                            feedsFragment.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json2, "", "", "", "", "", "", "", "1090", "", "", "", "", "", "", "", feedsFragment.newCourseData, feedsFragment.liveTestData, feedsFragment.liveClassData, feedsFragment.testResultList, arrayList, "0", feedsFragment.section_posiiton, feedsFragment.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                            if (!feedsFragment.is_filterbutton) {
                                PostDataTable postDataTable3 = new PostDataTable();
                                postDataTable3.setCreated("");
                                postDataTable3.setId("");
                                postDataTable3.setJson(new Gson().toJson(json2));
                                postDataTable3.setMeta_url("");
                                postDataTable3.setThumbnail("");
                                postDataTable3.setUrl("");
                                postDataTable3.setModified("");
                                postDataTable3.setMy_like("");
                                postDataTable3.setName("");
                                postDataTable3.setPost_type("1090");
                                postDataTable3.setProfile_picture("");
                                postDataTable3.setStatus("");
                                postDataTable3.setParentId(feedsFragment.master_cat);
                                postDataTable3.setMasterCat(feedsFragment.main_cat);
                                postDataTable3.setSub_cat_id(feedsFragment.sub_cat);
                                postDataTable3.setText("");
                                postDataTable3.setTotal_comments("");
                                postDataTable3.setTotal_likes("");
                                postDataTable3.setUser_id("");
                                postDataTable3.setNewCourseData(new Gson().toJson(feedsFragment.newCourseData));
                                postDataTable3.setLivetest(new Gson().toJson(feedsFragment.liveTestData));
                                postDataTable3.setLiveclass(new Gson().toJson(feedsFragment.liveClassData));
                                postDataTable3.setTestResult(new Gson().toJson(feedsFragment.testResultList));
                                postDataTable3.setBannerlist(new Gson().toJson(arrayList));
                                postDataTable3.setLiveClassStatus("0");
                                postDataTable3.setLiveTestStatus("0");
                                postDataTable3.setPage(String.valueOf(feedsFragment.page));
                                postDataTable3.setIscommentenable("0");
                                postDataTable3.setSectionposiiton(feedsFragment.section_posiiton);
                                postDataTable3.setLimit(String.valueOf(feedsFragment.limitdata));
                                postDataTable3.setMy_pinned(feedsFragment.pinnedPost);
                                feedsFragment.utkashRoom.getFeedDao().insertPost(postDataTable3);
                            }
                        }
                        JSONObject jSONObject12 = feedsFragment.feedJsonObject;
                        if (jSONObject12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject4 = null;
                        } else {
                            jSONObject4 = jSONObject12;
                        }
                        JSONArray jSONArray5 = jSONObject4.getJSONArray("results");
                        Intrinsics.checkNotNullExpressionValue(jSONArray5, "getJSONArray(...)");
                        if (jSONArray5.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            int length5 = jSONArray5.length();
                            for (int i10 = 0; i10 < length5; i10++) {
                                JSONObject jSONObjectOptJSONObject6 = jSONArray5.optJSONObject(i10);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject6, "optJSONObject(...)");
                                feedsFragment.testResultList.add((TestResult) new Gson().fromJson(jSONObjectOptJSONObject6.toString(), TestResult.class));
                            }
                            Json json3 = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                            feedsFragment.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json3, "", "", "", "", "", "", "", "1091", "", "", "", "", "", "", "", arrayList3, feedsFragment.liveTestData, feedsFragment.liveClassData, feedsFragment.testResultList, arrayList2, "0", feedsFragment.section_posiiton, feedsFragment.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                            if (!feedsFragment.is_filterbutton) {
                                PostDataTable postDataTable4 = new PostDataTable();
                                postDataTable4.setCreated("");
                                postDataTable4.setId("");
                                postDataTable4.setJson(new Gson().toJson(json3));
                                postDataTable4.setMeta_url("");
                                postDataTable4.setThumbnail("");
                                postDataTable4.setUrl("");
                                postDataTable4.setModified("");
                                postDataTable4.setMy_like("");
                                postDataTable4.setName("");
                                postDataTable4.setPost_type("1091");
                                postDataTable4.setParentId(feedsFragment.master_cat);
                                postDataTable4.setMasterCat(feedsFragment.main_cat);
                                postDataTable4.setSub_cat_id(feedsFragment.sub_cat);
                                postDataTable4.setProfile_picture("");
                                postDataTable4.setStatus("");
                                postDataTable4.setText("");
                                postDataTable4.setTotal_comments("");
                                postDataTable4.setTotal_likes("");
                                postDataTable4.setUser_id("");
                                postDataTable4.setNewCourseData(new Gson().toJson(arrayList3));
                                postDataTable4.setLivetest(new Gson().toJson(feedsFragment.liveTestData));
                                postDataTable4.setLiveclass(new Gson().toJson(feedsFragment.liveClassData));
                                postDataTable4.setTestResult(new Gson().toJson(feedsFragment.testResultList));
                                postDataTable4.setBannerlist(new Gson().toJson(arrayList2));
                                postDataTable4.setLiveClassStatus("0");
                                postDataTable4.setLiveTestStatus("0");
                                postDataTable4.setPage(String.valueOf(feedsFragment.page));
                                postDataTable4.setIscommentenable("0");
                                postDataTable4.setSectionposiiton(feedsFragment.section_posiiton);
                                postDataTable4.setLimit(String.valueOf(feedsFragment.limitdata));
                                postDataTable4.setMy_pinned(feedsFragment.pinnedPost);
                                postDataTable4.setSchedule_date("");
                                feedsFragment.utkashRoom.getFeedDao().insertPost(postDataTable4);
                            }
                        }
                        long jOptLong2 = jSONObject5.optLong("time") * ((long) 1000);
                        if (!feedsFragment.liveClassData.isEmpty()) {
                            jOptLong = feedsFragment.liveClassData.get(r3.size() - 1).getCd_time();
                        } else if (feedsFragment.liveTestData.isEmpty()) {
                            jOptLong = jSONObject5.optLong("cd_time");
                        } else {
                            jOptLong = feedsFragment.liveTestData.get(r3.size() - 1).getCd_time();
                        }
                        long minutes = TimeUnit.MILLISECONDS.toMinutes(jOptLong2 - jOptLong);
                        if (feedsFragment.isPullToRefresh) {
                            feedsFragment.isPullToRefresh = false;
                            int i11 = feedsFragment.refreshCount;
                            if (i11 == 2 || minutes >= 10) {
                                feedsFragment.refreshCount = 0;
                                feedsFragment.hitApiForLiveClass();
                            } else {
                                feedsFragment.refreshCount = i11 + 1;
                                ArrayList arrayList4 = new ArrayList();
                                ArrayList arrayList5 = new ArrayList();
                                if (feedsFragment.posttypeid.equals("0")) {
                                    List<PostDataTable> listRetrievePostData = feedsFragment.utkashRoom.getFeedDao().retrievePostData(feedsFragment.master_cat, feedsFragment.main_cat, feedsFragment.sub_cat);
                                    Intrinsics.checkNotNull(listRetrievePostData);
                                    feedsFragment.updatePostData(listRetrievePostData);
                                } else {
                                    List<PostDataTable> listRetrievePostData_viaposttype = feedsFragment.utkashRoom.getFeedDao().retrievePostData_viaposttype(feedsFragment.master_cat, feedsFragment.main_cat, feedsFragment.sub_cat, feedsFragment.posttypeid);
                                    Intrinsics.checkNotNull(listRetrievePostData_viaposttype);
                                    feedsFragment.updatePostData(listRetrievePostData_viaposttype);
                                }
                                if (!feedsFragment.liveClassData.isEmpty()) {
                                    feedsFragment.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", new Json("", arrayList5, "", "", "", "", "", "", ""), "", "", "", "", "", "", "", "1093", "", "", "", "", "", "", "", feedsFragment.newCourseData, feedsFragment.liveTestData, feedsFragment.liveClassData, feedsFragment.testResultList, arrayList4, "0", feedsFragment.section_posiiton, feedsFragment.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                                }
                                if (!feedsFragment.liveTestData.isEmpty()) {
                                    feedsFragment.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", new Json("", arrayList5, "", "", "", "", "", "", ""), "", "", "", "", "", "", "", "1092", "", "", "", "", "", "", "", feedsFragment.newCourseData, feedsFragment.liveTestData, feedsFragment.liveClassData, feedsFragment.testResultList, arrayList4, "0", feedsFragment.section_posiiton, feedsFragment.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                                }
                                FeedAdapter feedAdapter = feedsFragment.feedAdapter;
                                Intrinsics.checkNotNull(feedAdapter);
                                if (feedsFragment.datalist.size() > Integer.parseInt(feedsFragment.section_posiiton)) {
                                    feedsFragment.datalist.addAll(Integer.parseInt(feedsFragment.section_posiiton) + 1, feedsFragment.posiitonwiselist);
                                } else {
                                    feedsFragment.datalist.addAll(feedsFragment.posiitonwiselist);
                                }
                                feedsFragment.posiitonwiselist.clear();
                                feedsFragment.feedlist.clear();
                                feedAdapter.addFeed(feedsFragment.datalist);
                                feedAdapter.notifyDataSetChanged();
                                Unit unit3 = Unit.INSTANCE;
                            }
                        } else if (!feedsFragment.is_filterbutton) {
                            feedsFragment.hitApiForLiveClass();
                        } else {
                            FeedAdapter feedAdapter2 = feedsFragment.feedAdapter;
                            Intrinsics.checkNotNull(feedAdapter2);
                            if (feedsFragment.datalist.size() > Integer.parseInt(feedsFragment.section_posiiton)) {
                                feedsFragment.datalist.addAll(Integer.parseInt(feedsFragment.section_posiiton) + 1, feedsFragment.posiitonwiselist);
                            } else {
                                feedsFragment.datalist.addAll(feedsFragment.posiitonwiselist);
                            }
                            feedAdapter2.addFeed(feedsFragment.datalist);
                            feedAdapter2.notifyDataSetChanged();
                            Unit unit4 = Unit.INSTANCE;
                        }
                        if (feedsFragment.datalist.size() == 0) {
                            RelativeLayout relativeLayout3 = feedsFragment.no_data_found_RL;
                            Intrinsics.checkNotNull(relativeLayout3);
                            relativeLayout3.setVisibility(0);
                            FragmentFeedsBinding fragmentFeedsBinding2 = feedsFragment.feedsBinding;
                            Intrinsics.checkNotNull(fragmentFeedsBinding2);
                            fragmentFeedsBinding2.pulltoReferesh.setVisibility(8);
                        } else {
                            Toast.makeText(feedsFragment.requireActivity(), "No More Post found", 0).show();
                        }
                    } else if (i5 > 1) {
                        feedsFragment.loading = true;
                        int length6 = jSONArray.length();
                        for (int i12 = 0; i12 < length6; i12++) {
                            JSONObject jSONObjectOptJSONObject7 = jSONArray.optJSONObject(i12);
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject7, "optJSONObject(...)");
                            com.appnew.android.feeds.dataclass.Data data3 = (com.appnew.android.feeds.dataclass.Data) new Gson().fromJson(jSONObjectOptJSONObject7.toString(), com.appnew.android.feeds.dataclass.Data.class);
                            if (TextUtils.isEmpty(data3.getSchedule_date())) {
                                Boolean.valueOf(feedsFragment.datalist.add(data3));
                            } else {
                                if (Long.parseLong(data3.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                                    feedsFragment.datalist.add(data3);
                                }
                                Unit unit5 = Unit.INSTANCE;
                            }
                        }
                        FeedAdapter feedAdapter3 = feedsFragment.feedAdapter;
                        Intrinsics.checkNotNull(feedAdapter3);
                        int itemCount = feedAdapter3.getItemCount();
                        feedAdapter3.addFeed(feedsFragment.datalist);
                        feedAdapter3.notifyItemRangeChanged(itemCount + 1, feedAdapter3.getItemCount());
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FeedsFragment$setObservers$5$5(feedsFragment, jSONArray, null), 3, null);
                    }
                } else {
                    JSONObject jSONObject13 = feedsFragment.feedJsonObject;
                    if (jSONObject13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                        jSONObject13 = null;
                    }
                    if (jSONObject13.has(Const.POST_TYPE)) {
                        JSONObject jSONObject14 = feedsFragment.feedJsonObject;
                        if (jSONObject14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                            jSONObject3 = null;
                        } else {
                            jSONObject3 = jSONObject14;
                        }
                        JSONArray jSONArray6 = jSONObject3.getJSONArray(Const.POST_TYPE);
                        Intrinsics.checkNotNullExpressionValue(jSONArray6, "getJSONArray(...)");
                        SharedPreference.getInstance().putString(Const.POST_TYPE, jSONArray6.toString());
                        feedsFragment.posttypelist.clear();
                        Iterator<Integer> it2 = RangesKt.until(0, jSONArray6.length()).iterator();
                        while (it2.hasNext()) {
                            JSONObject jSONObjectOptJSONObject8 = jSONArray6.optJSONObject(((IntIterator) it2).nextInt());
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject8, "optJSONObject(...)");
                            feedsFragment.posttypelist.add((PostType) new Gson().fromJson(jSONObjectOptJSONObject8.toString(), PostType.class));
                        }
                    }
                    feedsFragment.posttypelist.add(0, new PostType("", "All"));
                    if (feedsFragment.datalist.size() == 0) {
                        RelativeLayout relativeLayout4 = feedsFragment.no_data_found_RL;
                        Intrinsics.checkNotNull(relativeLayout4);
                        relativeLayout4.setVisibility(0);
                        FragmentFeedsBinding fragmentFeedsBinding3 = feedsFragment.feedsBinding;
                        Intrinsics.checkNotNull(fragmentFeedsBinding3);
                        fragmentFeedsBinding3.pulltoReferesh.setVisibility(8);
                    } else {
                        Toast.makeText(feedsFragment.requireActivity(), "No More Post found", 0).show();
                    }
                }
            } else {
                feedsFragment.limitdata = 0;
                if (feedsFragment.datalist.size() == 0) {
                    RelativeLayout relativeLayout5 = feedsFragment.no_data_found_RL;
                    Intrinsics.checkNotNull(relativeLayout5);
                    relativeLayout5.setVisibility(0);
                    FragmentFeedsBinding fragmentFeedsBinding4 = feedsFragment.feedsBinding;
                    Intrinsics.checkNotNull(fragmentFeedsBinding4);
                    fragmentFeedsBinding4.pulltoReferesh.setVisibility(8);
                }
                RetrofitResponse.GetApiData(feedsFragment.requireContext(), jSONObject.has("auth_code") ? jSONObject.getString("auth_code") : "", jSONObject.getString("message"), false);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$35(FeedsFragment feedsFragment, JSONObject jSONObject) throws JSONException {
        if (Intrinsics.areEqual(jSONObject.optString("status"), "true")) {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            if (jSONArray.length() > 0) {
                feedsFragment.liveClassData.clear();
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                    Datum datum = (Datum) new Gson().fromJson(jSONObjectOptJSONObject.toString(), Datum.class);
                    datum.setCd_time(jSONObject.optLong("cd_time"));
                    feedsFragment.liveClassData.add(datum);
                }
                Json json = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                feedsFragment.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json, "", "", "", "", "", "", "", "1093", "", "", "", "", "", "", "", feedsFragment.newCourseData, feedsFragment.liveTestData, feedsFragment.liveClassData, feedsFragment.testResultList, arrayList, "0", feedsFragment.section_posiiton, feedsFragment.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                if (!feedsFragment.is_filterbutton) {
                    PostDataTable postDataTable = new PostDataTable();
                    postDataTable.setCreated("");
                    postDataTable.setId("");
                    postDataTable.setJson(new Gson().toJson(json));
                    postDataTable.setMeta_url("");
                    postDataTable.setThumbnail("");
                    postDataTable.setUrl("");
                    postDataTable.setModified("");
                    postDataTable.setMy_like("");
                    postDataTable.setName("");
                    postDataTable.setPost_type("1093");
                    postDataTable.setProfile_picture("");
                    postDataTable.setStatus("");
                    postDataTable.setParentId(feedsFragment.master_cat);
                    postDataTable.setMasterCat(feedsFragment.main_cat);
                    postDataTable.setSub_cat_id(feedsFragment.sub_cat);
                    postDataTable.setText("");
                    postDataTable.setTotal_comments("");
                    postDataTable.setTotal_likes("");
                    postDataTable.setUser_id("");
                    postDataTable.setNewCourseData(new Gson().toJson(feedsFragment.newCourseData));
                    postDataTable.setLivetest(new Gson().toJson(feedsFragment.liveTestData));
                    postDataTable.setLiveclass(new Gson().toJson(feedsFragment.liveClassData));
                    postDataTable.setTestResult(new Gson().toJson(feedsFragment.testResultList));
                    postDataTable.setBannerlist(new Gson().toJson(arrayList));
                    postDataTable.setLiveClassStatus("1");
                    postDataTable.setLiveTestStatus("0");
                    postDataTable.setPage(String.valueOf(feedsFragment.page));
                    postDataTable.setIscommentenable("0");
                    postDataTable.setSectionposiiton(feedsFragment.section_posiiton);
                    postDataTable.setLimit(String.valueOf(feedsFragment.limitdata));
                    postDataTable.setMy_pinned(feedsFragment.pinnedPost);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FeedsFragment$setObservers$6$1(feedsFragment, postDataTable, null), 3, null);
                }
            }
        }
        feedsFragment.hitApiForLiveTest();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setObservers$lambda$37(FeedsFragment feedsFragment, JSONObject jSONObject) throws JSONException {
        if (Intrinsics.areEqual(jSONObject.optString("status"), "true")) {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            if (jSONArray.length() > 0) {
                feedsFragment.liveTestData.clear();
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                    LiveTestData liveTestData = (LiveTestData) new Gson().fromJson(jSONObjectOptJSONObject.toString(), LiveTestData.class);
                    liveTestData.setCd_time(jSONObject.optLong("cd_time"));
                    feedsFragment.liveTestData.add(liveTestData);
                }
                Json json = new Json("", new ArrayList(), "", "", "", "", "", "", "");
                feedsFragment.posiitonwiselist.add(new com.appnew.android.feeds.dataclass.Data(false, "", "", json, "", "", "", "", "", "", "", "1092", "", "", "", "", "", "", "", feedsFragment.newCourseData, feedsFragment.liveTestData, feedsFragment.liveClassData, feedsFragment.testResultList, arrayList, "0", feedsFragment.section_posiiton, feedsFragment.limitdata, "0", null, null, null, null, null, null, -268435456, 3, null));
                if (!feedsFragment.is_filterbutton) {
                    PostDataTable postDataTable = new PostDataTable();
                    postDataTable.setCreated("");
                    postDataTable.setId("");
                    postDataTable.setJson(new Gson().toJson(json));
                    postDataTable.setMeta_url("");
                    postDataTable.setThumbnail("");
                    postDataTable.setUrl("");
                    postDataTable.setModified("");
                    postDataTable.setMy_like("");
                    postDataTable.setName("");
                    postDataTable.setPost_type("1092");
                    postDataTable.setProfile_picture("");
                    postDataTable.setStatus("");
                    postDataTable.setParentId(feedsFragment.master_cat);
                    postDataTable.setMasterCat(feedsFragment.main_cat);
                    postDataTable.setSub_cat_id(feedsFragment.sub_cat);
                    postDataTable.setText("");
                    postDataTable.setTotal_comments("");
                    postDataTable.setTotal_likes("");
                    postDataTable.setUser_id("");
                    postDataTable.setNewCourseData(new Gson().toJson(feedsFragment.newCourseData));
                    postDataTable.setLivetest(new Gson().toJson(feedsFragment.liveTestData));
                    postDataTable.setLiveclass(new Gson().toJson(feedsFragment.liveClassData));
                    postDataTable.setTestResult(new Gson().toJson(feedsFragment.testResultList));
                    postDataTable.setBannerlist(new Gson().toJson(arrayList));
                    postDataTable.setLiveClassStatus("0");
                    postDataTable.setLiveTestStatus("1");
                    postDataTable.setPage(String.valueOf(feedsFragment.page));
                    postDataTable.setIscommentenable("0");
                    postDataTable.setSectionposiiton(feedsFragment.section_posiiton);
                    postDataTable.setLimit(String.valueOf(feedsFragment.limitdata));
                    postDataTable.setMy_pinned(feedsFragment.pinnedPost);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FeedsFragment$setObservers$7$1(feedsFragment, postDataTable, null), 3, null);
                }
            }
        }
        FeedAdapter feedAdapter = feedsFragment.feedAdapter;
        Intrinsics.checkNotNull(feedAdapter);
        if (feedsFragment.datalist.size() > Integer.parseInt(feedsFragment.section_posiiton)) {
            feedsFragment.datalist.addAll(Integer.parseInt(feedsFragment.section_posiiton) + 1, feedsFragment.posiitonwiselist);
        } else {
            feedsFragment.datalist.addAll(feedsFragment.posiitonwiselist);
        }
        feedAdapter.addFeed(feedsFragment.datalist);
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
                    this.liveTestData = (ArrayList) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment.updatePostData.1
                    }.getType());
                    break;
                }
            }
        }
        if (this.liveClassData.isEmpty()) {
            for (PostDataTable postDataTable : postData) {
                if (postDataTable.getPost_type().equals("1093")) {
                    this.liveClassData = (ArrayList) new Gson().fromJson(postDataTable.getLiveclass(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment.updatePostData.2
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
                Object objFromJson = new Gson().fromJson(next.getJson(), new TypeToken<Json>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$catregoryPost$data$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                Json json = (Json) objFromJson;
                String meta_url = next.getMeta_url();
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
                List list = (List) new Gson().fromJson(next.getNewCourseData(), new TypeToken<List<? extends NewCourseData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$catregoryPost$data$2
                }.getType());
                List list2 = (List) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$catregoryPost$data$3
                }.getType());
                List list3 = (List) new Gson().fromJson(next.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$catregoryPost$data$4
                }.getType());
                List list4 = (List) new Gson().fromJson(next.getTestResult(), new TypeToken<List<? extends TestResult>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$catregoryPost$data$5
                }.getType());
                List list5 = (List) new Gson().fromJson(next.getBannerlist(), new TypeToken<List<? extends BannerData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$catregoryPost$data$6
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
                com.appnew.android.feeds.dataclass.Data data = new com.appnew.android.feeds.dataclass.Data(false, created, id, json, meta_url, "", thumbnail, url, modified, my_like, name, post_type, profile_picture, status, sub_cat_id, text, total_comments, total_likes, user_id, list, list2, list3, list4, list5, iscommentenable, null, 0, str, str2, parentId, masterCat, sub_cat_id2, schedule_date, null, 100663296, 2, null);
                if (TextUtils.isEmpty(data.getSchedule_date()) || Long.parseLong(data.getSchedule_date()) * ((long) 1000) <= MakeMyExam.time_server) {
                    this.datalist.add(data);
                }
                if (Intrinsics.areEqual(next.getLiveClassStatus(), "1")) {
                    this.liveClassData = (ArrayList) new Gson().fromJson(next.getLiveclass(), new TypeToken<List<? extends Datum>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment.catregoryPost.1
                    }.getType());
                }
                if (Intrinsics.areEqual(next.getLiveTestStatus(), "1")) {
                    this.liveTestData = (ArrayList) new Gson().fromJson(next.getLivetest(), new TypeToken<List<? extends LiveTestData>>() { // from class: com.appnew.android.feeds.fragments.FeedsFragment.catregoryPost.2
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
        FragmentFeedsBinding fragmentFeedsBinding = this.feedsBinding;
        Intrinsics.checkNotNull(fragmentFeedsBinding);
        fragmentFeedsBinding.progressBar.setVisibility(0);
    }

    public final void hideProgressView() {
        FragmentFeedsBinding fragmentFeedsBinding = this.feedsBinding;
        Intrinsics.checkNotNull(fragmentFeedsBinding);
        if (fragmentFeedsBinding.progressBar.getVisibility() == 0) {
            FragmentFeedsBinding fragmentFeedsBinding2 = this.feedsBinding;
            Intrinsics.checkNotNull(fragmentFeedsBinding2);
            fragmentFeedsBinding2.progressBar.setVisibility(4);
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
            FragmentFeedsBinding fragmentFeedsBinding = this.feedsBinding;
            Intrinsics.checkNotNull(fragmentFeedsBinding);
            if (!title6.equals(fragmentFeedsBinding.toolbartitleTV.getText().toString())) {
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
                            FragmentFeedsBinding fragmentFeedsBinding2 = this.feedsBinding;
                            Intrinsics.checkNotNull(fragmentFeedsBinding2);
                            fragmentFeedsBinding2.pulltoReferesh.setVisibility(0);
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
                        FragmentFeedsBinding fragmentFeedsBinding3 = this.feedsBinding;
                        Intrinsics.checkNotNull(fragmentFeedsBinding3);
                        fragmentFeedsBinding3.toolbartitleTV.setText(item.getTitle());
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

    /* JADX INFO: Access modifiers changed from: private */
    public final PopupWindow popupWindowPart() {
        final PopupWindow popupWindow = new PopupWindow(requireActivity());
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        View viewInflate = layoutInflater.inflate(R.layout.dialog_popup_feed, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.main_recyclerview);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.layput);
        CardView cardView = (CardView) viewInflate.findViewById(R.id.change_rl);
        TextView textView = (TextView) viewInflate.findViewById(R.id.change_prefence);
        cardView.setVisibility(0);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        MainCatAdapter mainCatAdapter = new MainCatAdapter(fragmentActivityRequireActivity, this.selected_master_cat, this.mastercatlist);
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
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsFragment.popupWindowPart$lambda$39(this.f$0, view);
            }
        });
        listView.setAdapter((ListAdapter) mainCatAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.appnew.android.feeds.fragments.FeedsFragment$$ExternalSyntheticLambda5
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FeedsFragment.popupWindowPart$lambda$40(this.f$0, popupWindow, adapterView, view, i, j);
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
    public static final void popupWindowPart$lambda$39(FeedsFragment feedsFragment, View view) {
        PopupWindow popupWindow = feedsFragment.popUp;
        Intrinsics.checkNotNull(popupWindow);
        popupWindow.dismiss();
        Helper.gotoActivity(new Intent(feedsFragment.requireActivity(), (Class<?>) IntroActivity.class), feedsFragment.requireActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popupWindowPart$lambda$40(FeedsFragment feedsFragment, PopupWindow popupWindow, AdapterView adapterView, View view, int i, long j) {
        TextView textView;
        TextView textView2;
        if (feedsFragment.posttypelist.size() > 0) {
            if (Helper.isNetworkConnected(feedsFragment.requireActivity())) {
                MasteAllCatTable masteAllCatTable = feedsFragment.selected_master_cat.get(i);
                Intrinsics.checkNotNullExpressionValue(masteAllCatTable, "get(...)");
                MasteAllCatTable masteAllCatTable2 = masteAllCatTable;
                String name = masteAllCatTable2.getName();
                FragmentFeedsBinding fragmentFeedsBinding = feedsFragment.feedsBinding;
                Intrinsics.checkNotNull(fragmentFeedsBinding);
                if (!name.equals(fragmentFeedsBinding.toolbartitleTV.getText().toString())) {
                    Iterator<MasteAllCatTable> it = feedsFragment.selected_master_cat.iterator();
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
                            RelativeLayout relativeLayout = feedsFragment.no_data_found_RL;
                            Intrinsics.checkNotNull(relativeLayout);
                            if (relativeLayout.getVisibility() == 0) {
                                RelativeLayout relativeLayout2 = feedsFragment.no_data_found_RL;
                                Intrinsics.checkNotNull(relativeLayout2);
                                relativeLayout2.setVisibility(8);
                                FragmentFeedsBinding fragmentFeedsBinding2 = feedsFragment.feedsBinding;
                                Intrinsics.checkNotNull(fragmentFeedsBinding2);
                                fragmentFeedsBinding2.pulltoReferesh.setVisibility(0);
                            }
                            feedsFragment.loading = true;
                            feedsFragment.main_cat = masteAllCatTable3.getId();
                            feedsFragment.master_cat = masteAllCatTable3.getMaster_type();
                            feedsFragment.selectedsub_all_cat.clear();
                            ArrayList arrayList = new ArrayList();
                            for (MasteAllCatTable masteAllCatTable4 : feedsFragment.masterAllCatTables) {
                                Iterator<Data.Preferences> it2 = feedsFragment.preferencesArrayList.iterator();
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
                                if (StringsKt.equals(feedsFragment.main_cat, masteAllCatTable5.getParent_id(), true)) {
                                    feedsFragment.selectedsub_all_cat.add(masteAllCatTable5);
                                }
                            }
                            if (feedsFragment.selectedsub_all_cat.size() > 0) {
                                feedsFragment.sub_cat_name = "All";
                                feedsFragment.sub_cat = "0";
                            }
                            feedsFragment.posttypeid = "0";
                            feedsFragment.posttypename = "All";
                            feedsFragment.sub_cat_filter = "";
                            feedsFragment.is_filterbutton = false;
                            feedsFragment.sub_cat_name_filter = "";
                            feedsFragment.datalist.clear();
                            if (!StringsKt.equals(BuildConfig.FLAVOR, "KSRAnatomyClasses", true)) {
                                FragmentFeedsBinding fragmentFeedsBinding3 = feedsFragment.feedsBinding;
                                if (fragmentFeedsBinding3 != null && (textView2 = fragmentFeedsBinding3.toolbartitleTV) != null) {
                                    textView2.setText(masteAllCatTable2.getName());
                                }
                            } else {
                                FragmentFeedsBinding fragmentFeedsBinding4 = feedsFragment.feedsBinding;
                                if (fragmentFeedsBinding4 != null && (textView = fragmentFeedsBinding4.toolbartitleTV) != null) {
                                    textView.setText("Discussion Forum");
                                }
                            }
                            feedsFragment.page = 1;
                            feedsFragment.section_posiiton = "0";
                            feedsFragment.limitdata = 0;
                            feedsFragment.posiitonwiselist.clear();
                            feedsFragment.pinnedPostList.clear();
                            FragmentFeedsBinding fragmentFeedsBinding5 = feedsFragment.feedsBinding;
                            Intrinsics.checkNotNull(fragmentFeedsBinding5);
                            fragmentFeedsBinding5.filter.setImageResource(R.mipmap.filter_icon);
                            FeedAdapter feedAdapter = feedsFragment.feedAdapter;
                            Intrinsics.checkNotNull(feedAdapter);
                            if (feedAdapter.getTimer() != null) {
                                FeedAdapter feedAdapter2 = feedsFragment.feedAdapter;
                                Intrinsics.checkNotNull(feedAdapter2);
                                Timer timer = feedAdapter2.getTimer();
                                Intrinsics.checkNotNull(timer);
                                timer.cancel();
                                FeedAdapter feedAdapter3 = feedsFragment.feedAdapter;
                                Intrinsics.checkNotNull(feedAdapter3);
                                Timer timer2 = feedAdapter3.getTimer();
                                Intrinsics.checkNotNull(timer2);
                                timer2.purge();
                            }
                            feedsFragment.getFeedViewModel().getProgressvalue().setValue("1");
                            if (feedsFragment.posttypeid.equals("0")) {
                                List<PostDataTable> listRetrievePostData = feedsFragment.utkashRoom.getFeedDao().retrievePostData(feedsFragment.master_cat, feedsFragment.main_cat, feedsFragment.sub_cat);
                                Intrinsics.checkNotNull(listRetrievePostData);
                                feedsFragment.catregoryPost(listRetrievePostData);
                            } else {
                                List<PostDataTable> listRetrievePostData_viaposttype = feedsFragment.utkashRoom.getFeedDao().retrievePostData_viaposttype(feedsFragment.master_cat, feedsFragment.main_cat, feedsFragment.sub_cat, feedsFragment.posttypeid);
                                Intrinsics.checkNotNull(listRetrievePostData_viaposttype);
                                feedsFragment.catregoryPost(listRetrievePostData_viaposttype);
                            }
                        }
                    }
                }
            } else {
                Helper.showInternetToast(feedsFragment.requireActivity());
            }
            popupWindow.dismiss();
        }
    }

    public final void openWebView(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (StringsKt.equals(BuildConfig.FLAVOR, "scoreBetter", true)) {
            WebViewFeedFragment webViewFeedFragment = new WebViewFeedFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", data);
            webViewFeedFragment.setArguments(bundle);
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Theme.DashboardActivityTheme1");
            ((DashboardActivityTheme1) activity).replaceFragment(webViewFeedFragment);
        }
    }

    /* JADX INFO: compiled from: FeedsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/feeds/fragments/FeedsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/feeds/fragments/FeedsFragment;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeedsFragment newInstance() {
            return new FeedsFragment();
        }
    }
}
