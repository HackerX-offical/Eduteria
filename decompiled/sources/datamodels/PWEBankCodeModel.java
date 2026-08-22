package datamodels;

import listfilter.ListFilter;

/* JADX INFO: loaded from: classes9.dex */
public class PWEBankCodeModel extends ListFilter {
    public String bank_code;
    public String bank_id;
    public String bank_name;
    public String image_path;

    public String getBank_name() {
        return this.bank_name;
    }

    public void setBank_name(String str) {
        this.bank_name = str;
    }

    public String getBank_code() {
        return this.bank_code;
    }

    public void setBank_code(String str) {
        this.bank_code = str;
    }

    public String getBank_id() {
        return this.bank_id;
    }

    public void setBank_id(String str) {
        this.bank_id = str;
    }

    public String getImage_path() {
        return this.image_path;
    }

    public void setImage_path(String str) {
        this.image_path = str;
    }

    @Override // listfilter.ListFilter
    public boolean filterThisListItem(String str) {
        return this.bank_name.toLowerCase().startsWith(str.toLowerCase());
    }
}
