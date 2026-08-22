package com.appnew.android.Model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Comment implements Serializable {
    private String comment;
    private String id;
    private String name;
    private String parent_id;
    private String post_id;
    private String profile_picture;
    private String sub_comment_count;
    private ArrayList<People> tagged_people;
    private String time;
    private String user_id;

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getSub_comment_count() {
        return this.sub_comment_count;
    }

    public void setSub_comment_count(String sub_comment_count) {
        this.sub_comment_count = sub_comment_count;
    }

    public ArrayList<People> getTagged_people() {
        return this.tagged_people;
    }

    public void setTagged_people(ArrayList<People> tagged_people) {
        this.tagged_people = tagged_people;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }
}
