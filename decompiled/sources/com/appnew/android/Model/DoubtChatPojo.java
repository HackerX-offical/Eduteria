package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class DoubtChatPojo implements Serializable {
    long date;
    String doubt_id;
    String firebase_id;
    String id;
    String is_active;
    boolean isplaying = false;
    String message;
    String name;
    private Original original;
    String platform;
    String profile_picture;
    String type;

    public DoubtChatPojo() {
    }

    public DoubtChatPojo(String id, String message, String name, long date, String is_active, String profile_picture, String platform, String type, String doubtid) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.date = date;
        this.is_active = is_active;
        this.profile_picture = profile_picture;
        this.platform = platform;
        this.type = type;
        this.doubt_id = doubtid;
    }

    public String getDoubt_id() {
        return this.doubt_id;
    }

    public void setDoubt_id(String doubt_id) {
        this.doubt_id = doubt_id;
    }

    public String getFirebase_id() {
        return this.firebase_id;
    }

    public void setFirebase_id(String firebase_id) {
        this.firebase_id = firebase_id;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Original getOriginal() {
        return this.original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }

    public String getIs_active() {
        return this.is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
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

    public boolean isIsplaying() {
        return this.isplaying;
    }

    public void setIsplaying(boolean isplaying) {
        this.isplaying = isplaying;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
