package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.models.display.common.Rect;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawArc;", "Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "rect", "Lcom/microsoft/clarity/models/display/common/Rect;", "startAngle", "", "sweepAngle", "useCenter", "", "paintIndex", "", "(Lcom/microsoft/clarity/models/display/common/Rect;FFZI)V", "getRect", "()Lcom/microsoft/clarity/models/display/common/Rect;", "getStartAngle", "()F", "getSweepAngle", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getUseCenter", "()Z", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrawArc extends PaintableCommand {
    private final Rect rect;
    private final float startAngle;
    private final float sweepAngle;
    private final DisplayCommandType type;
    private final boolean useCenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawArc(Rect rect, float f2, float f3, boolean z, int i) {
        super(i);
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rect = rect;
        this.startAngle = f2;
        this.sweepAngle = f3;
        this.useCenter = z;
        this.type = DisplayCommandType.DrawArc;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final float getStartAngle() {
        return this.startAngle;
    }

    public final float getSweepAngle() {
        return this.sweepAngle;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    public final boolean getUseCenter() {
        return this.useCenter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        MutationPayload$DisplayCommand mutationPayload$DisplayCommandBuild = MutationPayload$DisplayCommand.newBuilder().b(getType().name()).f(this.rect.toProtobufInstance()).b(this.startAngle).c(this.sweepAngle).b(this.useCenter).j(getPaintIndex()).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$DisplayCommandBuild, "newBuilder()\n           …dex)\n            .build()");
        return mutationPayload$DisplayCommandBuild;
    }
}
