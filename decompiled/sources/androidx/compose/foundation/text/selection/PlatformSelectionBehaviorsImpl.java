package androidx.compose.foundation.text.selection;

import android.app.RemoteAction;
import android.content.Context;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: PlatformSelectionBehaviors.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b\"\u0010#J \u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b&\u0010#J*\u0010'\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096@¢\u0006\u0004\b*\u0010+J \u0010,\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b-\u0010#J(\u0010.\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b0\u00101J<\u00104\u001a\u00020%*\u0002052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020%07¢\u0006\u0002\b8H\u0000¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b=\u0010>J?\u0010?\u001a\u0004\u0018\u0001H@\"\u0004\b\u0000\u0010@2'\u0010A\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H@0C\u0012\u0006\u0012\u0004\u0018\u0001030B¢\u0006\u0002\b8H\u0082@¢\u0006\u0002\u0010DR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviorsImpl;", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "context", "Landroid/content/Context;", "selectedTextType", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroid/content/Context;Landroidx/compose/foundation/text/selection/SelectedTextType;Landroidx/compose/ui/text/intl/LocaleList;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "textClassificationSession", "Landroid/view/textclassifier/TextClassifier;", "<set-?>", "Landroidx/compose/foundation/text/selection/TextClassificationResult;", "textClassificationResult", "getTextClassificationResult", "()Landroidx/compose/foundation/text/selection/TextClassificationResult;", "setTextClassificationResult", "(Landroidx/compose/foundation/text/selection/TextClassificationResult;)V", "textClassificationResult$delegate", "Landroidx/compose/runtime/MutableState;", "androidLocalList", "Landroid/os/LocaleList;", "getAndroidLocalList", "()Landroid/os/LocaleList;", "suggestSelectionForLongPressOrDoubleClick", "Landroidx/compose/ui/text/TextRange;", "text", "", "selection", "suggestSelectionForLongPressOrDoubleClick-pYaCw-w", "(Ljava/lang/CharSequence;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowContextMenuOrSelectionToolbar", "", "onShowContextMenuOrSelectionToolbar-Sb-Bc2M", "onShowContextMenu", "secondaryClickLocation", "Landroidx/compose/ui/geometry/Offset;", "onShowContextMenu-_2OEclM", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/geometry/Offset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowSelectionToolbar", "onShowSelectionToolbar-Sb-Bc2M", "classifyText", "textClassifier", "classifyText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssistantItemKey", "", "addSmartSelectionTextContextMenuItems", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "child", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Ljava/lang/CharSequence;JLkotlin/jvm/functions/Function1;)V", "tryGetTextClassification", "Landroid/view/textclassifier/TextClassification;", "tryGetTextClassification-FDrldGo", "(Ljava/lang/CharSequence;J)Landroid/view/textclassifier/TextClassification;", "requireTextClassificationSession", ExifInterface.GPS_DIRECTION_TRUE, BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformSelectionBehaviorsImpl implements PlatformSelectionBehaviors {
    public static final int $stable = 8;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final LocaleList localeList;
    private final SelectedTextType selectedTextType;
    private TextClassifier textClassificationSession;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: textClassificationResult$delegate, reason: from kotlin metadata */
    private final MutableState textClassificationResult = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private final Object AssistantItemKey = new Object();

    public PlatformSelectionBehaviorsImpl(CoroutineContext coroutineContext, Context context, SelectedTextType selectedTextType, LocaleList localeList) {
        this.coroutineContext = coroutineContext;
        this.context = context;
        this.selectedTextType = selectedTextType;
        this.localeList = localeList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TextClassificationResult getTextClassificationResult() {
        return (TextClassificationResult) this.textClassificationResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextClassificationResult(TextClassificationResult textClassificationResult) {
        this.textClassificationResult.setValue(textClassificationResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final android.os.LocaleList getAndroidLocalList() {
        android.os.LocaleList androidLocaleList;
        LocaleList localeList = this.localeList;
        return (localeList == null || (androidLocaleList = TextClassifierHelperMethods.INSTANCE.toAndroidLocaleList(localeList)) == null) ? new android.os.LocaleList(Locale.INSTANCE.getCurrent().getPlatformLocale()) : androidLocaleList;
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* JADX INFO: renamed from: suggestSelectionForLongPressOrDoubleClick-pYaCw-w */
    public Object mo2284suggestSelectionForLongPressOrDoubleClickpYaCww(CharSequence charSequence, long j, Continuation<? super TextRange> continuation) {
        if (charSequence.length() == 0 || TextRange.m8267getCollapsedimpl(j)) {
            return null;
        }
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(charSequence, j, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onShowContextMenuOrSelectionToolbar-Sb-Bc2M, reason: not valid java name */
    public final Object m2288onShowContextMenuOrSelectionToolbarSbBc2M(CharSequence charSequence, long j, Continuation<? super Unit> continuation) {
        if (charSequence.length() == 0 || TextRange.m8267getCollapsedimpl(j)) {
            return Unit.INSTANCE;
        }
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$onShowContextMenuOrSelectionToolbar$2(this, charSequence, j, null), continuation);
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* JADX INFO: renamed from: onShowContextMenu-_2OEclM */
    public Object mo2282onShowContextMenu_2OEclM(CharSequence charSequence, long j, Offset offset, Continuation<? super Unit> continuation) {
        Object objM2288onShowContextMenuOrSelectionToolbarSbBc2M = m2288onShowContextMenuOrSelectionToolbarSbBc2M(charSequence, j, continuation);
        return objM2288onShowContextMenuOrSelectionToolbarSbBc2M == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2288onShowContextMenuOrSelectionToolbarSbBc2M : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* JADX INFO: renamed from: onShowSelectionToolbar-Sb-Bc2M */
    public Object mo2283onShowSelectionToolbarSbBc2M(CharSequence charSequence, long j, Continuation<? super Unit> continuation) {
        Object objM2288onShowContextMenuOrSelectionToolbarSbBc2M = m2288onShowContextMenuOrSelectionToolbarSbBc2M(charSequence, j, continuation);
        return objM2288onShowContextMenuOrSelectionToolbarSbBc2M == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2288onShowContextMenuOrSelectionToolbarSbBc2M : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX INFO: renamed from: classifyText-M8tDOmk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m2287classifyTextM8tDOmk(java.lang.CharSequence r21, long r22, android.view.textclassifier.TextClassifier r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl.m2287classifyTextM8tDOmk(java.lang.CharSequence, long, android.view.textclassifier.TextClassifier, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation, reason: not valid java name */
    public final void m2289addSmartSelectionTextContextMenuItemsYmzfRxQ$foundation(TextContextMenuBuilderScope textContextMenuBuilderScope, CharSequence charSequence, long j, Function1<? super TextContextMenuBuilderScope, Unit> function1) {
        TextClassification textClassificationM2290tryGetTextClassificationFDrldGo = m2290tryGetTextClassificationFDrldGo(charSequence, j);
        if (textClassificationM2290tryGetTextClassificationFDrldGo == null) {
            function1.invoke(textContextMenuBuilderScope);
            return;
        }
        if (!textClassificationM2290tryGetTextClassificationFDrldGo.getActions().isEmpty()) {
            TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, textClassificationM2290tryGetTextClassificationFDrldGo, 0);
        } else if (TextClassifierHelperMethods.INSTANCE.hasLegacyAssistItem$foundation(textClassificationM2290tryGetTextClassificationFDrldGo)) {
            TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, textClassificationM2290tryGetTextClassificationFDrldGo, -1);
        }
        function1.invoke(textContextMenuBuilderScope);
        List<RemoteAction> actions = textClassificationM2290tryGetTextClassificationFDrldGo.getActions();
        int size = actions.size();
        for (int i = 0; i < size; i++) {
            actions.get(i);
            if (i > 0) {
                TextContextMenuBuilderScope_androidKt.textClassificationItem(textContextMenuBuilderScope, this.AssistantItemKey, textClassificationM2290tryGetTextClassificationFDrldGo, i);
            }
        }
    }

    /* JADX INFO: renamed from: tryGetTextClassification-FDrldGo, reason: not valid java name */
    public final TextClassification m2290tryGetTextClassificationFDrldGo(CharSequence text, long selection) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return null;
        }
        TextClassificationResult textClassificationResult = getTextClassificationResult();
        TextClassification textClassification = (textClassificationResult == null || !PlatformSelectionBehaviors_androidKt.m2295canReuseh5sm0ck(textClassificationResult, text, selection)) ? null : textClassificationResult.getTextClassification();
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        return textClassification;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformSelectionBehaviors.android.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 1}, l = {369, 273, 282}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<TextClassifier, Continuation<? super T>, Object> $block;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlatformSelectionBehaviorsImpl.this.new AnonymousClass2(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0098 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L36
                if (r1 == r4) goto L29
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r10)
                return r10
            L16:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1e:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L26
                goto L76
            L26:
                r10 = move-exception
                goto L9c
            L29:
                java.lang.Object r1 = r9.L$1
                androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl r1 = (androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl) r1
                java.lang.Object r4 = r9.L$0
                kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
                kotlin.ResultKt.throwOnFailure(r10)
                r10 = r4
                goto L51
            L36:
                kotlin.ResultKt.throwOnFailure(r10)
                androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl r10 = androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl.this
                kotlinx.coroutines.sync.Mutex r10 = androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl.access$getMutex$p(r10)
                androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl r1 = androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl.this
                r6 = r9
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r9.L$0 = r10
                r9.L$1 = r1
                r9.label = r4
                java.lang.Object r4 = r10.lock(r5, r6)
                if (r4 != r0) goto L51
                goto L97
            L51:
                android.view.textclassifier.TextClassifier r4 = androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl.access$getTextClassificationSession$p(r1)     // Catch: java.lang.Throwable -> L99
                if (r4 == 0) goto L5d
                boolean r6 = r4.isDestroyed()     // Catch: java.lang.Throwable -> L99
                if (r6 == 0) goto L7a
            L5d:
                androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1 r4 = new androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1     // Catch: java.lang.Throwable -> L99
                r4.<init>(r1, r5)     // Catch: java.lang.Throwable -> L99
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L99
                r9.L$0 = r10     // Catch: java.lang.Throwable -> L99
                r9.L$1 = r5     // Catch: java.lang.Throwable -> L99
                r9.label = r3     // Catch: java.lang.Throwable -> L99
                r6 = 300(0x12c, double:1.48E-321)
                java.lang.Object r1 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r6, r4, r9)     // Catch: java.lang.Throwable -> L99
                if (r1 != r0) goto L73
                goto L97
            L73:
                r8 = r1
                r1 = r10
                r10 = r8
            L76:
                r4 = r10
                android.view.textclassifier.TextClassifier r4 = (android.view.textclassifier.TextClassifier) r4     // Catch: java.lang.Throwable -> L26
                r10 = r1
            L7a:
                r10.unlock(r5)
                androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1 r10 = new androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1
                kotlin.jvm.functions.Function2<android.view.textclassifier.TextClassifier, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r1 = r9.$block
                r10.<init>(r4, r1, r5)
                kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
                r1 = r9
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r9.L$0 = r5
                r9.L$1 = r5
                r9.label = r2
                r2 = 200(0xc8, double:9.9E-322)
                java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r2, r10, r1)
                if (r10 != r0) goto L98
            L97:
                return r0
            L98:
                return r10
            L99:
                r0 = move-exception
                r1 = r10
                r10 = r0
            L9c:
                r1.unlock(r5)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PlatformSelectionBehaviors.android.kt */
        @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1", f = "PlatformSelectionBehaviors.android.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
            final /* synthetic */ Function2<TextClassifier, Continuation<? super T>, Object> $block;
            final /* synthetic */ TextClassifier $textClassificationSession;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(TextClassifier textClassifier, Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$textClassificationSession = textClassifier;
                this.$block = function2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$textClassificationSession, this.$block, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                TextClassifier textClassifier = this.$textClassificationSession;
                if (textClassifier == null) {
                    return null;
                }
                Function2<TextClassifier, Continuation<? super T>, Object> function2 = this.$block;
                this.label = 1;
                Object objInvoke = function2.invoke(textClassifier, this);
                return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object requireTextClassificationSession(Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return BuildersKt.withContext(this.coroutineContext, new AnonymousClass2(function2, null), continuation);
    }
}
