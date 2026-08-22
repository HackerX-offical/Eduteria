package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes8.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayAccentColor;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        this(MaterialAttributes.resolveBoolean(context, R.attr.elevationOverlayEnabled, false), MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0), MaterialColors.getColor(context, R.attr.elevationOverlayAccentColor, 0), MaterialColors.getColor(context, R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    public ElevationOverlayProvider(boolean z, int i, int i2, int i3, float f2) {
        this.elevationOverlayEnabled = z;
        this.elevationOverlayColor = i;
        this.elevationOverlayAccentColor = i2;
        this.colorSurface = i3;
        this.displayDensity = f2;
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f2, View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f2 + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f2) {
        return compositeOverlayIfNeeded(this.colorSurface, f2);
    }

    public int compositeOverlayIfNeeded(int i, float f2, View view) {
        return compositeOverlayIfNeeded(i, f2 + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayIfNeeded(int i, float f2) {
        return (this.elevationOverlayEnabled && isThemeSurfaceColor(i)) ? compositeOverlay(i, f2) : i;
    }

    public int compositeOverlay(int i, float f2, View view) {
        return compositeOverlay(i, f2 + getParentAbsoluteElevation(view));
    }

    public int compositeOverlay(int i, float f2) {
        int i2;
        float fCalculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f2);
        int iAlpha = Color.alpha(i);
        int iLayer = MaterialColors.layer(ColorUtils.setAlphaComponent(i, 255), this.elevationOverlayColor, fCalculateOverlayAlphaFraction);
        if (fCalculateOverlayAlphaFraction > 0.0f && (i2 = this.elevationOverlayAccentColor) != 0) {
            iLayer = MaterialColors.layer(iLayer, ColorUtils.setAlphaComponent(i2, OVERLAY_ACCENT_COLOR_ALPHA));
        }
        return ColorUtils.setAlphaComponent(iLayer, iAlpha);
    }

    public int calculateOverlayAlpha(float f2) {
        return Math.round(calculateOverlayAlphaFraction(f2) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float f2) {
        if (this.displayDensity <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / r0)) * FORMULA_MULTIPLIER) + 2.0f) / 100.0f, 1.0f);
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public float getParentAbsoluteElevation(View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    private boolean isThemeSurfaceColor(int i) {
        return ColorUtils.setAlphaComponent(i, 255) == this.colorSurface;
    }
}
