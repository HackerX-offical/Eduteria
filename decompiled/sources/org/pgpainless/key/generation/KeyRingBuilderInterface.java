package org.pgpainless.key.generation;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.pgpainless.key.collection.PGPKeyRing;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public interface KeyRingBuilderInterface {

    public interface Build {
        PGPKeyRing build() throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException;
    }

    public interface WithPassphrase {
        Build withPassphrase(@Nonnull Passphrase passphrase);

        Build withoutPassphrase();
    }

    public interface WithPrimaryUserId {
        WithPassphrase withPrimaryUserId(@Nonnull String str);

        WithPassphrase withPrimaryUserId(@Nonnull byte[] bArr);
    }

    WithPrimaryUserId withMasterKey(@Nonnull KeySpec keySpec);

    KeyRingBuilderInterface withSubKey(@Nonnull KeySpec keySpec);
}
