package com.appnew.android.Courses.Modal;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class OnlineUser implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("interact")
    @Expose
    private String interact;

    @SerializedName("is_chat_locked")
    @Expose
    private String is_chat_locked;

    @SerializedName("joined_at")
    @Expose
    private long joined_at;

    @SerializedName(Const.MOBILE)
    @Expose
    private String mobile;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("online")
    @Expose
    private String online;

    @SerializedName(Const.PROFILE_PICTURE)
    @Expose
    private String profile_picture;

    @SerializedName("type")
    @Expose
    private String type;

    public String getIs_chat_locked() {
        return this.is_chat_locked;
    }

    public void setIs_chat_locked(String is_chat_locked) {
        this.is_chat_locked = is_chat_locked;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOnline() {
        return this.online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInteract() {
        return this.interact;
    }

    public void setInteract(String interact) {
        this.interact = interact;
    }

    public long getJoined_at() {
        return this.joined_at;
    }

    public void setJoined_at(long joined_at) {
        this.joined_at = joined_at;
    }

    public OnlineUser() {
    }

    public OnlineUser(String name, String profile, String type, String online, String id, String mobile, String interact) {
        this.id = id;
        this.name = name;
        this.profile_picture = profile;
        this.type = type;
        this.online = online;
        this.mobile = mobile;
        this.interact = interact;
    }

    public OnlineUser(String name, String profile, String type, String online, String id, String mobile, String interact, long joined_at) {
        this.id = id;
        this.name = name;
        this.profile_picture = profile;
        this.type = type;
        this.online = online;
        this.mobile = mobile;
        this.interact = interact;
        this.joined_at = joined_at;
    }
}
