package com.appnew.android.Response;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class MyNotesResponse implements Serializable {

    @SerializedName("article_data")
    @Expose
    private PostResponse articleData;

    @SerializedName(Const.ARTICLE_ID)
    @Expose
    private String articleId;

    @SerializedName(Const.CREATION_TIME)
    @Expose
    private String creationTime;

    @SerializedName(Const.DOSE_TYPE)
    @Expose
    private String doseType;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName(Const.NOTE_DATA)
    @Expose
    private String noteData;

    @SerializedName("updated_time")
    @Expose
    private String updatedTime;

    @SerializedName("user_id")
    @Expose
    private String userId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getDoseType() {
        return this.doseType;
    }

    public void setDoseType(String doseType) {
        this.doseType = doseType;
    }

    public String getNoteData() {
        return this.noteData;
    }

    public void setNoteData(String noteData) {
        this.noteData = noteData;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public PostResponse getArticleData() {
        return this.articleData;
    }

    public void setArticleData(PostResponse articleData) {
        this.articleData = articleData;
    }
}
