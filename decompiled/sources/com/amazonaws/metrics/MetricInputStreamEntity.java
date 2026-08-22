package com.amazonaws.metrics;

import com.amazonaws.internal.MetricAware;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.InputStreamEntity;

/* JADX INFO: loaded from: classes4.dex */
public class MetricInputStreamEntity extends InputStreamEntity {
    private static final int BUFFER_SIZE = 2048;

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private final ByteThroughputHelper f302helper;

    public MetricInputStreamEntity(ThroughputMetricType throughputMetricType, InputStream inputStream, long j) {
        super(inputStream, j);
        this.f302helper = new ByteThroughputHelper(throughputMetricType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.http.entity.InputStreamEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if ((outputStream instanceof MetricAware) && ((MetricAware) outputStream).isMetricActivated()) {
            super.writeTo(outputStream);
        } else {
            writeToWithMetrics(outputStream);
        }
    }

    private void writeToWithMetrics(OutputStream outputStream) throws IOException {
        int i;
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream content = getContent();
        long contentLength = getContentLength();
        try {
            byte[] bArr = new byte[2048];
            if (contentLength < 0) {
                while (true) {
                    int i2 = content.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    long jStartTiming = this.f302helper.startTiming();
                    outputStream.write(bArr, 0, i2);
                    this.f302helper.increment(i2, jStartTiming);
                }
            } else {
                while (contentLength > 0 && (i = content.read(bArr, 0, (int) Math.min(2048L, contentLength))) != -1) {
                    long jStartTiming2 = this.f302helper.startTiming();
                    outputStream.write(bArr, 0, i);
                    this.f302helper.increment(i, jStartTiming2);
                    contentLength -= (long) i;
                }
            }
        } finally {
            this.f302helper.reportMetrics();
            content.close();
        }
    }
}
