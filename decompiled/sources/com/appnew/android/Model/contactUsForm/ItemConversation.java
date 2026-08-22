package com.appnew.android.Model.contactUsForm;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemConversation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bh\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0091\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003JÕ\u0002\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u0003HÆ\u0001J\u0013\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010n\u001a\u00020oHÖ\u0001J\t\u0010p\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010'R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010'R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010'R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010'R\u0016\u0010\u001f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010'R\u0016\u0010 \u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010'R\u0016\u0010!\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010'R\u0016\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010'R\u0016\u0010#\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010'¨\u0006q"}, d2 = {"Lcom/appnew/android/Model/contactUsForm/ItemConversation;", "", "time", "", "actualAmount", "address", "agent", "agentStatus", "appId", "batch", "branch", "candidateType", "courseId", "courseType", "creationTime", "email", "file", "id", "lastUpdated", "message", Const.MOBILE, "name", "offeredAmount", "page", "prospect", "qualification", "queryReply", "receiptId", TypedValues.Custom.S_REFERENCE, "skypeId", "status", "type", "userId", "whatsappNumber", "reply", "reply_user_name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTime", "()Ljava/lang/String;", "getActualAmount", "getAddress", "getAgent", "getAgentStatus", "getAppId", "getBatch", "getBranch", "getCandidateType", "getCourseId", "getCourseType", "getCreationTime", "getEmail", "getFile", "getId", "getLastUpdated", "getMessage", "getMobile", "getName", "getOfferedAmount", "getPage", "getProspect", "getQualification", "getQueryReply", "()Ljava/lang/Object;", "getReceiptId", "getRefrence", "getSkypeId", "getStatus", "getType", "getUserId", "getWhatsappNumber", "getReply", "getReply_user_name", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ItemConversation {
    public static final int $stable = 8;

    @SerializedName("actual_amount")
    private final String actualAmount;

    @SerializedName("address")
    private final String address;

    @SerializedName("agent")
    private final String agent;

    @SerializedName("agent_status")
    private final String agentStatus;

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("batch")
    private final String batch;

    @SerializedName("branch")
    private final String branch;

    @SerializedName("candidate_type")
    private final String candidateType;

    @SerializedName("course_id")
    private final String courseId;

    @SerializedName(Const.COURSE_TYPE)
    private final String courseType;

    @SerializedName(Const.CREATION_TIME)
    private final String creationTime;

    @SerializedName("email")
    private final String email;

    @SerializedName("file")
    private final String file;

    @SerializedName("id")
    private final String id;

    @SerializedName("last_updated")
    private final String lastUpdated;

    @SerializedName("message")
    private final String message;

    @SerializedName(Const.MOBILE)
    private final String mobile;

    @SerializedName("name")
    private final String name;

    @SerializedName("offered_amount")
    private final String offeredAmount;

    @SerializedName("page")
    private final String page;

    @SerializedName("prospect")
    private final String prospect;

    @SerializedName("qualification")
    private final String qualification;

    @SerializedName("query_reply")
    private final Object queryReply;

    @SerializedName("receipt_id")
    private final String receiptId;

    @SerializedName(TypedValues.Custom.S_REFERENCE)
    private final String refrence;

    @SerializedName("reply")
    private final String reply;

    @SerializedName("reply_user_name")
    private final String reply_user_name;

    @SerializedName("skype_id")
    private final String skypeId;

    @SerializedName("status")
    private final String status;

    @SerializedName("time")
    private final String time;

    @SerializedName("type")
    private final String type;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("whatsapp_number")
    private final String whatsappNumber;

    public static /* synthetic */ ItemConversation copy$default(ItemConversation itemConversation, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, Object obj, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, int i, int i2, Object obj2) {
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        Object obj3;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        String str58;
        String str59;
        String str60;
        String str61;
        String str62;
        String str63;
        String str64 = (i & 1) != 0 ? itemConversation.time : str;
        String str65 = (i & 2) != 0 ? itemConversation.actualAmount : str2;
        String str66 = (i & 4) != 0 ? itemConversation.address : str3;
        String str67 = (i & 8) != 0 ? itemConversation.agent : str4;
        String str68 = (i & 16) != 0 ? itemConversation.agentStatus : str5;
        String str69 = (i & 32) != 0 ? itemConversation.appId : str6;
        String str70 = (i & 64) != 0 ? itemConversation.batch : str7;
        String str71 = (i & 128) != 0 ? itemConversation.branch : str8;
        String str72 = (i & 256) != 0 ? itemConversation.candidateType : str9;
        String str73 = (i & 512) != 0 ? itemConversation.courseId : str10;
        String str74 = (i & 1024) != 0 ? itemConversation.courseType : str11;
        String str75 = (i & 2048) != 0 ? itemConversation.creationTime : str12;
        String str76 = (i & 4096) != 0 ? itemConversation.email : str13;
        String str77 = (i & 8192) != 0 ? itemConversation.file : str14;
        String str78 = str64;
        String str79 = (i & 16384) != 0 ? itemConversation.id : str15;
        String str80 = (i & 32768) != 0 ? itemConversation.lastUpdated : str16;
        String str81 = (i & 65536) != 0 ? itemConversation.message : str17;
        String str82 = (i & 131072) != 0 ? itemConversation.mobile : str18;
        String str83 = (i & 262144) != 0 ? itemConversation.name : str19;
        String str84 = (i & 524288) != 0 ? itemConversation.offeredAmount : str20;
        String str85 = (i & 1048576) != 0 ? itemConversation.page : str21;
        String str86 = (i & 2097152) != 0 ? itemConversation.prospect : str22;
        String str87 = (i & 4194304) != 0 ? itemConversation.qualification : str23;
        Object obj4 = (i & 8388608) != 0 ? itemConversation.queryReply : obj;
        String str88 = (i & 16777216) != 0 ? itemConversation.receiptId : str24;
        String str89 = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? itemConversation.refrence : str25;
        String str90 = (i & 67108864) != 0 ? itemConversation.skypeId : str26;
        String str91 = (i & 134217728) != 0 ? itemConversation.status : str27;
        String str92 = (i & 268435456) != 0 ? itemConversation.type : str28;
        String str93 = (i & 536870912) != 0 ? itemConversation.userId : str29;
        String str94 = (i & 1073741824) != 0 ? itemConversation.whatsappNumber : str30;
        String str95 = (i & Integer.MIN_VALUE) != 0 ? itemConversation.reply : str31;
        if ((i2 & 1) != 0) {
            str34 = str95;
            str33 = itemConversation.reply_user_name;
            str36 = str82;
            str37 = str83;
            str38 = str84;
            str39 = str85;
            str40 = str86;
            str41 = str87;
            obj3 = obj4;
            str42 = str88;
            str43 = str89;
            str44 = str90;
            str45 = str91;
            str46 = str92;
            str47 = str93;
            str48 = str94;
            str49 = str79;
            str51 = str66;
            str52 = str67;
            str53 = str68;
            str54 = str69;
            str55 = str70;
            str56 = str71;
            str57 = str72;
            str58 = str73;
            str59 = str74;
            str60 = str75;
            str61 = str76;
            str62 = str77;
            str63 = str80;
            str35 = str81;
            str50 = str65;
        } else {
            str33 = str32;
            str34 = str95;
            str35 = str81;
            str36 = str82;
            str37 = str83;
            str38 = str84;
            str39 = str85;
            str40 = str86;
            str41 = str87;
            obj3 = obj4;
            str42 = str88;
            str43 = str89;
            str44 = str90;
            str45 = str91;
            str46 = str92;
            str47 = str93;
            str48 = str94;
            str49 = str79;
            str50 = str65;
            str51 = str66;
            str52 = str67;
            str53 = str68;
            str54 = str69;
            str55 = str70;
            str56 = str71;
            str57 = str72;
            str58 = str73;
            str59 = str74;
            str60 = str75;
            str61 = str76;
            str62 = str77;
            str63 = str80;
        }
        return itemConversation.copy(str78, str50, str51, str52, str53, str54, str55, str56, str57, str58, str59, str60, str61, str62, str49, str63, str35, str36, str37, str38, str39, str40, str41, obj3, str42, str43, str44, str45, str46, str47, str48, str34, str33);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCourseId() {
        return this.courseId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCourseType() {
        return this.courseType;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCreationTime() {
        return this.creationTime;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getLastUpdated() {
        return this.lastUpdated;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getMobile() {
        return this.mobile;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActualAmount() {
        return this.actualAmount;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getOfferedAmount() {
        return this.offeredAmount;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getProspect() {
        return this.prospect;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getQualification() {
        return this.qualification;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Object getQueryReply() {
        return this.queryReply;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getReceiptId() {
        return this.receiptId;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getRefrence() {
        return this.refrence;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getSkypeId() {
        return this.skypeId;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getWhatsappNumber() {
        return this.whatsappNumber;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getReply() {
        return this.reply;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getReply_user_name() {
        return this.reply_user_name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAgentStatus() {
        return this.agentStatus;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBranch() {
        return this.branch;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCandidateType() {
        return this.candidateType;
    }

    public final ItemConversation copy(String time, String actualAmount, String address, String agent, String agentStatus, String appId, String batch, String branch, String candidateType, String courseId, String courseType, String creationTime, String email, String file, String id, String lastUpdated, String message, String mobile, String name, String offeredAmount, String page, String prospect, String qualification, Object queryReply, String receiptId, String refrence, String skypeId, String status, String type, String userId, String whatsappNumber, String reply, String reply_user_name) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(actualAmount, "actualAmount");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(agentStatus, "agentStatus");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(branch, "branch");
        Intrinsics.checkNotNullParameter(candidateType, "candidateType");
        Intrinsics.checkNotNullParameter(courseId, "courseId");
        Intrinsics.checkNotNullParameter(courseType, "courseType");
        Intrinsics.checkNotNullParameter(creationTime, "creationTime");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lastUpdated, "lastUpdated");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(offeredAmount, "offeredAmount");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(prospect, "prospect");
        Intrinsics.checkNotNullParameter(qualification, "qualification");
        Intrinsics.checkNotNullParameter(receiptId, "receiptId");
        Intrinsics.checkNotNullParameter(refrence, "refrence");
        Intrinsics.checkNotNullParameter(skypeId, "skypeId");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(whatsappNumber, "whatsappNumber");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(reply_user_name, "reply_user_name");
        return new ItemConversation(time, actualAmount, address, agent, agentStatus, appId, batch, branch, candidateType, courseId, courseType, creationTime, email, file, id, lastUpdated, message, mobile, name, offeredAmount, page, prospect, qualification, queryReply, receiptId, refrence, skypeId, status, type, userId, whatsappNumber, reply, reply_user_name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemConversation)) {
            return false;
        }
        ItemConversation itemConversation = (ItemConversation) other;
        return Intrinsics.areEqual(this.time, itemConversation.time) && Intrinsics.areEqual(this.actualAmount, itemConversation.actualAmount) && Intrinsics.areEqual(this.address, itemConversation.address) && Intrinsics.areEqual(this.agent, itemConversation.agent) && Intrinsics.areEqual(this.agentStatus, itemConversation.agentStatus) && Intrinsics.areEqual(this.appId, itemConversation.appId) && Intrinsics.areEqual(this.batch, itemConversation.batch) && Intrinsics.areEqual(this.branch, itemConversation.branch) && Intrinsics.areEqual(this.candidateType, itemConversation.candidateType) && Intrinsics.areEqual(this.courseId, itemConversation.courseId) && Intrinsics.areEqual(this.courseType, itemConversation.courseType) && Intrinsics.areEqual(this.creationTime, itemConversation.creationTime) && Intrinsics.areEqual(this.email, itemConversation.email) && Intrinsics.areEqual(this.file, itemConversation.file) && Intrinsics.areEqual(this.id, itemConversation.id) && Intrinsics.areEqual(this.lastUpdated, itemConversation.lastUpdated) && Intrinsics.areEqual(this.message, itemConversation.message) && Intrinsics.areEqual(this.mobile, itemConversation.mobile) && Intrinsics.areEqual(this.name, itemConversation.name) && Intrinsics.areEqual(this.offeredAmount, itemConversation.offeredAmount) && Intrinsics.areEqual(this.page, itemConversation.page) && Intrinsics.areEqual(this.prospect, itemConversation.prospect) && Intrinsics.areEqual(this.qualification, itemConversation.qualification) && Intrinsics.areEqual(this.queryReply, itemConversation.queryReply) && Intrinsics.areEqual(this.receiptId, itemConversation.receiptId) && Intrinsics.areEqual(this.refrence, itemConversation.refrence) && Intrinsics.areEqual(this.skypeId, itemConversation.skypeId) && Intrinsics.areEqual(this.status, itemConversation.status) && Intrinsics.areEqual(this.type, itemConversation.type) && Intrinsics.areEqual(this.userId, itemConversation.userId) && Intrinsics.areEqual(this.whatsappNumber, itemConversation.whatsappNumber) && Intrinsics.areEqual(this.reply, itemConversation.reply) && Intrinsics.areEqual(this.reply_user_name, itemConversation.reply_user_name);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((this.time.hashCode() * 31) + this.actualAmount.hashCode()) * 31) + this.address.hashCode()) * 31) + this.agent.hashCode()) * 31) + this.agentStatus.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.batch.hashCode()) * 31) + this.branch.hashCode()) * 31) + this.candidateType.hashCode()) * 31) + this.courseId.hashCode()) * 31) + this.courseType.hashCode()) * 31) + this.creationTime.hashCode()) * 31) + this.email.hashCode()) * 31) + this.file.hashCode()) * 31) + this.id.hashCode()) * 31) + this.lastUpdated.hashCode()) * 31) + this.message.hashCode()) * 31) + this.mobile.hashCode()) * 31) + this.name.hashCode()) * 31) + this.offeredAmount.hashCode()) * 31) + this.page.hashCode()) * 31) + this.prospect.hashCode()) * 31) + this.qualification.hashCode()) * 31;
        Object obj = this.queryReply;
        return ((((((((((((((((((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.receiptId.hashCode()) * 31) + this.refrence.hashCode()) * 31) + this.skypeId.hashCode()) * 31) + this.status.hashCode()) * 31) + this.type.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.whatsappNumber.hashCode()) * 31) + this.reply.hashCode()) * 31) + this.reply_user_name.hashCode();
    }

    public String toString() {
        return "ItemConversation(time=" + this.time + ", actualAmount=" + this.actualAmount + ", address=" + this.address + ", agent=" + this.agent + ", agentStatus=" + this.agentStatus + ", appId=" + this.appId + ", batch=" + this.batch + ", branch=" + this.branch + ", candidateType=" + this.candidateType + ", courseId=" + this.courseId + ", courseType=" + this.courseType + ", creationTime=" + this.creationTime + ", email=" + this.email + ", file=" + this.file + ", id=" + this.id + ", lastUpdated=" + this.lastUpdated + ", message=" + this.message + ", mobile=" + this.mobile + ", name=" + this.name + ", offeredAmount=" + this.offeredAmount + ", page=" + this.page + ", prospect=" + this.prospect + ", qualification=" + this.qualification + ", queryReply=" + this.queryReply + ", receiptId=" + this.receiptId + ", refrence=" + this.refrence + ", skypeId=" + this.skypeId + ", status=" + this.status + ", type=" + this.type + ", userId=" + this.userId + ", whatsappNumber=" + this.whatsappNumber + ", reply=" + this.reply + ", reply_user_name=" + this.reply_user_name + ")";
    }

    public ItemConversation(String time, String actualAmount, String address, String agent, String agentStatus, String appId, String batch, String branch, String candidateType, String courseId, String courseType, String creationTime, String email, String file, String id, String lastUpdated, String message, String mobile, String name, String offeredAmount, String page, String prospect, String qualification, Object obj, String receiptId, String refrence, String skypeId, String status, String type, String userId, String whatsappNumber, String reply, String reply_user_name) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(actualAmount, "actualAmount");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(agentStatus, "agentStatus");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(branch, "branch");
        Intrinsics.checkNotNullParameter(candidateType, "candidateType");
        Intrinsics.checkNotNullParameter(courseId, "courseId");
        Intrinsics.checkNotNullParameter(courseType, "courseType");
        Intrinsics.checkNotNullParameter(creationTime, "creationTime");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lastUpdated, "lastUpdated");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(offeredAmount, "offeredAmount");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(prospect, "prospect");
        Intrinsics.checkNotNullParameter(qualification, "qualification");
        Intrinsics.checkNotNullParameter(receiptId, "receiptId");
        Intrinsics.checkNotNullParameter(refrence, "refrence");
        Intrinsics.checkNotNullParameter(skypeId, "skypeId");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(whatsappNumber, "whatsappNumber");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(reply_user_name, "reply_user_name");
        this.time = time;
        this.actualAmount = actualAmount;
        this.address = address;
        this.agent = agent;
        this.agentStatus = agentStatus;
        this.appId = appId;
        this.batch = batch;
        this.branch = branch;
        this.candidateType = candidateType;
        this.courseId = courseId;
        this.courseType = courseType;
        this.creationTime = creationTime;
        this.email = email;
        this.file = file;
        this.id = id;
        this.lastUpdated = lastUpdated;
        this.message = message;
        this.mobile = mobile;
        this.name = name;
        this.offeredAmount = offeredAmount;
        this.page = page;
        this.prospect = prospect;
        this.qualification = qualification;
        this.queryReply = obj;
        this.receiptId = receiptId;
        this.refrence = refrence;
        this.skypeId = skypeId;
        this.status = status;
        this.type = type;
        this.userId = userId;
        this.whatsappNumber = whatsappNumber;
        this.reply = reply;
        this.reply_user_name = reply_user_name;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getActualAmount() {
        return this.actualAmount;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAgent() {
        return this.agent;
    }

    public final String getAgentStatus() {
        return this.agentStatus;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBatch() {
        return this.batch;
    }

    public final String getBranch() {
        return this.branch;
    }

    public final String getCandidateType() {
        return this.candidateType;
    }

    public final String getCourseId() {
        return this.courseId;
    }

    public final String getCourseType() {
        return this.courseType;
    }

    public final String getCreationTime() {
        return this.creationTime;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFile() {
        return this.file;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLastUpdated() {
        return this.lastUpdated;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOfferedAmount() {
        return this.offeredAmount;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getProspect() {
        return this.prospect;
    }

    public final String getQualification() {
        return this.qualification;
    }

    public final Object getQueryReply() {
        return this.queryReply;
    }

    public final String getReceiptId() {
        return this.receiptId;
    }

    public final String getRefrence() {
        return this.refrence;
    }

    public final String getSkypeId() {
        return this.skypeId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getWhatsappNumber() {
        return this.whatsappNumber;
    }

    public final String getReply() {
        return this.reply;
    }

    public final String getReply_user_name() {
        return this.reply_user_name;
    }
}
