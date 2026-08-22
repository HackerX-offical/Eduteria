package org.pgpainless.exception;

/* JADX INFO: loaded from: classes10.dex */
public class SecretKeyNotFoundException extends Exception {
    private static final long serialVersionUID = 1;
    private long keyId;

    public SecretKeyNotFoundException(long j) {
        super("No PGPSecretKey with id " + Long.toHexString(j) + " (" + j + ") found.");
        this.keyId = j;
    }

    public long getKeyId() {
        return this.keyId;
    }
}
