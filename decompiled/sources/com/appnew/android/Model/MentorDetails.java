package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class MentorDetails implements Serializable {
    private String getComment;
    private String getCommentTarget;
    private String getFollow;
    private String getFollowTarget;
    private String getLike;
    private String getLikeTarget;
    private String getQueries;
    private String getQueriesTarget;

    public String getGetLike() {
        return this.getLike;
    }

    public void setGetLike(String getLike) {
        this.getLike = getLike;
    }

    public String getGetComment() {
        return this.getComment;
    }

    public void setGetComment(String getComment) {
        this.getComment = getComment;
    }

    public String getGetFollow() {
        return this.getFollow;
    }

    public void setGetFollow(String getFollow) {
        this.getFollow = getFollow;
    }

    public String getGetQueries() {
        return this.getQueries;
    }

    public void setGetQueries(String getQueries) {
        this.getQueries = getQueries;
    }

    public String getGetLikeTarget() {
        return this.getLikeTarget;
    }

    public void setGetLikeTarget(String getLikeTarget) {
        this.getLikeTarget = getLikeTarget;
    }

    public String getGetCommentTarget() {
        return this.getCommentTarget;
    }

    public void setGetCommentTarget(String getCommentTarget) {
        this.getCommentTarget = getCommentTarget;
    }

    public String getGetQueriesTarget() {
        return this.getQueriesTarget;
    }

    public void setGetQueriesTarget(String getQueriesTarget) {
        this.getQueriesTarget = getQueriesTarget;
    }

    public String getGetFollowTarget() {
        return this.getFollowTarget;
    }

    public void setGetFollowTarget(String getFollowTarget) {
        this.getFollowTarget = getFollowTarget;
    }
}
