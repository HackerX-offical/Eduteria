package org.jivesoftware.smack.util;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes10.dex */
public class ArrayBlockingQueueWithShutdown<E> extends AbstractQueue<E> implements BlockingQueue<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int count;
    private volatile boolean isShutdown;
    private final E[] items;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    private int putIndex;
    private int takeIndex;

    public enum TryPutResult {
        couldNotLock,
        queueWasShutDown,
        queueWasFull,
        putSuccessful
    }

    public enum TryTakeResultCode {
        couldNotLock,
        queueWasShutDown,
        queueWasEmpty,
        takeSuccessful
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int inc(int i) {
        int i2 = i + 1;
        if (i2 == this.items.length) {
            return 0;
        }
        return i2;
    }

    private void insert(E e2) {
        insert(e2, true);
    }

    private void insert(E e2, boolean z) {
        E[] eArr = this.items;
        int i = this.putIndex;
        eArr[i] = e2;
        this.putIndex = inc(i);
        this.count++;
        if (z) {
            this.notEmpty.signal();
        }
    }

    private E extract() {
        E[] eArr = this.items;
        int i = this.takeIndex;
        E e2 = eArr[i];
        eArr[i] = null;
        this.takeIndex = inc(i);
        this.count--;
        this.notFull.signal();
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAt(int i) {
        int i2 = this.takeIndex;
        if (i == i2) {
            this.items[i2] = null;
            this.takeIndex = inc(i2);
        } else {
            while (true) {
                int iInc = inc(i);
                if (iInc == this.putIndex) {
                    break;
                }
                E[] eArr = this.items;
                eArr[i] = eArr[iInc];
                i = iInc;
            }
            this.items[i] = null;
            this.putIndex = i;
        }
        this.count--;
        this.notFull.signal();
    }

    private static void checkNotNull(Object obj) {
        obj.getClass();
    }

    private void checkNotShutdown() throws InterruptedException {
        if (this.isShutdown) {
            throw new InterruptedException("Queue was already shut down");
        }
    }

    private boolean hasNoElements() {
        return this.count == 0;
    }

    private boolean hasElements() {
        return !hasNoElements();
    }

    private boolean isFull() {
        return this.count == this.items.length;
    }

    private boolean isNotFull() {
        return !isFull();
    }

    public ArrayBlockingQueueWithShutdown(int i) {
        this(i, false);
    }

    public ArrayBlockingQueueWithShutdown(int i, boolean z) {
        this.isShutdown = false;
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.items = (E[]) new Object[i];
        ReentrantLock reentrantLock = new ReentrantLock(z);
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
    }

    public void shutdown() {
        this.lock.lock();
        try {
            this.isShutdown = true;
            this.notEmpty.signalAll();
            this.notFull.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean start() {
        this.lock.lock();
        try {
            boolean z = this.isShutdown;
            this.isShutdown = false;
            return z;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isShutdown() {
        this.lock.lock();
        try {
            return this.isShutdown;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        this.lock.lock();
        try {
            if (!hasNoElements()) {
                return extract();
            }
            this.lock.unlock();
            return null;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Queue
    public E peek() {
        this.lock.lock();
        try {
            return hasNoElements() ? null : this.items[this.takeIndex];
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        checkNotNull(e2);
        this.lock.lock();
        try {
            if (!isFull() && !this.isShutdown) {
                insert(e2);
                this.lock.unlock();
                return true;
            }
            this.lock.unlock();
            return false;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public boolean offerAndShutdown(E e2) {
        checkNotNull(e2);
        this.lock.lock();
        try {
            boolean zOffer = offer(e2);
            shutdown();
            return zOffer;
        } finally {
            this.lock.unlock();
        }
    }

    private void putInternal(E e2, boolean z) throws InterruptedException {
        while (isFull()) {
            try {
                this.notFull.await();
                checkNotShutdown();
            } catch (InterruptedException e3) {
                this.notFull.signal();
                throw e3;
            }
        }
        insert(e2, z);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        checkNotNull(e2);
        this.lock.lockInterruptibly();
        try {
            putInternal(e2, true);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean putIfNotShutdown(E e2) throws InterruptedException {
        checkNotNull(e2);
        this.lock.lockInterruptibly();
        try {
            if (!this.isShutdown) {
                putInternal(e2, true);
                return true;
            }
            this.lock.unlock();
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    public void putAll(Collection<? extends E> collection) throws InterruptedException {
        checkNotNull(collection);
        this.lock.lockInterruptibly();
        try {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                putInternal(it.next(), false);
            }
        } finally {
            this.notEmpty.signalAll();
            this.lock.unlock();
        }
    }

    public TryPutResult tryPut(E e2) {
        TryPutResult tryPutResult;
        checkNotNull(e2);
        if (!this.lock.tryLock()) {
            return TryPutResult.couldNotLock;
        }
        try {
            if (this.isShutdown) {
                tryPutResult = TryPutResult.queueWasShutDown;
            } else if (isFull()) {
                tryPutResult = TryPutResult.queueWasFull;
            } else {
                insert(e2);
                tryPutResult = TryPutResult.putSuccessful;
            }
            return tryPutResult;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        checkNotNull(e2);
        long nanos = timeUnit.toNanos(j);
        this.lock.lockInterruptibly();
        while (!isNotFull()) {
            try {
                if (nanos <= 0) {
                    this.lock.unlock();
                    return false;
                }
                try {
                    nanos = this.notFull.awaitNanos(nanos);
                    checkNotShutdown();
                } catch (InterruptedException e3) {
                    this.notFull.signal();
                    throw e3;
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        insert(e2);
        this.lock.unlock();
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        this.lock.lockInterruptibly();
        try {
            checkNotShutdown();
            while (hasNoElements()) {
                try {
                    this.notEmpty.await();
                    checkNotShutdown();
                } catch (InterruptedException e2) {
                    this.notEmpty.signal();
                    throw e2;
                }
            }
            return extract();
        } finally {
            this.lock.unlock();
        }
    }

    public static final class TryTakeResult<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final E element;
        private final TryTakeResultCode resultCode;

        private TryTakeResult(TryTakeResultCode tryTakeResultCode) {
            this.resultCode = tryTakeResultCode;
            this.element = null;
        }

        private TryTakeResult(E e2) {
            this.resultCode = TryTakeResultCode.takeSuccessful;
            this.element = e2;
        }

        public TryTakeResultCode getResultCode() {
            return this.resultCode;
        }

        public E getElement() {
            return this.element;
        }
    }

    public TryTakeResult<E> tryTake() {
        if (!this.lock.tryLock()) {
            return new TryTakeResult<>(TryTakeResultCode.couldNotLock);
        }
        try {
            if (this.isShutdown) {
                return new TryTakeResult<>(TryTakeResultCode.queueWasShutDown);
            }
            if (hasNoElements()) {
                return new TryTakeResult<>(TryTakeResultCode.queueWasEmpty);
            }
            return new TryTakeResult<>(extract());
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        this.lock.lockInterruptibly();
        try {
            checkNotShutdown();
            while (!hasElements()) {
                if (nanos <= 0) {
                    this.lock.unlock();
                    return null;
                }
                try {
                    nanos = this.notEmpty.awaitNanos(nanos);
                    checkNotShutdown();
                } catch (InterruptedException e2) {
                    this.notEmpty.signal();
                    throw e2;
                }
            }
            return extract();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        this.lock.lock();
        try {
            return this.items.length - this.count;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        checkNotNull(collection);
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        this.lock.lock();
        try {
            int iInc = this.takeIndex;
            int i = 0;
            while (i < this.count) {
                collection.add(this.items[iInc]);
                this.items[iInc] = null;
                iInc = inc(iInc);
                i++;
            }
            if (i > 0) {
                this.count = 0;
                this.putIndex = 0;
                this.takeIndex = 0;
                this.notFull.signalAll();
            }
            return i;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        checkNotNull(collection);
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        if (i <= 0) {
            return 0;
        }
        this.lock.lock();
        try {
            int iInc = this.takeIndex;
            int i3 = this.count;
            if (i >= i3) {
                i = i3;
            }
            while (i2 < i) {
                collection.add(this.items[iInc]);
                this.items[iInc] = null;
                iInc = inc(iInc);
                i2++;
            }
            if (i2 > 0) {
                this.count -= i2;
                this.takeIndex = iInc;
                this.notFull.signalAll();
            }
            return i2;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        this.lock.lock();
        try {
            return this.count;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        this.lock.lock();
        try {
            return new Itr();
        } finally {
            this.lock.unlock();
        }
    }

    private class Itr implements Iterator<E> {
        private int lastRet = -1;
        private int nextIndex;
        private E nextItem;

        Itr() {
            if (ArrayBlockingQueueWithShutdown.this.count != 0) {
                this.nextIndex = ArrayBlockingQueueWithShutdown.this.takeIndex;
                this.nextItem = (E) ArrayBlockingQueueWithShutdown.this.items[ArrayBlockingQueueWithShutdown.this.takeIndex];
            } else {
                this.nextIndex = -1;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex >= 0;
        }

        private void checkNext() {
            if (this.nextIndex != ArrayBlockingQueueWithShutdown.this.putIndex) {
                E e2 = (E) ArrayBlockingQueueWithShutdown.this.items[this.nextIndex];
                this.nextItem = e2;
                if (e2 == null) {
                    this.nextIndex = -1;
                    return;
                }
                return;
            }
            this.nextIndex = -1;
            this.nextItem = null;
        }

        @Override // java.util.Iterator
        public E next() {
            ArrayBlockingQueueWithShutdown.this.lock.lock();
            try {
                int i = this.nextIndex;
                if (i < 0) {
                    throw new NoSuchElementException();
                }
                this.lastRet = i;
                E e2 = this.nextItem;
                this.nextIndex = ArrayBlockingQueueWithShutdown.this.inc(i);
                checkNext();
                return e2;
            } finally {
                ArrayBlockingQueueWithShutdown.this.lock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            ArrayBlockingQueueWithShutdown.this.lock.lock();
            try {
                int i = this.lastRet;
                if (i < 0) {
                    throw new IllegalStateException();
                }
                this.lastRet = -1;
                int i2 = ArrayBlockingQueueWithShutdown.this.takeIndex;
                ArrayBlockingQueueWithShutdown.this.removeAt(i);
                if (i == i2) {
                    i = ArrayBlockingQueueWithShutdown.this.takeIndex;
                }
                this.nextIndex = i;
                checkNext();
            } finally {
                ArrayBlockingQueueWithShutdown.this.lock.unlock();
            }
        }
    }
}
