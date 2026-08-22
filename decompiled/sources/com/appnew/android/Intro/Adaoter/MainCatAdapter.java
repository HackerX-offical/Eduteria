package com.appnew.android.Intro.Adaoter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Intro.Adaoter.MainCatAdapter;
import com.appnew.android.Intro.ItemSelected;
import com.appnew.android.Intro.SubCat;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.MasteAllCatTable;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: MainCatAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0001&B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\b\b\u0001\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0017J\u001e\u0010!\u001a\u00020\"2\f\b\u0001\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/MainCatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Intro/Adaoter/MainCatAdapter$SubjectItemHolder;", "context", "Landroid/content/Context;", "maincatlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/SubCat;", "Lkotlin/collections/ArrayList;", "itemSelected", "Lcom/appnew/android/Intro/ItemSelected;", "categoryAdapter", "Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;", "catpos", "", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/appnew/android/Intro/ItemSelected;Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;I)V", "getContext", "()Landroid/content/Context;", "getMaincatlist", "()Ljava/util/ArrayList;", "getItemSelected", "()Lcom/appnew/android/Intro/ItemSelected;", "setItemSelected", "(Lcom/appnew/android/Intro/ItemSelected;)V", "getCategoryAdapter", "()Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;", "getCatpos", "()I", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "SubjectItemHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainCatAdapter extends RecyclerView.Adapter<SubjectItemHolder> {
    public static final int $stable = 8;
    private final CategoryAdapter categoryAdapter;
    private final int catpos;
    private final Context context;
    private ItemSelected itemSelected;
    private final ArrayList<SubCat> maincatlist;

    public final Context getContext() {
        return this.context;
    }

    public final ArrayList<SubCat> getMaincatlist() {
        return this.maincatlist;
    }

    public final ItemSelected getItemSelected() {
        return this.itemSelected;
    }

    public final void setItemSelected(ItemSelected itemSelected) {
        Intrinsics.checkNotNullParameter(itemSelected, "<set-?>");
        this.itemSelected = itemSelected;
    }

    public final CategoryAdapter getCategoryAdapter() {
        return this.categoryAdapter;
    }

    public final int getCatpos() {
        return this.catpos;
    }

    public MainCatAdapter(Context context, ArrayList<SubCat> maincatlist, ItemSelected itemSelected, CategoryAdapter categoryAdapter, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(maincatlist, "maincatlist");
        Intrinsics.checkNotNullParameter(itemSelected, "itemSelected");
        Intrinsics.checkNotNullParameter(categoryAdapter, "categoryAdapter");
        this.context = context;
        this.maincatlist = maincatlist;
        this.itemSelected = itemSelected;
        this.categoryAdapter = categoryAdapter;
        this.catpos = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SubjectItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_cat_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new SubjectItemHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SubjectItemHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setSingleFAQData(this.maincatlist, position);
    }

    /* JADX INFO: compiled from: MainCatAdapter.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/MainCatAdapter$SubjectItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Intro/Adaoter/MainCatAdapter;Landroid/view/View;)V", "category_name", "Landroid/widget/TextView;", "dropDownIV", "Landroid/widget/ImageView;", "parentLL", "Landroid/widget/LinearLayout;", ViewHierarchyConstants.VIEW_KEY, "category_count", "sub_cat_recycler", "Landroidx/recyclerview/widget/RecyclerView;", "setSingleFAQData", "", "maincatlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/SubCat;", "Lkotlin/collections/ArrayList;", Constants.INAPP_POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SubjectItemHolder extends RecyclerView.ViewHolder {
        private final TextView category_count;
        private final TextView category_name;
        private final ImageView dropDownIV;
        private final LinearLayout parentLL;
        private final RecyclerView sub_cat_recycler;
        final /* synthetic */ MainCatAdapter this$0;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubjectItemHolder(MainCatAdapter mainCatAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = mainCatAdapter;
            View viewFindViewById = itemView.findViewById(R.id.category_name);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.category_name = (TextView) viewFindViewById;
            this.sub_cat_recycler = (RecyclerView) itemView.findViewById(R.id.sub_cat_recycler);
            this.category_count = (TextView) itemView.findViewById(R.id.category_count);
            this.dropDownIV = (ImageView) itemView.findViewById(R.id.dropDownIV);
            this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            this.view = itemView.findViewById(R.id.view1);
        }

        public final void setSingleFAQData(final ArrayList<SubCat> maincatlist, final int pos) {
            Intrinsics.checkNotNullParameter(maincatlist, "maincatlist");
            this.category_name.setText(maincatlist.get(pos).getName());
            if (pos == maincatlist.size() - 1) {
                this.view.setVisibility(8);
            } else {
                this.view.setVisibility(0);
            }
            ArrayList arrayList = new ArrayList();
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            Iterator<MasteAllCatTable> it = ((IntroActivity) context).getMasterAllCatTables().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MasteAllCatTable next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MasteAllCatTable masteAllCatTable = next;
                if (StringsKt.equals(maincatlist.get(pos).getId(), masteAllCatTable.getParent_id(), true)) {
                    String id = masteAllCatTable.getId();
                    Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                    String name = masteAllCatTable.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String parent_id = masteAllCatTable.getParent_id();
                    Intrinsics.checkNotNullExpressionValue(parent_id, "getParent_id(...)");
                    String master_type = masteAllCatTable.getMaster_type();
                    Intrinsics.checkNotNullExpressionValue(master_type, "getMaster_type(...)");
                    arrayList.add(new SubCat(id, name, parent_id, master_type, false, false, false, 112, null));
                }
            }
            int size = arrayList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                int size2 = ((IntroActivity) this.this$0.getContext()).getMaincatlist().size();
                for (int i3 = 0; i3 < size2; i3++) {
                    if (Intrinsics.areEqual(((IntroActivity) this.this$0.getContext()).getMaincatlist().get(i3).getId(), ((SubCat) arrayList.get(i2)).getId())) {
                        ((SubCat) arrayList.get(i2)).set_subcatselct(true);
                        i++;
                    }
                }
            }
            if (i > 0) {
                this.category_count.setVisibility(0);
                this.category_count.setText("(" + i + ")");
            } else {
                this.category_count.setVisibility(4);
            }
            this.sub_cat_recycler.setLayoutManager(new LinearLayoutManager(this.this$0.getContext(), 1, false));
            RecyclerView recyclerView = this.sub_cat_recycler;
            Context context2 = this.this$0.getContext();
            ItemSelected itemSelected = this.this$0.getItemSelected();
            MainCatAdapter mainCatAdapter = this.this$0;
            recyclerView.setAdapter(new SubCatAdapter(context2, arrayList, itemSelected, pos, mainCatAdapter, mainCatAdapter.getCategoryAdapter(), this.this$0.getCatpos()));
            this.sub_cat_recycler.setNestedScrollingEnabled(false);
            if (maincatlist.get(pos).is_maincatselct()) {
                this.sub_cat_recycler.setVisibility(0);
                this.dropDownIV.setImageResource(R.mipmap.up_black);
            } else {
                this.sub_cat_recycler.setVisibility(8);
                this.dropDownIV.setImageResource(R.mipmap.down_black);
            }
            this.dropDownIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Adaoter.MainCatAdapter$SubjectItemHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainCatAdapter.SubjectItemHolder.setSingleFAQData$lambda$0(maincatlist, pos, this, view);
                }
            });
            this.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Adaoter.MainCatAdapter$SubjectItemHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainCatAdapter.SubjectItemHolder.setSingleFAQData$lambda$1(maincatlist, pos, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setSingleFAQData$lambda$0(ArrayList arrayList, int i, SubjectItemHolder subjectItemHolder, View view) {
            if (((SubCat) arrayList.get(i)).is_maincatselct()) {
                ((SubCat) arrayList.get(i)).set_maincatselct(false);
                subjectItemHolder.sub_cat_recycler.setVisibility(8);
                subjectItemHolder.dropDownIV.setImageResource(R.mipmap.down_black);
            } else {
                ((SubCat) arrayList.get(i)).set_maincatselct(true);
                subjectItemHolder.sub_cat_recycler.setVisibility(0);
                subjectItemHolder.dropDownIV.setImageResource(R.mipmap.up_black);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setSingleFAQData$lambda$1(ArrayList arrayList, int i, SubjectItemHolder subjectItemHolder, View view) {
            if (((SubCat) arrayList.get(i)).is_maincatselct()) {
                ((SubCat) arrayList.get(i)).set_maincatselct(false);
                subjectItemHolder.sub_cat_recycler.setVisibility(8);
                subjectItemHolder.dropDownIV.setImageResource(R.mipmap.down_black);
            } else {
                ((SubCat) arrayList.get(i)).set_maincatselct(true);
                subjectItemHolder.sub_cat_recycler.setVisibility(0);
                subjectItemHolder.dropDownIV.setImageResource(R.mipmap.up_black);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.maincatlist.size();
    }
}
