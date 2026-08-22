package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001aa\u0010\u001b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b&\u0010'\u001a\"\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020/H\u0002\u001a\u000e\u00105\u001a\u000203*\u0004\u0018\u000106H\u0002\"\u0018\u0010(\u001a\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0018\u0010,\u001a\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+\"\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109*8\b\u0007\u0010\u0012\"\u00020\u000e2\u00020\u000eB*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0006\b\u001a\u0012\u0002\b\f¨\u0006:²\u0006\f\u0010;\u001a\u0004\u0018\u000106X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020/X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020/X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "hasGreaterOrEqualPriorityThan", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "that", "hasGreaterOrEqualPriorityThan-vVDBVkM", "(Ljava/lang/String;Ljava/lang/String;)Z", "MenuAnchorType", "Lkotlin/Deprecated;", "message", "Renamed to ExposedDropdownMenuAnchorType", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "ExposedDropdownMenuAnchorType", "imports", "expandable", "Lkotlin/Function0;", "anchorType", "alwaysFocusable", "Landroidx/compose/runtime/MutableState;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-3-2CpT8", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/MutableState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "isClick", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnterMinusSpacebar", "isEnterMinusSpacebar-ZmokQxo", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/unit/IntRect;", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "verticalMargin", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m8830constructorimpl(16);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$23(boolean z, Function1 function1, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ExposedDropdownMenuBox(z, function1, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Renamed to ExposedDropdownMenuAnchorType", replaceWith = @ReplaceWith(expression = "ExposedDropdownMenuAnchorType", imports = {}))
    public static /* synthetic */ void MenuAnchorType$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ExposedDropdownMenuBox(boolean r27, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function3<? super androidx.compose.material3.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 1069
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$15$lambda$14(WindowBoundsCalculator windowBoundsCalculator, int i, MutableState mutableState, MutableIntState mutableIntState, MutableIntState mutableIntState2, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
        mutableIntState.setIntValue((int) (layoutCoordinates.mo7453getSizeYbymL2g() >> 32));
        mutableIntState2.setIntValue(calculateMaxHeight(windowBoundsCalculator.getVisibleWindowBounds(), getAnchorBounds(ExposedDropdownMenuBox$lambda$2(mutableState)), i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$18$lambda$17(WindowBoundsCalculator windowBoundsCalculator, int i, MutableState mutableState, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(calculateMaxHeight(windowBoundsCalculator.getVisibleWindowBounds(), getAnchorBounds(ExposedDropdownMenuBox$lambda$2(mutableState)), i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$20$lambda$19(boolean z, FocusRequester focusRequester) {
        if (z) {
            FocusRequester.m5628requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$22$lambda$21(Function1 function1) {
        function1.invoke(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hasGreaterOrEqualPriorityThan-vVDBVkM, reason: not valid java name */
    public static final boolean m2903hasGreaterOrEqualPriorityThanvVDBVkM(String str, String str2) {
        if (ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2880getPrimaryNotEditableoYjWRB4()) || ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2879getPrimaryEditableoYjWRB4())) {
            return true;
        }
        if (ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2881getSecondaryEditableoYjWRB4())) {
            return ExposedDropdownMenuAnchorType.m2875equalsimpl0(str2, ExposedDropdownMenuAnchorType.INSTANCE.m2881getSecondaryEditableoYjWRB4());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: expandable-3-2CpT8, reason: not valid java name */
    public static final Modifier m2902expandable32CpT8(Modifier modifier, final boolean z, final Function0<Unit> function0, final String str, final MutableState<Boolean> mutableState, final String str2, final String str3, final String str4, final SoftwareKeyboardController softwareKeyboardController) {
        return SemanticsModifierKt.semantics$default(KeyInputModifierKt.onPreviewKeyEvent(SuspendingPointerInputFilterKt.pointerInput(modifier, function0, new PointerInputEventHandler() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1

            /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1", f = "ExposedDropdownMenu.kt", i = {0}, l = {1426, 1430}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $anchorType;
                final /* synthetic */ Function0<Unit> $onExpandedChange;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$anchorType = str;
                    this.$onExpandedChange = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$anchorType, this.$onExpandedChange, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
                
                    if (r11 == r0) goto L19;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L22
                        if (r1 == r3) goto L1a
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L62
                    L12:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L1a:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L3e
                    L22:
                        kotlin.ResultKt.throwOnFailure(r11)
                        java.lang.Object r11 = r10.L$0
                        r4 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                        androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r7 = r10
                        kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                        r10.L$0 = r4
                        r10.label = r3
                        r5 = 0
                        r8 = 1
                        r9 = 0
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                        if (r11 != r0) goto L3d
                        goto L61
                    L3d:
                        r1 = r4
                    L3e:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        java.lang.String r3 = r10.$anchorType
                        androidx.compose.material3.ExposedDropdownMenuAnchorType$Companion r4 = androidx.compose.material3.ExposedDropdownMenuAnchorType.INSTANCE
                        java.lang.String r4 = r4.m2881getSecondaryEditableoYjWRB4()
                        boolean r3 = androidx.compose.material3.ExposedDropdownMenuAnchorType.m2875equalsimpl0(r3, r4)
                        if (r3 == 0) goto L51
                        r11.consume()
                    L51:
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r3 = r10
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4 = 0
                        r10.L$0 = r4
                        r10.label = r2
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, r11, r3)
                        if (r11 != r0) goto L62
                    L61:
                        return r0
                    L62:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        if (r11 == 0) goto L6b
                        kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r10.$onExpandedChange
                        r11.invoke()
                    L6b:
                        kotlin.Unit r11 = kotlin.Unit.INSTANCE
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(str, function0, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        }), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m2906invokeZmokQxo(keyEvent.m7133unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m2906invokeZmokQxo(android.view.KeyEvent keyEvent) {
                if (ExposedDropdownMenuKt.m2904isClickZmokQxo(keyEvent)) {
                    if (ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2879getPrimaryEditableoYjWRB4())) {
                        if (ExposedDropdownMenuKt.m2905isEnterMinusSpacebarZmokQxo(keyEvent)) {
                            function0.invoke();
                            return true;
                        }
                    } else {
                        function0.invoke();
                    }
                }
                if (ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2879getPrimaryEditableoYjWRB4()) && z && (Key.m6824equalsimpl0(KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent), Key.INSTANCE.m7072getTabEK5gGoQ()) || Key.m6824equalsimpl0(KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent), Key.INSTANCE.m6898getDirectionDownEK5gGoQ()) || Key.m6824equalsimpl0(KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent), Key.INSTANCE.m6903getDirectionUpEK5gGoQ()))) {
                    mutableState.setValue(true);
                    return true;
                }
                mutableState.setValue(false);
                return false;
            }
        }), false, new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenuKt.expandable_3_2CpT8$lambda$25(str, z, str2, str3, str4, function0, softwareKeyboardController, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit expandable_3_2CpT8$lambda$25(final String str, boolean z, String str2, String str3, String str4, final Function0 function0, final SoftwareKeyboardController softwareKeyboardController, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2881getSecondaryEditableoYjWRB4())) {
            SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8013getButtono7Vup1c());
            if (!z) {
                str2 = str3;
            }
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str4);
        } else {
            SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8016getDropdownListo7Vup1c());
        }
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ExposedDropdownMenuKt.expandable_3_2CpT8$lambda$25$lambda$24(function0, str, softwareKeyboardController));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean expandable_3_2CpT8$lambda$25$lambda$24(Function0 function0, String str, SoftwareKeyboardController softwareKeyboardController) {
        function0.invoke();
        if (!ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2879getPrimaryEditableoYjWRB4()) || softwareKeyboardController == null) {
            return true;
        }
        softwareKeyboardController.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m2904isClickZmokQxo(android.view.KeyEvent keyEvent) {
        if (KeyEventType.m7137equalsimpl0(KeyEvent_androidKt.m7145getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7142getKeyUpCS__XNY())) {
            return m2905isEnterMinusSpacebarZmokQxo(keyEvent) || Key.m6824equalsimpl0(KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent), Key.INSTANCE.m7059getSpacebarEK5gGoQ());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isEnterMinusSpacebar-ZmokQxo, reason: not valid java name */
    public static final boolean m2905isEnterMinusSpacebarZmokQxo(android.view.KeyEvent keyEvent) {
        long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent);
        return Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6897getDirectionCenterEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6911getEnterEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7008getNumPadEnterEK5gGoQ());
    }

    private static final int calculateMaxHeight(IntRect intRect, Rect rect, int i) {
        if (rect == null) {
            return 0;
        }
        int top = intRect.getTop() + i;
        int bottom = intRect.getBottom() - i;
        return Math.max((rect.getTop() > ((float) intRect.getBottom()) || rect.getBottom() < ((float) intRect.getTop())) ? bottom - top : MathKt.roundToInt(Math.max(rect.getTop() - top, bottom - rect.getBottom())), 0);
    }

    private static final Rect getAnchorBounds(LayoutCoordinates layoutCoordinates) {
        return (layoutCoordinates == null || !layoutCoordinates.isAttached()) ? Rect.INSTANCE.getZero() : RectKt.m5763Recttz77jQw(LayoutCoordinatesKt.positionInWindow(layoutCoordinates), IntSizeKt.m9013toSizeozmzZPI(layoutCoordinates.mo7453getSizeYbymL2g()));
    }
}
