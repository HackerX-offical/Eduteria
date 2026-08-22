package com.google.android.gms.internal.play_billing;

import com.amazonaws.services.s3.internal.Constants;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import javax.annotation.CheckForNull;
import org.jivesoftware.smack.packet.Message;
import org.mozilla.javascript.ES6Iterator;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzdg<V> extends zzeq implements zzec<V> {
    static final boolean zza;
    static final zzeb zzb;
    private static final zza zzc;
    private static final Object zzd;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    @CheckForNull
    private volatile zzd f613listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile zzk waiters;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    abstract class zza {
        /* synthetic */ zza(zzdj zzdjVar) {
        }

        abstract zzd zza(zzdg zzdgVar, zzd zzdVar);

        abstract zzk zzb(zzdg zzdgVar, zzk zzkVar);

        abstract void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2);

        abstract void zzd(zzk zzkVar, Thread thread);

        abstract boolean zze(zzdg zzdgVar, @CheckForNull zzd zzdVar, zzd zzdVar2);

        abstract boolean zzf(zzdg zzdgVar, @CheckForNull Object obj, Object obj2);

        abstract boolean zzg(zzdg zzdgVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2);
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    final class zzb {

        @CheckForNull
        static final zzb zza;

        @CheckForNull
        static final zzb zzb;
        final boolean zzc;

        @CheckForNull
        final Throwable zzd;

        static {
            if (zzdg.zza) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        zzb(boolean z, @CheckForNull Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.play_billing.zzdg.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    final class zzd {
        static final zzd zza = new zzd();

        @CheckForNull
        zzd next;

        @CheckForNull
        final Runnable zzb;

        @CheckForNull
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<? super zzdg<?>, zzk> zzc;
        final AtomicReferenceFieldUpdater<? super zzdg<?>, zzd> zzd;
        final AtomicReferenceFieldUpdater<? super zzdg<?>, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final zzd zza(zzdg zzdgVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzdgVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final zzk zzb(zzdg zzdgVar, zzk zzkVar) {
            return this.zzc.getAndSet(zzdgVar, zzkVar);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final void zzd(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zze(zzdg zzdgVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzdh.zza(this.zzd, zzdgVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zzf(zzdg zzdgVar, @CheckForNull Object obj, Object obj2) {
            return zzdh.zza(this.zze, zzdgVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zzg(zzdg zzdgVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return zzdh.zza(this.zzc, zzdgVar, zzkVar, zzkVar2);
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    final class zzf<V> implements Runnable {
        final zzdg<V> zza;
        final zzec<? extends V> zzb;

        zzf(zzdg zzdgVar, zzec zzecVar) {
            this.zza = zzdgVar;
            this.zzb = zzecVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzdg) this.zza).value != this) {
                return;
            }
            zzec<? extends V> zzecVar = this.zzb;
            if (zzdg.zzc.zzf(this.zza, this, zzdg.zzr(zzecVar))) {
                zzdg.zzw(this.zza, false);
            }
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    final class zzg extends zza {
        private zzg() {
            throw null;
        }

        /* synthetic */ zzg(zzdj zzdjVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final zzd zza(zzdg zzdgVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzdgVar) {
                zzdVar2 = zzdgVar.f613listeners;
                if (zzdVar2 != zzdVar) {
                    zzdgVar.f613listeners = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final zzk zzb(zzdg zzdgVar, zzk zzkVar) {
            zzk zzkVar2;
            synchronized (zzdgVar) {
                zzkVar2 = zzdgVar.waiters;
                if (zzkVar2 != zzkVar) {
                    zzdgVar.waiters = zzkVar;
                }
            }
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final void zzd(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zze(zzdg zzdgVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            synchronized (zzdgVar) {
                if (zzdgVar.f613listeners != zzdVar) {
                    return false;
                }
                zzdgVar.f613listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zzf(zzdg zzdgVar, @CheckForNull Object obj, Object obj2) {
            synchronized (zzdgVar) {
                if (zzdgVar.value != obj) {
                    return false;
                }
                zzdgVar.value = obj2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zzg(zzdg zzdgVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            synchronized (zzdgVar) {
                if (zzdgVar.waiters != zzkVar) {
                    return false;
                }
                zzdgVar.waiters = zzkVar2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    interface zzh<V> extends zzec<V> {
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    abstract class zzi<V> extends zzdg<V> implements zzh<V> {
        zzi() {
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.play_billing.zzdg.zzj.1
                    @Override // java.security.PrivilegedExceptionAction
                    public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                zzc = unsafe.objectFieldOffset(zzdg.class.getDeclaredField("waiters"));
                zzb = unsafe.objectFieldOffset(zzdg.class.getDeclaredField("listeners"));
                zzd = unsafe.objectFieldOffset(zzdg.class.getDeclaredField("value"));
                zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField(Message.Thread.ELEMENT));
                zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField(ES6Iterator.NEXT_METHOD));
                zza = unsafe;
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            }
        }

        private zzj() {
            throw null;
        }

        /* synthetic */ zzj(zzdj zzdjVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final zzd zza(zzdg zzdgVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzdgVar.f613listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzdgVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final zzk zzb(zzdg zzdgVar, zzk zzkVar) {
            zzk zzkVar2;
            do {
                zzkVar2 = zzdgVar.waiters;
                if (zzkVar == zzkVar2) {
                    break;
                }
            } while (!zzg(zzdgVar, zzkVar2, zzkVar));
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final void zzd(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zze(zzdg zzdgVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzdi.zza(zza, zzdgVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zzf(zzdg zzdgVar, @CheckForNull Object obj, Object obj2) {
            return zzdi.zza(zza, zzdgVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzdg.zza
        final boolean zzg(zzdg zzdgVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return zzdi.zza(zza, zzdgVar, zzc, zzkVar, zzkVar2);
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
    final class zzk {
        static final zzk zza = new zzk(false);

        @CheckForNull
        volatile zzk next;

        @CheckForNull
        volatile Thread thread;

        zzk() {
            zzdg.zzc.zzd(this, Thread.currentThread());
        }

        zzk(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        zza zzgVar;
        Throwable th2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zza = z;
        zzb = new zzeb(zzdg.class);
        zzdj zzdjVar = null;
        try {
            zzgVar = new zzj(zzdjVar);
            th = null;
            th2 = null;
        } catch (Error | Exception e2) {
            try {
                th = null;
                th2 = e2;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, Message.Thread.ELEMENT), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, ES6Iterator.NEXT_METHOD), AtomicReferenceFieldUpdater.newUpdater(zzdg.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzdg.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzdg.class, Object.class, "value"));
            } catch (Error | Exception e3) {
                th = e3;
                zzgVar = new zzg(zzdjVar);
                th2 = e2;
            }
        }
        zzc = zzgVar;
        if (th != null) {
            zzeb zzebVar = zzb;
            zzebVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzebVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzd = new Object();
    }

    protected zzdg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zzr(zzec zzecVar) {
        Throwable thZzg;
        if (zzecVar instanceof zzh) {
            Object zzbVar = ((zzdg) zzecVar).value;
            if (zzbVar instanceof zzb) {
                zzb zzbVar2 = (zzb) zzbVar;
                if (zzbVar2.zzc) {
                    Throwable th = zzbVar2.zzd;
                    zzbVar = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            return Objects.requireNonNull(zzbVar);
        }
        if ((zzecVar instanceof zzeq) && (thZzg = ((zzeq) zzecVar).zzg()) != null) {
            return new zzc(thZzg);
        }
        boolean zIsCancelled = zzecVar.isCancelled();
        if ((!zza) && zIsCancelled) {
            return Objects.requireNonNull(zzb.zzb);
        }
        try {
            Object objZzs = zzs(zzecVar);
            if (!zIsCancelled) {
                return objZzs == null ? zzd : objZzs;
            }
            return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(zzecVar)));
        } catch (Error | Exception e2) {
            return new zzc(e2);
        } catch (CancellationException e3) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(zzecVar))), e3)) : new zzb(false, e3);
        } catch (ExecutionException e4) {
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(zzecVar))), e4)) : new zzc(e4.getCause());
        }
    }

    private static Object zzs(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzt(StringBuilder sb) {
        try {
            Object objZzs = zzs(this);
            sb.append("SUCCESS, result=[");
            if (objZzs == null) {
                sb.append(Constants.NULL_VERSION_ID);
            } else if (objZzs == this) {
                sb.append("this future");
            } else {
                sb.append(objZzs.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzs)));
            }
            sb.append(com.clevertap.android.sdk.Constants.AES_SUFFIX);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(com.clevertap.android.sdk.Constants.AES_SUFFIX);
        } catch (Exception e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzu(java.lang.StringBuilder r6) {
        /*
            r5 = this;
            int r0 = r6.length()
            java.lang.String r1 = "PENDING"
            r6.append(r1)
            java.lang.Object r1 = r5.value
            boolean r2 = r1 instanceof com.google.android.gms.internal.play_billing.zzdg.zzf
            java.lang.String r3 = "]"
            if (r2 == 0) goto L21
            java.lang.String r2 = ", setFuture=["
            r6.append(r2)
            com.google.android.gms.internal.play_billing.zzdg$zzf r1 = (com.google.android.gms.internal.play_billing.zzdg.zzf) r1
            com.google.android.gms.internal.play_billing.zzec<? extends V> r1 = r1.zzb
            r5.zzv(r6, r1)
            r6.append(r3)
            goto L52
        L21:
            java.lang.String r1 = r5.zzf()     // Catch: java.lang.StackOverflowError -> L30 java.lang.Exception -> L32
            r2 = 0
            if (r1 == 0) goto L2e
            boolean r4 = r1.isEmpty()     // Catch: java.lang.StackOverflowError -> L30 java.lang.Exception -> L32
            if (r4 == 0) goto L45
        L2e:
            r1 = r2
            goto L45
        L30:
            r1 = move-exception
            goto L33
        L32:
            r1 = move-exception
        L33:
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Exception thrown from implementation: "
            java.lang.String r1 = r2.concat(r1)
        L45:
            if (r1 == 0) goto L52
            java.lang.String r2 = ", info=["
            r6.append(r2)
            r6.append(r1)
            r6.append(r3)
        L52:
            boolean r1 = r5.isDone()
            if (r1 == 0) goto L62
            int r1 = r6.length()
            r6.delete(r0, r1)
            r5.zzt(r6)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdg.zzu(java.lang.StringBuilder):void");
    }

    private final void zzv(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception | StackOverflowError e2) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e2.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzw(zzdg zzdgVar, boolean z) {
        zzd zzdVar;
        zzd zzdVar2 = null;
        while (true) {
            for (zzk zzkVarZzb = zzc.zzb(zzdgVar, zzk.zza); zzkVarZzb != null; zzkVarZzb = zzkVarZzb.next) {
                Thread thread = zzkVarZzb.thread;
                if (thread != null) {
                    zzkVarZzb.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            zzdgVar.zzm();
            zzd zzdVar3 = zzdVar2;
            zzd zzdVarZza = zzc.zza(zzdgVar, zzd.zza);
            zzd zzdVar4 = zzdVar3;
            while (zzdVarZza != null) {
                zzd zzdVar5 = zzdVarZza.next;
                zzdVarZza.next = zzdVar4;
                zzdVar4 = zzdVarZza;
                zzdVarZza = zzdVar5;
            }
            while (zzdVar4 != null) {
                Runnable runnable = zzdVar4.zzb;
                zzdVar = zzdVar4.next;
                Runnable runnable2 = (Runnable) Objects.requireNonNull(runnable);
                if (runnable2 instanceof zzf) {
                    zzf zzfVar = (zzf) runnable2;
                    zzdgVar = zzfVar.zza;
                    if (zzdgVar.value == zzfVar) {
                        if (zzc.zzf(zzdgVar, zzfVar, zzr(zzfVar.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    zzx(runnable2, (Executor) Objects.requireNonNull(zzdVar4.zzc));
                }
                zzdVar4 = zzdVar;
            }
            return;
            zzdVar2 = zzdVar;
        }
    }

    private static void zzx(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e2);
        }
    }

    private final void zzy(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                            break;
                        }
                    } else if (!zzc.zzg(this, zzkVar2, zzkVar4)) {
                        break;
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzz(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzd) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.android.gms.internal.play_billing.zzdg.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = r3
            goto Lb
        La:
            r4 = r2
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L60
            boolean r1 = com.google.android.gms.internal.play_billing.zzdg.zza
            if (r1 == 0) goto L1f
            com.google.android.gms.internal.play_billing.zzdg$zzb r1 = new com.google.android.gms.internal.play_billing.zzdg$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L2a
        L1f:
            if (r8 == 0) goto L24
            com.google.android.gms.internal.play_billing.zzdg$zzb r1 = com.google.android.gms.internal.play_billing.zzdg.zzb.zza
            goto L26
        L24:
            com.google.android.gms.internal.play_billing.zzdg$zzb r1 = com.google.android.gms.internal.play_billing.zzdg.zzb.zzb
        L26:
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
        L2a:
            r4 = r7
            r5 = r2
        L2c:
            com.google.android.gms.internal.play_billing.zzdg$zza r6 = com.google.android.gms.internal.play_billing.zzdg.zzc
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L59
            zzw(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.play_billing.zzdg.zzf
            if (r4 == 0) goto L58
            com.google.android.gms.internal.play_billing.zzdg$zzf r0 = (com.google.android.gms.internal.play_billing.zzdg.zzf) r0
            com.google.android.gms.internal.play_billing.zzec<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.play_billing.zzdg.zzh
            if (r4 == 0) goto L55
            r4 = r0
            com.google.android.gms.internal.play_billing.zzdg r4 = (com.google.android.gms.internal.play_billing.zzdg) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L4c
            r5 = r3
            goto L4d
        L4c:
            r5 = r2
        L4d:
            boolean r6 = r0 instanceof com.google.android.gms.internal.play_billing.zzdg.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L54
            r5 = r3
            goto L2c
        L54:
            return r3
        L55:
            r0.cancel(r8)
        L58:
            return r3
        L59:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.play_billing.zzdg.zzf
            if (r6 != 0) goto L2c
            return r5
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdg.cancel(boolean):boolean");
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzz(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zzc;
                zzaVar.zzc(zzkVar2, zzkVar);
                if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzy(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzz(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        return zzz(Objects.requireNonNull(this.value));
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.value != null) & (!(r0 instanceof zzf));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzt(sb);
        } else {
            zzu(sb);
        }
        sb.append(com.clevertap.android.sdk.Constants.AES_SUFFIX);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    protected String zzf() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzeq
    @CheckForNull
    protected final Throwable zzg() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final void zzl(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzam.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.f613listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzc.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.f613listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzx(runnable, executor);
    }

    protected void zzm() {
    }

    protected final boolean zzn(Object obj) {
        if (obj == null) {
            obj = zzd;
        }
        if (!zzc.zzf(this, null, obj)) {
            return false;
        }
        zzw(this, false);
        return true;
    }

    protected final boolean zzo(Throwable th) {
        if (!zzc.zzf(this, null, new zzc(th))) {
            return false;
        }
        zzw(this, false);
        return true;
    }

    protected final boolean zzp(zzec zzecVar) {
        zzc zzcVar;
        Object obj = this.value;
        if (obj == null) {
            if (zzecVar.isDone()) {
                if (!zzc.zzf(this, null, zzr(zzecVar))) {
                    return false;
                }
                zzw(this, false);
                return true;
            }
            zzf zzfVar = new zzf(this, zzecVar);
            if (zzc.zzf(this, null, zzfVar)) {
                try {
                    zzecVar.zzl(zzfVar, zzdl.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzc.zzf(this, zzfVar, zzcVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzb) {
            zzecVar.cancel(((zzb) obj).zzc);
        }
        return false;
    }

    protected final boolean zzq() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return zzz(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.waiters;
                if (zzkVar != zzk.zza) {
                    zzk zzkVar2 = new zzk();
                    do {
                        zza zzaVar = zzc;
                        zzaVar.zzc(zzkVar2, zzkVar);
                        if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (Thread.interrupted()) {
                                    zzy(zzkVar2);
                                    throw new InterruptedException();
                                }
                                Object obj2 = this.value;
                                if (!((obj2 != null) & (!(obj2 instanceof zzf)))) {
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    return zzz(obj2);
                                }
                            } while (nanos >= 1000);
                            zzy(zzkVar2);
                        } else {
                            zzkVar = this.waiters;
                        }
                    } while (zzkVar != zzk.zza);
                }
                return zzz(Objects.requireNonNull(this.value));
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if (!((obj3 != null) & (!(obj3 instanceof zzf)))) {
                    if (!Thread.interrupted()) {
                        nanos = jNanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                } else {
                    return zzz(obj3);
                }
            }
            String string = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String strConcat = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j2 = -nanos;
                long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                    if (z) {
                        strConcat3 = strConcat3.concat(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA);
                    }
                    strConcat2 = strConcat3.concat(" ");
                }
                if (z) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(strConcat + " for " + string);
        }
        throw new InterruptedException();
    }
}
