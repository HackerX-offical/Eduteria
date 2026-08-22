package com.appnew.android.sme;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.db.Column;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StudentDoubtListModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010#\u001a\u00020\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u009f\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u0006:"}, d2 = {"Lcom/appnew/android/sme/Doubt;", "", "appId", "", "chatNode", "createdAt", "doubtAudio", "doubtImage", "doubtMessage", "id", "isComplete", "status", "subjectId", "subjectName", "topicId", "userId", "pageNo", "QuestionNo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getChatNode", "getCreatedAt", "getDoubtAudio", "getDoubtImage", "getDoubtMessage", "getId", "getStatus", "getSubjectId", "getSubjectName", "getTopicId", "getUserId", "getPageNo", "getQuestionNo", "getDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Doubt {
    public static final int $stable = 0;

    @SerializedName("question_no")
    private final String QuestionNo;

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("chat_node")
    private final String chatNode;

    @SerializedName(Column.CREATED_AT)
    private final String createdAt;

    @SerializedName("doubt_audio")
    private final String doubtAudio;

    @SerializedName("doubt_image")
    private final String doubtImage;

    @SerializedName("doubt_message")
    private final String doubtMessage;

    @SerializedName("id")
    private final String id;

    @SerializedName("is_complete")
    private final String isComplete;

    @SerializedName("page_no")
    private final String pageNo;

    @SerializedName("status")
    private final String status;

    @SerializedName(Const.SUBJECT_ID)
    private final String subjectId;

    @SerializedName("subject_name")
    private final String subjectName;

    @SerializedName(Const.TOPIC_ID)
    private final String topicId;

    @SerializedName("user_id")
    private final String userId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTopicId() {
        return this.topicId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getPageNo() {
        return this.pageNo;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getQuestionNo() {
        return this.QuestionNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChatNode() {
        return this.chatNode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDoubtAudio() {
        return this.doubtAudio;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDoubtImage() {
        return this.doubtImage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDoubtMessage() {
        return this.doubtMessage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getIsComplete() {
        return this.isComplete;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final Doubt copy(String appId, String chatNode, String createdAt, String doubtAudio, String doubtImage, String doubtMessage, String id, String isComplete, String status, String subjectId, String subjectName, String topicId, String userId, String pageNo, String QuestionNo) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(chatNode, "chatNode");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(doubtAudio, "doubtAudio");
        Intrinsics.checkNotNullParameter(doubtImage, "doubtImage");
        Intrinsics.checkNotNullParameter(doubtMessage, "doubtMessage");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(isComplete, "isComplete");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(pageNo, "pageNo");
        Intrinsics.checkNotNullParameter(QuestionNo, "QuestionNo");
        return new Doubt(appId, chatNode, createdAt, doubtAudio, doubtImage, doubtMessage, id, isComplete, status, subjectId, subjectName, topicId, userId, pageNo, QuestionNo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Doubt)) {
            return false;
        }
        Doubt doubt = (Doubt) other;
        return Intrinsics.areEqual(this.appId, doubt.appId) && Intrinsics.areEqual(this.chatNode, doubt.chatNode) && Intrinsics.areEqual(this.createdAt, doubt.createdAt) && Intrinsics.areEqual(this.doubtAudio, doubt.doubtAudio) && Intrinsics.areEqual(this.doubtImage, doubt.doubtImage) && Intrinsics.areEqual(this.doubtMessage, doubt.doubtMessage) && Intrinsics.areEqual(this.id, doubt.id) && Intrinsics.areEqual(this.isComplete, doubt.isComplete) && Intrinsics.areEqual(this.status, doubt.status) && Intrinsics.areEqual(this.subjectId, doubt.subjectId) && Intrinsics.areEqual(this.subjectName, doubt.subjectName) && Intrinsics.areEqual(this.topicId, doubt.topicId) && Intrinsics.areEqual(this.userId, doubt.userId) && Intrinsics.areEqual(this.pageNo, doubt.pageNo) && Intrinsics.areEqual(this.QuestionNo, doubt.QuestionNo);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.appId.hashCode() * 31) + this.chatNode.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.doubtAudio.hashCode()) * 31) + this.doubtImage.hashCode()) * 31) + this.doubtMessage.hashCode()) * 31) + this.id.hashCode()) * 31) + this.isComplete.hashCode()) * 31) + this.status.hashCode()) * 31) + this.subjectId.hashCode()) * 31) + this.subjectName.hashCode()) * 31) + this.topicId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.pageNo.hashCode()) * 31) + this.QuestionNo.hashCode();
    }

    public String toString() {
        return "Doubt(appId=" + this.appId + ", chatNode=" + this.chatNode + ", createdAt=" + this.createdAt + ", doubtAudio=" + this.doubtAudio + ", doubtImage=" + this.doubtImage + ", doubtMessage=" + this.doubtMessage + ", id=" + this.id + ", isComplete=" + this.isComplete + ", status=" + this.status + ", subjectId=" + this.subjectId + ", subjectName=" + this.subjectName + ", topicId=" + this.topicId + ", userId=" + this.userId + ", pageNo=" + this.pageNo + ", QuestionNo=" + this.QuestionNo + ")";
    }

    public Doubt(String appId, String chatNode, String createdAt, String doubtAudio, String doubtImage, String doubtMessage, String id, String isComplete, String status, String subjectId, String subjectName, String topicId, String userId, String pageNo, String QuestionNo) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(chatNode, "chatNode");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(doubtAudio, "doubtAudio");
        Intrinsics.checkNotNullParameter(doubtImage, "doubtImage");
        Intrinsics.checkNotNullParameter(doubtMessage, "doubtMessage");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(isComplete, "isComplete");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(pageNo, "pageNo");
        Intrinsics.checkNotNullParameter(QuestionNo, "QuestionNo");
        this.appId = appId;
        this.chatNode = chatNode;
        this.createdAt = createdAt;
        this.doubtAudio = doubtAudio;
        this.doubtImage = doubtImage;
        this.doubtMessage = doubtMessage;
        this.id = id;
        this.isComplete = isComplete;
        this.status = status;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.topicId = topicId;
        this.userId = userId;
        this.pageNo = pageNo;
        this.QuestionNo = QuestionNo;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getChatNode() {
        return this.chatNode;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getDoubtAudio() {
        return this.doubtAudio;
    }

    public final String getDoubtImage() {
        return this.doubtImage;
    }

    public final String getDoubtMessage() {
        return this.doubtMessage;
    }

    public final String getId() {
        return this.id;
    }

    public final String isComplete() {
        return this.isComplete;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getPageNo() {
        return this.pageNo;
    }

    public final String getQuestionNo() {
        return this.QuestionNo;
    }

    public final String getDate() {
        String dateTime = Helper.getDateTime(Long.parseLong(this.createdAt));
        Intrinsics.checkNotNullExpressionValue(dateTime, "getDateTime(...)");
        return dateTime;
    }
}
