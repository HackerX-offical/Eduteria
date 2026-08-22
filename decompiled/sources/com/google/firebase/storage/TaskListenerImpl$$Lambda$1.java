package com.google.firebase.storage;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class TaskListenerImpl$$Lambda$1 implements Runnable {
    private final TaskListenerImpl arg$1;
    private final Object arg$2;

    private TaskListenerImpl$$Lambda$1(TaskListenerImpl taskListenerImpl, Object obj) {
        this.arg$1 = taskListenerImpl;
        this.arg$2 = obj;
    }

    public static Runnable lambdaFactory$(TaskListenerImpl taskListenerImpl, Object obj) {
        return new TaskListenerImpl$$Lambda$1(taskListenerImpl, obj);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.removeListener(this.arg$2);
    }
}
