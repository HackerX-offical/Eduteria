package org.jivesoftware.smack;

import java.io.IOException;
import java.lang.Exception;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.CallbackRecipient;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.SuccessCallback;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SmackFuture<V, E extends Exception> implements Future<V>, CallbackRecipient<V, E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(SmackFuture.class.getName());
    private boolean cancelled;
    private Consumer<SmackFuture<V, E>> completionCallback;
    protected E exception;
    private org.jivesoftware.smack.util.ExceptionCallback<E> exceptionCallback;
    protected V result;
    private SuccessCallback<V> successCallback;

    public static abstract class SimpleInternalProcessStanzaSmackFuture<V, E extends Exception> extends InternalProcessStanzaSmackFuture<V, E> {
        @Override // org.jivesoftware.smack.SmackFuture.InternalProcessStanzaSmackFuture
        protected boolean isNonFatalException(E e2) {
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean cancel(boolean z) {
        if (isDone()) {
            return false;
        }
        this.cancelled = true;
        if (z) {
            notifyAll();
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isDone() {
        return this.result != null;
    }

    @Override // org.jivesoftware.smack.util.CallbackRecipient
    public CallbackRecipient<V, E> onSuccess(SuccessCallback<V> successCallback) {
        this.successCallback = successCallback;
        maybeInvokeCallbacks();
        return this;
    }

    @Override // org.jivesoftware.smack.util.CallbackRecipient
    public CallbackRecipient<V, E> onError(org.jivesoftware.smack.util.ExceptionCallback<E> exceptionCallback) {
        this.exceptionCallback = exceptionCallback;
        maybeInvokeCallbacks();
        return this;
    }

    public void onCompletion(Consumer<SmackFuture<V, E>> consumer) {
        this.completionCallback = consumer;
        maybeInvokeCallbacks();
    }

    private V getOrThrowExecutionException() throws ExecutionException {
        V v = this.result;
        if (v != null) {
            return v;
        }
        if (this.exception != null) {
            throw new ExecutionException(this.exception);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public final synchronized V get() throws ExecutionException, InterruptedException {
        while (this.result == null && this.exception == null && !this.cancelled) {
            futureWait();
        }
        return getOrThrowExecutionException();
    }

    public final synchronized V getOrThrow() throws Exception {
        V v;
        while (true) {
            v = this.result;
            if (v != null || this.exception != null || this.cancelled) {
                break;
            }
            futureWait();
        }
        E e2 = this.exception;
        if (e2 != null) {
            throw e2;
        }
        if (this.cancelled) {
            throw new CancellationException();
        }
        return v;
    }

    @Override // java.util.concurrent.Future
    public final synchronized V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        V v;
        long jCurrentTimeMillis = System.currentTimeMillis() + timeUnit.toMillis(j);
        while (true) {
            v = this.result;
            if (v == null || this.exception == null) {
                break;
            }
            long jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis();
            if (jCurrentTimeMillis2 > 0) {
                futureWait(jCurrentTimeMillis2);
            }
        }
        if (this.cancelled) {
            throw new CancellationException();
        }
        if (v == null || this.exception == null) {
            throw new TimeoutException();
        }
        return getOrThrowExecutionException();
    }

    public V getIfAvailable() {
        return this.result;
    }

    protected final synchronized void maybeInvokeCallbacks() {
        Consumer<SmackFuture<V, E>> consumer;
        if (this.cancelled) {
            return;
        }
        if ((this.result != null || this.exception != null) && (consumer = this.completionCallback) != null) {
            consumer.accept(this);
        }
        if (this.result != null && this.successCallback != null) {
            AbstractXMPPConnection.asyncGo(new Runnable() { // from class: org.jivesoftware.smack.SmackFuture.1
                @Override // java.lang.Runnable
                public void run() {
                    SmackFuture.this.successCallback.onSuccess(SmackFuture.this.result);
                }
            });
        } else if (this.exception != null && this.exceptionCallback != null) {
            AbstractXMPPConnection.asyncGo(new Runnable() { // from class: org.jivesoftware.smack.SmackFuture.2
                @Override // java.lang.Runnable
                public void run() {
                    SmackFuture.this.exceptionCallback.processException(SmackFuture.this.exception);
                }
            });
        }
    }

    protected final void futureWait() throws InterruptedException {
        futureWait(0L);
    }

    protected void futureWait(long j) throws InterruptedException {
        wait(j);
    }

    public static class InternalSmackFuture<V, E extends Exception> extends SmackFuture<V, E> {
        public final synchronized void setResult(V v) {
            this.result = v;
            notifyAll();
            maybeInvokeCallbacks();
        }

        public final synchronized void setException(E e2) {
            this.exception = e2;
            notifyAll();
            maybeInvokeCallbacks();
        }
    }

    public static class SocketFuture extends InternalSmackFuture<Socket, IOException> {
        private final Socket socket;
        private boolean wasInterrupted;
        private final Object wasInterruptedLock = new Object();

        public SocketFuture(SocketFactory socketFactory) throws IOException {
            this.socket = socketFactory.createSocket();
        }

        @Override // org.jivesoftware.smack.SmackFuture
        protected void futureWait(long j) throws InterruptedException {
            try {
                super.futureWait(j);
            } catch (InterruptedException e2) {
                synchronized (this.wasInterruptedLock) {
                    this.wasInterrupted = true;
                    if (!this.socket.isClosed()) {
                        closeSocket();
                    }
                    throw e2;
                }
            }
        }

        public void connectAsync(final SocketAddress socketAddress, final int i) {
            AbstractXMPPConnection.asyncGo(new Runnable() { // from class: org.jivesoftware.smack.SmackFuture.SocketFuture.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SocketFuture.this.socket.connect(socketAddress, i);
                        synchronized (SocketFuture.this.wasInterruptedLock) {
                            if (SocketFuture.this.wasInterrupted) {
                                SocketFuture.this.closeSocket();
                            } else {
                                SocketFuture socketFuture = SocketFuture.this;
                                socketFuture.setResult(socketFuture.socket);
                            }
                        }
                    } catch (IOException e2) {
                        SocketFuture.this.setException(e2);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeSocket() {
            try {
                this.socket.close();
            } catch (IOException e2) {
                SmackFuture.LOGGER.log(Level.WARNING, "Could not close socket", (Throwable) e2);
            }
        }
    }

    public static abstract class InternalProcessStanzaSmackFuture<V, E extends Exception> extends InternalSmackFuture<V, E> implements StanzaListener, org.jivesoftware.smack.util.ExceptionCallback<E> {
        protected abstract void handleStanza(Stanza stanza);

        protected abstract boolean isNonFatalException(E e2);

        @Override // org.jivesoftware.smack.util.ExceptionCallback
        public final synchronized void processException(E e2) {
            if (!isNonFatalException(e2)) {
                this.exception = e2;
                notifyAll();
                maybeInvokeCallbacks();
            }
        }

        @Override // org.jivesoftware.smack.StanzaListener
        public final synchronized void processStanza(Stanza stanza) {
            handleStanza(stanza);
        }
    }

    public static <V, E extends Exception> SmackFuture<V, E> from(V v) {
        InternalSmackFuture internalSmackFuture = new InternalSmackFuture();
        internalSmackFuture.setResult(v);
        return internalSmackFuture;
    }

    public static boolean await(Collection<? extends SmackFuture<?, ?>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(collection.size());
        Iterator<? extends SmackFuture<?, ?>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().onCompletion(new Consumer() { // from class: org.jivesoftware.smack.SmackFuture$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.Consumer
                public final void accept(Object obj) {
                    countDownLatch.countDown();
                }
            });
        }
        return countDownLatch.await(j, timeUnit);
    }
}
