package info.mqtt.android.service;

import kotlin.Metadata;

/* JADX INFO: compiled from: MqttTraceHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH&¨\u0006\u000b"}, d2 = {"Linfo/mqtt/android/service/MqttTraceHandler;", "", "traceDebug", "", "message", "", "traceError", "traceException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MqttTraceHandler {
    void traceDebug(String message);

    void traceError(String message);

    void traceException(String message, Exception e2);
}
