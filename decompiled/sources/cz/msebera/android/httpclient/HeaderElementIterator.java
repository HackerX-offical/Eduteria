package cz.msebera.android.httpclient;

import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public interface HeaderElementIterator extends Iterator<Object> {
    @Override // java.util.Iterator
    boolean hasNext();

    HeaderElement nextElement();
}
