package com.appnew.android.Model.ZoomModel;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.db.Column;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class DoubtData implements Serializable {

    @SerializedName("question_no")
    private String QuestionNo;

    @SerializedName("chat_node")
    @Expose
    private String chat_node;

    @SerializedName(Column.CREATED_AT)
    @Expose
    private String created_at;

    @SerializedName("doubt_audio")
    @Expose
    private String doubt_audio;

    @SerializedName("doubt_id")
    @Expose
    private String doubt_id;

    @SerializedName("doubt_image")
    @Expose
    private String doubt_image;

    @SerializedName("doubt_message")
    @Expose
    private String doubt_message;

    @SerializedName("doubt_pdf")
    @Expose
    private String doubt_pdf;

    @SerializedName("isReviewSubmitted")
    @Expose
    private String isReviewSubmitted;

    @SerializedName("is_complete")
    @Expose
    private String is_complete;

    @SerializedName("page_no")
    private String pageNo;

    @SerializedName("reply")
    @Expose
    private ArrayList<ReplyModel> reply;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName(Const.SUBJECT_ID)
    private String subjectId;

    @SerializedName("subject_name")
    @Expose
    private String subject_name;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName(AnalyticsConstants.user_name)
    @Expose
    private String user_name;

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getIsReviewSubmitted() {
        return this.isReviewSubmitted;
    }

    public void setIsReviewSubmitted(String isReviewSubmitted) {
        this.isReviewSubmitted = isReviewSubmitted;
    }

    public String getDoubt_pdf() {
        return this.doubt_pdf;
    }

    public void setDoubt_pdf(String doubt_pdf) {
        this.doubt_pdf = doubt_pdf;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSubject_name() {
        return this.subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getDoubt_message() {
        return this.doubt_message;
    }

    public void setDoubt_message(String doubt_message) {
        this.doubt_message = doubt_message;
    }

    public String getDoubt_image() {
        return this.doubt_image;
    }

    public void setDoubt_image(String doubt_image) {
        this.doubt_image = doubt_image;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDoubt_id() {
        return this.doubt_id;
    }

    public void setDoubt_id(String doubt_id) {
        this.doubt_id = doubt_id;
    }

    public String getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getQuestionNo() {
        return this.QuestionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.QuestionNo = questionNo;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public ArrayList<ReplyModel> getReply() {
        return this.reply;
    }

    public void setReply(ArrayList<ReplyModel> reply) {
        this.reply = reply;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_complete() {
        return this.is_complete;
    }

    public void setIs_complete(String is_complete) {
        this.is_complete = is_complete;
    }

    public String getDoubt_audio() {
        return this.doubt_audio;
    }

    public void setDoubt_audio(String doubt_audio) {
        this.doubt_audio = doubt_audio;
    }

    public String getChat_node() {
        return this.chat_node;
    }

    public void setChat_node(String chat_node) {
        this.chat_node = chat_node;
    }
}
