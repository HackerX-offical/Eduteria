package com.microsoft.clarity.models.display.common;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DoubleList;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Vertices;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B}\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b\u0018\u00010\b\u0012\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b\u0018\u00010\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b\u0018\u00010\bHÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b\u0018\u00010\bHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J\u0091\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b\u0018\u00010\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b\u0018\u00010\b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001J\u0013\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\b\u0010)\u001a\u00020\u0002H\u0016J\t\u0010*\u001a\u00020+HÖ\u0001R\u001f\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006,"}, d2 = {"Lcom/microsoft/clarity/models/display/common/Vertices;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Vertices;", "mode", "", "isVolatile", "", "positions", "", "Lcom/microsoft/clarity/models/display/common/Point;", "texCoords", "colors", "boneIndices", "boneWeights", "", "indices", "(JZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBoneIndices", "()Ljava/util/List;", "getBoneWeights", "getColors", "getIndices", "()Z", "getMode", "()J", "getPositions", "getTexCoords", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class Vertices implements IProtoModel<MutationPayload$Vertices> {
    private final List<List<Long>> boneIndices;
    private final List<List<Float>> boneWeights;
    private final List<Long> colors;
    private final List<Long> indices;
    private final boolean isVolatile;
    private final long mode;
    private final List<Point> positions;
    private final List<Point> texCoords;

    /* JADX WARN: Multi-variable type inference failed */
    public Vertices(long j, boolean z, List<Point> positions, List<Point> list, List<Long> list2, List<? extends List<Long>> list3, List<? extends List<Float>> list4, List<Long> indices) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        Intrinsics.checkNotNullParameter(indices, "indices");
        this.mode = j;
        this.isVolatile = z;
        this.positions = positions;
        this.texCoords = list;
        this.colors = list2;
        this.boneIndices = list3;
        this.boneWeights = list4;
        this.indices = indices;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Vertices copy$default(Vertices vertices, long j, boolean z, List list, List list2, List list3, List list4, List list5, List list6, int i, Object obj) {
        if ((i & 1) != 0) {
            j = vertices.mode;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            z = vertices.isVolatile;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            list = vertices.positions;
        }
        List list7 = list;
        if ((i & 8) != 0) {
            list2 = vertices.texCoords;
        }
        return vertices.copy(j2, z2, list7, list2, (i & 16) != 0 ? vertices.colors : list3, (i & 32) != 0 ? vertices.boneIndices : list4, (i & 64) != 0 ? vertices.boneWeights : list5, (i & 128) != 0 ? vertices.indices : list6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsVolatile() {
        return this.isVolatile;
    }

    public final List<Point> component3() {
        return this.positions;
    }

    public final List<Point> component4() {
        return this.texCoords;
    }

    public final List<Long> component5() {
        return this.colors;
    }

    public final List<List<Long>> component6() {
        return this.boneIndices;
    }

    public final List<List<Float>> component7() {
        return this.boneWeights;
    }

    public final List<Long> component8() {
        return this.indices;
    }

    public final Vertices copy(long mode, boolean isVolatile, List<Point> positions, List<Point> texCoords, List<Long> colors, List<? extends List<Long>> boneIndices, List<? extends List<Float>> boneWeights, List<Long> indices) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return new Vertices(mode, isVolatile, positions, texCoords, colors, boneIndices, boneWeights, indices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vertices)) {
            return false;
        }
        Vertices vertices = (Vertices) other;
        return this.mode == vertices.mode && this.isVolatile == vertices.isVolatile && Intrinsics.areEqual(this.positions, vertices.positions) && Intrinsics.areEqual(this.texCoords, vertices.texCoords) && Intrinsics.areEqual(this.colors, vertices.colors) && Intrinsics.areEqual(this.boneIndices, vertices.boneIndices) && Intrinsics.areEqual(this.boneWeights, vertices.boneWeights) && Intrinsics.areEqual(this.indices, vertices.indices);
    }

    public final List<List<Long>> getBoneIndices() {
        return this.boneIndices;
    }

    public final List<List<Float>> getBoneWeights() {
        return this.boneWeights;
    }

    public final List<Long> getColors() {
        return this.colors;
    }

    public final List<Long> getIndices() {
        return this.indices;
    }

    public final long getMode() {
        return this.mode;
    }

    public final List<Point> getPositions() {
        return this.positions;
    }

    public final List<Point> getTexCoords() {
        return this.texCoords;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int iHashCode = Long.hashCode(this.mode) * 31;
        boolean z = this.isVolatile;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (this.positions.hashCode() + ((iHashCode + r1) * 31)) * 31;
        List<Point> list = this.texCoords;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<Long> list2 = this.colors;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<List<Long>> list3 = this.boneIndices;
        int iHashCode5 = (iHashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<List<Float>> list4 = this.boneWeights;
        return this.indices.hashCode() + ((iHashCode5 + (list4 != null ? list4.hashCode() : 0)) * 31);
    }

    public final boolean isVolatile() {
        return this.isVolatile;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Vertices toProtobufInstance() {
        MutationPayload$Vertices.a aVarA = MutationPayload$Vertices.newBuilder().a(this.mode).a(this.isVolatile);
        List<Point> list = this.positions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Point) it.next()).toProtobufInstance());
        }
        MutationPayload$Vertices.a aVarA2 = aVarA.a(CollectionsKt.toList(arrayList));
        List<Long> list2 = this.indices;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Double.valueOf(((Number) it2.next()).longValue()));
        }
        MutationPayload$Vertices.a aVarB = aVarA2.b(arrayList2);
        List<Point> list3 = this.texCoords;
        if (list3 != null) {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(((Point) it3.next()).toProtobufInstance());
            }
            aVarB.b(CollectionsKt.toList(arrayList3));
        }
        List<Long> list4 = this.colors;
        if (list4 != null) {
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it4 = list4.iterator();
            while (it4.hasNext()) {
                arrayList4.add(Double.valueOf(((Number) it4.next()).longValue()));
            }
            aVarB.a(arrayList4);
        }
        List<List> arrayList5 = this.boneIndices;
        if (arrayList5 == null) {
            arrayList5 = new ArrayList();
        }
        for (List list5 : arrayList5) {
            MutationPayload$DoubleList.a aVarNewBuilder = MutationPayload$DoubleList.newBuilder();
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
            Iterator it5 = list5.iterator();
            while (it5.hasNext()) {
                arrayList6.add(Double.valueOf(((Number) it5.next()).longValue()));
            }
            aVarB.a(aVarNewBuilder.a(arrayList6).build());
        }
        List arrayList7 = this.boneWeights;
        if (arrayList7 == null) {
            arrayList7 = new ArrayList();
        }
        Iterator it6 = arrayList7.iterator();
        while (it6.hasNext()) {
            aVarB.a(MutationPayload$FloatList.newBuilder().a((List) it6.next()).build());
        }
        MutationPayload$Vertices mutationPayload$VerticesBuild = aVarB.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$VerticesBuild, "builder.build()");
        return mutationPayload$VerticesBuild;
    }

    public String toString() {
        return b.a("Vertices(mode=").append(this.mode).append(", isVolatile=").append(this.isVolatile).append(", positions=").append(this.positions).append(", texCoords=").append(this.texCoords).append(", colors=").append(this.colors).append(", boneIndices=").append(this.boneIndices).append(", boneWeights=").append(this.boneWeights).append(", indices=").append(this.indices).append(')').toString();
    }
}
