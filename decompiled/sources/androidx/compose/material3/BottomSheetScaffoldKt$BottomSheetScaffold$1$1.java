package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class BottomSheetScaffoldKt$BottomSheetScaffold$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetContainerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $sheetDragHandle;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ float $sheetShadowElevation;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ float $sheetTonalElevation;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$BottomSheetScaffold$1$1(BottomSheetScaffoldState bottomSheetScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, float f2, float f3, boolean z, Shape shape, long j, long j2, float f4, float f5, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33) {
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$topBar = function2;
        this.$content = function3;
        this.$sheetPeekHeight = f2;
        this.$sheetMaxWidth = f3;
        this.$sheetSwipeEnabled = z;
        this.$sheetShape = shape;
        this.$sheetContainerColor = j;
        this.$sheetContentColor = j2;
        this.$sheetTonalElevation = f4;
        this.$sheetShadowElevation = f5;
        this.$sheetDragHandle = function22;
        this.$sheetContent = function32;
        this.$snackbarHost = function33;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$1$lambda$0(BottomSheetScaffoldState bottomSheetScaffoldState) {
        return bottomSheetScaffoldState.getBottomSheetState().requireOffset();
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C142@7637L52,146@7946L710,143@7722L49,144@7803L50,140@7554L1117:BottomSheetScaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(999829022, i, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:140)");
        }
        SheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
        Function2<Composer, Integer, Unit> function2 = this.$topBar;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
        final float f2 = this.$sheetPeekHeight;
        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-519581786, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C142@7639L48:BottomSheetScaffold.kt#uh7d8r");
                if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-519581786, i2, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:142)");
                }
                function3.invoke(PaddingKt.m1148PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f2, 7, null), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54);
        final BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
        final float f3 = this.$sheetPeekHeight;
        final float f4 = this.$sheetMaxWidth;
        final boolean z = this.$sheetSwipeEnabled;
        final Shape shape = this.$sheetShape;
        final long j = this.$sheetContainerColor;
        final long j2 = this.$sheetContentColor;
        final float f5 = this.$sheetTonalElevation;
        final float f6 = this.$sheetShadowElevation;
        final Function2<Composer, Integer, Unit> function22 = this.$sheetDragHandle;
        final Function3<ColumnScope, Composer, Integer, Unit> function32 = this.$sheetContent;
        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-815624571, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C147@7968L670:BottomSheetScaffold.kt#uh7d8r");
                if (composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-815624571, i2, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:147)");
                    }
                    BottomSheetScaffoldKt.m2495StandardBottomSheetw7I5h1o(bottomSheetScaffoldState.getBottomSheetState(), f3, f4, z, shape, j, j2, f5, f6, function22, function32, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }, composer, 54);
        final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = this.$snackbarHost;
        final BottomSheetScaffoldState bottomSheetScaffoldState2 = this.$scaffoldState;
        ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1111667356, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1.3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C143@7724L45:BottomSheetScaffold.kt#uh7d8r");
                if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1111667356, i2, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:143)");
                }
                function33.invoke(bottomSheetScaffoldState2.getSnackbarHostState(), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1236975696, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean zChanged = composer.changed(this.$scaffoldState);
        final BottomSheetScaffoldState bottomSheetScaffoldState3 = this.$scaffoldState;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(BottomSheetScaffoldKt$BottomSheetScaffold$1$1.invoke$lambda$1$lambda$0(bottomSheetScaffoldState3));
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        BottomSheetScaffoldKt.BottomSheetScaffoldLayout(function2, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, composableLambdaRememberComposableLambda3, (Function0) objRememberedValue, bottomSheetState, composer, 3504);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
