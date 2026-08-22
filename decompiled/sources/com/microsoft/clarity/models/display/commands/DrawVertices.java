package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001f\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawVertices;", "Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "verticesIndex", "", "mode", "", "paintIndex", "bones", "", "", "(IJILjava/util/List;)V", "getBones", "()Ljava/util/List;", "getMode", "()J", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getVerticesIndex", "()I", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrawVertices extends PaintableCommand {
    private final List<List<Float>> bones;
    private final long mode;
    private final DisplayCommandType type;
    private final int verticesIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public DrawVertices(int i, long j, int i2, List<? extends List<Float>> list) {
        super(i2);
        this.verticesIndex = i;
        this.mode = j;
        this.bones = list;
        this.type = DisplayCommandType.DrawVertices;
    }

    public final List<List<Float>> getBones() {
        return this.bones;
    }

    public final long getMode() {
        return this.mode;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    public final int getVerticesIndex() {
        return this.verticesIndex;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        MutationPayload$DisplayCommand.a aVarJ = MutationPayload$DisplayCommand.newBuilder().b(getType().name()).m(this.verticesIndex).b(this.mode).j(getPaintIndex());
        List arrayList = this.bones;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVarJ.a(MutationPayload$FloatList.newBuilder().a((List) it.next()).build());
        }
        MutationPayload$DisplayCommand mutationPayload$DisplayCommandBuild = aVarJ.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$DisplayCommandBuild, "builder.build()");
        return mutationPayload$DisplayCommandBuild;
    }
}
