package com.google.firebase.storage.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ActivityLifecycleListener {
    private static final ActivityLifecycleListener instance = new ActivityLifecycleListener();
    private final Map<Object, LifecycleEntry> cookieMap = new HashMap();
    private final Object sync = new Object();

    private ActivityLifecycleListener() {
    }

    public static ActivityLifecycleListener getInstance() {
        return instance;
    }

    public void runOnActivityStopped(Activity activity, Object obj, Runnable runnable) {
        synchronized (this.sync) {
            LifecycleEntry lifecycleEntry = new LifecycleEntry(activity, runnable, obj);
            OnStopCallback.getInstance(activity).addEntry(lifecycleEntry);
            this.cookieMap.put(obj, lifecycleEntry);
        }
    }

    public void removeCookie(Object obj) {
        synchronized (this.sync) {
            LifecycleEntry lifecycleEntry = this.cookieMap.get(obj);
            if (lifecycleEntry != null) {
                OnStopCallback.getInstance(lifecycleEntry.getActivity()).removeEntry(lifecycleEntry);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
    private static class LifecycleEntry {
        private final Activity activity;
        private final Object cookie;
        private final Runnable runnable;

        public LifecycleEntry(Activity activity, Runnable runnable, Object obj) {
            this.activity = activity;
            this.runnable = runnable;
            this.cookie = obj;
        }

        public int hashCode() {
            return this.cookie.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LifecycleEntry)) {
                return false;
            }
            LifecycleEntry lifecycleEntry = (LifecycleEntry) obj;
            return lifecycleEntry.cookie.equals(this.cookie) && lifecycleEntry.runnable == this.runnable && lifecycleEntry.activity == this.activity;
        }

        public Activity getActivity() {
            return this.activity;
        }

        public Runnable getRunnable() {
            return this.runnable;
        }

        public Object getCookie() {
            return this.cookie;
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
    private static class OnStopCallback extends LifecycleCallback {
        private static final String TAG = "StorageOnStopCallback";

        /* JADX INFO: renamed from: listeners, reason: collision with root package name */
        private final List<LifecycleEntry> f649listeners;

        private OnStopCallback(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.f649listeners = new ArrayList();
            this.mLifecycleFragment.addCallback(TAG, this);
        }

        public static OnStopCallback getInstance(Activity activity) {
            LifecycleFragment fragment = getFragment(new LifecycleActivity(activity));
            OnStopCallback onStopCallback = (OnStopCallback) fragment.getCallbackOrNull(TAG, OnStopCallback.class);
            return onStopCallback == null ? new OnStopCallback(fragment) : onStopCallback;
        }

        public void addEntry(LifecycleEntry lifecycleEntry) {
            synchronized (this.f649listeners) {
                this.f649listeners.add(lifecycleEntry);
            }
        }

        public void removeEntry(LifecycleEntry lifecycleEntry) {
            synchronized (this.f649listeners) {
                this.f649listeners.remove(lifecycleEntry);
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            ArrayList<LifecycleEntry> arrayList;
            synchronized (this.f649listeners) {
                arrayList = new ArrayList(this.f649listeners);
                this.f649listeners.clear();
            }
            for (LifecycleEntry lifecycleEntry : arrayList) {
                if (lifecycleEntry != null) {
                    Log.d(TAG, "removing subscription from activity.");
                    lifecycleEntry.getRunnable().run();
                    ActivityLifecycleListener.getInstance().removeCookie(lifecycleEntry.getCookie());
                }
            }
        }
    }
}
