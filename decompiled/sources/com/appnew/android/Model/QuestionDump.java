package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionDump implements Serializable {

    @SerializedName(Const.ANSWER)
    @Expose
    private String answer;

    @SerializedName(Const.GUESS)
    @Expose
    private String guess;

    @SerializedName(Const.ISCORRECT)
    @Expose
    private String isCorrect;

    @SerializedName(Const.QUESTIONID)
    @Expose
    private String questionId;

    public String getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getGuess() {
        return this.guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }
}
