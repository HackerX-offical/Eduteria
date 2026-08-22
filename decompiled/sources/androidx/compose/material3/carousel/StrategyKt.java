package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import androidx.collection.FloatListKt;
import androidx.collection.MutableFloatList;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Strategy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001a.\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001a8\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$*\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002\u001a0\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002¨\u0006+"}, d2 = {"getStartShiftDistance", "", "startKeylineSteps", "", "Landroidx/compose/material3/carousel/KeylineList;", "beforeContentPadding", "getEndShiftDistance", "endKeylineSteps", "afterContentPadding", "getStartKeylineSteps", "defaultKeylines", "carouselMainAxisSize", "itemSpacing", "getEndKeylineSteps", "createShiftedKeylineListForContentPadding", "from", "contentPadding", "pivot", "Landroidx/compose/material3/carousel/Keyline;", "pivotIndex", "", "moveKeylineAndCreateShiftedKeylineList", "srcIndex", "dstIndex", "getStepInterpolationPoints", "Landroidx/collection/FloatList;", "totalShiftDistance", "steps", "isShiftingLeft", "", "getShiftPointRange", "Landroidx/compose/material3/carousel/ShiftPointRange;", "stepsCount", "shiftPoint", "interpolation", "move", "", "lerp", "outputMin", "outputMax", "inputMin", "inputMax", "value", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StrategyKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float getStartShiftDistance(List<KeylineList> list, float f2) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        return Math.max(((Keyline) CollectionsKt.first((List) CollectionsKt.last((List) list))).getUnadjustedOffset() - ((Keyline) CollectionsKt.first((List) CollectionsKt.first((List) list))).getUnadjustedOffset(), f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getEndShiftDistance(List<KeylineList> list, float f2) {
        if (list.isEmpty()) {
            return 0.0f;
        }
        return Math.max(((Keyline) CollectionsKt.last((List) CollectionsKt.first((List) list))).getUnadjustedOffset() - ((Keyline) CollectionsKt.last((List) CollectionsKt.last((List) list))).getUnadjustedOffset(), f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KeylineList> getStartKeylineSteps(KeylineList keylineList, float f2, float f3, float f4) {
        if (keylineList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineList);
        if (keylineList.isFirstFocalItemAtStartOfContainer()) {
            if (f4 == 0.0f) {
                return arrayList;
            }
            arrayList.add(createShiftedKeylineListForContentPadding(keylineList, f2, f3, f4, keylineList.getFirstFocal(), keylineList.getFirstFocalIndex()));
            return arrayList;
        }
        int firstNonAnchorIndex = keylineList.getFirstNonAnchorIndex();
        int firstFocalIndex = keylineList.getFirstFocalIndex() - firstNonAnchorIndex;
        if (firstFocalIndex <= 0 && keylineList.getFirstFocal().getCutoff() > 0.0f) {
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f2, f3));
            return arrayList;
        }
        for (int i = 0; i < firstFocalIndex; i++) {
            KeylineList keylineList2 = (KeylineList) CollectionsKt.last((List) arrayList);
            int i2 = firstNonAnchorIndex + i;
            int lastIndex = CollectionsKt.getLastIndex(keylineList);
            if (i2 > 0) {
                lastIndex = keylineList2.firstIndexAfterFocalRangeWithSize(keylineList.get(i2 - 1).getSize()) - 1;
            }
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList2, keylineList.getFirstNonAnchorIndex(), lastIndex, f2, f3));
        }
        if (f4 == 0.0f) {
            return arrayList;
        }
        arrayList.set(CollectionsKt.getLastIndex(arrayList), createShiftedKeylineListForContentPadding((KeylineList) CollectionsKt.last((List) arrayList), f2, f3, f4, ((KeylineList) CollectionsKt.last((List) arrayList)).getFirstFocal(), ((KeylineList) CollectionsKt.last((List) arrayList)).getFirstFocalIndex()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KeylineList> getEndKeylineSteps(KeylineList keylineList, float f2, float f3, float f4) {
        if (keylineList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineList);
        if (keylineList.isLastFocalItemAtEndOfContainer(f2)) {
            if (f4 == 0.0f) {
                return arrayList;
            }
            arrayList.add(createShiftedKeylineListForContentPadding(keylineList, f2, f3, -f4, keylineList.getLastFocal(), keylineList.getLastFocalIndex()));
            return arrayList;
        }
        int lastFocalIndex = keylineList.getLastFocalIndex();
        int lastNonAnchorIndex = keylineList.getLastNonAnchorIndex();
        int i = lastNonAnchorIndex - lastFocalIndex;
        if (i <= 0 && keylineList.getLastFocal().getCutoff() > 0.0f) {
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f2, f3));
            return arrayList;
        }
        for (int i2 = 0; i2 < i; i2++) {
            KeylineList keylineList2 = (KeylineList) CollectionsKt.last((List) arrayList);
            int i3 = lastNonAnchorIndex - i2;
            arrayList.add(moveKeylineAndCreateShiftedKeylineList(keylineList2, keylineList.getLastNonAnchorIndex(), i3 < CollectionsKt.getLastIndex(keylineList) ? keylineList2.lastIndexBeforeFocalRangeWithSize(keylineList.get(i3 + 1).getSize()) + 1 : 0, f2, f3));
        }
        if (f4 == 0.0f) {
            return arrayList;
        }
        arrayList.set(CollectionsKt.getLastIndex(arrayList), createShiftedKeylineListForContentPadding((KeylineList) CollectionsKt.last((List) arrayList), f2, f3, -f4, ((KeylineList) CollectionsKt.last((List) arrayList)).getLastFocal(), ((KeylineList) CollectionsKt.last((List) arrayList)).getLastFocalIndex()));
        return arrayList;
    }

    private static final KeylineList createShiftedKeylineListForContentPadding(final KeylineList keylineList, float f2, float f3, float f4, Keyline keyline, int i) {
        KeylineList keylineList2 = keylineList;
        ArrayList arrayList = new ArrayList(keylineList2.size());
        int size = keylineList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Keyline keyline2 = keylineList2.get(i2);
            if (!keyline2.isAnchor()) {
                arrayList.add(keyline2);
            }
        }
        final float size2 = f4 / arrayList.size();
        KeylineList keylineListKeylineListOf = KeylineListKt.keylineListOf(f2, f3, i, (keyline.getOffset() - (size2 / 2.0f)) + f4, new Function1() { // from class: androidx.compose.material3.carousel.StrategyKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrategyKt.createShiftedKeylineListForContentPadding$lambda$2(keylineList, size2, (KeylineListScope) obj);
            }
        });
        ArrayList arrayList2 = new ArrayList(keylineListKeylineListOf.size());
        int size3 = keylineListKeylineListOf.size();
        for (int i3 = 0; i3 < size3; i3++) {
            arrayList2.add(Keyline.copy$default(keylineListKeylineListOf.get(i3), 0.0f, 0.0f, keylineList.get(i3).getUnadjustedOffset(), false, false, false, 0.0f, 123, null));
        }
        return new KeylineList(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createShiftedKeylineListForContentPadding$lambda$2(KeylineList keylineList, float f2, KeylineListScope keylineListScope) {
        KeylineList keylineList2 = keylineList;
        int size = keylineList2.size();
        for (int i = 0; i < size; i++) {
            Keyline keyline = keylineList2.get(i);
            keylineListScope.add(keyline.getSize() - Math.abs(f2), keyline.isAnchor());
        }
        return Unit.INSTANCE;
    }

    private static final KeylineList moveKeylineAndCreateShiftedKeylineList(final KeylineList keylineList, final int i, final int i2, float f2, float f3) {
        int i3 = i > i2 ? 1 : -1;
        return KeylineListKt.keylineListOf(f2, f3, keylineList.getPivotIndex() + i3, keylineList.getPivot().getOffset() + (((keylineList.get(i).getSize() - keylineList.get(i).getCutoff()) + f3) * i3), new Function1() { // from class: androidx.compose.material3.carousel.StrategyKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrategyKt.moveKeylineAndCreateShiftedKeylineList$lambda$5(keylineList, i, i2, (KeylineListScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit moveKeylineAndCreateShiftedKeylineList$lambda$5(KeylineList keylineList, int i, int i2, KeylineListScope keylineListScope) {
        List<Keyline> listMove = move(CollectionsKt.toMutableList((Collection) keylineList), i, i2);
        int size = listMove.size();
        for (int i3 = 0; i3 < size; i3++) {
            Keyline keyline = listMove.get(i3);
            keylineListScope.add(keyline.getSize(), keyline.isAnchor());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FloatList getStepInterpolationPoints(float f2, List<KeylineList> list, boolean z) {
        float unadjustedOffset;
        MutableFloatList mutableFloatListMutableFloatListOf = FloatListKt.mutableFloatListOf(0.0f);
        if (f2 == 0.0f || list.isEmpty()) {
            return mutableFloatListMutableFloatListOf;
        }
        IntRange intRangeUntil = RangesKt.until(1, list.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            int i = iNextInt - 1;
            KeylineList keylineList = list.get(i);
            KeylineList keylineList2 = list.get(iNextInt);
            if (z) {
                unadjustedOffset = ((Keyline) CollectionsKt.first((List) keylineList2)).getUnadjustedOffset() - ((Keyline) CollectionsKt.first((List) keylineList)).getUnadjustedOffset();
            } else {
                unadjustedOffset = ((Keyline) CollectionsKt.last((List) keylineList)).getUnadjustedOffset() - ((Keyline) CollectionsKt.last((List) keylineList2)).getUnadjustedOffset();
            }
            arrayList.add(Boolean.valueOf(mutableFloatListMutableFloatListOf.add(iNextInt == CollectionsKt.getLastIndex(list) ? 1.0f : mutableFloatListMutableFloatListOf.get(i) + (unadjustedOffset / f2))));
        }
        return mutableFloatListMutableFloatListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShiftPointRange getShiftPointRange(int i, FloatList floatList, float f2) {
        float f3 = floatList.get(0);
        Iterator<Integer> it = RangesKt.until(1, i).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            float f4 = floatList.get(iNextInt);
            if (f2 <= f4) {
                return new ShiftPointRange(iNextInt - 1, iNextInt, lerp(0.0f, 1.0f, f3, f4, f2));
            }
            f3 = f4;
        }
        return new ShiftPointRange(0, 0, 0.0f);
    }

    private static final List<Keyline> move(List<Keyline> list, int i, int i2) {
        Keyline keyline = list.get(i);
        list.remove(i);
        list.add(i2, keyline);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float lerp(float f2, float f3, float f4, float f5, float f6) {
        return f6 <= f4 ? f2 : f6 >= f5 ? f3 : MathHelpersKt.lerp(f2, f3, (f6 - f4) / (f5 - f4));
    }
}
