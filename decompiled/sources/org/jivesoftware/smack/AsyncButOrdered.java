package org.jivesoftware.smack;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes10.dex */
public class AsyncButOrdered<K> {
    private final Executor executor;
    private final Map<K, Queue<Runnable>> pendingRunnables;
    private final Map<K, AsyncButOrdered<K>.Handler> threadActiveMap;

    public AsyncButOrdered() {
        this(null);
    }

    public AsyncButOrdered(Executor executor) {
        this.pendingRunnables = new WeakHashMap();
        this.threadActiveMap = new HashMap();
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleHandler(AsyncButOrdered<K>.Handler handler) {
        Executor executor = this.executor;
        if (executor == null) {
            AbstractXMPPConnection.asyncGo(handler);
        } else {
            executor.execute(handler);
        }
    }

    public boolean performAsyncButOrdered(K k, Runnable runnable) {
        Queue<Runnable> concurrentLinkedQueue;
        AsyncButOrdered<K>.Handler handler;
        synchronized (this.pendingRunnables) {
            concurrentLinkedQueue = this.pendingRunnables.get(k);
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                this.pendingRunnables.put(k, concurrentLinkedQueue);
            }
        }
        concurrentLinkedQueue.add(runnable);
        synchronized (this.threadActiveMap) {
            if (this.threadActiveMap.containsKey(k)) {
                handler = null;
            } else {
                handler = new Handler(concurrentLinkedQueue, k);
                this.threadActiveMap.put(k, handler);
            }
        }
        if (handler == null) {
            return false;
        }
        scheduleHandler(handler);
        return true;
    }

    public Executor asExecutorFor(final K k) {
        return new Executor() { // from class: org.jivesoftware.smack.AsyncButOrdered.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                AsyncButOrdered.this.performAsyncButOrdered(k, runnable);
            }
        };
    }

    private class Handler implements Runnable {
        private final K key;
        private final Queue<Runnable> keyQueue;

        Handler(Queue<Runnable> queue, K k) {
            this.keyQueue = queue;
            this.key = k;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                Runnable runnablePoll = this.keyQueue.poll();
                if (runnablePoll == null) {
                    synchronized (AsyncButOrdered.this.threadActiveMap) {
                        if (this.keyQueue.isEmpty()) {
                            AsyncButOrdered.this.threadActiveMap.remove(this.key);
                            return;
                        }
                    }
                } else {
                    try {
                        runnablePoll.run();
                    } catch (Throwable th) {
                        Handler handler = new Handler(this.keyQueue, this.key);
                        synchronized (AsyncButOrdered.this.threadActiveMap) {
                            AsyncButOrdered.this.threadActiveMap.put(this.key, handler);
                            AsyncButOrdered.this.scheduleHandler(handler);
                            throw th;
                        }
                    }
                }
            }
        }
    }
}
