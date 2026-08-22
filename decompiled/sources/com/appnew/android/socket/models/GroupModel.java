package com.appnew.android.socket.models;

import com.appnew.android.Utils.StoreProvider;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u00106\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011HÆ\u0003J«\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0015\"\u0004\b \u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0015\"\u0004\b!\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0015\"\u0004\b$\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006>"}, d2 = {"Lcom/appnew/android/socket/models/GroupModel;", "", "id", "", "app_id", "course_id", StoreProvider.StoreData.CREATED_DATE, "group_name", "is_active", "is_attachment", "is_audio", "is_history_enable", "is_send_message", StoreProvider.StoreData.MODIFIED_DATE, "GroupMessage", "Ljava/util/ArrayList;", "Lcom/appnew/android/socket/models/GroupMessage;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getApp_id", "setApp_id", "getCourse_id", "setCourse_id", "getCreated", "setCreated", "getGroup_name", "setGroup_name", "set_active", "set_attachment", "set_audio", "set_history_enable", "set_send_message", "getModified", "setModified", "getGroupMessage", "()Ljava/util/ArrayList;", "setGroupMessage", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class GroupModel {
    public static final int $stable = 8;
    private ArrayList<GroupMessage> GroupMessage;
    private String app_id;
    private String course_id;
    private String created;
    private String group_name;
    private String id;
    private String is_active;
    private String is_attachment;
    private String is_audio;
    private String is_history_enable;
    private String is_send_message;
    private String modified;

    public GroupModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupModel copy$default(GroupModel groupModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupModel.id;
        }
        if ((i & 2) != 0) {
            str2 = groupModel.app_id;
        }
        if ((i & 4) != 0) {
            str3 = groupModel.course_id;
        }
        if ((i & 8) != 0) {
            str4 = groupModel.created;
        }
        if ((i & 16) != 0) {
            str5 = groupModel.group_name;
        }
        if ((i & 32) != 0) {
            str6 = groupModel.is_active;
        }
        if ((i & 64) != 0) {
            str7 = groupModel.is_attachment;
        }
        if ((i & 128) != 0) {
            str8 = groupModel.is_audio;
        }
        if ((i & 256) != 0) {
            str9 = groupModel.is_history_enable;
        }
        if ((i & 512) != 0) {
            str10 = groupModel.is_send_message;
        }
        if ((i & 1024) != 0) {
            str11 = groupModel.modified;
        }
        if ((i & 2048) != 0) {
            arrayList = groupModel.GroupMessage;
        }
        String str12 = str11;
        ArrayList arrayList2 = arrayList;
        String str13 = str9;
        String str14 = str10;
        String str15 = str7;
        String str16 = str8;
        String str17 = str5;
        String str18 = str6;
        return groupModel.copy(str, str2, str3, str4, str17, str18, str15, str16, str13, str14, str12, arrayList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getIs_send_message() {
        return this.is_send_message;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getModified() {
        return this.modified;
    }

    public final ArrayList<GroupMessage> component12() {
        return this.GroupMessage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getApp_id() {
        return this.app_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCourse_id() {
        return this.course_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGroup_name() {
        return this.group_name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getIs_active() {
        return this.is_active;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIs_attachment() {
        return this.is_attachment;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getIs_audio() {
        return this.is_audio;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getIs_history_enable() {
        return this.is_history_enable;
    }

    public final GroupModel copy(String id, String app_id, String course_id, String created, String group_name, String is_active, String is_attachment, String is_audio, String is_history_enable, String is_send_message, String modified, ArrayList<GroupMessage> GroupMessage) {
        return new GroupModel(id, app_id, course_id, created, group_name, is_active, is_attachment, is_audio, is_history_enable, is_send_message, modified, GroupMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupModel)) {
            return false;
        }
        GroupModel groupModel = (GroupModel) other;
        return Intrinsics.areEqual(this.id, groupModel.id) && Intrinsics.areEqual(this.app_id, groupModel.app_id) && Intrinsics.areEqual(this.course_id, groupModel.course_id) && Intrinsics.areEqual(this.created, groupModel.created) && Intrinsics.areEqual(this.group_name, groupModel.group_name) && Intrinsics.areEqual(this.is_active, groupModel.is_active) && Intrinsics.areEqual(this.is_attachment, groupModel.is_attachment) && Intrinsics.areEqual(this.is_audio, groupModel.is_audio) && Intrinsics.areEqual(this.is_history_enable, groupModel.is_history_enable) && Intrinsics.areEqual(this.is_send_message, groupModel.is_send_message) && Intrinsics.areEqual(this.modified, groupModel.modified) && Intrinsics.areEqual(this.GroupMessage, groupModel.GroupMessage);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.app_id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.course_id;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.created;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.group_name;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.is_active;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.is_attachment;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.is_audio;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.is_history_enable;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.is_send_message;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.modified;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        ArrayList<GroupMessage> arrayList = this.GroupMessage;
        return iHashCode11 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public String toString() {
        return "GroupModel(id=" + this.id + ", app_id=" + this.app_id + ", course_id=" + this.course_id + ", created=" + this.created + ", group_name=" + this.group_name + ", is_active=" + this.is_active + ", is_attachment=" + this.is_attachment + ", is_audio=" + this.is_audio + ", is_history_enable=" + this.is_history_enable + ", is_send_message=" + this.is_send_message + ", modified=" + this.modified + ", GroupMessage=" + this.GroupMessage + ")";
    }

    public GroupModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ArrayList<GroupMessage> arrayList) {
        this.id = str;
        this.app_id = str2;
        this.course_id = str3;
        this.created = str4;
        this.group_name = str5;
        this.is_active = str6;
        this.is_attachment = str7;
        this.is_audio = str8;
        this.is_history_enable = str9;
        this.is_send_message = str10;
        this.modified = str11;
        this.GroupMessage = arrayList;
    }

    public /* synthetic */ GroupModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : arrayList);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getApp_id() {
        return this.app_id;
    }

    public final void setApp_id(String str) {
        this.app_id = str;
    }

    public final String getCourse_id() {
        return this.course_id;
    }

    public final void setCourse_id(String str) {
        this.course_id = str;
    }

    public final String getCreated() {
        return this.created;
    }

    public final void setCreated(String str) {
        this.created = str;
    }

    public final String getGroup_name() {
        return this.group_name;
    }

    public final void setGroup_name(String str) {
        this.group_name = str;
    }

    public final String is_active() {
        return this.is_active;
    }

    public final void set_active(String str) {
        this.is_active = str;
    }

    public final String is_attachment() {
        return this.is_attachment;
    }

    public final void set_attachment(String str) {
        this.is_attachment = str;
    }

    public final String is_audio() {
        return this.is_audio;
    }

    public final void set_audio(String str) {
        this.is_audio = str;
    }

    public final String is_history_enable() {
        return this.is_history_enable;
    }

    public final void set_history_enable(String str) {
        this.is_history_enable = str;
    }

    public final String is_send_message() {
        return this.is_send_message;
    }

    public final void set_send_message(String str) {
        this.is_send_message = str;
    }

    public final String getModified() {
        return this.modified;
    }

    public final void setModified(String str) {
        this.modified = str;
    }

    public final ArrayList<GroupMessage> getGroupMessage() {
        return this.GroupMessage;
    }

    public final void setGroupMessage(ArrayList<GroupMessage> arrayList) {
        this.GroupMessage = arrayList;
    }
}
