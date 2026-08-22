package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextAutoSize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0015\u001a\u00020\u0012*\u00020\u0013H\u0002J\u0013\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/AutoSizeStepBased;", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getFontSize", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "didOverflow", "", "Landroidx/compose/ui/text/TextLayoutResult;", "didOverflowBounds", "didOverflowByEllipsize", "equals", "other", "", "hashCode", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AutoSizeStepBased implements TextAutoSize {
    private final long maxFontSize;
    private long minFontSize;
    private final long stepSize;

    public /* synthetic */ AutoSizeStepBased(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private AutoSizeStepBased(long j, long j2, long j3) {
        this.minFontSize = j;
        this.maxFontSize = j2;
        this.stepSize = j3;
        if (TextUnit.m9021equalsimpl0(j, TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for minFontSize. Try using other values e.g. 10.sp");
        }
        if (TextUnit.m9021equalsimpl0(j2, TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for maxFontSize. Try using other values e.g. 100.sp");
        }
        if (TextUnit.m9021equalsimpl0(j3, TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for stepSize. Try using other values e.g. 0.25.sp");
        }
        if (TextUnitType.m9052equalsimpl0(TextUnit.m9023getTypeUIouoOA(this.minFontSize), TextUnit.m9023getTypeUIouoOA(j2))) {
            long j4 = this.minFontSize;
            TextUnitKt.m9038checkArithmeticNB67dxo(j4, j2);
            if (Float.compare(TextUnit.m9024getValueimpl(j4), TextUnit.m9024getValueimpl(j2)) > 0) {
                this.minFontSize = j2;
            }
        }
        if (TextUnitType.m9052equalsimpl0(TextUnit.m9023getTypeUIouoOA(j3), TextUnitType.INSTANCE.m9057getSpUIouoOA())) {
            long sp = TextUnitKt.getSp(1.0E-4f);
            TextUnitKt.m9038checkArithmeticNB67dxo(j3, sp);
            if (Float.compare(TextUnit.m9024getValueimpl(j3), TextUnit.m9024getValueimpl(sp)) < 0) {
                throw new IllegalArgumentException("AutoSize.StepBased: stepSize must be greater than or equal to 0.0001f.sp");
            }
        }
        if (TextUnit.m9024getValueimpl(this.minFontSize) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: minFontSize must not be negative");
        }
        if (TextUnit.m9024getValueimpl(j2) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: maxFontSize must not be negative");
        }
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    /* JADX INFO: renamed from: getFontSize-Ci0_558, reason: not valid java name */
    public long mo1637getFontSizeCi0_558(TextAutoSizeLayoutScope textAutoSizeLayoutScope, long j, AnnotatedString annotatedString) {
        float f2 = textAutoSizeLayoutScope.mo487toPxR2X_6o(this.stepSize);
        float f3 = textAutoSizeLayoutScope.mo487toPxR2X_6o(this.minFontSize);
        float f4 = textAutoSizeLayoutScope.mo487toPxR2X_6o(this.maxFontSize);
        float f5 = 2;
        float f6 = (f3 + f4) / f5;
        float f7 = f3;
        float f8 = f4;
        while (f8 - f7 >= f2) {
            if (didOverflow(textAutoSizeLayoutScope.mo2235performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo491toSpkPz2Gy4(f6)))) {
                f8 = f6;
            } else {
                f7 = f6;
            }
            f6 = (f7 + f8) / f5;
        }
        float fFloor = f3 + (((float) Math.floor((f7 - f3) / f2)) * f2);
        float f9 = f2 + fFloor;
        if (f9 <= f4 && !didOverflow(textAutoSizeLayoutScope.mo2235performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo491toSpkPz2Gy4(f9)))) {
            fFloor = f9;
        }
        return textAutoSizeLayoutScope.mo491toSpkPz2Gy4(fFloor);
    }

    private final boolean didOverflow(TextLayoutResult textLayoutResult) {
        int overflow = textLayoutResult.getLayoutInput().getOverflow();
        if (TextOverflow.m8756equalsimpl0(overflow, TextOverflow.INSTANCE.m8765getClipgIe3tQ8()) || TextOverflow.m8756equalsimpl0(overflow, TextOverflow.INSTANCE.m8769getVisiblegIe3tQ8())) {
            return didOverflowBounds(textLayoutResult);
        }
        if (TextOverflow.m8756equalsimpl0(overflow, TextOverflow.INSTANCE.m8768getStartEllipsisgIe3tQ8()) || TextOverflow.m8756equalsimpl0(overflow, TextOverflow.INSTANCE.m8767getMiddleEllipsisgIe3tQ8()) || TextOverflow.m8756equalsimpl0(overflow, TextOverflow.INSTANCE.m8766getEllipsisgIe3tQ8())) {
            return didOverflowByEllipsize(textLayoutResult);
        }
        throw new IllegalArgumentException("TextOverflow type " + ((Object) TextOverflow.m8758toStringimpl(textLayoutResult.getLayoutInput().getOverflow())) + " is not supported.");
    }

    private final boolean didOverflowBounds(TextLayoutResult textLayoutResult) {
        return textLayoutResult.getDidOverflowWidth() || textLayoutResult.getDidOverflowHeight();
    }

    private final boolean didOverflowByEllipsize(TextLayoutResult textLayoutResult) {
        int lineCount = textLayoutResult.getLineCount();
        if (lineCount == 0) {
            return false;
        }
        if (lineCount == 1) {
            return textLayoutResult.isLineEllipsized(0);
        }
        int overflow = textLayoutResult.getLayoutInput().getOverflow();
        if (TextOverflow.m8756equalsimpl0(overflow, TextOverflow.INSTANCE.m8768getStartEllipsisgIe3tQ8()) || TextOverflow.m8756equalsimpl0(overflow, TextOverflow.INSTANCE.m8767getMiddleEllipsisgIe3tQ8())) {
            return didOverflowBounds(textLayoutResult);
        }
        if (TextOverflow.m8756equalsimpl0(overflow, TextOverflow.INSTANCE.m8766getEllipsisgIe3tQ8())) {
            return textLayoutResult.isLineEllipsized(textLayoutResult.getLineCount() - 1);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || !(other instanceof AutoSizeStepBased)) {
            return false;
        }
        AutoSizeStepBased autoSizeStepBased = (AutoSizeStepBased) other;
        return TextUnit.m9021equalsimpl0(autoSizeStepBased.minFontSize, this.minFontSize) && TextUnit.m9021equalsimpl0(autoSizeStepBased.maxFontSize, this.maxFontSize) && TextUnit.m9021equalsimpl0(autoSizeStepBased.stepSize, this.stepSize);
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public int hashCode() {
        return (((TextUnit.m9025hashCodeimpl(this.minFontSize) * 31) + TextUnit.m9025hashCodeimpl(this.maxFontSize)) * 31) + TextUnit.m9025hashCodeimpl(this.stepSize);
    }
}
