package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyListMeasuredItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010@\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J(\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016J\u001e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020B2\u0006\u00109\u001a\u00020\u0004J\u0017\u0010*\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010IJ\u0016\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\tJ\u0016\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\tJ(\u0010W\u001a\u00020\u0015*\u00020\u00152\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010!R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010'R\u001e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0014\u0010-\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0014\u0010/\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0014\u00101\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u001a\u00105\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010 R\u0018\u0010Q\u001a\u00020\u0004*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0018\u0010T\u001a\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", FirebaseAnalytics.Param.INDEX, "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "()Z", "J", "getKey", "()Ljava/lang/Object;", "getContentType", "getConstraints-msEJaDk", "()J", "value", "offset", "getOffset", "size", "getSize", "lane", "getLane", "span", "getSpan", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "getParentData", Const.POSITION, "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "getOffset-Bjo55l4", "(I)J", "applyScrollDelta", "delta", "updateAnimations", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", Constants.COPY_TYPE, "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection, z2, i2, i3, i4, j, obj, obj2, lazyLayoutItemAnimator, j2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyListMeasuredItem(int i, List<? extends Placeable> list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, long j2) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        this.span = 1;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = list.size();
        int height = 0;
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            height += getIsVertical() ? placeable.getHeight() : placeable.getWidth();
            iMax = Math.max(iMax, !getIsVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = height;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: isVertical, reason: from getter */
    public boolean getIsVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name and from getter */
    public long getConstraints() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
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

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight) {
        position(mainAxisOffset, layoutWidth, layoutHeight);
    }

    public final void position(int mainAxisOffset, int layoutWidth, int layoutHeight) {
        int width;
        this.offset = mainAxisOffset;
        this.mainAxisLayoutSize = getIsVertical() ? layoutHeight : layoutWidth;
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            int i2 = i * 2;
            if (getIsVertical()) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal != null) {
                    iArr[i2] = horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection);
                    this.placeableOffsets[i2 + 1] = mainAxisOffset;
                    width = placeable.getHeight();
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == true");
                    throw new KotlinNothingValueException();
                }
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i2] = mainAxisOffset;
                int i3 = i2 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical != null) {
                    iArr2[i3] = vertical.align(placeable.getHeight(), layoutHeight);
                    width = placeable.getWidth();
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalAlignment when isVertical == false");
                    throw new KotlinNothingValueException();
                }
            }
            mainAxisOffset += width;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void updateMainAxisLayoutSize(int mainAxisLayoutSize) {
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.maxMainAxisOffset = mainAxisLayoutSize + this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public long mo1301getOffsetBjo55l4(int index) {
        if (index == 0 && getPlaceablesCount() == 0) {
            if (getIsVertical()) {
                return IntOffset.m8952constructorimpl((4294967295L & ((long) getOffset())) | (((long) 0) << 32));
            }
            return IntOffset.m8952constructorimpl((4294967295L & ((long) 0)) | (((long) getOffset()) << 32));
        }
        int[] iArr = this.placeableOffsets;
        int i = index * 2;
        int i2 = iArr[i];
        return IntOffset.m8952constructorimpl((4294967295L & ((long) iArr[i + 1])) | (((long) i2) << 32));
    }

    public final void applyScrollDelta(int delta, boolean updateAnimations) {
        int iIntValue;
        int iM8959getYimpl;
        if (getNonScrollableItem()) {
            return;
        }
        this.offset = getOffset() + delta;
        int length = this.placeableOffsets.length;
        for (int i = 0; i < length; i++) {
            int i2 = i & 1;
            if ((getIsVertical() && i2 != 0) || (!getIsVertical() && i2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[i] = iArr[i] + delta;
            }
        }
        if (updateAnimations) {
            int placeablesCount = getPlaceablesCount();
            for (int i3 = 0; i3 < placeablesCount; i3++) {
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i3);
                if (animation != null) {
                    long rawOffset = animation.getRawOffset();
                    if (getIsVertical()) {
                        iIntValue = IntOffset.m8958getXimpl(rawOffset);
                        iM8959getYimpl = Integer.valueOf(IntOffset.m8959getYimpl(rawOffset) + delta).intValue();
                    } else {
                        iIntValue = Integer.valueOf(IntOffset.m8958getXimpl(rawOffset) + delta).intValue();
                        iM8959getYimpl = IntOffset.m8959getYimpl(rawOffset);
                    }
                    animation.m1367setRawOffsetgyyYBs(IntOffset.m8952constructorimpl((((long) iIntValue) << 32) | (4294967295L & ((long) iM8959getYimpl))));
                }
            }
        }
    }

    public final void place(Placeable.PlacementScope scope, boolean isLookingAhead) {
        GraphicsLayer layer;
        Placeable.PlacementScope placementScope;
        long jM8958getXimpl;
        int i = 0;
        if (!(this.mainAxisLayoutSize != Integer.MIN_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }
        int placeablesCount = getPlaceablesCount();
        while (i < placeablesCount) {
            Placeable placeable = this.placeables.get(i);
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i2 = this.maxMainAxisOffset;
            long jMo1301getOffsetBjo55l4 = mo1301getOffsetBjo55l4(i);
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                if (isLookingAhead) {
                    animation.m1366setLookaheadOffsetgyyYBs(jMo1301getOffsetBjo55l4);
                } else {
                    if (!IntOffset.m8957equalsimpl0(animation.getLookaheadOffset(), LazyLayoutItemAnimation.INSTANCE.m1368getNotInitializednOccac())) {
                        jMo1301getOffsetBjo55l4 = animation.getLookaheadOffset();
                    }
                    long jM8962plusqkQi6aY = IntOffset.m8962plusqkQi6aY(jMo1301getOffsetBjo55l4, animation.m1363getPlacementDeltanOccac());
                    if ((m1299getMainAxisgyyYBs(jMo1301getOffsetBjo55l4) <= mainAxisSize && m1299getMainAxisgyyYBs(jM8962plusqkQi6aY) <= mainAxisSize) || (m1299getMainAxisgyyYBs(jMo1301getOffsetBjo55l4) >= i2 && m1299getMainAxisgyyYBs(jM8962plusqkQi6aY) >= i2)) {
                        animation.cancelPlacementAnimation();
                    }
                    jMo1301getOffsetBjo55l4 = jM8962plusqkQi6aY;
                }
                layer = animation.getLayer();
            } else {
                layer = null;
            }
            if (this.reverseLayout) {
                if (getIsVertical()) {
                    jM8958getXimpl = (((long) ((this.mainAxisLayoutSize - IntOffset.m8959getYimpl(jMo1301getOffsetBjo55l4)) - getMainAxisSize(placeable))) & 4294967295L) | (((long) IntOffset.m8958getXimpl(jMo1301getOffsetBjo55l4)) << 32);
                } else {
                    jM8958getXimpl = (((long) ((this.mainAxisLayoutSize - IntOffset.m8958getXimpl(jMo1301getOffsetBjo55l4)) - getMainAxisSize(placeable))) << 32) | (4294967295L & ((long) IntOffset.m8959getYimpl(jMo1301getOffsetBjo55l4)));
                }
                jMo1301getOffsetBjo55l4 = IntOffset.m8952constructorimpl(jM8958getXimpl);
            }
            long jM8962plusqkQi6aY2 = IntOffset.m8962plusqkQi6aY(jMo1301getOffsetBjo55l4, this.visualOffset);
            if (!isLookingAhead && animation != null) {
                animation.m1365setFinalOffsetgyyYBs(jM8962plusqkQi6aY2);
            }
            if (!getIsVertical()) {
                placementScope = scope;
                GraphicsLayer graphicsLayer = layer;
                if (graphicsLayer != null) {
                    Placeable.PlacementScope.m7514placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM8962plusqkQi6aY2, graphicsLayer, 0.0f, 4, (Object) null);
                } else {
                    Placeable.PlacementScope.m7513placeRelativeWithLayeraW9wM$default(placementScope, placeable, jM8962plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
                }
            } else if (layer != null) {
                placementScope = scope;
                Placeable.PlacementScope.m7516placeWithLayeraW9wM$default(placementScope, placeable, jM8962plusqkQi6aY2, layer, 0.0f, 4, (Object) null);
            } else {
                placementScope = scope;
                Placeable.PlacementScope.m7515placeWithLayeraW9wM$default(placementScope, placeable, jM8962plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
            }
            i++;
            scope = placementScope;
        }
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m1299getMainAxisgyyYBs(long j) {
        return getIsVertical() ? IntOffset.m8959getYimpl(j) : IntOffset.m8958getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return getIsVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m1298copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int iM8959getYimpl;
        long j2;
        if (getIsVertical()) {
            int iM8958getXimpl = IntOffset.m8958getXimpl(j);
            iM8959getYimpl = function1.invoke(Integer.valueOf(IntOffset.m8959getYimpl(j))).intValue();
            j2 = iM8958getXimpl;
        } else {
            int iIntValue = function1.invoke(Integer.valueOf(IntOffset.m8958getXimpl(j))).intValue();
            iM8959getYimpl = IntOffset.m8959getYimpl(j);
            j2 = iIntValue;
        }
        return IntOffset.m8952constructorimpl((j2 << 32) | (((long) iM8959getYimpl) & 4294967295L));
    }
}
