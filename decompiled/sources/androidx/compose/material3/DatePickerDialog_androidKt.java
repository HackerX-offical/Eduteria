package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* JADX INFO: compiled from: DatePickerDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0097\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0019\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001c"}, d2 = {"DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "colors", "Landroidx/compose/material3/DatePickerColors;", JivePropertiesExtension.ELEMENT, "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DialogButtonsMainAxisSpacing", "F", "DialogButtonsCrossAxisSpacing", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DatePickerDialog_androidKt {
    private static final float DialogButtonsCrossAxisSpacing = Dp.m8830constructorimpl(12);
    private static final float DialogButtonsMainAxisSpacing;
    private static final PaddingValues DialogButtonsPadding;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerDialog_GmEhDVc$lambda$0(Function0 function0, Function2 function2, Modifier modifier, Function2 function22, Shape shape, float f2, DatePickerColors datePickerColors, DialogProperties dialogProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2753DatePickerDialogGmEhDVc(function0, function2, modifier, function22, shape, f2, datePickerColors, dialogProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    /* JADX INFO: renamed from: DatePickerDialog-GmEhDVc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2753DatePickerDialogGmEhDVc(final kotlin.jvm.functions.Function0<kotlin.Unit> r20, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.ui.graphics.Shape r24, float r25, androidx.compose.material3.DatePickerColors r26, androidx.compose.ui.window.DialogProperties r27, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDialog_androidKt.m2753DatePickerDialogGmEhDVc(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, float, androidx.compose.material3.DatePickerColors, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f2 = 8;
        DialogButtonsPadding = PaddingKt.m1148PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m8830constructorimpl(6), Dp.m8830constructorimpl(f2), 3, null);
        DialogButtonsMainAxisSpacing = Dp.m8830constructorimpl(f2);
    }
}
