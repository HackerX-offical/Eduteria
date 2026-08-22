package com.appnew.android.Theme;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: InfiniteBannerIndicator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\u001c2\b\b\u0001\u0010&\u001a\u00020\tJ\u0010\u0010'\u001a\u00020\u001c2\b\b\u0001\u0010&\u001a\u00020\tJ\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\rJ\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\rJ\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\rJ\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0018J\u000e\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0016J\b\u00101\u001a\u00020\u001cH\u0014J\b\u00102\u001a\u00020\u001cH\u0014J\u0012\u00103\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u000105H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/appnew/android/Theme/InfiniteBannerIndicator;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "indicatorCount", "", "selectedIndicatorColor", "unselectedIndicatorColor", "selectedIndicatorRadius", "", "unselectedIndicatorRadius", "indicatorSpacing", "currentPage", "paint", "Landroid/graphics/Paint;", "handler", "Landroid/os/Handler;", "isAutoScrolling", "", "autoScrollDelay", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "attachToViewPager2", "", "viewPager", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setCurrentPage", "page", "setIndicatorCount", "count", "setSelectedIndicatorColor", "color", "setUnselectedIndicatorColor", "setSelectedIndicatorRadius", Constants.KEY_RADIUS, "setUnselectedIndicatorRadius", "setIndicatorSpacing", "spacing", "setAutoScrollDelay", "delay", "setAutoScrolling", StreamManagement.Enabled.ELEMENT, "onAttachedToWindow", "onDetachedFromWindow", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "autoScrollRunnable", "Ljava/lang/Runnable;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InfiniteBannerIndicator extends View {
    public static final int $stable = 8;
    private long autoScrollDelay;
    private final Runnable autoScrollRunnable;
    private int currentPage;
    private final Handler handler;
    private int indicatorCount;
    private float indicatorSpacing;
    private boolean isAutoScrolling;
    private final Paint paint;
    private int selectedIndicatorColor;
    private float selectedIndicatorRadius;
    private int unselectedIndicatorColor;
    private float unselectedIndicatorRadius;
    private ViewPager2 viewPager2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfiniteBannerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedIndicatorColor = Color.parseColor("#FF0000");
        this.unselectedIndicatorColor = Color.parseColor("#808080");
        this.selectedIndicatorRadius = 8.0f;
        this.unselectedIndicatorRadius = 5.0f;
        this.indicatorSpacing = 10.0f;
        this.paint = new Paint(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.isAutoScrolling = true;
        this.autoScrollDelay = 5000L;
        this.autoScrollRunnable = new Runnable() { // from class: com.appnew.android.Theme.InfiniteBannerIndicator$autoScrollRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.isAutoScrolling && this.this$0.indicatorCount > 0) {
                    InfiniteBannerIndicator infiniteBannerIndicator = this.this$0;
                    infiniteBannerIndicator.currentPage = (infiniteBannerIndicator.currentPage + 1) % this.this$0.indicatorCount;
                    ViewPager2 viewPager2 = this.this$0.viewPager2;
                    if (viewPager2 != null) {
                        viewPager2.setCurrentItem(this.this$0.currentPage, true);
                    }
                    this.this$0.invalidate();
                }
                if (this.this$0.isAutoScrolling) {
                    this.this$0.handler.postDelayed(this, this.this$0.autoScrollDelay);
                }
            }
        };
    }

    public final void attachToViewPager2(ViewPager2 viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        this.viewPager2 = viewPager;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float f2 = 2;
        float f3 = this.selectedIndicatorRadius * f2;
        float f4 = this.indicatorSpacing;
        float width = (getWidth() - (((f3 + f4) * this.indicatorCount) - f4)) / 2.0f;
        int i = this.indicatorCount;
        int i2 = 0;
        while (i2 < i) {
            float f5 = (i2 * ((this.selectedIndicatorRadius * f2) + this.indicatorSpacing)) + width;
            float height = getHeight() / 2.0f;
            this.paint.setColor(i2 == this.currentPage ? this.selectedIndicatorColor : this.unselectedIndicatorColor);
            canvas.drawCircle(f5, height, i2 == this.currentPage ? this.selectedIndicatorRadius : this.unselectedIndicatorRadius, this.paint);
            i2++;
        }
    }

    public final void setCurrentPage(int page) {
        this.currentPage = page % this.indicatorCount;
        invalidate();
    }

    public final void setIndicatorCount(int count) {
        this.indicatorCount = count;
        invalidate();
    }

    public final void setSelectedIndicatorColor(int color) {
        this.selectedIndicatorColor = color;
        invalidate();
    }

    public final void setUnselectedIndicatorColor(int color) {
        this.unselectedIndicatorColor = color;
        invalidate();
    }

    public final void setSelectedIndicatorRadius(float radius) {
        this.selectedIndicatorRadius = radius;
        invalidate();
    }

    public final void setUnselectedIndicatorRadius(float radius) {
        this.unselectedIndicatorRadius = radius;
        invalidate();
    }

    public final void setIndicatorSpacing(float spacing) {
        this.indicatorSpacing = spacing;
        invalidate();
    }

    public final void setAutoScrollDelay(long delay) {
        this.autoScrollDelay = delay;
    }

    public final void setAutoScrolling(boolean enabled) {
        this.isAutoScrolling = enabled;
        if (enabled) {
            this.handler.removeCallbacks(this.autoScrollRunnable);
            this.handler.postDelayed(this.autoScrollRunnable, this.autoScrollDelay);
        } else {
            this.handler.removeCallbacks(this.autoScrollRunnable);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isAutoScrolling) {
            this.handler.removeCallbacks(this.autoScrollRunnable);
            this.handler.postDelayed(this.autoScrollRunnable, this.autoScrollDelay);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.handler.removeCallbacks(this.autoScrollRunnable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            if (this.isAutoScrolling) {
                this.handler.removeCallbacks(this.autoScrollRunnable);
            }
        } else if (numValueOf != null && numValueOf.intValue() == 1 && this.isAutoScrolling) {
            this.handler.postDelayed(this.autoScrollRunnable, this.autoScrollDelay);
        }
        return super.onTouchEvent(event);
    }
}
