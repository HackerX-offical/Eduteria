package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.dns.DNSResolver;
import org.jivesoftware.smack.util.dns.SmackDaneProvider;

/* JADX INFO: loaded from: classes10.dex */
public class DNSUtil {
    private static SmackDaneProvider daneProvider;
    private static DNSResolver dnsResolver;

    public static void setDNSResolver(DNSResolver dNSResolver) {
        dnsResolver = (DNSResolver) Objects.requireNonNull(dNSResolver);
    }

    public static DNSResolver getDNSResolver() {
        return dnsResolver;
    }

    public static void setDaneProvider(SmackDaneProvider smackDaneProvider) {
        daneProvider = (SmackDaneProvider) Objects.requireNonNull(smackDaneProvider);
    }

    public static SmackDaneProvider getDaneProvider() {
        return daneProvider;
    }
}
