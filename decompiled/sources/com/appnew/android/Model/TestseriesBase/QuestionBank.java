package com.appnew.android.Model.TestseriesBase;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionBank implements Serializable {

    @SerializedName(Const.ANSWER)
    @Expose
    private String answer;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("difficulty_level")
    @Expose
    private String difficultyLevel;

    @SerializedName(TypedValues.TransitionType.S_DURATION)
    @Expose
    private String duration;

    @SerializedName("for_quiz")
    @Expose
    private String forQuiz;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_bookmarked")
    @Expose
    private String isBookmarked;
    private boolean isMarkForReview;

    @SerializedName("is_verified")
    @Expose
    private String isVerified;
    private boolean isanswerRight;

    @SerializedName("marks")
    @Expose
    private String marks;

    @SerializedName("negative_marks")
    @Expose
    private String negativeMarks;

    @SerializedName("option_1")
    @Expose
    private String option1;

    @SerializedName("option_10")
    @Expose
    private String option10;

    @SerializedName("option_10_attempt")
    @Expose
    private String option10Attempt;

    @SerializedName("option_11")
    @Expose
    private String option11;

    @SerializedName("option_11_attempt")
    @Expose
    private String option11Attempt;

    @SerializedName("option_12")
    @Expose
    private String option12;

    @SerializedName("option_12_attempt")
    @Expose
    private String option12Attempt;

    @SerializedName("option_13")
    @Expose
    private String option13;

    @SerializedName("option_13_attempt")
    @Expose
    private String option13Attempt;

    @SerializedName("option_14")
    @Expose
    private String option14;

    @SerializedName("option_14_attempt")
    @Expose
    private String option14Attempt;

    @SerializedName("option_15")
    @Expose
    private String option15;

    @SerializedName("option_15_attempt")
    @Expose
    private String option15Attempt;

    @SerializedName("option_1_attempt")
    @Expose
    private String option1Attempt;

    @SerializedName("option_2")
    @Expose
    private String option2;

    @SerializedName("option_2_attempt")
    @Expose
    private String option2Attempt;

    @SerializedName("option_3")
    @Expose
    private String option3;

    @SerializedName("option_3_attempt")
    @Expose
    private String option3Attempt;

    @SerializedName("option_4")
    @Expose
    private String option4;

    @SerializedName("option_4_attempt")
    @Expose
    private String option4Attempt;

    @SerializedName("option_5")
    @Expose
    private String option5;

    @SerializedName("option_5_attempt")
    @Expose
    private String option5Attempt;

    @SerializedName("option_6")
    @Expose
    private String option6;

    @SerializedName("option_6_attempt")
    @Expose
    private String option6Attempt;

    @SerializedName("option_7")
    @Expose
    private String option7;

    @SerializedName("option_7_attempt")
    @Expose
    private String option7Attempt;

    @SerializedName("option_8")
    @Expose
    private String option8;

    @SerializedName("option_8_attempt")
    @Expose
    private String option8Attempt;

    @SerializedName("option_9")
    @Expose
    private String option9;

    @SerializedName("option_9_attempt")
    @Expose
    private String option9Attempt;

    @SerializedName("paragraph_text")
    @Expose
    private String paragraphText;

    @SerializedName(Const.PART)
    @Expose
    private String part;

    @SerializedName(Const.QUESTION)
    @Expose
    private String question;

    @SerializedName("question_type")
    @Expose
    private String questionType;

    @SerializedName("screen_type")
    @Expose
    private String screenType;

    @SerializedName("section_id")
    @Expose
    private String sectionId;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("stream_id")
    @Expose
    private String streamId;

    @SerializedName("sub_stream_id")
    @Expose
    private String subStreamId;

    @SerializedName(Const.SUBJECT_ID)
    @Expose
    private String subjectId;

    @SerializedName("subject_name")
    @Expose
    private String subjectName;

    @SerializedName(Const.TOPIC_ID)
    @Expose
    private String topicId;

    @SerializedName("total_attempt")
    @Expose
    private String totalAttempt;

    @SerializedName("total_right")
    @Expose
    private String totalRight;

    @SerializedName("total_wrong")
    @Expose
    private String totalWrong;

    @SerializedName("uploaded_by")
    @Expose
    private String uploadedBy;
    private boolean isanswer = false;
    private boolean isselctedanswer = false;
    private boolean answered = false;
    private int answerPosition = -1;
    private int selectedanswerPosition = -1;
    private boolean iswronganswer = false;
    private int wronganswerPosition = -1;
    private String isguess = "0";
    private boolean isPause = false;
    private int totalTimeSpent = 0;

    public boolean isAnswered() {
        return this.answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public boolean isMarkForReview() {
        return this.isMarkForReview;
    }

    public void setMarkForReview(boolean markForReview) {
        this.isMarkForReview = markForReview;
    }

    public String getIsguess() {
        return this.isguess;
    }

    public void setIsguess(String isguess) {
        this.isguess = isguess;
    }

    public boolean equals(Object anotherObject) {
        return (anotherObject instanceof QuestionBank) && this.id == ((QuestionBank) anotherObject).id;
    }

    public boolean isPause() {
        return this.isPause;
    }

    public void setPause(boolean pause) {
        this.isPause = pause;
    }

    public int getTotalTimeSpent() {
        return this.totalTimeSpent;
    }

    public void setTotalTimeSpent(int totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }

    public boolean isIsanswerRight() {
        return this.isanswerRight;
    }

    public void setIsanswerRight(boolean isanswerRight) {
        this.isanswerRight = isanswerRight;
    }

    public String getPart() {
        return this.part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getSubStreamId() {
        return this.subStreamId;
    }

    public void setSubStreamId(String subStreamId) {
        this.subStreamId = subStreamId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTopicId() {
        return this.topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getNegativeMarks() {
        return this.negativeMarks;
    }

    public void setNegativeMarks(String negativeMarks) {
        this.negativeMarks = negativeMarks;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOption1() {
        return this.option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption1Attempt() {
        return this.option1Attempt;
    }

    public void setOption1Attempt(String option1Attempt) {
        this.option1Attempt = option1Attempt;
    }

    public String getOption2() {
        return this.option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return this.option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return this.option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return this.option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getOption6() {
        return this.option6;
    }

    public void setOption6(String option6) {
        this.option6 = option6;
    }

    public String getOption7() {
        return this.option7;
    }

    public void setOption7(String option7) {
        this.option7 = option7;
    }

    public String getOption8() {
        return this.option8;
    }

    public void setOption8(String option8) {
        this.option8 = option8;
    }

    public String getOption9() {
        return this.option9;
    }

    public void setOption9(String option9) {
        this.option9 = option9;
    }

    public String getOption10() {
        return this.option10;
    }

    public void setOption10(String option10) {
        this.option10 = option10;
    }

    public String getOption11() {
        return this.option11;
    }

    public void setOption11(String option11) {
        this.option11 = option11;
    }

    public String getOption12() {
        return this.option12;
    }

    public void setOption12(String option12) {
        this.option12 = option12;
    }

    public String getOption13() {
        return this.option13;
    }

    public void setOption13(String option13) {
        this.option13 = option13;
    }

    public String getOption14() {
        return this.option14;
    }

    public void setOption14(String option14) {
        this.option14 = option14;
    }

    public String getOption15() {
        return this.option15;
    }

    public void setOption15(String option15) {
        this.option15 = option15;
    }

    public String getOption2Attempt() {
        return this.option2Attempt;
    }

    public void setOption2Attempt(String option2Attempt) {
        this.option2Attempt = option2Attempt;
    }

    public String getOption3Attempt() {
        return this.option3Attempt;
    }

    public void setOption3Attempt(String option3Attempt) {
        this.option3Attempt = option3Attempt;
    }

    public String getOption4Attempt() {
        return this.option4Attempt;
    }

    public void setOption4Attempt(String option4Attempt) {
        this.option4Attempt = option4Attempt;
    }

    public String getOption5Attempt() {
        return this.option5Attempt;
    }

    public void setOption5Attempt(String option5Attempt) {
        this.option5Attempt = option5Attempt;
    }

    public String getOption6Attempt() {
        return this.option6Attempt;
    }

    public void setOption6Attempt(String option6Attempt) {
        this.option6Attempt = option6Attempt;
    }

    public String getOption7Attempt() {
        return this.option7Attempt;
    }

    public void setOption7Attempt(String option7Attempt) {
        this.option7Attempt = option7Attempt;
    }

    public String getOption8Attempt() {
        return this.option8Attempt;
    }

    public void setOption8Attempt(String option8Attempt) {
        this.option8Attempt = option8Attempt;
    }

    public String getOption9Attempt() {
        return this.option9Attempt;
    }

    public void setOption9Attempt(String option9Attempt) {
        this.option9Attempt = option9Attempt;
    }

    public String getOption10Attempt() {
        return this.option10Attempt;
    }

    public void setOption10Attempt(String option10Attempt) {
        this.option10Attempt = option10Attempt;
    }

    public String getOption11Attempt() {
        return this.option11Attempt;
    }

    public void setOption11Attempt(String option11Attempt) {
        this.option11Attempt = option11Attempt;
    }

    public String getOption12Attempt() {
        return this.option12Attempt;
    }

    public void setOption12Attempt(String option12Attempt) {
        this.option12Attempt = option12Attempt;
    }

    public String getOption13Attempt() {
        return this.option13Attempt;
    }

    public void setOption13Attempt(String option13Attempt) {
        this.option13Attempt = option13Attempt;
    }

    public String getOption14Attempt() {
        return this.option14Attempt;
    }

    public void setOption14Attempt(String option14Attempt) {
        this.option14Attempt = option14Attempt;
    }

    public String getOption15Attempt() {
        return this.option15Attempt;
    }

    public void setOption15Attempt(String option15Attempt) {
        this.option15Attempt = option15Attempt;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getIsVerified() {
        return this.isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    public String getUploadedBy() {
        return this.uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalAttempt() {
        return this.totalAttempt;
    }

    public void setTotalAttempt(String totalAttempt) {
        this.totalAttempt = totalAttempt;
    }

    public String getTotalRight() {
        return this.totalRight;
    }

    public void setTotalRight(String totalRight) {
        this.totalRight = totalRight;
    }

    public String getTotalWrong() {
        return this.totalWrong;
    }

    public void setTotalWrong(String totalWrong) {
        this.totalWrong = totalWrong;
    }

    public String getForQuiz() {
        return this.forQuiz;
    }

    public void setForQuiz(String forQuiz) {
        this.forQuiz = forQuiz;
    }

    public String getScreenType() {
        return this.screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getParagraphText() {
        return this.paragraphText;
    }

    public void setParagraphText(String paragraphText) {
        this.paragraphText = paragraphText;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getIsBookmarked() {
        return this.isBookmarked;
    }

    public void setIsBookmarked(String isBookmarked) {
        this.isBookmarked = isBookmarked;
    }

    public boolean isanswer() {
        return this.isanswer;
    }

    public void setIsanswer(boolean isanswer, int position) {
        this.isanswer = isanswer;
        this.answerPosition = position;
    }

    public boolean isselectedanswer() {
        return this.isselctedanswer;
    }

    public void setselectedanswer(boolean isanswer, int position) {
        this.isselctedanswer = isanswer;
        this.selectedanswerPosition = position;
    }

    public boolean iswronganswer() {
        return this.iswronganswer;
    }

    public void setIswronganswer(boolean iswronganswer, int position) {
        this.iswronganswer = iswronganswer;
        this.wronganswerPosition = position;
    }

    public int getAnswerPosttion() {
        return this.answerPosition;
    }

    public int getselectedAnswerPosttion() {
        return this.selectedanswerPosition;
    }

    public int getwrongAnswerPosttion() {
        return this.wronganswerPosition;
    }

    public String getColor1() {
        int i = this.answerPosition;
        if (i == -1) {
            return "0";
        }
        if (i == 0) {
            return "2";
        }
        if (i != -1 && i != 0) {
            return "1";
        }
        return "3";
    }
}
