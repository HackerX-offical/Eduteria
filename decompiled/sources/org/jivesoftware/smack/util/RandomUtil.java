package org.jivesoftware.smack.util;

import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: loaded from: classes10.dex */
public class RandomUtil {
    static final ThreadLocal<SecureRandom> SECURE_RANDOM = new ThreadLocal<SecureRandom>() { // from class: org.jivesoftware.smack.util.RandomUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SecureRandom initialValue() {
            return new SecureRandom();
        }
    };
    static final ThreadLocal<Random> RANDOM = new ThreadLocal<Random>() { // from class: org.jivesoftware.smack.util.RandomUtil.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    };

    public static int nextSecureRandomInt(int i) {
        return SECURE_RANDOM.get().nextInt(i);
    }

    public static int nextSecureRandomInt() {
        return SECURE_RANDOM.get().nextInt();
    }

    public static void fillWithSecureRandom(byte[] bArr) {
        SECURE_RANDOM.get().nextBytes(bArr);
    }
}
