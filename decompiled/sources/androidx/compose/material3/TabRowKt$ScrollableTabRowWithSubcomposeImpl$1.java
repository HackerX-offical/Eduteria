package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class TabRowKt$ScrollableTabRowWithSubcomposeImpl$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX WARN: Multi-variable type inference failed */
    TabRowKt$ScrollableTabRowWithSubcomposeImpl$1(ScrollState scrollState, float f2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i) {
        this.$scrollState = scrollState;
        this.$edgePadding = f2;
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
        this.$selectedTabIndex = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C836@36657L24,838@36829L14,840@36888L263,853@37402L3390,847@37160L3632:TabRow.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2077251399, i, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:836)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683737348, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, -921189554, "CC(remember):TabRow.kt#9igjgp");
        boolean zChanged = composer.changed(this.$scrollState) | composer.changed(coroutineScope);
        ScrollState scrollState = this.$scrollState;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ScrollableTabData(scrollState, coroutineScope, finiteAnimationSpecValue);
            composer.updateRememberedValue(objRememberedValue2);
        }
        final ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), this.$scrollState, false, null, false, 14, null)));
        ComposerKt.sourceInformationMarkerStart(composer, -921169979, "CC(remember):TabRow.kt#9igjgp");
        boolean zChanged2 = composer.changed(this.$edgePadding) | composer.changed(this.$tabs) | composer.changed(this.$divider) | composer.changed(this.$indicator) | composer.changedInstance(scrollableTabData) | composer.changed(this.$selectedTabIndex);
        final float f2 = this.$edgePadding;
        final Function2<Composer, Integer, Unit> function2 = this.$tabs;
        final Function2<Composer, Integer, Unit> function22 = this.$divider;
        final int i2 = this.$selectedTabIndex;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function2() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TabRowKt$ScrollableTabRowWithSubcomposeImpl$1.invoke$lambda$9$lambda$8(f2, function2, function22, scrollableTabData, i2, function3, (SubcomposeMeasureScope) obj2, (Constraints) obj3);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue3 = obj;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, (Function2) objRememberedValue3, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult invoke$lambda$9$lambda$8(float f2, Function2 function2, final Function2 function22, final ScrollableTabData scrollableTabData, final int i, final Function3 function3, final SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        int i2 = subcomposeMeasureScope.mo482roundToPx0680j_4(TabRowDefaults.INSTANCE.m3583getScrollableTabRowMinTabWidthD9Ej5fM());
        final int i3 = subcomposeMeasureScope.mo482roundToPx0680j_4(f2);
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
        int iValueOf = 0;
        List<Measurable> list = listSubcompose;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            iValueOf = Integer.valueOf(Math.max(iValueOf.intValue(), listSubcompose.get(i4).maxIntrinsicHeight(Integer.MAX_VALUE)));
        }
        final int iIntValue = iValueOf.intValue();
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(constraints.getValue(), i2, 0, iIntValue, iIntValue, 2, null);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int size2 = list.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Measurable measurable = listSubcompose.get(i5);
            Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(jM8773copyZbe2FdA$default);
            float fM8830constructorimpl = Dp.m8830constructorimpl(subcomposeMeasureScope.mo485toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(placeableMo7445measureBRTryo0.getHeight()), placeableMo7445measureBRTryo0.getWidth())) - Dp.m8830constructorimpl(TabKt.getHorizontalTextPadding() * 2));
            arrayList.add(placeableMo7445measureBRTryo0);
            arrayList2.add(Dp.m8828boximpl(fM8830constructorimpl));
        }
        Integer numValueOf = Integer.valueOf(i3 * 2);
        int size3 = arrayList.size();
        for (int i6 = 0; i6 < size3; i6++) {
            numValueOf = Integer.valueOf(numValueOf.intValue() + ((Placeable) arrayList.get(i6)).getWidth());
        }
        final int iIntValue2 = numValueOf.intValue();
        return MeasureScope.layout$default(subcomposeMeasureScope, iIntValue2, iIntValue, null, new Function1() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt$ScrollableTabRowWithSubcomposeImpl$1.invoke$lambda$9$lambda$8$lambda$7(i3, arrayList, subcomposeMeasureScope, function22, scrollableTabData, i, arrayList2, constraints, iIntValue2, iIntValue, function3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8$lambda$7(int i, List list, SubcomposeMeasureScope subcomposeMeasureScope, Function2 function2, ScrollableTabData scrollableTabData, int i2, List list2, Constraints constraints, int i3, int i4, final Function3 function3, Placeable.PlacementScope placementScope) {
        final ArrayList arrayList = new ArrayList();
        int size = list.size();
        int width = i;
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, 0, 0.0f, 4, null);
            arrayList.add(new TabPosition(subcomposeMeasureScope.mo485toDpu2uoSUM(width), subcomposeMeasureScope.mo485toDpu2uoSUM(placeable.getWidth()), ((Dp) list2.get(i5)).m8844unboximpl(), null));
            width += placeable.getWidth();
        }
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
        int size2 = listSubcompose.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Placeable placeableMo7445measureBRTryo0 = listSubcompose.get(i6).mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(constraints.getValue(), i3, i3, 0, 0, 8, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo7445measureBRTryo0, 0, i4 - placeableMo7445measureBRTryo0.getHeight(), 0.0f, 4, null);
        }
        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(2125766411, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowWithSubcomposeImpl$1$1$1$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i7) {
                ComposerKt.sourceInformation(composer, "C920@40325L23:TabRow.kt#uh7d8r");
                if (!composer.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2125766411, i7, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:920)");
                }
                function3.invoke(arrayList, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        int size3 = listSubcompose2.size();
        for (int i7 = 0; i7 < size3; i7++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, listSubcompose2.get(i7).mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(i3, i4)), 0, 0, 0.0f, 4, null);
        }
        scrollableTabData.onLaidOut(subcomposeMeasureScope, i, arrayList, i2);
        return Unit.INSTANCE;
    }
}
