package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class GetBucketMetricsConfigurationResult implements Serializable {
    private MetricsConfiguration metricsConfiguration;

    public MetricsConfiguration getMetricsConfiguration() {
        return this.metricsConfiguration;
    }

    public void setMetricsConfiguration(MetricsConfiguration metricsConfiguration) {
        this.metricsConfiguration = metricsConfiguration;
    }

    public GetBucketMetricsConfigurationResult withMetricsConfiguration(MetricsConfiguration metricsConfiguration) {
        setMetricsConfiguration(metricsConfiguration);
        return this;
    }
}
