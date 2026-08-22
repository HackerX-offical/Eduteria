package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TimePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/TimePickerDialogDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeightForTimePicker", "Landroidx/compose/ui/unit/Dp;", "getMinHeightForTimePicker-D9Ej5fM", "()F", "F", "DisplayModeToggle", "", "onDisplayModeChange", "Lkotlin/Function0;", "displayMode", "Landroidx/compose/material3/TimePickerDisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "DisplayModeToggle-S7Bxtbk", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Title", "Title-pK_nZyw", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDialogDefaults {
    public static final int $stable = 0;
    public static final TimePickerDialogDefaults INSTANCE = new TimePickerDialogDefaults();
    private static final float MinHeightForTimePicker = Dp.m8830constructorimpl(300);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggle_S7Bxtbk$lambda$0(TimePickerDialogDefaults timePickerDialogDefaults, Function0 function0, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        timePickerDialogDefaults.m3729DisplayModeToggleS7Bxtbk(function0, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Title_pK_nZyw$lambda$1(TimePickerDialogDefaults timePickerDialogDefaults, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        timePickerDialogDefaults.m3730TitlepK_nZyw(i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private TimePickerDialogDefaults() {
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -443775449, "C(<get-containerColor>)242@10289L5:TimePickerDialog.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-443775449, i, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-containerColor> (TimePickerDialog.kt:242)");
        }
        long value = ColorSchemeKt.getValue(DialogTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1241096723, "C(<get-shape>)246@10412L5:TimePickerDialog.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1241096723, i, -1, "androidx.compose.material3.TimePickerDialogDefaults.<get-shape> (TimePickerDialog.kt:246)");
        }
        Shape value = ShapesKt.getValue(DialogTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getMinHeightForTimePicker-D9Ej5fM, reason: not valid java name */
    public final float m3731getMinHeightForTimePickerD9Ej5fM() {
        return MinHeightForTimePicker;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DisplayModeToggle-S7Bxtbk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3729DisplayModeToggleS7Bxtbk(final kotlin.jvm.functions.Function0<kotlin.Unit> r17, final int r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerDialogDefaults.m3729DisplayModeToggleS7Bxtbk(kotlin.jvm.functions.Function0, int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Title-pK_nZyw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3730TitlepK_nZyw(final int r30, androidx.compose.ui.Modifier r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerDialogDefaults.m3730TitlepK_nZyw(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
