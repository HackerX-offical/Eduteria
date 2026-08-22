package com.clevertap.android.sdk.network;

import android.util.Base64;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.cryption.AESGCMCrypt;
import com.clevertap.android.sdk.cryption.CTKeyGenerator;
import com.clevertap.android.sdk.network.api.EncryptedResponseBody;
import com.clevertap.android.sdk.network.api.EncryptionFailure;
import com.clevertap.android.sdk.network.api.EncryptionResult;
import com.clevertap.android.sdk.network.api.EncryptionSuccess;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

/* JADX INFO: compiled from: NetworkEncryptionManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0013\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/clevertap/android/sdk/network/NetworkEncryptionManager;", "", "keyGenerator", "Lcom/clevertap/android/sdk/cryption/CTKeyGenerator;", "aesgcm", "Lcom/clevertap/android/sdk/cryption/AESGCMCrypt;", "<init>", "(Lcom/clevertap/android/sdk/cryption/CTKeyGenerator;Lcom/clevertap/android/sdk/cryption/AESGCMCrypt;)V", "sessionKeyForEncryption", "Ljavax/crypto/SecretKey;", "sessionKeyBytes", "", "sessionEncryptionKey", "", "kotlin.jvm.PlatformType", "()Ljava/lang/String;", "encryptResponse", "Lcom/clevertap/android/sdk/network/api/EncryptionResult;", SaslNonza.Response.ELEMENT, "decryptResponse", "bodyString", "convertByteArrayToString", "arr", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkEncryptionManager {
    private static final Object lock = new Object();
    private static volatile SecretKey sessionKey;
    private final AESGCMCrypt aesgcm;
    private final CTKeyGenerator keyGenerator;

    public NetworkEncryptionManager(CTKeyGenerator keyGenerator, AESGCMCrypt aesgcm) {
        Intrinsics.checkNotNullParameter(keyGenerator, "keyGenerator");
        Intrinsics.checkNotNullParameter(aesgcm, "aesgcm");
        this.keyGenerator = keyGenerator;
        this.aesgcm = aesgcm;
    }

    private final SecretKey sessionKeyForEncryption() {
        if (sessionKey == null) {
            synchronized (lock) {
                if (sessionKey == null) {
                    sessionKey = this.keyGenerator.generateSecretKey();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        SecretKey secretKey = sessionKey;
        Intrinsics.checkNotNull(secretKey);
        return secretKey;
    }

    private final byte[] sessionKeyBytes() {
        byte[] encoded = sessionKeyForEncryption().getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        return encoded;
    }

    public final String sessionEncryptionKey() {
        return Base64.encodeToString(sessionKeyBytes(), 2);
    }

    public final EncryptionResult encryptResponse(String response) {
        Intrinsics.checkNotNullParameter(response, "response");
        AESGCMCrypt aESGCMCrypt = this.aesgcm;
        byte[] bytes = response.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        AESGCMCrypt.AESGCMCryptResult aESGCMCryptResultPerformCryptOperation = aESGCMCrypt.performCryptOperation(1, bytes, null, sessionKeyForEncryption());
        if (aESGCMCryptResultPerformCryptOperation != null) {
            return new EncryptionSuccess(convertByteArrayToString(aESGCMCryptResultPerformCryptOperation.getEncryptedBytes()), convertByteArrayToString(aESGCMCryptResultPerformCryptOperation.getIv()));
        }
        return EncryptionFailure.INSTANCE;
    }

    public final EncryptionResult decryptResponse(String bodyString) {
        Intrinsics.checkNotNullParameter(bodyString, "bodyString");
        try {
            EncryptedResponseBody encryptedResponseBodyFromJsonString = EncryptedResponseBody.INSTANCE.fromJsonString(bodyString);
            String encryptedPayload = encryptedResponseBodyFromJsonString.getEncryptedPayload();
            String iv = encryptedResponseBodyFromJsonString.getIv();
            byte[] bArrDecode = Base64.decode(encryptedPayload, 2);
            byte[] bArrDecode2 = Base64.decode(iv, 2);
            AESGCMCrypt aESGCMCrypt = this.aesgcm;
            Intrinsics.checkNotNull(bArrDecode);
            AESGCMCrypt.AESGCMCryptResult aESGCMCryptResultPerformCryptOperation = aESGCMCrypt.performCryptOperation(2, bArrDecode, bArrDecode2, sessionKeyForEncryption());
            if (aESGCMCryptResultPerformCryptOperation != null) {
                return new EncryptionSuccess(new String(aESGCMCryptResultPerformCryptOperation.getEncryptedBytes(), Charsets.UTF_8), new String(aESGCMCryptResultPerformCryptOperation.getIv(), Charsets.UTF_8));
            }
            return EncryptionFailure.INSTANCE;
        } catch (Exception e2) {
            Logger.v("Error decrypting response", e2);
            return EncryptionFailure.INSTANCE;
        }
    }

    private final String convertByteArrayToString(byte[] arr) {
        String strEncodeToString = Base64.encodeToString(arr, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
