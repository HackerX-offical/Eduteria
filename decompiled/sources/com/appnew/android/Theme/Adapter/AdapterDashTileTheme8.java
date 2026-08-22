package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.CourseTypeMasterTable;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: AdapterDashTileTheme8.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/appnew/android/Theme/Adapter/AdapterDashTileTheme8;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/AdapterDashTileTheme8$DashboardTabViewHolder;", "context", "Landroid/content/Context;", "courseTypeMasterTables", "", "Lcom/appnew/android/table/CourseTypeMasterTable;", "dashboardClicked", "Lcom/appnew/android/Theme/Adapter/AdapterDashTileTheme8$addDashboardItemClicked;", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/appnew/android/Theme/Adapter/AdapterDashTileTheme8$addDashboardItemClicked;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "DashboardTabViewHolder", "addDashboardItemClicked", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdapterDashTileTheme8 extends RecyclerView.Adapter<DashboardTabViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private List<? extends CourseTypeMasterTable> courseTypeMasterTables;
    private final addDashboardItemClicked dashboardClicked;

    /* JADX INFO: compiled from: AdapterDashTileTheme8.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/appnew/android/Theme/Adapter/AdapterDashTileTheme8$addDashboardItemClicked;", "", "onDashboardItemClicked", "", "courseTypeMasterTable", "Lcom/appnew/android/table/CourseTypeMasterTable;", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public AdapterDashTileTheme8(Context context, List<? extends CourseTypeMasterTable> courseTypeMasterTables, addDashboardItemClicked dashboardClicked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(courseTypeMasterTables, "courseTypeMasterTables");
        Intrinsics.checkNotNullParameter(dashboardClicked, "dashboardClicked");
        this.context = context;
        this.courseTypeMasterTables = courseTypeMasterTables;
        this.dashboardClicked = dashboardClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DashboardTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.item_tile_dash_theme8, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new DashboardTabViewHolder(this, viewInflate);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(com.appnew.android.Theme.Adapter.AdapterDashTileTheme8.DashboardTabViewHolder r6, final int r7) {
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
            java.lang.String r1 = r0.getName()
            if (r1 == 0) goto L63
            java.lang.String r1 = r0.getName()
            java.lang.String r2 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L63
            android.widget.TextView r1 = r6.getTitle()
            java.lang.String r2 = r0.getName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L63:
            android.view.View r6 = r6.itemView
            com.appnew.android.Theme.Adapter.AdapterDashTileTheme8$$ExternalSyntheticLambda0 r1 = new com.appnew.android.Theme.Adapter.AdapterDashTileTheme8$$ExternalSyntheticLambda0
            r1.<init>()
            r6.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.Adapter.AdapterDashTileTheme8.onBindViewHolder(com.appnew.android.Theme.Adapter.AdapterDashTileTheme8$DashboardTabViewHolder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(AdapterDashTileTheme8 adapterDashTileTheme8, CourseTypeMasterTable courseTypeMasterTable, int i, View view) {
        adapterDashTileTheme8.dashboardClicked.onDashboardItemClicked(courseTypeMasterTable, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseTypeMasterTables.size();
    }

    /* JADX INFO: compiled from: AdapterDashTileTheme8.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/appnew/android/Theme/Adapter/AdapterDashTileTheme8$DashboardTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Theme/Adapter/AdapterDashTileTheme8;Landroid/view/View;)V", "tabIV", "Landroid/widget/ImageView;", "getTabIV", "()Landroid/widget/ImageView;", "setTabIV", "(Landroid/widget/ImageView;)V", "parentRL", "Landroid/widget/LinearLayout;", "getParentRL", "()Landroid/widget/LinearLayout;", "setParentRL", "(Landroid/widget/LinearLayout;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DashboardTabViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout parentRL;
        private ImageView tabIV;
        final /* synthetic */ AdapterDashTileTheme8 this$0;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DashboardTabViewHolder(AdapterDashTileTheme8 adapterDashTileTheme8, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = adapterDashTileTheme8;
            View viewFindViewById = itemView.findViewById(R.id.tabIV);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.tabIV = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.parentRL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.parentRL = (LinearLayout) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.title = (TextView) viewFindViewById3;
        }

        public final ImageView getTabIV() {
            return this.tabIV;
        }

        public final void setTabIV(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.tabIV = imageView;
        }

        public final LinearLayout getParentRL() {
            return this.parentRL;
        }

        public final void setParentRL(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.parentRL = linearLayout;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final void setTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.title = textView;
        }
    }
}
