package com.microsoft.clarity.models.display.images;

import com.google.protobuf.ByteString;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.Asset;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Image;

/* JADX INFO: loaded from: classes9.dex */
public final class Image extends Asset implements IProtoModel<MutationPayload$Image> {
    private final byte[] mipmap;
    private final IRect subset;

    public Image(IRect iRect, byte[] bArr, String str, byte[] bArr2) {
        super(AssetType.Image, bArr, str);
        this.subset = iRect;
        this.mipmap = bArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Image.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Image toProtobufInstance() {
        MutationPayload$Image.a aVarNewBuilder = MutationPayload$Image.newBuilder();
        if (getDataHash() != null) {
            aVarNewBuilder.a(getDataHash());
        }
        IRect iRect = this.subset;
        if (iRect != null) {
            aVarNewBuilder.a(iRect.toProtobufInstance());
        }
        byte[] bArr = this.mipmap;
        if (bArr != null) {
            aVarNewBuilder.a(ByteString.copyFrom(bArr));
        }
        return aVarNewBuilder.build();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b.a("Image(").append(this.subset).append(", byteArrayOf(").toString());
        for (byte b2 : getData()) {
            sb.append((int) b2);
        }
        String str = "), ";
        sb.append("), ");
        if (this.mipmap == null) {
            str = "null, ";
        } else {
            sb.append("byteArrayOf(");
            for (byte b3 : this.mipmap) {
                sb.append((int) b3);
            }
        }
        sb.append(str);
        sb.append(getDataHash()).append(')');
        return sb.toString();
    }
}
