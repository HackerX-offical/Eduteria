package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PostMCQ implements Serializable {
    static PostMCQ postMCQ;
    private String answer_five;
    private String answer_four;
    private String answer_one;
    private String answer_three;
    private String answer_two;
    private String post_id;
    private String question;
    private String right_answer;
    private String user_id;

    public static PostMCQ newInstance() {
        PostMCQ postMCQ2 = new PostMCQ();
        postMCQ = postMCQ2;
        return postMCQ2;
    }

    public static PostMCQ getInstance() {
        if (postMCQ == null) {
            postMCQ = new PostMCQ();
        }
        return postMCQ;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getAnswer_one() {
        return this.answer_one;
    }

    public void setAnswer_one(String answer_one) {
        this.answer_one = answer_one;
    }

    public String getRight_answer() {
        return this.right_answer;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }

    public String getAnswer_four() {
        return this.answer_four;
    }

    public void setAnswer_four(String answer_four) {
        this.answer_four = answer_four;
    }

    public String getAnswer_two() {
        return this.answer_two;
    }

    public void setAnswer_two(String answer_two) {
        this.answer_two = answer_two;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_five() {
        return this.answer_five;
    }

    public void setAnswer_five(String answer_five) {
        this.answer_five = answer_five;
    }

    public String getAnswer_three() {
        return this.answer_three;
    }

    public void setAnswer_three(String answer_three) {
        this.answer_three = answer_three;
    }
}
