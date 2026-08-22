package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.PlacementScopeMarker;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;

/* JADX INFO: compiled from: GraphicsLayerScope.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0018\u0010 \u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u0018\u0010#\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020-X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u0018\u00100\u001a\u000201X¦\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u000207X¦\u000e¢\u0006\u0012\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010@\u001a\u0004\u0018\u00010?2\b\u0010>\u001a\u0004\u0018\u00010?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u00020E2\u0006\u0010>\u001a\u00020E8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010L\u001a\u0004\u0018\u00010K2\b\u0010>\u001a\u0004\u0018\u00010K8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u00020R2\u0006\u0010Q\u001a\u00020R8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bS\u0010H\"\u0004\bT\u0010JR\u0014\u0010U\u001a\u00020V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006XÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "scaleX", "", "getScaleX", "()F", "setScaleX", "(F)V", "scaleY", "getScaleY", "setScaleY", "alpha", "getAlpha", "setAlpha", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "_", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@PlacementScopeMarker
public interface GraphicsLayerScope extends Density {
    float getAlpha();

    float getCameraDistance();

    boolean getClip();

    default ColorFilter getColorFilter() {
        return null;
    }

    default RenderEffect getRenderEffect() {
        return null;
    }

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    Shape getShape();

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    long mo6166getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f2);

    /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    default void mo6167setAmbientShadowColor8_81llA(long j) {
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    default void mo6168setBlendModes9anfk8(int i) {
    }

    void setCameraDistance(float f2);

    void setClip(boolean z);

    default void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    default void mo6169setCompositingStrategyaDBOjCE(int i) {
    }

    default void setRenderEffect(RenderEffect renderEffect) {
    }

    void setRotationX(float f2);

    void setRotationY(float f2);

    void setRotationZ(float f2);

    void setScaleX(float f2);

    void setScaleY(float f2);

    void setShadowElevation(float f2);

    void setShape(Shape shape);

    /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    default void mo6170setSpotShadowColor8_81llA(long j) {
    }

    /* JADX INFO: renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    void mo6171setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f2);

    void setTranslationY(float f2);

    /* JADX INFO: compiled from: GraphicsLayerScope.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getClip$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6177roundToPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo481roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6178roundToPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f2) {
            return GraphicsLayerScope.super.mo482roundToPx0680j_4(f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6183toDpGaN1DYA(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo483toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6184toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, float f2) {
            return GraphicsLayerScope.super.mo484toDpu2uoSUM(f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6185toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, int i) {
            return GraphicsLayerScope.super.mo485toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6186toDpSizekrfVVM(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo486toDpSizekrfVVM(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6187toPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo487toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6188toPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f2) {
            return GraphicsLayerScope.super.mo488toPx0680j_4(f2);
        }

        @Deprecated
        public static Rect toRect(GraphicsLayerScope graphicsLayerScope, DpRect dpRect) {
            return GraphicsLayerScope.super.toRect(dpRect);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6189toSizeXkaWNTQ(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo489toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6190toSp0xMU5do(GraphicsLayerScope graphicsLayerScope, float f2) {
            return GraphicsLayerScope.super.mo490toSp0xMU5do(f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6191toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, float f2) {
            return GraphicsLayerScope.super.mo491toSpkPz2Gy4(f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6192toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, int i) {
            return GraphicsLayerScope.super.mo492toSpkPz2Gy4(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m6172getAmbientShadowColor0d7_KjU(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo6161getAmbientShadowColor0d7_KjU();
        }

        @Deprecated
        /* JADX INFO: renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m6179setAmbientShadowColor8_81llA(GraphicsLayerScope graphicsLayerScope, long j) {
            GraphicsLayerScope.super.mo6167setAmbientShadowColor8_81llA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m6176getSpotShadowColor0d7_KjU(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo6165getSpotShadowColor0d7_KjU();
        }

        @Deprecated
        /* JADX INFO: renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m6182setSpotShadowColor8_81llA(GraphicsLayerScope graphicsLayerScope, long j) {
            GraphicsLayerScope.super.mo6170setSpotShadowColor8_81llA(j);
        }

        @Deprecated
        public static RenderEffect getRenderEffect(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.getRenderEffect();
        }

        @Deprecated
        public static void setRenderEffect(GraphicsLayerScope graphicsLayerScope, RenderEffect renderEffect) {
            GraphicsLayerScope.super.setRenderEffect(renderEffect);
        }

        @Deprecated
        /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
        public static int m6173getBlendMode0nO6VwU(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo6162getBlendMode0nO6VwU();
        }

        @Deprecated
        /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
        public static void m6180setBlendModes9anfk8(GraphicsLayerScope graphicsLayerScope, int i) {
            GraphicsLayerScope.super.mo6168setBlendModes9anfk8(i);
        }

        @Deprecated
        public static ColorFilter getColorFilter(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.getColorFilter();
        }

        @Deprecated
        public static void setColorFilter(GraphicsLayerScope graphicsLayerScope, ColorFilter colorFilter) {
            GraphicsLayerScope.super.setColorFilter(colorFilter);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m6174getCompositingStrategyNrFUSI(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo6163getCompositingStrategyNrFUSI();
        }

        @Deprecated
        /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m6181setCompositingStrategyaDBOjCE(GraphicsLayerScope graphicsLayerScope, int i) {
            GraphicsLayerScope.super.mo6169setCompositingStrategyaDBOjCE(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m6175getSizeNHjbRc(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo6164getSizeNHjbRc();
        }
    }

    /* JADX INFO: renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    default long mo6161getAmbientShadowColor0d7_KjU() {
        return GraphicsLayerScopeKt.getDefaultShadowColor();
    }

    /* JADX INFO: renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    default long mo6165getSpotShadowColor0d7_KjU() {
        return GraphicsLayerScopeKt.getDefaultShadowColor();
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    default int mo6162getBlendMode0nO6VwU() {
        return BlendMode.INSTANCE.m5908getSrcOver0nO6VwU();
    }

    /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    default int mo6163getCompositingStrategyNrFUSI() {
        return CompositingStrategy.INSTANCE.m6059getAutoNrFUSI();
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo6164getSizeNHjbRc() {
        return Size.INSTANCE.m5800getUnspecifiedNHjbRc();
    }
}
