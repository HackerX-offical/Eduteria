package com.facebook.network.connectionclass;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes7.dex */
class ByteArrayScanner {
    private int mCurrentOffset;

    @Nullable
    private byte[] mData;
    private char mDelimiter;
    private boolean mDelimiterSet;
    private int mTotalLength;

    ByteArrayScanner() {
    }

    public ByteArrayScanner reset(byte[] bArr, int i) {
        this.mData = bArr;
        this.mCurrentOffset = 0;
        this.mTotalLength = i;
        this.mDelimiterSet = false;
        return this;
    }

    public ByteArrayScanner useDelimiter(char c2) {
        throwIfNotReset();
        this.mDelimiter = c2;
        this.mDelimiterSet = true;
        return this;
    }

    private void throwIfNotReset() {
        if (this.mData == null) {
            throw new IllegalStateException("Must call reset first");
        }
    }

    private void throwIfDelimiterNotSet() {
        if (!this.mDelimiterSet) {
            throw new IllegalStateException("Must call useDelimiter first");
        }
    }

    public String nextString() throws NoSuchElementException {
        throwIfNotReset();
        throwIfDelimiterNotSet();
        return new String(this.mData, this.mCurrentOffset, advance());
    }

    public boolean nextStringEquals(String str) throws NoSuchElementException {
        int i = this.mCurrentOffset;
        if (str.length() != advance()) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != this.mData[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int nextInt() throws NoSuchElementException {
        throwIfNotReset();
        throwIfDelimiterNotSet();
        int i = this.mCurrentOffset;
        return parseInt(this.mData, i, advance() + i);
    }

    public void skip() throws NoSuchElementException {
        throwIfNotReset();
        throwIfDelimiterNotSet();
        advance();
    }

    private int advance() throws NoSuchElementException {
        throwIfNotReset();
        throwIfDelimiterNotSet();
        int i = this.mTotalLength;
        int i2 = this.mCurrentOffset;
        if (i <= i2) {
            throw new NoSuchElementException("Reading past end of input stream at " + this.mCurrentOffset + InstructionFileId.DOT);
        }
        int iIndexOf = indexOf(this.mData, i2, i, this.mDelimiter);
        if (iIndexOf == -1) {
            int i3 = this.mTotalLength;
            int i4 = i3 - this.mCurrentOffset;
            this.mCurrentOffset = i3;
            return i4;
        }
        int i5 = iIndexOf - this.mCurrentOffset;
        this.mCurrentOffset = iIndexOf + 1;
        return i5;
    }

    private static int parseInt(byte[] bArr, int i, int i2) throws NumberFormatException {
        int i3 = 0;
        while (i < i2) {
            int i4 = i + 1;
            int i5 = bArr[i] - 48;
            if (i5 < 0 || i5 > 9) {
                throw new NumberFormatException("Invalid int in buffer at " + i + InstructionFileId.DOT);
            }
            i3 = (i3 * 10) + i5;
            i = i4;
        }
        return i3;
    }

    private static int indexOf(byte[] bArr, int i, int i2, char c2) {
        while (i < i2) {
            if (bArr[i] == c2) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
