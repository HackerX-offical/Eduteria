package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.ContentFetchManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContentFetchResponse.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/clevertap/android/sdk/response/ContentFetchResponse;", "Lcom/clevertap/android/sdk/response/CleverTapResponseDecorator;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "contentFetchManager", "Lcom/clevertap/android/sdk/network/ContentFetchManager;", "<init>", "(Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Lcom/clevertap/android/sdk/network/ContentFetchManager;)V", "logger", "Lcom/clevertap/android/sdk/Logger;", "processResponse", "", "jsonBody", "Lorg/json/JSONObject;", "stringBody", "", "context", "Landroid/content/Context;", "processContentFetchItems", "contentFetchArray", "Lorg/json/JSONArray;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentFetchResponse extends CleverTapResponseDecorator {
    private final CleverTapInstanceConfig config;
    private final ContentFetchManager contentFetchManager;
    private final Logger logger;

    public ContentFetchResponse(CleverTapInstanceConfig config, ContentFetchManager contentFetchManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(contentFetchManager, "contentFetchManager");
        this.config = config;
        this.contentFetchManager = contentFetchManager;
        Logger logger = config.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        this.logger = logger;
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponseDecorator, com.clevertap.android.sdk.response.CleverTapResponse
    public void processResponse(JSONObject jsonBody, String stringBody, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.logger.verbose(this.config.getAccountId(), "Processing Content Fetch response...");
        if (this.config.isAnalyticsOnly()) {
            this.logger.verbose(this.config.getAccountId(), "CleverTap instance is configured to analytics only, not processing Content Fetch response");
            return;
        }
        if (jsonBody == null) {
            this.logger.verbose(this.config.getAccountId(), "Can't parse Content Fetch Response, JSON response object is null");
            return;
        }
        if (!jsonBody.has(Constants.CONTENT_FETCH_JSON_RESPONSE_KEY)) {
            this.logger.verbose(this.config.getAccountId(), "JSON object doesn't contain the content_fetch key");
            return;
        }
        try {
            this.logger.verbose(this.config.getAccountId(), "Processing Content Fetch response");
            JSONArray jSONArray = jsonBody.getJSONArray(Constants.CONTENT_FETCH_JSON_RESPONSE_KEY);
            Intrinsics.checkNotNull(jSONArray);
            processContentFetchItems(jSONArray, context);
        } catch (Throwable th) {
            this.logger.verbose(this.config.getAccountId(), "Failed to parse content fetch response", th);
        }
    }

    private final void processContentFetchItems(JSONArray contentFetchArray, Context context) {
        if (contentFetchArray.length() == 0) {
            this.logger.verbose(this.config.getAccountId(), "No content fetch items to process");
            return;
        }
        this.logger.verbose(this.config.getAccountId(), "Found " + contentFetchArray.length() + " content fetch items");
        ContentFetchManager contentFetchManager = this.contentFetchManager;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        contentFetchManager.handleContentFetch(contentFetchArray, packageName);
    }
}
