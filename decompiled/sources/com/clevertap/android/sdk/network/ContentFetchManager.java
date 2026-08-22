package com.clevertap.android.sdk.network;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.api.ContentFetchRequestBody;
import com.clevertap.android.sdk.network.api.CtApiWrapper;
import com.clevertap.android.sdk.network.http.Response;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.clevertap.android.sdk.response.ClevertapResponseHandler;
import com.clevertap.android.sdk.utils.Clock;
import com.clevertap.android.sdk.utils.CtDefaultDispatchers;
import com.clevertap.android.sdk.utils.DispatcherProvider;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContentFetchManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 72\u00020\u0001:\u00017BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020'2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)H\u0002J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020'H\u0082@¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020.H\u0002J\u0006\u00105\u001a\u00020%J\b\u00106\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\n \"*\u0004\u0018\u00010!0!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u00068"}, d2 = {"Lcom/clevertap/android/sdk/network/ContentFetchManager;", "", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "coreMetaData", "Lcom/clevertap/android/sdk/CoreMetaData;", "queueHeaderBuilder", "Lcom/clevertap/android/sdk/network/QueueHeaderBuilder;", "ctApiWrapper", "Lcom/clevertap/android/sdk/network/api/CtApiWrapper;", "parallelRequests", "", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "dispatchers", "Lcom/clevertap/android/sdk/utils/DispatcherProvider;", "<init>", "(Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Lcom/clevertap/android/sdk/CoreMetaData;Lcom/clevertap/android/sdk/network/QueueHeaderBuilder;Lcom/clevertap/android/sdk/network/api/CtApiWrapper;ILcom/clevertap/android/sdk/utils/Clock;Lcom/clevertap/android/sdk/utils/DispatcherProvider;)V", "clevertapResponseHandler", "Lcom/clevertap/android/sdk/response/ClevertapResponseHandler;", "getClevertapResponseHandler", "()Lcom/clevertap/android/sdk/response/ClevertapResponseHandler;", "setClevertapResponseHandler", "(Lcom/clevertap/android/sdk/response/ClevertapResponseHandler;)V", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "getParentJob", "()Lkotlinx/coroutines/CompletableJob;", "setParentJob", "(Lkotlinx/coroutines/CompletableJob;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "logger", "Lcom/clevertap/android/sdk/Logger;", "kotlin.jvm.PlatformType", "Lcom/clevertap/android/sdk/Logger;", "handleContentFetch", "", "contentFetchItems", "Lorg/json/JSONArray;", "packageName", "", "getContentFetchPayload", "getMetaData", "Lorg/json/JSONObject;", "sendContentFetchRequest", "", "content", "(Lorg/json/JSONArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleContentFetchResponse", SaslNonza.Response.ELEMENT, "Lcom/clevertap/android/sdk/network/http/Response;", "isUserSwitching", "cancelAllResponseJobs", "resetScope", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentFetchManager {
    private static final int DEFAULT_PARALLEL_REQUESTS = 5;
    private static final String TAG = "ContentFetch";
    private ClevertapResponseHandler clevertapResponseHandler;
    private final Clock clock;
    private final CoreMetaData coreMetaData;
    private final CtApiWrapper ctApiWrapper;
    private final DispatcherProvider dispatchers;
    private final Logger logger;
    private final int parallelRequests;
    private CompletableJob parentJob;
    private final QueueHeaderBuilder queueHeaderBuilder;
    private CoroutineScope scope;

    public ContentFetchManager(CleverTapInstanceConfig config, CoreMetaData coreMetaData, QueueHeaderBuilder queueHeaderBuilder, CtApiWrapper ctApiWrapper, int i, Clock clock, DispatcherProvider dispatchers) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(coreMetaData, "coreMetaData");
        Intrinsics.checkNotNullParameter(queueHeaderBuilder, "queueHeaderBuilder");
        Intrinsics.checkNotNullParameter(ctApiWrapper, "ctApiWrapper");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.coreMetaData = coreMetaData;
        this.queueHeaderBuilder = queueHeaderBuilder;
        this.ctApiWrapper = ctApiWrapper;
        this.parallelRequests = i;
        this.clock = clock;
        this.dispatchers = dispatchers;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.parentJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus(dispatchers.io().limitedParallelism(i)));
        this.logger = config.getLogger();
    }

    public /* synthetic */ ContentFetchManager(CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData, QueueHeaderBuilder queueHeaderBuilder, CtApiWrapper ctApiWrapper, int i, Clock clock, DispatcherProvider dispatcherProvider, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(cleverTapInstanceConfig, coreMetaData, queueHeaderBuilder, ctApiWrapper, (i2 & 16) != 0 ? 5 : i, (i2 & 32) != 0 ? Clock.SYSTEM : clock, (i2 & 64) != 0 ? new CtDefaultDispatchers() : dispatcherProvider);
    }

    public final ClevertapResponseHandler getClevertapResponseHandler() {
        return this.clevertapResponseHandler;
    }

    public final void setClevertapResponseHandler(ClevertapResponseHandler clevertapResponseHandler) {
        this.clevertapResponseHandler = clevertapResponseHandler;
    }

    public final CompletableJob getParentJob() {
        return this.parentJob;
    }

    public final void setParentJob(CompletableJob completableJob) {
        Intrinsics.checkNotNullParameter(completableJob, "<set-?>");
        this.parentJob = completableJob;
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.network.ContentFetchManager$handleContentFetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentFetchManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.clevertap.android.sdk.network.ContentFetchManager$handleContentFetch$1", f = "ContentFetchManager.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    static final class C06571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSONArray $contentFetchItems;
        final /* synthetic */ String $packageName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06571(JSONArray jSONArray, String str, Continuation<? super C06571> continuation) {
            super(2, continuation);
            this.$contentFetchItems = jSONArray;
            this.$packageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContentFetchManager.this.new C06571(this.$contentFetchItems, this.$packageName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONArray contentFetchPayload = ContentFetchManager.this.getContentFetchPayload(this.$contentFetchItems, this.$packageName);
                    if (contentFetchPayload.length() > 0) {
                        this.label = 1;
                        if (ContentFetchManager.this.sendContentFetchRequest(contentFetchPayload, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        ContentFetchManager.this.logger.verbose(ContentFetchManager.TAG, "No valid content fetch items to send.");
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (CancellationException unused) {
                ContentFetchManager.this.logger.verbose(ContentFetchManager.TAG, "Fetch job was cancelled.");
            } catch (Exception e2) {
                ContentFetchManager.this.logger.verbose(ContentFetchManager.TAG, "Unexpected error during content fetch", e2);
            }
            return Unit.INSTANCE;
        }
    }

    public final void handleContentFetch(JSONArray contentFetchItems, String packageName) {
        Intrinsics.checkNotNullParameter(contentFetchItems, "contentFetchItems");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C06571(contentFetchItems, packageName, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONArray getContentFetchPayload(JSONArray contentFetchItems, String packageName) {
        JSONArray jSONArray = new JSONArray();
        int length = contentFetchItems.length();
        for (int i = 0; i < length; i++) {
            Object objOpt = contentFetchItems.opt(i);
            if (objOpt != null) {
                try {
                    JSONObject metaData = getMetaData(packageName);
                    metaData.put(Constants.KEY_EVT_DATA, objOpt);
                    jSONArray.put(metaData);
                    this.logger.verbose(TAG, "Added content fetch item: " + objOpt);
                } catch (Exception e2) {
                    this.logger.verbose(TAG, "Error adding content fetch item: " + objOpt, e2);
                }
            }
        }
        return jSONArray;
    }

    private final JSONObject getMetaData(String packageName) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "event");
        jSONObject.put(Constants.KEY_EVT_NAME, Constants.CONTENT_FETCH_JSON_RESPONSE_KEY);
        jSONObject.put(CmcdData.Factory.STREAMING_FORMAT_SS, this.coreMetaData.getCurrentSessionId());
        jSONObject.put("pg", CoreMetaData.getActivityCount());
        jSONObject.put("ep", this.clock.currentTimeSecondsInt());
        jSONObject.put("f", this.coreMetaData.isFirstSession());
        jSONObject.put("lsl", this.coreMetaData.getLastSessionLength());
        jSONObject.put("pai", packageName);
        String screenName = this.coreMetaData.getScreenName();
        if (screenName != null) {
            jSONObject.put(CTProductConfigConstants.PRODUCT_CONFIG_JSON_KEY_FOR_KEY, screenName);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendContentFetchRequest(JSONArray jSONArray, Continuation<? super Boolean> continuation) {
        JSONObject jSONObjectBuildHeader = this.queueHeaderBuilder.buildHeader(null);
        if (jSONObjectBuildHeader == null) {
            return Boxing.boxBoolean(false);
        }
        ContentFetchRequestBody contentFetchRequestBody = new ContentFetchRequestBody(jSONObjectBuildHeader, jSONArray);
        this.logger.debug(TAG, "Fetching Content: " + contentFetchRequestBody);
        try {
            Response responseSendContentFetch = this.ctApiWrapper.getCtApi().sendContentFetch(contentFetchRequestBody);
            try {
                Boolean boolBoxBoolean = Boxing.boxBoolean(handleContentFetchResponse(responseSendContentFetch, !JobKt.isActive(continuation.get$context())));
                CloseableKt.closeFinally(responseSendContentFetch, null);
                return boolBoxBoolean;
            } finally {
            }
        } catch (Exception e2) {
            this.logger.debug(TAG, "An exception occurred while fetching content.", e2);
            return Boxing.boxBoolean(false);
        }
    }

    private final boolean handleContentFetchResponse(Response response, boolean isUserSwitching) {
        ClevertapResponseHandler clevertapResponseHandler;
        if (response.isSuccess()) {
            String body = response.readBody();
            JSONObject jsonOrNull = CTXtensions.toJsonOrNull(body);
            this.logger.info(TAG, "Content fetch response received successfully with isUserSwitching = " + isUserSwitching);
            if (body != null && jsonOrNull != null && (clevertapResponseHandler = this.clevertapResponseHandler) != null) {
                clevertapResponseHandler.handleResponse(false, jsonOrNull, body, isUserSwitching);
            }
            return true;
        }
        if (response.getCode() == 429) {
            this.logger.info(TAG, "Content fetch request was rate limited (429). Consider reducing request frequency.");
        } else {
            this.logger.info(TAG, "Content fetch request failed with response code: " + response.getCode());
        }
        return false;
    }

    public final void cancelAllResponseJobs() throws InterruptedException {
        this.logger.info(TAG, "Cancelling pending content fetch jobs");
        Job.DefaultImpls.cancel$default((Job) this.parentJob, (CancellationException) null, 1, (Object) null);
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        resetScope();
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.network.ContentFetchManager$cancelAllResponseJobs$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContentFetchManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.clevertap.android.sdk.network.ContentFetchManager$cancelAllResponseJobs$1", f = "ContentFetchManager.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ContentFetchManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator<Job> it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = ContentFetchManager.this.getParentJob().getChildren().iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Job next = it.next();
                this.L$0 = it;
                this.label = 1;
                if (next.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final void resetScope() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.parentJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus(this.dispatchers.io().limitedParallelism(this.parallelRequests)));
    }
}
