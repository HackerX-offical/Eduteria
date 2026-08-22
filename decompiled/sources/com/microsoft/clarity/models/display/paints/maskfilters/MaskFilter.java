package com.microsoft.clarity.models.display.paints.maskfilters;

import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.Flattenable;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$MaskFilter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilter;", "Lcom/microsoft/clarity/models/display/common/Flattenable;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$MaskFilter;", "()V", "type", "Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilterType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilterType;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MaskFilter extends Flattenable implements IProtoModel<MutationPayload$MaskFilter> {
    public abstract MaskFilterType getType();
}
