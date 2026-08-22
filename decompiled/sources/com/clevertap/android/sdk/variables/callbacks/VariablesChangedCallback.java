package com.clevertap.android.sdk.variables.callbacks;

/* JADX INFO: loaded from: classes7.dex */
public abstract class VariablesChangedCallback implements Runnable {
    public abstract void variablesChanged();

    @Override // java.lang.Runnable
    public void run() {
        variablesChanged();
    }
}
