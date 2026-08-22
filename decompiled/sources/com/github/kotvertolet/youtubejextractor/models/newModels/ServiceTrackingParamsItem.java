package com.github.kotvertolet.youtubejextractor.models.newModels;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ServiceTrackingParamsItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/ServiceTrackingParamsItem;", "", "()V", NativeProtocol.WEB_DIALOG_PARAMS, "", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ParamsItem;", "getParams", "()Ljava/util/List;", "setParams", "(Ljava/util/List;)V", NotificationCompat.CATEGORY_SERVICE, "", "getService", "()Ljava/lang/String;", "setService", "(Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceTrackingParamsItem {

    @SerializedName(NativeProtocol.WEB_DIALOG_PARAMS)
    private List<ParamsItem> params;

    @SerializedName(NotificationCompat.CATEGORY_SERVICE)
    private String service;

    public final String getService() {
        return this.service;
    }

    public final void setService(String str) {
        this.service = str;
    }

    public final List<ParamsItem> getParams() {
        return this.params;
    }

    public final void setParams(List<ParamsItem> list) {
        this.params = list;
    }

    public String toString() {
        return "ServiceTrackingParamsItem{service = '" + this.service + "',params = '" + this.params + "'}";
    }
}
