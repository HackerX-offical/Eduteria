package org.bouncycastle.util;

/* JADX INFO: loaded from: classes10.dex */
public interface Selector<T> extends Cloneable {
    Object clone();

    boolean match(T t);
}
