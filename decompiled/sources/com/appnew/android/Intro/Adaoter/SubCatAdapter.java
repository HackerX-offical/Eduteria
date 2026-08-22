package com.appnew.android.Intro.Adaoter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Intro.Adaoter.SubCatAdapter;
import com.appnew.android.Intro.ItemSelected;
import com.appnew.android.Intro.SubCat;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SubCatAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0001.BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010%\u001a\u00060\u0002R\u00020\u00002\b\b\u0001\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\fH\u0017J\u001e\u0010)\u001a\u00020*2\f\b\u0001\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001d¨\u0006/"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/SubCatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Intro/Adaoter/SubCatAdapter$SubjectItemHolder;", "context", "Landroid/content/Context;", "maincatlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/SubCat;", "Lkotlin/collections/ArrayList;", "itemSelected", "Lcom/appnew/android/Intro/ItemSelected;", "maincatpos", "", "mainCatAdapter", "Lcom/appnew/android/Intro/Adaoter/MainCatAdapter;", "categoryAdapter", "Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;", "catposition", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/appnew/android/Intro/ItemSelected;ILcom/appnew/android/Intro/Adaoter/MainCatAdapter;Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;I)V", "getContext", "()Landroid/content/Context;", "getMaincatlist", "()Ljava/util/ArrayList;", "getItemSelected", "()Lcom/appnew/android/Intro/ItemSelected;", "setItemSelected", "(Lcom/appnew/android/Intro/ItemSelected;)V", "getMaincatpos", "()I", "setMaincatpos", "(I)V", "getMainCatAdapter", "()Lcom/appnew/android/Intro/Adaoter/MainCatAdapter;", "getCategoryAdapter", "()Lcom/appnew/android/Intro/Adaoter/CategoryAdapter;", "getCatposition", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "SubjectItemHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubCatAdapter extends RecyclerView.Adapter<SubjectItemHolder> {
    public static final int $stable = 8;
    private final CategoryAdapter categoryAdapter;
    private final int catposition;
    private final Context context;
    private ItemSelected itemSelected;
    private final MainCatAdapter mainCatAdapter;
    private final ArrayList<SubCat> maincatlist;
    private int maincatpos;

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

    public final int getMaincatpos() {
        return this.maincatpos;
    }

    public final void setMaincatpos(int i) {
        this.maincatpos = i;
    }

    public final MainCatAdapter getMainCatAdapter() {
        return this.mainCatAdapter;
    }

    public final CategoryAdapter getCategoryAdapter() {
        return this.categoryAdapter;
    }

    public final int getCatposition() {
        return this.catposition;
    }

    public SubCatAdapter(Context context, ArrayList<SubCat> maincatlist, ItemSelected itemSelected, int i, MainCatAdapter mainCatAdapter, CategoryAdapter categoryAdapter, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(maincatlist, "maincatlist");
        Intrinsics.checkNotNullParameter(itemSelected, "itemSelected");
        Intrinsics.checkNotNullParameter(mainCatAdapter, "mainCatAdapter");
        Intrinsics.checkNotNullParameter(categoryAdapter, "categoryAdapter");
        this.context = context;
        this.maincatlist = maincatlist;
        this.itemSelected = itemSelected;
        this.maincatpos = i;
        this.mainCatAdapter = mainCatAdapter;
        this.categoryAdapter = categoryAdapter;
        this.catposition = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SubjectItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_cat_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new SubjectItemHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SubjectItemHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setSingleFAQData(this.maincatlist, position);
    }

    /* JADX INFO: compiled from: SubCatAdapter.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/appnew/android/Intro/Adaoter/SubCatAdapter$SubjectItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Intro/Adaoter/SubCatAdapter;Landroid/view/View;)V", "sub_cat_name", "Landroid/widget/TextView;", "count", "selectCB", "Landroid/widget/CheckBox;", ViewHierarchyConstants.VIEW_KEY, "setSingleFAQData", "", "maincatlist", "Ljava/util/ArrayList;", "Lcom/appnew/android/Intro/SubCat;", "Lkotlin/collections/ArrayList;", Constants.INAPP_POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SubjectItemHolder extends RecyclerView.ViewHolder {
        private final TextView count;
        private final CheckBox selectCB;
        private final TextView sub_cat_name;
        final /* synthetic */ SubCatAdapter this$0;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubjectItemHolder(SubCatAdapter subCatAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = subCatAdapter;
            View viewFindViewById = itemView.findViewById(R.id.sub_cat_name);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.sub_cat_name = (TextView) viewFindViewById;
            this.selectCB = (CheckBox) itemView.findViewById(R.id.selectCB);
            this.view = itemView.findViewById(R.id.view1);
            this.count = (TextView) itemView.findViewById(R.id.count);
        }

        public final void setSingleFAQData(final ArrayList<SubCat> maincatlist, final int pos) {
            Intrinsics.checkNotNullParameter(maincatlist, "maincatlist");
            this.sub_cat_name.setText(maincatlist.get(pos).getName());
            this.count.setText((pos + 1) + ". ");
            if (pos == maincatlist.size() - 1) {
                this.view.setVisibility(8);
            } else {
                this.view.setVisibility(0);
            }
            this.selectCB.setChecked(maincatlist.get(pos).is_subcatselct());
            CheckBox checkBox = this.selectCB;
            final SubCatAdapter subCatAdapter = this.this$0;
            checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Adaoter.SubCatAdapter$SubjectItemHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubCatAdapter.SubjectItemHolder.setSingleFAQData$lambda$0(maincatlist, pos, subCatAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void setSingleFAQData$lambda$0(ArrayList arrayList, int i, SubCatAdapter subCatAdapter, View view) {
            String parenid;
            if (((SubCat) arrayList.get(i)).is_subcatselct()) {
                int i2 = 0;
                ((SubCat) arrayList.get(i)).set_subcatselct(false);
                Context context = subCatAdapter.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                int size = ((IntroActivity) context).getMaincatlist().size();
                while (true) {
                    if (i2 >= size) {
                        parenid = "";
                        break;
                    }
                    String id = ((SubCat) arrayList.get(i)).getId();
                    Context context2 = subCatAdapter.getContext();
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                    if (Intrinsics.areEqual(id, ((IntroActivity) context2).getMaincatlist().get(i2).getId())) {
                        Context context3 = subCatAdapter.getContext();
                        Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                        parenid = ((IntroActivity) context3).getMaincatlist().get(i2).getParenid();
                        ((IntroActivity) subCatAdapter.getContext()).getMaincatlist().remove(i2);
                        break;
                    }
                    i2++;
                }
                CategoryAdapter categoryAdapter = subCatAdapter.getCategoryAdapter();
                int catposition = subCatAdapter.getCatposition();
                Context context4 = subCatAdapter.getContext();
                Intrinsics.checkNotNull(context4, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
                categoryAdapter.notifyremove(catposition, ((IntroActivity) context4).getMaincatlist(), parenid);
                return;
            }
            ((SubCat) arrayList.get(i)).set_subcatselct(true);
            Context context5 = subCatAdapter.getContext();
            Intrinsics.checkNotNull(context5, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            ((IntroActivity) context5).getMaincatlist().add(arrayList.get(i));
            CategoryAdapter categoryAdapter2 = subCatAdapter.getCategoryAdapter();
            int catposition2 = subCatAdapter.getCatposition();
            Context context6 = subCatAdapter.getContext();
            Intrinsics.checkNotNull(context6, "null cannot be cast to non-null type com.appnew.android.Intro.Activity.IntroActivity");
            categoryAdapter2.notifyadd(catposition2, ((IntroActivity) context6).getMaincatlist());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.maincatlist.size();
    }
}
