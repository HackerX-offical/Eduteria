package com.appnew.android.Intro.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.appnew.android.Dao.GetMasterAllCatDao;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Intro.Fragment.ChildCategoryFragment;
import com.appnew.android.Intro.Fragment.LanguageFragment;
import com.appnew.android.Intro.Fragment.MainCategoryFragment;
import com.appnew.android.Intro.Mastercat;
import com.appnew.android.Intro.SubCat;
import com.appnew.android.Model.Courses.Cards;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.BackHandlerHelper;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityIntroBinding;
import com.appnew.android.feeds.activity.FeedsActivity;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.CourseTypeMasterTable;
import com.appnew.android.table.LanguagesTable;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: IntroActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0092\u0001\u001a\u00030\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0015J\n\u0010\u0096\u0001\u001a\u00030\u0093\u0001H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0093\u0001H\u0002J\u001a\u0010\u0098\u0001\u001a\u00030\u0093\u00012\u0006\u00104\u001a\u0002052\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\b\u0010\u009b\u0001\u001a\u00030\u0093\u0001J\n\u0010\u009c\u0001\u001a\u00030\u0093\u0001H\u0002J\n\u0010\u009d\u0001\u001a\u00030\u0093\u0001H\u0003J4\u0010\u009e\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010\u009f\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010J2\t\u0010¡\u0001\u001a\u0004\u0018\u00010J2\b\u0010¢\u0001\u001a\u00030£\u0001H\u0016J6\u0010¤\u0001\u001a\u00030\u0093\u00012\n\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010J2\t\u0010¡\u0001\u001a\u0004\u0018\u00010J2\b\u0010§\u0001\u001a\u00030\u009a\u0001H\u0016J+\u0010¨\u0001\u001a\u00030\u0093\u00012\t\u0010©\u0001\u001a\u0004\u0018\u00010J2\t\u0010 \u0001\u001a\u0004\u0018\u00010J2\t\u0010¡\u0001\u001a\u0004\u0018\u00010JH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R!\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&0\u001ej\b\u0012\u0004\u0012\u00020&` ¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010F\"\u0004\bQ\u0010HR\u001c\u0010R\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010F\"\u0004\bT\u0010HR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR*\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\\0\u001ej\b\u0012\u0004\u0012\u00020\\` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\"\"\u0004\b^\u0010$R*\u0010_\u001a\u0012\u0012\u0004\u0012\u00020`0\u001ej\b\u0012\u0004\u0012\u00020`` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\"\"\u0004\bb\u0010$R*\u0010c\u001a\u0012\u0012\u0004\u0012\u00020d0\u001ej\b\u0012\u0004\u0012\u00020d` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\"\"\u0004\bf\u0010$R*\u0010g\u001a\u0012\u0012\u0004\u0012\u00020h0\u001ej\b\u0012\u0004\u0012\u00020h` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\"\"\u0004\bj\u0010$R*\u0010k\u001a\u0012\u0012\u0004\u0012\u00020l0\u001ej\b\u0012\u0004\u0012\u00020l` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\"\"\u0004\bn\u0010$R\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010hX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010z\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001e\u0010\u007f\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010|\"\u0005\b\u0081\u0001\u0010~R\u001d\u0010\u0082\u0001\u001a\u00020JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010L\"\u0005\b\u0083\u0001\u0010NR\u001f\u0010\u0084\u0001\u001a\u0012\u0012\u0004\u0012\u00020`0\u001ej\b\u0012\u0004\u0012\u00020`` X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0085\u0001\u001a\u0012\u0012\u0004\u0012\u00020`0\u001ej\b\u0012\u0004\u0012\u00020`` X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0086\u0001\u001a\u00020JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010L\"\u0005\b\u0088\u0001\u0010NR\u001d\u0010\u0089\u0001\u001a\u00020JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010L\"\u0005\b\u008b\u0001\u0010NR \u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/appnew/android/Intro/Activity/IntroActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityIntroBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityIntroBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityIntroBinding;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "container", "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", "setContainer", "(Landroid/widget/FrameLayout;)V", "backPressed", "", "getBackPressed", "()J", "setBackPressed", "(J)V", "maincatlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/SubCat;", "Lkotlin/collections/ArrayList;", "getMaincatlist", "()Ljava/util/ArrayList;", "setMaincatlist", "(Ljava/util/ArrayList;)V", "prefencelist", "Lcom/appnew/android/pojo/Userinfo/Data$Preferences;", "getPrefencelist", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "next_layout", "Landroid/widget/LinearLayout;", "getNext_layout", "()Landroid/widget/LinearLayout;", "setNext_layout", "(Landroid/widget/LinearLayout;)V", "next_back", "getNext_back", "setNext_back", "step", "Landroid/widget/TextView;", "getStep", "()Landroid/widget/TextView;", "setStep", "(Landroid/widget/TextView;)V", "prefence", "", "getPrefence", "()Ljava/lang/String;", "setPrefence", "(Ljava/lang/String;)V", "back_text", "getBack_text", "setBack_text", "next_text", "getNext_text", "setNext_text", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "courseTypeMasterTables", "Lcom/appnew/android/table/CourseTypeMasterTable;", "getCourseTypeMasterTables", "setCourseTypeMasterTables", "masterAllCatTables", "Lcom/appnew/android/table/MasteAllCatTable;", "getMasterAllCatTables", "setMasterAllCatTables", "langlist", "Lcom/appnew/android/table/LanguagesTable;", "getLanglist", "setLanglist", "mastercatlist", "Lcom/appnew/android/Intro/Mastercat;", "getMastercatlist", "setMastercatlist", "cardsArrayList", "Lcom/appnew/android/Model/Courses/Cards;", "getCardsArrayList", "setCardsArrayList", "data", "Lcom/appnew/android/pojo/Userinfo/Data;", "getData", "()Lcom/appnew/android/pojo/Userinfo/Data;", "setData", "(Lcom/appnew/android/pojo/Userinfo/Data;)V", "mastercat", "getMastercat", "()Lcom/appnew/android/Intro/Mastercat;", "setMastercat", "(Lcom/appnew/android/Intro/Mastercat;)V", "subCat", "getSubCat", "()Lcom/appnew/android/Intro/SubCat;", "setSubCat", "(Lcom/appnew/android/Intro/SubCat;)V", "master_main_sub", "getMaster_main_sub", "setMaster_main_sub", "is_lang", "set_lang", "selected_master_cat", "selectedsub_all_cat", "subids", "getSubids", "setSubids", "normalUpdate", "getNormalUpdate", "setNormalUpdate", "backHandlerHelper", "Lcom/appnew/android/Utils/BackHandlerHelper;", "getBackHandlerHelper", "()Lcom/appnew/android/Utils/BackHandlerHelper;", "setBackHandlerHelper", "(Lcom/appnew/android/Utils/BackHandlerHelper;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setIds", "setClicks", "loadFragment", "isaddbackstack", "", "hit_api_master_data", "manageData", "onCustomBackPress", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IntroActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private long backPressed;
    private TextView back_text;
    public ActivityIntroBinding binding;
    private FrameLayout container;
    private Data data;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private SubCat master_main_sub;
    private Mastercat mastercat;
    private NetworkCall networkCall;
    private LinearLayout next_back;
    private LinearLayout next_layout;
    private TextView next_text;
    private ProgressBar progressBar;
    private TextView step;
    private SubCat subCat;
    private UtkashRoom utkashRoom;
    private ArrayList<SubCat> maincatlist = new ArrayList<>();
    private final ArrayList<Data.Preferences> prefencelist = new ArrayList<>();
    private String prefence = "";
    private ArrayList<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList<>();
    private ArrayList<MasteAllCatTable> masterAllCatTables = new ArrayList<>();
    private ArrayList<LanguagesTable> langlist = new ArrayList<>();
    private ArrayList<Mastercat> mastercatlist = new ArrayList<>();
    private ArrayList<Cards> cardsArrayList = new ArrayList<>();
    private String is_lang = "";
    private ArrayList<MasteAllCatTable> selected_master_cat = new ArrayList<>();
    private ArrayList<MasteAllCatTable> selectedsub_all_cat = new ArrayList<>();
    private String subids = "";
    private String normalUpdate = "feeds";
    private BackHandlerHelper backHandlerHelper = new BackHandlerHelper();

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public final ActivityIntroBinding getBinding() {
        ActivityIntroBinding activityIntroBinding = this.binding;
        if (activityIntroBinding != null) {
            return activityIntroBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityIntroBinding activityIntroBinding) {
        Intrinsics.checkNotNullParameter(activityIntroBinding, "<set-?>");
        this.binding = activityIntroBinding;
    }

    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public final void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public final FrameLayout getContainer() {
        return this.container;
    }

    public final void setContainer(FrameLayout frameLayout) {
        this.container = frameLayout;
    }

    public final long getBackPressed() {
        return this.backPressed;
    }

    public final void setBackPressed(long j) {
        this.backPressed = j;
    }

    public final ArrayList<SubCat> getMaincatlist() {
        return this.maincatlist;
    }

    public final void setMaincatlist(ArrayList<SubCat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.maincatlist = arrayList;
    }

    public final ArrayList<Data.Preferences> getPrefencelist() {
        return this.prefencelist;
    }

    @Override // android.app.Activity
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public final LinearLayout getNext_layout() {
        return this.next_layout;
    }

    public final void setNext_layout(LinearLayout linearLayout) {
        this.next_layout = linearLayout;
    }

    public final LinearLayout getNext_back() {
        return this.next_back;
    }

    public final void setNext_back(LinearLayout linearLayout) {
        this.next_back = linearLayout;
    }

    public final TextView getStep() {
        return this.step;
    }

    public final void setStep(TextView textView) {
        this.step = textView;
    }

    public final String getPrefence() {
        return this.prefence;
    }

    public final void setPrefence(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prefence = str;
    }

    public final TextView getBack_text() {
        return this.back_text;
    }

    public final void setBack_text(TextView textView) {
        this.back_text = textView;
    }

    public final TextView getNext_text() {
        return this.next_text;
    }

    public final void setNext_text(TextView textView) {
        this.next_text = textView;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        this.utkashRoom = utkashRoom;
    }

    public final ArrayList<CourseTypeMasterTable> getCourseTypeMasterTables() {
        return this.courseTypeMasterTables;
    }

    public final void setCourseTypeMasterTables(ArrayList<CourseTypeMasterTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.courseTypeMasterTables = arrayList;
    }

    public final ArrayList<MasteAllCatTable> getMasterAllCatTables() {
        return this.masterAllCatTables;
    }

    public final void setMasterAllCatTables(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.masterAllCatTables = arrayList;
    }

    public final ArrayList<LanguagesTable> getLanglist() {
        return this.langlist;
    }

    public final void setLanglist(ArrayList<LanguagesTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.langlist = arrayList;
    }

    public final ArrayList<Mastercat> getMastercatlist() {
        return this.mastercatlist;
    }

    public final void setMastercatlist(ArrayList<Mastercat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mastercatlist = arrayList;
    }

    public final ArrayList<Cards> getCardsArrayList() {
        return this.cardsArrayList;
    }

    public final void setCardsArrayList(ArrayList<Cards> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.cardsArrayList = arrayList;
    }

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data) {
        this.data = data;
    }

    public final Mastercat getMastercat() {
        return this.mastercat;
    }

    public final void setMastercat(Mastercat mastercat) {
        this.mastercat = mastercat;
    }

    public final SubCat getSubCat() {
        return this.subCat;
    }

    public final void setSubCat(SubCat subCat) {
        this.subCat = subCat;
    }

    public final SubCat getMaster_main_sub() {
        return this.master_main_sub;
    }

    public final void setMaster_main_sub(SubCat subCat) {
        this.master_main_sub = subCat;
    }

    /* JADX INFO: renamed from: is_lang, reason: from getter */
    public final String getIs_lang() {
        return this.is_lang;
    }

    public final void set_lang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.is_lang = str;
    }

    public final String getSubids() {
        return this.subids;
    }

    public final void setSubids(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subids = str;
    }

    public final String getNormalUpdate() {
        return this.normalUpdate;
    }

    public final void setNormalUpdate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.normalUpdate = str;
    }

    protected final BackHandlerHelper getBackHandlerHelper() {
        return this.backHandlerHelper;
    }

    protected final void setBackHandlerHelper(BackHandlerHelper backHandlerHelper) {
        Intrinsics.checkNotNullParameter(backHandlerHelper, "<set-?>");
        this.backHandlerHelper = backHandlerHelper;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(ActivityIntroBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(this);
        Intent intent = getIntent();
        if (intent.hasExtra("is_from_home")) {
            String stringExtra = intent.getStringExtra("is_from_home");
            Intrinsics.checkNotNull(stringExtra);
            this.normalUpdate = stringExtra;
        }
        IntroActivity introActivity = this;
        this.utkashRoom = UtkashRoom.getAppDatabase(introActivity);
        this.networkCall = new NetworkCall(this, introActivity);
        this.prefence = SharedPreference.getInstance().getString("prefence");
        setIds();
        hit_api_master_data();
        setClicks();
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            View root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            EdgeToEdgeHelperOld.applyInsets(introActivity, window, root, false, null);
        }
        this.backHandlerHelper.setup(this, new Runnable() { // from class: com.appnew.android.Intro.Activity.IntroActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onCustomBackPress();
            }
        });
    }

    private final void setIds() {
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.container = (FrameLayout) findViewById(R.id.container);
        this.next_layout = (LinearLayout) findViewById(R.id.next_layout);
        this.next_back = (LinearLayout) findViewById(R.id.next_back);
        this.next_text = (TextView) findViewById(R.id.next_text);
        this.back_text = (TextView) findViewById(R.id.back_text);
        this.step = (TextView) findViewById(R.id.step);
    }

    private final void setClicks() {
        LinearLayout linearLayout = this.next_layout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Activity.IntroActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IntroActivity.setClicks$lambda$2(this.f$0, view);
                }
            });
        }
        TextView textView = this.next_text;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Activity.IntroActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IntroActivity.setClicks$lambda$3(this.f$0, view);
                }
            });
        }
        TextView textView2 = this.back_text;
        Intrinsics.checkNotNull(textView2);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Activity.IntroActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCustomBackPress();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$2(IntroActivity introActivity, View view) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new IntroActivity$setClicks$1$1(introActivity, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$3(IntroActivity introActivity, View view) {
        FragmentManager supportFragmentManager = introActivity.getSupportFragmentManager();
        introActivity.fragmentManager = supportFragmentManager;
        Fragment fragmentFindFragmentById = supportFragmentManager != null ? supportFragmentManager.findFragmentById(R.id.container) : null;
        introActivity.fragment = fragmentFindFragmentById;
        if (fragmentFindFragmentById instanceof MainCategoryFragment) {
            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type com.appnew.android.Intro.Fragment.MainCategoryFragment");
            Boolean is_select_main_cat = ((MainCategoryFragment) fragmentFindFragmentById).getIs_select_main_cat();
            Intrinsics.checkNotNull(is_select_main_cat);
            if (is_select_main_cat.booleanValue()) {
                TextView textView = introActivity.step;
                Intrinsics.checkNotNull(textView);
                textView.setText("Step 2/4");
                ProgressBar progressBar = introActivity.progressBar;
                Intrinsics.checkNotNull(progressBar);
                progressBar.setProgress(2);
                Fragment fragment = introActivity.fragment;
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.appnew.android.Intro.Fragment.MainCategoryFragment");
                Mastercat mastercat = ((MainCategoryFragment) fragment).getMastercat();
                Intrinsics.checkNotNull(mastercat);
                introActivity.mastercat = mastercat;
                introActivity.loadFragment(new ChildCategoryFragment(), true);
                return;
            }
            Toast.makeText(introActivity, "Please Select to Proceed", 0).show();
            return;
        }
        if (fragmentFindFragmentById instanceof LanguageFragment) {
            Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type com.appnew.android.Intro.Fragment.LanguageFragment");
            Boolean is_lang_select = ((LanguageFragment) fragmentFindFragmentById).getIs_lang_select();
            Intrinsics.checkNotNull(is_lang_select);
            if (is_lang_select.booleanValue()) {
                NetworkCall networkCall = introActivity.networkCall;
                Intrinsics.checkNotNull(networkCall);
                networkCall.NetworkAPICall(API.update_preference, "", true, false);
                return;
            }
            Toast.makeText(introActivity, "Please Select to Proceed", 0).show();
        }
    }

    public final void loadFragment(Fragment fragment, boolean isaddbackstack) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment);
        fragmentTransactionBeginTransaction.commit();
        if (isaddbackstack) {
            fragmentTransactionBeginTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
    }

    public final void hit_api_master_data() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.master_content, "", true, false);
    }

    private final void manageData() {
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        this.data = loggedInUser;
        if ((loggedInUser != null ? loggedInUser.getPreferences() : null) != null) {
            Data data = this.data;
            ArrayList<Data.Preferences> preferences = data != null ? data.getPreferences() : null;
            Intrinsics.checkNotNull(preferences);
            if (preferences.size() > 0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05361(null), 3, null);
                return;
            }
        }
        if (StringsKt.contains$default((CharSequence) this.prefence, (CharSequence) "#@", false, 2, (Object) null)) {
            List listSplit$default = StringsKt.split$default((CharSequence) this.prefence, new String[]{"#@"}, false, 0, 6, (Object) null);
            int size = this.mastercatlist.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (Intrinsics.areEqual(listSplit$default.get(1), this.mastercatlist.get(i).getCatid())) {
                    this.mastercat = new Mastercat((String) listSplit$default.get(1), (String) listSplit$default.get(0), true, false, 8, null);
                    this.mastercatlist.get(i).set_select(true);
                    break;
                }
                i++;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<MasteAllCatTable> it = this.masterAllCatTables.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MasteAllCatTable next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MasteAllCatTable masteAllCatTable = next;
                String master_type = masteAllCatTable.getMaster_type();
                Mastercat mastercat = this.mastercat;
                Intrinsics.checkNotNull(mastercat);
                if (Intrinsics.areEqual(master_type, mastercat.getCatid()) && StringsKt.equals(masteAllCatTable.getParent_id(), "0", true)) {
                    String id = masteAllCatTable.getId();
                    Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                    String name = masteAllCatTable.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String parent_id = masteAllCatTable.getParent_id();
                    Intrinsics.checkNotNullExpressionValue(parent_id, "getParent_id(...)");
                    String master_type2 = masteAllCatTable.getMaster_type();
                    Intrinsics.checkNotNullExpressionValue(master_type2, "getMaster_type(...)");
                    arrayList.add(new SubCat(id, name, parent_id, master_type2, false, false, false, 112, null));
                }
            }
            int size2 = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    break;
                }
                if (Intrinsics.areEqual(listSplit$default.get(3), ((SubCat) arrayList.get(i2)).getId())) {
                    Mastercat mastercat2 = this.mastercat;
                    this.subCat = mastercat2 != null ? new SubCat((String) listSplit$default.get(3), (String) listSplit$default.get(2), "", mastercat2.getCatid(), true, false, false, 96, null) : null;
                } else {
                    i2++;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<MasteAllCatTable> it2 = this.masterAllCatTables.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                MasteAllCatTable next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                MasteAllCatTable masteAllCatTable2 = next2;
                SubCat subCat = this.subCat;
                Intrinsics.checkNotNull(subCat);
                if (StringsKt.equals(subCat.getId(), masteAllCatTable2.getParent_id(), true)) {
                    String id2 = masteAllCatTable2.getId();
                    Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                    String name2 = masteAllCatTable2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    String parent_id2 = masteAllCatTable2.getParent_id();
                    Intrinsics.checkNotNullExpressionValue(parent_id2, "getParent_id(...)");
                    String master_type3 = masteAllCatTable2.getMaster_type();
                    Intrinsics.checkNotNullExpressionValue(master_type3, "getMaster_type(...)");
                    arrayList2.add(new SubCat(id2, name2, parent_id2, master_type3, false, false, false, 112, null));
                }
            }
            int size3 = arrayList2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size3) {
                    break;
                }
                if (Intrinsics.areEqual(listSplit$default.get(5), ((SubCat) arrayList2.get(i3)).getId())) {
                    SubCat subCat2 = this.subCat;
                    this.master_main_sub = subCat2 != null ? new SubCat((String) listSplit$default.get(5), (String) listSplit$default.get(4), subCat2.getId(), subCat2.getMastertype(), false, false, false, 96, null) : null;
                    ((SubCat) arrayList2.get(i3)).set_selct(true);
                } else {
                    i3++;
                }
            }
            SubCat subCat3 = this.master_main_sub;
            if (subCat3 != null) {
                this.maincatlist.add(subCat3);
            }
            loadFragment(new MainCategoryFragment(), true);
            return;
        }
        loadFragment(new MainCategoryFragment(), true);
    }

    /* JADX INFO: renamed from: com.appnew.android.Intro.Activity.IntroActivity$manageData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntroActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Intro.Activity.IntroActivity$manageData$1", f = "IntroActivity.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
    static final class C05361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05361(Continuation<? super C05361> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntroActivity.this.new C05361(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            GetMasterAllCatDao masterAllCatDao;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UtkashRoom utkashRoom = IntroActivity.this.getUtkashRoom();
                List<MasteAllCatTable> list = (utkashRoom == null || (masterAllCatDao = utkashRoom.getMasterAllCatDao()) == null) ? null : masterAllCatDao.getmaster_allcat(MakeMyExam.userId);
                ArrayList arrayList = new ArrayList();
                Intrinsics.checkNotNull(list);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Data data = IntroActivity.this.getData();
                    ArrayList<Data.Preferences> preferences = data != null ? data.getPreferences() : null;
                    Intrinsics.checkNotNull(preferences);
                    int size2 = preferences.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        String id = list.get(i2).getId();
                        Data data2 = IntroActivity.this.getData();
                        ArrayList<Data.Preferences> preferences2 = data2 != null ? data2.getPreferences() : null;
                        Intrinsics.checkNotNull(preferences2);
                        if (Intrinsics.areEqual(id, preferences2.get(i3).getSub_cat())) {
                            arrayList.add(list.get(i2));
                            if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) != null && StringsKt.equals(SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE), "1", true)) {
                                IntroActivity introActivity = IntroActivity.this;
                                String id2 = list.get(i2).getId();
                                Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                                String name = list.get(i2).getName();
                                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                                String parent_id = list.get(i2).getParent_id();
                                Intrinsics.checkNotNullExpressionValue(parent_id, "getParent_id(...)");
                                String master_type = list.get(i2).getMaster_type();
                                Intrinsics.checkNotNullExpressionValue(master_type, "getMaster_type(...)");
                                introActivity.setMaster_main_sub(new SubCat(id2, name, parent_id, master_type, false, false, false, 80, null));
                            } else {
                                IntroActivity introActivity2 = IntroActivity.this;
                                String id3 = list.get(i2).getId();
                                Intrinsics.checkNotNullExpressionValue(id3, "getId(...)");
                                String name2 = list.get(i2).getName();
                                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                                String parent_id2 = list.get(i2).getParent_id();
                                Intrinsics.checkNotNullExpressionValue(parent_id2, "getParent_id(...)");
                                String master_type2 = list.get(i2).getMaster_type();
                                Intrinsics.checkNotNullExpressionValue(master_type2, "getMaster_type(...)");
                                introActivity2.setMaster_main_sub(new SubCat(id3, name2, parent_id2, master_type2, false, false, false, 96, null));
                            }
                            SubCat master_main_sub = IntroActivity.this.getMaster_main_sub();
                            if (master_main_sub != null) {
                                Boxing.boxBoolean(IntroActivity.this.getMaincatlist().add(master_main_sub));
                            }
                        }
                    }
                }
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(IntroActivity.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.appnew.android.Intro.Activity.IntroActivity$manageData$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: IntroActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.Intro.Activity.IntroActivity$manageData$1$2", f = "IntroActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IntroActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(IntroActivity introActivity, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = introActivity;
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
                this.this$0.loadFragment(new MainCategoryFragment(), true);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCustomBackPress() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fragmentManager = supportFragmentManager;
        Intrinsics.checkNotNull(supportFragmentManager);
        Fragment fragmentFindFragmentById = supportFragmentManager.findFragmentById(R.id.container);
        this.fragment = fragmentFindFragmentById;
        if (fragmentFindFragmentById instanceof MainCategoryFragment) {
            finish();
            return;
        }
        if (fragmentFindFragmentById instanceof LanguageFragment) {
            LinearLayout linearLayout = this.next_layout;
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.next_back;
            Intrinsics.checkNotNull(linearLayout2);
            linearLayout2.setVisibility(8);
            TextView textView = this.step;
            Intrinsics.checkNotNull(textView);
            textView.setText("Step 1/2");
            ProgressBar progressBar = this.progressBar;
            Intrinsics.checkNotNull(progressBar);
            progressBar.setProgress(1);
            FragmentManager fragmentManager = this.fragmentManager;
            Intrinsics.checkNotNull(fragmentManager);
            Fragment fragment = this.fragment;
            Intrinsics.checkNotNull(fragment);
            fragmentManager.popBackStack(fragment.getClass().getSimpleName(), 1);
            return;
        }
        super.getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.master_content)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(MakeMyExam.getUserId());
            return service.master_content(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.update_preference)) {
            return null;
        }
        if (!this.is_lang.equals("1") && !this.is_lang.equals("2") && this.is_lang.equals("1,2")) {
            this.is_lang = "0";
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setSub_cat_ids(this.subids);
        encryptionData2.setLang("0");
        return service.update_preference(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONArray jSONArrayOptJSONArray3;
        JSONArray jSONArrayOptJSONArray4;
        if (Intrinsics.areEqual(apitype, API.update_preference)) {
            try {
                Intrinsics.checkNotNull(jsonObject);
                if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
                    return;
                } else {
                    RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.master_content)) {
            try {
                Intrinsics.checkNotNull(jsonObject);
                if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                    JSONObject jSONObject = jsonObject.getJSONObject("data");
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                    try {
                        UtkashRoom utkashRoom = this.utkashRoom;
                        Intrinsics.checkNotNull(utkashRoom);
                        utkashRoom.getcoursetypemaster().deletedata();
                        UtkashRoom utkashRoom2 = this.utkashRoom;
                        Intrinsics.checkNotNull(utkashRoom2);
                        utkashRoom2.getLaunguages().deletedata();
                        UtkashRoom utkashRoom3 = this.utkashRoom;
                        Intrinsics.checkNotNull(utkashRoom3);
                        utkashRoom3.getMasterAllCatDao().deletedata();
                        UtkashRoom utkashRoom4 = this.utkashRoom;
                        Intrinsics.checkNotNull(utkashRoom4);
                        utkashRoom4.getMastercatDao().deletedata();
                        this.courseTypeMasterTables.clear();
                        this.masterAllCatTables.clear();
                        this.mastercatlist.clear();
                        this.selectedsub_all_cat.clear();
                        this.selected_master_cat.clear();
                        if (jSONObject.has("languages") && (jSONArrayOptJSONArray4 = jSONObject.optJSONArray("languages")) != null && jSONArrayOptJSONArray4.length() > 0) {
                            int length = jSONArrayOptJSONArray4.length();
                            for (int i = 0; i < length; i++) {
                                LanguagesTable languagesTable = (LanguagesTable) new Gson().fromJson(jSONArrayOptJSONArray4.get(i).toString(), LanguagesTable.class);
                                this.langlist.add(languagesTable);
                                UtkashRoom utkashRoom5 = this.utkashRoom;
                                Intrinsics.checkNotNull(utkashRoom5);
                                utkashRoom5.getLaunguages().addLaunguage(languagesTable);
                            }
                        }
                        if (jSONObject.has("all_cat") && (jSONArrayOptJSONArray3 = jSONObject.optJSONArray("all_cat")) != null && jSONArrayOptJSONArray3.length() > 0) {
                            int length2 = jSONArrayOptJSONArray3.length();
                            for (int i2 = 0; i2 < length2; i2++) {
                                MasteAllCatTable masteAllCatTable = (MasteAllCatTable) new Gson().fromJson(jSONArrayOptJSONArray3.get(i2).toString(), MasteAllCatTable.class);
                                masteAllCatTable.setUser_id(MakeMyExam.userId);
                                UtkashRoom utkashRoom6 = this.utkashRoom;
                                Intrinsics.checkNotNull(utkashRoom6);
                                utkashRoom6.getMasterAllCatDao().addUser(masteAllCatTable);
                                this.masterAllCatTables.add(masteAllCatTable);
                            }
                        }
                        if (jSONObject.has("master_cat") && (jSONArrayOptJSONArray2 = jSONObject.optJSONArray("master_cat")) != null && jSONArrayOptJSONArray2.length() > 0) {
                            int length3 = jSONArrayOptJSONArray2.length();
                            for (int i3 = 0; i3 < length3; i3++) {
                                MasterCat masterCat = (MasterCat) new Gson().fromJson(jSONArrayOptJSONArray2.get(i3).toString(), MasterCat.class);
                                masterCat.setUser_id(MakeMyExam.userId);
                                UtkashRoom utkashRoom7 = this.utkashRoom;
                                Intrinsics.checkNotNull(utkashRoom7);
                                utkashRoom7.getMastercatDao().addUser(masterCat);
                                String id = masterCat.getId();
                                Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                                String cat = masterCat.getCat();
                                Intrinsics.checkNotNullExpressionValue(cat, "getCat(...)");
                                this.mastercatlist.add(new Mastercat(id, cat, false, false, 12, null));
                            }
                        }
                        if (jSONObject.has("course_type_master") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("course_type_master")) != null && jSONArrayOptJSONArray.length() > 0) {
                            int length4 = jSONArrayOptJSONArray.length();
                            for (int i4 = 0; i4 < length4; i4++) {
                                CourseTypeMasterTable courseTypeMasterTable = (CourseTypeMasterTable) new Gson().fromJson(jSONArrayOptJSONArray.get(i4).toString(), CourseTypeMasterTable.class);
                                courseTypeMasterTable.setUser_id(MakeMyExam.userId);
                                UtkashRoom utkashRoom8 = this.utkashRoom;
                                Intrinsics.checkNotNull(utkashRoom8);
                                utkashRoom8.getcoursetypemaster().addUser(courseTypeMasterTable);
                                this.courseTypeMasterTables.add(courseTypeMasterTable);
                            }
                        }
                        Iterator<CourseTypeMasterTable> it = this.courseTypeMasterTables.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            CourseTypeMasterTable next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            CourseTypeMasterTable courseTypeMasterTable2 = next;
                            this.cardsArrayList.add(new Cards(courseTypeMasterTable2.getId(), courseTypeMasterTable2.getName(), Constants.BLACK, courseTypeMasterTable2.getName(), "0#0#0#0#0#0", "0"));
                        }
                        manageData();
                        try {
                            UtkashRoom utkashRoom9 = this.utkashRoom;
                            Intrinsics.checkNotNull(utkashRoom9);
                            if (utkashRoom9.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_009")) {
                                UtkashRoom utkashRoom10 = this.utkashRoom;
                                Intrinsics.checkNotNull(utkashRoom10);
                                utkashRoom10.getapidao().update_api_version("ut_009", MakeMyExam.userId, String.valueOf(jsonObject.optLong("time")), String.valueOf(jsonObject.optLong("interval")), String.valueOf(jsonObject.optLong("cd_time")));
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
                                UtkashRoom utkashRoom11 = this.utkashRoom;
                                Intrinsics.checkNotNull(utkashRoom11);
                                Long.valueOf(utkashRoom11.getapidao().addUser(apitable));
                            }
                            return;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                }
                RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
            } catch (Exception e5) {
                ErrorCallBack(e5.getMessage() + " : " + e5.getLocalizedMessage(), apitype, typeApi);
                e5.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Intro.Activity.IntroActivity$SuccessCallBack$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntroActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Intro.Activity.IntroActivity$SuccessCallBack$1", f = "IntroActivity.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntroActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IntroActivity.this.setData(SharedPreference.getInstance().getLoggedInUser());
                Data data = IntroActivity.this.getData();
                if (data != null) {
                    data.setPreferences(IntroActivity.this.getPrefencelist());
                }
                Data data2 = IntroActivity.this.getData();
                if (data2 != null) {
                    data2.setLang("0");
                }
                SharedPreference.getInstance().setLoggedInUserr(IntroActivity.this.getData());
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C01031(IntroActivity.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.appnew.android.Intro.Activity.IntroActivity$SuccessCallBack$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: IntroActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.Intro.Activity.IntroActivity$SuccessCallBack$1$1", f = "IntroActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IntroActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01031(IntroActivity introActivity, Continuation<? super C01031> continuation) {
                super(2, continuation);
                this.this$0 = introActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01031(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (StringsKt.equals(this.this$0.getNormalUpdate(), "feeds", true)) {
                    com.appnew.android.home.Constants.RELOADDASHBOARD = "true";
                    Intent intent = new Intent(this.this$0, (Class<?>) FeedsActivity.class);
                    intent.putExtras(new Bundle());
                    intent.setFlags(268468224);
                    this.this$0.startActivity(intent);
                    this.this$0.finish();
                } else if (StringsKt.equals(this.this$0.getNormalUpdate(), Const.HOME, true)) {
                    SharedPreference.getInstance().putString(Const.RELOADHOME, "true");
                    this.this$0.finish();
                } else {
                    if (!StringsKt.equals("1", "1", true)) {
                        if (!StringsKt.equals("1", "2", true)) {
                            if (!StringsKt.equals("1", "3", true)) {
                                if (!StringsKt.equals("1", "4", true)) {
                                    if (!StringsKt.equals("1", "5", true)) {
                                        if (StringsKt.equals("1", "6", true)) {
                                            Intent intent2 = new Intent(this.this$0, (Class<?>) DashboardActivityTheme7.class);
                                            intent2.putExtras(new Bundle());
                                            intent2.setFlags(268468224);
                                            this.this$0.startActivity(intent2);
                                        } else {
                                            Intent intent3 = new Intent(this.this$0, (Class<?>) DashboardActivityTheme8.class);
                                            intent3.putExtras(new Bundle());
                                            intent3.setFlags(268468224);
                                            this.this$0.startActivity(intent3);
                                        }
                                    } else {
                                        Intent intent4 = new Intent(this.this$0, (Class<?>) DashboardActivityTheme5.class);
                                        intent4.putExtras(new Bundle());
                                        intent4.setFlags(268468224);
                                        this.this$0.startActivity(intent4);
                                    }
                                } else {
                                    Intent intent5 = new Intent(this.this$0, (Class<?>) DashboardActivityTheme4.class);
                                    intent5.putExtras(new Bundle());
                                    intent5.setFlags(268468224);
                                    this.this$0.startActivity(intent5);
                                }
                            } else {
                                Intent intent6 = new Intent(this.this$0, (Class<?>) DashboardActivityTheme3.class);
                                intent6.putExtras(new Bundle());
                                intent6.setFlags(268468224);
                                this.this$0.startActivity(intent6);
                            }
                        } else {
                            Intent intent7 = new Intent(this.this$0, (Class<?>) DashboardActivityTheme2.class);
                            intent7.putExtras(new Bundle());
                            intent7.setFlags(268468224);
                            this.this$0.startActivity(intent7);
                        }
                    } else {
                        Intent intent8 = new Intent(this.this$0, (Class<?>) DashboardActivityTheme1.class);
                        intent8.putExtras(new Bundle());
                        intent8.setFlags(268468224);
                        this.this$0.startActivity(intent8);
                    }
                    this.this$0.finish();
                }
                return Unit.INSTANCE;
            }
        }
    }
}
