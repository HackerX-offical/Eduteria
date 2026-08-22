package com.appnew.android.table;

import com.appnew.android.Model.ExtendValidity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MycourseTable {
    private int autoid;
    private String batch_id;
    private String batchtype;
    private String cat_type;
    private String combo_course_ids;
    private String content_type;
    private String cover_image;
    private int delete;
    private String descHeaderImage;
    private String expiry_date;
    private String id;
    private String isExpand;
    private String isSelect;
    private String is_activated;
    private String lastread;
    private String mrp;
    private List<ExtendValidity> prices;
    private String purchase_date;
    private String title;
    private String txn_id;
    private String userid;

    @SerializedName("course_view_type")
    @Expose
    private String viewType;

    public int getAutoid() {
        return this.autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
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

    public String getBatch_id() {
        return this.batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getCover_image() {
        return this.cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
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

    public String getMrp() {
        return this.mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    public String getLastread() {
        return this.lastread;
    }

    public void setLastread(String lastread) {
        this.lastread = lastread;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBatchtype() {
        return this.batchtype;
    }

    public void setBatchtype(String batchtype) {
        this.batchtype = batchtype;
    }

    public String getCat_type() {
        return this.cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

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

    public int getDelete() {
        return this.delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public String getContent_type() {
        return this.content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public List<ExtendValidity> getPrices() {
        return this.prices;
    }

    public void setPrices(List<ExtendValidity> prices) {
        this.prices = prices;
    }

    public String getIs_activated() {
        return this.is_activated;
    }

    public void setIs_activated(String is_activated) {
        this.is_activated = is_activated;
    }

    public String getCombo_course_ids() {
        return this.combo_course_ids;
    }

    public void setCombo_course_ids(String combo_course_ids) {
        this.combo_course_ids = combo_course_ids;
    }

    public String getViewType() {
        return this.viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getDescHeaderImage() {
        return this.descHeaderImage;
    }

    public void setDescHeaderImage(String descHeaderImage) {
        this.descHeaderImage = descHeaderImage;
    }
}
