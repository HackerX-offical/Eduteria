package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class CryptoRuntime {
    private static final String BC_PROVIDER_FQCN = "org.bouncycastle.jce.provider.BouncyCastleProvider";
    static final String BOUNCY_CASTLE_PROVIDER = "BC";
    private static final Log LOGGER = LogFactory.getLog(CryptoRuntime.class);

    public static synchronized boolean isBouncyCastleAvailable() {
        return Security.getProvider("BC") != null;
    }

    public static synchronized void enableBouncyCastle() {
        if (isBouncyCastleAvailable()) {
            return;
        }
        try {
            Security.addProvider((Provider) Class.forName(BC_PROVIDER_FQCN).newInstance());
        } catch (Exception e2) {
            LOGGER.debug("Bouncy Castle not available", e2);
        }
    }

    public static boolean isAesGcmAvailable(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider("BC");
        }
        return AesGcm.check(provider);
    }

    static boolean isRsaKeyWrapAvailable(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider("BC");
        }
        return RsaEcbOaepWithSHA256AndMGF1Padding.check(provider);
    }

    private static final class AesGcm {
        private AesGcm() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean check(Provider provider) {
            try {
                Cipher.getInstance(ContentCryptoScheme.AES_GCM.getCipherAlgorithm(), provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    private static final class RsaEcbOaepWithSHA256AndMGF1Padding {
        private RsaEcbOaepWithSHA256AndMGF1Padding() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean check(Provider provider) {
            try {
                Cipher.getInstance(S3KeyWrapScheme.RSA_ECB_OAEP_WITH_SHA256_AND_MGF1_PADDING, provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
