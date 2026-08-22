package org.jivesoftware.smackx.ox.crypto;

import java.io.IOException;
import java.util.Collection;
import org.bouncycastle.openpgp.PGPException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.OpenPgpMessage;
import org.jivesoftware.smackx.ox.OpenPgpSelf;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;

/* JADX INFO: loaded from: classes10.dex */
public interface OpenPgpProvider {
    OpenPgpMessage decryptAndOrVerify(XMPPConnection xMPPConnection, OpenPgpElement openPgpElement, OpenPgpSelf openPgpSelf, OpenPgpContact openPgpContact) throws IOException, PGPException;

    OpenPgpElementAndMetadata encrypt(CryptElement cryptElement, OpenPgpSelf openPgpSelf, Collection<OpenPgpContact> collection) throws IOException, PGPException;

    OpenPgpStore getStore();

    OpenPgpElementAndMetadata sign(SignElement signElement, OpenPgpSelf openPgpSelf) throws IOException, PGPException;

    OpenPgpElementAndMetadata signAndEncrypt(SigncryptElement signcryptElement, OpenPgpSelf openPgpSelf, Collection<OpenPgpContact> collection) throws IOException, PGPException;
}
