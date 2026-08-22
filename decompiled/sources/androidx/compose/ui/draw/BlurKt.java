package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Blur.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radiusX", "Landroidx/compose/ui/unit/Dp;", "radiusY", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", Constants.KEY_RADIUS, "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BlurKt {
    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m5489blur1fqSgw$default(Modifier modifier, float f2, float f3, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m5492boximpl(BlurredEdgeTreatment.INSTANCE.m5499getRectangleGoahg());
        }
        return m5488blur1fqSgw(modifier, f2, f3, blurredEdgeTreatment.m5498unboximpl());
    }

    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m5488blur1fqSgw(Modifier modifier, final float f2, final float f3, final Shape shape) {
        int iM6366getDecal3opZhB0;
        final boolean z;
        if (shape != null) {
            iM6366getDecal3opZhB0 = TileMode.INSTANCE.m6365getClamp3opZhB0();
            z = true;
        } else {
            iM6366getDecal3opZhB0 = TileMode.INSTANCE.m6366getDecal3opZhB0();
            z = false;
        }
        final int i = iM6366getDecal3opZhB0;
        float f4 = 0;
        return ((Dp.m8829compareTo0680j_4(f2, Dp.m8830constructorimpl(f4)) <= 0 || Dp.m8829compareTo0680j_4(f3, Dp.m8830constructorimpl(f4)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                float f5 = graphicsLayerScope.mo488toPx0680j_4(f2);
                float f6 = graphicsLayerScope.mo488toPx0680j_4(f3);
                graphicsLayerScope.setRenderEffect((f5 <= 0.0f || f6 <= 0.0f) ? null : RenderEffectKt.m6294BlurEffect3YTHUZs(f5, f6, i));
                Shape rectangleShape = shape;
                if (rectangleShape == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayerScope.setShape(rectangleShape);
                graphicsLayerScope.setClip(z);
            }
        });
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m5491blurF8QBwvs$default(Modifier modifier, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m5492boximpl(BlurredEdgeTreatment.INSTANCE.m5499getRectangleGoahg());
        }
        return m5490blurF8QBwvs(modifier, f2, blurredEdgeTreatment.m5498unboximpl());
    }

    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m5490blurF8QBwvs(Modifier modifier, float f2, Shape shape) {
        return m5488blur1fqSgw(modifier, f2, f2, shape);
    }
}
