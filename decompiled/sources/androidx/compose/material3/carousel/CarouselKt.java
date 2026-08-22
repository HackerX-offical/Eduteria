package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.clevertap.android.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Carousel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0084\u0001\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b \u0010!\u001az\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u009a\u0001\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b&\u0010'\u001aÂ\u0001\u0010(\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*26\u0010+\u001a2\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110,¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020.0\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f21\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b0\u00101\u001a\u0019\u00102\u001a\u00020,*\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u00103\u001a\u0019\u00104\u001a\u00020,*\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0003¢\u0006\u0002\u00103\u001a:\u00105\u001a\u00020\u0007*\u00020\u00072\u0006\u00106\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\f\u00107\u001a\b\u0012\u0004\u0012\u000209082\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0000\u001a7\u0010>\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020\u0005H\u0002¢\u0006\u0004\bD\u0010E\u001a\u0018\u0010F\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u000209H\u0000\u001a\u0018\u0010G\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u000209H\u0001\u001a \u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020,H\u0002¨\u0006M"}, d2 = {"HorizontalMultiBrowseCarousel", "", "state", "Landroidx/compose/material3/carousel/CarouselState;", "preferredItemWidth", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "itemSpacing", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "minSmallItemWidth", "maxSmallItemWidth", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function2;", "Landroidx/compose/material3/carousel/CarouselItemScope;", "", "Lkotlin/ParameterName;", "name", "itemIndex", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalMultiBrowseCarousel-3tcCNu0", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalMultiBrowseCarousel-zCIJ0Nk", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;FFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "itemWidth", "HorizontalUncontainedCarousel-VUP9l70", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel-9QcgTRs", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalCenteredHeroCarousel", "maxItemWidth", "HorizontalCenteredHeroCarousel-p2lB3Bg", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/ui/Modifier;FFLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "Carousel", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "keylineList", "", "availableSpace", "Landroidx/compose/material3/carousel/KeylineList;", "maxNonFocalVisibleItemCount", "Carousel-cJHQLPU", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ILandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateBeforeContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateAfterContentPadding", "carouselItem", FirebaseAnalytics.Param.INDEX, "strategy", "Lkotlin/Function0;", "Landroidx/compose/material3/carousel/Strategy;", "carouselItemDrawInfo", "Landroidx/compose/material3/carousel/CarouselItemDrawInfoImpl;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "drawDebugLines", "pageSize", "Landroidx/compose/material3/carousel/CarouselPageSize;", "strokeColor", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "drawDebugLines-1Yev-eo", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/material3/carousel/CarouselPageSize;JF)Landroidx/compose/ui/Modifier;", "calculateCurrentScrollOffset", "calculateMaxScrollOffset", "getProgress", "before", "Landroidx/compose/material3/carousel/Keyline;", "after", "unadjustedOffset", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CarouselKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Carousel_cJHQLPU$lambda$19(CarouselState carouselState, Orientation orientation, Function2 function2, PaddingValues paddingValues, int i, Modifier modifier, float f2, TargetedFlingBehavior targetedFlingBehavior, boolean z, Function4 function4, int i2, int i3, Composer composer, int i4) {
        m4007CarouselcJHQLPU(carouselState, orientation, function2, paddingValues, i, modifier, f2, targetedFlingBehavior, z, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$13(CarouselState carouselState, Modifier modifier, float f2, float f3, TargetedFlingBehavior targetedFlingBehavior, boolean z, float f4, float f5, PaddingValues paddingValues, Function4 function4, int i, int i2, Composer composer, int i3) {
        m4008HorizontalCenteredHeroCarouselp2lB3Bg(carouselState, modifier, f2, f3, targetedFlingBehavior, z, f4, f5, paddingValues, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalMultiBrowseCarousel_3tcCNu0$lambda$3(CarouselState carouselState, float f2, Modifier modifier, float f3, TargetedFlingBehavior targetedFlingBehavior, boolean z, float f4, float f5, PaddingValues paddingValues, Function4 function4, int i, int i2, Composer composer, int i3) {
        m4009HorizontalMultiBrowseCarousel3tcCNu0(carouselState, f2, modifier, f3, targetedFlingBehavior, z, f4, f5, paddingValues, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalMultiBrowseCarousel_zCIJ0Nk$lambda$4(CarouselState carouselState, float f2, Modifier modifier, float f3, TargetedFlingBehavior targetedFlingBehavior, float f4, float f5, PaddingValues paddingValues, Function4 function4, int i, int i2, Composer composer, int i3) {
        m4010HorizontalMultiBrowseCarouselzCIJ0Nk(carouselState, f2, modifier, f3, targetedFlingBehavior, f4, f5, paddingValues, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalUncontainedCarousel_9QcgTRs$lambda$9(CarouselState carouselState, float f2, Modifier modifier, float f3, TargetedFlingBehavior targetedFlingBehavior, PaddingValues paddingValues, Function4 function4, int i, int i2, Composer composer, int i3) {
        m4011HorizontalUncontainedCarousel9QcgTRs(carouselState, f2, modifier, f3, targetedFlingBehavior, paddingValues, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalUncontainedCarousel_VUP9l70$lambda$8(CarouselState carouselState, float f2, Modifier modifier, float f3, TargetedFlingBehavior targetedFlingBehavior, boolean z, PaddingValues paddingValues, Function4 function4, int i, int i2, Composer composer, int i3) {
        m4012HorizontalUncontainedCarouselVUP9l70(carouselState, f2, modifier, f3, targetedFlingBehavior, z, paddingValues, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: HorizontalMultiBrowseCarousel-3tcCNu0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m4009HorizontalMultiBrowseCarousel3tcCNu0(final androidx.compose.material3.carousel.CarouselState r24, final float r25, androidx.compose.ui.Modifier r26, float r27, androidx.compose.foundation.gestures.TargetedFlingBehavior r28, boolean r29, float r30, float r31, androidx.compose.foundation.layout.PaddingValues r32, final kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m4009HorizontalMultiBrowseCarousel3tcCNu0(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeylineList HorizontalMultiBrowseCarousel_3tcCNu0$lambda$2$lambda$1(Density density, float f2, CarouselState carouselState, float f3, float f4, float f5, float f6) {
        return KeylinesKt.multiBrowseKeylineList(density, f5, density.mo488toPx0680j_4(f2), f6, carouselState.getPagerState().getPageCountState().getValue().invoke().intValue(), density.mo488toPx0680j_4(f3), density.mo488toPx0680j_4(f4));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Kept for binary compatibility")
    /* JADX INFO: renamed from: HorizontalMultiBrowseCarousel-zCIJ0Nk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m4010HorizontalMultiBrowseCarouselzCIJ0Nk(final androidx.compose.material3.carousel.CarouselState r26, final float r27, androidx.compose.ui.Modifier r28, float r29, androidx.compose.foundation.gestures.TargetedFlingBehavior r30, float r31, float r32, androidx.compose.foundation.layout.PaddingValues r33, final kotlin.jvm.functions.Function4 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 587
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m4010HorizontalMultiBrowseCarouselzCIJ0Nk(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010f  */
    /* JADX INFO: renamed from: HorizontalUncontainedCarousel-VUP9l70, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m4012HorizontalUncontainedCarouselVUP9l70(final androidx.compose.material3.carousel.CarouselState r24, final float r25, androidx.compose.ui.Modifier r26, float r27, androidx.compose.foundation.gestures.TargetedFlingBehavior r28, boolean r29, androidx.compose.foundation.layout.PaddingValues r30, final kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m4012HorizontalUncontainedCarouselVUP9l70(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeylineList HorizontalUncontainedCarousel_VUP9l70$lambda$7$lambda$6(Density density, float f2, float f3, float f4) {
        return KeylinesKt.uncontainedKeylineList(density, f3, density.mo488toPx0680j_4(f2), f4);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ea  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Kept for binary compatibility")
    /* JADX INFO: renamed from: HorizontalUncontainedCarousel-9QcgTRs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m4011HorizontalUncontainedCarousel9QcgTRs(final androidx.compose.material3.carousel.CarouselState r20, final float r21, androidx.compose.ui.Modifier r22, float r23, androidx.compose.foundation.gestures.TargetedFlingBehavior r24, androidx.compose.foundation.layout.PaddingValues r25, final kotlin.jvm.functions.Function4 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m4011HorizontalUncontainedCarousel9QcgTRs(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: HorizontalCenteredHeroCarousel-p2lB3Bg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m4008HorizontalCenteredHeroCarouselp2lB3Bg(final androidx.compose.material3.carousel.CarouselState r25, androidx.compose.ui.Modifier r26, float r27, float r28, androidx.compose.foundation.gestures.TargetedFlingBehavior r29, boolean r30, float r31, float r32, androidx.compose.foundation.layout.PaddingValues r33, final kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 759
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m4008HorizontalCenteredHeroCarouselp2lB3Bg(androidx.compose.material3.carousel.CarouselState, androidx.compose.ui.Modifier, float, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    /* JADX INFO: renamed from: Carousel-cJHQLPU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m4007CarouselcJHQLPU(androidx.compose.material3.carousel.CarouselState r32, final androidx.compose.foundation.gestures.Orientation r33, final kotlin.jvm.functions.Function2<? super java.lang.Float, ? super java.lang.Float, androidx.compose.material3.carousel.KeylineList> r34, final androidx.compose.foundation.layout.PaddingValues r35, final int r36, androidx.compose.ui.Modifier r37, float r38, androidx.compose.foundation.gestures.TargetedFlingBehavior r39, boolean r40, final kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 938
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m4007CarouselcJHQLPU(androidx.compose.material3.carousel.CarouselState, androidx.compose.foundation.gestures.Orientation, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, int, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Carousel_cJHQLPU$lambda$16$lambda$15(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8014getCarouselo7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Carousel_cJHQLPU$lambda$18$lambda$17(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8014getCarouselo7Vup1c());
        return Unit.INSTANCE;
    }

    private static final float calculateBeforeContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float fCalculateStartPadding;
        ComposerKt.sourceInformationMarkerStart(composer, 1896839347, "C(calculateBeforeContentPadding)N(orientation)484@21819L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896839347, i, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:476)");
        }
        if (orientation == Orientation.Vertical) {
            composer.startReplaceGroup(-143556958);
            composer.endReplaceGroup();
            fCalculateStartPadding = paddingValues.getTop();
        } else {
            composer.startReplaceGroup(-143505436);
            ComposerKt.sourceInformation(composer, "481@21770L7");
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume);
            composer.endReplaceGroup();
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fMo488toPx0680j_4 = ((Density) objConsume2).mo488toPx0680j_4(fCalculateStartPadding);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fMo488toPx0680j_4;
    }

    private static final float calculateAfterContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float fCalculateEndPadding;
        ComposerKt.sourceInformationMarkerStart(composer, 1018496720, "C(calculateAfterContentPadding)N(orientation)496@22177L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018496720, i, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:488)");
        }
        if (orientation == Orientation.Vertical) {
            composer.startReplaceGroup(-1907991582);
            composer.endReplaceGroup();
            fCalculateEndPadding = paddingValues.getBottom();
        } else {
            composer.startReplaceGroup(-1907937239);
            ComposerKt.sourceInformation(composer, "493@22128L7");
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume);
            composer.endReplaceGroup();
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fMo488toPx0680j_4 = ((Density) objConsume2).mo488toPx0680j_4(fCalculateEndPadding);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fMo488toPx0680j_4;
    }

    public static final Modifier carouselItem(Modifier modifier, final int i, final CarouselState carouselState, final Function0<Strategy> function0, final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl, final Shape shape) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CarouselKt.carouselItem$lambda$26(function0, carouselState, i, carouselItemDrawInfoImpl, shape, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult carouselItem$lambda$26(Function0 function0, final CarouselState carouselState, final int i, final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl, final Shape shape, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long jM8772copyZbe2FdA;
        final Strategy strategy = (Strategy) function0.invoke();
        if (!strategy.getIsValid()) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CarouselKt.carouselItem$lambda$26$lambda$22((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        final boolean z = carouselState.getPagerState().getLayoutInfo().getOrientation() == Orientation.Vertical;
        final boolean z2 = measureScope.getLayoutDirection() == LayoutDirection.Rtl;
        float itemMainAxisSize = strategy.getItemMainAxisSize();
        if (z) {
            jM8772copyZbe2FdA = Constraints.m8772copyZbe2FdA(constraints.getValue(), Constraints.m8785getMinWidthimpl(constraints.getValue()), Constraints.m8783getMaxWidthimpl(constraints.getValue()), MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize));
        } else {
            jM8772copyZbe2FdA = Constraints.m8772copyZbe2FdA(constraints.getValue(), MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize), Constraints.m8784getMinHeightimpl(constraints.getValue()), Constraints.m8782getMaxHeightimpl(constraints.getValue()));
        }
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(jM8772copyZbe2FdA);
        final float f2 = i != carouselState.getPagerState().getCurrentPage() ? i == 0 ? 0.0f : 1.0f / i : 1.0f;
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CarouselKt.carouselItem$lambda$26$lambda$25(placeableMo7445measureBRTryo0, f2, carouselState, strategy, i, z, carouselItemDrawInfoImpl, shape, z2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit carouselItem$lambda$26$lambda$22(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit carouselItem$lambda$26$lambda$25(Placeable placeable, float f2, final CarouselState carouselState, final Strategy strategy, final int i, final boolean z, final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl, final Shape shape, final boolean z2, Placeable.PlacementScope placementScope) {
        placementScope.placeWithLayer(placeable, 0, 0, f2, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CarouselKt.carouselItem$lambda$26$lambda$25$lambda$24(carouselState, strategy, i, z, carouselItemDrawInfoImpl, shape, z2, (GraphicsLayerScope) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit carouselItem$lambda$26$lambda$25$lambda$24(CarouselState carouselState, Strategy strategy, int i, boolean z, CarouselItemDrawInfoImpl carouselItemDrawInfoImpl, Shape shape, boolean z2, GraphicsLayerScope graphicsLayerScope) {
        float fCalculateCurrentScrollOffset = calculateCurrentScrollOffset(carouselState, strategy);
        float fCalculateMaxScrollOffset = calculateMaxScrollOffset(carouselState, strategy);
        KeylineList keylineListForScrollOffset$material3$default = Strategy.getKeylineListForScrollOffset$material3$default(strategy, fCalculateCurrentScrollOffset, fCalculateMaxScrollOffset, false, 4, null);
        KeylineList keylineListForScrollOffset$material3 = strategy.getKeylineListForScrollOffset$material3(fCalculateCurrentScrollOffset, fCalculateMaxScrollOffset, true);
        float itemMainAxisSize = ((i * (strategy.getItemMainAxisSize() + strategy.getItemSpacing())) + (strategy.getItemMainAxisSize() / 2.0f)) - fCalculateCurrentScrollOffset;
        Keyline keylineBefore = keylineListForScrollOffset$material3$default.getKeylineBefore(itemMainAxisSize);
        Keyline keylineAfter = keylineListForScrollOffset$material3$default.getKeylineAfter(itemMainAxisSize);
        Keyline keylineLerp = KeylineListKt.lerp(keylineBefore, keylineAfter, getProgress(keylineBefore, keylineAfter, itemMainAxisSize));
        boolean zAreEqual = Intrinsics.areEqual(keylineBefore, keylineAfter);
        float fIntBitsToFloat = (z ? Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)) : strategy.getItemMainAxisSize()) / 2.0f;
        float itemMainAxisSize2 = (z ? strategy.getItemMainAxisSize() : Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L))) / 2.0f;
        float fIntBitsToFloat2 = (z ? Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32)) : keylineLerp.getSize()) / 2.0f;
        float size = (z ? keylineLerp.getSize() : Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L))) / 2.0f;
        Rect rect = new Rect(fIntBitsToFloat - fIntBitsToFloat2, itemMainAxisSize2 - size, fIntBitsToFloat + fIntBitsToFloat2, itemMainAxisSize2 + size);
        carouselItemDrawInfoImpl.setSizeState(keylineLerp.getSize());
        Iterator<Keyline> it = keylineListForScrollOffset$material3.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Keyline next = it.next();
        if (it.hasNext()) {
            float size2 = next.getSize();
            do {
                Keyline next2 = it.next();
                float size3 = next2.getSize();
                if (Float.compare(size2, size3) > 0) {
                    next = next2;
                    size2 = size3;
                }
            } while (it.hasNext());
        }
        carouselItemDrawInfoImpl.setMinSizeState(next.getSize());
        carouselItemDrawInfoImpl.setMaxSizeState(keylineListForScrollOffset$material3.getFirstFocal().getSize());
        carouselItemDrawInfoImpl.setMaskRectState(rect);
        graphicsLayerScope.setClip(!Intrinsics.areEqual(rect, new Rect(0.0f, 0.0f, Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32)), Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)))));
        graphicsLayerScope.setShape(shape);
        float offset = keylineLerp.getOffset() - itemMainAxisSize;
        if (zAreEqual) {
            offset += (itemMainAxisSize - keylineLerp.getUnadjustedOffset()) / keylineLerp.getSize();
        }
        if (z) {
            graphicsLayerScope.setTranslationY(offset);
        } else {
            if (z2) {
                offset = -offset;
            }
            graphicsLayerScope.setTranslationX(offset);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawDebugLines-1Yev-eo$default, reason: not valid java name */
    static /* synthetic */ Modifier m4014drawDebugLines1Yeveo$default(Modifier modifier, CarouselState carouselState, CarouselPageSize carouselPageSize, long j, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Color.INSTANCE.m6001getMagenta0d7_KjU();
        }
        long j2 = j;
        if ((i & 8) != 0) {
            f2 = Dp.m8830constructorimpl(4);
        }
        return m4013drawDebugLines1Yeveo(modifier, carouselState, carouselPageSize, j2, f2);
    }

    /* JADX INFO: renamed from: drawDebugLines-1Yev-eo, reason: not valid java name */
    private static final Modifier m4013drawDebugLines1Yeveo(Modifier modifier, final CarouselState carouselState, final CarouselPageSize carouselPageSize, final long j, final float f2) {
        return DrawModifierKt.drawWithContent(modifier, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CarouselKt.drawDebugLines_1Yev_eo$lambda$28(carouselPageSize, carouselState, f2, j, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawDebugLines_1Yev_eo$lambda$28(CarouselPageSize carouselPageSize, CarouselState carouselState, float f2, long j, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Strategy strategy = carouselPageSize.getStrategy();
        KeylineList keylineListForScrollOffset$material3$default = Strategy.getKeylineListForScrollOffset$material3$default(strategy, calculateCurrentScrollOffset(carouselState, strategy), calculateMaxScrollOffset(carouselState, strategy), false, 4, null);
        float f3 = contentDrawScope.mo488toPx0680j_4(f2);
        for (Keyline keyline : keylineListForScrollOffset$material3$default) {
            DrawScope.m6535drawLineNGM6Ib0$default(contentDrawScope, j, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(keyline.getOffset())) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(keyline.getOffset())) << 32) | (((long) Float.floatToRawIntBits(100.0f)) & 4294967295L)), f3, 0, null, 0.0f, null, 0, 496, null);
        }
        return Unit.INSTANCE;
    }

    public static final float calculateCurrentScrollOffset(CarouselState carouselState, Strategy strategy) {
        float itemMainAxisSize = strategy.getItemMainAxisSize() + strategy.getItemSpacing();
        return ((carouselState.getPagerState().getCurrentPage() * itemMainAxisSize) + (carouselState.getPagerState().getCurrentPageOffsetFraction() * itemMainAxisSize)) - KeylineSnapPositionKt.getSnapPositionOffset(strategy, carouselState.getPagerState().getCurrentPage(), carouselState.getPagerState().getPageCount());
    }

    public static final float calculateMaxScrollOffset(CarouselState carouselState, Strategy strategy) {
        float pageCount = carouselState.getPagerState().getPageCount();
        return RangesKt.coerceAtLeast(((strategy.getItemMainAxisSize() * pageCount) + (strategy.getItemSpacing() * (pageCount - 1))) - strategy.getAvailableSpace(), 0.0f);
    }

    private static final float getProgress(Keyline keyline, Keyline keyline2, float f2) {
        if (Intrinsics.areEqual(keyline, keyline2)) {
            return 1.0f;
        }
        return (f2 - keyline.getUnadjustedOffset()) / (keyline2.getUnadjustedOffset() - keyline.getUnadjustedOffset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeylineList HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$12$lambda$11(Density density, float f2, CarouselState carouselState, float f3, float f4, float f5, float f6) {
        return KeylinesKt.heroKeylineList(density, f5, !Float.isNaN(f2) ? Float.valueOf(density.mo488toPx0680j_4(f2)) : null, f6, carouselState.getPagerState().getPageCountState().getValue().invoke().intValue(), true, density.mo488toPx0680j_4(f3), density.mo488toPx0680j_4(f4));
    }
}
