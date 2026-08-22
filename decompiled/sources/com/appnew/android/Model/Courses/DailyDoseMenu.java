package com.appnew.android.Model.Courses;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class DailyDoseMenu implements Serializable {

    @SerializedName("c_code")
    @Expose
    private String c_code;

    @SerializedName("child_type")
    @Expose
    private String child_type;

    @SerializedName("course_type_master_id")
    @Expose
    private String course_type_master_id;

    @SerializedName(Const.DOSE_ID)
    @Expose
    private String dose_id;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName(Const.PARENT_ID)
    @Expose
    private String parent_id;

    @SerializedName(TypedValues.AttributesType.S_TARGET)
    @Expose
    private String target;

    @SerializedName("web_url")
    @Expose
    private String web_url;

    public String getDose_id() {
        return this.dose_id;
    }

    public void setDose_id(String dose_id) {
        this.dose_id = dose_id;
    }

    public String getC_code() {
        return this.c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getWeb_url() {
        return this.web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChild_type() {
        return this.child_type;
    }

    public void setChild_type(String child_type) {
        this.child_type = child_type;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCourse_type_master_id() {
        return this.course_type_master_id;
    }

    public void setCourse_type_master_id(String course_type_master_id) {
        this.course_type_master_id = course_type_master_id;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String toString() {
        return "DailyDoseMenu{id='" + this.id + "', name='" + this.name + "', child_type='" + this.child_type + "', image='" + this.image + "', course_type_master_id='" + this.course_type_master_id + "', c_code='" + this.c_code + "', target='" + this.target + "', web_url='" + this.web_url + "', dose_id='" + this.dose_id + "', parent_id='" + this.parent_id + "'}";
    }
}
