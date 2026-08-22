package org.bouncycastle.openpgp.examples;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Security;
import java.util.Iterator;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.sig.NotationData;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class DirectKeySignature {
    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (strArr.length == 1) {
            Iterator signaturesOfType = new PGPPublicKeyRing(PGPUtil.getDecoderStream(new FileInputStream(strArr[0])), new JcaKeyFingerprintCalculator()).getPublicKey().getSignaturesOfType(31);
            while (signaturesOfType.hasNext()) {
                PGPSignature pGPSignature = (PGPSignature) signaturesOfType.next();
                System.out.println("Signature date is: " + pGPSignature.getHashedSubPackets().getSignatureCreationTime());
                NotationData[] notationDataOccurrences = pGPSignature.getHashedSubPackets().getNotationDataOccurrences();
                for (int i = 0; i < notationDataOccurrences.length; i++) {
                    System.out.println("Found Notation named '" + notationDataOccurrences[i].getNotationName() + "' with content '" + notationDataOccurrences[i].getNotationValue() + "'.");
                }
            }
            return;
        }
        if (strArr.length != 5) {
            System.err.println("usage: DirectKeySignature secretKeyFile secretKeyPass publicKeyFile(key to be signed) NotationName NotationValue");
            System.err.println("or: DirectKeySignature signedPublicKeyFile");
            return;
        }
        PGPSecretKeyRing pGPSecretKeyRing = new PGPSecretKeyRing(PGPUtil.getDecoderStream(new FileInputStream(strArr[0])), new JcaKeyFingerprintCalculator());
        PGPPublicKeyRing pGPPublicKeyRing = new PGPPublicKeyRing(new ByteArrayInputStream(signPublicKey(pGPSecretKeyRing.getSecretKey(), strArr[1], new PGPPublicKeyRing(PGPUtil.getDecoderStream(new FileInputStream(strArr[2])), new JcaKeyFingerprintCalculator()).getPublicKey(), strArr[3], strArr[4])), new JcaKeyFingerprintCalculator());
        ArmoredOutputStream armoredOutputStream = new ArmoredOutputStream(new FileOutputStream("SignedKey.asc"));
        pGPPublicKeyRing.encode(armoredOutputStream);
        armoredOutputStream.flush();
        armoredOutputStream.close();
    }

    private static byte[] signPublicKey(PGPSecretKey pGPSecretKey, String str, PGPPublicKey pGPPublicKey, String str2, String str3) throws Exception {
        PGPPrivateKey pGPPrivateKeyExtractPrivateKey = pGPSecretKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider(BouncyCastleProvider.PROVIDER_NAME).build(str.toCharArray()));
        PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(new JcaPGPContentSignerBuilder(pGPSecretKey.getPublicKey().getAlgorithm(), 2).setProvider(BouncyCastleProvider.PROVIDER_NAME));
        pGPSignatureGenerator.init(31, pGPPrivateKeyExtractPrivateKey);
        PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator = new PGPSignatureSubpacketGenerator();
        pGPSignatureSubpacketGenerator.setNotationData(true, true, str2, str3);
        pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketGenerator.generate());
        return PGPPublicKey.addCertification(pGPPublicKey, pGPSignatureGenerator.generate()).getEncoded();
    }
}
