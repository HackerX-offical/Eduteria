package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: FloatingToolbarTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010!\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010#\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018¨\u0006%"}, d2 = {"Landroidx/compose/material3/tokens/FloatingToolbarTokens;", "", "<init>", "()V", "ContainerBetweenSpace", "Landroidx/compose/ui/unit/Dp;", "getContainerBetweenSpace-D9Ej5fM", "()F", "F", "ContainerExternalPadding", "getContainerExternalPadding-D9Ej5fM", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerLeadingSpace", "getContainerLeadingSpace-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerTrailingSpace", "getContainerTrailingSpace-D9Ej5fM", "StandardContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getStandardContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "VibrantButtonSelectedContainerColor", "getVibrantButtonSelectedContainerColor", "VibrantButtonSelectedIconColor", "getVibrantButtonSelectedIconColor", "VibrantButtonSelectedTextColor", "getVibrantButtonSelectedTextColor", "VibrantButtonUnselectedIconColor", "getVibrantButtonUnselectedIconColor", "VibrantButtonUnselectedTextColor", "getVibrantButtonUnselectedTextColor", "VibrantContainerColor", "getVibrantContainerColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatingToolbarTokens {
    public static final int $stable = 0;
    private static final float ContainerLeadingSpace;
    private static final float ContainerTrailingSpace;
    public static final FloatingToolbarTokens INSTANCE = new FloatingToolbarTokens();
    private static final float ContainerBetweenSpace = Dp.m8830constructorimpl((float) 4.0d);
    private static final float ContainerExternalPadding = Dp.m8830constructorimpl((float) 16.0d);
    private static final float ContainerHeight = Dp.m8830constructorimpl((float) 64.0d);
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerFull;
    private static final ColorSchemeKeyTokens StandardContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
    private static final ColorSchemeKeyTokens VibrantButtonSelectedContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
    private static final ColorSchemeKeyTokens VibrantButtonSelectedIconColor = ColorSchemeKeyTokens.OnSurface;
    private static final ColorSchemeKeyTokens VibrantButtonSelectedTextColor = ColorSchemeKeyTokens.OnSurface;
    private static final ColorSchemeKeyTokens VibrantButtonUnselectedIconColor = ColorSchemeKeyTokens.OnPrimaryContainer;
    private static final ColorSchemeKeyTokens VibrantButtonUnselectedTextColor = ColorSchemeKeyTokens.OnPrimaryContainer;
    private static final ColorSchemeKeyTokens VibrantContainerColor = ColorSchemeKeyTokens.PrimaryContainer;

    private FloatingToolbarTokens() {
    }

    /* JADX INFO: renamed from: getContainerBetweenSpace-D9Ej5fM, reason: not valid java name */
    public final float m4535getContainerBetweenSpaceD9Ej5fM() {
        return ContainerBetweenSpace;
    }

    /* JADX INFO: renamed from: getContainerExternalPadding-D9Ej5fM, reason: not valid java name */
    public final float m4536getContainerExternalPaddingD9Ej5fM() {
        return ContainerExternalPadding;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m4537getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    /* JADX INFO: renamed from: getContainerLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4538getContainerLeadingSpaceD9Ej5fM() {
        return ContainerLeadingSpace;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    /* JADX INFO: renamed from: getContainerTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4539getContainerTrailingSpaceD9Ej5fM() {
        return ContainerTrailingSpace;
    }

    public final ColorSchemeKeyTokens getStandardContainerColor() {
        return StandardContainerColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonSelectedContainerColor() {
        return VibrantButtonSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonSelectedIconColor() {
        return VibrantButtonSelectedIconColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonSelectedTextColor() {
        return VibrantButtonSelectedTextColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonUnselectedIconColor() {
        return VibrantButtonUnselectedIconColor;
    }

    public final ColorSchemeKeyTokens getVibrantButtonUnselectedTextColor() {
        return VibrantButtonUnselectedTextColor;
    }

    public final ColorSchemeKeyTokens getVibrantContainerColor() {
        return VibrantContainerColor;
    }

    static {
        float f2 = (float) 8.0d;
        ContainerLeadingSpace = Dp.m8830constructorimpl(f2);
        ContainerTrailingSpace = Dp.m8830constructorimpl(f2);
    }
}
