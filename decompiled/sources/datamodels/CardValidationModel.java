package datamodels;

/* JADX INFO: loaded from: classes9.dex */
public class CardValidationModel {
    int card_image;
    String card_reg_exp;
    String card_type;
    String card_type_image;
    boolean luhnFlag;

    public CardValidationModel(String str, String str2, int i) {
        this.card_type = str;
        this.card_reg_exp = str2;
        this.card_image = i;
    }

    public CardValidationModel(String str, String str2, int i, boolean z) {
        this.card_type = str;
        this.card_reg_exp = str2;
        this.card_image = i;
        this.luhnFlag = z;
    }

    public CardValidationModel(String str, String str2, int i, boolean z, String str3) {
        this.card_type = str;
        this.card_reg_exp = str2;
        this.card_image = i;
        this.luhnFlag = z;
        this.card_type_image = str3;
    }

    public CardValidationModel() {
    }

    public String getCard_type() {
        return this.card_type;
    }

    public void setCard_type(String str) {
        this.card_type = str;
    }

    public String getCard_reg_exp() {
        return this.card_reg_exp;
    }

    public void setCard_reg_exp(String str) {
        this.card_reg_exp = str;
    }

    public int getDefaultCard_image() {
        return this.card_image;
    }

    public void setDefaultCardImage(int i) {
        this.card_image = i;
    }

    public boolean isLuhnFlag() {
        return this.luhnFlag;
    }

    public void setLuhnFlag(boolean z) {
        this.luhnFlag = z;
    }

    public String getCard_type_image() {
        return this.card_type_image;
    }

    public void setCard_type_image(String str) {
        this.card_type_image = str;
    }
}
