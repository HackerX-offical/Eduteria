package org.jivesoftware.smack.proxy;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.OutputStreamUtil;

/* JADX INFO: loaded from: classes10.dex */
public class Socks4ProxySocketConnection implements ProxySocketConnection {
    private final ProxyInfo proxy;

    Socks4ProxySocketConnection(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    @Override // org.jivesoftware.smack.proxy.ProxySocketConnection
    public void connect(Socket socket, String str, int i, int i2) throws IOException {
        String proxyAddress = this.proxy.getProxyAddress();
        int proxyPort = this.proxy.getProxyPort();
        String proxyUsername = this.proxy.getProxyUsername();
        socket.connect(new InetSocketAddress(proxyAddress, proxyPort), i2);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        OutputStream outputStream = socket.getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(4);
        byteArrayOutputStream.write(1);
        byteArrayOutputStream.write(i >>> 8);
        byteArrayOutputStream.write(i & 255);
        byteArrayOutputStream.write(InetAddress.getByName(proxyAddress).getAddress());
        if (proxyUsername != null) {
            byteArrayOutputStream.write(proxyUsername.getBytes(StandardCharsets.UTF_8));
        }
        byteArrayOutputStream.write(0);
        OutputStreamUtil.writeResetAndFlush(byteArrayOutputStream, outputStream);
        byte[] bArr = new byte[6];
        dataInputStream.readFully(bArr);
        if (bArr[0] != 0) {
            throw new ProxyException(ProxyInfo.ProxyType.SOCKS4, "server returns VN " + ((int) bArr[0]));
        }
        if (bArr[1] != 90) {
            throw new ProxyException(ProxyInfo.ProxyType.SOCKS4, "ProxySOCKS4: server returns CD " + ((int) bArr[1]));
        }
        dataInputStream.readFully(new byte[2]);
    }
}
