package org.pgpainless.key.selection.keyring;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SecretKeyRingSelectionStrategy<O> implements KeyRingSelectionStrategy<PGPSecretKeyRing, PGPSecretKeyRingCollection, O> {
    @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
    public Set<PGPSecretKeyRing> selectKeyRingsFromCollection(O o, @Nonnull PGPSecretKeyRingCollection pGPSecretKeyRingCollection) {
        HashSet hashSet = new HashSet();
        Iterator<PGPSecretKeyRing> keyRings = pGPSecretKeyRingCollection.getKeyRings();
        while (keyRings.hasNext()) {
            PGPSecretKeyRing next = keyRings.next();
            if (accept(o, next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
    public MultiMap<O, PGPSecretKeyRing> selectKeyRingsFromCollections(@Nonnull MultiMap<O, PGPSecretKeyRingCollection> multiMap) {
        MultiMap<O, PGPSecretKeyRing> multiMap2 = new MultiMap<>();
        for (O o : multiMap.keySet()) {
            Iterator<PGPSecretKeyRingCollection> it = multiMap.get(o).iterator();
            while (it.hasNext()) {
                multiMap2.put(o, selectKeyRingsFromCollection((Object) o, it.next()));
            }
        }
        return multiMap2;
    }
}
