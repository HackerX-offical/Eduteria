package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.models.display.common.RRect;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawRRect;", "Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "rrect", "Lcom/microsoft/clarity/models/display/common/RRect;", "paintIndex", "", "(Lcom/microsoft/clarity/models/display/common/RRect;I)V", "getRrect", "()Lcom/microsoft/clarity/models/display/common/RRect;", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrawRRect extends PaintableCommand {
    private final RRect rrect;
    private final DisplayCommandType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawRRect(RRect rrect, int i) {
        super(i);
        Intrinsics.checkNotNullParameter(rrect, "rrect");
        this.rrect = rrect;
        this.type = DisplayCommandType.DrawRRect;
    }

    public final RRect getRrect() {
        return this.rrect;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        MutationPayload$DisplayCommand mutationPayload$DisplayCommandBuild = MutationPayload$DisplayCommand.newBuilder().b(getType().name()).g(this.rrect.toProtobufInstance()).j(getPaintIndex()).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$DisplayCommandBuild, "builder.build()");
        return mutationPayload$DisplayCommandBuild;
    }
}
