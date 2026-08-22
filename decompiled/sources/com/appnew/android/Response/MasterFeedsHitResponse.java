package com.appnew.android.Response;

import com.appnew.android.Model.Course_subject_master;
import com.appnew.android.Model.Courses.Course;
import com.appnew.android.Model.People;
import com.appnew.android.Model.Tags;
import com.appnew.android.Model.Video;
import com.appnew.android.home.model.bannerHomeData.BannerData;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class MasterFeedsHitResponse {
    private ArrayList<Tags> all_tags;
    private ArrayList<BannerData> banner_list;
    private ArrayList<Course_subject_master> course_subject_master;
    private ArrayList<People> course_type_master;
    private String duration;
    private ArrayList<People> expert_list;
    private String payment_gateways;
    private ArrayList<People> people_you_may_know_list;
    private ArrayList<Course> suggested_course;
    private ArrayList<Video> suggested_videos;

    public ArrayList<People> getCourse_type_master() {
        return this.course_type_master;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPayment_gateways() {
        return this.payment_gateways;
    }

    public void setPayment_gateways(String payment_gateways) {
        this.payment_gateways = payment_gateways;
    }

    public void setCourse_type_master(ArrayList<People> course_type_master) {
        this.course_type_master = course_type_master;
    }

    public ArrayList<Course_subject_master> getCourse_subject_master() {
        return this.course_subject_master;
    }

    public void setCourse_subject_master(ArrayList<Course_subject_master> course_subject_master) {
        this.course_subject_master = course_subject_master;
    }

    public ArrayList<Course> getSuggested_course() {
        return this.suggested_course;
    }

    public void setSuggested_course(ArrayList<Course> suggested_course) {
        this.suggested_course = suggested_course;
    }

    public ArrayList<Video> getSuggested_videos() {
        return this.suggested_videos;
    }

    public void setSuggested_videos(ArrayList<Video> suggested_videos) {
        this.suggested_videos = suggested_videos;
    }

    public ArrayList<Tags> getAll_tags() {
        return this.all_tags;
    }

    public void setAll_tags(ArrayList<Tags> all_tags) {
        this.all_tags = all_tags;
    }

    public ArrayList<People> getPeople_you_may_know_list() {
        return this.people_you_may_know_list;
    }

    public void setPeople_you_may_know_list(ArrayList<People> people_you_may_know_list) {
        this.people_you_may_know_list = people_you_may_know_list;
    }

    public ArrayList<BannerData> getBanner_list() {
        return this.banner_list;
    }

    public void setBanner_list(ArrayList<BannerData> banner_list) {
        this.banner_list = banner_list;
    }

    public ArrayList<People> getExpert_list() {
        return this.expert_list;
    }

    public void setExpert_list(ArrayList<People> expert_list) {
        this.expert_list = expert_list;
    }

    public String toString() {
        return "ClassPojo [people_you_may_know_list = " + this.people_you_may_know_list + ", banner_list = " + this.banner_list + ", expert_list = " + this.expert_list + Constants.AES_SUFFIX;
    }
}
