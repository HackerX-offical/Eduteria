package com.microsoft.clarity.models.telemetry;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jo\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Lcom/microsoft/clarity/models/telemetry/ErrorReport;", "", "version", "", "projectId", "userId", "sessionId", "pageNum", "", "errorType", "message", "stack", "timestamp", "sourcePlatform", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getErrorType", "()Ljava/lang/String;", "getMessage", "getPageNum", "()I", "getProjectId", "getSessionId", "getSourcePlatform", "getStack", "getTimestamp", "getUserId", "getVersion", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "toJson", InAppPurchaseConstants.METHOD_TO_STRING, "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ErrorReport {
    private final String errorType;
    private final String message;
    private final int pageNum;
    private final String projectId;
    private final String sessionId;
    private final int sourcePlatform;
    private final String stack;
    private final String timestamp;
    private final String userId;
    private final String version;

    public ErrorReport(String version, String projectId, String userId, String sessionId, int i, String errorType, String str, String stack, String timestamp, int i2) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.version = version;
        this.projectId = projectId;
        this.userId = userId;
        this.sessionId = sessionId;
        this.pageNum = i;
        this.errorType = errorType;
        this.message = str;
        this.stack = stack;
        this.timestamp = timestamp;
        this.sourcePlatform = i2;
    }

    public /* synthetic */ ErrorReport(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, str5, str6, str7, str8, (i3 & 512) != 0 ? 1 : i2);
    }

    public static /* synthetic */ ErrorReport copy$default(ErrorReport errorReport, String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = errorReport.version;
        }
        if ((i3 & 2) != 0) {
            str2 = errorReport.projectId;
        }
        if ((i3 & 4) != 0) {
            str3 = errorReport.userId;
        }
        if ((i3 & 8) != 0) {
            str4 = errorReport.sessionId;
        }
        if ((i3 & 16) != 0) {
            i = errorReport.pageNum;
        }
        if ((i3 & 32) != 0) {
            str5 = errorReport.errorType;
        }
        if ((i3 & 64) != 0) {
            str6 = errorReport.message;
        }
        if ((i3 & 128) != 0) {
            str7 = errorReport.stack;
        }
        if ((i3 & 256) != 0) {
            str8 = errorReport.timestamp;
        }
        if ((i3 & 512) != 0) {
            i2 = errorReport.sourcePlatform;
        }
        String str9 = str8;
        int i4 = i2;
        String str10 = str6;
        String str11 = str7;
        int i5 = i;
        String str12 = str5;
        return errorReport.copy(str, str2, str3, str4, i5, str12, str10, str11, str9, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getSourcePlatform() {
        return this.sourcePlatform;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getErrorType() {
        return this.errorType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStack() {
        return this.stack;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    public final ErrorReport copy(String version, String projectId, String userId, String sessionId, int pageNum, String errorType, String message, String stack, String timestamp, int sourcePlatform) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return new ErrorReport(version, projectId, userId, sessionId, pageNum, errorType, message, stack, timestamp, sourcePlatform);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorReport)) {
            return false;
        }
        ErrorReport errorReport = (ErrorReport) other;
        return Intrinsics.areEqual(this.version, errorReport.version) && Intrinsics.areEqual(this.projectId, errorReport.projectId) && Intrinsics.areEqual(this.userId, errorReport.userId) && Intrinsics.areEqual(this.sessionId, errorReport.sessionId) && this.pageNum == errorReport.pageNum && Intrinsics.areEqual(this.errorType, errorReport.errorType) && Intrinsics.areEqual(this.message, errorReport.message) && Intrinsics.areEqual(this.stack, errorReport.stack) && Intrinsics.areEqual(this.timestamp, errorReport.timestamp) && this.sourcePlatform == errorReport.sourcePlatform;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSourcePlatform() {
        return this.sourcePlatform;
    }

    public final String getStack() {
        return this.stack;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = (this.errorType.hashCode() + ((Integer.hashCode(this.pageNum) + ((this.sessionId.hashCode() + ((this.userId.hashCode() + ((this.projectId.hashCode() + (this.version.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.message;
        return Integer.hashCode(this.sourcePlatform) + ((this.timestamp.hashCode() + ((this.stack.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31);
    }

    public final String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("v", this.version);
        jSONObject.put("p", this.projectId);
        jSONObject.put("u", this.userId);
        jSONObject.put(CmcdData.Factory.STREAMING_FORMAT_SS, this.sessionId);
        jSONObject.put(CTProductConfigConstants.PRODUCT_CONFIG_JSON_KEY_FOR_KEY, this.pageNum);
        jSONObject.put("t", this.errorType);
        jSONObject.put("m", this.message);
        jSONObject.put("e", this.stack);
        jSONObject.put(CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, this.timestamp);
        jSONObject.put("f", this.sourcePlatform);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        return string;
    }

    public String toString() {
        return b.a("ErrorReport(version=").append(this.version).append(", projectId=").append(this.projectId).append(", userId=").append(this.userId).append(", sessionId=").append(this.sessionId).append(", pageNum=").append(this.pageNum).append(", errorType=").append(this.errorType).append(", message=").append(this.message).append(", stack=").append(this.stack).append(", timestamp=").append(this.timestamp).append(", sourcePlatform=").append(this.sourcePlatform).append(')').toString();
    }
}
