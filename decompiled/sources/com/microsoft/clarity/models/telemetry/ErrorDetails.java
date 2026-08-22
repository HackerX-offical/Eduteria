package com.microsoft.clarity.models.telemetry;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0005J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/microsoft/clarity/models/telemetry/ErrorDetails;", "", "errorType", "Lcom/microsoft/clarity/models/telemetry/ErrorType;", "timestamp", "", "message", "stackTrace", "(Lcom/microsoft/clarity/models/telemetry/ErrorType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorType", "()Lcom/microsoft/clarity/models/telemetry/ErrorType;", "getMessage", "()Ljava/lang/String;", "getStackTrace", "getTimestamp", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", "toJson", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ErrorDetails {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorType errorType;
    private final String message;
    private final String stackTrace;
    private final String timestamp;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/telemetry/ErrorDetails$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/telemetry/ErrorDetails;", "jsonString", "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ErrorDetails fromJson(String jsonString) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            for (ErrorType errorType : ErrorType.values()) {
                if (errorType.ordinal() == jSONObject.getInt("errorType")) {
                    String string = jSONObject.getString("timestamp");
                    Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"timestamp\")");
                    String strOptString = jSONObject.optString("message", "");
                    String strOptString2 = jSONObject.optString("stackTrace", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "json.optString(\"stackTrace\", \"\")");
                    return new ErrorDetails(errorType, string, strOptString, strOptString2);
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    public ErrorDetails(ErrorType errorType, String timestamp, String str, String stackTrace) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        this.errorType = errorType;
        this.timestamp = timestamp;
        this.message = str;
        this.stackTrace = stackTrace;
    }

    public /* synthetic */ ErrorDetails(ErrorType errorType, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorType, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public static /* synthetic */ ErrorDetails copy$default(ErrorDetails errorDetails, ErrorType errorType, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            errorType = errorDetails.errorType;
        }
        if ((i & 2) != 0) {
            str = errorDetails.timestamp;
        }
        if ((i & 4) != 0) {
            str2 = errorDetails.message;
        }
        if ((i & 8) != 0) {
            str3 = errorDetails.stackTrace;
        }
        return errorDetails.copy(errorType, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ErrorType getErrorType() {
        return this.errorType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStackTrace() {
        return this.stackTrace;
    }

    public final ErrorDetails copy(ErrorType errorType, String timestamp, String message, String stackTrace) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        return new ErrorDetails(errorType, timestamp, message, stackTrace);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorDetails)) {
            return false;
        }
        ErrorDetails errorDetails = (ErrorDetails) other;
        return this.errorType == errorDetails.errorType && Intrinsics.areEqual(this.timestamp, errorDetails.timestamp) && Intrinsics.areEqual(this.message, errorDetails.message) && Intrinsics.areEqual(this.stackTrace, errorDetails.stackTrace);
    }

    public final ErrorType getErrorType() {
        return this.errorType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStackTrace() {
        return this.stackTrace;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = (this.timestamp.hashCode() + (this.errorType.hashCode() * 31)) * 31;
        String str = this.message;
        return this.stackTrace.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorType", this.errorType.ordinal());
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("message", this.message);
        jSONObject.put("stackTrace", this.stackTrace);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        return string;
    }

    public String toString() {
        return b.a("ErrorDetails(errorType=").append(this.errorType).append(", timestamp=").append(this.timestamp).append(", message=").append(this.message).append(", stackTrace=").append(this.stackTrace).append(')').toString();
    }
}
