package com.github.kotvertolet.youtubejextractor.models.newModels;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: compiled from: SubscribeAccessibility.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeAccessibility;", "", "()V", "accessibilityData", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/AccessibilityData;", "getAccessibilityData", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/AccessibilityData;", "setAccessibilityData", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/AccessibilityData;)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribeAccessibility {

    @SerializedName("accessibilityData")
    private AccessibilityData accessibilityData;

    public final AccessibilityData getAccessibilityData() {
        return this.accessibilityData;
    }

    public final void setAccessibilityData(AccessibilityData accessibilityData) {
        this.accessibilityData = accessibilityData;
    }

    public String toString() {
        return "SubscribeAccessibility{accessibilityData = '" + this.accessibilityData + "'}";
    }
}
