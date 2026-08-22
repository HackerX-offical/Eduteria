package datamodels;

import listfilter.ListFilter;

/* JADX INFO: loaded from: classes9.dex */
public class PayMethodCommonListModel extends ListFilter {
    public int bank_img_id;
    public String bank_name;
    public String unique_code;

    public PayMethodCommonListModel(String str, int i) {
        this.bank_name = str;
        this.bank_img_id = i;
    }

    public PayMethodCommonListModel(String str, int i, String str2) {
        this.bank_name = str;
        this.bank_img_id = i;
        this.unique_code = str2;
    }

    public PayMethodCommonListModel(String str) {
        this.bank_name = str;
    }

    @Override // listfilter.ListFilter
    public boolean filterThisListItem(String str) {
        return this.bank_name.toLowerCase().startsWith(str.toLowerCase());
    }
}
