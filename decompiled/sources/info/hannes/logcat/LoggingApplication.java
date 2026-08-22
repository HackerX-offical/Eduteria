package info.hannes.logcat;

import android.app.Application;
import info.hannes.timber.DebugFormatTree;
import kotlin.Metadata;
import timber.log.Timber;

/* JADX INFO: compiled from: LoggingApplication.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, d2 = {"Linfo/hannes/logcat/LoggingApplication;", "Landroid/app/Application;", "<init>", "()V", "onCreate", "", "setupLogging", "LogcatCore_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class LoggingApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        setupLogging();
    }

    protected void setupLogging() {
        LoggingTools.INSTANCE.globalErrorCatcher();
        Timber.INSTANCE.plant(new DebugFormatTree(false, 1, null));
    }
}
