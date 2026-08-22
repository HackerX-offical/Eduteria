package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: PlatformSelectionBehaviors.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 0, 0, 1}, l = {369, 159}, m = "invokeSuspend", n = {"suggestedSelection", "$this$withLock_u24default$iv", "newSelection", "newSelection"}, s = {"L$0", "L$1", "J$0", "J$0"}, v = 1)
final class PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super TextRange>, Object> {
    final /* synthetic */ long $selection;
    final /* synthetic */ CharSequence $text;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(CharSequence charSequence, long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Continuation<? super PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2> continuation) {
        super(2, continuation);
        this.$text = charSequence;
        this.$selection = j;
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 = new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(this.$text, this.$selection, this.this$0, continuation);
        platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2.L$0 = obj;
        return platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TextClassifier textClassifier, Continuation<? super TextRange> continuation) {
        return ((PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2) create(textClassifier, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        Mutex mutex;
        CharSequence charSequence;
        long j2;
        TextSelection textSelection;
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextClassifier textClassifier = (TextClassifier) this.L$0;
            TextSelection.Request.Builder defaultLocales = new TextSelection.Request.Builder(this.$text, TextRange.m8271getMinimpl(this.$selection), TextRange.m8270getMaximpl(this.$selection)).setDefaultLocales(this.this$0.getAndroidLocalList());
            if (Build.VERSION.SDK_INT >= 31) {
                defaultLocales.setIncludeTextClassification(true);
            }
            TextSelection textSelectionSuggestSelection = textClassifier.suggestSelection(defaultLocales.build());
            long jTextRange = TextRangeKt.TextRange(textSelectionSuggestSelection.getSelectionStartIndex(), textSelectionSuggestSelection.getSelectionEndIndex());
            if (Build.VERSION.SDK_INT < 31 || textSelectionSuggestSelection.getTextClassification() == null) {
                this.J$0 = jTextRange;
                this.label = 2;
                if (this.this$0.m2287classifyTextM8tDOmk(this.$text, jTextRange, textClassifier, this) != coroutine_suspended) {
                    j = jTextRange;
                    j2 = j;
                }
            } else {
                mutex = this.this$0.mutex;
                PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl2 = this.this$0;
                CharSequence charSequence2 = this.$text;
                this.L$0 = textSelectionSuggestSelection;
                this.L$1 = mutex;
                this.L$2 = platformSelectionBehaviorsImpl2;
                this.L$3 = charSequence2;
                this.J$0 = jTextRange;
                this.label = 1;
                if (mutex.lock(null, this) != coroutine_suspended) {
                    charSequence = charSequence2;
                    j2 = jTextRange;
                    textSelection = textSelectionSuggestSelection;
                    platformSelectionBehaviorsImpl = platformSelectionBehaviorsImpl2;
                    TextClassification textClassification = textSelection.getTextClassification();
                    Intrinsics.checkNotNull(textClassification);
                    platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence, j2, textClassification, null));
                    Unit unit = Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            long j3 = this.J$0;
            CharSequence charSequence3 = (CharSequence) this.L$3;
            platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) this.L$2;
            mutex = (Mutex) this.L$1;
            textSelection = (TextSelection) this.L$0;
            ResultKt.throwOnFailure(obj);
            charSequence = charSequence3;
            j2 = j3;
            try {
                TextClassification textClassification2 = textSelection.getTextClassification();
                Intrinsics.checkNotNull(textClassification2);
                platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence, j2, textClassification2, null));
                Unit unit2 = Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            j2 = j;
        }
        return TextRange.m8261boximpl(j2);
    }
}
