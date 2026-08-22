package com.appnew.android.testmodule.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class TestBasicInst implements Serializable {

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description_2")
    @Expose
    private String description_2;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("instruction")
    @Expose
    private String instruction;

    @SerializedName("lang_id")
    @Expose
    private String lang_id;

    @SerializedName("multi_description")
    @Expose
    private ArrayList<Multi_description> multi_description;

    @SerializedName("test_series_name")
    @Expose
    private String testSeriesName;

    @SerializedName("test_assets")
    @Expose
    private Test_assets test_assets;

    @SerializedName("time_in_mins")
    @Expose
    private String timeInMins;

    @SerializedName("total_marks")
    @Expose
    private String totalMarks;

    @SerializedName("total_questions")
    @Expose
    private String totalQuestions;

    @SerializedName("watermark")
    @Expose
    private String watermark;

    public String getDescription_2() {
        return this.description_2;
    }

    public void setDescription_2(String description_2) {
        this.description_2 = description_2;
    }

    public Test_assets getTest_assets() {
        return this.test_assets;
    }

    public void setTest_assets(Test_assets test_assets) {
        this.test_assets = test_assets;
    }

    public ArrayList<Multi_description> getMulti_description() {
        return this.multi_description;
    }

    public void setMulti_description(ArrayList<Multi_description> multi_description) {
        this.multi_description = multi_description;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestSeriesName() {
        return this.testSeriesName;
    }

    public void setTestSeriesName(String testSeriesName) {
        this.testSeriesName = testSeriesName;
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

    public String getWatermark() {
        return this.watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLang_id() {
        return this.lang_id;
    }

    public void setLang_id(String lang_id) {
        this.lang_id = lang_id;
    }

    public static class Test_assets implements Serializable {

        @SerializedName("disable_sec_click")
        @Expose
        private String disable_sec_click;

        @SerializedName("hide_inst_time")
        @Expose
        private String hide_inst_time;

        public String getHide_inst_time() {
            return this.hide_inst_time;
        }

        public void setHide_inst_time(String hide_inst_time) {
            this.hide_inst_time = hide_inst_time;
        }

        public String getDisable_sec_click() {
            return this.disable_sec_click;
        }

        public void setDisable_sec_click(String disable_sec_click) {
            this.disable_sec_click = disable_sec_click;
        }
    }

    public class Multi_description implements Serializable {

        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("lang_id")
        @Expose
        private String lang_id;

        public Multi_description() {
        }

        public String getLang_id() {
            return this.lang_id;
        }

        public void setLang_id(String lang_id) {
            this.lang_id = lang_id;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
