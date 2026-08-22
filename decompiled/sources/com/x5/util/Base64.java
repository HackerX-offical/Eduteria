package com.x5.util;

import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import okio.Utf8;

/* JADX INFO: loaded from: classes9.dex */
public class Base64 {
    public static final boolean DECODE = false;
    public static final boolean ENCODE = true;
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    private static final byte[] ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte[] DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, Ascii.SI, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    private Base64() {
    }

    private static byte[] encode3to4(byte[] bArr) {
        return encode3to4(bArr, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, int i) {
        byte[] bArr2 = new byte[4];
        encode3to4(bArr, 0, i, bArr2, 0);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = (i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0);
        if (i2 == 1) {
            byte[] bArr3 = ALPHABET;
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 == 2) {
            byte[] bArr4 = ALPHABET;
            bArr2[i3] = bArr4[i4 >>> 18];
            bArr2[i3 + 1] = bArr4[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr4[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        }
        if (i2 != 3) {
            return bArr2;
        }
        byte[] bArr5 = ALPHABET;
        bArr2[i3] = bArr5[i4 >>> 18];
        bArr2[i3 + 1] = bArr5[(i4 >>> 12) & 63];
        bArr2[i3 + 2] = bArr5[(i4 >>> 6) & 63];
        bArr2[i3 + 3] = bArr5[i4 & 63];
        return bArr2;
    }

    public static String encodeObject(Serializable serializable) {
        return encodeObject(serializable, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r5v0, types: [boolean] */
    public static String encodeObject(Serializable serializable, boolean z) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    outputStream = new OutputStream(byteArrayOutputStream, true, z);
                } catch (IOException e2) {
                    e = e2;
                    objectOutputStream = null;
                    outputStream = null;
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                r0 = z;
            }
        } catch (IOException e3) {
            e = e3;
            objectOutputStream = null;
            byteArrayOutputStream = null;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            outputStream = null;
        }
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            try {
                objectOutputStream.writeObject(serializable);
                try {
                    objectOutputStream.close();
                } catch (Exception unused) {
                }
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused3) {
                }
                return new String(byteArrayOutputStream.toByteArray());
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                try {
                    objectOutputStream.close();
                } catch (Exception unused4) {
                }
                try {
                    outputStream.close();
                } catch (Exception unused5) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused6) {
                }
                return null;
            }
        } catch (IOException e5) {
            e = e5;
            objectOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            try {
                r0.close();
            } catch (Exception unused7) {
            }
            try {
                outputStream.close();
            } catch (Exception unused8) {
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (Exception unused9) {
                throw th;
            }
        }
    }

    public static String encodeBytes(byte[] bArr) {
        return encodeBytes(bArr, true);
    }

    public static String encodeBytes(byte[] bArr, boolean z) {
        return encodeBytes(bArr, 0, bArr.length, z);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        return encodeBytes(bArr, i, i2, true);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2, boolean z) {
        int i3 = (i2 * 4) / 3;
        byte[] bArr2 = new byte[(i2 % 3 > 0 ? 4 : 0) + i3 + (z ? i3 / 76 : 0)];
        int i4 = i2 - 2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4) {
            encode3to4(bArr, i5 + i, 3, bArr2, i6);
            i7 += 4;
            if (z && i7 == 76) {
                bArr2[i6 + 4] = 10;
                i6++;
                i7 = 0;
            }
            i5 += 3;
            i6 += 4;
        }
        if (i5 < i2) {
            encode3to4(bArr, i + i5, i2 - i5, bArr2, i6);
            i6 += 4;
        }
        return new String(bArr2, 0, i6);
    }

    public static String encodeString(String str) {
        return encodeString(str, true);
    }

    public static String encodeString(String str, boolean z) {
        return encodeBytes(str.getBytes(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] decode4to3(byte[] bArr) {
        byte[] bArr2 = new byte[3];
        int iDecode4to3 = decode4to3(bArr, 0, bArr2, 0);
        byte[] bArr3 = new byte[iDecode4to3];
        for (int i = 0; i < iDecode4to3; i++) {
            bArr3[i] = bArr2[i];
        }
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i + 2;
        byte b2 = bArr[i3];
        if (b2 == 61) {
            byte[] bArr3 = DECODABET;
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] & 255) << 12) | ((bArr3[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        int i4 = i + 3;
        byte b3 = bArr[i4];
        if (b3 == 61) {
            byte[] bArr4 = DECODABET;
            int i5 = ((bArr4[bArr[i + 1]] & 255) << 12) | ((bArr4[bArr[i]] & 255) << 18) | ((bArr4[b2] & 255) << 6);
            bArr2[i2] = (byte) (i5 >>> 16);
            bArr2[i2 + 1] = (byte) (i5 >>> 8);
            return 2;
        }
        try {
            byte[] bArr5 = DECODABET;
            int i6 = ((bArr5[b2] & 255) << 6) | ((bArr5[bArr[i]] & 255) << 18) | ((bArr5[bArr[i + 1]] & 255) << 12) | (bArr5[b3] & 255);
            bArr2[i2] = (byte) (i6 >> 16);
            bArr2[i2 + 1] = (byte) (i6 >> 8);
            bArr2[i2 + 2] = (byte) i6;
            return 3;
        } catch (Exception unused) {
            PrintStream printStream = System.out;
            StringBuilder sbAppend = new StringBuilder("").append((int) bArr[i]).append(": ");
            byte[] bArr6 = DECODABET;
            printStream.println(sbAppend.append((int) bArr6[bArr[i]]).toString());
            int i7 = i + 1;
            System.out.println("" + ((int) bArr[i7]) + ": " + ((int) bArr6[bArr[i7]]));
            System.out.println("" + ((int) bArr[i3]) + ": " + ((int) bArr6[bArr[i3]]));
            System.out.println("" + ((int) bArr[i4]) + ": " + ((int) bArr6[bArr[i4]]));
            return -1;
        }
    }

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes();
        return decode(bytes, 0, bytes.length);
    }

    public static String decodeToString(String str) {
        return new String(decode(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.ObjectInputStream] */
    public static Object decodeToObject(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        ?? Decode = decode(str);
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(Decode);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object object = objectInputStream.readObject();
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused) {
                    }
                    try {
                        objectInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return object;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        objectInputStream.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    e.printStackTrace();
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        objectInputStream.close();
                    } catch (Exception unused6) {
                    }
                    return null;
                }
            } catch (IOException e4) {
                e = e4;
                objectInputStream = null;
            } catch (ClassNotFoundException e5) {
                e = e5;
                objectInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                Decode = 0;
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused7) {
                }
                try {
                    Decode.close();
                    throw th;
                } catch (Exception unused8) {
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
        } catch (ClassNotFoundException e7) {
            e = e7;
            objectInputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            Decode = 0;
        }
    }

    public static byte[] decode(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i3 = 0;
        int iDecode4to3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            byte b2 = (byte) (bArr[i4] & 127);
            byte b3 = DECODABET[b2];
            if (b3 < -5) {
                System.err.println("Bad Base64 input character at " + i4 + ": " + ((int) bArr[i4]) + "(decimal)");
                return null;
            }
            if (b3 >= -1) {
                int i5 = i3 + 1;
                bArr3[i3] = b2;
                if (i5 > 3) {
                    iDecode4to3 += decode4to3(bArr3, 0, bArr2, iDecode4to3);
                    if (b2 == 61) {
                        break;
                    }
                    i3 = 0;
                } else {
                    i3 = i5;
                }
            }
        }
        byte[] bArr4 = new byte[iDecode4to3];
        System.arraycopy(bArr2, 0, bArr4, 0, iDecode4to3);
        return bArr4;
    }

    public static class InputStream extends FilterInputStream {
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private boolean encode;
        private int lineLength;
        private int numSigBytes;
        private int position;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, false);
        }

        public InputStream(java.io.InputStream inputStream, boolean z) {
            this(inputStream, z, true);
        }

        public InputStream(java.io.InputStream inputStream, boolean z, boolean z2) {
            super(inputStream);
            this.breakLines = z2;
            this.encode = z;
            int i = z ? 4 : 3;
            this.bufferLength = i;
            this.buffer = new byte[i];
            this.position = -1;
            this.lineLength = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i;
            if (this.position < 0) {
                if (this.encode) {
                    byte[] bArr = new byte[3];
                    int i2 = 0;
                    for (int i3 = 0; i3 < 3; i3++) {
                        try {
                            int i4 = this.in.read();
                            if (i4 >= 0) {
                                bArr[i3] = (byte) i4;
                                i2++;
                            }
                        } catch (IOException e2) {
                            if (i3 == 0) {
                                throw e2;
                            }
                        }
                    }
                    if (i2 <= 0) {
                        return -1;
                    }
                    Base64.encode3to4(bArr, 0, i2, this.buffer, 0);
                    this.position = 0;
                    this.numSigBytes = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i5 = 0;
                    while (i5 < 4) {
                        do {
                            i = this.in.read();
                            if (i < 0) {
                                break;
                            }
                        } while (Base64.DECODABET[i & 127] <= -5);
                        if (i < 0) {
                            break;
                        }
                        bArr2[i5] = (byte) i;
                        i5++;
                    }
                    if (i5 != 4) {
                        if (i5 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.numSigBytes = Base64.decode4to3(bArr2, 0, this.buffer, 0);
                    this.position = 0;
                }
            }
            int i6 = this.position;
            if (i6 >= 0) {
                if (i6 >= this.numSigBytes) {
                    return -1;
                }
                if (this.encode && this.breakLines && this.lineLength >= 76) {
                    this.lineLength = 0;
                    return 10;
                }
                this.lineLength++;
                byte[] bArr3 = this.buffer;
                int i7 = i6 + 1;
                this.position = i7;
                byte b2 = bArr3[i6];
                if (i7 >= this.bufferLength) {
                    this.position = -1;
                }
                return b2 & 255;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int i4 = read();
                if (i4 >= 0) {
                    bArr[i + i3] = (byte) i4;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    public static class OutputStream extends FilterOutputStream {
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private boolean encode;
        private int lineLength;
        private int position;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, true);
        }

        public OutputStream(java.io.OutputStream outputStream, boolean z) {
            this(outputStream, z, true);
        }

        public OutputStream(java.io.OutputStream outputStream, boolean z, boolean z2) {
            super(outputStream);
            this.breakLines = z2;
            this.encode = z;
            int i = z ? 3 : 4;
            this.bufferLength = i;
            this.buffer = new byte[i];
            this.position = 0;
            this.lineLength = 0;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (!this.encode) {
                int i2 = i & 127;
                if (Base64.DECODABET[i2] <= -5) {
                    if (Base64.DECODABET[i2] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr = this.buffer;
                int i3 = this.position;
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) i;
                if (i4 >= this.bufferLength) {
                    this.out.write(Base64.decode4to3(this.buffer));
                    this.position = 0;
                    return;
                }
                return;
            }
            byte[] bArr2 = this.buffer;
            int i5 = this.position;
            int i6 = i5 + 1;
            this.position = i6;
            bArr2[i5] = (byte) i;
            if (i6 >= this.bufferLength) {
                this.out.write(Base64.encode3to4(this.buffer, this.bufferLength));
                int i7 = this.lineLength + 4;
                this.lineLength = i7;
                if (this.breakLines && i7 >= 76) {
                    this.out.write(10);
                    this.lineLength = 0;
                }
                this.position = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            super.flush();
            if (this.position > 0) {
                if (this.encode) {
                    this.out.write(Base64.encode3to4(this.buffer, this.position));
                    this.position = 0;
                } else {
                    throw new IOException("Base64 input not properly padded.");
                }
            }
            this.out.flush();
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.out.close();
            this.buffer = null;
            this.out = null;
        }
    }
}
