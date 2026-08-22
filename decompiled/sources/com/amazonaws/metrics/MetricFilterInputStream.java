package com.amazonaws.metrics;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class MetricFilterInputStream extends SdkFilterInputStream {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private final ByteThroughputHelper f301helper;

    @Override // com.amazonaws.internal.SdkFilterInputStream, com.amazonaws.internal.MetricAware
    public final boolean isMetricActivated() {
        return true;
    }

    public MetricFilterInputStream(ThroughputMetricType throughputMetricType, InputStream inputStream) {
        super(inputStream);
        this.f301helper = new ByteThroughputHelper(throughputMetricType);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        abortIfNeeded();
        long jStartTiming = this.f301helper.startTiming();
        int i3 = this.in.read(bArr, i, i2);
        if (i3 > 0) {
            this.f301helper.increment(i3, jStartTiming);
        }
        return i3;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f301helper.reportMetrics();
        this.in.close();
        abortIfNeeded();
    }
}
