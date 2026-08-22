package com.appnew.android.Intro.Adaoter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Intro.Mastercat;
import com.appnew.android.Intro.SubCat;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.MasteAllCatTable;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: CategoryMasterTypeAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0017H\u0017J(\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00172\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0017H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/CategoryMasterTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Intro/Adaoter/CategoryMasterTypeAdapter$CategoryAdapterVh;", "context", "Landroid/content/Context;", "mastercatlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/Mastercat;", "Lkotlin/collections/ArrayList;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMastercatlist", "()Ljava/util/ArrayList;", "setMastercatlist", "(Ljava/util/ArrayList;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "onCheckClick", "adapterPosition", "setData", "isSelect", "", "getItemCount", "CategoryAdapterVh", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CategoryMasterTypeAdapter extends RecyclerView.Adapter<CategoryAdapterVh> {
    public static final int $stable = 8;
    private Context context;
    private ArrayList<Mastercat> mastercatlist;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final ArrayList<Mastercat> getMastercatlist() {
        return this.mastercatlist;
    }

    public final void setMastercatlist(ArrayList<Mastercat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mastercatlist = arrayList;
    }

    public CategoryMasterTypeAdapter(Context context, ArrayList<Mastercat> mastercatlist) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mastercatlist, "mastercatlist");
        this.context = context;
        this.mastercatlist = mastercatlist;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CategoryAdapterVh onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_adapter, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new CategoryAdapterVh(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final CategoryAdapterVh holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getCategory_name().setText(this.mastercatlist.get(position).getCatname());
        holder.getDropDownIV().setVisibility(8);
        holder.getCategory_name().setTextColor(this.context.getResources().getColor(R.color.whie));
        holder.getSchool_cat().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_pink));
        holder.getCheckBox().setVisibility(0);
        if (this.mastercatlist.get(holder.getAdapterPosition()).is_select()) {
            holder.getCheckBox().setImageDrawable(this.context.getDrawable(com.appnew.android.R.drawable.check_on));
        } else {
            holder.getCheckBox().setImageDrawable(this.context.getDrawable(com.appnew.android.R.drawable.check_off));
        }
        holder.getCheckBox().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Adaoter.CategoryMasterTypeAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryMasterTypeAdapter.onBindViewHolder$lambda$0(this.f$0, holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(CategoryMasterTypeAdapter categoryMasterTypeAdapter, CategoryAdapterVh categoryAdapterVh, View view) {
        categoryMasterTypeAdapter.onCheckClick(categoryAdapterVh.getAdapterPosition(), categoryMasterTypeAdapter.mastercatlist);
    }

    private final void onCheckClick(int adapterPosition, ArrayList<Mastercat> mastercatlist) {
        mastercatlist.get(adapterPosition).set_select(!mastercatlist.get(adapterPosition).is_select());
        setData(adapterPosition, mastercatlist.get(adapterPosition).is_select());
        notifyItemChanged(adapterPosition);
    }

    private final void setData(int adapterPosition, boolean isSelect) {
        ArrayList arrayList = new ArrayList();
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        Iterator<MasteAllCatTable> it = ((IntroActivity) context).getMasterAllCatTables().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            MasteAllCatTable next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            MasteAllCatTable masteAllCatTable = next;
            Iterator<Mastercat> it2 = this.mastercatlist.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                Mastercat next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                Mastercat mastercat = next2;
                if (Intrinsics.areEqual(masteAllCatTable.getMaster_type(), mastercat.getCatid()) && StringsKt.equals(masteAllCatTable.getParent_id(), "0", true) && mastercat.is_select()) {
                    arrayList.add(masteAllCatTable);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next3 = it3.next();
            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
            MasteAllCatTable masteAllCatTable2 = (MasteAllCatTable) next3;
            Context context2 = this.context;
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            Iterator<MasteAllCatTable> it4 = ((IntroActivity) context2).getMasterAllCatTables().iterator();
            Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
            while (it4.hasNext()) {
                MasteAllCatTable next4 = it4.next();
                Intrinsics.checkNotNullExpressionValue(next4, "next(...)");
                MasteAllCatTable masteAllCatTable3 = next4;
                if (StringsKt.equals(masteAllCatTable2.getId(), masteAllCatTable3.getParent_id(), true)) {
                    arrayList2.add(masteAllCatTable3);
                }
            }
        }
        Iterator it5 = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it5, "iterator(...)");
        while (it5.hasNext()) {
            Object next5 = it5.next();
            Intrinsics.checkNotNullExpressionValue(next5, "next(...)");
            MasteAllCatTable masteAllCatTable4 = (MasteAllCatTable) next5;
            String id = masteAllCatTable4.getId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            String name = masteAllCatTable4.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String parent_id = masteAllCatTable4.getParent_id();
            Intrinsics.checkNotNullExpressionValue(parent_id, "getParent_id(...)");
            String master_type = masteAllCatTable4.getMaster_type();
            Intrinsics.checkNotNullExpressionValue(master_type, "getMaster_type(...)");
            arrayList3.add(new SubCat(id, name, parent_id, master_type, false, false, false, 112, null));
        }
        Context context3 = this.context;
        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        ((IntroActivity) context3).getMaincatlist().clear();
        Context context4 = this.context;
        Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        ((IntroActivity) context4).getMaincatlist().addAll(arrayList3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mastercatlist.size();
    }

    /* JADX INFO: compiled from: CategoryMasterTypeAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/CategoryMasterTypeAdapter$CategoryAdapterVh;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Intro/Adaoter/CategoryMasterTypeAdapter;Landroid/view/View;)V", "school_cat", "Landroid/widget/RelativeLayout;", "getSchool_cat", "()Landroid/widget/RelativeLayout;", "setSchool_cat", "(Landroid/widget/RelativeLayout;)V", "parentLL", "Landroid/widget/LinearLayout;", "getParentLL", "()Landroid/widget/LinearLayout;", "setParentLL", "(Landroid/widget/LinearLayout;)V", "lowerViewItem_maincat", "getLowerViewItem_maincat", "setLowerViewItem_maincat", "dropDownIV", "Landroid/widget/ImageView;", "getDropDownIV", "()Landroid/widget/ImageView;", "setDropDownIV", "(Landroid/widget/ImageView;)V", "category_name", "Landroid/widget/TextView;", "getCategory_name", "()Landroid/widget/TextView;", "setCategory_name", "(Landroid/widget/TextView;)V", "category_count", "getCategory_count", "setCategory_count", "checkBox", "getCheckBox", "setCheckBox", "main_cat_recycler", "Landroidx/recyclerview/widget/RecyclerView;", "getMain_cat_recycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setMain_cat_recycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CategoryAdapterVh extends RecyclerView.ViewHolder {
        private TextView category_count;
        private TextView category_name;
        private ImageView checkBox;
        private ImageView dropDownIV;
        private LinearLayout lowerViewItem_maincat;
        private RecyclerView main_cat_recycler;
        private LinearLayout parentLL;
        private RelativeLayout school_cat;
        final /* synthetic */ CategoryMasterTypeAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryAdapterVh(CategoryMasterTypeAdapter categoryMasterTypeAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = categoryMasterTypeAdapter;
            this.school_cat = (RelativeLayout) itemView.findViewById(R.id.school_cat);
            this.dropDownIV = (ImageView) itemView.findViewById(R.id.dropDownIV);
            this.checkBox = (ImageView) itemView.findViewById(R.id.checkBox);
            this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            this.main_cat_recycler = (RecyclerView) itemView.findViewById(R.id.main_cat_recycler);
            this.lowerViewItem_maincat = (LinearLayout) itemView.findViewById(R.id.lowerViewItem);
            this.category_name = (TextView) itemView.findViewById(R.id.category_name);
            this.category_count = (TextView) itemView.findViewById(R.id.category_count);
        }

        public final RelativeLayout getSchool_cat() {
            return this.school_cat;
        }

        public final void setSchool_cat(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.school_cat = relativeLayout;
        }

        public final LinearLayout getParentLL() {
            return this.parentLL;
        }

        public final void setParentLL(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.parentLL = linearLayout;
        }

        public final LinearLayout getLowerViewItem_maincat() {
            return this.lowerViewItem_maincat;
        }

        public final void setLowerViewItem_maincat(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.lowerViewItem_maincat = linearLayout;
        }

        public final ImageView getDropDownIV() {
            return this.dropDownIV;
        }

        public final void setDropDownIV(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.dropDownIV = imageView;
        }

        public final TextView getCategory_name() {
            return this.category_name;
        }

        public final void setCategory_name(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.category_name = textView;
        }

        public final TextView getCategory_count() {
            return this.category_count;
        }

        public final void setCategory_count(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.category_count = textView;
        }

        public final ImageView getCheckBox() {
            return this.checkBox;
        }

        public final void setCheckBox(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.checkBox = imageView;
        }

        public final RecyclerView getMain_cat_recycler() {
            return this.main_cat_recycler;
        }

        public final void setMain_cat_recycler(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.main_cat_recycler = recyclerView;
        }
    }
}
