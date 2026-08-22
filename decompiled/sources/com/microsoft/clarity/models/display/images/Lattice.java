package com.microsoft.clarity.models.display.images;

import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Lattice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\u0010\fJ\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microsoft/clarity/models/display/images/Lattice;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Lattice;", "xDivs", "", "", "yDivs", "rectType", "bounds", "Lcom/microsoft/clarity/models/display/common/IRect;", "colors", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/microsoft/clarity/models/display/common/IRect;Ljava/util/List;)V", "getBounds", "()Lcom/microsoft/clarity/models/display/common/IRect;", "getColors", "()Ljava/util/List;", "getRectType", "toProtobufInstance", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Lattice implements IProtoModel<MutationPayload$Lattice> {
    private final IRect bounds;
    private final List<Long> colors;
    private final List<Integer> rectType;
    private final List<Integer> xDivs;
    private final List<Integer> yDivs;

    public Lattice(List<Integer> xDivs, List<Integer> yDivs, List<Integer> rectType, IRect bounds, List<Long> colors) {
        Intrinsics.checkNotNullParameter(xDivs, "xDivs");
        Intrinsics.checkNotNullParameter(yDivs, "yDivs");
        Intrinsics.checkNotNullParameter(rectType, "rectType");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.xDivs = xDivs;
        this.yDivs = yDivs;
        this.rectType = rectType;
        this.bounds = bounds;
        this.colors = colors;
    }

    public final IRect getBounds() {
        return this.bounds;
    }

    public final List<Long> getColors() {
        return this.colors;
    }

    public final List<Integer> getRectType() {
        return this.rectType;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Lattice toProtobufInstance() {
        MutationPayload$Lattice.a aVarA = MutationPayload$Lattice.newBuilder().a(this.bounds.toProtobufInstance());
        List<Long> list = this.colors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(((Number) it.next()).longValue()));
        }
        MutationPayload$Lattice mutationPayload$LatticeBuild = aVarA.a(arrayList).a(this.rectType).c(this.yDivs).b(this.xDivs).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$LatticeBuild, "newBuilder()\n           …ivs)\n            .build()");
        return mutationPayload$LatticeBuild;
    }
}
