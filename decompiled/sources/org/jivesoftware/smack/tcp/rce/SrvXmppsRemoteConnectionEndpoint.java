package org.jivesoftware.smack.tcp.rce;

import com.clevertap.android.sdk.Constants;
import java.net.InetAddress;
import java.util.List;
import org.minidns.record.SRV;

/* JADX INFO: loaded from: classes10.dex */
public class SrvXmppsRemoteConnectionEndpoint extends SrvRemoteConnectionEndpoint {
    protected SrvXmppsRemoteConnectionEndpoint(SRV srv, List<? extends InetAddress> list) {
        super(srv, list);
    }

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    public String getDescription() {
        return "XEP-0368 SRV Endpoint + ['xmpps', " + this.srv + Constants.AES_SUFFIX;
    }
}
