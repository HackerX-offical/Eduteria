package org.jivesoftware.smack.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.stringencoder.Base64;

/* JADX INFO: loaded from: classes10.dex */
class HTTPProxySocketConnection implements ProxySocketConnection {
    private static final Pattern RESPONSE_PATTERN = Pattern.compile("HTTP/\\S+\\s(\\d+)\\s(.*)\\s*");
    private final ProxyInfo proxy;

    HTTPProxySocketConnection(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    @Override // org.jivesoftware.smack.proxy.ProxySocketConnection
    public void connect(Socket socket, String str, int i, int i2) throws IOException {
        String str2;
        String proxyAddress = this.proxy.getProxyAddress();
        socket.connect(new InetSocketAddress(proxyAddress, this.proxy.getProxyPort()));
        String str3 = "CONNECT " + str + ":" + i;
        String proxyUsername = this.proxy.getProxyUsername();
        if (proxyUsername == null) {
            str2 = "";
        } else {
            str2 = "\r\nProxy-Authorization: Basic " + Base64.encode(proxyUsername + ":" + this.proxy.getProxyPassword());
        }
        socket.getOutputStream().write((str3 + " HTTP/1.1\r\nHost: " + str + ":" + i + str2 + "\r\n\r\n").getBytes("UTF-8"));
        InputStream inputStream = socket.getInputStream();
        StringBuilder sb = new StringBuilder(100);
        int i3 = 0;
        do {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw new ProxyException(ProxyInfo.ProxyType.HTTP);
            }
            char c2 = (char) i4;
            sb.append(c2);
            if (sb.length() > 1024) {
                throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Received header of >1024 characters from " + proxyAddress + ", cancelling connection");
            }
            i3 = (((i3 == 0 || i3 == 2) && c2 == '\r') || ((i3 == 1 || i3 == 3) && c2 == '\n')) ? i3 + 1 : 0;
        } while (i3 != 4);
        if (i3 != 4) {
            throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Never received blank line from " + proxyAddress + ", cancelling connection");
        }
        String line = new BufferedReader(new StringReader(sb.toString())).readLine();
        if (line == null) {
            throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Empty proxy response from " + proxyAddress + ", cancelling");
        }
        Matcher matcher = RESPONSE_PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Unexpected proxy response from " + proxyAddress + ": " + line);
        }
        int i5 = Integer.parseInt(matcher.group(1));
        if (i5 != 200) {
            throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Error code in proxy response: " + i5);
        }
    }
}
