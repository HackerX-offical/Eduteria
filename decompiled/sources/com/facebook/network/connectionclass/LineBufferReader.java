package com.facebook.network.connectionclass;

import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
class LineBufferReader {
    private int mBytesInBuffer;
    private int mFileBufIndex;
    private byte[] mFileBuffer = new byte[512];
    private FileInputStream mInputStream;

    public void setFileStream(FileInputStream fileInputStream) {
        this.mInputStream = fileInputStream;
        this.mBytesInBuffer = 0;
        this.mFileBufIndex = 0;
    }

    public int readLine(byte[] bArr) throws IOException {
        int i;
        byte[] bArr2;
        int i2;
        byte b2;
        if (this.mFileBufIndex >= this.mBytesInBuffer) {
            this.mBytesInBuffer = this.mInputStream.read(this.mFileBuffer);
            this.mFileBufIndex = 0;
        }
        int i3 = 0;
        while (true) {
            i = this.mBytesInBuffer;
            if (i == -1 || i3 >= bArr.length || (b2 = (bArr2 = this.mFileBuffer)[(i2 = this.mFileBufIndex)]) == 10) {
                break;
            }
            bArr[i3] = b2;
            int i4 = i2 + 1;
            this.mFileBufIndex = i4;
            if (i4 >= i) {
                this.mBytesInBuffer = this.mInputStream.read(bArr2);
                this.mFileBufIndex = 0;
            }
            i3++;
        }
        this.mFileBufIndex++;
        if (i == -1) {
            return -1;
        }
        return i3;
    }

    public void skipLine() throws IOException {
        if (this.mFileBufIndex >= this.mBytesInBuffer) {
            this.mBytesInBuffer = this.mInputStream.read(this.mFileBuffer);
            this.mFileBufIndex = 0;
        }
        while (true) {
            int i = this.mBytesInBuffer;
            if (i == -1) {
                break;
            }
            byte[] bArr = this.mFileBuffer;
            int i2 = this.mFileBufIndex;
            if (bArr[i2] == 10) {
                break;
            }
            int i3 = i2 + 1;
            this.mFileBufIndex = i3;
            if (i3 >= i) {
                this.mBytesInBuffer = this.mInputStream.read(bArr);
                this.mFileBufIndex = 0;
            }
        }
        this.mFileBufIndex++;
    }
}
