package a.a.a.b;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.jivesoftware.smack.util.TLSUtils;

/* JADX INFO: loaded from: classes.dex */
public class c extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SSLSocketFactory f124a;

    public c(SSLSocketFactory sSLSocketFactory) {
        this.f124a = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f124a.createSocket(str, i);
        sSLSocket.setEnabledProtocols(new String[]{TLSUtils.PROTO_TLSV1_1, TLSUtils.PROTO_TLSV1_2});
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f124a.createSocket(str, i, inetAddress, i2);
        sSLSocket.setEnabledProtocols(new String[]{TLSUtils.PROTO_TLSV1_1, TLSUtils.PROTO_TLSV1_2});
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f124a.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(new String[]{TLSUtils.PROTO_TLSV1_1, TLSUtils.PROTO_TLSV1_2});
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f124a.createSocket(inetAddress, i, inetAddress2, i2);
        sSLSocket.setEnabledProtocols(new String[]{TLSUtils.PROTO_TLSV1_1, TLSUtils.PROTO_TLSV1_2});
        return sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        SSLSocket sSLSocket = (SSLSocket) this.f124a.createSocket(socket, str, i, z);
        sSLSocket.setEnabledProtocols(new String[]{TLSUtils.PROTO_TLSV1_1, TLSUtils.PROTO_TLSV1_2});
        return sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f124a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f124a.getSupportedCipherSuites();
    }
}
