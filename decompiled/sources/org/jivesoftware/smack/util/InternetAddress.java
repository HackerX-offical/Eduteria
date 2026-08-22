package org.jivesoftware.smack.util;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.minidns.dnslabel.DnsLabel;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsname.InvalidDnsNameException;
import org.minidns.util.InetAddressUtil;

/* JADX INFO: loaded from: classes10.dex */
public abstract class InternetAddress implements CharSequence {
    protected final String originalString;

    public abstract InetAddress asInetAddress() throws UnknownHostException;

    protected InternetAddress(String str) {
        this.originalString = (String) Objects.requireNonNull(str, "The 'originalString' argument must not be null");
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.originalString;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.originalString.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.originalString.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.originalString.subSequence(i, i2);
    }

    public static InternetAddress from(String str) {
        if (InetAddressUtil.isIpV4Address(str)) {
            return new Ipv4(str);
        }
        if (InetAddressUtil.isIpV6Address(str)) {
            return new Ipv6(str);
        }
        if (str.contains(InstructionFileId.DOT)) {
            try {
                return new DomainName(str, DnsName.from(str));
            } catch (InvalidDnsNameException e2) {
                return new InvalidDomainName(str, e2);
            }
        }
        return new DomainNameLabel(str, DnsLabel.from(str));
    }

    public static InternetAddress from(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return new Ipv4(inetAddress.getHostAddress(), (Inet4Address) inetAddress);
        }
        if (inetAddress instanceof Inet6Address) {
            return new Ipv6(inetAddress.getHostAddress(), (Inet6Address) inetAddress);
        }
        throw new IllegalArgumentException("Unknown type " + inetAddress.getClass() + " of " + inetAddress);
    }

    private static class InetAddressInternetAddress extends InternetAddress {
        private final InetAddress inetAddress;

        protected InetAddressInternetAddress(String str, InetAddress inetAddress) {
            super(str);
            this.inetAddress = inetAddress;
        }

        @Override // org.jivesoftware.smack.util.InternetAddress
        public InetAddress asInetAddress() {
            return this.inetAddress;
        }
    }

    public static final class Ipv4 extends InetAddressInternetAddress {
        private final Inet4Address inet4Address;

        @Override // org.jivesoftware.smack.util.InternetAddress.InetAddressInternetAddress, org.jivesoftware.smack.util.InternetAddress
        public /* bridge */ /* synthetic */ InetAddress asInetAddress() {
            return super.asInetAddress();
        }

        private Ipv4(String str) {
            this(str, InetAddressUtil.ipv4From(str));
        }

        private Ipv4(String str, Inet4Address inet4Address) {
            super(str, inet4Address);
            this.inet4Address = inet4Address;
        }

        public Inet4Address getInet4Address() {
            return this.inet4Address;
        }
    }

    public static final class Ipv6 extends InetAddressInternetAddress {
        private Inet6Address inet6Address;

        @Override // org.jivesoftware.smack.util.InternetAddress.InetAddressInternetAddress, org.jivesoftware.smack.util.InternetAddress
        public /* bridge */ /* synthetic */ InetAddress asInetAddress() {
            return super.asInetAddress();
        }

        private Ipv6(String str) {
            this(str, InetAddressUtil.ipv6From(str));
        }

        private Ipv6(String str, Inet6Address inet6Address) {
            super(str, inet6Address);
            this.inet6Address = inet6Address;
        }

        public Inet6Address getInet6Address() {
            return this.inet6Address;
        }
    }

    private static class NonNumericInternetAddress extends InternetAddress {
        private boolean attemptedToResolveInetAddress;
        private InetAddress inetAddress;

        protected NonNumericInternetAddress(String str) {
            super(str);
        }

        @Override // org.jivesoftware.smack.util.InternetAddress
        public InetAddress asInetAddress() throws UnknownHostException {
            InetAddress inetAddress = this.inetAddress;
            if (inetAddress != null || this.attemptedToResolveInetAddress) {
                return inetAddress;
            }
            this.attemptedToResolveInetAddress = true;
            InetAddress byName = InetAddress.getByName(this.originalString);
            this.inetAddress = byName;
            return byName;
        }
    }

    public static final class DomainName extends NonNumericInternetAddress {
        private final DnsName dnsName;

        @Override // org.jivesoftware.smack.util.InternetAddress.NonNumericInternetAddress, org.jivesoftware.smack.util.InternetAddress
        public /* bridge */ /* synthetic */ InetAddress asInetAddress() throws UnknownHostException {
            return super.asInetAddress();
        }

        private DomainName(String str, DnsName dnsName) {
            super(str);
            this.dnsName = dnsName;
        }

        public DnsName getDnsName() {
            return this.dnsName;
        }
    }

    public static final class DomainNameLabel extends NonNumericInternetAddress {
        private final DnsLabel dnsLabel;

        @Override // org.jivesoftware.smack.util.InternetAddress.NonNumericInternetAddress, org.jivesoftware.smack.util.InternetAddress
        public /* bridge */ /* synthetic */ InetAddress asInetAddress() throws UnknownHostException {
            return super.asInetAddress();
        }

        private DomainNameLabel(String str, DnsLabel dnsLabel) {
            super(str);
            this.dnsLabel = dnsLabel;
        }

        public DnsLabel getDnsLabel() {
            return this.dnsLabel;
        }
    }

    public static final class InvalidDomainName extends NonNumericInternetAddress {
        private final InvalidDnsNameException invalidDnsNameException;

        @Override // org.jivesoftware.smack.util.InternetAddress.NonNumericInternetAddress, org.jivesoftware.smack.util.InternetAddress
        public /* bridge */ /* synthetic */ InetAddress asInetAddress() throws UnknownHostException {
            return super.asInetAddress();
        }

        private InvalidDomainName(String str, InvalidDnsNameException invalidDnsNameException) {
            super(str);
            this.invalidDnsNameException = invalidDnsNameException;
        }

        public InvalidDnsNameException getInvalidDnsNameException() {
            return this.invalidDnsNameException;
        }
    }
}
