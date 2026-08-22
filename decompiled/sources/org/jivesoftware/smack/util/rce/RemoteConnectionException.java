package org.jivesoftware.smack.util.rce;

import java.net.InetAddress;
import org.jivesoftware.smack.util.ToStringUtil;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;

/* JADX INFO: loaded from: classes10.dex */
public final class RemoteConnectionException<RCE extends RemoteConnectionEndpoint> {
    private final RemoteConnectionEndpoint.InetSocketAddressCoupling<RCE> address;
    private final Exception exception;
    private transient String toStringCache;

    public RemoteConnectionException(RCE rce, InetAddress inetAddress, Exception exc) {
        this(new RemoteConnectionEndpoint.InetSocketAddressCoupling(rce, inetAddress), exc);
    }

    public RemoteConnectionException(RemoteConnectionEndpoint.InetSocketAddressCoupling<RCE> inetSocketAddressCoupling, Exception exc) {
        this.address = inetSocketAddressCoupling;
        this.exception = exc;
    }

    public RemoteConnectionEndpoint.InetSocketAddressCoupling<RCE> getAddress() {
        return this.address;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getErrorMessage() {
        return "'" + this.address + "' failed because: " + this.exception;
    }

    public String toString() {
        if (this.toStringCache == null) {
            this.toStringCache = ToStringUtil.builderFor(RemoteConnectionException.class).addValue("address", this.address).addValue("exception", this.exception).build();
        }
        return this.toStringCache;
    }

    public static <SARCE extends SingleAddressRemoteConnectionEndpoint> RemoteConnectionException<SARCE> from(SARCE sarce, Exception exc) {
        return new RemoteConnectionException<>(sarce, sarce.getInetAddress(), exc);
    }
}
