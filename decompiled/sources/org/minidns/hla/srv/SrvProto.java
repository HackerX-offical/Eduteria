package org.minidns.hla.srv;

import org.minidns.dnslabel.DnsLabel;

/* JADX INFO: loaded from: classes10.dex */
public enum SrvProto {
    tcp,
    udp;

    public final DnsLabel dnsLabel = DnsLabel.from("_" + name());

    SrvProto() {
    }
}
