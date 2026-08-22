package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: TextFieldBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e\u001a\u001a\u0010\u000f\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004\u001a\n\u0010\u0012\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\u0013\u001a\u00020\n*\u00020\u000b\u001aE\u0010\u0014\u001a\u00020\n*\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u0017H\u0087\b\u001aE\u0010\u001b\u001a\u00020\n*\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\n0\u0017H\u0087\b\u001a{\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2`\u0010 \u001a\\\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\n0!H\u0080\b\u001a\u001e\u0010&\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0000¨\u0006'"}, d2 = {"adjustTextRange", "Landroidx/compose/ui/text/TextRange;", "originalRange", "replaceStart", "", "replaceEnd", "insertedTextLength", "adjustTextRange-vJH6DeI", "(JIII)J", "insert", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", FirebaseAnalytics.Param.INDEX, "text", "", "delete", "start", "end", "placeCursorAtEnd", "selectAll", "forEachChange", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "range", "forEachChangeReversed", "findCommonPrefixAndSuffix", "a", "", "b", "onFound", "Lkotlin/Function4;", "aPrefixStart", "aSuffixStart", "bPrefixStart", "bSuffixStart", "setSelectionCoerced", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldBufferKt {
    /* JADX INFO: renamed from: adjustTextRange-vJH6DeI, reason: not valid java name */
    public static final long m1927adjustTextRangevJH6DeI(long j, int i, int i2, int i3) {
        int i4;
        int iM8271getMinimpl = TextRange.m8271getMinimpl(j);
        int iM8270getMaximpl = TextRange.m8270getMaximpl(j);
        if (iM8270getMaximpl < i) {
            return j;
        }
        if (iM8271getMinimpl <= i && i2 <= iM8270getMaximpl) {
            i4 = i3 - (i2 - i);
            if (iM8271getMinimpl == iM8270getMaximpl) {
                iM8271getMinimpl += i4;
            }
            i = iM8270getMaximpl + i4;
        } else if (iM8271getMinimpl > i && iM8270getMaximpl < i2) {
            i += i3;
            iM8271getMinimpl = i;
        } else if (iM8271getMinimpl >= i2) {
            i4 = i3 - (i2 - i);
            iM8271getMinimpl += i4;
            i = iM8270getMaximpl + i4;
        } else if (i < iM8271getMinimpl) {
            iM8271getMinimpl = i + i3;
            i4 = i3 - (i2 - i);
            i = iM8270getMaximpl + i4;
        }
        return TextRangeKt.TextRange(iM8271getMinimpl, i);
    }

    public static final void insert(TextFieldBuffer textFieldBuffer, int i, String str) {
        textFieldBuffer.replace(i, i, str);
    }

    public static final void delete(TextFieldBuffer textFieldBuffer, int i, int i2) {
        textFieldBuffer.replace(i, i2, "");
    }

    public static final void placeCursorAtEnd(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.placeCursorBeforeCharAt(textFieldBuffer.getLength());
    }

    public static final void selectAll(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.m1923setSelection5zctL8(TextRangeKt.TextRange(0, textFieldBuffer.getLength()));
    }

    public static final void forEachChange(TextFieldBuffer.ChangeList changeList, Function2<? super TextRange, ? super TextRange, Unit> function2) {
        for (int i = 0; i < changeList.getChangeCount(); i++) {
            function2.invoke(TextRange.m8261boximpl(changeList.mo1926getRangejx7JFs(i)), TextRange.m8261boximpl(changeList.mo1925getOriginalRangejx7JFs(i)));
        }
    }

    public static final void forEachChangeReversed(TextFieldBuffer.ChangeList changeList, Function2<? super TextRange, ? super TextRange, Unit> function2) {
        for (int changeCount = changeList.getChangeCount() - 1; changeCount >= 0; changeCount--) {
            function2.invoke(TextRange.m8261boximpl(changeList.mo1926getRangejx7JFs(changeCount)), TextRange.m8261boximpl(changeList.mo1925getOriginalRangejx7JFs(changeCount)));
        }
    }

    public static final void findCommonPrefixAndSuffix(CharSequence charSequence, CharSequence charSequence2, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        int i;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = 0;
        if (charSequence.length() <= 0 || charSequence2.length() <= 0) {
            i = 0;
        } else {
            int i3 = 0;
            i = 0;
            boolean z = false;
            while (true) {
                if (i2 == 0) {
                    if (charSequence.charAt(i3) == charSequence2.charAt(i)) {
                        i3++;
                        i++;
                    } else {
                        i2 = 1;
                    }
                }
                if (!z) {
                    if (charSequence.charAt(length - 1) == charSequence2.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z = true;
                    }
                }
                if (i3 >= length || i >= length2 || (i2 != 0 && z)) {
                    break;
                }
            }
            i2 = i3;
        }
        if (i2 < length || i < length2) {
            function4.invoke(Integer.valueOf(i2), Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(length2));
        }
    }

    public static /* synthetic */ void setSelectionCoerced$default(TextFieldBuffer textFieldBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        setSelectionCoerced(textFieldBuffer, i, i2);
    }

    public static final void setSelectionCoerced(TextFieldBuffer textFieldBuffer, int i, int i2) {
        textFieldBuffer.m1923setSelection5zctL8(TextRangeKt.TextRange(RangesKt.coerceIn(i, 0, textFieldBuffer.getLength()), RangesKt.coerceIn(i2, 0, textFieldBuffer.getLength())));
    }
}
