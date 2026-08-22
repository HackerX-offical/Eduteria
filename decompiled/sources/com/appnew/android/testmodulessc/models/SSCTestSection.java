package com.appnew.android.testmodulessc.models;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSCTestSection.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0013HÆ\u0003JÇ\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020\u0013HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010#R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006B"}, d2 = {"Lcom/appnew/android/testmodulessc/models/SSCTestSection;", "Ljava/io/Serializable;", "id", "", "sectionId", "sectionPart", "sectionTiming", "sectionAliase", "name", "name2", "marksPerQuestion", "isPartialMarking", "negativeMarks", "sectionCutoff", "timeRemain", "totalNoOfAttempts", "totalNoOfAttemptsBySectionType", "noOfQuestions", "indexOf", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getSectionId", "getSectionPart", "getSectionTiming", "getSectionAliase", "getName", "getName2", "getMarksPerQuestion", "getNegativeMarks", "getSectionCutoff", "getTimeRemain", "setTimeRemain", "(Ljava/lang/String;)V", "getTotalNoOfAttempts", "getTotalNoOfAttemptsBySectionType", "getNoOfQuestions", "getIndexOf", "()I", "setIndexOf", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SSCTestSection implements Serializable {
    public static final int $stable = 8;

    @SerializedName("id")
    @Expose
    private final String id;
    private int indexOf;

    @SerializedName("is_partial_marking")
    @Expose
    private final String isPartialMarking;

    @SerializedName("marks_per_question")
    @Expose
    private final String marksPerQuestion;

    @SerializedName("name")
    @Expose
    private final String name;

    @SerializedName("name_2")
    @Expose
    private final String name2;

    @SerializedName("negative_marks")
    @Expose
    private final String negativeMarks;

    @SerializedName("no_of_questions")
    @Expose
    private final String noOfQuestions;

    @SerializedName("section_aliase")
    @Expose
    private final String sectionAliase;

    @SerializedName("section_cutoff")
    @Expose
    private final String sectionCutoff;

    @SerializedName("section_id")
    @Expose
    private final String sectionId;

    @SerializedName("section_part")
    @Expose
    private final String sectionPart;

    @SerializedName("section_timing")
    @Expose
    private final String sectionTiming;

    @SerializedName(Const.TIME_REMAIN)
    @Expose
    private String timeRemain;

    @SerializedName("total_no_of_attempts")
    @Expose
    private final String totalNoOfAttempts;

    @SerializedName("total_no_of_attempts_by_section_type")
    @Expose
    private final String totalNoOfAttemptsBySectionType;

    public SSCTestSection() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 65535, null);
    }

    public static /* synthetic */ SSCTestSection copy$default(SSCTestSection sSCTestSection, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, int i2, Object obj) {
        String str16 = (i2 & 1) != 0 ? sSCTestSection.id : str;
        return sSCTestSection.copy(str16, (i2 & 2) != 0 ? sSCTestSection.sectionId : str2, (i2 & 4) != 0 ? sSCTestSection.sectionPart : str3, (i2 & 8) != 0 ? sSCTestSection.sectionTiming : str4, (i2 & 16) != 0 ? sSCTestSection.sectionAliase : str5, (i2 & 32) != 0 ? sSCTestSection.name : str6, (i2 & 64) != 0 ? sSCTestSection.name2 : str7, (i2 & 128) != 0 ? sSCTestSection.marksPerQuestion : str8, (i2 & 256) != 0 ? sSCTestSection.isPartialMarking : str9, (i2 & 512) != 0 ? sSCTestSection.negativeMarks : str10, (i2 & 1024) != 0 ? sSCTestSection.sectionCutoff : str11, (i2 & 2048) != 0 ? sSCTestSection.timeRemain : str12, (i2 & 4096) != 0 ? sSCTestSection.totalNoOfAttempts : str13, (i2 & 8192) != 0 ? sSCTestSection.totalNoOfAttemptsBySectionType : str14, (i2 & 16384) != 0 ? sSCTestSection.noOfQuestions : str15, (i2 & 32768) != 0 ? sSCTestSection.indexOf : i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getNegativeMarks() {
        return this.negativeMarks;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSectionCutoff() {
        return this.sectionCutoff;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTimeRemain() {
        return this.timeRemain;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getTotalNoOfAttempts() {
        return this.totalNoOfAttempts;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getTotalNoOfAttemptsBySectionType() {
        return this.totalNoOfAttemptsBySectionType;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getNoOfQuestions() {
        return this.noOfQuestions;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getIndexOf() {
        return this.indexOf;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSectionId() {
        return this.sectionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSectionPart() {
        return this.sectionPart;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSectionTiming() {
        return this.sectionTiming;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSectionAliase() {
        return this.sectionAliase;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getName2() {
        return this.name2;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMarksPerQuestion() {
        return this.marksPerQuestion;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getIsPartialMarking() {
        return this.isPartialMarking;
    }

    public final SSCTestSection copy(String id, String sectionId, String sectionPart, String sectionTiming, String sectionAliase, String name, String name2, String marksPerQuestion, String isPartialMarking, String negativeMarks, String sectionCutoff, String timeRemain, String totalNoOfAttempts, String totalNoOfAttemptsBySectionType, String noOfQuestions, int indexOf) {
        return new SSCTestSection(id, sectionId, sectionPart, sectionTiming, sectionAliase, name, name2, marksPerQuestion, isPartialMarking, negativeMarks, sectionCutoff, timeRemain, totalNoOfAttempts, totalNoOfAttemptsBySectionType, noOfQuestions, indexOf);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SSCTestSection)) {
            return false;
        }
        SSCTestSection sSCTestSection = (SSCTestSection) other;
        return Intrinsics.areEqual(this.id, sSCTestSection.id) && Intrinsics.areEqual(this.sectionId, sSCTestSection.sectionId) && Intrinsics.areEqual(this.sectionPart, sSCTestSection.sectionPart) && Intrinsics.areEqual(this.sectionTiming, sSCTestSection.sectionTiming) && Intrinsics.areEqual(this.sectionAliase, sSCTestSection.sectionAliase) && Intrinsics.areEqual(this.name, sSCTestSection.name) && Intrinsics.areEqual(this.name2, sSCTestSection.name2) && Intrinsics.areEqual(this.marksPerQuestion, sSCTestSection.marksPerQuestion) && Intrinsics.areEqual(this.isPartialMarking, sSCTestSection.isPartialMarking) && Intrinsics.areEqual(this.negativeMarks, sSCTestSection.negativeMarks) && Intrinsics.areEqual(this.sectionCutoff, sSCTestSection.sectionCutoff) && Intrinsics.areEqual(this.timeRemain, sSCTestSection.timeRemain) && Intrinsics.areEqual(this.totalNoOfAttempts, sSCTestSection.totalNoOfAttempts) && Intrinsics.areEqual(this.totalNoOfAttemptsBySectionType, sSCTestSection.totalNoOfAttemptsBySectionType) && Intrinsics.areEqual(this.noOfQuestions, sSCTestSection.noOfQuestions) && this.indexOf == sSCTestSection.indexOf;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sectionId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sectionPart;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sectionTiming;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sectionAliase;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.name;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.name2;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.marksPerQuestion;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.isPartialMarking;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.negativeMarks;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.sectionCutoff;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.timeRemain;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.totalNoOfAttempts;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.totalNoOfAttemptsBySectionType;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.noOfQuestions;
        return ((iHashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31) + Integer.hashCode(this.indexOf);
    }

    public String toString() {
        return "SSCTestSection(id=" + this.id + ", sectionId=" + this.sectionId + ", sectionPart=" + this.sectionPart + ", sectionTiming=" + this.sectionTiming + ", sectionAliase=" + this.sectionAliase + ", name=" + this.name + ", name2=" + this.name2 + ", marksPerQuestion=" + this.marksPerQuestion + ", isPartialMarking=" + this.isPartialMarking + ", negativeMarks=" + this.negativeMarks + ", sectionCutoff=" + this.sectionCutoff + ", timeRemain=" + this.timeRemain + ", totalNoOfAttempts=" + this.totalNoOfAttempts + ", totalNoOfAttemptsBySectionType=" + this.totalNoOfAttemptsBySectionType + ", noOfQuestions=" + this.noOfQuestions + ", indexOf=" + this.indexOf + ")";
    }

    public SSCTestSection(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i) {
        this.id = str;
        this.sectionId = str2;
        this.sectionPart = str3;
        this.sectionTiming = str4;
        this.sectionAliase = str5;
        this.name = str6;
        this.name2 = str7;
        this.marksPerQuestion = str8;
        this.isPartialMarking = str9;
        this.negativeMarks = str10;
        this.sectionCutoff = str11;
        this.timeRemain = str12;
        this.totalNoOfAttempts = str13;
        this.totalNoOfAttemptsBySectionType = str14;
        this.noOfQuestions = str15;
        this.indexOf = i;
    }

    public /* synthetic */ SSCTestSection(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : str8, (i2 & 256) != 0 ? null : str9, (i2 & 512) != 0 ? null : str10, (i2 & 1024) != 0 ? null : str11, (i2 & 2048) != 0 ? null : str12, (i2 & 4096) != 0 ? null : str13, (i2 & 8192) != 0 ? null : str14, (i2 & 16384) != 0 ? null : str15, (i2 & 32768) != 0 ? -1 : i);
    }

    public final String getId() {
        return this.id;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSectionPart() {
        return this.sectionPart;
    }

    public final String getSectionTiming() {
        return this.sectionTiming;
    }

    public final String getSectionAliase() {
        return this.sectionAliase;
    }

    public final String getName() {
        return this.name;
    }

    public final String getName2() {
        return this.name2;
    }

    public final String getMarksPerQuestion() {
        return this.marksPerQuestion;
    }

    public final String isPartialMarking() {
        return this.isPartialMarking;
    }

    public final String getNegativeMarks() {
        return this.negativeMarks;
    }

    public final String getSectionCutoff() {
        return this.sectionCutoff;
    }

    public final String getTimeRemain() {
        return this.timeRemain;
    }

    public final void setTimeRemain(String str) {
        this.timeRemain = str;
    }

    public final String getTotalNoOfAttempts() {
        return this.totalNoOfAttempts;
    }

    public final String getTotalNoOfAttemptsBySectionType() {
        return this.totalNoOfAttemptsBySectionType;
    }

    public final String getNoOfQuestions() {
        return this.noOfQuestions;
    }

    public final int getIndexOf() {
        return this.indexOf;
    }

    public final void setIndexOf(int i) {
        this.indexOf = i;
    }
}
