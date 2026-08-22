package com.clevertap.android.sdk.inapp.delay;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.inapp.data.InAppDelayConstants;
import com.clevertap.android.sdk.inapp.delay.DelayedInAppResult;
import com.clevertap.android.sdk.inapp.store.db.DelayedLegacyInAppStore;
import com.clevertap.android.sdk.utils.Clock;
import com.clevertap.android.sdk.utils.JsonUtilsKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppDelayManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 =2\u00020\u0001:\u0003=>?BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0002J)\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0000¢\u0006\u0002\b$J\u000e\u0010%\u001a\u00020 H\u0086@¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020 J\u0015\u0010(\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u0003H\u0000¢\u0006\u0002\b*J\u000e\u0010+\u001a\u00020 H\u0082@¢\u0006\u0002\u0010&J\r\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J\r\u0010/\u001a\u00020-H\u0000¢\u0006\u0002\b0J\u0015\u00101\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u0003H\u0000¢\u0006\u0002\b2J\u0013\u00103\u001a\b\u0012\u0004\u0012\u00020\u000304H\u0000¢\u0006\u0002\b5J\u0010\u00106\u001a\u00020 H\u0080@¢\u0006\u0004\b7\u0010&J\u0010\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/clevertap/android/sdk/inapp/delay/InAppDelayManager;", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", "logger", "Lcom/clevertap/android/sdk/Logger;", "delayedLegacyInAppStore", "Lcom/clevertap/android/sdk/inapp/store/db/DelayedLegacyInAppStore;", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Ljava/lang/String;Lcom/clevertap/android/sdk/Logger;Lcom/clevertap/android/sdk/inapp/store/db/DelayedLegacyInAppStore;Lcom/clevertap/android/sdk/utils/Clock;Lkotlinx/coroutines/CoroutineScope;Landroidx/lifecycle/LifecycleOwner;)V", "getDelayedLegacyInAppStore$clevertap_core_release", "()Lcom/clevertap/android/sdk/inapp/store/db/DelayedLegacyInAppStore;", "setDelayedLegacyInAppStore$clevertap_core_release", "(Lcom/clevertap/android/sdk/inapp/store/db/DelayedLegacyInAppStore;)V", "activeJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Job;", "cancelledJobs", "Lcom/clevertap/android/sdk/inapp/delay/InAppDelayManager$CancelledJobData;", "scheduleInAppCallbackWithDispatcher", "id", "delayInMs", "", "callback", "Lkotlin/Function1;", "Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult;", "", "scheduleDelayedInApps", "delayedInApps", "Lorg/json/JSONArray;", "scheduleDelayedInApps$clevertap_core_release", "onAppBackground", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAppForeground", "cancelCallback", "", "cancelCallback$clevertap_core_release", "cancelAllCallbacks", "getActiveCallbackCount", "", "getActiveCallbackCount$clevertap_core_release", "getCancelledJobsCount", "getCancelledJobsCount$clevertap_core_release", "isCallbackScheduled", "isCallbackScheduled$clevertap_core_release", "getActiveCallbackIds", "", "getActiveCallbackIds$clevertap_core_release", "cleanup", "cleanup$clevertap_core_release", "getInAppDelayInMs", Constants.INAPP_KEY, "Lorg/json/JSONObject;", "logCoroutineInfo", "msg", "Companion", "RescheduleData", "CancelledJobData", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppDelayManager {
    private static final int PARALLEL_SCHEDULERS = 20;
    private static final String TAG = "[InAppDelayManager]:";
    private final String accountId;
    private final ConcurrentHashMap<String, Job> activeJobs;
    private final ConcurrentHashMap<String, CancelledJobData> cancelledJobs;
    private final Clock clock;
    private DelayedLegacyInAppStore delayedLegacyInAppStore;
    private final LifecycleOwner lifecycleOwner;
    private final Logger logger;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cancelAllCallbacks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppDelayManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.clevertap.android.sdk.inapp.delay.InAppDelayManager", f = "InAppDelayManager.kt", i = {0, 0}, l = {327}, m = "cancelAllCallbacks", n = {"this", "cancelledCount"}, s = {"L$0", "I$0"})
    static final class C06531 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06531(Continuation<? super C06531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppDelayManager.this.cancelAllCallbacks(this);
        }
    }

    public InAppDelayManager(String accountId, Logger logger, DelayedLegacyInAppStore delayedLegacyInAppStore, Clock clock, CoroutineScope scope, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.accountId = accountId;
        this.logger = logger;
        this.delayedLegacyInAppStore = delayedLegacyInAppStore;
        this.clock = clock;
        this.scope = scope;
        this.lifecycleOwner = lifecycleOwner;
        this.activeJobs = new ConcurrentHashMap<>();
        this.cancelledJobs = new ConcurrentHashMap<>();
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: getDelayedLegacyInAppStore$clevertap_core_release, reason: from getter */
    public final DelayedLegacyInAppStore getDelayedLegacyInAppStore() {
        return this.delayedLegacyInAppStore;
    }

    public final void setDelayedLegacyInAppStore$clevertap_core_release(DelayedLegacyInAppStore delayedLegacyInAppStore) {
        this.delayedLegacyInAppStore = delayedLegacyInAppStore;
    }

    public /* synthetic */ InAppDelayManager(String str, Logger logger, DelayedLegacyInAppStore delayedLegacyInAppStore, Clock clock, CoroutineScope coroutineScope, LifecycleOwner lifecycleOwner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, logger, (i & 4) != 0 ? null : delayedLegacyInAppStore, (i & 8) != 0 ? Clock.SYSTEM : clock, (i & 16) != 0 ? CoroutineScopeKt.plus(LifecycleOwnerKt.getLifecycleScope(ProcessLifecycleOwner.INSTANCE.get()), Dispatchers.getDefault().limitedParallelism(20)) : coroutineScope, (i & 32) != 0 ? ProcessLifecycleOwner.INSTANCE.get() : lifecycleOwner);
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.delay.InAppDelayManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppDelayManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.clevertap.android.sdk.inapp.delay.InAppDelayManager$1", f = "InAppDelayManager.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = InAppDelayManager.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                InAppDelayManager inAppDelayManager = InAppDelayManager.this;
                StringBuilder sbAppend = new StringBuilder("lifeCycleOwner scope launch, ").append(coroutineScope.getCoroutineContext()).append(", ");
                Job job = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                inAppDelayManager.logCoroutineInfo(sbAppend.append(job != null ? job.getParent() : null).append('}').toString());
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(InAppDelayManager.this.lifecycleOwner, Lifecycle.State.STARTED, new C01331(InAppDelayManager.this, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.delay.InAppDelayManager$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: InAppDelayManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.clevertap.android.sdk.inapp.delay.InAppDelayManager$1$1", f = "InAppDelayManager.kt", i = {0, 1}, l = {63, 66}, m = "invokeSuspend", n = {"$this$repeatOnLifecycle", "$this$repeatOnLifecycle"}, s = {"L$0", "L$0"})
        static final class C01331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ InAppDelayManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01331(InAppDelayManager inAppDelayManager, Continuation<? super C01331> continuation) {
                super(2, continuation);
                this.this$0 = inAppDelayManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01331 c01331 = new C01331(this.this$0, continuation);
                c01331.L$0 = obj;
                return c01331;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1 */
            /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.CoroutineScope] */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ?? r0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ?? r1 = this.label;
                try {
                } catch (CancellationException unused) {
                    InAppDelayManager inAppDelayManager = this.this$0;
                    StringBuilder sbAppend = new StringBuilder("process lifeCycleOwner: Stopped, ").append(r1.getCoroutineContext()).append(", ");
                    Job job = (Job) r1.getCoroutineContext().get(Job.INSTANCE);
                    inAppDelayManager.logCoroutineInfo(sbAppend.append(job != null ? job.getParent() : null).append('}').toString());
                    this.L$0 = r1;
                    this.label = 2;
                    if (BuildersKt.withContext(NonCancellable.INSTANCE, new C01341(this.this$0, null), this) != coroutine_suspended) {
                        r0 = r1;
                    }
                    return coroutine_suspended;
                }
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    InAppDelayManager inAppDelayManager2 = this.this$0;
                    StringBuilder sbAppend2 = new StringBuilder("process lifeCycleOwner: started, ").append(coroutineScope.getCoroutineContext()).append(", ");
                    Job job2 = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                    inAppDelayManager2.logCoroutineInfo(sbAppend2.append(job2 != null ? job2.getParent() : null).append('}').toString());
                    this.this$0.onAppForeground();
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    r1 = coroutineScope;
                    if (DelayKt.awaitCancellation(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (r1 != 1) {
                        if (r1 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r0 = coroutineScope2;
                        CoroutineScopeKt.ensureActive(r0);
                        return Unit.INSTANCE;
                    }
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r1 = coroutineScope3;
                }
                throw new KotlinNothingValueException();
            }

            /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.delay.InAppDelayManager$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: InAppDelayManager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.clevertap.android.sdk.inapp.delay.InAppDelayManager$1$1$1", f = "InAppDelayManager.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
            static final class C01341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ InAppDelayManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01341(InAppDelayManager inAppDelayManager, Continuation<? super C01341> continuation) {
                    super(2, continuation);
                    this.this$0 = inAppDelayManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01341 c01341 = new C01341(this.this$0, continuation);
                    c01341.L$0 = obj;
                    return c01341;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        InAppDelayManager inAppDelayManager = this.this$0;
                        StringBuilder sbAppend = new StringBuilder("process lifeCycleOwner: withContext block, ").append(coroutineScope.getCoroutineContext()).append(", ");
                        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                        inAppDelayManager.logCoroutineInfo(sbAppend.append(job != null ? job.getParent() : null).append('}').toString());
                        this.label = 1;
                        if (this.this$0.onAppBackground(this) == coroutine_suspended) {
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
        }
    }

    private final Job scheduleInAppCallbackWithDispatcher(String id, long delayInMs, Function1<? super DelayedInAppResult, Unit> callback) {
        Job job = this.activeJobs.get(id);
        if (job != null) {
            if (job.isActive()) {
                this.logger.verbose(this.accountId, "[InAppDelayManager]: InApp callback with id '" + id + "' already scheduled, keeping existing");
                return job;
            }
            this.activeJobs.remove(id);
        }
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new InAppDelayManager$scheduleInAppCallbackWithDispatcher$job$1(this, delayInMs, id, callback, null), 3, null);
        this.activeJobs.put(id, jobLaunch$default);
        this.logger.verbose(this.accountId, "[InAppDelayManager]: Scheduled new InApp callback with id '" + id + "' for " + delayInMs + "ms delay");
        return jobLaunch$default;
    }

    public final void scheduleDelayedInApps$clevertap_core_release(JSONArray delayedInApps, Function1<? super DelayedInAppResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(delayedInApps, "delayedInApps");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.logger.verbose(this.accountId, "[InAppDelayManager]: Scheduling " + delayedInApps.length() + " delayed in-apps");
        if (this.delayedLegacyInAppStore == null) {
            this.logger.verbose(this.accountId, "[InAppDelayManager]: DelayedLegacyInAppStore is null, aborting scheduling");
            return;
        }
        JSONArray jSONArrayFilterObjects = JsonUtilsKt.filterObjects(delayedInApps, new Function1() { // from class: com.clevertap.android.sdk.inapp.delay.InAppDelayManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InAppDelayManager.scheduleDelayedInApps$lambda$1(this.f$0, (JSONObject) obj));
            }
        });
        DelayedLegacyInAppStore delayedLegacyInAppStore = this.delayedLegacyInAppStore;
        Intrinsics.checkNotNull(delayedLegacyInAppStore);
        int i = 0;
        if (!delayedLegacyInAppStore.saveDelayedInAppsBatch(jSONArrayFilterObjects)) {
            int length = jSONArrayFilterObjects.length();
            while (i < length) {
                Object obj = jSONArrayFilterObjects.get(i);
                if (obj instanceof JSONObject) {
                    String strOptString = ((JSONObject) obj).optString(Constants.INAPP_ID_IN_PAYLOAD);
                    DelayedInAppResult.Error.ErrorReason errorReason = DelayedInAppResult.Error.ErrorReason.DB_SAVE_FAILED;
                    Intrinsics.checkNotNull(strOptString);
                    callback.invoke(new DelayedInAppResult.Error(errorReason, strOptString, null, 4, null));
                }
                i++;
            }
            return;
        }
        int length2 = jSONArrayFilterObjects.length();
        while (i < length2) {
            Object obj2 = jSONArrayFilterObjects.get(i);
            if (obj2 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj2;
                String strOptString2 = jSONObject.optString(Constants.INAPP_ID_IN_PAYLOAD);
                long inAppDelayInMs = getInAppDelayInMs(jSONObject);
                if (inAppDelayInMs > 0) {
                    Intrinsics.checkNotNull(strOptString2);
                    scheduleInAppCallbackWithDispatcher(strOptString2, inAppDelayInMs, callback);
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean scheduleDelayedInApps$lambda$1(InAppDelayManager this$0, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strOptString = jsonObject.optString(Constants.INAPP_ID_IN_PAYLOAD);
        Intrinsics.checkNotNull(strOptString);
        return !StringsKt.isBlank(strOptString) && this$0.activeJobs.get(strOptString) == null;
    }

    public final Object onAppBackground(Continuation<? super Unit> continuation) {
        Object objCancelAllCallbacks = cancelAllCallbacks(continuation);
        return objCancelAllCallbacks == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancelAllCallbacks : Unit.INSTANCE;
    }

    public final void onAppForeground() {
        this.logger.verbose(this.accountId, "[InAppDelayManager]: App coming to foreground, checking for pending in-apps");
        if (this.delayedLegacyInAppStore == null) {
            this.logger.verbose(this.accountId, "[InAppDelayManager]: DelayedLegacyInAppStore is null, aborting foreground handling");
            return;
        }
        if (this.cancelledJobs.isEmpty()) {
            this.logger.verbose(this.accountId, "[InAppDelayManager]: No pending delayed in-apps found");
            return;
        }
        this.logger.verbose(this.accountId, "[InAppDelayManager]: Found " + this.cancelledJobs.size() + " pending delayed in-apps");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        ArrayList<RescheduleData> arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        for (Map.Entry<String, CancelledJobData> entry : this.cancelledJobs.entrySet()) {
            String key = entry.getKey();
            CancelledJobData value = entry.getValue();
            long originalDelayInMs = value.getOriginalDelayInMs();
            long scheduledAt = value.getScheduledAt();
            Function1<DelayedInAppResult, Unit> callback = value.getCallback();
            long j = jCurrentTimeMillis - scheduledAt;
            long j2 = originalDelayInMs - j;
            long j3 = jCurrentTimeMillis;
            this.logger.verbose(this.accountId, "[InAppDelayManager]: InApp " + key + " - Original delay: " + originalDelayInMs + "ms, Elapsed: " + j + "ms, Remaining: " + j2 + "ms");
            if (j2 > 0) {
                arrayList.add(new RescheduleData(key, j2, callback));
            } else {
                arrayList2.add(key);
            }
            jCurrentTimeMillis = j3;
        }
        int i = 0;
        int i2 = 0;
        for (RescheduleData rescheduleData : arrayList) {
            scheduleInAppCallbackWithDispatcher(rescheduleData.getInAppId(), rescheduleData.getRemainingTimeInMs(), rescheduleData.getCallback());
            i2++;
            this.logger.verbose(this.accountId, "[InAppDelayManager]: Rescheduled " + rescheduleData.getInAppId() + " with " + rescheduleData.getRemainingTimeInMs() + "ms remaining");
        }
        for (String str : arrayList2) {
            DelayedLegacyInAppStore delayedLegacyInAppStore = this.delayedLegacyInAppStore;
            Intrinsics.checkNotNull(delayedLegacyInAppStore);
            delayedLegacyInAppStore.removeDelayedInApp(str);
            this.cancelledJobs.remove(str);
            i++;
            this.logger.verbose(this.accountId, "[InAppDelayManager]: Discarded expired in-app " + str);
        }
        this.logger.verbose(this.accountId, "[InAppDelayManager]: Foreground handling complete - Rescheduled: " + i2 + ", Discarded: " + i);
    }

    public final boolean cancelCallback$clevertap_core_release(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Job job = this.activeJobs.get(id);
        if (job == null) {
            return false;
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        this.activeJobs.remove(id);
        this.logger.verbose(this.accountId, "Cancelled InApp callback with id: " + id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cancelAllCallbacks(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.clevertap.android.sdk.inapp.delay.InAppDelayManager.C06531
            if (r0 == 0) goto L14
            r0 = r7
            com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cancelAllCallbacks$1 r0 = (com.clevertap.android.sdk.inapp.delay.InAppDelayManager.C06531) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cancelAllCallbacks$1 r0 = new com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cancelAllCallbacks$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.L$0
            com.clevertap.android.sdk.inapp.delay.InAppDelayManager r5 = (com.clevertap.android.sdk.inapp.delay.InAppDelayManager) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5f
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, kotlinx.coroutines.Job> r7 = r6.activeJobs
            int r7 = r7.size()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, kotlinx.coroutines.Job> r2 = r6.activeJobs
            java.util.Collection r2 = r2.values()
            java.lang.String r4 = "<get-values>(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r5 = r6
            r4 = r2
            r2 = r7
        L5f:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L7d
            java.lang.Object r7 = r4.next()
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r0.L$0 = r5
            r0.L$1 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.JobKt.cancelAndJoin(r7, r0)
            if (r7 != r1) goto L5f
            return r1
        L7d:
            com.clevertap.android.sdk.Logger r7 = r5.logger
            java.lang.String r0 = r5.accountId
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "[InAppDelayManager]: Cancelled "
            r1.<init>(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " InApp callbacks"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r7.verbose(r0, r1)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.delay.InAppDelayManager.cancelAllCallbacks(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int getActiveCallbackCount$clevertap_core_release() {
        return this.activeJobs.size();
    }

    public final int getCancelledJobsCount$clevertap_core_release() {
        return this.cancelledJobs.size();
    }

    public final boolean isCallbackScheduled$clevertap_core_release(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Job job = this.activeJobs.get(id);
        if (job != null) {
            return job.isActive();
        }
        return false;
    }

    public final Set<String> getActiveCallbackIds$clevertap_core_release() {
        ConcurrentHashMap<String, Job> concurrentHashMap = this.activeJobs;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Job> entry : concurrentHashMap.entrySet()) {
            if (entry.getValue().isActive()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return CollectionsKt.toSet(linkedHashMap.keySet());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cleanup$clevertap_core_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cleanup$1
            if (r0 == 0) goto L14
            r0 = r5
            com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cleanup$1 r0 = (com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cleanup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cleanup$1 r0 = new com.clevertap.android.sdk.inapp.delay.InAppDelayManager$cleanup$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.clevertap.android.sdk.inapp.delay.InAppDelayManager r0 = (com.clevertap.android.sdk.inapp.delay.InAppDelayManager) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.cancelAllCallbacks(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            r0 = r4
        L45:
            kotlinx.coroutines.CoroutineScope r5 = r0.scope
            r0 = 0
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(r5, r0, r3, r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.delay.InAppDelayManager.cleanup$clevertap_core_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long getInAppDelayInMs(JSONObject inApp) {
        int iOptInt = inApp.optInt(InAppDelayConstants.INAPP_DELAY_AFTER_TRIGGER, 0);
        if (1 > iOptInt || iOptInt >= 1201) {
            return 0L;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m13751getInWholeMillisecondsimpl(DurationKt.toDuration(iOptInt, DurationUnit.SECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logCoroutineInfo(String msg) {
        this.logger.verbose(this.accountId, "[InAppDelayManager]: Running on: [" + Thread.currentThread().getName() + "] | " + msg);
    }

    /* JADX INFO: compiled from: InAppDelayManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/clevertap/android/sdk/inapp/delay/InAppDelayManager$RescheduleData;", "", Column.INAPP_ID, "", "remainingTimeInMs", "", "callback", "Lkotlin/Function1;", "Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult;", "", "<init>", "(Ljava/lang/String;JLkotlin/jvm/functions/Function1;)V", "getInAppId", "()Ljava/lang/String;", "getRemainingTimeInMs", "()J", "getCallback", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final /* data */ class RescheduleData {
        private final Function1<DelayedInAppResult, Unit> callback;
        private final String inAppId;
        private final long remainingTimeInMs;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RescheduleData copy$default(RescheduleData rescheduleData, String str, long j, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rescheduleData.inAppId;
            }
            if ((i & 2) != 0) {
                j = rescheduleData.remainingTimeInMs;
            }
            if ((i & 4) != 0) {
                function1 = rescheduleData.callback;
            }
            return rescheduleData.copy(str, j, function1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getInAppId() {
            return this.inAppId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getRemainingTimeInMs() {
            return this.remainingTimeInMs;
        }

        public final Function1<DelayedInAppResult, Unit> component3() {
            return this.callback;
        }

        public final RescheduleData copy(String inAppId, long remainingTimeInMs, Function1<? super DelayedInAppResult, Unit> callback) {
            Intrinsics.checkNotNullParameter(inAppId, "inAppId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            return new RescheduleData(inAppId, remainingTimeInMs, callback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RescheduleData)) {
                return false;
            }
            RescheduleData rescheduleData = (RescheduleData) other;
            return Intrinsics.areEqual(this.inAppId, rescheduleData.inAppId) && this.remainingTimeInMs == rescheduleData.remainingTimeInMs && Intrinsics.areEqual(this.callback, rescheduleData.callback);
        }

        public int hashCode() {
            return (((this.inAppId.hashCode() * 31) + Long.hashCode(this.remainingTimeInMs)) * 31) + this.callback.hashCode();
        }

        public String toString() {
            return "RescheduleData(inAppId=" + this.inAppId + ", remainingTimeInMs=" + this.remainingTimeInMs + ", callback=" + this.callback + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RescheduleData(String inAppId, long j, Function1<? super DelayedInAppResult, Unit> callback) {
            Intrinsics.checkNotNullParameter(inAppId, "inAppId");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.inAppId = inAppId;
            this.remainingTimeInMs = j;
            this.callback = callback;
        }

        public final String getInAppId() {
            return this.inAppId;
        }

        public final long getRemainingTimeInMs() {
            return this.remainingTimeInMs;
        }

        public final Function1<DelayedInAppResult, Unit> getCallback() {
            return this.callback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: InAppDelayManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/delay/InAppDelayManager$CancelledJobData;", "", "originalDelayInMs", "", "scheduledAt", "callback", "Lkotlin/Function1;", "Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult;", "", "<init>", "(JJLkotlin/jvm/functions/Function1;)V", "getOriginalDelayInMs", "()J", "getScheduledAt", "getCallback", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final /* data */ class CancelledJobData {
        private final Function1<DelayedInAppResult, Unit> callback;
        private final long originalDelayInMs;
        private final long scheduledAt;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CancelledJobData copy$default(CancelledJobData cancelledJobData, long j, long j2, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                j = cancelledJobData.originalDelayInMs;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = cancelledJobData.scheduledAt;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                function1 = cancelledJobData.callback;
            }
            return cancelledJobData.copy(j3, j4, function1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getOriginalDelayInMs() {
            return this.originalDelayInMs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getScheduledAt() {
            return this.scheduledAt;
        }

        public final Function1<DelayedInAppResult, Unit> component3() {
            return this.callback;
        }

        public final CancelledJobData copy(long originalDelayInMs, long scheduledAt, Function1<? super DelayedInAppResult, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            return new CancelledJobData(originalDelayInMs, scheduledAt, callback);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CancelledJobData)) {
                return false;
            }
            CancelledJobData cancelledJobData = (CancelledJobData) other;
            return this.originalDelayInMs == cancelledJobData.originalDelayInMs && this.scheduledAt == cancelledJobData.scheduledAt && Intrinsics.areEqual(this.callback, cancelledJobData.callback);
        }

        public int hashCode() {
            return (((Long.hashCode(this.originalDelayInMs) * 31) + Long.hashCode(this.scheduledAt)) * 31) + this.callback.hashCode();
        }

        public String toString() {
            return "CancelledJobData(originalDelayInMs=" + this.originalDelayInMs + ", scheduledAt=" + this.scheduledAt + ", callback=" + this.callback + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CancelledJobData(long j, long j2, Function1<? super DelayedInAppResult, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.originalDelayInMs = j;
            this.scheduledAt = j2;
            this.callback = callback;
        }

        public final long getOriginalDelayInMs() {
            return this.originalDelayInMs;
        }

        public final long getScheduledAt() {
            return this.scheduledAt;
        }

        public final Function1<DelayedInAppResult, Unit> getCallback() {
            return this.callback;
        }
    }
}
