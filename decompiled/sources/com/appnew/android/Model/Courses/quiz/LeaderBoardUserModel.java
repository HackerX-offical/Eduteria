package com.appnew.android.Model.Courses.quiz;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class LeaderBoardUserModel implements Serializable {
    private String creation_time;
    private String name;
    private String profile_picture;
    private String rank;
    private String user_id;

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String toString() {
        return "ClassPojo [profile_picture = " + this.profile_picture + ", name = " + this.name + ", creation_time = " + this.creation_time + ", user_id = " + this.user_id + Constants.AES_SUFFIX;
    }
}
