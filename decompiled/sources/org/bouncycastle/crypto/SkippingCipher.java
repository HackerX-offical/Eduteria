package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes10.dex */
public interface SkippingCipher {
    long getPosition();

    long seekTo(long j);

    long skip(long j);
}
