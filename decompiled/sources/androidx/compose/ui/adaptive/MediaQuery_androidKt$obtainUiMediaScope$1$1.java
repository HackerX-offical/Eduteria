package androidx.compose.ui.adaptive;

import android.content.Context;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MediaQuery.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$1$1", f = "MediaQuery.android.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MediaQuery_androidKt$obtainUiMediaScope$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ UiMediaScopeImpl $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaQuery_androidKt$obtainUiMediaScope$1$1(Context context, UiMediaScopeImpl uiMediaScopeImpl, Continuation<? super MediaQuery_androidKt$obtainUiMediaScope$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$scope = uiMediaScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaQuery_androidKt$obtainUiMediaScope$1$1(this.$context, this.$scope, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaQuery_androidKt$obtainUiMediaScope$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaQuery.android.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "layout", "Landroidx/window/layout/WindowLayoutInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$1$1$1", f = "MediaQuery.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WindowLayoutInfo, Continuation<? super Unit>, Object> {
        final /* synthetic */ UiMediaScopeImpl $scope;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UiMediaScopeImpl uiMediaScopeImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$scope = uiMediaScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WindowLayoutInfo windowLayoutInfo, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(windowLayoutInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$scope.m5464set_windowPostureInyEWag(MediaQuery_androidKt.resolvePosture((WindowLayoutInfo) this.L$0));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.collectLatest(WindowInfoTracker.INSTANCE.getOrCreate(this.$context).windowLayoutInfo(this.$context), new AnonymousClass1(this.$scope, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
