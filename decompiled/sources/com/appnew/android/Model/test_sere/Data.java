package com.appnew.android.Model.test_sere;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Data {

    @SerializedName("correct_count")
    private String mCorrectCount;

    @SerializedName("correct_guess")
    private String mCorrectGuess;

    @SerializedName(Const.CREATION_TIME)
    private String mCreationTime;

    @SerializedName("first_attempt")
    private String mFirstAttempt;

    @SerializedName("guess_count")
    private String mGuessCount;

    @SerializedName("id")
    private String mId;

    @SerializedName("incorrect_count")
    private String mIncorrectCount;

    @SerializedName("incorrect_guess")
    private String mIncorrectGuess;

    @SerializedName(Const.LAST_VIEW)
    private String mLastView;

    @SerializedName("marks")
    private String mMarks;

    @SerializedName("non_attempt")
    private String mNonAttempt;

    @SerializedName("question_dump")
    private String mQuestionDump;

    @SerializedName("report_origin")
    private String mReportOrigin;

    @SerializedName("result")
    private String mResult;

    @SerializedName("reward_points")
    private String mRewardPoints;

    @SerializedName("skip_rank")
    private String mSkipRank;

    @SerializedName("state")
    private String mState;

    @SerializedName(Const.TESTSERIES_ID)
    private String mTestSeriesId;

    @SerializedName("test_series_marks")
    private String mTestSeriesMarks;

    @SerializedName("test_series_name")
    private String mTestSeriesName;

    @SerializedName(Const.TEST_TYPE)
    private String mTestType;

    @SerializedName(Const.TIME_SPENT)
    private String mTimeSpent;

    @SerializedName("top_ten_list")
    private List<TopTenList> mTopTenList;

    @SerializedName("total_test_series_time")
    private String mTotalTestSeriesTime;

    @SerializedName("total_user_attempt")
    private String mTotalUserAttempt;

    @SerializedName("user_id")
    private String mUserId;

    @SerializedName("user_rank")
    private String mUserRank;

    public String getCorrectCount() {
        return this.mCorrectCount;
    }

    public void setCorrectCount(String correctCount) {
        this.mCorrectCount = correctCount;
    }

    public String getCorrectGuess() {
        return this.mCorrectGuess;
    }

    public void setCorrectGuess(String correctGuess) {
        this.mCorrectGuess = correctGuess;
    }

    public String getCreationTime() {
        return this.mCreationTime;
    }

    public void setCreationTime(String creationTime) {
        this.mCreationTime = creationTime;
    }

    public String getFirstAttempt() {
        return this.mFirstAttempt;
    }

    public void setFirstAttempt(String firstAttempt) {
        this.mFirstAttempt = firstAttempt;
    }

    public String getGuessCount() {
        return this.mGuessCount;
    }

    public void setGuessCount(String guessCount) {
        this.mGuessCount = guessCount;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getIncorrectCount() {
        return this.mIncorrectCount;
    }

    public void setIncorrectCount(String incorrectCount) {
        this.mIncorrectCount = incorrectCount;
    }

    public String getIncorrectGuess() {
        return this.mIncorrectGuess;
    }

    public void setIncorrectGuess(String incorrectGuess) {
        this.mIncorrectGuess = incorrectGuess;
    }

    public String getLastView() {
        return this.mLastView;
    }

    public void setLastView(String lastView) {
        this.mLastView = lastView;
    }

    public String getMarks() {
        return this.mMarks;
    }

    public void setMarks(String marks) {
        this.mMarks = marks;
    }

    public String getNonAttempt() {
        return this.mNonAttempt;
    }

    public void setNonAttempt(String nonAttempt) {
        this.mNonAttempt = nonAttempt;
    }

    public String getQuestionDump() {
        return this.mQuestionDump;
    }

    public void setQuestionDump(String questionDump) {
        this.mQuestionDump = questionDump;
    }

    public String getReportOrigin() {
        return this.mReportOrigin;
    }

    public void setReportOrigin(String reportOrigin) {
        this.mReportOrigin = reportOrigin;
    }

    public String getResult() {
        return this.mResult;
    }

    public void setResult(String result) {
        this.mResult = result;
    }

    public String getRewardPoints() {
        return this.mRewardPoints;
    }

    public void setRewardPoints(String rewardPoints) {
        this.mRewardPoints = rewardPoints;
    }

    public String getSkipRank() {
        return this.mSkipRank;
    }

    public void setSkipRank(String skipRank) {
        this.mSkipRank = skipRank;
    }

    public String getState() {
        return this.mState;
    }

    public void setState(String state) {
        this.mState = state;
    }

    public String getTestSeriesId() {
        return this.mTestSeriesId;
    }

    public void setTestSeriesId(String testSeriesId) {
        this.mTestSeriesId = testSeriesId;
    }

    public String getTestSeriesMarks() {
        return this.mTestSeriesMarks;
    }

    public void setTestSeriesMarks(String testSeriesMarks) {
        this.mTestSeriesMarks = testSeriesMarks;
    }

    public String getTestSeriesName() {
        return this.mTestSeriesName;
    }

    public void setTestSeriesName(String testSeriesName) {
        this.mTestSeriesName = testSeriesName;
    }

    public String getTestType() {
        return this.mTestType;
    }

    public void setTestType(String testType) {
        this.mTestType = testType;
    }

    public String getTimeSpent() {
        return this.mTimeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.mTimeSpent = timeSpent;
    }

    public List<TopTenList> getTopTenList() {
        return this.mTopTenList;
    }

    public void setTopTenList(List<TopTenList> topTenList) {
        this.mTopTenList = topTenList;
    }

    public String getTotalTestSeriesTime() {
        return this.mTotalTestSeriesTime;
    }

    public void setTotalTestSeriesTime(String totalTestSeriesTime) {
        this.mTotalTestSeriesTime = totalTestSeriesTime;
    }

    public String getTotalUserAttempt() {
        return this.mTotalUserAttempt;
    }

    public void setTotalUserAttempt(String totalUserAttempt) {
        this.mTotalUserAttempt = totalUserAttempt;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String userId) {
        this.mUserId = userId;
    }

    public String getUserRank() {
        return this.mUserRank;
    }

    public void setUserRank(String userRank) {
        this.mUserRank = userRank;
    }
}
