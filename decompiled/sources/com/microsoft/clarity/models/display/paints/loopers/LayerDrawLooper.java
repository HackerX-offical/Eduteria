package com.microsoft.clarity.models.display.paints.loopers;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Looper;
import com.x5.template.ThemeConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/loopers/LayerDrawLooper;", "Lcom/microsoft/clarity/models/display/paints/loopers/Looper;", ThemeConfig.LAYER_NAMES, "", "Lcom/microsoft/clarity/models/display/paints/loopers/Layer;", "(Ljava/util/List;)V", "getLayers", "()Ljava/util/List;", "type", "Lcom/microsoft/clarity/models/display/paints/loopers/LooperType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/loopers/LooperType;", "component1", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Looper;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class LayerDrawLooper extends Looper {
    private final List<Layer> layers;
    private final LooperType type;

    public LayerDrawLooper(List<Layer> layers) {
        Intrinsics.checkNotNullParameter(layers, "layers");
        this.layers = layers;
        this.type = LooperType.LayerDrawLooper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LayerDrawLooper copy$default(LayerDrawLooper layerDrawLooper, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = layerDrawLooper.layers;
        }
        return layerDrawLooper.copy(list);
    }

    public final List<Layer> component1() {
        return this.layers;
    }

    public final LayerDrawLooper copy(List<Layer> layers) {
        Intrinsics.checkNotNullParameter(layers, "layers");
        return new LayerDrawLooper(layers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LayerDrawLooper) && Intrinsics.areEqual(this.layers, ((LayerDrawLooper) other).layers);
    }

    public final List<Layer> getLayers() {
        return this.layers;
    }

    @Override // com.microsoft.clarity.models.display.paints.loopers.Looper
    public LooperType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.layers.hashCode();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Looper toProtobufInstance() {
        MutationPayload$Looper.a aVarA = MutationPayload$Looper.newBuilder().a(getType().name());
        List<Layer> list = this.layers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Layer) it.next()).toProtobufInstance());
        }
        MutationPayload$Looper mutationPayload$LooperBuild = aVarA.a(CollectionsKt.toList(arrayList)).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$LooperBuild, "builder.build()");
        return mutationPayload$LooperBuild;
    }

    public String toString() {
        return b.a("LayerDrawLooper(layers=").append(this.layers).append(')').toString();
    }
}
