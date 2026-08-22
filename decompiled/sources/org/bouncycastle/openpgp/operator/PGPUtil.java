package org.bouncycastle.openpgp.operator;

import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes10.dex */
class PGPUtil implements HashAlgorithmTags {
    PGPUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00de A[Catch: IOException -> 0x00ec, TryCatch #0 {IOException -> 0x00ec, blocks: (B:23:0x005a, B:24:0x0060, B:29:0x006f, B:30:0x007c, B:33:0x0084, B:35:0x008a, B:36:0x008f, B:38:0x009b, B:39:0x00a1, B:46:0x00d2, B:48:0x00de, B:50:0x00e6, B:49:0x00e2, B:40:0x00a6, B:41:0x00c2, B:42:0x00c3, B:45:0x00cf, B:44:0x00c9), top: B:62:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2 A[Catch: IOException -> 0x00ec, TryCatch #0 {IOException -> 0x00ec, blocks: (B:23:0x005a, B:24:0x0060, B:29:0x006f, B:30:0x007c, B:33:0x0084, B:35:0x008a, B:36:0x008f, B:38:0x009b, B:39:0x00a1, B:46:0x00d2, B:48:0x00de, B:50:0x00e6, B:49:0x00e2, B:40:0x00a6, B:41:0x00c2, B:42:0x00c3, B:45:0x00cf, B:44:0x00c9), top: B:62:0x005a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static byte[] makeKeyFromPassPhrase(org.bouncycastle.openpgp.operator.PGPDigestCalculator r15, int r16, org.bouncycastle.bcpg.S2K r17, char[] r18) throws org.bouncycastle.openpgp.PGPException {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.openpgp.operator.PGPUtil.makeKeyFromPassPhrase(org.bouncycastle.openpgp.operator.PGPDigestCalculator, int, org.bouncycastle.bcpg.S2K, char[]):byte[]");
    }

    public static byte[] makeKeyFromPassPhrase(PGPDigestCalculatorProvider pGPDigestCalculatorProvider, int i, S2K s2k, char[] cArr) throws PGPException {
        return makeKeyFromPassPhrase(pGPDigestCalculatorProvider.get(s2k != null ? s2k.getHashAlgorithm() : 1), i, s2k, cArr);
    }
}
