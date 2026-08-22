package com.microsoft.clarity.models.ingest;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.microsoft.clarity.models.AssetType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/microsoft/clarity/models/ingest/AssetMetadata;", "", "assetType", "Lcom/microsoft/clarity/models/AssetType;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(Lcom/microsoft/clarity/models/AssetType;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAssetType", "()Lcom/microsoft/clarity/models/AssetType;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AssetMetadata {
    private final AssetType assetType;
    private final Integer height;
    private final Integer width;

    public AssetMetadata(AssetType assetType, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        this.assetType = assetType;
        this.width = num;
        this.height = num2;
    }

    public /* synthetic */ AssetMetadata(AssetType assetType, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetType, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2);
    }

    public final AssetType getAssetType() {
        return this.assetType;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getWidth() {
        return this.width;
    }
}
