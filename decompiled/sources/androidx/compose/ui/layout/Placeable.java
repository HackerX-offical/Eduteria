package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: Placeable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0019\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b H$¢\u0006\u0004\b!\u0010\"J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0014¢\u0006\u0004\b!\u0010%R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@DX\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010'\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020&@DX\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R \u0010*\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u001a@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b+\u0010\u0012¨\u0006-"}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "<init>", "()V", "value", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth", "()I", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight", "measuredWidth", "getMeasuredWidth", "measuredHeight", "getMeasuredHeight", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "()J", "setMeasuredSize-ozmzZPI", "(J)V", "J", "onMeasuredSizeChanged", "", "placeAt", Const.POSITION, "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", Const.LAYER, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "PlacementScope", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private long measuredSize;
    private int width;
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private long apparentToRealOffset = IntOffset.INSTANCE.m8969getZeronOccac();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public abstract void mo7446placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock);

    public Placeable() {
        long j = 0;
        this.measuredSize = IntSize.m8996constructorimpl((j & 4294967295L) | (j << 32));
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return (int) (this.measuredSize >> 32);
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return (int) (this.measuredSize & 4294967295L);
    }

    /* JADX INFO: renamed from: getMeasuredSize-YbymL2g, reason: not valid java name and from getter */
    protected final long getMeasuredSize() {
        return this.measuredSize;
    }

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    protected final void m7509setMeasuredSizeozmzZPI(long j) {
        if (IntSize.m8999equalsimpl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        onMeasuredSizeChanged();
    }

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn((int) (this.measuredSize >> 32), Constraints.m8785getMinWidthimpl(this.measurementConstraints), Constraints.m8783getMaxWidthimpl(this.measurementConstraints));
        int iCoerceIn = RangesKt.coerceIn((int) (this.measuredSize & 4294967295L), Constraints.m8784getMinHeightimpl(this.measurementConstraints), Constraints.m8782getMaxHeightimpl(this.measurementConstraints));
        this.height = iCoerceIn;
        int i = this.width;
        long j = this.measuredSize;
        this.apparentToRealOffset = IntOffset.m8952constructorimpl((((long) ((i - ((int) (j >> 32))) / 2)) << 32) | (4294967295L & ((long) ((iCoerceIn - ((int) (j & 4294967295L))) / 2))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo7508placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        mo7446placeAtf8xVGno(position, zIndex, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* JADX INFO: renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name and from getter */
    protected final long getMeasurementConstraints() {
        return this.measurementConstraints;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m7510setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m8776equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        onMeasuredSizeChanged();
    }

    /* JADX INFO: renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name and from getter */
    protected final long getApparentToRealOffset() {
        return this.apparentToRealOffset;
    }

    /* JADX INFO: compiled from: Placeable.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0016\u001a\u00020\u0005*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J#\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J$\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J$\u0010#\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J#\u0010#\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b$\u0010 J>\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)¢\u0006\u0004\b*\u0010+J?\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)J?\u0010,\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)J>\u0010,\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)¢\u0006\u0004\b-\u0010+J,\u0010,\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J+\u0010,\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b-\u00100J,\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J+\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b*\u00100JA\u00101\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u001b\b\b\u0010&\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a\u0018\u00010'¢\u0006\u0002\b)H\u0080\b¢\u0006\u0004\b2\u0010+J,\u00101\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0080\b¢\u0006\u0004\b2\u00103JA\u00104\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u001b\b\b\u0010&\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a\u0018\u00010'¢\u0006\u0002\b)H\u0080\b¢\u0006\u0004\b5\u0010+J,\u00104\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0080\b¢\u0006\u0004\b5\u00103J\u001f\u00108\u001a\u00020\u001a2\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)J\f\u0010:\u001a\u00020\u001a*\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000bX¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/unit/Density;", "<init>", "()V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "parentWidth", "", "getParentWidth", "()I", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "current", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "placeRelative", "", "Landroidx/compose/ui/layout/Placeable;", Const.POSITION, "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "placeRelative-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "place", "place-70tqf50", "placeRelativeWithLayer", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeWithLayer", "placeWithLayer-aW-9-wM", Const.LAYER, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui", "(Landroidx/compose/ui/layout/Placeable;JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeApparentToRealOffset", "placeApparentToRealOffset-aW-9-wM$ui", "motionFrameOfReferencePlacement", "", "withMotionFrameOfReferencePlacement", BlockContactsIQ.ELEMENT, "handleMotionFrameOfReferencePlacement", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @PlacementScopeMarker
    public static abstract class PlacementScope implements Density {
        public static final int $stable = 0;
        private boolean motionFrameOfReferencePlacement;

        public float current(Ruler ruler, float f2) {
            return f2;
        }

        public LayoutCoordinates getCoordinates() {
            return null;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return 1.0f;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract LayoutDirection getParentLayoutDirection();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int getParentWidth();

        /* JADX INFO: renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m7512placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i & 2) != 0) {
                f2 = 0.0f;
            }
            placementScope.m7522placeRelative70tqf50(placeable, j, f2);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i3 & 4) != 0) {
                f2 = 0.0f;
            }
            placementScope.placeRelative(placeable, i, i2, f2);
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i3 & 4) != 0) {
                f2 = 0.0f;
            }
            placementScope.place(placeable, i, i2, f2);
        }

        /* JADX INFO: renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m7511place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i & 2) != 0) {
                f2 = 0.0f;
            }
            placementScope.m7517place70tqf50(placeable, j, f2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m7513placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f2 = 0.0f;
            }
            float f3 = f2;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m7523placeRelativeWithLayeraW9wM(placeable, j, f3, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f2, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i3 & 4) != 0) {
                f2 = 0.0f;
            }
            float f3 = f2;
            if ((i3 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i2, f3, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f2, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i3 & 4) != 0) {
                f2 = 0.0f;
            }
            float f3 = f2;
            if ((i3 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i, i2, f3, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m7515placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f2 = 0.0f;
            }
            float f3 = f2;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m7525placeWithLayeraW9wM(placeable, j, f3, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i3 & 8) != 0) {
                f2 = 0.0f;
            }
            placementScope.placeWithLayer(placeable, i, i2, graphicsLayer, f2);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m7516placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f2 = 0.0f;
            }
            placementScope.m7526placeWithLayeraW9wM(placeable, j, graphicsLayer, f2);
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i3 & 8) != 0) {
                f2 = 0.0f;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i2, graphicsLayer, f2);
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m7514placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, GraphicsLayer graphicsLayer, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f2 = 0.0f;
            }
            placementScope.m7524placeRelativeWithLayeraW9wM(placeable, j, graphicsLayer, f2);
        }

        /* JADX INFO: renamed from: placeAutoMirrored-aW-9-wM$ui, reason: not valid java name */
        public final void m7521placeAutoMirroredaW9wM$ui(Placeable placeable, long j, float f2, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, function1);
                return;
            }
            int parentWidth = (getParentWidth() - placeable.getWidth()) - IntOffset.m8958getXimpl(j);
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) IntOffset.m8959getYimpl(j)) & 4294967295L) | (((long) parentWidth) << 32));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, function1);
        }

        /* JADX INFO: renamed from: placeAutoMirrored-aW-9-wM$ui, reason: not valid java name */
        public final void m7520placeAutoMirroredaW9wM$ui(Placeable placeable, long j, float f2, GraphicsLayer graphicsLayer) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, graphicsLayer);
                return;
            }
            int parentWidth = (getParentWidth() - placeable.getWidth()) - IntOffset.m8958getXimpl(j);
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) IntOffset.m8959getYimpl(j)) & 4294967295L) | (((long) parentWidth) << 32));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, graphicsLayer);
        }

        /* JADX INFO: renamed from: placeApparentToRealOffset-aW-9-wM$ui, reason: not valid java name */
        public final void m7519placeApparentToRealOffsetaW9wM$ui(Placeable placeable, long j, float f2, Function1<? super GraphicsLayerScope, Unit> function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, function1);
        }

        /* JADX INFO: renamed from: placeApparentToRealOffset-aW-9-wM$ui, reason: not valid java name */
        public final void m7518placeApparentToRealOffsetaW9wM$ui(Placeable placeable, long j, float f2, GraphicsLayer graphicsLayer) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, graphicsLayer);
        }

        public final void withMotionFrameOfReferencePlacement(Function1<? super PlacementScope, Unit> block) {
            this.motionFrameOfReferencePlacement = true;
            block.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void handleMotionFrameOfReferencePlacement(Placeable placeable) {
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).updatePlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m7522placeRelative70tqf50(Placeable placeable, long j, float f2) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            int parentWidth = (getParentWidth() - placeable.getWidth()) - IntOffset.m8958getXimpl(j);
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) IntOffset.m8959getYimpl(j)) & 4294967295L) | (((long) parentWidth) << 32));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        public final void placeRelative(Placeable placeable, int i, int i2, float f2) {
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i) << 32) | (((long) i2) & 4294967295L));
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, (Function1<? super GraphicsLayerScope, Unit>) null);
            } else {
                long jM8952constructorimpl2 = IntOffset.m8952constructorimpl((((long) ((getParentWidth() - placeable.getWidth()) - IntOffset.m8958getXimpl(jM8952constructorimpl))) << 32) | (((long) IntOffset.m8959getYimpl(jM8952constructorimpl)) & 4294967295L));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl2, placeable.apparentToRealOffset), f2, (Function1<? super GraphicsLayerScope, Unit>) null);
            }
        }

        public final void place(Placeable placeable, int i, int i2, float f2) {
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* JADX INFO: renamed from: place-70tqf50, reason: not valid java name */
        public final void m7517place70tqf50(Placeable placeable, long j, float f2) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m7523placeRelativeWithLayeraW9wM(Placeable placeable, long j, float f2, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, function1);
                return;
            }
            int parentWidth = (getParentWidth() - placeable.getWidth()) - IntOffset.m8958getXimpl(j);
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) IntOffset.m8959getYimpl(j)) & 4294967295L) | (((long) parentWidth) << 32));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, function1);
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, float f2, Function1<? super GraphicsLayerScope, Unit> function1) {
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i) << 32) | (((long) i2) & 4294967295L));
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, function1);
            } else {
                long jM8952constructorimpl2 = IntOffset.m8952constructorimpl((((long) ((getParentWidth() - placeable.getWidth()) - IntOffset.m8958getXimpl(jM8952constructorimpl))) << 32) | (((long) IntOffset.m8959getYimpl(jM8952constructorimpl)) & 4294967295L));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl2, placeable.apparentToRealOffset), f2, function1);
            }
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, float f2, Function1<? super GraphicsLayerScope, Unit> function1) {
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, function1);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m7525placeWithLayeraW9wM(Placeable placeable, long j, float f2, Function1<? super GraphicsLayerScope, Unit> function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7446placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, function1);
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f2) {
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, graphicsLayer);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m7526placeWithLayeraW9wM(Placeable placeable, long j, GraphicsLayer graphicsLayer, float f2) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, graphicsLayer);
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, GraphicsLayer graphicsLayer, float f2) {
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) i) << 32) | (((long) i2) & 4294967295L));
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, graphicsLayer);
            } else {
                long jM8952constructorimpl2 = IntOffset.m8952constructorimpl((((long) ((getParentWidth() - placeable.getWidth()) - IntOffset.m8958getXimpl(jM8952constructorimpl))) << 32) | (((long) IntOffset.m8959getYimpl(jM8952constructorimpl)) & 4294967295L));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl2, placeable.apparentToRealOffset), f2, graphicsLayer);
            }
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m7524placeRelativeWithLayeraW9wM(Placeable placeable, long j, GraphicsLayer graphicsLayer, float f2) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(j, placeable.apparentToRealOffset), f2, graphicsLayer);
                return;
            }
            int parentWidth = (getParentWidth() - placeable.getWidth()) - IntOffset.m8958getXimpl(j);
            long jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) IntOffset.m8959getYimpl(j)) & 4294967295L) | (((long) parentWidth) << 32));
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo7508placeAtf8xVGno(IntOffset.m8962plusqkQi6aY(jM8952constructorimpl, placeable.apparentToRealOffset), f2, graphicsLayer);
        }
    }
}
