package datamodels;

import listfilter.ListFilter;

/* JADX INFO: loaded from: classes9.dex */
public class DebitAtmPinBankModel extends ListFilter {
    public String bank_id;
    public int bank_img_id;
    public String bank_name;
    public String image_name;
    public String image_path;

    public DebitAtmPinBankModel(String str, String str2, String str3) {
        this.bank_name = str;
        this.bank_id = str2;
        this.image_path = str3;
    }

    @Override // listfilter.ListFilter
    public boolean filterThisListItem(String str) {
        return this.bank_name.toLowerCase().startsWith(str.toLowerCase());
    }
}
