package org.jivesoftware.smack.util.dns;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.minidns.dnsname.DnsName;
import org.minidns.record.SRV;

/* JADX INFO: loaded from: classes10.dex */
public abstract class DNSResolver {
    protected static final Logger LOGGER = Logger.getLogger(DNSResolver.class.getName());
    private final boolean supportsDnssec;

    protected abstract Collection<SRV> lookupSrvRecords0(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode);

    protected DNSResolver(boolean z) {
        this.supportsDnssec = z;
    }

    public final Collection<SRV> lookupSrvRecords(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        checkIfDnssecRequestedAndSupported(dnssecMode);
        return lookupSrvRecords0(dnsName, list, dnssecMode);
    }

    public final List<InetAddress> lookupHostAddress(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        checkIfDnssecRequestedAndSupported(dnssecMode);
        return lookupHostAddress0(dnsName, list, dnssecMode);
    }

    protected List<InetAddress> lookupHostAddress0(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        if (dnssecMode != ConnectionConfiguration.DnssecMode.disabled) {
            throw new UnsupportedOperationException("This resolver does not support DNSSEC");
        }
        try {
            return Arrays.asList(InetAddress.getAllByName(dnsName.toString()));
        } catch (UnknownHostException e2) {
            list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, e2));
            return null;
        }
    }

    protected static boolean shouldContinue(CharSequence charSequence, CharSequence charSequence2, List<InetAddress> list) {
        if (list == null) {
            return true;
        }
        if (!list.isEmpty()) {
            return false;
        }
        LOGGER.log(Level.INFO, "The DNS name " + ((Object) charSequence) + ", points to a hostname (" + ((Object) charSequence2) + ") which has neither A or AAAA resource records. This is an indication of a broken DNS setup.");
        return true;
    }

    private void checkIfDnssecRequestedAndSupported(ConnectionConfiguration.DnssecMode dnssecMode) {
        if (dnssecMode != ConnectionConfiguration.DnssecMode.disabled && !this.supportsDnssec) {
            throw new UnsupportedOperationException("This resolver does not support DNSSEC");
        }
    }
}
