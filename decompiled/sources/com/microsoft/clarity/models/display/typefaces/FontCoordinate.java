package com.microsoft.clarity.models.display.typefaces;

import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FontCoordinate;

/* JADX INFO: loaded from: classes9.dex */
public final class FontCoordinate implements IProtoModel<MutationPayload$FontCoordinate> {
    private final String axis;
    private final float value;

    public FontCoordinate(String str, float f2) {
        this.axis = str;
        this.value = f2;
    }

    public String getAxis() {
        return this.axis;
    }

    public float getValue() {
        return this.value;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$FontCoordinate toProtobufInstance() {
        return MutationPayload$FontCoordinate.newBuilder().a(getAxis()).a(getValue()).build();
    }
}
