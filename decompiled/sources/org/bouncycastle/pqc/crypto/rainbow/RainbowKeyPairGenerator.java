package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

/* JADX INFO: loaded from: classes10.dex */
public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private short[][] A1;
    private short[][] A1inv;
    private short[][] A2;
    private short[][] A2inv;
    private short[] b1;
    private short[] b2;
    private boolean initialized = false;
    private Layer[] layers;
    private int numOfLayers;
    private short[][] pub_quadratic;
    private short[] pub_scalar;
    private short[][] pub_singular;
    private RainbowKeyGenerationParameters rainbowParams;
    private SecureRandom sr;
    private int[] vi;

    private void compactPublicKey(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        this.pub_quadratic = (short[][]) Array.newInstance((Class<?>) Short.TYPE, length, ((length2 + 1) * length2) / 2);
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            for (int i3 = 0; i3 < length2; i3++) {
                for (int i4 = i3; i4 < length2; i4++) {
                    short[][] sArr2 = this.pub_quadratic;
                    if (i4 == i3) {
                        sArr2[i][i2] = sArr[i][i3][i4];
                    } else {
                        short[] sArr3 = sArr2[i];
                        short[][] sArr4 = sArr[i];
                        sArr3[i2] = GF2Field.addElem(sArr4[i3][i4], sArr4[i4][i3]);
                    }
                    i2++;
                }
            }
        }
    }

    private void computePublicKey() {
        ComputeInField computeInField = new ComputeInField();
        int[] iArr = this.vi;
        boolean z = true;
        int i = 0;
        int i2 = iArr[iArr.length - 1] - iArr[0];
        int i3 = iArr[iArr.length - 1];
        int i4 = 3;
        int i5 = 2;
        short[][][] sArr = (short[][][]) Array.newInstance((Class<?>) Short.TYPE, i2, i3, i3);
        this.pub_singular = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i2, i3);
        this.pub_scalar = new short[i2];
        short[] sArr2 = new short[i3];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            Layer[] layerArr = this.layers;
            if (i6 >= layerArr.length) {
                break;
            }
            short[][][] coeffAlpha = layerArr[i6].getCoeffAlpha();
            short[][][] coeffBeta = this.layers[i6].getCoeffBeta();
            short[][] coeffGamma = this.layers[i6].getCoeffGamma();
            short[] coeffEta = this.layers[i6].getCoeffEta();
            int length = coeffAlpha[i].length;
            boolean z2 = z;
            int length2 = coeffBeta[i].length;
            int i8 = i;
            while (i < length) {
                int i9 = i5;
                for (int i10 = i8; i10 < length; i10++) {
                    int i11 = i8;
                    while (i11 < length2) {
                        int i12 = i3;
                        int i13 = i;
                        int i14 = i10 + length2;
                        short[] sArrMultVect = computeInField.multVect(coeffAlpha[i][i10][i11], this.A2[i14]);
                        int i15 = i7 + i13;
                        int i16 = i11;
                        sArr[i15] = computeInField.addSquareMatrix(sArr[i15], computeInField.multVects(sArrMultVect, this.A2[i16]));
                        short[] sArrMultVect2 = computeInField.multVect(this.b2[i16], sArrMultVect);
                        short[][] sArr3 = this.pub_singular;
                        sArr3[i15] = computeInField.addVect(sArrMultVect2, sArr3[i15]);
                        short[] sArrMultVect3 = computeInField.multVect(this.b2[i14], computeInField.multVect(coeffAlpha[i13][i10][i16], this.A2[i16]));
                        short[][] sArr4 = this.pub_singular;
                        sArr4[i15] = computeInField.addVect(sArrMultVect3, sArr4[i15]);
                        short sMultElem = GF2Field.multElem(coeffAlpha[i13][i10][i16], this.b2[i14]);
                        short[] sArr5 = this.pub_scalar;
                        sArr5[i15] = GF2Field.addElem(sArr5[i15], GF2Field.multElem(sMultElem, this.b2[i16]));
                        i11 = i16 + 1;
                        i = i13;
                        i3 = i12;
                    }
                }
                int i17 = i3;
                int i18 = i;
                int i19 = i8;
                while (i19 < length2) {
                    int i20 = i8;
                    while (i20 < length2) {
                        short[] sArrMultVect4 = computeInField.multVect(coeffBeta[i18][i19][i20], this.A2[i19]);
                        int i21 = i7 + i18;
                        int i22 = i19;
                        int i23 = length2;
                        sArr[i21] = computeInField.addSquareMatrix(sArr[i21], computeInField.multVects(sArrMultVect4, this.A2[i20]));
                        short[] sArrMultVect5 = computeInField.multVect(this.b2[i20], sArrMultVect4);
                        short[][] sArr6 = this.pub_singular;
                        sArr6[i21] = computeInField.addVect(sArrMultVect5, sArr6[i21]);
                        short[] sArrMultVect6 = computeInField.multVect(this.b2[i22], computeInField.multVect(coeffBeta[i18][i22][i20], this.A2[i20]));
                        short[][] sArr7 = this.pub_singular;
                        sArr7[i21] = computeInField.addVect(sArrMultVect6, sArr7[i21]);
                        short sMultElem2 = GF2Field.multElem(coeffBeta[i18][i22][i20], this.b2[i22]);
                        short[] sArr8 = this.pub_scalar;
                        sArr8[i21] = GF2Field.addElem(sArr8[i21], GF2Field.multElem(sMultElem2, this.b2[i20]));
                        i20++;
                        i19 = i22;
                        length2 = i23;
                    }
                    i19++;
                }
                int i24 = length2;
                int i25 = i8;
                while (i25 < i24 + length) {
                    short[] sArrMultVect7 = computeInField.multVect(coeffGamma[i18][i25], this.A2[i25]);
                    short[][] sArr9 = this.pub_singular;
                    int i26 = i7 + i18;
                    sArr9[i26] = computeInField.addVect(sArrMultVect7, sArr9[i26]);
                    short[] sArr10 = this.pub_scalar;
                    int i27 = i25;
                    sArr10[i26] = GF2Field.addElem(sArr10[i26], GF2Field.multElem(coeffGamma[i18][i25], this.b2[i27]));
                    i25 = i27 + 1;
                }
                short[] sArr11 = this.pub_scalar;
                int i28 = i7 + i18;
                sArr11[i28] = GF2Field.addElem(sArr11[i28], coeffEta[i18]);
                i = i18 + 1;
                i5 = i9;
                i3 = i17;
                length2 = i24;
            }
            i7 += length;
            i6++;
            z = z2;
            i = i8;
            i4 = 3;
        }
        int i29 = i3;
        boolean z3 = z;
        int i30 = i;
        int i31 = i5;
        int[] iArr2 = new int[i4];
        iArr2[i31] = i29;
        iArr2[z3 ? 1 : 0] = i29;
        iArr2[i30] = i2;
        short[][][] sArr12 = (short[][][]) Array.newInstance((Class<?>) Short.TYPE, iArr2);
        int[] iArr3 = new int[i31];
        iArr3[z3 ? 1 : 0] = i29;
        iArr3[i30] = i2;
        short[][] sArr13 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, iArr3);
        short[] sArr14 = new short[i2];
        for (int i32 = i30; i32 < i2; i32++) {
            int i33 = i30;
            while (true) {
                short[][] sArr15 = this.A1;
                if (i33 < sArr15.length) {
                    sArr12[i32] = computeInField.addSquareMatrix(sArr12[i32], computeInField.multMatrix(sArr15[i32][i33], sArr[i33]));
                    sArr13[i32] = computeInField.addVect(sArr13[i32], computeInField.multVect(this.A1[i32][i33], this.pub_singular[i33]));
                    sArr14[i32] = GF2Field.addElem(sArr14[i32], GF2Field.multElem(this.A1[i32][i33], this.pub_scalar[i33]));
                    i33++;
                }
            }
            sArr14[i32] = GF2Field.addElem(sArr14[i32], this.b1[i32]);
        }
        this.pub_singular = sArr13;
        this.pub_scalar = sArr14;
        compactPublicKey(sArr12);
    }

    private void generateF() {
        this.layers = new Layer[this.numOfLayers];
        int i = 0;
        while (i < this.numOfLayers) {
            Layer[] layerArr = this.layers;
            int[] iArr = this.vi;
            int i2 = i + 1;
            layerArr[i] = new Layer(iArr[i], iArr[i2], this.sr);
            i = i2;
        }
    }

    private void generateL1() {
        int[] iArr = this.vi;
        int i = iArr[iArr.length - 1] - iArr[0];
        this.A1 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i, i);
        this.A1inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A1inv == null) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.A1[i2][i3] = (short) (this.sr.nextInt() & 255);
                }
            }
            this.A1inv = computeInField.inverse(this.A1);
        }
        this.b1 = new short[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.b1[i4] = (short) (this.sr.nextInt() & 255);
        }
    }

    private void generateL2() {
        int[] iArr = this.vi;
        int i = iArr[iArr.length - 1];
        this.A2 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i, i);
        this.A2inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A2inv == null) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.A2[i2][i3] = (short) (this.sr.nextInt() & 255);
                }
            }
            this.A2inv = computeInField.inverse(this.A2);
        }
        this.b2 = new short[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.b2[i4] = (short) (this.sr.nextInt() & 255);
        }
    }

    private void initializeDefault() {
        initialize(new RainbowKeyGenerationParameters(CryptoServicesRegistrar.getSecureRandom(), new RainbowParameters()));
    }

    private void keygen() {
        generateL1();
        generateL2();
        generateF();
        computePublicKey();
    }

    public AsymmetricCipherKeyPair genKeyPair() {
        if (!this.initialized) {
            initializeDefault();
        }
        keygen();
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.A1inv, this.b1, this.A2inv, this.b2, this.vi, this.layers);
        int[] iArr = this.vi;
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RainbowPublicKeyParameters(iArr[iArr.length - 1] - iArr[0], this.pub_quadratic, this.pub_singular, this.pub_scalar), (AsymmetricKeyParameter) rainbowPrivateKeyParameters);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        RainbowKeyGenerationParameters rainbowKeyGenerationParameters = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.rainbowParams = rainbowKeyGenerationParameters;
        this.sr = rainbowKeyGenerationParameters.getRandom();
        this.vi = this.rainbowParams.getParameters().getVi();
        this.numOfLayers = this.rainbowParams.getParameters().getNumOfLayers();
        this.initialized = true;
    }
}
