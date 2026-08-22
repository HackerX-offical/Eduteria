package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes8.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract BlockingQueue<E> delegate();

    protected ForwardingBlockingQueue() {
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c2, int maxElements) {
        return delegate().drainTo(c2, maxElements);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c2) {
        return delegate().drainTo(c2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().offer(e2, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    @CheckForNull
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().poll(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        delegate().put(e2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }
}
