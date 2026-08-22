package com.clevertap.android.sdk.cryption;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AESGCMCrypt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0007H\u0002J0\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/cryption/AESGCMCrypt;", "Lcom/clevertap/android/sdk/cryption/Crypt;", "ctKeyGenerator", "Lcom/clevertap/android/sdk/cryption/CTKeyGenerator;", "<init>", "(Lcom/clevertap/android/sdk/cryption/CTKeyGenerator;)V", "encryptInternal", "", "plainText", "decryptInternal", "cipherText", "parseCipherText", "Lcom/clevertap/android/sdk/cryption/AESGCMCrypt$AESGCMCryptResult;", "performCryptOperation", "mode", "", "data", "", "iv", "secretKey", "Ljavax/crypto/SecretKey;", "AESGCMCryptResult", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AESGCMCrypt extends Crypt {
    private final CTKeyGenerator ctKeyGenerator;

    public AESGCMCrypt(CTKeyGenerator ctKeyGenerator) {
        Intrinsics.checkNotNullParameter(ctKeyGenerator, "ctKeyGenerator");
        this.ctKeyGenerator = ctKeyGenerator;
    }

    @Override // com.clevertap.android.sdk.cryption.Crypt
    public String encryptInternal(String plainText) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = plainText.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        AESGCMCryptResult aESGCMCryptResultPerformCryptOperation$default = performCryptOperation$default(this, 1, bytes, null, null, 12, null);
        if (aESGCMCryptResultPerformCryptOperation$default == null) {
            return null;
        }
        return Constants.AES_GCM_PREFIX + CryptExtensionsKt.toBase64(aESGCMCryptResultPerformCryptOperation$default.getIv()) + ':' + CryptExtensionsKt.toBase64(aESGCMCryptResultPerformCryptOperation$default.getEncryptedBytes()) + Constants.AES_GCM_SUFFIX;
    }

    @Override // com.clevertap.android.sdk.cryption.Crypt
    public String decryptInternal(String cipherText) {
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        AESGCMCryptResult cipherText2 = parseCipherText(cipherText);
        if (cipherText2 == null) {
            return null;
        }
        AESGCMCryptResult aESGCMCryptResultPerformCryptOperation$default = performCryptOperation$default(this, 2, cipherText2.getEncryptedBytes(), cipherText2.getIv(), null, 8, null);
        if (aESGCMCryptResultPerformCryptOperation$default == null) {
            return null;
        }
        byte[] encryptedBytes = aESGCMCryptResultPerformCryptOperation$default.getEncryptedBytes();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(encryptedBytes, UTF_8);
    }

    private final AESGCMCryptResult parseCipherText(String cipherText) {
        try {
            String strRemoveSuffix = StringsKt.removeSuffix(StringsKt.removePrefix(cipherText, (CharSequence) Constants.AES_GCM_PREFIX), (CharSequence) Constants.AES_GCM_SUFFIX);
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) strRemoveSuffix, ":", 0, false, 6, (Object) null);
            if (iIndexOf$default == -1) {
                Logger.v("Invalid cipher text format: delimiter not found");
                return null;
            }
            String strSubstring = strRemoveSuffix.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            byte[] bArrFromBase64 = CryptExtensionsKt.fromBase64(strSubstring);
            String strSubstring2 = strRemoveSuffix.substring(iIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            return new AESGCMCryptResult(bArrFromBase64, CryptExtensionsKt.fromBase64(strSubstring2));
        } catch (Exception e2) {
            Logger.v("Error parsing cipherText", e2);
            return null;
        } catch (OutOfMemoryError e3) {
            Logger.v("Unable to parse cipher text", e3);
            return null;
        }
    }

    public static /* synthetic */ AESGCMCryptResult performCryptOperation$default(AESGCMCrypt aESGCMCrypt, int i, byte[] bArr, byte[] bArr2, SecretKey secretKey, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            bArr2 = null;
        }
        if ((i2 & 8) != 0) {
            secretKey = aESGCMCrypt.ctKeyGenerator.generateOrGetKey();
        }
        return aESGCMCrypt.performCryptOperation(i, bArr, bArr2, secretKey);
    }

    public final AESGCMCryptResult performCryptOperation(int mode, byte[] data, byte[] iv, SecretKey secretKey) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            if (mode == 1) {
                cipher.init(mode, secretKey);
                byte[] iv2 = cipher.getIV();
                byte[] bArrDoFinal = cipher.doFinal(data);
                Intrinsics.checkNotNull(iv2);
                Intrinsics.checkNotNull(bArrDoFinal);
                return new AESGCMCryptResult(iv2, bArrDoFinal);
            }
            if (mode != 2) {
                Logger.v("Invalid mode used");
                return null;
            }
            if (iv != null) {
                cipher.init(mode, secretKey, new GCMParameterSpec(128, iv));
                byte[] bArrDoFinal2 = cipher.doFinal(data);
                Intrinsics.checkNotNull(bArrDoFinal2);
                return new AESGCMCryptResult(iv, bArrDoFinal2);
            }
            Logger.v("IV is required for decryption");
            return null;
        } catch (Exception e2) {
            Logger.v("Error performing crypt operation", e2);
            return null;
        }
    }

    /* JADX INFO: compiled from: AESGCMCrypt.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/sdk/cryption/AESGCMCrypt$AESGCMCryptResult;", "", "iv", "", "encryptedBytes", "<init>", "([B[B)V", "getIv", "()[B", "getEncryptedBytes", "equals", "", "other", "hashCode", "", "component1", "component2", Constants.COPY_TYPE, InAppPurchaseConstants.METHOD_TO_STRING, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AESGCMCryptResult {
        private final byte[] encryptedBytes;
        private final byte[] iv;

        public static /* synthetic */ AESGCMCryptResult copy$default(AESGCMCryptResult aESGCMCryptResult, byte[] bArr, byte[] bArr2, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = aESGCMCryptResult.iv;
            }
            if ((i & 2) != 0) {
                bArr2 = aESGCMCryptResult.encryptedBytes;
            }
            return aESGCMCryptResult.copy(bArr, bArr2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getIv() {
            return this.iv;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final byte[] getEncryptedBytes() {
            return this.encryptedBytes;
        }

        public final AESGCMCryptResult copy(byte[] iv, byte[] encryptedBytes) {
            Intrinsics.checkNotNullParameter(iv, "iv");
            Intrinsics.checkNotNullParameter(encryptedBytes, "encryptedBytes");
            return new AESGCMCryptResult(iv, encryptedBytes);
        }

        public String toString() {
            return "AESGCMCryptResult(iv=" + Arrays.toString(this.iv) + ", encryptedBytes=" + Arrays.toString(this.encryptedBytes) + ')';
        }

        public AESGCMCryptResult(byte[] iv, byte[] encryptedBytes) {
            Intrinsics.checkNotNullParameter(iv, "iv");
            Intrinsics.checkNotNullParameter(encryptedBytes, "encryptedBytes");
            this.iv = iv;
            this.encryptedBytes = encryptedBytes;
        }

        public final byte[] getIv() {
            return this.iv;
        }

        public final byte[] getEncryptedBytes() {
            return this.encryptedBytes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.clevertap.android.sdk.cryption.AESGCMCrypt.AESGCMCryptResult");
            AESGCMCryptResult aESGCMCryptResult = (AESGCMCryptResult) other;
            return Arrays.equals(this.iv, aESGCMCryptResult.iv) && Arrays.equals(this.encryptedBytes, aESGCMCryptResult.encryptedBytes);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.iv) * 31) + Arrays.hashCode(this.encryptedBytes);
        }
    }
}
