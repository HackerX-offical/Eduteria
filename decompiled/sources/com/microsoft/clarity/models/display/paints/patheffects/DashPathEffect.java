package com.microsoft.clarity.models.display.paints.patheffects;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathEffect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/patheffects/DashPathEffect;", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;", TypedValues.CycleType.S_WAVE_PHASE, "", "intervals", "", "(FLjava/util/List;)V", "getIntervals", "()Ljava/util/List;", "getPhase", "()F", "type", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffectType;", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathEffect;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DashPathEffect extends PathEffect {
    private final List<Float> intervals;
    private final float phase;
    private final PathEffectType type;

    public DashPathEffect(float f2, List<Float> intervals) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        this.phase = f2;
        this.intervals = intervals;
        this.type = PathEffectType.DashPathEffect;
    }

    public final List<Float> getIntervals() {
        return this.intervals;
    }

    public final float getPhase() {
        return this.phase;
    }

    @Override // com.microsoft.clarity.models.display.paints.patheffects.PathEffect
    public PathEffectType getType() {
        return this.type;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathEffect toProtobufInstance() {
        MutationPayload$PathEffect mutationPayload$PathEffectBuild = MutationPayload$PathEffect.newBuilder().a(getType().name()).a(this.phase).a(this.intervals).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$PathEffectBuild, "newBuilder()\n           …als)\n            .build()");
        return mutationPayload$PathEffectBuild;
    }
}
