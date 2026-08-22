package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.appnew.android.home.liveclasses.PayloadData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Video implements Serializable {
    private String URL;
    private String URL_ENC;
    private String allow_comments;
    private String answers;
    private String answers_by_student;
    private String app_id;
    private String attempt;
    private String author_name;
    private String banner_url;
    private ArrayList<UrlObject> bitrate_urls;
    private String chat_mode;
    private String chat_node;
    private String comments;
    private String correct_count;
    private String course_id;
    private String course_name;
    private String created;
    private String creation_time;
    private String day_wise;
    private String description;
    private String description_2;
    private String end_date;
    private String end_time;
    private String expired;
    private Extra_params extra_params;
    private String featured;
    private String file_id;
    private String file_type;
    private String file_url;
    private String file_url_enc;
    private String for_dams;
    private String for_non_dams;
    private String had_pdf;
    private String id;
    private String image;
    private String incorrect_count;
    private String initial_view;
    private String is_bookmarked;
    private String is_chat_locked;
    private boolean is_deleted;

    @SerializedName(Const.IS_DOWNLOAD)
    private String is_download_available;
    private String is_drm;
    private String is_favourite;
    private String is_like;
    private String is_live;
    private String is_locked;
    private String is_new;
    private String is_purchased;
    private String is_reattempt;
    private String is_test_purchased;
    private String is_viewed;
    private String is_vod;
    private String lang_id;
    private String lang_used;
    private String likes;
    private String live_on;
    private String live_status;
    private String main_cat;
    private String mark_as_complete;
    private String marks;
    private String modified;
    private String multiplayer;
    private String open_in_app;
    private PayloadData payload;
    private String pdf_view_url;
    private String playtime;
    private String question;
    private String remaining_time;
    private String report_id;
    private String result_date;
    private String result_status;
    private String screen_tag;
    private String set_type;
    private String solutions;
    private String start_date;
    private String start_time;
    private String state;
    private String sub_cat;
    private String subject_id;
    private String subject_name;
    private String submission_type;
    private String tags;
    private String test_code;
    private String test_series_name;
    private String test_series_type;
    private String test_type;
    private String thumbnail_url;
    private String tile_id;
    private String time_in_mins;
    private String title;
    private String token;
    private String topic_id;
    private String total_marks;
    private String total_questions;
    private String upload_allowed;
    private String vdc_id;
    private String video_creation_time;
    private Long video_currentpos;
    private String video_desc;
    private String video_duration;
    private String video_length;
    private String video_name;
    private String video_status;
    private String video_title;
    private String video_type;
    private String videotime;
    private String views;
    private String zoom_meeting_id;
    private String zoom_meeting_passcode;
    private String zoom_sdk_token;
    private String is_gst = "";
    private String is_share = "";
    private String tax_rate = "";
    private String price = "";
    private List<EncryptedUrl> encrypted_urls = null;
    private boolean video_download = false;
    private String progress = "";
    private String time_left = "";
    private String total_time = "";
    private String type = "";
    private String user_id = "";
    private String video_id = "";
    private String test_pattern = "";
    private String mode = "";
    private boolean isVideoPlaying = false;

    public String getIs_share() {
        return this.is_share;
    }

    public void setIs_share(String is_share) {
        this.is_share = is_share;
    }

    public String getZoom_sdk_token() {
        return this.zoom_sdk_token;
    }

    public void setZoom_sdk_token(String zoom_sdk_token) {
        this.zoom_sdk_token = zoom_sdk_token;
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public PayloadData getPayload() {
        return this.payload;
    }

    public void setPayload(PayloadData payload) {
        this.payload = payload;
    }

    public String getVideo_name() {
        return this.video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getTile_id() {
        return this.tile_id;
    }

    public void setTile_id(String tile_id) {
        this.tile_id = tile_id;
    }

    public String getFile_id() {
        return this.file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getSubject_name() {
        return this.subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getExpired() {
        return this.expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getProgress() {
        return this.progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getTime_left() {
        return this.time_left;
    }

    public void setTime_left(String time_left) {
        this.time_left = time_left;
    }

    public String getTotal_time() {
        return this.total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVideo_id() {
        return this.video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getTest_pattern() {
        return this.test_pattern;
    }

    public void setTest_pattern(String test_pattern) {
        this.test_pattern = test_pattern;
    }

    public String getStart_time() {
        return this.start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getIs_chat_locked() {
        return this.is_chat_locked;
    }

    public void setIs_chat_locked(String is_chat_locked) {
        this.is_chat_locked = is_chat_locked;
    }

    public String getVideo_duration() {
        return this.video_duration;
    }

    public void setVideo_duration(String video_duration) {
        this.video_duration = video_duration;
    }

    public String getTest_series_type() {
        return this.test_series_type;
    }

    public void setTest_series_type(String test_series_type) {
        this.test_series_type = test_series_type;
    }

    public String getPdf_view_url() {
        return this.pdf_view_url;
    }

    public void setPdf_view_url(String pdf_view_url) {
        this.pdf_view_url = pdf_view_url;
    }

    public String getHad_pdf() {
        return this.had_pdf;
    }

    public void setHad_pdf(String had_pdf) {
        this.had_pdf = had_pdf;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIs_gst() {
        return this.is_gst;
    }

    public void setIs_gst(String is_gst) {
        this.is_gst = is_gst;
    }

    public String getTax_rate() {
        return this.tax_rate;
    }

    public void setTax_rate(String tax_rate) {
        this.tax_rate = tax_rate;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIs_test_purchased() {
        return this.is_test_purchased;
    }

    public void setIs_test_purchased(String is_test_purchased) {
        this.is_test_purchased = is_test_purchased;
    }

    public String getDay_wise() {
        return this.day_wise;
    }

    public void setDay_wise(String day_wise) {
        this.day_wise = day_wise;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public String getZoom_meeting_passcode() {
        return this.zoom_meeting_passcode;
    }

    public void setZoom_meeting_passcode(String zoom_meeting_passcode) {
        this.zoom_meeting_passcode = zoom_meeting_passcode;
    }

    public String getZoom_meeting_id() {
        return this.zoom_meeting_id;
    }

    public void setZoom_meeting_id(String zoom_meeting_id) {
        this.zoom_meeting_id = zoom_meeting_id;
    }

    public Extra_params getExtra_params() {
        return this.extra_params;
    }

    public void setExtra_params(Extra_params extra_params) {
        this.extra_params = extra_params;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSolutions() {
        return this.solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }

    public String getAnswers() {
        return this.answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getIs_chat_lock() {
        return this.is_chat_locked;
    }

    public void setIs_chat_lock(String is_chat_lock) {
        this.is_chat_locked = is_chat_lock;
    }

    public PayloadData getPayloadData() {
        return this.payload;
    }

    public void setPayloadData(PayloadData payloadData) {
        this.payload = payloadData;
    }

    public String getIs_reattempt() {
        return this.is_reattempt;
    }

    public void setIs_reattempt(String is_reattempt) {
        this.is_reattempt = is_reattempt;
    }

    public String getResult_date() {
        return this.result_date;
    }

    public void setResult_date(String result_date) {
        this.result_date = result_date;
    }

    public String getModified() {
        return this.modified;
    }

    public String getIs_drm() {
        return this.is_drm;
    }

    public void setIs_drm(String is_drm) {
        this.is_drm = is_drm;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public ArrayList<UrlObject> getBitrate_urls() {
        return this.bitrate_urls;
    }

    public void setBitrate_urls(ArrayList<UrlObject> bitrate_urls) {
        this.bitrate_urls = bitrate_urls;
    }

    public boolean isIs_deleted() {
        return this.is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getBanner_url() {
        return this.banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getVdc_id() {
        return this.vdc_id;
    }

    public void setVdc_id(String vdc_id) {
        this.vdc_id = vdc_id;
    }

    public String getVideotime() {
        return this.videotime;
    }

    public void setVideotime(String videotime) {
        this.videotime = videotime;
    }

    public Long getVideo_currentpos() {
        return this.video_currentpos;
    }

    public void setVideo_currentpos(Long video_currentpos) {
        this.video_currentpos = video_currentpos;
    }

    public String getVideo_status() {
        return this.video_status;
    }

    public void setVideo_status(String video_status) {
        this.video_status = video_status;
    }

    public boolean isVideo_download() {
        return this.video_download;
    }

    public void setVideo_download(boolean video_download) {
        this.video_download = video_download;
    }

    public String getIs_download_available() {
        return this.is_download_available;
    }

    public void setIs_download_available(String is_download_available) {
        this.is_download_available = is_download_available;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMultiplayer() {
        return this.multiplayer;
    }

    public void setMultiplayer(String multiplayer) {
        this.multiplayer = multiplayer;
    }

    public String getPlaytime() {
        return this.playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getRemaining_time() {
        return this.remaining_time;
    }

    public void setRemaining_time(String remaining_time) {
        this.remaining_time = remaining_time;
    }

    public String getIs_vod() {
        return this.is_vod;
    }

    public void setIs_vod(String is_vod) {
        this.is_vod = is_vod;
    }

    public String getIs_Download() {
        return this.is_download_available;
    }

    public void setIs_Download(String is_download_available) {
        this.is_download_available = is_download_available;
    }

    public List<EncryptedUrl> getEncrypted_urls() {
        return this.encrypted_urls;
    }

    public void setEncrypted_urls(List<EncryptedUrl> encrypted_urls) {
        this.encrypted_urls = encrypted_urls;
    }

    public String getOpen_in_app() {
        return this.open_in_app;
    }

    public void setOpen_in_app(String open_in_app) {
        this.open_in_app = open_in_app;
    }

    public String getLive_on() {
        return this.live_on;
    }

    public void setLive_on(String live_on) {
        this.live_on = live_on;
    }

    public String getIs_purchased() {
        return this.is_purchased;
    }

    public void setIs_purchased(String is_purchased) {
        this.is_purchased = is_purchased;
    }

    public String getIs_locked() {
        return this.is_locked;
    }

    public void setIs_locked(String is_locked) {
        this.is_locked = is_locked;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile_type() {
        return this.file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getIs_favourite() {
        return this.is_favourite;
    }

    public void setIs_favourite(String is_favourite) {
        this.is_favourite = is_favourite;
    }

    public String getInitial_view() {
        return this.initial_view;
    }

    public void setInitial_view(String initial_view) {
        this.initial_view = initial_view;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFor_non_dams() {
        return this.for_non_dams;
    }

    public void setFor_non_dams(String for_non_dams) {
        this.for_non_dams = for_non_dams;
    }

    public String getScreen_tag() {
        return this.screen_tag;
    }

    public void setScreen_tag(String screen_tag) {
        this.screen_tag = screen_tag;
    }

    public String getVideo_type() {
        return this.video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    public String getAllow_comments() {
        return this.allow_comments;
    }

    public void setAllow_comments(String allow_comments) {
        this.allow_comments = allow_comments;
    }

    public String getIs_like() {
        return this.is_like;
    }

    public void setIs_like(String is_like) {
        this.is_like = is_like;
    }

    public String getVideo_title() {
        return this.video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getFeatured() {
        return this.featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getVideo_desc() {
        return this.video_desc;
    }

    public void setVideo_desc(String video_desc) {
        this.video_desc = video_desc;
    }

    public String getIs_viewed() {
        return this.is_viewed;
    }

    public void setIs_viewed(String is_viewed) {
        this.is_viewed = is_viewed;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChat_mode() {
        return this.chat_mode;
    }

    public void setChat_mode(String chat_mode) {
        this.chat_mode = chat_mode;
    }

    public String getIs_new() {
        return this.is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getSub_cat() {
        return this.sub_cat;
    }

    public void setSub_cat(String sub_cat) {
        this.sub_cat = sub_cat;
    }

    public String getViews() {
        return this.views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getLikes() {
        return this.likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getFor_dams() {
        return this.for_dams;
    }

    public void setFor_dams(String for_dams) {
        this.for_dams = for_dams;
    }

    public String getAuthor_name() {
        return this.author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getMain_cat() {
        return this.main_cat;
    }

    public void setMain_cat(String main_cat) {
        this.main_cat = main_cat;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getURL_ENC() {
        return this.URL_ENC;
    }

    public void setURL_ENC(String URL_ENC) {
        this.URL_ENC = URL_ENC;
    }

    public String getStart_date() {
        return this.start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getChat_node() {
        return this.chat_node;
    }

    public void setChat_node(String chat_node) {
        this.chat_node = chat_node;
    }

    public String getIs_live() {
        return this.is_live;
    }

    public void setIs_live(String is_live) {
        this.is_live = is_live;
    }

    public String getLive_status() {
        return this.live_status;
    }

    public void setLive_status(String live_status) {
        this.live_status = live_status;
    }

    public String getFile_url_enc() {
        return this.file_url_enc;
    }

    public void setFile_url_enc(String file_url_enc) {
        this.file_url_enc = file_url_enc;
    }

    public String getVideo_length() {
        return this.video_length;
    }

    public void setVideo_length(String video_length) {
        this.video_length = video_length;
    }

    public String getVideo_creation_time() {
        return this.video_creation_time;
    }

    public void setVideo_creation_time(String video_creation_time) {
        this.video_creation_time = video_creation_time;
    }

    public String getDuration() {
        return this.video_duration;
    }

    public void setDuration(String duration) {
        this.video_duration = duration;
    }

    public String getUpload_allowed() {
        return this.upload_allowed;
    }

    public void setUpload_allowed(String upload_allowed) {
        this.upload_allowed = upload_allowed;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription_2() {
        return this.description_2;
    }

    public void setDescription_2(String description_2) {
        this.description_2 = description_2;
    }

    public String getTest_series_name() {
        return this.test_series_name;
    }

    public void setTest_series_name(String test_series_name) {
        this.test_series_name = test_series_name;
    }

    public String getTest_code() {
        return this.test_code;
    }

    public void setTest_code(String test_code) {
        this.test_code = test_code;
    }

    public String getTest_type() {
        return this.test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public String getSet_type() {
        return this.set_type;
    }

    public void setSet_type(String set_type) {
        this.set_type = set_type;
    }

    public String getTotal_marks() {
        return this.total_marks;
    }

    public void setTotal_marks(String total_marks) {
        this.total_marks = total_marks;
    }

    public String getLang_id() {
        return this.lang_id;
    }

    public void setLang_id(String lang_id) {
        this.lang_id = lang_id;
    }

    public String getTotal_questions() {
        return this.total_questions;
    }

    public void setTotal_questions(String total_questions) {
        this.total_questions = total_questions;
    }

    public String getTime_in_mins() {
        return this.time_in_mins;
    }

    public void setTime_in_mins(String time_in_mins) {
        this.time_in_mins = time_in_mins;
    }

    public String getReport_id() {
        return this.report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCorrect_count() {
        return this.correct_count;
    }

    public void setCorrect_count(String correct_count) {
        this.correct_count = correct_count;
    }

    public String getIncorrect_count() {
        return this.incorrect_count;
    }

    public void setIncorrect_count(String incorrect_count) {
        this.incorrect_count = incorrect_count;
    }

    public String getLang_used() {
        return this.lang_used;
    }

    public void setLang_used(String lang_used) {
        this.lang_used = lang_used;
    }

    public String getSubmission_type() {
        return this.submission_type;
    }

    public void setSubmission_type(String submission_type) {
        this.submission_type = submission_type;
    }

    public String getResult_status() {
        return this.result_status;
    }

    public void setResult_status(String result_status) {
        this.result_status = result_status;
    }

    public String getAnswers_by_student() {
        return this.answers_by_student;
    }

    public void setAnswers_by_student(String answers_by_student) {
        this.answers_by_student = answers_by_student;
    }

    public String getAttempt() {
        return this.attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public boolean isVideoPlaying() {
        return this.isVideoPlaying;
    }

    public void setVideoPlaying(boolean videoPlaying) {
        this.isVideoPlaying = videoPlaying;
    }

    public String getMark_as_complete() {
        return this.mark_as_complete;
    }

    public void setMark_as_complete(String mark_as_complete) {
        this.mark_as_complete = mark_as_complete;
    }
}
