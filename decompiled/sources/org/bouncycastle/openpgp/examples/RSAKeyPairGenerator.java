package org.bouncycastle.openpgp.examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import java.util.Date;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyPair;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class RSAKeyPairGenerator {
    private static void exportKeyPair(OutputStream outputStream, OutputStream outputStream2, KeyPair keyPair, String str, char[] cArr, boolean z) throws SignatureException, IOException, InvalidKeyException, PGPException, NoSuchProviderException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        PGPDigestCalculator pGPDigestCalculator = new JcaPGPDigestCalculatorProviderBuilder().build().get(2);
        JcaPGPKeyPair jcaPGPKeyPair = new JcaPGPKeyPair(1, keyPair, new Date());
        PGPSecretKey pGPSecretKey = new PGPSecretKey(16, jcaPGPKeyPair, str, pGPDigestCalculator, null, null, new JcaPGPContentSignerBuilder(jcaPGPKeyPair.getPublicKey().getAlgorithm(), 2), new JcePBESecretKeyEncryptorBuilder(3, pGPDigestCalculator).setProvider(BouncyCastleProvider.PROVIDER_NAME).build(cArr));
        pGPSecretKey.encode(outputStream);
        outputStream.close();
        if (z) {
            outputStream2 = new ArmoredOutputStream(outputStream2);
        }
        pGPSecretKey.getPublicKey().encode(outputStream2);
        outputStream2.close();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME);
        keyPairGenerator.initialize(1024);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        if (strArr.length < 2) {
            System.out.println("RSAKeyPairGenerator [-a] identity passPhrase");
            System.exit(0);
        }
        if (!strArr[0].equals("-a")) {
            exportKeyPair(new FileOutputStream("secret.bpg"), new FileOutputStream("pub.bpg"), keyPairGenerateKeyPair, strArr[0], strArr[1].toCharArray(), false);
            return;
        }
        if (strArr.length < 3) {
            System.out.println("RSAKeyPairGenerator [-a] identity passPhrase");
            System.exit(0);
        }
        exportKeyPair(new FileOutputStream("secret.asc"), new FileOutputStream("pub.asc"), keyPairGenerateKeyPair, strArr[1], strArr[2].toCharArray(), true);
    }
}
