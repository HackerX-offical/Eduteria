package com.clevertap.android.sdk.network.api;

import android.net.Uri;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.http.CtHttpClient;
import com.clevertap.android.sdk.network.http.Request;
import com.clevertap.android.sdk.network.http.Response;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

/* JADX INFO: compiled from: CtApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 L2\u00020\u0001:\u0001LB{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u000202J\u000e\u00103\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005J\u000e\u00104\u001a\u00020/2\u0006\u00100\u001a\u000205J\u000e\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u00020/2\u0006\u00109\u001a\u000202J\u000e\u0010:\u001a\u00020/2\u0006\u00100\u001a\u00020;J\u000e\u0010<\u001a\u00020/2\u0006\u00100\u001a\u00020=J\u0010\u0010>\u001a\u0004\u0018\u00010\u00052\u0006\u00109\u001a\u000202J\u000e\u0010?\u001a\u00020\u00052\u0006\u00109\u001a\u000202J\u000e\u0010@\u001a\u0002022\u0006\u00109\u001a\u000202JB\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010E\u001a\u0002022\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$H\u0002J \u0010G\u001a\u00020H2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u000202H\u0002J\f\u0010I\u001a\u00020J*\u00020JH\u0002J\f\u0010K\u001a\u00020J*\u00020JH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0018R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020*@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006M"}, d2 = {"Lcom/clevertap/android/sdk/network/api/CtApi;", "", "httpClient", "Lcom/clevertap/android/sdk/network/http/CtHttpClient;", "defaultDomain", "", "cachedDomain", "cachedSpikyDomain", "region", "proxyDomain", "spikyProxyDomain", "customHandshakeDomain", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "accountToken", "sdkVersion", "logger", "Lcom/clevertap/android/sdk/Logger;", "logTag", "<init>", "(Lcom/clevertap/android/sdk/network/http/CtHttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/clevertap/android/sdk/Logger;Ljava/lang/String;)V", "getDefaultDomain", "()Ljava/lang/String;", "getCachedDomain", "setCachedDomain", "(Ljava/lang/String;)V", "getCachedSpikyDomain", "setCachedSpikyDomain", "getRegion", "setRegion", "getProxyDomain", "setProxyDomain", "getSpikyProxyDomain", "setSpikyProxyDomain", "getCustomHandshakeDomain", "setCustomHandshakeDomain", "defaultHeaders", "", "defaultQueryParams", "encryptionHeader", "Lkotlin/Pair;", "spikyRegionSuffix", "value", "", "currentRequestTimestampSeconds", "getCurrentRequestTimestampSeconds", "()I", "sendQueue", "Lcom/clevertap/android/sdk/network/http/Response;", "body", "isEncrypted", "", "sendImpressions", "sendContentFetch", "Lcom/clevertap/android/sdk/network/api/ContentFetchRequestBody;", "fetchFromUrl", "url", "performHandshakeForDomain", "isViewedEvent", "defineVars", "Lcom/clevertap/android/sdk/network/api/SendQueueRequestBody;", "defineTemplates", "Lcom/clevertap/android/sdk/network/api/DefineTemplatesRequestBody;", "getActualDomain", "getHandshakeDomain", "needsHandshake", "createRequest", "Lcom/clevertap/android/sdk/network/http/Request;", "baseUrl", "relativeUrl", "includeTs", HeadersExtension.ELEMENT, "getUriForPath", "Landroid/net/Uri;", "appendDefaultQueryParams", "Landroid/net/Uri$Builder;", "appendTsQueryParam", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CtApi {
    public static final String DEFAULT_CONTENT_TYPE = "application/json; charset=utf-8";
    public static final String DEFAULT_QUERY_PARAM_OS = "Android";
    public static final String HEADER_ACCOUNT_ID = "X-CleverTap-Account-ID";
    public static final String HEADER_ACCOUNT_TOKEN = "X-CleverTap-Token";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_CUSTOM_HANDSHAKE = "X-CleverTap-Handshake-Domain";
    public static final String HEADER_DOMAIN_NAME = "X-WZRK-RD";
    public static final String HEADER_ENCRYPTION_ENABLED = "X-CleverTap-Encryption-Enabled";
    public static final String HEADER_MUTE = "X-WZRK-MUTE";
    public static final String QUERY_PARAM_OS_KEY = "os";
    public static final String QUERY_PARAM_T_KEY = "t";
    public static final String QUERY_PARAM_Z_KEY = "z";
    public static final String SPIKY_HEADER_DOMAIN_NAME = "X-WZRK-SPIKY-RD";
    private String cachedDomain;
    private String cachedSpikyDomain;
    private int currentRequestTimestampSeconds;
    private String customHandshakeDomain;
    private final String defaultDomain;
    private final Map<String, String> defaultHeaders;
    private final Map<String, String> defaultQueryParams;
    private final Pair<String, String> encryptionHeader;
    private final CtHttpClient httpClient;
    private final String logTag;
    private final Logger logger;
    private String proxyDomain;
    private String region;
    private String spikyProxyDomain;
    private final String spikyRegionSuffix;

    public CtApi(CtHttpClient httpClient, String defaultDomain, String str, String str2, String str3, String str4, String str5, String str6, String accountId, String accountToken, String sdkVersion, Logger logger, String logTag) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(defaultDomain, "defaultDomain");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(accountToken, "accountToken");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.httpClient = httpClient;
        this.defaultDomain = defaultDomain;
        this.cachedDomain = str;
        this.cachedSpikyDomain = str2;
        this.region = str3;
        this.proxyDomain = str4;
        this.spikyProxyDomain = str5;
        this.customHandshakeDomain = str6;
        this.logger = logger;
        this.logTag = logTag;
        this.defaultHeaders = MapsKt.mapOf(TuplesKt.to("Content-Type", DEFAULT_CONTENT_TYPE), TuplesKt.to(HEADER_ACCOUNT_ID, accountId), TuplesKt.to(HEADER_ACCOUNT_TOKEN, accountToken));
        this.defaultQueryParams = MapsKt.mapOf(TuplesKt.to("os", DEFAULT_QUERY_PARAM_OS), TuplesKt.to("t", sdkVersion), TuplesKt.to(QUERY_PARAM_Z_KEY, accountId));
        this.encryptionHeader = TuplesKt.to(HEADER_ENCRYPTION_ENABLED, "true");
        this.spikyRegionSuffix = "-spiky";
    }

    public final String getDefaultDomain() {
        return this.defaultDomain;
    }

    public final String getCachedDomain() {
        return this.cachedDomain;
    }

    public final void setCachedDomain(String str) {
        this.cachedDomain = str;
    }

    public final String getCachedSpikyDomain() {
        return this.cachedSpikyDomain;
    }

    public final void setCachedSpikyDomain(String str) {
        this.cachedSpikyDomain = str;
    }

    public final String getRegion() {
        return this.region;
    }

    public final void setRegion(String str) {
        this.region = str;
    }

    public final String getProxyDomain() {
        return this.proxyDomain;
    }

    public final void setProxyDomain(String str) {
        this.proxyDomain = str;
    }

    public final String getSpikyProxyDomain() {
        return this.spikyProxyDomain;
    }

    public final void setSpikyProxyDomain(String str) {
        this.spikyProxyDomain = str;
    }

    public final String getCustomHandshakeDomain() {
        return this.customHandshakeDomain;
    }

    public final void setCustomHandshakeDomain(String str) {
        this.customHandshakeDomain = str;
    }

    public final int getCurrentRequestTimestampSeconds() {
        return this.currentRequestTimestampSeconds;
    }

    public static /* synthetic */ Response sendQueue$default(CtApi ctApi, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return ctApi.sendQueue(str, z);
    }

    public final Response sendQueue(String body, boolean isEncrypted) {
        Map<String, String> mapPlus;
        Intrinsics.checkNotNullParameter(body, "body");
        CtHttpClient ctHttpClient = this.httpClient;
        String actualDomain = getActualDomain(false);
        if (actualDomain == null) {
            actualDomain = this.defaultDomain;
        }
        String str = actualDomain;
        if (isEncrypted) {
            mapPlus = MapsKt.plus(this.defaultHeaders, this.encryptionHeader);
        } else {
            mapPlus = this.defaultHeaders;
        }
        return ctHttpClient.execute(createRequest$default(this, str, "a1", body, false, mapPlus, 8, null));
    }

    public final Response sendImpressions(String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        CtHttpClient ctHttpClient = this.httpClient;
        String actualDomain = getActualDomain(true);
        if (actualDomain == null) {
            actualDomain = this.defaultDomain;
        }
        return ctHttpClient.execute(createRequest$default(this, actualDomain, "a1", body, false, this.defaultHeaders, 8, null));
    }

    public final Response sendContentFetch(ContentFetchRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        CtHttpClient ctHttpClient = this.httpClient;
        String actualDomain = getActualDomain(false);
        if (actualDomain == null) {
            actualDomain = this.defaultDomain;
        }
        return ctHttpClient.execute(createRequest$default(this, actualDomain, "content", body.toString(), false, null, 24, null));
    }

    public final Response performHandshakeForDomain(boolean isViewedEvent) {
        Map<String, String> mapPlus;
        String handshakeDomain = getHandshakeDomain(isViewedEvent);
        if (CTXtensions.isNotNullAndBlank(this.customHandshakeDomain) && Intrinsics.areEqual(handshakeDomain, this.customHandshakeDomain)) {
            Map<String, String> map = this.defaultHeaders;
            String str = this.customHandshakeDomain;
            Intrinsics.checkNotNull(str);
            mapPlus = MapsKt.plus(map, TuplesKt.to(HEADER_CUSTOM_HANDSHAKE, str));
        } else {
            mapPlus = this.defaultHeaders;
        }
        Request requestCreateRequest = createRequest(handshakeDomain, "hello", null, false, mapPlus);
        this.logger.verbose(this.logTag, "Performing handshake with " + requestCreateRequest.getUrl());
        return this.httpClient.execute(requestCreateRequest);
    }

    public final Response defineVars(SendQueueRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        CtHttpClient ctHttpClient = this.httpClient;
        String actualDomain = getActualDomain(false);
        if (actualDomain == null) {
            actualDomain = this.defaultDomain;
        }
        return ctHttpClient.execute(createRequest$default(this, actualDomain, "defineVars", body.toString(), false, null, 24, null));
    }

    public final Response defineTemplates(DefineTemplatesRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        CtHttpClient ctHttpClient = this.httpClient;
        String actualDomain = getActualDomain(false);
        if (actualDomain == null) {
            actualDomain = this.defaultDomain;
        }
        return ctHttpClient.execute(createRequest$default(this, actualDomain, "defineTemplates", body.toString(), false, null, 24, null));
    }

    public final String getActualDomain(boolean isViewedEvent) {
        String str;
        if (CTXtensions.isNotNullAndBlank(this.region)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.region);
            if (isViewedEvent) {
                str = this.spikyRegionSuffix;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(InstructionFileId.DOT);
            sb.append(this.defaultDomain);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        String str2 = isViewedEvent ? this.spikyProxyDomain : this.proxyDomain;
        return CTXtensions.isNotNullAndBlank(str2) ? str2 : isViewedEvent ? this.cachedSpikyDomain : this.cachedDomain;
    }

    public final String getHandshakeDomain(boolean isViewedEvent) {
        String str;
        if (CTXtensions.isNotNullAndBlank(this.region)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.region);
            if (isViewedEvent) {
                str = this.spikyRegionSuffix;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(InstructionFileId.DOT);
            sb.append(this.defaultDomain);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        String str2 = isViewedEvent ? this.spikyProxyDomain : this.proxyDomain;
        if (CTXtensions.isNotNullAndBlank(str2)) {
            return str2;
        }
        if (CTXtensions.isNotNullAndBlank(this.customHandshakeDomain)) {
            String str3 = this.customHandshakeDomain;
            Intrinsics.checkNotNull(str3);
            return str3;
        }
        String str4 = isViewedEvent ? this.cachedSpikyDomain : this.cachedDomain;
        return CTXtensions.isNotNullAndBlank(str4) ? str4 : this.defaultDomain;
    }

    public final boolean needsHandshake(boolean isViewedEvent) {
        if (CTXtensions.isNotNullAndBlank(this.region)) {
            return false;
        }
        if (CTXtensions.isNotNullAndBlank(isViewedEvent ? this.spikyProxyDomain : this.proxyDomain)) {
            return false;
        }
        String str = isViewedEvent ? this.cachedSpikyDomain : this.cachedDomain;
        return str == null || StringsKt.isBlank(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Request createRequest$default(CtApi ctApi, String str, String str2, String str3, boolean z, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            map = ctApi.defaultHeaders;
        }
        return ctApi.createRequest(str, str2, str3, z2, map);
    }

    private final Request createRequest(String baseUrl, String relativeUrl, String body, boolean includeTs, Map<String, String> headers) {
        return new Request(getUriForPath(baseUrl, relativeUrl, includeTs), headers, body);
    }

    private final Uri getUriForPath(String baseUrl, String relativeUrl, boolean includeTs) {
        Uri.Builder builderAppendPath = new Uri.Builder().scheme(TournamentShareDialogURIBuilder.scheme).authority(baseUrl).appendPath(relativeUrl);
        Intrinsics.checkNotNullExpressionValue(builderAppendPath, "appendPath(...)");
        Uri.Builder builderAppendDefaultQueryParams = appendDefaultQueryParams(builderAppendPath);
        if (includeTs) {
            appendTsQueryParam(builderAppendDefaultQueryParams);
        }
        Uri uriBuild = builderAppendDefaultQueryParams.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
        return uriBuild;
    }

    private final Uri.Builder appendDefaultQueryParams(Uri.Builder builder) {
        for (Map.Entry<String, String> entry : this.defaultQueryParams.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builder;
    }

    private final Uri.Builder appendTsQueryParam(Uri.Builder builder) {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / ((long) 1000));
        this.currentRequestTimestampSeconds = iCurrentTimeMillis;
        Uri.Builder builderAppendQueryParameter = builder.appendQueryParameter(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, String.valueOf(iCurrentTimeMillis));
        Intrinsics.checkNotNullExpressionValue(builderAppendQueryParameter, "appendQueryParameter(...)");
        return builderAppendQueryParameter;
    }

    public final Response fetchFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Request request = new Request(Uri.parse(url), MapsKt.emptyMap(), null);
        this.logger.verbose(this.logTag, "Fetching content from URL");
        return this.httpClient.execute(request);
    }
}
