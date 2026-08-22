package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Theme.Adapter.DashboardTabAdapter;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.CourseTypeMasterTable;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: DashboardRectTileTabAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardRectTileTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/DashboardRectTileTabAdapter$DashboradSquareViewHolder;", "context", "Landroid/content/Context;", "courseTypeMasterTables", "", "Lcom/appnew/android/table/CourseTypeMasterTable;", "dashboardClicked", "Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "DashboradSquareViewHolder", "addDashboardItemClicked", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DashboardRectTileTabAdapter extends RecyclerView.Adapter<DashboradSquareViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private List<? extends CourseTypeMasterTable> courseTypeMasterTables;
    private final DashboardTabAdapter.addDashboardItemClicked dashboardClicked;

    /* JADX INFO: compiled from: DashboardRectTileTabAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardRectTileTabAdapter$addDashboardItemClicked;", "", "onDashboardItemClicked", "", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface addDashboardItemClicked {
        void onDashboardItemClicked(int position);
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public DashboardRectTileTabAdapter(Context context, List<? extends CourseTypeMasterTable> courseTypeMasterTables, DashboardTabAdapter.addDashboardItemClicked dashboardClicked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(courseTypeMasterTables, "courseTypeMasterTables");
        Intrinsics.checkNotNullParameter(dashboardClicked, "dashboardClicked");
        this.context = context;
        this.courseTypeMasterTables = courseTypeMasterTables;
        this.dashboardClicked = dashboardClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DashboradSquareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.single_item_rect_tile_home_tabs, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new DashboradSquareViewHolder(this, viewInflate);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006a  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(com.appnew.android.Theme.Adapter.DashboardRectTileTabAdapter.DashboradSquareViewHolder r8, final int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.List<? extends com.appnew.android.table.CourseTypeMasterTable> r0 = r7.courseTypeMasterTables
            java.lang.Object r0 = r0.get(r9)
            com.appnew.android.table.CourseTypeMasterTable r0 = (com.appnew.android.table.CourseTypeMasterTable) r0
            java.lang.String r1 = r0.getIcon()
            if (r1 == 0) goto L6a
            java.lang.String r1 = r0.getIcon()
            java.lang.String r2 = "getIcon(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L6a
            java.lang.String r1 = r0.getIcon()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r3 = 2
            r4 = 0
            java.lang.String r5 = ".gif"
            r6 = 0
            boolean r1 = kotlin.text.StringsKt.endsWith$default(r1, r5, r6, r3, r4)
            if (r1 == 0) goto L50
            android.widget.ImageView r1 = r8.getTabIV()
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER
            r1.setScaleType(r3)
            android.widget.ImageView r1 = r8.getTabIV()
            android.content.Context r3 = r7.context
            java.lang.String r0 = r0.getIcon()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.appnew.android.Theme.Adapter.ExtensionsKt.loadGIF(r1, r3, r0)
            goto Lbb
        L50:
            android.widget.ImageView r1 = r8.getTabIV()
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_XY
            r1.setScaleType(r3)
            android.widget.ImageView r1 = r8.getTabIV()
            android.content.Context r3 = r7.context
            java.lang.String r0 = r0.getIcon()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.appnew.android.Theme.Adapter.ExtensionsKt.load(r1, r3, r0)
            goto Lbb
        L6a:
            android.widget.ImageView r1 = r8.getTabIV()
            r2 = 2131755136(0x7f100080, float:1.9141143E38)
            r1.setImageResource(r2)
            java.lang.String r1 = r0.getBg_color()
            if (r1 == 0) goto Lbb
            java.lang.String r1 = r0.getBg_color()
            java.lang.String r2 = "getBg_color(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto Lbb
            java.lang.String r1 = r0.getFont_color()
            if (r1 == 0) goto Lbb
            java.lang.String r1 = r0.getFont_color()
            java.lang.String r2 = "getFont_color(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto Lbb
            java.lang.String r1 = r0.getBg_color()
            java.lang.String r0 = r0.getFont_color()
            r2 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r1, r0, r2)
            if (r0 == 0) goto Lbb
            android.widget.ImageView r0 = r8.getTabIV()
            r1 = 2131755254(0x7f1000f6, float:1.9141382E38)
            r0.setImageResource(r1)
        Lbb:
            android.view.View r8 = r8.itemView
            com.appnew.android.Theme.Adapter.DashboardRectTileTabAdapter$$ExternalSyntheticLambda0 r0 = new com.appnew.android.Theme.Adapter.DashboardRectTileTabAdapter$$ExternalSyntheticLambda0
            r0.<init>()
            r8.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.Adapter.DashboardRectTileTabAdapter.onBindViewHolder(com.appnew.android.Theme.Adapter.DashboardRectTileTabAdapter$DashboradSquareViewHolder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(DashboardRectTileTabAdapter dashboardRectTileTabAdapter, int i, View view) {
        DashboardTabAdapter.addDashboardItemClicked adddashboarditemclicked = dashboardRectTileTabAdapter.dashboardClicked;
        String id = dashboardRectTileTabAdapter.courseTypeMasterTables.get(i).getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        adddashboarditemclicked.onDashboardItemClicked(i, id);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseTypeMasterTables.size();
    }

    /* JADX INFO: compiled from: DashboardRectTileTabAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardRectTileTabAdapter$DashboradSquareViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Theme/Adapter/DashboardRectTileTabAdapter;Landroid/view/View;)V", "tabTitle", "Landroid/widget/TextView;", "getTabTitle", "()Landroid/widget/TextView;", "setTabTitle", "(Landroid/widget/TextView;)V", "tabIV", "Landroid/widget/ImageView;", "getTabIV", "()Landroid/widget/ImageView;", "setTabIV", "(Landroid/widget/ImageView;)V", "parentRL", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getParentRL", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setParentRL", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DashboradSquareViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout parentRL;
        private ImageView tabIV;
        private TextView tabTitle;
        final /* synthetic */ DashboardRectTileTabAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DashboradSquareViewHolder(DashboardRectTileTabAdapter dashboardRectTileTabAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dashboardRectTileTabAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tabTitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.tabTitle = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.tabIV);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.tabIV = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.parentRL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.parentRL = (ConstraintLayout) viewFindViewById3;
        }

        public final TextView getTabTitle() {
            return this.tabTitle;
        }

        public final void setTabTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tabTitle = textView;
        }

        public final ImageView getTabIV() {
            return this.tabIV;
        }

        public final void setTabIV(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.tabIV = imageView;
        }

        public final ConstraintLayout getParentRL() {
            return this.parentRL;
        }

        public final void setParentRL(ConstraintLayout constraintLayout) {
            Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
            this.parentRL = constraintLayout;
        }
    }
}
