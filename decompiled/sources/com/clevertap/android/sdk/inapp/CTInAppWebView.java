package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.os.Build;
import android.util.TypedValue;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.clevertap.android.sdk.CTWebInterface;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTInAppWebView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 '2\u00020\u0001:\u0001'B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\rJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0014J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0003J\b\u0010\u001c\u001a\u00020\u0005H\u0003J\b\u0010\u001d\u001a\u00020\u0005H\u0003J\b\u0010\u001e\u001a\u00020\u0005H\u0003J\b\u0010\u001f\u001a\u00020\u0005H\u0003J\b\u0010 \u001a\u00020\u0005H\u0003J\b\u0010!\u001a\u00020\u0005H\u0003J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0007J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTInAppWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "widthDp", "", "heightDp", "widthPercentage", "heightPercentage", Constants.INAPP_ASPECT_RATIO, "", "<init>", "(Landroid/content/Context;IIIID)V", "(Landroid/content/Context;IIII)V", "dim", "Landroid/graphics/Point;", "isFullscreen", "", "()Z", "setFullscreen", "(Z)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "updateDimension", "dpToPx", "dp", "calculatePercentageWidth", "calculatePercentageHeight", "calculateWidthWithWindowMetrics", "calculateHeightWithWindowMetrics", "calculateWidthWithDisplayMetrics", "calculateHeightWithDisplayMetrics", "setJavaScriptInterface", "webInterface", "Lcom/clevertap/android/sdk/CTWebInterface;", "cleanup", Constants.INAPP_JS_ENABLED, "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppWebView extends WebView {
    private static final double DEFAULT_ASPECT_RATIO = -1.0d;
    private static final String JAVASCRIPT_INTERFACE_NAME = "CleverTap";
    private final double aspectRatio;
    private final Context context;
    public final Point dim;
    private final int heightDp;
    private final int heightPercentage;
    private boolean isFullscreen;
    private final int widthDp;
    private final int widthPercentage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CTInAppWebView(Context context, int i, int i2, int i3, int i4, double d2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.widthDp = i;
        this.heightDp = i2;
        this.widthPercentage = i3;
        this.heightPercentage = i4;
        this.aspectRatio = d2;
        this.dim = new Point();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setOverScrollMode(2);
        setBackgroundColor(0);
        getSettings().setTextZoom(100);
        setId(188293);
    }

    /* JADX INFO: renamed from: isFullscreen, reason: from getter */
    public final boolean getIsFullscreen() {
        return this.isFullscreen;
    }

    public final void setFullscreen(boolean z) {
        this.isFullscreen = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CTInAppWebView(Context context, int i, int i2, int i3, int i4) {
        this(context, i, i2, i3, i4, -1.0d);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        updateDimension();
        setMeasuredDimension(this.dim.x, this.dim.y);
    }

    public final void updateDimension() {
        int iCalculatePercentageWidth;
        int iCalculatePercentageHeight;
        int i = this.widthDp;
        if (i > 0) {
            iCalculatePercentageWidth = dpToPx(i);
        } else {
            iCalculatePercentageWidth = calculatePercentageWidth();
        }
        int i2 = this.heightDp;
        if (i2 > 0) {
            iCalculatePercentageHeight = dpToPx(i2);
        } else {
            double d2 = this.aspectRatio;
            iCalculatePercentageHeight = (d2 != -1.0d && d2 > 0.0d) ? (int) (((double) iCalculatePercentageWidth) / d2) : calculatePercentageHeight();
        }
        this.dim.x = iCalculatePercentageWidth;
        this.dim.y = iCalculatePercentageHeight;
    }

    private final int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    private final int calculatePercentageWidth() {
        if (Build.VERSION.SDK_INT >= 30) {
            return calculateWidthWithWindowMetrics();
        }
        return calculateWidthWithDisplayMetrics();
    }

    private final int calculatePercentageHeight() {
        if (Build.VERSION.SDK_INT >= 30) {
            return calculateHeightWithWindowMetrics();
        }
        return calculateHeightWithDisplayMetrics();
    }

    private final int calculateWidthWithWindowMetrics() {
        int iWidth;
        Object systemService = this.context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return calculateWidthWithDisplayMetrics();
        }
        WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
        if (this.isFullscreen) {
            iWidth = currentWindowMetrics.getBounds().width();
        } else {
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
            iWidth = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right;
        }
        return (int) ((iWidth * this.widthPercentage) / 100.0f);
    }

    private final int calculateHeightWithWindowMetrics() {
        int iHeight;
        Object systemService = this.context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return calculateHeightWithDisplayMetrics();
        }
        WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
        if (this.isFullscreen) {
            iHeight = currentWindowMetrics.getBounds().height();
        } else {
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
            iHeight = (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
        }
        return (int) ((iHeight * this.heightPercentage) / 100.0f);
    }

    private final int calculateWidthWithDisplayMetrics() {
        return (int) ((getResources().getDisplayMetrics().widthPixels * this.widthPercentage) / 100.0f);
    }

    private final int calculateHeightWithDisplayMetrics() {
        return (int) ((getResources().getDisplayMetrics().heightPixels * this.heightPercentage) / 100.0f);
    }

    public final void setJavaScriptInterface(CTWebInterface webInterface) {
        Intrinsics.checkNotNullParameter(webInterface, "webInterface");
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        addJavascriptInterface(webInterface, "CleverTap");
    }

    public final void cleanup(boolean isJsEnabled) {
        removeAllViews();
        destroyDrawingCache();
        loadUrl("about:blank");
        if (isJsEnabled) {
            removeJavascriptInterface("CleverTap");
        }
        clearHistory();
        destroy();
    }
}
