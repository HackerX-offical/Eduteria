package com.appnew.android.Model.NotificationModel;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;

/* JADX INFO: loaded from: classes6.dex */
public class Extras {

    @SerializedName("admin_id")
    @Expose
    private String adminId;

    @SerializedName("chat_node")
    @Expose
    private String chat_node;

    @SerializedName("content_type")
    @Expose
    private String content_type;

    @SerializedName("coupon_for")
    @Expose
    private String coupon_for;

    @SerializedName("course_id")
    @Expose
    private String course_id;

    @SerializedName(AnalyticsConstants.device_type)
    @Expose
    private String deviceType;

    @SerializedName("end")
    @Expose
    private String end_date;

    @SerializedName("file_id")
    @Expose
    private String file_id;

    @SerializedName("file_url")
    @Expose
    private String file_url;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("notification_text")
    @Expose
    private String notificationText;

    @SerializedName("notification_type")
    @Expose
    private String notificationType;
    private String parent_id;

    @SerializedName("result_date")
    @Expose
    private String resultDate;

    @SerializedName("solutions")
    @Expose
    private String solutions;

    @SerializedName("start")
    @Expose
    private String start_date;

    @SerializedName("test_series_name")
    @Expose
    private String testSeriesName;

    @SerializedName("test_id")
    @Expose
    private String test_id;

    @SerializedName("tile_id")
    @Expose
    private String tile_id;

    @SerializedName(Const.TILE_TYPE)
    @Expose
    private String tiletype;

    @SerializedName(Const.TOPIC_ID)
    @Expose
    private String topic_id;

    @SerializedName(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP)
    @Expose
    private String ts;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("url_type")
    @Expose
    private String urlType;

    @SerializedName("users_description")
    @Expose
    private String usersDescription;

    @SerializedName("users_message")
    @Expose
    private String usersMessage;

    @SerializedName("users_type")
    @Expose
    private String usersType;

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getContent_type() {
        return this.content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTiletype() {
        return this.tiletype;
    }

    public void setTiletype(String tiletype) {
        this.tiletype = tiletype;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTest_id() {
        return this.test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getStart_date() {
        return this.start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getCoupon_for() {
        return this.coupon_for;
    }

    public void setCoupon_for(String coupon_for) {
        this.coupon_for = coupon_for;
    }

    public String getChat_node() {
        return this.chat_node;
    }

    public void setChat_node(String chat_node) {
        this.chat_node = chat_node;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getFile_id() {
        return this.file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTile_id() {
        return this.tile_id;
    }

    public void setTile_id(String tile_id) {
        this.tile_id = tile_id;
    }

    public String getUsersDescription() {
        return this.usersDescription;
    }

    public void setUsersDescription(String usersDescription) {
        this.usersDescription = usersDescription;
    }

    public String getUsersType() {
        return this.usersType;
    }

    public void setUsersType(String usersType) {
        this.usersType = usersType;
    }

    public String getUsersMessage() {
        return this.usersMessage;
    }

    public void setUsersMessage(String usersMessage) {
        this.usersMessage = usersMessage;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getNotificationType() {
        return this.notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationText() {
        return this.notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getAdminId() {
        return this.adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getUrlType() {
        return this.urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getSolutions() {
        return this.solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }

    public String getTestSeriesName() {
        return this.testSeriesName;
    }

    public void setTestSeriesName(String testSeriesName) {
        this.testSeriesName = testSeriesName;
    }

    public String getResultDate() {
        return this.resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
