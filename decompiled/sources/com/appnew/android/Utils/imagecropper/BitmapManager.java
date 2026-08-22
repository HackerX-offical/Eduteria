package com.appnew.android.Utils.imagecropper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileDescriptor;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class BitmapManager {
    private static final String TAG = "BitmapManager";
    private static BitmapManager sManager;
    private final WeakHashMap<Thread, ThreadStatus> mThreadStatus = new WeakHashMap<>();

    private enum State {
        CANCEL,
        ALLOW
    }

    private static class ThreadStatus {
        public BitmapFactory.Options mOptions;
        public State mState;

        private ThreadStatus() {
            this.mState = State.ALLOW;
        }

        public String toString() {
            String str;
            if (this.mState == State.CANCEL) {
                str = "Cancel";
            } else if (this.mState == State.ALLOW) {
                str = "Allow";
            } else {
                str = "?";
            }
            return "thread state = " + str + ", options = " + this.mOptions;
        }
    }

    public static class ThreadSet implements Iterable<Thread> {
        private final WeakHashMap<Thread, Object> mWeakCollection = new WeakHashMap<>();

        public void add(Thread t) {
            this.mWeakCollection.put(t, null);
        }

        public void remove(Thread t) {
            this.mWeakCollection.remove(t);
        }

        @Override // java.lang.Iterable
        public Iterator<Thread> iterator() {
            return this.mWeakCollection.keySet().iterator();
        }
    }

    private BitmapManager() {
    }

    private synchronized ThreadStatus getOrCreateThreadStatus(Thread t) {
        ThreadStatus threadStatus;
        threadStatus = this.mThreadStatus.get(t);
        if (threadStatus == null) {
            threadStatus = new ThreadStatus();
            this.mThreadStatus.put(t, threadStatus);
        }
        return threadStatus;
    }

    private synchronized void setDecodingOptions(Thread t, BitmapFactory.Options options) {
        getOrCreateThreadStatus(t).mOptions = options;
    }

    synchronized BitmapFactory.Options getDecodingOptions(Thread t) {
        ThreadStatus threadStatus;
        threadStatus = this.mThreadStatus.get(t);
        return threadStatus != null ? threadStatus.mOptions : null;
    }

    synchronized void removeDecodingOptions(Thread t) {
        this.mThreadStatus.get(t).mOptions = null;
    }

    public synchronized void allowThreadDecoding(ThreadSet threads) {
        Iterator<Thread> it = threads.iterator();
        while (it.hasNext()) {
            allowThreadDecoding(it.next());
        }
    }

    public synchronized void cancelThreadDecoding(ThreadSet threads) {
        Iterator<Thread> it = threads.iterator();
        while (it.hasNext()) {
            cancelThreadDecoding(it.next());
        }
    }

    public synchronized boolean canThreadDecoding(Thread t) {
        ThreadStatus threadStatus = this.mThreadStatus.get(t);
        if (threadStatus == null) {
            return true;
        }
        return threadStatus.mState != State.CANCEL;
    }

    public synchronized void allowThreadDecoding(Thread t) {
        getOrCreateThreadStatus(t).mState = State.ALLOW;
    }

    public synchronized void cancelThreadDecoding(Thread t) {
        ThreadStatus orCreateThreadStatus = getOrCreateThreadStatus(t);
        orCreateThreadStatus.mState = State.CANCEL;
        if (orCreateThreadStatus.mOptions != null) {
            orCreateThreadStatus.mOptions.requestCancelDecode();
        }
        notifyAll();
    }

    public synchronized void dump() {
        for (Map.Entry<Thread, ThreadStatus> entry : this.mThreadStatus.entrySet()) {
        }
    }

    public static synchronized BitmapManager instance() {
        if (sManager == null) {
            sManager = new BitmapManager();
        }
        return sManager;
    }

    public Bitmap decodeFileDescriptor(FileDescriptor fd, BitmapFactory.Options options) {
        if (options.mCancel) {
            return null;
        }
        Thread threadCurrentThread = Thread.currentThread();
        if (!canThreadDecoding(threadCurrentThread)) {
            return null;
        }
        setDecodingOptions(threadCurrentThread, options);
        Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fd, null, options);
        removeDecodingOptions(threadCurrentThread);
        return bitmapDecodeFileDescriptor;
    }
}
