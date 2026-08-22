package org.jivesoftware.smack.util.rce;

import org.jivesoftware.smack.util.ToStringUtil;
import org.minidns.dnsname.DnsName;

/* JADX INFO: loaded from: classes10.dex */
public abstract class RemoteConnectionEndpointLookupFailure {
    private final String description;
    private final Exception exception;
    private transient String toStringCache;

    public RemoteConnectionEndpointLookupFailure(String str, Exception exc) {
        this.description = str;
        this.exception = exc;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Exception getException() {
        return this.exception;
    }

    public String getErrorMessage() {
        return this.description + " because: " + this.exception;
    }

    public String toString() {
        if (this.toStringCache == null) {
            this.toStringCache = ToStringUtil.builderFor(RemoteConnectionEndpointLookupFailure.class).addValue("description", this.description).addValue("exception", this.exception).build();
        }
        return this.toStringCache;
    }

    public static class DnsLookupFailure extends RemoteConnectionEndpointLookupFailure {
        private final DnsName dnsName;

        public DnsLookupFailure(DnsName dnsName, Exception exc) {
            super("DNS lookup exception for " + ((Object) dnsName), exc);
            this.dnsName = dnsName;
        }

        public DnsName getDnsName() {
            return this.dnsName;
        }
    }
}
