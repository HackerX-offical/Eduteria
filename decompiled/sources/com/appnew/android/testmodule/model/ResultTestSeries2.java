package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import org.jivesoftware.smack.packet.Session;

/* JADX INFO: loaded from: classes6.dex */
public class ResultTestSeries2 implements Serializable {

    @SerializedName("allow_duplicate_rank")
    @Expose
    private String allowDuplicateRank;

    @SerializedName("answer_shuffle")
    @Expose
    private String answerShuffle;

    @SerializedName("avg_score")
    @Expose
    private String avgScore;

    @SerializedName("backend_user_id")
    @Expose
    private String backendUserId;

    @SerializedName("best_score")
    @Expose
    private String bestScore;

    @SerializedName(Const.CHAPTER_ID)
    @Expose
    private String chapterId;

    @SerializedName("correct_count")
    @Expose
    private String correctCount;

    @SerializedName("cutoff")
    @Expose
    private String cutoff;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("difficulty_level")
    @Expose
    private String difficultyLevel;

    @SerializedName(FirebaseAnalytics.Param.END_DATE)
    @Expose
    private String endDate;

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

    @SerializedName("incorrect_count")
    @Expose
    private String incorrectCount;

    @SerializedName("is_calc_allowed")
    @Expose
    private String isCalcAllowed;

    @SerializedName(Const.IS_REATTEMPT)
    @Expose
    private String is_reattempt;

    @SerializedName("lang_id")
    @Expose
    private String langId;

    @SerializedName("marks")
    @Expose
    private String marks;

    @SerializedName("non_attempt")
    @Expose
    private String nonAttempt;

    @SerializedName("pass_message")
    @Expose
    private String passMessage;

    @SerializedName("pass_percentage")
    @Expose
    private String passPercentage;

    @SerializedName("percentile")
    @Expose
    private String percentile;

    @SerializedName("publish")
    @Expose
    private String publish;

    @SerializedName("result_date")
    @Expose
    private String resultDate;

    @SerializedName("reward_points")
    @Expose
    private String rewardPoints;

    @SerializedName(Session.ELEMENT)
    @Expose
    private String session;

    @SerializedName("set_type")
    @Expose
    private String setType;

    @SerializedName("shuffle")
    @Expose
    private String shuffle;

    @SerializedName(FirebaseAnalytics.Param.START_DATE)
    @Expose
    private String startDate;

    @SerializedName("stream")
    @Expose
    private String stream;

    @SerializedName("sub_stream")
    @Expose
    private String subStream;

    @SerializedName(Const.SUBTOPIC_ID)
    @Expose
    private String subTopicId;

    @SerializedName("subject")
    @Expose
    private String subject;

    @SerializedName("template_id")
    @Expose
    private String templateId;

    @SerializedName("test_series_name")
    @Expose
    private String testSeriesName;

    @SerializedName(Const.TEST_TYPE)
    @Expose
    private String testType;

    @SerializedName("time_boundation")
    @Expose
    private String timeBoundation;

    @SerializedName("time_in_mins")
    @Expose
    private String timeInMins;

    @SerializedName(Const.TOPIC_ID)
    @Expose
    private String topicId;

    @SerializedName("total_marks")
    @Expose
    private String totalMarks;

    @SerializedName("total_questions")
    @Expose
    private String totalQuestions;

    @SerializedName("total_user_attempt")
    @Expose
    private Integer totalUserAttempt;

    @SerializedName(Const.UNIT_ID)
    @Expose
    private String unitId;

    @SerializedName("user_rank")
    @Expose
    private String userRank;

    @SerializedName("video_url")
    @Expose
    private String videoUrl;

    @SerializedName("watermark")
    @Expose
    private String watermark;

    @SerializedName("question_dump")
    @Expose
    private List<QuestionDumps> questionDump = null;

    @SerializedName("questions")
    @Expose
    private List<Questions2> questions = null;

    @SerializedName("cut_off")
    @Expose
    private List<CutOff> cut_off = null;

    @SerializedName("top_ten_list")
    @Expose
    private List<TopTenList> topTenList = null;

    @SerializedName("test_sections")
    @Expose
    private List<TestSections> testSections = null;

    public String getCutoff() {
        return this.cutoff;
    }

    public void setCutoff(String cutoff) {
        this.cutoff = cutoff;
    }

    public List<Questions2> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Questions2> questions) {
        this.questions = questions;
    }

    public List<CutOff> getCut_off() {
        return this.cut_off;
    }

    public void setCut_off(List<CutOff> cut_off) {
        this.cut_off = cut_off;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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

    public String getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
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

    public String getTimeInMins() {
        return this.timeInMins;
    }

    public void setTimeInMins(String timeInMins) {
        this.timeInMins = timeInMins;
    }

    public String getTotalMarks() {
        return this.totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
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

    public String getTimeBoundation() {
        return this.timeBoundation;
    }

    public void setTimeBoundation(String timeBoundation) {
        this.timeBoundation = timeBoundation;
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

    public String getResultDate() {
        return this.resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
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

    public String getStream() {
        return this.stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getSubStream() {
        return this.subStream;
    }

    public void setSubStream(String subStream) {
        this.subStream = subStream;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getTopicId() {
        return this.topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getSubTopicId() {
        return this.subTopicId;
    }

    public void setSubTopicId(String subTopicId) {
        this.subTopicId = subTopicId;
    }

    public String getLangId() {
        return this.langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getIsCalcAllowed() {
        return this.isCalcAllowed;
    }

    public void setIsCalcAllowed(String isCalcAllowed) {
        this.isCalcAllowed = isCalcAllowed;
    }

    public String getWatermark() {
        return this.watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public Integer getTotalUserAttempt() {
        return this.totalUserAttempt;
    }

    public void setTotalUserAttempt(Integer totalUserAttempt) {
        this.totalUserAttempt = totalUserAttempt;
    }

    public String getUserRank() {
        return this.userRank;
    }

    public void setUserRank(String userRank) {
        this.userRank = userRank;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getBestScore() {
        return this.bestScore;
    }

    public void setBestScore(String bestScore) {
        this.bestScore = bestScore;
    }

    public String getAvgScore() {
        return this.avgScore;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore;
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

    public String getNonAttempt() {
        return this.nonAttempt;
    }

    public void setNonAttempt(String nonAttempt) {
        this.nonAttempt = nonAttempt;
    }

    public List<QuestionDumps> getQuestionDump() {
        return this.questionDump;
    }

    public void setQuestionDump(List<QuestionDumps> questionDump) {
        this.questionDump = questionDump;
    }

    public String getPercentile() {
        return this.percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
    }

    public List<TopTenList> getTopTenList() {
        return this.topTenList;
    }

    public void setTopTenList(List<TopTenList> topTenList) {
        this.topTenList = topTenList;
    }

    public List<TestSections> getTestSections() {
        return this.testSections;
    }

    public void setTestSections(List<TestSections> testSections) {
        this.testSections = testSections;
    }

    public String getIs_reattempt() {
        return this.is_reattempt;
    }

    public void setIs_reattempt(String is_reattempt) {
        this.is_reattempt = is_reattempt;
    }
}
