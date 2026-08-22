package com.clevertap.android.sdk.cryption;

import kotlin.Metadata;

/* JADX INFO: compiled from: CryptRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/clevertap/android/sdk/cryption/ICryptRepository;", "", "storedEncryptionLevel", "", "isSSInAppDataMigrated", "", "updateIsSSInAppDataMigrated", "", "migrated", "migrationFailureCount", "localEncryptionKey", "", "updateLocalEncryptionKey", "key", "updateEncryptionLevel", "configEncryptionLevel", "updateMigrationFailureCount", "migrationSuccessful", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICryptRepository {
    boolean isSSInAppDataMigrated();

    String localEncryptionKey();

    int migrationFailureCount();

    int storedEncryptionLevel();

    void updateEncryptionLevel(int configEncryptionLevel);

    void updateIsSSInAppDataMigrated(boolean migrated);

    void updateLocalEncryptionKey(String key);

    void updateMigrationFailureCount(boolean migrationSuccessful);
}
