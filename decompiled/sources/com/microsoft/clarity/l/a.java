package com.microsoft.clarity.l;

import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.ingest.AssetMetadata;
import com.microsoft.clarity.models.ingest.IngestConfigs;
import com.microsoft.clarity.models.ingest.SerializedSessionPayload;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public interface a {
    IngestConfigs a(String str);

    Map a(String str, String str2, ArrayList arrayList);

    boolean a(SessionMetadata sessionMetadata, String str, byte[] bArr, AssetMetadata assetMetadata);

    boolean a(SerializedSessionPayload serializedSessionPayload, SessionMetadata sessionMetadata);

    boolean a(String str, String str2, String str3, byte[] bArr);
}
