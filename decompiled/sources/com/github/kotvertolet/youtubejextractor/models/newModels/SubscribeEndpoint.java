package com.github.kotvertolet.youtubejextractor.models.newModels;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SubscribeEndpoint.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0016R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeEndpoint;", "", "()V", "channelIds", "", "", "getChannelIds", "()Ljava/util/List;", "setChannelIds", "(Ljava/util/List;)V", NativeProtocol.WEB_DIALOG_PARAMS, "getParams", "()Ljava/lang/String;", "setParams", "(Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribeEndpoint {

    @SerializedName("channelIds")
    private List<String> channelIds;

    @SerializedName(NativeProtocol.WEB_DIALOG_PARAMS)
    private String params;

    public final List<String> getChannelIds() {
        return this.channelIds;
    }

    public final void setChannelIds(List<String> list) {
        this.channelIds = list;
    }

    public final String getParams() {
        return this.params;
    }

    public final void setParams(String str) {
        this.params = str;
    }

    public String toString() {
        return "SubscribeEndpoint{channelIds = '" + this.channelIds + "',params = '" + this.params + "'}";
    }
}
