package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: DockedToolbarTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/tokens/DockedToolbarTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "ContainerLeadingSpace", "getContainerLeadingSpace-D9Ej5fM", "ContainerMaxSpacing", "getContainerMaxSpacing-D9Ej5fM", "ContainerMinSpacing", "getContainerMinSpacing-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerTrailingSpace", "getContainerTrailingSpace-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DockedToolbarTokens {
    public static final int $stable = 0;
    private static final float ContainerLeadingSpace;
    private static final float ContainerTrailingSpace;
    public static final DockedToolbarTokens INSTANCE = new DockedToolbarTokens();
    private static final ColorSchemeKeyTokens ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
    private static final float ContainerHeight = Dp.m8830constructorimpl((float) 64.0d);
    private static final float ContainerMaxSpacing = Dp.m8830constructorimpl((float) 32.0d);
    private static final float ContainerMinSpacing = Dp.m8830constructorimpl((float) 4.0d);
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerNone;

    private DockedToolbarTokens() {
    }

    static {
        float f2 = (float) 16.0d;
        ContainerLeadingSpace = Dp.m8830constructorimpl(f2);
        ContainerTrailingSpace = Dp.m8830constructorimpl(f2);
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m4396getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    /* JADX INFO: renamed from: getContainerLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4397getContainerLeadingSpaceD9Ej5fM() {
        return ContainerLeadingSpace;
    }

    /* JADX INFO: renamed from: getContainerMaxSpacing-D9Ej5fM, reason: not valid java name */
    public final float m4398getContainerMaxSpacingD9Ej5fM() {
        return ContainerMaxSpacing;
    }

    /* JADX INFO: renamed from: getContainerMinSpacing-D9Ej5fM, reason: not valid java name */
    public final float m4399getContainerMinSpacingD9Ej5fM() {
        return ContainerMinSpacing;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    /* JADX INFO: renamed from: getContainerTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4400getContainerTrailingSpaceD9Ej5fM() {
        return ContainerTrailingSpace;
    }
}
