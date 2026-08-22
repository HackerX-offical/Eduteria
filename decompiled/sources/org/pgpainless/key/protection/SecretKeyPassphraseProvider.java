package org.pgpainless.key.protection;

import javax.annotation.Nullable;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public interface SecretKeyPassphraseProvider {
    @Nullable
    Passphrase getPassphraseFor(Long l);
}
