package org.pgpainless.decryption_verification;

import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKey;

/* JADX INFO: loaded from: classes10.dex */
public interface MissingPublicKeyCallback {
    PGPPublicKey onMissingPublicKeyEncountered(@Nonnull Long l);
}
