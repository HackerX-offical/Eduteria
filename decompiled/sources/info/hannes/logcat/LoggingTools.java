package info.hannes.logcat;

import java.lang.Thread;
import kotlin.Metadata;
import timber.log.Timber;

/* JADX INFO: compiled from: LoggingTools.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Linfo/hannes/logcat/LoggingTools;", "", "<init>", "()V", "globalErrorCatcher", "", "LogcatCore_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LoggingTools {
    public static final LoggingTools INSTANCE = new LoggingTools();

    private LoggingTools() {
    }

    public final void globalErrorCatcher() {
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: info.hannes.logcat.LoggingTools$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                LoggingTools.globalErrorCatcher$lambda$2(defaultUncaughtExceptionHandler, thread, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void globalErrorCatcher$lambda$2(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        Timber.Companion companion = Timber.INSTANCE;
        Throwable cause = th.getCause();
        if (cause == null) {
            cause = th;
        }
        companion.e(cause);
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
