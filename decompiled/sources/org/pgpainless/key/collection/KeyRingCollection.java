package org.pgpainless.key.collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.pgpainless.PGPainless;

/* JADX INFO: loaded from: classes10.dex */
public class KeyRingCollection {
    private static final Logger LOGGER = Logger.getLogger(KeyRingCollection.class.getName());
    private PGPPublicKeyRingCollection publicKeys;
    private PGPSecretKeyRingCollection secretKeys;

    public KeyRingCollection(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection, @Nonnull PGPSecretKeyRingCollection pGPSecretKeyRingCollection) {
        this.publicKeys = pGPPublicKeyRingCollection;
        this.secretKeys = pGPSecretKeyRingCollection;
    }

    public KeyRingCollection(File file, File file2) throws IOException, PGPException {
        if (file == null && file2 == null) {
            throw new NullPointerException("pubRingFile and secRingFile cannot BOTH be null.");
        }
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            this.publicKeys = PGPainless.readKeyRing().publicKeyRingCollection(fileInputStream);
            fileInputStream.close();
        }
        if (file2 != null) {
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            this.secretKeys = PGPainless.readKeyRing().secretKeyRingCollection(fileInputStream2);
            fileInputStream2.close();
        }
    }

    public KeyRingCollection(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
        this.publicKeys = pGPPublicKeyRingCollection;
    }

    public KeyRingCollection(@Nonnull PGPSecretKeyRingCollection pGPSecretKeyRingCollection) {
        this.secretKeys = pGPSecretKeyRingCollection;
    }

    public void importPublicKeys(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
        if (this.publicKeys == null) {
            this.publicKeys = pGPPublicKeyRingCollection;
            return;
        }
        for (PGPPublicKeyRing pGPPublicKeyRing : pGPPublicKeyRingCollection) {
            try {
                this.publicKeys = PGPPublicKeyRingCollection.addPublicKeyRing(this.publicKeys, pGPPublicKeyRing);
            } catch (IllegalArgumentException unused) {
                LOGGER.log(Level.FINE, "Keyring " + Long.toHexString(pGPPublicKeyRing.getPublicKey().getKeyID()) + " is already included in the collection. Skip!");
            }
        }
    }

    public void importSecretKeys(@Nonnull PGPSecretKeyRingCollection pGPSecretKeyRingCollection) {
        if (this.secretKeys == null) {
            this.secretKeys = pGPSecretKeyRingCollection;
            return;
        }
        for (PGPSecretKeyRing pGPSecretKeyRing : pGPSecretKeyRingCollection) {
            try {
                this.secretKeys = PGPSecretKeyRingCollection.addSecretKeyRing(this.secretKeys, pGPSecretKeyRing);
            } catch (IllegalArgumentException unused) {
                LOGGER.log(Level.FINE, "Keyring " + Long.toHexString(pGPSecretKeyRing.getPublicKey().getKeyID()) + " is already included in the collection. Skip!");
            }
        }
    }
}
