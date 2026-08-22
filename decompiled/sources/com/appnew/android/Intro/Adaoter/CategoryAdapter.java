package com.appnew.android.Intro.Adaoter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Intro.ItemSelected;
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

/* JADX INFO: compiled from: CategoryAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00016B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010)\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020$H\u0016J\u001c\u0010-\u001a\u00020.2\n\u0010/\u001a\u00060\u0002R\u00020\u00002\u0006\u00100\u001a\u00020$H\u0017J\b\u00101\u001a\u00020$H\u0016J&\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020$2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0006j\b\u0012\u0004\u0012\u00020\u001a`\bJ.\u00105\u001a\u00020.2\u0006\u00103\u001a\u00020$2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0006j\b\u0012\u0004\u0012\u00020\u001a`\b2\u0006\u0010\u001d\u001a\u00020\u001eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0006j\b\u0012\u0004\u0012\u00020\u001a`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00067"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Intro/Adaoter/CategoryAdapter$CategoryAdapterVh;", "context", "Landroid/content/Context;", "mastercatlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/Mastercat;", "Lkotlin/collections/ArrayList;", "itemSelected", "Lcom/appnew/android/Intro/ItemSelected;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/appnew/android/Intro/ItemSelected;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMastercatlist", "()Ljava/util/ArrayList;", "setMastercatlist", "(Ljava/util/ArrayList;)V", "getItemSelected", "()Lcom/appnew/android/Intro/ItemSelected;", "setItemSelected", "(Lcom/appnew/android/Intro/ItemSelected;)V", "list", "Lcom/appnew/android/Intro/SubCat;", "getList", "setList", "pid", "", "getPid", "()Ljava/lang/String;", "setPid", "(Ljava/lang/String;)V", "randomnumber", "", "getRandomnumber", "()I", "setRandomnumber", "(I)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "notifyadd", "catposition", "maincatlist", "notifyremove", "CategoryAdapterVh", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapterVh> {
    public static final int $stable = 8;
    private Context context;
    private ItemSelected itemSelected;
    private ArrayList<SubCat> list;
    private ArrayList<Mastercat> mastercatlist;
    private String pid;
    private int randomnumber;

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

    public final ItemSelected getItemSelected() {
        return this.itemSelected;
    }

    public final void setItemSelected(ItemSelected itemSelected) {
        Intrinsics.checkNotNullParameter(itemSelected, "<set-?>");
        this.itemSelected = itemSelected;
    }

    public CategoryAdapter(Context context, ArrayList<Mastercat> mastercatlist, ItemSelected itemSelected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mastercatlist, "mastercatlist");
        Intrinsics.checkNotNullParameter(itemSelected, "itemSelected");
        this.context = context;
        this.mastercatlist = mastercatlist;
        this.itemSelected = itemSelected;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        this.list = ((IntroActivity) context).getMaincatlist();
        this.pid = "";
    }

    public final ArrayList<SubCat> getList() {
        return this.list;
    }

    public final void setList(ArrayList<SubCat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final String getPid() {
        return this.pid;
    }

    public final void setPid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pid = str;
    }

    public final int getRandomnumber() {
        return this.randomnumber;
    }

    public final void setRandomnumber(int i) {
        this.randomnumber = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CategoryAdapterVh onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_adapter, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new CategoryAdapterVh(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final CategoryAdapterVh holder, final int position) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getCategory_name().setText(this.mastercatlist.get(position).getCatname());
        int i = position % 4;
        if (i == 0 || i == 1) {
            holder.getDropDownIV().setColorFilter(ContextCompat.getColor(this.context, R.color.whie), PorterDuff.Mode.SRC_IN);
            holder.getSchool_cat().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_pink));
            holder.getCategory_name().setTextColor(this.context.getResources().getColor(R.color.whie));
        } else if (i == 2) {
            holder.getDropDownIV().setColorFilter(ContextCompat.getColor(this.context, R.color.whie), PorterDuff.Mode.SRC_IN);
            holder.getSchool_cat().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_yello));
            holder.getCategory_name().setTextColor(this.context.getResources().getColor(R.color.whie));
        } else if (i == 3) {
            holder.getDropDownIV().setColorFilter(ContextCompat.getColor(this.context, R.color.whie), PorterDuff.Mode.SRC_IN);
            holder.getSchool_cat().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_pink));
            holder.getCategory_name().setTextColor(this.context.getResources().getColor(R.color.whie));
        }
        if (this.mastercatlist.get(position).is_expand_maincat()) {
            holder.getLowerViewItem_maincat().setVisibility(0);
            holder.getDropDownIV().setImageResource(R.drawable.up_arrow_black);
        } else {
            holder.getLowerViewItem_maincat().setVisibility(8);
            holder.getDropDownIV().setImageResource(R.drawable.down_arrow_black);
        }
        holder.getDropDownIV().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Adaoter.CategoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryAdapter.onBindViewHolder$lambda$0(this.f$0, position, holder, view);
            }
        });
        holder.getSchool_cat().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Adaoter.CategoryAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryAdapter.onBindViewHolder$lambda$1(this.f$0, position, holder, view);
            }
        });
        ArrayList arrayList = new ArrayList();
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        Iterator<MasteAllCatTable> it = ((IntroActivity) context).getMasterAllCatTables().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            str = "next(...)";
            if (!it.hasNext()) {
                break;
            }
            MasteAllCatTable next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            MasteAllCatTable masteAllCatTable = next;
            if (Intrinsics.areEqual(masteAllCatTable.getMaster_type(), this.mastercatlist.get(position).getCatid()) && StringsKt.equals(masteAllCatTable.getParent_id(), "0", true)) {
                String id = masteAllCatTable.getId();
                Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                String name = masteAllCatTable.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String parent_id = masteAllCatTable.getParent_id();
                Intrinsics.checkNotNullExpressionValue(parent_id, "getParent_id(...)");
                String master_type = masteAllCatTable.getMaster_type();
                Intrinsics.checkNotNullExpressionValue(master_type, "getMaster_type(...)");
                SubCat subCat = new SubCat(id, name, parent_id, master_type, false, false, false, 112, null);
                if (StringsKt.equals(this.pid, masteAllCatTable.getId(), true)) {
                    subCat.set_maincatselct(true);
                }
                arrayList.add(subCat);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Context context2 = this.context;
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
        Iterator<MasteAllCatTable> it2 = ((IntroActivity) context2).getMasterAllCatTables().iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            MasteAllCatTable next2 = it2.next();
            Intrinsics.checkNotNullExpressionValue(next2, str);
            MasteAllCatTable masteAllCatTable2 = next2;
            Iterator it3 = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                ArrayList arrayList3 = arrayList;
                Object next3 = it3.next();
                Intrinsics.checkNotNullExpressionValue(next3, str);
                String str2 = str;
                if (StringsKt.equals(((SubCat) next3).getId(), masteAllCatTable2.getParent_id(), true)) {
                    String id2 = masteAllCatTable2.getId();
                    Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                    String name2 = masteAllCatTable2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    String parent_id2 = masteAllCatTable2.getParent_id();
                    Intrinsics.checkNotNullExpressionValue(parent_id2, "getParent_id(...)");
                    String master_type2 = masteAllCatTable2.getMaster_type();
                    Intrinsics.checkNotNullExpressionValue(master_type2, "getMaster_type(...)");
                    arrayList2.add(new SubCat(id2, name2, parent_id2, master_type2, false, false, false, 112, null));
                }
                arrayList = arrayList3;
                str = str2;
            }
        }
        ArrayList arrayList4 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Context context3 = this.context;
            Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            int size2 = ((IntroActivity) context3).getMaincatlist().size();
            for (int i4 = 0; i4 < size2; i4++) {
                Context context4 = this.context;
                Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                if (Intrinsics.areEqual(((IntroActivity) context4).getMaincatlist().get(i4).getId(), ((SubCat) arrayList2.get(i3)).getId())) {
                    ((SubCat) arrayList2.get(i3)).set_subcatselct(true);
                    i2++;
                }
            }
        }
        if (i2 > 0) {
            holder.getCategory_count().setVisibility(0);
            if (i == 2) {
                holder.getCategory_count().setTextColor(this.context.getResources().getColor(R.color.whie));
            } else {
                holder.getCategory_count().setTextColor(this.context.getResources().getColor(R.color.whie));
            }
            holder.getCategory_count().setText("(" + i2 + ")");
        } else {
            holder.getCategory_count().setVisibility(4);
        }
        holder.getMain_cat_recycler().setLayoutManager(new LinearLayoutManager(this.context, 1, false));
        holder.getMain_cat_recycler().setAdapter(new MainCatAdapter(this.context, arrayList4, this.itemSelected, this, position));
        holder.getMain_cat_recycler().setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(CategoryAdapter categoryAdapter, int i, CategoryAdapterVh categoryAdapterVh, View view) {
        if (categoryAdapter.mastercatlist.get(i).is_expand_maincat()) {
            categoryAdapter.mastercatlist.get(i).set_expand_maincat(false);
            categoryAdapterVh.getLowerViewItem_maincat().setVisibility(8);
            categoryAdapterVh.getDropDownIV().setImageResource(R.mipmap.down_black);
        } else {
            categoryAdapter.mastercatlist.get(i).set_expand_maincat(true);
            categoryAdapterVh.getLowerViewItem_maincat().setVisibility(0);
            categoryAdapterVh.getDropDownIV().setImageResource(R.mipmap.up_black);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(CategoryAdapter categoryAdapter, int i, CategoryAdapterVh categoryAdapterVh, View view) {
        if (categoryAdapter.mastercatlist.get(i).is_expand_maincat()) {
            categoryAdapter.mastercatlist.get(i).set_expand_maincat(false);
            categoryAdapterVh.getLowerViewItem_maincat().setVisibility(8);
            categoryAdapterVh.getDropDownIV().setImageResource(R.mipmap.down_black);
        } else {
            categoryAdapter.mastercatlist.get(i).set_expand_maincat(true);
            categoryAdapterVh.getLowerViewItem_maincat().setVisibility(0);
            categoryAdapterVh.getDropDownIV().setImageResource(R.mipmap.up_black);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mastercatlist.size();
    }

    public final void notifyadd(int catposition, ArrayList<SubCat> maincatlist) {
        Intrinsics.checkNotNullParameter(maincatlist, "maincatlist");
        this.list = maincatlist;
        this.pid = maincatlist.get(maincatlist.size() - 1).getParenid();
        notifyItemChanged(catposition);
    }

    public final void notifyremove(int catposition, ArrayList<SubCat> maincatlist, String pid) {
        Intrinsics.checkNotNullParameter(maincatlist, "maincatlist");
        Intrinsics.checkNotNullParameter(pid, "pid");
        this.list = maincatlist;
        this.pid = pid;
        notifyItemChanged(catposition);
    }

    /* JADX INFO: compiled from: CategoryAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/CategoryAdapter$CategoryAdapterVh;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;Landroid/view/View;)V", "school_cat", "Landroid/widget/RelativeLayout;", "getSchool_cat", "()Landroid/widget/RelativeLayout;", "setSchool_cat", "(Landroid/widget/RelativeLayout;)V", "parentLL", "Landroid/widget/LinearLayout;", "getParentLL", "()Landroid/widget/LinearLayout;", "setParentLL", "(Landroid/widget/LinearLayout;)V", "lowerViewItem_maincat", "getLowerViewItem_maincat", "setLowerViewItem_maincat", "dropDownIV", "Landroid/widget/ImageView;", "getDropDownIV", "()Landroid/widget/ImageView;", "setDropDownIV", "(Landroid/widget/ImageView;)V", "category_name", "Landroid/widget/TextView;", "getCategory_name", "()Landroid/widget/TextView;", "setCategory_name", "(Landroid/widget/TextView;)V", "category_count", "getCategory_count", "setCategory_count", "main_cat_recycler", "Landroidx/recyclerview/widget/RecyclerView;", "getMain_cat_recycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setMain_cat_recycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CategoryAdapterVh extends RecyclerView.ViewHolder {
        private TextView category_count;
        private TextView category_name;
        private ImageView dropDownIV;
        private LinearLayout lowerViewItem_maincat;
        private RecyclerView main_cat_recycler;
        private LinearLayout parentLL;
        private RelativeLayout school_cat;
        final /* synthetic */ CategoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryAdapterVh(CategoryAdapter categoryAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = categoryAdapter;
            this.school_cat = (RelativeLayout) itemView.findViewById(R.id.school_cat);
            this.dropDownIV = (ImageView) itemView.findViewById(R.id.dropDownIV);
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

        public final RecyclerView getMain_cat_recycler() {
            return this.main_cat_recycler;
        }

        public final void setMain_cat_recycler(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.main_cat_recycler = recyclerView;
        }
    }
}
