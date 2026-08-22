package com.appnew.android.Model.Courses;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Course implements Serializable {
    private String c_code;
    private String course_attribute;
    private String course_category_fk;
    private String cover_image;
    private String currency;
    private String desc_header_image;
    private String description;
    private Element_meta[] element_meta;
    private String for_dams;
    private String free_segment_count;
    private String id;
    private String learner;
    private String mrp;
    private String non_dams;
    private String paid_segment_count;
    private String practice_id;
    private String publish;
    private String rating;
    private Review review;
    private String segment_information;
    private String state;
    private String tags;
    private String title;

    public String getCourse_attribute() {
        return this.course_attribute;
    }

    public void setCourse_attribute(String course_attribute) {
        this.course_attribute = course_attribute;
    }

    public String getPractice_id() {
        return this.practice_id;
    }

    public void setPractice_id(String practice_id) {
        this.practice_id = practice_id;
    }

    public String getC_code() {
        return this.c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getSegment_information() {
        return this.segment_information;
    }

    public void setSegment_information(String segment_information) {
        this.segment_information = segment_information;
    }

    public Element_meta[] getElement_meta() {
        return this.element_meta;
    }

    public void setElement_meta(Element_meta[] element_meta) {
        this.element_meta = element_meta;
    }

    public String getFree_segment_count() {
        return this.free_segment_count;
    }

    public void setFree_segment_count(String free_segment_count) {
        this.free_segment_count = free_segment_count;
    }

    public String getPaid_segment_count() {
        return this.paid_segment_count;
    }

    public void setPaid_segment_count(String paid_segment_count) {
        this.paid_segment_count = paid_segment_count;
    }

    public String getDesc_header_image() {
        return this.desc_header_image;
    }

    public void setDesc_header_image(String desc_header_image) {
        this.desc_header_image = desc_header_image;
    }

    public Review getReview() {
        return this.review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCover_image() {
        return this.cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
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

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNon_dams() {
        return this.non_dams;
    }

    public void setNon_dams(String non_dams) {
        this.non_dams = non_dams;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public class Element_meta implements Serializable {
        private String id;
        private String image;
        private String own;
        private String position;
        private String topic_name;

        public Element_meta() {
        }

        public String getImage() {
            return this.image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPosition() {
            return this.position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTopic_name() {
            return this.topic_name;
        }

        public void setTopic_name(String topic_name) {
            this.topic_name = topic_name;
        }

        public String getOwn() {
            return this.own;
        }

        public void setOwn(String own) {
            this.own = own;
        }

        public String toString() {
            return "ClassPojo [position = " + this.position + ", id = " + this.id + ", topic_name = , image = " + this.image + ", own = " + this.own + Constants.AES_SUFFIX;
        }
    }
}
