package androidx.compose.material3.carousel;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Carousel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class CarouselKt$Carousel$2 implements Function4<PagerScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ Function4<CarouselItemScope, Integer, Composer, Integer, Unit> $content;
    final /* synthetic */ CarouselPageSize $pageSize;
    final /* synthetic */ CarouselState $state;

    /* JADX WARN: Multi-variable type inference failed */
    CarouselKt$Carousel$2(CarouselState carouselState, CarouselPageSize carouselPageSize, Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        this.$state = carouselState;
        this.$pageSize = carouselPageSize;
        this.$content = function4;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer, Integer num2) {
        invoke(pagerScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PagerScope pagerScope, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(page)401@18647L39,402@18711L63,403@18803L390,420@19394L21,415@19207L409:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1817116752, i2, -1, "androidx.compose.material3.carousel.Carousel.<anonymous> (Carousel.kt:401)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1802492279, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new CarouselItemDrawInfoImpl();
            composer.updateRememberedValue(objRememberedValue);
        }
        final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl = (CarouselItemDrawInfoImpl) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1802494351, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new CarouselItemScopeImpl(carouselItemDrawInfoImpl);
            composer.updateRememberedValue(objRememberedValue2);
        }
        CarouselItemScopeImpl carouselItemScopeImpl = (CarouselItemScopeImpl) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1802497622, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Shape() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$2$clipShape$1$1
                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo382createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                    return new Outline.Rectangle(carouselItemDrawInfoImpl.getMaskRect());
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        CarouselKt$Carousel$2$clipShape$1$1 carouselKt$Carousel$2$clipShape$1$1 = (CarouselKt$Carousel$2$clipShape$1$1) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier.Companion companion = Modifier.INSTANCE;
        CarouselState carouselState = this.$state;
        ComposerKt.sourceInformationMarkerStart(composer, 1802516165, "CC(remember):Carousel.kt#9igjgp");
        boolean zChanged = composer.changed(this.$pageSize);
        final CarouselPageSize carouselPageSize = this.$pageSize;
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return carouselPageSize.getStrategy();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierCarouselItem = CarouselKt.carouselItem(companion, i, carouselState, (Function0) objRememberedValue4, carouselItemDrawInfoImpl, carouselKt$Carousel$2$clipShape$1$1);
        Function4<CarouselItemScope, Integer, Composer, Integer, Unit> function4 = this.$content;
        ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierCarouselItem);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer);
        Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -868976154, "C425@19589L13:Carousel.kt#dcf9yb");
        function4.invoke(carouselItemScopeImpl, Integer.valueOf(i), composer, Integer.valueOf(i2 & 112));
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
