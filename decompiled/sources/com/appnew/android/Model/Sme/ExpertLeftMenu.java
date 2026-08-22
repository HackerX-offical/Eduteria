package com.appnew.android.Model.Sme;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmeModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/appnew/android/Model/Sme/ExpertLeftMenu;", "", Const.CONTACTUS, "", "facebook_link", "instagram_link", "linkedin_link", "logout", Const.REPORTS, "telegram_link", "twitter_link", "website", "youtube_link", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContactus", "()Ljava/lang/String;", "getFacebook_link", "getInstagram_link", "getLinkedin_link", "getLogout", "getReports", "getTelegram_link", "getTwitter_link", "getWebsite", "getYoutube_link", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ExpertLeftMenu {
    public static final int $stable = 0;
    private final String contactus;
    private final String facebook_link;
    private final String instagram_link;
    private final String linkedin_link;
    private final String logout;
    private final String reports;
    private final String telegram_link;
    private final String twitter_link;
    private final String website;
    private final String youtube_link;

    public static /* synthetic */ ExpertLeftMenu copy$default(ExpertLeftMenu expertLeftMenu, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = expertLeftMenu.contactus;
        }
        if ((i & 2) != 0) {
            str2 = expertLeftMenu.facebook_link;
        }
        if ((i & 4) != 0) {
            str3 = expertLeftMenu.instagram_link;
        }
        if ((i & 8) != 0) {
            str4 = expertLeftMenu.linkedin_link;
        }
        if ((i & 16) != 0) {
            str5 = expertLeftMenu.logout;
        }
        if ((i & 32) != 0) {
            str6 = expertLeftMenu.reports;
        }
        if ((i & 64) != 0) {
            str7 = expertLeftMenu.telegram_link;
        }
        if ((i & 128) != 0) {
            str8 = expertLeftMenu.twitter_link;
        }
        if ((i & 256) != 0) {
            str9 = expertLeftMenu.website;
        }
        if ((i & 512) != 0) {
            str10 = expertLeftMenu.youtube_link;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str7;
        String str14 = str8;
        String str15 = str5;
        String str16 = str6;
        return expertLeftMenu.copy(str, str2, str3, str4, str15, str16, str13, str14, str11, str12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContactus() {
        return this.contactus;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getYoutube_link() {
        return this.youtube_link;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFacebook_link() {
        return this.facebook_link;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInstagram_link() {
        return this.instagram_link;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLinkedin_link() {
        return this.linkedin_link;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogout() {
        return this.logout;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReports() {
        return this.reports;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTelegram_link() {
        return this.telegram_link;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTwitter_link() {
        return this.twitter_link;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getWebsite() {
        return this.website;
    }

    public final ExpertLeftMenu copy(String contactus, String facebook_link, String instagram_link, String linkedin_link, String logout, String reports, String telegram_link, String twitter_link, String website, String youtube_link) {
        Intrinsics.checkNotNullParameter(contactus, "contactus");
        Intrinsics.checkNotNullParameter(facebook_link, "facebook_link");
        Intrinsics.checkNotNullParameter(instagram_link, "instagram_link");
        Intrinsics.checkNotNullParameter(linkedin_link, "linkedin_link");
        Intrinsics.checkNotNullParameter(logout, "logout");
        Intrinsics.checkNotNullParameter(reports, "reports");
        Intrinsics.checkNotNullParameter(telegram_link, "telegram_link");
        Intrinsics.checkNotNullParameter(twitter_link, "twitter_link");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(youtube_link, "youtube_link");
        return new ExpertLeftMenu(contactus, facebook_link, instagram_link, linkedin_link, logout, reports, telegram_link, twitter_link, website, youtube_link);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpertLeftMenu)) {
            return false;
        }
        ExpertLeftMenu expertLeftMenu = (ExpertLeftMenu) other;
        return Intrinsics.areEqual(this.contactus, expertLeftMenu.contactus) && Intrinsics.areEqual(this.facebook_link, expertLeftMenu.facebook_link) && Intrinsics.areEqual(this.instagram_link, expertLeftMenu.instagram_link) && Intrinsics.areEqual(this.linkedin_link, expertLeftMenu.linkedin_link) && Intrinsics.areEqual(this.logout, expertLeftMenu.logout) && Intrinsics.areEqual(this.reports, expertLeftMenu.reports) && Intrinsics.areEqual(this.telegram_link, expertLeftMenu.telegram_link) && Intrinsics.areEqual(this.twitter_link, expertLeftMenu.twitter_link) && Intrinsics.areEqual(this.website, expertLeftMenu.website) && Intrinsics.areEqual(this.youtube_link, expertLeftMenu.youtube_link);
    }

    public int hashCode() {
        return (((((((((((((((((this.contactus.hashCode() * 31) + this.facebook_link.hashCode()) * 31) + this.instagram_link.hashCode()) * 31) + this.linkedin_link.hashCode()) * 31) + this.logout.hashCode()) * 31) + this.reports.hashCode()) * 31) + this.telegram_link.hashCode()) * 31) + this.twitter_link.hashCode()) * 31) + this.website.hashCode()) * 31) + this.youtube_link.hashCode();
    }

    public String toString() {
        return "ExpertLeftMenu(contactus=" + this.contactus + ", facebook_link=" + this.facebook_link + ", instagram_link=" + this.instagram_link + ", linkedin_link=" + this.linkedin_link + ", logout=" + this.logout + ", reports=" + this.reports + ", telegram_link=" + this.telegram_link + ", twitter_link=" + this.twitter_link + ", website=" + this.website + ", youtube_link=" + this.youtube_link + ")";
    }

    public ExpertLeftMenu(String contactus, String facebook_link, String instagram_link, String linkedin_link, String logout, String reports, String telegram_link, String twitter_link, String website, String youtube_link) {
        Intrinsics.checkNotNullParameter(contactus, "contactus");
        Intrinsics.checkNotNullParameter(facebook_link, "facebook_link");
        Intrinsics.checkNotNullParameter(instagram_link, "instagram_link");
        Intrinsics.checkNotNullParameter(linkedin_link, "linkedin_link");
        Intrinsics.checkNotNullParameter(logout, "logout");
        Intrinsics.checkNotNullParameter(reports, "reports");
        Intrinsics.checkNotNullParameter(telegram_link, "telegram_link");
        Intrinsics.checkNotNullParameter(twitter_link, "twitter_link");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(youtube_link, "youtube_link");
        this.contactus = contactus;
        this.facebook_link = facebook_link;
        this.instagram_link = instagram_link;
        this.linkedin_link = linkedin_link;
        this.logout = logout;
        this.reports = reports;
        this.telegram_link = telegram_link;
        this.twitter_link = twitter_link;
        this.website = website;
        this.youtube_link = youtube_link;
    }

    public final String getContactus() {
        return this.contactus;
    }

    public final String getFacebook_link() {
        return this.facebook_link;
    }

    public final String getInstagram_link() {
        return this.instagram_link;
    }

    public final String getLinkedin_link() {
        return this.linkedin_link;
    }

    public final String getLogout() {
        return this.logout;
    }

    public final String getReports() {
        return this.reports;
    }

    public final String getTelegram_link() {
        return this.telegram_link;
    }

    public final String getTwitter_link() {
        return this.twitter_link;
    }

    public final String getWebsite() {
        return this.website;
    }

    public final String getYoutube_link() {
        return this.youtube_link;
    }
}
