package com.appnew.android.Model.Overview;

import com.appnew.android.Model.Courselist;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Data implements Serializable {

    @SerializedName("ceo_message")
    @Expose
    private CeoMessage ceoMessage;

    @SerializedName("description")
    @Expose
    private Description description;

    @SerializedName("description_2")
    @Expose
    private Description description2;

    @SerializedName("related_courses")
    @Expose
    private ArrayList<Courselist> relatedCourses = null;

    @SerializedName("visibility")
    @Expose
    private String visibility;

    public ArrayList<Courselist> getRelatedCourses() {
        return this.relatedCourses;
    }

    public void setRelatedCourses(ArrayList<Courselist> relatedCourses) {
        this.relatedCourses = relatedCourses;
    }

    public CeoMessage getCeoMessage() {
        return this.ceoMessage;
    }

    public void setCeoMessage(CeoMessage ceoMessage) {
        this.ceoMessage = ceoMessage;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Description getDescription() {
        return this.description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Description getDescription2() {
        return this.description2;
    }

    public void setDescription2(Description description2) {
        this.description2 = description2;
    }
}
