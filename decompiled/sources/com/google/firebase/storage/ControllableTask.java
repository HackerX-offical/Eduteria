package com.google.firebase.storage;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ControllableTask<StateT> extends CancellableTask<StateT> {
    public abstract ControllableTask<StateT> addOnPausedListener(Activity activity, OnPausedListener<? super StateT> onPausedListener);

    public abstract ControllableTask<StateT> addOnPausedListener(OnPausedListener<? super StateT> onPausedListener);

    public abstract ControllableTask<StateT> addOnPausedListener(Executor executor, OnPausedListener<? super StateT> onPausedListener);

    public abstract boolean isPaused();

    public abstract boolean pause();

    public abstract boolean resume();
}
