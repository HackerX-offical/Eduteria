package org.jivesoftware.smackx.ox.callback.backup;

import java.util.Set;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public interface SecretKeyBackupSelectionCallback {
    Set<OpenPgpV4Fingerprint> selectKeysToBackup(Set<OpenPgpV4Fingerprint> set);
}
