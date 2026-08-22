package com.appnew.android.Model.ZoomModel;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ReviewData implements Serializable {

    @SerializedName(Const.CREATION_TIME)
    @Expose
    private String creation_time;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("name")
    @Expose
    private String name;
    private String profile_picture;

    @SerializedName(Const.RATINGS)
    @Expose
    private String rating;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReviewData(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
