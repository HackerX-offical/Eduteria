package org.jivesoftware.smack.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ObservableWriter extends Writer {
    private static final int MAX_STRING_BUILDER_SIZE = 4096;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    final List<WriterListener> f1492listeners = new ArrayList();
    private final StringBuilder stringBuilder = new StringBuilder(4096);
    Writer wrappedWriter;

    public ObservableWriter(Writer writer) {
        this.wrappedWriter = null;
        this.wrappedWriter = writer;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.wrappedWriter.write(cArr, i, i2);
        maybeNotifyListeners(new String(cArr, i, i2));
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        notifyListeners();
        this.wrappedWriter.flush();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.wrappedWriter.close();
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.wrappedWriter.write(i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.wrappedWriter.write(cArr);
        maybeNotifyListeners(new String(cArr));
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.wrappedWriter.write(str);
        maybeNotifyListeners(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        this.wrappedWriter.write(str, i, i2);
        maybeNotifyListeners(str.substring(i, i2 + i));
    }

    private void maybeNotifyListeners(String str) {
        this.stringBuilder.append(str);
        if (this.stringBuilder.length() > 4096) {
            notifyListeners();
        }
    }

    private void notifyListeners() {
        int size;
        WriterListener[] writerListenerArr;
        synchronized (this.f1492listeners) {
            size = this.f1492listeners.size();
            writerListenerArr = new WriterListener[size];
            this.f1492listeners.toArray(writerListenerArr);
        }
        String string = this.stringBuilder.toString();
        this.stringBuilder.setLength(0);
        for (int i = 0; i < size; i++) {
            writerListenerArr[i].write(string);
        }
    }

    public void addWriterListener(WriterListener writerListener) {
        if (writerListener == null) {
            return;
        }
        synchronized (this.f1492listeners) {
            if (!this.f1492listeners.contains(writerListener)) {
                this.f1492listeners.add(writerListener);
            }
        }
    }

    public void removeWriterListener(WriterListener writerListener) {
        synchronized (this.f1492listeners) {
            this.f1492listeners.remove(writerListener);
        }
    }
}
