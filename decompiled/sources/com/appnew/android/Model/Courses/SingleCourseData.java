package com.appnew.android.Model.Courses;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class SingleCourseData implements Serializable {
    private String course_category_fk;
    private String cover_image;
    private String cover_video;
    private Curriculam curriculam;
    private String desc_header_image;
    private String description;
    private String for_dams;
    private String gst;
    private String id;
    private Instructor instructor_data;
    private String is_purchased;
    private String learner;
    private String mrp;
    private String non_dams;
    private String points_conversion_rate;
    private String publish;
    private String rating;
    private ArrayList<Course> related_course;
    private Review review;
    private String review_count;
    private Reviews[] reviews;
    private String state;
    private String tags;
    private String title;

    public String getPoints_conversion_rate() {
        return this.points_conversion_rate;
    }

    public void setPoints_conversion_rate(String points_conversion_rate) {
        this.points_conversion_rate = points_conversion_rate;
    }

    public String getGst() {
        return this.gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getDesc_header_image() {
        return this.desc_header_image;
    }

    public void setDesc_header_image(String desc_header_image) {
        this.desc_header_image = desc_header_image;
    }

    public String getCover_video() {
        return this.cover_video;
    }

    public void setCover_video(String cover_video) {
        this.cover_video = cover_video;
    }

    public ArrayList<Course> getRelated_course() {
        return this.related_course;
    }

    public void setRelated_course(ArrayList<Course> related_course) {
        this.related_course = related_course;
    }

    public Review getReview() {
        return this.review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getIs_purchased() {
        return this.is_purchased;
    }

    public void setIs_purchased(String is_purchased) {
        this.is_purchased = is_purchased;
    }

    public Curriculam getCurriculam() {
        return this.curriculam;
    }

    public void setCurriculam(Curriculam curriculam) {
        this.curriculam = curriculam;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Reviews[] getReviews() {
        return this.reviews;
    }

    public void setReviews(Reviews[] reviews) {
        this.reviews = reviews;
    }

    public String getCover_image() {
        return this.cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getReview_count() {
        return this.review_count;
    }

    public void setReview_count(String review_count) {
        this.review_count = review_count;
    }

    public String getLearner() {
        return this.learner;
    }

    public void setLearner(String learner) {
        this.learner = learner;
    }

    public String getMrp() {
        return this.mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNon_dams() {
        return this.non_dams;
    }

    public void setNon_dams(String non_dams) {
        this.non_dams = non_dams;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFor_dams() {
        return this.for_dams;
    }

    public void setFor_dams(String for_dams) {
        this.for_dams = for_dams;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCourse_category_fk() {
        return this.course_category_fk;
    }

    public void setCourse_category_fk(String course_category_fk) {
        this.course_category_fk = course_category_fk;
    }

    public String getPublish() {
        return this.publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Instructor getInstructor_data() {
        return this.instructor_data;
    }

    public void setInstructor_data(Instructor instructor_data) {
        this.instructor_data = instructor_data;
    }
}
