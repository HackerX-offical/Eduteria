package com.appnew.android.Model.Courses;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Instructor implements Serializable {
    private String about;
    private ArrayList<Course> course_list;
    private String courses;
    private String email;
    private String id;
    private String name;
    private String profile_pic;
    private String rating;
    private String review;
    private ArrayList<Reviews> reviews;
    private String students;
    private Review user_given_review;

    public Review getUser_given_review() {
        return this.user_given_review;
    }

    public void setUser_given_review(Review user_given_review) {
        this.user_given_review = user_given_review;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudents() {
        return this.students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    public String getCourses() {
        return this.courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProfile_pic() {
        return this.profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public ArrayList<Reviews> getReviews() {
        return this.reviews;
    }

    public void setReviews(ArrayList<Reviews> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Course> getCourse_list() {
        return this.course_list;
    }

    public void setCourse_list(ArrayList<Course> course_list) {
        this.course_list = course_list;
    }
}
