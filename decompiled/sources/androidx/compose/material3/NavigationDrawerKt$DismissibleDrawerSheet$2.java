package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class NavigationDrawerKt$DismissibleDrawerSheet$2 implements Function3<DrawerPredictiveBackState, Composer, Integer, Unit> {
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerContainerColor;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $drawerTonalElevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX WARN: Multi-variable type inference failed */
    NavigationDrawerKt$DismissibleDrawerSheet$2(WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f2, DrawerState drawerState, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        this.$windowInsets = windowInsets;
        this.$modifier = modifier;
        this.$drawerShape = shape;
        this.$drawerContainerColor = j;
        this.$drawerContentColor = j2;
        this.$drawerTonalElevation = f2;
        this.$drawerState = drawerState;
        this.$content = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(DrawerPredictiveBackState drawerPredictiveBackState, Composer composer, Integer num) {
        invoke(drawerPredictiveBackState, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DrawerPredictiveBackState drawerPredictiveBackState, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(drawerPredictiveBackState)740@31877L45,732@31490L474:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(drawerPredictiveBackState) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1623455535, i2, -1, "androidx.compose.material3.DismissibleDrawerSheet.<anonymous> (NavigationDrawer.kt:732)");
        }
        WindowInsets windowInsets = this.$windowInsets;
        Modifier modifier = this.$modifier;
        Shape shape = this.$drawerShape;
        long j = this.$drawerContainerColor;
        long j2 = this.$drawerContentColor;
        float f2 = this.$drawerTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 1067654364, "CC(remember):NavigationDrawer.kt#9igjgp");
        boolean zChanged = composer.changed(this.$drawerState);
        final DrawerState drawerState = this.$drawerState;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$2$$ExternalSyntheticLambda0
                @Override // androidx.compose.material3.internal.FloatProducer
                public final float invoke() {
                    return NavigationDrawerKt$DismissibleDrawerSheet$2.invoke$lambda$1$lambda$0(drawerState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        NavigationDrawerKt.m3165DrawerSheetcm3T3N0(drawerPredictiveBackState, windowInsets, modifier, shape, j, j2, f2, (FloatProducer) objRememberedValue, this.$content, composer, i2 & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$1$lambda$0(DrawerState drawerState) {
        return drawerState.getAnchoredDraggableState$material3().getOffset();
    }
}
