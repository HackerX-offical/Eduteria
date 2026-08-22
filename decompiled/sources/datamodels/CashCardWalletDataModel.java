package datamodels;

import listfilter.ListFilter;

/* JADX INFO: loaded from: classes9.dex */
public class CashCardWalletDataModel extends ListFilter {
    public String bank_code;
    public int bank_img_id;
    public String bank_name;
    public String cash_card_id;
    public String cash_card_img_name;
    public String cash_card_img_url;
    public boolean isBankSelected;

    public CashCardWalletDataModel(String str, int i) {
        this.bank_name = str;
        this.bank_img_id = i;
    }

    public CashCardWalletDataModel(String str) {
        this.bank_name = str;
    }

    @Override // listfilter.ListFilter
    public boolean filterThisListItem(String str) {
        return this.bank_name.toLowerCase().startsWith(str.toLowerCase());
    }

    public CashCardWalletDataModel(String str, String str2, String str3, int i, String str4, String str5, boolean z) {
        this.bank_name = str;
        this.cash_card_id = str2;
        this.cash_card_img_url = str3;
        this.bank_img_id = i;
        this.bank_code = str4;
        this.cash_card_img_name = str5;
        this.isBankSelected = z;
    }
}
