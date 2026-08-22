package org.jivesoftware.smack.tcp.rce;

import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;
import org.minidns.record.SRV;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SrvRemoteConnectionEndpoint implements RemoteConnectionEndpoint {
    private final List<? extends InetAddress> inetAddresses;
    protected final UInt16 port;
    protected final SRV srv;

    protected SrvRemoteConnectionEndpoint(SRV srv, List<? extends InetAddress> list) {
        this.srv = srv;
        this.port = UInt16.from(srv.port);
        this.inetAddresses = (List) Objects.requireNonNull(list);
    }

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    public final CharSequence getHost() {
        return this.srv.target;
    }

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    public final UInt16 getPort() {
        return this.port;
    }

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    public final Collection<? extends InetAddress> getInetAddresses() {
        return this.inetAddresses;
    }
}
