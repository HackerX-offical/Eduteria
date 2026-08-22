package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class chatPojo implements Serializable {
    String course_id;
    long date;
    String erp_token;
    String firebase_id;
    String id;
    String is_active;
    String is_chat_locked;
    String is_edited;
    boolean isplaying = false;
    String locked_user_id;
    String message;
    String name;
    private Original original;
    String pin;
    String platform;
    String profile_picture;
    String type;
    String userId;
    String viewType;

    public String getLocked_user_id() {
        return this.locked_user_id;
    }

    public void setLocked_user_id(String locked_user_id) {
        this.locked_user_id = locked_user_id;
    }

    public String getViewType() {
        return this.viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIs_edited() {
        return this.is_edited;
    }

    public void setIs_edited(String is_edited) {
        this.is_edited = is_edited;
    }

    public chatPojo() {
    }

    public chatPojo(String viewType, long date) {
        this.viewType = viewType;
        this.date = date;
    }

    public chatPojo(String id, String message, String name, long date, String is_active, String profile_picture, String platform, String type, String courseid) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.date = date;
        this.is_active = is_active;
        this.profile_picture = profile_picture;
        this.platform = platform;
        this.type = type;
        this.course_id = courseid;
    }

    public chatPojo(String id, String message, String name, long date, String platform, String type, String courseid) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.date = date;
        this.platform = platform;
        this.type = type;
        this.course_id = courseid;
    }

    public chatPojo(String id, String message, String name, long date, String is_active, String profile_picture, String platform, String type, String courseid, String viewType, String pin, String userId, String is_edited) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.date = date;
        this.is_active = is_active;
        this.profile_picture = profile_picture;
        this.platform = platform;
        this.type = type;
        this.course_id = courseid;
        this.viewType = viewType;
        this.pin = pin;
        this.userId = userId;
        this.is_edited = is_edited;
    }

    public String getIs_chat_locked() {
        return this.is_chat_locked;
    }

    public void setIs_chat_locked(String is_chat_locked) {
        this.is_chat_locked = is_chat_locked;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
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

    public String getErp_token() {
        return this.erp_token;
    }

    public void setErp_token(String erp_token) {
        this.erp_token = erp_token;
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
