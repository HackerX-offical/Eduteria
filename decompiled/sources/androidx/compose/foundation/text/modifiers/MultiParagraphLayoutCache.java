package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: MultiParagraphLayoutCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001eBk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002¢\u0006\u0004\bD\u0010?J\u001d\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020G2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)H\u0002¢\u0006\u0004\bL\u0010MJ'\u00103\u001a\u00020+2\u0006\u0010H\u001a\u00020)2\u0006\u0010N\u001a\u00020G2\u0006\u0010O\u001a\u00020PH\u0002¢\u0006\u0004\bQ\u0010RJ\u0016\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010H\u001a\u00020)Je\u0010U\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020'2\u0006\u0010H\u001a\u00020)H\u0002J\u001f\u0010Y\u001a\u00020P2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)H\u0002¢\u0006\u0004\bZ\u0010[J%\u0010\\\u001a\u00020\u000b*\u0004\u0018\u00010+2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)H\u0002¢\u0006\u0004\b]\u0010^J\b\u0010_\u001a\u00020AH\u0002J\b\u0010`\u001a\u00020AH\u0002J\u000e\u0010a\u001a\u00020\r2\u0006\u0010H\u001a\u00020)J\u000e\u0010b\u001a\u00020\r2\u0006\u0010H\u001a\u00020)J\b\u0010c\u001a\u00020dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0018\u00010/R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00100\u001a\u00060/R\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b7\u00105R$\u00108\u001a\u0002098\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation", "(Landroidx/compose/ui/unit/Density;)V", "setStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutCache", "Landroidx/compose/ui/text/TextLayoutResult;", "cachedIntrinsicHeightInputWidth", "cachedIntrinsicHeight", "_textAutoSizeLayoutScope", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "fontSizeSearchScope", "getFontSizeSearchScope", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutOrNull", "getLayoutOrNull", "historyFlag", "", "getHistoryFlag$foundation$annotations", "()V", "getHistoryFlag$foundation", "()J", "setHistoryFlag$foundation", "(J)V", "recordHistory", "", "op", "Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "recordHistory-4ETZmGE", "layoutWithConstraints", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "useMinLinesConstrainer", "useMinLinesConstrainer-Oh53vG4", "(JLandroidx/compose/ui/unit/LayoutDirection;)J", "finalConstraints", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "textLayoutResult-VKLhPVY", "(Landroidx/compose/ui/unit/LayoutDirection;JLandroidx/compose/ui/text/MultiParagraph;)Landroidx/compose/ui/text/TextLayoutResult;", "intrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, DiscoverItems.Item.UPDATE_ACTION, "update-J2qo7bo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Landroidx/compose/foundation/text/TextAutoSize;)V", "setLayoutDirection", "layoutText", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-VKLhPVY", "(Landroidx/compose/ui/text/TextLayoutResult;JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "markStyleAffectedDirty", "maxIntrinsicWidth", "minIntrinsicWidth", InAppPurchaseConstants.METHOD_TO_STRING, "", "TextAutoSizeLayoutScopeImpl", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiParagraphLayoutCache {
    public static final int $stable = 8;
    private TextAutoSizeLayoutScopeImpl _textAutoSizeLayoutScope;
    private TextAutoSize autoSize;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private FontFamily.Resolver fontFamilyResolver;
    private long historyFlag;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private TextLayoutResult layoutCache;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    public /* synthetic */ MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, List list, TextAutoSize textAutoSize, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, i, z, i2, i3, list, textAutoSize);
    }

    public static /* synthetic */ void getHistoryFlag$foundation$annotations() {
    }

    private MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list, TextAutoSize textAutoSize) {
        this.text = annotatedString;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.placeholders = list;
        this.autoSize = textAutoSize;
        this.lastDensity = InlineDensity.INSTANCE.m2207getUnspecifiedL26CHvs();
        this.style = textStyle;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    public /* synthetic */ MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, List list, TextAutoSize textAutoSize, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? TextOverflow.INSTANCE.m8765getClipgIe3tQ8() : i, (i4 & 16) != 0 ? true : z, (i4 & 32) != 0 ? Integer.MAX_VALUE : i2, (i4 & 64) != 0 ? 1 : i3, (i4 & 128) != 0 ? null : list, (i4 & 256) != 0 ? null : textAutoSize, null);
    }

    /* JADX INFO: renamed from: getDensity$foundation, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$foundation(Density density) {
        Density density2 = this.density;
        long jM2199constructorimpl = density != null ? InlineDensity.m2199constructorimpl(density) : InlineDensity.INSTANCE.m2207getUnspecifiedL26CHvs();
        if (density2 == null) {
            this.density = density;
            this.lastDensity = jM2199constructorimpl;
        } else if (density == null || !InlineDensity.m2201equalsimpl0(this.lastDensity, jM2199constructorimpl)) {
            this.density = density;
            this.lastDensity = jM2199constructorimpl;
            m2230recordHistory4ETZmGE(LayoutCacheOperation.INSTANCE.m2216getMarkDirtyDensityDEKiAbY());
            markDirty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStyle(TextStyle textStyle) {
        boolean zHasSameLayoutAffectingAttributes = textStyle.hasSameLayoutAffectingAttributes(this.style);
        this.style = textStyle;
        if (zHasSameLayoutAffectingAttributes) {
            return;
        }
        markStyleAffectedDirty();
    }

    private final TextAutoSizeLayoutScopeImpl getFontSizeSearchScope() {
        if (this._textAutoSizeLayoutScope == null) {
            this._textAutoSizeLayoutScope = new TextAutoSizeLayoutScopeImpl();
        }
        TextAutoSizeLayoutScopeImpl textAutoSizeLayoutScopeImpl = this._textAutoSizeLayoutScope;
        Intrinsics.checkNotNull(textAutoSizeLayoutScopeImpl);
        return textAutoSizeLayoutScopeImpl;
    }

    public final TextLayoutResult getTextLayoutResult() {
        TextLayoutResult textLayoutResult = this.layoutCache;
        if (textLayoutResult != null) {
            return textLayoutResult;
        }
        throw new IllegalStateException("Internal Error: MultiParagraphLayoutCache could not provide TextLayoutResult during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: " + this);
    }

    /* JADX INFO: renamed from: getLayoutOrNull, reason: from getter */
    public final TextLayoutResult getLayoutCache() {
        return this.layoutCache;
    }

    /* JADX INFO: renamed from: getHistoryFlag$foundation, reason: from getter */
    public final long getHistoryFlag() {
        return this.historyFlag;
    }

    public final void setHistoryFlag$foundation(long j) {
        this.historyFlag = j;
    }

    /* JADX INFO: renamed from: recordHistory-4ETZmGE, reason: not valid java name */
    private final void m2230recordHistory4ETZmGE(long op) {
        this.historyFlag = op | (this.historyFlag << 2);
    }

    /* JADX INFO: renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m2233layoutWithConstraintsK40F9xA(long constraints, LayoutDirection layoutDirection) {
        m2230recordHistory4ETZmGE(LayoutCacheOperation.INSTANCE.m2215getLayoutWithConstraintsDEKiAbY());
        long jM2232useMinLinesConstrainerOh53vG4 = this.minLines > 1 ? m2232useMinLinesConstrainerOh53vG4(constraints, layoutDirection) : constraints;
        if (!m2229newLayoutWillBeDifferentVKLhPVY(this.layoutCache, jM2232useMinLinesConstrainerOh53vG4, layoutDirection)) {
            TextLayoutResult textLayoutResult = this.layoutCache;
            Intrinsics.checkNotNull(textLayoutResult);
            if (Constraints.m8776equalsimpl0(jM2232useMinLinesConstrainerOh53vG4, textLayoutResult.getLayoutInput().getConstraints())) {
                return false;
            }
            TextLayoutResult textLayoutResult2 = this.layoutCache;
            Intrinsics.checkNotNull(textLayoutResult2);
            this.layoutCache = m2231textLayoutResultVKLhPVY(layoutDirection, jM2232useMinLinesConstrainerOh53vG4, textLayoutResult2.getMultiParagraph());
            return true;
        }
        if (this.autoSize != null) {
            this.intrinsicsLayoutDirection = layoutDirection;
            long jM8304getFontSizeXSAIIZE = this.style.m8304getFontSizeXSAIIZE();
            TextAutoSize textAutoSize = this.autoSize;
            Intrinsics.checkNotNull(textAutoSize);
            long jMo1637getFontSizeCi0_558 = textAutoSize.mo1637getFontSizeCi0_558(getFontSizeSearchScope(), constraints, this.text);
            if (TextUnit.m9026isEmimpl(jMo1637getFontSizeCi0_558)) {
                jMo1637getFontSizeCi0_558 = MultiParagraphLayoutCacheKt.m2237timesNB67dxo(jM8304getFontSizeXSAIIZE, jMo1637getFontSizeCi0_558);
            }
            long j = jMo1637getFontSizeCi0_558;
            TextLayoutResult lastLayoutResult = getFontSizeSearchScope().getLastLayoutResult();
            if (lastLayoutResult != null && TextUnit.m9021equalsimpl0(j, lastLayoutResult.getLayoutInput().getStyle().m8304getFontSizeXSAIIZE()) && TextOverflow.m8756equalsimpl0(lastLayoutResult.getLayoutInput().getOverflow(), this.overflow)) {
                this.layoutCache = lastLayoutResult;
                return true;
            }
            setStyle(TextStyle.m8286copyp1EtxEg$default(this.style, 0L, j, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null));
        }
        this.layoutCache = m2231textLayoutResultVKLhPVY(layoutDirection, jM2232useMinLinesConstrainerOh53vG4, m2228layoutTextK40F9xA(jM2232useMinLinesConstrainerOh53vG4, layoutDirection));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: useMinLinesConstrainer-Oh53vG4, reason: not valid java name */
    public final long m2232useMinLinesConstrainerOh53vG4(long constraints, LayoutDirection layoutDirection) {
        MinLinesConstrainer.Companion companion = MinLinesConstrainer.INSTANCE;
        MinLinesConstrainer minLinesConstrainer = this.mMinLinesConstrainer;
        TextStyle textStyle = this.style;
        Density density = this.density;
        Intrinsics.checkNotNull(density);
        MinLinesConstrainer minLinesConstrainerFrom = companion.from(minLinesConstrainer, layoutDirection, textStyle, density, this.fontFamilyResolver);
        this.mMinLinesConstrainer = minLinesConstrainerFrom;
        return minLinesConstrainerFrom.m2223coerceMinLinesOh53vG4$foundation(constraints, this.minLines);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: textLayoutResult-VKLhPVY, reason: not valid java name */
    public final TextLayoutResult m2231textLayoutResultVKLhPVY(LayoutDirection layoutDirection, long finalConstraints, MultiParagraph multiParagraph) {
        float fMin = Math.min(multiParagraph.getIntrinsics().getMaxIntrinsicWidth(), multiParagraph.getWidth());
        AnnotatedString annotatedString = this.text;
        TextStyle textStyle = this.style;
        List<AnnotatedString.Range<Placeholder>> listEmptyList = this.placeholders;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        int i = this.maxLines;
        boolean z = this.softWrap;
        int i2 = this.overflow;
        Density density = this.density;
        Intrinsics.checkNotNull(density);
        return new TextLayoutResult(new TextLayoutInput(annotatedString, textStyle, listEmptyList, i, z, i2, density, layoutDirection, this.fontFamilyResolver, finalConstraints, (DefaultConstructorMarker) null), multiParagraph, ConstraintsKt.m8797constrain4WqzIAM(finalConstraints, IntSize.m8996constructorimpl((((long) TextDelegateKt.ceilToIntPx(fMin)) << 32) | (((long) TextDelegateKt.ceilToIntPx(multiParagraph.getHeight())) & 4294967295L))), null);
    }

    public final int intrinsicHeight(int width, LayoutDirection layoutDirection) {
        int i = this.cachedIntrinsicHeightInputWidth;
        int i2 = this.cachedIntrinsicHeight;
        if (width == i && i != -1) {
            return i2;
        }
        long jConstraints = ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE);
        if (this.minLines > 1) {
            jConstraints = m2232useMinLinesConstrainerOh53vG4(jConstraints, layoutDirection);
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(TextDelegateKt.ceilToIntPx(m2228layoutTextK40F9xA(jConstraints, layoutDirection).getHeight()), Constraints.m8784getMinHeightimpl(jConstraints));
        this.cachedIntrinsicHeightInputWidth = width;
        this.cachedIntrinsicHeight = iCoerceAtLeast;
        return iCoerceAtLeast;
    }

    /* JADX INFO: renamed from: update-J2qo7bo, reason: not valid java name */
    public final void m2234updateJ2qo7bo(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders, TextAutoSize autoSize) {
        this.text = text;
        setStyle(style);
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.placeholders = placeholders;
        this.autoSize = autoSize;
        m2230recordHistory4ETZmGE(LayoutCacheOperation.INSTANCE.m2217getMarkDirtyNodeDEKiAbY());
        markDirty();
    }

    private final MultiParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || multiParagraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            AnnotatedString annotatedString = this.text;
            TextStyle textStyleResolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            FontFamily.Resolver resolver = this.fontFamilyResolver;
            List<AnnotatedString.Range<Placeholder>> listEmptyList = this.placeholders;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, textStyleResolveDefaults, listEmptyList, density, resolver);
        }
        this.paragraphIntrinsics = multiParagraphIntrinsics;
        return multiParagraphIntrinsics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: layoutText-K40F9xA, reason: not valid java name */
    public final MultiParagraph m2228layoutTextK40F9xA(long constraints, LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        return new MultiParagraph(layoutDirection2, LayoutUtilsKt.m2219finalConstraintstfFHcEY(constraints, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth()), LayoutUtilsKt.m2220finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), this.overflow, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: newLayoutWillBeDifferent-VKLhPVY, reason: not valid java name */
    private final boolean m2229newLayoutWillBeDifferentVKLhPVY(TextLayoutResult textLayoutResult, long j, LayoutDirection layoutDirection) {
        if (textLayoutResult == null || textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() || layoutDirection != textLayoutResult.getLayoutInput().getLayoutDirection()) {
            return true;
        }
        if (Constraints.m8776equalsimpl0(j, textLayoutResult.getLayoutInput().getConstraints())) {
            return false;
        }
        return Constraints.m8783getMaxWidthimpl(j) != Constraints.m8783getMaxWidthimpl(textLayoutResult.getLayoutInput().getConstraints()) || Constraints.m8785getMinWidthimpl(j) != Constraints.m8785getMinWidthimpl(textLayoutResult.getLayoutInput().getConstraints()) || ((float) Constraints.m8782getMaxHeightimpl(j)) < textLayoutResult.getMultiParagraph().getHeight() || textLayoutResult.getMultiParagraph().getDidExceedMaxLines();
    }

    private final void markDirty() {
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
        this.cachedIntrinsicHeight = -1;
        this.cachedIntrinsicHeightInputWidth = -1;
        this._textAutoSizeLayoutScope = null;
    }

    private final void markStyleAffectedDirty() {
        m2230recordHistory4ETZmGE(LayoutCacheOperation.INSTANCE.m2218getMarkDirtyStyleDEKiAbY());
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
        this.cachedIntrinsicHeight = -1;
        this.cachedIntrinsicHeightInputWidth = -1;
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    /* JADX INFO: compiled from: MultiParagraphLayoutCache.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0005*\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "<init>", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "lastLayoutResult", "getLastLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "performLayout", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "performLayout-5ZSfY2I", "(JLandroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/TextLayoutResult;", "toPx", "toPx--R2X_6o", "(J)F", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class TextAutoSizeLayoutScopeImpl implements TextAutoSizeLayoutScope {
        private TextLayoutResult lastLayoutResult;

        public TextAutoSizeLayoutScopeImpl() {
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            Density density = MultiParagraphLayoutCache.this.getDensity();
            Intrinsics.checkNotNull(density);
            return density.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            Density density = MultiParagraphLayoutCache.this.getDensity();
            Intrinsics.checkNotNull(density);
            return density.getFontScale();
        }

        public final TextLayoutResult getLastLayoutResult() {
            return this.lastLayoutResult;
        }

        @Override // androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope
        /* JADX INFO: renamed from: performLayout-5ZSfY2I, reason: not valid java name */
        public TextLayoutResult mo2235performLayout5ZSfY2I(long constraints, AnnotatedString text, long fontSize) {
            long jM2232useMinLinesConstrainerOh53vG4;
            TextStyle textStyle = MultiParagraphLayoutCache.this.style;
            long jM2237timesNB67dxo = TextUnit.m9026isEmimpl(fontSize) ? MultiParagraphLayoutCacheKt.m2237timesNB67dxo(MultiParagraphLayoutCache.this.style.m8304getFontSizeXSAIIZE(), fontSize) : fontSize;
            if (!TextUnit.m9021equalsimpl0(jM2237timesNB67dxo, MultiParagraphLayoutCache.this.style.m8304getFontSizeXSAIIZE())) {
                MultiParagraphLayoutCache multiParagraphLayoutCache = MultiParagraphLayoutCache.this;
                multiParagraphLayoutCache.setStyle(TextStyle.m8286copyp1EtxEg$default(multiParagraphLayoutCache.style, 0L, jM2237timesNB67dxo, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null));
            }
            if (MultiParagraphLayoutCache.this.minLines > 1) {
                MultiParagraphLayoutCache multiParagraphLayoutCache2 = MultiParagraphLayoutCache.this;
                LayoutDirection layoutDirection = multiParagraphLayoutCache2.intrinsicsLayoutDirection;
                Intrinsics.checkNotNull(layoutDirection);
                jM2232useMinLinesConstrainerOh53vG4 = multiParagraphLayoutCache2.m2232useMinLinesConstrainerOh53vG4(constraints, layoutDirection);
            } else {
                jM2232useMinLinesConstrainerOh53vG4 = constraints;
            }
            MultiParagraphLayoutCache multiParagraphLayoutCache3 = MultiParagraphLayoutCache.this;
            LayoutDirection layoutDirection2 = multiParagraphLayoutCache3.intrinsicsLayoutDirection;
            Intrinsics.checkNotNull(layoutDirection2);
            MultiParagraph multiParagraphM2228layoutTextK40F9xA = multiParagraphLayoutCache3.m2228layoutTextK40F9xA(jM2232useMinLinesConstrainerOh53vG4, layoutDirection2);
            MultiParagraphLayoutCache multiParagraphLayoutCache4 = MultiParagraphLayoutCache.this;
            LayoutDirection layoutDirection3 = multiParagraphLayoutCache4.intrinsicsLayoutDirection;
            Intrinsics.checkNotNull(layoutDirection3);
            TextLayoutResult textLayoutResultM2231textLayoutResultVKLhPVY = multiParagraphLayoutCache4.m2231textLayoutResultVKLhPVY(layoutDirection3, jM2232useMinLinesConstrainerOh53vG4, multiParagraphM2228layoutTextK40F9xA);
            this.lastLayoutResult = textLayoutResultM2231textLayoutResultVKLhPVY;
            MultiParagraphLayoutCache.this.setStyle(textStyle);
            return textLayoutResultM2231textLayoutResultVKLhPVY;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public float mo487toPxR2X_6o(long j) {
            if (TextUnit.m9026isEmimpl(j)) {
                if (!TextUnit.m9026isEmimpl(MultiParagraphLayoutCache.this.style.m8304getFontSizeXSAIIZE())) {
                    if (!TextUnit.m9021equalsimpl0(MultiParagraphLayoutCache.this.style.m8304getFontSizeXSAIIZE(), TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE())) {
                        return mo487toPxR2X_6o(MultiParagraphLayoutCache.this.style.m8304getFontSizeXSAIIZE()) * TextUnit.m9024getValueimpl(j);
                    }
                    throw new IllegalStateException("InternalAutoSize -> toPx(): Cannot convert Em to Px when style.fontSize is not set. Please specify a font size.".toString());
                }
                throw new IllegalStateException("InternalAutoSize -> toPx(): Cannot convert Em to Px when style.fontSize is Em\nDeclare the composable's style.fontSize with Sp units instead.".toString());
            }
            return mo488toPx0680j_4(mo483toDpGaN1DYA(j));
        }
    }

    public String toString() {
        TextLayoutInput layoutInput;
        StringBuilder sb = new StringBuilder("MultiParagraphLayoutCache(textLayoutResult=");
        TextLayoutResult textLayoutResult = this.layoutCache;
        Object objM8770boximpl = Constants.NULL_VERSION_ID;
        StringBuilder sbAppend = sb.append(textLayoutResult != null ? "<TextLayoutResult>" : Constants.NULL_VERSION_ID).append(", lastDensity=").append((Object) InlineDensity.m2205toStringimpl(this.lastDensity)).append(", history=").append(this.historyFlag).append(", constraints=");
        TextLayoutResult textLayoutResult2 = this.layoutCache;
        if (textLayoutResult2 != null && (layoutInput = textLayoutResult2.getLayoutInput()) != null) {
            objM8770boximpl = Constraints.m8770boximpl(layoutInput.getConstraints());
        }
        return sbAppend.append(objM8770boximpl).append(')').toString();
    }
}
