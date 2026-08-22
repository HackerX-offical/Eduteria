package org.jivesoftware.smackx.ox.callback;

import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public interface SecretKeyPassphraseCallback {
    Passphrase onPassphraseNeeded(OpenPgpV4Fingerprint openPgpV4Fingerprint);
}
