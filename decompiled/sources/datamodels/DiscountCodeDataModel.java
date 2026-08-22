package datamodels;

/* JADX INFO: loaded from: classes9.dex */
public class DiscountCodeDataModel {
    public String discount_code;
    public String discount_code_id;
    public String discount_description;
    public String payment_mode;

    public String getDiscount_code_id() {
        return this.discount_code_id;
    }

    public void setDiscount_code_id(String str) {
        this.discount_code_id = str;
    }

    public String getDiscount_code() {
        return this.discount_code;
    }

    public void setDiscount_code(String str) {
        this.discount_code = str;
    }

    public String getPayment_mode() {
        return this.payment_mode;
    }

    public void setPayment_mode(String str) {
        this.payment_mode = str;
    }

    public String getDiscount_description() {
        return this.discount_description;
    }

    public void setDiscount_description(String str) {
        this.discount_description = str;
    }

    public DiscountCodeDataModel(String str, String str2, String str3, String str4) {
        this.discount_code_id = str;
        this.discount_code = str2;
        this.payment_mode = str3;
        this.discount_description = str4;
    }

    public DiscountCodeDataModel() {
    }
}
