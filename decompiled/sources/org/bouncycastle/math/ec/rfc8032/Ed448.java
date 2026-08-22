package org.bouncycastle.math.ec.rfc8032;

import com.facebook.appevents.UserDataStore;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.math.ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Ed448 {
    private static final int C_d = -39081;
    private static final int L4_0 = 43969588;
    private static final int L4_1 = 30366549;
    private static final int L4_2 = 163752818;
    private static final int L4_3 = 258169998;
    private static final int L4_4 = 96434764;
    private static final int L4_5 = 227822194;
    private static final int L4_6 = 149865618;
    private static final int L4_7 = 550336261;
    private static final int L_0 = 78101261;
    private static final int L_1 = 141809365;
    private static final int L_2 = 175155932;
    private static final int L_3 = 64542499;
    private static final int L_4 = 158326419;
    private static final int L_5 = 191173276;
    private static final int L_6 = 104575268;
    private static final int L_7 = 137584065;
    private static final long M26L = 67108863;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_BASE = 7;
    private static final byte[] DOM4_PREFIX = Strings.toByteArray("SigEd448");
    private static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    private static final int[] L = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK};
    private static final int[] B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    private static final int[] B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    private static final Object precompLock = new Object();
    private static PointExt[] precompBaseTable = null;
    private static int[] precompBase = null;

    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;
    }

    private static class PointExt {
        int[] x;
        int[] y;
        int[] z;

        private PointExt() {
            this.x = X448Field.create();
            this.y = X448Field.create();
            this.z = X448Field.create();
        }
    }

    private static class PointPrecomp {
        int[] x;
        int[] y;

        private PointPrecomp() {
            this.x = X448Field.create();
            this.y = X448Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        decodeScalar(bArr3, 0, iArr3);
        Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i = 0; i < 28; i++) {
            encode32(iArr[i], bArr4, i * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        X448Field.sqr(iArr, iArrCreate2);
        X448Field.sqr(iArr2, iArrCreate3);
        X448Field.mul(iArrCreate2, iArrCreate3, iArrCreate);
        X448Field.add(iArrCreate2, iArrCreate3, iArrCreate2);
        X448Field.mul(iArrCreate, 39081, iArrCreate);
        X448Field.subOne(iArrCreate);
        X448Field.add(iArrCreate, iArrCreate2, iArrCreate);
        X448Field.normalize(iArrCreate);
        return X448Field.isZero(iArrCreate);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        X448Field.sqr(iArr, iArrCreate2);
        X448Field.sqr(iArr2, iArrCreate3);
        X448Field.sqr(iArr3, iArrCreate4);
        X448Field.mul(iArrCreate2, iArrCreate3, iArrCreate);
        X448Field.add(iArrCreate2, iArrCreate3, iArrCreate2);
        X448Field.mul(iArrCreate2, iArrCreate4, iArrCreate2);
        X448Field.sqr(iArrCreate4, iArrCreate4);
        X448Field.mul(iArrCreate, 39081, iArrCreate);
        X448Field.sub(iArrCreate, iArrCreate4, iArrCreate);
        X448Field.add(iArrCreate, iArrCreate2, iArrCreate);
        X448Field.normalize(iArrCreate);
        return X448Field.isZero(iArrCreate);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & 127) != 0) {
            return false;
        }
        decode32(bArr, 0, new int[14], 0, 14);
        return !Nat.gte(14, r2, P);
    }

    private static boolean checkScalarVar(byte[] bArr) {
        if (bArr[56] != 0) {
            return false;
        }
        decodeScalar(bArr, 0, new int[14]);
        return !Nat.gte(14, r2, L);
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    private static int decode24(byte[] bArr, int i) {
        return ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i) {
        return (bArr[i + 3] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static void decode32(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = decode32(bArr, (i4 * 4) + i);
        }
    }

    private static boolean decodePointVar(byte[] bArr, int i, boolean z, PointExt pointExt) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i + 57);
        if (!checkPointVar(bArrCopyOfRange)) {
            return false;
        }
        byte b2 = bArrCopyOfRange[56];
        int i2 = (b2 & 128) >>> 7;
        bArrCopyOfRange[56] = (byte) (b2 & 127);
        X448Field.decode(bArrCopyOfRange, 0, pointExt.y);
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        X448Field.sqr(pointExt.y, iArrCreate);
        X448Field.mul(iArrCreate, 39081, iArrCreate2);
        X448Field.negate(iArrCreate, iArrCreate);
        X448Field.addOne(iArrCreate);
        X448Field.addOne(iArrCreate2);
        if (!X448Field.sqrtRatioVar(iArrCreate, iArrCreate2, pointExt.x)) {
            return false;
        }
        X448Field.normalize(pointExt.x);
        if (i2 == 1 && X448Field.isZeroVar(pointExt.x)) {
            return false;
        }
        if (z ^ (i2 != (pointExt.x[0] & 1))) {
            X448Field.negate(pointExt.x, pointExt.x);
        }
        pointExtendXY(pointExt);
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        decode32(bArr, i, iArr, 0, 14);
    }

    private static void dom4(Xof xof, byte b2, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        xof.update(bArr2, 0, bArr2.length);
        xof.update(b2);
        xof.update((byte) bArr.length);
        xof.update(bArr, 0, bArr.length);
    }

    private static void encode24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
    }

    private static void encode32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    private static void encode56(long j, byte[] bArr, int i) {
        encode32((int) j, bArr, i);
        encode24((int) (j >>> 32), bArr, i + 4);
    }

    private static int encodePoint(PointExt pointExt, byte[] bArr, int i) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        X448Field.inv(pointExt.z, iArrCreate2);
        X448Field.mul(pointExt.x, iArrCreate2, iArrCreate);
        X448Field.mul(pointExt.y, iArrCreate2, iArrCreate2);
        X448Field.normalize(iArrCreate);
        X448Field.normalize(iArrCreate2);
        int iCheckPoint = checkPoint(iArrCreate, iArrCreate2);
        X448Field.encode(iArrCreate2, bArr, i);
        bArr[i + 56] = (byte) ((iArrCreate[0] & 1) << 7);
        return iCheckPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        Xof xofCreateXof = createXof();
        byte[] bArr3 = new byte[114];
        xofCreateXof.update(bArr, i, 57);
        xofCreateXof.doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static int getWindow4(int[] iArr, int i) {
        return (iArr[i >>> 3] >>> ((i & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] iArr, int i) {
        int[] iArr2 = new int[28];
        int i2 = 0;
        int i3 = 14;
        int i4 = 28;
        int i5 = 0;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            int i6 = iArr[i3];
            iArr2[i4 - 1] = (i5 << 16) | (i6 >>> 16);
            i4 -= 2;
            iArr2[i4] = i6;
            i5 = i6;
        }
        byte[] bArr = new byte[447];
        int i7 = 1 << i;
        int i8 = i7 - 1;
        int i9 = i7 >>> 1;
        int i10 = 0;
        int i11 = 0;
        while (i2 < 28) {
            int i12 = iArr2[i2];
            while (i10 < 16) {
                int i13 = i12 >>> i10;
                if ((i13 & 1) == i11) {
                    i10++;
                } else {
                    int i14 = (i13 & i8) + i11;
                    int i15 = i14 & i9;
                    int i16 = i14 - (i15 << 1);
                    i11 = i15 >>> (i - 1);
                    bArr[(i2 << 4) + i10] = (byte) i16;
                    i10 += i;
                }
            }
            i2++;
            i10 -= 16;
        }
        return bArr;
    }

    private static void implSign(Xof xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b2, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        dom4(xof, b2, bArr4);
        xof.update(bArr, 57, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] bArrReduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(bArrReduceScalar, bArr7, 0);
        dom4(xof, b2, bArr4);
        xof.update(bArr7, 0, 57);
        xof.update(bArr3, i, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] bArrCalculateS = calculateS(bArrReduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 57);
        System.arraycopy(bArrCalculateS, 0, bArr6, i4 + 57, 57);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (!checkContextVar(bArr2)) {
            throw new IllegalArgumentException("ctx");
        }
        Xof xofCreateXof = createXof();
        byte[] bArr5 = new byte[114];
        xofCreateXof.update(bArr, i, 57);
        xofCreateXof.doFinal(bArr5, 0, 114);
        byte[] bArr6 = new byte[57];
        pruneScalar(bArr5, 0, bArr6);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(bArr6, bArr7, 0);
        implSign(xofCreateXof, bArr5, bArr6, bArr7, 0, bArr2, b2, bArr3, i2, i3, bArr4, i4);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b2, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (!checkContextVar(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        Xof xofCreateXof = createXof();
        byte[] bArr6 = new byte[114];
        xofCreateXof.update(bArr, i, 57);
        xofCreateXof.doFinal(bArr6, 0, 114);
        byte[] bArr7 = new byte[57];
        pruneScalar(bArr6, 0, bArr7);
        implSign(xofCreateXof, bArr6, bArr7, bArr2, i2, bArr3, b2, bArr4, i3, i4, bArr5, i5);
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b2, byte[] bArr4, int i3, int i4) {
        if (!checkContextVar(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        int i5 = i + 57;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i5);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i5, i + 114);
        if (!checkPointVar(bArrCopyOfRange) || !checkScalarVar(bArrCopyOfRange2)) {
            return false;
        }
        PointExt pointExt = new PointExt();
        if (!decodePointVar(bArr2, i2, true, pointExt)) {
            return false;
        }
        Xof xofCreateXof = createXof();
        byte[] bArr5 = new byte[114];
        dom4(xofCreateXof, b2, bArr3);
        xofCreateXof.update(bArrCopyOfRange, 0, 57);
        xofCreateXof.update(bArr2, i2, 57);
        xofCreateXof.update(bArr4, i3, i4);
        xofCreateXof.doFinal(bArr5, 0, 114);
        byte[] bArrReduceScalar = reduceScalar(bArr5);
        int[] iArr = new int[14];
        decodeScalar(bArrCopyOfRange2, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArrReduceScalar, 0, iArr2);
        PointExt pointExt2 = new PointExt();
        scalarMultStrausVar(iArr, iArr2, pointExt, pointExt2);
        byte[] bArr6 = new byte[57];
        return encodePoint(pointExt2, bArr6, 0) != 0 && Arrays.areEqual(bArr6, bArrCopyOfRange);
    }

    private static void pointAdd(PointExt pointExt, PointExt pointExt2) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        int[] iArrCreate5 = X448Field.create();
        int[] iArrCreate6 = X448Field.create();
        int[] iArrCreate7 = X448Field.create();
        int[] iArrCreate8 = X448Field.create();
        X448Field.mul(pointExt.z, pointExt2.z, iArrCreate);
        X448Field.sqr(iArrCreate, iArrCreate2);
        X448Field.mul(pointExt.x, pointExt2.x, iArrCreate3);
        X448Field.mul(pointExt.y, pointExt2.y, iArrCreate4);
        X448Field.mul(iArrCreate3, iArrCreate4, iArrCreate5);
        X448Field.mul(iArrCreate5, 39081, iArrCreate5);
        X448Field.add(iArrCreate2, iArrCreate5, iArrCreate6);
        X448Field.sub(iArrCreate2, iArrCreate5, iArrCreate7);
        X448Field.add(pointExt.x, pointExt.y, iArrCreate2);
        X448Field.add(pointExt2.x, pointExt2.y, iArrCreate5);
        X448Field.mul(iArrCreate2, iArrCreate5, iArrCreate8);
        X448Field.add(iArrCreate4, iArrCreate3, iArrCreate2);
        X448Field.sub(iArrCreate4, iArrCreate3, iArrCreate5);
        X448Field.carry(iArrCreate2);
        X448Field.sub(iArrCreate8, iArrCreate2, iArrCreate8);
        X448Field.mul(iArrCreate8, iArrCreate, iArrCreate8);
        X448Field.mul(iArrCreate5, iArrCreate, iArrCreate5);
        X448Field.mul(iArrCreate6, iArrCreate8, pointExt2.x);
        X448Field.mul(iArrCreate5, iArrCreate7, pointExt2.y);
        X448Field.mul(iArrCreate6, iArrCreate7, pointExt2.z);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointExt pointExt) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        int[] iArrCreate5 = X448Field.create();
        int[] iArrCreate6 = X448Field.create();
        int[] iArrCreate7 = X448Field.create();
        X448Field.sqr(pointExt.z, iArrCreate);
        X448Field.mul(pointPrecomp.x, pointExt.x, iArrCreate2);
        X448Field.mul(pointPrecomp.y, pointExt.y, iArrCreate3);
        X448Field.mul(iArrCreate2, iArrCreate3, iArrCreate4);
        X448Field.mul(iArrCreate4, 39081, iArrCreate4);
        X448Field.add(iArrCreate, iArrCreate4, iArrCreate5);
        X448Field.sub(iArrCreate, iArrCreate4, iArrCreate6);
        X448Field.add(pointPrecomp.x, pointPrecomp.y, iArrCreate);
        X448Field.add(pointExt.x, pointExt.y, iArrCreate4);
        X448Field.mul(iArrCreate, iArrCreate4, iArrCreate7);
        X448Field.add(iArrCreate3, iArrCreate2, iArrCreate);
        X448Field.sub(iArrCreate3, iArrCreate2, iArrCreate4);
        X448Field.carry(iArrCreate);
        X448Field.sub(iArrCreate7, iArrCreate, iArrCreate7);
        X448Field.mul(iArrCreate7, pointExt.z, iArrCreate7);
        X448Field.mul(iArrCreate4, pointExt.z, iArrCreate4);
        X448Field.mul(iArrCreate5, iArrCreate7, pointExt.x);
        X448Field.mul(iArrCreate4, iArrCreate6, pointExt.y);
        X448Field.mul(iArrCreate5, iArrCreate6, pointExt.z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointExt pointExt2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        int[] iArrCreate5 = X448Field.create();
        int[] iArrCreate6 = X448Field.create();
        int[] iArrCreate7 = X448Field.create();
        int[] iArrCreate8 = X448Field.create();
        if (z) {
            X448Field.sub(pointExt.y, pointExt.x, iArrCreate8);
            iArr2 = iArrCreate2;
            iArr = iArrCreate5;
            iArr4 = iArrCreate6;
            iArr3 = iArrCreate7;
        } else {
            X448Field.add(pointExt.y, pointExt.x, iArrCreate8);
            iArr = iArrCreate2;
            iArr2 = iArrCreate5;
            iArr3 = iArrCreate6;
            iArr4 = iArrCreate7;
        }
        X448Field.mul(pointExt.z, pointExt2.z, iArrCreate);
        X448Field.sqr(iArrCreate, iArrCreate2);
        X448Field.mul(pointExt.x, pointExt2.x, iArrCreate3);
        X448Field.mul(pointExt.y, pointExt2.y, iArrCreate4);
        X448Field.mul(iArrCreate3, iArrCreate4, iArrCreate5);
        X448Field.mul(iArrCreate5, 39081, iArrCreate5);
        X448Field.add(iArrCreate2, iArrCreate5, iArr3);
        X448Field.sub(iArrCreate2, iArrCreate5, iArr4);
        X448Field.add(pointExt2.x, pointExt2.y, iArrCreate5);
        X448Field.mul(iArrCreate8, iArrCreate5, iArrCreate8);
        X448Field.add(iArrCreate4, iArrCreate3, iArr);
        X448Field.sub(iArrCreate4, iArrCreate3, iArr2);
        X448Field.carry(iArr);
        X448Field.sub(iArrCreate8, iArrCreate2, iArrCreate8);
        X448Field.mul(iArrCreate8, iArrCreate, iArrCreate8);
        X448Field.mul(iArrCreate5, iArrCreate, iArrCreate5);
        X448Field.mul(iArrCreate6, iArrCreate8, pointExt2.x);
        X448Field.mul(iArrCreate5, iArrCreate7, pointExt2.y);
        X448Field.mul(iArrCreate6, iArrCreate7, pointExt2.z);
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X448Field.copy(pointExt.x, 0, pointExt2.x, 0);
        X448Field.copy(pointExt.y, 0, pointExt2.y, 0);
        X448Field.copy(pointExt.z, 0, pointExt2.z, 0);
    }

    private static void pointDouble(PointExt pointExt) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        int[] iArrCreate5 = X448Field.create();
        int[] iArrCreate6 = X448Field.create();
        X448Field.add(pointExt.x, pointExt.y, iArrCreate);
        X448Field.sqr(iArrCreate, iArrCreate);
        X448Field.sqr(pointExt.x, iArrCreate2);
        X448Field.sqr(pointExt.y, iArrCreate3);
        X448Field.add(iArrCreate2, iArrCreate3, iArrCreate4);
        X448Field.carry(iArrCreate4);
        X448Field.sqr(pointExt.z, iArrCreate5);
        X448Field.add(iArrCreate5, iArrCreate5, iArrCreate5);
        X448Field.carry(iArrCreate5);
        X448Field.sub(iArrCreate4, iArrCreate5, iArrCreate6);
        X448Field.sub(iArrCreate, iArrCreate4, iArrCreate);
        X448Field.sub(iArrCreate2, iArrCreate3, iArrCreate2);
        X448Field.mul(iArrCreate, iArrCreate6, pointExt.x);
        X448Field.mul(iArrCreate4, iArrCreate2, pointExt.y);
        X448Field.mul(iArrCreate4, iArrCreate6, pointExt.z);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X448Field.one(pointExt.z);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * 512;
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            X448Field.cmov(i5, precompBase, i3, pointPrecomp.x, 0);
            X448Field.cmov(i5, precompBase, i3 + 16, pointPrecomp.y, 0);
            i3 += 32;
        }
    }

    private static void pointLookup(int[] iArr, int i, int[] iArr2, PointExt pointExt) {
        int window4 = getWindow4(iArr, i);
        int i2 = (window4 >>> 3) ^ 1;
        int i3 = (window4 ^ (-i2)) & 7;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i5 ^ i3) - 1) >> 31;
            X448Field.cmov(i6, iArr2, i4, pointExt.x, 0);
            X448Field.cmov(i6, iArr2, i4 + 16, pointExt.y, 0);
            X448Field.cmov(i6, iArr2, i4 + 32, pointExt.z, 0);
            i4 += 48;
        }
        X448Field.cnegate(i2, pointExt.x);
    }

    private static int[] pointPrecomp(PointExt pointExt, int i) {
        PointExt pointExtPointCopy = pointCopy(pointExt);
        PointExt pointExtPointCopy2 = pointCopy(pointExtPointCopy);
        pointDouble(pointExtPointCopy2);
        int[] iArrCreateTable = X448Field.createTable(i * 3);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            X448Field.copy(pointExtPointCopy.x, 0, iArrCreateTable, i2);
            X448Field.copy(pointExtPointCopy.y, 0, iArrCreateTable, i2 + 16);
            X448Field.copy(pointExtPointCopy.z, 0, iArrCreateTable, i2 + 32);
            i2 += 48;
            i3++;
            if (i3 == i) {
                return iArrCreateTable;
            }
            pointAdd(pointExtPointCopy2, pointExtPointCopy);
        }
    }

    private static PointExt[] pointPrecompVar(PointExt pointExt, int i) {
        PointExt pointExtPointCopy = pointCopy(pointExt);
        pointDouble(pointExtPointCopy);
        PointExt[] pointExtArr = new PointExt[i];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i2 = 1; i2 < i; i2++) {
            PointExt pointExtPointCopy2 = pointCopy(pointExtArr[i2 - 1]);
            pointExtArr[i2] = pointExtPointCopy2;
            pointAddVar(false, pointExtPointCopy, pointExtPointCopy2);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X448Field.zero(pointExt.x);
        X448Field.one(pointExt.y);
        X448Field.one(pointExt.z);
    }

    public static void precompute() {
        synchronized (precompLock) {
            if (precompBase == null) {
                PointExt pointExt = new PointExt();
                X448Field.copy(B_x, 0, pointExt.x, 0);
                X448Field.copy(B_y, 0, pointExt.y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecompVar(pointExt, 32);
                precompBase = X448Field.createTable(160);
                int i = 0;
                for (int i2 = 0; i2 < 5; i2++) {
                    PointExt[] pointExtArr = new PointExt[5];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 5) {
                            break;
                        }
                        pointAddVar(true, pointExt, pointExt2);
                        pointDouble(pointExt);
                        pointExtArr[i3] = pointCopy(pointExt);
                        if (i2 + i3 != 8) {
                            for (int i4 = 1; i4 < 18; i4++) {
                                pointDouble(pointExt);
                            }
                        }
                        i3++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[16];
                    pointExtArr2[0] = pointExt2;
                    int i5 = 1;
                    for (int i6 = 0; i6 < 4; i6++) {
                        int i7 = 1 << i6;
                        int i8 = 0;
                        while (i8 < i7) {
                            PointExt pointExtPointCopy = pointCopy(pointExtArr2[i5 - i7]);
                            pointExtArr2[i5] = pointExtPointCopy;
                            pointAddVar(false, pointExtArr[i6], pointExtPointCopy);
                            i8++;
                            i5++;
                        }
                    }
                    for (int i9 = 0; i9 < 16; i9++) {
                        PointExt pointExt3 = pointExtArr2[i9];
                        X448Field.inv(pointExt3.z, pointExt3.z);
                        X448Field.mul(pointExt3.x, pointExt3.z, pointExt3.x);
                        X448Field.mul(pointExt3.y, pointExt3.z, pointExt3.y);
                        X448Field.copy(pointExt3.x, 0, precompBase, i);
                        X448Field.copy(pointExt3.y, 0, precompBase, i + 16);
                        i += 32;
                    }
                }
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
    }

    private static byte[] reduceScalar(byte[] bArr) {
        long jDecode32 = ((long) decode32(bArr, 0)) & 4294967295L;
        long jDecode24 = ((long) (decode24(bArr, 4) << 4)) & 4294967295L;
        long jDecode322 = ((long) decode32(bArr, 7)) & 4294967295L;
        long jDecode242 = ((long) (decode24(bArr, 11) << 4)) & 4294967295L;
        long jDecode323 = ((long) decode32(bArr, 14)) & 4294967295L;
        long jDecode243 = ((long) (decode24(bArr, 18) << 4)) & 4294967295L;
        long jDecode324 = ((long) decode32(bArr, 21)) & 4294967295L;
        long jDecode244 = ((long) (decode24(bArr, 25) << 4)) & 4294967295L;
        long jDecode325 = ((long) decode32(bArr, 28)) & 4294967295L;
        long jDecode245 = ((long) (decode24(bArr, 32) << 4)) & 4294967295L;
        long jDecode326 = ((long) decode32(bArr, 35)) & 4294967295L;
        long jDecode246 = ((long) (decode24(bArr, 39) << 4)) & 4294967295L;
        long jDecode327 = ((long) decode32(bArr, 42)) & 4294967295L;
        long jDecode247 = ((long) (decode24(bArr, 46) << 4)) & 4294967295L;
        long jDecode328 = ((long) decode32(bArr, 49)) & 4294967295L;
        long jDecode248 = ((long) (decode24(bArr, 53) << 4)) & 4294967295L;
        long jDecode329 = ((long) decode32(bArr, 56)) & 4294967295L;
        long jDecode249 = ((long) (decode24(bArr, 60) << 4)) & 4294967295L;
        long jDecode3210 = ((long) decode32(bArr, 63)) & 4294967295L;
        long jDecode2410 = ((long) (decode24(bArr, 67) << 4)) & 4294967295L;
        long jDecode3211 = ((long) decode32(bArr, 70)) & 4294967295L;
        long jDecode2411 = ((long) (decode24(bArr, 74) << 4)) & 4294967295L;
        long jDecode3212 = ((long) decode32(bArr, 77)) & 4294967295L;
        long jDecode2412 = ((long) (decode24(bArr, 81) << 4)) & 4294967295L;
        long jDecode3213 = decode32(bArr, 84);
        long j = jDecode3213 & 4294967295L;
        long jDecode2413 = ((long) (decode24(bArr, 88) << 4)) & 4294967295L;
        long jDecode3214 = decode32(bArr, 91);
        long j2 = jDecode3214 & 4294967295L;
        long jDecode2414 = ((long) (decode24(bArr, 95) << 4)) & 4294967295L;
        long jDecode3215 = decode32(bArr, 98);
        long j3 = jDecode3215 & 4294967295L;
        long jDecode2415 = ((long) (decode24(bArr, 102) << 4)) & 4294967295L;
        long jDecode3216 = decode32(bArr, 105);
        long j4 = jDecode3216 & 4294967295L;
        long jDecode2416 = ((long) (decode24(bArr, 109) << 4)) & 4294967295L;
        long jDecode16 = ((long) decode16(bArr, 112)) & 4294967295L;
        long j5 = jDecode2416 + (j4 >>> 28);
        long j6 = jDecode3216 & M28L;
        long j7 = jDecode2411 + (jDecode16 * 227822194) + (j5 * 149865618);
        long j8 = jDecode3212 + (jDecode16 * 149865618) + (j5 * 550336261);
        long j9 = jDecode248 + (j5 * 43969588) + (j6 * 30366549);
        long j10 = jDecode329 + (jDecode16 * 43969588) + (j5 * 30366549) + (j6 * 163752818);
        long j11 = jDecode249 + (jDecode16 * 30366549) + (j5 * 163752818) + (j6 * 258169998);
        long j12 = jDecode3210 + (jDecode16 * 163752818) + (j5 * 258169998) + (j6 * 96434764);
        long j13 = jDecode2410 + (jDecode16 * 258169998) + (j5 * 96434764) + (j6 * 227822194);
        long j14 = jDecode3211 + (jDecode16 * 96434764) + (j5 * 227822194) + (j6 * 149865618);
        long j15 = jDecode2415 + (j3 >>> 28);
        long j16 = jDecode3215 & M28L;
        long j17 = j13 + (j15 * 149865618);
        long j18 = j14 + (j15 * 550336261);
        long j19 = jDecode247 + (j15 * 43969588) + (j16 * 30366549);
        long j20 = jDecode328 + (j6 * 43969588) + (j15 * 30366549) + (j16 * 163752818);
        long j21 = j9 + (j15 * 163752818) + (j16 * 258169998);
        long j22 = j10 + (j15 * 258169998) + (j16 * 96434764);
        long j23 = j11 + (j15 * 96434764) + (j16 * 227822194);
        long j24 = j12 + (j15 * 227822194) + (j16 * 149865618);
        long j25 = jDecode2414 + (j2 >>> 28);
        long j26 = jDecode3214 & M28L;
        long j27 = j24 + (j25 * 550336261);
        long j28 = jDecode246 + (j25 * 43969588) + (j26 * 30366549);
        long j29 = jDecode327 + (j16 * 43969588) + (j25 * 30366549) + (j26 * 163752818);
        long j30 = j19 + (j25 * 163752818) + (j26 * 258169998);
        long j31 = j20 + (j25 * 258169998) + (j26 * 96434764);
        long j32 = j21 + (j25 * 96434764) + (j26 * 227822194);
        long j33 = j22 + (j25 * 227822194) + (j26 * 149865618);
        long j34 = j23 + (j25 * 149865618) + (j26 * 550336261);
        long j35 = jDecode2413 + (j >>> 28);
        long j36 = jDecode3213 & M28L;
        long j37 = j7 + (j6 * 550336261) + (j18 >>> 28);
        long j38 = j18 & M28L;
        long j39 = j8 + (j37 >>> 28);
        long j40 = j37 & M28L;
        long j41 = jDecode2412 + (jDecode16 * 550336261) + (j39 >>> 28);
        long j42 = j39 & M28L;
        long j43 = j36 + (j41 >>> 28);
        long j44 = j41 & M28L;
        long j45 = j30 + (j35 * 96434764) + (j43 * 227822194) + (j44 * 149865618);
        long j46 = j31 + (j35 * 227822194) + (j43 * 149865618) + (j44 * 550336261);
        long j47 = jDecode244 + (j44 * 43969588) + (j42 * 30366549);
        long j48 = jDecode325 + (j43 * 43969588) + (j44 * 30366549) + (j42 * 163752818);
        long j49 = jDecode245 + (j35 * 43969588) + (j43 * 30366549) + (j44 * 163752818) + (j42 * 258169998);
        long j50 = jDecode326 + (j26 * 43969588) + (j35 * 30366549) + (j43 * 163752818) + (j44 * 258169998) + (j42 * 96434764);
        long j51 = j28 + (j35 * 163752818) + (j43 * 258169998) + (j44 * 96434764) + (j42 * 227822194);
        long j52 = j29 + (j35 * 258169998) + (j43 * 96434764) + (j44 * 227822194) + (j42 * 149865618);
        long j53 = j27 + (j34 >>> 28);
        long j54 = j34 & M28L;
        long j55 = j17 + (j16 * 550336261) + (j53 >>> 28);
        long j56 = j53 & M28L;
        long j57 = j38 + (j55 >>> 28);
        long j58 = j55 & M28L;
        long j59 = j40 + (j57 >>> 28);
        long j60 = j57 & M28L;
        long j61 = jDecode242 + (j58 * 43969588);
        long j62 = jDecode323 + (j60 * 43969588) + (j58 * 30366549);
        long j63 = jDecode243 + (j59 * 43969588) + (j60 * 30366549) + (j58 * 163752818);
        long j64 = jDecode324 + (j42 * 43969588) + (j59 * 30366549) + (j60 * 163752818) + (j58 * 258169998);
        long j65 = j47 + (j59 * 163752818) + (j60 * 258169998) + (j58 * 96434764);
        long j66 = j48 + (j59 * 258169998) + (j60 * 96434764) + (j58 * 227822194);
        long j67 = j49 + (j59 * 96434764) + (j60 * 227822194) + (j58 * 149865618);
        long j68 = j50 + (j59 * 227822194) + (j60 * 149865618) + (j58 * 550336261);
        long j69 = j32 + (j35 * 149865618) + (j43 * 550336261) + (j46 >>> 28);
        long j70 = j46 & M28L;
        long j71 = j33 + (j35 * 550336261) + (j69 >>> 28);
        long j72 = j69 & M28L;
        long j73 = j54 + (j71 >>> 28);
        long j74 = j71 & M28L;
        long j75 = j56 + (j73 >>> 28);
        long j76 = j73 & M28L;
        long j77 = j69 & M26L;
        long j78 = (j74 * 4) + (j72 >>> 26) + 1;
        long j79 = jDecode32 + (78101261 * j78);
        long j80 = jDecode322 + (j75 * 43969588) + (30366549 * j76) + (175155932 * j78);
        long j81 = j61 + (j75 * 30366549) + (163752818 * j76) + (64542499 * j78);
        long j82 = j62 + (j75 * 163752818) + (258169998 * j76) + (158326419 * j78);
        long j83 = j63 + (j75 * 258169998) + (96434764 * j76) + (191173276 * j78);
        long j84 = j64 + (j75 * 96434764) + (227822194 * j76) + (104575268 * j78);
        long j85 = j65 + (j75 * 227822194) + (149865618 * j76) + (j78 * 137584065);
        long j86 = jDecode24 + (43969588 * j76) + (141809365 * j78) + (j79 >>> 28);
        long j87 = j79 & M28L;
        long j88 = j80 + (j86 >>> 28);
        long j89 = j86 & M28L;
        long j90 = j81 + (j88 >>> 28);
        long j91 = j88 & M28L;
        long j92 = j82 + (j90 >>> 28);
        long j93 = j90 & M28L;
        long j94 = j83 + (j92 >>> 28);
        long j95 = j92 & M28L;
        long j96 = j84 + (j94 >>> 28);
        long j97 = j94 & M28L;
        long j98 = j85 + (j96 >>> 28);
        long j99 = j96 & M28L;
        long j100 = j66 + (j75 * 149865618) + (j76 * 550336261) + (j98 >>> 28);
        long j101 = j98 & M28L;
        long j102 = j67 + (j75 * 550336261) + (j100 >>> 28);
        long j103 = j100 & M28L;
        long j104 = j68 + (j102 >>> 28);
        long j105 = j102 & M28L;
        long j106 = j51 + (j59 * 149865618) + (j60 * 550336261) + (j104 >>> 28);
        long j107 = j104 & M28L;
        long j108 = j52 + (j59 * 550336261) + (j106 >>> 28);
        long j109 = j106 & M28L;
        long j110 = j45 + (j42 * 550336261) + (j108 >>> 28);
        long j111 = j108 & M28L;
        long j112 = j70 + (j110 >>> 28);
        long j113 = j110 & M28L;
        long j114 = j77 + (j112 >>> 28);
        long j115 = j112 & M28L;
        long j116 = j114 & M26L;
        long j117 = (j114 >>> 26) - 1;
        long j118 = j87 - (j117 & 78101261);
        long j119 = (j89 - (j117 & 141809365)) + (j118 >> 28);
        long j120 = j118 & M28L;
        long j121 = (j91 - (j117 & 175155932)) + (j119 >> 28);
        long j122 = j119 & M28L;
        long j123 = (j93 - (j117 & 64542499)) + (j121 >> 28);
        long j124 = j121 & M28L;
        long j125 = (j95 - (j117 & 158326419)) + (j123 >> 28);
        long j126 = j123 & M28L;
        long j127 = (j97 - (j117 & 191173276)) + (j125 >> 28);
        long j128 = j125 & M28L;
        long j129 = (j99 - (j117 & 104575268)) + (j127 >> 28);
        long j130 = j127 & M28L;
        long j131 = (j101 - (j117 & 137584065)) + (j129 >> 28);
        long j132 = j129 & M28L;
        long j133 = j103 + (j131 >> 28);
        long j134 = j131 & M28L;
        long j135 = j105 + (j133 >> 28);
        long j136 = j133 & M28L;
        long j137 = j107 + (j135 >> 28);
        long j138 = j135 & M28L;
        long j139 = j109 + (j137 >> 28);
        long j140 = j137 & M28L;
        long j141 = j111 + (j139 >> 28);
        long j142 = j139 & M28L;
        long j143 = j113 + (j141 >> 28);
        long j144 = j141 & M28L;
        long j145 = j115 + (j143 >> 28);
        long j146 = j143 & M28L;
        long j147 = j116 + (j145 >> 28);
        long j148 = j145 & M28L;
        byte[] bArr2 = new byte[57];
        encode56(j120 | (j122 << 28), bArr2, 0);
        encode56(j124 | (j126 << 28), bArr2, 7);
        encode56((j130 << 28) | j128, bArr2, 14);
        encode56((j134 << 28) | j132, bArr2, 21);
        encode56((j138 << 28) | j136, bArr2, 28);
        encode56(j140 | (j142 << 28), bArr2, 35);
        encode56(j144 | (j146 << 28), bArr2, 42);
        encode56(j148 | (j147 << 28), bArr2, 49);
        return bArr2;
    }

    private static void scalarMult(byte[] bArr, PointExt pointExt, PointExt pointExt2) {
        int[] iArr = new int[14];
        decodeScalar(bArr, 0, iArr);
        Nat.shiftDownBits(14, iArr, 2, 0);
        Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr);
        Nat.shiftDownBit(14, iArr, 1);
        int[] iArrPointPrecomp = pointPrecomp(pointExt, 8);
        pointLookup(iArr, 111, iArrPointPrecomp, pointExt2);
        PointExt pointExt3 = new PointExt();
        for (int i = 110; i >= 0; i--) {
            for (int i2 = 0; i2 < 4; i2++) {
                pointDouble(pointExt2);
            }
            pointLookup(iArr, i, iArrPointPrecomp, pointExt3);
            pointAdd(pointExt3, pointExt2);
        }
        for (int i3 = 0; i3 < 2; i3++) {
            pointDouble(pointExt2);
        }
    }

    private static void scalarMultBase(byte[] bArr, PointExt pointExt) {
        precompute();
        pointSetNeutral(pointExt);
        int[] iArr = new int[15];
        decodeScalar(bArr, 0, iArr);
        iArr[14] = Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr) + 4;
        Nat.shiftDownBit(15, iArr, 0);
        PointPrecomp pointPrecomp = new PointPrecomp();
        int i = 17;
        while (true) {
            int i2 = i;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < 5; i5++) {
                    i4 = (i4 & (~(1 << i5))) ^ ((iArr[i2 >>> 5] >>> (i2 & 31)) << i5);
                    i2 += 18;
                }
                int i6 = (i4 >>> 4) & 1;
                pointLookup(i3, ((-i6) ^ i4) & 15, pointPrecomp);
                X448Field.cnegate(i6, pointPrecomp.x);
                pointAddPrecomp(pointPrecomp, pointExt);
            }
            i--;
            if (i < 0) {
                return;
            } else {
                pointDouble(pointExt);
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr, pointExt);
        if (encodePoint(pointExt, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(X448.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by X448");
        }
        byte[] bArr2 = new byte[57];
        pruneScalar(bArr, i, bArr2);
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr2, pointExt);
        if (checkPoint(pointExt.x, pointExt.y, pointExt.z) == 0) {
            throw new IllegalStateException();
        }
        X448Field.copy(pointExt.x, 0, iArr, 0);
        X448Field.copy(pointExt.y, 0, iArr2, 0);
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointExt pointExt, PointExt pointExt2) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointExtArrPointPrecompVar = pointPrecompVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = 446;
        while (true) {
            byte b2 = wnafVar[i];
            if (b2 != 0) {
                int i2 = b2 >> Ascii.US;
                pointAddVar(i2 != 0, precompBaseTable[(b2 ^ i2) >>> 1], pointExt2);
            }
            byte b3 = wnafVar2[i];
            if (b3 != 0) {
                int i3 = b3 >> Ascii.US;
                pointAddVar(i3 != 0, pointExtArrPointPrecompVar[(b3 ^ i3) >>> 1], pointExt2);
            }
            i--;
            if (i < 0) {
                return;
            } else {
                pointDouble(pointExt2);
            }
        }
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 != xof.doFinal(bArr5, 0, 64)) {
            throw new IllegalArgumentException(UserDataStore.PHONE);
        }
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, Xof xof, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 != xof.doFinal(bArr4, 0, 64)) {
            throw new IllegalArgumentException(UserDataStore.PHONE);
        }
        implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException(UserDataStore.PHONE);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}
