package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class RewardTransaction implements Serializable {
    private String area;
    private String creation_time;
    private String id;
    private String reward;
    private String user_id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getReward() {
        return this.reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
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
        return "ClassPojo [id = " + this.id + ", area = " + this.area + ", reward = " + this.reward + ", creation_time = " + this.creation_time + ", user_id = " + this.user_id + Constants.AES_SUFFIX;
    }
}
