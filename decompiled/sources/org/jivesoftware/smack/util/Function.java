package org.jivesoftware.smack.util;

/* JADX INFO: loaded from: classes10.dex */
public interface Function<R, T> {
    static /* synthetic */ Object lambda$identity$0(Object obj) {
        return obj;
    }

    R apply(T t);

    static <T> Function<T, T> identity() {
        return new Function() { // from class: org.jivesoftware.smack.util.Function$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Function
            public final Object apply(Object obj) {
                return Function.lambda$identity$0(obj);
            }
        };
    }
}
