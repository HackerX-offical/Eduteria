package com.microsoft.clarity;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.models.ApplicationFramework;
import com.microsoft.clarity.models.LogLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u001b\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020\bH\u0000¢\u0006\u0002\b J\r\u0010!\u001a\u00020\bH\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006$"}, d2 = {"Lcom/microsoft/clarity/ClarityConfig;", "", "projectId", "", "userId", "logLevel", "Lcom/microsoft/clarity/models/LogLevel;", "allowMeteredNetworkUsage", "", "enableWebViewCapture", "allowedDomains", "", "applicationFramework", "Lcom/microsoft/clarity/models/ApplicationFramework;", "(Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/clarity/models/LogLevel;ZZLjava/util/List;Lcom/microsoft/clarity/models/ApplicationFramework;)V", "getAllowMeteredNetworkUsage", "()Z", "getAllowedDomains", "()Ljava/util/List;", "getApplicationFramework", "()Lcom/microsoft/clarity/models/ApplicationFramework;", "getEnableWebViewCapture", "getLogLevel", "()Lcom/microsoft/clarity/models/LogLevel;", "getProjectId", "()Ljava/lang/String;", "getUserId", "isCordova", "isCordova$sdk_prodRelease", "isIonic", "isIonic$sdk_prodRelease", "isReactNative", "isReactNative$sdk_prodRelease", "isValidUserId", "isValidUserId$sdk_prodRelease", InAppPurchaseConstants.METHOD_TO_STRING, "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClarityConfig {
    private final boolean allowMeteredNetworkUsage;
    private final List<String> allowedDomains;
    private final ApplicationFramework applicationFramework;
    private final boolean enableWebViewCapture;
    private final LogLevel logLevel;
    private final String projectId;
    private final String userId;

    public ClarityConfig(String projectId, String str, LogLevel logLevel, boolean z, boolean z2, List<String> allowedDomains, ApplicationFramework applicationFramework) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(allowedDomains, "allowedDomains");
        Intrinsics.checkNotNullParameter(applicationFramework, "applicationFramework");
        this.projectId = projectId;
        this.userId = str;
        this.logLevel = logLevel;
        this.allowMeteredNetworkUsage = z;
        this.enableWebViewCapture = z2;
        this.allowedDomains = allowedDomains;
        this.applicationFramework = applicationFramework;
    }

    public /* synthetic */ ClarityConfig(String str, String str2, LogLevel logLevel, boolean z, boolean z2, List list, ApplicationFramework applicationFramework, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? LogLevel.None : logLevel, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? CollectionsKt.listOf("*") : list, (i & 64) != 0 ? ApplicationFramework.Native : applicationFramework);
    }

    public final boolean getAllowMeteredNetworkUsage() {
        return this.allowMeteredNetworkUsage;
    }

    public final List<String> getAllowedDomains() {
        return this.allowedDomains;
    }

    public final ApplicationFramework getApplicationFramework() {
        return this.applicationFramework;
    }

    public final boolean getEnableWebViewCapture() {
        return this.enableWebViewCapture;
    }

    public final LogLevel getLogLevel() {
        return this.logLevel;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isCordova$sdk_prodRelease() {
        return this.applicationFramework == ApplicationFramework.Cordova;
    }

    public final boolean isIonic$sdk_prodRelease() {
        return this.applicationFramework == ApplicationFramework.Ionic;
    }

    public final boolean isReactNative$sdk_prodRelease() {
        return this.applicationFramework == ApplicationFramework.ReactNative;
    }

    public final boolean isValidUserId$sdk_prodRelease() {
        String str = this.userId;
        return (str == null || StringsKt.isBlank(str) || UStringsKt.toUIntOrNull(this.userId, 36) == null) ? false : true;
    }

    public String toString() {
        return com.microsoft.clarity.a.b.a("[ProjectId: ").append(this.projectId).append(", UserId: ").append(this.userId).append(", LogLevel: ").append(this.logLevel).append(", AllowMeteredNetworkUsage: ").append(this.allowMeteredNetworkUsage).append(", EnableWebViewCapture: ").append(this.enableWebViewCapture).append(", allowedDomains: (").append(CollectionsKt.joinToString$default(this.allowedDomains, ", ", null, null, 0, null, null, 62, null)).append("), applicationFramework: ").append(this.applicationFramework).append(']').toString();
    }
}
