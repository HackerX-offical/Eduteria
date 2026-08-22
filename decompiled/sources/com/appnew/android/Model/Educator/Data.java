package com.appnew.android.Model.Educator;

import androidx.autofill.HintConstants;
import com.appnew.android.Utils.Const;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Data {

    @SerializedName("about_user")
    private String aboutUser;

    @SerializedName("basic_details")
    private BasicDetails basicDetails;

    @SerializedName(Const.COMBO_COURSE_ID)
    private String courseIds;

    @SerializedName("experience")
    private String experience;

    @SerializedName("free_live_classes")
    private FreeLiveClasses freeLiveClasses;

    @SerializedName("id")
    private String id;

    @SerializedName("label")
    private ArrayList<LabelItem> label;

    @SerializedName("paid_live_classes")
    private PaidLiveClasses paidLiveClasses;

    @SerializedName(Const.PROFILE_PICTURE)
    private String profilePicture;

    @SerializedName(HintConstants.AUTOFILL_HINT_USERNAME)
    private String username;

    public void setBasicDetails(BasicDetails basicDetails) {
        this.basicDetails = basicDetails;
    }

    public BasicDetails getBasicDetails() {
        return this.basicDetails;
    }

    public void setPaidLiveClasses(PaidLiveClasses paidLiveClasses) {
        this.paidLiveClasses = paidLiveClasses;
    }

    public PaidLiveClasses getPaidLiveClasses() {
        return this.paidLiveClasses;
    }

    public void setFreeLiveClasses(FreeLiveClasses freeLiveClasses) {
        this.freeLiveClasses = freeLiveClasses;
    }

    public FreeLiveClasses getFreeLiveClasses() {
        return this.freeLiveClasses;
    }

    public void setLabel(ArrayList<LabelItem> label) {
        this.label = label;
    }

    public ArrayList<LabelItem> getLabel() {
        return this.label;
    }

    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser;
    }

    public String getAboutUser() {
        return this.aboutUser;
    }

    public void setCourseIds(String courseIds) {
        this.courseIds = courseIds;
    }

    public String getCourseIds() {
        return this.courseIds;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
