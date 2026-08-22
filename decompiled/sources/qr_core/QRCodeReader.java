package qr_core;

import java.util.List;
import java.util.Map;
import qr_core.common.BitMatrix;
import qr_core.common.DecoderResult;
import qr_core.common.DetectorResult;
import qr_core.qrcode.decoder.Decoder;
import qr_core.qrcode.decoder.QRCodeDecoderMetaData;
import qr_core.qrcode.detector.Detector;

/* JADX INFO: loaded from: classes2.dex */
public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    @Override // qr_core.Reader
    public void reset() {
    }

    protected final Decoder getDecoder() {
        return this.decoder;
    }

    @Override // qr_core.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException, ChecksumException {
        return decode(binaryBitmap, null);
    }

    @Override // qr_core.Reader
    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        ResultPoint[] points;
        DecoderResult decoderResultDecode;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            decoderResultDecode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            points = NO_POINTS;
        } else {
            DetectorResult detectorResultDetect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            DecoderResult decoderResultDecode2 = this.decoder.decode(detectorResultDetect.getBits(), map);
            points = detectorResultDetect.getPoints();
            decoderResultDecode = decoderResultDecode2;
        }
        if (decoderResultDecode.getOther() instanceof QRCodeDecoderMetaData) {
            ((QRCodeDecoderMetaData) decoderResultDecode.getOther()).applyMirroredCorrection(points);
        }
        Result result = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points, BarcodeFormat.QR_CODE);
        List<byte[]> byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decoderResultDecode.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResultDecode.getStructuredAppendSequenceNumber()));
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResultDecode.getStructuredAppendParity()));
        }
        result.putMetadata(ResultMetadataType.ERRORS_CORRECTED, decoderResultDecode.getErrorsCorrected());
        result.putMetadata(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]Q" + decoderResultDecode.getSymbologyModifier());
        return result;
    }

    private static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fModuleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = bottomRightOnBit[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3 && (i4 = i3 + i5) >= bitMatrix.getWidth()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iRound = Math.round(((i4 - i3) + 1) / fModuleSize);
        int iRound2 = Math.round((i5 + 1) / fModuleSize);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = (int) (fModuleSize / 2.0f);
        int i7 = i + i6;
        int i8 = i3 + i6;
        int i9 = (((int) ((iRound - 1) * fModuleSize)) + i8) - i4;
        if (i9 > 0) {
            if (i9 > i6) {
                throw NotFoundException.getNotFoundInstance();
            }
            i8 -= i9;
        }
        int i10 = (((int) ((iRound2 - 1) * fModuleSize)) + i7) - i2;
        if (i10 > 0) {
            if (i10 > i6) {
                throw NotFoundException.getNotFoundInstance();
            }
            i7 -= i10;
        }
        BitMatrix bitMatrix2 = new BitMatrix(iRound, iRound2);
        for (int i11 = 0; i11 < iRound2; i11++) {
            int i12 = ((int) (i11 * fModuleSize)) + i7;
            for (int i13 = 0; i13 < iRound; i13++) {
                if (bitMatrix.get(((int) (i13 * fModuleSize)) + i8, i12)) {
                    bitMatrix2.set(i13, i11);
                }
            }
        }
        return bitMatrix2;
    }

    private static float moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < width && i2 < height) {
            if (z != bitMatrix.get(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i == width || i2 == height) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i - iArr[0]) / 7.0f;
    }
}
