package com.appnew.android.Model.Courses.quiz;

import com.appnew.android.Utils.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.jivesoftware.smack.packet.Session;

/* JADX INFO: loaded from: classes6.dex */
public class Quiz_Basic_Info implements Serializable {

    @SerializedName("allow_duplicate_rank")
    @Expose
    private String allow_duplicate_rank;

    @SerializedName("allow_user_move")
    @Expose
    private String allow_user_move;

    @SerializedName("answer_shuffle")
    @Expose
    private String answer_shuffle;

    @SerializedName("consider_time")
    @Expose
    private String consider_time;

    @SerializedName("correct_count")
    @Expose
    private String correctCount;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description_2")
    @Expose
    private String description_2;

    @SerializedName("difficulty_level")
    @Expose
    private String difficulty_level;

    @SerializedName(FirebaseAnalytics.Param.END_DATE)
    @Expose
    private String end_date;

    @SerializedName(SDKConstants.PARAM_TOURNAMENTS_END_TIME)
    @Expose
    private String end_time;

    @SerializedName("fail_message")
    @Expose
    private String fail_message;

    @SerializedName("general_message")
    @Expose
    private String general_message;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("incorrect_count")
    @Expose
    private String incorrectCount;

    @SerializedName("is_locked")
    @Expose
    private String is_locked;

    @SerializedName(Const.LANG_USED)
    @Expose
    private String langUsed;

    @SerializedName("lang_id")
    @Expose
    private String lang_id;

    @SerializedName("mandatory_check")
    @Expose
    private String mandatory_check;

    @SerializedName("marks")
    @Expose
    private String marks;

    @SerializedName("marks_per_question")
    @Expose
    private String marks_per_question;

    @SerializedName("negative_marking")
    @Expose
    private String negative_marking;

    @SerializedName("no_of_subjects")
    @Expose
    private String no_of_subjects;

    @SerializedName("pass_message")
    @Expose
    private String pass_message;

    @SerializedName("pass_percentage")
    @Expose
    private String pass_percentage;

    @SerializedName("report_id")
    @Expose
    private String report_id;

    @SerializedName(Session.ELEMENT)
    @Expose
    private String session;

    @SerializedName("set_type")
    @Expose
    private String set_type;

    @SerializedName("show_question_time")
    @Expose
    private String show_question_time;

    @SerializedName("shuffle")
    @Expose
    private String shuffle;

    @SerializedName("skip_rank")
    @Expose
    private String skip_rank;

    @SerializedName(FirebaseAnalytics.Param.START_DATE)
    @Expose
    private String start_date;

    @SerializedName("start_time")
    @Expose
    private String start_time;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("subject")
    @Expose
    private String subject;

    @SerializedName("test_code")
    @Expose
    private String test_code;

    @SerializedName("test_price")
    @Expose
    private String test_price;

    @SerializedName(Const.TESTSEGMENT_ID)
    @Expose
    private String test_segment_id;

    @SerializedName("test_series_name")
    @Expose
    private String test_series_name;

    @SerializedName(Const.TEST_TYPE)
    @Expose
    private String test_type;

    @SerializedName("time_boundation")
    @Expose
    private String time_boundation;

    @SerializedName("time_in_mins")
    @Expose
    private String time_in_mins;

    @SerializedName("total_marks")
    @Expose
    private String total_marks;

    @SerializedName("total_questions")
    @Expose
    private String total_questions;

    public String getSet_type() {
        return this.set_type;
    }

    public void setSet_type(String set_type) {
        this.set_type = set_type;
    }

    public String getReport_id() {
        return this.report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIs_locked() {
        return this.is_locked;
    }

    public void setIs_locked(String is_locked) {
        this.is_locked = is_locked;
    }

    public String getNo_of_subjects() {
        return this.no_of_subjects;
    }

    public void setNo_of_subjects(String no_of_subjects) {
        this.no_of_subjects = no_of_subjects;
    }

    public String getLang_id() {
        return this.lang_id;
    }

    public void setLang_id(String lang_id) {
        this.lang_id = lang_id;
    }

    public String getPass_percentage() {
        return this.pass_percentage;
    }

    public void setPass_percentage(String pass_percentage) {
        this.pass_percentage = pass_percentage;
    }

    public String getTest_series_name() {
        return this.test_series_name;
    }

    public void setTest_series_name(String test_series_name) {
        this.test_series_name = test_series_name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNegative_marking() {
        return this.negative_marking;
    }

    public void setNegative_marking(String negative_marking) {
        this.negative_marking = negative_marking;
    }

    public String getTest_type() {
        return this.test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getAllow_duplicate_rank() {
        return this.allow_duplicate_rank;
    }

    public void setAllow_duplicate_rank(String allow_duplicate_rank) {
        this.allow_duplicate_rank = allow_duplicate_rank;
    }

    public String getDifficulty_level() {
        return this.difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public String getMarks_per_question() {
        return this.marks_per_question;
    }

    public void setMarks_per_question(String marks_per_question) {
        this.marks_per_question = marks_per_question;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_2() {
        return this.description_2;
    }

    public void setDescription_2(String description_2) {
        this.description_2 = description_2;
    }

    public String getTest_code() {
        return this.test_code;
    }

    public void setTest_code(String test_code) {
        this.test_code = test_code;
    }

    public String getSkip_rank() {
        return this.skip_rank;
    }

    public void setSkip_rank(String skip_rank) {
        this.skip_rank = skip_rank;
    }

    public String getShow_question_time() {
        return this.show_question_time;
    }

    public void setShow_question_time(String show_question_time) {
        this.show_question_time = show_question_time;
    }

    public String getTime_in_mins() {
        return this.time_in_mins;
    }

    public void setTime_in_mins(String time_in_mins) {
        this.time_in_mins = time_in_mins;
    }

    public String getTest_price() {
        return this.test_price;
    }

    public void setTest_price(String test_price) {
        this.test_price = test_price;
    }

    public String getMandatory_check() {
        return this.mandatory_check;
    }

    public void setMandatory_check(String mandatory_check) {
        this.mandatory_check = mandatory_check;
    }

    public String getGeneral_message() {
        return this.general_message;
    }

    public void setGeneral_message(String general_message) {
        this.general_message = general_message;
    }

    public String getFail_message() {
        return this.fail_message;
    }

    public void setFail_message(String fail_message) {
        this.fail_message = fail_message;
    }

    public String getAnswer_shuffle() {
        return this.answer_shuffle;
    }

    public void setAnswer_shuffle(String answer_shuffle) {
        this.answer_shuffle = answer_shuffle;
    }

    public String getTime_boundation() {
        return this.time_boundation;
    }

    public void setTime_boundation(String time_boundation) {
        this.time_boundation = time_boundation;
    }

    public String getConsider_time() {
        return this.consider_time;
    }

    public void setConsider_time(String consider_time) {
        this.consider_time = consider_time;
    }

    public String getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPass_message() {
        return this.pass_message;
    }

    public void setPass_message(String pass_message) {
        this.pass_message = pass_message;
    }

    public String getShuffle() {
        return this.shuffle;
    }

    public void setShuffle(String shuffle) {
        this.shuffle = shuffle;
    }

    public String getStart_time() {
        return this.start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getAllow_user_move() {
        return this.allow_user_move;
    }

    public void setAllow_user_move(String allow_user_move) {
        this.allow_user_move = allow_user_move;
    }

    public String getStart_date() {
        return this.start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getTotal_questions() {
        return this.total_questions;
    }

    public void setTotal_questions(String total_questions) {
        this.total_questions = total_questions;
    }

    public String getTotal_marks() {
        return this.total_marks;
    }

    public void setTotal_marks(String total_marks) {
        this.total_marks = total_marks;
    }

    public String getTest_segment_id() {
        return this.test_segment_id;
    }

    public void setTest_segment_id(String test_segment_id) {
        this.test_segment_id = test_segment_id;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCorrectCount() {
        return this.correctCount;
    }

    public void setCorrectCount(String correctCount) {
        this.correctCount = correctCount;
    }

    public String getIncorrectCount() {
        return this.incorrectCount;
    }

    public void setIncorrectCount(String incorrectCount) {
        this.incorrectCount = incorrectCount;
    }

    public String getLangUsed() {
        return this.langUsed;
    }

    public void setLangUsed(String langUsed) {
        this.langUsed = langUsed;
    }
}
