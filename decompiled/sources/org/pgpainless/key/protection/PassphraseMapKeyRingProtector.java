package org.pgpainless.key.protection;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public class PassphraseMapKeyRingProtector implements SecretKeyRingProtector, SecretKeyPassphraseProvider {
    private final Map<Long, Passphrase> cache;
    private final SecretKeyRingProtector protector;
    private final SecretKeyPassphraseProvider provider;

    public PassphraseMapKeyRingProtector(@Nonnull Map<Long, Passphrase> map, @Nonnull KeyRingProtectionSettings keyRingProtectionSettings, @Nullable SecretKeyPassphraseProvider secretKeyPassphraseProvider) {
        HashMap map2 = new HashMap();
        this.cache = map2;
        map2.putAll(map);
        this.protector = new PasswordBasedSecretKeyRingProtector(keyRingProtectionSettings, this);
        this.provider = secretKeyPassphraseProvider;
    }

    public void addPassphrase(@Nonnull Long l, @Nullable Passphrase passphrase) {
        this.cache.put(l, passphrase);
    }

    public void forgetPassphrase(@Nonnull Long l) {
        this.cache.get(l).clear();
        this.cache.remove(l);
    }

    @Override // org.pgpainless.key.protection.SecretKeyPassphraseProvider
    @Nullable
    public Passphrase getPassphraseFor(@Nonnull Long l) {
        Passphrase passphrase = this.cache.get(l);
        if (passphrase != null && passphrase.isValid()) {
            return passphrase;
        }
        Passphrase passphraseFor = this.provider.getPassphraseFor(l);
        if (passphraseFor != null) {
            this.cache.put(l, passphraseFor);
        }
        return passphraseFor;
    }

    @Override // org.pgpainless.key.protection.SecretKeyRingProtector
    @Nullable
    public PBESecretKeyDecryptor getDecryptor(@Nonnull Long l) {
        return this.protector.getDecryptor(l);
    }

    @Override // org.pgpainless.key.protection.SecretKeyRingProtector
    @Nullable
    public PBESecretKeyEncryptor getEncryptor(@Nonnull Long l) throws PGPException {
        return this.protector.getEncryptor(l);
    }
}
