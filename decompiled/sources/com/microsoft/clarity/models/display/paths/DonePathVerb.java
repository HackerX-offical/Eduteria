package com.microsoft.clarity.models.display.paths;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathVerb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/microsoft/clarity/models/display/paths/DonePathVerb;", "Lcom/microsoft/clarity/models/display/paths/PathVerb;", "()V", "type", "Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getType", "()Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "equals", "", "other", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathVerb;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DonePathVerb extends PathVerb {
    private final PathVerbType type = PathVerbType.Done;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(DonePathVerb.class, other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(toString(), other.toString());
    }

    @Override // com.microsoft.clarity.models.display.paths.PathVerb
    public PathVerbType getType() {
        return this.type;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathVerb toProtobufInstance() {
        MutationPayload$PathVerb mutationPayload$PathVerbBuild = MutationPayload$PathVerb.newBuilder().a(getType().name()).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$PathVerbBuild, "newBuilder()\n           …ame)\n            .build()");
        return mutationPayload$PathVerbBuild;
    }

    public String toString() {
        return "DonePathVerb()";
    }
}
