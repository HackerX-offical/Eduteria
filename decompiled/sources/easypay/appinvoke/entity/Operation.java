package easypay.appinvoke.entity;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class Operation {

    @SerializedName("actionMetadata")
    private String actionMetadata;

    @SerializedName(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE)
    private String actionType;

    @SerializedName("jsTemplate")
    private String jsTemplate;

    public String getJsTemplate() {
        return this.jsTemplate;
    }

    public void setJsTemplate(String str) {
        this.jsTemplate = str;
    }

    public String getActionType() {
        return this.actionType;
    }

    public void setActionType(String str) {
        this.actionType = str;
    }

    public String getActionMetadata() {
        return this.actionMetadata;
    }

    public void setActionMetadata(String str) {
        this.actionMetadata = str;
    }
}
