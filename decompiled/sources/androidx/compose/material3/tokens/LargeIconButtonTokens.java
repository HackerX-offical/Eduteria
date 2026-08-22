package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: LargeIconButtonTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007¨\u0006%"}, d2 = {"Landroidx/compose/material3/tokens/LargeIconButtonTokens;", "", "<init>", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "ContainerShapeRound", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShapeRound", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerShapeSquare", "getContainerShapeSquare", "IconSize", "getIconSize-D9Ej5fM", "NarrowLeadingSpace", "getNarrowLeadingSpace-D9Ej5fM", "NarrowTrailingSpace", "getNarrowTrailingSpace-D9Ej5fM", "OutlinedOutlineWidth", "getOutlinedOutlineWidth-D9Ej5fM", "PressedContainerShape", "getPressedContainerShape", "SelectedContainerShapeRound", "getSelectedContainerShapeRound", "SelectedContainerShapeSquare", "getSelectedContainerShapeSquare", "UniformLeadingSpace", "getUniformLeadingSpace-D9Ej5fM", "UniformTrailingSpace", "getUniformTrailingSpace-D9Ej5fM", "WideLeadingSpace", "getWideLeadingSpace-D9Ej5fM", "WideTrailingSpace", "getWideTrailingSpace-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LargeIconButtonTokens {
    public static final int $stable = 0;
    private static final float IconSize;
    private static final float NarrowLeadingSpace;
    private static final float NarrowTrailingSpace;
    private static final float UniformLeadingSpace;
    private static final float UniformTrailingSpace;
    private static final float WideLeadingSpace;
    private static final float WideTrailingSpace;
    public static final LargeIconButtonTokens INSTANCE = new LargeIconButtonTokens();
    private static final float ContainerHeight = Dp.m8830constructorimpl((float) 96.0d);
    private static final ShapeKeyTokens ContainerShapeRound = ShapeKeyTokens.CornerFull;
    private static final ShapeKeyTokens ContainerShapeSquare = ShapeKeyTokens.CornerExtraLarge;
    private static final float OutlinedOutlineWidth = Dp.m8830constructorimpl((float) 2.0d);
    private static final ShapeKeyTokens PressedContainerShape = ShapeKeyTokens.CornerLarge;
    private static final ShapeKeyTokens SelectedContainerShapeRound = ShapeKeyTokens.CornerExtraLarge;
    private static final ShapeKeyTokens SelectedContainerShapeSquare = ShapeKeyTokens.CornerFull;

    private LargeIconButtonTokens() {
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m4548getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShapeRound() {
        return ContainerShapeRound;
    }

    public final ShapeKeyTokens getContainerShapeSquare() {
        return ContainerShapeSquare;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4549getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getNarrowLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4550getNarrowLeadingSpaceD9Ej5fM() {
        return NarrowLeadingSpace;
    }

    /* JADX INFO: renamed from: getNarrowTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4551getNarrowTrailingSpaceD9Ej5fM() {
        return NarrowTrailingSpace;
    }

    /* JADX INFO: renamed from: getOutlinedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m4552getOutlinedOutlineWidthD9Ej5fM() {
        return OutlinedOutlineWidth;
    }

    public final ShapeKeyTokens getPressedContainerShape() {
        return PressedContainerShape;
    }

    public final ShapeKeyTokens getSelectedContainerShapeRound() {
        return SelectedContainerShapeRound;
    }

    public final ShapeKeyTokens getSelectedContainerShapeSquare() {
        return SelectedContainerShapeSquare;
    }

    /* JADX INFO: renamed from: getUniformLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4553getUniformLeadingSpaceD9Ej5fM() {
        return UniformLeadingSpace;
    }

    /* JADX INFO: renamed from: getUniformTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4554getUniformTrailingSpaceD9Ej5fM() {
        return UniformTrailingSpace;
    }

    /* JADX INFO: renamed from: getWideLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4555getWideLeadingSpaceD9Ej5fM() {
        return WideLeadingSpace;
    }

    /* JADX INFO: renamed from: getWideTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4556getWideTrailingSpaceD9Ej5fM() {
        return WideTrailingSpace;
    }

    static {
        float f2 = (float) 32.0d;
        IconSize = Dp.m8830constructorimpl(f2);
        float f3 = (float) 16.0d;
        NarrowLeadingSpace = Dp.m8830constructorimpl(f3);
        NarrowTrailingSpace = Dp.m8830constructorimpl(f3);
        UniformLeadingSpace = Dp.m8830constructorimpl(f2);
        UniformTrailingSpace = Dp.m8830constructorimpl(f2);
        float f4 = (float) 48.0d;
        WideLeadingSpace = Dp.m8830constructorimpl(f4);
        WideTrailingSpace = Dp.m8830constructorimpl(f4);
    }
}
