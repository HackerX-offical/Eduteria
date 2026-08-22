package org.pgpainless.key.selection.keyring.impl;

import java.util.Map;
import java.util.Set;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.pgpainless.key.selection.keyring.PublicKeyRingSelectionStrategy;
import org.pgpainless.key.selection.keyring.SecretKeyRingSelectionStrategy;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public class Whitelist {

    public static class PubRingSelectionStrategy<O> extends PublicKeyRingSelectionStrategy<O> {
        private final MultiMap<O, Long> whitelist;

        public PubRingSelectionStrategy(MultiMap<O, Long> multiMap) {
            this.whitelist = multiMap;
        }

        public PubRingSelectionStrategy(Map<O, Set<Long>> map) {
            this(new MultiMap(map));
        }

        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(O o, PGPPublicKeyRing pGPPublicKeyRing) {
            Set<Long> set = this.whitelist.get(o);
            if (set == null) {
                return false;
            }
            return set.contains(Long.valueOf(pGPPublicKeyRing.getPublicKey().getKeyID()));
        }
    }

    public static class SecRingSelectionStrategy<O> extends SecretKeyRingSelectionStrategy<O> {
        private final MultiMap<O, Long> whitelist;

        public SecRingSelectionStrategy(MultiMap<O, Long> multiMap) {
            this.whitelist = multiMap;
        }

        public SecRingSelectionStrategy(Map<O, Set<Long>> map) {
            this(new MultiMap(map));
        }

        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(O o, PGPSecretKeyRing pGPSecretKeyRing) {
            Set<Long> set = this.whitelist.get(o);
            if (set == null) {
                return false;
            }
            return set.contains(Long.valueOf(pGPSecretKeyRing.getPublicKey().getKeyID()));
        }
    }
}
