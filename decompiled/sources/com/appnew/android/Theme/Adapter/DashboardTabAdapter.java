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
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.table.CourseTypeMasterTable;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: DashboardTabAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$DashboardTabViewHolder;", "context", "Landroid/content/Context;", "courseTypeMasterTables", "", "Lcom/appnew/android/table/CourseTypeMasterTable;", "dashboardClicked", "Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;", "courseViewType", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getCourseViewType", "()Ljava/lang/String;", "setCourseViewType", "(Ljava/lang/String;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "DashboardTabViewHolder", "addDashboardItemClicked", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DashboardTabAdapter extends RecyclerView.Adapter<DashboardTabViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private List<? extends CourseTypeMasterTable> courseTypeMasterTables;
    private String courseViewType;
    private final addDashboardItemClicked dashboardClicked;

    /* JADX INFO: compiled from: DashboardTabAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;", "", "onDashboardItemClicked", "", Const.POSITION, "", "courseId", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface addDashboardItemClicked {
        void onDashboardItemClicked(int position, String courseId);
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final String getCourseViewType() {
        return this.courseViewType;
    }

    public final void setCourseViewType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.courseViewType = str;
    }

    public DashboardTabAdapter(Context context, List<? extends CourseTypeMasterTable> courseTypeMasterTables, addDashboardItemClicked dashboardClicked, String courseViewType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(courseTypeMasterTables, "courseTypeMasterTables");
        Intrinsics.checkNotNullParameter(dashboardClicked, "dashboardClicked");
        Intrinsics.checkNotNullParameter(courseViewType, "courseViewType");
        this.context = context;
        this.courseTypeMasterTables = courseTypeMasterTables;
        this.dashboardClicked = dashboardClicked;
        this.courseViewType = courseViewType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DashboardTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (StringsKt.equals(this.courseViewType, "1", true)) {
            View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.single_item_home_tabs, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new DashboardTabViewHolder(this, viewInflate);
        }
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.HORIZONTAL_COURSE), "1", true)) {
            View viewInflate2 = LayoutInflater.from(this.context).inflate(R.layout.single_item_home_new, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
            return new DashboardTabViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(this.context).inflate(R.layout.single_item_home_tabs, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "inflate(...)");
        return new DashboardTabViewHolder(this, viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DashboardTabViewHolder holder, final int position) {
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
                String icon2 = courseTypeMasterTable.getIcon();
                Intrinsics.checkNotNullExpressionValue(icon2, "getIcon(...)");
                if (StringsKt.endsWith$default(icon2, ".gif", false, 2, (Object) null)) {
                    ImageView tabIV = holder.getTabIV();
                    Context context = this.context;
                    String icon3 = courseTypeMasterTable.getIcon();
                    Intrinsics.checkNotNullExpressionValue(icon3, "getIcon(...)");
                    ExtensionsKt.loadGIF(tabIV, context, icon3);
                } else {
                    ImageView tabIV2 = holder.getTabIV();
                    Context context2 = this.context;
                    String icon4 = courseTypeMasterTable.getIcon();
                    Intrinsics.checkNotNullExpressionValue(icon4, "getIcon(...)");
                    ExtensionsKt.load(tabIV2, context2, icon4);
                }
            }
        }
        if (courseTypeMasterTable.getFont_color() != null) {
            String font_color = courseTypeMasterTable.getFont_color();
            Intrinsics.checkNotNullExpressionValue(font_color, "getFont_color(...)");
            if (font_color.length() > 0) {
                holder.getTabTitle().setTextColor(Color.parseColor(courseTypeMasterTable.getFont_color()));
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.DashboardTabAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardTabAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(DashboardTabAdapter dashboardTabAdapter, int i, View view) {
        addDashboardItemClicked adddashboarditemclicked = dashboardTabAdapter.dashboardClicked;
        String id = dashboardTabAdapter.courseTypeMasterTables.get(i).getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        adddashboarditemclicked.onDashboardItemClicked(i, id);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseTypeMasterTables.size();
    }

    /* JADX INFO: compiled from: DashboardTabAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$DashboardTabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter;Landroid/view/View;)V", "tabTitle", "Landroid/widget/TextView;", "getTabTitle", "()Landroid/widget/TextView;", "setTabTitle", "(Landroid/widget/TextView;)V", "tabIV", "Landroid/widget/ImageView;", "getTabIV", "()Landroid/widget/ImageView;", "setTabIV", "(Landroid/widget/ImageView;)V", "parentRL", "Landroid/widget/RelativeLayout;", "getParentRL", "()Landroid/widget/RelativeLayout;", "setParentRL", "(Landroid/widget/RelativeLayout;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DashboardTabViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout parentRL;
        private ImageView tabIV;
        private TextView tabTitle;
        final /* synthetic */ DashboardTabAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DashboardTabViewHolder(DashboardTabAdapter dashboardTabAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dashboardTabAdapter;
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
