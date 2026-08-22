package com.appnew.android.feeds.dataclass;

import android.widget.TextView;
import com.appnew.android.Model.UrlObject;
import com.appnew.android.Utils.Const;
import com.appnew.android.home.liveclasses.PayloadData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* JADX INFO: loaded from: classes6.dex */
public class Datum implements Serializable {
    private ArrayList<UrlObject> bitrate_urls;
    private long cd_time = 0;

    @SerializedName("chat_node")
    @Expose
    private String chatNode;

    @SerializedName(AnalyticsConstants.course_name)
    @Expose
    private String course_name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName(FirebaseAnalytics.Param.END_DATE)
    @Expose
    private String end_date;

    @SerializedName("file_type")
    @Expose
    private String fileType;

    @SerializedName("file_url")
    @Expose
    private String fileUrl;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName(Const.IS_DOWNLOAD)
    @Expose
    private String isDownload;

    @SerializedName("is_live")
    @Expose
    private String is_live;

    @SerializedName("is_locked")
    @Expose
    private String is_locked;

    @SerializedName("is_chat_locked")
    @Expose
    private String ischatlock;

    @SerializedName("live_status")
    @Expose
    private String liveStatus;

    @SerializedName("live_on")
    private String live_on;

    @SerializedName("open_in_app")
    @Expose
    private String openInApp;

    @SerializedName("payload")
    @Expose
    private PayloadData payload;

    @SerializedName("playtime")
    @Expose
    private String playtime;

    @SerializedName(FirebaseAnalytics.Param.START_DATE)
    @Expose
    private String startdate;

    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("video_length")
    @Expose
    private String videoLength;

    @SerializedName(Const.VIDEO_TYPE)
    @Expose
    private String videoType;

    public String getIs_locked() {
        return this.is_locked;
    }

    public void setIs_locked(String is_locked) {
        this.is_locked = is_locked;
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public ArrayList<UrlObject> getBitrate_urls() {
        return this.bitrate_urls;
    }

    public void setBitrate_urls(ArrayList<UrlObject> bitrate_urls) {
        this.bitrate_urls = bitrate_urls;
    }

    public String getLive_on() {
        return this.live_on;
    }

    public void setLive_on(String live_on) {
        this.live_on = live_on;
    }

    public PayloadData getPayload() {
        return this.payload;
    }

    public void setPayload(PayloadData payload) {
        this.payload = payload;
    }

    public String getIs_live() {
        return this.is_live;
    }

    public void setIs_live(String is_live) {
        this.is_live = is_live;
    }

    public String getIschatlock() {
        return this.ischatlock;
    }

    public void setIschatlock(String ischatlock) {
        this.ischatlock = ischatlock;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getIsDownload() {
        return this.isDownload;
    }

    public void setIsDownload(String isDownload) {
        this.isDownload = isDownload;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoLength() {
        return this.videoLength;
    }

    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }

    public String getChatNode() {
        return this.chatNode;
    }

    public void setChatNode(String chatNode) {
        this.chatNode = chatNode;
    }

    public String getLiveStatus() {
        return this.liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getOpenInApp() {
        return this.openInApp;
    }

    public void setOpenInApp(String openInApp) {
        this.openInApp = openInApp;
    }

    public String getPlaytime() {
        return this.playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public long getCd_time() {
        return this.cd_time;
    }

    public void setCd_time(long cd_time) {
        this.cd_time = cd_time;
    }

    public static void time(TextView textView, Datum data) {
        String date = getDate(Long.parseLong(data.getStartdate()) * 1000, "dd-MMM-yyyy hh:mm a");
        if (data.getEnd_date() != null) {
            date = date + " - " + getDate(Long.parseLong(data.getEnd_date()) * 1000, "dd-MMM-yyyy hh:mm a");
        }
        textView.setText(date);
    }

    private static String getDate(long start_msecond, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(start_msecond);
        return simpleDateFormat.format(calendar.getTime());
    }
}
