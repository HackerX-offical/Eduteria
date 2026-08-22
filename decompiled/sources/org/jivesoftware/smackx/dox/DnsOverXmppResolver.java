package org.jivesoftware.smackx.dox;

import java.io.IOException;
import org.minidns.dnsmessage.DnsMessage;

/* JADX INFO: loaded from: classes10.dex */
public interface DnsOverXmppResolver {
    DnsMessage resolve(DnsMessage dnsMessage) throws IOException;
}
