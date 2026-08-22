package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: HeightInLinesModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J#\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u001aH\u0016J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\u001e\u0010)\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, d2 = {"Landroidx/compose/foundation/text/HeightInLinesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minLines", "", "maxLines", "<init>", "(Landroidx/compose/ui/text/TextStyle;II)V", "dirty", "", "precomputedMinLinesHeight", "precomputedMaxLinesHeight", "resolvedStyle", "fontResolutionState", "Landroidx/compose/runtime/State;", "", "requireResolvedStyle", "requireFontResolutionState", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "onAttach", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "onObservedReadsChanged", "onFontResolutionStateChanged", "onLayoutDirectionChange", "onDensityChange", "onDetach", DiscoverItems.Item.UPDATE_ACTION, "computeHeights", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class HeightInLinesNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode, ObserverModifierNode {
    private boolean dirty;
    private State<? extends Object> fontResolutionState;
    private int maxLines;
    private int minLines;
    private TextStyle resolvedStyle;
    private final boolean shouldAutoInvalidate;
    private TextStyle textStyle;
    private int precomputedMinLinesHeight = -1;
    private int precomputedMaxLinesHeight = -1;

    public HeightInLinesNode(TextStyle textStyle, int i, int i2) {
        this.textStyle = textStyle;
        this.minLines = i;
        this.maxLines = i2;
    }

    private final TextStyle requireResolvedStyle() {
        TextStyle textStyle = this.resolvedStyle;
        if (textStyle != null) {
            return textStyle;
        }
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Resolved style is not set.");
        throw new KotlinNothingValueException();
    }

    private final State<Object> requireFontResolutionState() {
        State<? extends Object> state = this.fontResolutionState;
        if (state != null) {
            return state;
        }
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Font resolution state is not set.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        FontFamily.Resolver resolver = (FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFontFamilyResolver());
        this.resolvedStyle = TextStyleKt.resolveDefaults(this.textStyle, DelegatableNodeKt.requireLayoutDirection(this));
        FontFamily fontFamily = requireResolvedStyle().getFontFamily();
        FontWeight fontWeight = requireResolvedStyle().getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontStyle fontStyleM8305getFontStyle4Lr2A7w = requireResolvedStyle().m8305getFontStyle4Lr2A7w();
        int iM8390unboximpl = fontStyleM8305getFontStyle4Lr2A7w != null ? fontStyleM8305getFontStyle4Lr2A7w.m8390unboximpl() : FontStyle.INSTANCE.m8394getNormal_LCdwA();
        FontSynthesis fontSynthesisM8306getFontSynthesisZQGJjVo = requireResolvedStyle().m8306getFontSynthesisZQGJjVo();
        this.fontResolutionState = resolver.mo8359resolveDPcqOEQ(fontFamily, fontWeight, iM8390unboximpl, fontSynthesisM8306getFontSynthesisZQGJjVo != null ? fontSynthesisM8306getFontSynthesisZQGJjVo.m8403unboximpl() : FontSynthesis.INSTANCE.m8404getAllGVVA2EU());
        ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.text.HeightInLinesNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HeightInLinesNode.onAttach$lambda$0(this.f$0);
            }
        });
        this.dirty = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttach$lambda$0(HeightInLinesNode heightInLinesNode) {
        heightInLinesNode.requireFontResolutionState().getValue();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo72measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM8784getMinHeightimpl;
        int iM8782getMaxHeightimpl;
        if (this.dirty) {
            computeHeights(measureScope, requireResolvedStyle(), (FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFontFamilyResolver()));
            this.dirty = false;
        }
        int i = this.precomputedMinLinesHeight;
        if (i != -1) {
            iM8784getMinHeightimpl = RangesKt.coerceIn(i, Constraints.m8784getMinHeightimpl(j), Constraints.m8782getMaxHeightimpl(j));
        } else {
            iM8784getMinHeightimpl = Constraints.m8784getMinHeightimpl(j);
        }
        int i2 = iM8784getMinHeightimpl;
        int i3 = this.precomputedMaxLinesHeight;
        if (i3 != -1) {
            iM8782getMaxHeightimpl = RangesKt.coerceIn(i3, Constraints.m8784getMinHeightimpl(j), Constraints.m8782getMaxHeightimpl(j));
        } else {
            iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j);
        }
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, 0, i2, iM8782getMaxHeightimpl, 3, null));
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.text.HeightInLinesNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeightInLinesNode.measure_3p2s80s$lambda$0(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        onFontResolutionStateChanged();
    }

    private final void onFontResolutionStateChanged() {
        if (this.fontResolutionState != null) {
            ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.text.HeightInLinesNode$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HeightInLinesNode.onFontResolutionStateChanged$lambda$0(this.f$0);
                }
            });
        }
        this.dirty = true;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFontResolutionStateChanged$lambda$0(HeightInLinesNode heightInLinesNode) {
        heightInLinesNode.requireFontResolutionState().getValue();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public void onLayoutDirectionChange() {
        this.resolvedStyle = TextStyleKt.resolveDefaults(this.textStyle, DelegatableNodeKt.requireLayoutDirection(this));
        this.dirty = true;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        this.dirty = true;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.resolvedStyle = null;
        this.fontResolutionState = null;
        this.dirty = false;
    }

    public final void update(TextStyle textStyle, int minLines, int maxLines) {
        if (Intrinsics.areEqual(this.textStyle, textStyle) && this.minLines == minLines && this.maxLines == maxLines) {
            return;
        }
        this.textStyle = textStyle;
        this.minLines = minLines;
        this.maxLines = maxLines;
        this.resolvedStyle = TextStyleKt.resolveDefaults(textStyle, DelegatableNodeKt.requireLayoutDirection(this));
        this.dirty = true;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    private final void computeHeights(Density density, TextStyle resolvedStyle, FontFamily.Resolver fontFamilyResolver) {
        int iComputeSizeForDefaultText = (int) (TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1) & 4294967295L);
        int iComputeSizeForDefaultText2 = ((int) (TextFieldDelegateKt.computeSizeForDefaultText(resolvedStyle, density, fontFamilyResolver, TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2) & 4294967295L)) - iComputeSizeForDefaultText;
        int i = this.minLines;
        this.precomputedMinLinesHeight = i == 1 ? -1 : ((i - 1) * iComputeSizeForDefaultText2) + iComputeSizeForDefaultText;
        int i2 = this.maxLines;
        this.precomputedMaxLinesHeight = i2 != Integer.MAX_VALUE ? iComputeSizeForDefaultText + (iComputeSizeForDefaultText2 * (i2 - 1)) : -1;
    }
}
