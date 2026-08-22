package org.jivesoftware.smack.util.rce;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Collection;
import org.jivesoftware.smack.datatypes.UInt16;

/* JADX INFO: loaded from: classes10.dex */
public interface RemoteConnectionEndpoint {
    String getDescription();

    CharSequence getHost();

    Collection<? extends InetAddress> getInetAddresses();

    UInt16 getPort();

    public static class InetSocketAddressCoupling<RCE extends RemoteConnectionEndpoint> {
        private final RCE connectionEndpoint;
        private final InetSocketAddress inetSocketAddress;

        public InetSocketAddressCoupling(RCE rce, InetAddress inetAddress) {
            this.connectionEndpoint = rce;
            this.inetSocketAddress = new InetSocketAddress(inetAddress, rce.getPort().intValue());
        }

        public RCE getRemoteConnectionEndpoint() {
            return this.connectionEndpoint;
        }

        public InetSocketAddress getInetSocketAddress() {
            return this.inetSocketAddress;
        }

        public String toString() {
            return this.connectionEndpoint.getDescription() + " (" + this.inetSocketAddress + ')';
        }
    }
}
