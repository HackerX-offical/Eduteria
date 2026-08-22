package qr_core;

import java.util.Map;
import qr_core.common.BitMatrix;

/* JADX INFO: loaded from: classes2.dex */
public interface Writer {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException;

    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException;
}
