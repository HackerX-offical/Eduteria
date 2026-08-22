package org.jivesoftware.smack.proxy;

/* JADX INFO: loaded from: classes10.dex */
public class Socks5ProxySocketConnection implements ProxySocketConnection {
    private final ProxyInfo proxy;

    Socks5ProxySocketConnection(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0081, code lost:
    
        if (r2[1] == 0) goto L12;
     */
    @Override // org.jivesoftware.smack.proxy.ProxySocketConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void connect(java.net.Socket r10, java.lang.String r11, int r12, int r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.proxy.Socks5ProxySocketConnection.connect(java.net.Socket, java.lang.String, int, int):void");
    }
}
