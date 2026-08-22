package org.jivesoftware.smack.proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes10.dex */
public class ProxyInfo {
    private String proxyAddress;
    private String proxyPassword;
    private int proxyPort;
    private final ProxySocketConnection proxySocketConnection;
    private ProxyType proxyType;
    private String proxyUsername;

    public enum ProxyType {
        HTTP,
        SOCKS4,
        SOCKS5
    }

    public ProxyInfo(ProxyType proxyType, String str, int i, String str2, String str3) {
        this.proxyType = proxyType;
        this.proxyAddress = str;
        this.proxyPort = i;
        this.proxyUsername = str2;
        this.proxyPassword = str3;
        this.proxySocketConnection = ProxySocketConnection.forProxyType(proxyType).apply(this);
    }

    public static ProxyInfo forHttpProxy(String str, int i, String str2, String str3) {
        return new ProxyInfo(ProxyType.HTTP, str, i, str2, str3);
    }

    public static ProxyInfo forSocks4Proxy(String str, int i, String str2, String str3) {
        return new ProxyInfo(ProxyType.SOCKS4, str, i, str2, str3);
    }

    public static ProxyInfo forSocks5Proxy(String str, int i, String str2, String str3) {
        return new ProxyInfo(ProxyType.SOCKS5, str, i, str2, str3);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.proxy.ProxyInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType;

        static {
            int[] iArr = new int[ProxyType.values().length];
            $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType = iArr;
            try {
                iArr[ProxyType.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType[ProxyType.SOCKS4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType[ProxyType.SOCKS5.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Proxy.Type getJavaProxyType() {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType[this.proxyType.ordinal()];
        if (i == 1) {
            return Proxy.Type.HTTP;
        }
        if (i == 2 || i == 3) {
            return Proxy.Type.SOCKS;
        }
        throw new AssertionError("Invalid proxy type: " + this.proxyType);
    }

    public ProxyType getProxyType() {
        return this.proxyType;
    }

    public String getProxyAddress() {
        return this.proxyAddress;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public String getProxyUsername() {
        return this.proxyUsername;
    }

    public String getProxyPassword() {
        return this.proxyPassword;
    }

    public ProxySocketConnection getProxySocketConnection() {
        return this.proxySocketConnection;
    }

    public Proxy toJavaProxy() {
        return new Proxy(getJavaProxyType(), new InetSocketAddress(this.proxyAddress, this.proxyPort));
    }
}
