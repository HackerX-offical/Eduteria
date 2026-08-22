package org.jivesoftware.smack.util.rce;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes10.dex */
public interface SingleAddressRemoteConnectionEndpoint extends RemoteConnectionEndpoint {
    InetAddress getInetAddress();

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    default Collection<? extends InetAddress> getInetAddresses() {
        return Collections.singletonList(getInetAddress());
    }
}
