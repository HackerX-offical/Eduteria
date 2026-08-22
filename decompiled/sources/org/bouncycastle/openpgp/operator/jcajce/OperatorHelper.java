package org.bouncycastle.openpgp.operator.jcajce;

import com.amazonaws.services.s3.internal.crypto.S3KeyWrapScheme;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jcajce.io.CipherInputStream;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.PGPDataDecryptor;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
class OperatorHelper {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private JcaJceHelper f1478helper;

    OperatorHelper(JcaJceHelper jcaJceHelper) {
        this.f1478helper = jcaJceHelper;
    }

    private Signature createSignature(String str) throws PGPException {
        try {
            return this.f1478helper.createSignature(str);
        } catch (GeneralSecurityException e2) {
            throw new PGPException("cannot create signature: " + e2.getMessage(), e2);
        }
    }

    public AlgorithmParameters createAlgorithmParameters(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.f1478helper.createAlgorithmParameters(str);
    }

    Cipher createCipher(String str) throws PGPException {
        try {
            return this.f1478helper.createCipher(str);
        } catch (GeneralSecurityException e2) {
            throw new PGPException("cannot create cipher: " + e2.getMessage(), e2);
        }
    }

    PGPDataDecryptor createDataDecryptor(boolean z, int i, byte[] bArr) throws PGPException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, PGPUtil.getSymmetricCipherName(i));
            final Cipher cipherCreateStreamCipher = createStreamCipher(i, z);
            if (z) {
                cipherCreateStreamCipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipherCreateStreamCipher.getBlockSize()]));
            } else {
                cipherCreateStreamCipher.init(2, secretKeySpec);
            }
            return new PGPDataDecryptor() { // from class: org.bouncycastle.openpgp.operator.jcajce.OperatorHelper.1
                @Override // org.bouncycastle.openpgp.operator.PGPDataDecryptor
                public int getBlockSize() {
                    return cipherCreateStreamCipher.getBlockSize();
                }

                @Override // org.bouncycastle.openpgp.operator.PGPDataDecryptor
                public InputStream getInputStream(InputStream inputStream) {
                    return new CipherInputStream(inputStream, cipherCreateStreamCipher);
                }

                @Override // org.bouncycastle.openpgp.operator.PGPDataDecryptor
                public PGPDigestCalculator getIntegrityCalculator() {
                    return new SHA1PGPDigestCalculator();
                }
            };
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("Exception creating cipher", e3);
        }
    }

    MessageDigest createDigest(int i) throws GeneralSecurityException, PGPException {
        String digestName = getDigestName(i);
        try {
            return this.f1478helper.createMessageDigest(digestName);
        } catch (NoSuchAlgorithmException e2) {
            if (i < 8 || i > 11) {
                throw e2;
            }
            return this.f1478helper.createMessageDigest("SHA" + digestName.substring(4));
        }
    }

    public KeyAgreement createKeyAgreement(String str) throws GeneralSecurityException {
        return this.f1478helper.createKeyAgreement(str);
    }

    KeyFactory createKeyFactory(String str) throws GeneralSecurityException, PGPException {
        return this.f1478helper.createKeyFactory(str);
    }

    public KeyPairGenerator createKeyPairGenerator(String str) throws GeneralSecurityException {
        return this.f1478helper.createKeyPairGenerator(str);
    }

    Cipher createKeyWrapper(int i) throws PGPException {
        JcaJceHelper jcaJceHelper;
        String str;
        try {
            switch (i) {
                case 7:
                case 8:
                case 9:
                    jcaJceHelper = this.f1478helper;
                    str = S3KeyWrapScheme.AES_WRAP;
                    break;
                case 10:
                default:
                    throw new PGPException("unknown wrap algorithm: " + i);
                case 11:
                case 12:
                case 13:
                    jcaJceHelper = this.f1478helper;
                    str = "CamelliaWrap";
                    break;
            }
            return jcaJceHelper.createCipher(str);
        } catch (GeneralSecurityException e2) {
            throw new PGPException("cannot create cipher: " + e2.getMessage(), e2);
        }
    }

    Cipher createPublicKeyCipher(int i) throws PGPException {
        String str;
        if (i == 1 || i == 2) {
            str = "RSA/ECB/PKCS1Padding";
        } else {
            if (i != 16) {
                if (i == 17) {
                    throw new PGPException("Can't use DSA for encryption.");
                }
                if (i == 19) {
                    throw new PGPException("Can't use ECDSA for encryption.");
                }
                if (i != 20) {
                    if (i != 22) {
                        throw new PGPException("unknown asymmetric algorithm: " + i);
                    }
                    throw new PGPException("Can't use EDDSA for encryption.");
                }
            }
            str = "ElGamal/ECB/PKCS1Padding";
        }
        return createCipher(str);
    }

    public Signature createSignature(int i, int i2) throws PGPException {
        String str;
        String str2;
        if (i != 1 && i != 3) {
            if (i == 22) {
                str2 = EdDSAParameterSpec.Ed25519;
                return createSignature(str2);
            }
            if (i == 16) {
                str = "ElGamal";
            } else if (i == 17) {
                str = "DSA";
            } else if (i != 19) {
                if (i != 20) {
                    throw new PGPException("unknown algorithm tag in signature:" + i);
                }
                str = "ElGamal";
            } else {
                str = "ECDSA";
            }
            return createSignature(str2);
        }
        str = "RSA";
        str2 = PGPUtil.getDigestName(i2) + "with" + str;
        return createSignature(str2);
    }

    Cipher createStreamCipher(int i, boolean z) throws PGPException {
        return createCipher(PGPUtil.getSymmetricCipherName(i) + MqttTopic.TOPIC_LEVEL_SEPARATOR + (z ? "CFB" : "OpenPGPCFB") + "/NoPadding");
    }

    String getDigestName(int i) throws PGPException {
        switch (i) {
            case 1:
                return StringUtils.MD5;
            case 2:
                return "SHA-1";
            case 3:
                return "RIPEMD160";
            case 4:
            case 7:
            default:
                throw new PGPException("unknown hash algorithm tag in getDigestName: " + i);
            case 5:
                return "MD2";
            case 6:
                return "TIGER";
            case 8:
                return "SHA-256";
            case 9:
                return McElieceCCA2KeyGenParameterSpec.SHA384;
            case 10:
                return "SHA-512";
            case 11:
                return McElieceCCA2KeyGenParameterSpec.SHA224;
        }
    }
}
