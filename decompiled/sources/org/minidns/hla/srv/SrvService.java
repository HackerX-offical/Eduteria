package org.minidns.hla.srv;

import org.minidns.dnslabel.DnsLabel;

/* JADX INFO: loaded from: classes10.dex */
public enum SrvService {
    xmpp_client,
    xmpp_server,
    xmpps_client,
    xmpps_server;

    public final DnsLabel dnsLabel = DnsLabel.from("_" + name().replaceAll("_", "-"));

    SrvService() {
    }
}
