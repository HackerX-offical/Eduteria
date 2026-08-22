package com.appnew.android.testmodulessc.models;

import com.appnew.android.testmodule.model.Question;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSCQuestion.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0014HÆ\u0003J£\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010=\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010(\"\u0004\b)\u0010*R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006B"}, d2 = {"Lcom/appnew/android/testmodulessc/models/SSCQuestion;", "", "id", "", "sectionId", "subjectId", "sectionName", "questionHtml", "questionType", "fontType", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "Lcom/appnew/android/testmodulessc/models/SSCTestOption;", "paragraphText", "posMarks", "negMarks", "isMultiPG", "", "sectionType", "original", "Lcom/appnew/android/testmodule/model/Question;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/appnew/android/testmodule/model/Question;)V", "getId", "()Ljava/lang/String;", "getSectionId", "getSubjectId", "getSectionName", "getQuestionHtml", "setQuestionHtml", "(Ljava/lang/String;)V", "getQuestionType", "getFontType", "getOptions", "()Ljava/util/List;", "setOptions", "(Ljava/util/List;)V", "getParagraphText", "getPosMarks", "getNegMarks", "()Z", "setMultiPG", "(Z)V", "getSectionType", "getOriginal", "()Lcom/appnew/android/testmodule/model/Question;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SSCQuestion {
    public static final int $stable = 8;
    private final String fontType;
    private final String id;
    private boolean isMultiPG;
    private final String negMarks;
    private List<SSCTestOption> options;
    private final Question original;
    private final String paragraphText;
    private final String posMarks;
    private String questionHtml;
    private final String questionType;
    private final String sectionId;
    private final String sectionName;
    private final String sectionType;
    private final String subjectId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPosMarks() {
        return this.posMarks;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getNegMarks() {
        return this.negMarks;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsMultiPG() {
        return this.isMultiPG;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSectionType() {
        return this.sectionType;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Question getOriginal() {
        return this.original;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSectionId() {
        return this.sectionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSectionName() {
        return this.sectionName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getQuestionHtml() {
        return this.questionHtml;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getQuestionType() {
        return this.questionType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFontType() {
        return this.fontType;
    }

    public final List<SSCTestOption> component8() {
        return this.options;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getParagraphText() {
        return this.paragraphText;
    }

    public final SSCQuestion copy(String id, String sectionId, String subjectId, String sectionName, String questionHtml, String questionType, String fontType, List<SSCTestOption> options, String paragraphText, String posMarks, String negMarks, boolean isMultiPG, String sectionType, Question original) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sectionId, "sectionId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Intrinsics.checkNotNullParameter(questionHtml, "questionHtml");
        Intrinsics.checkNotNullParameter(questionType, "questionType");
        Intrinsics.checkNotNullParameter(fontType, "fontType");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(original, "original");
        return new SSCQuestion(id, sectionId, subjectId, sectionName, questionHtml, questionType, fontType, options, paragraphText, posMarks, negMarks, isMultiPG, sectionType, original);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SSCQuestion)) {
            return false;
        }
        SSCQuestion sSCQuestion = (SSCQuestion) other;
        return Intrinsics.areEqual(this.id, sSCQuestion.id) && Intrinsics.areEqual(this.sectionId, sSCQuestion.sectionId) && Intrinsics.areEqual(this.subjectId, sSCQuestion.subjectId) && Intrinsics.areEqual(this.sectionName, sSCQuestion.sectionName) && Intrinsics.areEqual(this.questionHtml, sSCQuestion.questionHtml) && Intrinsics.areEqual(this.questionType, sSCQuestion.questionType) && Intrinsics.areEqual(this.fontType, sSCQuestion.fontType) && Intrinsics.areEqual(this.options, sSCQuestion.options) && Intrinsics.areEqual(this.paragraphText, sSCQuestion.paragraphText) && Intrinsics.areEqual(this.posMarks, sSCQuestion.posMarks) && Intrinsics.areEqual(this.negMarks, sSCQuestion.negMarks) && this.isMultiPG == sSCQuestion.isMultiPG && Intrinsics.areEqual(this.sectionType, sSCQuestion.sectionType) && Intrinsics.areEqual(this.original, sSCQuestion.original);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.id.hashCode() * 31) + this.sectionId.hashCode()) * 31) + this.subjectId.hashCode()) * 31) + this.sectionName.hashCode()) * 31) + this.questionHtml.hashCode()) * 31) + this.questionType.hashCode()) * 31) + this.fontType.hashCode()) * 31) + this.options.hashCode()) * 31;
        String str = this.paragraphText;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.posMarks;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.negMarks;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.isMultiPG)) * 31;
        String str4 = this.sectionType;
        return ((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.original.hashCode();
    }

    public String toString() {
        return "SSCQuestion(id=" + this.id + ", sectionId=" + this.sectionId + ", subjectId=" + this.subjectId + ", sectionName=" + this.sectionName + ", questionHtml=" + this.questionHtml + ", questionType=" + this.questionType + ", fontType=" + this.fontType + ", options=" + this.options + ", paragraphText=" + this.paragraphText + ", posMarks=" + this.posMarks + ", negMarks=" + this.negMarks + ", isMultiPG=" + this.isMultiPG + ", sectionType=" + this.sectionType + ", original=" + this.original + ")";
    }

    public SSCQuestion(String id, String sectionId, String subjectId, String sectionName, String questionHtml, String questionType, String fontType, List<SSCTestOption> options, String str, String str2, String str3, boolean z, String str4, Question original) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sectionId, "sectionId");
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Intrinsics.checkNotNullParameter(questionHtml, "questionHtml");
        Intrinsics.checkNotNullParameter(questionType, "questionType");
        Intrinsics.checkNotNullParameter(fontType, "fontType");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(original, "original");
        this.id = id;
        this.sectionId = sectionId;
        this.subjectId = subjectId;
        this.sectionName = sectionName;
        this.questionHtml = questionHtml;
        this.questionType = questionType;
        this.fontType = fontType;
        this.options = options;
        this.paragraphText = str;
        this.posMarks = str2;
        this.negMarks = str3;
        this.isMultiPG = z;
        this.sectionType = str4;
        this.original = original;
    }

    public /* synthetic */ SSCQuestion(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, String str8, String str9, String str10, boolean z, String str11, Question question, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, list, str8, str9, str10, (i & 2048) != 0 ? false : z, str11, question);
    }

    public final String getId() {
        return this.id;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSectionName() {
        return this.sectionName;
    }

    public final String getQuestionHtml() {
        return this.questionHtml;
    }

    public final void setQuestionHtml(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.questionHtml = str;
    }

    public final String getQuestionType() {
        return this.questionType;
    }

    public final String getFontType() {
        return this.fontType;
    }

    public final List<SSCTestOption> getOptions() {
        return this.options;
    }

    public final void setOptions(List<SSCTestOption> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.options = list;
    }

    public final String getParagraphText() {
        return this.paragraphText;
    }

    public final String getPosMarks() {
        return this.posMarks;
    }

    public final String getNegMarks() {
        return this.negMarks;
    }

    public final boolean isMultiPG() {
        return this.isMultiPG;
    }

    public final void setMultiPG(boolean z) {
        this.isMultiPG = z;
    }

    public final String getSectionType() {
        return this.sectionType;
    }

    public final Question getOriginal() {
        return this.original;
    }
}
