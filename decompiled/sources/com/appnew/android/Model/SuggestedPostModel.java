package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class SuggestedPostModel implements Serializable {
    private String comments;
    private String creation_time;
    private String display_picture;
    private String id;
    private String is_bookmarked;
    private String is_liked;
    private String is_shared;
    private String likes;
    private String parent_id;
    private String pinned_post;
    private Post_data post_data;
    private String post_headline;
    private OwnerInfo post_owner_info;
    private String post_tag;
    private String post_tag_id;
    private String post_type;
    private String report_abuse;
    private String share;
    private String sub_cate_id;
    private ArrayList<OwnerInfo> tagged_people;
    private String user_id;

    public ArrayList<OwnerInfo> getTagged_people() {
        return this.tagged_people;
    }

    public void setTagged_people(ArrayList<OwnerInfo> tagged_people) {
        this.tagged_people = tagged_people;
    }

    public String getPost_tag_id() {
        return this.post_tag_id;
    }

    public OwnerInfo getPost_owner_info() {
        return this.post_owner_info;
    }

    public void setPost_owner_info(OwnerInfo post_owner_info) {
        this.post_owner_info = post_owner_info;
    }

    public String getSub_cate_id() {
        return this.sub_cate_id;
    }

    public void setSub_cate_id(String sub_cate_id) {
        this.sub_cate_id = sub_cate_id;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public String getPinned_post() {
        return this.pinned_post;
    }

    public void setPinned_post(String pinned_post) {
        this.pinned_post = pinned_post;
    }

    public String getDisplay_picture() {
        return this.display_picture;
    }

    public void setDisplay_picture(String display_picture) {
        this.display_picture = display_picture;
    }

    public String getIs_liked() {
        return this.is_liked;
    }

    public void setIs_liked(String is_liked) {
        this.is_liked = is_liked;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost_headline() {
        return this.post_headline;
    }

    public void setPost_headline(String post_headline) {
        this.post_headline = post_headline;
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

    public Post_data getPost_data() {
        return this.post_data;
    }

    public void setPost_data(Post_data post_data) {
        this.post_data = post_data;
    }

    public String getPost_tag() {
        return this.post_tag;
    }

    public void setPost_tag(String post_tag) {
        this.post_tag = post_tag;
    }

    public void setPost_tag_id(String post_tag_id) {
        this.post_tag_id = post_tag_id;
    }

    public String getIs_shared() {
        return this.is_shared;
    }

    public void setIs_shared(String is_shared) {
        this.is_shared = is_shared;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String toString() {
        return "ClassPojo [sub_cate_id = " + this.sub_cate_id + ", is_bookmarked = " + this.is_bookmarked + ", pinned_post = " + this.pinned_post + ", display_picture = " + this.display_picture + ", is_liked = " + this.is_liked + ", id = " + this.id + ", post_headline = " + this.post_headline + ", share = " + this.share + ", report_abuse = " + this.report_abuse + ", likes = " + this.likes + ", creation_time = " + this.creation_time + ", post_type = " + this.post_type + ", user_id = " + this.user_id + ", post_data = " + this.post_data + ", post_tag = " + this.post_tag + ", tagged_people = " + this.tagged_people + ", post_tag_id = " + this.post_tag_id + ", is_shared = " + this.is_shared + ", comments = " + this.comments + ", post_owner_info = " + this.post_owner_info + ", parent_id = " + this.parent_id + Constants.AES_SUFFIX;
    }

    public class Post_data implements Serializable {
        private String id;
        private ArrayList<PostFile> post_file;
        private String post_id;
        private String post_text_type;
        private String text;

        public Post_data() {
        }

        public ArrayList<PostFile> getPost_file() {
            return this.post_file;
        }

        public void setPost_file(ArrayList<PostFile> post_file) {
            this.post_file = post_file;
        }

        public String getPost_text_type() {
            return this.post_text_type;
        }

        public void setPost_text_type(String post_text_type) {
            this.post_text_type = post_text_type;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getPost_id() {
            return this.post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String toString() {
            return "ClassPojo [post_text_type = " + this.post_text_type + ", id = " + this.id + ", text = " + this.text + ", post_id = " + this.post_id + ", post_file = " + this.post_file + Constants.AES_SUFFIX;
        }
    }
}
