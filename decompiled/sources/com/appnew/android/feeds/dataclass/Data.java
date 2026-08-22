package com.appnew.android.feeds.dataclass;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.appnew.android.home.livetest.LiveTestData;
import com.clevertap.android.sdk.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bV\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0019\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u0005\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0005\u0012\b\b\u0002\u0010-\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00105\"\u0004\b?\u00107R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00105\"\u0004\bA\u00107R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00105\"\u0004\bE\u00107R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00105\"\u0004\bG\u00107R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00105\"\u0004\bI\u00107R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00105\"\u0004\bK\u00107R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00105\"\u0004\bM\u00107R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00105\"\u0004\bQ\u00107R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00105\"\u0004\bS\u00107R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00105\"\u0004\bU\u00107R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00105\"\u0004\bW\u00107R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00105\"\u0004\bY\u00107R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00105\"\u0004\b[\u00107R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010]\"\u0004\ba\u0010_R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010]\"\u0004\bc\u0010_R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010]\"\u0004\be\u0010_R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010]\"\u0004\bg\u0010_R\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u00105\"\u0004\bh\u00107R\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00105\"\u0004\bj\u00107R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00105\"\u0004\bp\u00107R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u00105\"\u0004\br\u00107R\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00105\"\u0004\bt\u00107R\u001a\u0010*\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u00105\"\u0004\bv\u00107R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u00105\"\u0004\bx\u00107R\u001a\u0010,\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u00105\"\u0004\bz\u00107R\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u00105\"\u0004\b{\u00107¨\u0006|"}, d2 = {"Lcom/appnew/android/feeds/dataclass/Data;", "", "expanded", "", StoreProvider.StoreData.CREATED_DATE, "", "id", "json", "Lcom/appnew/android/feeds/dataclass/Json;", "meta_url", Const.LINK_TYPE, "thumbnail", "url", StoreProvider.StoreData.MODIFIED_DATE, "my_like", "name", Const.POST_TYPE, Const.PROFILE_PICTURE, "status", "sub_cat_id", "text", "total_comments", "total_likes", "user_id", "newCourseData", "", "Lcom/appnew/android/feeds/dataclass/NewCourseData;", "livetest", "Lcom/appnew/android/home/livetest/LiveTestData;", "liveclass", "Lcom/appnew/android/feeds/dataclass/Datum;", "testResult", "Lcom/appnew/android/feeds/dataclass/TestResult;", "bannerlist", "Lcom/appnew/android/feeds/dataclass/BannerData;", "is_comment_enable", "section_posiiton", Constants.KEY_LIMIT, "", "my_pinned", "description", "master_cat_id", Const.CAT_ID, Const.SUB_CAT, "schedule_date", "is_youtube_short", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/appnew/android/feeds/dataclass/Json;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExpanded", "()Z", "setExpanded", "(Z)V", "getCreated", "()Ljava/lang/String;", "setCreated", "(Ljava/lang/String;)V", "getId", "setId", "getJson", "()Lcom/appnew/android/feeds/dataclass/Json;", "setJson", "(Lcom/appnew/android/feeds/dataclass/Json;)V", "getMeta_url", "setMeta_url", "getLink_type", "setLink_type", "getThumbnail", "setThumbnail", "getUrl", "setUrl", "getModified", "setModified", "getMy_like", "setMy_like", "getName", "setName", "getPost_type", "setPost_type", "getProfile_picture", "setProfile_picture", "getStatus", "setStatus", "getSub_cat_id", "setSub_cat_id", "getText", "setText", "getTotal_comments", "setTotal_comments", "getTotal_likes", "setTotal_likes", "getUser_id", "setUser_id", "getNewCourseData", "()Ljava/util/List;", "setNewCourseData", "(Ljava/util/List;)V", "getLivetest", "setLivetest", "getLiveclass", "setLiveclass", "getTestResult", "setTestResult", "getBannerlist", "setBannerlist", "set_comment_enable", "getSection_posiiton", "setSection_posiiton", "getLimit", "()I", "setLimit", "(I)V", "getMy_pinned", "setMy_pinned", "getDescription", "setDescription", "getMaster_cat_id", "setMaster_cat_id", "getMain_cat", "setMain_cat", "getSub_cat", "setSub_cat", "getSchedule_date", "setSchedule_date", "set_youtube_short", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Data {
    public static final int $stable = 8;
    private List<BannerData> bannerlist;
    private String created;
    private String description;
    private boolean expanded;
    private String id;
    private String is_comment_enable;
    private String is_youtube_short;
    private Json json;
    private int limit;
    private String link_type;
    private List<? extends Datum> liveclass;
    private List<? extends LiveTestData> livetest;
    private String main_cat;
    private String master_cat_id;
    private String meta_url;
    private String modified;
    private String my_like;
    private String my_pinned;
    private String name;
    private List<NewCourseData> newCourseData;
    private String post_type;
    private String profile_picture;
    private String schedule_date;
    private String section_posiiton;
    private String status;
    private String sub_cat;
    private String sub_cat_id;
    private List<TestResult> testResult;
    private String text;
    private String thumbnail;
    private String total_comments;
    private String total_likes;
    private String url;
    private String user_id;

    public Data(boolean z, String created, String id, Json json, String meta_url, String link_type, String thumbnail, String str, String modified, String my_like, String str2, String post_type, String str3, String status, String sub_cat_id, String text, String total_comments, String total_likes, String user_id, List<NewCourseData> list, List<? extends LiveTestData> list2, List<? extends Datum> list3, List<TestResult> list4, List<BannerData> list5, String is_comment_enable, String section_posiiton, int i, String my_pinned, String description, String master_cat_id, String main_cat, String sub_cat, String schedule_date, String is_youtube_short) {
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(meta_url, "meta_url");
        Intrinsics.checkNotNullParameter(link_type, "link_type");
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        Intrinsics.checkNotNullParameter(modified, "modified");
        Intrinsics.checkNotNullParameter(my_like, "my_like");
        Intrinsics.checkNotNullParameter(post_type, "post_type");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(sub_cat_id, "sub_cat_id");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(total_comments, "total_comments");
        Intrinsics.checkNotNullParameter(total_likes, "total_likes");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        Intrinsics.checkNotNullParameter(is_comment_enable, "is_comment_enable");
        Intrinsics.checkNotNullParameter(section_posiiton, "section_posiiton");
        Intrinsics.checkNotNullParameter(my_pinned, "my_pinned");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(master_cat_id, "master_cat_id");
        Intrinsics.checkNotNullParameter(main_cat, "main_cat");
        Intrinsics.checkNotNullParameter(sub_cat, "sub_cat");
        Intrinsics.checkNotNullParameter(schedule_date, "schedule_date");
        Intrinsics.checkNotNullParameter(is_youtube_short, "is_youtube_short");
        this.expanded = z;
        this.created = created;
        this.id = id;
        this.json = json;
        this.meta_url = meta_url;
        this.link_type = link_type;
        this.thumbnail = thumbnail;
        this.url = str;
        this.modified = modified;
        this.my_like = my_like;
        this.name = str2;
        this.post_type = post_type;
        this.profile_picture = str3;
        this.status = status;
        this.sub_cat_id = sub_cat_id;
        this.text = text;
        this.total_comments = total_comments;
        this.total_likes = total_likes;
        this.user_id = user_id;
        this.newCourseData = list;
        this.livetest = list2;
        this.liveclass = list3;
        this.testResult = list4;
        this.bannerlist = list5;
        this.is_comment_enable = is_comment_enable;
        this.section_posiiton = section_posiiton;
        this.limit = i;
        this.my_pinned = my_pinned;
        this.description = description;
        this.master_cat_id = master_cat_id;
        this.main_cat = main_cat;
        this.sub_cat = sub_cat;
        this.schedule_date = schedule_date;
        this.is_youtube_short = is_youtube_short;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Data(boolean r39, java.lang.String r40, java.lang.String r41, com.appnew.android.feeds.dataclass.Json r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, java.util.List r58, java.util.List r59, java.util.List r60, java.util.List r61, java.util.List r62, java.lang.String r63, java.lang.String r64, int r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.lang.String r70, java.lang.String r71, java.lang.String r72, int r73, int r74, kotlin.jvm.internal.DefaultConstructorMarker r75) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.dataclass.Data.<init>(boolean, java.lang.String, java.lang.String, com.appnew.android.feeds.dataclass.Json, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final void setExpanded(boolean z) {
        this.expanded = z;
    }

    public final String getCreated() {
        return this.created;
    }

    public final void setCreated(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.created = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final Json getJson() {
        return this.json;
    }

    public final void setJson(Json json) {
        Intrinsics.checkNotNullParameter(json, "<set-?>");
        this.json = json;
    }

    public final String getMeta_url() {
        return this.meta_url;
    }

    public final void setMeta_url(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.meta_url = str;
    }

    public final String getLink_type() {
        return this.link_type;
    }

    public final void setLink_type(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link_type = str;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thumbnail = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getModified() {
        return this.modified;
    }

    public final void setModified(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modified = str;
    }

    public final String getMy_like() {
        return this.my_like;
    }

    public final void setMy_like(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.my_like = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getPost_type() {
        return this.post_type;
    }

    public final void setPost_type(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.post_type = str;
    }

    public final String getProfile_picture() {
        return this.profile_picture;
    }

    public final void setProfile_picture(String str) {
        this.profile_picture = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final String getSub_cat_id() {
        return this.sub_cat_id;
    }

    public final void setSub_cat_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sub_cat_id = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final String getTotal_comments() {
        return this.total_comments;
    }

    public final void setTotal_comments(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.total_comments = str;
    }

    public final String getTotal_likes() {
        return this.total_likes;
    }

    public final void setTotal_likes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.total_likes = str;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final void setUser_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.user_id = str;
    }

    public final List<NewCourseData> getNewCourseData() {
        return this.newCourseData;
    }

    public final void setNewCourseData(List<NewCourseData> list) {
        this.newCourseData = list;
    }

    public final List<LiveTestData> getLivetest() {
        return this.livetest;
    }

    public final void setLivetest(List<? extends LiveTestData> list) {
        this.livetest = list;
    }

    public final List<Datum> getLiveclass() {
        return this.liveclass;
    }

    public final void setLiveclass(List<? extends Datum> list) {
        this.liveclass = list;
    }

    public final List<TestResult> getTestResult() {
        return this.testResult;
    }

    public final void setTestResult(List<TestResult> list) {
        this.testResult = list;
    }

    public final List<BannerData> getBannerlist() {
        return this.bannerlist;
    }

    public final void setBannerlist(List<BannerData> list) {
        this.bannerlist = list;
    }

    /* JADX INFO: renamed from: is_comment_enable, reason: from getter */
    public final String getIs_comment_enable() {
        return this.is_comment_enable;
    }

    public final void set_comment_enable(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.is_comment_enable = str;
    }

    public final String getSection_posiiton() {
        return this.section_posiiton;
    }

    public final void setSection_posiiton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.section_posiiton = str;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    public final String getMy_pinned() {
        return this.my_pinned;
    }

    public final void setMy_pinned(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.my_pinned = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final String getMaster_cat_id() {
        return this.master_cat_id;
    }

    public final void setMaster_cat_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.master_cat_id = str;
    }

    public final String getMain_cat() {
        return this.main_cat;
    }

    public final void setMain_cat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.main_cat = str;
    }

    public final String getSub_cat() {
        return this.sub_cat;
    }

    public final void setSub_cat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sub_cat = str;
    }

    public final String getSchedule_date() {
        return this.schedule_date;
    }

    public final void setSchedule_date(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schedule_date = str;
    }

    /* JADX INFO: renamed from: is_youtube_short, reason: from getter */
    public final String getIs_youtube_short() {
        return this.is_youtube_short;
    }

    public final void set_youtube_short(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.is_youtube_short = str;
    }
}
