package androidx.compose.material3.carousel;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Keylines.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0000\u001a(\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000\u001aU\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0012\u001a0\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a0\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002¨\u0006\u001d"}, d2 = {"multiBrowseKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "density", "Landroidx/compose/ui/unit/Density;", "carouselMainAxisSize", "", "preferredItemSize", "itemSpacing", "itemCount", "", "minSmallItemSize", "maxSmallItemSize", "uncontainedKeylineList", "itemSize", "heroKeylineList", "maxItemSize", "isCentered", "", "(Landroidx/compose/ui/unit/Density;FLjava/lang/Float;FIZFF)Landroidx/compose/material3/carousel/KeylineList;", "createLeftAlignedKeylineList", "leftAnchorSize", "rightAnchorSize", "arrangement", "Landroidx/compose/material3/carousel/Arrangement;", "createCenterAlignedKeylineList", "calculateMediumChildSize", "minimumMediumSize", "largeItemSize", "remainingSpace", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KeylinesKt {
    public static /* synthetic */ KeylineList multiBrowseKeylineList$default(Density density, float f2, float f3, float f4, int i, float f5, float f6, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            f5 = density.mo488toPx0680j_4(CarouselDefaults.INSTANCE.m3996getMinSmallItemSizeD9Ej5fM());
        }
        float f7 = f5;
        if ((i2 & 64) != 0) {
            f6 = density.mo488toPx0680j_4(CarouselDefaults.INSTANCE.m3995getMaxSmallItemSizeD9Ej5fM());
        }
        return multiBrowseKeylineList(density, f2, f3, f4, i, f7, f6);
    }

    public static final KeylineList multiBrowseKeylineList(Density density, float f2, float f3, float f4, int i, float f5, float f6) {
        float f7;
        if (f2 == 0.0f || f3 == 0.0f) {
            return KeylineListKt.emptyKeylineList();
        }
        int[] iArr = {1};
        int[] iArr2 = {1, 0};
        float fMin = Math.min(f3, f2);
        float fCoerceIn = RangesKt.coerceIn(fMin / 3.0f, f5, f6);
        float f8 = (fMin + fCoerceIn) / 2.0f;
        if (f2 < 2 * f5) {
            iArr = new int[]{0};
        }
        int[] iArr3 = iArr;
        int iCeil = (int) Math.ceil(f2 / fMin);
        int iMax = (iCeil - Math.max(1, (int) Math.floor(((f2 - (ArraysKt.maxOrThrow(iArr2) * f8)) - (ArraysKt.maxOrThrow(iArr3) * f6)) / fMin))) + 1;
        int[] iArr4 = new int[iMax];
        for (int i2 = 0; i2 < iMax; i2++) {
            iArr4[i2] = iCeil - i2;
        }
        float fMo488toPx0680j_4 = density.mo488toPx0680j_4(CarouselDefaults.INSTANCE.m3994getAnchorSizeD9Ej5fM$material3());
        Arrangement arrangementFindLowestCostArrangement = Arrangement.INSTANCE.findLowestCostArrangement(f2, f4, fCoerceIn, f5, f6, iArr3, f8, iArr2, fMin, iArr4);
        if (arrangementFindLowestCostArrangement == null || arrangementFindLowestCostArrangement.itemCount() <= i) {
            f7 = f2;
        } else {
            int smallCount = arrangementFindLowestCostArrangement.getSmallCount();
            int mediumCount = arrangementFindLowestCostArrangement.getMediumCount();
            for (int iItemCount = arrangementFindLowestCostArrangement.itemCount() - i; iItemCount > 0; iItemCount--) {
                if (smallCount > 0) {
                    smallCount--;
                } else if (mediumCount > 1) {
                    mediumCount--;
                }
            }
            f7 = f2;
            arrangementFindLowestCostArrangement = Arrangement.INSTANCE.findLowestCostArrangement(f7, f4, fCoerceIn, f5, f6, new int[]{smallCount}, f8, new int[]{mediumCount}, fMin, iArr4);
        }
        if (arrangementFindLowestCostArrangement == null) {
            return KeylineListKt.emptyKeylineList();
        }
        return createLeftAlignedKeylineList(f7, f4, fMo488toPx0680j_4, fMo488toPx0680j_4, arrangementFindLowestCostArrangement);
    }

    public static final KeylineList uncontainedKeylineList(Density density, float f2, float f3, float f4) {
        if (f2 == 0.0f || f3 == 0.0f) {
            return KeylineListKt.emptyKeylineList();
        }
        float fMin = Math.min(f3 + f4, f2);
        int iMax = Math.max(1, (int) Math.floor(f2 / fMin));
        float f5 = f2 - (iMax * fMin);
        int i = f5 <= 0.0f ? 0 : 1;
        float fMo488toPx0680j_4 = density.mo488toPx0680j_4(CarouselDefaults.INSTANCE.m3994getAnchorSizeD9Ej5fM$material3());
        float fCalculateMediumChildSize = calculateMediumChildSize(fMo488toPx0680j_4, fMin, f5);
        return createLeftAlignedKeylineList(f2, f4, Math.max(Math.min(fMo488toPx0680j_4, f3), fCalculateMediumChildSize * 0.5f), fMo488toPx0680j_4, new Arrangement(0, 0.0f, 0, fCalculateMediumChildSize, i, fMin, iMax));
    }

    public static /* synthetic */ KeylineList heroKeylineList$default(Density density, float f2, Float f3, float f4, int i, boolean z, float f5, float f6, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 64) != 0) {
            f5 = density.mo488toPx0680j_4(CarouselDefaults.INSTANCE.m3996getMinSmallItemSizeD9Ej5fM());
        }
        float f7 = f5;
        if ((i2 & 128) != 0) {
            f6 = density.mo488toPx0680j_4(CarouselDefaults.INSTANCE.m3995getMaxSmallItemSizeD9Ej5fM());
        }
        return heroKeylineList(density, f2, f3, f4, i, z2, f7, f6);
    }

    public static final KeylineList heroKeylineList(Density density, float f2, Float f3, float f4, int i, boolean z, float f5, float f6) {
        if (f2 == 0.0f) {
            return KeylineListKt.emptyKeylineList();
        }
        boolean z2 = z && i >= 3;
        int[] iArr = new int[1];
        if (z2) {
            iArr[0] = 2;
        } else {
            iArr[0] = 1;
        }
        float fMin = Math.min(f3 != null ? f3.floatValue() : f2, f2);
        float fCoerceIn = RangesKt.coerceIn(fMin / 3.0f, f5, f6);
        if (f2 < (ArraysKt.maxOrThrow(iArr) * f5) + (1.25f * f5)) {
            iArr = new int[]{0};
        }
        int iCeil = (int) Math.ceil(f2 / fMin);
        int iMax = (iCeil - Math.max(1, (int) Math.floor((f2 - (ArraysKt.maxOrThrow(iArr) * f5)) / fMin))) + 1;
        int[] iArr2 = new int[iMax];
        for (int i2 = 0; i2 < iMax; i2++) {
            iArr2[i2] = iCeil - i2;
        }
        float fMo488toPx0680j_4 = density.mo488toPx0680j_4(CarouselDefaults.INSTANCE.m3994getAnchorSizeD9Ej5fM$material3());
        Arrangement arrangementFindLowestCostArrangement = Arrangement.INSTANCE.findLowestCostArrangement(f2, f4, fCoerceIn, f5, f6, iArr, 0.0f, new int[]{0}, fMin, iArr2);
        if (arrangementFindLowestCostArrangement == null) {
            return KeylineListKt.emptyKeylineList();
        }
        if (z2 && i >= arrangementFindLowestCostArrangement.itemCount()) {
            return createCenterAlignedKeylineList(f2, f4, fMo488toPx0680j_4, fMo488toPx0680j_4, arrangementFindLowestCostArrangement);
        }
        return createLeftAlignedKeylineList(f2, f4, fMo488toPx0680j_4, fMo488toPx0680j_4, arrangementFindLowestCostArrangement);
    }

    public static final KeylineList createLeftAlignedKeylineList(float f2, float f3, final float f4, final float f5, final Arrangement arrangement) {
        return KeylineListKt.m4018keylineListOfWNYm7Xg(f2, f3, CarouselAlignment.INSTANCE.m3993getStartNUL3oTo(), new Function1() { // from class: androidx.compose.material3.carousel.KeylinesKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KeylinesKt.createLeftAlignedKeylineList$lambda$10(f4, arrangement, f5, (KeylineListScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createLeftAlignedKeylineList$lambda$10(float f2, Arrangement arrangement, float f3, KeylineListScope keylineListScope) {
        keylineListScope.add(f2, true);
        int largeCount = arrangement.getLargeCount();
        for (int i = 0; i < largeCount; i++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getLargeSize(), false, 2, null);
        }
        int mediumCount = arrangement.getMediumCount();
        for (int i2 = 0; i2 < mediumCount; i2++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getMediumSize(), false, 2, null);
        }
        int smallCount = arrangement.getSmallCount();
        for (int i3 = 0; i3 < smallCount; i3++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getSmallSize(), false, 2, null);
        }
        keylineListScope.add(f3, true);
        return Unit.INSTANCE;
    }

    public static final KeylineList createCenterAlignedKeylineList(float f2, float f3, final float f4, final float f5, final Arrangement arrangement) {
        return KeylineListKt.m4018keylineListOfWNYm7Xg(f2, f3, CarouselAlignment.INSTANCE.m3991getCenterNUL3oTo(), new Function1() { // from class: androidx.compose.material3.carousel.KeylinesKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KeylinesKt.createCenterAlignedKeylineList$lambda$16(f4, arrangement, f5, (KeylineListScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createCenterAlignedKeylineList$lambda$16(float f2, Arrangement arrangement, float f3, KeylineListScope keylineListScope) {
        keylineListScope.add(f2, true);
        int smallCount = arrangement.getSmallCount() / 2;
        for (int i = 0; i < smallCount; i++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getSmallSize(), false, 2, null);
        }
        int mediumCount = arrangement.getMediumCount() / 2;
        for (int i2 = 0; i2 < mediumCount; i2++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getMediumSize(), false, 2, null);
        }
        int largeCount = arrangement.getLargeCount();
        for (int i3 = 0; i3 < largeCount; i3++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getLargeSize(), false, 2, null);
        }
        int mediumCount2 = arrangement.getMediumCount() / 2;
        for (int i4 = 0; i4 < mediumCount2; i4++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getMediumSize(), false, 2, null);
        }
        int smallCount2 = arrangement.getSmallCount() / 2;
        for (int i5 = 0; i5 < smallCount2; i5++) {
            KeylineListScope.add$default(keylineListScope, arrangement.getSmallSize(), false, 2, null);
        }
        keylineListScope.add(f3, true);
        return Unit.INSTANCE;
    }

    private static final float calculateMediumChildSize(float f2, float f3, float f4) {
        float fMax = Math.max(1.5f * f4, f2);
        float f5 = 0.85f * f3;
        return fMax > f5 ? Math.min(Math.max(f5, f4 * 1.2f), f3) : fMax;
    }
}
