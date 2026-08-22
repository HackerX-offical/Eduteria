package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: TextLinkScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u001f\u001a\u00020 *\u00020 2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001e\u0010%\u001a\u00020 *\u00020 2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010'2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001c\u0010(\u001a\u0004\u0018\u00010)2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J0\u0010*\u001a\u0010\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0004\u0018\u0001`$2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$2\u0006\u0010\n\u001a\u00020\tH\u0002J\r\u0010+\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010,J\u001a\u0010-\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u0010!\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0002J\r\u00103\u001a\u00020\u0003H\u0000¢\u0006\u0002\b4J>\u00105\u001a\u00020\u00182\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000107\"\u0004\u0018\u00010\u00012\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u00109R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R/\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0005R%\u0010\u0014\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u00190\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006:"}, d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getInitialText$foundation", "()Landroidx/compose/ui/text/AnnotatedString;", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "text", "getText$foundation", "setText$foundation", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Lkotlin/ExtensionFunctionType;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "textRange", "Landroidx/compose/ui/Modifier;", "link", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/foundation/text/LinkRange;", "clipLink", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "calculateVisibleLinkRange", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "mergeOrUse", "Landroidx/compose/ui/text/SpanStyle;", "other", "handleLink", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "applyAnnotators", "applyAnnotators$foundation", "StyleAnnotation", "keys", "", BlockContactsIQ.ELEMENT, "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextLinkScope {
    public static final int $stable = 8;
    private final AnnotatedString initialText;
    private AnnotatedString text;

    /* JADX INFO: renamed from: textLayoutResult$delegate, reason: from kotlin metadata */
    private final MutableState textLayoutResult = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private final SnapshotStateList<Function1<TextAnnotatorScope, Unit>> annotators = SnapshotStateKt.mutableStateListOf();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinksComposables$lambda$1(TextLinkScope textLinkScope, int i, Composer composer, int i2) {
        textLinkScope.LinksComposables(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyleAnnotation$lambda$1(TextLinkScope textLinkScope, Object[] objArr, Function1 function1, int i, Composer composer, int i2) {
        textLinkScope.StyleAnnotation(objArr, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public TextLinkScope(AnnotatedString annotatedString) {
        this.initialText = annotatedString;
        this.text = annotatedString.flatMapAnnotations(new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextLinkScope._init_$lambda$0((AnnotatedString.Range) obj);
            }
        });
    }

    /* JADX INFO: renamed from: getInitialText$foundation, reason: from getter */
    public final AnnotatedString getInitialText() {
        return this.initialText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextLayoutResult getTextLayoutResult() {
        return (TextLayoutResult) this.textLayoutResult.getValue();
    }

    public final void setTextLayoutResult(TextLayoutResult textLayoutResult) {
        this.textLayoutResult.setValue(textLayoutResult);
    }

    /* JADX INFO: renamed from: getText$foundation, reason: from getter */
    public final AnnotatedString getText() {
        return this.text;
    }

    public final void setText$foundation(AnnotatedString annotatedString) {
        this.text = annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List _init_$lambda$0(androidx.compose.ui.text.AnnotatedString.Range r27) {
        /*
            java.lang.Object r0 = r27.getItem()
            boolean r0 = r0 instanceof androidx.compose.ui.text.LinkAnnotation
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L73
            java.lang.Object r0 = r27.getItem()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            androidx.compose.ui.text.LinkAnnotation r0 = (androidx.compose.ui.text.LinkAnnotation) r0
            androidx.compose.ui.text.TextLinkStyles r0 = r0.getStyles()
            boolean r0 = androidx.compose.foundation.text.TextLinkScopeKt.access$isNullOrEmpty(r0)
            if (r0 != 0) goto L73
            r0 = 2
            androidx.compose.ui.text.AnnotatedString$Range[] r0 = new androidx.compose.ui.text.AnnotatedString.Range[r0]
            r0[r1] = r27
            androidx.compose.ui.text.AnnotatedString$Range r1 = new androidx.compose.ui.text.AnnotatedString$Range
            java.lang.Object r4 = r27.getItem()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            androidx.compose.ui.text.LinkAnnotation r4 = (androidx.compose.ui.text.LinkAnnotation) r4
            androidx.compose.ui.text.TextLinkStyles r3 = r4.getStyles()
            if (r3 == 0) goto L3b
            androidx.compose.ui.text.SpanStyle r3 = r3.getStyle()
            if (r3 != 0) goto L61
        L3b:
            androidx.compose.ui.text.SpanStyle r4 = new androidx.compose.ui.text.SpanStyle
            r25 = 65535(0xffff, float:9.1834E-41)
            r26 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r4.<init>(r5, r7, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26)
            r3 = r4
        L61:
            int r4 = r27.getStart()
            int r5 = r27.getEnd()
            r1.<init>(r3, r4, r5)
            r0[r2] = r1
            java.util.ArrayList r0 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            goto L7b
        L73:
            androidx.compose.ui.text.AnnotatedString$Range[] r0 = new androidx.compose.ui.text.AnnotatedString.Range[r2]
            r0[r1] = r27
            java.util.ArrayList r0 = kotlin.collections.CollectionsKt.arrayListOf(r0)
        L7b:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLinkScope._init_$lambda$0(androidx.compose.ui.text.AnnotatedString$Range):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_shouldMeasureLinks_$lambda$0(TextLinkScope textLinkScope) {
        TextLayoutInput layoutInput;
        AnnotatedString annotatedString = textLinkScope.text;
        TextLayoutResult textLayoutResult = textLinkScope.getTextLayoutResult();
        return Intrinsics.areEqual(annotatedString, (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null) ? null : layoutInput.getText());
    }

    public final Function0<Boolean> getShouldMeasureLinks() {
        return new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TextLinkScope._get_shouldMeasureLinks_$lambda$0(this.f$0));
            }
        };
    }

    private final Modifier textRange(Modifier modifier, final AnnotatedString.Range<LinkAnnotation> range) {
        return modifier.then(new TextRangeLayoutModifier(new TextRangeScopeMeasurePolicy() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda3
            @Override // androidx.compose.foundation.text.TextRangeScopeMeasurePolicy
            public final TextRangeLayoutMeasureResult measure(TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
                return TextLinkScope.textRange$lambda$0(this.f$0, range, textRangeLayoutMeasureScope);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRangeLayoutMeasureResult textRange$lambda$0(TextLinkScope textLinkScope, AnnotatedString.Range range, TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
        TextLayoutResult textLayoutResult = textLinkScope.getTextLayoutResult();
        if (textLayoutResult == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextLinkScope.textRange$lambda$0$0();
                }
            });
        }
        AnnotatedString.Range<LinkAnnotation> rangeCalculateVisibleLinkRange = textLinkScope.calculateVisibleLinkRange(range, textLayoutResult);
        if (rangeCalculateVisibleLinkRange == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextLinkScope.textRange$lambda$0$1();
                }
            });
        }
        final IntRect intRectRoundToIntRect = IntRectKt.roundToIntRect(textLayoutResult.getPathForRange(rangeCalculateVisibleLinkRange.getStart(), rangeCalculateVisibleLinkRange.getEnd()).getBounds());
        return textRangeLayoutMeasureScope.layout(intRectRoundToIntRect.getWidth(), intRectRoundToIntRect.getHeight(), new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextLinkScope.textRange$lambda$0$2(intRectRoundToIntRect);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset textRange$lambda$0$0() {
        return IntOffset.m8949boximpl(IntOffset.INSTANCE.m8969getZeronOccac());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset textRange$lambda$0$1() {
        return IntOffset.m8949boximpl(IntOffset.INSTANCE.m8969getZeronOccac());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset textRange$lambda$0$2(IntRect intRect) {
        return IntOffset.m8949boximpl(intRect.m8987getTopLeftnOccac());
    }

    private final Modifier clipLink(Modifier modifier, final AnnotatedString.Range<LinkAnnotation> range) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextLinkScope.clipLink$lambda$0(this.f$0, range, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clipLink$lambda$0(TextLinkScope textLinkScope, AnnotatedString.Range range, GraphicsLayerScope graphicsLayerScope) {
        Shape shapeShapeForRange = textLinkScope.shapeForRange(range);
        if (shapeShapeForRange != null) {
            graphicsLayerScope.setShape(shapeShapeForRange);
            graphicsLayerScope.setClip(true);
        }
        return Unit.INSTANCE;
    }

    private final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> link) {
        final Path pathPathForRangeInRangeCoordinates = pathForRangeInRangeCoordinates(link);
        return pathPathForRangeInRangeCoordinates != null ? new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
            @Override // androidx.compose.ui.graphics.Shape
            /* JADX INFO: renamed from: createOutline-Pq9zytI */
            public Outline mo382createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                return new Outline.Generic(pathPathForRangeInRangeCoordinates);
            }
        } : null;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> link) {
        Path pathForRange = null;
        if (!getShouldMeasureLinks().invoke().booleanValue()) {
            return null;
        }
        TextLayoutResult textLayoutResult = getTextLayoutResult();
        if (textLayoutResult != null) {
            AnnotatedString.Range<LinkAnnotation> rangeCalculateVisibleLinkRange = calculateVisibleLinkRange(link, textLayoutResult);
            if (rangeCalculateVisibleLinkRange == null) {
                return null;
            }
            pathForRange = textLayoutResult.getPathForRange(rangeCalculateVisibleLinkRange.getStart(), rangeCalculateVisibleLinkRange.getEnd());
            Rect boundingBox = textLayoutResult.getBoundingBox(rangeCalculateVisibleLinkRange.getStart());
            pathForRange.mo5860translatek4lQ0M(Offset.m5715constructorimpl(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(textLayoutResult.getLineForOffset(rangeCalculateVisibleLinkRange.getStart()) == textLayoutResult.getLineForOffset(rangeCalculateVisibleLinkRange.getEnd() + (-1)) ? Math.min(textLayoutResult.getBoundingBox(rangeCalculateVisibleLinkRange.getEnd() - 1).getLeft(), boundingBox.getLeft()) : 0.0f)) << 32) | (((long) Float.floatToRawIntBits(boundingBox.getTop())) & 4294967295L)) ^ (-9223372034707292160L)));
        }
        return pathForRange;
    }

    private final AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange(AnnotatedString.Range<LinkAnnotation> link, TextLayoutResult textLayoutResult) {
        int lineEnd$default = TextLayoutResult.getLineEnd$default(textLayoutResult, textLayoutResult.getLineCount() - 1, false, 2, null);
        if (link.getStart() < lineEnd$default) {
            return AnnotatedString.Range.copy$default(link, null, 0, Math.min(link.getEnd(), lineEnd$default), null, 11, null);
        }
        return null;
    }

    public final void LinksComposables(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1154651354);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinksComposables)215@9182L7:TextLinkScope.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = 1;
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1154651354, i2, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:214)");
            }
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final UriHandler uriHandler = (UriHandler) objConsume;
            AnnotatedString annotatedString = this.text;
            List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
            int size = linkAnnotations.size();
            int i4 = 0;
            while (i4 < size) {
                final AnnotatedString.Range<LinkAnnotation> range = linkAnnotations.get(i4);
                if (range.getStart() != range.getEnd()) {
                    composerStartRestartGroup.startReplaceGroup(725478935);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "220@9372L39,224@9514L180,234@10047L38,222@9429L701");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 854684939, "CC(remember):TextLinkScope.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierClipLink = clipLink(Modifier.INSTANCE, range);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 854689624, "CC(remember):TextLinkScope.kt#9igjgp");
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TextLinkScope.LinksComposables$lambda$0$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(HoverableKt.hoverable$default(textRange(SemanticsModifierKt.semantics$default(modifierClipLink, false, (Function1) objRememberedValue2, i3, null), range), mutableInteractionSource, false, 2, null), PointerIcon.INSTANCE.getHand(), false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 854706538, "CC(remember):TextLinkScope.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(range) | composerStartRestartGroup.changedInstance(uriHandler);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TextLinkScope.LinksComposables$lambda$0$2$0(this.f$0, range, uriHandler);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxKt.Box(ClickableKt.m363combinedClickableauXiCPI$default(modifierPointerHoverIcon$default, mutableInteractionSource, null, false, null, null, null, null, null, false, (Function0) objRememberedValue3, TypedValues.PositionType.TYPE_CURVE_FIT, null), composerStartRestartGroup, 0);
                    if (!TextLinkScopeKt.isNullOrEmpty(range.getItem().getStyles())) {
                        composerStartRestartGroup.startReplaceGroup(726303039);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "243@10493L110,246@10645L51,246@10624L72,256@11137L1144,248@10718L1563");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 854720882, "CC(remember):TextLinkScope.kt#9igjgp");
                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new LinkStateInteractionSourceObserver(mutableInteractionSource);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        final LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = (LinkStateInteractionSourceObserver) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 854725687, "CC(remember):TextLinkScope.kt#9igjgp");
                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function2) new TextLinkScope$LinksComposables$1$3$1(linkStateInteractionSourceObserver, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composerStartRestartGroup, 6);
                        Boolean boolValueOf = Boolean.valueOf(linkStateInteractionSourceObserver.isHovered());
                        Boolean boolValueOf2 = Boolean.valueOf(linkStateInteractionSourceObserver.isFocused());
                        Boolean boolValueOf3 = Boolean.valueOf(linkStateInteractionSourceObserver.isPressed());
                        TextLinkStyles styles = range.getItem().getStyles();
                        SpanStyle style = styles != null ? styles.getStyle() : null;
                        TextLinkStyles styles2 = range.getItem().getStyles();
                        SpanStyle focusedStyle = styles2 != null ? styles2.getFocusedStyle() : null;
                        TextLinkStyles styles3 = range.getItem().getStyles();
                        SpanStyle hoveredStyle = styles3 != null ? styles3.getHoveredStyle() : null;
                        TextLinkStyles styles4 = range.getItem().getStyles();
                        Object[] objArr = {boolValueOf, boolValueOf2, boolValueOf3, style, focusedStyle, hoveredStyle, styles4 != null ? styles4.getPressedStyle() : null};
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 854742524, "CC(remember):TextLinkScope.kt#9igjgp");
                        boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(range);
                        Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TextLinkScope.LinksComposables$lambda$0$5$0(this.f$0, range, linkStateInteractionSourceObserver, (TextAnnotatorScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        StyleAnnotation(objArr, (Function1) objRememberedValue6, composerStartRestartGroup, (i2 << 6) & 896);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(728331710);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(728345598);
                    composerStartRestartGroup.endReplaceGroup();
                }
                i4++;
                i3 = 1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextLinkScope.LinksComposables$lambda$1(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinksComposables$lambda$0$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getLinkTestMarker(), Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinksComposables$lambda$0$2$0(TextLinkScope textLinkScope, AnnotatedString.Range range, UriHandler uriHandler) {
        textLinkScope.handleLink((LinkAnnotation) range.getItem(), uriHandler);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinksComposables$lambda$0$5$0(TextLinkScope textLinkScope, AnnotatedString.Range range, LinkStateInteractionSourceObserver linkStateInteractionSourceObserver, TextAnnotatorScope textAnnotatorScope) {
        TextLinkStyles styles;
        TextLinkStyles styles2;
        TextLinkStyles styles3;
        TextLinkStyles styles4 = ((LinkAnnotation) range.getItem()).getStyles();
        SpanStyle pressedStyle = null;
        SpanStyle spanStyleMergeOrUse = textLinkScope.mergeOrUse(textLinkScope.mergeOrUse(styles4 != null ? styles4.getStyle() : null, (!linkStateInteractionSourceObserver.isFocused() || (styles3 = ((LinkAnnotation) range.getItem()).getStyles()) == null) ? null : styles3.getFocusedStyle()), (!linkStateInteractionSourceObserver.isHovered() || (styles2 = ((LinkAnnotation) range.getItem()).getStyles()) == null) ? null : styles2.getHoveredStyle());
        if (linkStateInteractionSourceObserver.isPressed() && (styles = ((LinkAnnotation) range.getItem()).getStyles()) != null) {
            pressedStyle = styles.getPressedStyle();
        }
        textAnnotatorScope.replaceStyle(range, textLinkScope.mergeOrUse(spanStyleMergeOrUse, pressedStyle));
        return Unit.INSTANCE;
    }

    private final SpanStyle mergeOrUse(SpanStyle spanStyle, SpanStyle spanStyle2) {
        SpanStyle spanStyleMerge;
        return (spanStyle == null || (spanStyleMerge = spanStyle.merge(spanStyle2)) == null) ? spanStyle2 : spanStyleMerge;
    }

    private final void handleLink(LinkAnnotation link, UriHandler uriHandler) {
        LinkInteractionListener linkInteractionListener;
        if (link instanceof LinkAnnotation.Url) {
            LinkInteractionListener linkInteractionListener2 = ((LinkAnnotation.Url) link).getLinkInteractionListener();
            if (linkInteractionListener2 != null) {
                linkInteractionListener2.onClick(link);
                return;
            } else {
                try {
                    uriHandler.openUri(((LinkAnnotation.Url) link).getUrl());
                    return;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
        if (!(link instanceof LinkAnnotation.Clickable) || (linkInteractionListener = ((LinkAnnotation.Clickable) link).getLinkInteractionListener()) == null) {
            return;
        }
        linkInteractionListener.onClick(link);
    }

    public final AnnotatedString applyAnnotators$foundation() {
        AnnotatedString styledText;
        if (this.annotators.isEmpty()) {
            styledText = this.text;
        } else {
            TextAnnotatorScope textAnnotatorScope = new TextAnnotatorScope(this.text);
            SnapshotStateList<Function1<TextAnnotatorScope, Unit>> snapshotStateList = this.annotators;
            int size = snapshotStateList.size();
            for (int i = 0; i < size; i++) {
                snapshotStateList.get(i).invoke(textAnnotatorScope);
            }
            styledText = textAnnotatorScope.getStyledText();
        }
        this.text = styledText;
        return styledText;
    }

    private final void StyleAnnotation(final Object[] objArr, final Function1<? super TextAnnotatorScope, Unit> function1, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2083052099);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StyleAnnotation)N(keys,block)316@13856L89,316@13825L120:TextLinkScope.kt#423gt5");
        int i2 = (i & 48) == 0 ? (composerStartRestartGroup.changedInstance(function1) ? 32 : 16) | i : i;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        composerStartRestartGroup.startMovableGroup(-358306546, Integer.valueOf(objArr.length));
        int i3 = i2 | (composerStartRestartGroup.changed(objArr.length) ? 4 : 0);
        for (Object obj : objArr) {
            i3 |= composerStartRestartGroup.changedInstance(obj) ? 4 : 0;
        }
        composerStartRestartGroup.endMovableGroup();
        if ((i3 & 14) == 0) {
            i3 |= 2;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2083052099, i3, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:315)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(function1);
            spreadBuilder.addSpread(objArr);
            Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -358303338, "CC(remember):TextLinkScope.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | ((i3 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextLinkScope.StyleAnnotation$lambda$0$0(this.f$0, function1, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(array, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TextLinkScope.StyleAnnotation$lambda$1(this.f$0, objArr, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult StyleAnnotation$lambda$0$0(final TextLinkScope textLinkScope, final Function1 function1, DisposableEffectScope disposableEffectScope) {
        textLinkScope.annotators.add(function1);
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$lambda$0$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                this.this$0.annotators.remove(function1);
            }
        };
    }
}
