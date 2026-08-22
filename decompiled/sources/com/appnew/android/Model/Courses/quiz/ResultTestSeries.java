package com.appnew.android.Model.Courses.quiz;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ResultTestSeries implements Serializable {
    private String correct_count;
    private String creation_time;
    private String id;
    private String image;
    private String incorrect_count;
    private String marks;
    private String non_attempt;
    private String question_dump;
    private String result;
    private String reward_points;
    private String skip_rank;
    private String test_series_id;
    private String test_series_marks;
    private String test_series_name;
    private String test_type;
    private String time_spent;
    private ArrayList<LeaderBoardUserModel> top_list;
    private ArrayList<LeaderBoardUserModel> top_ten_list;
    private String total_test_series_time;
    private String total_user_attempt;
    private String user_id;
    private String user_rank;

    public ArrayList<LeaderBoardUserModel> getTop_list() {
        return this.top_list;
    }

    public void setTop_list(ArrayList<LeaderBoardUserModel> top_list) {
        this.top_list = top_list;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSkip_rank() {
        return this.skip_rank;
    }

    public void setSkip_rank(String skip_rank) {
        this.skip_rank = skip_rank;
    }

    public ArrayList<LeaderBoardUserModel> getTop_ten_list() {
        return this.top_ten_list;
    }

    public void setTop_ten_list(ArrayList<LeaderBoardUserModel> top_ten_list) {
        this.top_ten_list = top_ten_list;
    }

    public String getTest_type() {
        return this.test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public String getTest_series_name() {
        return this.test_series_name;
    }

    public void setTest_series_name(String test_series_name) {
        this.test_series_name = test_series_name;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNon_attempt() {
        return this.non_attempt;
    }

    public void setNon_attempt(String non_attempt) {
        this.non_attempt = non_attempt;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getTotal_user_attempt() {
        return this.total_user_attempt;
    }

    public void setTotal_user_attempt(String total_user_attempt) {
        this.total_user_attempt = total_user_attempt;
    }

    public String getTotal_test_series_time() {
        return this.total_test_series_time;
    }

    public void setTotal_test_series_time(String total_test_series_time) {
        this.total_test_series_time = total_test_series_time;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIncorrect_count() {
        return this.incorrect_count;
    }

    public void setIncorrect_count(String incorrect_count) {
        this.incorrect_count = incorrect_count;
    }

    public String getQuestion_dump() {
        return this.question_dump;
    }

    public void setQuestion_dump(String question_dump) {
        this.question_dump = question_dump;
    }

    public String getTest_series_id() {
        return this.test_series_id;
    }

    public void setTest_series_id(String test_series_id) {
        this.test_series_id = test_series_id;
    }

    public String getTime_spent() {
        return this.time_spent;
    }

    public void setTime_spent(String time_spent) {
        this.time_spent = time_spent;
    }

    public String getUser_rank() {
        return this.user_rank;
    }

    public void setUser_rank(String user_rank) {
        this.user_rank = user_rank;
    }

    public String getReward_points() {
        return this.reward_points;
    }

    public void setReward_points(String reward_points) {
        this.reward_points = reward_points;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCorrect_count() {
        return this.correct_count;
    }

    public void setCorrect_count(String correct_count) {
        this.correct_count = correct_count;
    }

    public String getTest_series_marks() {
        return this.test_series_marks;
    }

    public void setTest_series_marks(String test_series_marks) {
        this.test_series_marks = test_series_marks;
    }
}
