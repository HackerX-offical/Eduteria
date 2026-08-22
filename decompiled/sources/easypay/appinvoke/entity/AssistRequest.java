package easypay.appinvoke.entity;

import com.google.gson.annotations.SerializedName;
import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes9.dex */
public class AssistRequest {

    @SerializedName("bank")
    private String bank;

    @SerializedName(Constants.EXTRA_BANK_SCHEME)
    private String cardScheme;

    @SerializedName(Constants.EXTRA_BANK_PAYTYPE)
    private String payType;

    public String getCardScheme() {
        return this.cardScheme;
    }

    public void setCardScheme(String str) {
        this.cardScheme = str;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String str) {
        this.bank = str;
    }

    public String getPayType() {
        return this.payType;
    }

    public void setPayType(String str) {
        this.payType = str;
    }
}
