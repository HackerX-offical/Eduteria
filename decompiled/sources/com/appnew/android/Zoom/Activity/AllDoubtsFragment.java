package com.appnew.android.Zoom.Activity;

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
import androidx.core.widget.NestedScrollView;
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

/* JADX INFO: compiled from: AllDoubtsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J&\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001a\u0010T\u001a\u00020K2\u0006\u0010U\u001a\u00020O2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010V\u001a\u00020KH\u0016J\u0010\u0010W\u001a\u00020K2\u0006\u0010X\u001a\u00020EH\u0002J.\u0010Y\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010Z2\b\u0010[\u001a\u0004\u0018\u00010\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u00072\u0006\u0010]\u001a\u00020^H\u0016J,\u0010_\u001a\u00020K2\u0006\u0010`\u001a\u00020a2\b\u0010[\u001a\u0004\u0018\u00010\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u00072\u0006\u0010b\u001a\u00020EH\u0016J\u0016\u0010c\u001a\u00020K2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020)0eH\u0002J \u0010f\u001a\u00020K2\u0016\u0010g\u001a\u0012\u0012\u0004\u0012\u00020i0hj\b\u0012\u0004\u0012\u00020i`jH\u0002J&\u0010k\u001a\u00020K2\b\u0010`\u001a\u0004\u0018\u00010\u00072\b\u0010[\u001a\u0004\u0018\u00010\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010l\u001a\u00020E2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J\u0006\u0010o\u001a\u00020KJ\u0006\u0010p\u001a\u00020KR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\b\u0012\u0004\u0012\u00020)0\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001a\u0010,\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006q"}, d2 = {"Lcom/appnew/android/Zoom/Activity/AllDoubtsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "<init>", "()V", "param1", "", "param2", "filter_one_click", "Landroid/widget/RelativeLayout;", "getFilter_one_click", "()Landroid/widget/RelativeLayout;", "setFilter_one_click", "(Landroid/widget/RelativeLayout;)V", "filter_one", "Landroid/widget/TextView;", "getFilter_one", "()Landroid/widget/TextView;", "setFilter_one", "(Landroid/widget/TextView;)V", "filter_two_click", "getFilter_two_click", "setFilter_two_click", "filter_two", "getFilter_two", "setFilter_two", "addDoubt_floatingButton", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "getAddDoubt_floatingButton", "()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "setAddDoubt_floatingButton", "(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V", "topicsList", "", "Lcom/appnew/android/Model/ZoomModel/Topics;", "getTopicsList", "()Ljava/util/List;", "setTopicsList", "(Ljava/util/List;)V", "subjectList", "Lcom/appnew/android/Model/ZoomModel/DoubtData;", "getSubjectList", "setSubjectList", "ll_top_two", "Landroid/widget/LinearLayout;", "getLl_top_two", "()Landroid/widget/LinearLayout;", "setLl_top_two", "(Landroid/widget/LinearLayout;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "getNestedScrollView", "()Landroidx/core/widget/NestedScrollView;", "setNestedScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "mPage", "", "getMPage", "()I", "setMPage", "(I)V", "status", "", "getStatus", "()Z", "setStatus", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onResume", "get_doubt_list", "showProgress", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "setAdapter", "doubtDetailData", "", "setAdapter1", "doubtSubjectArray", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/DoubtSubject;", "Lkotlin/collections/ArrayList;", "ErrorCallBack", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "goToAskDoubt", "refreshData", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AllDoubtsFragment extends Fragment implements NetworkCall.MyNetworkCallBack, PopupMenu.OnMenuItemClickListener {
    public static final int $stable = 8;
    public FloatingActionButton addDoubt_floatingButton;
    public TextView filter_one;
    public RelativeLayout filter_one_click;
    public TextView filter_two;
    public RelativeLayout filter_two_click;
    public LinearLayout ll_top_two;
    private int mPage = 1;
    public NestedScrollView nestedScrollView;
    private String param1;
    private String param2;
    public ProgressBar progressBar;
    private boolean status;
    public List<DoubtData> subjectList;
    public List<Topics> topicsList;

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

    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            return progressBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        return null;
    }

    public final void setProgressBar(ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    public final NestedScrollView getNestedScrollView() {
        NestedScrollView nestedScrollView = this.nestedScrollView;
        if (nestedScrollView != null) {
            return nestedScrollView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
        return null;
    }

    public final void setNestedScrollView(NestedScrollView nestedScrollView) {
        Intrinsics.checkNotNullParameter(nestedScrollView, "<set-?>");
        this.nestedScrollView = nestedScrollView;
    }

    public final int getMPage() {
        return this.mPage;
    }

    public final void setMPage(int i) {
        this.mPage = i;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.param1 = arguments.getString("param1");
            this.param2 = arguments.getString("param2");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_all_doubts, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Helper.showProgressDialog(getActivity());
        AllDoubtsFragmentKt.setDoubtSubject(new DoubtSubject());
        AllDoubtsFragmentKt.setDoubtDetailData(new ArrayList());
        AllDoubtsFragmentKt.setDoubtSubjectArray(new ArrayList());
        AllDoubtsFragmentKt.setNetworkCall(new NetworkCall(this, getContext()));
        AllDoubtsFragmentKt.pullToReferesh = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh_doubtAll);
        AllDoubtsFragmentKt.recyclerview = (RecyclerView) view.findViewById(R.id.doubt_subjects);
        setProgressBar((ProgressBar) view.findViewById(R.id.progressBar));
        setFilter_one_click((RelativeLayout) view.findViewById(R.id.filter_one_click));
        setFilter_one((TextView) view.findViewById(R.id.filterOne));
        setFilter_two_click((RelativeLayout) view.findViewById(R.id.filter_two_click));
        setFilter_two((TextView) view.findViewById(R.id.filterTwo));
        AllDoubtsFragmentKt.doubt_list_recycler = (RecyclerView) view.findViewById(R.id.doubt_list_recycler);
        AllDoubtsFragmentKt.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        setLl_top_two((LinearLayout) view.findViewById(R.id.ll_top_two));
        setNestedScrollView((NestedScrollView) view.findViewById(R.id.nestedScrollView));
        setAddDoubt_floatingButton((FloatingActionButton) view.findViewById(R.id.addDoubt_floatingButton));
        getNestedScrollView().setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.Zoom.Activity.AllDoubtsFragment$$ExternalSyntheticLambda0
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                AllDoubtsFragment.onViewCreated$lambda$1(this.f$0, nestedScrollView, i, i2, i3, i4);
            }
        });
        AllDoubtsFragmentKt.setSubjectId("");
        NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_DOUBT_SUBJECT_LIST, "", false, false);
        }
        get_doubt_list(false);
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.DOUBT_TOPIC), "1", true)) {
            RecyclerView recyclerView = AllDoubtsFragmentKt.recyclerview;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(8);
            getLl_top_two().setVisibility(0);
        } else {
            RecyclerView recyclerView2 = AllDoubtsFragmentKt.recyclerview;
            Intrinsics.checkNotNull(recyclerView2);
            recyclerView2.setVisibility(0);
            getLl_top_two().setVisibility(8);
        }
        AllDoubtsFragmentKt.layoutManager1 = new LinearLayoutManager(getContext());
        RecyclerView recyclerView3 = AllDoubtsFragmentKt.doubt_list_recycler;
        Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setLayoutManager(AllDoubtsFragmentKt.layoutManager1);
        AllDoubtsFragmentKt.setItemClickListener(new ItemClickListener() { // from class: com.appnew.android.Zoom.Activity.AllDoubtsFragment.onViewCreated.2
            @Override // com.appnew.android.Zoom.ItemClickListener
            public void onClick(String position) {
                Intrinsics.checkNotNullParameter(position, "position");
                if (position.equals("0")) {
                    AllDoubtsFragmentKt.setSubjectId("");
                } else {
                    AllDoubtsFragmentKt.setSubjectId(position);
                }
                AllDoubtsFragment.this.get_doubt_list(false);
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
        });
        SwipeRefreshLayout swipeRefreshLayout = AllDoubtsFragmentKt.pullToReferesh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Zoom.Activity.AllDoubtsFragment$$ExternalSyntheticLambda1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    AllDoubtsFragment.onViewCreated$lambda$2(this.f$0);
                }
            });
        }
        getFilter_one_click().setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.AllDoubtsFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AllDoubtsFragment.onViewCreated$lambda$3(this.f$0);
            }
        }));
        getFilter_two_click().setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.AllDoubtsFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AllDoubtsFragment.onViewCreated$lambda$4(this.f$0);
            }
        }));
        getAddDoubt_floatingButton().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.AllDoubtsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.goToAskDoubt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(AllDoubtsFragment allDoubtsFragment, NestedScrollView v, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getChildAt(v.getChildCount() - 1) == null || i2 < v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight() || i2 <= i4 || !AllDoubtsFragmentKt.isPaginationAvailable) {
            return;
        }
        allDoubtsFragment.getProgressBar().setVisibility(0);
        allDoubtsFragment.mPage++;
        allDoubtsFragment.status = true;
        allDoubtsFragment.get_doubt_list(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(AllDoubtsFragment allDoubtsFragment) {
        allDoubtsFragment.status = false;
        allDoubtsFragment.mPage = 1;
        if (Helper.isConnected(allDoubtsFragment.getContext())) {
            Helper.showProgressDialog(allDoubtsFragment.getActivity());
        }
        allDoubtsFragment.get_doubt_list(false);
        SwipeRefreshLayout swipeRefreshLayout = AllDoubtsFragmentKt.pullToReferesh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(AllDoubtsFragment allDoubtsFragment) {
        if (!Helper.isNetworkConnected(allDoubtsFragment.getActivity())) {
            Helper.showInternetToast(allDoubtsFragment.getActivity());
            return Unit.INSTANCE;
        }
        PopupMenu popupMenu = new PopupMenu(allDoubtsFragment.requireActivity(), allDoubtsFragment.getFilter_one(), 3);
        ArrayList<DoubtSubject> doubtSubjectArray = AllDoubtsFragmentKt.getDoubtSubjectArray();
        Intrinsics.checkNotNull(doubtSubjectArray);
        Iterator<DoubtSubject> it = doubtSubjectArray.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            DoubtSubject next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            popupMenu.getMenu().add(next.getName());
        }
        AllDoubtsFragmentKt.setClicktype("2");
        popupMenu.setOnMenuItemClickListener(allDoubtsFragment);
        popupMenu.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(AllDoubtsFragment allDoubtsFragment) {
        if (!Helper.isNetworkConnected(allDoubtsFragment.getActivity())) {
            Helper.showInternetToast(allDoubtsFragment.getActivity());
            return Unit.INSTANCE;
        }
        PopupMenu popupMenu = new PopupMenu(allDoubtsFragment.requireActivity(), allDoubtsFragment.getFilter_two(), 3);
        Iterator<Topics> it = allDoubtsFragment.getTopicsList().iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next().getName());
        }
        AllDoubtsFragmentKt.setClicktype("3");
        popupMenu.setOnMenuItemClickListener(allDoubtsFragment);
        popupMenu.show();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void get_doubt_list(boolean showProgress) {
        if (Helper.isConnected(getActivity())) {
            Helper.showProgressDialog(getActivity());
            NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
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
        encryptionData.setSubject_id(AllDoubtsFragmentKt.getSubjectId());
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.DOUBT_TOPIC), "1", true)) {
            encryptionData.setTopic_id(AllDoubtsFragmentKt.getTopicId());
        }
        encryptionData.setType("all");
        encryptionData.setPage(new StringBuilder().append(this.mPage).toString());
        return service.getAllDoubt(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        ArrayList<DoubtSubject> doubtSubjectArray;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_SUBJECT_LIST)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    AllDoubtsFragmentKt.setDoubtSubjectDetail((DoubtSubjectDetail) new Gson().fromJson(jsonstring.toString(), DoubtSubjectDetail.class));
                    DoubtSubjectDetail doubtSubjectDetail = AllDoubtsFragmentKt.getDoubtSubjectDetail();
                    Intrinsics.checkNotNull(doubtSubjectDetail);
                    if (doubtSubjectDetail.getData() != null) {
                        ArrayList<DoubtSubject> doubtSubjectArray2 = AllDoubtsFragmentKt.getDoubtSubjectArray();
                        if (doubtSubjectArray2 != null) {
                            DoubtSubjectDetail doubtSubjectDetail2 = AllDoubtsFragmentKt.getDoubtSubjectDetail();
                            Intrinsics.checkNotNull(doubtSubjectDetail2);
                            doubtSubjectArray2.addAll(doubtSubjectDetail2.getData());
                        }
                        DoubtSubject doubtSubject = AllDoubtsFragmentKt.getDoubtSubject();
                        if (doubtSubject != null) {
                            doubtSubject.setId("0");
                        }
                        DoubtSubject doubtSubject2 = AllDoubtsFragmentKt.getDoubtSubject();
                        if (doubtSubject2 != null) {
                            doubtSubject2.setPosition("0");
                        }
                        DoubtSubject doubtSubject3 = AllDoubtsFragmentKt.getDoubtSubject();
                        if (doubtSubject3 != null) {
                            doubtSubject3.setName("All");
                        }
                        DoubtSubject doubtSubject4 = AllDoubtsFragmentKt.getDoubtSubject();
                        if (doubtSubject4 != null && (doubtSubjectArray = AllDoubtsFragmentKt.getDoubtSubjectArray()) != null) {
                            doubtSubjectArray.add(0, doubtSubject4);
                        }
                        ArrayList<DoubtSubject> doubtSubjectArray3 = AllDoubtsFragmentKt.getDoubtSubjectArray();
                        if (doubtSubjectArray3 != null) {
                            setAdapter1(doubtSubjectArray3);
                        }
                        getFilter_one().setText("All");
                        getFilter_two_click().setVisibility(4);
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
                if (jsonstring.getString("status").equals("true")) {
                    AllDoubtsFragmentKt.setTime(Long.valueOf(jsonstring.optLong("time")));
                    if (this.status) {
                        if (getProgressBar().isShown()) {
                            getProgressBar().setVisibility(8);
                        }
                        AllDoubtsFragmentKt.isPaginationAvailable = true;
                        ArrayList<DoubtData> doubtDetailData = AllDoubtsFragmentKt.getDoubtDetailData();
                        Intrinsics.checkNotNull(doubtDetailData);
                        int size = doubtDetailData.size();
                        AllDoubtsFragmentKt.setDoubtDetail((DoubtDetail) new Gson().fromJson(jsonstring.toString(), DoubtDetail.class));
                        DoubtDetail doubtDetail = AllDoubtsFragmentKt.getDoubtDetail();
                        Intrinsics.checkNotNull(doubtDetail);
                        if (doubtDetail.getData() != null) {
                            DoubtDetail doubtDetail2 = AllDoubtsFragmentKt.getDoubtDetail();
                            Intrinsics.checkNotNull(doubtDetail2);
                            if (doubtDetail2.getData().size() > 0) {
                                DoubtDetail doubtDetail3 = AllDoubtsFragmentKt.getDoubtDetail();
                                Intrinsics.checkNotNull(doubtDetail3);
                                for (DoubtData doubtData : doubtDetail3.getData()) {
                                    ArrayList<DoubtData> doubtDetailData2 = AllDoubtsFragmentKt.getDoubtDetailData();
                                    if (doubtDetailData2 != null) {
                                        doubtDetailData2.add(doubtData);
                                    }
                                }
                                RecyclerView.Adapter adapter = AllDoubtsFragmentKt.allDoubtAdapter;
                                Intrinsics.checkNotNull(adapter);
                                ArrayList<DoubtData> doubtDetailData3 = AllDoubtsFragmentKt.getDoubtDetailData();
                                Intrinsics.checkNotNull(doubtDetailData3);
                                int size2 = doubtDetailData3.size() - 1;
                                ArrayList<DoubtData> doubtDetailData4 = AllDoubtsFragmentKt.getDoubtDetailData();
                                Intrinsics.checkNotNull(doubtDetailData4);
                                adapter.notifyItemRangeChanged(size2, doubtDetailData4.size() - size);
                                return;
                            }
                        }
                        if (getProgressBar().isShown()) {
                            getProgressBar().setVisibility(8);
                            return;
                        }
                        return;
                    }
                    ArrayList<DoubtData> doubtDetailData5 = AllDoubtsFragmentKt.getDoubtDetailData();
                    Intrinsics.checkNotNull(doubtDetailData5);
                    doubtDetailData5.clear();
                    AllDoubtsFragmentKt.setDoubtDetail((DoubtDetail) new Gson().fromJson(jsonstring.toString(), DoubtDetail.class));
                    DoubtDetail doubtDetail4 = AllDoubtsFragmentKt.getDoubtDetail();
                    Intrinsics.checkNotNull(doubtDetail4);
                    if (doubtDetail4.getData() == null) {
                        RecyclerView recyclerView = AllDoubtsFragmentKt.doubt_list_recycler;
                        if (recyclerView != null) {
                            recyclerView.setVisibility(8);
                        }
                        RelativeLayout relativeLayout = AllDoubtsFragmentKt.no_data_found_RL;
                        Intrinsics.checkNotNull(relativeLayout);
                        relativeLayout.setVisibility(0);
                        FloatingActionButton addDoubt_floatingButton = getAddDoubt_floatingButton();
                        Intrinsics.checkNotNull(addDoubt_floatingButton);
                        addDoubt_floatingButton.setVisibility(0);
                        return;
                    }
                    ArrayList<DoubtData> doubtDetailData6 = AllDoubtsFragmentKt.getDoubtDetailData();
                    if (doubtDetailData6 != null) {
                        DoubtDetail doubtDetail5 = AllDoubtsFragmentKt.getDoubtDetail();
                        Intrinsics.checkNotNull(doubtDetail5);
                        doubtDetailData6.addAll(doubtDetail5.getData());
                    }
                    ArrayList<DoubtData> doubtDetailData7 = AllDoubtsFragmentKt.getDoubtDetailData();
                    if (doubtDetailData7 != null) {
                        setAdapter(doubtDetailData7);
                        return;
                    }
                    return;
                }
                if (!this.status) {
                    RecyclerView recyclerView2 = AllDoubtsFragmentKt.doubt_list_recycler;
                    if (recyclerView2 != null) {
                        recyclerView2.setVisibility(8);
                    }
                    RelativeLayout relativeLayout2 = AllDoubtsFragmentKt.no_data_found_RL;
                    Intrinsics.checkNotNull(relativeLayout2);
                    relativeLayout2.setVisibility(0);
                    FloatingActionButton addDoubt_floatingButton2 = getAddDoubt_floatingButton();
                    Intrinsics.checkNotNull(addDoubt_floatingButton2);
                    addDoubt_floatingButton2.setVisibility(0);
                } else if (getProgressBar().isShown()) {
                    getProgressBar().setVisibility(8);
                }
                if (jsonstring.has("auth_code")) {
                    StringsKt.equals(jsonstring.getString("auth_code"), Const.EXPIRY_AUTH_CODE, true);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private final void setAdapter(List<? extends DoubtData> doubtDetailData) {
        RecyclerView recyclerView = AllDoubtsFragmentKt.doubt_list_recycler;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        RelativeLayout relativeLayout = AllDoubtsFragmentKt.no_data_found_RL;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(8);
        FloatingActionButton addDoubt_floatingButton = getAddDoubt_floatingButton();
        Intrinsics.checkNotNull(addDoubt_floatingButton);
        addDoubt_floatingButton.setVisibility(8);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        AllDoubtsFragmentKt.allDoubtAdapter = new AllDoubtAdapter(doubtDetailData, fragmentActivityRequireActivity, "all_doubt");
        RecyclerView recyclerView2 = AllDoubtsFragmentKt.doubt_list_recycler;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(AllDoubtsFragmentKt.allDoubtAdapter);
    }

    private final void setAdapter1(ArrayList<DoubtSubject> doubtSubjectArray) {
        AllDoubtsFragmentKt.layoutManager = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView recyclerView = AllDoubtsFragmentKt.recyclerview;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(AllDoubtsFragmentKt.layoutManager);
        ItemClickListener itemClickListener = AllDoubtsFragmentKt.getItemClickListener();
        AllDoubtsFragmentKt.adapter = itemClickListener != null ? new CustomAdapter(doubtSubjectArray, itemClickListener) : null;
        RecyclerView recyclerView2 = AllDoubtsFragmentKt.recyclerview;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(AllDoubtsFragmentKt.adapter);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (Intrinsics.areEqual(apitype, API.API_GET_USER_DOUBT_LIST)) {
            if (AllDoubtsFragmentKt.getPaginationLoader() != null) {
                ProgressBar paginationLoader = AllDoubtsFragmentKt.getPaginationLoader();
                Intrinsics.checkNotNull(paginationLoader);
                if (paginationLoader.isShown()) {
                    ProgressBar paginationLoader2 = AllDoubtsFragmentKt.getPaginationLoader();
                    Intrinsics.checkNotNull(paginationLoader2);
                    paginationLoader2.setVisibility(8);
                }
            }
            if (AllDoubtsFragmentKt.recyclerview == null || AllDoubtsFragmentKt.no_data_found_RL == null) {
                return;
            }
            RecyclerView recyclerView = AllDoubtsFragmentKt.recyclerview;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(8);
            RelativeLayout relativeLayout = AllDoubtsFragmentKt.no_data_found_RL;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(0);
        }
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        if (StringsKt.equals(AllDoubtsFragmentKt.getClicktype(), "2", true)) {
            Intrinsics.checkNotNull(item);
            CharSequence title = item.getTitle();
            Intrinsics.checkNotNull(title);
            if (!title.equals("All")) {
                getFilter_two_click().setVisibility(0);
                ArrayList<DoubtSubject> doubtSubjectArray = AllDoubtsFragmentKt.getDoubtSubjectArray();
                Intrinsics.checkNotNull(doubtSubjectArray);
                Iterator<DoubtSubject> it = doubtSubjectArray.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DoubtSubject next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    DoubtSubject doubtSubject = next;
                    if (StringsKt.equals(doubtSubject.getName(), String.valueOf(item.getTitle()), true)) {
                        setTopicsList(doubtSubject.getTopics());
                        if (getTopicsList().size() > 0) {
                            getFilter_one().setText(doubtSubject.getName());
                            AllDoubtsFragmentKt.setSubjectId(doubtSubject.getId());
                            getFilter_two().setText(getTopicsList().get(0).getName());
                            AllDoubtsFragmentKt.setTopicId(getTopicsList().get(0).getId());
                            get_doubt_list(true);
                        }
                    }
                }
            } else {
                AllDoubtsFragmentKt.setTopicId("");
                AllDoubtsFragmentKt.setSubjectId("");
                getFilter_one().setText("All");
                get_doubt_list(true);
                getFilter_two_click().setVisibility(4);
            }
        } else if (StringsKt.equals(AllDoubtsFragmentKt.getClicktype(), "3", true)) {
            Iterator<Topics> it2 = getTopicsList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Topics next2 = it2.next();
                String name = next2.getName();
                Intrinsics.checkNotNull(item);
                if (StringsKt.equals(name, String.valueOf(item.getTitle()), true)) {
                    getFilter_two().setText(next2.getName());
                    AllDoubtsFragmentKt.setTopicId(next2.getId());
                    get_doubt_list(true);
                    break;
                }
            }
        }
        return false;
    }

    public final void goToAskDoubt() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Zoom.Activity.DoubtsActivity");
        ((DoubtsActivity) context).goToAskDoubt();
    }

    public final void refreshData() {
        if (!isAdded() || getContext() == null) {
            return;
        }
        this.mPage = 1;
        this.status = false;
        get_doubt_list(true);
    }
}
