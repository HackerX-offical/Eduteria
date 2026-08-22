package org.pgpainless.key.selection.key;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public abstract class PublicKeySelectionStrategy<O> implements KeySelectionStrategy<PGPPublicKey, PGPPublicKeyRing, O> {
    @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
    public Set<PGPPublicKey> selectKeysFromKeyRing(O o, @Nonnull PGPPublicKeyRing pGPPublicKeyRing) {
        HashSet hashSet = new HashSet();
        Iterator<PGPPublicKey> publicKeys = pGPPublicKeyRing.getPublicKeys();
        while (publicKeys.hasNext()) {
            PGPPublicKey next = publicKeys.next();
            if (accept(o, next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
    public MultiMap<O, PGPPublicKey> selectKeysFromKeyRings(@Nonnull MultiMap<O, PGPPublicKeyRing> multiMap) {
        MultiMap<O, PGPPublicKey> multiMap2 = new MultiMap<>();
        for (O o : multiMap.keySet()) {
            Iterator<PGPPublicKeyRing> it = multiMap.get(o).iterator();
            while (it.hasNext()) {
                multiMap2.put(o, selectKeysFromKeyRing((Object) o, it.next()));
            }
        }
        return multiMap2;
    }
}
