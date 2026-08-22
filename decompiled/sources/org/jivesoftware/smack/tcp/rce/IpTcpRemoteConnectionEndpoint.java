package org.jivesoftware.smack.tcp.rce;

import com.clevertap.android.sdk.Constants;
import java.net.InetAddress;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.rce.SingleAddressRemoteConnectionEndpoint;
import org.minidns.record.InternetAddressRR;

/* JADX INFO: loaded from: classes10.dex */
public final class IpTcpRemoteConnectionEndpoint<IARR extends InternetAddressRR<?>> implements Rfc6120TcpRemoteConnectionEndpoint, SingleAddressRemoteConnectionEndpoint {
    private final CharSequence host;
    private final IARR internetAddressResourceRecord;
    private final UInt16 port;

    public IpTcpRemoteConnectionEndpoint(CharSequence charSequence, UInt16 uInt16, IARR iarr) {
        this.host = (CharSequence) Objects.requireNonNull(charSequence);
        this.port = (UInt16) Objects.requireNonNull(uInt16);
        this.internetAddressResourceRecord = (IARR) Objects.requireNonNull(iarr);
    }

    public static IpTcpRemoteConnectionEndpoint<InternetAddressRR<?>> from(CharSequence charSequence, UInt16 uInt16, InetAddress inetAddress) {
        return new IpTcpRemoteConnectionEndpoint<>(charSequence, uInt16, InternetAddressRR.from(inetAddress));
    }

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    public CharSequence getHost() {
        return this.host;
    }

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    public UInt16 getPort() {
        return this.port;
    }

    @Override // org.jivesoftware.smack.util.rce.SingleAddressRemoteConnectionEndpoint
    public InetAddress getInetAddress() {
        return this.internetAddressResourceRecord.getInetAddress();
    }

    @Override // org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint
    public String getDescription() {
        return "RFC 6120 A/AAAA Endpoint + [" + ((Object) this.host) + ":" + ((Object) this.port) + Constants.AES_SUFFIX;
    }
}
