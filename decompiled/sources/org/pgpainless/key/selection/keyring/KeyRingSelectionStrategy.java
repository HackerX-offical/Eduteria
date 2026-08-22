package org.pgpainless.key.selection.keyring;

import java.util.Set;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public interface KeyRingSelectionStrategy<R, C, O> {
    boolean accept(O o, R r);

    Set<R> selectKeyRingsFromCollection(O o, C c2);

    MultiMap<O, R> selectKeyRingsFromCollections(MultiMap<O, C> multiMap);
}
