package org.jivesoftware.smackx.ox.crypto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.util.io.Streams;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.OpenPgpMessage;
import org.jivesoftware.smackx.ox.OpenPgpSelf;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.pgpainless.PGPainless;
import org.pgpainless.decryption_verification.DecryptionStream;
import org.pgpainless.decryption_verification.MissingPublicKeyCallback;
import org.pgpainless.decryption_verification.OpenPgpMetadata;
import org.pgpainless.encryption_signing.EncryptionStream;

/* JADX INFO: loaded from: classes10.dex */
public class PainlessOpenPgpProvider implements OpenPgpProvider {
    private static final Logger LOGGER = Logger.getLogger(PainlessOpenPgpProvider.class.getName());
    private final OpenPgpStore store;

    public PainlessOpenPgpProvider(OpenPgpStore openPgpStore) {
        this.store = (OpenPgpStore) Objects.requireNonNull(openPgpStore);
    }

    @Override // org.jivesoftware.smackx.ox.crypto.OpenPgpProvider
    public OpenPgpStore getStore() {
        return this.store;
    }

    @Override // org.jivesoftware.smackx.ox.crypto.OpenPgpProvider
    public OpenPgpElementAndMetadata signAndEncrypt(SigncryptElement signcryptElement, OpenPgpSelf openPgpSelf, Collection<OpenPgpContact> collection) throws IOException, PGPException {
        InputStream inputStream = signcryptElement.toInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList arrayList = new ArrayList();
        for (OpenPgpContact openPgpContact : collection) {
            PGPPublicKeyRingCollection trustedAnnouncedKeys = openPgpContact.getTrustedAnnouncedKeys();
            if (trustedAnnouncedKeys != null) {
                arrayList.add(trustedAnnouncedKeys);
            } else {
                LOGGER.log(Level.WARNING, "There are no suitable keys for contact " + openPgpContact.getJid().toString());
            }
        }
        EncryptionStream encryptionStreamNoArmor = PGPainless.createEncryptor().onOutputStream(byteArrayOutputStream).toRecipients((PGPPublicKeyRingCollection[]) arrayList.toArray(new PGPPublicKeyRingCollection[0])).andToSelf(openPgpSelf.getTrustedAnnouncedKeys()).usingSecureAlgorithms().signWith(getStore().getKeyRingProtector(), openPgpSelf.getSigningKeyRing()).noArmor();
        Streams.pipeAll(inputStream, encryptionStreamNoArmor);
        inputStream.close();
        encryptionStreamNoArmor.flush();
        encryptionStreamNoArmor.close();
        byteArrayOutputStream.close();
        return new OpenPgpElementAndMetadata(new OpenPgpElement(Base64.encodeToString(byteArrayOutputStream.toByteArray())), encryptionStreamNoArmor.getResult());
    }

    @Override // org.jivesoftware.smackx.ox.crypto.OpenPgpProvider
    public OpenPgpElementAndMetadata sign(SignElement signElement, OpenPgpSelf openPgpSelf) throws IOException, PGPException {
        InputStream inputStream = signElement.toInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        EncryptionStream encryptionStreamNoArmor = PGPainless.createEncryptor().onOutputStream(byteArrayOutputStream).doNotEncrypt().signWith(getStore().getKeyRingProtector(), openPgpSelf.getSigningKeyRing()).noArmor();
        Streams.pipeAll(inputStream, encryptionStreamNoArmor);
        inputStream.close();
        encryptionStreamNoArmor.flush();
        encryptionStreamNoArmor.close();
        byteArrayOutputStream.close();
        return new OpenPgpElementAndMetadata(new OpenPgpElement(Base64.encodeToString(byteArrayOutputStream.toByteArray())), encryptionStreamNoArmor.getResult());
    }

    @Override // org.jivesoftware.smackx.ox.crypto.OpenPgpProvider
    public OpenPgpElementAndMetadata encrypt(CryptElement cryptElement, OpenPgpSelf openPgpSelf, Collection<OpenPgpContact> collection) throws IOException, PGPException {
        InputStream inputStream = cryptElement.toInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList arrayList = new ArrayList();
        for (OpenPgpContact openPgpContact : collection) {
            PGPPublicKeyRingCollection trustedAnnouncedKeys = openPgpContact.getTrustedAnnouncedKeys();
            if (trustedAnnouncedKeys != null) {
                arrayList.add(trustedAnnouncedKeys);
            } else {
                LOGGER.log(Level.WARNING, "There are no suitable keys for contact " + openPgpContact.getJid().toString());
            }
        }
        EncryptionStream encryptionStreamNoArmor = PGPainless.createEncryptor().onOutputStream(byteArrayOutputStream).toRecipients((PGPPublicKeyRingCollection[]) arrayList.toArray(new PGPPublicKeyRingCollection[0])).andToSelf(openPgpSelf.getTrustedAnnouncedKeys()).usingSecureAlgorithms().doNotSign().noArmor();
        Streams.pipeAll(inputStream, encryptionStreamNoArmor);
        inputStream.close();
        encryptionStreamNoArmor.flush();
        encryptionStreamNoArmor.close();
        byteArrayOutputStream.close();
        return new OpenPgpElementAndMetadata(new OpenPgpElement(Base64.encodeToString(byteArrayOutputStream.toByteArray())), encryptionStreamNoArmor.getResult());
    }

    @Override // org.jivesoftware.smackx.ox.crypto.OpenPgpProvider
    public OpenPgpMessage decryptAndOrVerify(final XMPPConnection xMPPConnection, OpenPgpElement openPgpElement, OpenPgpSelf openPgpSelf, final OpenPgpContact openPgpContact) throws IOException, PGPException {
        OpenPgpMessage.State state;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = openPgpElement.toInputStream();
        PGPPublicKeyRingCollection announcedPublicKeys = openPgpContact.getAnnouncedPublicKeys();
        if (announcedPublicKeys == null) {
            LOGGER.log(Level.INFO, "Received a message from " + ((Object) openPgpContact.getJid()) + " but we have no keys yet. Try fetching them.");
            try {
                openPgpContact.updateKeys(xMPPConnection);
                announcedPublicKeys = openPgpContact.getAnnouncedPublicKeys();
            } catch (Exception e2) {
                LOGGER.log(Level.SEVERE, "Fetching keys of " + ((Object) openPgpContact.getJid()) + " failed. Abort decryption and discard message.", (Throwable) e2);
                throw new PGPException("Abort decryption due to lack of keys.", e2);
            }
        }
        DecryptionStream decryptionStreamBuild = PGPainless.createDecryptor().onInputStream(inputStream).decryptWith(getStore().getKeyRingProtector(), openPgpSelf.getSecretKeys()).verifyWith(announcedPublicKeys).handleMissingPublicKeysWith(new MissingPublicKeyCallback() { // from class: org.jivesoftware.smackx.ox.crypto.PainlessOpenPgpProvider.1
            @Override // org.pgpainless.decryption_verification.MissingPublicKeyCallback
            public PGPPublicKey onMissingPublicKeyEncountered(Long l) {
                try {
                    openPgpContact.updateKeys(xMPPConnection);
                    return openPgpContact.getAnyPublicKeys().getPublicKey(l.longValue());
                } catch (Exception e3) {
                    PainlessOpenPgpProvider.LOGGER.log(Level.WARNING, "Cannot fetch missing key " + l, (Throwable) e3);
                    return null;
                }
            }
        }).build();
        Streams.pipeAll(decryptionStreamBuild, byteArrayOutputStream);
        inputStream.close();
        decryptionStreamBuild.close();
        byteArrayOutputStream.close();
        OpenPgpMetadata result = decryptionStreamBuild.getResult();
        if (result.isSigned()) {
            if (result.isEncrypted()) {
                state = OpenPgpMessage.State.signcrypt;
            } else {
                state = OpenPgpMessage.State.sign;
            }
        } else if (result.isEncrypted()) {
            state = OpenPgpMessage.State.crypt;
        } else {
            throw new PGPException("Received message appears to be neither encrypted, nor signed.");
        }
        return new OpenPgpMessage(byteArrayOutputStream.toByteArray(), state, result);
    }
}
