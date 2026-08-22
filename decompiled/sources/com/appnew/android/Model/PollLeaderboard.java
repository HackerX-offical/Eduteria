package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PollLeaderboard implements Serializable {
    String name;
    String poll_id;
    String rank;
    String timetaken;
    String user_id;
    String correct_count = this.correct_count;
    String correct_count = this.correct_count;

    public PollLeaderboard(String name, String timetaken, String user_id, String rank) {
        this.name = name;
        this.timetaken = timetaken;
        this.user_id = user_id;
        this.rank = rank;
    }

    public String getCorrect_count() {
        return this.correct_count;
    }

    public void setCorrect_count(String correct_count) {
        this.correct_count = correct_count;
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimetaken() {
        return this.timetaken;
    }

    public void setTimetaken(String timetaken) {
        this.timetaken = timetaken;
    }

    public String getPoll_id() {
        return this.poll_id;
    }

    public void setPoll_id(String poll_id) {
        this.poll_id = poll_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
