package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LookaheadAnimationVisualDebugHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aT\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"colorIndex", "", "keyToColor", "Landroidx/collection/MutableScatterMap;", "", "Landroidx/compose/ui/graphics/Color;", "LookaheadAnimationVisualDebugging", "", "isEnabled", "", "overlayColor", "multipleMatchesColor", "unmatchedElementColor", "isShowKeyLabelEnabled", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "LookaheadAnimationVisualDebugging-gUzqikQ", "(ZJJJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "CustomizedLookaheadAnimationVisualDebugging", "debugColor", "CustomizedLookaheadAnimationVisualDebugging-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "animation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LookaheadAnimationVisualDebugHelperKt {
    private static int colorIndex;
    private static final MutableScatterMap<Object, Color> keyToColor = new MutableScatterMap<>(0, 1, null);

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: LookaheadAnimationVisualDebugging-gUzqikQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m139LookaheadAnimationVisualDebugginggUzqikQ(boolean r29, long r30, long r32, long r34, boolean r36, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt.m139LookaheadAnimationVisualDebugginggUzqikQ(boolean, long, long, long, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: CustomizedLookaheadAnimationVisualDebugging-Iv8Zu3U, reason: not valid java name */
    public static final void m138CustomizedLookaheadAnimationVisualDebuggingIv8Zu3U(final long j, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1657127863);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomizedLookaheadAnimationVisualDebugging)N(debugColor:c#ui.graphics.Color,content)592@22107L129:LookaheadAnimationVisualDebugHelper.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1657127863, i2, -1, "androidx.compose.animation.CustomizedLookaheadAnimationVisualDebugging (LookaheadAnimationVisualDebugHelper.kt:591)");
            }
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLookaheadAnimationVisualDebugColor().provides(Color.m5958boximpl(j)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.LookaheadAnimationVisualDebugHelperKt$CustomizedLookaheadAnimationVisualDebugging$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    LookaheadAnimationVisualDebugHelperKt.m138CustomizedLookaheadAnimationVisualDebuggingIv8Zu3U(j, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
