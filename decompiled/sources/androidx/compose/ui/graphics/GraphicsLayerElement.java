package androidx.compose.ui.graphics;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: GraphicsLayerModifier.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B£\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 J\b\u0010=\u001a\u00020\u0002H\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0002H\u0016J\f\u0010A\u001a\u00020?*\u00020BH\u0016J\t\u0010C\u001a\u00020\u0004HÆ\u0003J\t\u0010D\u001a\u00020\u0004HÆ\u0003J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J\t\u0010J\u001a\u00020\u0004HÆ\u0003J\t\u0010K\u001a\u00020\u0004HÆ\u0003J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\u0010\u0010M\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\bN\u0010-J\t\u0010O\u001a\u00020\u0011HÆ\u0003J\t\u0010P\u001a\u00020\u0013HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u0010R\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\bS\u0010-J\u0010\u0010T\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\bU\u0010-J\u0010\u0010V\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\bW\u00108J\u0010\u0010X\u001a\u00020\u001cHÆ\u0003¢\u0006\u0004\bY\u00108J\u000b\u0010Z\u001a\u0004\u0018\u00010\u001eHÆ\u0003JÒ\u0001\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b\\\u0010]J\u0014\u0010^\u001a\u00020\u00132\b\u0010_\u001a\u0004\u0018\u00010`HÖ\u0083\u0004J\n\u0010a\u001a\u00020bHÖ\u0081\u0004J\n\u0010c\u001a\u00020dHÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0016\u001a\u00020\u0017¢\u0006\n\n\u0002\u0010.\u001a\u0004\b5\u0010-R\u0013\u0010\u0018\u001a\u00020\u0017¢\u0006\n\n\u0002\u0010.\u001a\u0004\b6\u0010-R\u0013\u0010\u0019\u001a\u00020\u001a¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0013\u0010\u001b\u001a\u00020\u001c¢\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006e"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScaleX", "()F", "getScaleY", "getAlpha", "getTranslationX", "getTranslationY", "getShadowElevation", "getRotationX", "getRotationY", "getRotationZ", "getCameraDistance", "getTransformOrigin-SzJe1aQ", "()J", "J", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getClip", "()Z", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "getAmbientShadowColor-0d7_KjU", "getSpotShadowColor-0d7_KjU", "getCompositingStrategy--NrFUSI", "()I", "I", "getBlendMode-0nO6VwU", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "create", DiscoverItems.Item.UPDATE_ACTION, "", NodeElement.ELEMENT, "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component11-SzJe1aQ", "component12", "component13", "component14", "component15", "component15-0d7_KjU", "component16", "component16-0d7_KjU", "component17", "component17--NrFUSI", "component18", "component18-0nO6VwU", "component19", Constants.COPY_TYPE, "copy-cp5nf6A", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;)Landroidx/compose/ui/graphics/GraphicsLayerElement;", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
final /* data */ class GraphicsLayerElement extends ModifierNodeElement<SimpleGraphicsLayerModifier> {
    private final float alpha;
    private final long ambientShadowColor;
    private final int blendMode;
    private final float cameraDistance;
    private final boolean clip;
    private final ColorFilter colorFilter;
    private final int compositingStrategy;
    private final RenderEffect renderEffect;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleX;
    private final float scaleY;
    private final float shadowElevation;
    private final Shape shape;
    private final long spotShadowColor;
    private final long transformOrigin;
    private final float translationX;
    private final float translationY;

    public /* synthetic */ GraphicsLayerElement(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, int i2, ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, j, shape, z, renderEffect, j2, j3, i, i2, colorFilter);
    }

    /* JADX INFO: renamed from: copy-cp5nf6A$default, reason: not valid java name */
    public static /* synthetic */ GraphicsLayerElement m6118copycp5nf6A$default(GraphicsLayerElement graphicsLayerElement, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, int i2, ColorFilter colorFilter, int i3, Object obj) {
        ColorFilter colorFilter2;
        int i4;
        float f12 = (i3 & 1) != 0 ? graphicsLayerElement.scaleX : f2;
        float f13 = (i3 & 2) != 0 ? graphicsLayerElement.scaleY : f3;
        float f14 = (i3 & 4) != 0 ? graphicsLayerElement.alpha : f4;
        float f15 = (i3 & 8) != 0 ? graphicsLayerElement.translationX : f5;
        float f16 = (i3 & 16) != 0 ? graphicsLayerElement.translationY : f6;
        float f17 = (i3 & 32) != 0 ? graphicsLayerElement.shadowElevation : f7;
        float f18 = (i3 & 64) != 0 ? graphicsLayerElement.rotationX : f8;
        float f19 = (i3 & 128) != 0 ? graphicsLayerElement.rotationY : f9;
        float f20 = (i3 & 256) != 0 ? graphicsLayerElement.rotationZ : f10;
        float f21 = (i3 & 512) != 0 ? graphicsLayerElement.cameraDistance : f11;
        long j4 = (i3 & 1024) != 0 ? graphicsLayerElement.transformOrigin : j;
        Shape shape2 = (i3 & 2048) != 0 ? graphicsLayerElement.shape : shape;
        boolean z2 = (i3 & 4096) != 0 ? graphicsLayerElement.clip : z;
        float f22 = f12;
        RenderEffect renderEffect2 = (i3 & 8192) != 0 ? graphicsLayerElement.renderEffect : renderEffect;
        long j5 = (i3 & 16384) != 0 ? graphicsLayerElement.ambientShadowColor : j2;
        long j6 = (i3 & 32768) != 0 ? graphicsLayerElement.spotShadowColor : j3;
        int i5 = (i3 & 65536) != 0 ? graphicsLayerElement.compositingStrategy : i;
        int i6 = (i3 & 131072) != 0 ? graphicsLayerElement.blendMode : i2;
        if ((i3 & 262144) != 0) {
            i4 = i5;
            colorFilter2 = graphicsLayerElement.colorFilter;
        } else {
            colorFilter2 = colorFilter;
            i4 = i5;
        }
        return graphicsLayerElement.m6124copycp5nf6A(f22, f13, f14, f15, f16, f17, f18, f19, f20, f21, j4, shape2, z2, renderEffect2, j5, j6, i4, i6, colorFilter2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getScaleX() {
        return this.scaleX;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    /* JADX INFO: renamed from: component11-SzJe1aQ, reason: not valid java name and from getter */
    public final long getTransformOrigin() {
        return this.transformOrigin;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getClip() {
        return this.clip;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    /* JADX INFO: renamed from: component15-0d7_KjU, reason: not valid java name and from getter */
    public final long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    /* JADX INFO: renamed from: component16-0d7_KjU, reason: not valid java name and from getter */
    public final long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    /* JADX INFO: renamed from: component17--NrFUSI, reason: not valid java name and from getter */
    public final int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    /* JADX INFO: renamed from: component18-0nO6VwU, reason: not valid java name and from getter */
    public final int getBlendMode() {
        return this.blendMode;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getScaleY() {
        return this.scaleY;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getTranslationX() {
        return this.translationX;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getTranslationY() {
        return this.translationY;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getRotationX() {
        return this.rotationX;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getRotationY() {
        return this.rotationY;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getRotationZ() {
        return this.rotationZ;
    }

    /* JADX INFO: renamed from: copy-cp5nf6A, reason: not valid java name */
    public final GraphicsLayerElement m6124copycp5nf6A(float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, Shape shape, boolean clip, RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor, int compositingStrategy, int blendMode, ColorFilter colorFilter) {
        return new GraphicsLayerElement(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, renderEffect, ambientShadowColor, spotShadowColor, compositingStrategy, blendMode, colorFilter, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) other;
        return Float.compare(this.scaleX, graphicsLayerElement.scaleX) == 0 && Float.compare(this.scaleY, graphicsLayerElement.scaleY) == 0 && Float.compare(this.alpha, graphicsLayerElement.alpha) == 0 && Float.compare(this.translationX, graphicsLayerElement.translationX) == 0 && Float.compare(this.translationY, graphicsLayerElement.translationY) == 0 && Float.compare(this.shadowElevation, graphicsLayerElement.shadowElevation) == 0 && Float.compare(this.rotationX, graphicsLayerElement.rotationX) == 0 && Float.compare(this.rotationY, graphicsLayerElement.rotationY) == 0 && Float.compare(this.rotationZ, graphicsLayerElement.rotationZ) == 0 && Float.compare(this.cameraDistance, graphicsLayerElement.cameraDistance) == 0 && TransformOrigin.m6377equalsimpl0(this.transformOrigin, graphicsLayerElement.transformOrigin) && Intrinsics.areEqual(this.shape, graphicsLayerElement.shape) && this.clip == graphicsLayerElement.clip && Intrinsics.areEqual(this.renderEffect, graphicsLayerElement.renderEffect) && Color.m5969equalsimpl0(this.ambientShadowColor, graphicsLayerElement.ambientShadowColor) && Color.m5969equalsimpl0(this.spotShadowColor, graphicsLayerElement.spotShadowColor) && CompositingStrategy.m6055equalsimpl0(this.compositingStrategy, graphicsLayerElement.compositingStrategy) && BlendMode.m5877equalsimpl0(this.blendMode, graphicsLayerElement.blendMode) && Intrinsics.areEqual(this.colorFilter, graphicsLayerElement.colorFilter);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((Float.hashCode(this.scaleX) * 31) + Float.hashCode(this.scaleY)) * 31) + Float.hashCode(this.alpha)) * 31) + Float.hashCode(this.translationX)) * 31) + Float.hashCode(this.translationY)) * 31) + Float.hashCode(this.shadowElevation)) * 31) + Float.hashCode(this.rotationX)) * 31) + Float.hashCode(this.rotationY)) * 31) + Float.hashCode(this.rotationZ)) * 31) + Float.hashCode(this.cameraDistance)) * 31) + TransformOrigin.m6380hashCodeimpl(this.transformOrigin)) * 31) + this.shape.hashCode()) * 31) + Boolean.hashCode(this.clip)) * 31;
        RenderEffect renderEffect = this.renderEffect;
        int iHashCode2 = (((((((((iHashCode + (renderEffect == null ? 0 : renderEffect.hashCode())) * 31) + Color.m5975hashCodeimpl(this.ambientShadowColor)) * 31) + Color.m5975hashCodeimpl(this.spotShadowColor)) * 31) + CompositingStrategy.m6056hashCodeimpl(this.compositingStrategy)) * 31) + BlendMode.m5878hashCodeimpl(this.blendMode)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return iHashCode2 + (colorFilter != null ? colorFilter.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GraphicsLayerElement(scaleX=");
        sb.append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", alpha=").append(this.alpha).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", shadowElevation=").append(this.shadowElevation).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", rotationZ=").append(this.rotationZ).append(", cameraDistance=").append(this.cameraDistance).append(", transformOrigin=").append((Object) TransformOrigin.m6381toStringimpl(this.transformOrigin)).append(", shape=");
        sb.append(this.shape).append(", clip=").append(this.clip).append(", renderEffect=").append(this.renderEffect).append(", ambientShadowColor=").append((Object) Color.m5976toStringimpl(this.ambientShadowColor)).append(", spotShadowColor=").append((Object) Color.m5976toStringimpl(this.spotShadowColor)).append(", compositingStrategy=").append((Object) CompositingStrategy.m6057toStringimpl(this.compositingStrategy)).append(", blendMode=").append((Object) BlendMode.m5879toStringimpl(this.blendMode)).append(", colorFilter=").append(this.colorFilter).append(')');
        return sb.toString();
    }

    private GraphicsLayerElement(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, int i2, ColorFilter colorFilter) {
        this.scaleX = f2;
        this.scaleY = f3;
        this.alpha = f4;
        this.translationX = f5;
        this.translationY = f6;
        this.shadowElevation = f7;
        this.rotationX = f8;
        this.rotationY = f9;
        this.rotationZ = f10;
        this.cameraDistance = f11;
        this.transformOrigin = j;
        this.shape = shape;
        this.clip = z;
        this.renderEffect = renderEffect;
        this.ambientShadowColor = j2;
        this.spotShadowColor = j3;
        this.compositingStrategy = i;
        this.blendMode = i2;
        this.colorFilter = colorFilter;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    public final long m6129getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public final long m6125getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public final long m6128getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    public final int m6127getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m6126getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public SimpleGraphicsLayerModifier getNode() {
        return new SimpleGraphicsLayerModifier(this.scaleX, this.scaleY, this.alpha, this.translationX, this.translationY, this.shadowElevation, this.rotationX, this.rotationY, this.rotationZ, this.cameraDistance, this.transformOrigin, this.shape, this.clip, this.renderEffect, this.ambientShadowColor, this.spotShadowColor, this.compositingStrategy, this.blendMode, this.colorFilter, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SimpleGraphicsLayerModifier node) {
        node.setScaleX(this.scaleX);
        node.setScaleY(this.scaleY);
        node.setAlpha(this.alpha);
        node.setTranslationX(this.translationX);
        node.setTranslationY(this.translationY);
        node.setShadowElevation(this.shadowElevation);
        node.setRotationX(this.rotationX);
        node.setRotationY(this.rotationY);
        node.setRotationZ(this.rotationZ);
        node.setCameraDistance(this.cameraDistance);
        node.m6325setTransformOrigin__ExYCQ(this.transformOrigin);
        node.setShape(this.shape);
        node.setClip(this.clip);
        node.setRenderEffect(this.renderEffect);
        node.m6321setAmbientShadowColor8_81llA(this.ambientShadowColor);
        node.m6324setSpotShadowColor8_81llA(this.spotShadowColor);
        node.m6323setCompositingStrategyaDBOjCE(this.compositingStrategy);
        node.m6322setBlendModes9anfk8(this.blendMode);
        node.setColorFilter(this.colorFilter);
        node.invalidateLayerBlock();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("graphicsLayer");
        inspectorInfo.getProperties().set("scaleX", Float.valueOf(this.scaleX));
        inspectorInfo.getProperties().set("scaleY", Float.valueOf(this.scaleY));
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("translationX", Float.valueOf(this.translationX));
        inspectorInfo.getProperties().set("translationY", Float.valueOf(this.translationY));
        inspectorInfo.getProperties().set("shadowElevation", Float.valueOf(this.shadowElevation));
        inspectorInfo.getProperties().set("rotationX", Float.valueOf(this.rotationX));
        inspectorInfo.getProperties().set("rotationY", Float.valueOf(this.rotationY));
        inspectorInfo.getProperties().set("rotationZ", Float.valueOf(this.rotationZ));
        inspectorInfo.getProperties().set("cameraDistance", Float.valueOf(this.cameraDistance));
        inspectorInfo.getProperties().set("transformOrigin", TransformOrigin.m6370boximpl(this.transformOrigin));
        inspectorInfo.getProperties().set("shape", this.shape);
        inspectorInfo.getProperties().set("clip", Boolean.valueOf(this.clip));
        inspectorInfo.getProperties().set("renderEffect", this.renderEffect);
        inspectorInfo.getProperties().set("ambientShadowColor", Color.m5958boximpl(this.ambientShadowColor));
        inspectorInfo.getProperties().set("spotShadowColor", Color.m5958boximpl(this.spotShadowColor));
        inspectorInfo.getProperties().set("compositingStrategy", CompositingStrategy.m6052boximpl(this.compositingStrategy));
        inspectorInfo.getProperties().set("blendMode", BlendMode.m5874boximpl(this.blendMode));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
    }
}
