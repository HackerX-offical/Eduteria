package com.appnew.android.Intro.Fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Intro.Adaoter.AllSubCategoryAdapter;
import com.appnew.android.Intro.Mastercat;
import com.appnew.android.Intro.SubCat;
import com.appnew.android.Intro.SubCatItemSelected;
import com.appnew.android.table.MasteAllCatTable;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: All_ChildCategoryFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00108\u001a\u00020/2\u0006\u00109\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u0010:\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,¨\u0006<"}, d2 = {"Lcom/appnew/android/Intro/Fragment/All_ChildCategoryFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "param1", "", "param2", "sub_cat_recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getSub_cat_recyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setSub_cat_recyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "chose_txt", "Landroid/widget/TextView;", "getChose_txt", "()Landroid/widget/TextView;", "setChose_txt", "(Landroid/widget/TextView;)V", "subCatItemSelected", "Lcom/appnew/android/Intro/SubCatItemSelected;", "getSubCatItemSelected", "()Lcom/appnew/android/Intro/SubCatItemSelected;", "setSubCatItemSelected", "(Lcom/appnew/android/Intro/SubCatItemSelected;)V", "selectedsub_all_cat", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/SubCat;", "Lkotlin/collections/ArrayList;", "allsubCat", "getAllsubCat", "()Lcom/appnew/android/Intro/SubCat;", "setAllsubCat", "(Lcom/appnew/android/Intro/SubCat;)V", "allSubCategoryAdapter", "Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter;", "getAllSubCategoryAdapter", "()Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter;", "setAllSubCategoryAdapter", "(Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter;)V", "is_select_allsubcat", "", "()Ljava/lang/Boolean;", "set_select_allsubcat", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onActivityCreated", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class All_ChildCategoryFragment extends Fragment {
    private AllSubCategoryAdapter allSubCategoryAdapter;
    private SubCat allsubCat;
    private TextView chose_txt;
    private String param1;
    private String param2;
    private SubCatItemSelected subCatItemSelected;
    private RecyclerView sub_cat_recyclerview;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private ArrayList<SubCat> selectedsub_all_cat = new ArrayList<>();
    private Boolean is_select_allsubcat = false;

    @JvmStatic
    public static final All_ChildCategoryFragment newInstance(String str, String str2) {
        return INSTANCE.newInstance(str, str2);
    }

    public final RecyclerView getSub_cat_recyclerview() {
        return this.sub_cat_recyclerview;
    }

    public final void setSub_cat_recyclerview(RecyclerView recyclerView) {
        this.sub_cat_recyclerview = recyclerView;
    }

    public final TextView getChose_txt() {
        return this.chose_txt;
    }

    public final void setChose_txt(TextView textView) {
        this.chose_txt = textView;
    }

    public final SubCatItemSelected getSubCatItemSelected() {
        return this.subCatItemSelected;
    }

    public final void setSubCatItemSelected(SubCatItemSelected subCatItemSelected) {
        this.subCatItemSelected = subCatItemSelected;
    }

    public final SubCat getAllsubCat() {
        return this.allsubCat;
    }

    public final void setAllsubCat(SubCat subCat) {
        this.allsubCat = subCat;
    }

    public final AllSubCategoryAdapter getAllSubCategoryAdapter() {
        return this.allSubCategoryAdapter;
    }

    public final void setAllSubCategoryAdapter(AllSubCategoryAdapter allSubCategoryAdapter) {
        this.allSubCategoryAdapter = allSubCategoryAdapter;
    }

    /* JADX INFO: renamed from: is_select_allsubcat, reason: from getter */
    public final Boolean getIs_select_allsubcat() {
        return this.is_select_allsubcat;
    }

    public final void set_select_allsubcat(Boolean bool) {
        this.is_select_allsubcat = bool;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.param1 = arguments.getString("param1");
            this.param2 = arguments.getString("param2");
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        Iterator<MasteAllCatTable> it = ((IntroActivity) activity).getMasterAllCatTables().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            MasteAllCatTable next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            MasteAllCatTable masteAllCatTable = next;
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            SubCat subCat = ((IntroActivity) activity2).getSubCat();
            Intrinsics.checkNotNull(subCat);
            if (StringsKt.equals(subCat.getId(), masteAllCatTable.getParent_id(), true)) {
                String id = masteAllCatTable.getId();
                Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                String name = masteAllCatTable.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String parent_id = masteAllCatTable.getParent_id();
                Intrinsics.checkNotNullExpressionValue(parent_id, "getParent_id(...)");
                String master_type = masteAllCatTable.getMaster_type();
                Intrinsics.checkNotNullExpressionValue(master_type, "getMaster_type(...)");
                this.selectedsub_all_cat.add(new SubCat(id, name, parent_id, master_type, false, false, false, 112, null));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_all_child_category, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.sub_cat_recyclerview = (RecyclerView) view.findViewById(R.id.sub_cat_recyclerview);
        this.chose_txt = (TextView) view.findViewById(R.id.chose_txt);
        this.subCatItemSelected = new SubCatItemSelected() { // from class: com.appnew.android.Intro.Fragment.All_ChildCategoryFragment.onViewCreated.1
            @Override // com.appnew.android.Intro.SubCatItemSelected
            public void Selecteditem(int item, SubCat subcatdata) {
                Intrinsics.checkNotNullParameter(subcatdata, "subcatdata");
                All_ChildCategoryFragment.this.setAllsubCat(subcatdata);
                All_ChildCategoryFragment.this.set_select_allsubcat(true);
                ((SubCat) All_ChildCategoryFragment.this.selectedsub_all_cat.get(item)).set_selct(true);
                AllSubCategoryAdapter allSubCategoryAdapter = All_ChildCategoryFragment.this.getAllSubCategoryAdapter();
                Intrinsics.checkNotNull(allSubCategoryAdapter);
                allSubCategoryAdapter.setRandomnumber(0);
                AllSubCategoryAdapter allSubCategoryAdapter2 = All_ChildCategoryFragment.this.getAllSubCategoryAdapter();
                Intrinsics.checkNotNull(allSubCategoryAdapter2);
                allSubCategoryAdapter2.notifyDataSetChanged();
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        String lowerCase;
        String lowerCase2;
        String catname;
        String catname2;
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (!TextUtils.isEmpty(((IntroActivity) activity).getPrefence())) {
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            if (StringsKt.contains$default((CharSequence) ((IntroActivity) activity2).getPrefence(), (CharSequence) "#@", false, 2, (Object) null)) {
                FragmentActivity activity3 = getActivity();
                Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                List listSplit$default = StringsKt.split$default((CharSequence) ((IntroActivity) activity3).getPrefence(), new String[]{"#@"}, false, 0, 6, (Object) null);
                int size = this.selectedsub_all_cat.size();
                for (int i = 0; i < size; i++) {
                    if (Intrinsics.areEqual(listSplit$default.get(5), this.selectedsub_all_cat.get(i).getId())) {
                        this.is_select_allsubcat = true;
                        this.allsubCat = new SubCat((String) listSplit$default.get(5), (String) listSplit$default.get(4), "", "", true, false, false, 96, null);
                        this.selectedsub_all_cat.get(i).set_selct(true);
                    }
                }
            }
            FragmentActivity activity4 = getActivity();
            Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            Mastercat mastercat = ((IntroActivity) activity4).getMastercat();
            if (mastercat == null || (catname2 = mastercat.getCatname()) == null) {
                lowerCase = null;
            } else {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                lowerCase = catname2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            if (StringsKt.equals$default(lowerCase, "school", false, 2, null)) {
                TextView textView = this.chose_txt;
                if (textView != null) {
                    textView.setText("Select Class Name");
                }
            } else {
                FragmentActivity activity5 = getActivity();
                Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                Mastercat mastercat2 = ((IntroActivity) activity5).getMastercat();
                if (mastercat2 == null || (catname = mastercat2.getCatname()) == null) {
                    lowerCase2 = null;
                } else {
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                    lowerCase2 = catname.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                }
                if (StringsKt.equals$default(lowerCase2, "engineering", false, 2, null)) {
                    TextView textView2 = this.chose_txt;
                    if (textView2 != null) {
                        textView2.setText("Select Sub Stream");
                    }
                } else {
                    TextView textView3 = this.chose_txt;
                    if (textView3 != null) {
                        textView3.setText("Select Course Name");
                    }
                }
            }
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ArrayList<SubCat> arrayList = this.selectedsub_all_cat;
        SubCatItemSelected subCatItemSelected = this.subCatItemSelected;
        Intrinsics.checkNotNull(subCatItemSelected);
        AllSubCategoryAdapter allSubCategoryAdapter = new AllSubCategoryAdapter(fragmentActivityRequireActivity, arrayList, subCatItemSelected);
        this.allSubCategoryAdapter = allSubCategoryAdapter;
        RecyclerView recyclerView = this.sub_cat_recyclerview;
        if (recyclerView != null) {
            recyclerView.setAdapter(allSubCategoryAdapter);
            recyclerView.setHasFixedSize(true);
        }
    }

    /* JADX INFO: compiled from: All_ChildCategoryFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/appnew/android/Intro/Fragment/All_ChildCategoryFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/Intro/Fragment/All_ChildCategoryFragment;", "param1", "", "param2", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final All_ChildCategoryFragment newInstance(String param1, String param2) {
            Intrinsics.checkNotNullParameter(param1, "param1");
            Intrinsics.checkNotNullParameter(param2, "param2");
            All_ChildCategoryFragment all_ChildCategoryFragment = new All_ChildCategoryFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param1", param1);
            bundle.putString("param2", param2);
            all_ChildCategoryFragment.setArguments(bundle);
            return all_ChildCategoryFragment;
        }
    }
}
