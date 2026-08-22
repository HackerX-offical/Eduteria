package com.amazonaws.mobileconnectors.s3.transfermanager;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class PauseResult<T> {
    private final T infoToResume;
    private final PauseStatus pauseStatus;

    public PauseResult(PauseStatus pauseStatus, T t) {
        if (pauseStatus == null) {
            throw new IllegalArgumentException();
        }
        this.pauseStatus = pauseStatus;
        this.infoToResume = t;
    }

    public PauseResult(PauseStatus pauseStatus) {
        this(pauseStatus, null);
    }

    public PauseStatus getPauseStatus() {
        return this.pauseStatus;
    }

    public T getInfoToResume() {
        return this.infoToResume;
    }
}
