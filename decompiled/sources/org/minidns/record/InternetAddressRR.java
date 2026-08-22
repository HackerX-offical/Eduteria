package org.minidns.record;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class InternetAddressRR<IA extends InetAddress> extends Data {
    private transient IA inetAddress;
    protected final byte[] ip;

    protected InternetAddressRR(byte[] bArr) {
        this.ip = bArr;
    }

    protected InternetAddressRR(IA ia) {
        this(ia.getAddress());
        this.inetAddress = ia;
    }

    @Override // org.minidns.record.Data
    public final void serialize(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.ip);
    }

    public final byte[] getIp() {
        return (byte[]) this.ip.clone();
    }

    public final IA getInetAddress() {
        if (this.inetAddress == null) {
            try {
                this.inetAddress = (IA) InetAddress.getByAddress(this.ip);
            } catch (UnknownHostException e2) {
                throw new IllegalStateException(e2);
            }
        }
        return this.inetAddress;
    }

    public static InternetAddressRR<? extends InetAddress> from(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return new A((Inet4Address) inetAddress);
        }
        return new AAAA((Inet6Address) inetAddress);
    }
}
