package com.microsoft.clarity.e;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Insets;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.commands.ClipRect;
import com.microsoft.clarity.models.display.common.ImageSize;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaskingMode f738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Color4f f740c;

    public static final class a {
        public static void a(Canvas canvas, int i) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(new Rect(i, i, 1000000, 1000000));
        }

        public static void a(Canvas canvas, int i, int i2) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(0, 0, i, i2);
        }

        public static boolean a(ClipRect clipRect) {
            Intrinsics.checkNotNullParameter(clipRect, "clipRect");
            return ((int) clipRect.getRect().getRight()) == 1000000 && ((int) clipRect.getRect().getBottom()) == 1000000;
        }

        public static void b(Canvas canvas, int i) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(new Rect(i, i, 999996, 999996));
        }

        public static boolean b(ClipRect clipRect) {
            Intrinsics.checkNotNullParameter(clipRect, "clipRect");
            return ((int) clipRect.getRect().getRight()) == 999999 && ((int) clipRect.getRect().getBottom()) == 999999;
        }

        public static void c(Canvas canvas, int i) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(new Rect(i, i, 999998, 999998));
        }

        public static boolean c(ClipRect clipRect) {
            Intrinsics.checkNotNullParameter(clipRect, "clipRect");
            return ((int) clipRect.getRect().getRight()) == 999996 && ((int) clipRect.getRect().getBottom()) == 999996;
        }

        public static void d(Canvas canvas, int i) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(new Rect(i, i, 999994, 999994));
        }

        public static boolean d(ClipRect clipRect) {
            Intrinsics.checkNotNullParameter(clipRect, "clipRect");
            return ((int) clipRect.getRect().getRight()) == 999995 && ((int) clipRect.getRect().getBottom()) == 999995;
        }

        public static void e(Canvas canvas, int i) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(new Rect(i, i, 999999, 999999));
        }

        public static boolean e(ClipRect clipRect) {
            Intrinsics.checkNotNullParameter(clipRect, "clipRect");
            return ((int) clipRect.getRect().getRight()) == 999994 && ((int) clipRect.getRect().getBottom()) == 999994;
        }

        public static void f(Canvas canvas, int i) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(new Rect(i, i, 999995, 999995));
        }

        public static boolean f(ClipRect clipRect) {
            Intrinsics.checkNotNullParameter(clipRect, "clipRect");
            return ((int) clipRect.getRect().getRight()) == 999993 && ((int) clipRect.getRect().getBottom()) == 999993;
        }

        public static void g(Canvas canvas, int i) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(new Rect(i, i, 999997, 999997));
        }

        public static boolean g(ClipRect clipRect) {
            Intrinsics.checkNotNullParameter(clipRect, "clipRect");
            return ((int) clipRect.getRect().getRight()) == 999997 && ((int) clipRect.getRect().getBottom()) == 999997;
        }

        public static void h(Canvas canvas, int i) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.clipRect(new Rect(i, i, 999993, 999993));
        }
    }

    /* JADX INFO: renamed from: com.microsoft.clarity.e.b$b, reason: collision with other inner class name */
    public static final class C0186b extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f743c;

        public C0186b(View view, Drawable drawable, c type) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(type, "type");
            this.f741a = view;
            this.f742b = drawable;
            this.f743c = type;
        }

        @Override // android.graphics.drawable.Drawable
        public final void applyTheme(Resources.Theme t) {
            Unit unit;
            Intrinsics.checkNotNullParameter(t, "t");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.applyTheme(t);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.applyTheme(t);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean canApplyTheme() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.canApplyTheme() : super.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable
        public final void clearColorFilter() {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.clearColorFilter();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.clearColorFilter();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int uniqueDrawingId = (int) this.f741a.getUniqueDrawingId();
            canvas.save();
            int iOrdinal = this.f743c.ordinal();
            if (iOrdinal == 0) {
                a.e(canvas, uniqueDrawingId);
            } else if (iOrdinal == 1) {
                a.a(canvas, uniqueDrawingId);
            } else if (iOrdinal == 2) {
                a.f(canvas, uniqueDrawingId);
            } else if (iOrdinal == 3) {
                a.b(canvas, uniqueDrawingId);
            } else if (iOrdinal == 4) {
                a.g(canvas, uniqueDrawingId);
            } else if (iOrdinal == 5) {
                a.c(canvas, uniqueDrawingId);
            }
            canvas.restore();
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }

        public final boolean equals(Object obj) {
            Drawable drawable = this.f742b;
            return drawable != null ? Intrinsics.areEqual(drawable, obj) : super.equals(obj);
        }

        @Override // android.graphics.drawable.Drawable
        public final int getAlpha() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.getAlpha() : super.getAlpha();
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable.Callback getCallback() {
            Drawable.Callback callback;
            Drawable drawable = this.f742b;
            return (drawable == null || (callback = drawable.getCallback()) == null) ? super.getCallback() : callback;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getChangingConfigurations() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable
        public final ColorFilter getColorFilter() {
            ColorFilter colorFilter;
            Drawable drawable = this.f742b;
            return (drawable == null || (colorFilter = drawable.getColorFilter()) == null) ? super.getColorFilter() : colorFilter;
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable.ConstantState getConstantState() {
            Drawable.ConstantState constantState;
            Drawable drawable = this.f742b;
            return (drawable == null || (constantState = drawable.getConstantState()) == null) ? super.getConstantState() : constantState;
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable getCurrent() {
            return this;
        }

        @Override // android.graphics.drawable.Drawable
        public final Rect getDirtyBounds() {
            Drawable drawable = this.f742b;
            Rect dirtyBounds = drawable != null ? drawable.getDirtyBounds() : null;
            if (dirtyBounds != null) {
                return dirtyBounds;
            }
            Rect dirtyBounds2 = super.getDirtyBounds();
            Intrinsics.checkNotNullExpressionValue(dirtyBounds2, "super.getDirtyBounds()");
            return dirtyBounds2;
        }

        @Override // android.graphics.drawable.Drawable
        public final void getHotspotBounds(Rect outRect) {
            Unit unit;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.getHotspotBounds(outRect);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.getHotspotBounds(outRect);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.getIntrinsicHeight() : super.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.getIntrinsicWidth() : super.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getLayoutDirection() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.getLayoutDirection() : super.getLayoutDirection();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumHeight() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumWidth() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Inherits parent")
        public final int getOpacity() {
            Drawable drawable = this.f742b;
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public final Insets getOpticalInsets() {
            Drawable drawable = this.f742b;
            Insets opticalInsets = drawable != null ? drawable.getOpticalInsets() : null;
            if (opticalInsets != null) {
                return opticalInsets;
            }
            Insets opticalInsets2 = super.getOpticalInsets();
            Intrinsics.checkNotNullExpressionValue(opticalInsets2, "super.getOpticalInsets()");
            return opticalInsets2;
        }

        @Override // android.graphics.drawable.Drawable
        public final void getOutline(Outline outline) {
            Unit unit;
            Intrinsics.checkNotNullParameter(outline, "outline");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.getOutline(outline);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.getOutline(outline);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean getPadding(Rect padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.getPadding(padding) : super.getPadding(padding);
        }

        @Override // android.graphics.drawable.Drawable
        public final int[] getState() {
            Drawable drawable = this.f742b;
            int[] state = drawable != null ? drawable.getState() : null;
            if (state != null) {
                return state;
            }
            int[] state2 = super.getState();
            Intrinsics.checkNotNullExpressionValue(state2, "super.getState()");
            return state2;
        }

        @Override // android.graphics.drawable.Drawable
        public final Region getTransparentRegion() {
            Region transparentRegion;
            Drawable drawable = this.f742b;
            return (drawable == null || (transparentRegion = drawable.getTransparentRegion()) == null) ? super.getTransparentRegion() : transparentRegion;
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean hasFocusStateSpecified() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.hasFocusStateSpecified() : super.hasFocusStateSpecified();
        }

        public final int hashCode() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.hashCode() : super.hashCode();
        }

        @Override // android.graphics.drawable.Drawable
        public final void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
            Unit unit;
            Intrinsics.checkNotNullParameter(r, "r");
            Intrinsics.checkNotNullParameter(parser, "parser");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.inflate(r, parser, attrs);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.inflate(r, parser, attrs);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
            Unit unit;
            Intrinsics.checkNotNullParameter(r, "r");
            Intrinsics.checkNotNullParameter(parser, "parser");
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.inflate(r, parser, attrs, theme);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.inflate(r, parser, attrs, theme);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void invalidateSelf() {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.invalidateSelf();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isAutoMirrored() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.isAutoMirrored() : super.isAutoMirrored();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isFilterBitmap() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.isFilterBitmap() : super.isFilterBitmap();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isProjected() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.isProjected() : super.isProjected();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isStateful() {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.isStateful() : super.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public final void jumpToCurrentState() {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.jumpToCurrentState();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.jumpToCurrentState();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable mutate() {
            return this;
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean onLayoutDirectionChanged(int i) {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.onLayoutDirectionChanged(i) : super.onLayoutDirectionChanged(i);
        }

        @Override // android.graphics.drawable.Drawable
        public final void scheduleSelf(Runnable what, long j) {
            Unit unit;
            Intrinsics.checkNotNullParameter(what, "what");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.scheduleSelf(what, j);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.scheduleSelf(what, j);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
            Drawable drawable = this.f742b;
            if (drawable == null) {
                return;
            }
            drawable.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAutoMirrored(boolean z) {
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            } else {
                super.setAutoMirrored(z);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(int i, int i2, int i3, int i4) {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setBounds(i, i2, i3, i4);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setBounds(i, i2, i3, i4);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(Rect bounds) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setBounds(bounds);
            } else {
                super.setBounds(bounds);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setChangingConfigurations(int i) {
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setChangingConfigurations(i);
            } else {
                super.setChangingConfigurations(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Inherits parent")
        public final void setColorFilter(int i, PorterDuff.Mode mode) {
            Unit unit;
            Intrinsics.checkNotNullParameter(mode, "mode");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setColorFilter(i, mode);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setColorFilter(i, mode);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
            Drawable drawable = this.f742b;
            if (drawable == null) {
                return;
            }
            drawable.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Inherits parent")
        public final void setDither(boolean z) {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setDither(z);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setDither(z);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setFilterBitmap(boolean z) {
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            } else {
                super.setFilterBitmap(z);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setHotspot(float f2, float f3) {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setHotspot(f2, f3);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setHotspotBounds(int i, int i2, int i3, int i4) {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setHotspotBounds(i, i2, i3, i4);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setState(int[] stateSet) {
            Intrinsics.checkNotNullParameter(stateSet, "stateSet");
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.setState(stateSet) : super.setState(stateSet);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTint(int i) {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setTint(i);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setTint(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTintBlendMode(BlendMode blendMode) {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setTintBlendMode(blendMode);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setTintBlendMode(blendMode);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTintList(ColorStateList colorStateList) {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setTintList(colorStateList);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setTintList(colorStateList);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTintMode(PorterDuff.Mode mode) {
            Unit unit;
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.setTintMode(mode);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.setTintMode(mode);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setVisible(boolean z, boolean z2) {
            Drawable drawable = this.f742b;
            return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
        }

        public final String toString() {
            String string;
            Drawable drawable = this.f742b;
            return (drawable == null || (string = drawable.toString()) == null) ? super.toString() : string;
        }

        @Override // android.graphics.drawable.Drawable
        public final void unscheduleSelf(Runnable what) {
            Unit unit;
            Intrinsics.checkNotNullParameter(what, "what");
            Drawable drawable = this.f742b;
            if (drawable != null) {
                drawable.unscheduleSelf(what);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.unscheduleSelf(what);
            }
        }
    }

    public enum c {
        MaskViewStart,
        MaskViewEnd,
        UnmaskViewStart,
        UnmaskViewEnd,
        /* JADX INFO: Fake field, exist only in values array */
        SkipWebViewStart,
        /* JADX INFO: Fake field, exist only in values array */
        SkipWebViewEnd
    }

    public b(MaskingMode maskingMode) {
        Intrinsics.checkNotNullParameter(maskingMode, "maskingMode");
        this.f738a = maskingMode;
        this.f739b = new f();
        this.f740c = new Color4f(128.0f, 128.0f, 128.0f, 1.0f);
    }

    public final void a(ImageShader imageShader, DisplayFrame displayFrame) {
        Integer imageIndex = imageShader.getImageIndex();
        Intrinsics.checkNotNull(imageIndex);
        int iIntValue = imageIndex.intValue();
        if (iIntValue < 0 || iIntValue >= displayFrame.getImages().size()) {
            return;
        }
        byte[] data = displayFrame.getImages().get(iIntValue).getData();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        if (data.length == 0) {
            return;
        }
        ImageSize imageSizeA = com.microsoft.clarity.n.a.a(data);
        imageShader.setMaskedColor(this.f740c);
        imageShader.setMaskedWidth(Integer.valueOf(imageSizeA.getWidth()));
        imageShader.setMaskedHeight(Integer.valueOf(imageSizeA.getHeight()));
        imageShader.setImageIndex(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03e3  */
    /* JADX WARN: Type inference failed for: r10v9, types: [com.microsoft.clarity.models.display.blobs.TextBlob] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.microsoft.clarity.models.display.DisplayFrame, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.microsoft.clarity.models.observers.FramePicture r20, com.microsoft.clarity.models.display.DisplayFrame r21) throws com.microsoft.clarity.c.b {
        /*
            Method dump skipped, instruction units count: 1144
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.e.b.a(com.microsoft.clarity.models.observers.FramePicture, com.microsoft.clarity.models.display.DisplayFrame):void");
    }
}
