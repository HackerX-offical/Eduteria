package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

/* JADX INFO: compiled from: HandwritingGesture.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u0010J+\u0010\u0011\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J,\u0010\u0017\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001c\u0010\u001a\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u001b\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u001d\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nH\u0002J,\u0010\u001e\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001c\u0010 \u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010!\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010#\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0002J&\u0010$\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010&\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010(\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020)2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J#\u0010*\u001a\u00020\r*\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0012H\u0002¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0002J#\u00101\u001a\u00020\r*\u00020\u00062\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106JA\u0010\u0004\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0000¢\u0006\u0002\b\u0010J-\u0010\u0011\u001a\u00020\u0012*\u0002072\u0006\u0010\u0018\u001a\u00020\u00132\b\u00108\u001a\u0004\u0018\u0001092\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J2\u0010\u0017\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010\u001a\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u000109H\u0002J0\u0010\u001b\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010\u001d\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u001c2\b\u00108\u001a\u0004\u0018\u000109H\u0002J2\u0010\u001e\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\u001f2\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010 \u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\u001f2\b\u00108\u001a\u0004\u0018\u000109H\u0002J0\u0010!\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020\"2\u0006\u0010>\u001a\u00020?2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u001e\u0010#\u001a\u00020\r*\u0002072\u0006\u0010\u0018\u001a\u00020\"2\b\u00108\u001a\u0004\u0018\u000109H\u0002J:\u0010$\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J2\u0010&\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J:\u0010(\u001a\u00020\u0005*\u0002072\u0006\u0010\u0018\u001a\u00020)2\u0006\u0010>\u001a\u00020?2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J,\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010>\u001a\u00020B2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J5\u0010C\u001a\u00020\r2\u0006\u00102\u001a\u00020,2\b\u0010=\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002¢\u0006\u0004\bD\u0010EJ;\u0010F\u001a\u00020\r2\u0006\u00102\u001a\u00020,2\u0006\u0010>\u001a\u00020?2\u0006\u0010-\u001a\u00020\u00122\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002¢\u0006\u0004\bG\u0010HJ$\u0010I\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\r0;H\u0002J\u0013\u0010J\u001a\u00020K*\u00020\u0005H\u0002¢\u0006\u0004\bL\u0010M¨\u0006N"}, d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "<init>", "()V", "performHandwritingGesture", "", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "handwritingGesture", "Landroid/view/inputmethod/HandwritingGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "updateSelectionState", "Lkotlin/Function0;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation", "performSelectGesture", "gesture", "Landroid/view/inputmethod/SelectGesture;", "previewSelectGesture", "performDeleteGesture", "Landroid/view/inputmethod/DeleteGesture;", "previewDeleteGesture", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewSelectRangeGesture", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "previewDeleteRangeGesture", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performDeletion", "rangeInTransformedText", "Landroidx/compose/ui/text/TextRange;", "adjustRange", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", FallbackIndicationElement.ELEMENT, "highlightRange", "range", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "textSelectionManager", "text", "Landroidx/compose/ui/text/AnnotatedString;", "performInsertionOnLegacyTextField", "offset", "", "performSelectionOnLegacyTextField", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "performDeletionOnLegacyTextField", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "fallbackOnLegacyTextField", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HandwritingGestureApi34 {
    public static final int $stable = 0;
    public static final HandwritingGestureApi34 INSTANCE = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    public final int performHandwritingGesture$foundation(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture, TextLayoutState textLayoutState, Function0<Unit> function0, ViewConfiguration viewConfiguration) {
        if (handwritingGesture instanceof SelectGesture) {
            return performSelectGesture(transformedTextFieldState, (SelectGesture) handwritingGesture, textLayoutState, function0);
        }
        if (handwritingGesture instanceof DeleteGesture) {
            return performDeleteGesture(transformedTextFieldState, (DeleteGesture) handwritingGesture, textLayoutState);
        }
        if (handwritingGesture instanceof SelectRangeGesture) {
            return performSelectRangeGesture(transformedTextFieldState, (SelectRangeGesture) handwritingGesture, textLayoutState, function0);
        }
        if (handwritingGesture instanceof DeleteRangeGesture) {
            return performDeleteRangeGesture(transformedTextFieldState, (DeleteRangeGesture) handwritingGesture, textLayoutState);
        }
        if (handwritingGesture instanceof JoinOrSplitGesture) {
            return performJoinOrSplitGesture(transformedTextFieldState, (JoinOrSplitGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        if (handwritingGesture instanceof InsertGesture) {
            return performInsertGesture(transformedTextFieldState, (InsertGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        if (handwritingGesture instanceof RemoveSpaceGesture) {
            return performRemoveSpaceGesture(transformedTextFieldState, (RemoveSpaceGesture) handwritingGesture, textLayoutState, viewConfiguration);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation(final TransformedTextFieldState transformedTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextLayoutState textLayoutState, CancellationSignal cancellationSignal) {
        if (previewableHandwritingGesture instanceof SelectGesture) {
            previewSelectGesture(transformedTextFieldState, (SelectGesture) previewableHandwritingGesture, textLayoutState);
        } else if (previewableHandwritingGesture instanceof DeleteGesture) {
            previewDeleteGesture(transformedTextFieldState, (DeleteGesture) previewableHandwritingGesture, textLayoutState);
        } else if (previewableHandwritingGesture instanceof SelectRangeGesture) {
            previewSelectRangeGesture(transformedTextFieldState, (SelectRangeGesture) previewableHandwritingGesture, textLayoutState);
        } else {
            if (!(previewableHandwritingGesture instanceof DeleteRangeGesture)) {
                return false;
            }
            previewDeleteRangeGesture(transformedTextFieldState, (DeleteRangeGesture) previewableHandwritingGesture, textLayoutState);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda1
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.previewHandwritingGesture$lambda$0(transformedTextFieldState);
            }
        });
        return true;
    }

    private final int performSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState, Function0<Unit> function0) {
        long jM2001getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m2001getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1983toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m8267getCollapsedimpl(jM2001getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, selectGesture);
        }
        transformedTextFieldState.m2132selectCharsIn5zctL8(jM2001getRangeForScreenRectOH9lIzo);
        if (function0 == null) {
            return 1;
        }
        function0.invoke();
        return 1;
    }

    private final void previewSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        m1979highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m2001getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1983toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m1943getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        int iM1983toTextGranularityNUwxegE = m1983toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long jM2001getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m2001getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), iM1983toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m8267getCollapsedimpl(jM2001getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, deleteGesture);
        }
        m1980performDeletionSbBc2M(transformedTextFieldState, jM2001getRangeForScreenRectOH9lIzo, TextGranularity.m8230equalsimpl0(iM1983toTextGranularityNUwxegE, TextGranularity.INSTANCE.m8235getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        m1979highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m2001getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1983toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m1942getHandwritingDeletePreviewsxJuwY());
    }

    private final int performSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState, Function0<Unit> function0) {
        long jM2003getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m2003getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1983toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m8267getCollapsedimpl(jM2003getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, selectRangeGesture);
        }
        transformedTextFieldState.m2132selectCharsIn5zctL8(jM2003getRangeForScreenRectsO048IG0);
        if (function0 == null) {
            return 1;
        }
        function0.invoke();
        return 1;
    }

    private final void previewSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        m1979highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m2003getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1983toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m1943getHandwritingSelectPreviewsxJuwY());
    }

    private final int performDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        int iM1983toTextGranularityNUwxegE = m1983toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long jM2003getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m2003getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), iM1983toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m8267getCollapsedimpl(jM2003getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, deleteRangeGesture);
        }
        m1980performDeletionSbBc2M(transformedTextFieldState, jM2003getRangeForScreenRectsO048IG0, TextGranularity.m8230equalsimpl0(iM1983toTextGranularityNUwxegE, TextGranularity.INSTANCE.m8235getWordDRrd7Zo()));
        return 1;
    }

    private final void previewDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        m1979highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m2003getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1983toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m1942getHandwritingDeletePreviewsxJuwY());
    }

    private final int performJoinOrSplitGesture(TransformedTextFieldState transformedTextFieldState, JoinOrSplitGesture joinOrSplitGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        TextLayoutResult layoutResult;
        if (transformedTextFieldState.getOutputText() != transformedTextFieldState.getUntransformedText()) {
            return 3;
        }
        int iM1996getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1996getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
        if (iM1996getOffsetForHandwritingGestured4ec7I != -1 && ((layoutResult = textLayoutState.getLayoutResult()) == null || !HandwritingGesture_androidKt.isBiDiBoundary(layoutResult, iM1996getOffsetForHandwritingGestured4ec7I))) {
            long jRangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(transformedTextFieldState.getVisualText(), iM1996getOffsetForHandwritingGestured4ec7I);
            if (TextRange.m8267getCollapsedimpl(jRangeOfWhitespaces)) {
                TransformedTextFieldState.m2124replaceTextM8tDOmk$default(transformedTextFieldState, " ", jRangeOfWhitespaces, null, false, 12, null);
            } else {
                m1980performDeletionSbBc2M(transformedTextFieldState, jRangeOfWhitespaces, false);
            }
            return 1;
        }
        return fallback(transformedTextFieldState, joinOrSplitGesture);
    }

    private final int performInsertGesture(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        int iM1996getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1996getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
        if (iM1996getOffsetForHandwritingGestured4ec7I == -1) {
            return fallback(transformedTextFieldState, insertGesture);
        }
        TransformedTextFieldState.m2124replaceTextM8tDOmk$default(transformedTextFieldState, insertGesture.getTextToInsert(), TextRangeKt.TextRange(iM1996getOffsetForHandwritingGestured4ec7I), null, false, 12, null);
        return 1;
    }

    private final int performRemoveSpaceGesture(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        long jM1998getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m1998getRangeForRemoveSpaceGesture5iVPX68(textLayoutState.getLayoutResult(), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), textLayoutState.getTextLayoutNodeCoordinates(), viewConfiguration);
        if (TextRange.m8267getCollapsedimpl(jM1998getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallback(transformedTextFieldState, removeSpaceGesture);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String strReplace = new Regex("\\s+").replace(TextRangeKt.m8280substringFDrldGo(transformedTextFieldState.getVisualText(), jM1998getRangeForRemoveSpaceGesture5iVPX68), new Function1() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HandwritingGestureApi34.performRemoveSpaceGesture$lambda$1(intRef, intRef2, (MatchResult) obj);
            }
        });
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallback(transformedTextFieldState, removeSpaceGesture);
        }
        long jTextRange = TextRangeKt.TextRange(TextRange.m8273getStartimpl(jM1998getRangeForRemoveSpaceGesture5iVPX68) + intRef.element, TextRange.m8273getStartimpl(jM1998getRangeForRemoveSpaceGesture5iVPX68) + intRef2.element);
        String strSubstring = strReplace.substring(intRef.element, strReplace.length() - (TextRange.m8269getLengthimpl(jM1998getRangeForRemoveSpaceGesture5iVPX68) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        TransformedTextFieldState.m2124replaceTextM8tDOmk$default(transformedTextFieldState, strSubstring, jTextRange, null, false, 12, null);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence performRemoveSpaceGesture$lambda$1(Ref.IntRef intRef, Ref.IntRef intRef2, MatchResult matchResult) {
        if (intRef.element == -1) {
            intRef.element = matchResult.getRange().getFirst();
        }
        intRef2.element = matchResult.getRange().getLast() + 1;
        return "";
    }

    /* JADX INFO: renamed from: performDeletion-Sb-Bc2M, reason: not valid java name */
    private final void m1980performDeletionSbBc2M(TransformedTextFieldState transformedTextFieldState, long j, boolean z) {
        if (z) {
            j = HandwritingGesture_androidKt.m1992adjustHandwritingDeleteGestureRange72CqOWE(j, transformedTextFieldState.getVisualText());
        }
        TransformedTextFieldState.m2124replaceTextM8tDOmk$default(transformedTextFieldState, "", j, null, false, 12, null);
    }

    /* JADX INFO: renamed from: highlightRange-XJREzCE, reason: not valid java name */
    private final void m1979highlightRangeXJREzCE(TransformedTextFieldState transformedTextFieldState, long j, int i) {
        if (TextRange.m8267getCollapsedimpl(j)) {
            TextFieldState textFieldState = transformedTextFieldState.textFieldState;
            InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
            TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
            mainBuffer.clearHighlight$foundation();
            transformedTextFieldState.updateWedgeAffinity(mainBuffer);
            textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
            textFieldState.setUserCommit(true);
            return;
        }
        transformedTextFieldState.m2126highlightCharsIn7RAjNK8(i, j);
    }

    public final int performHandwritingGesture$foundation(LegacyTextFieldState legacyTextFieldState, HandwritingGesture handwritingGesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return 3;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return 3;
        }
        if (handwritingGesture instanceof SelectGesture) {
            return performSelectGesture(legacyTextFieldState, (SelectGesture) handwritingGesture, textFieldSelectionManager, function1);
        }
        if (handwritingGesture instanceof DeleteGesture) {
            return performDeleteGesture(legacyTextFieldState, (DeleteGesture) handwritingGesture, untransformedText, function1);
        }
        if (handwritingGesture instanceof SelectRangeGesture) {
            return performSelectRangeGesture(legacyTextFieldState, (SelectRangeGesture) handwritingGesture, textFieldSelectionManager, function1);
        }
        if (handwritingGesture instanceof DeleteRangeGesture) {
            return performDeleteRangeGesture(legacyTextFieldState, (DeleteRangeGesture) handwritingGesture, untransformedText, function1);
        }
        if (handwritingGesture instanceof JoinOrSplitGesture) {
            return performJoinOrSplitGesture(legacyTextFieldState, (JoinOrSplitGesture) handwritingGesture, untransformedText, viewConfiguration, function1);
        }
        if (handwritingGesture instanceof InsertGesture) {
            return performInsertGesture(legacyTextFieldState, (InsertGesture) handwritingGesture, viewConfiguration, function1);
        }
        if (handwritingGesture instanceof RemoveSpaceGesture) {
            return performRemoveSpaceGesture(legacyTextFieldState, (RemoveSpaceGesture) handwritingGesture, untransformedText, viewConfiguration, function1);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation(LegacyTextFieldState legacyTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, final TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return false;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return false;
        }
        if (previewableHandwritingGesture instanceof SelectGesture) {
            previewSelectGesture(legacyTextFieldState, (SelectGesture) previewableHandwritingGesture, textFieldSelectionManager);
        } else if (previewableHandwritingGesture instanceof DeleteGesture) {
            previewDeleteGesture(legacyTextFieldState, (DeleteGesture) previewableHandwritingGesture, textFieldSelectionManager);
        } else if (previewableHandwritingGesture instanceof SelectRangeGesture) {
            previewSelectRangeGesture(legacyTextFieldState, (SelectRangeGesture) previewableHandwritingGesture, textFieldSelectionManager);
        } else {
            if (!(previewableHandwritingGesture instanceof DeleteRangeGesture)) {
                return false;
            }
            previewDeleteRangeGesture(legacyTextFieldState, (DeleteRangeGesture) previewableHandwritingGesture, textFieldSelectionManager);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda3
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.previewHandwritingGesture$lambda$1(textFieldSelectionManager);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$1(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.clearPreviewHighlight$foundation();
        }
    }

    private final int performSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long jM2000getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m2000getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1983toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m8267getCollapsedimpl(jM2000getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(selectGesture, function1);
        }
        m1982performSelectionOnLegacyTextField8ffj60Q(jM2000getRangeForScreenRectOH9lIzo, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m2375setSelectionPreviewHighlight5zctL8$foundation(HandwritingGesture_androidKt.m2000getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1983toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    private final int performDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int iM1983toTextGranularityNUwxegE = m1983toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long jM2000getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m2000getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), iM1983toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m8267getCollapsedimpl(jM2000getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(deleteGesture, function1);
        }
        m1981performDeletionOnLegacyTextFieldvJH6DeI(jM2000getRangeForScreenRectOH9lIzo, annotatedString, TextGranularity.m8230equalsimpl0(iM1983toTextGranularityNUwxegE, TextGranularity.INSTANCE.m8235getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m2373setDeletionPreviewHighlight5zctL8$foundation(HandwritingGesture_androidKt.m2000getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1983toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    private final int performSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        long jM2002getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m2002getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1983toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m8267getCollapsedimpl(jM2002getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(selectRangeGesture, function1);
        }
        m1982performSelectionOnLegacyTextField8ffj60Q(jM2002getRangeForScreenRectsO048IG0, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m2375setSelectionPreviewHighlight5zctL8$foundation(HandwritingGesture_androidKt.m2002getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1983toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int iM1983toTextGranularityNUwxegE = m1983toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long jM2002getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m2002getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), iM1983toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m8267getCollapsedimpl(jM2002getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(deleteRangeGesture, function1);
        }
        m1981performDeletionOnLegacyTextFieldvJH6DeI(jM2002getRangeForScreenRectsO048IG0, annotatedString, TextGranularity.m8230equalsimpl0(iM1983toTextGranularityNUwxegE, TextGranularity.INSTANCE.m8235getWordDRrd7Zo()), function1);
        return 1;
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m2373setDeletionPreviewHighlight5zctL8$foundation(HandwritingGesture_androidKt.m2002getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1983toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    private final int performJoinOrSplitGesture(LegacyTextFieldState legacyTextFieldState, JoinOrSplitGesture joinOrSplitGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration != null) {
            int iM1995getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1995getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
            if (iM1995getOffsetForHandwritingGestured4ec7I != -1 && ((layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null || !HandwritingGesture_androidKt.isBiDiBoundary(value, iM1995getOffsetForHandwritingGestured4ec7I))) {
                long jRangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(annotatedString, iM1995getOffsetForHandwritingGestured4ec7I);
                if (TextRange.m8267getCollapsedimpl(jRangeOfWhitespaces)) {
                    performInsertionOnLegacyTextField(TextRange.m8273getStartimpl(jRangeOfWhitespaces), " ", function1);
                } else {
                    m1981performDeletionOnLegacyTextFieldvJH6DeI(jRangeOfWhitespaces, annotatedString, false, function1);
                }
                return 1;
            }
            return fallbackOnLegacyTextField(joinOrSplitGesture, function1);
        }
        return fallbackOnLegacyTextField(joinOrSplitGesture, function1);
    }

    private final int performInsertGesture(LegacyTextFieldState legacyTextFieldState, InsertGesture insertGesture, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration != null) {
            int iM1995getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1995getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
            if (iM1995getOffsetForHandwritingGestured4ec7I == -1 || ((layoutResult = legacyTextFieldState.getLayoutResult()) != null && (value = layoutResult.getValue()) != null && HandwritingGesture_androidKt.isBiDiBoundary(value, iM1995getOffsetForHandwritingGestured4ec7I))) {
                return fallbackOnLegacyTextField(insertGesture, function1);
            }
            performInsertionOnLegacyTextField(iM1995getOffsetForHandwritingGestured4ec7I, insertGesture.getTextToInsert(), function1);
            return 1;
        }
        return fallbackOnLegacyTextField(insertGesture, function1);
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        long jM1998getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m1998getRangeForRemoveSpaceGesture5iVPX68(layoutResult != null ? layoutResult.getValue() : null, HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
        if (TextRange.m8267getCollapsedimpl(jM1998getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallbackOnLegacyTextField(removeSpaceGesture, function1);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        String strReplace = new Regex("\\s+").replace(TextRangeKt.m8280substringFDrldGo(annotatedString, jM1998getRangeForRemoveSpaceGesture5iVPX68), new Function1() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HandwritingGestureApi34.performRemoveSpaceGesture$lambda$3(intRef, intRef2, (MatchResult) obj);
            }
        });
        if (intRef.element == -1 || intRef2.element == -1) {
            return fallbackOnLegacyTextField(removeSpaceGesture, function1);
        }
        int iM8273getStartimpl = TextRange.m8273getStartimpl(jM1998getRangeForRemoveSpaceGesture5iVPX68) + intRef.element;
        int iM8273getStartimpl2 = TextRange.m8273getStartimpl(jM1998getRangeForRemoveSpaceGesture5iVPX68) + intRef2.element;
        String strSubstring = strReplace.substring(intRef.element, strReplace.length() - (TextRange.m8269getLengthimpl(jM1998getRangeForRemoveSpaceGesture5iVPX68) - intRef2.element));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        function1.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(iM8273getStartimpl, iM8273getStartimpl2), new CommitTextCommand(strSubstring, 1)));
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence performRemoveSpaceGesture$lambda$3(Ref.IntRef intRef, Ref.IntRef intRef2, MatchResult matchResult) {
        if (intRef.element == -1) {
            intRef.element = matchResult.getRange().getFirst();
        }
        intRef2.element = matchResult.getRange().getLast() + 1;
        return "";
    }

    private final void performInsertionOnLegacyTextField(int offset, String text, Function1<? super EditCommand, Unit> editCommandConsumer) {
        editCommandConsumer.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(offset, offset), new CommitTextCommand(text, 1)));
    }

    /* JADX INFO: renamed from: performSelectionOnLegacyTextField-8ffj60Q, reason: not valid java name */
    private final void m1982performSelectionOnLegacyTextField8ffj60Q(long range, TextFieldSelectionManager textSelectionManager, Function1<? super EditCommand, Unit> editCommandConsumer) {
        editCommandConsumer.invoke(new SetSelectionCommand(TextRange.m8273getStartimpl(range), TextRange.m8268getEndimpl(range)));
        if (textSelectionManager != null) {
            textSelectionManager.enterSelectionMode$foundation(true);
        }
    }

    /* JADX INFO: renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    private final void m1981performDeletionOnLegacyTextFieldvJH6DeI(long range, AnnotatedString text, boolean adjustRange, Function1<? super EditCommand, Unit> editCommandConsumer) {
        if (adjustRange) {
            range = HandwritingGesture_androidKt.m1992adjustHandwritingDeleteGestureRange72CqOWE(range, text);
        }
        editCommandConsumer.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(TextRange.m8268getEndimpl(range), TextRange.m8268getEndimpl(range)), new DeleteSurroundingTextCommand(TextRange.m8269getLengthimpl(range), 0)));
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture gesture, Function1<? super EditCommand, Unit> editCommandConsumer) {
        String fallbackText = gesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        editCommandConsumer.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* JADX INFO: renamed from: toTextGranularity-NUwxegE, reason: not valid java name */
    private final int m1983toTextGranularityNUwxegE(int i) {
        if (i == 1) {
            return TextGranularity.INSTANCE.m8235getWordDRrd7Zo();
        }
        if (i == 2) {
            return TextGranularity.INSTANCE.m8234getCharacterDRrd7Zo();
        }
        return TextGranularity.INSTANCE.m8234getCharacterDRrd7Zo();
    }

    private final int fallback(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.clearHighlight$foundation();
        transformedTextFieldState.updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, fallbackText, true, null, false, 12, null);
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$0(TransformedTextFieldState transformedTextFieldState) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.clearHighlight$foundation();
        transformedTextFieldState.updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }
}
