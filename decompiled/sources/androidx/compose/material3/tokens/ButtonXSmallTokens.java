package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: ButtonXSmallTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/tokens/ButtonXSmallTokens;", "", "<init>", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", "F", "ContainerShapeRound", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShapeRound", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerShapeSquare", "getContainerShapeSquare", "IconLabelSpace", "getIconLabelSpace-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "LeadingSpace", "getLeadingSpace-D9Ej5fM", "OutlinedOutlineWidth", "getOutlinedOutlineWidth-D9Ej5fM", "PressedContainerShape", "getPressedContainerShape", "SelectedContainerShapeRound", "getSelectedContainerShapeRound", "SelectedContainerShapeSquare", "getSelectedContainerShapeSquare", "TrailingSpace", "getTrailingSpace-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonXSmallTokens {
    public static final int $stable = 0;
    private static final float LeadingSpace;
    private static final float TrailingSpace;
    public static final ButtonXSmallTokens INSTANCE = new ButtonXSmallTokens();
    private static final float ContainerHeight = Dp.m8830constructorimpl((float) 32.0d);
    private static final ShapeKeyTokens ContainerShapeRound = ShapeKeyTokens.CornerFull;
    private static final ShapeKeyTokens ContainerShapeSquare = ShapeKeyTokens.CornerMedium;
    private static final float IconLabelSpace = Dp.m8830constructorimpl((float) 8.0d);
    private static final float IconSize = Dp.m8830constructorimpl((float) 20.0d);
    private static final float OutlinedOutlineWidth = Dp.m8830constructorimpl((float) 1.0d);
    private static final ShapeKeyTokens PressedContainerShape = ShapeKeyTokens.CornerSmall;
    private static final ShapeKeyTokens SelectedContainerShapeRound = ShapeKeyTokens.CornerFull;
    private static final ShapeKeyTokens SelectedContainerShapeSquare = ShapeKeyTokens.CornerMedium;

    private ButtonXSmallTokens() {
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m4240getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShapeRound() {
        return ContainerShapeRound;
    }

    public final ShapeKeyTokens getContainerShapeSquare() {
        return ContainerShapeSquare;
    }

    /* JADX INFO: renamed from: getIconLabelSpace-D9Ej5fM, reason: not valid java name */
    public final float m4241getIconLabelSpaceD9Ej5fM() {
        return IconLabelSpace;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4242getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4243getLeadingSpaceD9Ej5fM() {
        return LeadingSpace;
    }

    /* JADX INFO: renamed from: getOutlinedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m4244getOutlinedOutlineWidthD9Ej5fM() {
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

    /* JADX INFO: renamed from: getTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4245getTrailingSpaceD9Ej5fM() {
        return TrailingSpace;
    }

    static {
        float f2 = (float) 16.0d;
        LeadingSpace = Dp.m8830constructorimpl(f2);
        TrailingSpace = Dp.m8830constructorimpl(f2);
    }
}
