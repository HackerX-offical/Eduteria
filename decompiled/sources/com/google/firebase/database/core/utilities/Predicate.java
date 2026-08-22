package com.google.firebase.database.core.utilities;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface Predicate<T> {
    public static final Predicate<Object> TRUE = new Predicate<Object>() { // from class: com.google.firebase.database.core.utilities.Predicate.1
        @Override // com.google.firebase.database.core.utilities.Predicate
        public boolean evaluate(Object obj) {
            return true;
        }
    };

    boolean evaluate(T t);
}
