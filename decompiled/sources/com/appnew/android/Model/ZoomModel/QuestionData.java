package com.appnew.android.Model.ZoomModel;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionData implements Serializable {

    @SerializedName(Const.ANSWER)
    @Expose
    private String answer;

    @SerializedName(Const.CONFIG_ID)
    @Expose
    private String config_id;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("option_1")
    @Expose
    private String option_1;

    @SerializedName("option_2")
    @Expose
    private String option_2;

    @SerializedName("option_3")
    @Expose
    private String option_3;

    @SerializedName("option_4")
    @Expose
    private String option_4;

    @SerializedName("option_5")
    @Expose
    private String option_5;

    @SerializedName("option_6")
    @Expose
    private String option_6;

    @SerializedName("option_7")
    @Expose
    private String option_7;

    @SerializedName("option_8")
    @Expose
    private String option_8;

    @SerializedName(Const.QUESTION)
    @Expose
    private String question;

    @SerializedName("question_type")
    @Expose
    private String question_type;

    public String getConfig_id() {
        return this.config_id;
    }

    public void setConfig_id(String config_id) {
        this.config_id = config_id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion_type() {
        return this.question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public String getOption_1() {
        return this.option_1;
    }

    public void setOption_1(String option_1) {
        this.option_1 = option_1;
    }

    public String getOption_2() {
        return this.option_2;
    }

    public void setOption_2(String option_2) {
        this.option_2 = option_2;
    }

    public String getOption_3() {
        return this.option_3;
    }

    public void setOption_3(String option_3) {
        this.option_3 = option_3;
    }

    public String getOption_4() {
        return this.option_4;
    }

    public void setOption_4(String option_4) {
        this.option_4 = option_4;
    }

    public String getOption_5() {
        return this.option_5;
    }

    public void setOption_5(String option_5) {
        this.option_5 = option_5;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOption_6() {
        return this.option_6;
    }

    public void setOption_6(String option_6) {
        this.option_6 = option_6;
    }

    public String getOption_7() {
        return this.option_7;
    }

    public void setOption_7(String option_7) {
        this.option_7 = option_7;
    }

    public String getOption_8() {
        return this.option_8;
    }

    public void setOption_8(String option_8) {
        this.option_8 = option_8;
    }
}
