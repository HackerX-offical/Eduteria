package com.microsoft.clarity.models.display.typefaces;

import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FontStyle;

/* JADX INFO: loaded from: classes9.dex */
public final class FontStyle implements IProtoModel<MutationPayload$FontStyle> {
    private final long slant;
    private final long weight;
    private final long width;

    public FontStyle(long j, long j2, long j3) {
        this.weight = j;
        this.width = j2;
        this.slant = j3;
    }

    public long getSlant() {
        return this.slant;
    }

    public long getWeight() {
        return this.weight;
    }

    public long getWidth() {
        return this.width;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$FontStyle toProtobufInstance() {
        return MutationPayload$FontStyle.newBuilder().a(getSlant()).b(getWeight()).c(getWidth()).build();
    }
}
