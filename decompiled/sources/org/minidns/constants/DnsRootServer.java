package org.minidns.constants;

import com.clevertap.android.sdk.Constants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: loaded from: classes10.dex */
public class DnsRootServer {
    private static final Map<Character, Inet4Address> IPV4_ROOT_SERVER_MAP = new HashMap();
    private static final Map<Character, Inet6Address> IPV6_ROOT_SERVER_MAP = new HashMap();
    protected static final Inet4Address[] IPV4_ROOT_SERVERS = {rootServerInet4Address('a', ByteCode.IFNULL, 41, 0, 4), rootServerInet4Address('b', 192, 228, 79, 201), rootServerInet4Address(Constants.INAPP_POSITION_CENTER, 192, 33, 4, 12), rootServerInet4Address('d', ByteCode.IFNONNULL, 7, 91, 13), rootServerInet4Address('e', 192, 203, 230, 10), rootServerInet4Address('f', 192, 5, 5, 241), rootServerInet4Address('g', 192, 112, 36, 4), rootServerInet4Address('h', ByteCode.IFNULL, 97, 190, 53), rootServerInet4Address('i', 192, 36, 148, 17), rootServerInet4Address('j', 192, 58, 128, 30), rootServerInet4Address('k', ByteCode.INSTANCEOF, 0, 14, 129), rootServerInet4Address(Constants.INAPP_POSITION_LEFT, ByteCode.IFNONNULL, 7, 83, 42), rootServerInet4Address('m', 202, 12, 27, 33)};
    protected static final Inet6Address[] IPV6_ROOT_SERVERS = {rootServerInet6Address('a', 8193, 1283, 47678, 0, 0, 0, 2, 48), rootServerInet6Address('b', 8193, 1280, 132, 0, 0, 0, 0, 11), rootServerInet6Address(Constants.INAPP_POSITION_CENTER, 8193, 1280, 2, 0, 0, 0, 0, 12), rootServerInet6Address('d', 8193, 1280, 45, 0, 0, 0, 0, 13), rootServerInet6Address('f', 8193, 1280, 47, 0, 0, 0, 0, 15), rootServerInet6Address('h', 8193, 1280, 1, 0, 0, 0, 0, 83), rootServerInet6Address('i', 8193, 2046, 0, 0, 0, 0, 0, 83), rootServerInet6Address('j', 8193, 1283, 3111, 0, 0, 0, 2, 48), rootServerInet6Address(Constants.INAPP_POSITION_LEFT, 8193, 1280, 3, 0, 0, 0, 0, 66), rootServerInet6Address('m', 8193, 3523, 0, 0, 0, 0, 0, 53)};

    private static Inet4Address rootServerInet4Address(char c2, int i, int i2, int i3, int i4) {
        try {
            Inet4Address inet4Address = (Inet4Address) InetAddress.getByAddress(c2 + ".root-servers.net", new byte[]{(byte) i, (byte) i2, (byte) i3, (byte) i4});
            IPV4_ROOT_SERVER_MAP.put(Character.valueOf(c2), inet4Address);
            return inet4Address;
        } catch (UnknownHostException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Inet6Address rootServerInet6Address(char c2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        try {
            Inet6Address inet6Address = (Inet6Address) InetAddress.getByAddress(c2 + ".root-servers.net", new byte[]{(byte) (i >> 8), (byte) i, (byte) (i2 >> 8), (byte) i2, (byte) (i3 >> 8), (byte) i3, (byte) (i4 >> 8), (byte) i4, (byte) (i5 >> 8), (byte) i5, (byte) (i6 >> 8), (byte) i6, (byte) (i7 >> 8), (byte) i7, (byte) (i8 >> 8), (byte) i8});
            IPV6_ROOT_SERVER_MAP.put(Character.valueOf(c2), inet6Address);
            return inet6Address;
        } catch (UnknownHostException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Inet4Address getRandomIpv4RootServer(Random random) {
        Inet4Address[] inet4AddressArr = IPV4_ROOT_SERVERS;
        return inet4AddressArr[random.nextInt(inet4AddressArr.length)];
    }

    public static Inet6Address getRandomIpv6RootServer(Random random) {
        Inet6Address[] inet6AddressArr = IPV6_ROOT_SERVERS;
        return inet6AddressArr[random.nextInt(inet6AddressArr.length)];
    }

    public static Inet4Address getIpv4RootServerById(char c2) {
        return IPV4_ROOT_SERVER_MAP.get(Character.valueOf(c2));
    }

    public static Inet6Address getIpv6RootServerById(char c2) {
        return IPV6_ROOT_SERVER_MAP.get(Character.valueOf(c2));
    }
}
