package org.jivesoftware.smack.util.dns.minidns;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.initializer.SmackInitializer;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.dns.DNSResolver;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.minidns.dnsname.DnsName;
import org.minidns.dnssec.DnssecResultNotAuthenticException;
import org.minidns.hla.DnssecResolverApi;
import org.minidns.hla.ResolutionUnsuccessfulException;
import org.minidns.hla.ResolverApi;
import org.minidns.hla.ResolverResult;
import org.minidns.hla.SrvResolverResult;
import org.minidns.record.A;
import org.minidns.record.AAAA;
import org.minidns.record.SRV;

/* JADX INFO: loaded from: classes10.dex */
public class MiniDnsResolver extends DNSResolver implements SmackInitializer {
    private static final MiniDnsResolver INSTANCE = new MiniDnsResolver();
    private static final ResolverApi DNSSEC_RESOLVER = DnssecResolverApi.INSTANCE;
    private static final ResolverApi NON_DNSSEC_RESOLVER = ResolverApi.INSTANCE;

    @Override // org.jivesoftware.smack.util.dns.DNSResolver
    protected /* bridge */ /* synthetic */ Collection lookupSrvRecords0(DnsName dnsName, List list, ConnectionConfiguration.DnssecMode dnssecMode) {
        return lookupSrvRecords0(dnsName, (List<RemoteConnectionEndpointLookupFailure>) list, dnssecMode);
    }

    public static DNSResolver getInstance() {
        return INSTANCE;
    }

    public MiniDnsResolver() {
        super(true);
    }

    @Override // org.jivesoftware.smack.util.dns.DNSResolver
    protected Set<SRV> lookupSrvRecords0(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        try {
            SrvResolverResult srvResolverResultResolveSrv = getResolver(dnssecMode).resolveSrv(dnsName);
            ResolutionUnsuccessfulException resolutionUnsuccessfulException = srvResolverResultResolveSrv.getResolutionUnsuccessfulException();
            if (resolutionUnsuccessfulException != null) {
                list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, resolutionUnsuccessfulException));
                return null;
            }
            if (shouldAbortIfNotAuthentic(dnsName, dnssecMode, srvResolverResultResolveSrv, list)) {
                return null;
            }
            return srvResolverResultResolveSrv.getAnswers();
        } catch (IOException e2) {
            list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, e2));
            return null;
        }
    }

    @Override // org.jivesoftware.smack.util.dns.DNSResolver
    protected List<InetAddress> lookupHostAddress0(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        Set setEmptySet;
        Set setEmptySet2;
        ResolverApi resolver = getResolver(dnssecMode);
        try {
            ResolverResult resolverResultResolve = resolver.resolve(dnsName, A.class);
            ResolverResult resolverResultResolve2 = resolver.resolve(dnsName, AAAA.class);
            if (!resolverResultResolve.wasSuccessful() && !resolverResultResolve2.wasSuccessful()) {
                list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, getExceptionFrom(resolverResultResolve)));
                list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, getExceptionFrom(resolverResultResolve2)));
                return null;
            }
            if (shouldAbortIfNotAuthentic(dnsName, dnssecMode, resolverResultResolve, list) || shouldAbortIfNotAuthentic(dnsName, dnssecMode, resolverResultResolve2, list)) {
                return null;
            }
            if (resolverResultResolve.wasSuccessful()) {
                setEmptySet = resolverResultResolve.getAnswers();
            } else {
                setEmptySet = Collections.emptySet();
            }
            if (resolverResultResolve2.wasSuccessful()) {
                setEmptySet2 = resolverResultResolve2.getAnswers();
            } else {
                setEmptySet2 = Collections.emptySet();
            }
            ArrayList arrayList = new ArrayList(setEmptySet.size() + setEmptySet2.size());
            Iterator it = setEmptySet.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(InetAddress.getByAddress(((A) it.next()).getIp()));
                } catch (UnknownHostException unused) {
                }
            }
            Iterator it2 = setEmptySet2.iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(InetAddress.getByAddress(dnsName.ace, ((AAAA) it2.next()).getIp()));
                } catch (UnknownHostException unused2) {
                }
            }
            return arrayList;
        } catch (IOException e2) {
            list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, e2));
            return null;
        }
    }

    public static void setup() {
        DNSUtil.setDNSResolver(getInstance());
    }

    @Override // org.jivesoftware.smack.initializer.SmackInitializer
    public List<Exception> initialize() {
        setup();
        MiniDnsDane.setup();
        return null;
    }

    private static ResolverApi getResolver(ConnectionConfiguration.DnssecMode dnssecMode) {
        if (dnssecMode == ConnectionConfiguration.DnssecMode.disabled) {
            return NON_DNSSEC_RESOLVER;
        }
        return DNSSEC_RESOLVER;
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.util.dns.minidns.MiniDnsResolver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode;

        static {
            int[] iArr = new int[ConnectionConfiguration.DnssecMode.values().length];
            $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode = iArr;
            try {
                iArr[ConnectionConfiguration.DnssecMode.needsDnssec.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode[ConnectionConfiguration.DnssecMode.needsDnssecAndDane.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode[ConnectionConfiguration.DnssecMode.disabled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static boolean shouldAbortIfNotAuthentic(DnsName dnsName, ConnectionConfiguration.DnssecMode dnssecMode, ResolverResult<?> resolverResult, List<RemoteConnectionEndpointLookupFailure> list) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode[dnssecMode.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                return false;
            }
            throw new IllegalStateException("Unknown DnssecMode: " + dnssecMode);
        }
        DnssecResultNotAuthenticException dnssecResultNotAuthenticException = resolverResult.getDnssecResultNotAuthenticException();
        if (dnssecResultNotAuthenticException == null) {
            return false;
        }
        list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, dnssecResultNotAuthenticException));
        return true;
    }

    private static ResolutionUnsuccessfulException getExceptionFrom(ResolverResult<?> resolverResult) {
        return new ResolutionUnsuccessfulException(resolverResult.getQuestion(), resolverResult.getResponseCode());
    }
}
