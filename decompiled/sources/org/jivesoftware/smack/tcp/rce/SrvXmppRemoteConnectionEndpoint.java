package org.jivesoftware.smack.tcp.rce;

import com.clevertap.android.sdk.Constants;
import java.net.InetAddress;
import java.util.List;
import org.minidns.record.SRV;

/* JADX INFO: loaded from: classes10.dex */
public final class SrvXmppRemoteConnectionEndpoint extends SrvRemoteConnectionEndpoint implements Rfc6120TcpRemoteConnectionEndpoint {
    protected SrvXmppRemoteConnectionEndpoint(SRV srv, List<? extends InetAddress> list) {
        super(srv, list);
    }

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    public String getDescription() {
        return "RFC 6120 SRV Endpoint + ['xmpp', " + this.srv + Constants.AES_SUFFIX;
    }
}
