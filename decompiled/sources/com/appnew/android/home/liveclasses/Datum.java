package com.appnew.android.home.liveclasses;

import android.widget.TextView;
import com.appnew.android.Model.UrlObject;
import com.appnew.android.Utils.Const;
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

    @SerializedName("cd_time")
    @Expose
    private long cd_time;

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

    @SerializedName("had_pdf")
    private String had_pdf;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName(Const.IS_DOWNLOAD)
    @Expose
    private String isDownload;

    @SerializedName("is_live")
    @Expose
    private String is_live;

    @SerializedName("is_lock")
    @Expose
    private String is_lock;

    @SerializedName("is_locked")
    @Expose
    private String is_locked;

    @SerializedName("is_chat_locked")
    @Expose
    private String ischatlock;

    @SerializedName("is_drm")
    @Expose
    private String isdrm;

    @SerializedName("join_url")
    @Expose
    private String join_url;

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

    @SerializedName("vdc_id")
    @Expose
    private String vdc_id;

    @SerializedName("video_length")
    @Expose
    private String videoLength;

    @SerializedName(Const.VIDEO_TYPE)
    @Expose
    private String videoType;

    @SerializedName("zoom_meeting_id")
    @Expose
    private String zoom_meeting_id;

    @SerializedName("zoom_meeting_passcode")
    @Expose
    private String zoom_meeting_passcode;

    @SerializedName("zoom_sdk_token")
    @Expose
    private String zoom_sdk_token;

    public String getVdc_id() {
        return this.vdc_id;
    }

    public void setVdc_id(String vdc_id) {
        this.vdc_id = vdc_id;
    }

    public String getIsdrm() {
        return this.isdrm;
    }

    public void setIsdrm(String isdrm) {
        this.isdrm = isdrm;
    }

    public String getIs_lock() {
        return this.is_lock;
    }

    public void setIs_lock(String is_lock) {
        this.is_lock = is_lock;
    }

    public String getZoom_meeting_id() {
        return this.zoom_meeting_id;
    }

    public void setZoom_meeting_id(String zoom_meeting_id) {
        this.zoom_meeting_id = zoom_meeting_id;
    }

    public String getZoom_meeting_passcode() {
        return this.zoom_meeting_passcode;
    }

    public void setZoom_meeting_passcode(String zoom_meeting_passcode) {
        this.zoom_meeting_passcode = zoom_meeting_passcode;
    }

    public String getJoin_url() {
        return this.join_url;
    }

    public void setJoin_url(String join_url) {
        this.join_url = join_url;
    }

    public String getZoom_sdk_token() {
        return this.zoom_sdk_token;
    }

    public void setZoom_sdk_token(String zoom_sdk_token) {
        this.zoom_sdk_token = zoom_sdk_token;
    }

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

    public long getCd_time() {
        return this.cd_time;
    }

    public void setCd_time(long cd_time) {
        this.cd_time = cd_time;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public ArrayList<UrlObject> getBitrate_urls() {
        return this.bitrate_urls;
    }

    public void setBitrate_urls(ArrayList<UrlObject> bitrate_urls) {
        this.bitrate_urls = bitrate_urls;
    }

    public String getHad_pdf() {
        return this.had_pdf;
    }

    public void setHad_pdf(String had_pdf) {
        this.had_pdf = had_pdf;
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

    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public static void time(TextView textView, Datum data) {
        textView.setText(getDate(Long.parseLong(data.getStartdate()) * 1000, "dd-MMM-yyyy hh:mm a") + " - " + getDate(Long.parseLong(data.getEnd_date()) * 1000, "dd-MMM-yyyy hh:mm a"));
    }

    private static String getDate(long start_msecond, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(start_msecond);
        return simpleDateFormat.format(calendar.getTime());
    }
}
