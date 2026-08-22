package qr_core;

/* JADX INFO: loaded from: classes2.dex */
public final class InvertedLuminanceSource extends LuminanceSource {
    private final LuminanceSource delegate;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        this.delegate = luminanceSource;
    }

    @Override // qr_core.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        byte[] row = this.delegate.getRow(i, bArr);
        int width = getWidth();
        for (int i2 = 0; i2 < width; i2++) {
            row[i2] = (byte) (255 - (row[i2] & 255));
        }
        return row;
    }

    @Override // qr_core.LuminanceSource
    public byte[] getMatrix() {
        byte[] matrix = this.delegate.getMatrix();
        int width = getWidth() * getHeight();
        byte[] bArr = new byte[width];
        for (int i = 0; i < width; i++) {
            bArr[i] = (byte) (255 - (matrix[i] & 255));
        }
        return bArr;
    }

    @Override // qr_core.LuminanceSource
    public boolean isCropSupported() {
        return this.delegate.isCropSupported();
    }

    @Override // qr_core.LuminanceSource
    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new InvertedLuminanceSource(this.delegate.crop(i, i2, i3, i4));
    }

    @Override // qr_core.LuminanceSource
    public boolean isRotateSupported() {
        return this.delegate.isRotateSupported();
    }

    @Override // qr_core.LuminanceSource
    public LuminanceSource invert() {
        return this.delegate;
    }

    @Override // qr_core.LuminanceSource
    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
    }

    @Override // qr_core.LuminanceSource
    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
    }
}
