package com.appnew.android.home.livetest;

import android.widget.TextView;
import com.appnew.android.Utils.Const;
import com.appnew.android.home.liveclasses.PayloadData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes6.dex */
public class LiveTestData implements Serializable {

    @SerializedName(Const.ANSWERS)
    @Expose
    private String answers;

    @SerializedName("answers_by_student")
    @Expose
    private String answersByStudent;

    @SerializedName("attempt")
    @Expose
    private String attempt;

    @SerializedName("attempt_limit")
    @Expose
    private String attempt_limit;

    @SerializedName("cat_type")
    @Expose
    private String cat_type;
    private long cd_time;

    @SerializedName("correct_count")
    @Expose
    private String correctCount;

    @SerializedName("course_id")
    @Expose
    private String courseId;

    @SerializedName(AnalyticsConstants.course_name)
    @Expose
    private String course_name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description_2")
    @Expose
    private String description2;

    @SerializedName(FirebaseAnalytics.Param.END_DATE)
    @Expose
    private String endDate;

    @SerializedName("file_type")
    @Expose
    private String file_type;

    @SerializedName("first_attempt")
    @Expose
    private String first_attempt;

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
    private String isLocked;

    @SerializedName("is_bookmarked")
    @Expose
    private String is_bookmarked;

    @SerializedName(Const.IS_REATTEMPT)
    @Expose
    private String is_reattempt;

    @SerializedName("is_test_purchased")
    @Expose
    private String is_test_purchased;

    @SerializedName("lang_id")
    @Expose
    private String langId;

    @SerializedName(Const.LANG_USED)
    @Expose
    private String langUsed;

    @SerializedName("marks")
    @Expose
    private String marks;

    @SerializedName("mode")
    @Expose
    private String mode;

    @SerializedName("payload")
    @Expose
    private PayloadData payload;

    @SerializedName(Const.QUESTION)
    @Expose
    private String question;

    @SerializedName("report_id")
    @Expose
    private String reportId;

    @SerializedName("result_date")
    @Expose
    private String resultDate;

    @SerializedName("result_status")
    @Expose
    private String result_status;

    @SerializedName("set_type")
    @Expose
    private String setType;

    @SerializedName("solutions")
    @Expose
    private String solutions;

    @SerializedName(FirebaseAnalytics.Param.START_DATE)
    @Expose
    private String startDate;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("submission_type")
    @Expose
    private String submission_type;

    @SerializedName("test_code")
    @Expose
    private String testCode;

    @SerializedName("test_series_name")
    @Expose
    private String testSeriesName;

    @SerializedName(Const.TEST_TYPE)
    @Expose
    private String testType;

    @SerializedName("test_pattern")
    @Expose
    private String test_pattern;

    @SerializedName("time_in_mins")
    @Expose
    private String timeInMins;

    @SerializedName("total_marks")
    @Expose
    private String totalMarks;

    @SerializedName("total_questions")
    @Expose
    private String totalQuestions;

    @SerializedName("upload_allowed")
    @Expose
    private String upload_allowed;

    public String getCourse_name() {
        return this.course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getFirst_attempt() {
        return this.first_attempt;
    }

    public void setFirst_attempt(String first_attempt) {
        this.first_attempt = first_attempt;
    }

    public String getIs_test_purchased() {
        return this.is_test_purchased;
    }

    public void setIs_test_purchased(String is_test_purchased) {
        this.is_test_purchased = is_test_purchased;
    }

    public String getCat_type() {
        return this.cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIs_reattempt() {
        return this.is_reattempt;
    }

    public void setIs_reattempt(String is_reattempt) {
        this.is_reattempt = is_reattempt;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription2() {
        return this.description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getTestSeriesName() {
        return this.testSeriesName;
    }

    public void setTestSeriesName(String testSeriesName) {
        this.testSeriesName = testSeriesName;
    }

    public String getTestCode() {
        return this.testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    public String getTestType() {
        return this.testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getSetType() {
        return this.setType;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public String getTotalMarks() {
        return this.totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLangId() {
        return this.langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getIsLocked() {
        return this.isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public String getTotalQuestions() {
        return this.totalQuestions;
    }

    public void setTotalQuestions(String totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getTimeInMins() {
        return this.timeInMins;
    }

    public void setTimeInMins(String timeInMins) {
        this.timeInMins = timeInMins;
    }

    public String getReportId() {
        return this.reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getResultDate() {
        return this.resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public PayloadData getPayload() {
        return this.payload;
    }

    public void setPayload(PayloadData payload) {
        this.payload = payload;
    }

    public String getSubmission_type() {
        return this.submission_type;
    }

    public void setSubmission_type(String submission_type) {
        this.submission_type = submission_type;
    }

    public String getFile_type() {
        return this.file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getAnswers() {
        return this.answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSolutions() {
        return this.solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }

    public String getAttempt() {
        return this.attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public String getResult_status() {
        return this.result_status;
    }

    public void setResult_status(String result_status) {
        this.result_status = result_status;
    }

    public String getAttempt_limit() {
        return this.attempt_limit;
    }

    public void setAttempt_limit(String attempt_limit) {
        this.attempt_limit = attempt_limit;
    }

    public String getTest_pattern() {
        return this.test_pattern;
    }

    public void setTest_pattern(String test_pattern) {
        this.test_pattern = test_pattern;
    }

    public long getCd_time() {
        return this.cd_time;
    }

    public void setCd_time(long cd_time) {
        this.cd_time = cd_time;
    }

    public String getAnswersByStudent() {
        return this.answersByStudent;
    }

    public void setAnswersByStudent(String answersByStudent) {
        this.answersByStudent = answersByStudent;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public String getUpload_allowed() {
        return this.upload_allowed;
    }

    public void setUpload_allowed(String upload_allowed) {
        this.upload_allowed = upload_allowed;
    }

    public static void time(TextView textView, LiveTestData liveTestData) {
        textView.setText(getDate(Long.parseLong(liveTestData.getStartDate()) * 1000, "dd-MMM-yyyy hh:mm a") + " - " + getDate(Long.parseLong(liveTestData.getEndDate()) * 1000, "dd-MMM-yyyy hh:mm a"));
    }

    private static String getDate(long start_msecond, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(start_msecond);
        return simpleDateFormat.format(calendar.getTime());
    }
}
