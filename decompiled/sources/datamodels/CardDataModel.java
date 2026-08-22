package datamodels;

/* JADX INFO: loaded from: classes9.dex */
public class CardDataModel {
    public int card_id;
    public String card_str;
    public String card_type;
    public String cvv;

    public CardDataModel(int i, String str, String str2) {
        this.card_id = i;
        this.card_str = str;
        this.card_type = str2;
    }

    public CardDataModel(int i, String str, String str2, String str3) {
        this.card_id = i;
        this.card_str = str;
        this.card_type = str2;
        this.cvv = str3;
    }
}
