package org.pgpainless.util;

import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes10.dex */
public class Passphrase {
    private final char[] chars;
    private final Object lock = new Object();
    private boolean valid = true;

    public Passphrase(@Nullable char[] cArr) {
        this.chars = cArr;
    }

    public void clear() {
        synchronized (this.lock) {
            char[] cArr = this.chars;
            if (cArr != null) {
                Arrays.fill(cArr, ' ');
            }
            this.valid = false;
        }
    }

    @Nullable
    public char[] getChars() {
        synchronized (this.lock) {
            if (!this.valid) {
                throw new IllegalStateException("Passphrase has been cleared.");
            }
            char[] cArr = this.chars;
            if (cArr == null) {
                return null;
            }
            char[] cArr2 = new char[cArr.length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            return cArr2;
        }
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.lock) {
            z = this.valid;
        }
        return z;
    }

    public static Passphrase emptyPassphrase() {
        return new Passphrase(null);
    }
}
