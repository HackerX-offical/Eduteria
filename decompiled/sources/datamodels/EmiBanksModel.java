package datamodels;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class EmiBanksModel {
    String bank_code;
    String bank_display_name;
    String bank_image_name;
    private String bank_logo;
    ArrayList<EmiPlansModel> emi_list;
    String id;

    public EmiBanksModel(String str, String str2, String str3, String str4, ArrayList<EmiPlansModel> arrayList) {
        new ArrayList();
        this.id = str;
        this.bank_display_name = str2;
        this.bank_code = str3;
        this.bank_logo = str4;
        this.emi_list = arrayList;
    }

    public EmiBanksModel() {
        this.emi_list = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getBank_display_name() {
        return this.bank_display_name;
    }

    public void setBank_display_name(String str) {
        this.bank_display_name = str;
    }

    public String getBank_code() {
        return this.bank_code;
    }

    public void setBank_code(String str) {
        this.bank_code = str;
    }

    public String getBank_logo() {
        return this.bank_logo;
    }

    public void setBank_logo(String str) {
        this.bank_logo = str;
    }

    public ArrayList<EmiPlansModel> getEmi_list() {
        return this.emi_list;
    }

    public void setEmi_list(ArrayList<EmiPlansModel> arrayList) {
        this.emi_list = arrayList;
    }

    public String getBank_image_name() {
        return this.bank_image_name;
    }

    public void setBank_image_name(String str) {
        this.bank_image_name = str;
    }
}
