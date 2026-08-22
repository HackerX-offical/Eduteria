package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TopTenList implements Serializable {

    @SerializedName("marks")
    @Expose
    private String marks;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName(Const.PROFILE_PICTURE)
    @Expose
    private String profilePicture;

    @SerializedName("rank")
    @Expose
    private String rank;

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("user_id")
    @Expose
    private String userId;

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
