package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class AttemptedUserPoll implements Serializable {
    String answer;
    String currentUserID;
    String pollkey;
    SendUserData userData;

    public String getCurrentUserID() {
        return this.currentUserID;
    }

    public void setCurrentUserID(String currentUserID) {
        this.currentUserID = currentUserID;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPollkey() {
        return this.pollkey;
    }

    public void setPollkey(String pollkey) {
        this.pollkey = pollkey;
    }

    public SendUserData getUserData() {
        return this.userData;
    }

    public void setUserData(SendUserData userData) {
        this.userData = userData;
    }

    public AttemptedUserPoll(String answer, String pollkey, SendUserData userData, String currentUserID) {
        this.answer = answer;
        this.pollkey = pollkey;
        this.userData = userData;
        this.currentUserID = currentUserID;
    }
}
