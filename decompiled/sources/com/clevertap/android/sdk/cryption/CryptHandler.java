package com.clevertap.android.sdk.cryption;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CryptHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/clevertap/android/sdk/cryption/CryptHandler;", "Lcom/clevertap/android/sdk/cryption/ICryptHandler;", "repository", "Lcom/clevertap/android/sdk/cryption/CryptRepository;", "cryptFactory", "Lcom/clevertap/android/sdk/cryption/CryptFactory;", "<init>", "(Lcom/clevertap/android/sdk/cryption/CryptRepository;Lcom/clevertap/android/sdk/cryption/CryptFactory;)V", "encryptSafe", "", "plainText", "decryptSafe", "cipherText", "encrypt", "decrypt", "decryptWithAlgorithm", "algorithm", "Lcom/clevertap/android/sdk/cryption/CryptHandler$EncryptionAlgorithm;", "updateMigrationFailureCount", "", "migrationSuccessful", "", "EncryptionAlgorithm", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CryptHandler implements ICryptHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final EncryptionAlgorithm DEFAULT_ALGORITHM = EncryptionAlgorithm.AES_GCM;
    private final CryptFactory cryptFactory;
    private final CryptRepository repository;

    @JvmStatic
    public static final boolean isTextEncrypted(String str) {
        return INSTANCE.isTextEncrypted(str);
    }

    public CryptHandler(CryptRepository repository, CryptFactory cryptFactory) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(cryptFactory, "cryptFactory");
        this.repository = repository;
        this.cryptFactory = cryptFactory;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: CryptHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/cryption/CryptHandler$EncryptionAlgorithm;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, "AES_GCM", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EncryptionAlgorithm {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EncryptionAlgorithm[] $VALUES;
        public static final EncryptionAlgorithm AES = new EncryptionAlgorithm(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, 0, 0);
        public static final EncryptionAlgorithm AES_GCM = new EncryptionAlgorithm("AES_GCM", 1, 1);
        private final int value;

        private static final /* synthetic */ EncryptionAlgorithm[] $values() {
            return new EncryptionAlgorithm[]{AES, AES_GCM};
        }

        public static EnumEntries<EncryptionAlgorithm> getEntries() {
            return $ENTRIES;
        }

        private EncryptionAlgorithm(String str, int i, int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            EncryptionAlgorithm[] encryptionAlgorithmArr$values = $values();
            $VALUES = encryptionAlgorithmArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(encryptionAlgorithmArr$values);
        }

        public static EncryptionAlgorithm valueOf(String str) {
            return (EncryptionAlgorithm) Enum.valueOf(EncryptionAlgorithm.class, str);
        }

        public static EncryptionAlgorithm[] values() {
            return (EncryptionAlgorithm[]) $VALUES.clone();
        }
    }

    @Override // com.clevertap.android.sdk.cryption.ICryptHandler
    public String encryptSafe(String plainText) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        return INSTANCE.isTextEncrypted(plainText) ? plainText : this.cryptFactory.getCryptInstance(DEFAULT_ALGORITHM).encryptInternal(plainText);
    }

    @Override // com.clevertap.android.sdk.cryption.ICryptHandler
    public String decryptSafe(String cipherText) {
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        return !INSTANCE.isTextEncrypted(cipherText) ? cipherText : this.cryptFactory.getCryptInstance(DEFAULT_ALGORITHM).decryptInternal(cipherText);
    }

    @Override // com.clevertap.android.sdk.cryption.ICryptHandler
    public String encrypt(String plainText) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        return this.cryptFactory.getCryptInstance(DEFAULT_ALGORITHM).encryptInternal(plainText);
    }

    @Override // com.clevertap.android.sdk.cryption.ICryptHandler
    public String decrypt(String cipherText) {
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        return this.cryptFactory.getCryptInstance(DEFAULT_ALGORITHM).decryptInternal(cipherText);
    }

    @Override // com.clevertap.android.sdk.cryption.ICryptHandler
    public String decryptWithAlgorithm(String cipherText, EncryptionAlgorithm algorithm) {
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        return this.cryptFactory.getCryptInstance(algorithm).decryptInternal(cipherText);
    }

    @Override // com.clevertap.android.sdk.cryption.ICryptHandler
    public void updateMigrationFailureCount(boolean migrationSuccessful) {
        this.repository.updateMigrationFailureCount(migrationSuccessful);
    }

    /* JADX INFO: compiled from: CryptHandler.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/cryption/CryptHandler$Companion;", "", "<init>", "()V", "DEFAULT_ALGORITHM", "Lcom/clevertap/android/sdk/cryption/CryptHandler$EncryptionAlgorithm;", "getDEFAULT_ALGORITHM", "()Lcom/clevertap/android/sdk/cryption/CryptHandler$EncryptionAlgorithm;", "isTextEncrypted", "", "plainText", "", "isTextAESEncrypted", "isTextAESGCMEncrypted", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EncryptionAlgorithm getDEFAULT_ALGORITHM() {
            return CryptHandler.DEFAULT_ALGORITHM;
        }

        @JvmStatic
        public final boolean isTextEncrypted(String plainText) {
            Intrinsics.checkNotNullParameter(plainText, "plainText");
            return isTextAESEncrypted(plainText) || isTextAESGCMEncrypted(plainText);
        }

        public final boolean isTextAESEncrypted(String plainText) {
            Intrinsics.checkNotNullParameter(plainText, "plainText");
            return StringsKt.startsWith$default(plainText, Constants.AES_PREFIX, false, 2, (Object) null) && StringsKt.endsWith$default(plainText, Constants.AES_SUFFIX, false, 2, (Object) null);
        }

        public final boolean isTextAESGCMEncrypted(String plainText) {
            Intrinsics.checkNotNullParameter(plainText, "plainText");
            return StringsKt.startsWith$default(plainText, Constants.AES_GCM_PREFIX, false, 2, (Object) null) && StringsKt.endsWith$default(plainText, Constants.AES_GCM_SUFFIX, false, 2, (Object) null);
        }
    }
}
