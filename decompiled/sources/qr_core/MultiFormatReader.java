package qr_core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiFormatReader implements Reader {
    private static final Reader[] EMPTY_READER_ARRAY = new Reader[0];
    private Map<DecodeHintType, ?> hints;
    private Reader[] readers;

    @Override // qr_core.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException {
        setHints(null);
        return decodeInternal(binaryBitmap);
    }

    @Override // qr_core.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        setHints(map);
        return decodeInternal(binaryBitmap);
    }

    public Result decodeWithState(BinaryBitmap binaryBitmap) throws NotFoundException {
        if (this.readers == null) {
            setHints(null);
        }
        return decodeInternal(binaryBitmap);
    }

    public void setHints(Map<DecodeHintType, ?> map) {
        this.hints = map;
        if (map != null) {
            map.containsKey(DecodeHintType.TRY_HARDER);
        }
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null && collection.contains(BarcodeFormat.QR_CODE)) {
            arrayList.add(new QRCodeReader());
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new QRCodeReader());
        }
        this.readers = (Reader[]) arrayList.toArray(EMPTY_READER_ARRAY);
    }

    @Override // qr_core.Reader
    public void reset() {
        Reader[] readerArr = this.readers;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                reader.reset();
            }
        }
    }

    private Result decodeInternal(BinaryBitmap binaryBitmap) throws NotFoundException {
        Reader[] readerArr = this.readers;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                if (Thread.currentThread().isInterrupted()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                try {
                    return reader.decode(binaryBitmap, this.hints);
                } catch (ReaderException unused) {
                }
            }
            Map<DecodeHintType, ?> map = this.hints;
            if (map != null && map.containsKey(DecodeHintType.ALSO_INVERTED)) {
                binaryBitmap.getBlackMatrix().flip();
                for (Reader reader2 : this.readers) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    try {
                        return reader2.decode(binaryBitmap, this.hints);
                    } catch (ReaderException unused2) {
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
