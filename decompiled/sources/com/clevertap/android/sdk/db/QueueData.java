package com.clevertap.android.sdk.db;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: compiled from: QueueData.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/clevertap/android/sdk/db/QueueData;", "", "<init>", "()V", "data", "Lorg/json/JSONArray;", "getData$clevertap_core_release", "()Lorg/json/JSONArray;", "eventIds", "", "", "getEventIds$clevertap_core_release", "()Ljava/util/List;", "profileEventIds", "getProfileEventIds$clevertap_core_release", "hasMore", "", "getHasMore$clevertap_core_release", "()Z", "setHasMore$clevertap_core_release", "(Z)V", "isEmpty", "isEmpty$clevertap_core_release", "hasEvents", "getHasEvents$clevertap_core_release", "hasProfileEvents", "getHasProfileEvents$clevertap_core_release", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QueueData {
    private boolean hasMore;
    private final JSONArray data = new JSONArray();
    private final List<String> eventIds = new ArrayList();
    private final List<String> profileEventIds = new ArrayList();

    /* JADX INFO: renamed from: getData$clevertap_core_release, reason: from getter */
    public final JSONArray getData() {
        return this.data;
    }

    public final List<String> getEventIds$clevertap_core_release() {
        return this.eventIds;
    }

    public final List<String> getProfileEventIds$clevertap_core_release() {
        return this.profileEventIds;
    }

    /* JADX INFO: renamed from: getHasMore$clevertap_core_release, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final void setHasMore$clevertap_core_release(boolean z) {
        this.hasMore = z;
    }

    public final boolean isEmpty$clevertap_core_release() {
        return this.data.length() <= 0;
    }

    public final boolean getHasEvents$clevertap_core_release() {
        return !this.eventIds.isEmpty();
    }

    public final boolean getHasProfileEvents$clevertap_core_release() {
        return !this.profileEventIds.isEmpty();
    }

    public String toString() {
        return "QueueData: numItems=" + this.data.length() + ", eventIds=" + this.eventIds.size() + ", profileEventIds=" + this.profileEventIds.size();
    }
}
