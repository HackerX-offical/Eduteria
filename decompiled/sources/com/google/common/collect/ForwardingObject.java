package com.google.common.collect;

/* JADX INFO: loaded from: classes8.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingObject {
    protected abstract Object delegate();

    protected ForwardingObject() {
    }

    public String toString() {
        return delegate().toString();
    }
}
