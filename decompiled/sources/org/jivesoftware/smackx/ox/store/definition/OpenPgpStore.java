package org.jivesoftware.smackx.ox.store.definition;

import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.callback.SecretKeyPassphraseCallback;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.protection.SecretKeyRingProtector;

/* JADX INFO: loaded from: classes10.dex */
public interface OpenPgpStore extends OpenPgpKeyStore, OpenPgpMetadataStore, OpenPgpTrustStore {
    SecretKeyRingProtector getKeyRingProtector();

    OpenPgpContact getOpenPgpContact(BareJid bareJid);

    void setKeyRingProtector(SecretKeyRingProtector secretKeyRingProtector);

    void setSecretKeyPassphraseCallback(SecretKeyPassphraseCallback secretKeyPassphraseCallback);
}
