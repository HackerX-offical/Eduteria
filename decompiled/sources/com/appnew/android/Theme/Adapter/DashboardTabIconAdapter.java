package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.CourseTypeMasterTable;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: DashboardTabIconAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardTabIconAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/DashboardTabIconAdapter$DashboardTabViewHolder;", "context", "Landroid/content/Context;", "free_mock", "", "courseTypeMasterTables", "", "Lcom/appnew/android/table/CourseTypeMasterTable;", "dashboardClicked", "Lcom/appnew/android/Theme/Adapter/DashboardTabIconAdapter$addDashboardItemClicked;", "<init>", "(Landroid/content/Context;ZLjava/util/List;Lcom/appnew/android/Theme/Adapter/DashboardTabIconAdapter$addDashboardItemClicked;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getFree_mock", "()Z", "setFree_mock", "(Z)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "DashboardTabViewHolder", "addDashboardItemClicked", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DashboardTabIconAdapter extends RecyclerView.Adapter<DashboardTabViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private List<? extends CourseTypeMasterTable> courseTypeMasterTables;
    private final addDashboardItemClicked dashboardClicked;
    private boolean free_mock;

    /* JADX INFO: compiled from: DashboardTabIconAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardTabIconAdapter$addDashboardItemClicked;", "", "onDashboardItemClicked", "", "courseTypeMasterTable", "Lcom/appnew/android/table/CourseTypeMasterTable;", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface addDashboardItemClicked {
        void onDashboardItemClicked(CourseTypeMasterTable courseTypeMasterTable, int position);
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final boolean getFree_mock() {
        return this.free_mock;
    }

    public final void setFree_mock(boolean z) {
        this.free_mock = z;
    }

    public DashboardTabIconAdapter(Context context, boolean z, List<? extends CourseTypeMasterTable> courseTypeMasterTables, addDashboardItemClicked dashboardClicked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(courseTypeMasterTables, "courseTypeMasterTables");
        Intrinsics.checkNotNullParameter(dashboardClicked, "dashboardClicked");
        this.context = context;
        this.free_mock = z;
        this.courseTypeMasterTables = courseTypeMasterTables;
        this.dashboardClicked = dashboardClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DashboardTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.single_item_home_tabs_icon, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new DashboardTabViewHolder(this, viewInflate);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(com.appnew.android.Theme.Adapter.DashboardTabIconAdapter.DashboardTabViewHolder r6, final int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.List<? extends com.appnew.android.table.CourseTypeMasterTable> r0 = r5.courseTypeMasterTables
            java.lang.Object r0 = r0.get(r7)
            com.appnew.android.table.CourseTypeMasterTable r0 = (com.appnew.android.table.CourseTypeMasterTable) r0
            java.lang.String r1 = r0.getIcon()
            if (r1 == 0) goto L35
            java.lang.String r1 = r0.getIcon()
            java.lang.String r2 = "getIcon(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L35
            android.widget.ImageView r1 = r6.getTabIV()
            android.content.Context r3 = r5.context
            java.lang.String r4 = r0.getIcon()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            com.appnew.android.Theme.Adapter.ExtensionsKt.load(r1, r3, r4)
            goto L3f
        L35:
            android.widget.ImageView r1 = r6.getTabIV()
            r2 = 2131755220(0x7f1000d4, float:1.9141313E38)
            r1.setImageResource(r2)
        L3f:
            android.view.View r6 = r6.itemView
            com.appnew.android.Theme.Adapter.DashboardTabIconAdapter$$ExternalSyntheticLambda0 r1 = new com.appnew.android.Theme.Adapter.DashboardTabIconAdapter$$ExternalSyntheticLambda0
            r1.<init>()
            r6.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.Adapter.DashboardTabIconAdapter.onBindViewHolder(com.appnew.android.Theme.Adapter.DashboardTabIconAdapter$DashboardTabViewHolder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(DashboardTabIconAdapter dashboardTabIconAdapter, CourseTypeMasterTable courseTypeMasterTable, int i, View view) {
        dashboardTabIconAdapter.dashboardClicked.onDashboardItemClicked(courseTypeMasterTable, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseTypeMasterTables.size();
    }

    /* JADX INFO: compiled from: DashboardTabIconAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardTabIconAdapter$DashboardTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Theme/Adapter/DashboardTabIconAdapter;Landroid/view/View;)V", "tabIV", "Landroid/widget/ImageView;", "getTabIV", "()Landroid/widget/ImageView;", "setTabIV", "(Landroid/widget/ImageView;)V", "parentRL", "Landroid/widget/RelativeLayout;", "getParentRL", "()Landroid/widget/RelativeLayout;", "setParentRL", "(Landroid/widget/RelativeLayout;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DashboardTabViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout parentRL;
        private ImageView tabIV;
        final /* synthetic */ DashboardTabIconAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DashboardTabViewHolder(DashboardTabIconAdapter dashboardTabIconAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dashboardTabIconAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tabIV);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.tabIV = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.parentRL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.parentRL = (RelativeLayout) viewFindViewById2;
        }

        public final ImageView getTabIV() {
            return this.tabIV;
        }

        public final void setTabIV(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.tabIV = imageView;
        }

        public final RelativeLayout getParentRL() {
            return this.parentRL;
        }

        public final void setParentRL(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.parentRL = relativeLayout;
        }
    }
}
