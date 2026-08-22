package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/RichTooltipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "titleContentColor", "actionContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getActionContentColor-0d7_KjU", Constants.COPY_TYPE, "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RichTooltipColors;", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RichTooltipColors {
    public static final int $stable = 0;
    private final long actionContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long titleContentColor;

    public /* synthetic */ RichTooltipColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private RichTooltipColors(long j, long j2, long j3, long j4) {
        this.containerColor = j;
        this.contentColor = j2;
        this.titleContentColor = j3;
        this.actionContentColor = j4;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTitleContentColor() {
        return this.titleContentColor;
    }

    /* JADX INFO: renamed from: getActionContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getActionContentColor() {
        return this.actionContentColor;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo$default, reason: not valid java name */
    public static /* synthetic */ RichTooltipColors m3306copyjRlVdoo$default(RichTooltipColors richTooltipColors, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = richTooltipColors.containerColor;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = richTooltipColors.contentColor;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = richTooltipColors.titleContentColor;
        }
        return richTooltipColors.m3307copyjRlVdoo(j5, j6, j3, (i & 8) != 0 ? richTooltipColors.actionContentColor : j4);
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final RichTooltipColors m3307copyjRlVdoo(long containerColor, long contentColor, long titleContentColor, long actionContentColor) {
        return new RichTooltipColors(containerColor != 16 ? containerColor : this.containerColor, contentColor != 16 ? contentColor : this.contentColor, titleContentColor != 16 ? titleContentColor : this.titleContentColor, actionContentColor != 16 ? actionContentColor : this.actionContentColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RichTooltipColors)) {
            return false;
        }
        RichTooltipColors richTooltipColors = (RichTooltipColors) other;
        return Color.m5969equalsimpl0(this.containerColor, richTooltipColors.containerColor) && Color.m5969equalsimpl0(this.contentColor, richTooltipColors.contentColor) && Color.m5969equalsimpl0(this.titleContentColor, richTooltipColors.titleContentColor) && Color.m5969equalsimpl0(this.actionContentColor, richTooltipColors.actionContentColor);
    }

    public int hashCode() {
        return (((((Color.m5975hashCodeimpl(this.containerColor) * 31) + Color.m5975hashCodeimpl(this.contentColor)) * 31) + Color.m5975hashCodeimpl(this.titleContentColor)) * 31) + Color.m5975hashCodeimpl(this.actionContentColor);
    }
}
