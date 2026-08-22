package com.microsoft.clarity.models.display.paints.loopers;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Layer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/loopers/Layer;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Layer;", "layerInfo", "Lcom/microsoft/clarity/models/display/paints/loopers/LayerInfo;", "paint", "Lcom/microsoft/clarity/models/display/paints/Paint;", "(Lcom/microsoft/clarity/models/display/paints/loopers/LayerInfo;Lcom/microsoft/clarity/models/display/paints/Paint;)V", "getLayerInfo", "()Lcom/microsoft/clarity/models/display/paints/loopers/LayerInfo;", "getPaint", "()Lcom/microsoft/clarity/models/display/paints/Paint;", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class Layer implements IProtoModel<MutationPayload$Layer> {
    private final LayerInfo layerInfo;
    private final Paint paint;

    public Layer(LayerInfo layerInfo, Paint paint) {
        Intrinsics.checkNotNullParameter(layerInfo, "layerInfo");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.layerInfo = layerInfo;
        this.paint = paint;
    }

    public static /* synthetic */ Layer copy$default(Layer layer, LayerInfo layerInfo, Paint paint, int i, Object obj) {
        if ((i & 1) != 0) {
            layerInfo = layer.layerInfo;
        }
        if ((i & 2) != 0) {
            paint = layer.paint;
        }
        return layer.copy(layerInfo, paint);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LayerInfo getLayerInfo() {
        return this.layerInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Paint getPaint() {
        return this.paint;
    }

    public final Layer copy(LayerInfo layerInfo, Paint paint) {
        Intrinsics.checkNotNullParameter(layerInfo, "layerInfo");
        Intrinsics.checkNotNullParameter(paint, "paint");
        return new Layer(layerInfo, paint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Layer)) {
            return false;
        }
        Layer layer = (Layer) other;
        return Intrinsics.areEqual(this.layerInfo, layer.layerInfo) && Intrinsics.areEqual(this.paint, layer.paint);
    }

    public final LayerInfo getLayerInfo() {
        return this.layerInfo;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public int hashCode() {
        return this.paint.hashCode() + (this.layerInfo.hashCode() * 31);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Layer toProtobufInstance() {
        MutationPayload$Layer mutationPayload$LayerBuild = MutationPayload$Layer.newBuilder().a(this.layerInfo.toProtobufInstance()).a(this.paint.toProtobufInstance()).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$LayerBuild, "newBuilder()\n           …e())\n            .build()");
        return mutationPayload$LayerBuild;
    }

    public String toString() {
        return b.a("Layer(layerInfo=").append(this.layerInfo).append(", paint=").append(this.paint).append(')').toString();
    }
}
