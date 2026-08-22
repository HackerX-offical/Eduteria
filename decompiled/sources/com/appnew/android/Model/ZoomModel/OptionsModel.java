package com.appnew.android.Model.ZoomModel;

/* JADX INFO: loaded from: classes6.dex */
public class OptionsModel {
    String answer;
    String option;
    String optionType;

    public String getOptionType() {
        return this.optionType;
    }

    public OptionsModel(String optionType, String option, String answer) {
        this.optionType = optionType;
        this.option = option;
        this.answer = answer;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
