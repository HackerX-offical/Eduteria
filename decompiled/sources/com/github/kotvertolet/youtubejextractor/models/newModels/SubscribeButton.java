package com.github.kotvertolet.youtubejextractor.models.newModels;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: compiled from: SubscribeButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeButton;", "", "()V", "subscribeButtonRenderer", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeButtonRenderer;", "getSubscribeButtonRenderer", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeButtonRenderer;", "setSubscribeButtonRenderer", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeButtonRenderer;)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribeButton {

    @SerializedName("subscribeButtonRenderer")
    private SubscribeButtonRenderer subscribeButtonRenderer;

    public final SubscribeButtonRenderer getSubscribeButtonRenderer() {
        return this.subscribeButtonRenderer;
    }

    public final void setSubscribeButtonRenderer(SubscribeButtonRenderer subscribeButtonRenderer) {
        this.subscribeButtonRenderer = subscribeButtonRenderer;
    }

    public String toString() {
        return "SubscribeButton{subscribeButtonRenderer = '" + this.subscribeButtonRenderer + "'}";
    }
}
