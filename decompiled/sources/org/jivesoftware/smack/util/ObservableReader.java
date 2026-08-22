package org.jivesoftware.smack.util;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ObservableReader extends Reader {

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    final List<ReaderListener> f1491listeners = new ArrayList();
    Reader wrappedReader;

    public ObservableReader(Reader reader) {
        this.wrappedReader = null;
        this.wrappedReader = reader;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int size;
        ReaderListener[] readerListenerArr;
        int i3 = this.wrappedReader.read(cArr, i, i2);
        if (i3 > 0) {
            String str = new String(cArr, i, i3);
            synchronized (this.f1491listeners) {
                size = this.f1491listeners.size();
                readerListenerArr = new ReaderListener[size];
                this.f1491listeners.toArray(readerListenerArr);
            }
            for (int i4 = 0; i4 < size; i4++) {
                readerListenerArr[i4].read(str);
            }
        }
        return i3;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.wrappedReader.close();
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        return this.wrappedReader.read();
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return this.wrappedReader.read(cArr);
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        return this.wrappedReader.skip(j);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        return this.wrappedReader.ready();
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return this.wrappedReader.markSupported();
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        this.wrappedReader.mark(i);
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        this.wrappedReader.reset();
    }

    public void addReaderListener(ReaderListener readerListener) {
        if (readerListener == null) {
            return;
        }
        synchronized (this.f1491listeners) {
            if (!this.f1491listeners.contains(readerListener)) {
                this.f1491listeners.add(readerListener);
            }
        }
    }

    public void removeReaderListener(ReaderListener readerListener) {
        synchronized (this.f1491listeners) {
            this.f1491listeners.remove(readerListener);
        }
    }
}
