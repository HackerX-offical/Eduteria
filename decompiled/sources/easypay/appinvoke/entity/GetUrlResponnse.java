package easypay.appinvoke.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class GetUrlResponnse {

    @SerializedName("responseCode")
    private int responseCode;

    @SerializedName("responseMessage")
    private String responseMessage;

    @SerializedName("url")
    private String responseUrl;

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public String getResponseUrl() {
        return this.responseUrl;
    }

    public void setResponseUrl(String str) {
        this.responseUrl = str;
    }
}
