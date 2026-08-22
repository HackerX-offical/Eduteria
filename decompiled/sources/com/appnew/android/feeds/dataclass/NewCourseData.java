package com.appnew.android.feeds.dataclass;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewCourseData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/appnew/android/feeds/dataclass/NewCourseData;", "", "course_sp", "", "cover_image", "id", "lang_id", "mrp", Const.SUBJECT_ID, "title", "validity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCourse_sp", "()Ljava/lang/String;", "getCover_image", "getId", "getLang_id", "getMrp", "getSubject_id", "getTitle", "getValidity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class NewCourseData {
    public static final int $stable = 0;
    private final String course_sp;
    private final String cover_image;
    private final String id;
    private final String lang_id;
    private final String mrp;
    private final String subject_id;
    private final String title;
    private final String validity;

    public static /* synthetic */ NewCourseData copy$default(NewCourseData newCourseData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newCourseData.course_sp;
        }
        if ((i & 2) != 0) {
            str2 = newCourseData.cover_image;
        }
        if ((i & 4) != 0) {
            str3 = newCourseData.id;
        }
        if ((i & 8) != 0) {
            str4 = newCourseData.lang_id;
        }
        if ((i & 16) != 0) {
            str5 = newCourseData.mrp;
        }
        if ((i & 32) != 0) {
            str6 = newCourseData.subject_id;
        }
        if ((i & 64) != 0) {
            str7 = newCourseData.title;
        }
        if ((i & 128) != 0) {
            str8 = newCourseData.validity;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return newCourseData.copy(str, str2, str3, str4, str11, str12, str9, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCourse_sp() {
        return this.course_sp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCover_image() {
        return this.cover_image;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLang_id() {
        return this.lang_id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMrp() {
        return this.mrp;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSubject_id() {
        return this.subject_id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getValidity() {
        return this.validity;
    }

    public final NewCourseData copy(String course_sp, String cover_image, String id, String lang_id, String mrp, String subject_id, String title, String validity) {
        Intrinsics.checkNotNullParameter(course_sp, "course_sp");
        Intrinsics.checkNotNullParameter(cover_image, "cover_image");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lang_id, "lang_id");
        Intrinsics.checkNotNullParameter(mrp, "mrp");
        Intrinsics.checkNotNullParameter(subject_id, "subject_id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(validity, "validity");
        return new NewCourseData(course_sp, cover_image, id, lang_id, mrp, subject_id, title, validity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewCourseData)) {
            return false;
        }
        NewCourseData newCourseData = (NewCourseData) other;
        return Intrinsics.areEqual(this.course_sp, newCourseData.course_sp) && Intrinsics.areEqual(this.cover_image, newCourseData.cover_image) && Intrinsics.areEqual(this.id, newCourseData.id) && Intrinsics.areEqual(this.lang_id, newCourseData.lang_id) && Intrinsics.areEqual(this.mrp, newCourseData.mrp) && Intrinsics.areEqual(this.subject_id, newCourseData.subject_id) && Intrinsics.areEqual(this.title, newCourseData.title) && Intrinsics.areEqual(this.validity, newCourseData.validity);
    }

    public int hashCode() {
        return (((((((((((((this.course_sp.hashCode() * 31) + this.cover_image.hashCode()) * 31) + this.id.hashCode()) * 31) + this.lang_id.hashCode()) * 31) + this.mrp.hashCode()) * 31) + this.subject_id.hashCode()) * 31) + this.title.hashCode()) * 31) + this.validity.hashCode();
    }

    public String toString() {
        return "NewCourseData(course_sp=" + this.course_sp + ", cover_image=" + this.cover_image + ", id=" + this.id + ", lang_id=" + this.lang_id + ", mrp=" + this.mrp + ", subject_id=" + this.subject_id + ", title=" + this.title + ", validity=" + this.validity + ")";
    }

    public NewCourseData(String course_sp, String cover_image, String id, String lang_id, String mrp, String subject_id, String title, String validity) {
        Intrinsics.checkNotNullParameter(course_sp, "course_sp");
        Intrinsics.checkNotNullParameter(cover_image, "cover_image");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(lang_id, "lang_id");
        Intrinsics.checkNotNullParameter(mrp, "mrp");
        Intrinsics.checkNotNullParameter(subject_id, "subject_id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(validity, "validity");
        this.course_sp = course_sp;
        this.cover_image = cover_image;
        this.id = id;
        this.lang_id = lang_id;
        this.mrp = mrp;
        this.subject_id = subject_id;
        this.title = title;
        this.validity = validity;
    }

    public final String getCourse_sp() {
        return this.course_sp;
    }

    public final String getCover_image() {
        return this.cover_image;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLang_id() {
        return this.lang_id;
    }

    public final String getMrp() {
        return this.mrp;
    }

    public final String getSubject_id() {
        return this.subject_id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getValidity() {
        return this.validity;
    }
}
