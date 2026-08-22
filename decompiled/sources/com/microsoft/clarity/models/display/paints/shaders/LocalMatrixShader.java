package com.microsoft.clarity.models.display.paints.shaders;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Shader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/shaders/LocalMatrixShader;", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "matrix", "", "", "shader", "(Ljava/util/List;Lcom/microsoft/clarity/models/display/paints/shaders/Shader;)V", "getMatrix", "()Ljava/util/List;", "getShader", "()Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "type", "Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/shaders/ShaderType;", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Shader;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class LocalMatrixShader extends Shader {
    private final List<Float> matrix;
    private final Shader shader;
    private final ShaderType type;

    public LocalMatrixShader(List<Float> matrix, Shader shader) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.matrix = matrix;
        this.shader = shader;
        this.type = ShaderType.LocalMatrixShader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocalMatrixShader copy$default(LocalMatrixShader localMatrixShader, List list, Shader shader, int i, Object obj) {
        if ((i & 1) != 0) {
            list = localMatrixShader.matrix;
        }
        if ((i & 2) != 0) {
            shader = localMatrixShader.shader;
        }
        return localMatrixShader.copy(list, shader);
    }

    public final List<Float> component1() {
        return this.matrix;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Shader getShader() {
        return this.shader;
    }

    public final LocalMatrixShader copy(List<Float> matrix, Shader shader) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        return new LocalMatrixShader(matrix, shader);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalMatrixShader)) {
            return false;
        }
        LocalMatrixShader localMatrixShader = (LocalMatrixShader) other;
        return Intrinsics.areEqual(this.matrix, localMatrixShader.matrix) && Intrinsics.areEqual(this.shader, localMatrixShader.shader);
    }

    public final List<Float> getMatrix() {
        return this.matrix;
    }

    public final Shader getShader() {
        return this.shader;
    }

    @Override // com.microsoft.clarity.models.display.paints.shaders.Shader
    public ShaderType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.matrix.hashCode() * 31;
        Shader shader = this.shader;
        return iHashCode + (shader == null ? 0 : shader.hashCode());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Shader toProtobufInstance() {
        MutationPayload$Shader.a aVarC = MutationPayload$Shader.newBuilder().a(getType().name()).c(this.matrix);
        Shader shader = this.shader;
        if (shader != null) {
            aVarC.a(shader.toProtobufInstance());
        }
        MutationPayload$Shader mutationPayload$ShaderBuild = aVarC.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$ShaderBuild, "builder.build()");
        return mutationPayload$ShaderBuild;
    }

    public String toString() {
        return b.a("LocalMatrixShader(matrix=").append(this.matrix).append(", shader=").append(this.shader).append(')').toString();
    }
}
