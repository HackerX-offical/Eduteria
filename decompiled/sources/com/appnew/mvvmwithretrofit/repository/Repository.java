package com.appnew.mvvmwithretrofit.repository;

import com.appnew.android.Utils.Network.APIInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

/* JADX INFO: compiled from: Repository.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fJ \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/appnew/mvvmwithretrofit/repository/Repository;", "", "apiInterface", "Lcom/appnew/android/Utils/Network/APIInterface;", "<init>", "(Lcom/appnew/android/Utils/Network/APIInterface;)V", "getApiInterface", "()Lcom/appnew/android/Utils/Network/APIInterface;", "getFeedApidata", "Lretrofit2/Response;", "", "bodydata", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostdata", "getLiveClassApidata", "getLiveTestApidata", "getChangeDetector", "getpostLike", "getCommentList", "addComment", "attempt_mcq", "pinPost", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Repository {
    public static final int $stable = 8;
    private final APIInterface apiInterface;

    public Repository(APIInterface apiInterface) {
        Intrinsics.checkNotNullParameter(apiInterface, "apiInterface");
        this.apiInterface = apiInterface;
    }

    public final APIInterface getApiInterface() {
        return this.apiInterface;
    }

    public final Object getFeedApidata(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.getPost(str, continuation);
    }

    public final Object getPostdata(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.get_post_detail(str, continuation);
    }

    public final Object getLiveClassApidata(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.getLiveClass(str, continuation);
    }

    public final Object getLiveTestApidata(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.getLiveTest(str, continuation);
    }

    public final Object getChangeDetector(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.getChangedetectot(str, continuation);
    }

    public final Object getpostLike(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.courutine_like_unlike_post(str, continuation);
    }

    public final Object getCommentList(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.courutine_get_feed_comments(str, continuation);
    }

    public final Object addComment(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.courutine_add_comments(str, continuation);
    }

    public final Object attempt_mcq(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.courutine_attempt_mcq(str, continuation);
    }

    public final Object pinPost(String str, Continuation<? super Response<String>> continuation) {
        return this.apiInterface.courutinePinPost(str, continuation);
    }
}
