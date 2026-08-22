package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
class TransferThreadPool {
    private static final Log LOGGER = LogFactory.getLog(TransferService.class);
    private static final int WAIT_TIME = 250;
    private static ExecutorService executorMainTask;
    private static ExecutorService executorPartTask;

    TransferThreadPool() {
    }

    static synchronized void init(int i) {
        LOGGER.debug("Initializing the thread pool of size: " + i);
        int iMax = Math.max((int) Math.ceil(((double) i) / 2.0d), 1);
        if (executorMainTask == null) {
            executorMainTask = buildExecutor(iMax);
        }
        if (executorPartTask == null) {
            executorPartTask = buildExecutor(iMax);
        }
    }

    public static <T> Future<T> submitTask(Callable<T> callable) {
        init(TransferUtilityOptions.getDefaultThreadPoolSize());
        if (callable instanceof UploadPartTask) {
            return executorPartTask.submit(callable);
        }
        return executorMainTask.submit(callable);
    }

    public static void closeThreadPool() {
        ExecutorService executorService = executorPartTask;
        if (executorService != null) {
            shutdown(executorService);
            executorPartTask = null;
        }
        ExecutorService executorService2 = executorMainTask;
        if (executorService2 != null) {
            shutdown(executorService2);
            executorMainTask = null;
        }
    }

    private static void shutdown(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(250L, TimeUnit.MILLISECONDS)) {
                return;
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static ExecutorService buildExecutor(int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
