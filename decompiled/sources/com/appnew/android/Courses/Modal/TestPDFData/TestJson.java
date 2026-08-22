package com.appnew.android.Courses.Modal.TestPDFData;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TestJson implements Serializable {

    @SerializedName("bookmark")
    @Expose
    private BICButton bookmark;

    @SerializedName(Const.CHAT)
    @Expose
    private BICButton chat;

    @SerializedName(FirebaseAnalytics.Param.INDEX)
    @Expose
    private BICButton index;

    @SerializedName("objective")
    @Expose
    private Objective objective;

    @SerializedName(Const.PDF)
    @Expose
    private PDFJson pdf;

    @SerializedName(Const.QUIZ)
    @Expose
    private Quiz quiz;

    @SerializedName(Const.SUBJECTIVE_TEST)
    @Expose
    private Subjective subjective;

    public Subjective getSubjective() {
        return this.subjective;
    }

    public void setSubjective(Subjective subjective) {
        this.subjective = subjective;
    }

    public Objective getObjective() {
        return this.objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Quiz getQuiz() {
        return this.quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public PDFJson getPdf() {
        return this.pdf;
    }

    public void setPdf(PDFJson pdf) {
        this.pdf = pdf;
    }

    public BICButton getBookmark() {
        return this.bookmark;
    }

    public void setBookmark(BICButton bookmark) {
        this.bookmark = bookmark;
    }

    public BICButton getIndex() {
        return this.index;
    }

    public void setIndex(BICButton index) {
        this.index = index;
    }

    public BICButton getChat() {
        return this.chat;
    }

    public void setChat(BICButton chat) {
        this.chat = chat;
    }
}
