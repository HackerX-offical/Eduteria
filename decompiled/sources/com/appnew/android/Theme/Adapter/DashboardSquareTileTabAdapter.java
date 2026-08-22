package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Theme.Adapter.DashboardTabAdapter;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.table.CourseTypeMasterTable;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: DashboardSquareTileTabAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001b\u001cB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0014\u0010\u0019\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u0000H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardSquareTileTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/DashboardSquareTileTabAdapter$DashboradSquareViewHolder;", "context", "Landroid/content/Context;", "courseTypeMasterTables", "", "Lcom/appnew/android/table/CourseTypeMasterTable;", "dashboardClicked", "Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "setTabSize", "getItemCount", "DashboradSquareViewHolder", "addDashboardItemClicked", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DashboardSquareTileTabAdapter extends RecyclerView.Adapter<DashboradSquareViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private List<? extends CourseTypeMasterTable> courseTypeMasterTables;
    private final DashboardTabAdapter.addDashboardItemClicked dashboardClicked;

    /* JADX INFO: compiled from: DashboardSquareTileTabAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardSquareTileTabAdapter$addDashboardItemClicked;", "", "onDashboardItemClicked", "", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public DashboardSquareTileTabAdapter(Context context, List<? extends CourseTypeMasterTable> courseTypeMasterTables, DashboardTabAdapter.addDashboardItemClicked dashboardClicked) {
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
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.single_item_square_tile_home_tabs_new, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new DashboradSquareViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DashboradSquareViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CourseTypeMasterTable courseTypeMasterTable = this.courseTypeMasterTables.get(position);
        holder.getTabIV().setImageResource(R.mipmap.ic_launcher);
        if (courseTypeMasterTable.getBg_color() != null) {
            String bg_color = courseTypeMasterTable.getBg_color();
            Intrinsics.checkNotNullExpressionValue(bg_color, "getBg_color(...)");
            if (bg_color.length() > 0 && courseTypeMasterTable.getFont_color() != null) {
                String font_color = courseTypeMasterTable.getFont_color();
                Intrinsics.checkNotNullExpressionValue(font_color, "getFont_color(...)");
                if (font_color.length() > 0) {
                    if (StringsKt.equals(courseTypeMasterTable.getBg_color(), courseTypeMasterTable.getFont_color(), true)) {
                        holder.getTabTitle().setVisibility(8);
                        holder.getTabIV().setImageResource(R.mipmap.square_icon);
                        if (!StringsKt.equals(BuildConfig.FLAVOR, "codesquadz", true)) {
                            setTabSize(holder);
                        }
                    } else {
                        holder.getTabTitle().setVisibility(0);
                        if (!StringsKt.equals(BuildConfig.FLAVOR, "codesquadz", true)) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, MathKt.roundToInt(Helper.convertDpToPixel(120, this.context)));
                            layoutParams.setMargins(android.R.attr.left, 30, android.R.attr.right, 30);
                            holder.getRelativeLayout().setLayoutParams(layoutParams);
                        }
                    }
                }
            }
        }
        holder.getTabTitle().setText(courseTypeMasterTable.getName());
        if (Helper.isTrishulThemeNew()) {
            holder.getTabTitle().setTypeface(ResourcesCompat.getFont(this.context, R.font.inter_bold));
        }
        if (courseTypeMasterTable.getBg_color() != null) {
            String bg_color2 = courseTypeMasterTable.getBg_color();
            Intrinsics.checkNotNullExpressionValue(bg_color2, "getBg_color(...)");
            if (bg_color2.length() > 0) {
                holder.getParentRL().setBackgroundColor(Color.parseColor(courseTypeMasterTable.getBg_color()));
                holder.getParentRL1().setBackgroundColor(Color.parseColor(courseTypeMasterTable.getBg_color()));
            }
        }
        if (courseTypeMasterTable.getIcon() != null) {
            String icon = courseTypeMasterTable.getIcon();
            Intrinsics.checkNotNullExpressionValue(icon, "getIcon(...)");
            if (icon.length() > 0) {
                String icon2 = courseTypeMasterTable.getIcon();
                Intrinsics.checkNotNullExpressionValue(icon2, "getIcon(...)");
                if (StringsKt.endsWith$default(icon2, ".gif", false, 2, (Object) null)) {
                    holder.getTabIV().setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ImageView tabIV = holder.getTabIV();
                    Context context = this.context;
                    String icon3 = courseTypeMasterTable.getIcon();
                    Intrinsics.checkNotNullExpressionValue(icon3, "getIcon(...)");
                    ExtensionsKt.loadGIF(tabIV, context, icon3);
                } else {
                    holder.getTabIV().setScaleType(ImageView.ScaleType.FIT_XY);
                    ImageView tabIV2 = holder.getTabIV();
                    Context context2 = this.context;
                    String icon4 = courseTypeMasterTable.getIcon();
                    Intrinsics.checkNotNullExpressionValue(icon4, "getIcon(...)");
                    ExtensionsKt.load(tabIV2, context2, icon4);
                }
            }
        }
        if (courseTypeMasterTable.getFont_color() != null) {
            String font_color2 = courseTypeMasterTable.getFont_color();
            Intrinsics.checkNotNullExpressionValue(font_color2, "getFont_color(...)");
            if (font_color2.length() > 0) {
                holder.getTabTitle().setTextColor(Color.parseColor(courseTypeMasterTable.getFont_color()));
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.DashboardSquareTileTabAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashboardSquareTileTabAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(DashboardSquareTileTabAdapter dashboardSquareTileTabAdapter, int i, View view) {
        DashboardTabAdapter.addDashboardItemClicked adddashboarditemclicked = dashboardSquareTileTabAdapter.dashboardClicked;
        String id = dashboardSquareTileTabAdapter.courseTypeMasterTables.get(i).getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        adddashboarditemclicked.onDashboardItemClicked(i, id);
    }

    private final void setTabSize(DashboradSquareViewHolder holder) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(android.R.attr.left, 30, android.R.attr.right, 30);
        holder.getRelativeLayout().setLayoutParams(layoutParams);
        holder.getTabIV().setLayoutParams(new RelativeLayout.LayoutParams(-1, MathKt.roundToInt(Helper.convertDpToPixel(120, this.context))));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseTypeMasterTables.size();
    }

    /* JADX INFO: compiled from: DashboardSquareTileTabAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DashboardSquareTileTabAdapter$DashboradSquareViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Theme/Adapter/DashboardSquareTileTabAdapter;Landroid/view/View;)V", "tabTitle", "Landroid/widget/TextView;", "getTabTitle", "()Landroid/widget/TextView;", "setTabTitle", "(Landroid/widget/TextView;)V", "tabIV", "Landroid/widget/ImageView;", "getTabIV", "()Landroid/widget/ImageView;", "setTabIV", "(Landroid/widget/ImageView;)V", "parentRL", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getParentRL", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setParentRL", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "parentRL1", "getParentRL1", "setParentRL1", "relativeLayout", "Landroid/widget/RelativeLayout;", "getRelativeLayout", "()Landroid/widget/RelativeLayout;", "setRelativeLayout", "(Landroid/widget/RelativeLayout;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DashboradSquareViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout parentRL;
        private ConstraintLayout parentRL1;
        private RelativeLayout relativeLayout;
        private ImageView tabIV;
        private TextView tabTitle;
        final /* synthetic */ DashboardSquareTileTabAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DashboradSquareViewHolder(DashboardSquareTileTabAdapter dashboardSquareTileTabAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dashboardSquareTileTabAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tabTitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.tabTitle = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.tabIV);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.tabIV = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.parentRL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.parentRL = (ConstraintLayout) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.parentRL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.parentRL1 = (ConstraintLayout) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.relativeLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.relativeLayout = (RelativeLayout) viewFindViewById5;
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

        public final ConstraintLayout getParentRL1() {
            return this.parentRL1;
        }

        public final void setParentRL1(ConstraintLayout constraintLayout) {
            Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
            this.parentRL1 = constraintLayout;
        }

        public final RelativeLayout getRelativeLayout() {
            return this.relativeLayout;
        }

        public final void setRelativeLayout(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.relativeLayout = relativeLayout;
        }
    }
}
