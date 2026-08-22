package org.pgpainless.key.protection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.bouncycastle.openpgp.operator.PGPDigestCalculatorProvider;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyDecryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyEncryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public class PasswordBasedSecretKeyRingProtector implements SecretKeyRingProtector {
    private static final PGPDigestCalculatorProvider calculatorProvider = new BcPGPDigestCalculatorProvider();
    protected final SecretKeyPassphraseProvider passphraseProvider;
    protected final KeyRingProtectionSettings protectionSettings;

    public PasswordBasedSecretKeyRingProtector(@Nonnull KeyRingProtectionSettings keyRingProtectionSettings, @Nonnull SecretKeyPassphraseProvider secretKeyPassphraseProvider) {
        this.protectionSettings = keyRingProtectionSettings;
        this.passphraseProvider = secretKeyPassphraseProvider;
    }

    @Override // org.pgpainless.key.protection.SecretKeyRingProtector
    @Nullable
    public PBESecretKeyDecryptor getDecryptor(Long l) {
        Passphrase passphraseFor = this.passphraseProvider.getPassphraseFor(l);
        if (passphraseFor == null) {
            return null;
        }
        return new BcPBESecretKeyDecryptorBuilder(calculatorProvider).build(passphraseFor.getChars());
    }

    @Override // org.pgpainless.key.protection.SecretKeyRingProtector
    @Nullable
    public PBESecretKeyEncryptor getEncryptor(Long l) throws PGPException {
        Passphrase passphraseFor = this.passphraseProvider.getPassphraseFor(l);
        if (passphraseFor == null) {
            return null;
        }
        return new BcPBESecretKeyEncryptorBuilder(this.protectionSettings.getEncryptionAlgorithm().getAlgorithmId(), calculatorProvider.get(this.protectionSettings.getHashAlgorithm().getAlgorithmId()), this.protectionSettings.getS2kCount()).build(passphraseFor.getChars());
    }
}
