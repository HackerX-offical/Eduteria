package androidx.work;

/* JADX INFO: loaded from: classes4.dex */
public interface RunnableScheduler {
    void cancel(Runnable runnable);

    void scheduleWithDelay(long delayInMillis, Runnable runnable);
}
