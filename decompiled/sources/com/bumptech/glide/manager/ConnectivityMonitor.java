package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes6.dex */
public interface ConnectivityMonitor extends LifecycleListener {

    public interface ConnectivityListener {
        void onConnectivityChanged(boolean z);
    }
}
