package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.models.display.common.Point;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawPoints;", "Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "pointMode", "", "points", "", "Lcom/microsoft/clarity/models/display/common/Point;", "paintIndex", "(ILjava/util/List;I)V", "getPointMode", "()I", "getPoints", "()Ljava/util/List;", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrawPoints extends PaintableCommand {
    private final int pointMode;
    private final List<Point> points;
    private final DisplayCommandType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawPoints(int i, List<Point> points, int i2) {
        super(i2);
        Intrinsics.checkNotNullParameter(points, "points");
        this.pointMode = i;
        this.points = points;
        this.type = DisplayCommandType.DrawPoints;
    }

    public final int getPointMode() {
        return this.pointMode;
    }

    public final List<Point> getPoints() {
        return this.points;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        MutationPayload$DisplayCommand.a aVarL = MutationPayload$DisplayCommand.newBuilder().b(getType().name()).l(this.pointMode);
        List<Point> list = this.points;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Point) it.next()).toProtobufInstance());
        }
        MutationPayload$DisplayCommand mutationPayload$DisplayCommandBuild = aVarL.b(CollectionsKt.toList(arrayList)).j(getPaintIndex()).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$DisplayCommandBuild, "builder.build()");
        return mutationPayload$DisplayCommandBuild;
    }
}
