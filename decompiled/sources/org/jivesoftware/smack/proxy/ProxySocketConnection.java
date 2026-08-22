package org.jivesoftware.smack.proxy;

import java.io.IOException;
import java.net.Socket;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.Function;

/* JADX INFO: loaded from: classes10.dex */
public interface ProxySocketConnection {
    void connect(Socket socket, String str, int i, int i2) throws IOException;

    /* JADX INFO: renamed from: org.jivesoftware.smack.proxy.ProxySocketConnection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType;

        static {
            int[] iArr = new int[ProxyInfo.ProxyType.values().length];
            $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType = iArr;
            try {
                iArr[ProxyInfo.ProxyType.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType[ProxyInfo.ProxyType.SOCKS4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType[ProxyInfo.ProxyType.SOCKS5.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static Function<ProxySocketConnection, ProxyInfo> forProxyType(ProxyInfo.ProxyType proxyType) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType[proxyType.ordinal()];
        if (i == 1) {
            return new Function() { // from class: org.jivesoftware.smack.proxy.ProxySocketConnection$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.Function
                public final Object apply(Object obj) {
                    return new HTTPProxySocketConnection((ProxyInfo) obj);
                }
            };
        }
        if (i == 2) {
            return new Function() { // from class: org.jivesoftware.smack.proxy.ProxySocketConnection$$ExternalSyntheticLambda1
                @Override // org.jivesoftware.smack.util.Function
                public final Object apply(Object obj) {
                    return new Socks4ProxySocketConnection((ProxyInfo) obj);
                }
            };
        }
        if (i == 3) {
            return new Function() { // from class: org.jivesoftware.smack.proxy.ProxySocketConnection$$ExternalSyntheticLambda2
                @Override // org.jivesoftware.smack.util.Function
                public final Object apply(Object obj) {
                    return new Socks5ProxySocketConnection((ProxyInfo) obj);
                }
            };
        }
        throw new AssertionError("Unknown proxy type: " + proxyType);
    }
}
