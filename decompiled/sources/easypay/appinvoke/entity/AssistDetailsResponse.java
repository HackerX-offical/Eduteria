package easypay.appinvoke.entity;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.gson.annotations.SerializedName;
import easypay.appinvoke.manager.Constants;
import java.util.ArrayList;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: loaded from: classes9.dex */
public class AssistDetailsResponse {

    @SerializedName("bankName")
    private String bank;

    @SerializedName(Constants.EXTRA_BANK_SCHEME)
    private String cardScheme;

    @SerializedName(StreamManagement.Enabled.ELEMENT)
    private Boolean enabled;

    @SerializedName(TransferTable.COLUMN_ETAG)
    private String etag;

    @SerializedName("payMode")
    private String payType;

    @SerializedName("pages")
    private ArrayList<AssistUrlResponse> response = null;

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

    public ArrayList<AssistUrlResponse> getResponse() {
        return this.response;
    }

    public void setResponse(ArrayList<AssistUrlResponse> arrayList) {
        this.response = arrayList;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AssistDetailsResponse)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        AssistDetailsResponse assistDetailsResponse = (AssistDetailsResponse) obj;
        return (getBank() + getPayType() + getCardScheme()).equals(assistDetailsResponse.getBank() + assistDetailsResponse.getPayType() + assistDetailsResponse.getCardScheme());
    }

    public String toString() {
        return getBank() + getPayType() + getCardScheme();
    }
}
