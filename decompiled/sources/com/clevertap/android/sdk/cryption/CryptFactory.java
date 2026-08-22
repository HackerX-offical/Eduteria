package com.clevertap.android.sdk.cryption;

import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.cryption.CryptHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CryptFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/cryption/CryptFactory;", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", "ctKeyGenerator", "Lcom/clevertap/android/sdk/cryption/CTKeyGenerator;", "<init>", "(Ljava/lang/String;Lcom/clevertap/android/sdk/cryption/CTKeyGenerator;)V", "cryptInstances", "", "Lcom/clevertap/android/sdk/cryption/CryptHandler$EncryptionAlgorithm;", "Lcom/clevertap/android/sdk/cryption/Crypt;", "getCryptInstance", "algorithm", "getAesGcmCrypt", "Lcom/clevertap/android/sdk/cryption/AESGCMCrypt;", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CryptFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String accountId;
    private final Map<CryptHandler.EncryptionAlgorithm, Crypt> cryptInstances;
    private final CTKeyGenerator ctKeyGenerator;

    @JvmStatic
    public static final Crypt getCrypt(CryptHandler.EncryptionAlgorithm encryptionAlgorithm, String str, CTKeyGenerator cTKeyGenerator) {
        return INSTANCE.getCrypt(encryptionAlgorithm, str, cTKeyGenerator);
    }

    public CryptFactory(String accountId, CTKeyGenerator ctKeyGenerator) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(ctKeyGenerator, "ctKeyGenerator");
        this.accountId = accountId;
        this.ctKeyGenerator = ctKeyGenerator;
        this.cryptInstances = new LinkedHashMap();
    }

    /* JADX INFO: compiled from: CryptFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/cryption/CryptFactory$Companion;", "", "<init>", "()V", "getCrypt", "Lcom/clevertap/android/sdk/cryption/Crypt;", "type", "Lcom/clevertap/android/sdk/cryption/CryptHandler$EncryptionAlgorithm;", "accountID", "", "ctKeyGenerator", "Lcom/clevertap/android/sdk/cryption/CTKeyGenerator;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: CryptFactory.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CryptHandler.EncryptionAlgorithm.values().length];
                try {
                    iArr[CryptHandler.EncryptionAlgorithm.AES.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CryptHandler.EncryptionAlgorithm.AES_GCM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Crypt getCrypt(CryptHandler.EncryptionAlgorithm type, String accountID, CTKeyGenerator ctKeyGenerator) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(accountID, "accountID");
            Intrinsics.checkNotNullParameter(ctKeyGenerator, "ctKeyGenerator");
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return new AESCrypt(accountID);
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return new AESGCMCrypt(ctKeyGenerator);
        }
    }

    public final Crypt getCryptInstance(CryptHandler.EncryptionAlgorithm algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Map<CryptHandler.EncryptionAlgorithm, Crypt> map = this.cryptInstances;
        Crypt crypt = map.get(algorithm);
        if (crypt == null) {
            crypt = INSTANCE.getCrypt(algorithm, this.accountId, this.ctKeyGenerator);
            map.put(algorithm, crypt);
        }
        return crypt;
    }

    public final AESGCMCrypt getAesGcmCrypt() {
        Map<CryptHandler.EncryptionAlgorithm, Crypt> map = this.cryptInstances;
        CryptHandler.EncryptionAlgorithm encryptionAlgorithm = CryptHandler.EncryptionAlgorithm.AES_GCM;
        Crypt crypt = map.get(encryptionAlgorithm);
        if (crypt == null) {
            crypt = INSTANCE.getCrypt(CryptHandler.EncryptionAlgorithm.AES_GCM, this.accountId, this.ctKeyGenerator);
            map.put(encryptionAlgorithm, crypt);
        }
        Intrinsics.checkNotNull(crypt, "null cannot be cast to non-null type com.clevertap.android.sdk.cryption.AESGCMCrypt");
        return (AESGCMCrypt) crypt;
    }
}
