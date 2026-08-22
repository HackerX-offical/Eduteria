package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class PrizeCourselist {
    private String avg_rating;

    @SerializedName(Const.BATCH_ID)
    @Expose
    private String batch_id;
    private String color_code;

    @SerializedName("combo_course_ids")
    @Expose
    private String combo_course_ids;
    private String content_type;
    private String course_attribute;
    private String course_sp;
    private String course_view_type;
    private String cover_image;
    private int delete;
    private String desc_header_image;
    Discount discount;
    private String emi_payment;

    @SerializedName("expiry_date")
    @Expose
    private String expiry_date;

    @SerializedName("extra_json")
    @Expose
    private ExtraJson extra_json;
    private String holder_type;
    private String id;
    private String is_activated;
    private String is_live;
    private String is_locked;

    @SerializedName("is_postal_available")
    @Expose
    private String is_postal_available;
    private String is_purchased;
    private String lang_id;

    @SerializedName("lastread")
    @Expose
    private String lastread;
    private String learner;
    private String live_video_count;
    private String maintenance_text;
    private String mrp;
    private String payment_mode;

    @SerializedName(FirebaseAnalytics.Param.PAYMENT_TYPE)
    @Expose
    private String payment_type;

    @SerializedName("prices")
    @Expose
    private List<ExtendValidity> prices;

    @SerializedName("purchase_date")
    @Expose
    private String purchase_date;
    private String segment_information;

    @SerializedName(Const.SKIP_CHAPTER)
    @Expose
    private String skipChapter;

    @SerializedName(Const.SKIP_UNIT)
    @Expose
    private String skipUnit;
    private String subject_id;
    private String subscription_code;
    private String title;
    private String txn_id;
    private String type_id;

    @SerializedName("url")
    @Expose
    private String url;
    private String user_rated;
    private String validity;
    private String cat_type = "";
    private String check_for_expiry = "";
    private String home_screen = "0";
    private boolean isExpand = false;
    private boolean isSelect = false;

    public String getCat_type() {
        return this.cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    public String getContent_type() {
        return this.content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getLive_video_count() {
        return this.live_video_count;
    }

    public void setLive_video_count(String live_video_count) {
        this.live_video_count = live_video_count;
    }

    public String getCover_image() {
        return this.cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
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

    public String getIs_purchased() {
        return this.is_purchased;
    }

    public void setIs_purchased(String is_purchased) {
        this.is_purchased = is_purchased;
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

    public ExtraJson getExtra_json() {
        return this.extra_json;
    }

    public void setExtra_json(ExtraJson extra_json) {
        this.extra_json = extra_json;
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

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean select) {
        this.isSelect = select;
    }

    public String getBatch_id() {
        return this.batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViewType() {
        return this.course_view_type;
    }

    public void setViewType(String viewType) {
        this.course_view_type = viewType;
    }

    public String getHolderType() {
        return this.holder_type;
    }

    public void setHolderType(String holderType) {
        this.holder_type = holderType;
    }

    public String getMaintenanceText() {
        return this.maintenance_text;
    }

    public void setMaintenanceText(String maintenanceText) {
        this.maintenance_text = maintenanceText;
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
        return this.course_attribute;
    }

    public void setCourseAttribute(String courseAttribute) {
        this.course_attribute = courseAttribute;
    }

    public String getDescHeaderImage() {
        return this.desc_header_image;
    }

    public void setDescHeaderImage(String descHeaderImage) {
        this.desc_header_image = descHeaderImage;
    }

    public String getMrp() {
        return this.mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getCourseSp() {
        return this.course_sp;
    }

    public void setCourseSp(String courseSp) {
        this.course_sp = courseSp;
    }

    public String getColorCode() {
        return this.color_code;
    }

    public void setColorCode(String colorCode) {
        this.color_code = colorCode;
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
        return this.is_live;
    }

    public void setIsLive(String isLive) {
        this.is_live = isLive;
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

    public boolean isExpand() {
        return this.isExpand;
    }

    public void setExpand(boolean expand) {
        this.isExpand = expand;
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

    public Discount getDiscount() {
        return this.discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public static class Discount {
        String discount;
        String discount_type;

        public String getDiscount() {
            return this.discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscount_type() {
            return this.discount_type;
        }

        public void setDiscount_type(String discount_type) {
            this.discount_type = discount_type;
        }
    }
}
