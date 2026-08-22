package com.clevertap.android.sdk.inapp.delay;

import com.clevertap.android.sdk.db.Column;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.paytm.pgsdk.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DelayedInAppResult.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult;", "", "Success", Constants.EVENT_ACTION_ERROR, "Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult$Error;", "Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult$Success;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DelayedInAppResult {

    /* JADX INFO: compiled from: DelayedInAppResult.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult$Success;", "Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult;", com.clevertap.android.sdk.Constants.INAPP_KEY, "Lorg/json/JSONObject;", Column.INAPP_ID, "", "<init>", "(Lorg/json/JSONObject;Ljava/lang/String;)V", "getInApp", "()Lorg/json/JSONObject;", "getInAppId", "()Ljava/lang/String;", "component1", "component2", com.clevertap.android.sdk.Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Success implements DelayedInAppResult {
        private final JSONObject inApp;
        private final String inAppId;

        public static /* synthetic */ Success copy$default(Success success, JSONObject jSONObject, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONObject = success.inApp;
            }
            if ((i & 2) != 0) {
                str = success.inAppId;
            }
            return success.copy(jSONObject, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final JSONObject getInApp() {
            return this.inApp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getInAppId() {
            return this.inAppId;
        }

        public final Success copy(JSONObject inApp, String inAppId) {
            Intrinsics.checkNotNullParameter(inApp, "inApp");
            Intrinsics.checkNotNullParameter(inAppId, "inAppId");
            return new Success(inApp, inAppId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.inApp, success.inApp) && Intrinsics.areEqual(this.inAppId, success.inAppId);
        }

        public int hashCode() {
            return (this.inApp.hashCode() * 31) + this.inAppId.hashCode();
        }

        public String toString() {
            return "Success(inApp=" + this.inApp + ", inAppId=" + this.inAppId + ')';
        }

        public Success(JSONObject inApp, String inAppId) {
            Intrinsics.checkNotNullParameter(inApp, "inApp");
            Intrinsics.checkNotNullParameter(inAppId, "inAppId");
            this.inApp = inApp;
            this.inAppId = inAppId;
        }

        public final JSONObject getInApp() {
            return this.inApp;
        }

        public final String getInAppId() {
            return this.inAppId;
        }
    }

    /* JADX INFO: compiled from: DelayedInAppResult.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult$Error;", "Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult;", "reason", "Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult$Error$ErrorReason;", Column.INAPP_ID, "", "throwable", "", "<init>", "(Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult$Error$ErrorReason;Ljava/lang/String;Ljava/lang/Throwable;)V", "getReason", "()Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult$Error$ErrorReason;", "getInAppId", "()Ljava/lang/String;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", com.clevertap.android.sdk.Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "ErrorReason", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Error implements DelayedInAppResult {
        private final String inAppId;
        private final ErrorReason reason;
        private final Throwable throwable;

        public static /* synthetic */ Error copy$default(Error error, ErrorReason errorReason, String str, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                errorReason = error.reason;
            }
            if ((i & 2) != 0) {
                str = error.inAppId;
            }
            if ((i & 4) != 0) {
                th = error.throwable;
            }
            return error.copy(errorReason, str, th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ErrorReason getReason() {
            return this.reason;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getInAppId() {
            return this.inAppId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final Error copy(ErrorReason reason, String inAppId, Throwable throwable) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(inAppId, "inAppId");
            return new Error(reason, inAppId, throwable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.reason == error.reason && Intrinsics.areEqual(this.inAppId, error.inAppId) && Intrinsics.areEqual(this.throwable, error.throwable);
        }

        public int hashCode() {
            int iHashCode = ((this.reason.hashCode() * 31) + this.inAppId.hashCode()) * 31;
            Throwable th = this.throwable;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Error(reason=" + this.reason + ", inAppId=" + this.inAppId + ", throwable=" + this.throwable + ')';
        }

        public Error(ErrorReason reason, String inAppId, Throwable th) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(inAppId, "inAppId");
            this.reason = reason;
            this.inAppId = inAppId;
            this.throwable = th;
        }

        public final ErrorReason getReason() {
            return this.reason;
        }

        public /* synthetic */ Error(ErrorReason errorReason, String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(errorReason, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : th);
        }

        public final String getInAppId() {
            return this.inAppId;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: DelayedInAppResult.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/clevertap/android/sdk/inapp/delay/DelayedInAppResult$Error$ErrorReason;", "", "message", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "NOT_FOUND_IN_DB", "STORE_NOT_INITIALIZED", "DB_SAVE_FAILED", "UNKNOWN", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class ErrorReason {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ErrorReason[] $VALUES;
            private final String message;
            public static final ErrorReason NOT_FOUND_IN_DB = new ErrorReason("NOT_FOUND_IN_DB", 0, "Delayed in-app not found in database");
            public static final ErrorReason STORE_NOT_INITIALIZED = new ErrorReason("STORE_NOT_INITIALIZED", 1, "DelayedLegacyInAppStore is not initialized");
            public static final ErrorReason DB_SAVE_FAILED = new ErrorReason("DB_SAVE_FAILED", 2, "Failed to save delayed in-app to database");
            public static final ErrorReason UNKNOWN = new ErrorReason("UNKNOWN", 3, "Unknown error occurred");

            private static final /* synthetic */ ErrorReason[] $values() {
                return new ErrorReason[]{NOT_FOUND_IN_DB, STORE_NOT_INITIALIZED, DB_SAVE_FAILED, UNKNOWN};
            }

            public static EnumEntries<ErrorReason> getEntries() {
                return $ENTRIES;
            }

            private ErrorReason(String str, int i, String str2) {
                this.message = str2;
            }

            public final String getMessage() {
                return this.message;
            }

            static {
                ErrorReason[] errorReasonArr$values = $values();
                $VALUES = errorReasonArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(errorReasonArr$values);
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.message;
            }

            public static ErrorReason valueOf(String str) {
                return (ErrorReason) Enum.valueOf(ErrorReason.class, str);
            }

            public static ErrorReason[] values() {
                return (ErrorReason[]) $VALUES.clone();
            }
        }
    }
}
