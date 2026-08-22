package com.appnew.android.Model.test_sere;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class TopTenList {

    @SerializedName(Const.CREATION_TIME)
    private String mCreationTime;

    @SerializedName("name")
    private String mName;

    @SerializedName(Const.PROFILE_PICTURE)
    private String mProfilePicture;

    @SerializedName("user_id")
    private String mUserId;

    public String getCreationTime() {
        return this.mCreationTime;
    }

    public void setCreationTime(String creationTime) {
        this.mCreationTime = creationTime;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getProfilePicture() {
        return this.mProfilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.mProfilePicture = profilePicture;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String userId) {
        this.mUserId = userId;
    }
}
