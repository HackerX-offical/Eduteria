package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PollLocalResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/appnew/android/Model/PollLocalResult;", "", "videoId", "", "userId", "pollId", "type", "msgData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVideoId", "()Ljava/lang/String;", "getUserId", "getPollId", "getType", "getMsgData", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PollLocalResult {
    public static final int $stable = 0;
    private final String msgData;
    private final String pollId;
    private final String type;
    private final String userId;
    private final String videoId;

    public static /* synthetic */ PollLocalResult copy$default(PollLocalResult pollLocalResult, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pollLocalResult.videoId;
        }
        if ((i & 2) != 0) {
            str2 = pollLocalResult.userId;
        }
        if ((i & 4) != 0) {
            str3 = pollLocalResult.pollId;
        }
        if ((i & 8) != 0) {
            str4 = pollLocalResult.type;
        }
        if ((i & 16) != 0) {
            str5 = pollLocalResult.msgData;
        }
        String str6 = str5;
        String str7 = str3;
        return pollLocalResult.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPollId() {
        return this.pollId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMsgData() {
        return this.msgData;
    }

    public final PollLocalResult copy(String videoId, String userId, String pollId, String type, String msgData) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(pollId, "pollId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(msgData, "msgData");
        return new PollLocalResult(videoId, userId, pollId, type, msgData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PollLocalResult)) {
            return false;
        }
        PollLocalResult pollLocalResult = (PollLocalResult) other;
        return Intrinsics.areEqual(this.videoId, pollLocalResult.videoId) && Intrinsics.areEqual(this.userId, pollLocalResult.userId) && Intrinsics.areEqual(this.pollId, pollLocalResult.pollId) && Intrinsics.areEqual(this.type, pollLocalResult.type) && Intrinsics.areEqual(this.msgData, pollLocalResult.msgData);
    }

    public int hashCode() {
        return (((((((this.videoId.hashCode() * 31) + this.userId.hashCode()) * 31) + this.pollId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.msgData.hashCode();
    }

    public String toString() {
        return "PollLocalResult(videoId=" + this.videoId + ", userId=" + this.userId + ", pollId=" + this.pollId + ", type=" + this.type + ", msgData=" + this.msgData + ")";
    }

    public PollLocalResult(String videoId, String userId, String pollId, String type, String msgData) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(pollId, "pollId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(msgData, "msgData");
        this.videoId = videoId;
        this.userId = userId;
        this.pollId = pollId;
        this.type = type;
        this.msgData = msgData;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getPollId() {
        return this.pollId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getMsgData() {
        return this.msgData;
    }
}
