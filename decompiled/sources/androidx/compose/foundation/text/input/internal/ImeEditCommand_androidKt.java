package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.clevertap.android.sdk.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ImeEditCommand.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a8\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f\u0018\u00010\fH\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002\u001a$\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001dH\u0001\u001a\u001c\u0010\u001e\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0001¨\u0006\u001f"}, d2 = {"commitText", "", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "text", "", "newCursorPosition", "", "setComposingRegion", "start", "end", "setComposingText", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "setSelection", "isSurrogatePair", "", Constants.PRIORITY_HIGH, "", "low", "imeReplace", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "", "imeDelete", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ImeEditCommand_androidKt {
    public static final void commitText(ImeEditCommandScope imeEditCommandScope, final String str, final int i) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.commitText$lambda$0(str, i, (TextFieldBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commitText$lambda$0(String str, int i, TextFieldBuffer textFieldBuffer) {
        TextRange composition = textFieldBuffer.getComposition();
        if (composition != null) {
            imeReplace(textFieldBuffer, TextRange.m8273getStartimpl(composition.getPackedValue()), TextRange.m8268getEndimpl(composition.getPackedValue()), str);
        } else {
            imeReplace(textFieldBuffer, TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars()), TextRange.m8270getMaximpl(textFieldBuffer.getSelectionInChars()), str);
        }
        textFieldBuffer.m1923setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i > 0 ? (r0 + i) - 1 : (TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars()) + i) - str.length(), 0, textFieldBuffer.getLength())));
        return Unit.INSTANCE;
    }

    public static final void setComposingRegion(final ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.setComposingRegion$lambda$0(i, i2, imeEditCommandScope, (TextFieldBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setComposingRegion$lambda$0(int i, int i2, ImeEditCommandScope imeEditCommandScope, TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.hasComposition$foundation()) {
            textFieldBuffer.commitComposition$foundation();
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        long jMo1958mapFromTransformedGEjPoXI = imeEditCommandScope.mo1958mapFromTransformedGEjPoXI(TextRangeKt.TextRange(i, i2));
        int iCoerceIn = RangesKt.coerceIn(TextRange.m8271getMinimpl(jMo1958mapFromTransformedGEjPoXI), 0, textFieldBuffer.getLength());
        int iCoerceIn2 = RangesKt.coerceIn(TextRange.m8270getMaximpl(jMo1958mapFromTransformedGEjPoXI), 0, textFieldBuffer.getLength());
        if (iCoerceIn != iCoerceIn2) {
            if (iCoerceIn < iCoerceIn2) {
                TextFieldBuffer.setComposition$foundation$default(textFieldBuffer, iCoerceIn, iCoerceIn2, null, 4, null);
            } else {
                TextFieldBuffer.setComposition$foundation$default(textFieldBuffer, iCoerceIn2, iCoerceIn, null, 4, null);
            }
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void setComposingText$default(ImeEditCommandScope imeEditCommandScope, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list = null;
        }
        setComposingText(imeEditCommandScope, str, i, list);
    }

    public static final void setComposingText(ImeEditCommandScope imeEditCommandScope, final String str, final int i, final List<AnnotatedString.Range<AnnotatedString.Annotation>> list) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.setComposingText$lambda$0(str, list, i, (TextFieldBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setComposingText$lambda$0(String str, List list, int i, TextFieldBuffer textFieldBuffer) {
        TextRange composition = textFieldBuffer.getComposition();
        if (composition != null) {
            String str2 = str;
            imeReplace(textFieldBuffer, TextRange.m8273getStartimpl(composition.getPackedValue()), TextRange.m8268getEndimpl(composition.getPackedValue()), str2);
            if (str2.length() > 0) {
                textFieldBuffer.setComposition$foundation(TextRange.m8273getStartimpl(composition.getPackedValue()), TextRange.m8273getStartimpl(composition.getPackedValue()) + str.length(), list);
            }
        } else {
            int iM8271getMinimpl = TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars());
            String str3 = str;
            imeReplace(textFieldBuffer, iM8271getMinimpl, TextRange.m8270getMaximpl(textFieldBuffer.getSelectionInChars()), str3);
            if (str3.length() > 0) {
                textFieldBuffer.setComposition$foundation(iM8271getMinimpl, str.length() + iM8271getMinimpl, list);
            }
        }
        textFieldBuffer.m1923setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i > 0 ? (r5 + i) - 1 : (TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars()) + i) - str.length(), 0, textFieldBuffer.getLength())));
        return Unit.INSTANCE;
    }

    public static final void deleteSurroundingText(final ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.deleteSurroundingText$lambda$0(i, i2, imeEditCommandScope, (TextFieldBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteSurroundingText$lambda$0(int i, int i2, ImeEditCommandScope imeEditCommandScope, TextFieldBuffer textFieldBuffer) {
        if (!(i >= 0 && i2 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
        }
        long jMo1959mapToTransformedGEjPoXI = imeEditCommandScope.mo1959mapToTransformedGEjPoXI(textFieldBuffer.getSelectionInChars());
        int iM8270getMaximpl = TextRange.m8270getMaximpl(jMo1959mapToTransformedGEjPoXI);
        int transformedLength = iM8270getMaximpl + i2;
        if (((i2 ^ transformedLength) & (iM8270getMaximpl ^ transformedLength)) < 0) {
            transformedLength = imeEditCommandScope.getTransformedLength();
        }
        long jMo1958mapFromTransformedGEjPoXI = imeEditCommandScope.mo1958mapFromTransformedGEjPoXI(TextRangeKt.TextRange(TextRange.m8270getMaximpl(jMo1959mapToTransformedGEjPoXI), Math.min(transformedLength, imeEditCommandScope.getTransformedLength())));
        imeDelete(textFieldBuffer, TextRange.m8271getMinimpl(jMo1958mapFromTransformedGEjPoXI), TextRange.m8270getMaximpl(jMo1958mapFromTransformedGEjPoXI));
        int iM8271getMinimpl = TextRange.m8271getMinimpl(jMo1959mapToTransformedGEjPoXI);
        int i3 = iM8271getMinimpl - i;
        if (((i ^ iM8271getMinimpl) & (iM8271getMinimpl ^ i3)) < 0) {
            i3 = 0;
        }
        long jMo1958mapFromTransformedGEjPoXI2 = imeEditCommandScope.mo1958mapFromTransformedGEjPoXI(TextRangeKt.TextRange(Math.max(0, i3), TextRange.m8271getMinimpl(jMo1959mapToTransformedGEjPoXI)));
        imeDelete(textFieldBuffer, TextRange.m8271getMinimpl(jMo1958mapFromTransformedGEjPoXI2), TextRange.m8270getMaximpl(jMo1958mapFromTransformedGEjPoXI2));
        return Unit.INSTANCE;
    }

    public static final void deleteSurroundingTextInCodePoints(ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.deleteSurroundingTextInCodePoints$lambda$0(i, i2, (TextFieldBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteSurroundingTextInCodePoints$lambda$0(int i, int i2, TextFieldBuffer textFieldBuffer) {
        int i3 = 0;
        if (!(i >= 0 && i2 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
        }
        int i4 = 0;
        int iM8271getMinimpl = 0;
        while (true) {
            if (i4 < i) {
                int i5 = iM8271getMinimpl + 1;
                if (TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars()) > i5) {
                    iM8271getMinimpl = isSurrogatePair(textFieldBuffer.asCharSequence().charAt((TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars()) - i5) - 1), textFieldBuffer.asCharSequence().charAt(TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars()) - i5)) ? iM8271getMinimpl + 2 : i5;
                    i4++;
                } else {
                    iM8271getMinimpl = TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars());
                    break;
                }
            } else {
                break;
            }
        }
        int length = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i6 = length + 1;
            if (TextRange.m8270getMaximpl(textFieldBuffer.getSelectionInChars()) + i6 < textFieldBuffer.getLength()) {
                length = isSurrogatePair(textFieldBuffer.asCharSequence().charAt((TextRange.m8270getMaximpl(textFieldBuffer.getSelectionInChars()) + i6) - 1), textFieldBuffer.asCharSequence().charAt(TextRange.m8270getMaximpl(textFieldBuffer.getSelectionInChars()) + i6)) ? length + 2 : i6;
                i3++;
            } else {
                length = textFieldBuffer.getLength() - TextRange.m8270getMaximpl(textFieldBuffer.getSelectionInChars());
                break;
            }
        }
        imeDelete(textFieldBuffer, TextRange.m8270getMaximpl(textFieldBuffer.getSelectionInChars()), TextRange.m8270getMaximpl(textFieldBuffer.getSelectionInChars()) + length);
        imeDelete(textFieldBuffer, TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars()) - iM8271getMinimpl, TextRange.m8271getMinimpl(textFieldBuffer.getSelectionInChars()));
        return Unit.INSTANCE;
    }

    public static final void finishComposingText(ImeEditCommandScope imeEditCommandScope) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.finishComposingText$lambda$0((TextFieldBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit finishComposingText$lambda$0(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.commitComposition$foundation();
        return Unit.INSTANCE;
    }

    public static final void setSelection(final ImeEditCommandScope imeEditCommandScope, final int i, final int i2) {
        imeEditCommandScope.edit(new Function1() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImeEditCommand_androidKt.setSelection$lambda$0(imeEditCommandScope, i, i2, (TextFieldBuffer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSelection$lambda$0(ImeEditCommandScope imeEditCommandScope, int i, int i2, TextFieldBuffer textFieldBuffer) {
        long jMo1959mapToTransformedGEjPoXI = imeEditCommandScope.mo1959mapToTransformedGEjPoXI(TextRangeKt.TextRange(0, textFieldBuffer.getLength()));
        int iM8271getMinimpl = TextRange.m8271getMinimpl(jMo1959mapToTransformedGEjPoXI);
        int iM8270getMaximpl = TextRange.m8270getMaximpl(jMo1959mapToTransformedGEjPoXI);
        if (i < iM8271getMinimpl) {
            i = iM8271getMinimpl;
        }
        if (i <= iM8270getMaximpl) {
            iM8270getMaximpl = i;
        }
        int iM8271getMinimpl2 = TextRange.m8271getMinimpl(jMo1959mapToTransformedGEjPoXI);
        int iM8270getMaximpl2 = TextRange.m8270getMaximpl(jMo1959mapToTransformedGEjPoXI);
        if (i2 < iM8271getMinimpl2) {
            i2 = iM8271getMinimpl2;
        }
        if (i2 <= iM8270getMaximpl2) {
            iM8270getMaximpl2 = i2;
        }
        textFieldBuffer.m1923setSelection5zctL8(imeEditCommandScope.mo1958mapFromTransformedGEjPoXI(TextRangeKt.TextRange(iM8270getMaximpl, iM8270getMaximpl2)));
        return Unit.INSTANCE;
    }

    private static final boolean isSurrogatePair(char c2, char c3) {
        return Character.isHighSurrogate(c2) && Character.isLowSurrogate(c3);
    }

    public static final void imeReplace(TextFieldBuffer textFieldBuffer, int i, int i2, CharSequence charSequence) {
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        int i3 = 0;
        int i4 = iMin;
        while (i4 < iMax && i3 < charSequence.length() && charSequence.charAt(i3) == textFieldBuffer.asCharSequence().charAt(i4)) {
            i3++;
            i4++;
        }
        int length = charSequence.length();
        while (iMax > i4 && length > i3 && charSequence.charAt(length - 1) == textFieldBuffer.asCharSequence().charAt(iMax - 1)) {
            length--;
            iMax--;
        }
        if (i4 != iMax || i3 != length) {
            textFieldBuffer.replace(i4, iMax, charSequence.subSequence(i3, length));
        } else {
            textFieldBuffer.commitComposition$foundation();
            textFieldBuffer.clearHighlight$foundation();
        }
        textFieldBuffer.m1923setSelection5zctL8(TextRangeKt.TextRange(iMin + charSequence.length()));
    }

    public static final void imeDelete(TextFieldBuffer textFieldBuffer, int i, int i2) {
        TextRange composition = textFieldBuffer.getComposition();
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        TextFieldBufferKt.delete(textFieldBuffer, iMin, iMax);
        if (composition != null) {
            composition.getPackedValue();
            long jM1927adjustTextRangevJH6DeI = TextFieldBufferKt.m1927adjustTextRangevJH6DeI(composition.getPackedValue(), iMin, iMax, 0);
            if (TextRange.m8267getCollapsedimpl(jM1927adjustTextRangevJH6DeI)) {
                textFieldBuffer.commitComposition$foundation();
            } else {
                TextFieldBuffer.setComposition$foundation$default(textFieldBuffer, TextRange.m8271getMinimpl(jM1927adjustTextRangevJH6DeI), TextRange.m8270getMaximpl(jM1927adjustTextRangevJH6DeI), null, 4, null);
            }
        }
    }
}
