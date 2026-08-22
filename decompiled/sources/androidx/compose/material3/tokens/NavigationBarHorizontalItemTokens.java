package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: NavigationBarHorizontalItemTokens.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/tokens/NavigationBarHorizontalItemTokens;", "", "<init>", "()V", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", "F", "ActiveIndicatorLeadingSpace", "getActiveIndicatorLeadingSpace-D9Ej5fM", "ActiveIndicatorTrailingSpace", "getActiveIndicatorTrailingSpace-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarHorizontalItemTokens {
    public static final int $stable = 0;
    private static final float ActiveIndicatorLeadingSpace;
    private static final float ActiveIndicatorTrailingSpace;
    public static final NavigationBarHorizontalItemTokens INSTANCE = new NavigationBarHorizontalItemTokens();
    private static final float ActiveIndicatorHeight = Dp.m8830constructorimpl((float) 40.0d);
    private static final float IconSize = Dp.m8830constructorimpl((float) 24.0d);

    private NavigationBarHorizontalItemTokens() {
    }

    /* JADX INFO: renamed from: getActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m4597getActiveIndicatorHeightD9Ej5fM() {
        return ActiveIndicatorHeight;
    }

    /* JADX INFO: renamed from: getActiveIndicatorLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4598getActiveIndicatorLeadingSpaceD9Ej5fM() {
        return ActiveIndicatorLeadingSpace;
    }

    /* JADX INFO: renamed from: getActiveIndicatorTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m4599getActiveIndicatorTrailingSpaceD9Ej5fM() {
        return ActiveIndicatorTrailingSpace;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4600getIconSizeD9Ej5fM() {
        return IconSize;
    }

    static {
        float f2 = (float) 16.0d;
        ActiveIndicatorLeadingSpace = Dp.m8830constructorimpl(f2);
        ActiveIndicatorTrailingSpace = Dp.m8830constructorimpl(f2);
    }
}
