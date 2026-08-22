package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010(\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0017\u0010<\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>J\u001e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J(\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016J-\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020\u000b¢\u0006\u0004\bN\u0010OJ\u000e\u0010P\u001a\u00020@2\u0006\u0010/\u001a\u00020\u0004J\u0016\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u000bJ(\u0010W\u001a\u000209*\u0002092\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[J\b\u0010\\\u001a\u00020]H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019R\u000e\u0010/\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010%R\u0016\u00105\u001a\u000206X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b7\u0010!R \u0010:\u001a\u0002092\u0006\u00108\u001a\u000209@RX\u0096\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b;\u0010!R\u0011\u0010C\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u0018\u0010A\u001a\u00020\u0004*\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0019\u0010)\u001a\u00020\u0004*\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010V¨\u0006^"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", FirebaseAnalytics.Param.INDEX, "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "()Z", "getLane", "getSpan", "getContentType", "getConstraints-msEJaDk", "()J", "J", "isVisible", "setVisible", "(Z)V", "placeablesCount", "getPlaceablesCount", "getParentData", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "value", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "getOffset", "getOffset-Bjo55l4", "(I)J", Const.POSITION, "", "mainAxis", "crossAxis", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "getMainAxisOffset", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "reverseLayout", "contentOffset", "isLookingAhead", "place-GMOY1bU", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;ZJZ)V", "updateMainAxisLayoutSize", "applyScrollDelta", "delta", "updateAnimations", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", Constants.COPY_TYPE, "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int span;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i, Object obj, List list, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, list, z, i2, i3, i4, i5, i6, obj2, lazyLayoutItemAnimator, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyStaggeredGridMeasuredItem(int i, Object obj, List<? extends Placeable> list, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj2, LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> lazyLayoutItemAnimator, long j) {
        int height;
        long jM8996constructorimpl;
        this.index = i;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z;
        this.lane = i3;
        this.span = i4;
        this.beforeContentPadding = i5;
        this.afterContentPadding = i6;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j;
        int i7 = 1;
        this.isVisible = true;
        int i8 = 0;
        if (list.isEmpty()) {
            height = 0;
        } else {
            Placeable placeable = (Placeable) list.get(0);
            height = getIsVertical() ? placeable.getHeight() : placeable.getWidth();
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i9 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) list.get(i9);
                    int height2 = getIsVertical() ? placeable2.getHeight() : placeable2.getWidth();
                    height = height2 > height ? height2 : height;
                    if (i9 == lastIndex) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
        }
        this.mainAxisSize = height;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(height + i2, 0);
        List<Placeable> list2 = this.placeables;
        if (!list2.isEmpty()) {
            Placeable placeable3 = list2.get(0);
            int width = getIsVertical() ? placeable3.getWidth() : placeable3.getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable placeable4 = list2.get(i7);
                    int width2 = getIsVertical() ? placeable4.getWidth() : placeable4.getHeight();
                    width = width2 > width ? width2 : width;
                    if (i7 == lastIndex2) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            i8 = width;
        }
        this.crossAxisSize = i8;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        if (getIsVertical()) {
            jM8996constructorimpl = IntSize.m8996constructorimpl((((long) this.mainAxisSize) & 4294967295L) | (((long) i8) << 32));
        } else {
            jM8996constructorimpl = IntSize.m8996constructorimpl((((long) i8) & 4294967295L) | (((long) this.mainAxisSize) << 32));
        }
        this.size = jM8996constructorimpl;
        this.offset = IntOffset.INSTANCE.m8969getZeronOccac();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public boolean getIsVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: from getter */
    public long getConstraints() {
        return this.constraints;
    }

    /* JADX INFO: renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: from getter */
    public long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4 */
    public long mo1301getOffsetBjo55l4(int index) {
        return getOffset();
    }

    public final void position(int mainAxis, int crossAxis, int mainAxisLayoutSize) {
        long jM8952constructorimpl;
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
        if (getIsVertical()) {
            jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) crossAxis) << 32) | (4294967295L & ((long) mainAxis)));
        } else {
            jM8952constructorimpl = IntOffset.m8952constructorimpl((((long) crossAxis) & 4294967295L) | (((long) mainAxis) << 32));
        }
        this.offset = jM8952constructorimpl;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        if (getIsVertical()) {
            layoutWidth = layoutHeight;
        }
        position(mainAxisOffset, crossAxisOffset, layoutWidth);
    }

    public final int getMainAxisOffset() {
        return !getIsVertical() ? IntOffset.m8958getXimpl(getOffset()) : IntOffset.m8959getYimpl(getOffset());
    }

    /* JADX INFO: renamed from: place-GMOY1bU, reason: not valid java name */
    public final void m1443placeGMOY1bU(Placeable.PlacementScope scope, boolean reverseLayout, long contentOffset, boolean isLookingAhead) {
        GraphicsLayer layer;
        int iM8958getXimpl;
        int iM8959getYimpl;
        if (!(this.mainAxisLayoutSize != Integer.MIN_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            int height = this.minMainAxisOffset - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
            int i2 = this.maxMainAxisOffset;
            long offset = getOffset();
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                if (isLookingAhead) {
                    animation.m1366setLookaheadOffsetgyyYBs(offset);
                } else {
                    long jM8962plusqkQi6aY = IntOffset.m8962plusqkQi6aY(!IntOffset.m8957equalsimpl0(animation.getLookaheadOffset(), LazyLayoutItemAnimation.INSTANCE.m1368getNotInitializednOccac()) ? animation.getLookaheadOffset() : offset, animation.m1363getPlacementDeltanOccac());
                    if ((m1442getMainAxisgyyYBs(offset) <= height && m1442getMainAxisgyyYBs(jM8962plusqkQi6aY) <= height) || (m1442getMainAxisgyyYBs(offset) >= i2 && m1442getMainAxisgyyYBs(jM8962plusqkQi6aY) >= i2)) {
                        animation.cancelPlacementAnimation();
                    }
                    offset = jM8962plusqkQi6aY;
                }
                layer = animation.getLayer();
            } else {
                layer = null;
            }
            if (reverseLayout) {
                if (getIsVertical()) {
                    iM8958getXimpl = IntOffset.m8958getXimpl(offset);
                } else {
                    iM8958getXimpl = (this.mainAxisLayoutSize - IntOffset.m8958getXimpl(offset)) - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
                }
                if (!getIsVertical()) {
                    iM8959getYimpl = IntOffset.m8959getYimpl(offset);
                } else {
                    iM8959getYimpl = (this.mainAxisLayoutSize - IntOffset.m8959getYimpl(offset)) - (getIsVertical() ? placeable.getHeight() : placeable.getWidth());
                }
                offset = IntOffset.m8952constructorimpl((((long) iM8959getYimpl) & 4294967295L) | (((long) iM8958getXimpl) << 32));
            }
            long jM8962plusqkQi6aY2 = IntOffset.m8962plusqkQi6aY(offset, contentOffset);
            if (!isLookingAhead && animation != null) {
                animation.m1365setFinalOffsetgyyYBs(jM8962plusqkQi6aY2);
            }
            if (layer != null) {
                Placeable.PlacementScope.m7514placeRelativeWithLayeraW9wM$default(scope, placeable, jM8962plusqkQi6aY2, layer, 0.0f, 4, (Object) null);
            } else {
                Placeable.PlacementScope.m7513placeRelativeWithLayeraW9wM$default(scope, placeable, jM8962plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }

    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void applyScrollDelta(int delta, boolean updateAnimations) {
        if (getNonScrollableItem()) {
            return;
        }
        long offset = getOffset();
        int iM8958getXimpl = getIsVertical() ? IntOffset.m8958getXimpl(offset) : IntOffset.m8958getXimpl(offset) + delta;
        boolean isVertical = getIsVertical();
        int iM8959getYimpl = IntOffset.m8959getYimpl(offset);
        if (isVertical) {
            iM8959getYimpl += delta;
        }
        this.offset = IntOffset.m8952constructorimpl((((long) iM8958getXimpl) << 32) | (((long) iM8959getYimpl) & 4294967295L));
        if (updateAnimations) {
            int placeablesCount = getPlaceablesCount();
            for (int i = 0; i < placeablesCount; i++) {
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
                if (animation != null) {
                    long rawOffset = animation.getRawOffset();
                    int iM8958getXimpl2 = getIsVertical() ? IntOffset.m8958getXimpl(rawOffset) : Integer.valueOf(IntOffset.m8958getXimpl(rawOffset) + delta).intValue();
                    boolean isVertical2 = getIsVertical();
                    int iM8959getYimpl2 = IntOffset.m8959getYimpl(rawOffset);
                    if (isVertical2) {
                        iM8959getYimpl2 = Integer.valueOf(iM8959getYimpl2 + delta).intValue();
                    }
                    animation.m1367setRawOffsetgyyYBs(IntOffset.m8952constructorimpl((((long) iM8959getYimpl2) & 4294967295L) | (((long) iM8958getXimpl2) << 32)));
                }
            }
        }
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m1442getMainAxisgyyYBs(long j) {
        return getIsVertical() ? IntOffset.m8959getYimpl(j) : IntOffset.m8958getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m1441copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int iM8958getXimpl = getIsVertical() ? IntOffset.m8958getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m8958getXimpl(j))).intValue();
        boolean isVertical = getIsVertical();
        int iM8959getYimpl = IntOffset.m8959getYimpl(j);
        if (isVertical) {
            iM8959getYimpl = function1.invoke(Integer.valueOf(iM8959getYimpl)).intValue();
        }
        return IntOffset.m8952constructorimpl((((long) iM8958getXimpl) << 32) | (((long) iM8959getYimpl) & 4294967295L));
    }

    public String toString() {
        return super.toString();
    }
}
