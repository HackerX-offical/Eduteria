package org.bouncycastle.openpgp.operator.jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.PBEProtectionRemoverFactory;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PGPDigestCalculatorProvider;

/* JADX INFO: loaded from: classes10.dex */
public class JcePBEProtectionRemoverFactory implements PBEProtectionRemoverFactory {
    private PGPDigestCalculatorProvider calculatorProvider;
    private JcaPGPDigestCalculatorProviderBuilder calculatorProviderBuilder;

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private OperatorHelper f1470helper;
    private final char[] passPhrase;

    public JcePBEProtectionRemoverFactory(char[] cArr) {
        this.f1470helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.passPhrase = cArr;
        this.calculatorProviderBuilder = new JcaPGPDigestCalculatorProviderBuilder();
    }

    public JcePBEProtectionRemoverFactory(char[] cArr, PGPDigestCalculatorProvider pGPDigestCalculatorProvider) {
        this.f1470helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.passPhrase = cArr;
        this.calculatorProvider = pGPDigestCalculatorProvider;
    }

    @Override // org.bouncycastle.openpgp.operator.PBEProtectionRemoverFactory
    public PBESecretKeyDecryptor createDecryptor(String str) throws PGPException {
        if (this.calculatorProvider == null) {
            this.calculatorProvider = this.calculatorProviderBuilder.build();
        }
        return new PBESecretKeyDecryptor(this.passPhrase, this.calculatorProvider) { // from class: org.bouncycastle.openpgp.operator.jcajce.JcePBEProtectionRemoverFactory.1
            @Override // org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor
            public byte[] recoverKeyData(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3) throws PGPException {
                try {
                    Cipher cipherCreateCipher = JcePBEProtectionRemoverFactory.this.f1470helper.createCipher(PGPUtil.getSymmetricCipherName(i) + "/CBC/NoPadding");
                    cipherCreateCipher.init(2, JcaJcePGPUtil.makeSymmetricKey(i, bArr), new IvParameterSpec(bArr2));
                    return cipherCreateCipher.doFinal(bArr3, i2, i3);
                } catch (InvalidAlgorithmParameterException e2) {
                    throw new PGPException("invalid parameter: " + e2.getMessage(), e2);
                } catch (InvalidKeyException e3) {
                    throw new PGPException("invalid key: " + e3.getMessage(), e3);
                } catch (BadPaddingException e4) {
                    throw new PGPException("bad padding: " + e4.getMessage(), e4);
                } catch (IllegalBlockSizeException e5) {
                    throw new PGPException("illegal block size: " + e5.getMessage(), e5);
                }
            }
        };
    }

    public JcePBEProtectionRemoverFactory setProvider(String str) {
        this.f1470helper = new OperatorHelper(new NamedJcaJceHelper(str));
        JcaPGPDigestCalculatorProviderBuilder jcaPGPDigestCalculatorProviderBuilder = this.calculatorProviderBuilder;
        if (jcaPGPDigestCalculatorProviderBuilder != null) {
            jcaPGPDigestCalculatorProviderBuilder.setProvider(str);
        }
        return this;
    }

    public JcePBEProtectionRemoverFactory setProvider(Provider provider) {
        this.f1470helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        JcaPGPDigestCalculatorProviderBuilder jcaPGPDigestCalculatorProviderBuilder = this.calculatorProviderBuilder;
        if (jcaPGPDigestCalculatorProviderBuilder != null) {
            jcaPGPDigestCalculatorProviderBuilder.setProvider(provider);
        }
        return this;
    }
}
