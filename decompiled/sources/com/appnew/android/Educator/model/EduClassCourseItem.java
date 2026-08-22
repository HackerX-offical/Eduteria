package com.appnew.android.Educator.model;

/* JADX INFO: loaded from: classes6.dex */
public class EduClassCourseItem {
    int courseImage;
    String courseName;
    String courseTitle;
    int discount;
    int imageBanner;
    Boolean isCourse;
    Boolean isFreeCourse;
    Boolean isLiveClass;
    Boolean isPaidCourse;
    String liveDate;
    String liveTime;
    double originalPrice;
    double price;
    String studyItemTitle;
    String timing;
    int validity;

    public EduClassCourseItem(Boolean isLiveClass, int courseImage, String courseName, String studyItemTitle, String liveDate, String liveTime, String timing, Boolean isCourse, Boolean isPaidCourse, Boolean isFreeCourse, int imageBanner, String courseTitle, int validity, double price, int discount, double originalPrice) {
        this.isLiveClass = isLiveClass;
        this.courseImage = courseImage;
        this.courseName = courseName;
        this.studyItemTitle = studyItemTitle;
        this.liveDate = liveDate;
        this.liveTime = liveTime;
        this.timing = timing;
        this.isCourse = isCourse;
        this.isPaidCourse = isPaidCourse;
        this.isFreeCourse = isFreeCourse;
        this.imageBanner = imageBanner;
        this.courseTitle = courseTitle;
        this.validity = validity;
        this.price = price;
        this.discount = discount;
        this.originalPrice = originalPrice;
    }

    public Boolean getLiveClass() {
        return this.isLiveClass;
    }

    public void setLiveClass(Boolean liveClass) {
        this.isLiveClass = liveClass;
    }

    public int getCourseImage() {
        return this.courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudyItemTitle() {
        return this.studyItemTitle;
    }

    public void setStudyItemTitle(String studyItemTitle) {
        this.studyItemTitle = studyItemTitle;
    }

    public String getLiveDate() {
        return this.liveDate;
    }

    public void setLiveDate(String liveDate) {
        this.liveDate = liveDate;
    }

    public String getLiveTime() {
        return this.liveTime;
    }

    public void setLiveTime(String liveTime) {
        this.liveTime = liveTime;
    }

    public String getTiming() {
        return this.timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public Boolean getCourse() {
        return this.isCourse;
    }

    public void setCourse(Boolean course) {
        this.isCourse = course;
    }

    public Boolean getPaidCourse() {
        return this.isPaidCourse;
    }

    public void setPaidCourse(Boolean paidCourse) {
        this.isPaidCourse = paidCourse;
    }

    public Boolean getFreeCourse() {
        return this.isFreeCourse;
    }

    public void setFreeCourse(Boolean freeCourse) {
        this.isFreeCourse = freeCourse;
    }

    public int getImageBanner() {
        return this.imageBanner;
    }

    public void setImageBanner(int imageBanner) {
        this.imageBanner = imageBanner;
    }

    public String getCourseTitle() {
        return this.courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getValidity() {
        return this.validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getOriginalPrice() {
        return this.originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
}
