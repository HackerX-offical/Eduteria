package org.jivesoftware.smack.tcp.rce;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.dns.DNSResolver;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.minidns.dnsname.DnsName;
import org.minidns.record.SRV;
import org.minidns.util.SrvUtil;

/* JADX INFO: loaded from: classes10.dex */
public class RemoteXmppTcpConnectionEndpoints {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(RemoteXmppTcpConnectionEndpoints.class.getName());
    public static final String XMPP_CLIENT_DNS_SRV_PREFIX = "_xmpp-client._tcp";
    public static final String XMPP_SERVER_DNS_SRV_PREFIX = "_xmpp-server._tcp";

    public static Result<Rfc6120TcpRemoteConnectionEndpoint> lookup(ConnectionConfiguration connectionConfiguration) {
        List arrayList;
        List<Rfc6120TcpRemoteConnectionEndpoint> listResolveXmppServiceDomain;
        InetAddress hostAddress = connectionConfiguration.getHostAddress();
        DnsName host = connectionConfiguration.getHost();
        if (hostAddress != null) {
            arrayList = Collections.emptyList();
            listResolveXmppServiceDomain = Collections.singletonList(IpTcpRemoteConnectionEndpoint.from(hostAddress.toString(), connectionConfiguration.getPort(), hostAddress));
        } else if (host != null) {
            ArrayList arrayList2 = new ArrayList(1);
            List<InetAddress> listLookupHostAddress = DNSUtil.getDNSResolver().lookupHostAddress(host, arrayList2, connectionConfiguration.getDnssecMode());
            if (listLookupHostAddress != null) {
                ArrayList arrayList3 = new ArrayList(listLookupHostAddress.size());
                UInt16 port = connectionConfiguration.getPort();
                Iterator<InetAddress> it = listLookupHostAddress.iterator();
                while (it.hasNext()) {
                    arrayList3.add(IpTcpRemoteConnectionEndpoint.from(host, port, it.next()));
                }
                listResolveXmppServiceDomain = arrayList3;
            } else {
                listResolveXmppServiceDomain = Collections.emptyList();
            }
            arrayList = arrayList2;
        } else {
            arrayList = new ArrayList();
            DnsName xmppServiceDomainAsDnsNameIfPossible = connectionConfiguration.getXmppServiceDomainAsDnsNameIfPossible();
            if (xmppServiceDomainAsDnsNameIfPossible == null) {
                throw new IllegalStateException();
            }
            listResolveXmppServiceDomain = resolveXmppServiceDomain(xmppServiceDomainAsDnsNameIfPossible, arrayList, connectionConfiguration.getDnssecMode());
        }
        return new Result<>(listResolveXmppServiceDomain, arrayList, null);
    }

    public static final class Result<RCE extends RemoteConnectionEndpoint> {
        public final List<RCE> discoveredRemoteConnectionEndpoints;
        public final List<RemoteConnectionEndpointLookupFailure> lookupFailures;

        /* synthetic */ Result(List list, List list2, AnonymousClass1 anonymousClass1) {
            this(list, list2);
        }

        private Result(List<RCE> list, List<RemoteConnectionEndpointLookupFailure> list2) {
            this.discoveredRemoteConnectionEndpoints = list;
            this.lookupFailures = list2;
        }
    }

    enum DomainType {
        server(RemoteXmppTcpConnectionEndpoints.XMPP_SERVER_DNS_SRV_PREFIX),
        client(RemoteXmppTcpConnectionEndpoints.XMPP_CLIENT_DNS_SRV_PREFIX);

        public final DnsName srvPrefix;

        DomainType(String str) {
            this.srvPrefix = DnsName.from(str);
        }
    }

    public static List<Rfc6120TcpRemoteConnectionEndpoint> resolveXmppServiceDomain(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        return resolveDomain(dnsName, DomainType.client, list, dnssecMode, getDnsResolverOrThrow());
    }

    public static List<Rfc6120TcpRemoteConnectionEndpoint> resolveXmppServerDomain(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        return resolveDomain(dnsName, DomainType.server, list, dnssecMode, getDnsResolverOrThrow());
    }

    private static List<Rfc6120TcpRemoteConnectionEndpoint> resolveDomain(DnsName dnsName, DomainType domainType, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode, DNSResolver dNSResolver) {
        UInt16 uInt16From;
        ArrayList arrayList = new ArrayList();
        DnsName dnsNameFrom = DnsName.from(domainType.srvPrefix, dnsName);
        Collection<SRV> collectionLookupSrvRecords = dNSResolver.lookupSrvRecords(dnsNameFrom, list, dnssecMode);
        if (collectionLookupSrvRecords != null && !collectionLookupSrvRecords.isEmpty()) {
            if (LOGGER.isLoggable(Level.FINE)) {
                String str = "Resolved SRV RR for " + ((Object) dnsNameFrom) + ":";
                Iterator<SRV> it = collectionLookupSrvRecords.iterator();
                while (it.hasNext()) {
                    str = str + " " + it.next();
                }
                LOGGER.fine(str);
            }
            for (SRV srv : SrvUtil.sortSrvRecords(collectionLookupSrvRecords)) {
                List<InetAddress> listLookupHostAddress = dNSResolver.lookupHostAddress(srv.target, list, dnssecMode);
                if (listLookupHostAddress != null) {
                    arrayList.add(new SrvXmppRemoteConnectionEndpoint(srv, listLookupHostAddress));
                }
            }
        } else {
            LOGGER.info("Could not resolve DNS SRV resource records for " + ((Object) dnsNameFrom) + ". Consider adding those.");
        }
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$tcp$rce$RemoteXmppTcpConnectionEndpoints$DomainType[domainType.ordinal()];
        if (i == 1) {
            uInt16From = UInt16.from(5222);
        } else if (i == 2) {
            uInt16From = UInt16.from(5269);
        } else {
            throw new AssertionError();
        }
        List<InetAddress> listLookupHostAddress2 = dNSResolver.lookupHostAddress(dnsName, list, dnssecMode);
        if (listLookupHostAddress2 != null) {
            Iterator<InetAddress> it2 = listLookupHostAddress2.iterator();
            while (it2.hasNext()) {
                arrayList.add(IpTcpRemoteConnectionEndpoint.from(dnsName, uInt16From, it2.next()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$tcp$rce$RemoteXmppTcpConnectionEndpoints$DomainType;

        static {
            int[] iArr = new int[DomainType.values().length];
            $SwitchMap$org$jivesoftware$smack$tcp$rce$RemoteXmppTcpConnectionEndpoints$DomainType = iArr;
            try {
                iArr[DomainType.client.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$tcp$rce$RemoteXmppTcpConnectionEndpoints$DomainType[DomainType.server.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static DNSResolver getDnsResolverOrThrow() {
        DNSResolver dNSResolver = DNSUtil.getDNSResolver();
        if (dNSResolver != null) {
            return dNSResolver;
        }
        throw new IllegalStateException("No DNS resolver configured in Smack");
    }
}
