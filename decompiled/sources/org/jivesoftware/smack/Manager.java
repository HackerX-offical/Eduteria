package org.jivesoftware.smack;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smack.ScheduledAction;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Manager {
    final WeakReference<XMPPConnection> weakConnection;

    public Manager(XMPPConnection xMPPConnection) {
        Objects.requireNonNull(xMPPConnection, "XMPPConnection must not be null");
        this.weakConnection = new WeakReference<>(xMPPConnection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final XMPPConnection connection() {
        return this.weakConnection.get();
    }

    protected final XMPPConnection getAuthenticatedConnectionOrThrow() throws SmackException.NotLoggedInException {
        XMPPConnection xMPPConnectionConnection = connection();
        if (xMPPConnectionConnection.isAuthenticated()) {
            return xMPPConnectionConnection;
        }
        throw new SmackException.NotLoggedInException();
    }

    protected static final ScheduledAction schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(runnable, j, timeUnit, ScheduledAction.Kind.NonBlocking);
    }

    protected static final ScheduledAction scheduleBlocking(Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(runnable, j, timeUnit, ScheduledAction.Kind.Blocking);
    }

    protected static final ScheduledAction schedule(Runnable runnable, long j, TimeUnit timeUnit, ScheduledAction.Kind kind) {
        return AbstractXMPPConnection.SMACK_REACTOR.schedule(runnable, j, timeUnit, kind);
    }
}
