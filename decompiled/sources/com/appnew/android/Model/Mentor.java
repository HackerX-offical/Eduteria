package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Mentor implements Serializable {
    private String get_comment;
    private String get_comment_target;
    private String get_follow;
    private String get_follow_target;
    private String get_like;
    private String get_like_target;
    private String get_queries;
    private String get_queries_target;

    public String getGet_like_target() {
        return this.get_like_target;
    }

    public void setGet_like_target(String get_like_target) {
        this.get_like_target = get_like_target;
    }

    public String getGet_comment_target() {
        return this.get_comment_target;
    }

    public void setGet_comment_target(String get_comment_target) {
        this.get_comment_target = get_comment_target;
    }

    public String getGet_queries_target() {
        return this.get_queries_target;
    }

    public void setGet_queries_target(String get_queries_target) {
        this.get_queries_target = get_queries_target;
    }

    public String getGet_follow_target() {
        return this.get_follow_target;
    }

    public void setGet_follow_target(String get_follow_target) {
        this.get_follow_target = get_follow_target;
    }

    public String getGet_comment() {
        return this.get_comment;
    }

    public void setGet_comment(String get_comment) {
        this.get_comment = get_comment;
    }

    public String getGet_follow() {
        return this.get_follow;
    }

    public void setGet_follow(String get_follow) {
        this.get_follow = get_follow;
    }

    public String getGet_queries() {
        return this.get_queries;
    }

    public void setGet_queries(String get_queries) {
        this.get_queries = get_queries;
    }

    public String getGet_like() {
        return this.get_like;
    }

    public void setGet_like(String get_like) {
        this.get_like = get_like;
    }

    public String toString() {
        return "ClassPojo [get_comment = " + this.get_comment + ", get_follow = " + this.get_follow + ", get_queries = " + this.get_queries + ", get_like = " + this.get_like + Constants.AES_SUFFIX;
    }
}
