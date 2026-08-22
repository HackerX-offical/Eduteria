package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextualFlowLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0017\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014\u0012;\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0\u0019J\u001b\u0010.\u001a\u00020-*\u00020+2\u0006\u0010/\u001a\u00020,H\u0002¢\u0006\u0004\b0\u00101J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\u0010\u00105\u001a\u00020\tHÂ\u0003¢\u0006\u0004\b6\u00107J\t\u00108\u001a\u00020\u000bHÆ\u0003J\u0010\u00109\u001a\u00020\tHÂ\u0003¢\u0006\u0004\b:\u00107J\t\u0010;\u001a\u00020\u000eHÂ\u0003J\t\u0010<\u001a\u00020\u000eHÂ\u0003J\t\u0010=\u001a\u00020\u000eHÂ\u0003J\t\u0010>\u001a\u00020\u0012HÂ\u0003J\u001a\u0010?\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014HÂ\u0003JC\u0010@\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017HÂ\u0003¢\u0006\u0002\u0010AJÎ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u00142=\b\u0002\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017HÆ\u0001¢\u0006\u0004\bC\u0010DJ\u0014\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0083\u0004J\n\u0010H\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010I\u001a\u00020JHÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010!R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000RE\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006K"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "itemCount", "", "maxLines", "maxItemsInMainAxis", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "<init>", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Lkotlin/jvm/functions/Function4;", "getMeasurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "measure", "constraints", "measure-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "component10", "component11", "component12", "()Lkotlin/jvm/functions/Function4;", Constants.COPY_TYPE, "copy-E4Q9ldg", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;)Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final /* data */ class FlowMeasureLazyPolicy implements FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Function4<Integer, FlowLineInfo, Composer, Integer, Unit> getComposable;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final int itemCount;
    private final float mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;
    private final List<Function2<Composer, Integer, Unit>> overflowComposables;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasureLazyPolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f2, CrossAxisAlignment crossAxisAlignment, float f3, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState, List list, Function4 function4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, horizontal, vertical, f2, crossAxisAlignment, f3, i, i2, i3, flowLayoutOverflowState, list, function4);
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    private final FlowLayoutOverflowState getOverflow() {
        return this.overflow;
    }

    private final List<Function2<Composer, Integer, Unit>> component11() {
        return this.overflowComposables;
    }

    private final Function4<Integer, FlowLineInfo, Composer, Integer, Unit> component12() {
        return this.getComposable;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    private final float getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name and from getter */
    private final float getCrossAxisArrangementSpacing() {
        return this.crossAxisArrangementSpacing;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final int getItemCount() {
        return this.itemCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final int getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final int getMaxItemsInMainAxis() {
        return this.maxItemsInMainAxis;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-E4Q9ldg$default, reason: not valid java name */
    public static /* synthetic */ FlowMeasureLazyPolicy m1009copyE4Q9ldg$default(FlowMeasureLazyPolicy flowMeasureLazyPolicy, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f2, CrossAxisAlignment crossAxisAlignment, float f3, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState, List list, Function4 function4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = flowMeasureLazyPolicy.isHorizontal;
        }
        if ((i4 & 2) != 0) {
            horizontal = flowMeasureLazyPolicy.horizontalArrangement;
        }
        if ((i4 & 4) != 0) {
            vertical = flowMeasureLazyPolicy.verticalArrangement;
        }
        if ((i4 & 8) != 0) {
            f2 = flowMeasureLazyPolicy.mainAxisSpacing;
        }
        if ((i4 & 16) != 0) {
            crossAxisAlignment = flowMeasureLazyPolicy.crossAxisAlignment;
        }
        if ((i4 & 32) != 0) {
            f3 = flowMeasureLazyPolicy.crossAxisArrangementSpacing;
        }
        if ((i4 & 64) != 0) {
            i = flowMeasureLazyPolicy.itemCount;
        }
        if ((i4 & 128) != 0) {
            i2 = flowMeasureLazyPolicy.maxLines;
        }
        if ((i4 & 256) != 0) {
            i3 = flowMeasureLazyPolicy.maxItemsInMainAxis;
        }
        if ((i4 & 512) != 0) {
            flowLayoutOverflowState = flowMeasureLazyPolicy.overflow;
        }
        if ((i4 & 1024) != 0) {
            list = flowMeasureLazyPolicy.overflowComposables;
        }
        if ((i4 & 2048) != 0) {
            function4 = flowMeasureLazyPolicy.getComposable;
        }
        List list2 = list;
        Function4 function42 = function4;
        int i5 = i3;
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        int i6 = i;
        int i7 = i2;
        CrossAxisAlignment crossAxisAlignment2 = crossAxisAlignment;
        float f4 = f3;
        return flowMeasureLazyPolicy.m1011copyE4Q9ldg(z, horizontal, vertical, f2, crossAxisAlignment2, f4, i6, i7, i5, flowLayoutOverflowState2, list2, function42);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsHorizontal() {
        return this.isHorizontal;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    /* JADX INFO: renamed from: copy-E4Q9ldg, reason: not valid java name */
    public final FlowMeasureLazyPolicy m1011copyE4Q9ldg(boolean isHorizontal, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, float mainAxisSpacing, CrossAxisAlignment crossAxisAlignment, float crossAxisArrangementSpacing, int itemCount, int maxLines, int maxItemsInMainAxis, FlowLayoutOverflowState overflow, List<? extends Function2<? super Composer, ? super Integer, Unit>> overflowComposables, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> getComposable) {
        return new FlowMeasureLazyPolicy(isHorizontal, horizontalArrangement, verticalArrangement, mainAxisSpacing, crossAxisAlignment, crossAxisArrangementSpacing, itemCount, maxLines, maxItemsInMainAxis, overflow, overflowComposables, getComposable, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowMeasureLazyPolicy)) {
            return false;
        }
        FlowMeasureLazyPolicy flowMeasureLazyPolicy = (FlowMeasureLazyPolicy) other;
        return this.isHorizontal == flowMeasureLazyPolicy.isHorizontal && Intrinsics.areEqual(this.horizontalArrangement, flowMeasureLazyPolicy.horizontalArrangement) && Intrinsics.areEqual(this.verticalArrangement, flowMeasureLazyPolicy.verticalArrangement) && Dp.m8835equalsimpl0(this.mainAxisSpacing, flowMeasureLazyPolicy.mainAxisSpacing) && Intrinsics.areEqual(this.crossAxisAlignment, flowMeasureLazyPolicy.crossAxisAlignment) && Dp.m8835equalsimpl0(this.crossAxisArrangementSpacing, flowMeasureLazyPolicy.crossAxisArrangementSpacing) && this.itemCount == flowMeasureLazyPolicy.itemCount && this.maxLines == flowMeasureLazyPolicy.maxLines && this.maxItemsInMainAxis == flowMeasureLazyPolicy.maxItemsInMainAxis && Intrinsics.areEqual(this.overflow, flowMeasureLazyPolicy.overflow) && Intrinsics.areEqual(this.overflowComposables, flowMeasureLazyPolicy.overflowComposables) && Intrinsics.areEqual(this.getComposable, flowMeasureLazyPolicy.getComposable);
    }

    public int hashCode() {
        return (((((((((((((((((((((Boolean.hashCode(this.isHorizontal) * 31) + this.horizontalArrangement.hashCode()) * 31) + this.verticalArrangement.hashCode()) * 31) + Dp.m8836hashCodeimpl(this.mainAxisSpacing)) * 31) + this.crossAxisAlignment.hashCode()) * 31) + Dp.m8836hashCodeimpl(this.crossAxisArrangementSpacing)) * 31) + Integer.hashCode(this.itemCount)) * 31) + Integer.hashCode(this.maxLines)) * 31) + Integer.hashCode(this.maxItemsInMainAxis)) * 31) + this.overflow.hashCode()) * 31) + this.overflowComposables.hashCode()) * 31) + this.getComposable.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FlowMeasureLazyPolicy(isHorizontal=");
        sb.append(this.isHorizontal).append(", horizontalArrangement=").append(this.horizontalArrangement).append(", verticalArrangement=").append(this.verticalArrangement).append(", mainAxisSpacing=").append((Object) Dp.m8841toStringimpl(this.mainAxisSpacing)).append(", crossAxisAlignment=").append(this.crossAxisAlignment).append(", crossAxisArrangementSpacing=").append((Object) Dp.m8841toStringimpl(this.crossAxisArrangementSpacing)).append(", itemCount=").append(this.itemCount).append(", maxLines=").append(this.maxLines).append(", maxItemsInMainAxis=").append(this.maxItemsInMainAxis).append(", overflow=").append(this.overflow).append(", overflowComposables=").append(this.overflowComposables).append(", getComposable=");
        sb.append(this.getComposable).append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FlowMeasureLazyPolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f2, CrossAxisAlignment crossAxisAlignment, float f3, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4) {
        this.isHorizontal = z;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisSpacing = f2;
        this.crossAxisAlignment = crossAxisAlignment;
        this.crossAxisArrangementSpacing = f3;
        this.itemCount = i;
        this.maxLines = i2;
        this.maxItemsInMainAxis = i3;
        this.overflow = flowLayoutOverflowState;
        this.overflowComposables = list;
        this.getComposable = function4;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult getMeasurePolicy$lambda$0(FlowMeasureLazyPolicy flowMeasureLazyPolicy, SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        return flowMeasureLazyPolicy.m1010measure0kLqBqw(subcomposeMeasureScope, constraints.getValue());
    }

    public final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> getMeasurePolicy() {
        return new Function2() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FlowMeasureLazyPolicy.getMeasurePolicy$lambda$0(this.f$0, (SubcomposeMeasureScope) obj, (Constraints) obj2);
            }
        };
    }

    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
    private final MeasureResult m1010measure0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        LayoutOrientation layoutOrientation;
        if (this.itemCount <= 0 || this.maxLines == 0 || this.maxItemsInMainAxis == 0 || (Constraints.m8782getMaxHeightimpl(j) == 0 && this.overflow.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.Visible)) {
            return MeasureScope.layout$default(subcomposeMeasureScope, 0, 0, null, new Function1() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FlowMeasureLazyPolicy.measure_0kLqBqw$lambda$0((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        ContextualFlowItemIterator contextualFlowItemIterator = new ContextualFlowItemIterator(this.itemCount, new Function2() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FlowMeasureLazyPolicy.measure_0kLqBqw$lambda$1(subcomposeMeasureScope, this, ((Integer) obj).intValue(), (FlowLineInfo) obj2);
            }
        });
        this.overflow.setItemCount$foundation_layout(this.itemCount);
        FlowMeasureLazyPolicy flowMeasureLazyPolicy = this;
        this.overflow.m1000setOverflowMeasurablesVKLhPVY$foundation_layout(flowMeasureLazyPolicy, j, new Function2() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FlowMeasureLazyPolicy.measure_0kLqBqw$lambda$2(this.f$0, subcomposeMeasureScope, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
            }
        });
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        ContextualFlowItemIterator contextualFlowItemIterator2 = contextualFlowItemIterator;
        float f2 = this.mainAxisSpacing;
        float f3 = this.crossAxisArrangementSpacing;
        if (isHorizontal()) {
            layoutOrientation = LayoutOrientation.Horizontal;
        } else {
            layoutOrientation = LayoutOrientation.Vertical;
        }
        return FlowLayoutKt.m992breakDownItemsdi9J0FM(subcomposeMeasureScope2, flowMeasureLazyPolicy, contextualFlowItemIterator2, f2, f3, OrientationIndependentConstraints.m1119constructorimpl(j, layoutOrientation), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_0kLqBqw$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List measure_0kLqBqw$lambda$1(SubcomposeMeasureScope subcomposeMeasureScope, final FlowMeasureLazyPolicy flowMeasureLazyPolicy, final int i, final FlowLineInfo flowLineInfo) {
        return subcomposeMeasureScope.subcompose(Integer.valueOf(i), ComposableLambdaKt.composableLambdaInstance(-195060736, true, new Function2() { // from class: androidx.compose.foundation.layout.FlowMeasureLazyPolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FlowMeasureLazyPolicy.measure_0kLqBqw$lambda$1$0(this.f$0, i, flowLineInfo, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_0kLqBqw$lambda$1$0(FlowMeasureLazyPolicy flowMeasureLazyPolicy, int i, FlowLineInfo flowLineInfo, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C486@20655L26:ContextualFlowLayout.kt#2w3rfo");
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-195060736, i2, -1, "androidx.compose.foundation.layout.FlowMeasureLazyPolicy.measure.<anonymous>.<anonymous> (ContextualFlowLayout.kt:486)");
            }
            flowMeasureLazyPolicy.getComposable.invoke(Integer.valueOf(i), flowLineInfo, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Measurable measure_0kLqBqw$lambda$2(FlowMeasureLazyPolicy flowMeasureLazyPolicy, SubcomposeMeasureScope subcomposeMeasureScope, boolean z, int i) {
        Function2<? super Composer, ? super Integer, Unit> function2 = (Function2) CollectionsKt.getOrNull(flowMeasureLazyPolicy.overflowComposables, !z ? 1 : 0);
        if (function2 != null) {
            return (Measurable) CollectionsKt.getOrNull(subcomposeMeasureScope.subcompose(new StringBuilder().append(z).append(flowMeasureLazyPolicy.itemCount).append(i).toString(), function2), 0);
        }
        return null;
    }
}
