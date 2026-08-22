package org.jivesoftware.smack.util.stringencoder;

/* JADX INFO: loaded from: classes10.dex */
public interface StringEncoder<O> {
    O decode(String str);

    String encode(O o);
}
