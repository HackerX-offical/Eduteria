package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "()V", "type", "Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "getType", "()Lcom/microsoft/clarity/models/display/commands/DisplayCommandType;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DisplayCommand implements IProtoModel<MutationPayload$DisplayCommand> {
    public abstract DisplayCommandType getType();
}
