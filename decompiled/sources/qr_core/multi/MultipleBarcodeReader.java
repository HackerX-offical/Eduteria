package qr_core.multi;

import java.util.Map;
import qr_core.BinaryBitmap;
import qr_core.DecodeHintType;
import qr_core.NotFoundException;
import qr_core.Result;

/* JADX INFO: loaded from: classes2.dex */
public interface MultipleBarcodeReader {
    Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException;

    Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException;
}
