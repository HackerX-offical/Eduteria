package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AnimatedVisibility.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aa\u0010\u0000\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0019\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001am\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001d\u001ak\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010 \u001a\u0091\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010'\u001a9\u0010+\u001a\u00020$\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010,\u001a\u0002H\u001bH\u0003¢\u0006\u0002\u0010-\"\u001e\u0010(\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020$0\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006.²\u0006\u001c\u0010/\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"AnimatedVisibility", "", "visible", "", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "transition", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AnimatedEnterExitImpl", "shouldDisposeBlock", "Lkotlin/Function2;", "Landroidx/compose/animation/EnterExitState;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exitFinished", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AnimatedVisibilityKt {
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AnimatedVisibility(boolean r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, final kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AnimatedVisibility(final androidx.compose.foundation.layout.RowScope r23, final boolean r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, final kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AnimatedVisibility(final androidx.compose.foundation.layout.ColumnScope r23, final boolean r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, final kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, boolean, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AnimatedVisibility(final androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r23, androidx.compose.ui.Modifier r24, androidx.compose.animation.EnterTransition r25, androidx.compose.animation.ExitTransition r26, java.lang.String r27, final kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AnimatedVisibility(final androidx.compose.foundation.layout.RowScope r23, final androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, final kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.RowScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AnimatedVisibility(final androidx.compose.foundation.layout.ColumnScope r23, final androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r24, androidx.compose.ui.Modifier r25, androidx.compose.animation.EnterTransition r26, androidx.compose.animation.ExitTransition r27, java.lang.String r28, final kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.foundation.layout.ColumnScope, androidx.compose.animation.core.MutableTransitionState, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> void AnimatedVisibility(final androidx.compose.animation.core.Transition<T> r21, final kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r22, androidx.compose.ui.Modifier r23, androidx.compose.animation.EnterTransition r24, androidx.compose.animation.ExitTransition r25, final kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final <T> void AnimatedVisibilityImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        ExitTransition exitTransition2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1706321816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibilityImpl)N(transition,visible,modifier,enter,exit,content)683@38862L423,695@39360L62,679@38732L724:AnimatedVisibility.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(enterTransition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            exitTransition2 = exitTransition;
            i2 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
        } else {
            exitTransition2 = exitTransition;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1706321816, i2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:678)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -902229601, "CC(remember):AnimatedVisibility.kt#9igjgp");
            int i3 = i2 & 112;
            int i4 = i2 & 14;
            boolean z = (i3 == 32) | (i4 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m75invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m75invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        long jM8996constructorimpl;
                        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(j);
                        if (measureScope.isLookingAhead() && !function1.invoke((T) transition.getTargetState()).booleanValue()) {
                            jM8996constructorimpl = IntSize.INSTANCE.m9006getZeroYbymL2g();
                        } else {
                            jM8996constructorimpl = IntSize.m8996constructorimpl((((long) placeableMo7445measureBRTryo0.getWidth()) << 32) | (((long) placeableMo7445measureBRTryo0.getHeight()) & 4294967295L));
                        }
                        return MeasureScope.layout$default(measureScope, (int) (jM8996constructorimpl >> 32), (int) (jM8996constructorimpl & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.place$default(placementScope, placeableMo7445measureBRTryo0, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayout = LayoutModifierKt.layout(modifier, (Function3) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -902214026, "CC(remember):AnimatedVisibility.kt#9igjgp");
            AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1 animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue = new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                        return Boolean.valueOf(enterExitState == enterExitState2 && enterExitState2 == EnterExitState.PostExit);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnimatedEnterExitImpl(transition, function1, modifierLayout, enterTransition, exitTransition2, (Function2) animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue, null, function3, composerStartRestartGroup, i3 | 196608 | i4 | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibilityImpl.3
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

                public final void invoke(Composer composer2, int i5) {
                    AnimatedVisibilityKt.AnimatedVisibilityImpl(transition, function1, modifier, enterTransition, exitTransition, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final <T> void AnimatedEnterExitImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function2<? super EnterExitState, ? super EnterExitState, Boolean> function2, OnLookaheadMeasured onLookaheadMeasured, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        final OnLookaheadMeasured onLookaheadMeasured2;
        int i4;
        Modifier.Companion companionLayout;
        OnLookaheadMeasured onLookaheadMeasured3 = onLookaheadMeasured;
        Composer composerStartRestartGroup = composer.startRestartGroup(1912839215);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedEnterExitImpl)N(transition,visible,modifier,enter,exit,shouldDisposeBlock,onLookaheadMeasured,content):AnimatedVisibility.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(enterTransition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(exitTransition) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        int i5 = i2 & 64;
        int i6 = 1572864;
        if (i5 != 0) {
            i3 |= i6;
        } else if ((1572864 & i) == 0) {
            i6 = (i & 2097152) == 0 ? composerStartRestartGroup.changed(onLookaheadMeasured3) : composerStartRestartGroup.changedInstance(onLookaheadMeasured3) ? 1048576 : 524288;
            i3 |= i6;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i7 = i3;
        boolean z = true;
        if (!composerStartRestartGroup.shouldExecute((4793491 & i7) != 4793490, i7 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                onLookaheadMeasured3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1912839215, i7, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:716)");
            }
            if (function1.invoke(transition.getTargetState()).booleanValue() || function1.invoke(transition.getCurrentState()).booleanValue() || transition.isSeeking() || transition.getHasInitialValueAnimations()) {
                composerStartRestartGroup.startReplaceGroup(-232386135);
                ComposerKt.sourceInformation(composerStartRestartGroup, "724@40266L124,734@40987L23,735@41052L21,737@41116L40,743@41365L529,740@41208L686");
                int i8 = i7 & 14;
                int i9 = i8 | 48;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -539313577, "CC(createChildTransition)N(label,transformToChildState)1788@75927L36,1789@75987L74,1790@76084L39,1791@76135L63:Transition.kt#pdpnli");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1410701659, "CC(remember):Transition.kt#9igjgp");
                int i10 = i9 & 14;
                boolean z2 = ((i10 ^ 6) > 4 && composerStartRestartGroup.changed(transition)) || (i9 & 6) == 4;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = transition.getCurrentState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (transition.isSeeking()) {
                    objRememberedValue = transition.getCurrentState();
                }
                composerStartRestartGroup.startReplaceGroup(1844425648);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it)725@40348L28:AnimatedVisibility.kt#xbi5r1");
                onLookaheadMeasured2 = onLookaheadMeasured3;
                if (ComposerKt.isTraceInProgress()) {
                    i4 = i8;
                    ComposerKt.traceEventStart(1844425648, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:725)");
                } else {
                    i4 = i8;
                }
                int i11 = i7 & 126;
                EnterExitState enterExitStateTargetEnterExit = targetEnterExit(transition, function1, objRememberedValue, composerStartRestartGroup, i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                T targetState = transition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(1844425648);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it)725@40348L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1844425648, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:725)");
                }
                EnterExitState enterExitStateTargetEnterExit2 = targetEnterExit(transition, function1, targetState, composerStartRestartGroup, i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                int i12 = i4;
                Transition transitionCreateChildTransitionInternal = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, enterExitStateTargetEnterExit, enterExitStateTargetEnterExit2, "EnterExitTransition", composerStartRestartGroup, i10 | 3072);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransitionTrackActiveEnter = EnterExitTransitionKt.trackActiveEnter(transitionCreateChildTransitionInternal, enterTransition, composerStartRestartGroup, (i7 >> 6) & 112);
                ExitTransition exitTransitionTrackActiveExit = EnterExitTransitionKt.trackActiveExit(transitionCreateChildTransitionInternal, exitTransition, composerStartRestartGroup, (i7 >> 9) & 112);
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 15) & 14);
                Boolean boolInvoke = function2.invoke(transitionCreateChildTransitionInternal.getCurrentState(), transitionCreateChildTransitionInternal.getTargetState());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7462016, "CC(remember):AnimatedVisibility.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(transitionCreateChildTransitionInternal) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(transitionCreateChildTransitionInternal, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                State stateProduceState = SnapshotStateKt.produceState(boolInvoke, (Function2) animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue, composerStartRestartGroup, 0);
                if (!getExitFinished(transitionCreateChildTransitionInternal) || !AnimatedEnterExitImpl$lambda$3(stateProduceState)) {
                    composerStartRestartGroup.startReplaceGroup(-230699766);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "759@41992L69,765@42260L248,784@43276L50,760@42074L1267");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7442412, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    boolean z3 = i12 == 4;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new AnimatedVisibilityScopeImpl(transitionCreateChildTransitionInternal);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierCreateModifier = EnterExitTransitionKt.createModifier(transitionCreateChildTransitionInternal, enterTransitionTrackActiveEnter, exitTransitionTrackActiveExit, false, null, "Built-in", composerStartRestartGroup, 199680, 8);
                    composer2 = composerStartRestartGroup;
                    if (onLookaheadMeasured2 != null) {
                        composer2.startReplaceGroup(-230087268);
                        ComposerKt.sourceInformation(composer2, "773@42663L479");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -7420530, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if ((3670016 & i7) != 1048576 && ((i7 & 2097152) == 0 || !composer2.changedInstance(onLookaheadMeasured2))) {
                            z = false;
                        }
                        Object objRememberedValue3 = composer2.rememberedValue();
                        if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                    return m74invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                }

                                /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                public final MeasureResult m74invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                    final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(j);
                                    OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured2;
                                    if (measureScope.isLookingAhead()) {
                                        onLookaheadMeasured4.m140invokeozmzZPI(IntSize.m8996constructorimpl((((long) placeableMo7445measureBRTryo0.getWidth()) << 32) | (((long) placeableMo7445measureBRTryo0.getHeight()) & 4294967295L)));
                                    }
                                    return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                            Placeable.PlacementScope.place$default(placementScope, placeableMo7445measureBRTryo0, 0, 0, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        companionLayout = LayoutModifierKt.layout(companion, (Function3) objRememberedValue3);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-7404393);
                        composer2.endReplaceGroup();
                        companionLayout = Modifier.INSTANCE;
                    }
                    Modifier modifierThen = modifier.then(modifierCreateModifier.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart(composer2, -7401343, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierThen);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    onLookaheadMeasured2 = onLookaheadMeasured2;
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer2);
                    Updater.m5077setimpl(composerM5069constructorimpl, animatedEnterExitMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m5073initimpl(composerM5069constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m5075reconcileimpl(composerM5069constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -1766274760, "C761@42116L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(animatedVisibilityScopeImpl, composer2, Integer.valueOf((i7 >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-229368781);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-229362829);
                composerStartRestartGroup.endReplaceGroup();
                onLookaheadMeasured2 = onLookaheadMeasured3;
                composer2 = composerStartRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onLookaheadMeasured3 = onLookaheadMeasured2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i13) {
                    AnimatedVisibilityKt.AnimatedEnterExitImpl(transition, function1, modifier, enterTransition, exitTransition, function2, onLookaheadMeasured4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        return transition.getCurrentState() == EnterExitState.PostExit && transition.getTargetState() == EnterExitState.PostExit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer composer, int i) {
        EnterExitState enterExitState;
        ComposerKt.sourceInformationMarkerStart(composer, 361571134, "C(targetEnterExit)N(visible,targetState):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:848)");
        }
        composer.startMovableGroup(-422486745, transition);
        ComposerKt.sourceInformation(composer, "");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(-212166497);
            composer.endReplaceGroup();
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else {
            composer.startReplaceGroup(-211892364);
            ComposerKt.sourceInformation(composer, "860@45819L34");
            ComposerKt.sourceInformationMarkerStart(composer, -422476640, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(true);
            }
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
            composer.endReplaceGroup();
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterExitState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$1(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
