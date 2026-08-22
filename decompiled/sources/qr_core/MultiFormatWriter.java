package qr_core;

import java.util.Map;
import qr_core.common.BitMatrix;
import qr_core.qrcode.QRCodeWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiFormatWriter implements Writer {
    @Override // qr_core.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    /* JADX INFO: renamed from: qr_core.MultiFormatWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$qr_core$BarcodeFormat;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            $SwitchMap$qr_core$BarcodeFormat = iArr;
            try {
                iArr[BarcodeFormat.QR_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // qr_core.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (AnonymousClass1.$SwitchMap$qr_core$BarcodeFormat[barcodeFormat.ordinal()] != 1) {
            throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return new QRCodeWriter().encode(str, barcodeFormat, i, i2, map);
    }
}
