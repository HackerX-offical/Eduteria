package org.pgpainless.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyRing;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.util.io.Streams;
import org.pgpainless.algorithm.KeyFlag;
import org.pgpainless.key.selection.key.impl.NoRevocation;
import org.pgpainless.key.selection.key.impl.SignedByMasterKey;
import org.pgpainless.key.selection.key.util.And;

/* JADX INFO: loaded from: classes10.dex */
public class BCUtil {
    private static final Logger LOGGER = Logger.getLogger(BCUtil.class.getName());

    public static PGPPublicKeyRingCollection keyRingsToKeyRingCollection(@Nonnull PGPPublicKeyRing... pGPPublicKeyRingArr) throws IOException, PGPException {
        return new PGPPublicKeyRingCollection(Arrays.asList(pGPPublicKeyRingArr));
    }

    public static PGPSecretKeyRingCollection keyRingsToKeyRingCollection(@Nonnull PGPSecretKeyRing... pGPSecretKeyRingArr) throws IOException, PGPException {
        return new PGPSecretKeyRingCollection(Arrays.asList(pGPSecretKeyRingArr));
    }

    public static PGPPublicKeyRing publicKeyRingFromSecretKeyRing(@Nonnull PGPSecretKeyRing pGPSecretKeyRing) throws IOException, PGPException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        Iterator<PGPSecretKey> it = pGPSecretKeyRing.iterator();
        while (it.hasNext()) {
            PGPPublicKey publicKey = it.next().getPublicKey();
            if (publicKey != null) {
                publicKey.encode(byteArrayOutputStream, false);
            }
        }
        return new PGPPublicKeyRing(byteArrayOutputStream.toByteArray(), new BcKeyFingerprintCalculator());
    }

    public static PGPSecretKeyRing getKeyRingFromCollection(@Nonnull PGPSecretKeyRingCollection pGPSecretKeyRingCollection, @Nonnull Long l) throws PGPException {
        PGPSecretKeyRing secretKeyRing = pGPSecretKeyRingCollection.getSecretKeyRing(l.longValue());
        HashSet hashSet = new HashSet();
        hashSet.add(l);
        Iterator<PGPPublicKey> keysWithSignaturesBy = secretKeyRing.getKeysWithSignaturesBy(l.longValue());
        while (keysWithSignaturesBy.hasNext()) {
            hashSet.add(Long.valueOf(keysWithSignaturesBy.next().getKeyID()));
        }
        Iterator<PGPSecretKey> secretKeys = secretKeyRing.getSecretKeys();
        while (secretKeys.hasNext()) {
            PGPSecretKey next = secretKeys.next();
            if (!hashSet.contains(Long.valueOf(next.getKeyID()))) {
                secretKeyRing = PGPSecretKeyRing.removeSecretKey(secretKeyRing, next);
            }
        }
        return secretKeyRing;
    }

    public static PGPPublicKeyRing getKeyRingFromCollection(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection, @Nonnull Long l) throws PGPException {
        return removeUnassociatedKeysFromKeyRing(pGPPublicKeyRingCollection.getPublicKeyRing(l.longValue()), pGPPublicKeyRingCollection.getPublicKey(l.longValue()));
    }

    public static InputStream getPgpDecoderInputStream(@Nonnull byte[] bArr) throws IOException {
        return getPgpDecoderInputStream(new ByteArrayInputStream(bArr));
    }

    public static InputStream getPgpDecoderInputStream(@Nonnull InputStream inputStream) throws IOException {
        return PGPUtil.getDecoderStream(inputStream);
    }

    public static byte[] getDecodedBytes(@Nonnull byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Streams.pipeAll(getPgpDecoderInputStream(bArr), byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] getDecodedBytes(@Nonnull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Streams.pipeAll(inputStream, byteArrayOutputStream);
        return getDecodedBytes(byteArrayOutputStream.toByteArray());
    }

    public static PGPPublicKeyRing removeUnassociatedKeysFromKeyRing(@Nonnull PGPPublicKeyRing pGPPublicKeyRing, @Nonnull PGPPublicKey pGPPublicKey) {
        if (!pGPPublicKey.isMasterKey()) {
            throw new IllegalArgumentException("Given key is not a master key.");
        }
        And.PubKeySelectionStrategy pubKeySelectionStrategy = new And.PubKeySelectionStrategy(new SignedByMasterKey.PubkeySelectionStrategy(), new NoRevocation.PubKeySelectionStrategy());
        Iterator<PGPPublicKey> publicKeys = pGPPublicKeyRing.getPublicKeys();
        while (publicKeys.hasNext()) {
            PGPPublicKey next = publicKeys.next();
            if (!pubKeySelectionStrategy.accept(pGPPublicKey, next)) {
                pGPPublicKeyRing = PGPPublicKeyRing.removePublicKey(pGPPublicKeyRing, next);
            }
        }
        return pGPPublicKeyRing;
    }

    public static PGPSecretKeyRing removeUnassociatedKeysFromKeyRing(@Nonnull PGPSecretKeyRing pGPSecretKeyRing, @Nonnull PGPPublicKey pGPPublicKey) {
        if (!pGPPublicKey.isMasterKey()) {
            throw new IllegalArgumentException("Given key is not a master key.");
        }
        And.PubKeySelectionStrategy pubKeySelectionStrategy = new And.PubKeySelectionStrategy(new SignedByMasterKey.PubkeySelectionStrategy(), new NoRevocation.PubKeySelectionStrategy());
        Iterator<PGPSecretKey> secretKeys = pGPSecretKeyRing.getSecretKeys();
        while (secretKeys.hasNext()) {
            PGPSecretKey next = secretKeys.next();
            if (!pubKeySelectionStrategy.accept(pGPPublicKey, next.getPublicKey())) {
                pGPSecretKeyRing = PGPSecretKeyRing.removeSecretKey(pGPSecretKeyRing, next);
            }
        }
        return pGPSecretKeyRing;
    }

    public static PGPPublicKey getMasterKeyFrom(@Nonnull PGPPublicKeyRing pGPPublicKeyRing) {
        Iterator<PGPPublicKey> publicKeys = pGPPublicKeyRing.getPublicKeys();
        while (publicKeys.hasNext()) {
            PGPPublicKey next = publicKeys.next();
            if (next.isMasterKey()) {
                return next;
            }
        }
        return null;
    }

    public static PGPPublicKey getMasterKeyFrom(@Nonnull PGPKeyRing pGPKeyRing) {
        Iterator<PGPPublicKey> publicKeys = pGPKeyRing.getPublicKeys();
        while (publicKeys.hasNext()) {
            PGPPublicKey next = publicKeys.next();
            if (next.isMasterKey()) {
                return next;
            }
        }
        return null;
    }

    public static Set<Long> signingKeyIds(@Nonnull PGPSecretKeyRing pGPSecretKeyRing) {
        HashSet hashSet = new HashSet();
        Iterator<PGPPublicKey> publicKeys = pGPSecretKeyRing.getPublicKeys();
        while (publicKeys.hasNext()) {
            PGPPublicKey next = publicKeys.next();
            Iterator signatures = next.getSignatures();
            while (true) {
                if (signatures.hasNext()) {
                    Object next2 = signatures.next();
                    if (next2 instanceof PGPSignature) {
                        PGPSignature pGPSignature = (PGPSignature) next2;
                        if (pGPSignature.hasSubpackets()) {
                            try {
                                pGPSignature.verifyCertification(pGPSecretKeyRing.getPublicKey(pGPSignature.getKeyID()));
                                if (KeyFlag.fromBitmask(pGPSignature.getHashedSubPackets().getKeyFlags()).contains(KeyFlag.SIGN_DATA)) {
                                    hashSet.add(Long.valueOf(next.getKeyID()));
                                    break;
                                }
                            } catch (PGPException unused) {
                                LOGGER.log(Level.WARNING, "Could not verify signature on " + Long.toHexString(next.getKeyID()) + " made by " + Long.toHexString(pGPSignature.getKeyID()));
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return hashSet;
    }

    public static boolean keyRingContainsKeyWithId(@Nonnull PGPPublicKeyRing pGPPublicKeyRing, long j) {
        return pGPPublicKeyRing.getPublicKey(j) != null;
    }

    public static boolean keyRingContainsKeyWithId(@Nonnull PGPSecretKeyRing pGPSecretKeyRing, long j) {
        return pGPSecretKeyRing.getSecretKey(j) != null;
    }
}
