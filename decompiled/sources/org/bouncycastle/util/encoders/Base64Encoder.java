package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes10.dex */
public class Base64Encoder implements Encoder {
    protected final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    protected byte padding = kotlin.io.encoding.Base64.padSymbol;
    protected final byte[] decodingTable = new byte[128];

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c2, char c3, char c4, char c5) throws IOException {
        char c6 = this.padding;
        if (c4 == c6) {
            if (c5 != c6) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            byte[] bArr = this.decodingTable;
            byte b2 = bArr[c2];
            byte b3 = bArr[c3];
            if ((b2 | b3) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b2 << 2) | (b3 >> 4));
            return 1;
        }
        if (c5 == c6) {
            byte[] bArr2 = this.decodingTable;
            byte b4 = bArr2[c2];
            byte b5 = bArr2[c3];
            byte b6 = bArr2[c4];
            if ((b4 | b5 | b6) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b4 << 2) | (b5 >> 4));
            outputStream.write((b5 << 4) | (b6 >> 2));
            return 2;
        }
        byte[] bArr3 = this.decodingTable;
        byte b7 = bArr3[c2];
        byte b8 = bArr3[c3];
        byte b9 = bArr3[c4];
        byte b10 = bArr3[c5];
        if ((b7 | b8 | b9 | b10) < 0) {
            throw new IOException("invalid characters encountered at end of base64 data");
        }
        outputStream.write((b7 << 2) | (b8 >> 4));
        outputStream.write((b8 << 4) | (b9 >> 2));
        outputStream.write((b9 << 6) | b10);
        return 3;
    }

    private boolean ignore(char c2) {
        return c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == ' ';
    }

    private int nextI(String str, int i, int i2) {
        while (i < i2 && ignore(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private int nextI(byte[] bArr, int i, int i2) {
        while (i < i2 && ignore((char) bArr[i])) {
            i++;
        }
        return i;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        if (length == 0) {
            return 0;
        }
        int i2 = length;
        int i3 = 0;
        while (i2 > 0 && i3 != 4) {
            if (!ignore(str.charAt(i2 - 1))) {
                i3++;
            }
            i2--;
        }
        int iNextI = nextI(str, 0, i2);
        while (iNextI < i2) {
            int i4 = iNextI + 1;
            byte b2 = this.decodingTable[str.charAt(iNextI)];
            int iNextI2 = nextI(str, i4, i2);
            int i5 = iNextI2 + 1;
            byte b3 = this.decodingTable[str.charAt(iNextI2)];
            int iNextI3 = nextI(str, i5, i2);
            int i6 = iNextI3 + 1;
            byte b4 = this.decodingTable[str.charAt(iNextI3)];
            int iNextI4 = nextI(str, i6, i2);
            int i7 = iNextI4 + 1;
            byte b5 = this.decodingTable[str.charAt(iNextI4)];
            if ((b2 | b3 | b4 | b5) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            outputStream.write((b2 << 2) | (b3 >> 4));
            outputStream.write((b3 << 4) | (b4 >> 2));
            outputStream.write((b4 << 6) | b5);
            i += 3;
            iNextI = nextI(str, i7, i2);
        }
        int iNextI5 = nextI(str, iNextI, length);
        int iNextI6 = nextI(str, iNextI5 + 1, length);
        int iNextI7 = nextI(str, iNextI6 + 1, length);
        return i + decodeLastBlock(outputStream, str.charAt(iNextI5), str.charAt(iNextI6), str.charAt(iNextI7), str.charAt(nextI(str, iNextI7 + 1, length)));
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3 = i2 + i;
        while (i3 > i && ignore((char) bArr[i3 - 1])) {
            i3--;
        }
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        int i5 = i3;
        int i6 = 0;
        while (i5 > i && i6 != 4) {
            if (!ignore((char) bArr[i5 - 1])) {
                i6++;
            }
            i5--;
        }
        int iNextI = nextI(bArr, i, i5);
        while (iNextI < i5) {
            int i7 = iNextI + 1;
            byte b2 = this.decodingTable[bArr[iNextI]];
            int iNextI2 = nextI(bArr, i7, i5);
            int i8 = iNextI2 + 1;
            byte b3 = this.decodingTable[bArr[iNextI2]];
            int iNextI3 = nextI(bArr, i8, i5);
            int i9 = iNextI3 + 1;
            byte b4 = this.decodingTable[bArr[iNextI3]];
            int iNextI4 = nextI(bArr, i9, i5);
            int i10 = iNextI4 + 1;
            byte b5 = this.decodingTable[bArr[iNextI4]];
            if ((b2 | b3 | b4 | b5) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            outputStream.write((b2 << 2) | (b3 >> 4));
            outputStream.write((b3 << 4) | (b4 >> 2));
            outputStream.write((b4 << 6) | b5);
            i4 += 3;
            iNextI = nextI(bArr, i10, i5);
        }
        int iNextI5 = nextI(bArr, iNextI, i3);
        int iNextI6 = nextI(bArr, iNextI5 + 1, i3);
        int iNextI7 = nextI(bArr, iNextI6 + 1, i3);
        return i4 + decodeLastBlock(outputStream, (char) bArr[iNextI5], (char) bArr[iNextI6], (char) bArr[iNextI7], (char) bArr[nextI(bArr, iNextI7 + 1, i3)]);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a3  */
    @Override // org.bouncycastle.util.encoders.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int encode(byte[] r11, int r12, int r13, java.io.OutputStream r14) throws java.io.IOException {
        /*
            r10 = this;
            int r0 = r13 % 3
            int r13 = r13 - r0
            r1 = r12
        L4:
            int r2 = r12 + r13
            r3 = 4
            r4 = 2
            if (r1 >= r2) goto L4c
            r2 = r11[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r5 = r1 + 1
            r5 = r11[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r1 + 2
            r6 = r11[r6]
            r7 = r6 & 255(0xff, float:3.57E-43)
            byte[] r8 = r10.encodingTable
            int r9 = r2 >>> 2
            r9 = r9 & 63
            r8 = r8[r9]
            r14.write(r8)
            byte[] r8 = r10.encodingTable
            int r2 = r2 << r3
            int r3 = r5 >>> 4
            r2 = r2 | r3
            r2 = r2 & 63
            r2 = r8[r2]
            r14.write(r2)
            byte[] r2 = r10.encodingTable
            int r3 = r5 << 2
            int r4 = r7 >>> 6
            r3 = r3 | r4
            r3 = r3 & 63
            r2 = r2[r3]
            r14.write(r2)
            byte[] r2 = r10.encodingTable
            r3 = r6 & 63
            r2 = r2[r3]
            r14.write(r2)
            int r1 = r1 + 3
            goto L4
        L4c:
            r12 = 1
            if (r0 == r12) goto L7b
            if (r0 == r4) goto L52
            goto L9e
        L52:
            r1 = r11[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r2 = r2 + r12
            r11 = r11[r2]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r12 = r1 >>> 2
            r12 = r12 & 63
            int r1 = r1 << r3
            int r2 = r11 >>> 4
            r1 = r1 | r2
            r1 = r1 & 63
            int r11 = r11 << r4
            r11 = r11 & 63
            byte[] r2 = r10.encodingTable
            r12 = r2[r12]
            r14.write(r12)
            byte[] r12 = r10.encodingTable
            r12 = r12[r1]
            r14.write(r12)
            byte[] r12 = r10.encodingTable
            r11 = r12[r11]
            goto L96
        L7b:
            r11 = r11[r2]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r12 = r11 >>> 2
            r12 = r12 & 63
            int r11 = r11 << r3
            r11 = r11 & 63
            byte[] r1 = r10.encodingTable
            r12 = r1[r12]
            r14.write(r12)
            byte[] r12 = r10.encodingTable
            r11 = r12[r11]
            r14.write(r11)
            byte r11 = r10.padding
        L96:
            r14.write(r11)
            byte r11 = r10.padding
            r14.write(r11)
        L9e:
            int r13 = r13 / 3
            int r13 = r13 * r3
            if (r0 != 0) goto La4
            r3 = 0
        La4:
            int r13 = r13 + r3
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.util.encoders.Base64Encoder.encode(byte[], int, int, java.io.OutputStream):int");
    }

    protected void initialiseDecodingTable() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i >= bArr2.length) {
                return;
            }
            this.decodingTable[bArr2[i]] = (byte) i;
            i++;
        }
    }
}
