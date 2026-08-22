package qr_core;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface Reader {
    Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException, ChecksumException;

    Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException;

    void reset();
}
