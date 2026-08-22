package org.jivesoftware.smack;

import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ScheduledAction;

/* JADX INFO: loaded from: classes10.dex */
public class SmackReactor {
    private static final int DEFAULT_REACTOR_THREAD_COUNT = 2;
    private static SmackReactor INSTANCE = null;
    private static final Logger LOGGER = Logger.getLogger(SmackReactor.class.getName());
    private static final int PENDING_SET_INTEREST_OPS_MAX_BATCH_SIZE = 1024;
    private final String reactorName;
    private final Selector selector;
    private final List<Reactor> reactorThreads = Collections.synchronizedList(new ArrayList());
    private final DelayQueue<ScheduledAction> scheduledActions = new DelayQueue<>();
    private final Lock registrationLock = new ReentrantLock();
    private final Semaphore actionsSemaphore = new Semaphore(-1, false);
    private final Queue<SelectionKey> pendingSelectionKeys = new ConcurrentLinkedQueue();
    private final Queue<SetInterestOps> pendingSetInterestOps = new ConcurrentLinkedQueue();

    public interface ChannelSelectedCallback {
        void onChannelSelected(SelectableChannel selectableChannel, SelectionKey selectionKey);
    }

    static synchronized SmackReactor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SmackReactor("DefaultReactor");
        }
        return INSTANCE;
    }

    SmackReactor(String str) {
        this.reactorName = str;
        try {
            this.selector = Selector.open();
            setReactorThreadCount(2);
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public SelectionKey registerWithSelector(SelectableChannel selectableChannel, int i, ChannelSelectedCallback channelSelectedCallback) throws ClosedChannelException {
        SelectionKeyAttachment selectionKeyAttachment = new SelectionKeyAttachment(channelSelectedCallback);
        this.registrationLock.lock();
        try {
            this.selector.wakeup();
            return selectableChannel.register(this.selector, i, selectionKeyAttachment);
        } finally {
            this.registrationLock.unlock();
        }
    }

    public void setInterestOps(SelectionKey selectionKey, int i) {
        this.pendingSetInterestOps.add(new SetInterestOps(selectionKey, i));
        this.selector.wakeup();
    }

    private static final class SetInterestOps {
        private final int interestOps;
        private final SelectionKey selectionKey;

        private SetInterestOps(SelectionKey selectionKey, int i) {
            this.selectionKey = selectionKey;
            this.interestOps = i;
        }
    }

    ScheduledAction schedule(Runnable runnable, long j, TimeUnit timeUnit, ScheduledAction.Kind kind) {
        ScheduledAction scheduledAction = new ScheduledAction(runnable, new Date(System.currentTimeMillis() + timeUnit.toMillis(j)), this, kind);
        this.scheduledActions.add(scheduledAction);
        this.selector.wakeup();
        return scheduledAction;
    }

    boolean cancel(ScheduledAction scheduledAction) {
        return this.scheduledActions.remove(scheduledAction);
    }

    private class Reactor extends Thread {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile long shutdownRequestTimestamp;

        private Reactor() {
            this.shutdownRequestTimestamp = -1L;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                reactorLoop();
                if (this.shutdownRequestTimestamp <= 0) {
                    SmackReactor.this.reactorThreads.remove(this);
                } else {
                    SmackReactor.LOGGER.info(this + " shut down after " + (System.currentTimeMillis() - this.shutdownRequestTimestamp) + "ms");
                }
            } catch (Throwable th) {
                if (this.shutdownRequestTimestamp <= 0) {
                    SmackReactor.this.reactorThreads.remove(this);
                } else {
                    SmackReactor.LOGGER.info(this + " shut down after " + (System.currentTimeMillis() - this.shutdownRequestTimestamp) + "ms");
                }
                throw th;
            }
        }

        private void reactorLoop() {
            while (this.shutdownRequestTimestamp < 0) {
                handleScheduledActionsOrPerformSelect();
                handlePendingSelectionKeys();
            }
        }

        private void handleScheduledActionsOrPerformSelect() {
            ScheduledAction scheduledAction;
            if (SmackReactor.this.actionsSemaphore.tryAcquire()) {
                try {
                    scheduledAction = (ScheduledAction) SmackReactor.this.scheduledActions.poll();
                } finally {
                    SmackReactor.this.actionsSemaphore.release();
                }
            } else {
                scheduledAction = null;
            }
            if (scheduledAction == null) {
                synchronized (SmackReactor.this.selector) {
                    ScheduledAction scheduledAction2 = (ScheduledAction) SmackReactor.this.scheduledActions.peek();
                    long timeToDueMillis = scheduledAction2 == null ? 0L : scheduledAction2.getTimeToDueMillis();
                    if (timeToDueMillis < 0) {
                        return;
                    }
                    int i = 0;
                    while (true) {
                        SetInterestOps setInterestOps = (SetInterestOps) SmackReactor.this.pendingSetInterestOps.poll();
                        if (setInterestOps == null) {
                            break;
                        }
                        setInterestOpsCancelledKeySafe(setInterestOps.selectionKey, setInterestOps.interestOps);
                        int i2 = i + 1;
                        if (i >= 1024) {
                            SmackReactor.this.selector.wakeup();
                            break;
                        }
                        i = i2;
                    }
                    SmackReactor.this.registrationLock.lock();
                    SmackReactor.this.registrationLock.unlock();
                    try {
                        int iSelect = SmackReactor.this.selector.select(timeToDueMillis);
                        if (iSelect == 0) {
                            return;
                        }
                        Set<SelectionKey> setSelectedKeys = SmackReactor.this.selector.selectedKeys();
                        Iterator<SelectionKey> it = setSelectedKeys.iterator();
                        while (it.hasNext()) {
                            ((SelectionKeyAttachment) it.next().attachment()).setRacing();
                        }
                        Iterator<SelectionKey> it2 = setSelectedKeys.iterator();
                        while (it2.hasNext()) {
                            setInterestOpsCancelledKeySafe(it2.next(), 0);
                        }
                        ArrayList arrayList = new ArrayList(setSelectedKeys.size());
                        arrayList.addAll(setSelectedKeys);
                        setSelectedKeys.clear();
                        int size = arrayList.size();
                        int size2 = SmackReactor.this.reactorThreads.size();
                        int i3 = size > size2 ? size / size2 : size;
                        Level level = Level.FINE;
                        if (SmackReactor.LOGGER.isLoggable(level)) {
                            SmackReactor.LOGGER.log(level, "New selected key count: " + iSelect + ". Total selected key count " + size + ". My key count: " + i3 + ". Current reactor thread count: " + size2);
                        }
                        ArrayList arrayList2 = new ArrayList(i3);
                        Iterator it3 = arrayList.iterator();
                        for (int i4 = 0; i4 < i3; i4++) {
                            arrayList2.add((SelectionKey) it3.next());
                        }
                        while (it3.hasNext()) {
                            SmackReactor.this.pendingSelectionKeys.add((SelectionKey) it3.next());
                        }
                        if (size - i3 > 0) {
                            SmackReactor.this.selector.wakeup();
                        }
                        SmackReactor.handleSelectedKeys(arrayList2);
                        return;
                    } catch (IOException e2) {
                        SmackReactor.LOGGER.log(Level.SEVERE, "IOException while using select()", (Throwable) e2);
                        return;
                    }
                }
            }
            scheduledAction.run();
        }

        private void handlePendingSelectionKeys() {
            int size = SmackReactor.this.pendingSelectionKeys.size();
            if (size == 0) {
                return;
            }
            int size2 = size / SmackReactor.this.reactorThreads.size();
            ArrayList arrayList = new ArrayList(size2);
            for (int i = 0; i < size2; i++) {
                SelectionKey selectionKey = (SelectionKey) SmackReactor.this.pendingSelectionKeys.poll();
                if (selectionKey == null) {
                    break;
                }
                arrayList.add(selectionKey);
            }
            if (!SmackReactor.this.pendingSelectionKeys.isEmpty()) {
                SmackReactor.this.selector.wakeup();
            }
            SmackReactor.handleSelectedKeys(arrayList);
        }

        private void setInterestOpsCancelledKeySafe(SelectionKey selectionKey, int i) {
            try {
                selectionKey.interestOps(i);
            } catch (CancelledKeyException e2) {
                Level level = Level.FINER;
                if (SmackReactor.LOGGER.isLoggable(level)) {
                    SmackReactor.LOGGER.log(level, "Key '" + selectionKey + "' has been cancelled", (Throwable) e2);
                }
            }
        }

        void requestShutdown() {
            this.shutdownRequestTimestamp = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleSelectedKeys(Collection<SelectionKey> collection) {
        for (SelectionKey selectionKey : collection) {
            ((SelectionKeyAttachment) selectionKey.attachment()).channelSelectedCallback.onChannelSelected(selectionKey.channel(), selectionKey);
        }
    }

    public void setReactorThreadCount(int i) {
        if (i < 2) {
            throw new IllegalArgumentException("Must have at least two reactor threads, but you requested " + i);
        }
        synchronized (this.reactorThreads) {
            int size = i - this.reactorThreads.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    Reactor reactor = new Reactor();
                    reactor.setDaemon(true);
                    reactor.setName("Smack " + this.reactorName + " Thread #" + i2);
                    this.reactorThreads.add(reactor);
                    reactor.start();
                }
                this.actionsSemaphore.release(size);
            } else {
                int i3 = 0 - 1;
                for (int i4 = i3; i4 > 0; i4--) {
                    this.actionsSemaphore.acquireUninterruptibly();
                }
                while (i3 > 0) {
                    this.reactorThreads.remove(i3).requestShutdown();
                    i3--;
                }
                this.selector.wakeup();
            }
        }
    }

    public static final class SelectionKeyAttachment {
        private final ChannelSelectedCallback channelSelectedCallback;
        private final AtomicBoolean reactorThreadRacing;

        private SelectionKeyAttachment(ChannelSelectedCallback channelSelectedCallback) {
            this.reactorThreadRacing = new AtomicBoolean();
            this.channelSelectedCallback = channelSelectedCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRacing() {
            this.reactorThreadRacing.lazySet(true);
        }

        public void resetReactorThreadRacing() {
            this.reactorThreadRacing.set(false);
        }

        public boolean isReactorThreadRacing() {
            return this.reactorThreadRacing.get();
        }
    }
}
