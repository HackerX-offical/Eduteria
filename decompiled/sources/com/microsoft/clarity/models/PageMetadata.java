package com.microsoft.clarity.models;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.SessionMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/microsoft/clarity/models/PageMetadata;", "", "sessionMetadata", "Lcom/microsoft/clarity/models/SessionMetadata;", "pageNum", "", "(Lcom/microsoft/clarity/models/SessionMetadata;I)V", "getPageNum", "()I", "getSessionMetadata", "()Lcom/microsoft/clarity/models/SessionMetadata;", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "toJson", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class PageMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int pageNum;
    private final SessionMetadata sessionMetadata;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/PageMetadata$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/PageMetadata;", "jsoString", "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PageMetadata fromJson(String jsoString) throws JSONException {
            Intrinsics.checkNotNullParameter(jsoString, "jsoString");
            JSONObject jSONObject = new JSONObject(jsoString);
            SessionMetadata.Companion companion = SessionMetadata.INSTANCE;
            String string = jSONObject.getString("sessionMetadata");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"sessionMetadata\")");
            return new PageMetadata(companion.fromJson(string), jSONObject.getInt("pageNum"));
        }
    }

    public PageMetadata(SessionMetadata sessionMetadata, int i) {
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        this.sessionMetadata = sessionMetadata;
        this.pageNum = i;
    }

    public static /* synthetic */ PageMetadata copy$default(PageMetadata pageMetadata, SessionMetadata sessionMetadata, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sessionMetadata = pageMetadata.sessionMetadata;
        }
        if ((i2 & 2) != 0) {
            i = pageMetadata.pageNum;
        }
        return pageMetadata.copy(sessionMetadata, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SessionMetadata getSessionMetadata() {
        return this.sessionMetadata;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    public final PageMetadata copy(SessionMetadata sessionMetadata, int pageNum) {
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        return new PageMetadata(sessionMetadata, pageNum);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageMetadata)) {
            return false;
        }
        PageMetadata pageMetadata = (PageMetadata) other;
        return Intrinsics.areEqual(this.sessionMetadata, pageMetadata.sessionMetadata) && this.pageNum == pageMetadata.pageNum;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final SessionMetadata getSessionMetadata() {
        return this.sessionMetadata;
    }

    public int hashCode() {
        return Integer.hashCode(this.pageNum) + (this.sessionMetadata.hashCode() * 31);
    }

    public final String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sessionMetadata", this.sessionMetadata.toJson());
        jSONObject.put("pageNum", this.pageNum);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        return string;
    }

    public String toString() {
        return b.a("PageMetadata(sessionMetadata=").append(this.sessionMetadata).append(", pageNum=").append(this.pageNum).append(')').toString();
    }
}
