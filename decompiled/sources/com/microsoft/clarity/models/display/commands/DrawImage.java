package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.models.display.images.Sampling;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawImage;", "Lcom/microsoft/clarity/models/display/commands/DrawImageBase;", "x", "", "y", "imageIndex", "", "sampling", "Lcom/microsoft/clarity/models/display/images/Sampling;", "paintIndex", "(FFLjava/lang/Integer;Lcom/microsoft/clarity/models/display/images/Sampling;I)V", "getSampling", "()Lcom/microsoft/clarity/models/display/images/Sampling;", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getX", "()F", "getY", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrawImage extends DrawImageBase {
    private final Sampling sampling;
    private final DisplayCommandType type;
    private final float x;
    private final float y;

    public DrawImage(float f2, float f3, Integer num, Sampling sampling, int i) {
        super(num, i);
        this.x = f2;
        this.y = f3;
        this.sampling = sampling;
        this.type = DisplayCommandType.DrawImage;
    }

    public final Sampling getSampling() {
        return this.sampling;
    }

    @Override // com.microsoft.clarity.models.display.commands.DisplayCommand
    public DisplayCommandType getType() {
        return this.type;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        MutationPayload$DisplayCommand.a aVarJ = MutationPayload$DisplayCommand.newBuilder().b(getType().name()).g(this.x).h(this.y).j(getPaintIndex());
        Sampling sampling = this.sampling;
        if (sampling != null) {
            aVarJ.a(sampling.toProtobufInstance());
        }
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
