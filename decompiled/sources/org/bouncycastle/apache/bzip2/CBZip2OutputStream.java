package org.bouncycastle.apache.bzip2;

import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes10.dex */
public class CBZip2OutputStream extends OutputStream implements BZip2Constants {
    protected static final int CLEARMASK = -2097153;
    protected static final int DEPTH_THRESH = 10;
    protected static final int GREATER_ICOST = 15;
    protected static final int LESSER_ICOST = 0;
    protected static final int QSORT_STACK_SIZE = 1000;
    protected static final int SETMASK = 2097152;
    protected static final int SMALL_THRESH = 20;
    private int allowableBlockSize;
    private char[] block;
    private int blockCRC;
    boolean blockRandomised;
    int blockSize100k;
    int bsBuff;
    int bsLive;
    private OutputStream bsStream;
    int bytesOut;
    boolean closed;
    private int combinedCRC;
    private int currentChar;
    private boolean finished;
    private boolean firstAttempt;
    private int[] ftab;
    private boolean[] inUse;
    private int[] incs;
    int last;
    CRC mCrc;
    private int[] mtfFreq;
    private int nBlocksRandomised;
    private int nInUse;
    private int nMTF;
    int origPtr;
    private int[] quadrant;
    private int runLength;
    private char[] selector;
    private char[] selectorMtf;
    private char[] seqToUnseq;
    private short[] szptr;
    private char[] unseqToSeq;
    private int workDone;
    private int workFactor;
    private int workLimit;
    private int[] zptr;

    private static class StackElem {
        int dd;
        int hh;
        int ll;

        private StackElem() {
        }
    }

    public CBZip2OutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 9);
    }

    public CBZip2OutputStream(OutputStream outputStream, int i) throws IOException {
        this.mCrc = new CRC();
        this.inUse = new boolean[256];
        this.seqToUnseq = new char[256];
        this.unseqToSeq = new char[256];
        this.selector = new char[BZip2Constants.MAX_SELECTORS];
        this.selectorMtf = new char[BZip2Constants.MAX_SELECTORS];
        this.mtfFreq = new int[BZip2Constants.MAX_ALPHA_SIZE];
        this.currentChar = -1;
        this.runLength = 0;
        this.closed = false;
        this.incs = new int[]{1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
        this.block = null;
        this.quadrant = null;
        this.zptr = null;
        this.ftab = null;
        outputStream.write(66);
        outputStream.write(90);
        bsSetStream(outputStream);
        this.workFactor = 50;
        i = i > 9 ? 9 : i;
        this.blockSize100k = i < 1 ? 1 : i;
        allocateCompressStructures();
        initialize();
        initBlock();
    }

    private void allocateCompressStructures() {
        int i = this.blockSize100k;
        int i2 = 100000 * i;
        this.block = new char[i2 + 21];
        this.quadrant = new int[i2 + 20];
        this.zptr = new int[i2];
        this.ftab = new int[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY];
        this.szptr = new short[i * 200000];
    }

    private void bsFinishedWithStream() throws IOException {
        while (this.bsLive > 0) {
            this.bsStream.write(this.bsBuff >> 24);
            this.bsBuff <<= 8;
            this.bsLive -= 8;
            this.bytesOut++;
        }
    }

    private void bsPutIntVS(int i, int i2) throws IOException {
        bsW(i, i2);
    }

    private void bsPutUChar(int i) throws IOException {
        bsW(8, i);
    }

    private void bsPutint(int i) throws IOException {
        bsW(8, (i >> 24) & 255);
        bsW(8, (i >> 16) & 255);
        bsW(8, (i >> 8) & 255);
        bsW(8, i & 255);
    }

    private void bsSetStream(OutputStream outputStream) {
        this.bsStream = outputStream;
        this.bsLive = 0;
        this.bsBuff = 0;
        this.bytesOut = 0;
    }

    private void bsW(int i, int i2) throws IOException {
        while (true) {
            int i3 = this.bsLive;
            if (i3 < 8) {
                this.bsBuff = (i2 << ((32 - i3) - i)) | this.bsBuff;
                this.bsLive = i3 + i;
                return;
            } else {
                this.bsStream.write(this.bsBuff >> 24);
                this.bsBuff <<= 8;
                this.bsLive -= 8;
                this.bytesOut++;
            }
        }
    }

    private void doReversibleTransformation() {
        this.workLimit = this.workFactor * this.last;
        int i = 0;
        this.workDone = 0;
        this.blockRandomised = false;
        this.firstAttempt = true;
        mainSort();
        if (this.workDone > this.workLimit && this.firstAttempt) {
            randomiseBlock();
            this.workDone = 0;
            this.workLimit = 0;
            this.blockRandomised = true;
            this.firstAttempt = false;
            mainSort();
        }
        this.origPtr = -1;
        while (true) {
            if (i > this.last) {
                break;
            }
            if (this.zptr[i] == 0) {
                this.origPtr = i;
                break;
            }
            i++;
        }
        if (this.origPtr == -1) {
            panic();
        }
    }

    private void endBlock() throws IOException {
        int finalCRC = this.mCrc.getFinalCRC();
        this.blockCRC = finalCRC;
        int i = this.combinedCRC;
        this.combinedCRC = finalCRC ^ ((i >>> 31) | (i << 1));
        doReversibleTransformation();
        bsPutUChar(49);
        bsPutUChar(65);
        bsPutUChar(89);
        bsPutUChar(38);
        bsPutUChar(83);
        bsPutUChar(89);
        bsPutint(this.blockCRC);
        if (this.blockRandomised) {
            bsW(1, 1);
            this.nBlocksRandomised++;
        } else {
            bsW(1, 0);
        }
        moveToFrontCodeAndSend();
    }

    private void endCompression() throws IOException {
        bsPutUChar(23);
        bsPutUChar(114);
        bsPutUChar(69);
        bsPutUChar(56);
        bsPutUChar(80);
        bsPutUChar(144);
        bsPutint(this.combinedCRC);
        bsFinishedWithStream();
    }

    private boolean fullGtU(int i, int i2) {
        char[] cArr = this.block;
        char c2 = cArr[i + 1];
        char c3 = cArr[i2 + 1];
        if (c2 != c3) {
            return c2 > c3;
        }
        char c4 = cArr[i + 2];
        char c5 = cArr[i2 + 2];
        if (c4 != c5) {
            return c4 > c5;
        }
        char c6 = cArr[i + 3];
        char c7 = cArr[i2 + 3];
        if (c6 != c7) {
            return c6 > c7;
        }
        char c8 = cArr[i + 4];
        char c9 = cArr[i2 + 4];
        if (c8 != c9) {
            return c8 > c9;
        }
        char c10 = cArr[i + 5];
        char c11 = cArr[i2 + 5];
        if (c10 != c11) {
            return c10 > c11;
        }
        int i3 = i + 6;
        char c12 = cArr[i3];
        int i4 = i2 + 6;
        char c13 = cArr[i4];
        if (c12 != c13) {
            return c12 > c13;
        }
        int i5 = this.last + 1;
        do {
            char[] cArr2 = this.block;
            int i6 = i3 + 1;
            char c14 = cArr2[i6];
            int i7 = i4 + 1;
            char c15 = cArr2[i7];
            if (c14 != c15) {
                return c14 > c15;
            }
            int[] iArr = this.quadrant;
            int i8 = iArr[i3];
            int i9 = iArr[i4];
            if (i8 != i9) {
                return i8 > i9;
            }
            int i10 = i3 + 2;
            char c16 = cArr2[i10];
            int i11 = i4 + 2;
            char c17 = cArr2[i11];
            if (c16 != c17) {
                return c16 > c17;
            }
            int i12 = iArr[i6];
            int i13 = iArr[i7];
            if (i12 != i13) {
                return i12 > i13;
            }
            int i14 = i3 + 3;
            char c18 = cArr2[i14];
            int i15 = i4 + 3;
            char c19 = cArr2[i15];
            if (c18 != c19) {
                return c18 > c19;
            }
            int i16 = iArr[i10];
            int i17 = iArr[i11];
            if (i16 != i17) {
                return i16 > i17;
            }
            i3 += 4;
            char c20 = cArr2[i3];
            i4 += 4;
            char c21 = cArr2[i4];
            if (c20 != c21) {
                return c20 > c21;
            }
            int i18 = iArr[i14];
            int i19 = iArr[i15];
            if (i18 != i19) {
                return i18 > i19;
            }
            int i20 = this.last;
            if (i3 > i20) {
                i3 = (i3 - i20) - 1;
            }
            if (i4 > i20) {
                i4 = (i4 - i20) - 1;
            }
            i5 -= 4;
            this.workDone++;
        } while (i5 >= 0);
        return false;
    }

    private void generateMTFValues() {
        char[] cArr = new char[256];
        makeMaps();
        int i = this.nInUse + 1;
        for (int i2 = 0; i2 <= i; i2++) {
            this.mtfFreq[i2] = 0;
        }
        for (int i3 = 0; i3 < this.nInUse; i3++) {
            cArr[i3] = (char) i3;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 <= this.last; i6++) {
            char c2 = this.unseqToSeq[this.block[this.zptr[i6]]];
            char c3 = cArr[0];
            int i7 = 0;
            while (c2 != c3) {
                i7++;
                char c4 = cArr[i7];
                cArr[i7] = c3;
                c3 = c4;
            }
            cArr[0] = c3;
            if (i7 == 0) {
                i4++;
            } else {
                if (i4 > 0) {
                    int i8 = i4 - 1;
                    while (true) {
                        int i9 = i8 % 2;
                        if (i9 == 0) {
                            this.szptr[i5] = 0;
                            i5++;
                            int[] iArr = this.mtfFreq;
                            iArr[0] = iArr[0] + 1;
                        } else if (i9 == 1) {
                            this.szptr[i5] = 1;
                            i5++;
                            int[] iArr2 = this.mtfFreq;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i8 < 2) {
                            break;
                        } else {
                            i8 = (i8 - 2) / 2;
                        }
                    }
                    i4 = 0;
                }
                int i10 = i7 + 1;
                this.szptr[i5] = (short) i10;
                i5++;
                int[] iArr3 = this.mtfFreq;
                iArr3[i10] = iArr3[i10] + 1;
            }
        }
        if (i4 > 0) {
            int i11 = i4 - 1;
            while (true) {
                int i12 = i11 % 2;
                if (i12 == 0) {
                    this.szptr[i5] = 0;
                    i5++;
                    int[] iArr4 = this.mtfFreq;
                    iArr4[0] = iArr4[0] + 1;
                } else if (i12 == 1) {
                    this.szptr[i5] = 1;
                    i5++;
                    int[] iArr5 = this.mtfFreq;
                    iArr5[1] = iArr5[1] + 1;
                }
                if (i11 < 2) {
                    break;
                } else {
                    i11 = (i11 - 2) / 2;
                }
            }
        }
        this.szptr[i5] = (short) i;
        int[] iArr6 = this.mtfFreq;
        iArr6[i] = iArr6[i] + 1;
        this.nMTF = i5 + 1;
    }

    private void hbAssignCodes(int[] iArr, char[] cArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i <= i2) {
            for (int i5 = 0; i5 < i3; i5++) {
                if (cArr[i5] == i) {
                    iArr[i5] = i4;
                    i4++;
                }
            }
            i4 <<= 1;
            i++;
        }
    }

    protected static void hbMakeCodeLengths(char[] cArr, int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 260;
        int[] iArr2 = new int[260];
        int[] iArr3 = new int[516];
        int[] iArr4 = new int[516];
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i3 = 1;
            if (i9 >= i) {
                break;
            }
            int i10 = i9 + 1;
            int i11 = iArr[i9];
            if (i11 != 0) {
                i3 = i11;
            }
            iArr3[i10] = i3 << 8;
            i9 = i10;
        }
        while (true) {
            iArr2[i8] = i8;
            iArr3[i8] = i8;
            iArr4[i8] = -2;
            int i12 = i8;
            int i13 = i3;
            while (true) {
                i4 = -1;
                if (i13 > i) {
                    break;
                }
                iArr4[i13] = -1;
                i12++;
                iArr2[i12] = i13;
                int i14 = i12;
                while (true) {
                    int i15 = iArr3[i13];
                    int i16 = i14 >> 1;
                    int i17 = iArr2[i16];
                    if (i15 < iArr3[i17]) {
                        iArr2[i14] = i17;
                        i14 = i16;
                    }
                }
                iArr2[i14] = i13;
                i13++;
            }
            if (i12 >= i7) {
                panic();
            }
            int i18 = i;
            while (i12 > i3) {
                int i19 = iArr2[i3];
                int i20 = iArr2[i12];
                iArr2[i3] = i20;
                int i21 = i12 - 1;
                int i22 = i3;
                while (true) {
                    int i23 = i22 << 1;
                    if (i23 > i21) {
                        i5 = i3;
                        break;
                    }
                    if (i23 < i21) {
                        int i24 = i23 + 1;
                        if (iArr3[iArr2[i24]] < iArr3[iArr2[i23]]) {
                            i23 = i24;
                        }
                    }
                    int i25 = iArr3[i20];
                    int i26 = iArr2[i23];
                    i5 = i3;
                    if (i25 < iArr3[i26]) {
                        break;
                    }
                    iArr2[i22] = i26;
                    i22 = i23;
                    i3 = i5;
                }
                iArr2[i22] = i20;
                int i27 = iArr2[i5];
                int i28 = iArr2[i21];
                iArr2[i5] = i28;
                int i29 = i12 - 2;
                int i30 = i5;
                while (true) {
                    int i31 = i30 << 1;
                    if (i31 > i29) {
                        i6 = i4;
                        break;
                    }
                    if (i31 < i29) {
                        int i32 = i31 + 1;
                        i6 = i4;
                        if (iArr3[iArr2[i32]] < iArr3[iArr2[i31]]) {
                            i31 = i32;
                        }
                    } else {
                        i6 = i4;
                    }
                    int i33 = iArr3[i28];
                    int i34 = iArr2[i31];
                    if (i33 < iArr3[i34]) {
                        break;
                    }
                    iArr2[i30] = i34;
                    i4 = i6;
                    i30 = i31;
                }
                iArr2[i30] = i28;
                i18++;
                iArr4[i27] = i18;
                iArr4[i19] = i18;
                int i35 = iArr3[i19];
                int i36 = iArr3[i27];
                iArr3[i18] = (((i35 & 255) > (i36 & 255) ? i35 & 255 : i36 & 255) + 1) | ((i35 & (-256)) + (i36 & (-256)));
                iArr4[i18] = i6;
                i12--;
                iArr2[i12] = i18;
                int i37 = i12;
                while (true) {
                    int i38 = iArr3[i18];
                    int i39 = i37 >> 1;
                    int i40 = iArr2[i39];
                    if (i38 < iArr3[i40]) {
                        iArr2[i37] = i40;
                        i37 = i39;
                    }
                }
                iArr2[i37] = i18;
                i4 = i6;
                i3 = i5;
            }
            int i41 = i3;
            if (i18 >= 516) {
                panic();
            }
            int i42 = 0;
            for (int i43 = i41; i43 <= i; i43++) {
                int i44 = i43;
                int i45 = 0;
                while (true) {
                    i44 = iArr4[i44];
                    if (i44 < 0) {
                        break;
                    } else {
                        i45++;
                    }
                }
                cArr[i43 - 1] = (char) i45;
                if (i45 > i2) {
                    i42 = i41;
                }
            }
            if (i42 == 0) {
                return;
            }
            for (int i46 = i41; i46 < i; i46++) {
                iArr3[i46] = (((iArr3[i46] >> 8) / 2) + 1) << 8;
            }
            i3 = i41;
            i7 = 260;
            i8 = 0;
        }
    }

    private void initBlock() {
        this.mCrc.initialiseCRC();
        this.last = -1;
        for (int i = 0; i < 256; i++) {
            this.inUse[i] = false;
        }
        this.allowableBlockSize = (this.blockSize100k * 100000) - 20;
    }

    private void initialize() throws IOException {
        this.bytesOut = 0;
        this.nBlocksRandomised = 0;
        bsPutUChar(104);
        bsPutUChar(this.blockSize100k + 48);
        this.combinedCRC = 0;
    }

    private void mainSort() {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        boolean[] zArr = new boolean[256];
        int i6 = 0;
        while (true) {
            i = 2;
            i2 = 20;
            z = true;
            if (i6 >= 20) {
                break;
            }
            char[] cArr = this.block;
            int i7 = this.last;
            cArr[i7 + i6 + 2] = cArr[(i6 % (i7 + 1)) + 1];
            i6++;
        }
        int i8 = 0;
        while (true) {
            i3 = this.last;
            if (i8 > i3 + 20) {
                break;
            }
            this.quadrant[i8] = 0;
            i8++;
        }
        char[] cArr2 = this.block;
        cArr2[0] = cArr2[i3 + 1];
        if (i3 >= 4000) {
            for (int i9 = 0; i9 <= 255; i9++) {
                zArr[i9] = false;
            }
            for (int i10 = 0; i10 <= 65536; i10++) {
                this.ftab[i10] = 0;
            }
            char c2 = this.block[0];
            int i11 = 0;
            while (i11 <= this.last) {
                i11++;
                char c3 = this.block[i11];
                int[] iArr3 = this.ftab;
                int i12 = (c2 << '\b') + c3;
                iArr3[i12] = iArr3[i12] + 1;
                c2 = c3;
            }
            for (int i13 = 1; i13 <= 65536; i13++) {
                int[] iArr4 = this.ftab;
                iArr4[i13] = iArr4[i13] + iArr4[i13 - 1];
            }
            char c4 = this.block[1];
            int i14 = 0;
            while (true) {
                i4 = this.last;
                if (i14 >= i4) {
                    break;
                }
                char c5 = this.block[i14 + 2];
                int i15 = (c4 << '\b') + c5;
                int[] iArr5 = this.ftab;
                int i16 = iArr5[i15] - 1;
                iArr5[i15] = i16;
                this.zptr[i16] = i14;
                i14++;
                c4 = c5;
            }
            char[] cArr3 = this.block;
            int i17 = (cArr3[i4 + 1] << '\b') + cArr3[1];
            int[] iArr6 = this.ftab;
            int i18 = iArr6[i17] - 1;
            iArr6[i17] = i18;
            this.zptr[i18] = i4;
            for (int i19 = 0; i19 <= 255; i19++) {
                iArr[i19] = i19;
            }
            int i20 = 1;
            do {
                i20 = (i20 * 3) + 1;
            } while (i20 <= 256);
            do {
                i20 /= 3;
                for (int i21 = i20; i21 <= 255; i21++) {
                    int i22 = iArr[i21];
                    int i23 = i21;
                    do {
                        int[] iArr7 = this.ftab;
                        i5 = i23 - i20;
                        int i24 = iArr[i5];
                        if (iArr7[(i24 + 1) << 8] - iArr7[i24 << 8] > iArr7[(i22 + 1) << 8] - iArr7[i22 << 8]) {
                            iArr[i23] = i24;
                            i23 = i5;
                        }
                        iArr[i23] = i22;
                    } while (i5 > i20 - 1);
                    iArr[i23] = i22;
                }
            } while (i20 != 1);
            int i25 = 0;
            while (i25 <= 255) {
                int i26 = iArr[i25];
                int i27 = 0;
                while (i27 <= 255) {
                    int i28 = (i26 << 8) + i27;
                    int[] iArr8 = this.ftab;
                    int i29 = iArr8[i28];
                    boolean z2 = z;
                    if ((i29 & 2097152) != 2097152) {
                        int i30 = i29 & CLEARMASK;
                        int i31 = (CLEARMASK & iArr8[i28 + 1]) - 1;
                        if (i31 > i30) {
                            qSort3(i30, i31, i);
                            if (this.workDone > this.workLimit && this.firstAttempt) {
                                return;
                            }
                        }
                        int[] iArr9 = this.ftab;
                        iArr9[i28] = 2097152 | iArr9[i28];
                    }
                    i27++;
                    z = z2;
                }
                boolean z3 = z;
                zArr[i26] = z3;
                if (i25 < 255) {
                    int[] iArr10 = this.ftab;
                    int i32 = iArr10[i26 << 8] & CLEARMASK;
                    int i33 = (iArr10[(i26 + 1) << 8] & CLEARMASK) - i32;
                    int i34 = 0;
                    while ((i33 >> i34) > 65534) {
                        i34++;
                    }
                    int i35 = 0;
                    while (i35 < i33) {
                        int i36 = this.zptr[i32 + i35];
                        int i37 = i35 >> i34;
                        int[] iArr11 = this.quadrant;
                        iArr11[i36] = i37;
                        if (i36 < i2) {
                            iArr11[i36 + this.last + 1] = i37;
                        }
                        i35++;
                        i2 = 20;
                    }
                    if (((i33 - 1) >> i34) > 65535) {
                        panic();
                    }
                }
                for (int i38 = 0; i38 <= 255; i38++) {
                    iArr2[i38] = this.ftab[(i38 << 8) + i26] & CLEARMASK;
                }
                for (int i39 = this.ftab[i26 << 8] & CLEARMASK; i39 < (this.ftab[(i26 + 1) << 8] & CLEARMASK); i39++) {
                    char[] cArr4 = this.block;
                    int[] iArr12 = this.zptr;
                    int i40 = iArr12[i39];
                    char c6 = cArr4[i40];
                    if (!zArr[c6]) {
                        iArr12[iArr2[c6]] = i40 == 0 ? this.last : i40 - 1;
                        iArr2[c6] = iArr2[c6] + 1;
                    }
                }
                for (int i41 = 0; i41 <= 255; i41++) {
                    int[] iArr13 = this.ftab;
                    int i42 = (i41 << 8) + i26;
                    iArr13[i42] = iArr13[i42] | 2097152;
                }
                i25++;
                z = z3;
                i = 2;
                i2 = 20;
            }
            return;
        }
        int i43 = 0;
        while (true) {
            int i44 = this.last;
            if (i43 > i44) {
                this.firstAttempt = false;
                this.workLimit = 0;
                this.workDone = 0;
                simpleSort(0, i44, 0);
                return;
            }
            this.zptr[i43] = i43;
            i43++;
        }
    }

    private void makeMaps() {
        this.nInUse = 0;
        for (int i = 0; i < 256; i++) {
            if (this.inUse[i]) {
                char[] cArr = this.seqToUnseq;
                int i2 = this.nInUse;
                cArr[i2] = (char) i;
                this.unseqToSeq[i] = (char) i2;
                this.nInUse = i2 + 1;
            }
        }
    }

    private char med3(char c2, char c3, char c4) {
        if (c2 <= c3) {
            c3 = c2;
            c2 = c3;
        }
        if (c2 <= c4) {
            c4 = c2;
        }
        return c3 > c4 ? c3 : c4;
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsPutIntVS(24, this.origPtr);
        generateMTFValues();
        sendMTFValues();
    }

    private static void panic() {
        System.out.println("panic");
    }

    private void qSort3(int i, int i2, int i3) {
        StackElem[] stackElemArr = new StackElem[1000];
        for (int i4 = 0; i4 < 1000; i4++) {
            stackElemArr[i4] = new StackElem();
        }
        stackElemArr[0].ll = i;
        stackElemArr[0].hh = i2;
        stackElemArr[0].dd = i3;
        int i5 = 1;
        while (i5 > 0) {
            if (i5 >= 1000) {
                panic();
            }
            int i6 = i5 - 1;
            int i7 = stackElemArr[i6].ll;
            int i8 = stackElemArr[i6].hh;
            int i9 = stackElemArr[i6].dd;
            if (i8 - i7 < 20 || i9 > 10) {
                simpleSort(i7, i8, i9);
                if (this.workDone > this.workLimit && this.firstAttempt) {
                    return;
                } else {
                    i5 = i6;
                }
            } else {
                char[] cArr = this.block;
                int[] iArr = this.zptr;
                char cMed3 = med3(cArr[iArr[i7] + i9 + 1], cArr[iArr[i8] + i9 + 1], cArr[iArr[(i7 + i8) >> 1] + i9 + 1]);
                int i10 = i7;
                int i11 = i10;
                int i12 = i8;
                int i13 = i12;
                while (true) {
                    if (i10 <= i12) {
                        char[] cArr2 = this.block;
                        int[] iArr2 = this.zptr;
                        int i14 = iArr2[i10];
                        int i15 = cArr2[(i14 + i9) + 1] - cMed3;
                        if (i15 == 0) {
                            iArr2[i10] = iArr2[i11];
                            iArr2[i11] = i14;
                            i11++;
                        } else if (i15 > 0) {
                        }
                        i10++;
                    }
                    while (i10 <= i12) {
                        char[] cArr3 = this.block;
                        int[] iArr3 = this.zptr;
                        int i16 = iArr3[i12];
                        int i17 = cArr3[(i16 + i9) + 1] - cMed3;
                        if (i17 != 0) {
                            if (i17 < 0) {
                                break;
                            }
                        } else {
                            iArr3[i12] = iArr3[i13];
                            iArr3[i13] = i16;
                            i13--;
                        }
                        i12--;
                    }
                    if (i10 > i12) {
                        break;
                    }
                    int[] iArr4 = this.zptr;
                    int i18 = iArr4[i10];
                    iArr4[i10] = iArr4[i12];
                    iArr4[i12] = i18;
                    i10++;
                    i12--;
                }
                if (i13 < i11) {
                    stackElemArr[i6].ll = i7;
                    stackElemArr[i6].hh = i8;
                    stackElemArr[i6].dd = i9 + 1;
                } else {
                    int i19 = i11 - i7;
                    int i20 = i10 - i11;
                    if (i19 >= i20) {
                        i19 = i20;
                    }
                    vswap(i7, i10 - i19, i19);
                    int i21 = i8 - i13;
                    int i22 = i13 - i12;
                    if (i21 >= i22) {
                        i21 = i22;
                    }
                    vswap(i10, (i8 - i21) + 1, i21);
                    int i23 = (i10 + i7) - i11;
                    int i24 = i8 - i22;
                    stackElemArr[i6].ll = i7;
                    stackElemArr[i6].hh = i23 - 1;
                    stackElemArr[i6].dd = i9;
                    stackElemArr[i5].ll = i23;
                    stackElemArr[i5].hh = i24;
                    stackElemArr[i5].dd = i9 + 1;
                    int i25 = i5 + 1;
                    stackElemArr[i25].ll = i24 + 1;
                    stackElemArr[i25].hh = i8;
                    stackElemArr[i25].dd = i9;
                    i5 += 2;
                }
            }
        }
    }

    private void randomiseBlock() {
        for (int i = 0; i < 256; i++) {
            this.inUse[i] = false;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 <= this.last) {
            if (i3 == 0) {
                i3 = (char) rNums[i4];
                i4++;
                if (i4 == 512) {
                    i4 = 0;
                }
            }
            i3--;
            char[] cArr = this.block;
            i2++;
            char c2 = (char) (cArr[i2] ^ (i3 == 1 ? (char) 1 : (char) 0));
            cArr[i2] = c2;
            char c3 = (char) (c2 & 255);
            cArr[i2] = c3;
            this.inUse[c3] = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12, types: [int] */
    /* JADX WARN: Type inference failed for: r14v13, types: [int] */
    /* JADX WARN: Type inference failed for: r14v14, types: [int] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r31v0, types: [org.bouncycastle.apache.bzip2.CBZip2OutputStream] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [int] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    private void sendMTFValues() throws IOException {
        char c2;
        int[][] iArr;
        int i;
        char c3;
        char c4;
        int i2 = 2;
        char c5 = 1;
        ?? r8 = 0;
        int i3 = 6;
        char[][] cArr = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 6, BZip2Constants.MAX_ALPHA_SIZE);
        int i4 = this.nInUse;
        int i5 = i4 + 2;
        int i6 = 0;
        while (true) {
            c2 = 15;
            if (i6 >= 6) {
                break;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                cArr[i6][i7] = 15;
            }
            i6++;
        }
        if (this.nMTF <= 0) {
            panic();
        }
        int i8 = this.nMTF;
        char c6 = 4;
        int i9 = i8 < 200 ? 2 : i8 < 600 ? 3 : i8 < 1200 ? 4 : i8 < 2400 ? 5 : 6;
        int i10 = 0;
        int i11 = i9;
        while (i11 > 0) {
            int i12 = i8 / i11;
            ?? r14 = r8;
            char c7 = c2;
            int i13 = i10 - 1;
            ?? r82 = r8;
            while (true) {
                c4 = r82;
                if (r14 >= i12 || i13 >= i4 + 1) {
                    break;
                }
                i13++;
                r82 = c4;
                r14 += this.mtfFreq[i13];
            }
            if (i13 > i10 && i11 != i9 && i11 != 1 && (i9 - i11) % 2 == 1) {
                r14 -= this.mtfFreq[i13];
                i13--;
            }
            for (int i14 = c4; i14 < i5; i14++) {
                if (i14 < i10 || i14 > i13) {
                    cArr[i11 - 1][i14] = c7;
                } else {
                    cArr[i11 - 1][i14] = c4;
                }
            }
            i11--;
            i10 = i13 + 1;
            i8 -= r14;
            c2 = c7;
            r8 = c4;
        }
        boolean z = r8;
        char c8 = c2;
        int i15 = 5;
        int[] iArr2 = new int[2];
        iArr2[1] = 258;
        iArr2[z ? 1 : 0] = 6;
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr2);
        int[] iArr4 = new int[6];
        short[] sArr = new short[6];
        ?? r10 = r8;
        ?? r83 = r8;
        while (true) {
            int i16 = 20;
            if (r83 >= c6) {
                break;
            }
            for (int i17 = z ? 1 : 0; i17 < i9; i17++) {
                iArr4[i17] = z ? 1 : 0;
            }
            for (int i18 = z ? 1 : 0; i18 < i9; i18++) {
                for (int i19 = z ? 1 : 0; i19 < i5; i19++) {
                    iArr3[i18][i19] = z ? 1 : 0;
                }
            }
            int i20 = z ? 1 : 0;
            int i21 = i20;
            int i22 = i20;
            while (true) {
                int i23 = this.nMTF;
                if (i21 >= i23) {
                    break;
                }
                char c9 = c6;
                int i24 = i21 + 49;
                if (i24 >= i23) {
                    i24 = i23 - 1;
                }
                for (int i25 = z ? 1 : 0; i25 < i9; i25++) {
                    sArr[i25] = z ? (short) 1 : (short) 0;
                }
                if (i9 == i3) {
                    c3 = c5;
                    short s = z ? 1 : 0;
                    short s2 = s;
                    short s3 = s2;
                    short s4 = s3;
                    short s5 = s4;
                    short s6 = s5;
                    for (int i26 = i21; i26 <= i24; i26++) {
                        short s7 = this.szptr[i26];
                        s = (short) (s + cArr[z ? 1 : 0][s7]);
                        int i27 = i2;
                        short s8 = (short) (s2 + cArr[c3][s7]);
                        short s9 = (short) (s3 + cArr[i27][s7]);
                        int[][] iArr5 = iArr3;
                        short s10 = (short) (s4 + cArr[3][s7]);
                        s5 = (short) (s5 + cArr[c9][s7]);
                        s2 = s8;
                        s6 = (short) (s6 + cArr[5][s7]);
                        s4 = s10;
                        i2 = i27;
                        iArr3 = iArr5;
                        s3 = s9;
                    }
                    iArr = iArr3;
                    i = i2;
                    sArr[z ? 1 : 0] = s;
                    sArr[c3] = s2;
                    sArr[i] = s3;
                    sArr[3] = s4;
                    sArr[c9] = s5;
                    sArr[5] = s6;
                } else {
                    iArr = iArr3;
                    i = i2;
                    c3 = c5;
                    for (int i28 = i21; i28 <= i24; i28++) {
                        short s11 = this.szptr[i28];
                        for (int i29 = z ? 1 : 0; i29 < i9; i29++) {
                            sArr[i29] = (short) (sArr[i29] + cArr[i29][s11]);
                        }
                    }
                }
                int i30 = -1;
                short s12 = 999999999;
                for (int i31 = z ? 1 : 0; i31 < i9; i31++) {
                    short s13 = sArr[i31];
                    if (s13 < s12) {
                        i30 = i31;
                        s12 = s13;
                    }
                }
                iArr4[i30 == true ? 1 : 0] = iArr4[i30 == true ? 1 : 0] + 1;
                this.selector[i22 == true ? 1 : 0] = i30 == true ? (char) 1 : (char) 0;
                int i32 = (i22 == true ? 1 : 0) + 1;
                for (int i33 = i21; i33 <= i24; i33++) {
                    int[] iArr6 = iArr[i30 == true ? 1 : 0];
                    short s14 = this.szptr[i33];
                    iArr6[s14] = iArr6[s14] + 1;
                }
                int i34 = i24 + 1;
                c6 = c9;
                c5 = c3;
                i2 = i;
                iArr3 = iArr;
                i3 = 6;
                i16 = 20;
                i22 = i32;
                i21 = i34;
            }
            int i35 = z ? 1 : 0;
            while (i35 < i9) {
                hbMakeCodeLengths(cArr[i35], iArr3[i35], i5, i16);
                i35++;
                c6 = c6;
            }
            r83++;
            r10 = i22;
        }
        int i36 = i2;
        char c10 = c5;
        if (r10 >= 32768 || r10 > 18002) {
            panic();
        }
        char[] cArr2 = new char[6];
        for (int i37 = z ? 1 : 0; i37 < i9; i37++) {
            cArr2[i37] = (char) i37;
        }
        for (int i38 = z ? 1 : 0; i38 < r10; i38++) {
            char c11 = this.selector[i38];
            char c12 = cArr2[z ? 1 : 0];
            int i39 = z ? 1 : 0;
            while (c11 != c12) {
                i39++;
                char c13 = cArr2[i39];
                cArr2[i39] = c12;
                c12 = c13;
            }
            cArr2[z ? 1 : 0] = c12;
            this.selectorMtf[i38] = (char) i39;
        }
        int[] iArr7 = new int[i36];
        iArr7[c10] = 258;
        iArr7[z ? 1 : 0] = 6;
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr7);
        int i40 = z ? 1 : 0;
        while (i40 < i9) {
            char c14 = ' ';
            int i41 = z ? 1 : 0;
            int i42 = i41;
            while (i41 < i5) {
                char c15 = cArr[i40][i41];
                int i43 = i42;
                if (c15 > i42) {
                    i43 = c15;
                }
                if (c15 < c14) {
                    c14 = c15;
                }
                i41++;
                i42 = i43;
            }
            if (i42 > 20) {
                panic();
            }
            if (c14 < c10) {
                panic();
            }
            hbAssignCodes(iArr8[i40], cArr[i40], c14 == true ? 1 : 0, i42 == true ? 1 : 0, i5);
            i40++;
            c10 = 1;
        }
        boolean[] zArr = new boolean[16];
        for (int i44 = z ? 1 : 0; i44 < 16; i44++) {
            zArr[i44] = z;
            for (int i45 = z ? 1 : 0; i45 < 16; i45++) {
                if (this.inUse[(i44 * 16) + i45]) {
                    zArr[i44] = true;
                }
            }
        }
        int i46 = z ? 1 : 0;
        while (i46 < 16) {
            if (zArr[i46]) {
                bsW(1, 1);
            } else {
                bsW(1, z ? 1 : 0);
            }
            i46++;
            z = false;
        }
        for (int i47 = 0; i47 < 16; i47++) {
            if (zArr[i47]) {
                for (int i48 = 0; i48 < 16; i48++) {
                    if (this.inUse[(i47 * 16) + i48]) {
                        bsW(1, 1);
                    } else {
                        bsW(1, 0);
                    }
                }
            }
        }
        bsW(3, i9);
        bsW(c8, r10);
        for (int i49 = 0; i49 < r10; i49++) {
            for (int i50 = 0; i50 < this.selectorMtf[i49]; i50++) {
                bsW(1, 1);
            }
            bsW(1, 0);
        }
        int i51 = 0;
        int i52 = 0;
        while (i52 < i9) {
            char c16 = cArr[i52][i51];
            int i53 = i15;
            bsW(i53, c16);
            int i54 = 0;
            int i55 = c16;
            while (i54 < i5) {
                while (i55 < cArr[i52][i54]) {
                    bsW(2, 2);
                    i55++;
                }
                int i56 = i55;
                while (i56 > cArr[i52][i54]) {
                    bsW(2, 3);
                    i56--;
                }
                bsW(1, 0);
                i54++;
                i55 = i56;
            }
            i52++;
            i15 = i53;
            i51 = 0;
        }
        int i57 = i51;
        int i58 = i57;
        while (true) {
            int i59 = this.nMTF;
            if (i58 >= i59) {
                break;
            }
            int i60 = i58 + 49;
            if (i60 >= i59) {
                i60 = i59 - 1;
            }
            while (i58 <= i60) {
                char c17 = this.selector[i57];
                char[] cArr3 = cArr[c17];
                short s15 = this.szptr[i58];
                bsW(cArr3[s15], iArr8[c17][s15]);
                i58++;
            }
            i58 = i60 + 1;
            i57++;
        }
        if (i57 != r10) {
            panic();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0013, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0013, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void simpleSort(int r10, int r11, int r12) {
        /*
            r9 = this;
            int r0 = r11 - r10
            int r0 = r0 + 1
            r1 = 2
            if (r0 >= r1) goto L9
            goto La3
        L9:
            r1 = 0
        La:
            int[] r2 = r9.incs
            r2 = r2[r1]
            if (r2 >= r0) goto L13
            int r1 = r1 + 1
            goto La
        L13:
            int r1 = r1 + (-1)
            if (r1 < 0) goto La3
            int[] r0 = r9.incs
            r0 = r0[r1]
            int r2 = r10 + r0
            r3 = r2
        L1e:
            if (r3 <= r11) goto L21
            goto L73
        L21:
            int[] r4 = r9.zptr
            r4 = r4[r3]
            r5 = r3
        L26:
            int[] r6 = r9.zptr
            int r7 = r5 - r0
            r6 = r6[r7]
            int r6 = r6 + r12
            int r8 = r4 + r12
            boolean r6 = r9.fullGtU(r6, r8)
            if (r6 == 0) goto L43
            int[] r6 = r9.zptr
            r8 = r6[r7]
            r6[r5] = r8
            int r5 = r2 + (-1)
            if (r7 > r5) goto L41
            r5 = r7
            goto L43
        L41:
            r5 = r7
            goto L26
        L43:
            int[] r6 = r9.zptr
            r6[r5] = r4
            int r4 = r3 + 1
            if (r4 <= r11) goto L4c
            goto L73
        L4c:
            r5 = r6[r4]
        L4e:
            int[] r6 = r9.zptr
            int r7 = r4 - r0
            r6 = r6[r7]
            int r6 = r6 + r12
            int r8 = r5 + r12
            boolean r6 = r9.fullGtU(r6, r8)
            if (r6 == 0) goto L6b
            int[] r6 = r9.zptr
            r8 = r6[r7]
            r6[r4] = r8
            int r4 = r2 + (-1)
            if (r7 > r4) goto L69
            r4 = r7
            goto L6b
        L69:
            r4 = r7
            goto L4e
        L6b:
            int[] r6 = r9.zptr
            r6[r4] = r5
            int r4 = r3 + 2
            if (r4 <= r11) goto L74
        L73:
            goto L13
        L74:
            r5 = r6[r4]
        L76:
            int[] r6 = r9.zptr
            int r7 = r4 - r0
            r6 = r6[r7]
            int r6 = r6 + r12
            int r8 = r5 + r12
            boolean r6 = r9.fullGtU(r6, r8)
            if (r6 == 0) goto L93
            int[] r6 = r9.zptr
            r8 = r6[r7]
            r6[r4] = r8
            int r4 = r2 + (-1)
            if (r7 > r4) goto L91
            r4 = r7
            goto L93
        L91:
            r4 = r7
            goto L76
        L93:
            int[] r6 = r9.zptr
            r6[r4] = r5
            int r3 = r3 + 3
            int r4 = r9.workDone
            int r5 = r9.workLimit
            if (r4 <= r5) goto L1e
            boolean r4 = r9.firstAttempt
            if (r4 == 0) goto L1e
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.apache.bzip2.CBZip2OutputStream.simpleSort(int, int, int):void");
    }

    private void vswap(int i, int i2, int i3) {
        while (i3 > 0) {
            int[] iArr = this.zptr;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            i++;
            i2++;
            i3--;
        }
    }

    private void writeRun() throws IOException {
        int i;
        if (this.last >= this.allowableBlockSize) {
            endBlock();
            initBlock();
            writeRun();
            return;
        }
        this.inUse[this.currentChar] = true;
        int i2 = 0;
        while (true) {
            i = this.runLength;
            if (i2 >= i) {
                break;
            }
            this.mCrc.updateCRC((char) this.currentChar);
            i2++;
        }
        if (i == 1) {
            int i3 = this.last;
            this.last = i3 + 1;
            this.block[i3 + 2] = (char) this.currentChar;
            return;
        }
        if (i == 2) {
            int i4 = this.last;
            this.last = i4 + 1;
            char[] cArr = this.block;
            int i5 = this.currentChar;
            cArr[i4 + 2] = (char) i5;
            this.last = i4 + 2;
            cArr[i4 + 3] = (char) i5;
            return;
        }
        if (i == 3) {
            int i6 = this.last;
            this.last = i6 + 1;
            char[] cArr2 = this.block;
            int i7 = this.currentChar;
            cArr2[i6 + 2] = (char) i7;
            this.last = i6 + 2;
            cArr2[i6 + 3] = (char) i7;
            this.last = i6 + 3;
            cArr2[i6 + 4] = (char) i7;
            return;
        }
        this.inUse[i - 4] = true;
        int i8 = this.last;
        this.last = i8 + 1;
        char[] cArr3 = this.block;
        int i9 = this.currentChar;
        cArr3[i8 + 2] = (char) i9;
        this.last = i8 + 2;
        cArr3[i8 + 3] = (char) i9;
        this.last = i8 + 3;
        cArr3[i8 + 4] = (char) i9;
        this.last = i8 + 4;
        cArr3[i8 + 5] = (char) i9;
        this.last = i8 + 5;
        cArr3[i8 + 6] = (char) (i - 4);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        finish();
        this.closed = true;
        super.close();
        this.bsStream.close();
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        if (this.runLength > 0) {
            writeRun();
        }
        this.currentChar = -1;
        endBlock();
        endCompression();
        this.finished = true;
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        super.flush();
        this.bsStream.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        int i2 = (i + 256) % 256;
        int i3 = this.currentChar;
        if (i3 == -1) {
            this.currentChar = i2;
            this.runLength++;
            return;
        }
        if (i3 != i2) {
            writeRun();
            this.runLength = 1;
            this.currentChar = i2;
            return;
        }
        int i4 = this.runLength + 1;
        this.runLength = i4;
        if (i4 > 254) {
            writeRun();
            this.currentChar = -1;
            this.runLength = 0;
        }
    }
}
