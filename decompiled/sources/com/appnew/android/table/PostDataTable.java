package com.appnew.android.table;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PostDataTable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\be\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001a\u00101\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\u001a\u00104\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001a\u00107\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001a\u0010:\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR\u001a\u0010=\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR\u001a\u0010@\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0007\"\u0004\bB\u0010\tR\u001a\u0010C\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR\u001a\u0010F\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR\u001a\u0010I\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\tR\u001a\u0010L\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0007\"\u0004\bN\u0010\tR\u001a\u0010O\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR\u001a\u0010R\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0007\"\u0004\bT\u0010\tR\u001a\u0010U\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0007\"\u0004\bW\u0010\tR\u001a\u0010X\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0007\"\u0004\bZ\u0010\tR\u001a\u0010[\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0007\"\u0004\b]\u0010\tR\u001a\u0010^\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0007\"\u0004\b`\u0010\tR\u001a\u0010a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0007\"\u0004\bc\u0010\tR\u001a\u0010d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0007\"\u0004\bf\u0010\tR\u001a\u0010g\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR\u001a\u0010j\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0007\"\u0004\bl\u0010\tR\u001a\u0010m\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0007\"\u0004\bo\u0010\tR\u001c\u0010p\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0007\"\u0004\br\u0010\tR\u001c\u0010s\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0007\"\u0004\bu\u0010\t¨\u0006v"}, d2 = {"Lcom/appnew/android/table/PostDataTable;", "", "<init>", "()V", StoreProvider.StoreData.CREATED_DATE, "", "getCreated", "()Ljava/lang/String;", "setCreated", "(Ljava/lang/String;)V", "page", "getPage", "setPage", "masterCat", "getMasterCat", "setMasterCat", "postId", "", "getPostId", "()I", "setPostId", "(I)V", "id", "getId", "setId", "json", "getJson", "setJson", "meta_url", "getMeta_url", "setMeta_url", Const.LINK_TYPE, "getLink_type", "setLink_type", "thumbnail", "getThumbnail", "setThumbnail", "url", "getUrl", "setUrl", StoreProvider.StoreData.MODIFIED_DATE, "getModified", "setModified", "my_like", "getMy_like", "setMy_like", "name", "getName", "setName", Const.POST_TYPE, "getPost_type", "setPost_type", Const.PROFILE_PICTURE, "getProfile_picture", "setProfile_picture", "status", "getStatus", "setStatus", "sub_cat_id", "getSub_cat_id", "setSub_cat_id", "text", "getText", "setText", "total_comments", "getTotal_comments", "setTotal_comments", "total_likes", "getTotal_likes", "setTotal_likes", "user_id", "getUser_id", "setUser_id", "newCourseData", "getNewCourseData", "setNewCourseData", "livetest", "getLivetest", "setLivetest", "liveclass", "getLiveclass", "setLiveclass", "testResult", "getTestResult", "setTestResult", "bannerlist", "getBannerlist", "setBannerlist", "liveClassStatus", "getLiveClassStatus", "setLiveClassStatus", "liveTestStatus", "getLiveTestStatus", "setLiveTestStatus", "iscommentenable", "getIscommentenable", "setIscommentenable", "sectionposiiton", "getSectionposiiton", "setSectionposiiton", Constants.KEY_LIMIT, "getLimit", "setLimit", "my_pinned", "getMy_pinned", "setMy_pinned", "parentId", "getParentId", "setParentId", "description", "getDescription", "setDescription", "image_type", "getImage_type", "setImage_type", "schedule_date", "getSchedule_date", "setSchedule_date", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostDataTable {
    public static final int $stable = 8;
    private int postId;
    private String created = "";
    private String page = "";
    private String masterCat = "";
    private String id = "";
    private String json = "";
    private String meta_url = "";
    private String link_type = "";
    private String thumbnail = "";
    private String url = "";
    private String modified = "";
    private String my_like = "";
    private String name = "";
    private String post_type = "";
    private String profile_picture = "";
    private String status = "";
    private String sub_cat_id = "";
    private String text = "";
    private String total_comments = "";
    private String total_likes = "";
    private String user_id = "";
    private String newCourseData = "";
    private String livetest = "";
    private String liveclass = "";
    private String testResult = "";
    private String bannerlist = "";
    private String liveClassStatus = "";
    private String liveTestStatus = "";
    private String iscommentenable = "";
    private String sectionposiiton = "";
    private String limit = "";
    private String my_pinned = "";
    private String parentId = "";
    private String description = "";
    private String image_type = "";
    private String schedule_date = "";

    public final String getCreated() {
        return this.created;
    }

    public final void setCreated(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.created = str;
    }

    public final String getPage() {
        return this.page;
    }

    public final void setPage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.page = str;
    }

    public final String getMasterCat() {
        return this.masterCat;
    }

    public final void setMasterCat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.masterCat = str;
    }

    public final int getPostId() {
        return this.postId;
    }

    public final void setPostId(int i) {
        this.postId = i;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getJson() {
        return this.json;
    }

    public final void setJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.json = str;
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
        Intrinsics.checkNotNullParameter(str, "<set-?>");
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
        Intrinsics.checkNotNullParameter(str, "<set-?>");
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
        Intrinsics.checkNotNullParameter(str, "<set-?>");
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

    public final String getNewCourseData() {
        return this.newCourseData;
    }

    public final void setNewCourseData(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.newCourseData = str;
    }

    public final String getLivetest() {
        return this.livetest;
    }

    public final void setLivetest(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.livetest = str;
    }

    public final String getLiveclass() {
        return this.liveclass;
    }

    public final void setLiveclass(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveclass = str;
    }

    public final String getTestResult() {
        return this.testResult;
    }

    public final void setTestResult(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testResult = str;
    }

    public final String getBannerlist() {
        return this.bannerlist;
    }

    public final void setBannerlist(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bannerlist = str;
    }

    public final String getLiveClassStatus() {
        return this.liveClassStatus;
    }

    public final void setLiveClassStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveClassStatus = str;
    }

    public final String getLiveTestStatus() {
        return this.liveTestStatus;
    }

    public final void setLiveTestStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveTestStatus = str;
    }

    public final String getIscommentenable() {
        return this.iscommentenable;
    }

    public final void setIscommentenable(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iscommentenable = str;
    }

    public final String getSectionposiiton() {
        return this.sectionposiiton;
    }

    public final void setSectionposiiton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sectionposiiton = str;
    }

    public final String getLimit() {
        return this.limit;
    }

    public final void setLimit(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.limit = str;
    }

    public final String getMy_pinned() {
        return this.my_pinned;
    }

    public final void setMy_pinned(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.my_pinned = str;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final void setParentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parentId = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final String getImage_type() {
        return this.image_type;
    }

    public final void setImage_type(String str) {
        this.image_type = str;
    }

    public final String getSchedule_date() {
        return this.schedule_date;
    }

    public final void setSchedule_date(String str) {
        this.schedule_date = str;
    }
}
