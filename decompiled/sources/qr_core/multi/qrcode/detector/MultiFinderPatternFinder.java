package qr_core.multi.qrcode.detector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import qr_core.DecodeHintType;
import qr_core.NotFoundException;
import qr_core.ResultPoint;
import qr_core.ResultPointCallback;
import qr_core.common.BitMatrix;
import qr_core.qrcode.detector.FinderPattern;
import qr_core.qrcode.detector.FinderPatternFinder;
import qr_core.qrcode.detector.FinderPatternInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiFinderPatternFinder extends FinderPatternFinder {
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;
    private static final FinderPatternInfo[] EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    private static final FinderPattern[] EMPTY_FP_ARRAY = new FinderPattern[0];
    private static final FinderPattern[][] EMPTY_FP_2D_ARRAY = new FinderPattern[0][];

    private static final class ModuleSizeComparator implements Comparator<FinderPattern>, Serializable {
        private ModuleSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            double estimatedModuleSize = finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize();
            if (estimatedModuleSize < 0.0d) {
                return -1;
            }
            return estimatedModuleSize > 0.0d ? 1 : 0;
        }
    }

    public MultiFinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }

    private FinderPattern[][] selectMultipleBestPatterns() throws NotFoundException {
        char c2;
        char c3;
        char c4;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        Iterator<FinderPattern> it = getPossibleCenters().iterator();
        while (true) {
            c2 = 2;
            if (!it.hasNext()) {
                break;
            }
            FinderPattern next = it.next();
            if (next.getCount() >= 2) {
                arrayList2.add(next);
            }
        }
        int size = arrayList2.size();
        int i = 3;
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        char c5 = 0;
        char c6 = 1;
        if (size == 3) {
            return new FinderPattern[][]{(FinderPattern[]) arrayList2.toArray(EMPTY_FP_ARRAY)};
        }
        Collections.sort(arrayList2, new ModuleSizeComparator());
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        while (i2 < size - 2) {
            FinderPattern finderPattern = (FinderPattern) arrayList2.get(i2);
            if (finderPattern != null) {
                int i3 = i2 + 1;
                while (i3 < size - 1) {
                    FinderPattern finderPattern2 = (FinderPattern) arrayList2.get(i3);
                    if (finderPattern2 != null) {
                        float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                        float fAbs = Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize());
                        float f2 = 0.5f;
                        float f3 = DIFF_MODSIZE_CUTOFF_PERCENT;
                        if (fAbs > 0.5f && estimatedModuleSize >= DIFF_MODSIZE_CUTOFF_PERCENT) {
                            break;
                        }
                        int i4 = i3 + 1;
                        while (i4 < size) {
                            FinderPattern finderPattern3 = (FinderPattern) arrayList2.get(i4);
                            if (finderPattern3 != null) {
                                c3 = c2;
                                c4 = c5;
                                float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) > f2 && estimatedModuleSize2 >= f3) {
                                    break;
                                }
                                FinderPattern[] finderPatternArr = new FinderPattern[i];
                                finderPatternArr[c4] = finderPattern;
                                finderPatternArr[c6] = finderPattern2;
                                finderPatternArr[c3] = finderPattern3;
                                ResultPoint.orderBestPatterns(finderPatternArr);
                                FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPatternArr);
                                float fDistance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                float fDistance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                float fDistance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                float estimatedModuleSize3 = (fDistance + fDistance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                if (estimatedModuleSize3 <= 180.0f && estimatedModuleSize3 >= MIN_MODULE_COUNT_PER_EDGE && Math.abs((fDistance - fDistance3) / Math.min(fDistance, fDistance3)) < 0.1f) {
                                    double d2 = fDistance;
                                    ArrayList arrayList4 = arrayList3;
                                    double d3 = fDistance3;
                                    float fSqrt = (float) Math.sqrt((d2 * d2) + (d3 * d3));
                                    if (Math.abs((fDistance2 - fSqrt) / Math.min(fDistance2, fSqrt)) >= 0.1f) {
                                        arrayList = arrayList4;
                                    } else {
                                        arrayList = arrayList4;
                                        arrayList.add(finderPatternArr);
                                    }
                                }
                                i4++;
                                arrayList3 = arrayList;
                                c2 = c3;
                                c5 = c4;
                                i = 3;
                                c6 = 1;
                                f2 = 0.5f;
                                f3 = DIFF_MODSIZE_CUTOFF_PERCENT;
                            } else {
                                c3 = c2;
                                c4 = c5;
                            }
                            arrayList = arrayList3;
                            i4++;
                            arrayList3 = arrayList;
                            c2 = c3;
                            c5 = c4;
                            i = 3;
                            c6 = 1;
                            f2 = 0.5f;
                            f3 = DIFF_MODSIZE_CUTOFF_PERCENT;
                        }
                        c3 = c2;
                        c4 = c5;
                    } else {
                        c3 = c2;
                        c4 = c5;
                    }
                    i3++;
                    arrayList3 = arrayList3;
                    c2 = c3;
                    c5 = c4;
                    i = 3;
                    c6 = 1;
                }
            }
            i2++;
            arrayList3 = arrayList3;
            c2 = c2;
            c5 = c5;
            i = 3;
            c6 = 1;
        }
        ArrayList arrayList5 = arrayList3;
        if (!arrayList5.isEmpty()) {
            return (FinderPattern[][]) arrayList5.toArray(EMPTY_FP_2D_ARRAY);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public FinderPatternInfo[] findMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i = (height * 3) / 388;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        for (int i2 = i - 1; i2 < height; i2 += i) {
            doClearCounts(iArr);
            int i3 = 0;
            for (int i4 = 0; i4 < width; i4++) {
                if (image.get(i4, i2)) {
                    if ((i3 & 1) == 1) {
                        i3++;
                    }
                    iArr[i3] = iArr[i3] + 1;
                } else if ((i3 & 1) != 0) {
                    iArr[i3] = iArr[i3] + 1;
                } else if (i3 == 4) {
                    if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i4)) {
                        doClearCounts(iArr);
                        i3 = 0;
                    } else {
                        doShiftCounts2(iArr);
                        i3 = 3;
                    }
                } else {
                    i3++;
                    iArr[i3] = iArr[i3] + 1;
                }
            }
            if (foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i2, width);
            }
        }
        FinderPattern[][] finderPatternArrSelectMultipleBestPatterns = selectMultipleBestPatterns();
        ArrayList arrayList = new ArrayList();
        for (FinderPattern[] finderPatternArr : finderPatternArrSelectMultipleBestPatterns) {
            ResultPoint.orderBestPatterns(finderPatternArr);
            arrayList.add(new FinderPatternInfo(finderPatternArr));
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        return (FinderPatternInfo[]) arrayList.toArray(EMPTY_RESULT_ARRAY);
    }
}
