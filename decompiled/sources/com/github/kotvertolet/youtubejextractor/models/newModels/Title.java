package com.github.kotvertolet.youtubejextractor.models.newModels;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: compiled from: Title.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/Title;", "", "()V", "simpleText", "", "getSimpleText", "()Ljava/lang/String;", "setSimpleText", "(Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class Title {

    @SerializedName("simpleText")
    private String simpleText;

    public final String getSimpleText() {
        return this.simpleText;
    }

    public final void setSimpleText(String str) {
        this.simpleText = str;
    }

    public String toString() {
        return "Title{simpleText = '" + this.simpleText + "'}";
    }
}
