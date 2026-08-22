package com.google.android.gms.internal.play_billing;

import com.clevertap.android.sdk.Constants;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzea extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzdy(null);
    private static final Runnable zzb = new zzdy(null);

    zzea() {
    }

    private final void zzg(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzdx zzdxVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof zzdx)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzdxVar = (zzdx) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(zzdxVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objZza = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zZzf = zzf();
            if (!zZzf) {
                try {
                    objZza = zza();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzg(threadCurrentThread);
                        }
                        zzc(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzg(threadCurrentThread);
                        }
                        zzd(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, zza)) {
                zzg(threadCurrentThread);
            }
            if (zZzf) {
                return;
            }
            zzd(objZza);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            str = "running=[DONE]";
        } else if (runnable instanceof zzdx) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + Constants.AES_SUFFIX;
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + zzb();
    }

    abstract Object zza() throws Exception;

    abstract String zzb();

    abstract void zzc(Throwable th);

    abstract void zzd(Object obj);

    final void zze() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzdx zzdxVar = new zzdx(this, null);
            super/*java.util.concurrent.locks.AbstractOwnableSynchronizer*/.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzdxVar)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th;
                }
            }
        }
    }

    abstract boolean zzf();
}
