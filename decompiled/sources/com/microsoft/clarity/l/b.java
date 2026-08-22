package com.microsoft.clarity.l;

import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.ingest.SessionEvent;

/* JADX INFO: loaded from: classes9.dex */
public interface b {
    boolean a(AssetType assetType, byte[] bArr, String str);

    boolean a(SessionEvent sessionEvent, e eVar);

    boolean a(String str, e eVar);

    boolean a(String str, byte[] bArr);
}
