package com.appnew.android.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class PurchaseHistoryModel implements Serializable {
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return this.data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public static class Data implements Serializable {
        private String address;
        private String admit_card_url;
        private String batch_id;
        private String book_address;

        @SerializedName("book_thumbnail")
        private String book_image;
        private String book_invoice_no;
        private String book_invoice_url;
        private String book_price;
        private String book_title;
        private String cat_type;
        private String coupon;
        private String cover_image;
        private String created;
        private String delivery_address;

        @SerializedName("desc_header_image")
        private String desc_header_image;
        private String email;
        private String emi_no;
        private String emi_payment;
        private String end_date;
        private String expiry_date;
        private String id;
        private String invoice_no;
        private String invoice_url;
        private String location;
        private String mode;
        private String mrp;

        @SerializedName("order_id")
        private String order_id;
        private String payment_id;

        @SerializedName("prices")
        @Expose
        private List<ExtendValidity> prices;
        private String purchase_date;
        private String qty;
        private String shipment_status;
        private String start_date;
        private String status;
        private String subscription_code;
        private String tax;
        private String test_series_name;
        private String title;
        private String track_url;
        private String transaction_status;
        private String txn_id;
        private String upcoming_emi_date;
        private String user_id;
        private String next_date = "";
        private String penalty_paid = "";
        private String paid_on = "";
        private String amount_paid = "";
        private String is_complete = "";
        private String payment_mode = "";
        private String order_status = "";
        private String product_code = "";
        private String pre_transaction_id = "";
        private String upcoming_emi_amount = "";
        private String dues = "";
        private String panelty_amount = "";
        private String is_subscription = "";
        private String razorpay_subscription_code = "";
        private String subscription_status = "";

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

        public String getCover_image() {
            return this.cover_image;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public String getBatch_id() {
            return this.batch_id;
        }

        public void setBatch_id(String batch_id) {
            this.batch_id = batch_id;
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

        public String getInvoice_no() {
            return this.invoice_no;
        }

        public void setInvoice_no(String invoice_no) {
            this.invoice_no = invoice_no;
        }

        public String getPayment_id() {
            return this.payment_id;
        }

        public void setPayment_id(String payment_id) {
            this.payment_id = payment_id;
        }

        public String getCat_type() {
            return this.cat_type;
        }

        public void setCat_type(String cat_type) {
            this.cat_type = cat_type;
        }

        public String getSubscription_code() {
            return this.subscription_code;
        }

        public void setSubscription_code(String subscription_code) {
            this.subscription_code = subscription_code;
        }

        public String getAdmit_card_url() {
            return this.admit_card_url;
        }

        public void setAdmit_card_url(String admit_card_url) {
            this.admit_card_url = admit_card_url;
        }

        public String getIs_subscription() {
            return this.is_subscription;
        }

        public void setIs_subscription(String is_subscription) {
            this.is_subscription = is_subscription;
        }

        public String getTrack_url() {
            return this.track_url;
        }

        public void setTrack_url(String track_url) {
            this.track_url = track_url;
        }

        public String getShipment_status() {
            return this.shipment_status;
        }

        public void setShipment_status(String shipment_status) {
            this.shipment_status = shipment_status;
        }

        public String getEmi_no() {
            return this.emi_no;
        }

        public void setEmi_no(String emi_no) {
            this.emi_no = emi_no;
        }

        public String getLocation() {
            return this.location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getMode() {
            return this.mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getTest_series_name() {
            return this.test_series_name;
        }

        public void setTest_series_name(String test_series_name) {
            this.test_series_name = test_series_name;
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStart_date() {
            return this.start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public String getEnd_date() {
            return this.end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public String getDesc_header_image() {
            return this.desc_header_image;
        }

        public void setDesc_header_image(String desc_header_image) {
            this.desc_header_image = desc_header_image;
        }

        public String getBook_image() {
            return this.book_image;
        }

        public void setBook_image(String book_image) {
            this.book_image = book_image;
        }

        public String getOrder_id() {
            return this.order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getEmi_payment() {
            return this.emi_payment;
        }

        public void setEmi_payment(String emi_payment) {
            this.emi_payment = emi_payment;
        }

        public String getInvoice_url() {
            return this.invoice_url;
        }

        public void setInvoice_url(String invoice_url) {
            this.invoice_url = invoice_url;
        }

        public String getBook_invoice_no() {
            return this.book_invoice_no;
        }

        public void setBook_invoice_no(String book_invoice_no) {
            this.book_invoice_no = book_invoice_no;
        }

        public String getBook_invoice_url() {
            return this.book_invoice_url;
        }

        public void setBook_invoice_url(String book_invoice_url) {
            this.book_invoice_url = book_invoice_url;
        }

        public String getBook_address() {
            return this.book_address;
        }

        public void setBook_address(String book_address) {
            this.book_address = book_address;
        }

        public String getTax() {
            return this.tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getUpcoming_emi_date() {
            return this.upcoming_emi_date;
        }

        public void setUpcoming_emi_date(String upcoming_emi_date) {
            this.upcoming_emi_date = upcoming_emi_date;
        }

        public String getPanelty_amount() {
            return this.panelty_amount;
        }

        public void setPanelty_amount(String panelty_amount) {
            this.panelty_amount = panelty_amount;
        }

        public String getDues() {
            return this.dues;
        }

        public void setDues(String dues) {
            this.dues = dues;
        }

        public String getUpcoming_emi_amount() {
            return this.upcoming_emi_amount;
        }

        public void setUpcoming_emi_amount(String upcoming_emi_amount) {
            this.upcoming_emi_amount = upcoming_emi_amount;
        }

        public String getOrder_status() {
            return this.order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public String getProduct_code() {
            return this.product_code;
        }

        public void setProduct_code(String product_code) {
            this.product_code = product_code;
        }

        public String getPre_transaction_id() {
            return this.pre_transaction_id;
        }

        public void setPre_transaction_id(String pre_transaction_id) {
            this.pre_transaction_id = pre_transaction_id;
        }

        public String getTransaction_status() {
            return this.transaction_status;
        }

        public void setTransaction_status(String transaction_status) {
            this.transaction_status = transaction_status;
        }

        public List<ExtendValidity> getPrices() {
            return this.prices;
        }

        public void setPrices(List<ExtendValidity> prices) {
            this.prices = prices;
        }

        public String getNext_date() {
            return this.next_date;
        }

        public void setNext_date(String next_date) {
            this.next_date = next_date;
        }

        public String getPenalty_paid() {
            return this.penalty_paid;
        }

        public void setPenalty_paid(String penalty_paid) {
            this.penalty_paid = penalty_paid;
        }

        public String getPaid_on() {
            return this.paid_on;
        }

        public void setPaid_on(String paid_on) {
            this.paid_on = paid_on;
        }

        public String getAmount_paid() {
            return this.amount_paid;
        }

        public void setAmount_paid(String amount_paid) {
            this.amount_paid = amount_paid;
        }

        public String getIs_complete() {
            return this.is_complete;
        }

        public void setIs_complete(String is_complete) {
            this.is_complete = is_complete;
        }

        public String getPayment_mode() {
            return this.payment_mode;
        }

        public void setPayment_mode(String payment_mode) {
            this.payment_mode = payment_mode;
        }

        public String getUser_id() {
            return this.user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBook_title() {
            return this.book_title;
        }

        public void setBook_title(String book_title) {
            this.book_title = book_title;
        }

        public String getBook_price() {
            return this.book_price;
        }

        public void setBook_price(String book_price) {
            this.book_price = book_price;
        }

        public String getDelivery_address() {
            return this.delivery_address;
        }

        public void setDelivery_address(String delivery_address) {
            this.delivery_address = delivery_address;
        }

        public String getCoupon() {
            return this.coupon;
        }

        public void setCoupon(String coupon) {
            this.coupon = coupon;
        }

        public String getQty() {
            return this.qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getCreated() {
            return this.created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRazorpay_subscription_code() {
            return this.razorpay_subscription_code;
        }

        public void setRazorpay_subscription_code(String razorpay_subscription_code) {
            this.razorpay_subscription_code = razorpay_subscription_code;
        }

        public String getSubscription_status() {
            return this.subscription_status;
        }

        public void setSubscription_status(String subscription_status) {
            this.subscription_status = subscription_status;
        }
    }
}
