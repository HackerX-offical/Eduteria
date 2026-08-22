package com.clevertap.android.sdk.db;

import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.cryption.CryptHandler;
import com.clevertap.android.sdk.cryption.EncryptionLevel;
import com.clevertap.android.sdk.cryption.ICryptHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.ox.element.CryptElement;

/* JADX INFO: compiled from: DBEncryptionHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bJ6\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0015H\u0082\b¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/clevertap/android/sdk/db/DBEncryptionHandler;", "", CryptElement.ELEMENT, "Lcom/clevertap/android/sdk/cryption/ICryptHandler;", "logger", "Lcom/clevertap/android/sdk/ILogger;", CleverTapInstanceConfig.KEY_ENCRYPTION_LEVEL, "Lcom/clevertap/android/sdk/cryption/EncryptionLevel;", "<init>", "(Lcom/clevertap/android/sdk/cryption/ICryptHandler;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/cryption/EncryptionLevel;)V", "unwrapDbData", "", "data", "wrapDbData", "isInCorrectEncryptionFormat", "", "measureTimeInMillisAndLog", ExifInterface.GPS_DIRECTION_TRUE, "tag", "message", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DBEncryptionHandler {
    private static final String TAG = "DBEncryptionHandler";
    private final ICryptHandler crypt;
    private final EncryptionLevel encryptionLevel;
    private final ILogger logger;

    /* JADX INFO: compiled from: DBEncryptionHandler.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EncryptionLevel.values().length];
            try {
                iArr[EncryptionLevel.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EncryptionLevel.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EncryptionLevel.FULL_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DBEncryptionHandler(ICryptHandler crypt, ILogger logger, EncryptionLevel encryptionLevel) {
        Intrinsics.checkNotNullParameter(crypt, "crypt");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(encryptionLevel, "encryptionLevel");
        this.crypt = crypt;
        this.logger = logger;
        this.encryptionLevel = encryptionLevel;
    }

    public /* synthetic */ DBEncryptionHandler(ICryptHandler iCryptHandler, ILogger iLogger, EncryptionLevel encryptionLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iCryptHandler, iLogger, (i & 4) != 0 ? EncryptionLevel.NONE : encryptionLevel);
    }

    public final boolean isInCorrectEncryptionFormat(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i = WhenMappings.$EnumSwitchMapping$0[this.encryptionLevel.ordinal()];
        if (i == 1 || i == 2) {
            return !CryptHandler.INSTANCE.isTextEncrypted(data);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return CryptHandler.INSTANCE.isTextAESGCMEncrypted(data);
    }

    public final String unwrapDbData(String data) {
        System.currentTimeMillis();
        if (data != null) {
            String strDecryptSafe = this.crypt.decryptSafe(data);
            if (strDecryptSafe == null) {
                this.logger.verbose(TAG, "unwrapDbData: Decryption failed for " + data);
            }
            data = strDecryptSafe;
        }
        System.currentTimeMillis();
        return data;
    }

    public final String wrapDbData(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        System.currentTimeMillis();
        if (this.encryptionLevel == EncryptionLevel.FULL_DATA) {
            String strEncryptSafe = this.crypt.encryptSafe(data);
            if (strEncryptSafe == null) {
                this.logger.verbose(TAG, "wrapDbData: Encryption failed for " + data);
            }
            if (strEncryptSafe != null) {
                data = strEncryptSafe;
            }
        }
        System.currentTimeMillis();
        return data;
    }

    private final <T> T measureTimeInMillisAndLog(String tag, String message, Function0<? extends T> block) {
        System.currentTimeMillis();
        T tInvoke = block.invoke();
        System.currentTimeMillis();
        return tInvoke;
    }

    static /* synthetic */ Object measureTimeInMillisAndLog$default(DBEncryptionHandler dBEncryptionHandler, String str, String str2, Function0 function0, int i, Object obj) {
        System.currentTimeMillis();
        Object objInvoke = function0.invoke();
        System.currentTimeMillis();
        return objInvoke;
    }
}
