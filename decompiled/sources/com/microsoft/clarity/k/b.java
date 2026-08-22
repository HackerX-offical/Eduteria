package com.microsoft.clarity.k;

import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.ingest.SerializedSessionPayload;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.ingest.mutation.BaseMutationEvent;
import com.microsoft.clarity.models.repositories.RepositoryAsset;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface b {
    int a();

    SessionMetadata a(String str);

    SerializedSessionPayload a(boolean z, PayloadMetadata payloadMetadata);

    void a(PayloadMetadata payloadMetadata);

    void a(PayloadMetadata payloadMetadata, WebViewAnalyticsEvent webViewAnalyticsEvent);

    void a(PayloadMetadata payloadMetadata, WebViewMutationEvent webViewMutationEvent);

    void a(PayloadMetadata payloadMetadata, AnalyticsEvent analyticsEvent);

    void a(PayloadMetadata payloadMetadata, BaseMutationEvent baseMutationEvent);

    void a(SessionMetadata sessionMetadata);

    void a(String str, AssetType assetType, String str2);

    void a(String str, PayloadMetadata payloadMetadata);

    void a(String str, String str2, AssetType assetType, byte[] bArr);

    List<RepositoryAsset> b(String str);
}
