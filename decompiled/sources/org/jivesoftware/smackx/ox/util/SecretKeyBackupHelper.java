package org.jivesoftware.smackx.ox.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.ox.OpenPgpSecretKeyBackupPassphrase;
import org.jivesoftware.smackx.ox.crypto.OpenPgpProvider;
import org.jivesoftware.smackx.ox.element.SecretkeyElement;
import org.jivesoftware.smackx.ox.exception.InvalidBackupCodeException;
import org.jivesoftware.smackx.ox.exception.MissingOpenPgpKeyException;
import org.jxmpp.jid.BareJid;
import org.pgpainless.PGPainless;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public class SecretKeyBackupHelper {
    public static OpenPgpSecretKeyBackupPassphrase generateBackupPassword() {
        return new OpenPgpSecretKeyBackupPassphrase(StringUtils.secureOfflineAttackSafeRandomString());
    }

    public static SecretkeyElement createSecretkeyElement(OpenPgpProvider openPgpProvider, BareJid bareJid, Set<OpenPgpV4Fingerprint> set, OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphrase) throws IOException, PGPException, MissingOpenPgpKeyException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (OpenPgpV4Fingerprint openPgpV4Fingerprint : set) {
            PGPSecretKeyRing secretKeyRing = openPgpProvider.getStore().getSecretKeyRing(bareJid, openPgpV4Fingerprint);
            if (secretKeyRing == null) {
                throw new MissingOpenPgpKeyException(bareJid, openPgpV4Fingerprint);
            }
            byteArrayOutputStream.write(secretKeyRing.getEncoded());
        }
        return createSecretkeyElement(byteArrayOutputStream.toByteArray(), openPgpSecretKeyBackupPassphrase);
    }

    public static SecretkeyElement createSecretkeyElement(byte[] bArr, OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphrase) throws IOException, PGPException {
        return new SecretkeyElement(Base64.encode(PGPainless.encryptWithPassword(bArr, new Passphrase(openPgpSecretKeyBackupPassphrase.toString().toCharArray()), SymmetricKeyAlgorithm.AES_256)));
    }

    public static PGPSecretKeyRing restoreSecretKeyBackup(SecretkeyElement secretkeyElement, OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphrase) throws InvalidBackupCodeException, IOException, PGPException {
        try {
            return PGPainless.readKeyRing().secretKeyRing(PGPainless.decryptWithPassword(Base64.decode(secretkeyElement.getB64Data()), new Passphrase(openPgpSecretKeyBackupPassphrase.toString().toCharArray())));
        } catch (IOException | PGPException e2) {
            throw new InvalidBackupCodeException("Could not decrypt secret key backup. Possibly wrong passphrase?", e2);
        }
    }
}
