package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;

/* JADX INFO: compiled from: ContextMenuUi.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$ContextMenuUiKt {
    public static final ComposableSingletons$ContextMenuUiKt INSTANCE = new ComposableSingletons$ContextMenuUiKt();

    /* JADX INFO: renamed from: lambda$-1571120048, reason: not valid java name */
    private static Function8<Modifier, String, Boolean, ContextMenuColors, Function3<? super Color, ? super Composer, ? super Integer, Unit>, Function0<Unit>, Composer, Integer, Unit> f1lambda$1571120048 = ComposableLambdaKt.composableLambdaInstance(-1571120048, false, new Function8() { // from class: androidx.compose.foundation.contextmenu.ComposableSingletons$ContextMenuUiKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function8
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
            return ComposableSingletons$ContextMenuUiKt.lambda__1571120048$lambda$0((Modifier) obj, (String) obj2, ((Boolean) obj3).booleanValue(), (ContextMenuColors) obj4, (Function3) obj5, (Function0) obj6, (Composer) obj7, ((Integer) obj8).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1455401925, reason: not valid java name */
    private static Function3<ContextMenuColors, Composer, Integer, Unit> f0lambda$1455401925 = ComposableLambdaKt.composableLambdaInstance(-1455401925, false, new Function3() { // from class: androidx.compose.foundation.contextmenu.ComposableSingletons$ContextMenuUiKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ContextMenuUiKt.lambda__1455401925$lambda$0((ContextMenuColors) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1455401925$foundation, reason: not valid java name */
    public final Function3<ContextMenuColors, Composer, Integer, Unit> m442getLambda$1455401925$foundation() {
        return f0lambda$1455401925;
    }

    /* JADX INFO: renamed from: getLambda$-1571120048$foundation, reason: not valid java name */
    public final Function8<Modifier, String, Boolean, ContextMenuColors, Function3<? super Color, ? super Composer, ? super Integer, Unit>, Function0<Unit>, Composer, Integer, Unit> m443getLambda$1571120048$foundation() {
        return f1lambda$1571120048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1571120048$lambda$0(Modifier modifier, String str, boolean z, ContextMenuColors contextMenuColors, Function3 function3, Function0 function0, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(modifier,label,enabled,colors,leadingIcon,onClick)136@5002L71:ContextMenuUi.kt#3xeu6s");
        if ((i & 6) == 0) {
            i2 = (composer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composer.changed(str) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composer.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composer.changed(contextMenuColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composer.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i2 |= composer.changedInstance(function0) ? 131072 : 65536;
        }
        if (!composer.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1571120048, i2, -1, "androidx.compose.foundation.contextmenu.ComposableSingletons$ContextMenuUiKt.lambda$-1571120048.<anonymous> (ContextMenuUi.kt:136)");
            }
            ContextMenuUiKt.ContextMenuItem(str, z, contextMenuColors, modifier, function3, function0, composer, ((i2 >> 3) & 1022) | ((i2 << 9) & 7168) | (57344 & i2) | (i2 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1455401925$lambda$0(ContextMenuColors contextMenuColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(colors)305@11326L290:ContextMenuUi.kt#3xeu6s");
        if ((i & 6) == 0) {
            i |= composer.changed(contextMenuColors) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1455401925, i, -1, "androidx.compose.foundation.contextmenu.ComposableSingletons$ContextMenuUiKt.lambda$-1455401925.<anonymous> (ContextMenuUi.kt:305)");
            }
            BoxKt.Box(BackgroundKt.m313backgroundbw27NRU$default(SizeKt.m1207height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m1153paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, ContextMenuSpec.INSTANCE.m455getDividerVerticalPaddingD9Ej5fM(), 1, null), 0.0f, 1, null), ContextMenuSpec.INSTANCE.m454getDividerHeightD9Ej5fM()), contextMenuColors.getIconColor(), null, 2, null), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
