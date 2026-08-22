package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.models.display.common.Rect;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawImageNine;", "Lcom/microsoft/clarity/models/display/commands/DrawImageBase;", "center", "Lcom/microsoft/clarity/models/display/common/IRect;", "dst", "Lcom/microsoft/clarity/models/display/common/Rect;", "imageIndex", "", "paintIndex", "(Lcom/microsoft/clarity/models/display/common/IRect;Lcom/microsoft/clarity/models/display/common/Rect;Ljava/lang/Integer;I)V", "getCenter", "()Lcom/microsoft/clarity/models/display/common/IRect;", "getDst", "()Lcom/microsoft/clarity/models/display/common/Rect;", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrawImageNine extends DrawImageBase {
    private final IRect center;
    private final Rect dst;
    private final DisplayCommandType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawImageNine(IRect center, Rect dst, Integer num, int i) {
        super(num, i);
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(dst, "dst");
        this.center = center;
        this.dst = dst;
        this.type = DisplayCommandType.DrawImageNine;
    }

    public final IRect getCenter() {
        return this.center;
    }

    public final Rect getDst() {
        return this.dst;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        MutationPayload$DisplayCommand.a aVarJ = MutationPayload$DisplayCommand.newBuilder().b(getType().name()).b(this.center.toProtobufInstance()).c(this.dst.toProtobufInstance()).j(getPaintIndex());
        if (getImageIndex() != null) {
            Integer imageIndex = getImageIndex();
            aVarJ.f(imageIndex != null ? imageIndex.intValue() : 0);
        }
        if (getMaskedWidth() != null) {
            Integer maskedWidth = getMaskedWidth();
            aVarJ.h(maskedWidth != null ? maskedWidth.intValue() : 0);
        }
        if (getMaskedHeight() != null) {
            Integer maskedWidth2 = getMaskedWidth();
            aVarJ.g(maskedWidth2 != null ? maskedWidth2.intValue() : 0);
        }
        if (getMaskedColor() != null) {
            Color4f maskedColor = getMaskedColor();
            aVarJ.a(maskedColor != null ? maskedColor.toProtobufInstance() : null);
        }
        MutationPayload$DisplayCommand mutationPayload$DisplayCommandBuild = aVarJ.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$DisplayCommandBuild, "builder.build()");
        return mutationPayload$DisplayCommandBuild;
    }
}
