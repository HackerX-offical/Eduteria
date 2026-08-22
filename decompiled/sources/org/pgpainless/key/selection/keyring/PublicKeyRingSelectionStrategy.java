package org.pgpainless.key.selection.keyring;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public abstract class PublicKeyRingSelectionStrategy<O> implements KeyRingSelectionStrategy<PGPPublicKeyRing, PGPPublicKeyRingCollection, O> {
    @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
    public Set<PGPPublicKeyRing> selectKeyRingsFromCollection(@Nonnull O o, @Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
        HashSet hashSet = new HashSet();
        Iterator<PGPPublicKeyRing> keyRings = pGPPublicKeyRingCollection.getKeyRings();
        while (keyRings.hasNext()) {
            PGPPublicKeyRing next = keyRings.next();
            if (accept(o, next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
    public MultiMap<O, PGPPublicKeyRing> selectKeyRingsFromCollections(@Nonnull MultiMap<O, PGPPublicKeyRingCollection> multiMap) {
        MultiMap<O, PGPPublicKeyRing> multiMap2 = new MultiMap<>();
        for (O o : multiMap.keySet()) {
            Iterator<PGPPublicKeyRingCollection> it = multiMap.get(o).iterator();
            while (it.hasNext()) {
                multiMap2.put(o, selectKeyRingsFromCollection((Object) o, it.next()));
            }
        }
        return multiMap2;
    }
}
