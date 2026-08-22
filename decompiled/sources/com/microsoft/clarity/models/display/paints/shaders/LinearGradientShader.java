package com.microsoft.clarity.models.display.paints.shaders;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.display.common.Point;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Shader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0003Je\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\b\u0010+\u001a\u00020,H\u0016J\t\u0010-\u001a\u00020.HÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/LinearGradientShader;", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "start", "Lcom/microsoft/clarity/models/display/common/Point;", "end", "tileMode", "", "gradFlags", "colors", "", "Lcom/microsoft/clarity/models/display/paints/Color4f;", Constants.INAPP_POSITION, "", "localMatrix", "(Lcom/microsoft/clarity/models/display/common/Point;Lcom/microsoft/clarity/models/display/common/Point;JJLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getColors", "()Ljava/util/List;", "getEnd", "()Lcom/microsoft/clarity/models/display/common/Point;", "getGradFlags", "()J", "getLocalMatrix", "getPos", "getStart", "getTileMode", "type", "Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Shader;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class LinearGradientShader extends Shader {
    private final List<Color4f> colors;
    private final Point end;
    private final long gradFlags;
    private final List<Float> localMatrix;
    private final List<Float> pos;
    private final Point start;
    private final long tileMode;
    private final ShaderType type;

    public LinearGradientShader(Point start, Point end, long j, long j2, List<Color4f> colors, List<Float> list, List<Float> list2) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.start = start;
        this.end = end;
        this.tileMode = j;
        this.gradFlags = j2;
        this.colors = colors;
        this.pos = list;
        this.localMatrix = list2;
        this.type = ShaderType.LinearGradientShader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LinearGradientShader copy$default(LinearGradientShader linearGradientShader, Point point, Point point2, long j, long j2, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            point = linearGradientShader.start;
        }
        if ((i & 2) != 0) {
            point2 = linearGradientShader.end;
        }
        if ((i & 4) != 0) {
            j = linearGradientShader.tileMode;
        }
        if ((i & 8) != 0) {
            j2 = linearGradientShader.gradFlags;
        }
        if ((i & 16) != 0) {
            list = linearGradientShader.colors;
        }
        if ((i & 32) != 0) {
            list2 = linearGradientShader.pos;
        }
        if ((i & 64) != 0) {
            list3 = linearGradientShader.localMatrix;
        }
        List list4 = list3;
        List list5 = list;
        long j3 = j2;
        long j4 = j;
        return linearGradientShader.copy(point, point2, j4, j3, list5, list2, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Point getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Point getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTileMode() {
        return this.tileMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getGradFlags() {
        return this.gradFlags;
    }

    public final List<Color4f> component5() {
        return this.colors;
    }

    public final List<Float> component6() {
        return this.pos;
    }

    public final List<Float> component7() {
        return this.localMatrix;
    }

    public final LinearGradientShader copy(Point start, Point end, long tileMode, long gradFlags, List<Color4f> colors, List<Float> pos, List<Float> localMatrix) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new LinearGradientShader(start, end, tileMode, gradFlags, colors, pos, localMatrix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinearGradientShader)) {
            return false;
        }
        LinearGradientShader linearGradientShader = (LinearGradientShader) other;
        return Intrinsics.areEqual(this.start, linearGradientShader.start) && Intrinsics.areEqual(this.end, linearGradientShader.end) && this.tileMode == linearGradientShader.tileMode && this.gradFlags == linearGradientShader.gradFlags && Intrinsics.areEqual(this.colors, linearGradientShader.colors) && Intrinsics.areEqual(this.pos, linearGradientShader.pos) && Intrinsics.areEqual(this.localMatrix, linearGradientShader.localMatrix);
    }

    public final List<Color4f> getColors() {
        return this.colors;
    }

    public final Point getEnd() {
        return this.end;
    }

    public final long getGradFlags() {
        return this.gradFlags;
    }

    public final List<Float> getLocalMatrix() {
        return this.localMatrix;
    }

    public final List<Float> getPos() {
        return this.pos;
    }

    public final Point getStart() {
        return this.start;
    }

    public final long getTileMode() {
        return this.tileMode;
    }

    @Override // com.microsoft.clarity.models.display.paints.shaders.Shader
    public ShaderType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = (this.colors.hashCode() + ((Long.hashCode(this.gradFlags) + ((Long.hashCode(this.tileMode) + ((this.end.hashCode() + (this.start.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        List<Float> list = this.pos;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Float> list2 = this.localMatrix;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Shader toProtobufInstance() {
        MutationPayload$Shader.a aVarA = MutationPayload$Shader.newBuilder().a(getType().name()).c(this.start.toProtobufInstance()).b(this.end.toProtobufInstance()).d(this.tileMode).a(this.gradFlags);
        List<Color4f> list = this.colors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Color4f) it.next()).toProtobufInstance());
        }
        MutationPayload$Shader.a aVarA2 = aVarA.a(CollectionsKt.toList(arrayList));
        List<Float> list2 = this.pos;
        if (list2 != null) {
            aVarA2.d(list2);
        }
        List<Float> list3 = this.localMatrix;
        if (list3 != null) {
            aVarA2.b(list3);
        }
        MutationPayload$Shader mutationPayload$ShaderBuild = aVarA2.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$ShaderBuild, "builder.build()");
        return mutationPayload$ShaderBuild;
    }

    public String toString() {
        return b.a("LinearGradientShader(start=").append(this.start).append(", end=").append(this.end).append(", tileMode=").append(this.tileMode).append(", gradFlags=").append(this.gradFlags).append(", colors=").append(this.colors).append(", pos=").append(this.pos).append(", localMatrix=").append(this.localMatrix).append(')').toString();
    }
}
