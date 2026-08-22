package com.appnew.android.Zoom.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.TimeTable.Data;
import com.appnew.android.Model.ZoomModel.CurrentAffairDataModel;
import com.appnew.android.Model.ZoomModel.DoubtData;
import com.appnew.android.Model.ZoomModel.DoubtDetail;
import com.appnew.android.Model.ZoomModel.DoubtSubject;
import com.appnew.android.Model.ZoomModel.DoubtSubjectDetail;
import com.appnew.android.Model.ZoomModel.Topics;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Zoom.Activity.DoubtsActivity;
import com.appnew.android.Zoom.Adapter.AllDoubtAdapter;
import com.appnew.android.Zoom.Adapter.CustomAdapter;
import com.appnew.android.Zoom.ItemClickListener;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: MyDoubtFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0086\u0001\u001a\u00030\u0087\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J.\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\u0013\u0010\u0090\u0001\u001a\u00030\u0087\u00012\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0007J \u0010\u0092\u0001\u001a\u00030\u0087\u00012\b\u0010\u0093\u0001\u001a\u00030\u008b\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\n\u0010\u0094\u0001\u001a\u00030\u0087\u0001H\u0016J\u0013\u0010\u0095\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0096\u0001\u001a\u00020EH\u0002J4\u0010\u0097\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0098\u00012\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00072\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J3\u0010\u009d\u0001\u001a\u00030\u0087\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010 \u0001\u001a\u00020EH\u0016J\u0019\u0010¡\u0001\u001a\u00030\u0087\u00012\r\u00103\u001a\t\u0012\u0004\u0012\u0002040¢\u0001H\u0002J\"\u0010£\u0001\u001a\u00030\u0087\u00012\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.H\u0002J+\u0010¤\u0001\u001a\u00030\u0087\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010¥\u0001\u001a\u00030\u0087\u0001J\u0015\u0010¦\u0001\u001a\u00020E2\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0016J\b\u0010©\u0001\u001a\u00030\u0087\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R.\u0010+\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010,j\n\u0012\u0004\u0012\u00020-\u0018\u0001`.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R.\u00103\u001a\u0016\u0012\u0004\u0012\u000204\u0018\u00010,j\n\u0012\u0004\u0012\u000204\u0018\u0001`.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00100\"\u0004\b6\u00102R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010D\u001a\u00020EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010G\"\u0004\bL\u0010IR\u000e\u0010M\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\t\"\u0004\bV\u0010\u000bR\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020_X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010[\"\u0004\bf\u0010]R\u001a\u0010g\u001a\u00020_X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010a\"\u0004\bi\u0010cR \u0010j\u001a\b\u0012\u0004\u0012\u00020l0kX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR \u0010q\u001a\b\u0012\u0004\u0012\u0002040kX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010n\"\u0004\bs\u0010pR\u001a\u0010t\u001a\u00020uX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020{X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\t\"\u0005\b\u0082\u0001\u0010\u000bR\u001d\u0010\u0083\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\t\"\u0005\b\u0085\u0001\u0010\u000b¨\u0006ª\u0001"}, d2 = {"Lcom/appnew/android/Zoom/Fragment/MyDoubtFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "<init>", "()V", "doubtIdToreset", "", "getDoubtIdToreset", "()Ljava/lang/String;", "setDoubtIdToreset", "(Ljava/lang/String;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager1", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/CustomAdapter$ViewHolder;", "allDoubtAdapter", "Lcom/appnew/android/Zoom/Adapter/AllDoubtAdapter$ViewHolder;", "no_data_found_RL", "Landroid/widget/RelativeLayout;", "recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "doubt_list_recycler", "paginationLoader", "Landroid/widget/ProgressBar;", "getPaginationLoader", "()Landroid/widget/ProgressBar;", "setPaginationLoader", "(Landroid/widget/ProgressBar;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "doubtSubjectDetail", "Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;", "getDoubtSubjectDetail", "()Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;", "setDoubtSubjectDetail", "(Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;)V", "doubtSubjectArray", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/DoubtSubject;", "Lkotlin/collections/ArrayList;", "getDoubtSubjectArray", "()Ljava/util/ArrayList;", "setDoubtSubjectArray", "(Ljava/util/ArrayList;)V", "doubtDetailData", "Lcom/appnew/android/Model/ZoomModel/DoubtData;", "getDoubtDetailData", "setDoubtDetailData", "doubtDetail", "Lcom/appnew/android/Model/ZoomModel/DoubtDetail;", "getDoubtDetail", "()Lcom/appnew/android/Model/ZoomModel/DoubtDetail;", "setDoubtDetail", "(Lcom/appnew/android/Model/ZoomModel/DoubtDetail;)V", "time", "", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "status", "", "getStatus", "()Z", "setStatus", "(Z)V", "doubtPage", "getDoubtPage", "setDoubtPage", "isPaginationAvailable", "itemClickListener", "Lcom/appnew/android/Zoom/ItemClickListener;", "getItemClickListener", "()Lcom/appnew/android/Zoom/ItemClickListener;", "setItemClickListener", "(Lcom/appnew/android/Zoom/ItemClickListener;)V", "subjectId", "getSubjectId", "setSubjectId", "pullToReferesh", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "filter_one_click", "getFilter_one_click", "()Landroid/widget/RelativeLayout;", "setFilter_one_click", "(Landroid/widget/RelativeLayout;)V", "filter_one", "Landroid/widget/TextView;", "getFilter_one", "()Landroid/widget/TextView;", "setFilter_one", "(Landroid/widget/TextView;)V", "filter_two_click", "getFilter_two_click", "setFilter_two_click", "filter_two", "getFilter_two", "setFilter_two", "topicsList", "", "Lcom/appnew/android/Model/ZoomModel/Topics;", "getTopicsList", "()Ljava/util/List;", "setTopicsList", "(Ljava/util/List;)V", "subjectList", "getSubjectList", "setSubjectList", "ll_top_two", "Landroid/widget/LinearLayout;", "getLl_top_two", "()Landroid/widget/LinearLayout;", "setLl_top_two", "(Landroid/widget/LinearLayout;)V", "addDoubt_floatingButton", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "getAddDoubt_floatingButton", "()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "setAddDoubt_floatingButton", "(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V", "topicId", "getTopicId", "setTopicId", "clicktype", "getClicktype", "setClicktype", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "resetResolveStatus", "doubtId", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onResume", "get_doubt_list", "showProgress", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "setAdapter", "", "setAdapter1", "ErrorCallBack", "goToAskDoubt", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "refreshData", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyDoubtFragment extends Fragment implements NetworkCall.MyNetworkCallBack, PopupMenu.OnMenuItemClickListener {
    public static final int $stable = 8;
    private RecyclerView.Adapter<CustomAdapter.ViewHolder> adapter;
    public FloatingActionButton addDoubt_floatingButton;
    private RecyclerView.Adapter<AllDoubtAdapter.ViewHolder> allDoubtAdapter;
    private DoubtDetail doubtDetail;
    private ArrayList<DoubtData> doubtDetailData;
    private boolean doubtPage;
    private ArrayList<DoubtSubject> doubtSubjectArray;
    private DoubtSubjectDetail doubtSubjectDetail;
    private RecyclerView doubt_list_recycler;
    public TextView filter_one;
    public RelativeLayout filter_one_click;
    public TextView filter_two;
    public RelativeLayout filter_two_click;
    private ItemClickListener itemClickListener;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager1;
    public LinearLayout ll_top_two;
    private NetworkCall networkCall;
    private RelativeLayout no_data_found_RL;
    private ProgressBar paginationLoader;
    private SwipeRefreshLayout pullToReferesh;
    private RecyclerView recyclerview;
    private boolean status;
    private String subjectId;
    public List<DoubtData> subjectList;
    private Long time;
    private String topicId;
    public List<Topics> topicsList;
    private String doubtIdToreset = "";
    private boolean isPaginationAvailable = true;
    private String clicktype = "";

    public final String getDoubtIdToreset() {
        return this.doubtIdToreset;
    }

    public final void setDoubtIdToreset(String str) {
        this.doubtIdToreset = str;
    }

    public final ProgressBar getPaginationLoader() {
        return this.paginationLoader;
    }

    public final void setPaginationLoader(ProgressBar progressBar) {
        this.paginationLoader = progressBar;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final DoubtSubjectDetail getDoubtSubjectDetail() {
        return this.doubtSubjectDetail;
    }

    public final void setDoubtSubjectDetail(DoubtSubjectDetail doubtSubjectDetail) {
        this.doubtSubjectDetail = doubtSubjectDetail;
    }

    public final ArrayList<DoubtSubject> getDoubtSubjectArray() {
        return this.doubtSubjectArray;
    }

    public final void setDoubtSubjectArray(ArrayList<DoubtSubject> arrayList) {
        this.doubtSubjectArray = arrayList;
    }

    public final ArrayList<DoubtData> getDoubtDetailData() {
        return this.doubtDetailData;
    }

    public final void setDoubtDetailData(ArrayList<DoubtData> arrayList) {
        this.doubtDetailData = arrayList;
    }

    public final DoubtDetail getDoubtDetail() {
        return this.doubtDetail;
    }

    public final void setDoubtDetail(DoubtDetail doubtDetail) {
        this.doubtDetail = doubtDetail;
    }

    public final Long getTime() {
        return this.time;
    }

    public final void setTime(Long l) {
        this.time = l;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public final boolean getDoubtPage() {
        return this.doubtPage;
    }

    public final void setDoubtPage(boolean z) {
        this.doubtPage = z;
    }

    public final ItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final RelativeLayout getFilter_one_click() {
        RelativeLayout relativeLayout = this.filter_one_click;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filter_one_click");
        return null;
    }

    public final void setFilter_one_click(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.filter_one_click = relativeLayout;
    }

    public final TextView getFilter_one() {
        TextView textView = this.filter_one;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filter_one");
        return null;
    }

    public final void setFilter_one(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.filter_one = textView;
    }

    public final RelativeLayout getFilter_two_click() {
        RelativeLayout relativeLayout = this.filter_two_click;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filter_two_click");
        return null;
    }

    public final void setFilter_two_click(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.filter_two_click = relativeLayout;
    }

    public final TextView getFilter_two() {
        TextView textView = this.filter_two;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filter_two");
        return null;
    }

    public final void setFilter_two(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.filter_two = textView;
    }

    public final List<Topics> getTopicsList() {
        List<Topics> list = this.topicsList;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topicsList");
        return null;
    }

    public final void setTopicsList(List<Topics> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.topicsList = list;
    }

    public final List<DoubtData> getSubjectList() {
        List<DoubtData> list = this.subjectList;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subjectList");
        return null;
    }

    public final void setSubjectList(List<DoubtData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.subjectList = list;
    }

    public final LinearLayout getLl_top_two() {
        LinearLayout linearLayout = this.ll_top_two;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ll_top_two");
        return null;
    }

    public final void setLl_top_two(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.ll_top_two = linearLayout;
    }

    public final FloatingActionButton getAddDoubt_floatingButton() {
        FloatingActionButton floatingActionButton = this.addDoubt_floatingButton;
        if (floatingActionButton != null) {
            return floatingActionButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("addDoubt_floatingButton");
        return null;
    }

    public final void setAddDoubt_floatingButton(FloatingActionButton floatingActionButton) {
        Intrinsics.checkNotNullParameter(floatingActionButton, "<set-?>");
        this.addDoubt_floatingButton = floatingActionButton;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final void setTopicId(String str) {
        this.topicId = str;
    }

    public final String getClicktype() {
        return this.clicktype;
    }

    public final void setClicktype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clicktype = str;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_my_doubt, container, false);
    }

    public final void resetResolveStatus(String doubtId) {
        ArrayList<DoubtData> arrayList = this.doubtDetailData;
        if ((arrayList != null ? arrayList.size() : 0) > 0) {
            ArrayList<DoubtData> arrayList2 = this.doubtDetailData;
            Intrinsics.checkNotNull(arrayList2);
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                ArrayList<DoubtData> arrayList3 = this.doubtDetailData;
                Intrinsics.checkNotNull(arrayList3);
                if (arrayList3.get(i).getDoubt_id().equals(doubtId)) {
                    ArrayList<DoubtData> arrayList4 = this.doubtDetailData;
                    Intrinsics.checkNotNull(arrayList4);
                    arrayList4.get(i).setIs_complete("1");
                    RecyclerView.Adapter<AllDoubtAdapter.ViewHolder> adapter = this.allDoubtAdapter;
                    Intrinsics.checkNotNull(adapter);
                    adapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.doubtDetailData = new ArrayList<>();
        this.doubtSubjectArray = new ArrayList<>();
        this.networkCall = new NetworkCall(this, getContext());
        this.pullToReferesh = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        setAddDoubt_floatingButton((FloatingActionButton) view.findViewById(R.id.addDoubt_floatingButton));
        this.recyclerview = (RecyclerView) view.findViewById(R.id.doubt_subjects);
        this.doubt_list_recycler = (RecyclerView) view.findViewById(R.id.mydoubt_list_recycler);
        setFilter_one_click((RelativeLayout) view.findViewById(R.id.filter_one_click));
        setFilter_one((TextView) view.findViewById(R.id.filterOne));
        setFilter_two_click((RelativeLayout) view.findViewById(R.id.filter_two_click));
        setFilter_two((TextView) view.findViewById(R.id.filterTwo));
        setLl_top_two((LinearLayout) view.findViewById(R.id.ll_top_two));
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.DOUBT_TOPIC), "1", true)) {
            RecyclerView recyclerView = this.recyclerview;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(8);
            getLl_top_two().setVisibility(0);
        } else {
            RecyclerView recyclerView2 = this.recyclerview;
            Intrinsics.checkNotNull(recyclerView2);
            recyclerView2.setVisibility(0);
            getLl_top_two().setVisibility(8);
        }
        this.layoutManager1 = new LinearLayoutManager(getContext());
        RecyclerView recyclerView3 = this.doubt_list_recycler;
        Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setLayoutManager(this.layoutManager1);
        this.itemClickListener = new ItemClickListener() { // from class: com.appnew.android.Zoom.Fragment.MyDoubtFragment.onViewCreated.1
            @Override // com.appnew.android.Zoom.ItemClickListener
            public void onClick(String position) {
                Intrinsics.checkNotNullParameter(position, "position");
                MyDoubtFragment.this.setSubjectId(position);
                MyDoubtFragment.this.get_doubt_list(false);
            }

            @Override // com.appnew.android.Zoom.ItemClickListener
            public void onClickCurrentAffair(List<CurrentAffairDataModel> position) {
                Intrinsics.checkNotNullParameter(position, "position");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.appnew.android.Zoom.ItemClickListener
            public void onClickTimeTableDate(ArrayList<Data> data, int position) {
                Intrinsics.checkNotNullParameter(data, "data");
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }

            @Override // com.appnew.android.Zoom.ItemClickListener
            public void getPosition(int pos) {
                throw new NotImplementedError("An operation is not implemented: Not yet implemented");
            }
        };
        SwipeRefreshLayout swipeRefreshLayout = this.pullToReferesh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Zoom.Fragment.MyDoubtFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    MyDoubtFragment.onViewCreated$lambda$0(this.f$0);
                }
            });
        }
        getFilter_one_click().setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.MyDoubtFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyDoubtFragment.onViewCreated$lambda$1(this.f$0);
            }
        }));
        getFilter_two_click().setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Fragment.MyDoubtFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyDoubtFragment.onViewCreated$lambda$2(this.f$0);
            }
        }));
        if (Helper.isConnected(getContext())) {
            Helper.showProgressDialog(getContext());
            NetworkCall networkCall = this.networkCall;
            if (networkCall != null) {
                networkCall.NetworkAPICall(API.API_GET_DOUBT_SUBJECT_LIST, "", false, false);
            }
        } else {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            ExtensionFucationKt.showToast(contextRequireContext, "No Internet Connection!!");
        }
        getAddDoubt_floatingButton().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Fragment.MyDoubtFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.goToAskDoubt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(MyDoubtFragment myDoubtFragment) {
        myDoubtFragment.status = false;
        Helper.showProgressDialog(myDoubtFragment.getActivity());
        myDoubtFragment.get_doubt_list(false);
        SwipeRefreshLayout swipeRefreshLayout = myDoubtFragment.pullToReferesh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(MyDoubtFragment myDoubtFragment) {
        if (!Helper.isNetworkConnected(myDoubtFragment.getActivity())) {
            Helper.showInternetToast(myDoubtFragment.getActivity());
            return Unit.INSTANCE;
        }
        PopupMenu popupMenu = new PopupMenu(myDoubtFragment.requireActivity(), myDoubtFragment.getFilter_one(), 3);
        ArrayList<DoubtSubject> arrayList = myDoubtFragment.doubtSubjectArray;
        Intrinsics.checkNotNull(arrayList);
        Iterator<DoubtSubject> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            DoubtSubject next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            popupMenu.getMenu().add(next.getName());
        }
        myDoubtFragment.clicktype = "2";
        popupMenu.setOnMenuItemClickListener(myDoubtFragment);
        popupMenu.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(MyDoubtFragment myDoubtFragment) {
        if (!Helper.isNetworkConnected(myDoubtFragment.getActivity())) {
            Helper.showInternetToast(myDoubtFragment.getActivity());
            return Unit.INSTANCE;
        }
        PopupMenu popupMenu = new PopupMenu(myDoubtFragment.requireActivity(), myDoubtFragment.getFilter_two(), 3);
        Iterator<Topics> it = myDoubtFragment.getTopicsList().iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next().getName());
        }
        myDoubtFragment.clicktype = "3";
        popupMenu.setOnMenuItemClickListener(myDoubtFragment);
        popupMenu.show();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String string = SharedPreference.getInstance().getString("doubtResetId");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() != 0) {
            resetResolveStatus(SharedPreference.getInstance().getString("doubtResetId"));
            SharedPreference.getInstance().putString("doubtResetId", "");
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Zoom.Activity.DoubtsActivity");
        if (((DoubtsActivity) context).getIsDialogShown()) {
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.Zoom.Activity.DoubtsActivity");
            ((DoubtsActivity) context2).setDialogShown(false);
            return;
        }
        this.doubtSubjectArray = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void get_doubt_list(boolean showProgress) {
        if (Helper.isConnected(getContext())) {
            Helper.showProgressDialog(getContext());
            NetworkCall networkCall = this.networkCall;
            if (networkCall != null) {
                networkCall.NetworkAPICall(API.API_GET_USER_DOUBT_LIST, "", showProgress, false);
                return;
            }
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ExtensionFucationKt.showToast(contextRequireContext, "No Internet Connection!!");
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_SUBJECT_LIST)) {
            return service.postSubjectList(AES.encrypt(new Gson().toJson(new EncryptionData())));
        }
        if (!Intrinsics.areEqual(apitype, API.API_GET_USER_DOUBT_LIST)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setSubject_id(this.subjectId);
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.DOUBT_TOPIC), "1", true)) {
            encryptionData.setTopic_id(this.topicId);
        }
        encryptionData.setType("my");
        return service.getAllDoubt(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        ArrayList<DoubtSubject> arrayList;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_SUBJECT_LIST)) {
            try {
                Helper.dismissProgressDialog();
                if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                    DoubtSubjectDetail doubtSubjectDetail = (DoubtSubjectDetail) new Gson().fromJson(jsonstring.toString(), DoubtSubjectDetail.class);
                    this.doubtSubjectDetail = doubtSubjectDetail;
                    Intrinsics.checkNotNull(doubtSubjectDetail);
                    if (doubtSubjectDetail.getData().size() > 0) {
                        DoubtSubjectDetail doubtSubjectDetail2 = this.doubtSubjectDetail;
                        Intrinsics.checkNotNull(doubtSubjectDetail2);
                        this.subjectId = doubtSubjectDetail2.getData().get(0).getId();
                        get_doubt_list(false);
                        ArrayList<DoubtSubject> arrayList2 = this.doubtSubjectArray;
                        if (arrayList2 != null) {
                            DoubtSubjectDetail doubtSubjectDetail3 = this.doubtSubjectDetail;
                            Intrinsics.checkNotNull(doubtSubjectDetail3);
                            arrayList2.addAll(doubtSubjectDetail3.getData());
                        }
                        if (!StringsKt.equals(SharedPreference.getInstance().getString(Const.DOUBT_TOPIC), "1", true) && (arrayList = this.doubtSubjectArray) != null) {
                            setAdapter1(arrayList);
                        }
                        DoubtSubjectDetail doubtSubjectDetail4 = this.doubtSubjectDetail;
                        Intrinsics.checkNotNull(doubtSubjectDetail4);
                        if (doubtSubjectDetail4.getData().get(0).getTopics().size() > 0) {
                            ArrayList<DoubtSubject> arrayList3 = this.doubtSubjectArray;
                            Intrinsics.checkNotNull(arrayList3);
                            this.topicId = arrayList3.get(0).getTopics().get(0).getId();
                            TextView filter_one = getFilter_one();
                            ArrayList<DoubtSubject> arrayList4 = this.doubtSubjectArray;
                            Intrinsics.checkNotNull(arrayList4);
                            filter_one.setText(arrayList4.get(0).getName());
                            TextView filter_two = getFilter_two();
                            ArrayList<DoubtSubject> arrayList5 = this.doubtSubjectArray;
                            Intrinsics.checkNotNull(arrayList5);
                            filter_two.setText(arrayList5.get(0).getTopics().get(0).getName());
                            ArrayList<DoubtSubject> arrayList6 = this.doubtSubjectArray;
                            Intrinsics.checkNotNull(arrayList6);
                            this.subjectId = arrayList6.get(0).getId();
                            ArrayList<DoubtSubject> arrayList7 = this.doubtSubjectArray;
                            Intrinsics.checkNotNull(arrayList7);
                            setTopicsList(arrayList7.get(0).getTopics());
                        }
                        get_doubt_list(false);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.API_GET_USER_DOUBT_LIST)) {
            try {
                Helper.dismissProgressDialog();
                RelativeLayout relativeLayout = null;
                if (jsonstring.getString("status").equals("true")) {
                    RecyclerView recyclerView = this.doubt_list_recycler;
                    Intrinsics.checkNotNull(recyclerView);
                    recyclerView.setVisibility(0);
                    RelativeLayout relativeLayout2 = this.no_data_found_RL;
                    if (relativeLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("no_data_found_RL");
                        relativeLayout2 = null;
                    }
                    relativeLayout2.setVisibility(8);
                    this.status = true;
                    ArrayList<DoubtData> arrayList8 = this.doubtDetailData;
                    if (arrayList8 != null) {
                        arrayList8.clear();
                    }
                    this.time = Long.valueOf(jsonstring.optLong("time"));
                    this.isPaginationAvailable = true;
                    ProgressBar progressBar = this.paginationLoader;
                    if (progressBar != null) {
                        Intrinsics.checkNotNull(progressBar);
                        if (progressBar.isShown()) {
                            ProgressBar progressBar2 = this.paginationLoader;
                            Intrinsics.checkNotNull(progressBar2);
                            progressBar2.setVisibility(8);
                        }
                    }
                    if (this.status) {
                        DoubtDetail doubtDetail = (DoubtDetail) new Gson().fromJson(jsonstring.toString(), DoubtDetail.class);
                        this.doubtDetail = doubtDetail;
                        Intrinsics.checkNotNull(doubtDetail);
                        if (doubtDetail.getData() != null) {
                            ArrayList<DoubtData> arrayList9 = this.doubtDetailData;
                            if (arrayList9 != null) {
                                DoubtDetail doubtDetail2 = this.doubtDetail;
                                Intrinsics.checkNotNull(doubtDetail2);
                                arrayList9.addAll(doubtDetail2.getData());
                            }
                            ArrayList<DoubtData> arrayList10 = this.doubtDetailData;
                            if (arrayList10 != null) {
                                setAdapter(arrayList10);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView2 = this.doubt_list_recycler;
                    Intrinsics.checkNotNull(recyclerView2);
                    recyclerView2.setVisibility(8);
                    RelativeLayout relativeLayout3 = this.no_data_found_RL;
                    if (relativeLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("no_data_found_RL");
                    } else {
                        relativeLayout = relativeLayout3;
                    }
                    relativeLayout.setVisibility(0);
                    FloatingActionButton addDoubt_floatingButton = getAddDoubt_floatingButton();
                    Intrinsics.checkNotNull(addDoubt_floatingButton);
                    addDoubt_floatingButton.setVisibility(0);
                    return;
                }
                RecyclerView recyclerView3 = this.doubt_list_recycler;
                Intrinsics.checkNotNull(recyclerView3);
                recyclerView3.setVisibility(8);
                RelativeLayout relativeLayout4 = this.no_data_found_RL;
                if (relativeLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("no_data_found_RL");
                } else {
                    relativeLayout = relativeLayout4;
                }
                relativeLayout.setVisibility(0);
                FloatingActionButton addDoubt_floatingButton2 = getAddDoubt_floatingButton();
                Intrinsics.checkNotNull(addDoubt_floatingButton2);
                addDoubt_floatingButton2.setVisibility(0);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private final void setAdapter(List<? extends DoubtData> doubtDetailData) {
        FloatingActionButton addDoubt_floatingButton = getAddDoubt_floatingButton();
        Intrinsics.checkNotNull(addDoubt_floatingButton);
        addDoubt_floatingButton.setVisibility(8);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        this.allDoubtAdapter = new AllDoubtAdapter(doubtDetailData, fragmentActivityRequireActivity, "my_doubt");
        RecyclerView recyclerView = this.doubt_list_recycler;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setAdapter(this.allDoubtAdapter);
    }

    private final void setAdapter1(ArrayList<DoubtSubject> doubtSubjectArray) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.layoutManager = linearLayoutManager;
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        ItemClickListener itemClickListener = this.itemClickListener;
        this.adapter = itemClickListener != null ? new CustomAdapter(doubtSubjectArray, itemClickListener) : null;
        RecyclerView recyclerView2 = this.recyclerview;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(this.adapter);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_SUBJECT_LIST)) {
            ProgressBar progressBar = this.paginationLoader;
            if (progressBar != null) {
                Intrinsics.checkNotNull(progressBar);
                if (progressBar.isShown()) {
                    ProgressBar progressBar2 = this.paginationLoader;
                    Intrinsics.checkNotNull(progressBar2);
                    progressBar2.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(apitype, API.API_GET_USER_DOUBT_LIST)) {
            ProgressBar progressBar3 = this.paginationLoader;
            if (progressBar3 != null) {
                Intrinsics.checkNotNull(progressBar3);
                if (progressBar3.isShown()) {
                    ProgressBar progressBar4 = this.paginationLoader;
                    Intrinsics.checkNotNull(progressBar4);
                    progressBar4.setVisibility(8);
                }
            }
            if (this.doubt_list_recycler != null) {
                if (this.no_data_found_RL == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("no_data_found_RL");
                }
                RecyclerView recyclerView = this.doubt_list_recycler;
                Intrinsics.checkNotNull(recyclerView);
                recyclerView.setVisibility(8);
                RelativeLayout relativeLayout = this.no_data_found_RL;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("no_data_found_RL");
                    relativeLayout = null;
                }
                relativeLayout.setVisibility(0);
                FloatingActionButton addDoubt_floatingButton = getAddDoubt_floatingButton();
                Intrinsics.checkNotNull(addDoubt_floatingButton);
                addDoubt_floatingButton.setVisibility(0);
            }
        }
    }

    public final void goToAskDoubt() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Zoom.Activity.DoubtsActivity");
        ((DoubtsActivity) context).goToAskDoubt();
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        if (StringsKt.equals(this.clicktype, "2", true)) {
            ArrayList<DoubtSubject> arrayList = this.doubtSubjectArray;
            Intrinsics.checkNotNull(arrayList);
            Iterator<DoubtSubject> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DoubtSubject next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                DoubtSubject doubtSubject = next;
                String name = doubtSubject.getName();
                Intrinsics.checkNotNull(item);
                if (StringsKt.equals(name, String.valueOf(item.getTitle()), true)) {
                    setTopicsList(doubtSubject.getTopics());
                    if (getTopicsList().size() > 0) {
                        getFilter_one().setText(doubtSubject.getName());
                        this.subjectId = doubtSubject.getId();
                        getFilter_two().setText(getTopicsList().get(0).getName());
                        this.topicId = getTopicsList().get(0).getId();
                        get_doubt_list(true);
                    }
                }
            }
        } else if (StringsKt.equals(this.clicktype, "3", true)) {
            Iterator<Topics> it2 = getTopicsList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Topics next2 = it2.next();
                String name2 = next2.getName();
                Intrinsics.checkNotNull(item);
                if (StringsKt.equals(name2, String.valueOf(item.getTitle()), true)) {
                    getFilter_two().setText(next2.getName());
                    this.topicId = next2.getId();
                    get_doubt_list(true);
                    break;
                }
            }
        }
        return false;
    }

    public final void refreshData() {
        if (!isAdded() || getContext() == null) {
            return;
        }
        this.status = false;
        get_doubt_list(true);
    }
}
