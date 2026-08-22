package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.core.os.LocaleListCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aô\u0001\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d\u001a$\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u001a5\u0010,\u001a\u0002H-\"\u0004\b\u0000\u0010-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e00H\u0080@ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u001d\u00102\u001a\u00020\u001e*\u0002032\u0006\u0010\u0014\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104\u001a#\u00105\u001a\u00020\u001e*\u0002032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u00106\u001a#\u00107\u001a\u00020\u001e*\u0002032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002080\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u00106\u001a#\u00109\u001a\u00020\u001e*\u0002032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002080\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u00106\u001a#\u0010:\u001a\u00020\u001e*\u0002032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u00106\u001a5\u0010;\u001a\u00020\u0006*\u0002032\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010<\u001a\u0010\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020>*\u000203\u001a\u001d\u0010?\u001a\u00020\u0002*\u0002032\u0006\u0010\u0014\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104\u001a\u001b\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e*\u000203H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010A\u001a\"\u0010B\u001a\u00020\n*\u0002032\u0006\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0006\u001a%\u0010G\u001a\u00020\n\"\u0004\b\u0000\u0010H*\b\u0012\u0004\u0012\u0002HH0I2\u0006\u0010J\u001a\u0002HHH\u0000¢\u0006\u0002\u0010K\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\"\u0016\u0010\u0014\u001a\u00020\u0006*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\b\"\u0016\u0010\u0016\u001a\u00020\u0006*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\b\"\u0016\u0010\u0018\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006L"}, d2 = {"bytesDownloaded", "", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "getBytesDownloaded", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)J", "errorCode", "", "getErrorCode", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)I", "hasTerminalStatus", "", "getHasTerminalStatus", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)Z", "languages", "", "", "getLanguages", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)Ljava/util/List;", "moduleNames", "getModuleNames", "sessionId", "getSessionId", "status", "getStatus", "totalBytesToDownload", "getTotalBytesToDownload", "SplitInstallStateUpdatedListener", "Lcom/google/android/play/core/splitinstall/SplitInstallStateUpdatedListener;", "onRequiresConfirmation", "Lkotlin/Function1;", "", "onInstalled", "onFailed", "onPending", "onDownloaded", "onDownloading", "onInstalling", "onCanceling", "onCanceled", "onNonTerminalStatus", "onTerminalStatus", "buildSplitInstallRequest", "Lcom/google/android/play/core/splitinstall/SplitInstallRequest;", "modules", "runTask", ExifInterface.GPS_DIRECTION_TRUE, "task", "Lcom/google/android/gms/tasks/Task;", "Lkotlin/Function0;", "(Lcom/google/android/gms/tasks/Task;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCancelInstall", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDeferredInstall", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDeferredLanguageInstall", "Ljava/util/Locale;", "requestDeferredLanguageUninstall", "requestDeferredUninstall", "requestInstall", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestProgressFlow", "Lkotlinx/coroutines/flow/Flow;", "requestSessionState", "requestSessionStates", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConfirmationDialogForResult", "sessionState", "fragment", "Landroidx/fragment/app/Fragment;", "requestCode", "tryOffer", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/SendChannel;", "element", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Z", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_feature_delivery_ktx"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SplitInstallManagerKtxKt {

    /* JADX INFO: renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {}, l = {46}, m = "requestInstall", n = {}, s = {})
    static final class C06591 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06591(Continuation<? super C06591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestInstall(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1", f = "SplitInstallManagerKtx.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    static final class C06601 extends SuspendLambda implements Function2<ProducerScope<? super SplitInstallSessionState>, Continuation<? super Unit>, Object> {
        final /* synthetic */ SplitInstallManager $this_requestProgressFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06601(SplitInstallManager splitInstallManager, Continuation<? super C06601> continuation) {
            super(2, continuation);
            this.$this_requestProgressFlow = splitInstallManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06601 c06601 = new C06601(this.$this_requestProgressFlow, continuation);
            c06601.L$0 = obj;
            return c06601;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super SplitInstallSessionState> producerScope, Continuation<? super Unit> continuation) {
            return ((C06601) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final LinkedHashSet linkedHashSet = new LinkedHashSet();
                final SplitInstallStateUpdatedListener splitInstallStateUpdatedListener = new SplitInstallStateUpdatedListener() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1
                    @Override // com.google.android.play.core.listener.StateUpdatedListener
                    public final void onStateUpdate(SplitInstallSessionState state) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        linkedHashSet.add(Integer.valueOf(state.sessionId()));
                        SplitInstallManagerKtxKt.tryOffer(producerScope, state);
                    }
                };
                this.$this_requestProgressFlow.registerListener(splitInstallStateUpdatedListener);
                this.$this_requestProgressFlow.getSessionStates().addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestProgressFlow.1.1
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(List<? extends SplitInstallSessionState> sessionList) {
                        Intrinsics.checkNotNullParameter(sessionList, "sessionList");
                        Set<Integer> set = linkedHashSet;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : sessionList) {
                            if (!set.contains(Integer.valueOf(((SplitInstallSessionState) obj2).sessionId()))) {
                                arrayList.add(obj2);
                            }
                        }
                        ProducerScope<SplitInstallSessionState> producerScope2 = producerScope;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            SplitInstallManagerKtxKt.tryOffer(producerScope2, (SplitInstallSessionState) it.next());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestProgressFlow.1.2
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exception) {
                        Intrinsics.checkNotNullParameter(exception, "exception");
                        producerScope.close(exception);
                    }
                });
                final SplitInstallManager splitInstallManager = this.$this_requestProgressFlow;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestProgressFlow.1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        splitInstallManager.unregisterListener(splitInstallStateUpdatedListener);
                    }
                }, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {}, l = {120}, m = "requestSessionState", n = {}, s = {})
    static final class C06611 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06611(Continuation<? super C06611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestSessionState(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {}, l = {94}, m = "requestSessionStates", n = {}, s = {})
    static final class C06621 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06621(Continuation<? super C06621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplitInstallManagerKtxKt.requestSessionStates(null, this);
        }
    }

    public static final int getErrorCode(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "<this>");
        return splitInstallSessionState.errorCode();
    }

    public static final int getSessionId(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "<this>");
        return splitInstallSessionState.sessionId();
    }

    public static final int getStatus(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "<this>");
        return splitInstallSessionState.status();
    }

    public static final long getBytesDownloaded(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "<this>");
        return splitInstallSessionState.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "<this>");
        return splitInstallSessionState.totalBytesToDownload();
    }

    private static final SplitInstallRequest buildSplitInstallRequest(List<String> list, List<String> list2) {
        SplitInstallRequest.Builder builderNewBuilder = SplitInstallRequest.newBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            builderNewBuilder.addModule((String) it.next());
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            builderNewBuilder.addLanguage(LocaleListCompat.forLanguageTags((String) it2.next()).get(0));
        }
        SplitInstallRequest splitInstallRequestBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(splitInstallRequestBuild, "newBuilder()\n    .apply …(0)) }\n    }\n    .build()");
        return splitInstallRequestBuild;
    }

    public static final SplitInstallStateUpdatedListener SplitInstallStateUpdatedListener(final Function1<? super SplitInstallSessionState, Unit> onRequiresConfirmation, final Function1<? super SplitInstallSessionState, Unit> onInstalled, final Function1<? super SplitInstallSessionState, Unit> onFailed, final Function1<? super SplitInstallSessionState, Unit> onPending, final Function1<? super SplitInstallSessionState, Unit> onDownloaded, final Function1<? super SplitInstallSessionState, Unit> onDownloading, final Function1<? super SplitInstallSessionState, Unit> onInstalling, final Function1<? super SplitInstallSessionState, Unit> onCanceling, final Function1<? super SplitInstallSessionState, Unit> onCanceled, final Function1<? super SplitInstallSessionState, Unit> onNonTerminalStatus, final Function1<? super SplitInstallSessionState, Unit> onTerminalStatus) {
        Intrinsics.checkNotNullParameter(onRequiresConfirmation, "onRequiresConfirmation");
        Intrinsics.checkNotNullParameter(onInstalled, "onInstalled");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        Intrinsics.checkNotNullParameter(onPending, "onPending");
        Intrinsics.checkNotNullParameter(onDownloaded, "onDownloaded");
        Intrinsics.checkNotNullParameter(onDownloading, "onDownloading");
        Intrinsics.checkNotNullParameter(onInstalling, "onInstalling");
        Intrinsics.checkNotNullParameter(onCanceling, "onCanceling");
        Intrinsics.checkNotNullParameter(onCanceled, "onCanceled");
        Intrinsics.checkNotNullParameter(onNonTerminalStatus, "onNonTerminalStatus");
        Intrinsics.checkNotNullParameter(onTerminalStatus, "onTerminalStatus");
        return new SplitInstallStateUpdatedListener() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.SplitInstallStateUpdatedListener.10
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public final void onStateUpdate(SplitInstallSessionState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                switch (state.status()) {
                    case 0:
                    case 6:
                        onFailed.invoke(state);
                        break;
                    case 1:
                        onPending.invoke(state);
                        break;
                    case 2:
                        onDownloading.invoke(state);
                        break;
                    case 3:
                        onDownloaded.invoke(state);
                        break;
                    case 4:
                        onInstalling.invoke(state);
                        break;
                    case 5:
                        onInstalled.invoke(state);
                        break;
                    case 7:
                        onCanceled.invoke(state);
                        break;
                    case 8:
                        onRequiresConfirmation.invoke(state);
                        break;
                    case 9:
                        onCanceling.invoke(state);
                        break;
                }
                if (state.hasTerminalStatus()) {
                    onTerminalStatus.invoke(state);
                } else {
                    onNonTerminalStatus.invoke(state);
                }
            }
        };
    }

    public static final Object requestCancelInstall(SplitInstallManager splitInstallManager, int i, Continuation<? super Unit> continuation) {
        Task<Void> taskCancelInstall = splitInstallManager.cancelInstall(i);
        Intrinsics.checkNotNullExpressionValue(taskCancelInstall, "cancelInstall(sessionId)");
        Object objRunTask$default = runTask$default(taskCancelInstall, null, continuation, 2, null);
        return objRunTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunTask$default : Unit.INSTANCE;
    }

    public static final Object requestDeferredInstall(SplitInstallManager splitInstallManager, List<String> list, Continuation<? super Unit> continuation) {
        Task<Void> taskDeferredInstall = splitInstallManager.deferredInstall(list);
        Intrinsics.checkNotNullExpressionValue(taskDeferredInstall, "deferredInstall(moduleNames)");
        Object objRunTask$default = runTask$default(taskDeferredInstall, null, continuation, 2, null);
        return objRunTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunTask$default : Unit.INSTANCE;
    }

    public static final Object requestDeferredLanguageInstall(SplitInstallManager splitInstallManager, List<Locale> list, Continuation<? super Unit> continuation) {
        Task<Void> taskDeferredLanguageInstall = splitInstallManager.deferredLanguageInstall(list);
        Intrinsics.checkNotNullExpressionValue(taskDeferredLanguageInstall, "deferredLanguageInstall(languages)");
        Object objRunTask$default = runTask$default(taskDeferredLanguageInstall, null, continuation, 2, null);
        return objRunTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunTask$default : Unit.INSTANCE;
    }

    public static final Object requestDeferredLanguageUninstall(SplitInstallManager splitInstallManager, List<Locale> list, Continuation<? super Unit> continuation) {
        Task<Void> taskDeferredLanguageUninstall = splitInstallManager.deferredLanguageUninstall(list);
        Intrinsics.checkNotNullExpressionValue(taskDeferredLanguageUninstall, "deferredLanguageUninstall(languages)");
        Object objRunTask$default = runTask$default(taskDeferredLanguageUninstall, null, continuation, 2, null);
        return objRunTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunTask$default : Unit.INSTANCE;
    }

    public static final Object requestDeferredUninstall(SplitInstallManager splitInstallManager, List<String> list, Continuation<? super Unit> continuation) {
        Task<Void> taskDeferredInstall = splitInstallManager.deferredInstall(list);
        Intrinsics.checkNotNullExpressionValue(taskDeferredInstall, "deferredInstall(moduleNames)");
        Object objRunTask$default = runTask$default(taskDeferredInstall, null, continuation, 2, null);
        return objRunTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunTask$default : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object requestInstall(com.google.android.play.core.splitinstall.SplitInstallManager r4, java.util.List<java.lang.String> r5, java.util.List<java.lang.String> r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            boolean r0 = r7 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.C06591
            if (r0 == 0) goto L14
            r0 = r7
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1 r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.C06591) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1 r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestInstall$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4d
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.play.core.splitinstall.SplitInstallRequest r5 = buildSplitInstallRequest(r5, r6)
            com.google.android.gms.tasks.Task r4 = r4.startInstall(r5)
            java.lang.String r5 = "startInstall(buildSplitI…uest(modules, languages))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.label = r3
            r5 = 0
            r6 = 2
            java.lang.Object r7 = runTask$default(r4, r5, r0, r6, r5)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            java.lang.String r4 = "runTask(startInstall(bui…est(modules, languages)))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestInstall(com.google.android.play.core.splitinstall.SplitInstallManager, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object requestInstall$default(SplitInstallManager splitInstallManager, List list, List list2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return requestInstall(splitInstallManager, list, list2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object requestSessionState(com.google.android.play.core.splitinstall.SplitInstallManager r4, int r5, kotlin.coroutines.Continuation<? super com.google.android.play.core.splitinstall.SplitInstallSessionState> r6) {
        /*
            boolean r0 = r6 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.C06611
            if (r0 == 0) goto L14
            r0 = r6
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1 r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.C06611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1 r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionState$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.gms.tasks.Task r4 = r4.getSessionState(r5)
            java.lang.String r5 = "getSessionState(sessionId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.label = r3
            r5 = 0
            r6 = 2
            java.lang.Object r6 = runTask$default(r4, r5, r0, r6, r5)
            if (r6 != r1) goto L49
            return r1
        L49:
            java.lang.String r4 = "runTask(getSessionState(sessionId))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestSessionState(com.google.android.play.core.splitinstall.SplitInstallManager, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object requestSessionStates(com.google.android.play.core.splitinstall.SplitInstallManager r4, kotlin.coroutines.Continuation<? super java.util.List<? extends com.google.android.play.core.splitinstall.SplitInstallSessionState>> r5) {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.SplitInstallManagerKtxKt.C06621
            if (r0 == 0) goto L14
            r0 = r5
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1 r0 = (com.google.android.play.core.ktx.SplitInstallManagerKtxKt.C06621) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1 r0 = new com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestSessionStates$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L49
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            com.google.android.gms.tasks.Task r4 = r4.getSessionStates()
            java.lang.String r5 = "sessionStates"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.label = r3
            r5 = 0
            r2 = 2
            java.lang.Object r5 = runTask$default(r4, r5, r0, r2, r5)
            if (r5 != r1) goto L49
            return r1
        L49:
            java.lang.String r4 = "runTask(sessionStates)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.requestSessionStates(com.google.android.play.core.splitinstall.SplitInstallManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> Object runTask(Task<T> task, final Function0<Unit> function0, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$runTask$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                function0.invoke();
            }
        });
        if (task.isComplete()) {
            if (task.isSuccessful()) {
                cancellableContinuationImpl2.resumeWith(Result.m12393constructorimpl(task.getResult()));
            } else {
                Exception exception = task.getException();
                Intrinsics.checkNotNull(exception);
                cancellableContinuationImpl2.resumeWith(Result.m12393constructorimpl(ResultKt.createFailure(exception)));
            }
        } else {
            task.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$runTask$3$2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(T t) {
                    cancellableContinuationImpl2.resumeWith(Result.m12393constructorimpl(t));
                }
            });
            task.addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$runTask$3$3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exception2) {
                    Intrinsics.checkNotNullParameter(exception2, "exception");
                    cancellableContinuationImpl2.resumeWith(Result.m12393constructorimpl(ResultKt.createFailure(exception2)));
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object runTask$default(Task task, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.runTask.2
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        return runTask(task, function0, continuation);
    }

    public static final List<String> getLanguages(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "<this>");
        List<String> listLanguages = splitInstallSessionState.languages();
        Intrinsics.checkNotNullExpressionValue(listLanguages, "languages()");
        return listLanguages;
    }

    public static final List<String> getModuleNames(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "<this>");
        List<String> listModuleNames = splitInstallSessionState.moduleNames();
        Intrinsics.checkNotNullExpressionValue(listModuleNames, "moduleNames()");
        return listModuleNames;
    }

    public static final Flow<SplitInstallSessionState> requestProgressFlow(SplitInstallManager splitInstallManager) {
        Intrinsics.checkNotNullParameter(splitInstallManager, "<this>");
        return FlowKt__ContextKt.buffer$default(FlowKt.callbackFlow(new C06601(splitInstallManager, null)), Integer.MAX_VALUE, null, 2, null);
    }

    public static final boolean getHasTerminalStatus(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "<this>");
        return splitInstallSessionState.hasTerminalStatus();
    }

    public static final boolean startConfirmationDialogForResult(SplitInstallManager splitInstallManager, SplitInstallSessionState sessionState, final Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(splitInstallManager, "<this>");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return splitInstallManager.startConfirmationDialogForResult(sessionState, new IntentSenderForResultStarter() { // from class: com.google.android.play.core.ktx.SplitInstallManagerKtxKt.startConfirmationDialogForResult.1
            @Override // com.google.android.play.core.common.IntentSenderForResultStarter
            public final void startIntentSenderForResult(IntentSender p0, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
                Intrinsics.checkNotNullParameter(p0, "p0");
                fragment.startIntentSenderForResult(p0, i2, intent, i3, i4, i5, bundle);
            }
        }, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> boolean tryOffer(SendChannel<? super E> sendChannel, E e2) {
        Intrinsics.checkNotNullParameter(sendChannel, "<this>");
        return ChannelResult.m13920isSuccessimpl(sendChannel.mo13895trySendJP2dKIU(e2));
    }
}
