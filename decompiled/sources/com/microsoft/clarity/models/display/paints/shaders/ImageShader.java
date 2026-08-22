package com.microsoft.clarity.models.display.paints.shaders;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.images.Sampling;
import com.microsoft.clarity.models.display.paints.Color4f;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Shader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003JM\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u00108\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0012HÖ\u0001J\b\u0010<\u001a\u00020=H\u0016J\t\u0010>\u001a\u00020?HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001e\u0010!\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006@"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/ImageShader;", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "tX", "", "tY", "matrix", "", "", "raw", "", "image", "Lcom/microsoft/clarity/models/display/images/Image;", "sampling", "Lcom/microsoft/clarity/models/display/images/Sampling;", "(JJLjava/util/List;ZLcom/microsoft/clarity/models/display/images/Image;Lcom/microsoft/clarity/models/display/images/Sampling;)V", "getImage", "()Lcom/microsoft/clarity/models/display/images/Image;", "imageIndex", "", "getImageIndex", "()Ljava/lang/Integer;", "setImageIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maskedColor", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "getMaskedColor", "()Lcom/microsoft/clarity/models/display/paints/Color4f;", "setMaskedColor", "(Lcom/microsoft/clarity/models/display/paints/Color4f;)V", "maskedHeight", "getMaskedHeight", "setMaskedHeight", "maskedWidth", "getMaskedWidth", "setMaskedWidth", "getMatrix", "()Ljava/util/List;", "getRaw", "()Z", "getSampling", "()Lcom/microsoft/clarity/models/display/images/Sampling;", "getTX", "()J", "getTY", "type", "Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "equals", "other", "", "hashCode", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Shader;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ImageShader extends Shader {
    private final transient Image image;
    private Integer imageIndex;
    private Color4f maskedColor;
    private Integer maskedHeight;
    private Integer maskedWidth;
    private final List<Float> matrix;
    private final boolean raw;
    private final Sampling sampling;
    private final long tX;
    private final long tY;
    private final ShaderType type;

    public ImageShader(long j, long j2, List<Float> matrix, boolean z, Image image, Sampling sampling) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(image, "image");
        this.tX = j;
        this.tY = j2;
        this.matrix = matrix;
        this.raw = z;
        this.image = image;
        this.sampling = sampling;
        this.type = ShaderType.ImageShader;
    }

    public /* synthetic */ ImageShader(long j, long j2, List list, boolean z, Image image, Sampling sampling, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, list, z, (i & 16) != 0 ? new Image(null, new byte[0], null, null) : image, sampling);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageShader copy$default(ImageShader imageShader, long j, long j2, List list, boolean z, Image image, Sampling sampling, int i, Object obj) {
        if ((i & 1) != 0) {
            j = imageShader.tX;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = imageShader.tY;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            list = imageShader.matrix;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            z = imageShader.raw;
        }
        return imageShader.copy(j3, j4, list2, z, (i & 16) != 0 ? imageShader.image : image, (i & 32) != 0 ? imageShader.sampling : sampling);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTX() {
        return this.tX;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTY() {
        return this.tY;
    }

    public final List<Float> component3() {
        return this.matrix;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRaw() {
        return this.raw;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Image getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Sampling getSampling() {
        return this.sampling;
    }

    public final ImageShader copy(long tX, long tY, List<Float> matrix, boolean raw, Image image, Sampling sampling) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(image, "image");
        return new ImageShader(tX, tY, matrix, raw, image, sampling);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageShader)) {
            return false;
        }
        ImageShader imageShader = (ImageShader) other;
        return this.tX == imageShader.tX && this.tY == imageShader.tY && Intrinsics.areEqual(this.matrix, imageShader.matrix) && this.raw == imageShader.raw && Intrinsics.areEqual(this.image, imageShader.image) && Intrinsics.areEqual(this.sampling, imageShader.sampling);
    }

    public final Image getImage() {
        return this.image;
    }

    public final Integer getImageIndex() {
        return this.imageIndex;
    }

    public final Color4f getMaskedColor() {
        return this.maskedColor;
    }

    public final Integer getMaskedHeight() {
        return this.maskedHeight;
    }

    public final Integer getMaskedWidth() {
        return this.maskedWidth;
    }

    public final List<Float> getMatrix() {
        return this.matrix;
    }

    public final boolean getRaw() {
        return this.raw;
    }

    public final Sampling getSampling() {
        return this.sampling;
    }

    public final long getTX() {
        return this.tX;
    }

    public final long getTY() {
        return this.tY;
    }

    @Override // com.microsoft.clarity.models.display.paints.shaders.Shader
    public ShaderType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = (this.matrix.hashCode() + ((Long.hashCode(this.tY) + (Long.hashCode(this.tX) * 31)) * 31)) * 31;
        boolean z = this.raw;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (this.image.hashCode() + ((iHashCode + r1) * 31)) * 31;
        Sampling sampling = this.sampling;
        return iHashCode2 + (sampling == null ? 0 : sampling.hashCode());
    }

    public final void setImageIndex(Integer num) {
        this.imageIndex = num;
    }

    public final void setMaskedColor(Color4f color4f) {
        this.maskedColor = color4f;
    }

    public final void setMaskedHeight(Integer num) {
        this.maskedHeight = num;
    }

    public final void setMaskedWidth(Integer num) {
        this.maskedWidth = num;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Shader toProtobufInstance() {
        MutationPayload$Shader.a aVarA = MutationPayload$Shader.newBuilder().a(getType().name()).b(this.tX).c(this.tY).c(this.matrix).a(this.raw);
        Sampling sampling = this.sampling;
        if (sampling != null) {
            aVarA.a(sampling.toProtobufInstance());
        }
        Integer num = this.imageIndex;
        if (num != null) {
            aVarA.a(num.intValue());
        }
        Integer num2 = this.maskedWidth;
        if (num2 != null) {
            aVarA.c(num2.intValue());
        }
        if (this.maskedHeight != null) {
            Integer num3 = this.maskedWidth;
            aVarA.b(num3 != null ? num3.intValue() : 0);
        }
        Color4f color4f = this.maskedColor;
        if (color4f != null) {
            aVarA.a(color4f.toProtobufInstance());
        }
        MutationPayload$Shader mutationPayload$ShaderBuild = aVarA.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$ShaderBuild, "builder.build()");
        return mutationPayload$ShaderBuild;
    }

    public String toString() {
        return b.a("ImageShader(tX=").append(this.tX).append(", tY=").append(this.tY).append(", matrix=").append(this.matrix).append(", raw=").append(this.raw).append(", image=").append(this.image).append(", sampling=").append(this.sampling).append(')').toString();
    }
}
