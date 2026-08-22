package com.appnew.android.Utils.firebaseToken;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.appnew.android.Utils.Helper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: compiled from: FCMTokenHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002JL\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u00142\u001e\b\u0002\u0010\u0015\u001a\u0018\u0012\f\u0012\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0 H\u0082@¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0012H\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010%\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/appnew/android/Utils/firebaseToken/FCMTokenHelper;", "", "<init>", "()V", "TAG", "", "PREF_NAME", FCMTokenHelper.KEY_LAST_INFO, "KEY_DEVICE_TOKEN", "MAX_RETRIES", "", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "getValidFCMToken", "", "currentUserId", "Lcom/appnew/android/Utils/firebaseToken/UserInfo;", "onTokenReady", "Lkotlin/Function1;", "onFailure", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getSavedToken", "resetUserIdOnly", "clearAll", "preloadTokenIfMissing", "getOrRefreshToken", "(Landroid/content/Context;Lcom/appnew/android/Utils/firebaseToken/UserInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "await", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/android/gms/tasks/Task;", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUserInfo", "userInfo", "getUserInfo", "isGooglePlayServicesReady", "", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FCMTokenHelper {
    public static final int $stable = 0;
    public static final FCMTokenHelper INSTANCE = new FCMTokenHelper();
    private static final String KEY_DEVICE_TOKEN = "device_token_new";
    private static final String KEY_LAST_INFO = "KEY_LAST_INFO";
    private static final int MAX_RETRIES = 3;
    private static final String PREF_NAME = "fcm_prefs";
    private static final String TAG = "FCMTokenHelper";

    /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getOrRefreshToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: FCMTokenHelper.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper", f = "FCMTokenHelper.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {118, 123, 135}, m = "getOrRefreshToken", n = {"context", "currentUserId", "context", "currentUserId", "attempt", "context", "currentUserId"}, s = {"L$0", "L$1", "L$0", "L$1", "I$2", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FCMTokenHelper.this.getOrRefreshToken(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$isGooglePlayServicesReady$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FCMTokenHelper.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper", f = "FCMTokenHelper.kt", i = {0, 1, 2, 3, 4, 5}, l = {ByteCode.ARETURN, ByteCode.INVOKEDYNAMIC, ByteCode.MONITOREXIT, 213, 226, 237, 257}, m = "isGooglePlayServicesReady", n = {"context", "context", "context", "context", "context", "context"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
    static final class C05501 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05501(Continuation<? super C05501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FCMTokenHelper.this.isGooglePlayServicesReady(null, this);
        }
    }

    private FCMTokenHelper() {
    }

    private final SharedPreferences getPrefs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public static /* synthetic */ void getValidFCMToken$default(Context context, UserInfo userInfo, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 8) != 0) {
            function12 = null;
        }
        getValidFCMToken(context, userInfo, function1, function12);
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FCMTokenHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1", f = "FCMTokenHelper.kt", i = {0}, l = {47, 64, 65, 71}, m = "invokeSuspend", n = {"googlePlayServiceIsReady"}, s = {"L$0"})
    static final class C05491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ UserInfo $currentUserId;
        final /* synthetic */ Function1<String, Unit> $onTokenReady;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05491(Context context, UserInfo userInfo, Function1<? super String, Unit> function1, Continuation<? super C05491> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$currentUserId = userInfo;
            this.$onTokenReady = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05491(this.$context, this.$currentUserId, this.$onTokenReady, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, new com.appnew.android.Utils.firebaseToken.FCMTokenHelper.C05491.AnonymousClass2(r6, (java.lang.String) r11, null), r10) != r0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00bf, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.appnew.android.Utils.firebaseToken.FCMTokenHelper.C05491.AnonymousClass3(r10.$onTokenReady, null), r10) != r0) goto L36;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                java.lang.String r2 = "FCMTokenHelper"
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = 0
                if (r1 == 0) goto L37
                if (r1 == r6) goto L2f
                if (r1 == r5) goto L29
                if (r1 == r4) goto L24
                if (r1 != r3) goto L1c
                kotlin.ResultKt.throwOnFailure(r11)
                goto Lc2
            L1c:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L24:
                kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L2d
                goto Lc2
            L29:
                kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L2d
                goto L81
            L2d:
                r11 = move-exception
                goto L9e
            L2f:
                java.lang.Object r1 = r10.L$0
                kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
                kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L2d
                goto L5c
            L37:
                kotlin.ResultKt.throwOnFailure(r11)
                kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
                r1.<init>()
                kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L2d
                kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L2d
                com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$1 r8 = new com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$1     // Catch: java.lang.Exception -> L2d
                android.content.Context r9 = r10.$context     // Catch: java.lang.Exception -> L2d
                r8.<init>(r9, r1, r7)     // Catch: java.lang.Exception -> L2d
                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: java.lang.Exception -> L2d
                r9 = r10
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Exception -> L2d
                r10.L$0 = r1     // Catch: java.lang.Exception -> L2d
                r10.label = r6     // Catch: java.lang.Exception -> L2d
                java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r8, r9)     // Catch: java.lang.Exception -> L2d
                if (r11 != r0) goto L5c
                goto Lc1
            L5c:
                boolean r11 = r1.element     // Catch: java.lang.Exception -> L2d
                if (r11 != 0) goto L68
                java.lang.String r11 = "Google Play Services not available. Aborting token fetch."
                android.util.Log.e(r2, r11)     // Catch: java.lang.Exception -> L2d
                kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L2d
                return r11
            L68:
                android.content.Context r11 = r10.$context     // Catch: java.lang.Exception -> L2d
                com.appnew.android.Utils.Helper.showProgressDialog(r11)     // Catch: java.lang.Exception -> L2d
                com.appnew.android.Utils.firebaseToken.FCMTokenHelper r11 = com.appnew.android.Utils.firebaseToken.FCMTokenHelper.INSTANCE     // Catch: java.lang.Exception -> L2d
                android.content.Context r1 = r10.$context     // Catch: java.lang.Exception -> L2d
                com.appnew.android.Utils.firebaseToken.UserInfo r6 = r10.$currentUserId     // Catch: java.lang.Exception -> L2d
                r8 = r10
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.lang.Exception -> L2d
                r10.L$0 = r7     // Catch: java.lang.Exception -> L2d
                r10.label = r5     // Catch: java.lang.Exception -> L2d
                java.lang.Object r11 = com.appnew.android.Utils.firebaseToken.FCMTokenHelper.access$getOrRefreshToken(r11, r1, r6, r8)     // Catch: java.lang.Exception -> L2d
                if (r11 != r0) goto L81
                goto Lc1
            L81:
                java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Exception -> L2d
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L2d
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch: java.lang.Exception -> L2d
                com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$2 r5 = new com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$2     // Catch: java.lang.Exception -> L2d
                kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r6 = r10.$onTokenReady     // Catch: java.lang.Exception -> L2d
                r5.<init>(r6, r11, r7)     // Catch: java.lang.Exception -> L2d
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Exception -> L2d
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Exception -> L2d
                r10.label = r4     // Catch: java.lang.Exception -> L2d
                java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r1, r5, r11)     // Catch: java.lang.Exception -> L2d
                if (r11 != r0) goto Lc2
                goto Lc1
            L9e:
                java.lang.String r1 = "Token fetch failed after retries"
                java.lang.Throwable r11 = (java.lang.Throwable) r11
                android.util.Log.e(r2, r1, r11)
                kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
                com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$3 r1 = new com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$3
                kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r2 = r10.$onTokenReady
                r1.<init>(r2, r7)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r2 = r10
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r10.L$0 = r7
                r10.label = r3
                java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r1, r2)
                if (r11 != r0) goto Lc2
            Lc1:
                return r0
            Lc2:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.firebaseToken.FCMTokenHelper.C05491.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FCMTokenHelper.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$1", f = "FCMTokenHelper.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
        static final class C01061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ Ref.BooleanRef $googlePlayServiceIsReady;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01061(Context context, Ref.BooleanRef booleanRef, Continuation<? super C01061> continuation) {
                super(2, continuation);
                this.$context = context;
                this.$googlePlayServiceIsReady = booleanRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01061(this.$context, this.$googlePlayServiceIsReady, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Ref.BooleanRef booleanRef;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Helper.isNetworkConnected(this.$context)) {
                        Ref.BooleanRef booleanRef2 = this.$googlePlayServiceIsReady;
                        this.L$0 = booleanRef2;
                        this.label = 1;
                        Object objIsGooglePlayServicesReady = FCMTokenHelper.INSTANCE.isGooglePlayServicesReady(this.$context, this);
                        if (objIsGooglePlayServicesReady == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        booleanRef = booleanRef2;
                        obj = objIsGooglePlayServicesReady;
                    } else {
                        Helper.showToast(this.$context, "No internet network connection", 0);
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booleanRef = (Ref.BooleanRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                booleanRef.element = ((Boolean) obj).booleanValue();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: FCMTokenHelper.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$2", f = "FCMTokenHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<String, Unit> $onTokenReady;
            final /* synthetic */ String $token;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function1<? super String, Unit> function1, String str, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$onTokenReady = function1;
                this.$token = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$onTokenReady, this.$token, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Helper.dismissProgressDialog();
                this.$onTokenReady.invoke(this.$token);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: FCMTokenHelper.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper$getValidFCMToken$1$3", f = "FCMTokenHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<String, Unit> $onTokenReady;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(Function1<? super String, Unit> function1, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$onTokenReady = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$onTokenReady, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$onTokenReady.invoke("device_token_static");
                return Unit.INSTANCE;
            }
        }
    }

    @JvmStatic
    public static final void getValidFCMToken(Context context, UserInfo currentUserId, Function1<? super String, Unit> onTokenReady, Function1<? super Exception, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(currentUserId, "currentUserId");
        Intrinsics.checkNotNullParameter(onTokenReady, "onTokenReady");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C05491(context, currentUserId, onTokenReady, null), 3, null);
    }

    @JvmStatic
    public static final String getSavedToken(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getPrefs(context).getString(KEY_DEVICE_TOKEN, null);
    }

    @JvmStatic
    public static final void resetUserIdOnly(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getPrefs(context).edit().remove(KEY_LAST_INFO).apply();
    }

    @JvmStatic
    public static final void clearAll(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getPrefs(context).edit().clear().apply();
    }

    @JvmStatic
    public static final void preloadTokenIfMissing(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final SharedPreferences prefs = INSTANCE.getPrefs(context);
        String string = prefs.getString(KEY_DEVICE_TOKEN, null);
        String str = string;
        if (str == null || str.length() == 0) {
            Task<String> token = FirebaseMessaging.getInstance().getToken();
            final Function1 function1 = new Function1() { // from class: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FCMTokenHelper.preloadTokenIfMissing$lambda$0(prefs, (String) obj);
                }
            };
            Intrinsics.checkNotNull(token.addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    FCMTokenHelper.preloadTokenIfMissing$lambda$2(exc);
                }
            }));
            return;
        }
        Log.d(TAG, "existing FCM token at startup: " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadTokenIfMissing$lambda$0(SharedPreferences sharedPreferences, String str) {
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            sharedPreferences.edit().putString(KEY_DEVICE_TOKEN, str).apply();
            Log.d(TAG, "Prefetched FCM token at startup: " + str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadTokenIfMissing$lambda$2(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Log.w(TAG, "FCM preload failed", it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00af, code lost:
    
        if (await(r2, r3) == r4) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f1 A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #1 {Exception -> 0x0062, blocks: (B:38:0x00e3, B:40:0x00f1, B:17:0x005d), top: B:54:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ef -> B:49:0x0171). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0169 -> B:48:0x016d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getOrRefreshToken(android.content.Context r17, com.appnew.android.Utils.firebaseToken.UserInfo r18, kotlin.coroutines.Continuation<? super java.lang.String> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.firebaseToken.FCMTokenHelper.getOrRefreshToken(android.content.Context, com.appnew.android.Utils.firebaseToken.UserInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object await(Task<T> task, Continuation<? super T> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        final Function1<T, Unit> function1 = new Function1<T, Unit>() { // from class: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$await$2$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                Continuation<T> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m12393constructorimpl(t));
            }
        };
        task.addOnSuccessListener(new OnSuccessListener(function1) { // from class: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.function.invoke(obj);
            }
        });
        task.addOnFailureListener(new OnFailureListener() { // from class: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$await$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<T> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m12393constructorimpl(ResultKt.createFailure(it)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @JvmStatic
    public static final void saveUserInfo(Context context, UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        SharedPreferences prefs = INSTANCE.getPrefs(context);
        prefs.edit().putString(KEY_LAST_INFO, new Gson().toJson(userInfo)).apply();
    }

    @JvmStatic
    public static final UserInfo getUserInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = INSTANCE.getPrefs(context).getString(KEY_LAST_INFO, null);
        if (string == null) {
            return null;
        }
        try {
            return (UserInfo) new Gson().fromJson(string, UserInfo.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x015b, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r3, r1) != r2) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object isGooglePlayServicesReady(android.content.Context r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.firebaseToken.FCMTokenHelper.isGooglePlayServicesReady(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$isGooglePlayServicesReady$2, reason: invalid class name */
    /* JADX INFO: compiled from: FCMTokenHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper$isGooglePlayServicesReady$2", f = "FCMTokenHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.$context, "Google Play Services is disabled. Please enable it in settings.", 1).show();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$isGooglePlayServicesReady$3, reason: invalid class name */
    /* JADX INFO: compiled from: FCMTokenHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper$isGooglePlayServicesReady$3", f = "FCMTokenHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ int $status;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(int i, Context context, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$status = i;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$status, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (GoogleApiAvailability.getInstance().isUserResolvableError(this.$status) && (this.$context instanceof Activity)) {
                Dialog errorDialog = GoogleApiAvailability.getInstance().getErrorDialog((Activity) this.$context, this.$status, 2404);
                if (errorDialog == null) {
                    return null;
                }
                errorDialog.show();
                return Unit.INSTANCE;
            }
            Toast.makeText(this.$context, "Google Play Services is outdated or unsupported.", 1).show();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.firebaseToken.FCMTokenHelper$isGooglePlayServicesReady$4, reason: invalid class name */
    /* JADX INFO: compiled from: FCMTokenHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Utils.firebaseToken.FCMTokenHelper$isGooglePlayServicesReady$4", f = "FCMTokenHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Exception $e;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Context context, Exception exc, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$e = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$context, this.$e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.$context, "Unexpected error: " + this.$e.getLocalizedMessage(), 1).show();
            return Unit.INSTANCE;
        }
    }
}
