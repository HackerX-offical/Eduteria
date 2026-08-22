package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: TransformedTextFieldState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 g2\u00020\u0001:\u0002fgB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010*\u001a\u00020+2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000e\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.J\u0015\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0015¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u0015¢\u0006\u0004\b5\u00102J\u001d\u00106\u001a\u00020+2\u0006\u00107\u001a\u0002082\u0006\u00100\u001a\u00020\u0015¢\u0006\u0004\b9\u0010:J\u000e\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020+J\u0006\u0010?\u001a\u00020+J1\u0010@\u001a\u00020+2\u0006\u0010<\u001a\u00020=2\u0006\u0010A\u001a\u00020\u00152\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020\u0019¢\u0006\u0004\bE\u0010FJ,\u0010G\u001a\u00020+2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010H\u001a\u00020\u00192\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020\u0019J\u0006\u0010I\u001a\u00020+J\u0006\u0010J\u001a\u00020+J\u0006\u0010K\u001a\u00020+J\u0006\u0010L\u001a\u00020+J,\u0010M\u001a\u00020+2\b\b\u0002\u0010D\u001a\u00020\u00192\u0017\u0010N\u001a\u0013\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020+0O¢\u0006\u0002\bQH\u0086\bJ\f\u0010R\u001a\u00020+*\u00020PH\u0002J\u0015\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020.¢\u0006\u0004\bU\u0010VJ\u0015\u0010S\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0015¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\u00020\u00152\u0006\u0010T\u001a\u00020.¢\u0006\u0004\bZ\u0010VJ\u0015\u0010Y\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0015¢\u0006\u0004\b[\u0010XJ\u0016\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0086@¢\u0006\u0002\u0010`J\u0013\u0010a\u001a\u00020\u00192\b\u0010b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010c\u001a\u00020.H\u0016J\b\u0010d\u001a\u00020eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b \u0010\u001bR+\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006h"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "outputTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "codepointTransformedText", "untransformedText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getUntransformedText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "untransformedComposition", "Landroidx/compose/ui/text/TextRange;", "getUntransformedComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "userCommit", "", "getUserCommit", "()Z", "outputText", "getOutputText", "visualText", "getVisualText", "isTransformed", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", DiscoverItems.Item.UPDATE_ACTION, "", "placeCursorBeforeCharAt", "transformedOffset", "", "selectCharsIn", "transformedRange", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "highlightCharsIn", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightCharsIn-7RAjNK8", "(IJ)V", "replaceAll", "newText", "", "selectAll", "deleteSelectedText", "replaceText", "range", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "restartImeIfContentChanges", "replaceText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;Z)V", "replaceSelectedText", "clearComposition", "collapseSelectionToMax", "collapseSelectionToEnd", "undo", "redo", "editUntransformedTextAsUser", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Lkotlin/ExtensionFunctionType;", "updateWedgeAffinity", "mapToTransformed", "offset", "mapToTransformed--jx7JFs", "(I)J", "mapToTransformed-GEjPoXI", "(J)J", "mapFromTransformed", "mapFromTransformed--jx7JFs", "mapFromTransformed-GEjPoXI", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "TransformedText", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransformedTextFieldState {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private final CodepointTransformation codepointTransformation;
    private final State<TransformedText> codepointTransformedText;
    private InputTransformation inputTransformation;
    private final OutputTransformation outputTransformation;
    private final State<TransformedText> outputTransformedText;

    /* JADX INFO: renamed from: selectionWedgeAffinity$delegate, reason: from kotlin metadata */
    private final MutableState selectionWedgeAffinity;
    private final TextFieldState textFieldState;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransformedTextFieldState.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TransformedTextFieldState", f = "TransformedTextFieldState.kt", i = {0}, l = {769}, m = "collectImeNotifications", n = {"transformedNotifyImeListener"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformedTextFieldState.this.collectImeNotifications(null, this);
        }
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, outputTransformation, selectionWedgeAffinity);
    }

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.calculateTransformedText(textFieldCharSequence, codepointTransformation, selectionWedgeAffinity);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
    private static final long m2122mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m2136mapFromTransformedxdX6G0(j, offsetMappingCalculator);
    }

    @JvmStatic
    /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
    private static final long m2123mapToTransformedXGyztTk(long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity) {
        return Companion.m2137mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
    }

    public TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, final CodepointTransformation codepointTransformation, final OutputTransformation outputTransformation) {
        this.textFieldState = textFieldState;
        this.inputTransformation = inputTransformation;
        this.codepointTransformation = codepointTransformation;
        this.outputTransformation = outputTransformation;
        this.outputTransformedText = outputTransformation != null ? SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TransformedTextFieldState.outputTransformedText$lambda$0$0(this.f$0, outputTransformation);
            }
        }) : null;
        this.codepointTransformedText = codepointTransformation != null ? SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TransformedTextFieldState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TransformedTextFieldState.codepointTransformedText$lambda$0$0(this.f$0, codepointTransformation);
            }
        }) : null;
        this.selectionWedgeAffinity = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SelectionWedgeAffinity(WedgeAffinity.Start), null, 2, null);
    }

    public /* synthetic */ TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState, (i & 2) != 0 ? null : inputTransformation, (i & 4) != 0 ? null : codepointTransformation, (i & 8) != 0 ? null : outputTransformation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransformedText outputTransformedText$lambda$0$0(TransformedTextFieldState transformedTextFieldState, OutputTransformation outputTransformation) {
        return Companion.calculateTransformedText(transformedTextFieldState.textFieldState.getValue$foundation(), outputTransformation, transformedTextFieldState.getSelectionWedgeAffinity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransformedText codepointTransformedText$lambda$0$0(TransformedTextFieldState transformedTextFieldState, CodepointTransformation codepointTransformation) {
        TextFieldCharSequence value$foundation;
        TransformedText value;
        Companion companion = Companion;
        State<TransformedText> state = transformedTextFieldState.outputTransformedText;
        if (state == null || (value = state.getValue()) == null || (value$foundation = value.getText()) == null) {
            value$foundation = transformedTextFieldState.textFieldState.getValue$foundation();
        }
        return companion.calculateTransformedText(value$foundation, codepointTransformation, transformedTextFieldState.getSelectionWedgeAffinity());
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation();
    }

    /* JADX INFO: renamed from: getUntransformedComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m2125getUntransformedCompositionMzsxiRA() {
        return this.textFieldState.m1930getCompositionMzsxiRA();
    }

    public final boolean getUserCommit() {
        return this.textFieldState.getUserCommit$foundation();
    }

    public final TextFieldCharSequence getOutputText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.outputTransformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? getUntransformedText() : text;
    }

    public final TextFieldCharSequence getVisualText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.codepointTransformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? getOutputText() : text;
    }

    public final boolean isTransformed() {
        return (this.outputTransformation == null && this.codepointTransformation == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SelectionWedgeAffinity getSelectionWedgeAffinity() {
        return (SelectionWedgeAffinity) this.selectionWedgeAffinity.getValue();
    }

    public final void setSelectionWedgeAffinity(SelectionWedgeAffinity selectionWedgeAffinity) {
        this.selectionWedgeAffinity.setValue(selectionWedgeAffinity);
    }

    public final void update(InputTransformation inputTransformation) {
        this.inputTransformation = inputTransformation;
    }

    public final void placeCursorBeforeCharAt(int transformedOffset) {
        m2132selectCharsIn5zctL8(TextRangeKt.TextRange(transformedOffset));
    }

    /* JADX INFO: renamed from: selectCharsIn-5zc-tL8, reason: not valid java name */
    public final void m2132selectCharsIn5zctL8(long transformedRange) {
        m2133selectUntransformedCharsIn5zctL8(m2128mapFromTransformedGEjPoXI(transformedRange));
    }

    /* JADX INFO: renamed from: selectUntransformedCharsIn-5zc-tL8, reason: not valid java name */
    public final void m2133selectUntransformedCharsIn5zctL8(long untransformedRange) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBufferKt.setSelectionCoerced(textFieldState.getMainBuffer(), TextRange.m8273getStartimpl(untransformedRange), TextRange.m8268getEndimpl(untransformedRange));
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    /* JADX INFO: renamed from: highlightCharsIn-7RAjNK8, reason: not valid java name */
    public final void m2126highlightCharsIn7RAjNK8(int type, long transformedRange) {
        long jM2128mapFromTransformedGEjPoXI = m2128mapFromTransformedGEjPoXI(transformedRange);
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        textFieldState.getMainBuffer().m1922setHighlightK7f2yys$foundation(type, TextRange.m8273getStartimpl(jM2128mapFromTransformedGEjPoXI), TextRange.m8268getEndimpl(jM2128mapFromTransformedGEjPoXI));
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    public final void replaceAll(CharSequence newText) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        TextFieldBufferKt.delete(mainBuffer, 0, mainBuffer.getLength());
        mainBuffer.append(newText.toString());
        updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    public final void selectAll() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        TextFieldBufferKt.setSelectionCoerced(mainBuffer, 0, mainBuffer.getLength());
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    public final void deleteSelectedText() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.NeverMerge;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        TextFieldBufferKt.delete(mainBuffer, TextRange.m8271getMinimpl(mainBuffer.getSelectionInChars()), TextRange.m8270getMaximpl(mainBuffer.getSelectionInChars()));
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer, TextRange.m8271getMinimpl(mainBuffer.getSelectionInChars()), 0, 2, null);
        updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk$default, reason: not valid java name */
    public static /* synthetic */ void m2124replaceTextM8tDOmk$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        TextFieldEditUndoBehavior textFieldEditUndoBehavior2 = textFieldEditUndoBehavior;
        if ((i & 8) != 0) {
            z = true;
        }
        transformedTextFieldState.m2131replaceTextM8tDOmk(charSequence, j, textFieldEditUndoBehavior2, z);
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk, reason: not valid java name */
    public final void m2131replaceTextM8tDOmk(CharSequence newText, long range, TextFieldEditUndoBehavior undoBehavior, boolean restartImeIfContentChanges) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        long jM2128mapFromTransformedGEjPoXI = m2128mapFromTransformedGEjPoXI(range);
        mainBuffer.replace(TextRange.m8271getMinimpl(jM2128mapFromTransformedGEjPoXI), TextRange.m8270getMaximpl(jM2128mapFromTransformedGEjPoXI), newText);
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer, TextRange.m8271getMinimpl(jM2128mapFromTransformedGEjPoXI) + newText.length(), 0, 2, null);
        updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, restartImeIfContentChanges, undoBehavior);
        textFieldState.setUserCommit(true);
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        transformedTextFieldState.replaceSelectedText(charSequence, z, textFieldEditUndoBehavior, z2);
    }

    public final void replaceSelectedText(CharSequence newText, boolean clearComposition, TextFieldEditUndoBehavior undoBehavior, boolean restartImeIfContentChanges) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        if (clearComposition) {
            mainBuffer.commitComposition$foundation();
        }
        long selectionInChars = mainBuffer.getSelectionInChars();
        mainBuffer.replace(TextRange.m8271getMinimpl(selectionInChars), TextRange.m8270getMaximpl(selectionInChars), newText);
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer, TextRange.m8271getMinimpl(selectionInChars) + newText.length(), 0, 2, null);
        updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, restartImeIfContentChanges, undoBehavior);
        textFieldState.setUserCommit(true);
    }

    public final void collapseSelectionToMax() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer, TextRange.m8270getMaximpl(mainBuffer.getSelectionInChars()), 0, 2, null);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    public final void collapseSelectionToEnd() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        TextFieldBufferKt.setSelectionCoerced$default(mainBuffer, TextRange.m8268getEndimpl(mainBuffer.getSelectionInChars()), 0, 2, null);
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState transformedTextFieldState, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        function1.invoke(mainBuffer);
        transformedTextFieldState.updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    public final void editUntransformedTextAsUser(boolean restartImeIfContentChanges, Function1<? super TextFieldBuffer, Unit> block) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
        block.invoke(mainBuffer);
        updateWedgeAffinity(mainBuffer);
        textFieldState.commitEditAsUser(inputTransformation, restartImeIfContentChanges, textFieldEditUndoBehavior);
        textFieldState.setUserCommit(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWedgeAffinity(TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.getChangeTracker$foundation().getChangeCount() <= 0 || !TextRange.m8267getCollapsedimpl(textFieldBuffer.getSelectionInChars())) {
            return;
        }
        setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
    }

    /* JADX INFO: renamed from: mapToTransformed--jx7JFs, reason: not valid java name */
    public final long m2129mapToTransformedjx7JFs(int offset) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMapping = null;
        OffsetMappingCalculator offsetMapping2 = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMapping = value.getOffsetMapping();
        }
        long jM2059mapFromSourcejx7JFs = offsetMapping2 != null ? offsetMapping2.m2059mapFromSourcejx7JFs(offset) : TextRangeKt.TextRange(offset);
        return offsetMapping != null ? Companion.m2137mapToTransformedXGyztTk(jM2059mapFromSourcejx7JFs, offsetMapping, getSelectionWedgeAffinity()) : jM2059mapFromSourcejx7JFs;
    }

    /* JADX INFO: renamed from: mapToTransformed-GEjPoXI, reason: not valid java name */
    public final long m2130mapToTransformedGEjPoXI(long range) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMapping = null;
        OffsetMappingCalculator offsetMapping2 = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMapping = value.getOffsetMapping();
        }
        if (offsetMapping2 != null) {
            range = Companion.m2138mapToTransformedXGyztTk$default(Companion, range, offsetMapping2, null, 4, null);
        }
        return offsetMapping != null ? Companion.m2137mapToTransformedXGyztTk(range, offsetMapping, getSelectionWedgeAffinity()) : range;
    }

    /* JADX INFO: renamed from: mapFromTransformed--jx7JFs, reason: not valid java name */
    public final long m2127mapFromTransformedjx7JFs(int offset) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMapping = null;
        OffsetMappingCalculator offsetMapping2 = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMapping = value.getOffsetMapping();
        }
        long jM2058mapFromDestjx7JFs = offsetMapping != null ? offsetMapping.m2058mapFromDestjx7JFs(offset) : TextRangeKt.TextRange(offset);
        return offsetMapping2 != null ? Companion.m2136mapFromTransformedxdX6G0(jM2058mapFromDestjx7JFs, offsetMapping2) : jM2058mapFromDestjx7JFs;
    }

    /* JADX INFO: renamed from: mapFromTransformed-GEjPoXI, reason: not valid java name */
    public final long m2128mapFromTransformedGEjPoXI(long range) {
        TransformedText value;
        TransformedText value2;
        State<TransformedText> state = this.outputTransformedText;
        OffsetMappingCalculator offsetMapping = null;
        OffsetMappingCalculator offsetMapping2 = (state == null || (value2 = state.getValue()) == null) ? null : value2.getOffsetMapping();
        State<TransformedText> state2 = this.codepointTransformedText;
        if (state2 != null && (value = state2.getValue()) != null) {
            offsetMapping = value.getOffsetMapping();
        }
        if (offsetMapping != null) {
            range = Companion.m2136mapFromTransformedxdX6G0(range, offsetMapping);
        }
        return offsetMapping2 != null ? Companion.m2136mapFromTransformedxdX6G0(range, offsetMapping2) : range;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectImeNotifications(final androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text.input.internal.TransformedTextFieldState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1 r0 = (androidx.compose.foundation.text.input.internal.TransformedTextFieldState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1 r0 = new androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 == r3) goto L2e
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2e:
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener r5 = (androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L79
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text.input.OutputTransformation r6 = r4.outputTransformation
            if (r6 == 0) goto L43
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$$ExternalSyntheticLambda0 r6 = new androidx.compose.foundation.text.input.internal.TransformedTextFieldState$$ExternalSyntheticLambda0
            r6.<init>()
            r5 = r6
        L43:
            r0.L$0 = r5
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r6.<init>(r2, r3)
            r6.initCancellability()
            r2 = r6
            kotlinx.coroutines.CancellableContinuation r2 = (kotlinx.coroutines.CancellableContinuation) r2
            androidx.compose.foundation.text.input.TextFieldState r3 = access$getTextFieldState$p(r4)
            r3.addNotifyImeListener$foundation(r5)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1 r3 = new androidx.compose.foundation.text.input.internal.TransformedTextFieldState$collectImeNotifications$2$1
            r3.<init>()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2.invokeOnCancellation(r3)
            java.lang.Object r5 = r6.getResult()
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r6) goto L76
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L76:
            if (r5 != r1) goto L79
            return r1
        L79:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TransformedTextFieldState.collectImeNotifications(androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectImeNotifications$lambda$0(TextFieldState.NotifyImeListener notifyImeListener, TransformedTextFieldState transformedTextFieldState, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
        TextFieldCharSequence text;
        TransformedText transformedTextCalculateTransformedText = Companion.calculateTransformedText(textFieldCharSequence, transformedTextFieldState.outputTransformation, transformedTextFieldState.getSelectionWedgeAffinity());
        if (transformedTextCalculateTransformedText != null && (text = transformedTextCalculateTransformedText.getText()) != null) {
            textFieldCharSequence = text;
        }
        notifyImeListener.onChange(textFieldCharSequence, transformedTextFieldState.getVisualText(), z);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransformedTextFieldState)) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = (TransformedTextFieldState) other;
        if (Intrinsics.areEqual(this.textFieldState, transformedTextFieldState.textFieldState) && Intrinsics.areEqual(this.codepointTransformation, transformedTextFieldState.codepointTransformation)) {
            return Intrinsics.areEqual(this.outputTransformation, transformedTextFieldState.outputTransformation);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.textFieldState.hashCode() * 31;
        CodepointTransformation codepointTransformation = this.codepointTransformation;
        int iHashCode2 = (iHashCode + (codepointTransformation != null ? codepointTransformation.hashCode() : 0)) * 31;
        OutputTransformation outputTransformation = this.outputTransformation;
        return iHashCode2 + (outputTransformation != null ? outputTransformation.hashCode() : 0);
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", outputTransformation=" + this.outputTransformation + ", outputTransformedText=" + this.outputTransformedText + ", codepointTransformation=" + this.codepointTransformation + ", codepointTransformedText=" + this.codepointTransformedText + ", outputText=\"" + ((Object) getOutputText()) + "\", visualText=\"" + ((Object) getVisualText()) + "\")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TransformedTextFieldState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public static /* synthetic */ TransformedText copy$default(TransformedText transformedText, TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator, int i, Object obj) {
            if ((i & 1) != 0) {
                textFieldCharSequence = transformedText.text;
            }
            if ((i & 2) != 0) {
                offsetMappingCalculator = transformedText.offsetMapping;
            }
            return transformedText.copy(textFieldCharSequence, offsetMappingCalculator);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final TextFieldCharSequence getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence text, OffsetMappingCalculator offsetMapping) {
            return new TransformedText(text, offsetMapping);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransformedText)) {
                return false;
            }
            TransformedText transformedText = (TransformedText) other;
            return Intrinsics.areEqual(this.text, transformedText.text) && Intrinsics.areEqual(this.offsetMapping, transformedText.offsetMapping);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + ((Object) this.text) + ", offsetMapping=" + this.offsetMapping + ')';
        }

        public TransformedText(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            this.text = textFieldCharSequence;
            this.offsetMapping = offsetMappingCalculator;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }
    }

    /* JADX INFO: compiled from: TransformedTextFieldState.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0003J+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "<init>", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapToTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "selectionWedgeAffinity", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "mapFromTransformed", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {

        /* JADX INFO: compiled from: TransformedTextFieldState.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[WedgeAffinity.values().length];
                try {
                    iArr[WedgeAffinity.Start.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WedgeAffinity.End.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence untransformedValue, OutputTransformation outputTransformation, SelectionWedgeAffinity wedgeAffinity) {
            List<AnnotatedString.Range<AnnotatedString.Annotation>> list;
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(untransformedValue, null, null, offsetMappingCalculator, 6, null);
            textFieldBuffer.setCanCallAddStyle$foundation(true);
            outputTransformation.transformOutput(textFieldBuffer);
            textFieldBuffer.setCanCallAddStyle$foundation(false);
            List<AnnotatedString.Range<AnnotatedString.Annotation>> outputTransformationAnnotations$foundation = textFieldBuffer.getOutputTransformationAnnotations$foundation();
            if (textFieldBuffer.getChanges().getChangeCount() == 0 && ((list = outputTransformationAnnotations$foundation) == null || list.isEmpty())) {
                return null;
            }
            long jM2137mapToTransformedXGyztTk = m2137mapToTransformedXGyztTk(untransformedValue.getSelection(), offsetMappingCalculator, wedgeAffinity);
            TextRange composition = untransformedValue.getComposition();
            return new TransformedText(TextFieldBuffer.m1918toTextFieldCharSequencewFTz33Y$foundation$default(textFieldBuffer, jM2137mapToTransformedXGyztTk, composition != null ? TextRange.m8261boximpl(TransformedTextFieldState.Companion.m2137mapToTransformedXGyztTk(composition.getPackedValue(), offsetMappingCalculator, wedgeAffinity)) : null, null, outputTransformationAnnotations$foundation, 4, null), offsetMappingCalculator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence untransformedValue, CodepointTransformation codepointTransformation, SelectionWedgeAffinity wedgeAffinity) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            CharSequence visualText = CodepointTransformationKt.toVisualText(untransformedValue, codepointTransformation, offsetMappingCalculator);
            TextRange textRangeM8261boximpl = null;
            if (visualText == untransformedValue) {
                return null;
            }
            long jM2137mapToTransformedXGyztTk = m2137mapToTransformedXGyztTk(untransformedValue.getSelection(), offsetMappingCalculator, wedgeAffinity);
            TextRange composition = untransformedValue.getComposition();
            if (composition != null) {
                textRangeM8261boximpl = TextRange.m8261boximpl(TransformedTextFieldState.Companion.m2137mapToTransformedXGyztTk(composition.getPackedValue(), offsetMappingCalculator, wedgeAffinity));
            }
            return new TransformedText(new TextFieldCharSequence(visualText, jM2137mapToTransformedXGyztTk, textRangeM8261boximpl, null, null, null, 56, null), offsetMappingCalculator);
        }

        /* JADX INFO: renamed from: mapToTransformed-XGyztTk$default, reason: not valid java name */
        static /* synthetic */ long m2138mapToTransformedXGyztTk$default(Companion companion, long j, OffsetMappingCalculator offsetMappingCalculator, SelectionWedgeAffinity selectionWedgeAffinity, int i, Object obj) {
            if ((i & 4) != 0) {
                selectionWedgeAffinity = null;
            }
            return companion.m2137mapToTransformedXGyztTk(j, offsetMappingCalculator, selectionWedgeAffinity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* JADX INFO: renamed from: mapToTransformed-XGyztTk, reason: not valid java name */
        public final long m2137mapToTransformedXGyztTk(long range, OffsetMappingCalculator mapping, SelectionWedgeAffinity selectionWedgeAffinity) {
            long jTextRange;
            long jM2059mapFromSourcejx7JFs = mapping.m2059mapFromSourcejx7JFs(TextRange.m8273getStartimpl(range));
            long jM2059mapFromSourcejx7JFs2 = TextRange.m8267getCollapsedimpl(range) ? jM2059mapFromSourcejx7JFs : mapping.m2059mapFromSourcejx7JFs(TextRange.m8268getEndimpl(range));
            WedgeAffinity endAffinity = null;
            WedgeAffinity startAffinity = selectionWedgeAffinity != null ? selectionWedgeAffinity.getStartAffinity() : null;
            if (TextRange.m8267getCollapsedimpl(range)) {
                endAffinity = startAffinity;
            } else if (selectionWedgeAffinity != null) {
                endAffinity = selectionWedgeAffinity.getEndAffinity();
            }
            if (startAffinity != null && !TextRange.m8267getCollapsedimpl(jM2059mapFromSourcejx7JFs)) {
                int i = WhenMappings.$EnumSwitchMapping$0[startAffinity.ordinal()];
                if (i == 1) {
                    jM2059mapFromSourcejx7JFs = TextRangeKt.TextRange(TextRange.m8273getStartimpl(jM2059mapFromSourcejx7JFs));
                } else {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    jM2059mapFromSourcejx7JFs = TextRangeKt.TextRange(TextRange.m8268getEndimpl(jM2059mapFromSourcejx7JFs));
                }
            }
            if (endAffinity != null && !TextRange.m8267getCollapsedimpl(jM2059mapFromSourcejx7JFs2)) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[endAffinity.ordinal()];
                if (i2 == 1) {
                    jTextRange = TextRangeKt.TextRange(TextRange.m8273getStartimpl(jM2059mapFromSourcejx7JFs2));
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    jTextRange = TextRangeKt.TextRange(TextRange.m8268getEndimpl(jM2059mapFromSourcejx7JFs2));
                }
                jM2059mapFromSourcejx7JFs2 = jTextRange;
            }
            int iMin = Math.min(TextRange.m8271getMinimpl(jM2059mapFromSourcejx7JFs), TextRange.m8271getMinimpl(jM2059mapFromSourcejx7JFs2));
            int iMax = Math.max(TextRange.m8270getMaximpl(jM2059mapFromSourcejx7JFs), TextRange.m8270getMaximpl(jM2059mapFromSourcejx7JFs2));
            if (TextRange.m8272getReversedimpl(range)) {
                return TextRangeKt.TextRange(iMax, iMin);
            }
            return TextRangeKt.TextRange(iMin, iMax);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* JADX INFO: renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
        public final long m2136mapFromTransformedxdX6G0(long range, OffsetMappingCalculator mapping) {
            long jM2058mapFromDestjx7JFs = mapping.m2058mapFromDestjx7JFs(TextRange.m8273getStartimpl(range));
            long jM2058mapFromDestjx7JFs2 = TextRange.m8267getCollapsedimpl(range) ? jM2058mapFromDestjx7JFs : mapping.m2058mapFromDestjx7JFs(TextRange.m8268getEndimpl(range));
            int iMin = Math.min(TextRange.m8271getMinimpl(jM2058mapFromDestjx7JFs), TextRange.m8271getMinimpl(jM2058mapFromDestjx7JFs2));
            int iMax = Math.max(TextRange.m8270getMaximpl(jM2058mapFromDestjx7JFs), TextRange.m8270getMaximpl(jM2058mapFromDestjx7JFs2));
            if (TextRange.m8272getReversedimpl(range)) {
                return TextRangeKt.TextRange(iMax, iMin);
            }
            return TextRangeKt.TextRange(iMin, iMax);
        }
    }
}
