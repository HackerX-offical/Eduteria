package datamodels;

/* JADX INFO: loaded from: classes9.dex */
public class PWEPaymentOptionDataModel {
    int display_icon;
    String display_name;
    String display_note;
    String payment_option_key;
    String payment_option_name;

    public PWEPaymentOptionDataModel() {
        this.payment_option_name = "";
        this.payment_option_key = "";
        this.display_name = "";
        this.display_note = "";
        this.display_icon = -1;
    }

    public PWEPaymentOptionDataModel(String str, String str2, String str3, int i, String str4) {
        this.payment_option_name = str;
        this.payment_option_key = str2;
        this.display_name = str3;
        this.display_icon = i;
        this.display_note = str4;
    }

    public String getPayment_option_key() {
        return this.payment_option_key;
    }

    public String getDisplay_name() {
        return this.display_name;
    }

    public String getDisplay_note() {
        return this.display_note;
    }

    public int getDisplay_icon() {
        return this.display_icon;
    }

    public String getPayment_option_name() {
        return this.payment_option_name;
    }

    public void setPayment_option_name(String str) {
        this.payment_option_name = str;
    }

    public void setPayment_option_key(String str) {
        this.payment_option_key = str;
    }

    public void setDisplay_name(String str) {
        this.display_name = str;
    }

    public void setDisplay_note(String str) {
        this.display_note = str;
    }

    public void setDisplay_icon(int i) {
        this.display_icon = i;
    }
}
