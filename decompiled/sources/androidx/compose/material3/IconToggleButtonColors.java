package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: IconButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJI\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001c\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Landroidx/compose/material3/IconToggleButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "getCheckedContainerColor-0d7_KjU", "getCheckedContentColor-0d7_KjU", Constants.COPY_TYPE, "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/IconToggleButtonColors;", "Landroidx/compose/runtime/State;", StreamManagement.Enabled.ELEMENT, "", "checked", "containerColor$material3", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IconToggleButtonColors {
    public static final int $stable = 0;
    private final long checkedContainerColor;
    private final long checkedContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ IconToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private IconToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.containerColor = j;
        this.contentColor = j2;
        this.disabledContainerColor = j3;
        this.disabledContentColor = j4;
        this.checkedContainerColor = j5;
        this.checkedContentColor = j6;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContentColor() {
        return this.disabledContentColor;
    }

    /* JADX INFO: renamed from: getCheckedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedContainerColor() {
        return this.checkedContainerColor;
    }

    /* JADX INFO: renamed from: getCheckedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedContentColor() {
        return this.checkedContentColor;
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ$default, reason: not valid java name */
    public static /* synthetic */ IconToggleButtonColors m2999copytNS2XkQ$default(IconToggleButtonColors iconToggleButtonColors, long j, long j2, long j3, long j4, long j5, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            j = iconToggleButtonColors.containerColor;
        }
        return iconToggleButtonColors.m3000copytNS2XkQ(j, (i & 2) != 0 ? iconToggleButtonColors.contentColor : j2, (i & 4) != 0 ? iconToggleButtonColors.disabledContainerColor : j3, (i & 8) != 0 ? iconToggleButtonColors.disabledContentColor : j4, (i & 16) != 0 ? iconToggleButtonColors.checkedContainerColor : j5, (i & 32) != 0 ? iconToggleButtonColors.checkedContentColor : j6);
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final IconToggleButtonColors m3000copytNS2XkQ(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor) {
        return new IconToggleButtonColors(containerColor != 16 ? containerColor : this.containerColor, contentColor != 16 ? contentColor : this.contentColor, disabledContainerColor != 16 ? disabledContainerColor : this.disabledContainerColor, disabledContentColor != 16 ? disabledContentColor : this.disabledContentColor, checkedContainerColor != 16 ? checkedContainerColor : this.checkedContainerColor, checkedContentColor != 16 ? checkedContentColor : this.checkedContentColor, null);
    }

    public final State<Color> containerColor$material3(boolean z, boolean z2, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, 1175394478, "C(containerColor)N(enabled,checked)889@39444L28:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1175394478, i, -1, "androidx.compose.material3.IconToggleButtonColors.containerColor (IconButton.kt:882)");
        }
        if (!z) {
            j = this.disabledContainerColor;
        } else if (!z2) {
            j = this.containerColor;
        } else {
            j = this.checkedContainerColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m5958boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateRememberUpdatedState;
    }

    public final State<Color> contentColor$material3(boolean z, boolean z2, Composer composer, int i) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, 1340854054, "C(contentColor)N(enabled,checked)906@40014L28:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1340854054, i, -1, "androidx.compose.material3.IconToggleButtonColors.contentColor (IconButton.kt:899)");
        }
        if (!z) {
            j = this.disabledContentColor;
        } else if (!z2) {
            j = this.contentColor;
        } else {
            j = this.checkedContentColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m5958boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateRememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof IconToggleButtonColors)) {
            return false;
        }
        IconToggleButtonColors iconToggleButtonColors = (IconToggleButtonColors) other;
        return Color.m5969equalsimpl0(this.containerColor, iconToggleButtonColors.containerColor) && Color.m5969equalsimpl0(this.contentColor, iconToggleButtonColors.contentColor) && Color.m5969equalsimpl0(this.disabledContainerColor, iconToggleButtonColors.disabledContainerColor) && Color.m5969equalsimpl0(this.disabledContentColor, iconToggleButtonColors.disabledContentColor) && Color.m5969equalsimpl0(this.checkedContainerColor, iconToggleButtonColors.checkedContainerColor) && Color.m5969equalsimpl0(this.checkedContentColor, iconToggleButtonColors.checkedContentColor);
    }

    public int hashCode() {
        return (((((((((Color.m5975hashCodeimpl(this.containerColor) * 31) + Color.m5975hashCodeimpl(this.contentColor)) * 31) + Color.m5975hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m5975hashCodeimpl(this.disabledContentColor)) * 31) + Color.m5975hashCodeimpl(this.checkedContainerColor)) * 31) + Color.m5975hashCodeimpl(this.checkedContentColor);
    }
}
