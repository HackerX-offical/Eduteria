package com.amazonaws.event;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class ProgressListenerChain implements ProgressListener {
    private static final Log log = LogFactory.getLog(ProgressListenerChain.class);

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final List<ProgressListener> f300listeners;
    private final ProgressEventFilter progressEventFilter;

    public interface ProgressEventFilter {
        ProgressEvent filter(ProgressEvent progressEvent);
    }

    public ProgressListenerChain(ProgressListener... progressListenerArr) {
        this(null, progressListenerArr);
    }

    public ProgressListenerChain(ProgressEventFilter progressEventFilter, ProgressListener... progressListenerArr) {
        this.f300listeners = new CopyOnWriteArrayList();
        if (progressListenerArr == null) {
            throw new IllegalArgumentException("Progress Listeners cannot be null.");
        }
        for (ProgressListener progressListener : progressListenerArr) {
            addProgressListener(progressListener);
        }
        this.progressEventFilter = progressEventFilter;
    }

    public synchronized void addProgressListener(ProgressListener progressListener) {
        if (progressListener == null) {
            return;
        }
        this.f300listeners.add(progressListener);
    }

    public synchronized void removeProgressListener(ProgressListener progressListener) {
        if (progressListener == null) {
            return;
        }
        this.f300listeners.remove(progressListener);
    }

    protected List<ProgressListener> getListeners() {
        return this.f300listeners;
    }

    @Override // com.amazonaws.event.ProgressListener
    public void progressChanged(ProgressEvent progressEvent) {
        ProgressEventFilter progressEventFilter = this.progressEventFilter;
        if (progressEventFilter == null || (progressEvent = progressEventFilter.filter(progressEvent)) != null) {
            Iterator<ProgressListener> it = this.f300listeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().progressChanged(progressEvent);
                } catch (RuntimeException e2) {
                    log.warn("Couldn't update progress listener", e2);
                }
            }
        }
    }
}
