package com.appnew.android.loginRevamp.Fragment;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.DivisionModel.DivisionModel;
import com.appnew.android.Model.DivisionModel.SubDivision;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.loginRevamp.Fragment.SelectDivisionClassFragment;
import com.appnew.android.pojo.Userinfo.Data;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: SelectDivisionClassFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00108\u001a\u00020-2\u0006\u00109\u001a\u0002032\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u0010:\u001a\u00020-H\u0002J\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020=0<j\b\u0012\u0004\u0012\u00020=`>J\u0016\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0@2\u0006\u0010A\u001a\u00020\u001bJ\u0006\u0010B\u001a\u00020-J.\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010\u001b2\b\u0010F\u001a\u0004\u0018\u00010\u001b2\u0006\u0010G\u001a\u00020HH\u0016J(\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020K2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u0006H\u0016J&\u0010M\u001a\u00020-2\b\u0010N\u001a\u0004\u0018\u00010\u001b2\b\u0010E\u001a\u0004\u0018\u00010\u001b2\b\u0010F\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010O\u001a\u00020-2\b\u0010P\u001a\u0004\u0018\u00010\u001bH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u0011\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001c\u0010)\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001f¨\u0006R"}, d2 = {"Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "activity", "Landroid/app/Activity;", "isFromHome", "", "isForceClose", "<init>", "(Landroid/app/Activity;ZZ)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "()Z", "setFromHome", "(Z)V", "setForceClose", "preferenceRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "formPageLevel", "", "getFormPageLevel", "()Ljava/lang/String;", "setFormPageLevel", "(Ljava/lang/String;)V", "selectedStudentDivision", "getSelectedStudentDivision", "setSelectedStudentDivision", "selectedStudentClass", "getSelectedStudentClass", "setSelectedStudentClass", "selectedStudentDivisionTitle", "getSelectedStudentDivisionTitle", "setSelectedStudentDivisionTitle", "selectedStudentClassTitle", "getSelectedStudentClassTitle", "setSelectedStudentClassTitle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "showStudentDivision", "getDivisionActualList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/DivisionModel/DivisionModel;", "Lkotlin/collections/ArrayList;", "getSubDivisionTitlesForDivision", "", "selectedDivision", "hitApiForUpdateProfile", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonobject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "showMessage", "message", "ExamPreferenceAdapter", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectDivisionClassFragment extends BottomSheetDialogFragment implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private Activity activity;
    private String formPageLevel;
    private boolean isForceClose;
    private boolean isFromHome;
    private NetworkCall networkCall;
    private RecyclerView preferenceRecyclerview;
    private String selectedStudentClass;
    private String selectedStudentClassTitle;
    private String selectedStudentDivision;
    private String selectedStudentDivisionTitle;

    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.activity = activity;
    }

    /* JADX INFO: renamed from: isFromHome, reason: from getter */
    public final boolean getIsFromHome() {
        return this.isFromHome;
    }

    public final void setFromHome(boolean z) {
        this.isFromHome = z;
    }

    /* JADX INFO: renamed from: isForceClose, reason: from getter */
    public final boolean getIsForceClose() {
        return this.isForceClose;
    }

    public final void setForceClose(boolean z) {
        this.isForceClose = z;
    }

    public SelectDivisionClassFragment(Activity activity, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.isFromHome = z;
        this.isForceClose = z2;
        this.formPageLevel = "0";
        this.selectedStudentDivision = "0";
        this.selectedStudentClass = "0";
        this.selectedStudentDivisionTitle = "";
        this.selectedStudentClassTitle = "";
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final String getFormPageLevel() {
        return this.formPageLevel;
    }

    public final void setFormPageLevel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.formPageLevel = str;
    }

    public final String getSelectedStudentDivision() {
        return this.selectedStudentDivision;
    }

    public final void setSelectedStudentDivision(String str) {
        this.selectedStudentDivision = str;
    }

    public final String getSelectedStudentClass() {
        return this.selectedStudentClass;
    }

    public final void setSelectedStudentClass(String str) {
        this.selectedStudentClass = str;
    }

    public final String getSelectedStudentDivisionTitle() {
        return this.selectedStudentDivisionTitle;
    }

    public final void setSelectedStudentDivisionTitle(String str) {
        this.selectedStudentDivisionTitle = str;
    }

    public final String getSelectedStudentClassTitle() {
        return this.selectedStudentClassTitle;
    }

    public final void setSelectedStudentClassTitle(String str) {
        this.selectedStudentClassTitle = str;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomSheetDialogStyle);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        dialogOnCreateDialog.setCancelable(false);
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_division_class_view, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.loginRevamp.Fragment.SelectDivisionClassFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return SelectDivisionClassFragment.onViewCreated$lambda$1(this.f$0, dialogInterface, i, keyEvent);
                }
            });
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.appnew.android.loginRevamp.Fragment.SelectDivisionClassFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    SelectDivisionClassFragment.onViewCreated$lambda$3(dialogInterface);
                }
            });
        }
        this.networkCall = new NetworkCall(this, this.activity);
        this.preferenceRecyclerview = (RecyclerView) view.findViewById(R.id.prefrence_recyclerview);
        showStudentDivision();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1(SelectDivisionClassFragment selectDivisionClassFragment, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        if (Intrinsics.areEqual(selectDivisionClassFragment.formPageLevel, "1")) {
            selectDivisionClassFragment.showStudentDivision();
        } else if (selectDivisionClassFragment.isForceClose) {
            Activity activity = selectDivisionClassFragment.activity;
            if (activity instanceof ComponentActivity) {
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                ((ComponentActivity) activity).getOnBackPressedDispatcher().onBackPressed();
            } else {
                activity.onBackPressed();
            }
        } else {
            selectDivisionClassFragment.dismissAllowingStateLoss();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(DialogInterface dialogInterface) {
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        View viewFindViewById = ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
        if (viewFindViewById != null) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.height = -1;
            viewFindViewById.setLayoutParams(layoutParams);
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setDraggable(false);
        }
    }

    private final void showStudentDivision() {
        this.formPageLevel = "0";
        RecyclerView recyclerView = this.preferenceRecyclerview;
        if (recyclerView != null) {
            recyclerView.setAdapter(new ExamPreferenceAdapter(getDivisionActualList(), this));
        }
    }

    /* JADX INFO: compiled from: SelectDivisionClassFragment.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001+B)\b\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB1\b\u0016\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000eJ\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020!H\u0016J\u0016\u0010'\u001a\u00020(2\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0*R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment$ExamPreferenceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment$ExamPreferenceAdapter$MyViewHodler;", "divisionList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/DivisionModel/DivisionModel;", "Lkotlin/collections/ArrayList;", "fragment", "Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment;", "<init>", "(Ljava/util/ArrayList;Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment;)V", "subDivisionList", "Lcom/appnew/android/Model/DivisionModel/SubDivision;", Const.DIVISION, "(Ljava/util/ArrayList;Lcom/appnew/android/Model/DivisionModel/DivisionModel;Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment;)V", "getDivisionList", "()Ljava/util/ArrayList;", "setDivisionList", "(Ljava/util/ArrayList;)V", "getSubDivisionList", "setSubDivisionList", "getDivision", "()Lcom/appnew/android/Model/DivisionModel/DivisionModel;", "setDivision", "(Lcom/appnew/android/Model/DivisionModel/DivisionModel;)V", "getFragment", "()Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment;", "setFragment", "(Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "getWithCommaDivision", "", "subDivisionTitlesForDivision", "", "MyViewHodler", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExamPreferenceAdapter extends RecyclerView.Adapter<MyViewHodler> {
        public static final int $stable = 8;
        private DivisionModel division;
        private ArrayList<DivisionModel> divisionList;
        private SelectDivisionClassFragment fragment;
        private ArrayList<SubDivision> subDivisionList;

        public final ArrayList<DivisionModel> getDivisionList() {
            return this.divisionList;
        }

        public final void setDivisionList(ArrayList<DivisionModel> arrayList) {
            this.divisionList = arrayList;
        }

        public final ArrayList<SubDivision> getSubDivisionList() {
            return this.subDivisionList;
        }

        public final void setSubDivisionList(ArrayList<SubDivision> arrayList) {
            this.subDivisionList = arrayList;
        }

        public final DivisionModel getDivision() {
            return this.division;
        }

        public final void setDivision(DivisionModel divisionModel) {
            this.division = divisionModel;
        }

        public final SelectDivisionClassFragment getFragment() {
            return this.fragment;
        }

        public final void setFragment(SelectDivisionClassFragment selectDivisionClassFragment) {
            Intrinsics.checkNotNullParameter(selectDivisionClassFragment, "<set-?>");
            this.fragment = selectDivisionClassFragment;
        }

        public ExamPreferenceAdapter(ArrayList<DivisionModel> divisionList, SelectDivisionClassFragment fragment) {
            Intrinsics.checkNotNullParameter(divisionList, "divisionList");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.divisionList = divisionList;
            this.fragment = fragment;
        }

        public ExamPreferenceAdapter(ArrayList<SubDivision> subDivisionList, DivisionModel division, SelectDivisionClassFragment fragment) {
            Intrinsics.checkNotNullParameter(subDivisionList, "subDivisionList");
            Intrinsics.checkNotNullParameter(division, "division");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.subDivisionList = subDivisionList;
            this.division = division;
            this.fragment = fragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_prefrence_item_adapter, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new MyViewHodler(viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHodler holder, int position) {
            final SubDivision subDivision;
            CharSequence title;
            final DivisionModel divisionModel;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (Intrinsics.areEqual(this.fragment.getFormPageLevel(), "0")) {
                ArrayList<DivisionModel> arrayList = this.divisionList;
                if (arrayList == null || (divisionModel = arrayList.get(position)) == null) {
                    return;
                }
                holder.getCategoryName().setText(TextUtils.isEmpty(divisionModel.getTitle()) ? "N/A" : divisionModel.getTitle());
                String divisionID = Helper.getDivisionID();
                if (divisionID != null && StringsKt.equals(divisionID, divisionModel.getId(), true)) {
                    holder.getCategoryName().setText(holder.itemView.getContext().getString(R.string.label_with_check, StringsKt.trim((CharSequence) holder.getCategoryName().getText().toString()).toString()));
                }
                SelectDivisionClassFragment selectDivisionClassFragment = this.fragment;
                String title2 = divisionModel.getTitle();
                if (title2 == null) {
                    title2 = "";
                }
                String withCommaDivision = getWithCommaDivision(selectDivisionClassFragment.getSubDivisionTitlesForDivision(title2));
                if (!TextUtils.isEmpty(withCommaDivision)) {
                    holder.getCategorySubitem().setVisibility(0);
                    holder.getCategorySubitem().setText(withCommaDivision);
                } else {
                    holder.getCategorySubitem().setVisibility(8);
                }
                holder.getContainer().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SelectDivisionClassFragment$ExamPreferenceAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SelectDivisionClassFragment.ExamPreferenceAdapter.onBindViewHolder$lambda$0(divisionModel, this, view);
                    }
                });
                return;
            }
            ArrayList<SubDivision> arrayList2 = this.subDivisionList;
            if (arrayList2 == null || (subDivision = arrayList2.get(position)) == null) {
                return;
            }
            TextView categoryName = holder.getCategoryName();
            if (!TextUtils.isEmpty(subDivision.getTitle())) {
                title = subDivision.getTitle();
            }
            categoryName.setText(title);
            String subDivisionID = Helper.getSubDivisionID();
            if (subDivisionID != null && StringsKt.equals(subDivisionID, subDivision.getId(), true)) {
                holder.getCategoryName().setText(holder.itemView.getContext().getString(R.string.label_with_check, StringsKt.trim((CharSequence) holder.getCategoryName().getText().toString()).toString()));
            }
            holder.getCategorySubitem().setVisibility(8);
            holder.getContainer().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SelectDivisionClassFragment$ExamPreferenceAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectDivisionClassFragment.ExamPreferenceAdapter.onBindViewHolder$lambda$1(this.f$0, subDivision, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$0(DivisionModel divisionModel, ExamPreferenceAdapter examPreferenceAdapter, View view) {
            ArrayList arrayList;
            ArrayList<SubDivision> sub_divisions = divisionModel.getSub_divisions();
            if (sub_divisions == null || (arrayList = (ArrayList) CollectionsKt.toCollection(sub_divisions, new ArrayList())) == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.isEmpty()) {
                examPreferenceAdapter.fragment.setFormPageLevel("1");
                examPreferenceAdapter.fragment.setSelectedStudentDivision(divisionModel.getId());
                examPreferenceAdapter.fragment.setSelectedStudentDivisionTitle(divisionModel.getTitle());
                RecyclerView recyclerView = examPreferenceAdapter.fragment.preferenceRecyclerview;
                if (recyclerView != null) {
                    recyclerView.setAdapter(new ExamPreferenceAdapter(arrayList, divisionModel, examPreferenceAdapter.fragment));
                    return;
                }
                return;
            }
            examPreferenceAdapter.fragment.setSelectedStudentDivision(divisionModel.getId());
            examPreferenceAdapter.fragment.setSelectedStudentClass("0");
            examPreferenceAdapter.fragment.setSelectedStudentDivisionTitle(divisionModel.getTitle());
            examPreferenceAdapter.fragment.setSelectedStudentClassTitle("");
            examPreferenceAdapter.fragment.hitApiForUpdateProfile();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$1(ExamPreferenceAdapter examPreferenceAdapter, SubDivision subDivision, View view) {
            examPreferenceAdapter.fragment.setSelectedStudentClass(subDivision.getId());
            examPreferenceAdapter.fragment.setSelectedStudentClassTitle(subDivision.getTitle());
            examPreferenceAdapter.fragment.hitApiForUpdateProfile();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (Intrinsics.areEqual(this.fragment.getFormPageLevel(), "1")) {
                ArrayList<SubDivision> arrayList = this.subDivisionList;
                if (arrayList != null) {
                    return arrayList.size();
                }
                return 0;
            }
            ArrayList<DivisionModel> arrayList2 = this.divisionList;
            if (arrayList2 != null) {
                return arrayList2.size();
            }
            return 0;
        }

        public final String getWithCommaDivision(List<String> subDivisionTitlesForDivision) {
            Intrinsics.checkNotNullParameter(subDivisionTitlesForDivision, "subDivisionTitlesForDivision");
            if (!subDivisionTitlesForDivision.isEmpty()) {
                String strJoin = TextUtils.join(Constants.SEPARATOR_COMMA, subDivisionTitlesForDivision);
                Intrinsics.checkNotNullExpressionValue(strJoin, "join(...)");
                return strJoin;
            }
            return "";
        }

        /* JADX INFO: compiled from: SelectDivisionClassFragment.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/appnew/android/loginRevamp/Fragment/SelectDivisionClassFragment$ExamPreferenceAdapter$MyViewHodler;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "container", "Landroid/widget/RelativeLayout;", "getContainer", "()Landroid/widget/RelativeLayout;", "setContainer", "(Landroid/widget/RelativeLayout;)V", "categoryName", "Landroid/widget/TextView;", "getCategoryName", "()Landroid/widget/TextView;", "setCategoryName", "(Landroid/widget/TextView;)V", "categorySubitem", "getCategorySubitem", "setCategorySubitem", "logo", "Landroid/widget/ImageView;", "getLogo", "()Landroid/widget/ImageView;", "setLogo", "(Landroid/widget/ImageView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class MyViewHodler extends RecyclerView.ViewHolder {
            public static final int $stable = 8;
            private TextView categoryName;
            private TextView categorySubitem;
            private RelativeLayout container;
            private ImageView logo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MyViewHodler(View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                View viewFindViewById = itemView.findViewById(R.id.container);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.container = (RelativeLayout) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.category_name);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.categoryName = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.category_subitem);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.categorySubitem = (TextView) viewFindViewById3;
                this.logo = (ImageView) itemView.findViewById(R.id.logo);
            }

            public final RelativeLayout getContainer() {
                return this.container;
            }

            public final void setContainer(RelativeLayout relativeLayout) {
                Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
                this.container = relativeLayout;
            }

            public final TextView getCategoryName() {
                return this.categoryName;
            }

            public final void setCategoryName(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.categoryName = textView;
            }

            public final TextView getCategorySubitem() {
                return this.categorySubitem;
            }

            public final void setCategorySubitem(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.categorySubitem = textView;
            }

            public final ImageView getLogo() {
                return this.logo;
            }

            public final void setLogo(ImageView imageView) {
                this.logo = imageView;
            }
        }
    }

    public final ArrayList<DivisionModel> getDivisionActualList() {
        ArrayList<DivisionModel> arrayList = new ArrayList<>();
        try {
            String string = SharedPreference.getInstance().getString(Const.DIVISION);
            if (!TextUtils.isEmpty(string)) {
                ArrayList arrayList2 = (ArrayList) new Gson().fromJson(string, new TypeToken<ArrayList<DivisionModel>>() { // from class: com.appnew.android.loginRevamp.Fragment.SelectDivisionClassFragment$getDivisionActualList$type$1
                }.getType());
                if (arrayList2 != null) {
                    arrayList.addAll(arrayList2);
                }
            }
            return arrayList;
        } catch (JsonSyntaxException e2) {
            Log.e("SelectDivisionFragment", "Division parse error", e2);
            return arrayList;
        }
    }

    public final List<String> getSubDivisionTitlesForDivision(String selectedDivision) {
        ArrayList<SubDivision> sub_divisions;
        String title;
        Intrinsics.checkNotNullParameter(selectedDivision, "selectedDivision");
        ArrayList arrayList = new ArrayList();
        try {
            String string = SharedPreference.getInstance().getString(Const.DIVISION);
            if (!TextUtils.isEmpty(string)) {
                List<DivisionModel> list = (List) new Gson().fromJson(string, new TypeToken<List<DivisionModel>>() { // from class: com.appnew.android.loginRevamp.Fragment.SelectDivisionClassFragment$getSubDivisionTitlesForDivision$type$1
                }.getType());
                if (list != null) {
                    for (DivisionModel divisionModel : list) {
                        if (StringsKt.equals(selectedDivision, divisionModel.getTitle(), true) && (sub_divisions = divisionModel.getSub_divisions()) != null) {
                            for (SubDivision subDivision : sub_divisions) {
                                if (subDivision != null && (title = subDivision.getTitle()) != null) {
                                    arrayList.add(title);
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e2) {
            Log.e("SelectDivisionFragment", "Subdivision parse error", e2);
            return arrayList;
        }
    }

    public final void hitApiForUpdateProfile() {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.update_profile, "", true, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.update_profile)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setDivision(this.selectedStudentDivision);
        encryptionData.setSub_division(this.selectedStudentClass);
        return service.updateprofile(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonobject, "jsonobject");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        if (Intrinsics.areEqual(apitype, API.update_profile)) {
            if (Intrinsics.areEqual(jsonobject.optString("status"), "true")) {
                if (this.isFromHome) {
                    Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
                    String str = this.selectedStudentDivisionTitle;
                    if (str == null) {
                        str = "";
                    }
                    loggedInUser.setDivision(str);
                    String str2 = this.selectedStudentClassTitle;
                    loggedInUser.setStudent_class(str2 != null ? str2 : "");
                    SharedPreference.getInstance().putString(Const.GET_DIVISION, this.selectedStudentDivision);
                    SharedPreference.getInstance().putString(Const.GET_SUB_DIVISION, this.selectedStudentClass);
                    SharedPreference.getInstance().setLoggedInUserr(loggedInUser);
                    Intent intent = this.activity.getIntent();
                    ActivityOptions activityOptionsMakeCustomAnimation = ActivityOptions.makeCustomAnimation(this.activity, R.anim.activity_in, R.anim.activity_out);
                    this.activity.finish();
                    this.activity.startActivity(intent, activityOptionsMakeCustomAnimation.toBundle());
                    return;
                }
                return;
            }
            showMessage(jsonobject.optString("message"));
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        showMessage(jsonstring);
    }

    private final void showMessage(String message) {
        String str = message;
        if (str == null || str.length() == 0) {
            return;
        }
        Toast.makeText(this.activity, str, 0).show();
    }
}
