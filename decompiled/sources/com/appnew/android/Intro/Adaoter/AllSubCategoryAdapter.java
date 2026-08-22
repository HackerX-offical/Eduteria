package com.appnew.android.Intro.Adaoter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Intro.SubCat;
import com.appnew.android.Intro.SubCatItemSelected;
import com.appnew.android.Utils.Const;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: AllSubCategoryAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001.B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aH\u0016J\u001c\u0010)\u001a\u00020*2\n\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010,\u001a\u00020\u001aH\u0017J\b\u0010-\u001a\u00020\u001aH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006/"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter$CategoryAdapterVh;", "context", "Landroid/content/Context;", "mastercatlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/SubCat;", "Lkotlin/collections/ArrayList;", "subCatItemSelected", "Lcom/appnew/android/Intro/SubCatItemSelected;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/appnew/android/Intro/SubCatItemSelected;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMastercatlist", "()Ljava/util/ArrayList;", "setMastercatlist", "(Ljava/util/ArrayList;)V", "getSubCatItemSelected", "()Lcom/appnew/android/Intro/SubCatItemSelected;", "setSubCatItemSelected", "(Lcom/appnew/android/Intro/SubCatItemSelected;)V", "randomnumber", "", "getRandomnumber", "()I", "setRandomnumber", "(I)V", "colorchnage", "", "getColorchnage", "()Z", "setColorchnage", "(Z)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "CategoryAdapterVh", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AllSubCategoryAdapter extends RecyclerView.Adapter<CategoryAdapterVh> {
    public static final int $stable = 8;
    private boolean colorchnage;
    private Context context;
    private ArrayList<SubCat> mastercatlist;
    private int randomnumber;
    private SubCatItemSelected subCatItemSelected;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final ArrayList<SubCat> getMastercatlist() {
        return this.mastercatlist;
    }

    public final void setMastercatlist(ArrayList<SubCat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mastercatlist = arrayList;
    }

    public final SubCatItemSelected getSubCatItemSelected() {
        return this.subCatItemSelected;
    }

    public final void setSubCatItemSelected(SubCatItemSelected subCatItemSelected) {
        Intrinsics.checkNotNullParameter(subCatItemSelected, "<set-?>");
        this.subCatItemSelected = subCatItemSelected;
    }

    public AllSubCategoryAdapter(Context context, ArrayList<SubCat> mastercatlist, SubCatItemSelected subCatItemSelected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mastercatlist, "mastercatlist");
        Intrinsics.checkNotNullParameter(subCatItemSelected, "subCatItemSelected");
        this.context = context;
        this.mastercatlist = mastercatlist;
        this.subCatItemSelected = subCatItemSelected;
    }

    public final int getRandomnumber() {
        return this.randomnumber;
    }

    public final void setRandomnumber(int i) {
        this.randomnumber = i;
    }

    public final boolean getColorchnage() {
        return this.colorchnage;
    }

    public final void setColorchnage(boolean z) {
        this.colorchnage = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CategoryAdapterVh onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_adapter, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new CategoryAdapterVh(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CategoryAdapterVh holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getCategory_name().setText(this.mastercatlist.get(position).getName());
        int i = position % 4;
        if (i == 0) {
            holder.getSchool_cat().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_pink));
            holder.getCategory_name().setTextColor(this.context.getResources().getColor(R.color.whie));
        } else if (i == 1) {
            holder.getSchool_cat().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_blue));
            holder.getCategory_name().setTextColor(this.context.getResources().getColor(R.color.whie));
        } else if (i == 2) {
            holder.getSchool_cat().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_yello));
            holder.getCategory_name().setTextColor(this.context.getResources().getColor(R.color.blackApp));
        } else if (i == 3) {
            holder.getSchool_cat().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.round_green));
            holder.getCategory_name().setTextColor(this.context.getResources().getColor(R.color.whie));
        }
        holder.getSchool_cat().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Adaoter.AllSubCategoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllSubCategoryAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(AllSubCategoryAdapter allSubCategoryAdapter, int i, View view) {
        int size = allSubCategoryAdapter.mastercatlist.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (allSubCategoryAdapter.mastercatlist.get(i2).is_selct()) {
                allSubCategoryAdapter.mastercatlist.get(i2).set_selct(false);
            }
        }
        SubCatItemSelected subCatItemSelected = allSubCategoryAdapter.subCatItemSelected;
        SubCat subCat = allSubCategoryAdapter.mastercatlist.get(i);
        Intrinsics.checkNotNullExpressionValue(subCat, "get(...)");
        subCatItemSelected.Selecteditem(i, subCat);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mastercatlist.size();
    }

    /* JADX INFO: compiled from: AllSubCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter$CategoryAdapterVh;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Intro/Adaoter/AllSubCategoryAdapter;Landroid/view/View;)V", "school_cat", "Landroid/widget/RelativeLayout;", "getSchool_cat", "()Landroid/widget/RelativeLayout;", "setSchool_cat", "(Landroid/widget/RelativeLayout;)V", "category_name", "Landroid/widget/TextView;", "getCategory_name", "()Landroid/widget/TextView;", "setCategory_name", "(Landroid/widget/TextView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CategoryAdapterVh extends RecyclerView.ViewHolder {
        private TextView category_name;
        private RelativeLayout school_cat;
        final /* synthetic */ AllSubCategoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryAdapterVh(AllSubCategoryAdapter allSubCategoryAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = allSubCategoryAdapter;
            this.school_cat = (RelativeLayout) itemView.findViewById(R.id.school_cat);
            this.category_name = (TextView) itemView.findViewById(R.id.category_name);
        }

        public final RelativeLayout getSchool_cat() {
            return this.school_cat;
        }

        public final void setSchool_cat(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.school_cat = relativeLayout;
        }

        public final TextView getCategory_name() {
            return this.category_name;
        }

        public final void setCategory_name(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.category_name = textView;
        }
    }
}
