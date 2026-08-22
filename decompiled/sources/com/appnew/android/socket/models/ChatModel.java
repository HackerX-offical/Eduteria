package com.appnew.android.socket.models;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChatModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0003Jo\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/appnew/android/socket/models/ChatModel;", "Ljava/io/Serializable;", FirebaseAnalytics.Param.GROUP_ID, "", "group_name", "is_send_message", "is_out_app", "is_teacher", "socket_url", "group_member", "Ljava/util/ArrayList;", "Lcom/appnew/android/socket/models/ChatMembers;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getGroup_id", "()Ljava/lang/String;", "setGroup_id", "(Ljava/lang/String;)V", "getGroup_name", "setGroup_name", "set_send_message", "set_out_app", "set_teacher", "getSocket_url", "setSocket_url", "getGroup_member", "()Ljava/util/ArrayList;", "setGroup_member", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ChatModel implements Serializable {
    public static final int $stable = 8;
    private String group_id;
    private ArrayList<ChatMembers> group_member;
    private String group_name;
    private String is_out_app;
    private String is_send_message;
    private String is_teacher;
    private String socket_url;

    public ChatModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatModel copy$default(ChatModel chatModel, String str, String str2, String str3, String str4, String str5, String str6, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatModel.group_id;
        }
        if ((i & 2) != 0) {
            str2 = chatModel.group_name;
        }
        if ((i & 4) != 0) {
            str3 = chatModel.is_send_message;
        }
        if ((i & 8) != 0) {
            str4 = chatModel.is_out_app;
        }
        if ((i & 16) != 0) {
            str5 = chatModel.is_teacher;
        }
        if ((i & 32) != 0) {
            str6 = chatModel.socket_url;
        }
        if ((i & 64) != 0) {
            arrayList = chatModel.group_member;
        }
        String str7 = str6;
        ArrayList arrayList2 = arrayList;
        String str8 = str5;
        String str9 = str3;
        return chatModel.copy(str, str2, str9, str4, str8, str7, arrayList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGroup_id() {
        return this.group_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGroup_name() {
        return this.group_name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIs_send_message() {
        return this.is_send_message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIs_out_app() {
        return this.is_out_app;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getIs_teacher() {
        return this.is_teacher;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSocket_url() {
        return this.socket_url;
    }

    public final ArrayList<ChatMembers> component7() {
        return this.group_member;
    }

    public final ChatModel copy(String group_id, String group_name, String is_send_message, String is_out_app, String is_teacher, String socket_url, ArrayList<ChatMembers> group_member) {
        return new ChatModel(group_id, group_name, is_send_message, is_out_app, is_teacher, socket_url, group_member);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatModel)) {
            return false;
        }
        ChatModel chatModel = (ChatModel) other;
        return Intrinsics.areEqual(this.group_id, chatModel.group_id) && Intrinsics.areEqual(this.group_name, chatModel.group_name) && Intrinsics.areEqual(this.is_send_message, chatModel.is_send_message) && Intrinsics.areEqual(this.is_out_app, chatModel.is_out_app) && Intrinsics.areEqual(this.is_teacher, chatModel.is_teacher) && Intrinsics.areEqual(this.socket_url, chatModel.socket_url) && Intrinsics.areEqual(this.group_member, chatModel.group_member);
    }

    public int hashCode() {
        String str = this.group_id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.group_name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.is_send_message;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.is_out_app;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.is_teacher;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.socket_url;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ArrayList<ChatMembers> arrayList = this.group_member;
        return iHashCode6 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public String toString() {
        return "ChatModel(group_id=" + this.group_id + ", group_name=" + this.group_name + ", is_send_message=" + this.is_send_message + ", is_out_app=" + this.is_out_app + ", is_teacher=" + this.is_teacher + ", socket_url=" + this.socket_url + ", group_member=" + this.group_member + ")";
    }

    public ChatModel(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<ChatMembers> arrayList) {
        this.group_id = str;
        this.group_name = str2;
        this.is_send_message = str3;
        this.is_out_app = str4;
        this.is_teacher = str5;
        this.socket_url = str6;
        this.group_member = arrayList;
    }

    public /* synthetic */ ChatModel(String str, String str2, String str3, String str4, String str5, String str6, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : arrayList);
    }

    public final String getGroup_id() {
        return this.group_id;
    }

    public final void setGroup_id(String str) {
        this.group_id = str;
    }

    public final String getGroup_name() {
        return this.group_name;
    }

    public final void setGroup_name(String str) {
        this.group_name = str;
    }

    public final String is_send_message() {
        return this.is_send_message;
    }

    public final void set_send_message(String str) {
        this.is_send_message = str;
    }

    public final String is_out_app() {
        return this.is_out_app;
    }

    public final void set_out_app(String str) {
        this.is_out_app = str;
    }

    public final String is_teacher() {
        return this.is_teacher;
    }

    public final void set_teacher(String str) {
        this.is_teacher = str;
    }

    public final String getSocket_url() {
        return this.socket_url;
    }

    public final void setSocket_url(String str) {
        this.socket_url = str;
    }

    public final ArrayList<ChatMembers> getGroup_member() {
        return this.group_member;
    }

    public final void setGroup_member(ArrayList<ChatMembers> arrayList) {
        this.group_member = arrayList;
    }
}
