package com.appnew.android.Model.COURSEDETAIL;

import com.appnew.android.Model.ExtraJson;
import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CourseDetailData implements Serializable {

    @SerializedName("author")
    @Expose
    private Author author;

    @SerializedName("avg_rating")
    @Expose
    private String avg_rating;

    @SerializedName("book_redirection_link")
    @Expose
    private String book_redirection_link;

    @SerializedName("cat_type")
    @Expose
    private String cat_type;

    @SerializedName("combo_has_book")
    @Expose
    private String combo_has_book;

    @SerializedName("course_sp")
    @Expose
    private String courseSp;

    @SerializedName("course_code")
    @Expose
    private String course_code;

    @SerializedName("cover_image")
    @Expose
    private String cover_image;

    @SerializedName(Const.DELIVERY_CHARGE)
    @Expose
    private String delivery_charge;

    @SerializedName("desc_header_image")
    @Expose
    private String descHeaderImage;

    @SerializedName("description")
    @Expose
    private String description = "";

    @SerializedName("display_locked")
    @Expose
    private String display_locked;
    private String external_coupon_off;

    @SerializedName("extra_json")
    @Expose
    private ExtraJson extra_json;

    @SerializedName("hide_validity")
    @Expose
    private String hide_validity;

    @Expose
    private String id;
    private String installment;

    @SerializedName("is_purchased")
    @Expose
    private String isPurchased;

    @SerializedName("is_activated")
    @Expose
    private String is_activated;

    @SerializedName(Const.IS_COMBO)
    @Expose
    private String is_combo;

    @SerializedName("is_gst")
    @Expose
    private String is_gst;

    @SerializedName("is_trial")
    @Expose
    private String is_trial;

    @SerializedName("last_paid_txn_id")
    @Expose
    private String last_paid_txn_id;

    @SerializedName("mrp")
    @Expose
    private String mrp;

    @SerializedName("skip_payment")
    @Expose
    private String skip_payment;

    @SerializedName("stocks")
    @Expose
    private String stocks;

    @SerializedName("tax")
    @Expose
    private String tax;

    @SerializedName("tax_rate")
    @Expose
    private String tax_rate;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("token_activation")
    @Expose
    private String token_activation;
    private String transaction_status;

    @SerializedName("txn_id")
    @Expose
    private String txn_id;

    @SerializedName("user_rated")
    @Expose
    private String user_rated;

    @SerializedName("valid_to")
    @Expose
    private String valid_to;

    @SerializedName("validity")
    @Expose
    private String validity;

    @SerializedName("view_type")
    @Expose
    private String viewType;

    public String getBook_redirection_link() {
        return this.book_redirection_link;
    }

    public void setBook_redirection_link(String book_redirection_link) {
        this.book_redirection_link = book_redirection_link;
    }

    public String getValid_to() {
        return this.valid_to;
    }

    public void setValid_to(String valid_to) {
        this.valid_to = valid_to;
    }

    public String getInstallment() {
        return this.installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getTransaction_status() {
        return this.transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getHide_validity() {
        return this.hide_validity;
    }

    public void setHide_validity(String hide_validity) {
        this.hide_validity = hide_validity;
    }

    public String getToken_activation() {
        return this.token_activation;
    }

    public void setToken_activation(String token_activation) {
        this.token_activation = token_activation;
    }

    public String getIs_activated() {
        return this.is_activated;
    }

    public void setIs_activated(String is_activated) {
        this.is_activated = is_activated;
    }

    public String getDisplay_locked() {
        return this.display_locked;
    }

    public void setDisplay_locked(String display_locked) {
        this.display_locked = display_locked;
    }

    public String getViewType() {
        return this.viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTax_rate() {
        return this.tax_rate;
    }

    public void setTax_rate(String tax_rate) {
        this.tax_rate = tax_rate;
    }

    public String getCombo_has_book() {
        return this.combo_has_book;
    }

    public void setCombo_has_book(String combo_has_book) {
        this.combo_has_book = combo_has_book;
    }

    public String getUser_rated() {
        return this.user_rated;
    }

    public void setUser_rated(String user_rated) {
        this.user_rated = user_rated;
    }

    public String getAvg_rating() {
        return this.avg_rating;
    }

    public void setAvg_rating(String avg_rating) {
        this.avg_rating = avg_rating;
    }

    public String getStocks() {
        return this.stocks;
    }

    public void setStocks(String stocks) {
        this.stocks = stocks;
    }

    public String getExternal_coupon_off() {
        return this.external_coupon_off;
    }

    public void setExternal_coupon_off(String external_coupon_off) {
        this.external_coupon_off = external_coupon_off;
    }

    public String getCourse_code() {
        return this.course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getIs_gst() {
        return this.is_gst;
    }

    public void setIs_gst(String is_gst) {
        this.is_gst = is_gst;
    }

    public String getDelivery_charge() {
        return this.delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getCat_type() {
        return this.cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

    public String getSkip_payment() {
        return this.skip_payment;
    }

    public void setSkip_payment(String skip_payment) {
        this.skip_payment = skip_payment;
    }

    public String getId() {
        return this.id;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getIsPurchased() {
        return this.isPurchased;
    }

    public void setIsPurchased(String isPurchased) {
        this.isPurchased = isPurchased;
    }

    public String getCover_image() {
        return this.cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getIs_combo() {
        return this.is_combo;
    }

    public void setIs_combo(String is_combo) {
        this.is_combo = is_combo;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIs_trial() {
        return this.is_trial;
    }

    public void setIs_trial(String is_trial) {
        this.is_trial = is_trial;
    }

    public String getLast_paid_txn_id() {
        return this.last_paid_txn_id;
    }

    public void setLast_paid_txn_id(String last_paid_txn_id) {
        this.last_paid_txn_id = last_paid_txn_id;
    }

    public ExtraJson getExtra_json() {
        return this.extra_json;
    }

    public void setExtra_json(ExtraJson extra_json) {
        this.extra_json = extra_json;
    }
}
