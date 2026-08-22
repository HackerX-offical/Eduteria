package com.appnew.android.Response.ParentResponse;

import com.appnew.android.Model.OwnerInfo;
import com.appnew.android.Model.People;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class PostParentResponse extends ParentResponse implements Serializable {
    private String comments;
    private String creation_time;
    private String description;
    private String hlslink;
    private String id;
    private boolean is_bookmarked;
    private boolean is_liked;
    private String is_shared;
    private String likes;
    private String name;
    private String parent_id;
    private String pinned_post;
    OwnerInfo post_owner_info;
    private String post_tag;
    private String post_tag_id;
    private String post_type;
    private String report_abuse;
    private String segment_type = "";
    private String share;
    private String sub_title;
    ArrayList<People> tagged_people;
    private String thumbnail_url;
    private String title;
    private String user_id;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return this.sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getSegment_type() {
        return this.segment_type;
    }

    public void setSegment_type(String segment_type) {
        this.segment_type = segment_type;
    }

    public String getPinned_post() {
        return this.pinned_post;
    }

    public void setPinned_post(String pinned_post) {
        this.pinned_post = pinned_post;
    }

    public String getPost_tag_id() {
        return this.post_tag_id;
    }

    public void setPost_tag_id(String post_tag_id) {
        this.post_tag_id = post_tag_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHlslink() {
        return this.hlslink;
    }

    public void setHlslink(String hlslink) {
        this.hlslink = hlslink;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getPost_tag() {
        return this.post_tag;
    }

    public void setPost_tag(String post_tag) {
        this.post_tag = post_tag;
    }

    public ArrayList<People> getTagged_people() {
        return this.tagged_people;
    }

    public void setTagged_people(ArrayList<People> tagged_people) {
        this.tagged_people = tagged_people;
    }

    public boolean is_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(boolean is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public String getIs_shared() {
        return this.is_shared;
    }

    public void setIs_shared(String is_shared) {
        this.is_shared = is_shared;
    }

    public boolean isLiked() {
        return this.is_liked;
    }

    public void setLiked(boolean liked) {
        this.is_liked = liked;
    }

    public OwnerInfo getPost_owner_info() {
        return this.post_owner_info;
    }

    public void setPost_owner_info(OwnerInfo post_owner_info) {
        this.post_owner_info = post_owner_info;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShare() {
        return this.share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getReport_abuse() {
        return this.report_abuse;
    }

    public void setReport_abuse(String report_abuse) {
        this.report_abuse = report_abuse;
    }

    public String getLikes() {
        return this.likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getPost_type() {
        return this.post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public class PostSharedOf implements Serializable {
        private String id;
        private String name;

        public PostSharedOf() {
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
    }
}
