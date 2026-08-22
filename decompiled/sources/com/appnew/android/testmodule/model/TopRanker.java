package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TopRanker implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

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

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
