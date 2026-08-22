package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class DueEmiTable implements Serializable {
    private int auto_id;

    @SerializedName("avg_rating")
    @Expose
    private String avg_rating;

    @SerializedName(Const.BATCH_ID)
    @Expose
    private String batch_id;

    @SerializedName(Const.COLOR_CODE)
    @Expose
    private String colorCode;

    @SerializedName("combo_course_ids")
    @Expose
    private String combo_course_ids;

    @SerializedName("course_attribute")
    @Expose
    private String courseAttribute;

    @SerializedName("course_sp")
    @Expose
    private String courseSp;

    @SerializedName("cover_image")
    @Expose
    private String cover_image;

    @SerializedName("delete")
    @Expose
    private int delete;

    @SerializedName("desc_header_image")
    @Expose
    private String descHeaderImage;

    @SerializedName("emi_payment")
    @Expose
    private String emi_payment;

    @SerializedName("expiry_date")
    @Expose
    private String expiry_date;

    @SerializedName("holder_type")
    @Expose
    private String holderType;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_live")
    @Expose
    private String isLive;

    @SerializedName("is_activated")
    @Expose
    private String is_activated;
    private String is_locked;

    @SerializedName("is_postal_available")
    @Expose
    private String is_postal_available;

    @SerializedName("lang_id")
    @Expose
    private String lang_id;

    @SerializedName("lastread")
    @Expose
    private String lastread;

    @SerializedName("learner")
    @Expose
    private String learner;

    @SerializedName("maintenance_text")
    @Expose
    private String maintenanceText;

    @SerializedName("mrp")
    @Expose
    private String mrp;

    @SerializedName("payment_mode")
    @Expose
    private String payment_mode;

    @SerializedName(FirebaseAnalytics.Param.PAYMENT_TYPE)
    @Expose
    private String payment_type;
    private List<ExtendValidity> prices;

    @SerializedName("purchase_date")
    @Expose
    private String purchase_date;

    @SerializedName("segment_information")
    @Expose
    private String segment_information;

    @SerializedName(Const.SKIP_CHAPTER)
    @Expose
    private String skipChapter;

    @SerializedName(Const.SKIP_UNIT)
    @Expose
    private String skipUnit;

    @SerializedName(Const.SUBJECT_ID)
    @Expose
    private String subject_id;

    @SerializedName("subscription_code")
    @Expose
    private String subscription_code;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("txn_id")
    @Expose
    private String txn_id;

    @SerializedName("type_id")
    @Expose
    private String type_id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("user_rated")
    @Expose
    private String user_rated;

    @SerializedName("validity")
    @Expose
    private String validity;

    @SerializedName("view_type")
    @Expose
    private String viewType;
    private String isSelect = "";
    private String isExpand = "";
    private String check_for_expiry = "";
    private String home_screen = "0";

    public String getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(String isSelect) {
        this.isSelect = isSelect;
    }

    public String getIsExpand() {
        return this.isExpand;
    }

    public void setIsExpand(String isExpand) {
        this.isExpand = isExpand;
    }

    public String getCover_image() {
        return this.cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public int getAuto_id() {
        return this.auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    public String getAvg_rating() {
        return this.avg_rating;
    }

    public void setAvg_rating(String avg_rating) {
        this.avg_rating = avg_rating;
    }

    public String getUser_rated() {
        return this.user_rated;
    }

    public void setUser_rated(String user_rated) {
        this.user_rated = user_rated;
    }

    public String getIs_activated() {
        return this.is_activated;
    }

    public void setIs_activated(String is_activated) {
        this.is_activated = is_activated;
    }

    public String getCheck_for_expiry() {
        return this.check_for_expiry;
    }

    public void setCheck_for_expiry(String check_for_expiry) {
        this.check_for_expiry = check_for_expiry;
    }

    public String getCombo_course_ids() {
        return this.combo_course_ids;
    }

    public void setCombo_course_ids(String combo_course_ids) {
        this.combo_course_ids = combo_course_ids;
    }

    public List<ExtendValidity> getPrices() {
        return this.prices;
    }

    public void setPrices(List<ExtendValidity> prices) {
        this.prices = prices;
    }

    public String getBatch_id() {
        return this.batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getHome_screen() {
        return this.home_screen;
    }

    public void setHome_screen(String home_screen) {
        this.home_screen = home_screen;
    }

    public String getIs_locked() {
        return this.is_locked;
    }

    public void setIs_locked(String is_locked) {
        this.is_locked = is_locked;
    }

    public String getLastread() {
        return this.lastread;
    }

    public void setLastread(String lastread) {
        this.lastread = lastread;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViewType() {
        return this.viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getHolderType() {
        return this.holderType;
    }

    public void setHolderType(String holderType) {
        this.holderType = holderType;
    }

    public String getMaintenanceText() {
        return this.maintenanceText;
    }

    public void setMaintenanceText(String maintenanceText) {
        this.maintenanceText = maintenanceText;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSegment_information() {
        return this.segment_information;
    }

    public void setSegment_information(String segment_information) {
        this.segment_information = segment_information;
    }

    public String getCourseAttribute() {
        return this.courseAttribute;
    }

    public void setCourseAttribute(String courseAttribute) {
        this.courseAttribute = courseAttribute;
    }

    public String getDescHeaderImage() {
        return this.descHeaderImage;
    }

    public void setDescHeaderImage(String descHeaderImage) {
        this.descHeaderImage = descHeaderImage;
    }

    public String getMrp() {
        return this.mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getCourseSp() {
        return this.courseSp;
    }

    public void setCourseSp(String courseSp) {
        this.courseSp = courseSp;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getLearner() {
        return this.learner;
    }

    public void setLearner(String learner) {
        this.learner = learner;
    }

    public String getIsLive() {
        return this.isLive;
    }

    public void setIsLive(String isLive) {
        this.isLive = isLive;
    }

    public String getSkipUnit() {
        return this.skipUnit;
    }

    public void setSkipUnit(String skipUnit) {
        this.skipUnit = skipUnit;
    }

    public String getSkipChapter() {
        return this.skipChapter;
    }

    public void setSkipChapter(String skipChapter) {
        this.skipChapter = skipChapter;
    }

    public String getPayment_type() {
        return this.payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getIs_postal_available() {
        return this.is_postal_available;
    }

    public void setIs_postal_available(String is_postal_available) {
        this.is_postal_available = is_postal_available;
    }

    public String getExpiry_date() {
        return this.expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getPurchase_date() {
        return this.purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLang_id() {
        return this.lang_id;
    }

    public void setLang_id(String lang_id) {
        this.lang_id = lang_id;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getType_id() {
        return this.type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public int getDelete() {
        return this.delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public String getPayment_mode() {
        return this.payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public String getEmi_payment() {
        return this.emi_payment;
    }

    public void setEmi_payment(String emi_payment) {
        this.emi_payment = emi_payment;
    }

    public String getSubscription_code() {
        return this.subscription_code;
    }

    public void setSubscription_code(String subscription_code) {
        this.subscription_code = subscription_code;
    }
}
