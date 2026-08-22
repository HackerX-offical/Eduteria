package com.microsoft.clarity.models.display.paints;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.paints.colorfilters.ColorFilter;
import com.microsoft.clarity.models.display.paints.loopers.Looper;
import com.microsoft.clarity.models.display.paints.maskfilters.MaskFilter;
import com.microsoft.clarity.models.display.paints.patheffects.PathEffect;
import com.microsoft.clarity.models.display.paints.shaders.Shader;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u007f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u00102\u001a\u00020\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J\t\u0010=\u001a\u00020\u000bHÆ\u0003J\t\u0010>\u001a\u00020\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u000eHÆ\u0003J\u009f\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010A\u001a\u00020\u000e2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\b\u0010F\u001a\u00020\u0002H\u0016J\t\u0010G\u001a\u00020HHÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001e¨\u0006I"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/Paint;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Paint;", "color", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "style", "", "blendMode", "strokeCap", "strokeJoin", "strokeWidth", "", "strokeMiter", "antiAlias", "", "dither", "colorFilter", "Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilter;", "maskFilter", "Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilter;", "shader", "Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "looper", "Lcom/microsoft/clarity/models/display/paints/loopers/Looper;", "pathEffect", "Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;", "(Lcom/microsoft/clarity/models/display/paints/Color4f;JJJJFFZZLcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilter;Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilter;Lcom/microsoft/clarity/models/display/paints/shaders/Shader;Lcom/microsoft/clarity/models/display/paints/loopers/Looper;Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;)V", "getAntiAlias", "()Z", "getBlendMode", "()J", "getColor", "()Lcom/microsoft/clarity/models/display/paints/Color4f;", "getColorFilter", "()Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilter;", "getDither", "getLooper", "()Lcom/microsoft/clarity/models/display/paints/loopers/Looper;", "getMaskFilter", "()Lcom/microsoft/clarity/models/display/paints/maskfilters/MaskFilter;", "getPathEffect", "()Lcom/microsoft/clarity/models/display/paints/patheffects/PathEffect;", "getShader", "()Lcom/microsoft/clarity/models/display/paints/shaders/Shader;", "getStrokeCap", "getStrokeJoin", "getStrokeMiter", "()F", "getStrokeWidth", "getStyle", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", Constants.COPY_TYPE, "equals", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class Paint implements IProtoModel<MutationPayload$Paint> {
    private final boolean antiAlias;
    private final long blendMode;
    private final Color4f color;
    private final ColorFilter colorFilter;
    private final boolean dither;
    private final Looper looper;
    private final MaskFilter maskFilter;
    private final PathEffect pathEffect;
    private final Shader shader;
    private final long strokeCap;
    private final long strokeJoin;
    private final float strokeMiter;
    private final float strokeWidth;
    private final long style;

    public Paint(Color4f color, long j, long j2, long j3, long j4, float f2, float f3, boolean z, boolean z2, ColorFilter colorFilter, MaskFilter maskFilter, Shader shader, Looper looper, PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.style = j;
        this.blendMode = j2;
        this.strokeCap = j3;
        this.strokeJoin = j4;
        this.strokeWidth = f2;
        this.strokeMiter = f3;
        this.antiAlias = z;
        this.dither = z2;
        this.colorFilter = colorFilter;
        this.maskFilter = maskFilter;
        this.shader = shader;
        this.looper = looper;
        this.pathEffect = pathEffect;
    }

    public static /* synthetic */ Paint copy$default(Paint paint, Color4f color4f, long j, long j2, long j3, long j4, float f2, float f3, boolean z, boolean z2, ColorFilter colorFilter, MaskFilter maskFilter, Shader shader, Looper looper, PathEffect pathEffect, int i, Object obj) {
        Color4f color4f2 = (i & 1) != 0 ? paint.color : color4f;
        return paint.copy(color4f2, (i & 2) != 0 ? paint.style : j, (i & 4) != 0 ? paint.blendMode : j2, (i & 8) != 0 ? paint.strokeCap : j3, (i & 16) != 0 ? paint.strokeJoin : j4, (i & 32) != 0 ? paint.strokeWidth : f2, (i & 64) != 0 ? paint.strokeMiter : f3, (i & 128) != 0 ? paint.antiAlias : z, (i & 256) != 0 ? paint.dither : z2, (i & 512) != 0 ? paint.colorFilter : colorFilter, (i & 1024) != 0 ? paint.maskFilter : maskFilter, (i & 2048) != 0 ? paint.shader : shader, (i & 4096) != 0 ? paint.looper : looper, (i & 8192) != 0 ? paint.pathEffect : pathEffect);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color4f getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MaskFilter getMaskFilter() {
        return this.maskFilter;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Shader getShader() {
        return this.shader;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Looper getLooper() {
        return this.looper;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getBlendMode() {
        return this.blendMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getStrokeCap() {
        return this.strokeCap;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getStrokeJoin() {
        return this.strokeJoin;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getStrokeMiter() {
        return this.strokeMiter;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAntiAlias() {
        return this.antiAlias;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getDither() {
        return this.dither;
    }

    public final Paint copy(Color4f color, long style, long blendMode, long strokeCap, long strokeJoin, float strokeWidth, float strokeMiter, boolean antiAlias, boolean dither, ColorFilter colorFilter, MaskFilter maskFilter, Shader shader, Looper looper, PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new Paint(color, style, blendMode, strokeCap, strokeJoin, strokeWidth, strokeMiter, antiAlias, dither, colorFilter, maskFilter, shader, looper, pathEffect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Paint)) {
            return false;
        }
        Paint paint = (Paint) other;
        return Intrinsics.areEqual(this.color, paint.color) && this.style == paint.style && this.blendMode == paint.blendMode && this.strokeCap == paint.strokeCap && this.strokeJoin == paint.strokeJoin && Intrinsics.areEqual((Object) Float.valueOf(this.strokeWidth), (Object) Float.valueOf(paint.strokeWidth)) && Intrinsics.areEqual((Object) Float.valueOf(this.strokeMiter), (Object) Float.valueOf(paint.strokeMiter)) && this.antiAlias == paint.antiAlias && this.dither == paint.dither && Intrinsics.areEqual(this.colorFilter, paint.colorFilter) && Intrinsics.areEqual(this.maskFilter, paint.maskFilter) && Intrinsics.areEqual(this.shader, paint.shader) && Intrinsics.areEqual(this.looper, paint.looper) && Intrinsics.areEqual(this.pathEffect, paint.pathEffect);
    }

    public final boolean getAntiAlias() {
        return this.antiAlias;
    }

    public final long getBlendMode() {
        return this.blendMode;
    }

    public final Color4f getColor() {
        return this.color;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final boolean getDither() {
        return this.dither;
    }

    public final Looper getLooper() {
        return this.looper;
    }

    public final MaskFilter getMaskFilter() {
        return this.maskFilter;
    }

    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public final Shader getShader() {
        return this.shader;
    }

    public final long getStrokeCap() {
        return this.strokeCap;
    }

    public final long getStrokeJoin() {
        return this.strokeJoin;
    }

    public final float getStrokeMiter() {
        return this.strokeMiter;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final long getStyle() {
        return this.style;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public int hashCode() {
        int iHashCode = (Float.hashCode(this.strokeMiter) + ((Float.hashCode(this.strokeWidth) + ((Long.hashCode(this.strokeJoin) + ((Long.hashCode(this.strokeCap) + ((Long.hashCode(this.blendMode) + ((Long.hashCode(this.style) + (this.color.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.antiAlias;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.dither;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        int iHashCode2 = (i2 + (colorFilter == null ? 0 : colorFilter.hashCode())) * 31;
        MaskFilter maskFilter = this.maskFilter;
        int iHashCode3 = (iHashCode2 + (maskFilter == null ? 0 : maskFilter.hashCode())) * 31;
        Shader shader = this.shader;
        int iHashCode4 = (iHashCode3 + (shader == null ? 0 : shader.hashCode())) * 31;
        Looper looper = this.looper;
        int iHashCode5 = (iHashCode4 + (looper == null ? 0 : looper.hashCode())) * 31;
        PathEffect pathEffect = this.pathEffect;
        return iHashCode5 + (pathEffect != null ? pathEffect.hashCode() : 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Paint toProtobufInstance() {
        MutationPayload$Paint.a aVarB = MutationPayload$Paint.newBuilder().a(this.color.toProtobufInstance()).d(this.style).a(this.blendMode).b(this.strokeCap).c(this.strokeJoin).b(this.strokeWidth).a(this.strokeMiter).a(this.antiAlias).b(this.dither);
        ColorFilter colorFilter = this.colorFilter;
        if (colorFilter != null) {
            aVarB.a(colorFilter.toProtobufInstance());
        }
        MaskFilter maskFilter = this.maskFilter;
        if (maskFilter != null) {
            aVarB.a(maskFilter.toProtobufInstance());
        }
        Shader shader = this.shader;
        if (shader != null) {
            aVarB.a(shader.toProtobufInstance());
        }
        Looper looper = this.looper;
        if (looper != null) {
            aVarB.a(looper.toProtobufInstance());
        }
        PathEffect pathEffect = this.pathEffect;
        if (pathEffect != null) {
            aVarB.a(pathEffect.toProtobufInstance());
        }
        MutationPayload$Paint mutationPayload$PaintBuild = aVarB.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$PaintBuild, "builder.build()");
        return mutationPayload$PaintBuild;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Paint(color=");
        sb.append(this.color).append(", style=").append(this.style).append(", blendMode=").append(this.blendMode).append(", strokeCap=").append(this.strokeCap).append(", strokeJoin=").append(this.strokeJoin).append(", strokeWidth=").append(this.strokeWidth).append(", strokeMiter=").append(this.strokeMiter).append(", antiAlias=").append(this.antiAlias).append(", dither=").append(this.dither).append(", colorFilter=").append(this.colorFilter).append(", maskFilter=").append(this.maskFilter).append(", shader=");
        sb.append(this.shader).append(", looper=").append(this.looper).append(", pathEffect=").append(this.pathEffect).append(')');
        return sb.toString();
    }
}
