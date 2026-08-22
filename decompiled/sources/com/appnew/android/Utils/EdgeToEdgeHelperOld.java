package com.appnew.android.Utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgeToEdgeHelperOld.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J@\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0007J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0007J@\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0007¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/Utils/EdgeToEdgeHelperOld;", "", "<init>", "()V", "applyHeaderWithToolbar", "", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "rootView", "Landroid/view/View;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "applyInsets", "darkMode", "", "onInsetsApplied", "Lkotlin/Function1;", "Landroidx/core/view/WindowInsetsCompat;", "applyDialogHeaderInsets", "headerView", "applyInsetsNew", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EdgeToEdgeHelperOld {
    public static final int $stable = 0;
    public static final EdgeToEdgeHelperOld INSTANCE = new EdgeToEdgeHelperOld();

    private EdgeToEdgeHelperOld() {
    }

    @JvmStatic
    public static final void applyHeaderWithToolbar(Context context, Window window, final View rootView, final Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(0);
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(false);
        final int paddingLeft = toolbar.getPaddingLeft();
        final int paddingTop = toolbar.getPaddingTop();
        final int paddingRight = toolbar.getPaddingRight();
        final int paddingBottom = toolbar.getPaddingBottom();
        final int paddingLeft2 = rootView.getPaddingLeft();
        final int paddingTop2 = rootView.getPaddingTop();
        final int paddingRight2 = rootView.getPaddingRight();
        final int paddingBottom2 = rootView.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: com.appnew.android.Utils.EdgeToEdgeHelperOld$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return EdgeToEdgeHelperOld.applyHeaderWithToolbar$lambda$0(toolbar, paddingLeft, paddingTop, paddingRight, paddingBottom, rootView, paddingLeft2, paddingTop2, paddingRight2, paddingBottom2, view, windowInsetsCompat);
            }
        });
        ViewCompat.requestApplyInsets(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyHeaderWithToolbar$lambda$0(Toolbar toolbar, int i, int i2, int i3, int i4, View view, int i5, int i6, int i7, int i8, View view2, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view2, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        if (!Intrinsics.areEqual(toolbar.getTag(), (Object) true)) {
            toolbar.setTag(true);
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
            if (layoutParams.height > 0) {
                layoutParams.height += insets2.top;
                toolbar.setLayoutParams(layoutParams);
            }
            toolbar.setPadding(i, i2 + insets2.top, i3, i4);
        }
        view.setPadding(i5, i6, i7, i8 + insets2.bottom);
        return insets;
    }

    public static /* synthetic */ void applyInsets$default(Context context, Window window, View view, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        applyInsets(context, window, view, z, function1);
    }

    @JvmStatic
    public static final void applyInsets(Context context, Window window, View rootView, boolean darkMode, final Function1<? super WindowInsetsCompat, Unit> onInsetsApplied) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        window.setNavigationBarColor(0);
        if (context.getResources().getConfiguration().orientation == 2) {
            EdgeToEdgeHelperOldKt.safeSetStatusBarColor(window, -16777216);
            windowInsetsControllerCompat.setAppearanceLightStatusBars(false);
            windowInsetsControllerCompat.setAppearanceLightNavigationBars(!darkMode);
        } else {
            EdgeToEdgeHelperOldKt.safeSetStatusBarColor(window, 0);
            windowInsetsControllerCompat.setAppearanceLightStatusBars(!darkMode);
            windowInsetsControllerCompat.setAppearanceLightNavigationBars(!darkMode);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-1029));
        }
        final int paddingLeft = rootView.getPaddingLeft();
        final int paddingTop = rootView.getPaddingTop();
        final int paddingRight = rootView.getPaddingRight();
        final int paddingBottom = rootView.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: com.appnew.android.Utils.EdgeToEdgeHelperOld$$ExternalSyntheticLambda3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return EdgeToEdgeHelperOld.applyInsets$lambda$1(paddingLeft, paddingTop, paddingRight, paddingBottom, onInsetsApplied, view, windowInsetsCompat);
            }
        });
        ViewCompat.requestApplyInsets(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyInsets$lambda$1(int i, int i2, int i3, int i4, Function1 function1, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(i + insets2.left, i2 + insets2.top, i3 + insets2.right, i4 + insets2.bottom);
        if (function1 != null) {
            function1.invoke(insets);
        }
        return insets;
    }

    @JvmStatic
    public static final void applyDialogHeaderInsets(Window window, final View rootView, final View headerView) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(headerView, "headerView");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(0);
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(false);
        final int paddingLeft = headerView.getPaddingLeft();
        final int paddingTop = headerView.getPaddingTop();
        final int paddingRight = headerView.getPaddingRight();
        final int paddingBottom = headerView.getPaddingBottom();
        final int i = headerView.getLayoutParams().height;
        final int paddingLeft2 = rootView.getPaddingLeft();
        final int paddingTop2 = rootView.getPaddingTop();
        final int paddingRight2 = rootView.getPaddingRight();
        final int paddingBottom2 = rootView.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: com.appnew.android.Utils.EdgeToEdgeHelperOld$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return EdgeToEdgeHelperOld.applyDialogHeaderInsets$lambda$2(headerView, i, paddingLeft, paddingTop, paddingRight, paddingBottom, rootView, paddingLeft2, paddingTop2, paddingRight2, paddingBottom2, view, windowInsetsCompat);
            }
        });
        ViewCompat.requestApplyInsets(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyDialogHeaderInsets$lambda$2(View view, int i, int i2, int i3, int i4, int i5, View view2, int i6, int i7, int i8, int i9, View view3, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view3, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.statusBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
        if (!Intrinsics.areEqual(view.getTag(), "DIALOG_HEADER_DONE")) {
            view.setTag("DIALOG_HEADER_DONE");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams.height > 0) {
                layoutParams.height = i + insets2.top;
                view.setLayoutParams(layoutParams);
            }
            view.setPadding(i2, i3 + insets2.top, i4, i5);
        }
        view2.setPadding(i6 + insets3.left, i7, i8 + insets3.right, i9 + insets3.bottom);
        return insets;
    }

    public static /* synthetic */ void applyInsetsNew$default(Context context, Window window, View view, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            function1 = null;
        }
        applyInsetsNew(context, window, view, z, function1);
    }

    @JvmStatic
    public static final void applyInsetsNew(Context context, Window window, View rootView, boolean darkMode, final Function1<? super WindowInsetsCompat, Unit> onInsetsApplied) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        window.setNavigationBarColor(0);
        final boolean z = context.getResources().getConfiguration().orientation == 2;
        if (z) {
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
            EdgeToEdgeHelperOldKt.safeSetStatusBarColor(window, -16777216);
            windowInsetsControllerCompat.setAppearanceLightStatusBars(false);
            windowInsetsControllerCompat.setAppearanceLightNavigationBars(!darkMode);
        } else {
            windowInsetsControllerCompat.show(WindowInsetsCompat.Type.systemBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(1);
            EdgeToEdgeHelperOldKt.safeSetStatusBarColor(window, 0);
            windowInsetsControllerCompat.setAppearanceLightStatusBars(!darkMode);
            windowInsetsControllerCompat.setAppearanceLightNavigationBars(!darkMode);
        }
        final int paddingLeft = rootView.getPaddingLeft();
        final int paddingTop = rootView.getPaddingTop();
        final int paddingRight = rootView.getPaddingRight();
        final int paddingBottom = rootView.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: com.appnew.android.Utils.EdgeToEdgeHelperOld$$ExternalSyntheticLambda2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return EdgeToEdgeHelperOld.applyInsetsNew$lambda$3(z, paddingLeft, paddingTop, paddingRight, paddingBottom, onInsetsApplied, view, windowInsetsCompat);
            }
        });
        ViewCompat.requestApplyInsets(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyInsetsNew$lambda$3(boolean z, int i, int i2, int i3, int i4, Function1 function1, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (z) {
            v.setPadding(0, 0, 0, 0);
        } else {
            Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            v.setPadding(i + insets2.left, i2 + insets2.top, i3 + insets2.right, i4 + insets2.bottom);
        }
        if (function1 != null) {
            function1.invoke(insets);
        }
        return insets;
    }
}
