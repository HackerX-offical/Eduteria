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

/* JADX INFO: compiled from: ChildCategoryFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J&\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010>\u001a\u0002052\u0006\u0010?\u001a\u0002092\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010@\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0014j\b\u0012\u0004\u0012\u00020\u001c`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006B"}, d2 = {"Lcom/appnew/android/Intro/Fragment/ChildCategoryFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "param1", "", "param2", "sub_cat_recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getSub_cat_recyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setSub_cat_recyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "chose_txt", "Landroid/widget/TextView;", "getChose_txt", "()Landroid/widget/TextView;", "setChose_txt", "(Landroid/widget/TextView;)V", "masterAllCatTables", "Ljava/util/ArrayList;", "Lcom/appnew/android/table/MasteAllCatTable;", "Lkotlin/collections/ArrayList;", "getMasterAllCatTables", "()Ljava/util/ArrayList;", "setMasterAllCatTables", "(Ljava/util/ArrayList;)V", "selected_master_cat", "Lcom/appnew/android/Intro/SubCat;", "allSubCategoryAdapter", "Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter;", "getAllSubCategoryAdapter", "()Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter;", "setAllSubCategoryAdapter", "(Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter;)V", "is_select_course", "", "()Ljava/lang/Boolean;", "set_select_course", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "subCat", "getSubCat", "()Lcom/appnew/android/Intro/SubCat;", "setSubCat", "(Lcom/appnew/android/Intro/SubCat;)V", "subCatItemSelected", "Lcom/appnew/android/Intro/SubCatItemSelected;", "getSubCatItemSelected", "()Lcom/appnew/android/Intro/SubCatItemSelected;", "setSubCatItemSelected", "(Lcom/appnew/android/Intro/SubCatItemSelected;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onActivityCreated", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChildCategoryFragment extends Fragment {
    private AllSubCategoryAdapter allSubCategoryAdapter;
    private TextView chose_txt;
    private String param1;
    private String param2;
    private SubCat subCat;
    private SubCatItemSelected subCatItemSelected;
    private RecyclerView sub_cat_recyclerview;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private ArrayList<MasteAllCatTable> masterAllCatTables = new ArrayList<>();
    private ArrayList<SubCat> selected_master_cat = new ArrayList<>();
    private Boolean is_select_course = false;

    @JvmStatic
    public static final ChildCategoryFragment newInstance(String str, String str2) {
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

    public final ArrayList<MasteAllCatTable> getMasterAllCatTables() {
        return this.masterAllCatTables;
    }

    public final void setMasterAllCatTables(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.masterAllCatTables = arrayList;
    }

    public final AllSubCategoryAdapter getAllSubCategoryAdapter() {
        return this.allSubCategoryAdapter;
    }

    public final void setAllSubCategoryAdapter(AllSubCategoryAdapter allSubCategoryAdapter) {
        this.allSubCategoryAdapter = allSubCategoryAdapter;
    }

    /* JADX INFO: renamed from: is_select_course, reason: from getter */
    public final Boolean getIs_select_course() {
        return this.is_select_course;
    }

    public final void set_select_course(Boolean bool) {
        this.is_select_course = bool;
    }

    public final SubCat getSubCat() {
        return this.subCat;
    }

    public final void setSubCat(SubCat subCat) {
        this.subCat = subCat;
    }

    public final SubCatItemSelected getSubCatItemSelected() {
        return this.subCatItemSelected;
    }

    public final void setSubCatItemSelected(SubCatItemSelected subCatItemSelected) {
        this.subCatItemSelected = subCatItemSelected;
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
        ArrayList<MasteAllCatTable> masterAllCatTables = ((IntroActivity) activity).getMasterAllCatTables();
        this.masterAllCatTables = masterAllCatTables;
        Iterator<MasteAllCatTable> it = masterAllCatTables.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            MasteAllCatTable next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            MasteAllCatTable masteAllCatTable = next;
            String master_type = masteAllCatTable.getMaster_type();
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            Mastercat mastercat = ((IntroActivity) activity2).getMastercat();
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
                this.selected_master_cat.add(new SubCat(id, name, parent_id, master_type2, false, false, false, 112, null));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_child_category, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.sub_cat_recyclerview = (RecyclerView) view.findViewById(R.id.sub_cat_recyclerview);
        this.chose_txt = (TextView) view.findViewById(R.id.chose_txt);
        this.subCatItemSelected = new SubCatItemSelected() { // from class: com.appnew.android.Intro.Fragment.ChildCategoryFragment.onViewCreated.1
            @Override // com.appnew.android.Intro.SubCatItemSelected
            public void Selecteditem(int item, SubCat subcatdata) {
                Intrinsics.checkNotNullParameter(subcatdata, "subcatdata");
                ChildCategoryFragment.this.set_select_course(true);
                ((SubCat) ChildCategoryFragment.this.selected_master_cat.get(item)).set_selct(true);
                AllSubCategoryAdapter allSubCategoryAdapter = ChildCategoryFragment.this.getAllSubCategoryAdapter();
                Intrinsics.checkNotNull(allSubCategoryAdapter);
                allSubCategoryAdapter.setRandomnumber(0);
                AllSubCategoryAdapter allSubCategoryAdapter2 = ChildCategoryFragment.this.getAllSubCategoryAdapter();
                Intrinsics.checkNotNull(allSubCategoryAdapter2);
                allSubCategoryAdapter2.notifyDataSetChanged();
                ChildCategoryFragment.this.setSubCat(subcatdata);
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
        Boolean bool = this.is_select_course;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            if (!TextUtils.isEmpty(((IntroActivity) activity).getPrefence())) {
                FragmentActivity activity2 = getActivity();
                Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                if (StringsKt.contains$default((CharSequence) ((IntroActivity) activity2).getPrefence(), (CharSequence) "#@", false, 2, (Object) null)) {
                    FragmentActivity activity3 = getActivity();
                    Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                    List listSplit$default = StringsKt.split$default((CharSequence) ((IntroActivity) activity3).getPrefence(), new String[]{"#@"}, false, 0, 6, (Object) null);
                    int size = this.selected_master_cat.size();
                    for (int i = 0; i < size; i++) {
                        if (Intrinsics.areEqual(listSplit$default.get(3), this.selected_master_cat.get(i).getId())) {
                            this.is_select_course = true;
                            this.subCat = new SubCat((String) listSplit$default.get(3), (String) listSplit$default.get(2), "", "", true, false, false, 96, null);
                            this.selected_master_cat.get(i).set_selct(true);
                            FragmentActivity activity4 = getActivity();
                            Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                            ((IntroActivity) activity4).setSubCat(this.subCat);
                        }
                    }
                }
            }
        }
        FragmentActivity activity5 = getActivity();
        Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        Mastercat mastercat = ((IntroActivity) activity5).getMastercat();
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
                textView.setText("Select Board");
            }
        } else {
            FragmentActivity activity6 = getActivity();
            Intrinsics.checkNotNull(activity6, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            Mastercat mastercat2 = ((IntroActivity) activity6).getMastercat();
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
                    textView2.setText("Select Stream");
                }
            } else {
                TextView textView3 = this.chose_txt;
                if (textView3 != null) {
                    textView3.setText("Select Course Category");
                }
            }
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ArrayList<SubCat> arrayList = this.selected_master_cat;
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

    /* JADX INFO: compiled from: ChildCategoryFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/appnew/android/Intro/Fragment/ChildCategoryFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/Intro/Fragment/ChildCategoryFragment;", "param1", "", "param2", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChildCategoryFragment newInstance(String param1, String param2) {
            Intrinsics.checkNotNullParameter(param1, "param1");
            Intrinsics.checkNotNullParameter(param2, "param2");
            ChildCategoryFragment childCategoryFragment = new ChildCategoryFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param1", param1);
            bundle.putString("param2", param2);
            childCategoryFragment.setArguments(bundle);
            return childCategoryFragment;
        }
    }
}
