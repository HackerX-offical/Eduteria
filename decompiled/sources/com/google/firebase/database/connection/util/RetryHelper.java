package com.google.firebase.database.connection.util;

import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class RetryHelper {
    private long currentRetryDelay;
    private final ScheduledExecutorService executorService;
    private final double jitterFactor;
    private boolean lastWasSuccess;
    private final LogWrapper logger;
    private final long maxRetryDelay;
    private final long minRetryDelayAfterFailure;
    private final Random random;
    private final double retryExponent;
    private ScheduledFuture<?> scheduledRetry;

    private RetryHelper(ScheduledExecutorService scheduledExecutorService, LogWrapper logWrapper, long j, long j2, double d2, double d3) {
        this.random = new Random();
        this.lastWasSuccess = true;
        this.executorService = scheduledExecutorService;
        this.logger = logWrapper;
        this.minRetryDelayAfterFailure = j;
        this.maxRetryDelay = j2;
        this.retryExponent = d2;
        this.jitterFactor = d3;
    }

    public void retry(final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.google.firebase.database.connection.util.RetryHelper.1
            @Override // java.lang.Runnable
            public void run() {
                RetryHelper.this.scheduledRetry = null;
                runnable.run();
            }
        };
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling previous scheduled retry", new Object[0]);
            this.scheduledRetry.cancel(false);
            this.scheduledRetry = null;
        }
        long jNextDouble = 0;
        if (!this.lastWasSuccess) {
            long j = this.currentRetryDelay;
            if (j == 0) {
                this.currentRetryDelay = this.minRetryDelayAfterFailure;
            } else {
                this.currentRetryDelay = Math.min((long) (j * this.retryExponent), this.maxRetryDelay);
            }
            double d2 = this.jitterFactor;
            long j2 = this.currentRetryDelay;
            jNextDouble = (long) (((1.0d - d2) * j2) + (d2 * j2 * this.random.nextDouble()));
        }
        this.lastWasSuccess = false;
        this.logger.debug("Scheduling retry in %dms", Long.valueOf(jNextDouble));
        this.scheduledRetry = this.executorService.schedule(runnable2, jNextDouble, TimeUnit.MILLISECONDS);
    }

    public void signalSuccess() {
        this.lastWasSuccess = true;
        this.currentRetryDelay = 0L;
    }

    public void setMaxDelay() {
        this.currentRetryDelay = this.maxRetryDelay;
    }

    public void cancel() {
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling existing retry attempt", new Object[0]);
            this.scheduledRetry.cancel(false);
            this.scheduledRetry = null;
        } else {
            this.logger.debug("No existing retry attempt to cancel", new Object[0]);
        }
        this.currentRetryDelay = 0L;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
    public static class Builder {
        private final LogWrapper logger;
        private final ScheduledExecutorService service;
        private long minRetryDelayAfterFailure = 1000;
        private double jitterFactor = 0.5d;
        private long retryMaxDelay = 30000;
        private double retryExponent = 1.3d;

        public Builder(ScheduledExecutorService scheduledExecutorService, Logger logger, String str) {
            this.service = scheduledExecutorService;
            this.logger = new LogWrapper(logger, str);
        }

        public Builder withMinDelayAfterFailure(long j) {
            this.minRetryDelayAfterFailure = j;
            return this;
        }

        public Builder withMaxDelay(long j) {
            this.retryMaxDelay = j;
            return this;
        }

        public Builder withRetryExponent(double d2) {
            this.retryExponent = d2;
            return this;
        }

        public Builder withJitterFactor(double d2) {
            if (d2 < 0.0d || d2 > 1.0d) {
                throw new IllegalArgumentException("Argument out of range: " + d2);
            }
            this.jitterFactor = d2;
            return this;
        }

        public RetryHelper build() {
            return new RetryHelper(this.service, this.logger, this.minRetryDelayAfterFailure, this.retryMaxDelay, this.retryExponent, this.jitterFactor);
        }
    }
}
