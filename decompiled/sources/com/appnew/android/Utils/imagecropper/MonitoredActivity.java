package com.appnew.android.Utils.imagecropper;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class MonitoredActivity extends Activity {
    private final ArrayList<LifeCycleListener> mListeners = new ArrayList<>();

    public static class LifeCycleAdapter implements LifeCycleListener {
        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityCreated(MonitoredActivity activity) {
        }

        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityDestroyed(MonitoredActivity activity) {
        }

        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityPaused(MonitoredActivity activity) {
        }

        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityResumed(MonitoredActivity activity) {
        }

        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityStarted(MonitoredActivity activity) {
        }

        @Override // com.appnew.android.Utils.imagecropper.MonitoredActivity.LifeCycleListener
        public void onActivityStopped(MonitoredActivity activity) {
        }
    }

    public interface LifeCycleListener {
        void onActivityCreated(MonitoredActivity activity);

        void onActivityDestroyed(MonitoredActivity activity);

        void onActivityPaused(MonitoredActivity activity);

        void onActivityResumed(MonitoredActivity activity);

        void onActivityStarted(MonitoredActivity activity);

        void onActivityStopped(MonitoredActivity activity);
    }

    public void addLifeCycleListener(LifeCycleListener listener) {
        if (this.mListeners.contains(listener)) {
            return;
        }
        this.mListeners.add(listener);
    }

    public void removeLifeCycleListener(LifeCycleListener listener) {
        this.mListeners.remove(listener);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Iterator<LifeCycleListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityCreated(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Iterator<LifeCycleListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityDestroyed(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator<LifeCycleListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityStarted(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator<LifeCycleListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityStopped(this);
        }
    }
}
