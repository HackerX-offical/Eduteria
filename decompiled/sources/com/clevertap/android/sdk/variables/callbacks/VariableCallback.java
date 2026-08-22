package com.clevertap.android.sdk.variables.callbacks;

import com.clevertap.android.sdk.variables.Var;

/* JADX INFO: loaded from: classes7.dex */
public abstract class VariableCallback<T> implements Runnable {
    private Var<T> variable;

    public abstract void onValueChanged(Var<T> var);

    public void setVariable(Var<T> var) {
        this.variable = var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.variable) {
            onValueChanged(this.variable);
        }
    }
}
