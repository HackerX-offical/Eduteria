package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawPaint;", "Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "paintIndex", "", "(I)V", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrawPaint extends PaintableCommand {
    private final DisplayCommandType type;

    public DrawPaint(int i) {
        super(i);
        this.type = DisplayCommandType.DrawPaint;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        MutationPayload$DisplayCommand mutationPayload$DisplayCommandBuild = MutationPayload$DisplayCommand.newBuilder().b(getType().name()).j(getPaintIndex()).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$DisplayCommandBuild, "builder.build()");
        return mutationPayload$DisplayCommandBuild;
    }
}
