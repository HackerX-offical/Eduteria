package org.jivesoftware.smack.util;

/* JADX INFO: loaded from: classes10.dex */
public interface DefaultCharSequence extends CharSequence {
    @Override // java.lang.CharSequence
    default int length() {
        return toString().length();
    }

    @Override // java.lang.CharSequence
    default char charAt(int i) {
        return toString().charAt(i);
    }

    @Override // java.lang.CharSequence
    default CharSequence subSequence(int i, int i2) {
        return toString().subSequence(i, i2);
    }
}
