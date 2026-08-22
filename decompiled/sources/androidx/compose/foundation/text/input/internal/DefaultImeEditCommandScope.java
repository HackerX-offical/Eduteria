package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: ImeEditCommand.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J!\u0010\u001b\u001a\u00020\u00172\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0014\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/input/internal/DefaultImeEditCommandScope;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "batchEditTextFieldBuffer", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "batchDepth", "", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "transformedLength", "getTransformedLength", "()I", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "beginBatchEdit", "", "edit", BlockContactsIQ.ELEMENT, "endBatchEdit", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultImeEditCommandScope implements ImeEditCommandScope {
    public static final int $stable = 8;
    private int batchDepth;
    private TextFieldBuffer batchEditTextFieldBuffer;
    private final MutableVector<Function1<TextFieldBuffer, Unit>> editCommands = new MutableVector<>(new Function1[16], 0);
    private final TransformedTextFieldState transformedTextFieldState;

    public DefaultImeEditCommandScope(TransformedTextFieldState transformedTextFieldState) {
        this.transformedTextFieldState = transformedTextFieldState;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    /* JADX INFO: renamed from: mapFromTransformed-GEjPoXI */
    public long mo1958mapFromTransformedGEjPoXI(long range) {
        return this.transformedTextFieldState.isTransformed() ? this.transformedTextFieldState.m2128mapFromTransformedGEjPoXI(range) : range;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    /* JADX INFO: renamed from: mapToTransformed-GEjPoXI */
    public long mo1959mapToTransformedGEjPoXI(long range) {
        return this.transformedTextFieldState.isTransformed() ? this.transformedTextFieldState.m2130mapToTransformedGEjPoXI(range) : range;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public int getTransformedLength() {
        TextFieldBuffer textFieldBuffer = this.batchEditTextFieldBuffer;
        return textFieldBuffer != null ? textFieldBuffer.getLength() : this.transformedTextFieldState.getVisualText().length();
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean beginBatchEdit() {
        this.batchDepth++;
        return true;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public void edit(Function1<? super TextFieldBuffer, Unit> block) {
        beginBatchEdit();
        this.editCommands.add(block);
        endBatchEdit();
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean endBatchEdit() {
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0 && this.editCommands.getSize() != 0) {
            TransformedTextFieldState transformedTextFieldState = this.transformedTextFieldState;
            TextFieldState textFieldState = transformedTextFieldState.textFieldState;
            InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState.getMainBuffer().getChangeTracker$foundation().clearChanges();
            TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
            if (!this.transformedTextFieldState.isTransformed()) {
                this.batchEditTextFieldBuffer = mainBuffer;
            }
            MutableVector<Function1<TextFieldBuffer, Unit>> mutableVector = this.editCommands;
            Function1<TextFieldBuffer, Unit>[] function1Arr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i2 = 0; i2 < size; i2++) {
                function1Arr[i2].invoke(mainBuffer);
            }
            transformedTextFieldState.updateWedgeAffinity(mainBuffer);
            textFieldState.commitEditAsUser(inputTransformation, false, textFieldEditUndoBehavior);
            textFieldState.setUserCommit(true);
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }
}
