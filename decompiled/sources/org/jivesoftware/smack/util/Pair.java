package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;

/* JADX INFO: loaded from: classes10.dex */
public final class Pair<F, S> {
    private final F first;
    private final HashCode.Cache hashCodeCache = new HashCode.Cache();
    private final S second;

    private Pair(F f2, S s) {
        this.first = f2;
        this.second = s;
    }

    public static <F, S> Pair<F, S> create(F f2, S s) {
        return new Pair<>(f2, s);
    }

    public static <F, S> Pair<F, S> createAndInitHashCode(F f2, S s) {
        Pair<F, S> pair = new Pair<>(f2, s);
        pair.hashCode();
        return pair;
    }

    public F getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    public int hashCode() {
        return this.hashCodeCache.getHashCode(new HashCode.Calculator() { // from class: org.jivesoftware.smack.util.Pair$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.HashCode.Calculator
            public final void calculateHash(HashCode.Builder builder) {
                this.f$0.m14234lambda$hashCode$0$orgjivesoftwaresmackutilPair(builder);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$hashCode$0$org-jivesoftware-smack-util-Pair, reason: not valid java name */
    /* synthetic */ void m14234lambda$hashCode$0$orgjivesoftwaresmackutilPair(HashCode.Builder builder) {
        builder.append(this.first).append(this.second);
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smack.util.Pair$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14233lambda$equals$1$orgjivesoftwaresmackutilPair(builder, (Pair) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$1$org-jivesoftware-smack-util-Pair, reason: not valid java name */
    /* synthetic */ void m14233lambda$equals$1$orgjivesoftwaresmackutilPair(EqualsUtil.Builder builder, Pair pair) {
        builder.append(this.first, pair.first).append(this.second, pair.second);
    }
}
