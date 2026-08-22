package org.mozilla.javascript;

import java.util.Comparator;

/* JADX INFO: loaded from: classes10.dex */
public final class Sorting {
    private static final int SMALLSORT = 16;

    public static void insertionSort(Object[] objArr, Comparator<Object> comparator) {
        insertionSort(objArr, 0, objArr.length - 1, comparator);
    }

    public static void insertionSort(Object[] objArr, int i, int i2, Comparator<Object> comparator) {
        for (int i3 = i; i3 <= i2; i3++) {
            Object obj = objArr[i3];
            int i4 = i3 - 1;
            while (i4 >= i && comparator.compare(objArr[i4], obj) > 0) {
                objArr[i4 + 1] = objArr[i4];
                i4--;
            }
            objArr[i4 + 1] = obj;
        }
    }

    public static void hybridSort(Object[] objArr, Comparator<Object> comparator) {
        hybridSort(objArr, 0, objArr.length - 1, comparator, log2(objArr.length) * 2);
    }

    private static void hybridSort(Object[] objArr, int i, int i2, Comparator<Object> comparator, int i3) {
        if (i < i2) {
            if (i3 == 0 || i2 - i <= 16) {
                insertionSort(objArr, i, i2, comparator);
                return;
            }
            int iPartition = partition(objArr, i, i2, comparator);
            int i4 = i3 - 1;
            hybridSort(objArr, i, iPartition, comparator, i4);
            hybridSort(objArr, iPartition + 1, i2, comparator, i4);
        }
    }

    private static int partition(Object[] objArr, int i, int i2, Comparator<Object> comparator) {
        int iMedian = median(objArr, i, i2, comparator);
        Object obj = objArr[iMedian];
        objArr[iMedian] = objArr[i];
        objArr[i] = obj;
        int i3 = i2 + 1;
        int i4 = i;
        while (true) {
            i4++;
            if (comparator.compare(objArr[i4], obj) >= 0 || i4 == i2) {
                do {
                    i3--;
                    if (comparator.compare(objArr[i3], obj) < 0) {
                        break;
                    }
                } while (i3 != i);
                if (i4 < i3) {
                    swap(objArr, i4, i3);
                } else {
                    swap(objArr, i, i3);
                    return i3;
                }
            }
        }
    }

    private static void swap(Object[] objArr, int i, int i2) {
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    private static int log2(int i) {
        return (int) (Math.log10(i) / Math.log10(2.0d));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int median(java.lang.Object[] r4, int r5, int r6, java.util.Comparator<java.lang.Object> r7) {
        /*
            int r0 = r6 - r5
            int r0 = r0 / 2
            int r0 = r0 + r5
            r1 = r4[r5]
            r2 = r4[r0]
            int r1 = r7.compare(r1, r2)
            if (r1 <= 0) goto L11
            r1 = r0
            goto L12
        L11:
            r1 = r5
        L12:
            r2 = r4[r1]
            r3 = r4[r6]
            int r2 = r7.compare(r2, r3)
            if (r2 <= 0) goto L1d
            r1 = r6
        L1d:
            if (r1 != r5) goto L2a
            r5 = r4[r0]
            r4 = r4[r6]
            int r4 = r7.compare(r5, r4)
            if (r4 >= 0) goto L37
            goto L43
        L2a:
            if (r1 != r0) goto L38
            r0 = r4[r5]
            r4 = r4[r6]
            int r4 = r7.compare(r0, r4)
            if (r4 >= 0) goto L37
            goto L42
        L37:
            return r6
        L38:
            r6 = r4[r5]
            r4 = r4[r0]
            int r4 = r7.compare(r6, r4)
            if (r4 >= 0) goto L43
        L42:
            return r5
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Sorting.median(java.lang.Object[], int, int, java.util.Comparator):int");
    }
}
