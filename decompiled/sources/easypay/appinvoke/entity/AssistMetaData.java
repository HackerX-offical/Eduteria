package easypay.appinvoke.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class AssistMetaData {

    @SerializedName("fieldHtml")
    private String fieldHtml;

    @SerializedName("jsField")
    private String jsField;

    @SerializedName("msgKeywords")
    private String msgKeywords;

    @SerializedName("msgPattern")
    private String msgPattern;

    @SerializedName("msgSender")
    private String msgSender;

    @SerializedName("passwordId")
    private String passwordId;

    @SerializedName("userId")
    private String userId;

    public String getFieldHtml() {
        return this.fieldHtml;
    }

    public void setFieldHtml(String str) {
        this.fieldHtml = str;
    }

    public String getMsgPattern() {
        return this.msgPattern;
    }

    public void setMsgPattern(String str) {
        this.msgPattern = str;
    }

    public String getJsField() {
        return this.jsField;
    }

    public void setJsField(String str) {
        this.jsField = str;
    }

    public String getMsgKeywords() {
        return this.msgKeywords;
    }

    public void setMsgKeywords(String str) {
        this.msgKeywords = str;
    }

    public String getMsgSender() {
        return this.msgSender;
    }

    public void setMsgSender(String str) {
        this.msgSender = str;
    }

    public String getPasswordId() {
        return this.passwordId;
    }

    public void setPasswordId(String str) {
        this.passwordId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
