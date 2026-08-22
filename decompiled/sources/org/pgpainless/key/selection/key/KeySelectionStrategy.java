package org.pgpainless.key.selection.key;

import java.util.Set;
import javax.annotation.Nonnull;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public interface KeySelectionStrategy<K, R, O> {
    boolean accept(O o, K k);

    Set<K> selectKeysFromKeyRing(O o, @Nonnull R r);

    MultiMap<O, K> selectKeysFromKeyRings(MultiMap<O, R> multiMap);
}
