package org.pgpainless.decryption_verification;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPSignature;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.protection.SecretKeyRingProtector;
import org.pgpainless.key.protection.UnprotectedKeysProtector;

/* JADX INFO: loaded from: classes10.dex */
public interface DecryptionBuilderInterface {

    public interface Build {
        DecryptionStream build() throws IOException, PGPException;
    }

    public interface HandleMissingPublicKeys {
        Build handleMissingPublicKeysWith(@Nonnull MissingPublicKeyCallback missingPublicKeyCallback);

        Build ignoreMissingPublicKeys();
    }

    DecryptWith onInputStream(@Nonnull InputStream inputStream);

    public interface DecryptWith {
        Verify decryptWith(@Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull PGPSecretKeyRingCollection pGPSecretKeyRingCollection);

        Verify doNotDecrypt();

        default Verify decryptWith(@Nonnull PGPSecretKeyRingCollection pGPSecretKeyRingCollection) {
            return decryptWith(new UnprotectedKeysProtector(), pGPSecretKeyRingCollection);
        }
    }

    public interface Verify extends VerifyWith {
        Build doNotVerify();

        VerifyWith verifyDetachedSignature(@Nonnull InputStream inputStream) throws IOException, PGPException;

        VerifyWith verifyDetachedSignatures(@Nonnull List<PGPSignature> list);

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        HandleMissingPublicKeys verifyWith(@Nonnull Set<PGPPublicKeyRing> set);

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        HandleMissingPublicKeys verifyWith(@Nonnull Set<OpenPgpV4Fingerprint> set, @Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection);

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        HandleMissingPublicKeys verifyWith(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection);

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        default HandleMissingPublicKeys verifyWith(@Nonnull OpenPgpV4Fingerprint openPgpV4Fingerprint, @Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            return verifyWith(Collections.singleton(openPgpV4Fingerprint), pGPPublicKeyRingCollection);
        }

        @Override // org.pgpainless.decryption_verification.DecryptionBuilderInterface.VerifyWith
        default HandleMissingPublicKeys verifyWith(@Nonnull PGPPublicKeyRing pGPPublicKeyRing) {
            return verifyWith(Collections.singleton(pGPPublicKeyRing));
        }

        default VerifyWith verifyDetachedSignature(@Nonnull byte[] bArr) throws IOException, PGPException {
            return verifyDetachedSignature(new ByteArrayInputStream(bArr));
        }

        default VerifyWith verifyDetachedSignature(@Nonnull PGPSignature pGPSignature) {
            return verifyDetachedSignatures(Collections.singletonList(pGPSignature));
        }
    }

    public interface VerifyWith {
        HandleMissingPublicKeys verifyWith(@Nonnull Set<PGPPublicKeyRing> set);

        HandleMissingPublicKeys verifyWith(@Nonnull Set<OpenPgpV4Fingerprint> set, @Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection);

        HandleMissingPublicKeys verifyWith(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection);

        default HandleMissingPublicKeys verifyWith(@Nonnull OpenPgpV4Fingerprint openPgpV4Fingerprint, @Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            return verifyWith(Collections.singleton(openPgpV4Fingerprint), pGPPublicKeyRingCollection);
        }

        default HandleMissingPublicKeys verifyWith(@Nonnull PGPPublicKeyRing pGPPublicKeyRing) {
            return verifyWith(Collections.singleton(pGPPublicKeyRing));
        }
    }
}
