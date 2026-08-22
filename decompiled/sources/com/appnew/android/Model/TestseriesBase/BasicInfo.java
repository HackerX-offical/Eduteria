package com.appnew.android.Model.TestseriesBase;

import com.appnew.android.Utils.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* JADX INFO: loaded from: classes6.dex */
public class BasicInfo implements Serializable {

    @SerializedName("allow_duplicate_rank")
    @Expose
    private String allowDuplicateRank;

    @SerializedName("allow_user_move")
    @Expose
    private String allowUserMove;

    @SerializedName("answer_shuffle")
    @Expose
    private String answerShuffle;

    @SerializedName("backend_user_id")
    @Expose
    private String backendUserId;

    @SerializedName("bookmark_count")
    @Expose
    private String bookmark_count;

    @SerializedName("consider_time")
    @Expose
    private String considerTime;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("difficulty_level")
    @Expose
    private String difficultyLevel;

    @SerializedName("display_reattempt")
    @Expose
    private String displayReattempt;

    @SerializedName("display_v_solution")
    @Expose
    private String displayVSolution;

    @SerializedName("display_bookmark")
    @Expose
    private String display_bookmark;
    private String display_bubble;
    private String display_qid;

    @SerializedName(FirebaseAnalytics.Param.END_DATE)
    @Expose
    private String endDate;

    @SerializedName(SDKConstants.PARAM_TOURNAMENTS_END_TIME)
    @Expose
    private String endTime;

    @SerializedName("fail_message")
    @Expose
    private String failMessage;

    @SerializedName("general_message")
    @Expose
    private String generalMessage;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("instruction")
    @Expose
    private String instruction;

    @SerializedName("is_vod")
    @Expose
    private String isVod;

    @SerializedName("mandatory_check")
    @Expose
    private String mandatoryCheck;

    @SerializedName("marking_scheme")
    @Expose
    private String markingScheme;

    @SerializedName("marks_per_question")
    @Expose
    private String marksPerQuestion;

    @SerializedName("negative_marking")
    @Expose
    private String negativeMarking;

    @SerializedName("pass_message")
    @Expose
    private String passMessage;

    @SerializedName("pass_percentage")
    @Expose
    private String passPercentage;

    @SerializedName("publish")
    @Expose
    private String publish;

    @SerializedName("reward_points")
    @Expose
    private String rewardPoints;

    @SerializedName(Session.ELEMENT)
    @Expose
    private String session;

    @SerializedName("set_type")
    @Expose
    private String setType;

    @SerializedName("show_question_time")
    @Expose
    private String showQuestionTime;

    @SerializedName("shuffle")
    @Expose
    private String shuffle;

    @SerializedName("skip_rank")
    @Expose
    private String skipRank;

    @SerializedName(FirebaseAnalytics.Param.START_DATE)
    @Expose
    private String startDate;

    @SerializedName("start_time")
    @Expose
    private String startTime;

    @SerializedName("subject")
    @Expose
    private String subject;

    @SerializedName("subject_name")
    @Expose
    private String subject_name;

    @SerializedName("template_html")
    @Expose
    private String templateHtml;

    @SerializedName("test_end_date")
    @Expose
    private String testEndDate;

    @SerializedName("test_price")
    @Expose
    private String testPrice;

    @SerializedName("test_result_date")
    @Expose
    private String testResultDate;

    @SerializedName("test_series_name")
    @Expose
    private String testSeriesName;

    @SerializedName("test_start_date")
    @Expose
    private String testStartDate;

    @SerializedName(Const.TEST_TYPE)
    @Expose
    private String testType;

    @SerializedName("test_type_master")
    @Expose
    private String testTypeMaster;

    @SerializedName("time_boundation")
    @Expose
    private String timeBoundation;

    @SerializedName("time_in_mins")
    @Expose
    private String timeInMins;

    @SerializedName("total_marks")
    @Expose
    private String totalMarks;

    @SerializedName("total_questions")
    @Expose
    private String totalQuestions;

    @SerializedName("video_solution")
    @Expose
    private String videoSolution;

    @SerializedName("parts")
    @Expose
    private List<Part> parts = null;

    @SerializedName(DataLayout.Section.ELEMENT)
    @Expose
    private List<Section> section = null;
    private long timeRemaining = 0;

    public long getTimeRemaining() {
        return this.timeRemaining;
    }

    public void setTimeRemaining(long timeRemaining) {
        this.timeRemaining = timeRemaining;
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

    public String getTestSeriesName() {
        return this.testSeriesName;
    }

    public void setTestSeriesName(String testSeriesName) {
        this.testSeriesName = testSeriesName;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getTestPrice() {
        return this.testPrice;
    }

    public void setTestPrice(String testPrice) {
        this.testPrice = testPrice;
    }

    public String getTestType() {
        return this.testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getBackendUserId() {
        return this.backendUserId;
    }

    public void setBackendUserId(String backendUserId) {
        this.backendUserId = backendUserId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTotalQuestions() {
        return this.totalQuestions;
    }

    public void setTotalQuestions(String totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getConsiderTime() {
        return this.considerTime;
    }

    public void setConsiderTime(String considerTime) {
        this.considerTime = considerTime;
    }

    public String getTimeInMins() {
        return this.timeInMins;
    }

    public void setTimeInMins(String timeInMins) {
        this.timeInMins = timeInMins;
    }

    public String getNegativeMarking() {
        return this.negativeMarking;
    }

    public void setNegativeMarking(String negativeMarking) {
        this.negativeMarking = negativeMarking;
    }

    public String getTotalMarks() {
        return this.totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getMarksPerQuestion() {
        return this.marksPerQuestion;
    }

    public void setMarksPerQuestion(String marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }

    public String getShuffle() {
        return this.shuffle;
    }

    public void setShuffle(String shuffle) {
        this.shuffle = shuffle;
    }

    public String getAnswerShuffle() {
        return this.answerShuffle;
    }

    public void setAnswerShuffle(String answerShuffle) {
        this.answerShuffle = answerShuffle;
    }

    public String getMandatoryCheck() {
        return this.mandatoryCheck;
    }

    public void setMandatoryCheck(String mandatoryCheck) {
        this.mandatoryCheck = mandatoryCheck;
    }

    public String getAllowUserMove() {
        return this.allowUserMove;
    }

    public void setAllowUserMove(String allowUserMove) {
        this.allowUserMove = allowUserMove;
    }

    public String getTimeBoundation() {
        return this.timeBoundation;
    }

    public void setTimeBoundation(String timeBoundation) {
        this.timeBoundation = timeBoundation;
    }

    public String getShowQuestionTime() {
        return this.showQuestionTime;
    }

    public void setShowQuestionTime(String showQuestionTime) {
        this.showQuestionTime = showQuestionTime;
    }

    public String getPassMessage() {
        return this.passMessage;
    }

    public void setPassMessage(String passMessage) {
        this.passMessage = passMessage;
    }

    public String getGeneralMessage() {
        return this.generalMessage;
    }

    public void setGeneralMessage(String generalMessage) {
        this.generalMessage = generalMessage;
    }

    public String getFailMessage() {
        return this.failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    public String getPassPercentage() {
        return this.passPercentage;
    }

    public void setPassPercentage(String passPercentage) {
        this.passPercentage = passPercentage;
    }

    public String getAllowDuplicateRank() {
        return this.allowDuplicateRank;
    }

    public void setAllowDuplicateRank(String allowDuplicateRank) {
        this.allowDuplicateRank = allowDuplicateRank;
    }

    public String getSkipRank() {
        return this.skipRank;
    }

    public void setSkipRank(String skipRank) {
        this.skipRank = skipRank;
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

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPublish() {
        return this.publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getRewardPoints() {
        return this.rewardPoints;
    }

    public void setRewardPoints(String rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getSetType() {
        return this.setType;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public String getTestTypeMaster() {
        return this.testTypeMaster;
    }

    public void setTestTypeMaster(String testTypeMaster) {
        this.testTypeMaster = testTypeMaster;
    }

    public String getTestStartDate() {
        return this.testStartDate;
    }

    public void setTestStartDate(String testStartDate) {
        this.testStartDate = testStartDate;
    }

    public String getTestEndDate() {
        return this.testEndDate;
    }

    public void setTestEndDate(String testEndDate) {
        this.testEndDate = testEndDate;
    }

    public String getTestResultDate() {
        return this.testResultDate;
    }

    public void setTestResultDate(String testResultDate) {
        this.testResultDate = testResultDate;
    }

    public String getVideoSolution() {
        return this.videoSolution;
    }

    public void setVideoSolution(String videoSolution) {
        this.videoSolution = videoSolution;
    }

    public String getIsVod() {
        return this.isVod;
    }

    public void setIsVod(String isVod) {
        this.isVod = isVod;
    }

    public String getMarkingScheme() {
        return this.markingScheme;
    }

    public void setMarkingScheme(String markingScheme) {
        this.markingScheme = markingScheme;
    }

    public String getDisplayVSolution() {
        return this.displayVSolution;
    }

    public void setDisplayVSolution(String displayVSolution) {
        this.displayVSolution = displayVSolution;
    }

    public String getDisplayReattempt() {
        return this.displayReattempt;
    }

    public void setDisplayReattempt(String displayReattempt) {
        this.displayReattempt = displayReattempt;
    }

    public String getTemplateHtml() {
        return this.templateHtml;
    }

    public void setTemplateHtml(String templateHtml) {
        this.templateHtml = templateHtml;
    }

    public List<Part> getParts() {
        return this.parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public List<Section> getSection() {
        return this.section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    public String getDisplay_qid() {
        return this.display_qid;
    }

    public void setDisplay_qid(String display_qid) {
        this.display_qid = display_qid;
    }

    public String getDisplay_bubble() {
        return this.display_bubble;
    }

    public void setDisplay_bubble(String display_bubble) {
        this.display_bubble = display_bubble;
    }

    public String getSubject_name() {
        return this.subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getBookmark_count() {
        return this.bookmark_count;
    }

    public void setBookmark_count(String bookmark_count) {
        this.bookmark_count = bookmark_count;
    }

    public String getDisplay_bookmark() {
        return this.display_bookmark;
    }

    public void setDisplay_bookmark(String display_bookmark) {
        this.display_bookmark = display_bookmark;
    }
}
