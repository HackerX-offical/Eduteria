package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.CourseTypeMasterTable;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SquareTileAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/appnew/android/Theme/Adapter/SquareTileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/SquareTileAdapter$SquareTileViewHolder;", "context", "Landroid/content/Context;", "courseTypeMasterTables", "", "Lcom/appnew/android/table/CourseTypeMasterTable;", "dashboardClicked", "Lcom/appnew/android/Theme/Adapter/SquareTileAdapter$addDashboardItemClicked;", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/appnew/android/Theme/Adapter/SquareTileAdapter$addDashboardItemClicked;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "SquareTileViewHolder", "addDashboardItemClicked", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SquareTileAdapter extends RecyclerView.Adapter<SquareTileViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private List<? extends CourseTypeMasterTable> courseTypeMasterTables;
    private final addDashboardItemClicked dashboardClicked;

    /* JADX INFO: compiled from: SquareTileAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/Theme/Adapter/SquareTileAdapter$addDashboardItemClicked;", "", "onDashboardItemClicked", "", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public SquareTileAdapter(Context context, List<? extends CourseTypeMasterTable> courseTypeMasterTables, addDashboardItemClicked dashboardClicked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(courseTypeMasterTables, "courseTypeMasterTables");
        Intrinsics.checkNotNullParameter(dashboardClicked, "dashboardClicked");
        this.context = context;
        this.courseTypeMasterTables = courseTypeMasterTables;
        this.dashboardClicked = dashboardClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SquareTileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.single_item_square_tile_home_tabs, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new SquareTileViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SquareTileViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CourseTypeMasterTable courseTypeMasterTable = this.courseTypeMasterTables.get(position);
        holder.getTabTitle().setText(courseTypeMasterTable.getName());
        holder.getTabIV().setImageResource(R.mipmap.ic_launcher);
        if (courseTypeMasterTable.getBg_color() != null) {
            String bg_color = courseTypeMasterTable.getBg_color();
            Intrinsics.checkNotNullExpressionValue(bg_color, "getBg_color(...)");
            if (bg_color.length() > 0) {
                holder.getParentRL().setBackgroundColor(Color.parseColor(courseTypeMasterTable.getBg_color()));
            }
        }
        if (courseTypeMasterTable.getIcon() != null) {
            String icon = courseTypeMasterTable.getIcon();
            Intrinsics.checkNotNullExpressionValue(icon, "getIcon(...)");
            if (icon.length() > 0) {
                ImageView tabIV = holder.getTabIV();
                Context context = this.context;
                String icon2 = courseTypeMasterTable.getIcon();
                Intrinsics.checkNotNullExpressionValue(icon2, "getIcon(...)");
                ExtensionsKt.load(tabIV, context, icon2);
            }
        }
        if (courseTypeMasterTable.getFont_color() != null) {
            String font_color = courseTypeMasterTable.getFont_color();
            Intrinsics.checkNotNullExpressionValue(font_color, "getFont_color(...)");
            if (font_color.length() > 0) {
                holder.getTabTitle().setTextColor(Color.parseColor(courseTypeMasterTable.getFont_color()));
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.SquareTileAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareTileAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(SquareTileAdapter squareTileAdapter, int i, View view) {
        squareTileAdapter.dashboardClicked.onDashboardItemClicked(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseTypeMasterTables.size();
    }

    /* JADX INFO: compiled from: SquareTileAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/appnew/android/Theme/Adapter/SquareTileAdapter$SquareTileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Theme/Adapter/SquareTileAdapter;Landroid/view/View;)V", "tabTitle", "Landroid/widget/TextView;", "getTabTitle", "()Landroid/widget/TextView;", "setTabTitle", "(Landroid/widget/TextView;)V", "tabIV", "Landroid/widget/ImageView;", "getTabIV", "()Landroid/widget/ImageView;", "setTabIV", "(Landroid/widget/ImageView;)V", "parentRL", "Landroid/widget/RelativeLayout;", "getParentRL", "()Landroid/widget/RelativeLayout;", "setParentRL", "(Landroid/widget/RelativeLayout;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SquareTileViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout parentRL;
        private ImageView tabIV;
        private TextView tabTitle;
        final /* synthetic */ SquareTileAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SquareTileViewHolder(SquareTileAdapter squareTileAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = squareTileAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tabTitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.tabTitle = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.tabIV);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.tabIV = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.parentRL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.parentRL = (RelativeLayout) viewFindViewById3;
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

        public final RelativeLayout getParentRL() {
            return this.parentRL;
        }

        public final void setParentRL(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.parentRL = relativeLayout;
        }
    }
}
