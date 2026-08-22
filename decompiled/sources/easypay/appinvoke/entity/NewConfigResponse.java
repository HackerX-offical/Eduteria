package easypay.appinvoke.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class NewConfigResponse {

    @SerializedName("assistBaseSRO")
    private AssistDetailsResponse assistBaseSRO;

    @SerializedName("responseCode")
    private Integer responseCode;

    @SerializedName("responseMessage")
    private String responseMessage;

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public AssistDetailsResponse getAssistBaseSRO() {
        return this.assistBaseSRO;
    }

    public void setAssistBaseSRO(AssistDetailsResponse assistDetailsResponse) {
        this.assistBaseSRO = assistDetailsResponse;
    }
}
