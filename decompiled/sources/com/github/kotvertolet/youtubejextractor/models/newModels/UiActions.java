package com.github.kotvertolet.youtubejextractor.models.newModels;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: compiled from: UiActions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/UiActions;", "", "()V", "isHideEnclosingContainer", "", "()Z", "setHideEnclosingContainer", "(Z)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class UiActions {

    @SerializedName("hideEnclosingContainer")
    private boolean isHideEnclosingContainer;

    /* JADX INFO: renamed from: isHideEnclosingContainer, reason: from getter */
    public final boolean getIsHideEnclosingContainer() {
        return this.isHideEnclosingContainer;
    }

    public final void setHideEnclosingContainer(boolean z) {
        this.isHideEnclosingContainer = z;
    }

    public String toString() {
        return "UiActions{hideEnclosingContainer = '" + this.isHideEnclosingContainer + "'}";
    }
}
