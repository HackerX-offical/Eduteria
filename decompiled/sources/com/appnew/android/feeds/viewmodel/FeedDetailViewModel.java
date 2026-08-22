package com.appnew.android.feeds.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.appnew.mvvmwithretrofit.repository.Repository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: compiled from: FeedDetailViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020AJ\u0016\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010EJ\b\u0010G\u001a\u00020AH\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0011\u00108\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R \u0010<\u001a\b\u0012\u0004\u0012\u00020\u001b0,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010.\"\u0004\b>\u0010?¨\u0006H"}, d2 = {"Lcom/appnew/android/feeds/viewmodel/FeedDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/appnew/mvvmwithretrofit/repository/Repository;", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "<init>", "(Lcom/appnew/mvvmwithretrofit/repository/Repository;Lcom/appnew/android/Room/UtkashRoom;)V", "getRepository", "()Lcom/appnew/mvvmwithretrofit/repository/Repository;", "setRepository", "(Lcom/appnew/mvvmwithretrofit/repository/Repository;)V", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "adapter_response", "Landroidx/lifecycle/MutableLiveData;", "Lorg/json/JSONObject;", "getAdapter_response", "()Landroidx/lifecycle/MutableLiveData;", "setAdapter_response", "(Landroidx/lifecycle/MutableLiveData;)V", "jsonObjectmutable", "getJsonObjectmutable", "setJsonObjectmutable", "adapter_bodydata", "", "getAdapter_bodydata", "setAdapter_bodydata", "progressvalue", "getProgressvalue", "setProgressvalue", "type", "getType", "setType", "bodydata", "getBodydata", "setBodydata", "_relatedCourse", "", "Lcom/appnew/android/feeds/dataclass/NewCourseData;", "get_relatedCourse", "relatedCourse", "Landroidx/lifecycle/LiveData;", "getRelatedCourse", "()Landroidx/lifecycle/LiveData;", "metaindexencryptionData", "Lcom/appnew/android/EncryptionModel/EncryptionData;", "getMetaindexencryptionData", "()Lcom/appnew/android/EncryptionModel/EncryptionData;", "userid", "getUserid", "()Ljava/lang/String;", "setUserid", "(Ljava/lang/String;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "responseString", "getResponseString", "setResponseString", "(Landroidx/lifecycle/LiveData;)V", "getcourutine_adapter_post", "", "getPostData", "checkchnageDetector", "jsonObject", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkandupdateversion", "onCleared", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDetailViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<List<NewCourseData>> _relatedCourse;
    private MutableLiveData<String> adapter_bodydata;
    private MutableLiveData<JSONObject> adapter_response;
    private MutableLiveData<String> bodydata;
    private final CoroutineExceptionHandler handler;
    private MutableLiveData<JSONObject> jsonObjectmutable;
    private final EncryptionData metaindexencryptionData;
    private MutableLiveData<String> progressvalue;
    private final LiveData<List<NewCourseData>> relatedCourse;
    private Repository repository;
    private LiveData<String> responseString;
    private MutableLiveData<String> type;
    private String userid;
    private UtkashRoom utkashRoom;

    /* JADX INFO: renamed from: com.appnew.android.feeds.viewmodel.FeedDetailViewModel$checkandupdateversion$1, reason: invalid class name */
    /* JADX INFO: compiled from: FeedDetailViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.viewmodel.FeedDetailViewModel", f = "FeedDetailViewModel.kt", i = {}, l = {162}, m = "checkandupdateversion", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FeedDetailViewModel.this.checkandupdateversion(null, this);
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.viewmodel.FeedDetailViewModel$checkchnageDetector$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedDetailViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.viewmodel.FeedDetailViewModel", f = "FeedDetailViewModel.kt", i = {0, 0, 1, 1}, l = {138, 150}, m = "checkchnageDetector", n = {"this", "jsonObject", "this", "jsonObject"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C05831 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05831(Continuation<? super C05831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FeedDetailViewModel.this.checkchnageDetector(null, this);
        }
    }

    public final Repository getRepository() {
        return this.repository;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setRepository(Repository repository) {
        Intrinsics.checkNotNullParameter(repository, "<set-?>");
        this.repository = repository;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    public FeedDetailViewModel(Repository repository, UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(utkashRoom, "utkashRoom");
        this.repository = repository;
        this.utkashRoom = utkashRoom;
        this.adapter_response = new MutableLiveData<>();
        this.jsonObjectmutable = new MutableLiveData<>();
        this.adapter_bodydata = new MutableLiveData<>();
        this.progressvalue = new MutableLiveData<>();
        this.type = new MutableLiveData<>();
        this.bodydata = new MutableLiveData<>();
        MutableLiveData<List<NewCourseData>> mutableLiveData = new MutableLiveData<>();
        this._relatedCourse = mutableLiveData;
        this.relatedCourse = mutableLiveData;
        EncryptionData encryptionData = new EncryptionData();
        this.metaindexencryptionData = encryptionData;
        this.userid = "";
        encryptionData.setUser_id("1");
        this.userid = MakeMyExam.userId;
        this.handler = new FeedDetailViewModel$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.responseString = new MutableLiveData();
    }

    public final MutableLiveData<JSONObject> getAdapter_response() {
        return this.adapter_response;
    }

    public final void setAdapter_response(MutableLiveData<JSONObject> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.adapter_response = mutableLiveData;
    }

    public final MutableLiveData<JSONObject> getJsonObjectmutable() {
        return this.jsonObjectmutable;
    }

    public final void setJsonObjectmutable(MutableLiveData<JSONObject> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.jsonObjectmutable = mutableLiveData;
    }

    public final MutableLiveData<String> getAdapter_bodydata() {
        return this.adapter_bodydata;
    }

    public final void setAdapter_bodydata(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.adapter_bodydata = mutableLiveData;
    }

    public final MutableLiveData<String> getProgressvalue() {
        return this.progressvalue;
    }

    public final void setProgressvalue(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressvalue = mutableLiveData;
    }

    public final MutableLiveData<String> getType() {
        return this.type;
    }

    public final void setType(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.type = mutableLiveData;
    }

    public final MutableLiveData<String> getBodydata() {
        return this.bodydata;
    }

    public final void setBodydata(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.bodydata = mutableLiveData;
    }

    public final MutableLiveData<List<NewCourseData>> get_relatedCourse() {
        return this._relatedCourse;
    }

    public final LiveData<List<NewCourseData>> getRelatedCourse() {
        return this.relatedCourse;
    }

    public final EncryptionData getMetaindexencryptionData() {
        return this.metaindexencryptionData;
    }

    public final String getUserid() {
        return this.userid;
    }

    public final void setUserid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userid = str;
    }

    public final CoroutineExceptionHandler getHandler() {
        return this.handler;
    }

    public final LiveData<String> getResponseString() {
        return this.responseString;
    }

    public final void setResponseString(LiveData<String> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.responseString = liveData;
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.viewmodel.FeedDetailViewModel$getcourutine_adapter_post$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.viewmodel.FeedDetailViewModel$getcourutine_adapter_post$1", f = "FeedDetailViewModel.kt", i = {7}, l = {65, 68, 71, 74, 77, 80, 83, 92}, m = "invokeSuspend", n = {"jsonObject"}, s = {"L$0"})
    static final class C05851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C05851(Continuation<? super C05851> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedDetailViewModel.this.new C05851(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        
            if (r7 == r0) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00ae, code lost:
        
            if (r7 == r0) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00de, code lost:
        
            if (r7 == r0) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x010e, code lost:
        
            if (r7 == r0) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x013d, code lost:
        
            if (r7 == r0) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x016b, code lost:
        
            if (r7 == r0) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0190, code lost:
        
            if (r7 == r0) goto L74;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0172  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0197 A[Catch: Exception -> 0x01f3, TRY_ENTER, TryCatch #0 {Exception -> 0x01f3, blocks: (B:7:0x0015, B:76:0x01ea, B:68:0x0197, B:70:0x01a1, B:72:0x01aa), top: B:80:0x0006 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01a0  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01aa A[Catch: Exception -> 0x01f3, TryCatch #0 {Exception -> 0x01f3, blocks: (B:7:0x0015, B:76:0x01ea, B:68:0x0197, B:70:0x01a1, B:72:0x01aa), top: B:80:0x0006 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instruction units count: 550
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.viewmodel.FeedDetailViewModel.C05851.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void getcourutine_adapter_post() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.handler, null, new C05851(null), 2, null);
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.viewmodel.FeedDetailViewModel$getPostData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FeedDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.viewmodel.FeedDetailViewModel$getPostData$1", f = "FeedDetailViewModel.kt", i = {1}, l = {103, 116}, m = "invokeSuspend", n = {"jsonObject"}, s = {"L$0"})
    static final class C05841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C05841(Continuation<? super C05841> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FeedDetailViewModel.this.new C05841(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00b7 A[Catch: Exception -> 0x00e8, PHI: r11
          0x00b7: PHI (r11v26 androidx.lifecycle.MutableLiveData<org.json.JSONObject>) = 
          (r11v23 androidx.lifecycle.MutableLiveData<org.json.JSONObject>)
          (r11v28 androidx.lifecycle.MutableLiveData<org.json.JSONObject>)
         binds: [B:48:0x00d6, B:32:0x00b5] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {Exception -> 0x00e8, blocks: (B:31:0x00af, B:33:0x00b7, B:35:0x00bc, B:49:0x00d7, B:51:0x00df, B:53:0x00e4, B:54:0x00e7, B:46:0x00ce, B:20:0x0051, B:22:0x005e, B:24:0x0068), top: B:60:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00bb A[PHI: r0 r11
          0x00bb: PHI (r0v9 org.json.JSONObject) = (r0v8 org.json.JSONObject), (r0v10 org.json.JSONObject) binds: [B:47:0x00d4, B:32:0x00b5] A[DONT_GENERATE, DONT_INLINE]
          0x00bb: PHI (r11v24 androidx.lifecycle.MutableLiveData<org.json.JSONObject>) = 
          (r11v23 androidx.lifecycle.MutableLiveData<org.json.JSONObject>)
          (r11v28 androidx.lifecycle.MutableLiveData<org.json.JSONObject>)
         binds: [B:47:0x00d4, B:32:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00df A[Catch: Exception -> 0x00e8, TryCatch #4 {Exception -> 0x00e8, blocks: (B:31:0x00af, B:33:0x00b7, B:35:0x00bc, B:49:0x00d7, B:51:0x00df, B:53:0x00e4, B:54:0x00e7, B:46:0x00ce, B:20:0x0051, B:22:0x005e, B:24:0x0068), top: B:60:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.viewmodel.FeedDetailViewModel.C05841.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void getPostData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.handler, null, new C05841(null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkchnageDetector(org.json.JSONObject r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.viewmodel.FeedDetailViewModel.checkchnageDetector(org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0155 A[Catch: Exception -> 0x0046, TryCatch #0 {Exception -> 0x0046, blocks: (B:11:0x0041, B:18:0x0054, B:20:0x005a, B:22:0x0066, B:25:0x007d, B:28:0x0095, B:30:0x00a3, B:32:0x00d1, B:35:0x0147, B:37:0x0155, B:39:0x0172, B:41:0x017b, B:44:0x019c, B:46:0x01aa, B:48:0x01c5, B:49:0x01e7, B:43:0x0183, B:50:0x021a, B:52:0x0228, B:54:0x0236, B:56:0x0264, B:57:0x028e, B:58:0x02c1, B:60:0x02cd, B:62:0x02dc, B:64:0x030b, B:66:0x0320, B:67:0x0335, B:69:0x0347, B:71:0x0371, B:72:0x0380, B:73:0x0396, B:74:0x03a9, B:33:0x010f), top: B:79:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0228 A[Catch: Exception -> 0x0046, TryCatch #0 {Exception -> 0x0046, blocks: (B:11:0x0041, B:18:0x0054, B:20:0x005a, B:22:0x0066, B:25:0x007d, B:28:0x0095, B:30:0x00a3, B:32:0x00d1, B:35:0x0147, B:37:0x0155, B:39:0x0172, B:41:0x017b, B:44:0x019c, B:46:0x01aa, B:48:0x01c5, B:49:0x01e7, B:43:0x0183, B:50:0x021a, B:52:0x0228, B:54:0x0236, B:56:0x0264, B:57:0x028e, B:58:0x02c1, B:60:0x02cd, B:62:0x02dc, B:64:0x030b, B:66:0x0320, B:67:0x0335, B:69:0x0347, B:71:0x0371, B:72:0x0380, B:73:0x0396, B:74:0x03a9, B:33:0x010f), top: B:79:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02cd A[Catch: Exception -> 0x0046, TryCatch #0 {Exception -> 0x0046, blocks: (B:11:0x0041, B:18:0x0054, B:20:0x005a, B:22:0x0066, B:25:0x007d, B:28:0x0095, B:30:0x00a3, B:32:0x00d1, B:35:0x0147, B:37:0x0155, B:39:0x0172, B:41:0x017b, B:44:0x019c, B:46:0x01aa, B:48:0x01c5, B:49:0x01e7, B:43:0x0183, B:50:0x021a, B:52:0x0228, B:54:0x0236, B:56:0x0264, B:57:0x028e, B:58:0x02c1, B:60:0x02cd, B:62:0x02dc, B:64:0x030b, B:66:0x0320, B:67:0x0335, B:69:0x0347, B:71:0x0371, B:72:0x0380, B:73:0x0396, B:74:0x03a9, B:33:0x010f), top: B:79:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkandupdateversion(org.json.JSONObject r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instruction units count: 966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.viewmodel.FeedDetailViewModel.checkandupdateversion(org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.viewmodel.FeedDetailViewModel$checkandupdateversion$2, reason: invalid class name */
    /* JADX INFO: compiled from: FeedDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.viewmodel.FeedDetailViewModel$checkandupdateversion$2", f = "FeedDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSONObject $jsonObject;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(JSONObject jSONObject, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$jsonObject = jSONObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$jsonObject, continuation);
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
            RetrofitResponse.GetApiData(MakeMyExam.getAppContext(), this.$jsonObject.has("auth_code") ? this.$jsonObject.getString("auth_code") : "", this.$jsonObject.getString("message"), false);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
    }
}
