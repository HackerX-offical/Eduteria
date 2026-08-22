package com.google.common.eventbus;

/* JADX INFO: loaded from: classes8.dex */
@ElementTypesAreNonnullByDefault
public interface SubscriberExceptionHandler {
    void handleException(Throwable exception, SubscriberExceptionContext context);
}
