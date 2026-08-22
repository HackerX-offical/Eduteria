package com.appnew.android.Intro.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Dao.GetMasterAllCatDao;
import com.appnew.android.Dao.MasterCatDao;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Intro.Adaoter.CategoryAdapter;
import com.appnew.android.Intro.Adaoter.CategoryMasterTypeAdapter;
import com.appnew.android.Intro.ItemSelected;
import com.appnew.android.Intro.Mastercat;
import com.appnew.android.Intro.SubCat;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainCategoryFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001a\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010F\u001a\u00020D2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010G\u001a\u00020DH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00110)j\b\u0012\u0004\u0012\u00020\u0011`*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006H"}, d2 = {"Lcom/appnew/android/Intro/Fragment/MainCategoryFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "school_cat", "Landroid/widget/RelativeLayout;", "getSchool_cat", "()Landroid/widget/RelativeLayout;", "setSchool_cat", "(Landroid/widget/RelativeLayout;)V", "is_select_main_cat", "", "()Ljava/lang/Boolean;", "set_select_main_cat", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mastercat", "Lcom/appnew/android/Intro/Mastercat;", "getMastercat", "()Lcom/appnew/android/Intro/Mastercat;", "setMastercat", "(Lcom/appnew/android/Intro/Mastercat;)V", "main_cat_recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMain_cat_recyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMain_cat_recyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "itemSelected", "Lcom/appnew/android/Intro/ItemSelected;", "getItemSelected", "()Lcom/appnew/android/Intro/ItemSelected;", "setItemSelected", "(Lcom/appnew/android/Intro/ItemSelected;)V", "chose_txt", "Landroid/widget/TextView;", "getChose_txt", "()Landroid/widget/TextView;", "setChose_txt", "(Landroid/widget/TextView;)V", "mastercatlist", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMastercatlist", "()Ljava/util/ArrayList;", "setMastercatlist", "(Ljava/util/ArrayList;)V", "categoryAdapter", "Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;", "getCategoryAdapter", "()Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;", "setCategoryAdapter", "(Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;)V", "categoryMasterTypeAdapter", "Lcom/appnew/android/Intro/Adaoter/CategoryMasterTypeAdapter;", "getCategoryMasterTypeAdapter", "()Lcom/appnew/android/Intro/Adaoter/CategoryMasterTypeAdapter;", "setCategoryMasterTypeAdapter", "(Lcom/appnew/android/Intro/Adaoter/CategoryMasterTypeAdapter;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "onActivityCreated", "updatePrefs", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainCategoryFragment extends Fragment {
    public static final int $stable = 8;
    private CategoryAdapter categoryAdapter;
    private CategoryMasterTypeAdapter categoryMasterTypeAdapter;
    private TextView chose_txt;
    private ItemSelected itemSelected;
    private RecyclerView main_cat_recyclerview;
    private Mastercat mastercat;
    private RelativeLayout school_cat;
    private Boolean is_select_main_cat = false;
    private ArrayList<Mastercat> mastercatlist = new ArrayList<>();

    public final RelativeLayout getSchool_cat() {
        return this.school_cat;
    }

    public final void setSchool_cat(RelativeLayout relativeLayout) {
        this.school_cat = relativeLayout;
    }

    /* JADX INFO: renamed from: is_select_main_cat, reason: from getter */
    public final Boolean getIs_select_main_cat() {
        return this.is_select_main_cat;
    }

    public final void set_select_main_cat(Boolean bool) {
        this.is_select_main_cat = bool;
    }

    public final Mastercat getMastercat() {
        return this.mastercat;
    }

    public final void setMastercat(Mastercat mastercat) {
        this.mastercat = mastercat;
    }

    public final RecyclerView getMain_cat_recyclerview() {
        return this.main_cat_recyclerview;
    }

    public final void setMain_cat_recyclerview(RecyclerView recyclerView) {
        this.main_cat_recyclerview = recyclerView;
    }

    public final ItemSelected getItemSelected() {
        return this.itemSelected;
    }

    public final void setItemSelected(ItemSelected itemSelected) {
        this.itemSelected = itemSelected;
    }

    public final TextView getChose_txt() {
        return this.chose_txt;
    }

    public final void setChose_txt(TextView textView) {
        this.chose_txt = textView;
    }

    public final ArrayList<Mastercat> getMastercatlist() {
        return this.mastercatlist;
    }

    public final void setMastercatlist(ArrayList<Mastercat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mastercatlist = arrayList;
    }

    public final CategoryAdapter getCategoryAdapter() {
        return this.categoryAdapter;
    }

    public final void setCategoryAdapter(CategoryAdapter categoryAdapter) {
        this.categoryAdapter = categoryAdapter;
    }

    public final CategoryMasterTypeAdapter getCategoryMasterTypeAdapter() {
        return this.categoryMasterTypeAdapter;
    }

    public final void setCategoryMasterTypeAdapter(CategoryMasterTypeAdapter categoryMasterTypeAdapter) {
        this.categoryMasterTypeAdapter = categoryMasterTypeAdapter;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_main_category, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.main_cat_recyclerview = (RecyclerView) view.findViewById(R.id.main_cat_recyclerview);
        this.chose_txt = (TextView) view.findViewById(R.id.chose_txt);
        this.itemSelected = new ItemSelected() { // from class: com.appnew.android.Intro.Fragment.MainCategoryFragment.onViewCreated.1
            @Override // com.appnew.android.Intro.ItemSelected
            public void Selectedsubcat(int item, SubCat sucat, String type) {
                Intrinsics.checkNotNullParameter(sucat, "sucat");
                Intrinsics.checkNotNullParameter(type, "type");
            }

            @Override // com.appnew.android.Intro.ItemSelected
            public void Selecteditem(int item, Mastercat master) {
                Intrinsics.checkNotNullParameter(master, "master");
                MainCategoryFragment.this.set_select_main_cat(true);
                MainCategoryFragment.this.getMastercatlist().get(item).set_select(true);
                MainCategoryFragment.this.setMastercat(master);
                CategoryAdapter categoryAdapter = MainCategoryFragment.this.getCategoryAdapter();
                if (categoryAdapter != null) {
                    categoryAdapter.setRandomnumber(0);
                }
                CategoryAdapter categoryAdapter2 = MainCategoryFragment.this.getCategoryAdapter();
                if (categoryAdapter2 != null) {
                    categoryAdapter2.notifyDataSetChanged();
                }
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        this.mastercatlist = ((IntroActivity) activity).getMastercatlist();
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        if (((IntroActivity) activity2).getMaincatlist().size() > 0) {
            int size = this.mastercatlist.size();
            for (int i = 0; i < size; i++) {
                FragmentActivity activity3 = getActivity();
                Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                int size2 = ((IntroActivity) activity3).getMaincatlist().size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String catid = this.mastercatlist.get(i).getCatid();
                    FragmentActivity activity4 = getActivity();
                    Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                    if (Intrinsics.areEqual(catid, ((IntroActivity) activity4).getMaincatlist().get(i2).getMastertype())) {
                        this.mastercat = new Mastercat(this.mastercatlist.get(i).getCatid(), this.mastercatlist.get(i).getCatname(), true, false, 8, null);
                        this.is_select_main_cat = true;
                        this.mastercatlist.get(i).set_select(true);
                        this.mastercatlist.get(i).set_expand_maincat(true);
                        FragmentActivity activity5 = getActivity();
                        Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                        ((IntroActivity) activity5).setMastercat(this.mastercat);
                    }
                }
            }
        } else {
            Boolean bool = this.is_select_main_cat;
            Intrinsics.checkNotNull(bool);
            if (!bool.booleanValue()) {
                FragmentActivity activity6 = getActivity();
                Intrinsics.checkNotNull(activity6, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                if (!TextUtils.isEmpty(((IntroActivity) activity6).getPrefence())) {
                    FragmentActivity activity7 = getActivity();
                    Intrinsics.checkNotNull(activity7, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                    if (StringsKt.contains$default((CharSequence) ((IntroActivity) activity7).getPrefence(), (CharSequence) "#@", false, 2, (Object) null)) {
                        FragmentActivity activity8 = getActivity();
                        Intrinsics.checkNotNull(activity8, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                        List listSplit$default = StringsKt.split$default((CharSequence) ((IntroActivity) activity8).getPrefence(), new String[]{"#@"}, false, 0, 6, (Object) null);
                        int size3 = this.mastercatlist.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            if (Intrinsics.areEqual(listSplit$default.get(1), this.mastercatlist.get(i3).getCatid())) {
                                this.mastercat = new Mastercat((String) listSplit$default.get(1), (String) listSplit$default.get(0), true, false, 8, null);
                                this.is_select_main_cat = true;
                                this.mastercatlist.get(i3).set_select(true);
                                this.mastercatlist.get(i3).set_expand_maincat(true);
                                FragmentActivity activity9 = getActivity();
                                Intrinsics.checkNotNull(activity9, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                                ((IntroActivity) activity9).setMastercat(this.mastercat);
                            }
                        }
                    }
                }
            }
        }
        if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) == null || !StringsKt.equals(SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE), "1", true)) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            ArrayList<Mastercat> arrayList = this.mastercatlist;
            ItemSelected itemSelected = this.itemSelected;
            Intrinsics.checkNotNull(itemSelected);
            CategoryAdapter categoryAdapter = new CategoryAdapter(fragmentActivityRequireActivity, arrayList, itemSelected);
            this.categoryAdapter = categoryAdapter;
            RecyclerView recyclerView = this.main_cat_recyclerview;
            if (recyclerView != null) {
                recyclerView.setAdapter(categoryAdapter);
                recyclerView.setHasFixedSize(true);
                return;
            }
            return;
        }
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
        CategoryMasterTypeAdapter categoryMasterTypeAdapter = new CategoryMasterTypeAdapter(fragmentActivityRequireActivity2, this.mastercatlist);
        this.categoryMasterTypeAdapter = categoryMasterTypeAdapter;
        RecyclerView recyclerView2 = this.main_cat_recyclerview;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(categoryMasterTypeAdapter);
            recyclerView2.setHasFixedSize(true);
        }
    }

    private final void updatePrefs() {
        int size;
        MasterCatDao mastercatDao;
        GetMasterAllCatDao masterAllCatDao;
        ArrayList<Data.Preferences> preferences = SharedPreference.getInstance().getLoggedInUser().getPreferences();
        if (preferences.size() > 0) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            UtkashRoom utkashRoom = ((IntroActivity) context).getUtkashRoom();
            List<MasterCat> list = null;
            List<MasteAllCatTable> list2 = (utkashRoom == null || (masterAllCatDao = utkashRoom.getMasterAllCatDao()) == null) ? null : masterAllCatDao.getmaster_allcat(MakeMyExam.userId);
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            UtkashRoom utkashRoom2 = ((IntroActivity) context2).getUtkashRoom();
            if (utkashRoom2 != null && (mastercatDao = utkashRoom2.getMastercatDao()) != null) {
                list = mastercatDao.getmastercat(MakeMyExam.userId);
            }
            ArrayList arrayList2 = new ArrayList(list);
            ArrayList arrayList3 = new ArrayList();
            HashSet hashSet2 = new HashSet();
            ArrayList arrayList4 = new ArrayList();
            if (list2 != null) {
                for (MasteAllCatTable masteAllCatTable : list2) {
                    Iterator<Data.Preferences> it = preferences.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        if (StringsKt.equals(masteAllCatTable.getId(), it.next().getSub_cat(), true)) {
                            arrayList.add(masteAllCatTable);
                            String master_type = masteAllCatTable.getMaster_type();
                            Intrinsics.checkNotNullExpressionValue(master_type, "getMaster_type(...)");
                            hashSet.add(master_type);
                        }
                    }
                }
                for (Object obj : arrayList2) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    MasterCat masterCat = (MasterCat) obj;
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        if (StringsKt.equals(masterCat.getId(), (String) it2.next(), true)) {
                            arrayList3.add(masterCat);
                        }
                    }
                }
                for (MasteAllCatTable masteAllCatTable2 : list2) {
                    Iterator it3 = arrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                    while (it3.hasNext()) {
                        Object next = it3.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        MasteAllCatTable masteAllCatTable3 = (MasteAllCatTable) next;
                        if (Intrinsics.areEqual(masteAllCatTable2.getId(), masteAllCatTable3.getParent_id()) && StringsKt.equals(masteAllCatTable2.getParent_id(), "0", true) && StringsKt.equals(masteAllCatTable2.getMaster_type(), masteAllCatTable3.getMaster_type(), true)) {
                            Intrinsics.checkNotNull(masteAllCatTable2);
                            hashSet2.add(masteAllCatTable2);
                        }
                    }
                }
                for (Object obj2 : hashSet2) {
                    Intrinsics.checkNotNullExpressionValue(obj2, "next(...)");
                    MasteAllCatTable masteAllCatTable4 = (MasteAllCatTable) obj2;
                    if (StringsKt.equals(masteAllCatTable4.getParent_id(), "0", true)) {
                        arrayList4.add(masteAllCatTable4);
                    }
                }
                if (arrayList4.size() <= 0 || TextUtils.isEmpty(SharedPreference.getInstance().getString("sub_cat_id")) || (size = arrayList4.size()) < 0) {
                    return;
                }
                for (int i = 0; i != size; i++) {
                }
            }
        }
    }
}
