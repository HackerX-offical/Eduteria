package com.appnew.android.home.adapters;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Theme.Adapter.DashboardTabAdapter;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.SingleItemHomeNewBinding;
import com.appnew.android.databinding.SingleItemSquareTileHomeTabsBinding;
import com.appnew.android.table.MasteAllCatTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: CourseTypeSmallTileAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004-./0B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J@\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0002J0\u0010)\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0013H\u0002J \u0010,\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/appnew/android/home/adapters/CourseTypeSmallTileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "masterAllCatTables", "", "Lcom/appnew/android/table/MasteAllCatTable;", "dashboardClicked", "Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;", "isGridLayout", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/appnew/android/Theme/Adapter/DashboardTabAdapter$addDashboardItemClicked;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemViewType", "", Const.POSITION, "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "manageUI", "tabIV", "Landroid/widget/ImageView;", "masterCat", "tabTitle", "Landroid/widget/TextView;", "itemView", "Landroid/view/View;", "", "parentRL", "Landroid/widget/RelativeLayout;", "setDefaultUI", "setGridLayout", "dpToPx", "dp", "makeDynamicUIChangesForGridLayout", "Companion", "CourseTypeSmallTileViewHolder", "GridLayoutViewHolder", "addDashboardItemClicked", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CourseTypeSmallTileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_GRID_LAYOUT = 2;
    private Context context;
    private final DashboardTabAdapter.addDashboardItemClicked dashboardClicked;
    private final String isGridLayout;
    private List<? extends MasteAllCatTable> masterAllCatTables;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CourseTypeSmallTileAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/home/adapters/CourseTypeSmallTileAdapter$addDashboardItemClicked;", "", "onDashboardItemClicked", "", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public CourseTypeSmallTileAdapter(Context context, List<? extends MasteAllCatTable> masterAllCatTables, DashboardTabAdapter.addDashboardItemClicked dashboardClicked, String isGridLayout) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(masterAllCatTables, "masterAllCatTables");
        Intrinsics.checkNotNullParameter(dashboardClicked, "dashboardClicked");
        Intrinsics.checkNotNullParameter(isGridLayout, "isGridLayout");
        this.context = context;
        this.masterAllCatTables = masterAllCatTables;
        this.dashboardClicked = dashboardClicked;
        this.isGridLayout = isGridLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return Integer.parseInt(this.isGridLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            SingleItemHomeNewBinding singleItemHomeNewBindingInflate = SingleItemHomeNewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(singleItemHomeNewBindingInflate, "inflate(...)");
            return new GridLayoutViewHolder(singleItemHomeNewBindingInflate);
        }
        SingleItemSquareTileHomeTabsBinding singleItemSquareTileHomeTabsBindingInflate = SingleItemSquareTileHomeTabsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(singleItemSquareTileHomeTabsBindingInflate, "inflate(...)");
        return new CourseTypeSmallTileViewHolder(singleItemSquareTileHomeTabsBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MasteAllCatTable masteAllCatTable = this.masterAllCatTables.get(position);
        if (holder instanceof CourseTypeSmallTileViewHolder) {
            CourseTypeSmallTileViewHolder courseTypeSmallTileViewHolder = (CourseTypeSmallTileViewHolder) holder;
            ImageView tabIV = courseTypeSmallTileViewHolder.getSingleItemSquareTileHomeTabsBinding().tabIV;
            Intrinsics.checkNotNullExpressionValue(tabIV, "tabIV");
            TextView tabTitle = courseTypeSmallTileViewHolder.getSingleItemSquareTileHomeTabsBinding().tabTitle;
            Intrinsics.checkNotNullExpressionValue(tabTitle, "tabTitle");
            View itemView = courseTypeSmallTileViewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            RelativeLayout parentRL = courseTypeSmallTileViewHolder.getSingleItemSquareTileHomeTabsBinding().parentRL;
            Intrinsics.checkNotNullExpressionValue(parentRL, "parentRL");
            manageUI(tabIV, masteAllCatTable, tabTitle, itemView, position, false, parentRL);
            return;
        }
        if (holder instanceof GridLayoutViewHolder) {
            GridLayoutViewHolder gridLayoutViewHolder = (GridLayoutViewHolder) holder;
            ImageView tabIV2 = gridLayoutViewHolder.getSingleItemSquareTileHomeTabsBinding().tabIV;
            Intrinsics.checkNotNullExpressionValue(tabIV2, "tabIV");
            TextView tabTitle2 = gridLayoutViewHolder.getSingleItemSquareTileHomeTabsBinding().tabTitle;
            Intrinsics.checkNotNullExpressionValue(tabTitle2, "tabTitle");
            View itemView2 = gridLayoutViewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            RelativeLayout parentRL2 = gridLayoutViewHolder.getSingleItemSquareTileHomeTabsBinding().parentRL;
            Intrinsics.checkNotNullExpressionValue(parentRL2, "parentRL");
            manageUI(tabIV2, masteAllCatTable, tabTitle2, itemView2, position, true, parentRL2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.masterAllCatTables.size();
    }

    /* JADX INFO: compiled from: CourseTypeSmallTileAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/appnew/android/home/adapters/CourseTypeSmallTileAdapter$CourseTypeSmallTileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "singleItemSquareTileHomeTabsBinding", "Lcom/appnew/android/databinding/SingleItemSquareTileHomeTabsBinding;", "<init>", "(Lcom/appnew/android/databinding/SingleItemSquareTileHomeTabsBinding;)V", "getSingleItemSquareTileHomeTabsBinding", "()Lcom/appnew/android/databinding/SingleItemSquareTileHomeTabsBinding;", "setSingleItemSquareTileHomeTabsBinding", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CourseTypeSmallTileViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private SingleItemSquareTileHomeTabsBinding singleItemSquareTileHomeTabsBinding;

        public final SingleItemSquareTileHomeTabsBinding getSingleItemSquareTileHomeTabsBinding() {
            return this.singleItemSquareTileHomeTabsBinding;
        }

        public final void setSingleItemSquareTileHomeTabsBinding(SingleItemSquareTileHomeTabsBinding singleItemSquareTileHomeTabsBinding) {
            Intrinsics.checkNotNullParameter(singleItemSquareTileHomeTabsBinding, "<set-?>");
            this.singleItemSquareTileHomeTabsBinding = singleItemSquareTileHomeTabsBinding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CourseTypeSmallTileViewHolder(SingleItemSquareTileHomeTabsBinding singleItemSquareTileHomeTabsBinding) {
            super(singleItemSquareTileHomeTabsBinding.getRoot());
            Intrinsics.checkNotNullParameter(singleItemSquareTileHomeTabsBinding, "singleItemSquareTileHomeTabsBinding");
            this.singleItemSquareTileHomeTabsBinding = singleItemSquareTileHomeTabsBinding;
        }
    }

    /* JADX INFO: compiled from: CourseTypeSmallTileAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/appnew/android/home/adapters/CourseTypeSmallTileAdapter$GridLayoutViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "singleItemSquareTileHomeTabsBinding", "Lcom/appnew/android/databinding/SingleItemHomeNewBinding;", "<init>", "(Lcom/appnew/android/databinding/SingleItemHomeNewBinding;)V", "getSingleItemSquareTileHomeTabsBinding", "()Lcom/appnew/android/databinding/SingleItemHomeNewBinding;", "setSingleItemSquareTileHomeTabsBinding", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GridLayoutViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private SingleItemHomeNewBinding singleItemSquareTileHomeTabsBinding;

        public final SingleItemHomeNewBinding getSingleItemSquareTileHomeTabsBinding() {
            return this.singleItemSquareTileHomeTabsBinding;
        }

        public final void setSingleItemSquareTileHomeTabsBinding(SingleItemHomeNewBinding singleItemHomeNewBinding) {
            Intrinsics.checkNotNullParameter(singleItemHomeNewBinding, "<set-?>");
            this.singleItemSquareTileHomeTabsBinding = singleItemHomeNewBinding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GridLayoutViewHolder(SingleItemHomeNewBinding singleItemSquareTileHomeTabsBinding) {
            super(singleItemSquareTileHomeTabsBinding.getRoot());
            Intrinsics.checkNotNullParameter(singleItemSquareTileHomeTabsBinding, "singleItemSquareTileHomeTabsBinding");
            this.singleItemSquareTileHomeTabsBinding = singleItemSquareTileHomeTabsBinding;
        }
    }

    private final void manageUI(ImageView tabIV, MasteAllCatTable masterCat, TextView tabTitle, View itemView, final int position, boolean isGridLayout, RelativeLayout parentRL) {
        final MasteAllCatTable masteAllCatTable;
        TextView textView;
        View view;
        if (Helper.isTrishulThemeNew()) {
            ViewGroup.LayoutParams layoutParams = tabIV.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = "1:1";
            Intrinsics.checkNotNull(Glide.with(this.context).load(masterCat.getImage()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).error(R.mipmap.square_placeholder)).into(tabIV));
            masteAllCatTable = masterCat;
            textView = tabTitle;
            view = itemView;
        } else if (isGridLayout) {
            masteAllCatTable = masterCat;
            textView = tabTitle;
            view = itemView;
            setGridLayout(tabIV, masteAllCatTable, textView, view, parentRL);
        } else {
            masteAllCatTable = masterCat;
            textView = tabTitle;
            view = itemView;
            if (!isGridLayout) {
                setDefaultUI(tabIV, masteAllCatTable);
            } else {
                setDefaultUI(tabIV, masteAllCatTable);
            }
        }
        textView.setText(masteAllCatTable.getName());
        view.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.CourseTypeSmallTileAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CourseTypeSmallTileAdapter.manageUI$lambda$2(masteAllCatTable, this, position, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void manageUI$lambda$2(MasteAllCatTable masteAllCatTable, CourseTypeSmallTileAdapter courseTypeSmallTileAdapter, int i, View view) {
        if (StringsKt.equals(BuildConfig.FLAVOR, "resodigital", true)) {
            String bg_color = masteAllCatTable.getBg_color();
            Intrinsics.checkNotNullExpressionValue(bg_color, "getBg_color(...)");
            if (bg_color.length() > 0) {
                SharedPreference.getInstance().putString("theme_color_hai_bhai", masteAllCatTable.getBg_color() + ":" + masteAllCatTable.getFont_color());
            }
        }
        courseTypeSmallTileAdapter.dashboardClicked.onDashboardItemClicked(i, "");
    }

    private final void setDefaultUI(ImageView tabIV, MasteAllCatTable masterCat) {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Intrinsics.checkNotNull(windowManager);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        tabIV.getLayoutParams().height = (int) (100 * displayMetrics.scaledDensity);
        tabIV.getLayoutParams().width = -1;
        Glide.with(this.context).load(masterCat.getImage()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.placeholder_course).error(R.mipmap.placeholder_course)).into(tabIV);
    }

    private final void setGridLayout(ImageView tabIV, MasteAllCatTable masterCat, TextView tabTitle, View itemView, RelativeLayout parentRL) {
        makeDynamicUIChangesForGridLayout(itemView, parentRL, tabIV);
        Glide.with(this.context).load(masterCat.getImage()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.placeholder_course).error(R.mipmap.placeholder_course)).into(tabIV);
        ViewGroup.LayoutParams layoutParams = tabTitle.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(this.context.getResources().getDimensionPixelSize(R.dimen.dp4), 0, this.context.getResources().getDimensionPixelSize(R.dimen.dp4), this.context.getResources().getDimensionPixelSize(R.dimen.dp8));
        tabTitle.setLayoutParams(marginLayoutParams);
        tabTitle.setText(masterCat.getName());
    }

    private final int dpToPx(int dp) {
        return (int) (dp * this.context.getResources().getDisplayMetrics().density);
    }

    private final void makeDynamicUIChangesForGridLayout(View itemView, RelativeLayout parentRL, ImageView tabIV) {
        int iDpToPx = (itemView.getContext().getResources().getDisplayMetrics().widthPixels - (dpToPx(8) * 4)) / 3;
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        layoutParams.width = iDpToPx;
        itemView.setLayoutParams(layoutParams);
        itemView.requestLayout();
        View childAt = parentRL.getChildAt(0);
        LinearLayout.LayoutParams layoutParams2 = null;
        LinearLayout linearLayout = childAt instanceof LinearLayout ? (LinearLayout) childAt : null;
        if (linearLayout != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(13, -1);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setGravity(17);
        }
        ViewGroup.LayoutParams layoutParams4 = tabIV.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = layoutParams4 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams4 : null;
        if (layoutParams5 != null) {
            layoutParams5.width = dpToPx(60);
            layoutParams5.height = dpToPx(60);
            layoutParams5.gravity = 17;
            layoutParams2 = layoutParams5;
        }
        tabIV.setLayoutParams(layoutParams2);
    }
}
