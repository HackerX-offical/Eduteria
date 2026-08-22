package org.minidns.source;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.dnsqueryresult.StandardDnsQueryResult;
import org.minidns.source.AbstractDnsDataSource;
import org.minidns.util.MultipleIoException;

/* JADX INFO: loaded from: classes10.dex */
public class NetworkDataSource extends AbstractDnsDataSource {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final Logger LOGGER = Logger.getLogger(NetworkDataSource.class.getName());

    @Override // org.minidns.source.AbstractDnsDataSource, org.minidns.source.DnsDataSource
    public StandardDnsQueryResult query(DnsMessage dnsMessage, InetAddress inetAddress, int i) throws Throwable {
        DnsMessage dnsMessage2;
        InetAddress inetAddress2;
        int i2;
        AbstractDnsDataSource.QueryMode queryMode = getQueryMode();
        int i3 = AnonymousClass1.$SwitchMap$org$minidns$source$AbstractDnsDataSource$QueryMode[queryMode.ordinal()];
        boolean z = true;
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                throw new IllegalStateException("Unsupported query mode: " + queryMode);
            }
            z = false;
        }
        ArrayList arrayList = new ArrayList(2);
        DnsMessage dnsMessageQueryUdp = null;
        if (z) {
            try {
                dnsMessageQueryUdp = queryUdp(dnsMessage, inetAddress, i);
            } catch (IOException e2) {
                arrayList.add(e2);
            }
            DnsMessage dnsMessage3 = dnsMessageQueryUdp;
            if (dnsMessage3 != null && !dnsMessage3.truncated) {
                return new StandardDnsQueryResult(inetAddress, i, DnsQueryResult.QueryMethod.udp, dnsMessage, dnsMessage3);
            }
            dnsMessage2 = dnsMessage;
            inetAddress2 = inetAddress;
            i2 = i;
            LOGGER.log(Level.FINE, "Fallback to TCP because {0}", new Object[]{dnsMessage3 != null ? "response is truncated" : arrayList.get(0)});
            dnsMessageQueryUdp = dnsMessage3;
        } else {
            dnsMessage2 = dnsMessage;
            inetAddress2 = inetAddress;
            i2 = i;
        }
        try {
            dnsMessageQueryUdp = queryTcp(dnsMessage2, inetAddress2, i2);
        } catch (IOException e3) {
            arrayList.add(e3);
            MultipleIoException.throwIfRequired(arrayList);
        }
        return new StandardDnsQueryResult(inetAddress2, i2, DnsQueryResult.QueryMethod.tcp, dnsMessage2, dnsMessageQueryUdp);
    }

    /* JADX INFO: renamed from: org.minidns.source.NetworkDataSource$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$minidns$source$AbstractDnsDataSource$QueryMode;

        static {
            int[] iArr = new int[AbstractDnsDataSource.QueryMode.values().length];
            $SwitchMap$org$minidns$source$AbstractDnsDataSource$QueryMode = iArr;
            try {
                iArr[AbstractDnsDataSource.QueryMode.dontCare.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$minidns$source$AbstractDnsDataSource$QueryMode[AbstractDnsDataSource.QueryMode.udpTcp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$minidns$source$AbstractDnsDataSource$QueryMode[AbstractDnsDataSource.QueryMode.tcp.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected DnsMessage queryUdp(DnsMessage dnsMessage, InetAddress inetAddress, int i) throws Throwable {
        DatagramSocket datagramSocketCreateDatagramSocket;
        DatagramPacket datagramPacketAsDatagram = dnsMessage.asDatagram(inetAddress, i);
        int i2 = this.udpPayloadSize;
        byte[] bArr = new byte[i2];
        try {
            datagramSocketCreateDatagramSocket = createDatagramSocket();
            try {
                datagramSocketCreateDatagramSocket.setSoTimeout(this.timeout);
                datagramSocketCreateDatagramSocket.send(datagramPacketAsDatagram);
                DatagramPacket datagramPacket = new DatagramPacket(bArr, i2);
                datagramSocketCreateDatagramSocket.receive(datagramPacket);
                DnsMessage dnsMessage2 = new DnsMessage(datagramPacket.getData());
                if (dnsMessage2.id != dnsMessage.id) {
                    throw new MiniDnsException.IdMismatch(dnsMessage, dnsMessage2);
                }
                if (datagramSocketCreateDatagramSocket != null) {
                    datagramSocketCreateDatagramSocket.close();
                }
                return dnsMessage2;
            } catch (Throwable th) {
                th = th;
                if (datagramSocketCreateDatagramSocket != null) {
                    datagramSocketCreateDatagramSocket.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            datagramSocketCreateDatagramSocket = null;
        }
    }

    protected DnsMessage queryTcp(DnsMessage dnsMessage, InetAddress inetAddress, int i) throws Throwable {
        Socket socketCreateSocket;
        try {
            socketCreateSocket = createSocket();
            try {
                socketCreateSocket.connect(new InetSocketAddress(inetAddress, i), this.timeout);
                socketCreateSocket.setSoTimeout(this.timeout);
                DataOutputStream dataOutputStream = new DataOutputStream(socketCreateSocket.getOutputStream());
                dnsMessage.writeTo(dataOutputStream);
                dataOutputStream.flush();
                DataInputStream dataInputStream = new DataInputStream(socketCreateSocket.getInputStream());
                int unsignedShort = dataInputStream.readUnsignedShort();
                byte[] bArr = new byte[unsignedShort];
                for (int i2 = 0; i2 < unsignedShort; i2 += dataInputStream.read(bArr, i2, unsignedShort - i2)) {
                }
                DnsMessage dnsMessage2 = new DnsMessage(bArr);
                if (dnsMessage2.id != dnsMessage.id) {
                    throw new MiniDnsException.IdMismatch(dnsMessage, dnsMessage2);
                }
                if (socketCreateSocket != null) {
                    socketCreateSocket.close();
                }
                return dnsMessage2;
            } catch (Throwable th) {
                th = th;
                if (socketCreateSocket != null) {
                    socketCreateSocket.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            socketCreateSocket = null;
        }
    }

    protected Socket createSocket() {
        return new Socket();
    }

    protected DatagramSocket createDatagramSocket() throws SocketException {
        return new DatagramSocket();
    }
}
