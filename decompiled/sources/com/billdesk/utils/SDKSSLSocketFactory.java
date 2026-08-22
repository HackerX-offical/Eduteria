package com.billdesk.utils;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes6.dex */
public class SDKSSLSocketFactory extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SSLSocketFactory f533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f534b;

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f533a.createSocket(str, i);
        sSLSocket.setEnabledProtocols(this.f534b);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f533a.createSocket(str, i, inetAddress, i2);
        sSLSocket.setEnabledProtocols(this.f534b);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f533a.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(this.f534b);
        return sSLSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f533a.createSocket(inetAddress, i, inetAddress2, i2);
        sSLSocket.setEnabledProtocols(this.f534b);
        return sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        SSLSocket sSLSocket = (SSLSocket) this.f533a.createSocket(socket, str, i, z);
        sSLSocket.setEnabledProtocols(this.f534b);
        return sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f533a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f533a.getSupportedCipherSuites();
    }
}
