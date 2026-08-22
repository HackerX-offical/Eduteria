package com.appnew.android.table;

/* JADX INFO: loaded from: classes6.dex */
public class PollDataTable {
    private String firebase_node;
    private int id;
    private String poll_answer;
    private String poll_id;
    private String user_id;

    public String getFirebase_node() {
        return this.firebase_node;
    }

    public void setFirebase_node(String firebase_node) {
        this.firebase_node = firebase_node;
    }

    public String getPoll_id() {
        return this.poll_id;
    }

    public void setPoll_id(String poll_id) {
        this.poll_id = poll_id;
    }

    public String getPoll_answer() {
        return this.poll_answer;
    }

    public void setPoll_answer(String poll_answer) {
        this.poll_answer = poll_answer;
    }

    public PollDataTable(String user_id, String poll_id, String poll_answer, String firebase_node) {
        this.user_id = user_id;
        this.poll_id = poll_id;
        this.poll_answer = poll_answer;
        this.firebase_node = firebase_node;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
