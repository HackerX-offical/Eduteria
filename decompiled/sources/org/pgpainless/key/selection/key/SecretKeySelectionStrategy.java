package org.pgpainless.key.selection.key;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SecretKeySelectionStrategy<O> implements KeySelectionStrategy<PGPSecretKey, PGPSecretKeyRing, O> {
    @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
    public Set<PGPSecretKey> selectKeysFromKeyRing(O o, @Nonnull PGPSecretKeyRing pGPSecretKeyRing) {
        HashSet hashSet = new HashSet();
        Iterator<PGPSecretKey> secretKeys = pGPSecretKeyRing.getSecretKeys();
        while (secretKeys.hasNext()) {
            PGPSecretKey next = secretKeys.next();
            if (accept(o, next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
    public MultiMap<O, PGPSecretKey> selectKeysFromKeyRings(@Nonnull MultiMap<O, PGPSecretKeyRing> multiMap) {
        MultiMap<O, PGPSecretKey> multiMap2 = new MultiMap<>();
        for (O o : multiMap.keySet()) {
            Iterator<PGPSecretKeyRing> it = multiMap.get(o).iterator();
            while (it.hasNext()) {
                multiMap2.put(o, selectKeysFromKeyRing((Object) o, it.next()));
            }
        }
        return multiMap2;
    }
}
