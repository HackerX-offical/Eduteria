package org.jivesoftware.smack;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.util.Async;

/* JADX INFO: loaded from: classes10.dex */
public class ScheduledAction implements Delayed {
    private final Runnable action;
    final Kind kind;
    final Date releaseTime;
    final SmackReactor smackReactor;

    enum Kind {
        NonBlocking,
        Blocking
    }

    ScheduledAction(Runnable runnable, Date date, SmackReactor smackReactor, Kind kind) {
        this.action = runnable;
        this.releaseTime = date;
        this.smackReactor = smackReactor;
        this.kind = kind;
    }

    public boolean cancel() {
        return this.smackReactor.cancel(this);
    }

    public boolean isDue() {
        return new Date().after(this.releaseTime);
    }

    public long getTimeToDueMillis() {
        return this.releaseTime.getTime() - System.currentTimeMillis();
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        return Long.compare(getDelay(TimeUnit.MILLISECONDS), delayed.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(getTimeToDueMillis(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.ScheduledAction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ScheduledAction$Kind;

        static {
            int[] iArr = new int[Kind.values().length];
            $SwitchMap$org$jivesoftware$smack$ScheduledAction$Kind = iArr;
            try {
                iArr[Kind.NonBlocking.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$ScheduledAction$Kind[Kind.Blocking.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    void run() {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$ScheduledAction$Kind[this.kind.ordinal()];
        if (i == 1) {
            this.action.run();
        } else {
            if (i != 2) {
                return;
            }
            Async.go(new Runnable() { // from class: org.jivesoftware.smack.ScheduledAction$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14191lambda$run$0$orgjivesoftwaresmackScheduledAction();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$run$0$org-jivesoftware-smack-ScheduledAction, reason: not valid java name */
    /* synthetic */ void m14191lambda$run$0$orgjivesoftwaresmackScheduledAction() {
        this.action.run();
    }
}
