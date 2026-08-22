package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.appnew.android.Utils.Const;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: TextLayoutState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020;J-\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u000208¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020I¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020I2\u0006\u0010N\u001a\u00020IH\u0000¢\u0006\u0004\bR\u0010SR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R;\u0010\u0006\u001a#\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010\u001f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR/\u0010#\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR+\u0010(\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001e\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006T"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "", "<init>", "()V", "layoutCache", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "Lkotlin/ExtensionFunctionType;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function2;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function2;)V", "layoutResult", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult$delegate", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutNodeCoordinates", "getTextLayoutNodeCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setTextLayoutNodeCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "textLayoutNodeCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "coreNodeCoordinates", "getCoreNodeCoordinates", "setCoreNodeCoordinates", "coreNodeCoordinates$delegate", "decoratorNodeCoordinates", "getDecoratorNodeCoordinates", "setDecoratorNodeCoordinates", "decoratorNodeCoordinates$delegate", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "bringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "getBringIntoViewRequester", "()Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "layoutWithNewMeasureInputs", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetForPosition", "", Const.POSITION, "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation", "(J)J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextLayoutState {
    public static final int $stable = 8;
    private final BringIntoViewRequester bringIntoViewRequester;

    /* JADX INFO: renamed from: coreNodeCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState coreNodeCoordinates;

    /* JADX INFO: renamed from: decoratorNodeCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState decoratorNodeCoordinates;
    private TextFieldLayoutStateCache layoutCache;

    /* JADX INFO: renamed from: layoutResult$delegate, reason: from kotlin metadata */
    private final TextFieldLayoutStateCache layoutResult;

    /* JADX INFO: renamed from: minHeightForSingleLineField$delegate, reason: from kotlin metadata */
    private final MutableState minHeightForSingleLineField;
    private Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout;

    /* JADX INFO: renamed from: textLayoutNodeCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState textLayoutNodeCoordinates;

    public TextLayoutState() {
        TextFieldLayoutStateCache textFieldLayoutStateCache = new TextFieldLayoutStateCache();
        this.layoutCache = textFieldLayoutStateCache;
        this.layoutResult = textFieldLayoutStateCache;
        this.textLayoutNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.coreNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.decoratorNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.minHeightForSingleLineField = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m8828boximpl(Dp.m8830constructorimpl(0)), null, 2, null);
        this.bringIntoViewRequester = BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public final Function2<Density, Function0<TextLayoutResult>, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    public final void setOnTextLayout(Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.onTextLayout = function2;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult.getValue();
    }

    public final LayoutCoordinates getTextLayoutNodeCoordinates() {
        return (LayoutCoordinates) this.textLayoutNodeCoordinates.getValue();
    }

    public final void setTextLayoutNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        this.textLayoutNodeCoordinates.setValue(layoutCoordinates);
    }

    public final LayoutCoordinates getCoreNodeCoordinates() {
        return (LayoutCoordinates) this.coreNodeCoordinates.getValue();
    }

    public final void setCoreNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        this.coreNodeCoordinates.setValue(layoutCoordinates);
    }

    public final LayoutCoordinates getDecoratorNodeCoordinates() {
        return (LayoutCoordinates) this.decoratorNodeCoordinates.getValue();
    }

    public final void setDecoratorNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decoratorNodeCoordinates.setValue(layoutCoordinates);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMinHeightForSingleLineField-D9Ej5fM, reason: not valid java name */
    public final float m2111getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((Dp) this.minHeightForSingleLineField.getValue()).m8844unboximpl();
    }

    /* JADX INFO: renamed from: setMinHeightForSingleLineField-0680j_4, reason: not valid java name */
    public final void m2115setMinHeightForSingleLineField0680j_4(float f2) {
        this.minHeightForSingleLineField.setValue(Dp.m8828boximpl(f2));
    }

    public final BringIntoViewRequester getBringIntoViewRequester() {
        return this.bringIntoViewRequester;
    }

    public final void updateNonMeasureInputs(TransformedTextFieldState textFieldState, TextStyle textStyle, boolean singleLine, boolean softWrap, KeyboardOptions keyboardOptions) {
        this.layoutCache.updateNonMeasureInputs(textFieldState, textStyle, singleLine, softWrap, keyboardOptions);
    }

    /* JADX INFO: renamed from: layoutWithNewMeasureInputs--hBUhpc, reason: not valid java name */
    public final TextLayoutResult m2114layoutWithNewMeasureInputshBUhpc(Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long constraints) {
        TextLayoutResult textLayoutResultM2102layoutWithNewMeasureInputshBUhpc = this.layoutCache.m2102layoutWithNewMeasureInputshBUhpc(density, layoutDirection, fontFamilyResolver, constraints);
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2 = this.onTextLayout;
        if (function2 != null) {
            function2.invoke(density, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextLayoutState$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextLayoutState.layoutWithNewMeasureInputs__hBUhpc$lambda$0$0(this.f$0);
                }
            });
        }
        return textLayoutResultM2102layoutWithNewMeasureInputshBUhpc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextLayoutResult layoutWithNewMeasureInputs__hBUhpc$lambda$0$0(TextLayoutState textLayoutState) {
        return textLayoutState.layoutCache.getValue();
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m2109getOffsetForPosition3MmeM6k$default(TextLayoutState textLayoutState, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutState.m2112getOffsetForPosition3MmeM6k(j, z);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m2112getOffsetForPosition3MmeM6k(long position, boolean coerceInVisibleBounds) {
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return -1;
        }
        if (coerceInVisibleBounds) {
            position = m2110coercedInVisibleBoundsOfInputTextMKHz9U$foundation(position);
        }
        return layoutResult.m8243getOffsetForPositionk4lQ0M(TextLayoutStateKt.m2117fromDecorationToTextLayoutUv8p0NA(this, position));
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m2113isPositionOnTextk4lQ0M(long offset) {
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return false;
        }
        long jM2117fromDecorationToTextLayoutUv8p0NA = TextLayoutStateKt.m2117fromDecorationToTextLayoutUv8p0NA(this, m2110coercedInVisibleBoundsOfInputTextMKHz9U$foundation(offset));
        int lineForVerticalPosition = layoutResult.getLineForVerticalPosition(Float.intBitsToFloat((int) (4294967295L & jM2117fromDecorationToTextLayoutUv8p0NA)));
        int i = (int) (jM2117fromDecorationToTextLayoutUv8p0NA >> 32);
        return Float.intBitsToFloat(i) >= layoutResult.getLineLeft(lineForVerticalPosition) && Float.intBitsToFloat(i) <= layoutResult.getLineRight(lineForVerticalPosition);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long m2110coercedInVisibleBoundsOfInputTextMKHz9U$foundation(long r6) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.getTextLayoutNodeCoordinates()
            if (r0 == 0) goto L22
            boolean r1 = r0.isAttached()
            if (r1 == 0) goto L1a
            androidx.compose.ui.layout.LayoutCoordinates r1 = r5.getDecoratorNodeCoordinates()
            r2 = 0
            if (r1 == 0) goto L20
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r1, r0, r3, r4, r2)
            goto L20
        L1a:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L20:
            if (r2 != 0) goto L28
        L22:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L28:
            long r6 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.m2116coerceIn3MmeM6k(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextLayoutState.m2110coercedInVisibleBoundsOfInputTextMKHz9U$foundation(long):long");
    }
}
