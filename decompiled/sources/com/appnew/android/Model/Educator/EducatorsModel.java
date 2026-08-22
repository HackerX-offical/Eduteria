package com.appnew.android.Model.Educator;

import androidx.autofill.HintConstants;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class EducatorsModel {

    @SerializedName("cd_time")
    @Expose
    private Long cdTime;

    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data;

    @SerializedName("interval")
    @Expose
    private Integer interval;

    @SerializedName(Constants.KEY_LIMIT)
    @Expose
    private Integer limit;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("time")
    @Expose
    private Integer time;

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Datum> getData() {
        return this.data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getInterval() {
        return this.interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getCdTime() {
        return this.cdTime;
    }

    public void setCdTime(Long cdTime) {
        this.cdTime = cdTime;
    }

    public class Datum {

        @SerializedName("experience")
        @Expose
        private String experience;

        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName(Const.PROFILE_PICTURE)
        @Expose
        private String profilePicture;

        @SerializedName(HintConstants.AUTOFILL_HINT_USERNAME)
        @Expose
        private String username;

        public Datum() {
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getExperience() {
            return this.experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getProfilePicture() {
            return this.profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
        }
    }
}
