package com.appnew.android.socket.models;

import com.appnew.android.Model.chatPojo;
import com.appnew.android.Utils.StoreProvider;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/appnew/android/socket/models/GroupMessage;", "", "id", "", StoreProvider.StoreData.CREATED_DATE, FirebaseAnalytics.Param.GROUP_ID, "message", "Lcom/appnew/android/Model/chatPojo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/appnew/android/Model/chatPojo;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getCreated", "setCreated", "getGroup_id", "setGroup_id", "getMessage", "()Lcom/appnew/android/Model/chatPojo;", "setMessage", "(Lcom/appnew/android/Model/chatPojo;)V", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class GroupMessage {
    public static final int $stable = 8;
    private String created;
    private String group_id;
    private String id;
    private chatPojo message;

    public GroupMessage() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GroupMessage copy$default(GroupMessage groupMessage, String str, String str2, String str3, chatPojo chatpojo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupMessage.id;
        }
        if ((i & 2) != 0) {
            str2 = groupMessage.created;
        }
        if ((i & 4) != 0) {
            str3 = groupMessage.group_id;
        }
        if ((i & 8) != 0) {
            chatpojo = groupMessage.message;
        }
        return groupMessage.copy(str, str2, str3, chatpojo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGroup_id() {
        return this.group_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final chatPojo getMessage() {
        return this.message;
    }

    public final GroupMessage copy(String id, String created, String group_id, chatPojo message) {
        return new GroupMessage(id, created, group_id, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMessage)) {
            return false;
        }
        GroupMessage groupMessage = (GroupMessage) other;
        return Intrinsics.areEqual(this.id, groupMessage.id) && Intrinsics.areEqual(this.created, groupMessage.created) && Intrinsics.areEqual(this.group_id, groupMessage.group_id) && Intrinsics.areEqual(this.message, groupMessage.message);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.created;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.group_id;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        chatPojo chatpojo = this.message;
        return iHashCode3 + (chatpojo != null ? chatpojo.hashCode() : 0);
    }

    public String toString() {
        return "GroupMessage(id=" + this.id + ", created=" + this.created + ", group_id=" + this.group_id + ", message=" + this.message + ")";
    }

    public GroupMessage(String str, String str2, String str3, chatPojo chatpojo) {
        this.id = str;
        this.created = str2;
        this.group_id = str3;
        this.message = chatpojo;
    }

    public /* synthetic */ GroupMessage(String str, String str2, String str3, chatPojo chatpojo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : chatpojo);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getCreated() {
        return this.created;
    }

    public final void setCreated(String str) {
        this.created = str;
    }

    public final String getGroup_id() {
        return this.group_id;
    }

    public final void setGroup_id(String str) {
        this.group_id = str;
    }

    public final chatPojo getMessage() {
        return this.message;
    }

    public final void setMessage(chatPojo chatpojo) {
        this.message = chatpojo;
    }
}
