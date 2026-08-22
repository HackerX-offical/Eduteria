package qr_core.multi.qrcode.detector;

import java.util.ArrayList;
import java.util.Map;
import qr_core.DecodeHintType;
import qr_core.NotFoundException;
import qr_core.ReaderException;
import qr_core.ResultPointCallback;
import qr_core.common.BitMatrix;
import qr_core.common.DetectorResult;
import qr_core.qrcode.detector.Detector;
import qr_core.qrcode.detector.FinderPatternInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiDetector extends Detector {
    private static final DetectorResult[] EMPTY_DETECTOR_RESULTS = new DetectorResult[0];

    public MultiDetector(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    public DetectorResult[] detectMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        FinderPatternInfo[] finderPatternInfoArrFindMulti = new MultiFinderPatternFinder(getImage(), map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)).findMulti(map);
        if (finderPatternInfoArrFindMulti.length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (FinderPatternInfo finderPatternInfo : finderPatternInfoArrFindMulti) {
            try {
                arrayList.add(processFinderPatternInfo(finderPatternInfo));
            } catch (ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return EMPTY_DETECTOR_RESULTS;
        }
        return (DetectorResult[]) arrayList.toArray(EMPTY_DETECTOR_RESULTS);
    }
}
