package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.clevertap.android.sdk.Constants;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0000\u001aW\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001e\"\u0010\u0010\u001f\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 \"\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"DragHandleWithTooltip", "", "Landroidx/compose/foundation/layout/ColumnScope;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "velocity", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "positionalThreshold", "Landroidx/compose/ui/unit/Dp;", "velocityThreshold", "rememberSheetState-AGcomas", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "DragHandleVerticalPadding", "F", "BottomSheetAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SheetDefaultsKt {
    private static final float DragHandleVerticalPadding = Dp.m8830constructorimpl(22);
    private static final AnimationSpec<Float> BottomSheetAnimationSpec = AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandleWithTooltip$lambda$1(ColumnScope columnScope, Function2 function2, int i, Composer composer, int i2) {
        DragHandleWithTooltip(columnScope, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberSheetState_AGcomas$lambda$3$lambda$2(SheetValue sheetValue) {
        return true;
    }

    public static final void DragHandleWithTooltip(final ColumnScope columnScope, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1033612924);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DragHandleWithTooltip)N(content)433@17991L51,435@18147L349:SheetDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1033612924, i3, -1, "androidx.compose.material3.DragHandleWithTooltip (SheetDefaults.kt:432)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_bottom_sheet_drag_handle_description), composerStartRestartGroup, 0);
            Modifier modifierAlign = columnScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 772858620, "C438@18272L60,439@18356L48,440@18426L22,436@18197L293:SheetDefaults.kt#uh7d8r");
            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m3900rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m3887getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(2059851063, true, new Function3<TooltipScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SheetDefaultsKt$DragHandleWithTooltip$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(TooltipScope tooltipScope, Composer composer2, Integer num) {
                    invoke(tooltipScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(TooltipScope tooltipScope, Composer composer2, int i4) {
                    int i5;
                    ComposerKt.sourceInformation(composer2, "C439@18371L31,439@18358L44:SheetDefaults.kt#uh7d8r");
                    if ((i4 & 6) == 0) {
                        i5 = i4 | ((i4 & 8) == 0 ? composer2.changed(tooltipScope) : composer2.changedInstance(tooltipScope) ? 4 : 2);
                    } else {
                        i5 = i4;
                    }
                    if (!composer2.shouldExecute((i5 & 19) != 18, i5 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2059851063, i5, -1, "androidx.compose.material3.DragHandleWithTooltip.<anonymous>.<anonymous> (SheetDefaults.kt:439)");
                    }
                    final String str = strM4145getString2EP1pXo;
                    TooltipKt.m3908PlainTooltipgv3ox5I(tooltipScope, null, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-999924215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SheetDefaultsKt$DragHandleWithTooltip$1$1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i6) {
                            ComposerKt.sourceInformation(composer3, "C439@18373L27:SheetDefaults.kt#uh7d8r");
                            if (!composer3.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-999924215, i6, -1, "androidx.compose.material3.DragHandleWithTooltip.<anonymous>.<anonymous>.<anonymous> (SheetDefaults.kt:439)");
                            }
                            TextKt.m3703TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 262142);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, (i5 & 14) | C.ENCODING_PCM_32BIT, 255);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, function2, composerStartRestartGroup, ((i3 << 21) & 234881024) | 48, 248);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SheetDefaultsKt.DragHandleWithTooltip$lambda$1(columnScope, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(final SheetState sheetState, final Orientation orientation, final Function1<? super Float, Unit> function1) {
        return new NestedScrollConnection() { // from class: androidx.compose.material3.SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1
            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
            public long mo1255onPreScrollOzD1aCk(long available, int source) {
                float fOffsetToFloat = offsetToFloat(available);
                if (fOffsetToFloat < 0.0f && NestedScrollSource.m7169equalsimpl0(source, NestedScrollSource.INSTANCE.m7181getUserInputWNlRxjI())) {
                    return toOffset(sheetState.getAnchoredDraggableState$material3().dispatchRawDelta(fOffsetToFloat));
                }
                return Offset.INSTANCE.m5739getZeroF1C5BW0();
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
            public long mo677onPostScrollDzOQY0M(long consumed, long available, int source) {
                if (NestedScrollSource.m7169equalsimpl0(source, NestedScrollSource.INSTANCE.m7181getUserInputWNlRxjI())) {
                    return toOffset(sheetState.getAnchoredDraggableState$material3().dispatchRawDelta(offsetToFloat(available)));
                }
                return Offset.INSTANCE.m5739getZeroF1C5BW0();
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPreFling-QWom1Mo */
            public Object mo1254onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = sheetState.requireOffset();
                float fMinAnchor = sheetState.getAnchoredDraggableState$material3().getAnchors().minAnchor();
                if (fVelocityToFloat < 0.0f && fRequireOffset > fMinAnchor) {
                    function1.invoke(Boxing.boxFloat(fVelocityToFloat));
                } else {
                    j = Velocity.INSTANCE.m9079getZero9UxMQ8M();
                }
                return Velocity.m9059boximpl(j);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
            public Object mo676onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
                function1.invoke(Boxing.boxFloat(velocityToFloat(j2)));
                return Velocity.m9059boximpl(j2);
            }

            private final long toOffset(float f2) {
                float f3 = orientation == Orientation.Horizontal ? f2 : 0.0f;
                if (orientation != Orientation.Vertical) {
                    f2 = 0.0f;
                }
                return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
            }

            private final float velocityToFloat(long j) {
                return orientation == Orientation.Horizontal ? Velocity.m9068getXimpl(j) : Velocity.m9069getYimpl(j);
            }

            private final float offsetToFloat(long j) {
                return Float.intBitsToFloat((int) (orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
            }
        };
    }

    /* JADX INFO: renamed from: rememberSheetState-AGcomas, reason: not valid java name */
    public static final SheetState m3415rememberSheetStateAGcomas(boolean z, Function1<? super SheetValue, Boolean> function1, SheetValue sheetValue, boolean z2, float f2, float f3, Composer composer, int i, int i2) {
        final Function1<? super SheetValue, Boolean> function12;
        ComposerKt.sourceInformationMarkerStart(composer, -20307384, "C(rememberSheetState)N(skipPartiallyExpanded,confirmValueChange,initialValue,skipHiddenState,positionalThreshold:c#ui.unit.Dp,velocityThreshold:c#ui.unit.Dp)509@20940L8,515@21212L7,516@21254L48,517@21335L46,530@21855L231,518@21393L693:SheetDefaults.kt#uh7d8r");
        final boolean z3 = (i2 & 1) != 0 ? false : z;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 1959445744, "CC(remember):SheetDefaults.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SheetDefaultsKt.rememberSheetState_AGcomas$lambda$3$lambda$2((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function12 = (Function1) objRememberedValue;
        } else {
            function12 = function1;
        }
        final SheetValue sheetValue2 = (i2 & 4) != 0 ? SheetValue.Hidden : sheetValue;
        final boolean z4 = (i2 & 8) != 0 ? false : z2;
        final float fM2489getPositionalThresholdD9Ej5fM$material3 = (i2 & 16) != 0 ? BottomSheetDefaults.INSTANCE.m2489getPositionalThresholdD9Ej5fM$material3() : f2;
        final float fM2492getVelocityThresholdD9Ej5fM$material3 = (i2 & 32) != 0 ? BottomSheetDefaults.INSTANCE.m2492getVelocityThresholdD9Ej5fM$material3() : f3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20307384, i, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:514)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 1959455832, "CC(remember):SheetDefaults.kt#9igjgp");
        boolean z5 = true;
        boolean zChanged = composer.changed(density) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(fM2489getPositionalThresholdD9Ej5fM$material3)) || (i & 24576) == 16384);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(density.mo488toPx0680j_4(fM2489getPositionalThresholdD9Ej5fM$material3));
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        final Function0<Float> function0 = (Function0) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1959458422, "CC(remember):SheetDefaults.kt#9igjgp");
        boolean zChanged2 = composer.changed(density) | ((((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(fM2492getVelocityThresholdD9Ej5fM$material3)) || (i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(density.mo488toPx0680j_4(fM2492getVelocityThresholdD9Ej5fM$material3));
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        final Function0<Float> function02 = (Function0) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object[] objArr = {Boolean.valueOf(z3), function12, Boolean.valueOf(z4)};
        Saver<SheetState, SheetValue> Saver = SheetState.INSTANCE.Saver(z3, function0, function02, function12, z4);
        ComposerKt.sourceInformationMarkerStart(composer, 1959475247, "CC(remember):SheetDefaults.kt#9igjgp");
        boolean zChanged3 = ((((i & 14) ^ 6) > 4 && composer.changed(z3)) || (i & 6) == 4) | composer.changed(function0) | composer.changed(function02) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(sheetValue2.ordinal())) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i & 112) ^ 48) > 32 && composer.changed(function12)) || (i & 48) == 32);
        if ((((i & 7168) ^ 3072) <= 2048 || !composer.changed(z4)) && (i & 3072) != 2048) {
            z5 = false;
        }
        boolean z6 = zChanged3 | z5;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SheetDefaultsKt.rememberSheetState_AGcomas$lambda$11$lambda$10(z3, function0, function02, sheetValue2, function12, z4);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SheetState sheetState = (SheetState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue4, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SheetState rememberSheetState_AGcomas$lambda$11$lambda$10(boolean z, Function0 function0, Function0 function02, SheetValue sheetValue, Function1 function1, boolean z2) {
        return new SheetState(z, function0, function02, sheetValue, function1, z2);
    }
}
