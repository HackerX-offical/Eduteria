package com.appnew.android.Response;

import com.appnew.android.Model.Tags;
import com.appnew.android.Response.Registration.CoursesInterestedResponse;
import com.appnew.android.Response.Registration.SpecializationResponse;
import com.appnew.android.Response.Registration.StreamResponse;
import com.appnew.android.Response.Registration.SubStreamResponse;
import com.clevertap.android.sdk.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MasterRegistrationResponse implements Serializable {
    private ArrayList<Tags> all_tags;

    @SerializedName("chrome_detection")
    @Expose
    private int chrome_detection;

    @SerializedName("chromecast")
    @Expose
    private Chromecast chromecast;
    private ArrayList<CoursesInterestedResponse> intersted_course;
    private ArrayList<StreamResponse> main_category;
    private ArrayList<SubStreamResponse> main_sub_category;

    @SerializedName("recorder_detection")
    @Expose
    private int recorder_detection;
    private ArrayList<SpecializationResponse> specialization;

    public ArrayList<CoursesInterestedResponse> getIntersted_course() {
        return this.intersted_course;
    }

    public ArrayList<Tags> getAll_tags() {
        return this.all_tags;
    }

    public int getChrome_detection() {
        return this.chrome_detection;
    }

    public void setChrome_detection(int chrome_detection) {
        this.chrome_detection = chrome_detection;
    }

    public void setAll_tags(ArrayList<Tags> all_tags) {
        this.all_tags = all_tags;
    }

    public void setIntersted_course(ArrayList<CoursesInterestedResponse> intersted_course) {
        this.intersted_course = intersted_course;
    }

    public ArrayList<SpecializationResponse> getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(ArrayList<SpecializationResponse> specialization) {
        this.specialization = specialization;
    }

    public ArrayList<SubStreamResponse> getMain_sub_category() {
        return this.main_sub_category;
    }

    public void setMain_sub_category(ArrayList<SubStreamResponse> main_sub_category) {
        this.main_sub_category = main_sub_category;
    }

    public ArrayList<StreamResponse> getMain_category() {
        return this.main_category;
    }

    public void setMain_category(ArrayList<StreamResponse> main_category) {
        this.main_category = main_category;
    }

    public int getRecorder_detection() {
        return this.recorder_detection;
    }

    public void setRecorder_detection(int recorder_detection) {
        this.recorder_detection = recorder_detection;
    }

    public Chromecast getChromecast() {
        return this.chromecast;
    }

    public void setChromecast(Chromecast chromecast) {
        this.chromecast = chromecast;
    }

    public String toString() {
        return "ClassPojo [intersted_course = " + this.intersted_course + ", specialization = " + this.specialization + ", main_sub_category = " + this.main_sub_category + ", main_category = " + this.main_category + Constants.AES_SUFFIX;
    }

    public void setData(MasterRegistrationResponse masterRegistrationResponse) {
        setMain_category(masterRegistrationResponse.getMain_category());
        setMain_sub_category(masterRegistrationResponse.getMain_sub_category());
    }

    public class Chromecast {

        @SerializedName("chrome_cast")
        @Expose
        private List<String> chromeCast = null;

        @SerializedName("reset_chromecast")
        @Expose
        private Integer resetChromecast;

        public Chromecast() {
        }

        public Integer getResetChromecast() {
            return this.resetChromecast;
        }

        public void setResetChromecast(Integer resetChromecast) {
            this.resetChromecast = resetChromecast;
        }

        public List<String> getChromeCast() {
            return this.chromeCast;
        }

        public void setChromeCast(List<String> chromeCast) {
            this.chromeCast = chromeCast;
        }
    }
}
