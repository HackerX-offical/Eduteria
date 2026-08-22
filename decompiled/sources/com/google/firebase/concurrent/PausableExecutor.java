package com.google.firebase.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public interface PausableExecutor extends Executor {
    boolean isPaused();

    void pause();

    void resume();
}
