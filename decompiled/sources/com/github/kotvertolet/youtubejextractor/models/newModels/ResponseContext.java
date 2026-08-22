package com.github.kotvertolet.youtubejextractor.models.newModels;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ResponseContext.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/ResponseContext;", "", "()V", "mainAppWebResponseContext", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/MainAppWebResponseContext;", "getMainAppWebResponseContext", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/MainAppWebResponseContext;", "setMainAppWebResponseContext", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/MainAppWebResponseContext;)V", "serviceTrackingParams", "", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ServiceTrackingParamsItem;", "getServiceTrackingParams", "()Ljava/util/List;", "setServiceTrackingParams", "(Ljava/util/List;)V", "webResponseContextExtensionData", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebResponseContextExtensionData;", "getWebResponseContextExtensionData", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebResponseContextExtensionData;", "setWebResponseContextExtensionData", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/WebResponseContextExtensionData;)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class ResponseContext {

    @SerializedName("mainAppWebResponseContext")
    private MainAppWebResponseContext mainAppWebResponseContext;

    @SerializedName("serviceTrackingParams")
    private List<ServiceTrackingParamsItem> serviceTrackingParams;

    @SerializedName("webResponseContextExtensionData")
    private WebResponseContextExtensionData webResponseContextExtensionData;

    public final List<ServiceTrackingParamsItem> getServiceTrackingParams() {
        return this.serviceTrackingParams;
    }

    public final void setServiceTrackingParams(List<ServiceTrackingParamsItem> list) {
        this.serviceTrackingParams = list;
    }

    public final WebResponseContextExtensionData getWebResponseContextExtensionData() {
        return this.webResponseContextExtensionData;
    }

    public final void setWebResponseContextExtensionData(WebResponseContextExtensionData webResponseContextExtensionData) {
        this.webResponseContextExtensionData = webResponseContextExtensionData;
    }

    public final MainAppWebResponseContext getMainAppWebResponseContext() {
        return this.mainAppWebResponseContext;
    }

    public final void setMainAppWebResponseContext(MainAppWebResponseContext mainAppWebResponseContext) {
        this.mainAppWebResponseContext = mainAppWebResponseContext;
    }

    public String toString() {
        return "ResponseContext{serviceTrackingParams = '" + this.serviceTrackingParams + "',webResponseContextExtensionData = '" + this.webResponseContextExtensionData + "',mainAppWebResponseContext = '" + this.mainAppWebResponseContext + "'}";
    }
}
